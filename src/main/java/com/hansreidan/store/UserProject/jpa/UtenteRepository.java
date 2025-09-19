package com.hansreidan.store.UserProject.jpa;

import com.hansreidan.store.UserProject.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    List<Utente> findByNome(String nome);
}
