package money;

public class Money {
    protected int amount;

    public boolean equals(Object object) {
        Money dollar = (Money) object;
        return amount == dollar.amount;
    }
}
