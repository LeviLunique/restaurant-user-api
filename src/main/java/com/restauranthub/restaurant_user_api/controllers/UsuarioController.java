package com.restauranthub.restaurant_user_api.controllers;

import com.restauranthub.restaurant_user_api.dto.AlterarSenhaRequest;
import com.restauranthub.restaurant_user_api.dto.ApiMessageResponse;
import com.restauranthub.restaurant_user_api.dto.PageResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioRequest;
import com.restauranthub.restaurant_user_api.dto.UsuarioResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioResumoResponse;
import com.restauranthub.restaurant_user_api.dto.UsuarioUpdateRequest;
import com.restauranthub.restaurant_user_api.services.UsuarioService;
import jakarta.validation.Valid;
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

@RestController
@Validated
@RequestMapping("/api/v1")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest request) {
        UsuarioResponse created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<PageResponse<UsuarioResumoResponse>> listarUsuarios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort) {
        return ResponseEntity.ok(service.findAll(page, size, sort));
    }

    @GetMapping("/users/search")
    public ResponseEntity<PageResponse<UsuarioResumoResponse>> buscarPorNome(
            @RequestParam("nome") String nome,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sort) {
        return ResponseEntity.ok(service.searchByNome(nome, page, size, sort));
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<UsuarioResumoResponse> buscarPorEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(
            @PathVariable("id") Long id,
            @Valid @RequestBody UsuarioUpdateRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @PatchMapping("/users/{id}/password")
    public ResponseEntity<ApiMessageResponse> alterarSenha(
            @PathVariable("id") Long id,
            @Valid @RequestBody AlterarSenhaRequest request) {
        return ResponseEntity.ok(service.alterarSenha(id, request));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> desativarUsuario(@PathVariable("id") Long id) {
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }
}
