package com.restauranthub.restaurant_user_api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restauranthub.restaurant_user_api.dto.AlterarSenhaRequest;
import com.restauranthub.restaurant_user_api.dto.ApiMessageResponse;
import com.restauranthub.restaurant_user_api.dto.PageResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioRequest;
import com.restauranthub.restaurant_user_api.dto.UsuarioResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioResumoResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioUpdateRequest;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/v1")
public class UsuarioController {

    @PostMapping("/users")
    public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest request) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable("id") Long id) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/users")
    public ResponseEntity<PageResponse<UsuarioResumoResponse>> listarUsuarios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/users/search")
    public ResponseEntity<PageResponse<UsuarioResumoResponse>> buscarPorNome(
            @RequestParam("nome") String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<UsuarioResumoResponse> buscarPorEmail(@PathVariable("email") String email) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(
            @PathVariable("id") Long id,
            @Valid @RequestBody UsuarioUpdateRequest request) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @PatchMapping("/users/{id}/password")
    public ResponseEntity<ApiMessageResponse> alterarSenha(
            @PathVariable("id") Long id,
            @Valid @RequestBody AlterarSenhaRequest request) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> desativarUsuario(@PathVariable("id") Long id) {
        // TODO: delegar para camada de serviço
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
