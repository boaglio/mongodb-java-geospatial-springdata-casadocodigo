package com.boaglio.casadocodigo.mongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	private static final String SERVIDOR_MONGODB = "127.0.0.1";
	private static final String BANCO_DE_DADOS = "test";

	@Override
	public String getDatabaseName() {
		return BANCO_DE_DADOS;
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		return new MongoClient(SERVIDOR_MONGODB);
	}
}
