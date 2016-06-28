package test.jiracollector.practice;

import com.github.jsdevel.testng.selenium.AbstractPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import test.jiracollector.practice.result.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by daou on 2016-04-19.
 */
public class CollectorHomePage extends AbstractPage<CollectorHomePage, CollectorPageFactory> {

    @FindBy(xpath = "//*[@id=\"project\"]")
    public WebElement productSelector;

    @FindBy(xpath = "//*[@id=\"version\"]")
    public WebElement versionSelector;

    @FindBy(xpath = "//*[@id=\"graph\"]")
    public WebElement graphSelector;

    @FindBy(xpath = "//*[@id=\"btnSubmitGraph\"]")
    public WebElement graphCreatButton;

    @FindBy(xpath = "//*[@id=\"tableType\"]")
    public WebElement graphTypes;

    @FindBy(xpath = "//*[@id=\"tbContents\"]/tbody/tr[2]/td[1]")
    public WebElement firstDateInTable;

    @FindBy(xpath = "//*[@id=\"btnGoAdmin\"]")
    public WebElement goAdminPageButton;

    @FindBy(xpath = "//*[@id=\"topMenuList\"]/li[2]/a")
    public WebElement projectAdminTopList;

    @FindBy(xpath = "//*[@id=\"topMenuList\"]/li[2]/ul/li[1]/a")
    public WebElement projectList;

    @FindBy(xpath = "//*[@id=\"topMenuList\"]/li[2]/ul/li[2]/a")
    public WebElement projectDate;

    @FindBy(xpath = "//*[@id=\"topMenuList\"]/li[2]/ul/li[3]/a")
    public WebElement releaseVersionList;

    @FindBy(xpath = "//*[@id=\"btnProjectAddition\"]")
    public WebElement addProjectButton;

    @FindBy(xpath = "//*[@id=\"newProjectName\"]")
    public WebElement newProjectNameTextField;

    @FindBy(xpath = "//*[@id=\"newProjectKey\"]")
    public WebElement newProjectKeyTextField;

    @FindBy(xpath = "//*[@id=\"personInCharge\"]")
    public WebElement newPersonSelector;

    @FindBy(xpath = "//*[@id=\"btnForSavingNewProject\"]")
    public WebElement saveProjectButton;

    @FindBy(xpath = "//*[@id=\"jiraNameConfigContentArea\"]/table/tbody/tr[3]/td[2]")
    public WebElement checkProjectName;

    @FindBy(xpath = "//*[@id=\"jiraNameConfigContentArea\"]/table/tbody/tr[3]/td[3]")
    public WebElement checkProjecyKey;

    @FindBy(xpath = "//*[@id=\"jiraNameConfigContentArea\"]/table/tbody/tr[3]/td[5]")
    public WebElement checkPerson;

    @FindBy(xpath = "//*[@id=\"jiraNameConfigContentArea\"]/table/tbody/tr[3]/td[1]")
    public WebElement deleteCheckbox;

    @FindBy(xpath = "//*[@id=\"btnDelete\"]")
    public WebElement deleteButton;

    public CollectorChartsResultPage selectProject(String projectValue) {

        Select clickProduct = new Select(productSelector);
        clickProduct.selectByValue(projectValue);

        return getPageFactory().getCollectorChartsResultPage();

    }

    public CollectorChartsResultPage selectVersion(String versionValue) {

        Select clickVersion = new Select(versionSelector);
        clickVersion.selectByValue(versionValue);

        return getPageFactory().getCollectorChartsResultPage();

    }


    public CollectorChartsResultPage drawCharts(int graphTypeIndex) {

        Select clickGraph = new Select(graphSelector);
        clickGraph.selectByIndex(graphTypeIndex);

        graphCreatButton.click();

        return getPageFactory().getCollectorChartsResultPage();

    }

    public String checkChartsTitle() {

        String  Title = getWebDriver().findElement(By.tagName("svg")).findElement(By.className("highcharts-title")).getText();

        System.out.println("Title : " + Title);

        return Title;

    }

    public String checkChartsSubtitle() {

        String Title = getWebDriver().findElement(By.tagName("svg")).findElement(By.className("highcharts-subtitle")).getText();

        System.out.println("Subtitle : " + Title);

        return Title;

    }

    public String checkToCurrentUrl() {

        return getWebDriver().getCurrentUrl();
    }


    public String checkDateInTable(String dateType) throws InterruptedException {

        Select clickGraph = new Select(graphTypes);
        clickGraph.selectByValue(dateType);

        Thread.sleep(1000);

        String Date = firstDateInTable.getText();

        System.out.println("표의 날짜 : " + Date);

        return Date;

    }

    public String checkFirstDateInGraph() {

        String firestDate = getWebDriver().findElement(By.xpath("//*[@id=\"tbContents\"]/tbody/tr[2]/td[1]")).getText();

        System.out.println("그래프의 날짜 : " + firestDate);

        return firestDate;

    }

    public CollectorDashboardResultPage goAdministratorPage() {

        goAdminPageButton.click();

        return getPageFactory().getCollectorDashboardResultPage();

    }

    public CollectorProjectListResultPage goProjectListPage() {

        projectAdminTopList.click();
        projectList.click();

        return getPageFactory().getCollectorProjectListResultPage();

    }

    public CollectorProjectAdditionResultPage goAddProject() {

        addProjectButton.click();

        return getPageFactory().getCollectorProjectAdditionResultPage();
    }

    ArrayList<String> writeAddProject(String projectName, String projectKey, String person) throws InterruptedException {

        newProjectNameTextField.sendKeys(projectName);

        newProjectKeyTextField.sendKeys(projectKey);

        Select clickPerson = new Select(newPersonSelector);
        clickPerson.selectByVisibleText(person);

        saveProjectButton.click();

        Thread.sleep(5000);

        ArrayList<String> addProjectInfo = new ArrayList<String>();

        addProjectInfo.add(checkProjectName.getText());
        addProjectInfo.add(checkProjecyKey.getText());
        addProjectInfo.add(checkPerson.getText());

        System.out.println(addProjectInfo);

        return addProjectInfo;
    }

    int deleteProject() throws InterruptedException {

        deleteCheckbox.findElement(By.id("projectCheckbox")).click();

        Thread.sleep(2000);

        deleteButton.click();

        Thread.sleep(10000);

        int rowCount = getWebDriver().findElements(By.xpath("//*[@id=\"jiraNameConfigContentArea\"]/table/tbody/tr")).size();

        System.out.println(rowCount);

        return rowCount;

    }

}
