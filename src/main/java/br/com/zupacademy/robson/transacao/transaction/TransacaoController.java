package br.com.zupacademy.robson.transacao.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import br.com.zupacademy.robson.transacao.card.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zupacademy.robson.transacao.card.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RestController
@RequestMapping("api/transacao")
public class TransacaoController {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    CardRepository cardRepository;

    @GetMapping("/{cardId}")
    public ResponseEntity<?> getRecentTransactions(
            @PathVariable("cardId") String cardId) {

        Optional<Card> card = cardRepository.findById(cardId);
        if (card.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "efetivadaEm");
        Page<Transaction> possibleTransactions = transactionRepository
                .findByCardID(cardId, pageable);

        Page<TransactionResponse> transacoes = TransactionResponse
                .converter(possibleTransactions);
        return ResponseEntity.ok().body(transacoes);
    }

}
