import java.util.Properties;

public class ConfigLoader {

    public static  ConfigLoader configLoader;
    private static Properties properties;
    public  ConfigLoader(){
//        properties= new Properties();
//        properties= new Properties();
        properties = TestProperty.getPropertyInstance();
    }

public static ConfigLoader getInstance(){

        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
    return configLoader;

}
//ist mthd
public Properties getProperties(){
        return properties;
}
//2nd method
    public String getName(){
        if(properties!=null){
            return properties.getProperty("name");
        }
        else{
            throw new RuntimeException(" Property not found");
        }
    }
}
