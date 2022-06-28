package nienow.katia.uno.tddtesteunitario;

//org - nome do pacote (organização)
import org.junit.Test;
import static org.junit.Assert.*;

import nienow.katia.uno.tddtesteunitario.forma.Circunferencia;


public class CircunferenciaTest {
    private static Circunferencia circunferencia = new Circunferencia(1);;

    @Test
    //sempre vai ser void - não tem outro retorno
    public void deveriaTerUmaMedidaDeRaioMaiorDoQueZeroNoArrayDeMedidas() {
        Circunferencia circunferencia = new Circunferencia(1);
        circunferencia.setMedida(0, 3);

        //posição ZERO por se tratar de uma circunferência que precisa de apenas uma informação para calcular a área
        double raio = circunferencia.getMedida(0);

        boolean x = raio > 0;

        assertTrue(x);

    }

    public void deveriaTerUmLimiteDeTamanhoOVetorDeInformacoesDoCalculoDaArea(){
        boolean tamanhoValido = circunferencia.setMedida(0,3) > circunferencia.TAMANHO_ARRAY_INFO_CALCULO_AEREA;
    }
}


