package com.linran.resolver;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResolverTest {

	@Test
	public void pathMatchingResourcePatternResolverTest() throws IOException {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		//当先项目只能从build/classes/java/test下面年开始解析
		Resource[] resources = resolver.getResources("classpath:com/**/*.*");
		for (Resource resource : resources) {
			System.out.printf("filename:%s description:%s %n", resource.getFilename(), resource.getDescription());
			System.out.printf("absolute path:%s", resource.getURL().getPath());
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
				String buffer = null;
				System.out.println("content is :");
				while ((buffer = reader.readLine()) != null) {
					System.out.println(buffer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
