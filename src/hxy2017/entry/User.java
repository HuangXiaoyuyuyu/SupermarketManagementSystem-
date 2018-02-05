package hxy2017.entry;

public class User {
	private String name;
	 private String password;
	 private int id;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public User() {
		super();
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString(){
		return "[" +"�û�id��"+ id+","+"�û�����"+name + ", " +"��¼���룺"+password +  "]"+"\n";
	}
	 
}
