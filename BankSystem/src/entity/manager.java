package entity;
/**
 * 银行管理员实体类
 * @author rui
 *
 */
public class manager {
	private String account_number;
	private String password;

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "manager [account_number=" + account_number + ", password="
				+ password + "]";
	}
	
	
}
