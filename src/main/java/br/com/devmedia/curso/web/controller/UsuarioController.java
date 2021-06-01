package br.com.devmedia.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.curso.dao.UsuarioDao;

/*
 * a string "usuario" é o caminho na url para acessar esse controller
 */

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	// precisamos ter acesso ao UsuarioDao para buscar no método getAll os usuarios
	// injetamos dentro do controller o objeto referente ao usuario dao com a anotaçao @Autowired
	
	@Autowired
	private UsuarioDao dao;
	
	/*
	 * existem outros objetos dentro do spring que são capazes de encapsular 
	 * o que queremos enviar para a página. Um deles é o ModelMap.
	 * Quando passamos ModelMap como argumento do método, ele automaticamente vem estanciado
	 * então não precisamos criar essa estância dentro do método.
	 * 
	 * em addAtribute, passamos a variavel que foi usada no foreach da página list.jsp,
	 * que irá armazenar a lista.
	 * E para ter acesso a lista, uso o dao.getAll que me retorna o objeto do tipo list
	 * 
	 * o return informa ao spring para qual página ele deve enviar esse objeto e qual é o objeto(model0
	 */
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView getAll(ModelMap model) {
		model.addAttribute("usuarios", dao.getAll());
		return new ModelAndView("/user/list", model);
	}
}
