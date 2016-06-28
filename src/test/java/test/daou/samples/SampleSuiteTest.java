package test.daou.samples;

import com.github.jsdevel.testng.selenium.AbstractSuite;
import org.testng.annotations.*;
import test.daou.samples.result.page.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by intern on 2016-04-14.
 */
public class SampleSuiteTest extends AbstractSuite<DaouPageFactory> {

    DaouLoginResultsPage loginPage;

    @BeforeMethod
    public void before() throws InterruptedException {

        loginPage = getPageFactory().getHomePage().login("test0044", "1234");

        Thread.sleep(5000);
    }
/*
    @Test
    public void home_page_okay() {

        getPageFactory().getHomePage();
    }

    @Test
    public void login_search_result() throws InterruptedException {

        DaouLoginResultsPage loginPage = getPageFactory().getHomePage().login("test0044", "1234");

        Thread.sleep(10000);

        DaouSearchResultsPage searchPage = loginPage.getPageFactory().getHomePage().submitSearch("test");

        assertEquals("다음 메뉴에 대해 일치하는 결과가 없습니다.", searchPage.getPageFactory().getHomePage().getResultText());
    }
*/
    @Test
    public void send_mail() throws InterruptedException {

        DaouReceivedMailResultPage mailReceivedPage = loginPage.getPageFactory().getHomePage().daouGoReceivedMail();

        Thread.sleep(2000);

        DaouGoMailResultPage mailPage = mailReceivedPage.getPageFactory().getHomePage().daouGoMail();

        Thread.sleep(2000);

        DaouReceivedMailResultPage resultMail = mailPage.getPageFactory().getHomePage().sendMail("test0045@terracetech.co.kr", "테스트 메일", "테스트 입니다.");

        Thread.sleep(5000);

        DaouLoginResultsPage logInAnotherID = resultMail.getPageFactory().getHomePage().logoutAndlogIn("test0045","1234");

        Thread.sleep(2000);

        DaouReceivedMailResultPage checkMailPage = logInAnotherID.getPageFactory().getHomePage().daouGoReceivedMail();

        Thread.sleep(2000);

        String result = checkMailPage.getPageFactory().getHomePage().getResultText();

        assertEquals("테스트 메일", result);

    }

    @Test
    public void go_boardPage() throws InterruptedException {

        DaouBoardReulstPage boardPage = loginPage.getPageFactory().getHomePage().goBoradPage();

        Thread.sleep(5000);

        DaouBoardWritePage writePage  = boardPage.getPageFactory().getHomePage().getWriteBoardPage();

        Thread.sleep(5000);

        assertTrue(writePage.getPageFactory().getHomePage().writeBoard("test 게시판 글쓰기","test 게시판 글쓰기입니다."));

    }
}
