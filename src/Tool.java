import java.util.Iterator;
import java.util.List;

// Enum for type, builder, wood to avoiding using string comparisons and misspelling a word
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

    MARTIN, FENDER, PRS, OLSON;

    public String toString(){

        switch (this) {
            case MARTIN : return  "martin";
            case FENDER : return  "fender";
            case PRS : return  "prs";
            case OLSON : return  "olson";
            default: return "";
        }
    }

}

enum Wood{

    ALDER, STIKA;

    public String toString(){
        switch (this) {
            case ALDER : return "alder";
            case STIKA : return "stika";
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




public class Tool {

    // A function to add some instruments to the inventory
    private static void initInventory(Inventory inventory){

        inventory.addInstrument("V95693",  1499.95, new GuitarSpec("Stratocastor" ,Type.ELECTRIC, Builder.FENDER, Wood.ALDER, Wood.ALDER,12));
        inventory.addInstrument("233123",  1549.95, new GuitarSpec("Stratocastor" ,Type.ELECTRIC, Builder.FENDER, Wood.ALDER, Wood.ALDER,12));
        inventory.addInstrument("234123",  2000, new MandolinSpec("Stratocastor" ,Type.ELECTRIC, Builder.FENDER, Wood.ALDER, Wood.ALDER,Style.A));
        inventory.addInstrument("235123",  3021.95, new MandolinSpec("Stratocastor" ,Type.ELECTRIC, Builder.FENDER, Wood.ALDER, Wood.ALDER,Style.F));
    }


    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        initInventory(inventory); // initializing the inventory


        List matchingGuitars = inventory.search(new GuitarSpec("Stratocastor" ,Type.ELECTRIC, Builder.FENDER, Wood.ALDER, Wood.ALDER,12));

        if (!matchingGuitars.isEmpty()){
            System.out.println(" You might like these guitars .. ");
            for (Iterator i = matchingGuitars.iterator(); i.hasNext() ;){

                Guitar guitar =  (Guitar)i.next();
                GuitarSpec spec = (GuitarSpec)guitar.getSpec();

                System.out.println(
                        " We have a " +
                        spec.getBuilder() + " " + spec.getModel() + " " +
                        spec.getType() + " guitar:\n "+
                        spec.getBackWood() + " back and sides \n "+
                        spec.getTopWood() + " top.\n You can have it for only $" +
                        guitar.getPrice() + "!\n ----"
                );
            }

        }else {
            System.out.println("We haven't found what you're looking for ..");
        }


    }
}
