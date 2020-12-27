
public class LibraryVO {

	private String bookName;
	private String author;
	private String publisher;
	private String publishedDate;
	private int price;
	private String genre;
	
	public LibraryVO() {
		
	}
	public LibraryVO(String bookName, String author, String publisher,
			String publishedDate, int price,String genre) {
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.price = price;
		this.genre = genre;
	}
	
	public void print() {
		System.out.printf("%14s\t%6s\t%7s\t%14s\t%9d\t%4s\n", 
				bookName, author, publisher, publishedDate, price, genre);
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
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
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	
	
}


