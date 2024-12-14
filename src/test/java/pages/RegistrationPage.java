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

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber(String value) {
        userNumberInput.setValue(value);

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

    public RegistrationPage submissionModalWindowMessage(String value) {
        modalComponent.getTitle(value);

        return this;
    }

    public RegistrationPage resultTablePairs(String key, String value) {
        tableComponent.checkTableValue(key, value);

        return this;
    }
}
