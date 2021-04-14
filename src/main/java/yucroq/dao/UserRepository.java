package yucroq.dao;

import yucroq.entity.Proprietaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Proprietaire, Long> {
    Proprietaire findByUsername(String name);
}
