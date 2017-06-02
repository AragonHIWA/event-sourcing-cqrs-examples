package bankservice.projection.accounttransactions;

import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static bankservice.projection.accounttransactions.TransactionProjection.TransactionType.DEPOSIT;
import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.TEN;
import static java.util.UUID.randomUUID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.joda.time.DateTime.now;
import static org.joda.time.DateTimeZone.UTC;
import static org.junit.Assert.assertThat;

public class InMemoryAccountTransactionsRepositoryTest {

    private AccountTransactionsRepository accountTransactionsRepository =
            new InMemoryAccountTransactionsRepository();

    @Test
    public void listEventsSortedByVersion() throws Exception {
        UUID accountId = randomUUID();
        TransactionProjection tx2 = new TransactionProjection(accountId, DEPOSIT, TEN, now(UTC), 2);
        TransactionProjection tx1 = new TransactionProjection(accountId, DEPOSIT, ONE, now(UTC), 1);
        accountTransactionsRepository.save(tx2);
        accountTransactionsRepository.save(tx1);

        List<TransactionProjection> transactions = accountTransactionsRepository.listByAccount(accountId);
        assertThat(transactions.get(0), equalTo(tx1));
        assertThat(transactions.get(1), equalTo(tx2));
    }
}