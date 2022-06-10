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
    private static final String SOMA = "Soma";
    private static final String SUBTRACAO = "Subtração";
    private static final String MULTIPLICACAO = "Multiplicação";
    private static final String DIVISAO = "Divisão";
    private static final String TAG = "Main Activity";
    private static final String POTENCIA_DE_10 = "Potência de 10";
    private static final String POTENCIACAO = "Potenciação";
    private static final String RAIZ_QUADRADA = "Raiz Quadrada";
    private static final String LOGARITMO = "Logaritmo";
    private int ZERO = 0;
    private int BASE_DEZ = 10;
    private TextView tvOpcao, tvResultado;
    private ImageView imgvOperacao, imgvIgual;
    private EditText edtInserirNumero1, edtInserirNumero2, edtResultado;
    private Spinner spiOpcoes;
    private Button btnCalcular;



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
                        if (validarOperacoes()){
                            tvResultado.setText(somar());
                        } else {
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                } else if (opcaoSelecionada.equals(SUBTRACAO)) {
                    if(validarTermosVazios()){
                        if(validarOperacoes()){
                            tvResultado.setText(subtrair());
                        } else{
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                } else if (opcaoSelecionada.equals(MULTIPLICACAO)) {
                    if(validarTermosVazios()){
                        if(validarOperacoes()) {
                            tvResultado.setText(multiplicar());
                        }else {
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                            Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                        }
                } else if (opcaoSelecionada.equals(DIVISAO)) {
                    if (validarTermosVazios()) {
                        if (validarOperacoes()) {
                            tvResultado.setText(dividir());
                        } else {
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                } else if(opcaoSelecionada.equals(POTENCIA_DE_10)){
                    if(validarTermosVazios()){
                        if(validarOperacoes()){
                            tvResultado.setText(potenciaDe10());
                        } else {
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                }else if (opcaoSelecionada.equals(POTENCIACAO)){
                    if(validarTermosVazios()) {
                        if (validarOperacoes()) {
                            tvResultado.setText(potenciacao());
                        } else {
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                    /*Toast.makeText(MainActivity.this, "Selecione uma operação matemática válida!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Insira um número!", Toast.LENGTH_SHORT).show();*/
                }else if(opcaoSelecionada.equals(RAIZ_QUADRADA)){
                    if (validarTermosVazios()){
                        if(validarOperacoes()){
                            tvResultado.setText(raizQuadrada());
                        } else {
                            Toast.makeText(MainActivity.this,"O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this,"Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
                } else if(opcaoSelecionada.equals(LOGARITMO)){
                    if(validarTermosVazios()){
                        if(validarOperacoes()){
                            tvResultado.setText(logaritmo());
                        } else {
                            Toast.makeText(MainActivity.this, "O valor informado não pode ser zero!", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(MainActivity.this, "Preencha com algum valor!", Toast.LENGTH_SHORT).show();
                    }
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

        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIA_DE_10)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            edtInserirNumero1.setHint("base");
            tvResultado.setHint("algarismo");
            edtInserirNumero2.setVisibility(View.INVISIBLE);

        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            edtInserirNumero1.setHint("base");
            edtInserirNumero2.setHint("expoente");
            tvResultado.setHint("potência");

        } else if (adapterView.getItemAtPosition(i).toString().equals(RAIZ_QUADRADA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            edtInserirNumero1.setHint("radicando");
            tvResultado.setHint("raiz");
            edtInserirNumero2.setVisibility(View.INVISIBLE);


        } else if (adapterView.getItemAtPosition(i).toString().equals(LOGARITMO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            edtInserirNumero1.setHint("logaritmando");
            tvResultado.setHint("logaritmo");
            edtInserirNumero2.setVisibility(View.INVISIBLE);

        } else {
            Log.d(TAG, "Nenhuma opção foi selecionada");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private boolean validarOperacoes() {
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double n2 = Double.valueOf(edtInserirNumero2.getText().toString());

        if (n1 != ZERO) {
            return true;
        } else if (n2 != ZERO) {
            return true;
        } else{
            return false;
        }
    }

    private String somar() {
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double n2 = Double.valueOf(edtInserirNumero2.getText().toString());
        String resultado = String.valueOf(n1 + n2);
        return "O resultado da soma é: " + resultado;
    }

    private String subtrair() {
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double n2 = Double.valueOf(edtInserirNumero2.getText().toString());
        String resultado = String.valueOf(n1 - n2);
        return "O resultado da subtração é: " + resultado;
    }

    private String multiplicar() {
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double n2 = Double.valueOf(edtInserirNumero2.getText().toString());
        String resultado = String.valueOf(n1 * n2);
        return "O resultado da multiplicação é: " + resultado;
    }

    private String dividir() {
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double n2 = Double.valueOf(edtInserirNumero2.getText().toString());
        String resultado = String.valueOf(n1 / n2);
        return "O resultado da divisão é: " + resultado;
    }

    private String potenciaDe10(){
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double resultado = Math.pow(BASE_DEZ, n1);
        return "O resultato da potência de 10 é: " + resultado;
    }

    private String potenciacao(){
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double n2 = Double.valueOf(edtInserirNumero2.getText().toString());
        double resultado = Math.pow(n1, n2);
        return "O resultado da potenciação é: " + resultado;
    }

    private String raizQuadrada(){
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double resultado = Math.sqrt(n1);
        return "O resultado da raiz quadrada é: " + resultado;
    }

    private String logaritmo(){
        double n1 = Double.valueOf(edtInserirNumero1.getText().toString());
        double resultado = Math.log(n1);
        return "O resultado do logaritmo é: " +  resultado;
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