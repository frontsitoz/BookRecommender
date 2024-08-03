package com.backend.service.impl;

import com.backend.model.User;
import com.backend.repository.IGenericRepo;
import com.backend.repository.IUserRepo;
import com.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, String> implements IUserService {

    private final IUserRepo userRepo;

    @Override
    public IGenericRepo<User, String> getRepo() {
        return userRepo;
    }

    @Override
    public Boolean existsByUsernameAndIdUserAndAndEmail(String username, String idUser, String email) {
        return userRepo.existsByUsernameAndIdUserAndAndEmail(username, idUser, email);
    }
}
