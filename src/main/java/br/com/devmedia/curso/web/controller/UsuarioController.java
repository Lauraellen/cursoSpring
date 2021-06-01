package br.com.devmedia.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.devmedia.curso.dao.UsuarioDao;

/*
 * a string "usuario" � o caminho na url para acessar esse controller
 */

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	// precisamos ter acesso ao UsuarioDao para buscar no m�todo getAll os usuarios
	// injetamos dentro do controller o objeto referente ao usuario dao com a anota�ao @Autowired
	
	@Autowired
	private UsuarioDao dao;
	
	/*
	 * existem outros objetos dentro do spring que s�o capazes de encapsular 
	 * o que queremos enviar para a p�gina. Um deles � o ModelMap.
	 * Quando passamos ModelMap como argumento do m�todo, ele automaticamente vem estanciado
	 * ent�o n�o precisamos criar essa est�ncia dentro do m�todo.
	 * 
	 * em addAtribute, passamos a variavel que foi usada no foreach da p�gina list.jsp,
	 * que ir� armazenar a lista.
	 * E para ter acesso a lista, uso o dao.getAll que me retorna o objeto do tipo list
	 * 
	 * o return informa ao spring para qual p�gina ele deve enviar esse objeto e qual � o objeto(model0
	 */
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView getAll(ModelMap model) {
		model.addAttribute("usuarios", dao.getAll());
		return new ModelAndView("/user/list", model);
	}
}
