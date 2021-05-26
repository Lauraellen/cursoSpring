package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Extendendo a classe à uma classe abstrata do spring;
 * Essa classe funciona quase igual ao arquivo web.xml. 
 * Sempre que inicializamos uma aplicação em java,
 * o primeiro recurso lido é o web.xml, mas como não vamos usar as configurações lá,
 * denominamos aqui.
 * 
 * Ao extender essa classe abstrata, é necessário implementar três métodos.
 * 
 */
public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * Denominamos nossa classe raiz em RootConfig;
	 * Quando o servidor iniciar, ele vai subir a aplicação, e 
	 * essa classe RootConfig será a primeira configuração a ser carregada.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {RootConfig.class};
	}
	
	/*
	 * Quem é a classe que contém a parte de servlet para nós
	 * que nesse caso, é a SpringMvcConfig;
	 */

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {SpringMvcConfig.class};
	}

	/*
	 * Aqui, iremos retornar um array de String;
	 * Sempre que encontrar uma '/', a aplicação irá saber
	 * que está lidando com um servlet
	 * 
	 * a anotação @O
	 */
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
