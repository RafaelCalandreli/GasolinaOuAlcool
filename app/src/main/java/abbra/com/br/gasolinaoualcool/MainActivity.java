package abbra.com.br.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button botaoVerificar;
    private EditText precoAlcool;
    private EditText precoGasolina;
    private TextView TextoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoVerificar =(Button) findViewById(R.id.VerificarID);
        precoAlcool = (EditText) findViewById(R.id.caixaTextoAlcoolId);
        precoGasolina = (EditText) findViewById(R.id.caixaTextoGasolinaId);
        TextoResultado = (TextView) findViewById(R.id.resultadoId);

        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recuperar valores

                String textoPrecoAlcool = precoAlcool.getText().toString();
                String textoPrecoGasolina = precoGasolina.getText().toString();

                //Verificar se os mesmo não estão nulos
                if(textoPrecoAlcool.isEmpty() || textoPrecoGasolina.isEmpty()){
                    TextoResultado.setText("Um dos valores está faltando");
                }  else{

                //Converter valores
                    double valorAlcool  = Double.parseDouble(textoPrecoAlcool);
                    double valorGasolina= Double.parseDouble(textoPrecoGasolina);
                double resultado;
                double calculo = 0.7;

                    resultado = valorAlcool / valorGasolina;

                    if(resultado >= calculo){
                        //Gasolina
                        TextoResultado.setText("É mais vantajoso abastecer com a Gasolina");
                    } else {
                        //Alcool
                        TextoResultado.setText("É mais vantajoso abastecer com o Álcool");
                    }

                }
            }


        });


    }
}
