package br.com.zupacademy.robson.transacao.transaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.com.zupacademy.robson.transacao.card.Card;
import br.com.zupacademy.robson.transacao.establishment.Establishment;

@Entity
public class Transaction {

    @Id
    private String id;

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne(optional = false)
    private Establishment establishment;

    @ManyToOne(optional = false)
    private Card card;

    @Column(nullable = false)
    private LocalDateTime effectiveOn;

    public Transaction(String id, BigDecimal value, Establishment establishment,
            Card card, LocalDateTime effectiveOn) {

        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = effectiveOn;
    }

    @Deprecated
    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public Card getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }

}
