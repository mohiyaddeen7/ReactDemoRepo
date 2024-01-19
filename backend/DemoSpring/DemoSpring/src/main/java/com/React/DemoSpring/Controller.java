package com.React.DemoSpring;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class Controller {

    private Service service;

    public Controller(Service service) {
        super();
        this.service = service;
    }

    @PostMapping("/addUser")
    public ResponseEntity<Model> addUser (@RequestBody Model model)
    {
        return service.createUser(model);
    }

    @GetMapping("/getUsers")
    public List<Model> getAllUsers()
    {
        return service.getUsers();
    }
}
