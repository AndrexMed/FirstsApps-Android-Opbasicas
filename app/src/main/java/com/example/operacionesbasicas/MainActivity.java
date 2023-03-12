package com.example.operacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText campo1,campo2;
    TextView resultSuma,resultResta,resultMulti,resultDivi;

    DecimalFormat formato = new DecimalFormat("#.##"); // Para modificar la cantidad de decimales...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campo1 =  findViewById(R.id.numero1);
        campo2 =  findViewById(R.id.numero2);
        resultSuma = findViewById(R.id.resultadoSuma);
        resultResta = findViewById(R.id.resultadoResta);
        resultMulti = findViewById(R.id.resultadoMulti);
        resultDivi = findViewById(R.id.resultadoDivision);

    }

    public void Calcular(View view){

        String numero1,numero2;

        numero1 = campo1.getText().toString();
        numero2 = campo2.getText().toString();

        if (numero1.isEmpty() || numero2.isEmpty()){
            Toast.makeText(this, "Error - Complete TODOS los campos!", Toast.LENGTH_SHORT).show();
            campo1.requestFocus();
        }else{
            float num1,num2,suma,resta,multi,divi;

            //Convertir los datos de entrada a numericos.
            num1 = Float.parseFloat(numero1);
            num2 = Float.parseFloat(numero2);

            suma = num1 + num2;
            resta = num1 - num2;
            multi = num1 * num2;

            //Imprimir resultados
            resultSuma.setText(String.valueOf(suma));
            resultResta.setText(String.valueOf(resta));
            resultMulti.setText(String.valueOf(multi));

            if (num2 == 0){
                Toast.makeText(this, "No se puede dividir entre 0!", Toast.LENGTH_SHORT).show();
            }else{
                divi = num1/num2;
                resultDivi.setText(formato.format(divi));
            }
        }
    }// Fin del metodo calcular....

    public void Limpiar(View view){
        campo1.setText("");
        campo2.setText("");
        resultSuma.setText("0");
        resultResta.setText("0");
        resultMulti.setText("0");
        resultDivi.setText("0");
        campo1.requestFocus();
    }
}