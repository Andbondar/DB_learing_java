package Utils;

import java.io.*;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by bondar on 4/2/2015.
 */
public class WriteToFile {
    private String filePath = "D:\\XML_manual.xml";
    private PrintWriter targetFile;

    public WriteToFile() {
        try {
            this.targetFile = new PrintWriter(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public WriteToFile(String filePath){
        this.filePath = filePath;
        try {
            this.targetFile = new PrintWriter(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter(){
        this.targetFile.close();
    }
    public void addRow(String addedRow){
        this.targetFile.println(addedRow);
    }
    public void addXMLDefaultInfo(){
        this.targetFile.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
    }
    public void addXMLRow(String tag, String data){
        String tagName = tag.replaceAll("\\s+","");
        String addedRow = "<"+tagName+">"+data+"</"+tagName+">";
        this.targetFile.println(addedRow);
    }
    public void addXMLTag(String tag){
        String tagName = tag.replaceAll("\\s+","");
        this.targetFile.println("<"+tagName+">");
    }
    public void closeXMLTag(String tag){
        String tagName = tag.replaceAll("\\s+","");
        this.targetFile.println("</"+tagName+">");
    }


    public String getFilePath(){
        return this.filePath;
    }
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public static void writeStringToFile(String inputString, String filePath) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filePath);
        out.println(inputString);
        out.close();
        System.out.println("Data was written to file " + filePath);
    }


}
