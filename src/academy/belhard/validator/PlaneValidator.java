package academy.belhard.validator;

import academy.belhard.entity.Plane;
import academy.belhard.exception.NullFieldException;

public class PlaneValidator {

    public static void validatePlane(Plane plane) {

        if (plane.getBrand() == null) {
            throw new NullFieldException("brand");
        }

        if (plane.getModel() == null) {
            throw new NullFieldException("model");
        }

        if (plane.getCapacity() <= 0) {
            throw new NullFieldException("capacity");
        }

        if (plane.getTaleNumber() == null) {
            throw new NullFieldException("taleNumber");
        }

    }
}