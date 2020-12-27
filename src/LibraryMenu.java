import java.util.Scanner;
import java.util.TreeMap;

public class LibraryMenu {
	Scanner sc = new Scanner(System.in);
	CustomerAction join = new CustomerAction();
	BookAction ba = new BookAction();
	static TreeMap<String, LibraryVO> bookList = new TreeMap<String, LibraryVO>();
	static TreeMap<String, CustomerVO> cusList = new TreeMap<String, CustomerVO>();

	public LibraryMenu() {
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(" 비트서점 도서관리 시스템 ");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		

		String userId = null;
		String userPwd = null;

		bookList = ba.setBooks();
		cusList = join.setCusList();
		do {
			String menu = conInput("메뉴(1:책 목록, 2:책 검색, 3:로그인, 4:회원가입, 0:종료)");
			
			if (menu.equals("1")) ba.bookList();
			else if (menu.equals("2")) ba.searchBookbyName();
			else if (menu.equals("3")){
				userId = conInput("아이디");
				userPwd = conInput("비밀번호");
				if(userId !=null && userPwd !=null) {
					if (join.admCheck(userId, userPwd) == 1) {
						do {
							realMenu();
						} while (true);
					} else if (join.admCheck(userId, userPwd) == 2) {
						do {
							custMenu();
						}while(true);
					}else {
						System.out.println("다시시도");
					}
				} else {
					System.out.println("없는 회원정보입니다");
				}
			} else if (menu.equals("4")) {
				join.cusJoin();
				System.out.println("회원가입이 완료되었습니다! 로그인해주세요.");
			} else if (menu.equals("0")) {
				System.exit(0);
			} else {
				System.out.println("메뉴를 잘 못 선택하셨습니다.");
			}
		} while(true);

	}// LibraryMenu

	
	public void custMenu() {
		String custMenu = conInput("1:책 목록, 2:책 검색, 3:분야보기, 4:작가검색 0:종료");
		if(custMenu.equals("1")) ba.bookList();
		else if (custMenu.equals("2")) ba.searchBookbyName();
		else if (custMenu.equals("3")) ba.searchBookbyGenre();
		else if (custMenu.equals("4")) ba.searchBookbyAuthor();
		else if (custMenu.equals("0")) System.exit(0);
	}
	
	public void realMenu() {
		String realMenu = conInput("1:도서관리 2:회원관리");
		if (realMenu.equals("1")) {
			String choiceBook = conInput("1:책 목록, 2:책 검색, 3:책 추가, 4:책 수정, 5:책 삭제, 0:종료");
			if (choiceBook.equals("1"))
				ba.bookList();
			else if (choiceBook.equals("2"))
				ba.searchBookbyName();
			else if (choiceBook.equals("3"))
				ba.addBook();
			else if (choiceBook.equals("4"))
				ba.editBook();
			else if (choiceBook.equals("5"))
				ba.deleteBook();
			else if (choiceBook.equals("0"))
				System.exit(0);
		} else if (realMenu.equals("2")) {
			String choiceCus = conInput("1:회원 목록, 2:회원 검색, 3:회원 추가, 4:회원 수정, 5:회원 삭제  0:종료");
			if (choiceCus.equals("1"))
				join.cusList();
			else if (choiceCus.equals("2"))
				join.searchCus();
			else if (choiceCus.equals("3")) {
				join.cusJoin();
			System.out.println("회원이 추가되었습니다.");
				
			}else if (choiceCus.equals("4"))
				join.editCus();
			else if (choiceCus.equals("5"))
				join.deleteCus();
			else if (choiceCus.equals("0"))
				System.exit(0);
		}
		
	}
	
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return sc.next();
	}

	public static void main(String[] args) {
		new LibraryMenu();
	}

}
