package com.hansreidan.store.jpa;

import com.hansreidan.store.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

}
