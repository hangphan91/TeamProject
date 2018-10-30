package lab5in;

import java.sql.Date;

public class Conference
{
private String name;
private Date start_date;
public Conference(String name, Date start_date)
{
	this.name = name;
	this.start_date = start_date;
}
public String getName()
{
	return name;
}
public void setName(String name)
{
	this.name = name;
}
public Date getStart_date()
{
	return start_date;
}
public void setStart_date(Date start_date)
{
	this.start_date = start_date;
}

}
