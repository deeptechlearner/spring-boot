package com.example.demo.controller;

import com.example.demo.model.InputRequestModel;
import com.example.demo.model.OutPutRespModel;
import com.example.demo.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @PutMapping("/v1/hello")
    public ResponseEntity<OutPutRespModel> getRecords(@RequestBody InputRequestModel inputRequestModel){
        OutPutRespModel respModel = helloWorldService.CheckForNullOrEmpty(inputRequestModel);
        return new ResponseEntity<>(respModel, HttpStatus.OK);
    }
}
