package TableClasses.UsersPackage;

import TableClasses.RolesPackage.Role;
import TableClasses.RolesPackage.Roles;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by bondar on 5/20/2015.
 */
@XmlRootElement
public class User{
    private int id;
    private int enabled;
    private String fullName = "";
    private String email = "";
    private int partOfCustomer;
    private Roles currentRoles = null;

    public User(int id, int enabled, String fullName, String email){
        this.setId(id);
        this.setEnabled(enabled);
        this.setFullName(fullName);
        this.setEmail(email);
    }
    public User(int id, String fullName, String email, Roles currentRoles){
        this.setId(id);
        this.setFullName(fullName);
        this.setEmail(email);
        this.currentRoles = currentRoles;
    }
    public User(int id){
        this.id = id;
    }
    //default constructor
    public User(){}

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }    public int getId() {
        return id;
    }
    public int getEnabled() {
        return enabled;
    }
    @XmlElement
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    public String getFullName() {
        return fullName;
    }
    @XmlElement
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    @XmlElement
    public void setEmail(String email) {
        this.email = email;
    }
    @XmlElement(name = "Current_Roles")
    public Roles getCurrentRoles() {
        return currentRoles;
    }
    public void setCurrentRoles(Roles currentRoles) {
        this.currentRoles = currentRoles;
    }

    public String toString(){
        return this.fullName;
    }


    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder{
        private Builder() {
            // private constructor
        }
        public Builder setId(int id){
            User.this.id = id;
            return this;
        }
        public Builder setFullName(String fullName) {
            User.this.fullName = fullName;
            return this;
        }
        public Builder setEmail(String email) {
            User.this.email = email;
            return this;
        }
        public Builder setEnabled(int enabled) {
            User.this.enabled = enabled;
            return this;
        }
        public Builder setPartOfCustomer(int partOfCustomer) {
            User.this.partOfCustomer = partOfCustomer;
            return this;
        }
        public User build() {
            return User.this;
        }
    }
}
