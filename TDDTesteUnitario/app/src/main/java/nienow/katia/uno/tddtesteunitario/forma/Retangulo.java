package nienow.katia.uno.tddtesteunitario.forma;

public class Retangulo extends Forma{
    private static double P = 8;
    private static double A = 4 ;
    private static final double BASE = 2;
    private static final double ALTURA = 2;

    public Retangulo(int numMedidas) {
        super(numMedidas);
    }

    /*public void areaRetangulo(){
        A = base * altura;
    }*/

    @Override
    public double area() {
        return A = BASE * ALTURA;
    }

    public void perimetroRetangulo(){
        P = 2 * (BASE + ALTURA);
    }
}
