package card;

public class CardCompany {

    public static CardCompany instance = new CardCompany();

    private CardCompany() {}

    public static CardCompany getInstance() {
        if(instance == null)
            instance = new CardCompany();
        return instance;
    }

    public Card createCard() {
        Card card = new Card();
        return card;
    }
}