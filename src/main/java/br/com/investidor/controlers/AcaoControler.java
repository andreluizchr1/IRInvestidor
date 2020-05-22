package br.com.investidor.controlers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.investidor.exception.CodigoDuplicadoException;
import br.com.investidor.model.Acao;
import br.com.investidor.model.Empresa;
import br.com.investidor.model.TipoAcao;
import br.com.investidor.service.AcaoService;
import br.com.investidor.service.EmpresaService;
import br.com.investidor.service.TipoAcaoService;

@Controller
@RequestMapping("/acoes")
public class AcaoControler {

	private static final String NOVA_ACAO = "/acao/form";

	private static final String REDIRECIONAR_PARA_NOVA_ACAO = "redirect:/acoes/novo";

	private static final String LISTAR_ACOES = "/acao/list";

	private static final String MENSAGEM_SUCESSO = "Ação cadastrada com sucesso";

	private ModelAndView mv;

	@Autowired
	private AcaoService service;

	@Autowired
	private TipoAcaoService tiposAcoesService;

	@Autowired
	private EmpresaService empresaService;

	/*
	 * Método responsável por responder a requisições para a URL /acoes/novo,
	 * retornado um objeto ModelAndView com o endereço real da página e um objeto
	 * Acao em branco.
	 */
	@RequestMapping("/novo")
	public ModelAndView novo() {
		mv = new ModelAndView(NOVA_ACAO);
		mv.addObject(new Acao());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Acao acao, Errors errors, RedirectAttributes attributes) {

		if (errors.hasErrors()) {
			return new ModelAndView(NOVA_ACAO);
		}

		try {
			service.salvar(acao);
			attributes.addFlashAttribute("msg", MENSAGEM_SUCESSO);
			return new ModelAndView(REDIRECIONAR_PARA_NOVA_ACAO);
		} catch (CodigoDuplicadoException e) {
			errors.reject(null, e.getMessage());
			mv = new ModelAndView(NOVA_ACAO);
			mv.addObject(acao);
			return mv;
		}

	}

	@RequestMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Acao acao) {
		mv = new ModelAndView(NOVA_ACAO);
		mv.addObject(acao);
		return mv;
	}

	@RequestMapping
	public ModelAndView listar() {
		mv = new ModelAndView(LISTAR_ACOES);
		mv.addObject("acoes", service.listar());
		return mv;
	}

	@ModelAttribute("tiposAcoes")
	public Collection<TipoAcao> tipoAcoes() {
		return tiposAcoesService.listar();
	}

	@ModelAttribute("empresas")
	public Collection<Empresa> empresas() {
		return empresaService.listar();
	}
}
