package academy.belhard.validator;

import academy.belhard.entity.Flight;
import academy.belhard.exception.NullFieldException;


public class FlightValidator {

    public static void validateFlight(Flight flight) {

        if (flight.getDate() == null) {
            throw new NullFieldException("date");
        }

        if (flight.getTime() == null) {
            throw new NullFieldException("time");
        }

        if (flight.getNumber() == null) {
            throw new NullFieldException("number");
        }

        if (flight.getPlanesId() == null) {
            throw new NullFieldException("planesId");

        }

        if (flight.getPilotsId() == null) {
            throw new NullFieldException("pilotsId");
        }

    }
}
