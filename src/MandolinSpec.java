// Class for the guitar specs
public class MandolinSpec extends InstrumentSpec {

    private Style style;

    public MandolinSpec(String model, Type type, Builder builder, Wood backWood, Wood topWood, Style style) {
        super(model, type, builder, backWood, topWood);
        this.style = style;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public boolean matches(InstrumentSpec otherSpec) {
        if(!super.matches(otherSpec)){
            return false;
        }
        if (!(otherSpec instanceof MandolinSpec)){
            return false;
        }
        MandolinSpec spec = (MandolinSpec)otherSpec;
        if(style != spec.style){
            return false;
        }
        return true;
    }
}
