package register.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Userld")
	private String userld;

	@Column(name="Fullname")
	private String fullname;

	@Column(name="Password")
	private String password;

	public User() {
	}

	public String getUserld() {
		return this.userld;
	}

	public void setUserld(String userld) {
		this.userld = userld;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}