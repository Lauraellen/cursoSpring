package br.com.devmedia.curso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import br.com.devmedia.curso.web.conversor.TipoSexoConverter;

/*
 * é uma classe de configuração;
 * Aqui iremos definir como queremos usar o MVC
 * 
 * extendemos para a classe WebMvcConfigureAdapter que possui varios métodos
 * que podem ser subscritos.
 */

@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

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

	/*
	 * passamos a instancia do TipoSexoConverter
	 * assim quando o spring encontrar um atributo desse tipo, ele faz a conversão
	 */
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new TipoSexoConverter());
	}
	
	
}
