package lab5in;

public class Floor
{
	private Employee[] admins = new Employee[3];
	private int id_number;
	private String phone_number;
	private String email;

	private Book[] book; 
	private Journal[] journal;
	private Conference[] conference;
	
	
	
	public Floor(Employee[] admins, int id_number, String phone_number, String email)
	{
		this.admins = admins;
		this.id_number = id_number;
		this.phone_number = phone_number;
		this.email = email;
	}
	public Employee[] getAdmins()
	{
		return admins;
	}
	public void setAdmins(Employee[] admins)
	{
		this.admins = admins;
	}
	public int getId_number()
	{
		return id_number;
	}
	public void setId_number(int id_number)
	{
		this.id_number = id_number;
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
	
	public Book[] getBook()
	{
		return book;
	}
	public void setBook(Book[] book)
	{
		this.book = book;
	}
	public Journal[] getJournal()
	{
		return journal;
	}
	public void setJournal(Journal[] journal)
	{
		this.journal = journal;
	}
	public Conference[] getConference()
	{
		return conference;
	}
	public void setConference(Conference[] conference)
	{
		this.conference = conference;
	}
	

}
