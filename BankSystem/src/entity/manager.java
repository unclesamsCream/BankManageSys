package entity;
/**
 * 银行管理员实体类
 * @author rui
 *
 */
public class manager {
	private String account;
	private String password;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "manager [account=" + account + ", password="
				+ password + "]";
	}
	
	
}
