package academy.belhard.dataReader;

import academy.belhard.builder.FlightBuilder;
import academy.belhard.entity.Flight;
import academy.belhard.exception.EmptyDataFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightDataReader implements FileDataReader<Flight> {
    private final String fileName;

    public FlightDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Flight> read() throws EmptyDataFileException {
        List<Flight> flights = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String flightsLine;

            while ((flightsLine = reader.readLine()) != null) {
                Flight flight = FlightBuilder.build(flightsLine);

                flights.add(flight);
            }
            if (flights.size() == 0) {
                throw new EmptyDataFileException("Файл для чтения пуст");
            }
        } catch (FileNotFoundException e) {
            throw new EmptyDataFileException("Файл для чтения не найден");
        } catch (IOException e) {
            e.getMessage();
        }
        return flights;
    }
}
