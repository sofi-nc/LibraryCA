package library.objects;

public class Visitor {
	private String name,  regDate;
	private boolean bBooks, status, bFound;
	private int visitorId, borrowedBooks;
	
	public Visitor() {
		//EMpty constructor
	}
	
	public Visitor(String name, boolean status, String regDate,
			boolean bBooks, int visitorId, int borrowedBooks) {
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


	public boolean getStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getRegDate() {
		return regDate;
	}


	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}


	public boolean getbBooks() {
		return bBooks;
	}


	public void setbBooks(boolean bBooks) {
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
	
	public boolean isbFound() {
		return bFound;
	}

	public void setbFound(boolean bFound) {
		this.bFound = bFound;
	}


	@Override
	public String toString() {
		return "Visitor [name=" + name + ", status=" + status + ", visitorId=" + visitorId + "]";
	}

	
	
	
	
	
}
