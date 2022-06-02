package nienow.katia.uno.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvOpcao;
    private ImageView imgvSoma, imgvIgual;
    private EditText edtInserirNumero1, edtInserirNumero2, edtResultado;
    private Spinner spiOpcoes;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOpcao           = findViewById(R.id.tvOpcao);
        imgvSoma          = findViewById(R.id.imgvSoma);
        imgvIgual         = findViewById(R.id.imgvIgual);
        edtInserirNumero1 = findViewById(R.id.edtInserirNumero1);
        edtInserirNumero2 = findViewById(R.id.edtInserirNumero2);
        spiOpcoes         = findViewById(R.id.spiOpcoes);
        btnCalcular       = findViewById(R.id.btnCalcular);

        Bundle extras = getIntent().getExtras();
    }
}