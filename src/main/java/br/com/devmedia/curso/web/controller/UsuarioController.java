package br.com.devmedia.curso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devmedia.curso.dao.UsuarioDao;
import br.com.devmedia.curso.domain.Usuario;

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
	
	/*
	 * Método para redirecionar para a tela de cadastro;
	 * ao invés de usarmos @RequestMapping, usamos @GetMapping q já especifica que é do tipo get
	 * e depois só passamos o path;
	 * 
	 * A anotação ModelAttribute é porque estamos trabalhando com a página add que tem um modelAttribute,
	 * para fazermos a ligação entre ambas, usamos essa anotação. E o tipo de objeto q vamos usar 
	 * no formulario, é do tipo Usuario.
	 * 
	 * Quando acessarmos a url cadastro, irá abrir a página add;
	 */
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("usuario") Usuario usuario, ModelMap model) {
		return "/user/add";
	}
	
	/*
	 * Método para salvar o novo cadastro;
	 * A anotação ModelAttribute é porque estamos trabalhando com a página add que tem um modelAttribute,
	 * para fazermos a ligação entre ambas, usamos essa anotação. E o tipo de objeto q vamos usar 
	 * no formulario, é do tipo Usuario.
	 * 
	 * Quando o formulario enviar os dados, recebemos ja como um objeto;
	 */
	@PostMapping("/save")
	public String save(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr) {
		dao.salvar(usuario);
		attr.addFlashAttribute("message", "Usuário salvo com sucesso");
		return "redirect:/usuario/todos";
	}
	
	/*
	 * Recebemos um id nesse método
	 * A anotação @PathVariable, captura o valor que estamos recebendo na url e adiciona ela
	 * à um objeto.
	 * 
	 * Criamos um usuario do tipo usuario e usando o dao, passamos o id capturado, e que trará
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
	 * método que recebe o formulario depois dos dados serem alterados
	 */
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute("usuario") Usuario usuario, RedirectAttributes attr) {
		dao.editar(usuario);
		attr.addFlashAttribute("message", "Usuário alterado com sucesso");
		return new ModelAndView("redirect:/usuario/todos");
	}
	
	/*
	 * métod para deletar um usuário
	 */
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		dao.excluir(id);
		attr.addFlashAttribute("message", "Usuário excluido com sucesso");
		return  "redirect:/usuario/todos";
	}
}
