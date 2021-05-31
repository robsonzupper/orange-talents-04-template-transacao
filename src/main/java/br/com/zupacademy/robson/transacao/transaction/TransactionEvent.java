package br.com.zupacademy.robson.transacao.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import br.com.zupacademy.robson.transacao.card.Card;
import br.com.zupacademy.robson.transacao.card.TransactionCard;
import br.com.zupacademy.robson.transacao.establishment.EstablishmentTransaction;

public class TransactionEvent {

    private String id;
    private BigDecimal value;
    private EstablishmentTransaction establishment;
    private TransactionCard card;
    private LocalDateTime effectiveOn;

    public TransactionEvent(String id, BigDecimal value,
            EstablishmentTransaction establishment,
            TransactionCard card, LocalDateTime effectiveOn) {

        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectiveOn = effectiveOn;
    }

    @Deprecated
    public TransactionEvent() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentTransaction getEstablishment() {
        return establishment;
    }

    public TransactionCard getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{"
                + "id='" + id + '\''
                + ", valor=" + value
                + ", estabelecimento=" + establishment
                + ", cartao=" + card
                + ", efetivadaEm=" + effectiveOn
                + '}';
    }

    public Transaction converte(Card card) {

        return new Transaction(
                id,
                value,
                establishment.converte(),
                card,
                effectiveOn
        );
    }
}
