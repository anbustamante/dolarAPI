package com.anbustamante.dolarhoy.controller;

import com.anbustamante.dolarhoy.model.BlueDto;
import com.anbustamante.dolarhoy.service.DolarAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class DolarAPIController {

    private DolarAPIService dolarAPIService;

    @Autowired
    public DolarAPIController(DolarAPIService dolarAPIService) {
        this.dolarAPIService = dolarAPIService;
    }

    @GetMapping("/dolar/blue")
    public ResponseEntity<BlueDto> getDolarBlue() throws IOException {
        return ResponseEntity.ok(dolarAPIService.getDolarBlue());
    }

    @GetMapping("/dolar/oficial")
    public ResponseEntity<BlueDto> getDolarOficial() throws IOException {
        return ResponseEntity.ok(dolarAPIService.getDolarOficial());
    }


}
