package org.stepdef;

import java.util.concurrent.TimeUnit;

import org.cuBase.Gana;
import org.cuBase.Gana1;
import org.cuBase.Gana2;
import org.cuBase.Gana3;

import baseClassv.BaseVikki;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDef extends BaseVikki {
	Gana gana;
	Gana1 gana1;
	Gana2 gana2;
	Gana3 gana3;

	@Given("^User is on adactinHotel page on chrome browser$")
	public void user_is_on_adactinHotel_page_on_chrome_browser() throws Exception {

		getDriverChrome();
		loadUrl("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@When("^user enter the \"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enter_the_and(String arg1, String arg2) throws Exception {
		Gana a = new Gana();
		typeText(a.getTxtUserName(), arg1);
		typeText(a.getTxtPassword(), arg2);
	}

	@When("^user click the login button$")
	public void user_click_the_login_button() throws Exception {
		Gana a = new Gana();
		click(a.getBtnLogin());
	}

	@When("^user check search hotel page visible or not$")
	public void user_check_search_hotel_page_visible_or_not() throws Exception {

		String text = findElementByXpath("//td[text()='Search Hotel ']").getText();
		Assert.assertTrue("verify Tittle in search hotel", text.contains("Search Hotel"));
		sysout(text);
	}

	@When("^user enter the details in search hote page \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enter_the_details_in_search_hote_page_and(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6) throws Exception {

		Gana1 b = new Gana1();

		selectByText(b.getDropDownLocation(), arg1);
		selectByText(b.getDropDownHotels(), arg2);
		selectByText(b.getDropDownRoomType(), arg3);
		selectByText(b.getNoOfRooms(), arg4);
		selectByText(b.getAdultRoom(), arg5);
		selectByText(b.getChildRoom(), arg6);
	}

	@When("^user click the search button$")
	public void user_click_the_search_button() throws Exception {

		Gana1 b = new Gana1();

		click(b.getSubmit());

	}

	@When("^user check select hotel page visible or not$")
	public void user_check_select_hotel_page_visible_or_not() throws Exception {

		String text1 = findElementByXpath("//td[text()='Select Hotel ']").getText();
		Assert.assertTrue("verify Tittle in select hotel", text1.contains("Select Hotel"));
		sysout(text1);
	}

	@When("^user select the hotel and click the search button$")
	public void user_select_the_hotel_and_click_the_search_button() throws Exception {

		Gana2 c = new Gana2();

		click(c.getClick1());
		click(c.getClick2());
	}
	@When("^user check booking page visible or not$")
	public void user_check_booking_page_visible_or_not() throws Exception {

		String text2 = findElementByXpath("//td[text()='Book A Hotel ']").getText();
		Assert.assertTrue("verify Tittle in Book hotel", text2.contains("Book A Hotel"));
		sysout(text2);
	}
	@When("^user enter the details in booking page \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"and\"([^\"]*)\"$")
	public void user_enter_the_details_in_booking_page_and(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7, String arg8) throws Exception {

		Gana3 d = new Gana3();

		typeText(d.getFirstName(), arg1);
		typeText(d.getLastName(), arg2);
		typeText(d.getAddress(), arg3);
		typeText(d.getCcNumber(), arg4);
		selectByText(d.getCcType(), arg5);
		selectByText(d.getCcExpMonth(), arg6);
		selectByText(d.getCcExpYear(), arg7);
		typeText(d.getCcCVV(), arg8);

	}

	@When("^user click the booking button$")
	public void user_click_the_booking_button() throws Exception {

		Gana3 d = new Gana3();
		click(d.getClick());

		String attribute = findElementById("order_no").getAttribute("value");
		sysout(attribute);
	}

}
