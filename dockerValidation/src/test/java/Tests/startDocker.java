package Tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class startDocker {

    @Test
    public void startFile() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerUp.bat");
    }




}
