package academy.belhard.dataWriter;

import academy.belhard.entity.FullData;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FullInfoWriter {

    public static void writer(List<FullData> result, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (FullData fullData : result) {
                writer.write(fullData.getFlightNumber() + ";" +
                        fullData.getFlightDate() + ";" +
                        fullData.getFlightTime() + ";" +
                        fullData.getPlaneTaleNumber() + ";" +
                        fullData.getPlaneBrandModel() + ";" +
                        fullData.getPlaneCapacity() + ";" +
                        fullData.getPilotFullName() + ";" +
                        fullData.getPilotCodeRang() +
                        "\n");
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}