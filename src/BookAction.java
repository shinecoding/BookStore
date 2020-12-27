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
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.printf("%14s\t%6s\t%7s\t%10s\t%6s\t%4s\n", "����", "�۰�", "���ǻ�", "�Ⱓ��", "�ǸŰ�", "�з�");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		Collection<LibraryVO> valueList = bookList.values();
		Iterator<LibraryVO> it = valueList.iterator();
		while(it.hasNext()) {
			it.next().print();
		}
		System.out.println();
	}
	
	
	public void searchBookbyName() {
	/*	String name = conInput("å �̸� �˻�");
		LibraryVO search. = bookList.get(name);
		if(search!=null) {
				search.print();
		}
		*/
		
		String name = conInput("å �̸�");
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
		String genre = conInput("�о� �˻� (�Ҽ�, �ڱ���, �ι�, ����, ���)");
		Object[] key = bookList.keySet().toArray();
		for(Object k : key) {
				if(bookList.get(k).getGenre().equals(genre)) {
					bookList.get(k).print();
					
			}
			
		}
		
	}
	
	public void searchBookbyAuthor() {
		String author = conInput("�۰� �̸�");
		Object[] key = bookList.keySet().toArray();
		for(Object k: key) {
			if(bookList.get(k).getAuthor().equals(author)) {
				bookList.get(k).print();
			} 
		}
	}

	

	
	public void addBook() { //å �߰�
		String bookName = conInput("å �̸�");
		String author = conInput("�۰�");
		String publisher = conInput("���ǻ�");
		String publishedDate = conInput("������(����: 2020-1-1)");
		int price = Integer.parseInt(conInput("�ǸŰ�"));
		String genre = conInput("�帣");
	
		LibraryVO libvo = new LibraryVO(bookName, author, publisher, publishedDate, price, genre);
		bookList.put(bookName, libvo);
		bookList.get(bookName).print();
	}
	
	public void editBook() {
		String bookName = conInput("������ å �̸�");
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
			
			String editMenu = conInput("������ �׸��� �����ϼ���. (1:�۰�, 2:���ǻ�, 3:������, 4:�ǸŰ�, 5:�帣)");
			String data = conInput("������ ������ �Է�");
	
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
				System.out.println("������ �׸��� �߸� �����ϼ̽��ϴ�.");
				break;
			}
		}else {
			System.out.println(bookName+ "�� ���� �����Դϴ�.");
			}	
		
		
		
	}
	
	
	public void deleteBook() {
		String key = conInput("������ ������ �Է�");
		bookList.remove(key);
	}
	

		
		
	public TreeMap<String, LibraryVO> setBooks() {
		bookList.put("�����", new LibraryVO("�����", "������", "������", "2020-5-3", 12000, "�Ҽ�"));
		bookList.put("�� ���� �̾߱�", new LibraryVO("�� ���� �̾߱�", "������", "������", "2020-4-14", 18000, "�Ҽ�"));
		bookList.put("�ֽ����� 100�� ����", new LibraryVO("�ֽ����� 100�� ����", "���ֽ�", "������", "2019-8-16", 13000, "�ڱ���"));
		bookList.put("��������å", new LibraryVO("��������å", "��������ȸ", "������", "2015-5-26", 9000, "����"));
		bookList.put("������ ����", new LibraryVO("������ ����", "ȣ����", "��ȭ��", "2017-12-25", 10000, "���"));
		bookList.put("����� ���", new LibraryVO("����� ���", "���Ѿ���", "��ȭ��", "2018-11-13", 11000, "���"));
		bookList.put("�ι��� ��å", new LibraryVO("�ι��� ��å", "������", "������", "2016-9-19", 16000, "�ι�"));
		bookList.put("�� �����ǹ���", new LibraryVO("�� �����ǹ���", "������", "������", "2018-7-6", 13000, "�ڱ���"));
		return bookList;
	}
	}

