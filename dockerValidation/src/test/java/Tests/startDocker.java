package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class startDocker {

    @Test
    public void startFile() throws IOException, InterruptedException {
       boolean flag = false;
       Runtime runtime = Runtime.getRuntime();
       runtime.exec("cmd /c start dockerUp.bat");
       String file = "output.txt";
        // Tell Java output.txt is a file and not a string

        // Using calender class to add 30 seconds to give time for file reader to get text
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,360);
        long stopnow = calendar.getTimeInMillis();
        Thread.sleep(3000);

        // Checking system time to stopnow time
        while (System.currentTimeMillis() < stopnow) {

            if (flag){
                break;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            // Read the current line inside the text document
            String currentLine = reader.readLine();
            // Loop each line looking for Registering the node to the hub

            while (currentLine != null && !flag) {
                if (currentLine.contains("Added node")) {
                    System.out.println("Found my Text");
                    flag = true; // 14th seconds
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();
        }
            Assert.assertTrue(flag);
        // create 5 chrome browsers
        runtime.exec("cmd /c start scale.bat");
            Thread.sleep(5000);
        }
    }



