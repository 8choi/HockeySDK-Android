package net.hockeyapp.android;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import junit.framework.Assert;

import net.hockeyapp.android.utils.Util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UtilTest extends InstrumentationTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void encodeParamTest() throws Exception {
        String testParam = "Something something 2015 2.0 ê";
        String expected = "Something+something+2015+2.0+%C3%AA";
        Assert.assertTrue(Util.encodeParam(testParam).equals(expected));
    }

    @Test
    public void validMailTest() throws Exception {
        String validMail = "test@example.com";
        Assert.assertTrue(Util.isValidEmail(validMail));
    }

    @Test
    public void invalidMailTest() throws Exception {
        String invalidMail = "1235 %4 something";
        Assert.assertFalse(Util.isValidEmail(invalidMail));

        invalidMail = "me@example";
        Assert.assertFalse(Util.isValidEmail(invalidMail));

        invalidMail = "mail@example .com";
        Assert.assertFalse(Util.isValidEmail(invalidMail));
    }

    @Test
    public void testValidAppIdentifierGetsConvertedToGuid() {
        String appIdentifier = "ca2aba1482cb9458a67b917930b202c8";
        String expected = "ca2aba14-82cb-9458-a67b-917930b202c8";

        String actual = Util.convertAppIdentifierToGuid(appIdentifier);
        Assert.assertEquals(expected, actual);
    }

}
