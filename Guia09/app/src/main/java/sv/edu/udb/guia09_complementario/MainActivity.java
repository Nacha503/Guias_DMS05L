package sv.edu.udb.guia09_complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import interfaces.RepositorioAPI;
import models.Repositorio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText buscartxt;
    private TextView textView;
    private Button btnbuscar;
    private TextView txt_repos_encontrados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscartxt = findViewById(R.id.BuscarTxt);
        textView = findViewById(R.id.listaView);
        btnbuscar = findViewById(R.id.button);
        txt_repos_encontrados = findViewById(R.id.txt_repos_encontrados);
        txt_repos_encontrados.setVisibility(View.INVISIBLE);

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               buscarUsuario(buscartxt.getText().toString());

            }
        });
    }

    public void buscarUsuario(String username) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RepositorioAPI repo = retrofit.create(RepositorioAPI.class);
        Call<List<Repositorio>> call = repo.getRepositorios(username);

        call.enqueue(new Callback<List<Repositorio>>() {
            @Override
            public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Repositorio> respositorios = response.body();
                        txt_repos_encontrados.setVisibility(View.VISIBLE);

                        String result="";
                        for(int i=0;i<respositorios.size();i++)
                        {


                            result = result + "\n  " + (i+1) + " - [Nombre]: "+respositorios.get(i).getName();
                            result = result + "\n       [Link]:" + respositorios.get(i).getUrl() + "\n ";

                        }
                        textView.setBackgroundResource(R.color.teal_200);
                        textView.setText(result);

                    }

                } catch (Exception exception) {
                    Toast.makeText(MainActivity.this, exception.toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Repositorio>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();

            }
        });


    }
}