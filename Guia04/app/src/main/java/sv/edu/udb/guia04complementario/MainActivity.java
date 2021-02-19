package sv.edu.udb.guia04complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etHoras;
    private Double afp;
    private Double salarioBase;
    private Double salarioNeto;
    private Double isss;
    private Double renta;
    private Double costoHora=8.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHoras= (EditText) findViewById(R.id.textHoras);
        etNombre= (EditText) findViewById(R.id.textNombre);
    }

    public void segundaActividad(View view) {

        salarioBase = costoHora * Double.parseDouble(etHoras.getText().toString());
        renta = salarioBase * 0.04;
        isss = salarioBase * 0.02;
        afp = salarioBase * 0.03;
        salarioNeto= salarioBase - isss - afp - renta;


        Intent miIntent=new Intent(this, segundaActividad.class);
        miIntent.putExtra("txtNombre", etNombre.getText().toString());
        miIntent.putExtra("txtISSS", String.valueOf(isss));
        miIntent.putExtra("txtAFP", String.valueOf(afp));
        miIntent.putExtra("txtRENTA", String.valueOf(renta));
        miIntent.putExtra("txtNETO", String.valueOf(salarioNeto));
        startActivity(miIntent);

    }
}