package df.s03project;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by domin on 13/11/2016.
 */

public class SettingsActivity extends PreferenceActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }
}
