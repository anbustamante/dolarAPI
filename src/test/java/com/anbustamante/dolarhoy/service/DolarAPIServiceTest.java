package com.anbustamante.dolarhoy.service;

import com.anbustamante.dolarhoy.model.ResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DolarAPIServiceTest {
    private DolarAPIService dolarAPIService;

    @Autowired public DolarAPIServiceTest() {
        this.dolarAPIService = new DolarAPIService();
    }

    @Test
    @Tag("task:1")
    @DisplayName("Hace el mapeo correcto")
    void mapping() {
        ResponseDto dto1 = dolarAPIService.mapping("tipoDeDolar","$312","$316");
        assertEquals("tipoDeDolar", dto1.getType());
        assertEquals("$312", dto1.getCompra());
        assertEquals("$316", dto1.getVenta());
    }
}