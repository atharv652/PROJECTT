package entities;

public class Registration 
{
String id,name,address,city,pincode,password,contact,role,uid;

public Registration(String id, String name, String address, String city, String pincode, String password,
		String contact, String role, String uid) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.city = city;
	this.pincode = pincode;
	this.password = password;
	this.contact = contact;
	this.role = role;
	this.uid = uid;
}

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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getPincode() {
	return pincode;
}

public void setPincode(String pincode) {
	this.pincode = pincode;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}


}
