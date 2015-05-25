package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by User on 25.05.2015.
 */
public class MakeJSON {
    private JSONObject obj;

    public void setObj(JSONObject obj) {
        this.obj = obj;
    }
    public JSONObject getObj(){
        return this.obj;
    }
    public MakeJSON(){
        this.obj = new JSONObject();
    }


    public void putJsonObj(String key, String value){
        obj.put(key, value);
    }

    public void addJsonArrayToObject(String arrayName, JSONArray jsonArray){
        this.obj.put(arrayName,jsonArray);
    }

    public void writeToFile(String filePath) throws IOException {
        FileWriter file = new FileWriter(filePath);
        try {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            file.flush();
            file.close();
        }
    }
}
