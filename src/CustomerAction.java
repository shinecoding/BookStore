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
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.printf("%12s %8s %7s %12s %12s %17s\n", "아이디", "비밀번호", "이름", "전화번호", "이메일", "주소");
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		Collection<CustomerVO> valueList = cusList.values();
		Iterator<CustomerVO> it = valueList.iterator();
		while (it.hasNext()) {
			it.next().print();
		}
		System.out.println();
	}

	public void searchCus() {
		String name = conInput("회원 아이디");
		CustomerVO search = cusList.get(name);
		if (search != null) {
			search.print();
		} else {
			System.out.println("존재하는 회원이 없습니다.");
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
			userId = conInput("아이디");
			if (cusList.containsKey(userId)) {
				System.out.println("중복된 아이디가 존재합니다.");
			} else {
				break;
			}
		} while (true);

		String userPwd;
		do {
			userPwd = conInput("비밀번호");
			if (!pwdMatch(userPwd)) {
				System.out.println("6자리 이상의 영문자, 숫자, 특수문자_ 의 조합만 가능");
			} else {
				break;
			}
		} while (true);

		String name = conInput("이름");
		String tel;
		String email;
		do {
			tel = conInput("전화번호");
			if (!telMatch(tel)) {
				System.out.println("정확한 전화번호를 작성해주세요");
			} else {
				break;
			}
		} while (true);
		do {
			email = conInput("이메일");
			if (!emMatch(email)) {
				System.out.println("정확한 이메일을 작성해주세요.");
			} else {
				break;
			}
		} while (true);

		String address = conInput("주소");

		CustomerVO cusvo = new CustomerVO(userId, userPwd, name, tel, email, address);
		cusList.put(userId, cusvo);
		cusList.get(userId).print();
	}

	public void editCus() {
		String cusId = conInput("수정할 아이디");
		CustomerVO cusvo = cusList.get(cusId);
		if (cusvo != null) {
			cusvo.print();
			String editMenu = conInput("수정할 항목을 선택하세요. (1:비밀번호 2:이름 3:전화번호 4:이메일 5:주소)");
			String data = conInput("수정할 데이터 입력");

			switch (editMenu) {
			case "1":
				do {
					if (!pwdMatch(data)) {
						data = conInput("6자리 이상의 영문자, 숫자, 특수문자_ 의 조합만 가능");
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
						data = conInput("정확한 전화번호를 작성해주세요");
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
						data = conInput("정확한 이메일을 작성해주세요");
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
				System.out.println("수정할 항목을 잘못 선택하셨습니다.");
				break;
			}
		} else

		{
			System.out.println(cusId + "고객님을 찾을 수 없습니다.");
		}
	}

	public void deleteCus() {
		String key = conInput("삭제할 아이디 입력");
		cusList.remove(key);
	}

	public TreeMap<String, CustomerVO> setCusList() {
		cusList.put("kim", new CustomerVO("kim", "1234", "김고객", "010-1111-2222", "kim@naver.com", "서울시 마포구 백범로"));
		cusList.put("park", new CustomerVO("park", "1234", "박고객", "010-1111-2222", "park@naver.com", "서울시 마포구 마포대로"));
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
