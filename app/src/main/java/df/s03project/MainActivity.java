package df.s03project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //private static final String bgColor_list="bgColor_list";
    public String lvBgColor;
    public String tvBgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lvStudents = (ListView) findViewById(R.id.lvStudents);
        //TextView tvTitle    = (TextView) findViewById(R.id.tvTitle);
        String[] students = getResources().getStringArray(R.array.saStudents);
        ArrayAdapter<String> lvAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                students);

        lvStudents.setAdapter(lvAdapter);

        lvStudents.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "LongClick "+adapterView.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        ListView lvStudents = (ListView) findViewById(R.id.lvStudents);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        lvBgColor = settings.getString("bgColor_list", "9");

        switch (lvBgColor) {
            case "0":
                lvStudents.setBackgroundColor(Color.BLACK);
                break;
            case "1":
                lvStudents.setBackgroundColor(Color.WHITE);
                break;
            case "2":
                lvStudents.setBackgroundColor(Color.DKGRAY);
                break;
            default:
                lvStudents.setBackgroundColor(Color.BLACK);
        }

        tvBgColor = settings.getString("textview_bg_color", "9");
        switch (tvBgColor) {
            case "0":
                tvTitle.setBackgroundColor(Color.BLACK);
                break;
            case "1":
                tvTitle.setBackgroundColor(Color.WHITE);
                break;
            case "2":
                tvTitle.setBackgroundColor(Color.DKGRAY);
                break;
            default:
                tvTitle.setBackgroundColor(Color.BLACK);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.Settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return true;
    }
}
