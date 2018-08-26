package com.machintosh1983.var.platform.common;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfiguration {

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
	       return new EmbeddedServletContainerCustomizer() {
	           @Override
	           public void customize(ConfigurableEmbeddedServletContainer container) {
	                container.setSessionTimeout(-1);//单位为S
	          }
	    };
	}
}
