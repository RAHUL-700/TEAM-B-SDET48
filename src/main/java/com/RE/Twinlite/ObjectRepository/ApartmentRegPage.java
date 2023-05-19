package com.RE.Twinlite.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentRegPage {

	//declaration 
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='apartment_name']")private WebElement apartname;
			@FindBy(xpath="(//input[@id='fullname'])[2]")private WebElement fullname;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='mobile']")private WebElement mobile;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='alternat_mobile']")private WebElement alternat_mobile;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='email']")private WebElement email;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='plot_number']")private WebElement plotNo;
			@FindBy(xpath="(//input[@name='rooms'])")private WebElement rooms;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='country']")private WebElement country;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='state']")private WebElement state;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='city']")private WebElement city;
			@FindBy(xpath="//input[@name='rent[]']")private WebElement rent;
			@FindBy(xpath="//input[@name='deposit[]']")private WebElement deposit;
			@FindBy(xpath="//input[@name='accommodation[]']")private WebElement accommodation;
			@FindBy(xpath="//input[@name='description[]']")private WebElement description;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='landmark']")private WebElement landmark;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='address']")private WebElement address;
			@FindBy(xpath="//select[@class='form-control']")private WebElement vacantOrOccupied;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//input[@name='image']")private WebElement UploadImg;
			@FindBy(xpath="//h2[.='Apartment Room']/../form//button[.='Submit']")private WebElement submitApartReg;
			@FindBy(xpath="//a[.='Add More(Plat Number/Description)']")private WebElement moreFlatsBtn;
			
			@FindBy(xpath="//input[@name='ap_number_of_plats[]']")private WebElement noOfFlats;
			@FindBy(xpath="//input[@name='rooms[]']")private WebElement noOfRooms;
			@FindBy(xpath="//input[@name='area[]']")private WebElement area;
			
			@FindBy(xpath="//a[.='Individual Home Registration']")private WebElement RegRoomsBtn;
			@FindBy(xpath="(//div[.='Registration successfull. Thank you'])[1]")private WebElement successText;
			
			//initialization using constructors
			public ApartmentRegPage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
			
			

			public WebElement getMoreFlatsBtn() {
				return moreFlatsBtn;
			}



			public WebElement getApartname() {
				return apartname;
			}


			public WebElement getNoOfFlats() {
				return noOfFlats;
			}

			public WebElement getNoOfRooms() {
				return noOfRooms;
			}

			public WebElement getArea() {
				return area;
			}

			public WebElement getFullname() {
				return fullname;
			}
			

			public WebElement getSuccessText() {
				return successText;
			}

			public WebElement getMobile() {
				return mobile;
			}

			public WebElement getAlternat_mobile() {
				return alternat_mobile;
			}

			public WebElement getEmail() {
				return email;
			}

			public WebElement getPlotNo() {
				return plotNo;
			}

			public WebElement getRooms() {
				return rooms;
			}

			public WebElement getCountry() {
				return country;
			}

			public WebElement getState() {
				return state;
			}

			public WebElement getCity() {
				return city;
			}

			public WebElement getRent() {
				return rent;
			}

			public WebElement getDeposit() {
				return deposit;
			}

			public WebElement getAccommodation() {
				return accommodation;
			}

			public WebElement getDescription() {
				return description;
			}

			public WebElement getLandmark() {
				return landmark;
			}

			public WebElement getAddress() {
				return address;
			}

			public WebElement getVacantOrOccupied() {
				return vacantOrOccupied;
			}

			public WebElement getUploadImg() {
				return UploadImg;
			}

			public WebElement getSubmitApartReg() {
				return submitApartReg;
			}

			public WebElement getRegRoomsBtn() {
				return RegRoomsBtn;
			}
			

		
}
