package Utils;

import java.sql.*;

/**
 * Created by bondar on 5/20/2015.
 */
public class Connector {
    private Connection conn = null;
    private ResultSet resultSet = null;


    public Connection getConn() {
        return conn;
    }
    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public Connector(Connection conn){
        this.conn = conn;
    }
    public Connector() {
        this.conn = null;
    }

    public void establishConnection(String url, String userName, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.conn = DriverManager.getConnection("jdbc:sqlserver://" + url, userName, password);
    }
    public void closeConnection() throws SQLException {
        conn.close();
    }

    public ResultsProcessing getResultsForQuery(String SQLQuery) throws SQLException {
        Statement sta = conn.createStatement();
        ResultSet rs = sta.executeQuery(SQLQuery);
        return new ResultsProcessing(this.conn, rs);
    }

    public void establishLocalConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.conn = DriverManager.getConnection("jdbc:sqlserver://localhost;integratedSecurity=true");
    }
}
