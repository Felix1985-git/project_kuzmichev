package academy.belhard;


import academy.belhard.data.reader.FlightDataReader;
import academy.belhard.data.reader.PilotDataReader;
import academy.belhard.data.reader.PlaneDataReader;
import academy.belhard.data.writer.FullInfoWriter;
import academy.belhard.db.reader.FullDataReader;
import academy.belhard.db.writer.FlightWriter;
import academy.belhard.db.writer.PilotWriter;
import academy.belhard.db.writer.PlaneWriter;
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
