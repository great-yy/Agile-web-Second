//扑克牌类
public class Cards {
    private String firstCard;
    private String secondCard;
    private String thirdCard;
    private String fourthCard;
    private String fifthCard;

    public Cards() {
    }

    public Cards(String firstCard, String secondCard, String thirdCard, String fourthCard, String fifthCard) {
        this.firstCard = firstCard;
        this.secondCard = secondCard;
        this.thirdCard = thirdCard;
        this.fourthCard = fourthCard;
        this.fifthCard = fifthCard;
    }

    public String getFirstCard() {
        return firstCard;
    }

    public void setFirstCard(String firstCard) {
        this.firstCard = firstCard;
    }

    public String getSecondCard() {
        return secondCard;
    }

    public void setSecondCard(String secondCard) {
        this.secondCard = secondCard;
    }

    public String getThirdCard() {
        return thirdCard;
    }

    public void setThirdCard(String thirdCard) {
        this.thirdCard = thirdCard;
    }

    public String getFourthCard() {
        return fourthCard;
    }

    public void setFourthCard(String fourthCard) {
        this.fourthCard = fourthCard;
    }

    public String getFifthCard() {
        return fifthCard;
    }

    public void setFifthCard(String fifthCard) {
        this.fifthCard = fifthCard;
    }
// 生成一组扑克牌
    public static void subCards(){

    }


}
