import java.util.Scanner;
import java.util.TreeMap;

public class LibraryMenu {
	Scanner sc = new Scanner(System.in);
	CustomerAction join = new CustomerAction();
	BookAction ba = new BookAction();
	static TreeMap<String, LibraryVO> bookList = new TreeMap<String, LibraryVO>();
	static TreeMap<String, CustomerVO> cusList = new TreeMap<String, CustomerVO>();

	public LibraryMenu() {
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println(" ��Ʈ���� �������� �ý��� ");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤ�");
		

		String userId = null;
		String userPwd = null;

		bookList = ba.setBooks();
		cusList = join.setCusList();
		do {
			String menu = conInput("�޴�(1:å ���, 2:å �˻�, 3:�α���, 4:ȸ������, 0:����)");
			
			if (menu.equals("1")) ba.bookList();
			else if (menu.equals("2")) ba.searchBookbyName();
			else if (menu.equals("3")){
				userId = conInput("���̵�");
				userPwd = conInput("��й�ȣ");
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
						System.out.println("�ٽýõ�");
					}
				} else {
					System.out.println("���� ȸ�������Դϴ�");
				}
			} else if (menu.equals("4")) {
				join.cusJoin();
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�! �α������ּ���.");
			} else if (menu.equals("0")) {
				System.exit(0);
			} else {
				System.out.println("�޴��� �� �� �����ϼ̽��ϴ�.");
			}
		} while(true);

	}// LibraryMenu

	
	public void custMenu() {
		String custMenu = conInput("1:å ���, 2:å �˻�, 3:�оߺ���, 4:�۰��˻� 0:����");
		if(custMenu.equals("1")) ba.bookList();
		else if (custMenu.equals("2")) ba.searchBookbyName();
		else if (custMenu.equals("3")) ba.searchBookbyGenre();
		else if (custMenu.equals("4")) ba.searchBookbyAuthor();
		else if (custMenu.equals("0")) System.exit(0);
	}
	
	public void realMenu() {
		String realMenu = conInput("1:�������� 2:ȸ������");
		if (realMenu.equals("1")) {
			String choiceBook = conInput("1:å ���, 2:å �˻�, 3:å �߰�, 4:å ����, 5:å ����, 0:����");
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
			String choiceCus = conInput("1:ȸ�� ���, 2:ȸ�� �˻�, 3:ȸ�� �߰�, 4:ȸ�� ����, 5:ȸ�� ����  0:����");
			if (choiceCus.equals("1"))
				join.cusList();
			else if (choiceCus.equals("2"))
				join.searchCus();
			else if (choiceCus.equals("3")) {
				join.cusJoin();
			System.out.println("ȸ���� �߰��Ǿ����ϴ�.");
				
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
