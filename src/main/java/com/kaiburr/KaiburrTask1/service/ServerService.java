package com.kaiburr.KaiburrTask1.service;

import com.kaiburr.KaiburrTask1.model.Server;

import java.util.List;
import java.util.Optional;
//import java.util.*;

public interface ServerService {

    List<Server> findAll();

    Optional<Server> findById(String Id);

    void createOrUpdateServer(Server server);

    void deleteServerById(String Id);

    List<Server> findByName(String name);
}
