package ru.job4j.car.model.entities.xml;

/**
 * Class CarXML.
 */
public class CarXML extends BaseEntityXML {
    private EngineXML engine;
    private TransmissionXML transmission;
    private CarbodyXML carbody;

    /**
     * getEngine.
     * @return engine
     */
    public EngineXML getEngine() {
        return engine;
    }

    /**
     * setEngine.
     * @param engine set engine
     */
    public void setEngine(EngineXML engine) {
        this.engine = engine;
    }
    /**
     * getTransmission.
     * @return transmission
     */
    public TransmissionXML getTransmission() {
        return transmission;
    }
    /**
     * setTransmission.
     * @param transmission set transmission
     */
    public void setTransmission(TransmissionXML transmission) {
        this.transmission = transmission;
    }
    /**
     * getCarbody.
     * @return carbody
     */
    public CarbodyXML getCarbody() {
        return carbody;
    }
    /**
     * setCarbody
     * @param carbody set carbody
     */
    public void setCarbody(CarbodyXML carbody) {
        this.carbody = carbody;
    }
}
