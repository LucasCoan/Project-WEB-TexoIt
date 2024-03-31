package page;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class AccessPageTest {

    private WebDriver driver;

    private By accessPhotosbuttonLocator = By.xpath("//a[contains(text(), '/albums/1/photos')]");

    public AccessPageTest(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPhotosMenu() {

        WebElement element = driver.findElement(accessPhotosbuttonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(accessPhotosbuttonLocator).click();
    }

    public <AllJson> List<AllJson> searchingJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<AllJson> json = mapper.readValue(new URL("https://jsonplaceholder.typicode.com/albums/1/photos"), new TypeReference<List<AllJson>>() {
        });

        for (AllJson displayJson : json) {
            System.out.println(displayJson);
        }
        return json;
    }

    public void validatingObjectsInsideTheId6() throws IOException {
        List<HashMap<String, Object>> jsonList = searchingJson();

        for (HashMap<String, Object> json : jsonList) {
            if (json.containsKey("id") && json.get("id").equals(6)) {
                Integer Id = (Integer) json.get("id");
                String title = (String) json.get("title");
                String url = (String) json.get("url");
                String thumbnailUrl = (String) json.get("thumbnailUrl");

                System.out.println("Id: " + Id);
                System.out.println("Title: " + title);
                System.out.println("URL: " + url);
                System.out.println("Thumbnail URL: " + thumbnailUrl);

                if (Id == 6 & ("accusamus ea aliquid et amet sequi nemo".equals(title)
                        & ("https://via.placeholder.com/600/56a8c2".equals(url)
                        & ("https://via.placeholder.com/150/56a8c2".equals(thumbnailUrl))))) {
                    System.out.println("Valid Data!");
                } else {
                    System.out.println("Invalid Data!");
                }
                break;
            }
        }
    }
}


