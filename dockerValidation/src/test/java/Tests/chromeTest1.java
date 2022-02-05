package Tests;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class chromeTest1 {

    // Before test we will operate Docker start file in start docker class
    @BeforeTest
    public void startDockerScale() throws IOException, InterruptedException {
        startDocker s = new startDocker();
        s.startFile();
    }

    // After test we will operate docker stop file in start docker class
    @AfterTest
    public void stopDockerDeleteFile() throws IOException, InterruptedException {
        stopDocker stop = new stopDocker();
        stop.stopFile();
    }




    @Test
    public static void test1() throws MalformedURLException {

        /*
        SELENIUM DOCKER HUB INTEGRATION
         */

        //Desired Capabilites class called to create Object
        DesiredCapabilities cap = new DesiredCapabilities();
        // set capabilities with cap variable from desired capabilities class to use chrome
        cap.setCapability("browserName","chrome");
        // using Url class to create new url object to then use with localhost and mapping with port number
        // in docker to send to Remote WebDriver
        URL u = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(u,cap);
        // Selenium get method to go to url inside docker
        driver.get("http://google.com");
        String title = driver.getTitle();
        // Print out Title
        System.out.println(title);
        System.out.println("Docker Test Ended");
    }


}
