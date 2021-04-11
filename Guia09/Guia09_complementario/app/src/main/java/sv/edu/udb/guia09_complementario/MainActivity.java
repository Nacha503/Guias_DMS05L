package sv.edu.udb.guia09_complementario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView TxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscartxt=findViewById(R.id.BuscarTxt);
        TxtView=findViewById(R.id.listaView);
    }

    public void buscar(View view)
    {
        findUser(buscartxt.getText().toString());
    }

    public void findUser(String username)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RepositorioAPI repo=retrofit.create(RepositorioAPI.class);
        Call<List<Repositorio>> call=repo.find(username);

        call.enqueue(new Callback<List<Repositorio>>() {
            @Override
            public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                try {
                    if(response.isSuccessful())
                    {
                        //    response.body().getResults().get(0).getSlug();

                        List<Repositorio> p=response.body();

                       // System.out.println(p.toString());

                        Toast.makeText(MainActivity.this,"Busqueda exitosa",Toast.LENGTH_SHORT).show();
                       // Toast.makeText(MainActivity.this,p.toString(),Toast.LENGTH_LONG).show();
                        String result="";
                        for(int i=0;i<p.size();i++)
                        {

                           // result=result+"\n "+(i+1)+"-Nombre: "+p.get(i).getName()+" URL:"+p.get(i).getUrl()+"\n ";
                            result = result + "\n  " + (i+1) + " - [Nombre]: "+p.get(i).getName();
                            result = result + "\n       [Link]:" + p.get(i).getUrl() + "\n ";

                        }
                        TxtView.setText(result);
                    }

                }catch(Exception exception)
                {
                    Toast.makeText(MainActivity.this,exception.toString(),Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Repositorio>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Ocurrio un error",Toast.LENGTH_SHORT).show();

            }
        });
    }
}