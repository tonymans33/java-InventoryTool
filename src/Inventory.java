import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Inventory class that have a list of guitars and methods for insert, display and search for spec guitar
public class Inventory {

    private List guitars;

    public Inventory(){
        guitars = new LinkedList();
    }

    // Function to add guitar
    public void addGuitar(String serialNumber, double price, GuitarSpec spec){

        Guitar guitar = new Guitar(serialNumber, price, spec); // Making a new object of guitar
        guitars.add(guitar); // Added it to the list

    }

    // Function to get spec guitar
    public Guitar getGuitar(String serialNumber){

        for (Iterator i = guitars.iterator(); i.hasNext() ;){
            Guitar guitar = (Guitar)i.next();
            if(guitar.getSerialNumber().equals(serialNumber)){
                return guitar;
            }

        }
        return null;
    }

    // Function to search for a spec guitar and return list of the matched guitars
    public List search(GuitarSpec searchSpec){

        List matchingGuitars  = new LinkedList(); // Making a linked list of the guitars that match with the given spec
        for (Iterator i = guitars.iterator(); i.hasNext() ;){

            Guitar guitar = (Guitar)i.next();
            GuitarSpec guitarSpec = guitar.getSpec();

            if(guitar.getSpec().matches(searchSpec)){ // Calling the matches function to check if match
                matchingGuitars.add(guitar);
            }

        }

        return matchingGuitars; // return a list of all matching guitars
    }

}
