package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.HelperSeleniumAction;

public class MenuPopUpPage extends BaseClass<LoginPage>{
    private final By MENU_BUTTON =By.cssSelector("div.bm-burger-button button#react-burger-menu-btn");
    private  MenuPopUpPage menuPopUpPage;
    public MenuPopUpPage(WebDriver driver) {
        super(driver);
    }

    public MenuPopUpPage getMenuPopUpPage() {
        return (menuPopUpPage == null) ? menuPopUpPage = new MenuPopUpPage(super.getDriver()) : menuPopUpPage;
    }
    public MenuPopUpPage clickMenuButton() {
        HelperSeleniumAction.click(driver, MENU_BUTTON);
        return getMenuPopUpPage();
    }


}
