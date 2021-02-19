package sv.edu.udb.guia04complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class segundaActividad extends AppCompatActivity {

    private TextView tv_ISSS;
    private TextView tv_Nombre;
    private TextView tv_NETO;
    private TextView tv_RENTA;
    private TextView tvAFP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        tv_ISSS=(TextView)findViewById(R.id.textViewISSS);
        tv_Nombre=(TextView)findViewById(R.id.textViewNOMBRE);
        tv_RENTA=(TextView)findViewById(R.id.textViewRENTA);
        tv_NETO=(TextView)findViewById(R.id.textViewNETO);
        tvAFP=(TextView)findViewById(R.id.textViewAFP);
        Bundle bundle = getIntent().getExtras();
        String nombre=bundle.getString("txtNombre");
        String isss=bundle.getString("txtISSS");
        String afp=bundle.getString("txtAFP");
        String renta=bundle.getString("txtRENTA");
        String neto=bundle.getString("txtNETO");
        tv_Nombre.setText(nombre);
        tv_ISSS.setText(isss);
        tvAFP.setText(afp);
        tv_RENTA.setText(renta);
        tv_NETO.setText(neto);
    }

    public void finalizar(View view) {
        finish();
    }
}