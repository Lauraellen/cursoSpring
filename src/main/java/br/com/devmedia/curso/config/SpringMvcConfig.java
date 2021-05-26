package br.com.devmedia.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * � uma classe de configura��o;
 * Aqui iremos definir como queremos usar o MVC
 */

@Configuration
public class SpringMvcConfig {

	/* Quando precisamos que um m�todo seja gerenciado pelo spring,
	 * usamos a anota��o @Bean;
	 * 
	 * m�todo com uma classe do spring, que sabe como resolver
	 * as nossas p�ginas.
	 * viewResolver = nome do m�todo;
	 * instanciamos;
	 * setamos o prefixo que nossas p�ginas v�o estar no diretorio /WEB-INF/views/;
	 * o tipo de arquivo ser� .jsp;
	 * O tipo de recurso que ser� utilizado ser� o JstlView.
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
