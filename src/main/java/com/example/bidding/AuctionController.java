package com.example.bidding;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AuctionController {

    private AuctionService service = new AuctionService();

    @PostMapping("/bid")
    public String placeBid(@RequestBody Bid bid) {
        boolean success = service.placeBid(bid);
        return success ? "Bid placed successfully" : "Bid too low!";
    }

    @GetMapping("/highest")
    public Map<String, Object> getHighest() {
        Map<String, Object> response = new HashMap<>();
        response.put("highestBid", service.getHighestBid());
        response.put("highestBidder", service.getHighestBidder());
        return response;
    }
}