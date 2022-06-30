package nienow.katia.uno.tddtesteunitario;

import org.junit.Test;

import nienow.katia.uno.tddtesteunitario.forma.Triangulo;

public class TrianguloTest {
    private static final double LADO_1 = 3;
    private static final double LADO_2 = 3;
    private static final double LADO_3 = 3;
    private static final Triangulo triangulo = new Triangulo();

    TrianguloTest(){}

    @Test
    public void deveriaTerUmValorDeSomaDosLadosDoTriangulo(){}
        double sl = LADO_1 + LADO_2 + LADO_3;

    @Test
    public void deveriaTerOsValoresDaSomaDosTriangulosDivididoPorDois(){
        double resultadoDivisao = sl / 2;
    }

    @Test
    public void deveriaCalcularAreaDoPerimetroDoTriangulo(){
        double perimetro = sl *(sl - LADO_1) * (sl - LADO_2) * (sl - LADO_3);
    }
}
