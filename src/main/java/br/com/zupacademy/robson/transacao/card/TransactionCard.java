package br.com.zupacademy.robson.transacao.card;

public class TransactionCard {

    private String id;
    private String email;

    public TransactionCard(String id, String email) {
        this.id = id;
        this.email = email;
    }

    @Deprecated
    public TransactionCard() {
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CardTransacao{"
                + "id='" + id + '\''
                + ", email='" + email + '\''
                + '}';
    }

    public Card converte() {
        return new Card(id, email);
    }

}
