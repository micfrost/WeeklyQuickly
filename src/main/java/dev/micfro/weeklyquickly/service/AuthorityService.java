package dev.micfro.weeklyquickly.service;

import dev.micfro.weeklyquickly.model.Authority;
import dev.micfro.weeklyquickly.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }


    // CRUD

    // save authority
    public void saveAuthority(Authority authority) {
        authorityRepository.save(authority);

    }



}
