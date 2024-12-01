package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeTestsStart() {
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void dragAndDropCheckElements() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void actionsCheckElements() {
        open("/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
    }
}
