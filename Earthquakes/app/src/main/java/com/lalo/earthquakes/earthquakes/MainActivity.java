package com.lalo.earthquakes.earthquakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.lalo.earthquakes.Earthquake;
import com.lalo.earthquakes.databinding.ActivityMainBinding;
import com.lalo.earthquakes.details.DetailActivity;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding.eqRecycler.setLayoutManager(new LinearLayoutManager(this));
        EqAdapter adapter = new EqAdapter();
        adapter.setOnItemClickListener(earthquake -> {
            Toast.makeText(MainActivity.this, earthquake.getPlace(),
                    Toast.LENGTH_SHORT).show();
            binding.eqRecycler.setAdapter(adapter);

            viewModel.getEqList().observe(this, eqList -> {
                adapter.submitList(eqList);
            });
        });
    }

    private void openDetailActivity(Earthquake earthquake){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("MAGNITUDE", earthquake.getMagnitude());
        intent.putExtra("PLACE", earthquake.getPlace());
        intent.putExtra("ID", earthquake.getId());
        startActivity(intent);
    }
}