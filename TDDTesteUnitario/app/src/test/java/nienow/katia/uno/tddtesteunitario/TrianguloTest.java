package nienow.katia.uno.tddtesteunitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import nienow.katia.uno.tddtesteunitario.forma.Triangulo;

public class TrianguloTest {
    private static final int POSICAO_ZERO_TRIANGULO_LADO_1 = 3;
    private static final int POSICAO_UM_TRIANGULO_LADO_2 = 3;
    private static final int POSICAO_DOIS_TRIANGULO_LADO_3 = 3;
    private Triangulo triangulo;


    @Before
    public void instanciarObjeto() {
        triangulo = new Triangulo();
    }

    @Test
    public void deveriaCalcularAreaDoTriangulo() {
        double areaDoTrianguloCalculadaNoPapel = 3.8971;
        double DIFERENCA_ACEITAVEL = 0.0001;

        triangulo.setMedida(POSICAO_ZERO_TRIANGULO_LADO_1, 3);
        triangulo.setMedida(POSICAO_UM_TRIANGULO_LADO_2, 3);
        triangulo.setMedida(POSICAO_DOIS_TRIANGULO_LADO_3, 3);

        double x = triangulo.getMedida(POSICAO_ZERO_TRIANGULO_LADO_1)
                + triangulo.getMedida(POSICAO_UM_TRIANGULO_LADO_2)
                + triangulo.getMedida(POSICAO_DOIS_TRIANGULO_LADO_3)) / 2;

        double y = x * (x - triangulo.getMedida(POSICAO_ZERO_TRIANGULO_LADO_1)
                * (x - triangulo.getMedida(POSICAO_UM_TRIANGULO_LADO_2)
                * (x - triangulo.getMedida(POSICAO_DOIS_TRIANGULO_LADO_3));

        double area = Math.sqrt(y);
    }
    /*@Test
    public void deveriaTerUmValorDeSomaDosLadosDoTriangulo() {
        double sl = LADO_1 + LADO_2 + LADO_3;
    }*/

    /*@Test
    public void deveriaTerOsValoresDaSomaDosTriangulosDivididoPorDois() {
      double resultadoDivisao = sl / DIVISAO;
    }*/

    /*@Test
    public void deveriaCalcularAreaDoPerimetroDoTriangulo() {
        double perimetro = sl * (sl - LADO_1) * (sl - LADO_2) * (sl - LADO_3);
    }*/


}
