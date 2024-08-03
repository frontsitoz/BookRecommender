package com.backend.service;

import com.backend.model.Book;
import com.backend.model.User;

public interface IUserService extends ICRUD<User, String>{

    Boolean existsByUsernameAndIdUserAndAndEmail(String username, String idUser, String email);
}
