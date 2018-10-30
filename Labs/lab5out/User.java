package lab5out;

public class User
{
	private int id;
	private int username;
	private int password;
	public int getUsername()
	{
		return username;
	}
	public void setUsername(int username)
	{
		this.username = username;
	}
	public int getPassword()
	{
		return password;
	}
	public void setPassword(int password)
	{
		this.password = password;
	}
	public User() {

		id =-1;
				
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
}
