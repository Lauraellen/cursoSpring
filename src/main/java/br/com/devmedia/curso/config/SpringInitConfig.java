package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * Extendendo a classe � uma classe abstrata do spring;
 * Essa classe funciona quase igual ao arquivo web.xml. 
 * Sempre que inicializamos uma aplica��o em java,
 * o primeiro recurso lido � o web.xml, mas como n�o vamos usar as configura��es l�,
 * denominamos aqui.
 * 
 * Ao extender essa classe abstrata, � necess�rio implementar tr�s m�todos.
 * 
 */
public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*
	 * Denominamos nossa classe raiz em RootConfig;
	 * Quando o servidor iniciar, ele vai subir a aplica��o, e 
	 * essa classe RootConfig ser� a primeira configura��o a ser carregada.
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] {RootConfig.class};
	}
	
	/*
	 * Quem � a classe que cont�m a parte de servlet para n�s
	 * que nesse caso, � a SpringMvcConfig;
	 */

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class[] {SpringMvcConfig.class};
	}

	/*
	 * Aqui, iremos retornar um array de String;
	 * Sempre que encontrar uma '/', a aplica��o ir� saber
	 * que est� lidando com um servlet
	 * 
	 * a anota��o @O
	 */
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}

}
