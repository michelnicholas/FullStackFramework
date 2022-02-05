import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class extractJson {
    public static void main(String[] args) throws IOException {
        // Json will be the response of API

        ObjectMapper oj = new ObjectMapper();
       // Using Object Mapper class and object and using readValue instead to extract json
        CustomerDetailsAppium c = oj.readValue(new File("C:\\Users\\Miche\\IdeaProjects\\FullStackAutomationProject\\JsonJava\\customerInfo0.json"),
                CustomerDetailsAppium.class);

        System.out.println(c.getCourseName());
        c.getStudentName();

        // Validate record in Web Table are correct or not
        // getText() Appium

    }


}
