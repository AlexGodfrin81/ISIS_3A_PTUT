package yucroq.dto;
import yucroq.entity.Espece;

public interface RechercheCroquettes {
    Integer getIdcroq();
    String getMarque();
    String getNom();
    Espece getEspece();
}
