package academy.belhard;

import academy.belhard.dataReader.FlightDataReader;
import academy.belhard.dataReader.PilotDataReader;
import academy.belhard.dataReader.PlaneDataReader;
import academy.belhard.dataWriter.FullInfoWriter;
import academy.belhard.dbReader.FullDataReader;
import academy.belhard.dbWriter.FlightWriter;
import academy.belhard.dbWriter.PilotWriter;
import academy.belhard.dbWriter.PlaneWriter;
import academy.belhard.entity.Flight;
import academy.belhard.entity.FullData;
import academy.belhard.entity.Pilot;
import academy.belhard.entity.Plane;
import academy.belhard.exception.EmptyDataFileException;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        PilotDataReader pilotDataReader = new PilotDataReader("db\\data\\pilots.csv");
        try {
            List<Pilot> pilots = pilotDataReader.read();
            PilotWriter.write(pilots);
        } catch (EmptyDataFileException e) {
            System.err.println(e.getMessage());
        }

        PlaneDataReader planeDataReader = new PlaneDataReader("db\\data\\planes.csv");
        try {
            List<Plane> planes = planeDataReader.read();
            PlaneWriter.write(planes);
        } catch (EmptyDataFileException e) {
            System.err.println(e.getMessage());
        }

        FlightDataReader flightDataReader = new FlightDataReader("db\\data\\flights.csv");
        try {
            List<Flight> flights = flightDataReader.read();
            FlightWriter.write(flights);
        } catch (EmptyDataFileException e) {
            System.err.println(e.getMessage());
        }
        FullDataReader fullDataReader = new FullDataReader();
        List<FullData> result = fullDataReader.read();
        FullInfoWriter.writer(result,"result\\result.csv");

    }
}
