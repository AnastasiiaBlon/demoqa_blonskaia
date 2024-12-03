package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CodeJunitTest {

    @BeforeAll
    static void browserSetUp() {
        Configuration.browserSize = "1928x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void codeOnJUnitPageTest() {
        // open Selenide page in github
        open("/selenide/selenide");
        $("#repository-container-header").shouldHave(text("selenide / selenide"));

        // go to Wiki project section
        $("#wiki-tab").click();
        $(".markdown-heading").shouldHave(text("Welcome to the selenide wiki!"));

        // check: there is SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));

        // open SoftAssertions page
        $("#wiki-body").$(byText("Soft assertions")).click();

        // check: there is code example for JUnit5
        $("#wiki-body").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"
        ));
    }
}
