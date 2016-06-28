package com.github.jsdevel.testng.selenium.samples;

import com.github.jsdevel.testng.selenium.AbstractPage;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends AbstractPage<GoogleHomePage, SamplePageFactory> {
  @FindBy(css = "[name=q]")
  public WebElement q;

  @FindBy(xpath = "//*[@id=\"hdtb-msb\"]/div[2]/a")
  public WebElement imageButton;

  public GoogleSearchResultsPage submitSearch(String query) {
    q.sendKeys(query);
    q.submit();
    return getPageFactory().getSearchResultsPage();
  }

  public SearchDinosaursImgPage searchImgDinosaurs(){

    imageButton.click();

    return getPageFactory().getSearchImgDinosaurs();
  }

  @Override
  protected boolean isPageViewableFrom(URL proposedUrl) {
    return proposedUrl.getPath().startsWith("/");
  }
}
