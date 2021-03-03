package academy.belhard.entity;

import java.sql.Date;
import java.sql.Time;


public class Flight {
    private int id;
    private Integer planesId;
    private Integer pilotsId;
    private Date date;
    private Time time;
    private String number;


    public Flight(int id, Integer planesId, Integer pilotsId, Date date, Time time, String number) {
        this.id = id;
        this.planesId = planesId;
        this.pilotsId = pilotsId;
        this.date = date;
        this.time = time;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public Integer getPlanesId() {
        return planesId;
    }

    public Integer getPilotsId() {
        return pilotsId;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", first_name='" + planesId + '\'' +
                ", last_name='" + pilotsId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
