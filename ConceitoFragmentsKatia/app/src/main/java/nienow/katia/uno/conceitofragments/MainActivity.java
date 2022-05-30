package nienow.katia.uno.conceitofragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener {
    private Fragment frgTexto, frgToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonClick(int tamanhofonte, String texto) {
        TextoFragment tvExibirTexto = (TextoFragment) getSupportFragmentManager().findFragmentById(R.id.frgTexto);
        tvExibirTexto.trocarPropriedadesDoTexto(tamanhofonte, texto);
    }
}