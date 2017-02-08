package net.sytes.codeline.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumher;
	private String photo;
	private Date registrationDate;
	private Domain domainId;
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="PHONE_NUMBER")
	public String getPhoneNumher() {
		return phoneNumher;
	}
	public void setPhoneNumher(String phoneNumher) {
		this.phoneNumher = phoneNumher;
	}
	
	@Column(name="PHOTO")
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Column(name="REGISTRATION_DATE")
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@JoinColumn(name="DOMAIN_ID", referencedColumnName="DOMAIN_ID")
	@ManyToOne
	public Domain getDomainId() {
		return domainId;
	}
	public void setDomainId(Domain domainId) {
		this.domainId = domainId;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", address=" + address + ", phoneNumher=" + phoneNumher
				+ ", photo=" + photo + ", registrationDate=" + registrationDate + ", domainId=" + domainId + "]";
	}
	
}
