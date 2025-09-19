package com.hansreidan.store.UserProject.controllers;

import com.hansreidan.store.UserProject.domain.Utente;
import com.hansreidan.store.UserProject.jpa.UtenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")

// ComponentScan(basePackeges = "com.example")
// Qualifier -> Nome per il Bean
// Wildfire -> Apache

public class UserController {

    // RestController prende i file JSON
    // Controller invece HTML
    // SLIDE 381
    // HTTP Master (app per SQL/crazione table)
    // Design Pattern

    @Autowired // Alloca memoria, attento in ampio uso
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

    // CREAZIONE UTENTE POST
    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody Utente user,
                                             BindingResult bindingResult) {
        // Binding contiene i risultati della validazione. Se ci sono errori, possiamo
        // gestirli appropriatamente
        if (bindingResult.hasErrors()) {
        // Gestione degli errori di validazione
            String errorMsg = bindingResult.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
            return new ResponseEntity<>(errorMsg, HttpStatus.BAD_REQUEST);
        }
        Utente savedUser = utenteRepository.save(user);
        return new ResponseEntity<>(savedUser.getId().toString() + " creato con successo", HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public List<Utente> searchUser(@RequestParam String nome) {
        return utenteRepository.findByNome(nome);
    }
}
