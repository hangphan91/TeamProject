package lab5out;

public class CreateAccountData
{
	private String newAccount;
	private String newPass;
	private String re_newPass;
	public CreateAccountData() {
		this.newAccount = "";
		this.newPass = "";
		this.re_newPass ="";
	}
	public String getNewAccount()
	{
		return newAccount;
	}
	public void setNewAccount(String newAccount)
	{
		this.newAccount = newAccount;
	}
	public String getNewPass()
	{
		return newPass;
	}
	public void setNewPass(String newPass)
	{
		this.newPass = newPass;
	}
	public String getRe_newPass()
	{
		return re_newPass;
	}
	public void setRe_newPass(String re_newPass)
	{
		this.re_newPass = re_newPass;
	}
	
	
}
