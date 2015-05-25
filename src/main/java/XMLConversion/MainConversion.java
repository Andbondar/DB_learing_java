package XMLConversion;

import TableClasses.MainTable;
import TableClasses.RolesPackage.Roles;
import TableClasses.UsersPackage.User;
import TableClasses.UsersPackage.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by bondar on 5/22/2015.
 */
public class MainConversion {
    public static void main(String[] args) {
        User user = User.newBuilder()
                .setId(100)
                .setEmail("email@test.com")
                .setFullName("Test user name")
                .setPartOfCustomer(3)
                .build();

        //test categories
        Users users = new Users();
        users.createDummyUsers();
        Roles roles = new Roles();
        roles.createDummyRoles();

        MainTable mainTable = new MainTable();
        mainTable.setUsers(users);
        mainTable.setRoles(roles);

        try {

            File file = new File("D:\\XML_file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(MainTable.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(mainTable, file);
            jaxbMarshaller.marshal(mainTable, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
