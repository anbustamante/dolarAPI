package com.anbustamante.dolarhoy.service;

import com.anbustamante.dolarhoy.model.ResponseDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DolarAPIService {

    public ResponseDto getDolarBlue() throws IOException {
        try {
            final String URL = "https://dolarhoy.com/";
            final Document doc = Jsoup.connect(URL).get();
            String valorCompra = doc.selectXpath("//div[contains(@class, 'tile is-parent is-5')]//div[contains(@class, 'tile is-child')]//div[contains(@class, 'values')]//div[contains(@class, 'compra')]//div[contains(@class, 'val')]").text();
            String valorVenta = doc.selectXpath("//div[contains(@class, 'tile is-parent is-5')]//div[contains(@class, 'tile is-child')]//div[contains(@class, 'values')]//div[contains(@class, 'venta')]//div[contains(@class, 'val')]").text();
            return mapping("blue",valorCompra,valorVenta);
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }

    public ResponseDto getDolarOficial() throws IOException {
        try {
        final String URL = "https://dolarhoy.com/";
        final Document doc = Jsoup.connect(URL).get();
        String valorCompra = doc.select("div.is-7:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)").text();
        String valorVenta = doc.selectXpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div[2]").text();
        return mapping("oficial",valorCompra,valorVenta);
        } catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }


    private ResponseDto mapping(String type, String valorCompra, String valorVenta){
        ResponseDto dto = new ResponseDto();
        dto.setType(type);
        dto.setFecha(LocalDateTime.now());
        dto.setCompra(valorCompra);
        dto.setVenta(valorVenta);
        return dto;
    }


}
