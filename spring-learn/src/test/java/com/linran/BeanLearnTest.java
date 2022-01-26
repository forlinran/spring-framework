package com.linran;

import com.linran.bean.*;
import com.linran.bean.aop.annotation.AnnotationConfiguration;
import com.linran.bean.aop.annotation.AnnotationMathCalculator;
import com.linran.bean.aop.xml.MathCalculator;
import com.linran.bean.autowire.School;
import com.linran.bean.factorymethod.Person;
import com.linran.bean.lifecycle.LifeCycle;
import com.linran.bean.methodoverrides.Fruit;
import com.linran.bean.methodoverrides.FruitPlate;
import com.linran.bean.resolvebeforeinstantiation.Car;
import com.linran.bean.selfeditor.Customer;
import com.linran.bean.selftag.Student;
import com.linran.bean.supplier.Gopher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.PluggableSchemaResolver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLearnTest {

	@Test
	public void injectTest() {
//      注释掉的代码在getEnvironment().resolveRequiredPlaceholders的时候会进行placeholder解析
//		System.setProperty("spring", "classpath");
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("${spring}:config.xml");
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml","classpath:spring-${username}.xml");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		Logo logoP = context.getBean(Logo.class);
		System.out.printf("this is logoP printf:%s%n", logoP.toString());
	}

	/**
	 * 循环依赖
	 * 三级缓存_存在的意义是为了解决代理类带来的循环依赖问题
	 * 代理类是在BFF.after调用创建的(实例化，完成初始化后，放入一级缓存前)
	 * 如果有循环依赖则在属性赋值通过getEarlyReference方法提前创建代理对象将其暴露（此时被当作属性赋值的对象还未完成初始化）
	 */
	@Test
	public void circleDependencyTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		CircleA circleA = context.getBean(CircleA.class);
		CircleB circleB = context.getBean(CircleB.class);
		System.out.printf("this is circleA printf:%s%n", circleA.toString());
		System.out.printf("this is circleB printf:%s%n", circleB.toString());
	}

	/**
	 * 都是用来创建对象的
	 * 当使用BeanFactory的时候必须要遵循完整的创建过程，这个过程是由spring来管理控制的
	 * 而使用FactoryBean只需要调用getObject就可以返回具体的对象，整个对象的创建过程是由用户自己来控制，更加灵活
	 */
	@Test
	public void factoryBeanTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		//容器创建好后，容器中是没有Bird对象，但是会有myFactoryBeanObject对象，在实际调用getBean的时候先获取对应的FactoryBean对象，然后再是执行getObject对象
		MyFactoryBeanObject myFactoryBeanObject = (MyFactoryBeanObject) context.getBean("&myFactoryBeanObject");
		Bird bird1 = (Bird) context.getBean("myFactoryBeanObject");
		Bird bird2 = (Bird) context.getBean("myFactoryBeanObject");
		System.out.printf("bird1:%s  bird2:%s %n", bird1, bird2);
	}

	/**
	 * 位置
	 * obtainFreshBeanFactory#refreshBeanFactory#loadBeanDefinitions...
	 * {@link org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader#parseBeanDefinitions->delegate.parseCustomElement}
	 * <p>
	 * 自定义标签解析测试
	 * 1.官方定义的context:placeholder可以作为参考，debug定位到parseCustomElement可以看到
	 * 对应的Handler为:ContextNameSpaceHandler
	 * 本次示例的parser为:PropertyPlaceholderBeanDefinitionParser(在ContextNameSpaceHandler的init中进行注册)
	 * <p>
	 * 参考
	 *
	 * @see org.springframework.context.config.ContextNamespaceHandler
	 * 思考：什么时候配置好的，什么时候开始加载的，什么时候开始真正doParse
	 */
	@Test
	public void customerTagTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		//容器创建好后，容器中是没有Bird对象，但是会有myFactoryBeanObject对象，在实际调用getBean的时候先获取对应的FactoryBean对象，然后再是执行getObject对象
		Student student = context.getBean("student", Student.class);
		System.out.println(student);
	}

	/**
	 * 位置
	 * 核心方法：prepareBeanFactory->beanFactory.addPropertyEditorRegistrar
	 * 实际注册时机：populateBean前的initBeanWrapper方法将editor注册到当前BeanWrapper
	 * 实际处理：populateBean属性字段填充时applyPropertyValues方法
	 * 参考
	 *
	 * @see org.springframework.jmx.export.CustomDateEditorRegistrar
	 * <p>
	 * 思考：什么时候配置好的，什么时候开始注册PropertyEditor的，什么时候开始真正setAsText
	 */
	@Test
	public void customerPropertyEditor() {
		//customEditorConfigurer
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-selfeditor.xml");
		//容器创建好后，容器中是没有Bird对象，但是会有myFactoryBeanObject对象，在实际调用getBean的时候先获取对应的FactoryBean对象，然后再是执行getObject对象
		Customer customer = context.getBean("customer", Customer.class);
	}

	/**
	 * spring中默认的对象都是单例的，spring会在一级缓存中持有该对象，
	 * 方便下次直接获取,那么如果是原型作用域的话，会创建一个新的对象
	 * 如果想在一个单例模式的bean下引用一个原型模式的bean,
	 * 怎么办?在此时就需要引用lookup-method标签来解决此问题
	 * <p>
	 * 如果apple&banana是原型模式，则每次都是getBean的时候获取最新的bean
	 */
	@Test
	public void methodOverrides() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
		//容器创建好后，容器中是没有Bird对象，但是会有myFactoryBeanObject对象，在实际调用getBean的时候先获取对应的FactoryBean对象，然后再是执行getObject对象
		FruitPlate fruitplate1 = context.getBean("fruitplate1", FruitPlate.class);
		Fruit fruit1 = fruitplate1.getFruit();
		FruitPlate fruitplate2 = context.getBean("fruitplate2", FruitPlate.class);
		Fruit fruit2 = fruitplate2.getFruit();

		FruitPlate fruitplate3 = context.getBean("fruitplate1", FruitPlate.class);
		Fruit fruit3 = fruitplate1.getFruit();
		System.out.println("fruit3==fruit1 :" + (fruit1 == fruit3));
	}

	/**
	 * doCreateBean之前执行resolveBeforeInstantiation方法的时候，通过BPP返回自定义的动态代理对象
	 */
	@Test
	public void resolveBeforeInstantiationTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:resolvebeforeinstantiation.xml");
		Car car = context.getBean("car", Car.class);
		car.run();
	}

	/**
	 * beanDefinition.resolvedConstructorOrFactoryMethod属性
	 * 第一次实例化后，所用的构造器会缓存起来; prototype原型模式才会在第二次调用的时候出现
	 */
	@Test
	public void prototypeTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:resolvedConstructorOrFactoryMethod.xml");
		Person person1 = context.getBean("prototypePerson", Person.class);
		Person person2 = context.getBean("prototypePerson", Person.class);
	}

	/**
	 * aware接口调用,@PostConstruct,@PreDestruct
	 */
	@Test
	public void lifeCycleTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:lifecycle.xml");
		LifeCycle lifecycle = context.getBean("lifecycle", LifeCycle.class);
	}

	/**
	 * supplier创建bean对象
	 */
	@Test
	public void supplierTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:supplier.xml");
		Gopher gopher = context.getBean("gopher", Gopher.class);
	}

	@Test
	public void factoryMethodTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:factorymethod.xml");
		Person person1 = context.getBean("person1", Person.class);
		Person person2 = context.getBean("person2", Person.class);
	}

	/**
	 * AutowiredAnnotationBeanPostProcessor对@Autowired的解析处理
	 * 位置:doCreateBean#applyMergedBeanDefinitionPostProcessors
	 */
	@Test
	public void autowiredAnnotationBeanPostProcessorTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:autowiredbpp.xml");
		School school = context.getBean(School.class);
		school.hello();
	}

	/**
	 * populateBean
	 */
	@Test
	public void populateBeanTest() {
		MyClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext("classpath:spring-config.xml");
		Logo logoP = context.getBean(Logo.class);
		System.out.printf("this is logoP printf:%s%n", logoP.toString());
	}

	/**
	 * 代理类调试
	 */
	@Test
	public void aopXmlTest() {
		MyClassPathXmlApplicationContext context = new MyClassPathXmlApplicationContext("classpath:aop-xml.xml");
		MathCalculator calculator = context.getBean(MathCalculator.class);
		calculator.div(1, 2);
	}

	@Test
	public void aopAnnotationTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotationConfiguration.class);
		context.refresh();
		AnnotationMathCalculator calculator = context.getBean(AnnotationMathCalculator.class);
		calculator.div(1, 2);
	}

	@Test
	public void loadTest() {
		PluggableSchemaResolver schemaResolver = new PluggableSchemaResolver(ClassLoader.getSystemClassLoader());
		schemaResolver.toString();
	}
}
