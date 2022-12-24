package com.example.aramydeopenweathermap.adaoter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.accelerexholdings.anp3.R;
//import com.accelerexholdings.anp3.data.model.SevenDaysForecastWeather;
//import com.accelerexholdings.anp3.databinding.ItemWealtherListBinding;
//import com.accelerexholdings.anp3.utils.FormUtility;
//import com.accelerexholdings.anp3.utils.SharedPrefUtil;

import com.example.aramydeopenweathermap.R;
import com.example.aramydeopenweathermap.databinding.ItemWealtherListBinding;
import com.example.aramydeopenweathermap.model.sevenDayForecast.SevenDaysForecastWeather;

import java.util.List;

public class SevenDaysAdapter extends RecyclerView.Adapter<SevenDaysAdapter.SevenDaysViewHolder> {
    private List<SevenDaysForecastWeather> agentsTransactions;
    private Context context;
    private SevenDaysAdapter.OnItemClickListener listener;





    public SevenDaysAdapter(List<SevenDaysForecastWeather> agentsTransactions, Context context) {
        this.agentsTransactions = agentsTransactions;
        this.context = context;
    }

    @NonNull
    @Override
    public SevenDaysAdapter.SevenDaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                ItemWealtherListBinding binding = ItemWealtherListBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new SevenDaysAdapter.SevenDaysViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SevenDaysAdapter.SevenDaysViewHolder holder, int position) {
        SevenDaysForecastWeather transactionsList = this.agentsTransactions.get(holder.getAdapterPosition());
        holder.bind(transactionsList);
    }

    @Override
    public int getItemCount() {
        return agentsTransactions.size();
    }

    protected class SevenDaysViewHolder extends RecyclerView.ViewHolder {
        private ItemWealtherListBinding binding;

        public SevenDaysViewHolder(@NonNull ItemWealtherListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SevenDaysForecastWeather transactionsList) {
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v, transactionsList, getAdapterPosition());
                }
            });


            binding.day.setText(transactionsList.getTimezoneOffset());
            binding.degree.setText(transactionsList.getDaily().get(getAdapterPosition()).getHumidity());
            binding.narration.setText(transactionsList.getCurrent().getWeather().get(getAdapterPosition()).getDescription());

            switch (transactionsList.getCurrent().getWeather().get(getAdapterPosition()).getMain()) {
                case "Rain":
                    binding.indicator.setBackgroundResource(R.drawable.humidity);
                    break;
                case "Clouds":
                    binding.indicator.setBackgroundResource(R.drawable.rain);
                    break;
                default:
                    binding.indicator.setBackgroundResource(R.drawable.cloudsun);
                    break;
            }

        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, SevenDaysForecastWeather agentsTransactions, int pos);
    }

    public void setOnItemClickListener(SevenDaysAdapter.OnItemClickListener listener){
        this.listener = listener;
    }
}
