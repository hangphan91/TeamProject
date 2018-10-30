package lab5in;

public class Journal
{
private String name;
private int year;
private int month;
public Journal(String name, int year, int month)
{
	super();
	this.name = name;
	this.year = year;
	this.month = month;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}
public int getYear()
{
	return year;
}
public void setYear(int year)
{
	this.year = year;
}
public int getMonth()
{
	return month;
}
public void setMonth(int month)
{
	this.month = month;
}

}
