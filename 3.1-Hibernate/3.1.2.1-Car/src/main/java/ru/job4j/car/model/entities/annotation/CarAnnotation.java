package ru.job4j.car.model.entities.annotation;

import javax.persistence.*;

/**
 * Class CarXML.
 */
@Entity
@Table(name = "car")
public class CarAnnotation extends BaseEntityAnnotation {
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private EngineAnnotation engine;
    @ManyToOne
    @JoinColumn(name = "transmission_id")
    private TransmissionAnnotation transmission;
    @ManyToOne
    @JoinColumn(name = "carbody_id")
    private CarbodyAnnotation carbody;

    /**
     * getEngine.
     * @return engine
     */
    public EngineAnnotation getEngine() {
        return engine;
    }

    /**
     * setEngine.
     * @param engine set engine
     */
    public void setEngine(EngineAnnotation engine) {
        this.engine = engine;
    }
    /**
     * getTransmission.
     * @return transmission
     */
    public TransmissionAnnotation getTransmission() {
        return transmission;
    }
    /**
     * setTransmission.
     * @param transmission set transmission
     */
    public void setTransmission(TransmissionAnnotation transmission) {
        this.transmission = transmission;
    }
    /**
     * getCarbody.
     * @return carbody
     */
    public CarbodyAnnotation getCarbody() {
        return carbody;
    }
    /**
     * setCarbody
     * @param carbody set carbody
     */
    public void setCarbody(CarbodyAnnotation carbody) {
        this.carbody = carbody;
    }
}
