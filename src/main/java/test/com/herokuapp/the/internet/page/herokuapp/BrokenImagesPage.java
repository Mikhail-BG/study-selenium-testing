package test.com.herokuapp.the.internet.page.herokuapp;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import test.com.herokuapp.the.internet.constant.url.HerokuappUrl;
import test.com.herokuapp.the.internet.page.AbstractPageObject;

/**
 * Api for BrokenImages page.
 */
public class BrokenImagesPage extends AbstractPageObject
{
    @FindBy(xpath = "//div[@class='example']/img")
    private List<WebElement> images;

    /**
     * Default constructor.
     */
    public BrokenImagesPage(WebDriver webDriver)
    {
        super(webDriver);
        setUrl(HerokuappUrl.BROKENIMAGES);
    }

    @Override
    public void openPage()
    {
        getWebDriver().get(getUrl());
    }

    /**
     * Count all images on the page.
     *
     * @return number of all images.
     */
    public int countAllImages()
    {
        return images.size();
    }

    /**
     * Count broken images on the page.
     *
     * @return number of broken images.
     */
    public int countBrokenImages()
    {
        return findBrokenImages().size();
    }

    private List<WebElement> findBrokenImages()
    {
        return images.stream()
                .filter(image -> image.getAttribute("naturalWidth").equals("0"))
                .collect(Collectors.toList());
    }
}
