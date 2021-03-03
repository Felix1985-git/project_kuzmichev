package academy.belhard.builder;

import academy.belhard.entity.Flight;
import academy.belhard.validator.FlightValidator;

import java.sql.Date;
import java.sql.Time;

public class FlightBuilder {
    public static Flight build(String flightsLine) {
        String[] flightsData = flightsLine.split(";");

        int id = Integer.parseInt(flightsData[0]);
        Integer planesId = Integer.valueOf(flightsData[1]);
        Integer pilotsId = Integer.valueOf(flightsData[2]);
        Date date = Date.valueOf(flightsData[3]);
        Time time = Time.valueOf(flightsData[4]);
        String number = flightsData[5];

        Flight flight = new Flight(id, planesId, pilotsId, date, time, number);

        FlightValidator.validateFlight(flight);

        return flight;
    }
}