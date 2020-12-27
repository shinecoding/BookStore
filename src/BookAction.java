import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class BookAction {
	static TreeMap<String, LibraryVO> bookList = new TreeMap<String, LibraryVO>();
	Scanner sc = new Scanner(System.in);
	public BookAction() {}

	public String conInput(String msg) {
		System.out.print(msg +"=");
		return sc.nextLine();
	}
	
	public void bookList() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.printf("%14s\t%6s\t%7s\t%10s\t%6s\t%4s\n", "제목", "작가", "출판사", "출간일", "판매가", "분류");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Collection<LibraryVO> valueList = bookList.values();
		Iterator<LibraryVO> it = valueList.iterator();
		while(it.hasNext()) {
			it.next().print();
		}
		System.out.println();
	}
	
	
	public void searchBookbyName() {
	/*	String name = conInput("책 이름 검색");
		LibraryVO search. = bookList.get(name);
		if(search!=null) {
				search.print();
		}
		*/
		
		String name = conInput("책 이름");
		String newName = name.replaceAll("\\s", "");
		Object[] key = bookList.keySet().toArray();
		for (Object k : key) {
			String k1 = k.toString().replaceAll("\\s", "");
			if(newName.equals(k1)) {
				bookList.get(k).print();
			}
		}
		
	}
		

	
	public void searchBookbyGenre() {	
		String genre = conInput("분야 검색 (소설, 자기계발, 인문, 참고서, 어린이)");
		Object[] key = bookList.keySet().toArray();
		for(Object k : key) {
				if(bookList.get(k).getGenre().equals(genre)) {
					bookList.get(k).print();
					
			}
			
		}
		
	}
	
	public void searchBookbyAuthor() {
		String author = conInput("작가 이름");
		Object[] key = bookList.keySet().toArray();
		for(Object k: key) {
			if(bookList.get(k).getAuthor().equals(author)) {
				bookList.get(k).print();
			} 
		}
	}

	

	
	public void addBook() { //책 추가
		String bookName = conInput("책 이름");
		String author = conInput("작가");
		String publisher = conInput("출판사");
		String publishedDate = conInput("출판일(예시: 2020-1-1)");
		int price = Integer.parseInt(conInput("판매가"));
		String genre = conInput("장르");
	
		LibraryVO libvo = new LibraryVO(bookName, author, publisher, publishedDate, price, genre);
		bookList.put(bookName, libvo);
		bookList.get(bookName).print();
	}
	
	public void editBook() {
		String bookName = conInput("수정할 책 이름");
		LibraryVO libvo = null;
		String newName = bookName.replaceAll("\\s", "");
		Object[] key = bookList.keySet().toArray();
		for (Object k : key) {
			String k1 = k.toString().replaceAll("\\s", "");
			if(newName.equals(k1)) {
				bookList.get(k).print();
				libvo = bookList.get(k);
			}
		}
		
		if(libvo !=null) {
			
			String editMenu = conInput("수정할 항목을 선택하세요. (1:작가, 2:출판사, 3:출판일, 4:판매가, 5:장르)");
			String data = conInput("수정할 데이터 입력");
	
			switch(editMenu) {
			
			case "1":
				libvo.setAuthor(data);
				libvo.print();
				break;
			case "2":
				libvo.setPublisher(data);
				libvo.print();
				break;
			case "3":
				libvo.setPublishedDate(data);
				libvo.print();
				break;
			case "4":
				libvo.setPrice(Integer.parseInt(data));
				libvo.print();
				break;
			case "5":
				libvo.setGenre(data);
				libvo.print();
				break;
			default:
				System.out.println("수정할 항목을 잘못 선택하셨습니다.");
				break;
			}
		}else {
			System.out.println(bookName+ "은 없는 도서입니다.");
			}	
		
		
		
	}
	
	
	public void deleteBook() {
		String key = conInput("삭제할 도서명 입력");
		bookList.remove(key);
	}
	

		
		
	public TreeMap<String, LibraryVO> setBooks() {
		bookList.put("어린왕자", new LibraryVO("어린왕자", "생떼쥐", "민음사", "2020-5-3", 12000, "소설"));
		bookList.put("두 도시 이야기", new LibraryVO("두 도시 이야기", "찰스디", "민음사", "2020-4-14", 18000, "소설"));
		bookList.put("주식으로 100억 벌기", new LibraryVO("주식으로 100억 벌기", "백주식", "백음사", "2019-8-16", 13000, "자기계발"));
		bookList.put("수학익힘책", new LibraryVO("수학익힘책", "수포위원회", "학음사", "2015-5-26", 9000, "참고서"));
		bookList.put("나비의 모험", new LibraryVO("나비의 모험", "호랑나", "동화사", "2017-12-25", 10000, "어린이"));
		bookList.put("물고기 비늘", new LibraryVO("물고기 비늘", "착한아이", "동화사", "2018-11-13", 11000, "어린이"));
		bookList.put("인문학 산책", new LibraryVO("인문학 산책", "쓰레빠", "학음사", "2016-9-19", 16000, "인문"));
		bookList.put("난 강남건물주", new LibraryVO("난 강남건물주", "강건주", "백음사", "2018-7-6", 13000, "자기계발"));
		return bookList;
	}
	}

