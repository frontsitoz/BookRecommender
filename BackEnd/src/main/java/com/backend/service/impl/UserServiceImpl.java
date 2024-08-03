package com.backend.service.impl;

import com.backend.model.User;
import com.backend.repository.IGenericRepo;
import com.backend.repository.IUserRepo;
import com.backend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Long> implements IUserService {

    private final IUserRepo userRepo;

    @Override
    public IGenericRepo<User, Long> getRepo() {
        return userRepo;
    }


}
