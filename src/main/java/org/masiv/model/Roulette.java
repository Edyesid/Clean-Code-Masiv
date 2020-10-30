package org.masiv.model;
import org.masiv.Exceptions.RouletteException;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.util.ArrayList;
import java.util.List;
@RedisHash("Roulette")
public class Roulette {
    @Id
    private String id;
    private State state;
    private List<Bet> bets;
    public Roulette() {
        bets = new ArrayList<>();
        this.state = State.CLOSE;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void openState() throws RouletteException {
        if (this.state == State.OPEN) {
            throw new RouletteException(RouletteException.IS_ALREADY_OPEN);
        }
        this.state = State.OPEN;
    }
    public void closeState() throws RouletteException {
        if (this.state == State.CLOSE) {
            throw new RouletteException(RouletteException.IS_ALREADY_CLOSE);
        }
        this.state = State.CLOSE;
    }
    public void addBet(Bet bet) throws RouletteException {
        if (this.state == State.CLOSE) {
            throw new RouletteException(RouletteException.IS_ALREADY_CLOSE);
        }
        this.bets.add(bet);
    }
}
