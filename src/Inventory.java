import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List inventory;

    public Inventory(){
        inventory = new LinkedList();
    }

    // Function to add instrument
    public void addInstrument(String serialNumber, double price, InstrumentSpec spec){

        Instrument instrument = null;

        if(spec instanceof GuitarSpec){
            instrument = new Guitar(serialNumber, price, (GuitarSpec)spec);
        }else if (spec instanceof MandolinSpec){
            instrument = new Mandolin(serialNumber, price, (MandolinSpec)spec);
        }

        inventory.add(instrument);
    }

    // Function to get spec instrument
    public Instrument getInstrument(String serialNumber){

        for (Iterator i = inventory.iterator(); i.hasNext() ;){
            Instrument instrument = (Instrument)i.next();
            if(instrument.getSerialNumber().equals(serialNumber)){
                return instrument;
            }

        }
        return null;
    }

    // Function to search for a spec guitar and return list of the matched guitars
    public List search(GuitarSpec searchSpec){

        List matchingGuitars  = new LinkedList(); // Making a linked list of the guitars that match with the given spec
        for (Iterator i = inventory.iterator(); i.hasNext() ;){
            if (i instanceof Guitar){
                Guitar guitar = (Guitar)i.next();
                if(guitar.getSpec().matches(searchSpec)){ // Calling the matches function to check if match
                    matchingGuitars.add(guitar);
                }
            }

        }

        return matchingGuitars; // return a list of all matching guitars
    }

    // Function to search for a spec mandolin and return list of the matched mandolins
    public List search(MandolinSpec searchSpec){

        List matchingMandolins  = new LinkedList(); // Making a linked list of the mandolins that match with the given spec
        for (Iterator i = inventory.iterator(); i.hasNext() ;){

            Mandolin mandolin = (Mandolin) i.next();
            if(mandolin.getSpec().matches(searchSpec)){ // Calling the matches function to check if match
                matchingMandolins.add(mandolin);
            }

        }

        return matchingMandolins; // return a list of all matching guitars
    }

}
