public class CustomerVO {
	private String userId;
	private String userPwd;
	private String name;
	private String tel;
	private String email;
	
	private String address;
	
	public CustomerVO() {
		
	}
	
	public CustomerVO(String userId, String userPwd, String name, String tel, String email, String address) {
	this.userId = userId;
	this.userPwd = userPwd;
	this.name = name;
	this.tel = tel;
	this.email = email;
	this.address = address;
	}

	public void print() {
		System.out.printf("%14s %10s %10s %17s %16s %16s\n", userId, userPwd, name, tel, email, address);
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserID(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
