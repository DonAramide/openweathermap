package com.example.aramydeopenweathermap.fragments;

import static com.example.aramydeopenweathermap.MainActivity.TAG;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aramydeopenweathermap.R;
import com.example.aramydeopenweathermap.constant.Languages;
import com.example.aramydeopenweathermap.constant.Units;
import com.example.aramydeopenweathermap.implementation.OpenWeatherMapHelper;
import com.example.aramydeopenweathermap.implementation.callback.CurrentWeatherCallback;
import com.example.aramydeopenweathermap.model.currentweather.CurrentWeather;

import java.awt.font.TextAttribute;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AlgorithmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlgorithmFragment extends Fragment {
    private View view;

    TextView country,date,degree,uv,wind,humi,day,ther;
    String report;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AlgorithmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AlgorithmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AlgorithmFragment newInstance(String param1, String param2) {
        AlgorithmFragment fragment = new AlgorithmFragment();
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

        view = inflater.inflate(R.layout.fragment_algorithm, container, false);
iniView();
        return view ;
    }

    private void iniView() {

        country = (TextView) view.findViewById(R.id.country);
        date = (TextView) view.findViewById(R.id.date);
        degree = (TextView) view.findViewById(R.id.degree);
        ther = (TextView) view.findViewById(R.id.ther);
        humi = (TextView) view.findViewById(R.id.humi);
        uv = (TextView) view.findViewById(R.id.uv);
        wind = (TextView) view.findViewById(R.id.wind);
        day = (TextView) view.findViewById(R.id.day);
        setHome();


    }


    public void setHome(){

        //  give_report = findViewById(R.id.give_report);
        OpenWeatherMapHelper helper = new OpenWeatherMapHelper(getString(R.string.OPEN_WEATHER_MAP_API_KEY));
        helper.setUnits(Units.IMPERIAL);
        helper.setLanguage(Languages.ENGLISH);

        helper.getCurrentWeatherByCityName("NIGERIA", new CurrentWeatherCallback() {
            @Override
            public void onSuccess(CurrentWeather currentWeather) {
                report = "Coordinates: " + currentWeather.getCoord().getLat() + ", "+currentWeather.getCoord().getLon() +"\n"
                        +"Weather Description: " + currentWeather.getWeather().get(0).getDescription() + "\n"
                        +"Temperature: " + currentWeather.getMain().getTempMax()+"\n"
                        +"Wind Speed: " + currentWeather.getWind().getSpeed() + "\n"
                        +"City, Country: " + currentWeather.getName() + ", " + currentWeather.getSys().getCountry();
                Log.v(TAG,
                        report +""+currentWeather.toString()
                );

                country.setText(currentWeather.getName());
                date.setText(currentWeather.getTimezone()+"");
                degree.setText(currentWeather.getMain().getTempMax()+ " \u2103");
                wind.setText(currentWeather.getSys().getCountry());
                day.setText(currentWeather.getWeather().get(0).getDescription());
                country.setText(currentWeather.getSys().getCountry());
                country.setText(currentWeather.getSys().getCountry());
                //   give_report.setText(report);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.v(TAG, throwable.getMessage());
            }
        });

    }


}