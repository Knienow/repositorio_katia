package nienow.katia.uno.calcular;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
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
    private TextView tvOpcao, tvResultado;
    private ImageView imgvOperacao, imgvIgual;
    private EditText edtInserirNumero1, edtInserirNumero2, edtResultado;
    private Spinner spiOpcoes;
    private Button btnCalcular;
    public static final String SOMA = "Soma";
    public static final String SUBTRACAO = "Subtração";
    public static final String MULTIPLICACAO = "Multiplicação";
    public static final String DIVISAO = "Divisão";
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Calcular");
        }

        tvOpcao = findViewById(R.id.tvOpcao);
        tvResultado = findViewById(R.id.tvResultado);
        imgvOperacao = findViewById(R.id.imgvOperacao);
        imgvIgual = findViewById(R.id.imgvIgual);
        edtInserirNumero1 = findViewById(R.id.edtInserirNumero1);
        edtInserirNumero2 = findViewById(R.id.edtInserirNumero2);
        spiOpcoes = findViewById(R.id.spiOpcoes);
        btnCalcular = findViewById(R.id.btnCalcular);

        imgvOperacao.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.operacoes_matematicas));
        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter - fazer com que o conteúdo seja exibido na spinner
        //AlertDialog.Builder spinner;

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (opcaoSelecionada == SOMA) {
                    //System.out.println(edtInserirNumero1 + edtInserirNumero2.getText().toString());
                } else if (opcaoSelecionada == SUBTRACAO) {

                } else if (opcaoSelecionada == MULTIPLICACAO) {

                } else if (opcaoSelecionada == DIVISAO) {

                } else {

                    Toast.makeText(MainActivity.this, "Selecione uma operação matemática válida!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Insira um número!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(MainActivity.this, adapterView.getItemIdAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
        imgvOperacao.setVisibility(View.VISIBLE);

        if (adapterView.getItemAtPosition(i).toString().equals(DIVISAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_divisao, getTheme()));
        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiplica, getTheme()));
        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma, getTheme()));
        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
        } else {
            Log.d(TAG, "Nenhuma opção foi selecionada");
        }

       /*
        código stack
        this.spiOpcoes = findViewById(R.id.spiOpcoes);
        this.spiOpcoes.setClickable(false);
        this.spiOpcoes.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.v(TAG, "spinner touch");

                //replicating a click
                if(event.getAction() == MotionEvent.ACTION_UP){
                    v.playSoundEffect(android.view.SoundEffectConstants.CLICK);
                }
                return true;
            }
        });*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}