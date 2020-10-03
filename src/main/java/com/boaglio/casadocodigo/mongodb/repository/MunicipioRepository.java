package com.boaglio.casadocodigo.mongodb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.boaglio.casadocodigo.mongodb.model.Municipio;
import com.boaglio.casadocodigo.mongodb.util.CalculaDistancia;
 
 
@Repository
public class MunicipioRepository {

	private static final int QT_MUNICIPIOS_PROXIMOS = 11;

	public static final Double RAIO_DE_DISTANCIA_EM_KM = 90.0d;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Municipio> findAll() {

		List<Municipio> municipios = new ArrayList<>();
		Query query = new Query();		
     	query.with(Sort.by(Sort.Direction.ASC,"nome"));
		municipios = mongoTemplate.find(query,Municipio.class);
		System.out.println("findAll="+query);
		System.out.println("total de municipios = " + municipios.size());
		return municipios;
	}

	public Municipio findById(String id) {

		Municipio municipio = new Municipio();
		System.out.println("busca por id = " + id);

		Query queryDeBuscaPorID = new Query(Criteria.where("_id").is(Double.parseDouble(id)));
		System.out.println("findById="+queryDeBuscaPorID);

		municipio = mongoTemplate.findOne(queryDeBuscaPorID,Municipio.class);

		return municipio;
	}

	public List<Municipio> findMunicipiosProximos(Double x,Double y) {

		List<Municipio> municipios = new ArrayList<Municipio>();

		Criteria criteria = new Criteria("loc").near(new Point(x,y)).maxDistance(CalculaDistancia.getInKilometer(RAIO_DE_DISTANCIA_EM_KM));
		Query buscaMunicipios = new Query(criteria);
		System.out.println("findMunicipiosProximos="+buscaMunicipios);
		
		municipios = mongoTemplate.find(buscaMunicipios.limit(QT_MUNICIPIOS_PROXIMOS),Municipio.class);

		municipios.remove(municipios.get(0));

		System.out.println("total de municípios proximos = " + municipios.size());

		return municipios;
	}

}
