package nienow.katia.uno.conceitofragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toolbar;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private EditText edtInformarTexto;
    private SeekBar skbFormatarTexto;
    private Button btnAlterarTexto;
    private ToolbarListener toolbarListener;
    private static int textSize = 10;
    public static final String TAG = "Toolbar Fragment";

    public interface ToolbarListener{
       public void onButtonClick(int position, String texto);
    }

    public ToolbarFragment() {}

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            toolbarListener = (ToolbarListener) context;

        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "Obrigatório implementar uma interface ToolbarListener ");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toolbar, container, false);

        edtInformarTexto    = view.findViewById(R.id.edtInformarTexto);
        skbFormatarTexto    = view.findViewById(R.id.skbFormatarTexto);
        btnAlterarTexto     = view.findViewById(R.id.btnAlterarTexto);

        btnAlterarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        skbFormatarTexto.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) this);

        return view;
    }

   public void buttonClicked(View view){
        toolbarListener.onButtonClick(textSize, edtInformarTexto.getText().toString());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        textSize = i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Log.d(TAG, "onStarTrackingTouch: executou o método quando tirou-se o dedo de cima da view - seekbar.");
    }
}