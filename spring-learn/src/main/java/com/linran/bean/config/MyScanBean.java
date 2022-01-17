package com.linran.bean.config;

import com.linran.bean.Logo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.linran.bean.config")
public class MyScanBean {

	@Bean
	public Logo logo() {
		return new Logo();
	}
}
