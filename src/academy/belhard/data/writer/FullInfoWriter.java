package academy.belhard.data.writer;

import academy.belhard.builder.CsvConstants;
import academy.belhard.entity.FullData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FullInfoWriter {

    public static void writer(List<FullData> result, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (FullData fullData : result) {
                writer.write(fullData.getFlightNumber() + CsvConstants.CSV_DELIMITER +
                        fullData.getFlightDate() + CsvConstants.CSV_DELIMITER +
                        fullData.getFlightTime() + CsvConstants.CSV_DELIMITER +
                        fullData.getPlaneTaleNumber() + CsvConstants.CSV_DELIMITER +
                        fullData.getPlaneBrandModel() + CsvConstants.CSV_DELIMITER +
                        fullData.getPlaneCapacity() + CsvConstants.CSV_DELIMITER +
                        fullData.getPilotFullName() + CsvConstants.CSV_DELIMITER +
                        fullData.getPilotCodeRang() +
                        "\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}