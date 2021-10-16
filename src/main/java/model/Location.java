package model;

import java.math.BigDecimal;

public class Location {
    public String city;
    public String country;
    public BigDecimal latitude;
    public BigDecimal longitude;
    Location(){}

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public BigDecimal getLatitude() {
        return this.latitude;
    }

    public BigDecimal getLongitude() {
        return this.longitude;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
