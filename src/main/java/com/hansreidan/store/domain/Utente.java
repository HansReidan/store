package com.hansreidan.store.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Entity
// Significa che diventa una classe entità JPA, e sarà mappata a una tabella del DB
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter

    private Long id;
    @Getter @Setter
    @NotBlank(message = "Il campo nome non può essere vuoto")
    @Size(min = 2, max = 30, message = "Il nome deve avere tra 2 e 30 caratteri")
    private String nome;
    @Getter @Setter
    @Email(message = "L'email deve essere valida")
    @NotBlank(message = "Il campo email non può essere vuoto")
    @NotNull(message = "L'email non può essere nulla")
    private String email;

    // VARI @TAG
//    @Size Specifica la dimensione minima e/o massima di una collezione, array, stringa, ecc.
//    @NotNull Assicura che il valore non sia null
//    @Min e @Max()  Impongono un valore minimo e massimo su numeri.
//    @Email Verifica che il valore sia un indirizzo email valido
//    @Pattern() Valida il valore contro una regex specificata.

    public Utente() {
    }
    public Utente(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

}
