package mx.edu.ittepic.calculadoraseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView Numero;
    SeekBar barra;
    ListView listaResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Numero=findViewById(R.id.texto);
        barra=findViewById(R.id.barra);
        listaResult=findViewById(R.id.listaresultado);
        barra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Numero.setText(""+barra.getProgress());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String cadena="";
                String result12="";
                cadena=Numero.getText().toString();
                int num=Integer.parseInt(cadena);
                for (int i=0;i<=20;i++){
                    int result=i*num;
                    result12 += num+ " x " + i + " = " + String.valueOf(result) + '\n';



                    String[] values = new String[]{"Resultado: \n"+result12};
                    ArrayAdapter<String> adapter = new ArrayAdapter <String> (getApplicationContext(),android.R.layout.simple_list_item_1, android.R.id.text1, values);
                    listaResult.setAdapter(adapter);

                }

            }
        });
    }
}

