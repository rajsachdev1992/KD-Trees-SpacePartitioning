
package project2;

import java.math.BigDecimal;

/**
 * This class defines the model of a crime record.
 */
public class CrimeRecord {

    private BigDecimal x;       //x coordinate
    private BigDecimal y;       //y coordinate
    private long time;          //time of incident 
    private String street;      //street name of incident
    private String offense;     //offense/ type of incident
    private String date;        //date of incident
    private long tract;
    private BigDecimal latitude;    //latitude of incident location
    private BigDecimal longitude;   //longitude of incident location

    public CrimeRecord() {
        //default contructor
    }

    public CrimeRecord(BigDecimal x, BigDecimal y, long time, String street,
            String offense, String date, long tract, BigDecimal latitude, BigDecimal longitude) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.street = street;
        this.offense = offense;
        this.date = date;
        this.tract = tract;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getOffense() {
        return offense;
    }

    public void setOffense(String offense) {
        this.offense = offense;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTract() {
        return tract;
    }

    public void setTract(long tract) {
        this.tract = tract;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + time + "," + street + "," + offense + ","
                + date + "," + tract + "," + latitude + "," + longitude;
    }

}
