package net.hockeyapp.android.util;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;

import net.hockeyapp.android.Constants;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ConstantsTest extends InstrumentationTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testLoadingConstantsWorks() {
        Constants.loadFromContext(getInstrumentation().getContext());
        assertNotNull(Constants.BASE_URL);
        assertEquals("https://sdk.hockeyapp.net/", Constants.BASE_URL);
        assertNotNull(Constants.SDK_NAME);
        assertEquals("HockeySDK", Constants.SDK_NAME);
        assertNotNull(Constants.FILES_DIRECTORY_NAME);
        assertEquals("HockeyApp", Constants.FILES_DIRECTORY_NAME);
        assertEquals(1, Constants.UPDATE_PERMISSIONS_REQUEST);
        assertEquals("HockeyApp", Constants.FILES_DIRECTORY_NAME);
        assertNotNull(Constants.ANDROID_VERSION);
        assertNotNull(Constants.ANDROID_BUILD);
        assertNotNull(Constants.PHONE_MODEL);
        assertNotNull(Constants.PHONE_MANUFACTURER);
        assertNotNull(Constants.CRASH_IDENTIFIER);
        assertNotNull(Constants.DEVICE_IDENTIFIER);

        //TODO add tests for other constants, too.
    }


}
