<<<<<<< HEAD

package mice.bean;

public class User {
	private String password;
	private String name;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnonymousName() {

			return name.substring(0, 1) + "*";
	}

}
=======
package mice.bean;

public class User {
	private int id;
	private String name;
	private String passwd;
	private String creatDate;

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

}
>>>>>>> c0687b9101aa3aad2a25d30c163cca51017aa544
