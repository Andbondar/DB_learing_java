package JSONConversion;

import Utils.MakeJSON;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

/**
 * Created by User on 25.05.2015.
 */
public class MainJSONConversion {
    public static void main(String[] args) {
        MakeJSON jsonMaker = new MakeJSON();
        jsonMaker.putJsonObj("User", "Andrew");
        jsonMaker.putJsonObj("Admin", "John");

        JSONArray roles = new JSONArray();
        roles.add("Role: Curator");
        roles.add("Role: Annotator");
        roles.add("Role: Tester");

        jsonMaker.addJsonArrayToObject("Roles", roles);

        try {
            jsonMaker.writeToFile("D:\\jsonTest.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
