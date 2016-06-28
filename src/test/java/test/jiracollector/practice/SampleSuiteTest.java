package test.jiracollector.practice;

import com.github.jsdevel.testng.selenium.AbstractSuite;
import org.testng.annotations.Test;
import test.jiracollector.practice.result.*;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by daou on 2016-04-19.
 */
public class SampleSuiteTest extends AbstractSuite<CollectorPageFactory> {

    @Test
    public void goChartDrawerPage() {

        getPageFactory().getHomePage("/chartdrawer");

    }

    @Test
    public void checkProjectNameByDrawingGraph() throws InterruptedException {

        getPageFactory().getHomePage("/chartdrawer");

        Thread.sleep(5000);

        CollectorChartsResultPage project = getPageFactory().getHomePage().selectProject("GO");

        Thread.sleep(1000);

        CollectorChartsResultPage version = project.getPageFactory().getHomePage().selectVersion("2.3.3");

        Thread.sleep(1000);

        CollectorChartsResultPage graph = version.getPageFactory().getHomePage().drawCharts(1);

        Thread.sleep(2000);

        String checkedProjectText = graph.getPageFactory().getHomePage().checkChartsTitle();

        assertEquals("DaouOffice JIRA 이슈", checkedProjectText);
    }

    @Test
    public void checkVersionNameByDrawingGraph() throws InterruptedException {

        getPageFactory().getHomePage("/chartdrawer");

        Thread.sleep(5000);

        CollectorChartsResultPage project = getPageFactory().getHomePage().selectProject("GO");

        Thread.sleep(1000);

        CollectorChartsResultPage version = project.getPageFactory().getHomePage().selectVersion("2.3.3");

        Thread.sleep(1000);

        CollectorChartsResultPage graph = version.getPageFactory().getHomePage().drawCharts(1);

        Thread.sleep(2000);

        String checkedversionText = graph.getPageFactory().getHomePage().checkChartsSubtitle();

        assertEquals("2.3.3 이슈 조치율", checkedversionText);
    }

    @Test
    public void checkDateInTable() throws InterruptedException {

        getPageFactory().getHomePage("/chartdrawer");

        Thread.sleep(5000);

        CollectorChartsResultPage project = getPageFactory().getHomePage().selectProject("GO");

        Thread.sleep(1000);

        CollectorChartsResultPage version = project.getPageFactory().getHomePage().selectVersion("2.3.3");

        Thread.sleep(1000);

        CollectorChartsResultPage graph = version.getPageFactory().getHomePage().drawCharts(1);

        Thread.sleep(2000);

        String checkDate = graph.getPageFactory().getHomePage().checkDateInTable("allData");

        Thread.sleep(2000);

        String checkDateInGraph = graph.getPageFactory().getHomePage().checkFirstDateInGraph();

        assertEquals(checkDateInGraph,checkDate);

    }

    @Test
    public void checkToExistsDate() throws InterruptedException {

        getPageFactory().getHomePage("/chartdrawer");

        Thread.sleep(5000);

        CollectorChartsResultPage project = getPageFactory().getHomePage().selectProject("TMSE");

        Thread.sleep(1000);

        CollectorChartsResultPage version = project.getPageFactory().getHomePage().selectVersion("1.0.2");

        Thread.sleep(1000);

        CollectorChartsResultPage graph = version.getPageFactory().getHomePage().drawCharts(1);

        Thread.sleep(5000);

        String currentUrl = graph.getPageFactory().getHomePage().checkToCurrentUrl();

        assertEquals("http://localhost:8080/admin/projectdate", currentUrl);

    }

    @Test
    public void addProject() throws InterruptedException {

        getPageFactory().getHomePage("/chartdrawer");

        CollectorDashboardResultPage dashboardPage = getPageFactory().getHomePage().goAdministratorPage();

        Thread.sleep(2000);

        CollectorProjectListResultPage projectListPage = dashboardPage.getPageFactory().getHomePage().goProjectListPage();

        Thread.sleep(2000);

        CollectorProjectAdditionResultPage projectAdditionPage = projectListPage.getPageFactory().getHomePage().goAddProject();

        Thread.sleep(2000);

        ArrayList<String> checkValue = projectAdditionPage.getPageFactory().getHomePage().writeAddProject("testProject","testKey","윤병식");

        assertEquals("testProject",checkValue.get(0));
        assertEquals("testKey",checkValue.get(1));
        assertEquals("윤병식",checkValue.get(2));
    }

    @Test
    public void deleteProject() throws InterruptedException {

        getPageFactory().getHomePage("/chartdrawer");

        Thread.sleep(2000);

        CollectorDashboardResultPage dashboardPage = getPageFactory().getHomePage().goAdministratorPage();

        Thread.sleep(2000);

        CollectorProjectListResultPage projectListPage = dashboardPage.getPageFactory().getHomePage().goProjectListPage();

        Thread.sleep(2000);

        int checkToDeleteProject = projectListPage.getPageFactory().getHomePage().deleteProject();

        Thread.sleep(5000);

        assertEquals(2,checkToDeleteProject);

    }

}
