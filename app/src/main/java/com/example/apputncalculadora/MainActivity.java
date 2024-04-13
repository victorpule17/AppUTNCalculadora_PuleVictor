package com.example.apputncalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtNumero1, txtNumero2;
    Button btnSuma, btnResta, btnMultiplicacion, btnDivision;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtNumero1 = findViewById(R.id.txtNumero1);
        txtNumero2 = findViewById(R.id.txtNumero2);
        btnSuma = findViewById(R.id.btnMas);
        btnResta = findViewById(R.id.btnMenos);
        btnDivision = findViewById(R.id.btnDivision);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        lblResultado = findViewById(R.id.lblResultado);
    }
    public void sumaOnClick(View v) {
        String strNumero1 = txtNumero1.getText().toString();
        String strNumero2 = txtNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            double numero1 = Double.parseDouble(strNumero1);
            double numero2 = Double.parseDouble(strNumero2);
            double resultado = numero1 + numero2;
            lblResultado.setText(String.valueOf(resultado));
        } else {
            Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show();
        }
    }
    public void restaOnClick(View v){
        String strNumero1 = txtNumero1.getText().toString();
        String strNumero2 = txtNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            double numero1 = Double.parseDouble(strNumero1);
            double numero2 = Double.parseDouble(strNumero2);
            double resultado = numero1 - numero2;
            lblResultado.setText(String.valueOf(resultado));
        } else {
            Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show();
        }
    }
    public void divisionOnClick(View v){
        String strNumero1 = txtNumero1.getText().toString();
        String strNumero2 = txtNumero2.getText().toString();
        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            float numero1 = Float.parseFloat(strNumero1);
            float numero2 = Float.parseFloat(strNumero2);
            if (numero2 != 0) {
                float resultado = numero1 / numero2;
                lblResultado.setText(String.valueOf(resultado));
            } else {
                lblResultado.setText("∞");
                Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show();
        }
    }
    public void multiplicacionOnClick(View v){
        String strNumero1 = txtNumero1.getText().toString();
        String strNumero2 = txtNumero2.getText().toString();

        if (esNumeroValido(strNumero1) && esNumeroValido(strNumero2)) {
            double numero1 = Double.parseDouble(strNumero1);
            double numero2 = Double.parseDouble(strNumero2);
            double resultado = numero1 * numero2;
            lblResultado.setText(String.valueOf(resultado));
        } else {
            Toast.makeText(this, "Operación no válida", Toast.LENGTH_SHORT).show();
        }
    }
    public void limpiarOnClick(View v){
        txtNumero1.setText("");
        txtNumero2.setText("");
        lblResultado.setText("");
    }
    private boolean esNumeroValido(String numero) {
        try {
            Float.parseFloat(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}