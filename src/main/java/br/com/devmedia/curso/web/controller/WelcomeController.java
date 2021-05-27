package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * a anotação @Controller, serve para indicar ao spring que essa é uma classe controller
 */
@Controller
public class WelcomeController {
	
	/*
	 * método que irá chamar a página;
	 * return welcome é o nome do arquivo sem a extensão;
	 * a anotação @RequestMapping indica ao spring qual método é pra ele usar;
	 * possui dois atributos:
	 * Value = path da requisição, caminho;
	 * Method = método da requisição, se é GET, PUT, DELETE, etc
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	/*
	 * o tipo de retorno ModelAndView, é um objeto do próprio do spring
	 * para enviarmos informações própria para a página. Pode ser string, ou até 
	 * objetos mais complexos.
	 */
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView teste() {
		/*
		 * instância de ModelandView
		 * entre ( ), que é o método construtor, passamo a página que é 
		 * para ser carregada;
		 * addObjetect, função com dois parametro:
		 * a primeira "teste" é o nome da string que espero receber na página
		 * ${teste};
		 * e no segundo parametro passo o valor dessa variavel
		 */
		
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("teste", "Olá, eu sou o spring MVC.");
		return view;
	}

}
