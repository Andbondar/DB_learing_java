package Utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bondar on 5/21/2015.
 */
public class ResultsProcessing extends Connector{
    private ResultSet resultSet = null;
    private Connection conn = null;
    //constructors here
    public ResultsProcessing (Connection conn, ResultSet resultSet){
        this.conn = conn;
        this.resultSet = resultSet;
    }

    public String getFirstCell() throws SQLException {
        resultSet.next();
        return resultSet.getString(1);
    }
    public void printFirstCell() throws SQLException {
        System.out.println(this.getFirstCell());
    }
    public List<String> getFirstRow() throws SQLException {
        List<String> returnedList = new ArrayList<String>();
        resultSet.next();//switch to first row
        //get number of columns
        ResultSetMetaData rsmd = resultSet.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        //read data from columns one by one
        int i = 1;
        while(i <= columnsNumber){
            returnedList.add(resultSet.getString(i));
            i++;
        }
        return returnedList;
    }
    public void printFirstRow() throws SQLException {
        List<String> toPrint = this.getFirstRow();
        for (int i = 0; i < toPrint.size()-1; i++) {
            System.out.print(toPrint.get(i) + ", ");
        }
        System.out.println(toPrint.get(toPrint.size()-1));//print last element without space and comma
    }
    public List<String> getDataFromColumn(String columnName) throws SQLException {
        List<String> returnedList = new ArrayList<String>();
        while (resultSet.next()) {
            returnedList.add(resultSet.getString(columnName));
        }
        return returnedList;
    }
    public List<List<String>> getQueryResults() throws SQLException {
        List<List<String>> returnedList = new ArrayList<List<String>>();
        int columnsNumber = resultSet.getMetaData().getColumnCount();
        //data is stored in lists. each row is a list too. List of rows is stored in the returnedList
        while (resultSet.next()){
            ArrayList<String> currentRow = new ArrayList<String>();
            int i = 1;
            while(i <= columnsNumber){ //read data from columns one by one
                currentRow.add(resultSet.getString(i));
                i++;
            }
            returnedList.add(currentRow);
        }
        return returnedList;
    }
    public void printQueryResults() throws SQLException {
        List<List<String>> resultList = this.getQueryResults();
        for (List<String> aResultList : resultList) {
            for (String anAResultList : aResultList) {
                System.out.print(anAResultList + " ");
            }
            System.out.println();
        }
    }



    public ResultSet getResultSet() {
        return resultSet;
    }
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
