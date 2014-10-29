package com.boaglio.casadocodigo.mongodb.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.boaglio.casadocodigo.mongodb.model.Zip;

@Repository
public class ZipsRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Zip> findAll() {

		List<Zip> zips = new ArrayList<Zip>();
		Query query = new Query();
		query.with(new Sort(Sort.Direction.ASC,"city"));
		zips = mongoTemplate.find(query,Zip.class);

		System.out.println("total de zips = " + zips.size());
		return zips;
	}

	public Zip findById(String id) {

		Zip zip = new Zip();
		System.out.println("busca por id = " + id);

		Query queryDeBuscaPorID = new Query(Criteria.where("id").is(id));

		zip = mongoTemplate.findOne(queryDeBuscaPorID,Zip.class);

		return zip;
	}

}
