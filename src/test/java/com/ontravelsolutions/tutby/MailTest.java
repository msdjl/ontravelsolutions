package com.ontravelsolutions.tutby;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class MailTest{
    private MailPage mail;

    @BeforeTest
    public void beforeTest() {
        String login = System.getProperty("credentials.username");
        String password = System.getProperty("credentials.password");
        TutbyPage page = open("/", TutbyPage.class);
        page.login(login, password);
        mail = page.mainMenu.openMailPage();
    }

    @Test(description = "let's take number of sent mails from the badge on the left side panel")
    public void testBadgeContent() throws Exception {
        mail.leftPanel.getSentMessagesNumber().shouldHave(exactText("3"));
    }

    @Test(description = "as an alternative let's count visible items of the messages list (will not work in case there is pagination or something like)")
    public void testVisibleMessagesCount() throws Exception {
        mail.leftPanel.sentFolder.click();
        mail.getVisibleMessages().shouldHaveSize(3);
    }
}
