package com.example.michael.myapplication;

import android.content.Context;
import android.util.Log;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.michael.myapplication", appContext.getPackageName());
        Log.i("34543", TestBean.temp);
    }
}
