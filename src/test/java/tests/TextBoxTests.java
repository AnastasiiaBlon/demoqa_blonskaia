package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends BrowserTestConfig {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                    .setUserName("Alex")
                    .setUserEmail("alex@egorov.com")
                    .setCurrentAddressBox("Some street 1")
                    .setPermanentAddressBox("Another street 1")
                    .submit();

        textBoxPage.resultName("Alex")
                .resultEmail("alex@egorov.com")
                .resultCurrentAddress("Some street 1")
                .setPermanentAddressBox("Another street 1");
    }
}