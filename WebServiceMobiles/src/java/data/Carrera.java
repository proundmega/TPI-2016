package data;

/**
 * Created by sakshi on 27/04/2016.
 */
public enum Carrera {
    SISTEMAS("Ing. Sistemas informaticos"),
    CIVIL("Ing. Civil"),
    INDUSTRIAL("Ing. industrial"),
    ELECTRICA("Ing. electrica"),
    MECANICA("Ing. mecanica"),
    QUIMICA("Ing. quimica"),
    ARQUITECTURA("Arquitectura");


    private String nombreCarrera;
    private Carrera(String nombreCarrera){
        this.nombreCarrera = nombreCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    @Override
    public String toString() {
        return getNombreCarrera();
    }

    public static Carrera getCarreraByNombre(String carreraString) {
        for(Carrera carrera : Carrera.values()) {
            if(carrera.getNombreCarrera().equals(carreraString)) {
                return carrera;
            }
        }
        throw new IllegalArgumentException("Esta carrera no existe");
    }
}
