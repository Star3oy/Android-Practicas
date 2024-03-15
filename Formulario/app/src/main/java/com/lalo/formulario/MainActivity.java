package com.lalo.formulario;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLimpiar = findViewById(R.id.btnLimpiar);
        Button btnRegistrar = findViewById(R.id.btnRegistrar);
        EditText editNombre = findViewById(R.id.editTextNombre);
        EditText editFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        EditText editNumero = findViewById(R.id.editTextTelefono);
        EditText editCorreo = findViewById(R.id.editTextCorreo);
        EditText editContrasena = findViewById(R.id.editTextContrasena);
        EditText editRepetirContrasena = findViewById(R.id.editTextRepetirContrasena);
        TextView txtErrorNombre = findViewById(R.id.errorNombre);
        TextView txtErrorFechaNacimiento = findViewById(R.id.errorFechaNacimiento);
        TextView txtErrorCorreo = findViewById(R.id.errorCorreo);
        TextView txtErrorContrasena = findViewById(R.id.errorContrasena);
        TextView txtErrorRepetirContrasena = findViewById(R.id.errorRepetirContrasena);

        btnRegistrar.setOnClickListener(v -> {
            txtErrorNombre.setVisibility(View.GONE);
            txtErrorFechaNacimiento.setVisibility(View.GONE);
            txtErrorCorreo.setVisibility(View.GONE);
            txtErrorContrasena.setVisibility(View.GONE);
            txtErrorRepetirContrasena.setVisibility(View.GONE);


            boolean flag = true;
            if(isValid(editNombre.getText().toString())){
                txtErrorNombre.setVisibility(View.VISIBLE);
                flag = false;
            }

            if(isValid(editFechaNacimiento.getText().toString())){
                txtErrorFechaNacimiento.setVisibility(View.VISIBLE);
                flag = false;
            }

            if (!isValidEmail(editCorreo.getText().toString())) {
                txtErrorCorreo.setVisibility(View.VISIBLE);
                flag = false;
            }

            if(isValid(editContrasena.getText().toString())){
                txtErrorContrasena.setVisibility(View.VISIBLE);
                flag = false;
            }

            if(!passwordsMatch(editContrasena.getText().toString(), editRepetirContrasena.getText().toString())){
                txtErrorRepetirContrasena.setVisibility(View.VISIBLE);
                flag = false;
            }

            if (flag){
                Toast.makeText(this, R.string.registro_exitoso,
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnLimpiar.setOnClickListener(v -> {
            editNombre.setText("");
            editFechaNacimiento.setText("");
            editNumero.setText("");
            editCorreo.setText("");
            editContrasena.setText("");
            editRepetirContrasena.setText("");
        });


    }

    private boolean isValid (String name){
        return TextUtils.isEmpty(name);
    }

    private boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean passwordsMatch(String password, String repeatPassword){
        return password.equals(repeatPassword);
    }
}