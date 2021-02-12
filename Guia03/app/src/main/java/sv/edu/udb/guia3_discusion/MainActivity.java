package sv.edu.udb.guia3_discusion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnIncrement;
    TextView txtView;
    MyViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIncrement = (Button) findViewById(R.id.btnIncrement);
        txtView = (TextView) findViewById(R.id.textView);


        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementar();
                if(model.getNumero().getValue() >= 10)
                    reset();

            }
        });

        model = new ViewModelProvider(this).get(MyViewModel.class);
        model.getNumero().observe(this, new Observer<Integer>() {
           @Override
           public void onChanged(Integer integer) {
               txtView.setText(String.valueOf(integer));
           }
       });

    }


    public void incrementar(){
        model.Incrementar();

    }

    public void reset(){
        model.Reset();
    }


}