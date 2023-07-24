package org.conacry.caero.domain.entity;

public class Aircraft {
    private final AircraftID aircraftID;
    private final Model model;

    public static Aircraft of(AircraftID aircraftID, Model model) {
        if (aircraftID == null) {
            throw AircraftError.errAircraftIDValueIsRequired();
        }

        if (model == null) {
            throw AircraftError.errModelIsRequired();
        }

        return new Aircraft(aircraftID, model);
    }

    private Aircraft(AircraftID aircraftID, Model model) {
        this.aircraftID = aircraftID;
        this.model = model;
    }

    public AircraftID getAircraftID() {
        return aircraftID;
    }

    public Model getModel() {
        return model;
    }
}
