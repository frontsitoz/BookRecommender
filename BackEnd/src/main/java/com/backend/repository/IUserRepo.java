package com.backend.repository;

import com.backend.model.User;

public interface IUserRepo extends IGenericRepo<User, String>{

    Boolean existsByUsernameAndIdUserAndAndEmail(String username, String idUser, String email);
}
