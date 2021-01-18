// Main Guitar Class

public class Guitar {

    private String serialNumber, model;
    private double price;
    private GuitarSpec spec;


    // Guitar constructor that takes a serial number, price, object contains all the other guitar spec such as "model, wood, etc .."
    public Guitar(String serialNumber, double price, GuitarSpec spec){

        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;

    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public GuitarSpec getSpec(){
        return spec;
    }
}
