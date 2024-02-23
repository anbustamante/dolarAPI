package com.anbustamante.dolarhoy.service;

import com.anbustamante.dolarhoy.model.ResponseDto;
import com.anbustamante.dolarhoy.util.NotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DolarAPIService {

    private ResponseDto getDolarBlue() throws IOException {
        try {
            String[] valoresArray = scrapping(
                    "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[1]/div/div[1]/div[1]/div[2]",
                    "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[1]/div/div[1]/div[2]/div[2]"
            );
            return mapping("blue",valoresArray[0],valoresArray[1]);
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }

    private ResponseDto getDolarOficial() throws IOException {
        try {
            String[] valoresArray = scrapping(
                    "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[2]",
                    "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div[2]"
                    );
            return mapping("oficial",valoresArray[0],valoresArray[1]);
        } catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }

    private ResponseDto getDolarMep() throws IOException {
        try {
            String[] valoresArray = scrapping(
                    "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div[4]/div/div[1]/div[2]",
                    "/html/body/div[3]/div[2]/div[1]/div[1]/div[2]/section/div/div/div/div[1]/div/div[2]/div[4]/div/div[2]/div[2]"
            );
            return mapping("mep",valoresArray[0],valoresArray[1]);
        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }

    public ResponseDto getDolarByType(String type) throws IOException {
            if (type.equals("blue")) {
                return getDolarBlue();
            } else if (type.equals("oficial")){
                return getDolarOficial();
            }else if (type.equals("mep")){
                return getDolarOficial();
            }else {
                throw new NotFoundException("Type not found");
            }
    }

    public ResponseDto mapping(String type, String valorCompra, String valorVenta){
        ResponseDto dto = new ResponseDto();
        dto.setType(type);
        dto.setFecha(LocalDateTime.now());
        dto.setCompra(valorCompra);
        dto.setVenta(valorVenta);
        return dto;
    }

    public String[] scrapping(String XPath1, String XPath2) throws IOException {
        Document doc = getDoc();
        return scrapFromXPaths(doc,XPath1,XPath2);
    }

    public Document getDoc() throws IOException {
        final String URL = "https://dolarhoy.com/";
        final Document doc = Jsoup.connect(URL).get();
        return doc;
    }

    public String[] scrapFromXPaths(Document doc,String XPath1, String XPath2) throws IOException {
        String[] values = new String[2];
        values[0] = doc.selectXpath(XPath1).text();
        values[1] = doc.selectXpath(XPath2).text();
        return values;


    }


}
