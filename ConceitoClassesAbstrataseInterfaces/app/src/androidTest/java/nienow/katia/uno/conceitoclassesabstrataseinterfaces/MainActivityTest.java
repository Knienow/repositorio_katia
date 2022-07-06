package nienow.katia.uno.conceitoclassesabstrataseinterfaces;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Test
    public void deveriaEstarVisivelMainActivity(){
        ActivityScenario<MainActivity> activityScenario = ActivityScenario.launch(MainActivity.class);

        onView(withId(R.id.main_activity)).check(matches(isDisplayed()));
    }
}