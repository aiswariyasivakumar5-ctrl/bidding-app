package com.example.bidding;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuctionServiceTest {

    @Test
    void testValidBid() {
        AuctionService service = new AuctionService();
        assertTrue(service.placeBid(new Bid("Alice", 100)));
    }

    @Test
    void testInvalidBid() {
        AuctionService service = new AuctionService();
        service.placeBid(new Bid("Alice", 100));
        assertFalse(service.placeBid(new Bid("Bob", 90)));
    }

    @Test
    void testHighestBidder() {
        AuctionService service = new AuctionService();
        service.placeBid(new Bid("Alice", 100));
        service.placeBid(new Bid("Bob", 200));

        assertEquals("Bob", service.getHighestBidder());
    }
}