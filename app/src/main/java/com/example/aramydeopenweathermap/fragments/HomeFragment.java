package com.example.aramydeopenweathermap.fragments;

import static com.example.aramydeopenweathermap.MainActivity.TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aramydeopenweathermap.R;
import com.example.aramydeopenweathermap.adaoter.SevenDaysAdapter;
import com.example.aramydeopenweathermap.constant.Languages;
import com.example.aramydeopenweathermap.constant.Units;
import com.example.aramydeopenweathermap.databinding.FragmentHomeBinding;
import com.example.aramydeopenweathermap.implementation.OpenWeatherMapHelper;
import com.example.aramydeopenweathermap.implementation.callback.CurrentWeatherCallback;
import com.example.aramydeopenweathermap.implementation.callback.SevenDaysForecastCallback;
import com.example.aramydeopenweathermap.model.currentweather.CurrentWeather;
import com.example.aramydeopenweathermap.model.sevenDayForecast.SevenDaysForecastWeather;
import com.example.aramydeopenweathermap.model.sevenDayForecast.SevendaysForecast;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
 String report;
    private View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        init();

        return binding.getRoot();
    }

    private void init() {
        setHome();
    }


    public void setHome(){

        //  give_report = findViewById(R.id.give_report);
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));

        //Seting Units
        helper.setUnits(Units.IMPERIAL);

        //Seting Languages
        helper.setLanguage(Languages.ENGLISH);

        helper.getSevenDays( new SevenDaysForecastCallback() {
            @Override
            public void onSuccess(SevendaysForecast currentWeather) {
                report = currentWeather.toString();
                Log.v(TAG,
                        report +""+currentWeather.toString()
                );
                updateSevrnDays(currentWeather.getList());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());
            }
        });

    }

    protected void updateSevrnDays(List<SevenDaysForecastWeather> agentsTransactions) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setHasFixedSize(true);
        SevenDaysAdapter agentTransactionsAdapter = new SevenDaysAdapter(agentsTransactions, getContext());

        binding.recyclerView.setAdapter(agentTransactionsAdapter);
        agentTransactionsAdapter.notifyDataSetChanged();
    }

}