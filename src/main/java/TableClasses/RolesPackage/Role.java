package TableClasses.RolesPackage;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by User on 24.05.2015.
 */
@XmlRootElement
public class Role {
    private String roleName;
    private int id;

    public Role(int ID, String roleName){
        this.roleName = roleName;
        this.id = ID;
    }
    public Role(){};

    @XmlElement
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
