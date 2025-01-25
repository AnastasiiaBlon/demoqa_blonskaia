package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomTestData;

import static io.qameta.allure.Allure.step;

public class AutomationFormsPageObjectFakeTest extends BrowserTestConfig {
    private String
            firstNameUser,
            lastNameUser,
            email,
            gender,
            phone,
            yearOfBirth,
            monthOfBirth,
            dayOfBirth,
            subjectOne,
            hobby,
            picture,
            street,
            state,
            city;

    private String confirmPageFullStudentName = "Student Name",
                    confirmPageStudentEmail = "Student Email",
                    confirmPageStudentGender = "Gender",
                    confirmPageStudentPhone = "Mobile",
                    confirmPageStudentBirthday = "Date of Birth",
                    confirmPageStudentSubject = "Subjects",
                    confirmPageStudentHobby = "Hobbies",
                    confirmPageStudentPicture = "Picture",
                    confirmPageStudentAddress = "Address",
                    confirmPageStudentStateAndCity = "State and City";
    RegistrationPage registrationPage = new RegistrationPage();
    RandomTestData randomTestData = new RandomTestData();

    @BeforeEach
    public void setUp() {
        firstNameUser = randomTestData.getFirstName();
        lastNameUser = randomTestData.getLastName();
        gender = randomTestData.getGender();
        email = randomTestData.getUserEmail();
        phone = randomTestData.getUserPhone();
        yearOfBirth = randomTestData.getYearOfBirth();
        monthOfBirth = randomTestData.getMonthOfBirth();
        dayOfBirth = randomTestData.getDayOfBirth();
        subjectOne = randomTestData.getSubject();
        hobby = randomTestData.getHobby();
        picture = randomTestData.getPicture();
        street = randomTestData.getStreetAddress();
        state = randomTestData.getState();
        city = randomTestData.getCity();
    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill in first name field", () -> {
            registrationPage.setFirstName(firstNameUser);
        });

        step("Fill in last name field", () -> {
            registrationPage.setLastName(lastNameUser);
        });

        step("Fill in email field", () -> {
            registrationPage.setEmail(email);
        });

        step("Select gender", () -> {
            registrationPage.setGender(gender);
        });

        step("Fill in phone number field", () -> {
            registrationPage.setNumber(phone);
        });

        step("Select date of birth", () -> {
            registrationPage.setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        });

        step("Select subjects", () -> {
            registrationPage.setSubjects(subjectOne);
        });

        step("Select hobbies", () -> {
            registrationPage.setHobbies(hobby);
        });

        step("Set image", () -> {
            registrationPage.setImage(picture);
        });

        step("Set address", () -> {
            registrationPage.setAddress(street);
        });

        step("Set state", () -> {
            registrationPage.setState(state);
        });

        step("Set city", () -> {
            registrationPage.setCity(city);
        });

        step("Submit filled in form", () -> {
            registrationPage.submit();
        });

        step("Success window is shown", () -> {
            registrationPage.submissionSuccess();
        });

        step("Success message is shown", () -> {
            registrationPage.submissionModalWindowMessage();
        });

        step("Data is matched with data in fields of registration form", () -> {
            registrationPage
                    .resultTablePairs(confirmPageFullStudentName, firstNameUser + " " + lastNameUser)
                    .resultTablePairs(confirmPageStudentEmail, email)
                    .resultTablePairs(confirmPageStudentGender, gender)
                    .resultTablePairs(confirmPageStudentPhone, phone)
                    .resultTablePairs(confirmPageStudentBirthday, dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                    .resultTablePairs(confirmPageStudentSubject, subjectOne)
                    .resultTablePairs(confirmPageStudentHobby, hobby)
                    .resultTablePairs(confirmPageStudentPicture, picture)
                    .resultTablePairs(confirmPageStudentAddress, street)
                    .resultTablePairs(confirmPageStudentStateAndCity, state + " " + city);
        });
        }

    @Test
    @Tag("demoqa")
    void requiredFieldsFillTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });

        step("Fill in first name field", () -> {
            registrationPage.setFirstName(firstNameUser);
        });

        step("Fill in last name field", () -> {
            registrationPage.setLastName(lastNameUser);
        });

        step("Fill in email field", () -> {
            registrationPage.setEmail(email);
        });

        step("Select gender", () -> {
            registrationPage.setGender(gender);
        });

        step("Fill in phone number field", () -> {
            registrationPage.setNumber(phone);
        });

        step("Submit filled in form", () -> {
            registrationPage.submit();
        });

        step("Success window is shown", () -> {
            registrationPage.submissionSuccess();
        });

        step("Success message is shown", () -> {
            registrationPage.submissionModalWindowMessage();
        });

        step("Data is matched with data in fields of registration form", () -> {
            registrationPage
                    .resultTablePairs(confirmPageFullStudentName, firstNameUser + " " + lastNameUser)
                    .resultTablePairs(confirmPageStudentEmail, email)
                    .resultTablePairs(confirmPageStudentGender, gender)
                    .resultTablePairs(confirmPageStudentPhone, phone);
        });
    }

    @Test
    @Tag("demoqa")
    void emptyFieldsSubmissionTest() {
            step("Open form", () -> {
                registrationPage.openPage();
            });

        step("Submit filled in form", () -> {
            registrationPage.submit();
        });

        step("No registration form shown", () -> {
            registrationPage.submissionFail();
        });
    }
}
