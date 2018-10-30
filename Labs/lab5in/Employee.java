package lab5in;

public class Employee
{
	private int id;
	private String dept_name;
	private String person_name;
	private String phone_number;
	private String email;
	public Employee(int id, String dept_name, String person_name, String phone_number, String email)
	{
		this.id = id;
		this.dept_name = dept_name;
		this.person_name = person_name;
		this.phone_number = phone_number;
		this.email = email;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getDept_name()
	{
		return dept_name;
	}
	public void setDept_name(String dept_name)
	{
		this.dept_name = dept_name;
	}
	public String getPerson_name()
	{
		return person_name;
	}
	public void setPerson_name(String person_name)
	{
		this.person_name = person_name;
	}
	public String getPhone_number()
	{
		return phone_number;
	}
	public void setPhone_number(String phone_number)
	{
		this.phone_number = phone_number;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	

}
