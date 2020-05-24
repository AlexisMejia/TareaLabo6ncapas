package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {

	@Autowired
	private ContribuyenteService contribuyenteService;

	@Autowired
	private ImportanciaService importanciaService;

	@GetMapping("/main")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		Contribuyente cont = new Contribuyente();
		List<Importancia> list = importanciaService.finAll();

		mav.addObject("contribuyente", cont);
		mav.addObject("importancia", list);

		mav.setViewName("main");

		return mav;
	}

	@PostMapping("/inicio")
	public ModelAndView formContribuyente(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();

		if (result.hasErrors()) {
			mav.setViewName("main");
		} else {
			contribuyenteService.save(contribuyente);
			List<Contribuyente> contribuyentes = null;

			try {
				contribuyentes = contribuyenteService.findAllContribuyente();
			} catch (Exception e) {
				e.printStackTrace();
			}

			mav.addObject("contribuyentes", contribuyentes);
			mav.setViewName("list");

		}

		return mav;
	}

	@PostMapping("/listadoGeneral")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contri = null;

		try {
			contri = contribuyenteService.findAllContribuyente();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("contribuyentes", contri);
		mav.setViewName("list");

		return mav;
	}

}
