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

import com.boaglio.casadocodigo.mongodb.model.Zip;
import com.boaglio.casadocodigo.mongodb.util.CalculaDistancia;

@Repository
public class ZipsRepository {

	public static final Double RAIO_DE_DISTANCIA_EM_KM = 90.0d;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Zip> findAll() {

		List<Zip> zips = new ArrayList<Zip>();
		Query query = new Query();
		query.with(new Sort(Sort.Direction.ASC,"city"));
		zips = mongoTemplate.find(query,Zip.class);

		System.out.println("total de cidades = " + zips.size());
		return zips;
	}

	public Zip findById(String id) {

		Zip zip = new Zip();
		System.out.println("busca por id = " + id);

		Query queryDeBuscaPorID = new Query(Criteria.where("id").is(id));

		zip = mongoTemplate.findOne(queryDeBuscaPorID,Zip.class);

		return zip;
	}

	public List<Zip> findCidadesProximas(Double x,Double y) {

		List<Zip> zips = new ArrayList<Zip>();

		Criteria criteria = new Criteria("loc").near(new Point(x,y)).maxDistance(CalculaDistancia.getInKilometer(RAIO_DE_DISTANCIA_EM_KM));
		Query buscaCidades = new Query(criteria);
		zips = mongoTemplate.find(buscaCidades.limit(11),Zip.class);

		zips.remove(zips.get(0));

		System.out.println("total de cidades proximas = " + zips.size());

		return zips;
	}

}
