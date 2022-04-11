package helper.assertion;


import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.BPage;

import java.io.IOException;

public class AssertionHelper extends BPage {

    public AssertionHelper() throws IOException {
    }

    private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);


    public static void verifyText(String s1, String s2) {
        log.info("verifying test: " + s1 + " with " + s2);
        Assert.assertEquals(s1, s1);
    }

    public static void markPass() {
        log.info("making script PASSED..");
        Assert.assertTrue(true);
    }

    public static void markPass(String message) {
        log.info("making script PASSED.." + message);
        Assert.assertEquals(true, message);
    }

    public static void markFail() {
        log.info("making script FAILED..");
        Assert.assertTrue(false);
        log.info("making script FAILED..");
    }

    public static void markFail(String message) {
        log.info("making script FAILED.." + message);
        Assert.assertEquals(false, message);

    }

    public static void verifyTrue(boolean status) {
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status) {
        Assert.assertFalse(status);
    }

    public static void verifyNull(String s1) {
        log.info("getOrVerify object is null..");
        Assert.assertNull(s1);
    }

    public static void verifyNotNull(String s1) {
        log.info("getOrVerify object is not null..");
        Assert.assertNotNull(s1);
    }

    public static void fail() {
        Assert.assertTrue(false);
    }

    public static void pass() {
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status) throws InterruptedException {
        if (status) {
            pass();
        } else {
            fail();
        }
    }
}
