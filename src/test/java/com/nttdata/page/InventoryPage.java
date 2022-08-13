package com.nttdata.page;

import org.openqa.selenium.By;

public class InventoryPage {

    public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.xpath("/html/body/div[4]/main/div[1]/div[10]/div[2]/div[1]");

    public static By userName = By.id("header-profile-user-name");

    public static By mensaje = By.cssSelector("added-product  highlight");
}
