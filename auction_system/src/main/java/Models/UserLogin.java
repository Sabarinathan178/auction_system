package Models;

public class UserLogin {
	private String username;
	private String email;
	private String password;

	public void setUsername(String user) {
		this.username=user;
		
	}
	public void setEmail(String email) {
		this.email=email;
		
	}

	public void setPassword(String pass) {
		
		this.password=pass;
	}
	public String getUsername()
	{
		return username;
	}
	public String getPassword()
	{
		return password;
	}

	public String getEmail() {
		return email;
	}

}
