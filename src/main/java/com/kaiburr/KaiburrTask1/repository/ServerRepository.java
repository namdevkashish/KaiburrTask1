package com.kaiburr.KaiburrTask1.repository;

import com.kaiburr.KaiburrTask1.model.Server;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServerRepository extends MongoRepository<Server, String> {
    List<Server> findByName(String name);
}
