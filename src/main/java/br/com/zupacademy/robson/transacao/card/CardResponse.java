package br.com.zupacademy.robson.transacao.card;

public class CardResponse {
    private String id;
    private String email;

    public CardResponse(Card card) {
        this.id = card.getId();
        this.email = card.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
