package nienow.katia.uno.conceitoclassesabstrataseinterfaces.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nienow.katia.uno.conceitoclassesabstrataseinterfaces.R;

public class TrianguloFrag extends Fragment {

    public TrianguloFrag() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layoutFragment = inflater.inflate(R.layout.fragment_blank, container, false);

        return layoutFragment;
    }
}