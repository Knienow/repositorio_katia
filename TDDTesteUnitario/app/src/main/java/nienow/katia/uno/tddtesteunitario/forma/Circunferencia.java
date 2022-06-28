package nienow.katia.uno.tddtesteunitario.forma;

public class Circunferencia extends Forma{
    public static final int TAMANHO_ARRAY_INFO_CALCULO_AEREA = 1;

    public Circunferencia(int numMedidas) {
        super(numMedidas);
    }

    @Override
    public double area() {
        return TAMANHO_ARRAY_INFO_CALCULO_AEREA;
    }
}
