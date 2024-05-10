package day6_SchemaValidation;

public class Students_POJO_PostRequest {
	
	//We have to create setter and getter method for all variables
	
	String id;
	String name;
	String location;
	String phone;
	String courses[];

	
	//Create all getter setter method automatically follow below step
	//1. Select All Variables
	//2. Go to Source--> Generate Getter And Setters --> Select Variables --> Click Generate
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}

}
