package com.ontravelsolutions.tutby.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class MailPage {
    @FindBy(className = "block-left-box")
    public LeftPanel leftPanel;

    public ElementsCollection getVisibleMessages() {
        return $$(".b-messages__message").filter(visible);
    }

    public static class LeftPanel extends ElementsContainer {
        @FindBy(className = "b-folders__folder_sent")
        public SelenideElement sentFolder;

        public SelenideElement getSentMessagesNumber() {
            return sentFolder.$(".b-folders__folder__counters__total");
        }
    }
}
