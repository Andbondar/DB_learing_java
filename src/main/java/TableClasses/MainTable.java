package TableClasses;

import TableClasses.RolesPackage.Roles;
import TableClasses.UsersPackage.Users;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by bondar on 5/22/2015.
 */
@XmlRootElement(name = "Main")
//@XmlAccessorType(XmlAccessType.FIELD)
public class MainTable {

    private Users users = null;
    private Roles roles = null;


    @XmlElement(name = "Users")
    public Users getUsers(){
        return this.users;
    }
    public void setUsers(Users users){
        this.users = users;
    }

    @XmlElement(name = "Roles")
    public Roles getRoles() {
        return roles;
    }
    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}
