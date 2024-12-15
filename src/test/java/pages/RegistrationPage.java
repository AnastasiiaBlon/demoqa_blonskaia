package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalComponent;
import pages.components.TableComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

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
                            stateField = $("#state"),
                            stateDropdown = $("#stateCity-wrapper"),
                            cityField = $("#city"),
                            cityDropdown = $("#stateCity-wrapper"),
                            submitButton = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableComponent tableComponent = new TableComponent();
    ModalComponent modalComponent = new ModalComponent();

    private final static String confirmationPageTitle = "Thanks for submitting the form";

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstNameUser) {
        firstNameInput.setValue(firstNameUser);

        return this;
    }

    public RegistrationPage setLastName(String lastNameUser) {
        lastNameInput.setValue(lastNameUser);

        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderWrapper.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setNumber(String phone) {
        userNumberInput.setValue(phone);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressTab();

        return this;
    }

    public RegistrationPage setImage(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateField.click();
        stateDropdown.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityField.click();
        cityDropdown.$(byText(value)).click();

        return this;
    }
    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage submissionSuccess() {
        modalComponent.isVisible();

        return this;
    }

    public RegistrationPage submissionFail() {
        modalComponent.isHidden();
        return this;
    }

    public RegistrationPage submissionModalWindowMessage() {
        modalComponent.getTitle(confirmationPageTitle);

        return this;
    }

    public RegistrationPage resultTablePairs(String key, String value) {
        tableComponent.checkTableValue(key, value);

        return this;
    }
}
