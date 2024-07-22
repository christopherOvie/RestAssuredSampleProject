import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestProperty {

    public static Properties getPropertyInstance() {
        Properties properties = new Properties();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(".\\src\\main\\resources\\sample.properties"));

            properties.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(properties.getProperty("name"));
//        System.out.println(properties.getProperty("skill"));
        return properties;
    }


}
