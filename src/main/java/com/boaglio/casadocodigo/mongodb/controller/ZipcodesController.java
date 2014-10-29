package com.boaglio.casadocodigo.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaglio.casadocodigo.mongodb.model.Zip;
import com.boaglio.casadocodigo.mongodb.repository.ZipsRepository;
import com.boaglio.casadocodigo.mongodb.util.CalculaDistancia;

@Controller
public class ZipcodesController {

	@Autowired
	private ZipsRepository repository;

	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String index(ModelMap model) {

		List<Zip> zips = repository.findAll();
		model.addAttribute("zips",zips);
		return "home";

	}

	@RequestMapping(value = "/calcular",method = RequestMethod.GET)
	public String detalhe(@RequestParam("idCidadeOrigem") String idCidadeOrigem,@RequestParam("idCidadeDestino") String idCidadeDestino,ModelMap model) {

		Zip zip1 = repository.findById(idCidadeOrigem);
		System.out.println("cidade origem =" + zip1);
		Zip zip2 = repository.findById(idCidadeDestino);
		System.out.println("cidade destino =" + zip2);

		double distancia = CalculaDistancia.distance(zip1.getLoc().getX(),zip1.getLoc().getY(),zip2.getLoc().getX(),zip2.getLoc().getY());
		model.addAttribute("distancia",distancia);
		System.out.println("distancia entre as duas =" + distancia);

		model.addAttribute("cidadeOrigem",zip1.getCity() + " (" + zip1.getState() + ")");
		model.addAttribute("cidadeDestino",zip2.getCity() + " (" + zip2.getState() + ")");

		model.addAttribute("latitudeOrigem",zip1.getLoc().getX());
		model.addAttribute("longitudeOrigem",zip1.getLoc().getY());

		model.addAttribute("latitudeDestino",zip2.getLoc().getX());
		model.addAttribute("longitudeDestino",zip2.getLoc().getY());

		return "calcular";

	}

}
