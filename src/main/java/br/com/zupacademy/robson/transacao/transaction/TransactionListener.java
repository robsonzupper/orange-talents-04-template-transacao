package br.com.zupacademy.robson.transacao.transaction;

import java.util.Optional;
import org.springframework.stereotype.Component;
import br.com.zupacademy.robson.transacao.card.Card;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.zupacademy.robson.transacao.card.CardRepository;
import br.com.zupacademy.transacao.robson.utils.TransactionExecutor;

@Component
public class TransactionListener {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionExecutor executor;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransactionEvent transactionEvent) {
        try {
            Card card;
            Optional<Card> possibleCard = cardRepository.findById(transactionEvent.getCard().getId());
            if (possibleCard.isPresent()) {
                card = possibleCard.get();
            } else {
                card = transactionEvent.getCard().converte();
                executor.saveAndCommit(card);
            }
            Transaction transaction = transactionEvent.converte(card);
            executor.saveAndCommit(transaction.getEstablishment());
            executor.saveAndCommit(transaction);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
