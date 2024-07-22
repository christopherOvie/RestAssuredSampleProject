import java.util.HashMap;

public class ClientA {

    public static void main(String[] args) {
        HashMap<String, String> myData= new   HashMap<String, String>();
        myData.put("firstname",ConfigLoader.getInstance().getName());

        myData.put("myskill",ConfigLoader.getInstance().getProperties().getProperty("skill"));
        System.out.println(myData.get("firstname"));

        System.out.println(myData.get("myskill"));
    }

}
