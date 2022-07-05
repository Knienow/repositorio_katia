package nienow.katia.uno.tddtesteunitario.forma;

public class Triangulo extends Forma{
   /* private static final double LADO_1 = 3;
    private static final double LADO_2 = 3;
    private static final double LADO_3 = 3;
    private static final int numMedidas = 3;*/
   private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO = 3;


    public Triangulo() {
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO);
    }

    @Override
    public double area() {
        return getMedida(0) * getMedida(1);
    }
}
