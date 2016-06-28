package test.jiracollector.practice;

import com.github.jsdevel.testng.selenium.PageFactory;
import test.jiracollector.practice.result.*;

/**
 * Created by daou on 2016-04-19.
 */
public interface CollectorPageFactory extends PageFactory {
    CollectorHomePage getHomePage();
    CollectorHomePage getHomePage(String path);

    CollectorChartsResultPage getCollectorChartsResultPage();
    CollectorChartsResultPage getCollectorChartsResultPage(String path);

    CollectorProjectDateResultPage getCollectorProjectDateResultPage();
    CollectorProjectDateResultPage getCollectorProjectDateResultPage(String path);

    CollectorProjectListResultPage getCollectorProjectListResultPage();
    CollectorProjectListResultPage getCollectorProjectListResultPage(String path);

    CollectorDashboardResultPage getCollectorDashboardResultPage();
    CollectorDashboardResultPage getCollectorDashboardResultPage(String path);

    CollectorReleaseVersionListResultPage getCollectorReleaseVersionListResultPage();
    CollectorReleaseVersionListResultPage getCollectorReleaseVersionListResultPage(String path);

    CollectorProjectAdditionResultPage getCollectorProjectAdditionResultPage();
    CollectorProjectAdditionResultPage getCollectorProjectAdditionResultPage(String path);

}
