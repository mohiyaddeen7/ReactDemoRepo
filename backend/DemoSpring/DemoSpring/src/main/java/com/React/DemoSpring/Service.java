package com.React.DemoSpring;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public ResponseEntity<Model> createUser(Model model)
    {
        return new ResponseEntity<Model>(repository.save(model), HttpStatus.CREATED);
    }

    public List<Model> getUsers()
    {
        return repository.findAll();
    }
}
