package TableClasses.RolesPackage;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 24.05.2015.
 */
@XmlRootElement
public class Roles {
    private List<Role> roleList = null;

    @XmlElement(name = "Role")
    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public void createDummyRoles(){
        List<Role> returnedList = new ArrayList<Role>();
        returnedList.add(new Role(1, "admin"));
        returnedList.add(new Role(2, "user"));
        returnedList.add(new Role(3, "curator"));
        this.roleList = returnedList;
        }

    public void createDummyRolesForUser(){
        List<Role> returnedList = new ArrayList<Role>();
        returnedList.add(new Role(1, "admin"));
        returnedList.add(new Role(2, "user"));
        this.roleList = returnedList;
    }
}

