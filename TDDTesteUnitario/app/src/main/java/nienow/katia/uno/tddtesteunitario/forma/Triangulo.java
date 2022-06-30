package nienow.katia.uno.tddtesteunitario.forma;

public class Triangulo extends Forma{
    private static final double LADO_1 = 3;
    private static final double LADO_2 = 3;
    private static final double LADO_3 = 3;
    private static final int numMedidas = 3;


    public Triangulo() {
        super(numMedidas);
    }

    @Override
    public double area() {
        return 0;
    }
    //soma do lados do triangulo dividido por 2;
    //raiz quadrada de sl

}
