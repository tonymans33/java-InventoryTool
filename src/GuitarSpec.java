// Class for the guitar specs
public class GuitarSpec {

    private String model;
    private Type type;
    private Builder builder;
    private Wood backWood, topWood;
    private int numStrings;

    // Guitar Specs constructor that takes builder name, model, type, etc ..
    public GuitarSpec(Builder builder, String model, Type type, Wood backWood, Wood topWood, int numStrings){

        this.builder = builder;
        this.topWood = topWood;
        this.backWood = backWood;
        this.type = type;
        this.model = model;
        this.numStrings = numStrings;

    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public int getNumStrings() {
        return numStrings;
    }


    // Matches function that takes another spec object and start comparing the values and if matches return true " uses in the search method "
    public boolean matches(GuitarSpec otherSpec){

        if(builder != otherSpec.builder){
            return false;
        }

        if(model != null && !model.equals("") && !model.equals(otherSpec.model)){
            return false;
        }

        if(type != otherSpec.type){
            return false;
        }

        if(backWood != otherSpec.backWood){
            return false;
        }

        if(topWood != otherSpec.topWood){
            return false;
        }

        if(numStrings != otherSpec.numStrings){
            return false;
        }

    return true;

    }

}
