package org.masiv.model;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.masiv.Exceptions.BetException;
import java.util.UUID;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BetNumber.class, name = "number"),
        @JsonSubTypes.Type(value = BetColor.class, name = "color")
})
public abstract class Bet {
    private String idBet;
    private String idUser;
    private int money;
    public Bet(int money) throws BetException {
        this.idBet = UUID.randomUUID().toString();
        setMoney(money);
    }
    public void setMoney(int money) throws BetException {
        if (money <= 0) {
            throw new BetException(BetException.MIN_MONEY);
        } else if (money > 10000) {
            throw new BetException(BetException.MAX_MONEY);
        }
        this.money = money;
    }
    public void setIdUser(String IdUser) {
        this.idUser = IdUser;
    }
}