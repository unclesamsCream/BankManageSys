package entity;

public class users {
	private String account;
	private String name;
	private String id;
	private byte type;
	private float residual;
	private byte rate;
	private String password;
	private String address;
	private String telphone;
	private String email;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public float getResidual() {
		return residual;
	}

	public void setResidual(float residual) {
		this.residual = residual;
	}

	public byte getRate() {
		return rate;
	}

	public void setRate(byte rate) {
		this.rate = rate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "users [account=" + account + ", name=" + name + ", id=" + id
				+ ", type=" + type + ", residual=" + residual + ", rate="
				+ rate + ", password=" + password + ", address=" + address
				+ ", telphone=" + telphone + ", email=" + email + "]";
	}

}
