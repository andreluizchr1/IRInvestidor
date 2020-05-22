package br.com.investidor.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.investidor.exception.EmpresaDuplicadaException;
import br.com.investidor.model.Empresa;
import br.com.investidor.service.EmpresaService;

/**
 * 
 * @author: André Luiz C. Rodrigues
 * @date: 22 de mai de 2020
 */

@Controller
@RequestMapping("/empresas")
public class EmpresaControler {

	private static final String NOVA_EMPRESA = "/empresa/form";

	private static final String REDIRECIONAR_PARA_NOVA_EMPRESA = "redirect:/empresas/novo";

	private static final String LISTAR_EMPRESAS = "/empresa/list";

	private static final String MENSAGEM_SUCESSO = "Empresa cadastrada com sucesso";

	private ModelAndView mv;

	@Autowired
	private EmpresaService service;

	/**
	 * Método responsável por atender as requisições vindas da URL /empresas/novo e
	 * retorna a página contida no caminho /empresa/form
	 * 
	 * @return
	 */
	@RequestMapping("/novo")
	public ModelAndView novo() {
		mv = new ModelAndView(NOVA_EMPRESA);
		mv.addObject(new Empresa());
		return mv;
	}

	/**
	 * Método responsável por receber requisição do tipo POST para salvar uma nova
	 * empresa. É realizada a validação das informações vindas da página, se estiver
	 * tudo certo, as informações são salvas e mostrada uma mensagem de sucesso. Se
	 * ocorrer de uma empresa já existir na base de dados, será emitida uma mensagem
	 * de erro, com cnpj duplicado e retorno das informações para correção.
	 * 
	 * @param empresa
	 * @param errors
	 * @param attributes
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Empresa empresa, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return new ModelAndView(NOVA_EMPRESA);
		}

		try {
			service.salvar(empresa);
			attributes.addFlashAttribute("msg", MENSAGEM_SUCESSO);
			return new ModelAndView(REDIRECIONAR_PARA_NOVA_EMPRESA);
		} catch (EmpresaDuplicadaException e) {
			errors.reject(null, e.getMessage());
			mv = new ModelAndView(NOVA_EMPRESA);
			mv.addObject(empresa);
			return mv;
		}

	}

	/*
	 * Método responsável por escutar a requisação de URL /empresas. Ela é
	 * responsável por listar todas as empresas já cadastradas pelos usuários
	 */
	@RequestMapping
	public ModelAndView listar() {
		mv = new ModelAndView(LISTAR_EMPRESAS);
		mv.addObject("empresas", service.listar());
		return mv;
	}

	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Empresa empresa) {
		mv = new ModelAndView(NOVA_EMPRESA);
		mv.addObject(empresa);
		return mv;
	}

}
