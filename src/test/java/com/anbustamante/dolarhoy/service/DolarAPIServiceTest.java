package com.anbustamante.dolarhoy.service;

import com.anbustamante.dolarhoy.model.ResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DolarAPIServiceTest {
    private DolarAPIService service;

    @Autowired public DolarAPIServiceTest() {
        this.service = new DolarAPIService();
    }

    @Test
    @Tag("task:1")
    @DisplayName("Hace el mapeo correcto")
    void mapping_basicScenario() {
        ResponseDto dto1 = service.mapping("tipoDeDolar","$312","$316");
        assertEquals("tipoDeDolar", dto1.getType());
        assertEquals("$312", dto1.getCompra());
        assertEquals("$316", dto1.getVenta());

    }

    @Test
    @Tag("task:2")
    @DisplayName("Trae un document desde dolarhoy.com")
    void getDoc_basicScenario() throws IOException {
        Document doc =  service.getDoc();
        assertEquals("https://dolarhoy.com/", doc.baseUri());
        assertNotEquals(null, doc.title());
    }

    @Test
    @Tag("task:3")
    @DisplayName("Scrapea correctamente lorem ipsum")
    void scrapFromXPaths_withLorem() throws IOException {
        final Document doc = Jsoup.connect("https://es.lipsum.com/").get();
        String[] values = service.scrapFromXPaths(doc,
                "/html/body/div/div[2]/h1",
                "/html/body/div/div[2]/div[1]/a[10]");
        System.out.println(values[0]);
        System.out.println(values[1]);
        assertEquals("Lorem Ipsum",values[0]);
        assertEquals("English", values[1]);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Scrapea correctamente dolarhoy")
    void scrapFromXPaths_withDolarHoy() throws IOException {
        final Document doc = Jsoup.connect("https://dolarhoy.com/").get();
        String[] values = service.scrapFromXPaths(doc,
                "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/div[2]",
                "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div[2]");
        System.out.println(values[0]);
        System.out.println(values[1]);
        assertEquals("Lorem Ipsum",values[0]);
        assertEquals("English", values[1]);
    }



}