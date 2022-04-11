package helper.browserConfiguration.config;



import helper.browserConfiguration.BrowserType;
import helper.resource.ResourceHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class PropertyReader implements ConfigReader {

    public static Properties OR;
    private static FileInputStream file;

    public PropertyReader() {
        try {
            String filePath = ResourceHelper.getResourcePath("src/main/java/com/resources/configfile/config.properties");
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);

            String filePath1 = ResourceHelper.getResourcePath("src/main/java/com/resources/configfile/config1.properties");
            file = new FileInputStream(new File(filePath1));
            OR = new Properties();
            OR.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getImplicitWait() {
        return Integer.parseInt(OR.getProperty("implicitwait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(OR.getProperty("explicitwait"));
    }

    public int getPageLoadTime() {
        return Integer.parseInt(OR.getProperty("pageloadtime"));
    }

    public BrowserType getBrowserType() {
        return BrowserType.valueOf(OR.getProperty("browserType"));
    }

    public String getUrl() {
        if (System.getProperty("url") != null) {
            return System.getProperty("url");
        }
        return OR.getProperty("applicationUrl");
    }

    @Override
    public String getEmailAddress() {
        if (System.getProperty("EmailAddress") != null) {
            return System.getProperty("EmailAddress");
        }
        return OR.getProperty("EmailAddress");
    }

    public String getUserName() {
        if (System.getProperty("EmailAddress") != null) {
            return System.getProperty("EmailAddress");
        }
        return OR.getProperty("EmailAddress");
    }

    public String getPassword() {
        if (System.getProperty("Password") != null) {
            return System.getProperty("Password");
        }
        return OR.getProperty("Password");
    }

}
