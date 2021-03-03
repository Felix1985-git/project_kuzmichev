package academy.belhard.builder;

import academy.belhard.entity.Pilot;
import academy.belhard.entity.Rang;
import academy.belhard.validator.PilotValidator;

public class PilotBuilder {
    public static Pilot build(String pilotLine) {
        String[] pilotData = pilotLine.split(";");

        int id = Integer.parseInt(pilotData[0]);
        String firstName = pilotData[1];
        String lastName = pilotData[2];
        Rang rang = Rang.valueOf(pilotData[3]);
        String code = pilotData[4];

        Pilot pilot = new Pilot(id, firstName, lastName, rang, code);

        PilotValidator.validatePilot(pilot);

        return pilot;
    }
}
