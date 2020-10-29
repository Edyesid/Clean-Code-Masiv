package org.masiv.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
@RedisHash("Roulette")
public class Roulette {
    @Id
    private String id;
    private State state;
    public Roulette() {
        this.state = State.CLOSE;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void openState() {
        this.state = State.OPEN;
    }
    public void closeState() {
        this.state = State.CLOSE;
    }
}
