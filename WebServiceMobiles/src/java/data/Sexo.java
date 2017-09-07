package data;

/**
 * Created by sakshi on 27/04/2016.
 */
public enum Sexo {
    MASCULINO("Masculino"),
    FEMENINO("Femenino");

    private String sexo;

    private Sexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public static Sexo parseSexo(String sexo) {
        if(Sexo.MASCULINO.getSexo().equals(sexo)) {
            return Sexo.MASCULINO;
        }
        else {
            return Sexo.FEMENINO;
        }
    }

}
