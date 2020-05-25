package com.uca.capas.controller;

import java.util.Date;
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
		System.out.println("regreso a la lista de importancia");
		mav.addObject("importancia", list);

		mav.setViewName("main");

		return mav;
	}

	@PostMapping("/main")
	public ModelAndView formContribuyente(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Importancia> list = importanciaService.finAll();
		if (result.hasErrors()) {
			mav.addObject("importancia", list);
			mav.setViewName("main");
			System.out.println("error");
		} else {
			contribuyente.setfIngreso(new Date());
			contribuyenteService.save(contribuyente);
			List<Contribuyente> contribuyentes = null;
			try {
				list = importanciaService.finAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("exito");

			mav.addObject("contribuyentes", contribuyentes);
			mav.addObject("msg", "contribuyente guardado con exito");
			mav.setViewName("exito");

		}

		return mav;
	}

	@PostMapping("/verContribuyentes")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contri = contribuyenteService.findAllContribuyente();

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
