package libraryCA;

public class Books {
	private int bookId;
	private String title, author, lang, subject;
	
	public Books(int bookId, String title, String author, String lang, String subject) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.lang = lang;
		this.subject = subject;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
