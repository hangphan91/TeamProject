package lab5in;

public class Book
{
private int id_number;
private String tittle;
private String author;
public Book(int id_number, String tittle, String author)
{
	
	this.id_number = id_number;
	this.tittle = tittle;
	this.author = author;
}
public int getId_number()
{
	return id_number;
}
public void setId_number(int id_number)
{
	this.id_number = id_number;
}
public String getTittle()
{
	return tittle;
}
public void setTittle(String tittle)
{
	this.tittle = tittle;
}
public String getAuthor()
{
	return author;
}
public void setAuthor(String author)
{
	this.author = author;
}


}
