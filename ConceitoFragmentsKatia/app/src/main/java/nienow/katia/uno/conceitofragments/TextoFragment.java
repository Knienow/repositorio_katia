package nienow.katia.uno.conceitofragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextoFragment extends Fragment {
    private TextView tvExibirTexto;

    public TextoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_texto, container, false);

        tvExibirTexto = view.findViewById(R.id.tvExibirTexto);

        return view;
    }

    public void trocarPropriedadesDoTexto (int tamanhofonte,String texto){
        tvExibirTexto.setTextSize(tamanhofonte);
        tvExibirTexto.setText(texto);
    }


}