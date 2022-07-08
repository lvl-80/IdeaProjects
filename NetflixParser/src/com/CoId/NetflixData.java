package com.CoId;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class NetflixData {
    private static final List<NetflixDataElement> NetflixElementsList = new ArrayList<>();
    public static void add(NetflixDataElement _element){
        NetflixElementsList.add(_element);
    }
    public List<NetflixDataElement> getNetflixElementsList(){
        return NetflixElementsList;
    }
    @JsonAutoDetect
    static class NetflixDataElement{
        private final String title;
        private final String href;
        NetflixDataElement(@JsonProperty("title") String _title,
                           @JsonProperty("href") String _href){
            title = _title;
            href = _href;
            NetflixData.add(this);
        }
        public String getTitle() {
            return title;
        }
        public String getHref(){
            return href;
        }
    }

}
