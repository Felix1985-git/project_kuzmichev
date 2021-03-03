package academy.belhard.dataReader;

import academy.belhard.builder.PilotBuilder;
import academy.belhard.entity.Pilot;
import academy.belhard.exception.EmptyDataFileException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PilotDataReader implements FileDataReader<Pilot> {
    private final String fileName;

    public PilotDataReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Pilot> read() throws EmptyDataFileException {
        List<Pilot> pilots = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String pilotLine;

            while ((pilotLine = reader.readLine()) != null) {
                Pilot pilot = PilotBuilder.build(pilotLine);

                pilots.add(pilot);
            }
            if (pilots.size() == 0) {
                throw new EmptyDataFileException("Файл для чтения пуст");
            }
        } catch (FileNotFoundException e) {
            throw new EmptyDataFileException("Файл для чтения не найден");
        } catch (IOException e) {
            e.getMessage();
        }
        return pilots;
    }
}