package br.com.devmedia.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * é uma classe de configuração;
 * Aqui iremos definir como queremos usar o MVC
 */

@Configuration
public class SpringMvcConfig {

	/* Quando precisamos que um método seja gerenciado pelo spring,
	 * usamos a anotação @Bean;
	 * 
	 * método com uma classe do spring, que sabe como resolver
	 * as nossas páginas.
	 * viewResolver = nome do método;
	 * instanciamos;
	 * setamos o prefixo que nossas páginas vão estar no diretorio /WEB-INF/views/;
	 * o tipo de arquivo será .jsp;
	 * O tipo de recurso que será utilizado será o JstlView.
	 */
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
}
