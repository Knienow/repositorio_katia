package nienow.katia.uno.tddtesteunitario;

import nienow.katia.uno.tddtesteunitario.forma.Forma;

public class TrianguloTest extends Forma {

    public TrianguloTest(int numMedidas) {
        super(numMedidas);
    }

    //soma dos lados - sl
    @Override
    public double area() {
        double lado1 = 3;
        double lado2 = 3;
        double lado3 = 3;

        //soma do lados do triangulo dividido por 2;
        //raiz quadrada de sl
        return sl * (sl - lado2) * (sl - lado3);
    }
}
