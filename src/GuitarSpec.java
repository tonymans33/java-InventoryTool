// Class for the guitar specs
public class GuitarSpec extends InstrumentSpec {

    private int numStrings;

    public GuitarSpec(String model, Type type, Builder builder, Wood backWood, Wood topWood, int numStrings) {
        super(model, type, builder, backWood, topWood);
        this.numStrings = numStrings;
    }

    public void setNumStrings(int numStrings) {
        this.numStrings = numStrings;
    }
    public int getNumStrings() {
        return numStrings;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if(!super.matches(otherSpec)){
            return false;
        }
        if (!(otherSpec instanceof GuitarSpec)){
            return false;
        }
        GuitarSpec spec = (GuitarSpec)otherSpec;
        if(numStrings != spec.numStrings){
            return false;
        }
        return true;
    }
}
