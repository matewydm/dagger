package pl.darenie.mobiletech;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public CounterService counterService;
    @Inject
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApp.app().getMyComponent().inject(this);
        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.counter);
        text.setText(counterService.getCount().toString());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void add(View view) {
        TextView text = findViewById(R.id.counter);
        if (sharedPreferences.getLong("max", 0L) <= counterService.getCount()) {
            text.setText(counterService.getCount().toString() + " LIMIT ");
        } else {
            counterService.add();
            text.setText(counterService.getCount().toString());
        }
    }

    public void subtract(View view) {
        TextView text = findViewById(R.id.counter);
        if (sharedPreferences.getLong("min", 0L) >= counterService.getCount()) {
            text.setText(counterService.getCount().toString() + " LIMIT ");
        } else {
            counterService.subtract();
            text.setText(counterService.getCount().toString());
        }
    }
}
