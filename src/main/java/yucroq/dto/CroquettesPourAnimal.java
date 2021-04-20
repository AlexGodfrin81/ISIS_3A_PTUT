package yucroq.dto;
import yucroq.entity.Espece;


public interface CroquettesPourAnimal {
    Integer getIdcroq();
    String getNomcroq();
    String getMarquecroq();
    Espece getEspece();
}
