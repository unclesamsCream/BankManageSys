package entity;

public class stuff {
	private String account;
	private String password;
	private byte openable;
	private byte closeable;
	private byte modifiable;
	private byte viewable;
	private byte queryable;

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

	public byte getOpenable() {
		return openable;
	}

	public void setOpenable(byte openable) {
		this.openable = openable;
	}

	public byte getCloseable() {
		return closeable;
	}

	public void setCloseable(byte closeable) {
		this.closeable = closeable;
	}

	public byte getModifiable() {
		return modifiable;
	}

	public void setModifiable(byte modifiable) {
		this.modifiable = modifiable;
	}

	public byte getViewable() {
		return viewable;
	}

	public void setViewable(byte viewable) {
		this.viewable = viewable;
	}

	public byte getQueryable() {
		return queryable;
	}

	public void setQueryable(byte queryable) {
		this.queryable = queryable;
	}

	@Override
	public String toString() {
		return "stuff [account=" + account + ", password=" + password
				+ ", openable=" + openable + ", closeable=" + closeable
				+ ", modifiable=" + modifiable + ", viewable=" + viewable
				+ ", queryable=" + queryable + "]";
	}

}
