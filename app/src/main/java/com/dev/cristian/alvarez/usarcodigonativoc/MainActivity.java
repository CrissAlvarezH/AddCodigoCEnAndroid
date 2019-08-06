package com.dev.cristian.alvarez.usarcodigonativoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ActividadMain";
    private EditText edtNum1, edtNum2;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = findViewById(R.id.edt_num1);
        edtNum2 = findViewById(R.id.edt_num2);
        txtRes = findViewById(R.id.txt_res_suma);

        edtNum1.addTextChangedListener(new MiTextWatcher());
        edtNum2.addTextChangedListener(new MiTextWatcher());
    }

    private class MiTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            // Validamos que no estén vacios lo campos de texto
            if ( !edtNum1.getText().toString().trim().isEmpty() &&
                    !edtNum2.getText().toString().trim().isEmpty() ) {

                int numero1 = Integer.parseInt(edtNum1.getText().toString());
                int numero2 = Integer.parseInt(edtNum2.getText().toString());

                int resultado = ClaseNativa.sumar(numero1, numero2);

                txtRes.setText(  resultado + "" );
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
