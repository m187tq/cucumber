package utilities;

public class data {

    public final static String CONFIG_PROPERTIES_DIRECTORY = "properties\\config.properties";

    public final static String GECKO_DRIVER_DIRECTORY = System.getProperty("user.dir") + "\\src\\main\\java\\com\\resources\\geckodriver.exe";
    public final static String CHROME_DRIVER_DIRECTORY = System.getProperty("user.dir") + "\\src\\test\\java\\com\\resources\\chromedriver,exe";
    public final static String HalfCHROME_DRIVER_DIRECTORY = System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

    public final static String BaseUrl = "https://cornerstone-light-demo.mybigcommerce.com/";

    public static final String BASE_URL = "https://cornerstone-light-demo.mybigcommerce.com/";

    public static final String baseUrl = "https://cornerstone-light-demo.mybigcommerce.com/";

    public static final String baseTitle = "Cornerstone Demo";
    public static final String USER_DIRECTORY = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String DRIVERS_DIRECTORY = "//drivers//";
    public static final String LOCAL_DRIVERS_CHROME_DIRECTORY = "C:\\drivers\\chromedriver.exe";
    public static final String LOCAL_DRIVERS_FIREFOX_DIRECTORY = "C:\\drivers\\geckodriver.exe";
    public static final String LOCAL_DRIVERS_IE_DIRECTORY = "C:\\drivers\\IEDriverServer.exe";
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String IE = "ie";
    public static final String GECKO_DRIVER_KEY = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_KEY = "webdriver.chrome.driver";
    public static final String IE_DRIVER_KEY = "webdriver.ie.driver";
    public static final String GECKO_DRIVER_VALUE = "geckodriver";
    public static final String CHROME_DRIVER_VALUE = "chromedriver";
    public static final String IE_DRIVER_VALUE = "IEDriverServer";
    public static final String LOGINNAME = "datastudioplace";
    public static final String PASSWORD = "Manchester1";

    public static final String FIRSTNAME = "FirstName";
    public static final String LASTNAME = "lastName";
    public static final String EMAIL = "datastudioplace@gmail.com";
    public static final String TELEPHONE = "2022034001";
    public static final String FAX = "2022034005";

    public static final int FIVE_SECONDS = 5;
    public static final int FOUR_SECONDS = 4;
    public static final int THREE_SECONDS = 3;
    public static final int TWO_SECONDS = 2;
    public static final int SIX_SECONDS = 6;
    public static final int SEVEN_SECONDS = 7;
    public static final int EIGHT_SECONDS = 8;
    public static final int TEN_SECONDS = 10;
    public static final int FIFTEEN_SECONDS = 15;
    public static final int THIRTY_SECONDS = 30;
    public static final int SIXTY_SECONDS = 60;
    public static final int HUNDREDANDTWENTY_SECONDS = 120;
    public static final int TEN = 10;
    public static final String firstName = "yourFirstName";
    public static final String lastName = "yourLastName";
    public static final String EmailAddress = "yourEmail@yourEmail.com";
    public static final String phoneNum = "2122332000";
    public static final String faxNumber = "2122332444";
    public static final String fax = "2122332445";
    public static final String companyName = "yourCompanyName";
    public static final String addressLine1 = "address Line 1";
    public static final String addressLine2 = "address Line 2";
    public static final String suburbOrCityName = "Manchester";
    public static final String StateOrProvince = "Lancashire";
    public static final String postCode = "M1 7TG";
    public static final String country = "United Kingdom";
    public static final String password = "yourPassword01";
    public static final String confirmPassword = "yourPassword01";
    public static final String expectedURL = "https://cornerstone-light-demo.mybigcommerce.com/";
    public static final String expectedTitle = "Cornerstone Demo";


    public static final String expCreateAccPageURL = "https://cornerstone-light-demo.mybigcommerce.com/login.php?action=create_account";
    public static final String expCreateAccPageTitle = "Cornerstone Demo - Create Account";


    public static String getExpLoginPageURL() {
        return expLoginPageURL;
    }

    public static String getExpLoginPageTitle() {
        return expLoginPageTitle;
    }

    public static final String expLoginPageURL = "https://cornerstone-light-demo.mybigcommerce.com/login.php";
    public static final String expLoginPageTitle = "Cornerstone Demo - Sign in";


    public static int getFiveSeconds() {
        return FIVE_SECONDS;
    }

    public static int getFourSeconds() {
        return FOUR_SECONDS;
    }

    public static int getThreeSeconds() {
        return THREE_SECONDS;
    }

    public static int getTwoSeconds() {
        return TWO_SECONDS;
    }

    public static int getSixSeconds() {
        return SIX_SECONDS;
    }

    public static int getSevenSeconds() {
        return SEVEN_SECONDS;
    }

    public static int getEightSeconds() {
        return EIGHT_SECONDS;
    }

    public static int getTenSeconds() {
        return TEN_SECONDS;
    }

    public static int getFifteenSeconds() {
        return FIFTEEN_SECONDS;
    }

    public static int getThirtySeconds() {
        return THIRTY_SECONDS;
    }

    public static int getSixtySeconds() {
        return SIXTY_SECONDS;
    }

    public static int getHundredandtwentySeconds() {
        return HUNDREDANDTWENTY_SECONDS;
    }

    public static int getTEN() {
        return TEN;
    }


}
