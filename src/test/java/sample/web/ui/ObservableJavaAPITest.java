package sample.web.ui;

import org.junit.Test;
import sample.web.ui.domain.Bidder;
import sample.web.ui.domain.Product;

import java.math.BigDecimal;

public class ObservableJavaAPITest {

    @Test
    public void testObserver() {
        Product product = new Product("4MM schroeven 20kg", new BigDecimal(325));
        Bidder bidder1 = new Bidder("User1");
        Bidder bidder2 = new Bidder("User2");
        Bidder bidder3 = new Bidder("User3");
        product.addObserver(bidder1);
        product.addObserver(bidder2);
        product.addObserver(bidder3);
        product.setBidAmount(bidder1, new BigDecimal(350));
        product.deleteObserver(bidder2);
        product.setBidAmount(bidder3, new BigDecimal(375));
    }
}