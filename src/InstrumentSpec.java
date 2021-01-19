public class InstrumentSpec {

    private String model;
    private Type type;
    private Builder builder;
    private Wood backWood, topWood;

    public InstrumentSpec(String model, Type type, Builder builder, Wood backWood, Wood topWood) {
        this.model = model;
        this.type = type;
        this.builder = builder;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Builder getBuilder() {
        return builder;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    public void setTopWood(Wood topWood) {
        this.topWood = topWood;
    }

    // Matches function that takes another spec object and start comparing the values and if matches return true " uses in the search method "
    public boolean matches(InstrumentSpec otherSpec){

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

        return true;

    }
}
