package yucroq.service;

import yucroq.entity.Proprietaire;

public interface UserService {
    void initializeRolesAndAdmin();

    void save(Proprietaire user);

    Proprietaire findByUserName(String username);
}
