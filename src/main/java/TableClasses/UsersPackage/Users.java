package TableClasses.UsersPackage;

import TableClasses.RolesPackage.Roles;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24.05.2015.
 */
@XmlRootElement
public class Users {
    private List<User> usersList = null;

    @XmlElement(name = "user")
    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }
    //stub for testing output in XML

    public void createDummyUsers(){
        List<User> returnedList = new ArrayList<User>();
        returnedList.add(new User(100, 1, "Andrew", "Andrew@test.ru"));
        returnedList.add(new User(1152, 3, "Gridjesh", "Gridjesh@test.com"));
        Roles dummyRoles = new Roles();
        dummyRoles.createDummyRolesForUser();
        returnedList.add(new User(1234, "John", "John@mail.ru", dummyRoles));
        this.usersList = returnedList;
    }

}
