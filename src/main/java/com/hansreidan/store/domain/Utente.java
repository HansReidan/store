package com.hansreidan.store.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
// Significa che diventa una classe entità JPA, e sarà mappata a una tabella del DB
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter

    private Long id;
    @Getter @Setter
    @NotBlank(message = "Il campo nome non può essere vuoto")
    private String nome;
    @Getter @Setter
    @Email(message = "L'email deve essere valida")
    @NotBlank(message = "Il campo email non può essere vuoto")
    private String email;

    public Utente() {
    }
    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

}
