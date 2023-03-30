package dto;

public class Book {
	private int id;
	private String book_name;
	private String author;
	private String publisher;
	private int isbn;
	private String version;
	private String day;
	
	public Book(int id, String book_name, String author, String publisher, int isbn, String version, String day) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.publisher = publisher;
		this.isbn = isbn;
		this.version = version;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}


	}