package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class AutomationPracticeFormsPageObjectTest extends BrowserTestConfig {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("johnDoe@gmail.com")
                .setGender("Female")
                .setNumber("8900000000")
                .setDateOfBirth("18", "May", "1993")
                .setSubjects("Arts")
                .setHobbies("Sports")
                .setImage("ams.jpg")
                .setAddress("USA")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .submit();

        registrationPage
                .submissionSuccess()
                .submissionModalWindowMessage();

        registrationPage
                .resultTablePairs("Student Name", "John Doe")
                .resultTablePairs("Student Email", "johnDoe@gmail.com")
                .resultTablePairs("Gender", "Female")
                .resultTablePairs("Mobile", "8900000000")
                .resultTablePairs("Date of Birth", "18 May,1993")
                .resultTablePairs("Subjects", "Arts")
                .resultTablePairs("Hobbies", "Sports")
                .resultTablePairs("Picture", "ams.jpg")
                .resultTablePairs("Address", "USA")
                .resultTablePairs("State and City", "Uttar Pradesh Lucknow");
        }

    @Test
    void requiredFieldsFillTest() {
        registrationPage.openPage()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("johnDoe@gmail.com")
                .setGender("Female")
                .setNumber("8900000000")
                .submit();

        registrationPage
                .submissionSuccess()
                .submissionModalWindowMessage();

        registrationPage
                .resultTablePairs("Student Name", "John Doe")
                .resultTablePairs("Student Email", "johnDoe@gmail.com")
                .resultTablePairs("Gender", "Female")
                .resultTablePairs("Mobile", "8900000000");
    }

    @Test
    void emptyFieldsSubmissionTest() {
        registrationPage.openPage()
                .submit();

        registrationPage
                .submissionFail();
    }
}
