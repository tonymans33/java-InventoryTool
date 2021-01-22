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

        Instrument instrument = new Instrument(serialNumber, price, spec);

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

    // Function to search for a spec instrument and return list of the matched instruments
    public List search(InstrumentSpec searchSpec){

        List matchingInstruments  = new LinkedList(); // Making a linked list of the guitars that match with the given spec
        for (Iterator i = inventory.iterator(); i.hasNext() ;){

            Instrument instrument = (Instrument) i.next();
            if(instrument.getSpec().matches(searchSpec)){ // Calling the matches function to check if match
                matchingInstruments.add(instrument);
            }

        }

        return matchingInstruments; // return a list of all matching guitars
    }





}
