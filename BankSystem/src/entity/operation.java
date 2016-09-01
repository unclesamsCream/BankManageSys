package entity;

import java.util.Date;

public class operation {
	private String card_number;
	private byte type;
	private float residual;
	private String transaction_to;
	private String transaction_from;
	private float transaction_amount;
	private Date deal_date;

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
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

	public String getTransaction_to() {
		return transaction_to;
	}

	public void setTransaction_to(String transaction_to) {
		this.transaction_to = transaction_to;
	}

	public String getTransaction_from() {
		return transaction_from;
	}

	public void setTransaction_from(String transaction_from) {
		this.transaction_from = transaction_from;
	}

	public float getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(float transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public Date getDeal_date() {
		return deal_date;
	}

	public void setDeal_date(Date deal_date) {
		this.deal_date = deal_date;
	}

	@Override
	public String toString() {
		return "operation [card_number=" + card_number + ", type=" + type
				+ ", residual=" + residual + ", transaction_to="
				+ transaction_to + ", transaction_from=" + transaction_from
				+ ", transaction_amount=" + transaction_amount + ", deal_date="
				+ deal_date + "]";
	}

}
