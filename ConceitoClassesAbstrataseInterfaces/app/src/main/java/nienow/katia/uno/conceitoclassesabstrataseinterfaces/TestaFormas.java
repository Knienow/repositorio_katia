package nienow.katia.uno.conceitoclassesabstrataseinterfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import nienow.katia.uno.conceitoclassesabstrataseinterfaces.formas.Circunferencia;
import nienow.katia.uno.conceitoclassesabstrataseinterfaces.formas.Forma;
import nienow.katia.uno.conceitoclassesabstrataseinterfaces.formas.Retangulo;
import nienow.katia.uno.conceitoclassesabstrataseinterfaces.formas.Triangulo;

public class TestaFormas extends AppCompatActivity {

    public static void main(String a[]) {
        Circunferencia c = new Circunferencia(1.5);
        System.out.println("areaCirc = " + c.area());
        Retangulo r = new Retangulo(2.5, 4.0);
        System.out.println("areaRet = " + r.area());
        Forma formas[] = new Forma[3];
        formas[0] = c;
        formas[1] = r;
        formas[2] = new Triangulo(1.0, 2.0, 2.0);
        for (int i = 0; i < formas.length; i++) {
            System.out.println(formas[i]);
            System.out.println("area = " + formas[i].area());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}