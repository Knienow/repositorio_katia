package katia.nienow.projetoconceitosintent;

import androidx.annotation.Nullable;
//import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    private TextView tvTextoVisivel, tvExibirResposta;
    private Button btnPerguntar;
    private EditText edtDigiteUmaPergunta;
    private ImageButton imgbClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTextoVisivel       = findViewById(R.id.tvTextoVisivel);
        btnPerguntar         = findViewById(R.id.btnPerguntar);
        edtDigiteUmaPergunta = findViewById(R.id.edtDigiteUmaPergunta);
        imgbClear             = findViewById(R.id.imgbClear);
        tvExibirResposta = findViewById(R.id.tvExibirResposta);

        tvTextoVisivel.setVisibility(View.INVISIBLE);

        /*Bundle extras = getIntent().getExtras();
        String pergunta = "";
        if(extras!=null) {
            pergunta = extras.getString("Pergunta");
            tvTextoVisivel.setText(pergunta);

        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
           actionBar.setTitle("Activity de respostas");

        }*/

        imgbClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtDigiteUmaPergunta.setText("");
                tvExibirResposta.setText("");
            }
        });

        btnPerguntar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtDigiteUmaPergunta.getText().toString().isEmpty()){
                    Intent irParaOutraActivity = new Intent(MainActivity.this, RespostaActivity.class);

                    String conteudo = edtDigiteUmaPergunta.getText().toString();
                    irParaOutraActivity.putExtra("Pergunta", conteudo);

                   /*if(tvTextoVisivel.getText().toString().isEmpty()){
                        String myResposta = tvTextoVisivel.getText().toString();
                        intent.putExtra("Resposta", myResposta);
                    }

                    setResult(RESULT_OK, intent);*/
                    startActivityForResult(irParaOutraActivity, REQUEST_CODE);

                } else {
                    Toast.makeText(MainActivity.this, "Faça uma pergunta!", Toast.LENGTH_SHORT).show();
                    /*Intent irParaOutraActivity = new Intent(MainActivity.this, RespostaActivity.class);
                    startActivity(irParaOutraActivity);*/
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {

            String returnString = data.getExtras().getString("returnData");
            //String resposta = data.getExtras().getString("resposta");

            if(returnString != null){
                if(returnString.isEmpty()){
                    tvTextoVisivel.setVisibility(View.VISIBLE);
                }
            }

            tvExibirResposta.setText(returnString);
        }
    }

   /*public void openActivityForResult(){
        Intent intent = new Intent(MainActivity.this, RespostaActivity.class);
        }*/
    }