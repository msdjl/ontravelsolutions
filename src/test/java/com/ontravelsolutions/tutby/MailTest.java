package com.ontravelsolutions.tutby;

import com.ontravelsolutions.tutby.pages.MailPage;
import com.ontravelsolutions.tutby.pages.TutbyPage;
import com.ontravelsolutions.tutby.util.Config;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class MailTest{
    private MailPage mail;
    final private int expectedMessagesCount = 3;

    @BeforeTest
    public void beforeTest() throws Exception {
        String login = Config.username;
        String password = Config.password;
        TutbyPage page = open("/", TutbyPage.class);
        page.login(login, password);
        mail = page.mainMenu.openMailPage();
    }

    @Test(description = "let's take number of sent mails from the badge on the left side panel")
    public void testBadgeContent() throws Exception {
        mail.leftPanel.getSentMessagesNumber().shouldHave(exactText(String.valueOf(expectedMessagesCount)));
    }

    @Test(description = "as an alternative let's count visible items of the messages list (will not work in case there is pagination or something like)")
    public void testVisibleMessagesCount() throws Exception {
        mail.leftPanel.sentFolder.click();
        mail.getVisibleMessages().shouldHaveSize(expectedMessagesCount);
    }
}
