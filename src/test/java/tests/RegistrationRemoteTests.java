package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class RegistrationRemoteTests {

    @BeforeAll
    static void beforeTestsStart() {
        Configuration.browserSize = "1928x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void afterEachTest() {
        Selenide.closeWebDriver();
    }

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Open form", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Fill in form", () -> {
            $("#firstName").setValue("John");
            $("#lastName").setValue("Doe");
            $("#userEmail").setValue("johnDoe@gmail.com");
            $("#genterWrapper").$(byText("Female")).click();
            $("#userNumber").setValue("8900000000");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("1993");
            $$(".react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text("18")).click();
            $("#userForm #subjectsInput").setValue("Arts");
            $("#userForm .subjects-auto-complete__menu").click();
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#uploadPicture").uploadFromClasspath("ams.jpg");
            $("#currentAddress").setValue("USA");
            $("#react-select-3-input").setValue("Uttar Pradesh").pressEnter();
            $("#react-select-4-input").setValue("Lucknow").pressEnter();
            $("#submit").click();
                });
        step("Verify results", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table").$(byText("Student Name")).sibling(0).shouldHave(text("John Doe"));
            $(".table").$(byText("Student Email")).sibling(0).shouldHave(text("johnDoe@gmail.com"));
            $(".table").$(byText("Gender")).sibling(0).shouldHave(text("Female"));
            $(".table").$(byText("Mobile")).sibling(0).shouldHave(text("8900000000"));
            $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("18 May,1993"));
            $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Arts"));
            $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Sports, Reading"));
            $(".table").$(byText("Picture")).sibling(0).shouldHave(text("ams.jpg"));
            $(".table").$(byText("Address")).sibling(0).shouldHave(text("USA"));
            $(".table").$(byText("State and City")).sibling(0).shouldHave(text("Uttar Pradesh Lucknow"));
        });
    }
}