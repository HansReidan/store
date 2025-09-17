package com.hansreidan.store.controllers;

import com.hansreidan.store.domain.Utente;
import com.hansreidan.store.jpa.UtenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UtenteRepository utenteRepository;

    // GET /api/users - Recupera tutti gli utenti
    @GetMapping
    public List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    // GET /api/users/{id} - Recupera un utente per ID
    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUserById(@PathVariable Long id) {
        Optional<Utente> userOpt = utenteRepository.findById(id);
        return userOpt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/users - Crea un nuovo utente
    @PostMapping
    public Utente createUser(@RequestBody Utente user) {
        return utenteRepository.save(user);
    }

    // PUT /api/users/{id} - Aggiorna un utente esistente
    @PutMapping("/{id}")
    public ResponseEntity<Utente> updateUser(@PathVariable Long id, @RequestBody
    Utente userDetails) {
        Optional<Utente> userOpt = utenteRepository.findById(id);
        if (!userOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Utente user = userOpt.get();
        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());
        Utente updatedUser = utenteRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // DELETE /api/users/{id} - Elimina un utente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<Utente> userOpt = utenteRepository.findById(id);
        if (!userOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        utenteRepository.delete(userOpt.get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Utente> createUser(@Valid @RequestBody Utente user,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        // Gestione degli errori di validazione
            return ResponseEntity.badRequest().build();
        }
        Utente savedUser = utenteRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
