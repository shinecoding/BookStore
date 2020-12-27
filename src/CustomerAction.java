import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class CustomerAction {

	static TreeMap<String, CustomerVO> cusList = new TreeMap<String, CustomerVO>();
	CustomerVO custvo = new CustomerVO();
	Scanner sc = new Scanner(System.in);
	private String telRegExp = "(02|010)-\\d{3,4}-\\d{4}";
	private String emRegExp = "\\w+@\\w+\\.\\w+(\\.\\w)?";
	private String pwdRegExp = "\\w{6,}";

	public CustomerAction() {
	}

	public String conInput(String msg) {
		System.out.print(msg + "=");
		return sc.nextLine();
	}

	public void cusList() {
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.printf("%12s %8s %7s %12s %12s %17s\n", "���̵�", "��й�ȣ", "�̸�", "��ȭ��ȣ", "�̸���", "�ּ�");
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		Collection<CustomerVO> valueList = cusList.values();
		Iterator<CustomerVO> it = valueList.iterator();
		while (it.hasNext()) {
			it.next().print();
		}
		System.out.println();
	}

	public void searchCus() {
		String name = conInput("ȸ�� ���̵�");
		CustomerVO search = cusList.get(name);
		if (search != null) {
			search.print();
		} else {
			System.out.println("�����ϴ� ȸ���� �����ϴ�.");
		}
	}

	public boolean telMatch(String tel) {
		return Pattern.matches(telRegExp, tel);
	}

	public boolean emMatch(String email) {
		return Pattern.matches(emRegExp, email);
	}

	public boolean pwdMatch(String userPwd) {
		return Pattern.matches(pwdRegExp, userPwd);
	}

	public void cusJoin() {
		String userId;
		do {
			userId = conInput("���̵�");
			if (cusList.containsKey(userId)) {
				System.out.println("�ߺ��� ���̵� �����մϴ�.");
			} else {
				break;
			}
		} while (true);

		String userPwd;
		do {
			userPwd = conInput("��й�ȣ");
			if (!pwdMatch(userPwd)) {
				System.out.println("6�ڸ� �̻��� ������, ����, Ư������_ �� ���ո� ����");
			} else {
				break;
			}
		} while (true);

		String name = conInput("�̸�");
		String tel;
		String email;
		do {
			tel = conInput("��ȭ��ȣ");
			if (!telMatch(tel)) {
				System.out.println("��Ȯ�� ��ȭ��ȣ�� �ۼ����ּ���");
			} else {
				break;
			}
		} while (true);
		do {
			email = conInput("�̸���");
			if (!emMatch(email)) {
				System.out.println("��Ȯ�� �̸����� �ۼ����ּ���.");
			} else {
				break;
			}
		} while (true);

		String address = conInput("�ּ�");

		CustomerVO cusvo = new CustomerVO(userId, userPwd, name, tel, email, address);
		cusList.put(userId, cusvo);
		cusList.get(userId).print();
	}

	public void editCus() {
		String cusId = conInput("������ ���̵�");
		CustomerVO cusvo = cusList.get(cusId);
		if (cusvo != null) {
			cusvo.print();
			String editMenu = conInput("������ �׸��� �����ϼ���. (1:��й�ȣ 2:�̸� 3:��ȭ��ȣ 4:�̸��� 5:�ּ�)");
			String data = conInput("������ ������ �Է�");

			switch (editMenu) {
			case "1":
				do {
					if (!pwdMatch(data)) {
						data = conInput("6�ڸ� �̻��� ������, ����, Ư������_ �� ���ո� ����");
					} else {
						cusvo.setUserPwd(data);
						break;
					}
				} while (true);
				cusList.get(cusId).print();
				break;
			case "2":
				cusvo.setName(data);
				cusList.get(cusId).print();
				break;
			case "3":
				do {
					if (!telMatch(data)) {
						data = conInput("��Ȯ�� ��ȭ��ȣ�� �ۼ����ּ���");
					} else {
						cusvo.setTel(data);
						break;
					}
				} while (true);
				cusList.get(cusId).print();
				break;
			case "4":
				do {
					if (!emMatch(data)) {
						data = conInput("��Ȯ�� �̸����� �ۼ����ּ���");
					} else {
						cusvo.setEmail(data);
						break;
					}
				} while (true);
				cusList.get(cusId).print();
				break;
			case "5":
				cusvo.setAddress(data);
				cusList.get(cusId).print();
				break;
			default:
				System.out.println("������ �׸��� �߸� �����ϼ̽��ϴ�.");
				break;
			}
		} else

		{
			System.out.println(cusId + "������ ã�� �� �����ϴ�.");
		}
	}

	public void deleteCus() {
		String key = conInput("������ ���̵� �Է�");
		cusList.remove(key);
	}

	public TreeMap<String, CustomerVO> setCusList() {
		cusList.put("kim", new CustomerVO("kim", "1234", "���", "010-1111-2222", "kim@naver.com", "����� ������ �����"));
		cusList.put("park", new CustomerVO("park", "1234", "�ڰ�", "010-1111-2222", "park@naver.com", "����� ������ �������"));
		return cusList;
	}

	private String userId = "admin";
	private String userPwd = "1234";

	public int admCheck(String userId, String userPwd) {
		try {

			if (this.userId.equals(userId) && this.userPwd.equals(userPwd)) {
				return 1;
			} else if (cusList.get(userId).getUserId().equals(userId)
					&& cusList.get(userId).getUserPwd().equals(userPwd)) {
				return 2;
			} else {
				return -1;
			}
		} catch (NullPointerException npe) {
			return -1;
		}

	}
}
