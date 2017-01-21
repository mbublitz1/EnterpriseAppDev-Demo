package ca.nait.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import Helper.Gmail;
import ca.nait.domain.GuestResponse;

//mark this class as a JSF CDI-managed bean class
@Named //allows you to access an instance of this class using JSF-EL (Expression Language)
@RequestScoped  // create an instance for one HTTP request and destroy it after the HTTP response is sent
				// other scopes:
				// @ViewedScoped //Keep instance until HTTP request for another page
				// @SessionScoped //allows instance to be shared across multiple pages for one client
				// @ApplcationScoped //one instance is shared with ALL clients (global data)
public class RsvpFormController {

	private GuestResponse guestResponse = new GuestResponse(); //getter and setter
	
	public GuestResponse getGuestResponse() {
		return guestResponse;
	}

	public void setGuestResponse(GuestResponse guestResponse) {
		this.guestResponse = guestResponse;
	}

	//an "action" method returns a String to the next page
	//an "actionListener" does not return a value and navigation stays on the same page
	public String submitForm()
	{
		System.out.println(guestResponse);
		Gmail mailer = new Gmail("test@test.com", "MyPassword");
		String mailMessage = "";
		if(guestResponse.getWillAttend())
		{
			mailMessage = "It's great that you're coming to my party.  Thank you, you are awesome";
		}
		else
		{
			mailMessage = "Sorry to hear that you can't make it.  A gift is still expected";
		}
		try {
			mailer.sendmail("test@test.com", guestResponse.getEmail(), "Party Invitation", mailMessage);
		} catch (Exception e) {
			System.out.println("Cannot send Email");
		}
		return "/thanks?faces-redirect=true"; // this allows pages to be book markable otherwise the address will never change in the address bar>
	}
	
	
}
