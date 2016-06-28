package test.daou.samples;

import com.github.jsdevel.testng.selenium.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.daou.samples.result.page.*;

import java.net.URL;

public class DaouHomePage extends AbstractPage<DaouHomePage, DaouPageFactory> {

    @FindBy(xpath = "//*[@id=\"search-keyword\"]")
    public WebElement search;

    @FindBy(xpath = "//*[@id=\"btn-search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement id;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement pw;

    @FindBy(xpath = "//*[@id=\"login_submit\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"no_search_menu\"]/h1")
    public WebElement resultString;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/a/span[1]")
    public WebElement communicationButton;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/li[2]/div/ul/li[1]/a/span")
    public WebElement mailButton;

    @FindBy(xpath = "//*[@id=\"mailLeftMenuWrap\"]/section[2]/a")
    public WebElement mailWriteButton;

    @FindBy(xpath = "//*[@id=\"to\"]")
    public WebElement mailReceiver;

    @FindBy(xpath = "//*[@id=\"subject\"]")
    public WebElement mailSubject;

    @FindBy(xpath = "//*[@id=\"write_toolbar_wrap\"]/div[1]/a[1]")
    public WebElement mailSendButton;

    @FindBy(xpath = "//*[@id=\"gpopupLayer\"]/footer/a[1]")
    public WebElement mailSendOkButton;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/a/span[1]")
    public WebElement socialButton;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/li[3]/div/ul/li[1]/a/span")
    public WebElement boardButton;

    @FindBy(xpath = "//*[@id=\"writeBtn\"]")
    public WebElement boardWriteButton;

    @FindBy(xpath = "//*[@id=\"subject\"]")
    public WebElement boardWriteSubject;

    @FindBy(xpath = "//*[@id=\"classicWriteSubmitWrap\"]/span[1]")
    public WebElement boardWriteSubmitButton;

    @FindBy(xpath = "//*[@id=\"top_logout\"]/a")
    public WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"Inbox_31\"]/td[4]/a/span")
    public WebElement checkText;

    public DaouBoardWritePage getWriteBoardPage() {

        boardWriteButton.click();

        return getPageFactory().getBoardWritePage();

    }

    public boolean writeBoard(String boardSubject, String boardContents) throws InterruptedException {
        boardWriteSubject.sendKeys(boardSubject);

        Thread.sleep(1000);

        getWebDriver().switchTo().frame(getWebDriver().findElement(By.xpath("//*[@id=\"classicWriteWrap\"]/fieldset/div/iframe")));
        getWebDriver().switchTo().frame(getWebDriver().findElement(By.xpath("//*[@id=\"se2_iframe\"]")));
        getWebDriver().findElement(By.className("se2_inputarea")).sendKeys(boardContents);

        Thread.sleep(1000);

        getWebDriver().switchTo().defaultContent();

        boardWriteSubmitButton.click();

        return true;
    }

    public DaouBoardReulstPage goBoradPage() {

        socialButton.click();
        boardButton.click();

        return getPageFactory().getBoardPage();
    }

    public DaouLoginResultsPage login(String daouId, String daouPw) {

        id.sendKeys(daouId);
        pw.sendKeys(daouPw);
        loginButton.click();
        return getPageFactory().getDaouLoginResultsPage();
    }

    public DaouSearchResultsPage submitSearch(String query) {

        search.sendKeys(query);
        searchButton.click();
        return getPageFactory().getSearchResultsPage();
    }

    public DaouReceivedMailResultPage daouGoReceivedMail() {

        communicationButton.click();
        mailButton.click();

        return getPageFactory().getDaouReceivedMailResultPage();
    }

    public DaouGoMailResultPage daouGoMail() {
        mailWriteButton.click();

        return getPageFactory().getMailPage();
    }

    public DaouReceivedMailResultPage sendMail(String receiver, String subject, String contents) throws InterruptedException {

        mailReceiver.click();
        mailReceiver.sendKeys(receiver);
        mailSubject.sendKeys(subject);

        getWebDriver().switchTo().frame(getWebDriver().findElement(By.xpath("//*[@id=\"modeHtmlWrapper\"]/iframe")));
        getWebDriver().switchTo().frame(getWebDriver().findElement(By.xpath("//*[@id=\"se2_iframe\"]")));
        getWebDriver().findElement(By.className("se2_inputarea")).sendKeys(contents);

        getWebDriver().switchTo().defaultContent();

        mailSendButton.click();
        Thread.sleep(2000);
        mailSendOkButton.click();
        Thread.sleep(2000);

        return getPageFactory().getDaouReceivedMailResultPage();
    }

    public DaouLoginResultsPage logoutAndlogIn(String daouId, String daouPw) {
        logoutButton.click();

        id.sendKeys(daouId);
        pw.sendKeys(daouPw);
        loginButton.click();
        return getPageFactory().getDaouLoginResultsPage();
    }

    public String getResultText() {

        return checkText.getText();
    }

    protected boolean isPageViewableFrom(URL proposedUrl) {

        return proposedUrl.getPath().startsWith("/");
    }
}
