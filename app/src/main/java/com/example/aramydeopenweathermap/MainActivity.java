package com.example.aramydeopenweathermap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.widget.TextView;

import com.example.aramydeopenweathermap.constant.Languages;
import com.example.aramydeopenweathermap.constant.Units;
import com.example.aramydeopenweathermap.fragments.AlgorithmFragment;
import com.example.aramydeopenweathermap.fragments.HomeFragment;
import com.example.aramydeopenweathermap.fragments.ShareFragment;
import com.example.aramydeopenweathermap.implementation.OpenWeatherMapHelper;
import com.example.aramydeopenweathermap.implementation.callback.CurrentWeatherCallback;
import com.example.aramydeopenweathermap.model.currentweather.CurrentWeather;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    TextView give_report;
    String report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AlgorithmFragment()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.




        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.algorithm) {
            selectedFragment = new AlgorithmFragment();
        } else if (itemId == R.id.course) {
            selectedFragment = new HomeFragment();
        } else if (itemId == R.id.profile) {
            selectedFragment = new ShareFragment();
        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    };
}

