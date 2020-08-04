package com.boaglio.casadocodigo.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boaglio.casadocodigo.mongodb.model.Municipio;
import com.boaglio.casadocodigo.mongodb.repository.MunicipioRepository;
import com.boaglio.casadocodigo.mongodb.util.CalculaDistancia;

@Controller
public class MunicipioController {

	@Autowired
	private MunicipioRepository repository;

	@GetMapping("/home")
	public String index(ModelMap model) {

		List<Municipio> municipios = repository.findAll();
		model.addAttribute("municipios",municipios);
		return "home";

	}

	@PostMapping("/calcular")
	public String detalhe(@RequestParam("idCidadeOrigem") String idCidadeOrigem,@RequestParam("idCidadeDestino") String idCidadeDestino,ModelMap model) {

		Municipio municipioOrigem = repository.findById(idCidadeOrigem);
		System.out.println("cidade origem =" + municipioOrigem);
		Municipio municipioDestino = repository.findById(idCidadeDestino);
		System.out.println("cidade destino =" + municipioDestino);

		double distancia = CalculaDistancia.distance(municipioOrigem.getLoc().getX(),municipioOrigem.getLoc().getY(),municipioDestino.getLoc().getX(),municipioDestino.getLoc().getY());
		model.addAttribute("distancia",distancia);
		System.out.println("distancia entre as duas =" + distancia);

		model.addAttribute("cidadeOrigem",municipioOrigem.getNome() + " (" + municipioOrigem.getEstado()+ ")");
		model.addAttribute("cidadeDestino",municipioDestino.getNome() + " (" + municipioDestino.getEstado() + ")");

		model.addAttribute("latitudeOrigem",municipioOrigem.getLoc().getX());
		model.addAttribute("longitudeOrigem",municipioOrigem.getLoc().getY());

		model.addAttribute("latitudeDestino",municipioDestino.getLoc().getX());
		model.addAttribute("longitudeDestino",municipioDestino.getLoc().getY());

		List<Municipio> cidadesProximas = repository.findCidadesProximas(municipioDestino.getLoc().getX(),municipioDestino.getLoc().getY());
		model.addAttribute("cidadesProximas",cidadesProximas);

		return "calcular";

	}

}
