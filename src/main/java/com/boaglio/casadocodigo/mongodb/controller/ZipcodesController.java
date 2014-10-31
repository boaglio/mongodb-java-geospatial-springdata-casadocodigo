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

	@RequestMapping(value = "/calcular",method = RequestMethod.POST)
	public String detalhe(@RequestParam("idCidadeOrigem") String idCidadeOrigem,@RequestParam("idCidadeDestino") String idCidadeDestino,ModelMap model) {

		Zip zipOrigem = repository.findById(idCidadeOrigem);
		System.out.println("cidade origem =" + zipOrigem);
		Zip zipDestino = repository.findById(idCidadeDestino);
		System.out.println("cidade destino =" + zipDestino);

		double distancia = CalculaDistancia.distance(zipOrigem.getLoc().getX(),zipOrigem.getLoc().getY(),zipDestino.getLoc().getX(),zipDestino.getLoc().getY());
		model.addAttribute("distancia",distancia);
		System.out.println("distancia entre as duas =" + distancia);

		model.addAttribute("cidadeOrigem",zipOrigem.getCity() + " (" + zipOrigem.getState() + ")");
		model.addAttribute("cidadeDestino",zipDestino.getCity() + " (" + zipDestino.getState() + ")");

		model.addAttribute("latitudeOrigem",zipOrigem.getLoc().getX());
		model.addAttribute("longitudeOrigem",zipOrigem.getLoc().getY());

		model.addAttribute("latitudeDestino",zipDestino.getLoc().getX());
		model.addAttribute("longitudeDestino",zipDestino.getLoc().getY());

		List<Zip> cidadesProximas = repository.findCidadesProximas(zipDestino.getLoc().getX(),zipDestino.getLoc().getY());
		model.addAttribute("cidadesProximas",cidadesProximas);

		return "calcular";

	}

}
