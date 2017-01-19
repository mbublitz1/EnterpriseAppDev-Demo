package ca.nait.domain;

import org.hibernate.validator.constraints.NotBlank;

public class GuestResponse {
	
	//Java annotations for validation using bean validation
	@NotBlank(message="Please enter your name")
	private String name;
	@NotBlank(message="Please enter your Email address")
	@Email(message="Please enter a valid email address")
	private String email;
	@NotBlank(message="Please enter your phone number")
	private String phone;
	@NotNull (message="Please select whether you'll attend")
//	Using Boolean is a wrapper that will handle nullable values
	private Boolean willAttend;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getWillAttend() {
		return willAttend;
	}
	public void setWillAttend(Boolean willAttend) {
		this.willAttend = willAttend;
	}
	
	//something something

}
