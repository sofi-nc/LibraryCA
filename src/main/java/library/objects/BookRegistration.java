package library.objects;

import generated.registration.BookRegistrationRequest.RegistrationType;

public class BookRegistration {
	private int bookID, userID, bookQty, total;
	private RegistrationType reg;
	
	private String userInfo, bkDtls, regType;
	private int totalBks, complReg;
	
	public BookRegistration() {
	}

	public BookRegistration(int bookID, int userID, int bookQty, RegistrationType reg) {
		this.bookID = bookID;
		this.userID = userID;
		this.bookQty = bookQty;
		this.reg = reg;
	}

	public BookRegistration(String userInfo, String bkDtls, String regType, int totalBks, int complReg) {
		this.userInfo = userInfo;
		this.bkDtls = bkDtls;
		this.regType = regType;
		this.totalBks = totalBks;
		this.complReg = complReg;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public RegistrationType getReg() {
		return reg;
	}

	public void setReg(RegistrationType reg) {
		this.reg = reg;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getBkDtls() {
		return bkDtls;
	}

	public void setBkDtls(String bkDtls) {
		this.bkDtls = bkDtls;
	}

	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}

	public int getTotalBks() {
		return totalBks;
	}

	public void setTotalBks(int totalBks) {
		this.totalBks = totalBks;
	}

	public int getComplReg() {
		return complReg;
	}

	public void setComplReg(int complReg) {
		this.complReg = complReg;
	}
	
	
}
