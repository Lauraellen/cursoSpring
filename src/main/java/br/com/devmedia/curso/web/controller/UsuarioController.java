package br.com.devmedia.curso.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.curso.dao.UsuarioDao;
import br.com.devmedia.curso.domain.TipoSexo;
import br.com.devmedia.curso.domain.Usuario;

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
	
	/*
	 * M�todo para redirecionar para a tela de cadastro;
	 * ao inv�s de usarmos @RequestMapping, usamos @GetMapping q j� especifica que � do tipo get
	 * e depois s� passamos o path;
	 * 
	 * A anota��o ModelAttribute � porque estamos trabalhando com a p�gina add que tem um modelAttribute,
	 * para fazermos a liga��o entre ambas, usamos essa anota��o. E o tipo de objeto q vamos usar 
	 * no formulario, � do tipo Usuario.
	 * 
	 * Quando acessarmos a url cadastro, ir� abrir a p�gina add;
	 */
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		/*
		 * o values � um m�todo padr�o do enum que retorna um array
		 * com todos os valores que temos no enum;
		 * � como se estivesse retornando uma lista contendo cada um dos tipos
		 * que n�s temos dentro do TipoSexo.
		 */
		model.addAttribute("sexos", TipoSexo.values());
		return "/user/add";
	}
	
	/*
	 * M�todo para salvar o novo cadastro;
	 * A anota��o ModelAttribute � porque estamos trabalhando com a p�gina add que tem um modelAttribute,
	 * para fazermos a liga��o entre ambas, usamos essa anota��o. E o tipo de objeto q vamos usar 
	 * no formulario, � do tipo Usuario.
	 * 
	 * Quando o formulario enviar os dados, recebemos ja como um objeto;
	 * 
	 * a anota��o @Valid diz ao spring pra ele usar a valida��o do Bean Validation;
	 * 
	 * BindignResult � para usar para alterar o fluxo para caso tenha algum tipo de erro (caminho)
	 * e tem que estar obrigatoriamente antes do redirect
	 */
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/user/add";
		}
		dao.salvar(usuario);
		attr.addFlashAttribute("message", "Usu�rio salvo com sucesso");
		return "redirect:/usuario/todos";
	}
	
	/*
	 * Recebemos um id nesse m�todo
	 * A anota��o @PathVariable, captura o valor que estamos recebendo na url e adiciona ela
	 * � um objeto.
	 * 
	 * Criamos um usuario do tipo usuario e usando o dao, passamos o id capturado, e que trar�
	 * o usuario com esse id.
	 * 
	 */
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Usuario usuario = dao.getId(id);
		model.addAttribute("usuario", usuario);
		return new ModelAndView("/user/add", model);
	}
	
	/*
	 * m�todo que recebe o formulario depois dos dados serem alterados
	 */
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/user/add");
		}
		dao.editar(usuario);
		attr.addFlashAttribute("message", "Usu�rio alterado com sucesso");
		return new ModelAndView("redirect:/usuario/todos");
	}
	
	/*
	 * m�tod para deletar um usu�rio
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		dao.excluir(id);
		attr.addFlashAttribute("message", "Usu�rio excluido com sucesso");
		return  "redirect:/usuario/todos";
	}
}
