import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Enum for type, builder, wood, instrument type to avoiding using string comparisons and misspelling a word
enum Type{

    ACOUSTIC, ELECTRIC;

    public String toString(){
        switch (this) {
            case ACOUSTIC : return  "acoustic";
            case ELECTRIC : return  "electric";
            default: return "";

        }
    }

}

enum Builder{

    MARTIN, FENDER, PRS, OLSON, GIBSON, COLLINGS;

    public String toString(){

        switch (this) {
            case MARTIN : return  "martin";
            case FENDER : return  "fender";
            case PRS : return  "prs";
            case OLSON : return  "olson";
            case GIBSON : return  "gibson";
            case COLLINGS : return  "collings";
            default: return "";
        }
    }

}

enum Wood{

    ALDER, STIKA, MAPLE, INDIAN_ROSEWOOD, MAHOGANY, ADIRONDACK;

    public String toString(){
        switch (this) {
            case ALDER : return "alder";
            case STIKA : return "stika";
            case MAPLE : return "maple";
            case INDIAN_ROSEWOOD : return "indian_rosewood";
            case MAHOGANY : return "mahogany";
            case ADIRONDACK : return "adirondack";
            default: return "";

        }
    }

}

enum Style{

    A, F;

    public String toString(){
        switch (this) {
            case A : return "a";
            case F : return "f";
            default: return "";

        }
    }


}

enum InstrumentType{

    GUITAR, BANJO, DOBRO, FIDDLE, BASS, MANDOLIN;

    public String toString(){
        switch (this) {
            case GUITAR : return "guitar";
            case BANJO : return "banjo";
            case DOBRO : return "dobro";
            case FIDDLE : return "fiddle";
            case BASS : return "bass";
            case MANDOLIN : return "mandolin";
            default: return "unspecified";

        }
    }

}




public class Tool {

    // A function to add some instruments to the inventory
    private static void initInventory(Inventory inventory){

        Map properties = new HashMap();
        properties.put("instrumentType", InstrumentType.GUITAR);
        properties.put("builder", Builder.COLLINGS);
        properties.put("model", "CJ");
        properties.put("type", Type.ACOUSTIC);
        properties.put("numStrings", 6);
        properties.put("topWood", Wood.INDIAN_ROSEWOOD);
        properties.put("backWood", Wood.STIKA);
        inventory.addInstrument("11277", 3999.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.MARTIN);
        properties.put("model", "D-18");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.ADIRONDACK);
        inventory.addInstrument("122784", 5495.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.FENDER);
        properties.put("model", "Stratocastor");
        properties.put("type", Type.ELECTRIC);
        properties.put("topWood", Wood.ALDER);
        properties.put("backWood", Wood.ALDER);
        inventory.addInstrument("V95693", 1499.95, new InstrumentSpec(properties));
        inventory.addInstrument("V9512", 1549.95, new InstrumentSpec(properties));

        properties.put("builder", Builder.GIBSON);
        properties.put("model", "les paul");
        properties.put("topWood", Wood.MAPLE);
        properties.put("backWood", Wood.MAPLE);
        inventory.addInstrument("7019283", 2295.95, new InstrumentSpec(properties));

        properties.put("model", "SG '61 Reissue'");
        properties.put("topWood", Wood.MAHOGANY);
        properties.put("backWood", Wood.MAHOGANY);
        inventory.addInstrument("9299371", 1890.09, new InstrumentSpec(properties));

        properties.put("instrumentType", InstrumentType.MANDOLIN);
        properties.put("model", "F-5G");
        properties.put("type", Type.ACOUSTIC);
        properties.put("topWood", Wood.MAPLE);
        properties.put("backWood", Wood.MAPLE);
        properties.remove("numStrings");
        inventory.addInstrument("9032291", 3982.11, new InstrumentSpec(properties));

        properties.put("instrumentType", InstrumentType.BANJO);
        properties.put("model", "RB-3 Wreath");
        properties.put("type", Type.ACOUSTIC);
        properties.remove("topWood");
        properties.put("numStrings", 5);
        inventory.addInstrument("9502291", 1393.22, new InstrumentSpec(properties));



    }


    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        initInventory(inventory); // initializing the inventory


        // TEST CASE FOR SEARCHING WITH SPECIFIC PROPERTIES AND RETURNING A LIST OF THE MATCHING INSTRUMENTS
        Map properties = new HashMap();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);
        InstrumentSpec clientSpec = new InstrumentSpec(properties);


        List matchingInstruments = inventory.search(clientSpec);

        if (!matchingInstruments.isEmpty()){

            System.out.println(" You might like these instruments .. ");
            for (Iterator i = matchingInstruments.iterator(); i.hasNext() ;){

                Instrument instrument = (Instrument)i.next();
                InstrumentSpec instrumentSpec = instrument.getSpec();

                System.out.println("We have a " + instrumentSpec.getProperty("instrumentType") + " with the following properties :" );

                for (Iterator j = instrumentSpec.getProperties().keySet().iterator() ; j.hasNext() ;){
                    String propertyName = (String)j.next();
                    if (propertyName.equals("instrumentType")){
                        continue;
                    }
                    System.out.println("   " + propertyName + ": " + instrumentSpec.getProperty(propertyName));
                }

                System.out.println(" You can have this " + instrumentSpec.getProperty("instrumentType") + " for only $" + instrument.getPrice() + "\n-----------");
            }

        }else {
            System.out.println("We haven't found what you're looking for ..");
        }



        // TEST CASE FOR RETURNING SINGLE INSTRUMENT FROM THE INVENTORY
        Instrument single = inventory.getInstrument("122784");

        for (Iterator i = single.getSpec().getProperties().keySet().iterator(); i.hasNext() ;){

            String propertyName = (String)i.next();
            if (propertyName.equals("instrumentType")){
                continue;
            }
            System.out.println("   " + propertyName + ": " + single.getSpec().getProperty(propertyName));

        }


    }
}