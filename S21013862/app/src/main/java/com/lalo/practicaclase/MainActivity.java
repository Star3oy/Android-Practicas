package com.lalo.practicaclase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editName = findViewById(R.id.txt_name);
        TextView txtOut = findViewById(R.id.txt_output);
        Button btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(v -> {
            String name = editName.getText().toString();
            if(!name.isEmpty()) {
                txtOut.setText(getString(R.string.Welcome_message, name));
            }else{
                Toast.makeText(this, R.string.message_write_your_name,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}