package com.github.jsdevel.testng.selenium.samples;

import com.github.jsdevel.testng.selenium.AbstractPage;

import java.net.URL;

/**
 * Created by intern on 2016-04-15.
 */
public class SearchDinosaursImgPage extends AbstractPage <SearchDinosaursImgPage, SamplePageFactory> {

    @Override
    public boolean isPageViewableFrom(URL proposedUrl) {
        return "/search".equals(proposedUrl.getPath());
    }
}
