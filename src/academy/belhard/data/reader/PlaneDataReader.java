package academy.belhard.data.reader;

import academy.belhard.builder.PlaneBuilder;
import academy.belhard.entity.Plane;
import academy.belhard.exception.EmptyDataFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDataReader implements FileDataReader<Plane> {
    private final String fileName;

    public PlaneDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Plane> read() throws EmptyDataFileException {
        List<Plane> planes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String planesLine;

            while ((planesLine = reader.readLine()) != null) {
                Plane plane = PlaneBuilder.build(planesLine);

                planes.add(plane);
            }
            if (planes.size() == 0) {
                throw new EmptyDataFileException(fileName, "пуст");
            }
        } catch (FileNotFoundException e) {
            throw new EmptyDataFileException(fileName, "не найден");
        } catch (IOException e) {
            e.getMessage();
        }
        return planes;
    }
}
