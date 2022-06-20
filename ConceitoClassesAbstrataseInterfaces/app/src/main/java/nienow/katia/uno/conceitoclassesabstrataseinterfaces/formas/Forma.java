package nienow.katia.uno.conceitoclassesabstrataseinterfaces.formas;

/*Java - Guia do Programador - 3ª Edição - https://github.com/pjandl/jgp3*/

public abstract class Forma {
    private double medida[]; // array de medidas - declarado private para obrigar o uso dos métodos
    // setMedida(int,double) e getMedida(int) no ajuste de medidas, garantindo a adequada consistência
    // do seu número e de seus valores.

    // Construtor parametrizado
    public Forma(int numMedidas) {
        medida = new double[numMedidas]; // aloca array de medidas
    }

    // Métodos
    public double getMedida(int i) { // obtém uma medida
        if (i < 0 || i >= medida.length) {
            throw new RuntimeException("Numero invalido de medida.");
        }
        return medida[i];
    }

    public int getNumMedidas() { // retorna no. de medidas
        return medida.length;
    }

    /*o método setMedida() é protected para permitir que futuras subclasses decidam por sua exibição
     como public, tornando as medidas do objeto alteráveis.*/
    protected void setMedida(int i, double m) { // ajusta uma medida
        if (i < 0 || i >= medida.length) {
            throw new RuntimeException("Numero invalido de medida.");
        }
        if (m < 0) {
            throw new RuntimeException("Medida #" + i + "invalida.");
        }
        medida[i] = m;
    }

    /* o método toString() obtém o nome da classe e concatena as medidas do objeto em uma única mensagem com uso de um StringBuffer.*/
    @Override
    public String toString() { // representação textual
        StringBuffer sb = new StringBuffer(getClass().getName());
        sb.append("[medidas:");
        for (int i = 0; i < medida.length - 1; i++) {
            sb.append(medida[i]);
            sb.append(",");
        }
        sb.append(medida[medida.length - 1]);
        sb.append("]");
        return sb.toString();
    }

    // método abstrato que determinara área
    public abstract double area();
}