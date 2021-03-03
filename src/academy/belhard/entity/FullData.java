package academy.belhard.entity;

import java.sql.Date;
import java.sql.Time;


public class FullData {
    private String flightNumber;
    private Date flightDate;
    private Time flightTime;
    private String planeTaleNumber;
    private String planeBrandModel;
    private Integer planeCapacity;
    private String pilotFullName;
    private String pilotCodeRang;

    public FullData(String flightNumber, Date flightDate, Time flightTime, String planeTaleNumber, String planeBrandModel, Integer planeCapacity, String pilotFullName, String pilotCodeRang) {
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.planeTaleNumber = planeTaleNumber;
        this.planeBrandModel = planeBrandModel;
        this.planeCapacity = planeCapacity;
        this.pilotFullName = pilotFullName;
        this.pilotCodeRang = pilotCodeRang;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public String getPlaneTaleNumber() {
        return planeTaleNumber;
    }

    public String getPlaneBrandModel() {
        return planeBrandModel;
    }

    public Integer getPlaneCapacity() {
        return planeCapacity;
    }

    public String getPilotFullName() {
        return pilotFullName;
    }

    public String getPilotCodeRang() {
        return pilotCodeRang;
    }

    @Override
    public String toString() {
        return "FullData{" +
                "flightNumber=" + flightNumber +
                ", flightDate='" + flightDate + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", planeTaleNumber='" + planeTaleNumber + '\'' +
                ", planeBrandModel='" + planeBrandModel + '\'' +
                ", planeCapacity='" + planeCapacity + '\'' +
                ", pilotFullName='" + pilotFullName + '\'' +
                ", pilotCodeRang='" + pilotCodeRang + '\'' +
                '}';
    }
}
