import Utils.Connector;

import java.sql.SQLException;

/**
 * Created by bondar on 5/20/2015.
 */
public class HomeWork {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "";//user
        String password = "";//password here
        String url = "";//url

        Connector connector = new Connector();
        //connector.establishConnection(url, userName, password);
        connector.establishLocalConnection();

        System.out.println("Examples:");
        System.out.println();

        System.out.println("Test refactoring:");
        connector.getResultsForQuery("select distinct pr.displayname, rels.Actual from ARP.dbo.Releases rels, arp.dbo.projects pr\n" +
                "where rels.BelongsToProject = pr.ID;").printFirstCell();
        connector.getResultsForQuery("select distinct pr.displayname, rels.Actual from ARP.dbo.Releases rels, arp.dbo.projects pr\n" +
                "where rels.BelongsToProject = pr.ID;").printFirstRow();
        connector.getResultsForQuery("select distinct pr.displayname, rels.Actual from ARP.dbo.Releases rels, arp.dbo.projects pr\n" +
                "where rels.BelongsToProject = pr.ID;").printQueryResults();


    }
}
