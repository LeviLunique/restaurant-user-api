package com.restauranthub.restaurant_user_api.services.impl;

import com.restauranthub.restaurant_user_api.dto.LoginRequest;
import com.restauranthub.restaurant_user_api.dto.LoginResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioResumoResponse;
import com.restauranthub.restaurant_user_api.entities.UsuarioEntity;
import com.restauranthub.restaurant_user_api.exceptions.DomainValidationException;
import com.restauranthub.restaurant_user_api.exceptions.ResourceNotFoundException;
import com.restauranthub.restaurant_user_api.mappers.UsuarioMapper;
import com.restauranthub.restaurant_user_api.repositories.UsuarioRepository;
import com.restauranthub.restaurant_user_api.services.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthServiceImpl(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {
        if (request == null) throw new DomainValidationException("request não pode ser nulo");
        UsuarioEntity entity = repository.findByEmailIgnoreCase(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com email: " + request.getEmail()));
        if (Boolean.FALSE.equals(entity.getAtivo())) {
            throw new DomainValidationException("Usuário inativo");
        }
        if (!passwordEncoder.matches(request.getSenha(), entity.getSenha())) {
            throw new DomainValidationException("Credenciais inválidas");
        }
        UsuarioResumoResponse resumo = mapper.toResumo(mapper.toDomain(entity));
        return LoginResponse.builder()
                .token("mock-token") // TODO: gerar JWT na etapa de segurança
                .tipo("Bearer")
                .usuario(resumo)
                .build();
    }
}
