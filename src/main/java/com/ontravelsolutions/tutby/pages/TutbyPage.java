package com.ontravelsolutions.tutby.pages;

import com.codeborne.selenide.ElementsContainer;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactTextCaseSensitive;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class TutbyPage {
    @FindBy(id = "mainmenu")
    public MainMenu mainMenu;

    public void login(String login, String password) {
        $("a.enter").click();
        $("input[name='login']").val(login);
        $("input[name='password']").val(password).pressEnter();
    }

    public static class MainMenu extends ElementsContainer {
        public void clickOnTopMenuElement (String name) {
            getSelf().$$("ul > li").filterBy(exactTextCaseSensitive(name)).get(0).click();
        }
        public MailPage openMailPage() {
            clickOnTopMenuElement("Почта"); //TODO: can be moved to resources
            return page(MailPage.class);
        }
    }
}
