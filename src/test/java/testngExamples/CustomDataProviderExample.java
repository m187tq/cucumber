package testngExamples;

import org.testng.annotations.DataProvider;

// Driving data from another Class
public class CustomDataProviderExample {

    @DataProvider(name="LoginDataProvider")
    public Object[][] getData(){

        Object[][] data = {{"abc@gmail@com","abc"},{"xyz@gmail.com","xyz"},{"mno@gmail.com","mno"}};
        return data;
    }
}

