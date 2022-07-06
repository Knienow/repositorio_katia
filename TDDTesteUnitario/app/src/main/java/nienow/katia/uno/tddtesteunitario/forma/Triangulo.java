package nienow.katia.uno.tddtesteunitario.forma;

public class Triangulo extends Forma{
   private static final int TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO = 3;
   private static final int POSICAO_ZERO_TRIANGULO_LADO_1 = 0;
   private static final int POSICAO_UM_TRIANGULO_LADO_2 = 1;
   private static final int POSICAO_DOIS_TRIANGULO_LADO_3 = 2;

    public Triangulo() {
        super(TAMANHO_ARRAY_INFO_CALCULO_AREA_TRIANGULO);
    }

    @Override
    public double area() {

        double x = getMedida(POSICAO_ZERO_TRIANGULO_LADO_1)
                + getMedida(POSICAO_UM_TRIANGULO_LADO_2)
                + getMedida(POSICAO_DOIS_TRIANGULO_LADO_3) / 2;

        double y = x * (x - getMedida(POSICAO_ZERO_TRIANGULO_LADO_1))
                * (x - getMedida(POSICAO_UM_TRIANGULO_LADO_2))
                * (x - getMedida(POSICAO_DOIS_TRIANGULO_LADO_3));

        return Math.sqrt(y);
    }
}
