package com.anbustamante.dolarhoy.service;

import com.anbustamante.dolarhoy.model.BlueDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DolarAPIService {

    public BlueDto getDolarBlue() throws IOException {

        final String URL = "https://dolarhoy.com/";
        final Document doc = Jsoup.connect(URL).get();


        Elements valorCompra = doc.selectXpath("//div[contains(@class, 'tile is-parent is-5')]//div[contains(@class, 'tile is-child')]//div[contains(@class, 'values')]//div[contains(@class, 'compra')]//div[contains(@class, 'val')]");
        Elements valorVenta = doc.selectXpath("//div[contains(@class, 'tile is-parent is-5')]//div[contains(@class, 'tile is-child')]//div[contains(@class, 'values')]//div[contains(@class, 'venta')]//div[contains(@class, 'val')]");



        BlueDto dto = new BlueDto();
        dto.setFecha(LocalDateTime.now());
        dto.setCompra(valorCompra.text());
        dto.setVenta(valorVenta.text());
        System.out.println(dto.toString());
        return dto;
    }

    public BlueDto getDolarOficial() throws IOException {

        final String URL = "https://dolarhoy.com/";
        final Document doc = Jsoup.connect(URL).get();

        Elements divOficial = doc.selectXpath("//div[contains(@class, 'tile is-parent is-7 is-vertical')]");

        Elements valorCompra = doc.select("div.is-7:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)");
        Elements valorVenta = doc.selectXpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div[2]");



        BlueDto dto = new BlueDto();
        dto.setFecha(LocalDateTime.now());
        dto.setCompra(valorCompra.text());
        dto.setVenta(valorVenta.text());
        System.out.println(dto.toString());
        return dto;
    }

}
