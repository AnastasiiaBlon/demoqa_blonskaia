package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private SelenideElement firstNameInput = $("#firstName"),
                            lastNameInput = $("#lastName"),
                            userEmailInput = $("#userEmail"),
                            genderWrapper = $("#genterWrapper"),
                            userNumberInput = $("#userNumber"),
                            dateOfBirthInput = $("#dateOfBirthInput"),
                            subjectsInput = $("#userForm #subjectsInput"),
                            hobbiesInput = $("#hobbiesWrapper"),
                            pictureUpload = $("#uploadPicture"),
                            currentAddressInput = $("#currentAddress"),
                            cityFieldInput = $("#react-select-3-input"),
                            stateDropdown =  $("#react-select-4-input"),
                            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();

}
