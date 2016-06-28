package test.daou.samples;

import com.github.jsdevel.testng.selenium.PageFactory;
import test.daou.samples.result.page.*;

public interface DaouPageFactory extends PageFactory {

  DaouHomePage getHomePage();
  DaouHomePage getHomePage(String path);

  DaouSearchResultsPage getSearchResultsPage();
  DaouSearchResultsPage getSearchResultsPage(String path);

  DaouLoginResultsPage getDaouLoginResultsPage();
  DaouLoginResultsPage getDaouLoginResultsPage(String path);

  DaouGoMailResultPage getMailPage();
  DaouGoMailResultPage getMailPage(String path);

  DaouBoardReulstPage getBoardPage();
  DaouBoardReulstPage getBoardPage(String path);

  DaouBoardWritePage getBoardWritePage();
  DaouBoardWritePage getBoardWritePage(String path);

  DaouReceivedMailResultPage getDaouReceivedMailResultPage();
  DaouReceivedMailResultPage getDaouReceivedMailResultPage(String path);

  // Used to throw an Exception in the test.
  String getFoo();

}
