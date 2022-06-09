package nienow.katia.uno.calcular;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;import androidx.appcompat.app.ActionBar;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static final String SOMA = "Soma";
    public static final String SUBTRACAO = "Subtração";
    public static final String MULTIPLICACAO = "Multiplicação";
    public static final String DIVISAO = "Divisão";
    public int ZERO = 0;
    private TextView tvOpcao, tvResultado;
    private ImageView imgvOperacao, imgvIgual;
    private EditText edtInserirNumero1, edtInserirNumero2, edtResultado;
    private Spinner spiOpcoes;
    private Button btnCalcular;
    private ImageButton imgbVoltar;
    private int empty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Calcular");
        }

        tvOpcao             = findViewById(R.id.tvOpcao);
        tvResultado         = findViewById(R.id.tvResultado);
        imgvOperacao        = findViewById(R.id.imgvOperacao);
        imgvIgual           = findViewById(R.id.imgvIgual);
        edtInserirNumero1   = findViewById(R.id.edtInserirNumero1);
        edtInserirNumero2   = findViewById(R.id.edtInserirNumero2);
        spiOpcoes           = findViewById(R.id.spiOpcoes);
        btnCalcular         = findViewById(R.id.btnCalcular);

        imgvOperacao.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.operacoes_matematicas));
        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter - fazer com que o conteúdo seja exibido na spinner
        //AlertDialog.Builder spinner;

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this); //argumento do método

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (opcaoSelecionada.equals(SOMA)) {
                    if (validarTermosVazios()) {
                        if (validar){
                            tvResultado.setText(somar());
                        } else {
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                } else if (opcaoSelecionada.equals(SUBTRACAO)) {
                    if(validarTermosVazios()){
                        if(validar){
                            tvResultado.setText(subtrair());
                        } else{
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                } else if (opcaoSelecionada.equals(MULTIPLICACAO)) {
                    if(tvResultado.setText(multiplicar());

                } else if (opcaoSelecionada.equals(DIVISAO)) {
                    if (validarTermosVazios()) {
                        if (validarDivisor()) {
                            tvResultado.setText(dividir());
                        } else {
                            Toast.makeText(MainActivity.this, "O divisor não pode ser ZERO!!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                    /*Toast.makeText(MainActivity.this, "Selecione uma operação matemática válida!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Insira um número!", Toast.LENGTH_SHORT).show();*/
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
            edtInserirNumero1.setHint("dividendo");
            edtInserirNumero2.setHint("divisor");
            tvResultado.setHint("quociente");

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiplica, getTheme()));
            edtInserirNumero1.setHint("fator");
            edtInserirNumero2.setHint("fator");
            tvResultado.setHint("produto");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma, getTheme()));
            edtInserirNumero1.setHint("parcela");
            edtInserirNumero2.setHint("parcela");
            tvResultado.setHint("total");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            edtInserirNumero1.setHint("minuendo");
            edtInserirNumero2.setHint("subtraendo");
            tvResultado.setHint("diferença");

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

    private boolean validarOperacoes() {
        int n1 = Integer.valueOf(edtInserirNumero1.getText().toString());
        int n2 = Integer.valueOf(edtInserirNumero2.getText().toString());

        if (n1 != empty) {
            return true;
        } else {
            return false;
        }

        //if (n2 == empty){
        //}
    }

    private String somar() {
        int n1 = Integer.valueOf(edtInserirNumero1.getText().toString());
        int n2 = Integer.valueOf(edtInserirNumero2.getText().toString());
        String resultado = String.valueOf(n1 + n2);
        return "O resultado da soma é: " + resultado;
    }

    private String subtrair() {
        int n1 = parseInt(edtInserirNumero1.getText().toString());
        int n2 = parseInt(edtInserirNumero2.getText().toString());
        int resultado = n1 - n2;
        return "O resultado da subtração é: " + resultado;
    }

    private String multiplicar() {
        int n1 = parseInt(edtInserirNumero1.getText().toString());
        int n2 = parseInt(edtInserirNumero2.getText().toString());
        int resultado = n1 * n2;
        return "O resultado da multiplicação é: " + resultado;
    }

    private String dividir() {
        int n1 = parseInt(edtInserirNumero1.getText().toString());
        int n2 = parseInt(edtInserirNumero2.getText().toString());
        int resultado = n1 / n2;
        return "O resultado da divisão é: " + resultado;
    }

    private boolean validarTermosVazios() {
        if(!edtInserirNumero1.getText().toString().isEmpty()){
            if(!edtInserirNumero1.getText().toString().isEmpty()){
                return true;
            }else{
                edtInserirNumero1.requestFocus();
                return false;
            }

        }else {
            edtInserirNumero2.requestFocus();
            return false;
        }
    }
}

    /*private boolean validarOperacoes(String tipoOperacao) {
        boolean n1 = validarTermoVazio(edtInserirNumero1);
        boolean n2 = validarTermoVazio(edtInserirNumero2);
        if (tipoOperacao.equals(DIVISAO)) {
            if (n1) {
                Toast.makeText(this, "Informe o dividendo", Toast.LENGTH_SHORT).show();
                edtInserirNumero1.requestFocus();
                return false;
            } else if (n2) {
                Toast.makeText(this, "Informe o divisor", Toast.LENGTH_SHORT).show();
                edtInserirNumero2.requestFocus();
                return false;
            }
        } else if (tipoOperacao.equals(MULTIPLICACAO)) {
            if (n1) {
                Toast.makeText(this, "Informe o fator", Toast.LENGTH_SHORT).show();
                edtInserirNumero1.requestFocus();
                return false;
            } else if (n2) {
                Toast.makeText(this, "Informe o fator", Toast.LENGTH_SHORT).show();
                edtInserirNumero2.requestFocus();
                return false;
            }
        } else if (tipoOperacao.equals(SOMA)) {
            if (n1) {
                Toast.makeText(this, "Informe a parcela", Toast.LENGTH_SHORT).show();
                edtInserirNumero1.requestFocus();
                return false;
            } else if (n2) {
                Toast.makeText(this, "Informe a parcela", Toast.LENGTH_SHORT).show();
                edtInserirNumero2.requestFocus();
                return false;
            }
        } else if (tipoOperacao.equals(SUBTRACAO)) {
            if (n1) {
                Toast.makeText(this, "Informe o dividendo", Toast.LENGTH_SHORT).show();
                edtInserirNumero1.requestFocus();
                return false;
            } else if (n2) {
                Toast.makeText(this, "Informe o divisor", Toast.LENGTH_SHORT).show();
                edtInserirNumero2.requestFocus();
                return false;
            }
        }
        return true;
    }*/