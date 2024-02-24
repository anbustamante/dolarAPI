package com.anbustamante.dolarhoy.controller;

import com.anbustamante.dolarhoy.model.ResponseDto;
import com.anbustamante.dolarhoy.service.DolarAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

@Controller
public class DolarAPIController {

    private DolarAPIService service;

    @Autowired
    public DolarAPIController(DolarAPIService service) {
        this.service = service;
    }


    @GetMapping("/dolar/{type}")
    public ResponseEntity<ResponseDto> retrieveDolarByType(@PathVariable String type) throws IOException {
        return ResponseEntity.ok(service.getDolarByType(type));
    }
}
