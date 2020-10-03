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
	public String detalhe(@RequestParam("idMunicipioOrigem") String idMunicipioOrigem,@RequestParam("idMunicipioDestino") String idMunicipioDestino,ModelMap model) {

		Municipio municipioOrigem = repository.findById(idMunicipioOrigem);
		System.out.println("municipio origem =" + municipioOrigem);
		Municipio municipioDestino = repository.findById(idMunicipioDestino);
		System.out.println("municipio destino =" + municipioDestino);

		double distancia = CalculaDistancia.distance(municipioOrigem.getLoc().getX(),municipioOrigem.getLoc().getY(),municipioDestino.getLoc().getX(),municipioDestino.getLoc().getY());
		model.addAttribute("distancia",distancia);
		System.out.println("distancia entre as duas =" + distancia);

		model.addAttribute("municipioOrigem",municipioOrigem.getNome() + " (" + municipioOrigem.getEstado()+ ")");
		model.addAttribute("municipioDestino",municipioDestino.getNome() + " (" + municipioDestino.getEstado() + ")");

		model.addAttribute("latitudeOrigem",municipioOrigem.getLoc().getX());
		model.addAttribute("longitudeOrigem",municipioOrigem.getLoc().getY());

		model.addAttribute("latitudeDestino",municipioDestino.getLoc().getX());
		model.addAttribute("longitudeDestino",municipioDestino.getLoc().getY());

		List<Municipio> municipiosProximos = repository.findMunicipiosProximos(municipioDestino.getLoc().getX(),municipioDestino.getLoc().getY());
		model.addAttribute("municipiosProximos",municipiosProximos);

		return "calcular";

	}

}
