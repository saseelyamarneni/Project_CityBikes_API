package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Networks {
    private String id;
    private String href;
    @JsonDeserialize(using = CustomStringDeserializer.class)
    private List<String> company;
    private Location location;
    private String source;
    private String name;
    private License license;
    private String gbfs_href;

    Networks(){}

    public String getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public List<String> getCompany() {
        return company;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getGbfs_href() {
        return gbfs_href;
    }
    public License getLicense() {
        return license;
    }
}
