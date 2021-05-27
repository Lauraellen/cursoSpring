package br.com.devmedia.curso.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
 * a anota��o @Controller, serve para indicar ao spring que essa � uma classe controller
 */
@Controller
public class WelcomeController {
	
	/*
	 * m�todo que ir� chamar a p�gina;
	 * return welcome � o nome do arquivo sem a extens�o;
	 * a anota��o @RequestMapping indica ao spring qual m�todo � pra ele usar;
	 * possui dois atributos:
	 * Value = path da requisi��o, caminho;
	 * Method = m�todo da requisi��o, se � GET, PUT, DELETE, etc
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "welcome";
	}
	
	/*
	 * o tipo de retorno ModelAndView, � um objeto do pr�prio do spring
	 * para enviarmos informa��es pr�pria para a p�gina. Pode ser string, ou at� 
	 * objetos mais complexos.
	 */
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView teste() {
		/*
		 * inst�ncia de ModelandView
		 * entre ( ), que � o m�todo construtor, passamo a p�gina que � 
		 * para ser carregada;
		 * addObjetect, fun��o com dois parametro:
		 * a primeira "teste" � o nome da string que espero receber na p�gina
		 * ${teste};
		 * e no segundo parametro passo o valor dessa variavel
		 */
		
		ModelAndView view = new ModelAndView("welcome");
		view.addObject("teste", "Ol�, eu sou o spring MVC.");
		return view;
	}

}
