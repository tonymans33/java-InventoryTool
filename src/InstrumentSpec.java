import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {

    // Map variable : dynamically store all the properties for any instrument
    private Map properties;

    public InstrumentSpec(Map properties) {
        if(properties == null){
            this.properties = new HashMap();
        }else {
            this.properties = new HashMap(properties);
        }
    }

   public Object getProperty(String propertyName){
        return properties.get(propertyName);
   }

    public Map getProperties() {
        return properties;
    }

    // Matches function that takes another spec object and start comparing the values and if matches return true " uses in the search method "
    public boolean matches(InstrumentSpec otherSpec){

        for (Iterator i = otherSpec.getProperties().keySet().iterator(); i.hasNext() ;){

            String propertyName = (String)i.next();
            if(!properties.get(propertyName).equals(otherSpec.getProperty(propertyName))){
                return false;
            }

        }
        return true;

    }
}
