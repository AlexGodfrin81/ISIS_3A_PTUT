package yucroq.dto;

import java.time.LocalDate;

public interface RationPourAnimal {
    Integer getIdcroq();
    String getMarquecroq();
    String getNomcroq();
    float getQuantiteration();
    LocalDate getDatedebut();
    LocalDate getDatefin();
    float getDensiteenergetique();
    Integer getIdration();
}
