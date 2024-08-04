package libraryCA;

public class Books {
	private int bookId, bookQty;
	private String title, author, lang, subject;
	
	public Books(int bookId, String title, String author, String lang, String subject, int bookQty) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.lang = lang;
		this.subject = subject;
		this.bookQty = bookQty;
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
	
	public int getBookQty() {
		return bookQty;
	}

	public void setBookQty(int bookQty) {
		this.bookQty = bookQty;
	}
	
	
	public int compareObject(Object obj, String opt) {
		/*
		 * Vehicles myVehicles = (Vehicles) obj;
        return this.sLocation.compareTo(myVehicles.getsLocation());
		 */
		Books book2 = (Books) obj;
		if(opt.equalsIgnoreCase("Title")) {
			return this.title.compareTo(book2.title);
		} else if(opt.equalsIgnoreCase("Author")) {
			return this.author.compareTo(book2.author);
		} else if(opt.equalsIgnoreCase("ID")) {
			if(this.bookId>book2.bookId) {
				return 1;
			} else if(this.bookId<book2.bookId) {
				return -1;
			} else {
				return 0;
			}
			
		} else {
			return -1;
		}
		
	}

	@Override
	public String toString() {
		return "Book [Book ID= " + bookId + ", Title= " + title + ", Author= " + author + ", Language= " + lang + ", Subject= "
				+ subject + "]";
	}

	
	
	
	
}
