package library.objects;

public class Visitor {
	private String name, status, regDate, bBooks;
	private int visitorId, borrowedBooks;
	
	public Visitor() {
		
	}
	
	public Visitor(String name, String status, String regDate, String bBooks, int visitorId, int borrowedBooks) {
		this.name = name;
		this.status = status;
		this.regDate = regDate;
		this.bBooks = bBooks;
		this.visitorId = visitorId;
		this.borrowedBooks = borrowedBooks;
	}





	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public String getbBooks() {
		return bBooks;
	}


	public void setbBooks(String bBooks) {
		this.bBooks = bBooks;
	}


	public int getVisitorId() {
		return visitorId;
	}


	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}


	public int getBorrowedBooks() {
		return borrowedBooks;
	}


	public void setBorrowedBooks(int borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}


	@Override
	public String toString() {
		return "Visitor [name=" + name + ", status=" + status + ", visitorId=" + visitorId + "]";
	}
	
	
	
	
}
