package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenide {

    @Test
    void andreiSolntsevSouldBeTheFirstContributor() {

        // open selenide page
        open("");

        // hover mouse to the first contributor icon of contributors block
        // check: text "Andrei Solntsev" in pop window
    }
}
