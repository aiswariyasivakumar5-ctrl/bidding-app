package com.example.bidding;

import java.util.*;

public class AuctionService {
    private List<Bid> bids = new ArrayList<>();
    private double highestBid = 0;
    private String highestBidder = null;

    public synchronized boolean placeBid(Bid bid) {
        if (bid.amount <= highestBid) {
            return false;
        }
        bids.add(bid);
        highestBid = bid.amount;
        highestBidder = bid.bidderName;
        return true;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }
}