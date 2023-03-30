package dto;

public class Rental {
	private int history_id;
	private int account_id;
	private  String mail;
	private int book_id;
	private String book_name;
	private String leadingday;
	private String  repayment;
	public Rental(int history_id, int account_id, String mail, int book_id, String book_name, String leadingday,
			String repayment) {
		super();
		this.history_id = history_id;
		this.account_id = account_id;
		this.mail = mail;
		this.book_id = book_id;
		this.book_name = book_name;
		this.leadingday = leadingday;
		this.repayment = repayment;
	}
	public int getHistory_id() {
		return history_id;
	}
	public void setHistory_id(int history_id) {
		this.history_id = history_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getLeadingday() {
		return leadingday;
	}
	public void setLeadingday(String leadingday) {
		this.leadingday = leadingday;
	}
	public String getRepayment() {
		return repayment;
	}
	public void setRepayment(String repayment) {
		this.repayment = repayment;
	}
	
	
}
