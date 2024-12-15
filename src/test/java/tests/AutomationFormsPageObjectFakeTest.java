package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomTestData;

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
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjectOne)
                .setHobbies(hobby)
                .setImage(picture)
                .setAddress(street)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPage
                .submissionSuccess()
                .submissionModalWindowMessage();

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
        }

    @Test
    void requiredFieldsFillTest() {
        registrationPage.openPage()
                .setFirstName(firstNameUser)
                .setLastName(lastNameUser)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .submit();

        registrationPage
                .submissionSuccess()
                .submissionModalWindowMessage();

        registrationPage
                .resultTablePairs("Student Name", firstNameUser + " " + lastNameUser)
                .resultTablePairs("Student Email", email)
                .resultTablePairs("Gender", gender)
                .resultTablePairs("Mobile", phone);
    }

    @Test
    void emptyFieldsSubmissionTest() {
        registrationPage.openPage()
                .submit();

        registrationPage
                .submissionFail();
    }
}
