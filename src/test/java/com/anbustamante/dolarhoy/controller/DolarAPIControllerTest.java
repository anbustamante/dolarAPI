package com.anbustamante.dolarhoy.controller;

import com.anbustamante.dolarhoy.model.ResponseDto;
import com.anbustamante.dolarhoy.service.DolarAPIService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DolarAPIControllerTest {

    @Mock
    private DolarAPIService serviceMock;

    @InjectMocks
    private DolarAPIController controllerimpl;



    @Test
    @Tag("int:1")
    @DisplayName("retrieveDolarByType mapea bien blue.")
    void retrieveDolarByType_blue_map_correctly() throws IOException {
        when(serviceMock.getDolarByType("blue")).thenReturn(
                new ResponseDto(
                        "blue", LocalDateTime.now(),"$312","$316"));


        ResponseEntity<ResponseDto> response = controllerimpl.retrieveDolarByType("blue");
        assertEquals(response.getStatusCodeValue(),200);
        assertEquals(response.getBody().getType(), "blue");
        assertEquals(response.getBody().getCompra(), "$312");
        assertEquals(response.getBody().getVenta(), "$316");
    }

    @Test
    @Tag("int:2")
    @DisplayName("retrieveDolarByType devuelve http 200.")
    void retrieveDolarByType_expects_200() throws IOException {
        when(serviceMock.getDolarByType("blue")).thenReturn(
                new ResponseDto(
                        "blue", LocalDateTime.now(),"$312","$316"));
        ResponseEntity<ResponseDto> response = controllerimpl.retrieveDolarByType("blue");
        assertEquals(response.getStatusCodeValue(),200);
    }


}