package nienow.katia.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvOpcao;
    private ImageView imgvOperacao, imgvIgual;
    private EditText edtInserirNumero1, edtInserirNumero2, edtResultado;
    private Spinner spiOpcoes;
    private Button btnCalcular;
    public static final String SOMA = "Soma";
    public static final String SUBTRACAO = "Subtração";
    public static final String MULTIPLICACAO = "Multiplicação";
    public static final String DIVISAO = "Divisão";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOpcao           = findViewById(R.id.tvOpcao);
        imgvOperacao      = findViewById(R.id.imgvOperacao);
        imgvIgual         = findViewById(R.id.imgvIgual);
        edtInserirNumero1 = findViewById(R.id.edtInserirNumero1);
        edtInserirNumero2 = findViewById(R.id.edtInserirNumero2);
        spiOpcoes         = findViewById(R.id.spiOpcoes);
        btnCalcular       = findViewById(R.id.btnCalcular);

        imgvOperacao.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.operacoes_matematicas));
        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter - fazer com que o conteúdo seja exibido na spinner
        AlertDialog.Builder spinner;

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (opcaoSelecionada == SOMA) {
                //System.out.println(edtInserirNumero1 + edtInserirNumero2.getText().toString());
                }
                if (opcaoSelecionada == SUBTRACAO) {
                }
                if (opcaoSelecionada == MULTIPLICACAO) {
                }
                if (opcaoSelecionada == DIVISAO) {
                }

                Toast.makeText(MainActivity.this, "Selecione uma operação matemática válida!", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Insira um número!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(MainActivity.this, adapterView.getItemIdAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
        if(adapterView.getItemIdAtPosition(i).toString().equal)

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {


    }
}