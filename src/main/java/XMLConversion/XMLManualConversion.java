package XMLConversion;

import Utils.WriteToFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by User on 25.05.2015.
 */
public class XMLManualConversion {
    public static void main(String[] args) {
        WriteToFile writer = new WriteToFile("D:\\XML_manual.xml");
        writer.addXMLDefaultInfo();
        writer.addXMLTag("Main");
            writer.addXMLRow("tag","Test");
            writer.addXMLRow("new tag","New row");
        writer.closeXMLTag("Main");
        writer.closeWriter();



    }


}
