package br.com.devmedia.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.com.devmedia.curso.web.conversor.TipoSexoConverter;

/*
 * � uma classe de configura��o;
 * Aqui iremos definir como queremos usar o MVC
 * 
 * extendemos para a classe WebMvcConfigureAdapter que possui varios m�todos
 * que podem ser subscritos.
 */

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

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

	/*
	 * passamos a instancia do TipoSexoConverter
	 * assim quando o spring encontrar um atributo desse tipo, ele faz a convers�o
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new TipoSexoConverter());
	}
	
	
}
