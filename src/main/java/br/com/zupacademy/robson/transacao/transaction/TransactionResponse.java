package br.com.zupacademy.robson.transacao.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import br.com.zupacademy.robson.transacao.card.CardResponse;
import br.com.zupacademy.robson.transacao.establishment.EstablishmentResponse;

public class TransactionResponse {

    private String id;
    private BigDecimal value;
    private EstablishmentResponse establishmentResponse;
    private CardResponse card;
    private LocalDateTime effectiveOn;

    public TransactionResponse(Transaction transaction) {
        this.id = transaction.getId();
        this.value = transaction.getValue();
        this.establishmentResponse = new EstablishmentResponse(transaction.getEstablishment());
        this.card = new CardResponse(transaction.getCard());
        this.effectiveOn = transaction.getEffectiveOn();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public EstablishmentResponse getEstablishmentResponse() {
        return establishmentResponse;
    }

    public CardResponse getCard() {
        return card;
    }

    public LocalDateTime getEffectiveOn() {
        return effectiveOn;
    }

    public static Page<TransactionResponse> converter(Page<Transaction> transacoes) {
        return transacoes.map(TransactionResponse::new);
    }
}
