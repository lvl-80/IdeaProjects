package com.CoId;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    private final static String WEB = "https://www.netflix.com/by-ru/browse/genre/1191605";
    private final static NetflixData NETFLIX_DATA = new NetflixData();

    public static void main(String[] args) throws IOException {
        if (!Paths.get("/Users/nikitasudaev/IdeaProjects/NetflixParser/Data.json").toFile().exists())
            Paths.get("/Users/nikitasudaev/IdeaProjects/NetflixParser/Data.json").toFile().createNewFile();

        Document document = Jsoup.connect(WEB)
                .userAgent("Chrome")
                .get();
        Elements elements = document.select("a.nm-collections-title");
        elements.select("span.nm-collections-title-name")
                .forEach((element) -> new NetflixData.NetflixDataElement(element.text(),element.parent().attr("href")));

        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(
                Paths.get("/Users/nikitasudaev/IdeaProjects/NetflixParser/Data.json").toFile(),
                NETFLIX_DATA.getNetflixElementsList());


        NetflixData.NetflixDataElement[] des = mapper.readValue(
                Paths.get("/Users/nikitasudaev/IdeaProjects/NetflixParser/Data.json").toFile(),
                NetflixData.NetflixDataElement[].class
        );
        Arrays.stream(des).forEach(element -> System.out.println(element.getTitle()));
    }
}
