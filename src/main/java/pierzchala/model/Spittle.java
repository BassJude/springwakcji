package pierzchala.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Spittle {

    private Long id;
    private String message;
    private Date time;
    // kasuje final z powyzszych, nie wiem po co to było ..

    private Double latitude;
    private Double longitude;

    public Spittle() {
    }

    public Spittle(String message, Date time) {
        this(message, time, null, null);
    }

    public Spittle(
            String message, Date time, Double longitude, Double latitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude = longitude;

        this.latitude = latitude;
    }
//    public long getId() {
//        return id;
//    }
//    public String getMessage() {
//        return message;
//    }
//    public Date getTime() {
//        return time;
//    }
//    public Double getLongitude() {
//        return longitude;
//    }
//    public Double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(Double latitude) {
//        this.latitude = latitude;
//    }
//
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }


    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id", "time");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id", "time");
    }
}
