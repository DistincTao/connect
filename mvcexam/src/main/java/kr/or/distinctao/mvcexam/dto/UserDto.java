package kr.or.distinctao.mvcexam.dto;


public class UserDto {

	private String name;
	private String email;
	private int age;
	

	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", email=" + email + ", age=" + age + "]";
	}	
	
}
