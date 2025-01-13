package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositorySearchAtTheTop() {
        // open main page
        open("https://github.com/");

        // fill search field in with "selenide" and press enter
        $("").setValue("selenide").pressEnter();
        // click on the first repository among found
        $$("").first().$("").click();
        // check: headline is selenide/selenide
        $("").shouldHave(Condition.text(""));
        sleep(5000);

        // .className, #id1, [], a[href=abc].red

        // Test structure
        // ARRANGE
        // ACT
        // ASSERT




    }
}
