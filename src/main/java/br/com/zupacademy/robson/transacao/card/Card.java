package br.com.zupacademy.robson.transacao.card;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Card {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String email;

    public Card(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    public Card() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void getCard(String id) {
    }
}
