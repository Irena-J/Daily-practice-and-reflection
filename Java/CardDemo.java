import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


// 牌的结构
class Card{
    Card(String suit, int rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        String strNum = String.format("%d", rank);

        switch(rank)
        {
            case 11:
                strNum = "J";
                break;
            case 12:
                strNum = "Q";
                break;
            case 13:
                strNum = "K";
                break;
        }

        return suit + ":" + strNum;
    }

    private String suit;  // 代表牌的花色
    private int rank;    //  代表牌面值
}


class CardDeam{
    // 构造一幅扑克牌
    String Color[] = {"♥", "♦", "♣", "♠"};

    public List<Card> BuyDeck()
    {
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < 4; ++i){
            for(int j = 1; j <= 13; ++j){
                // 牌面值 和 牌的花色
                Card c = new Card(Color[i], j);
                cards.add(c);
            }
        }

        return cards;
    }

    // 洗牌
    public void shuffleCard(List<Card> cards){
        for(int i = cards.size()-1; i > 0; i--){

            // 从[0，i)区间中随机取一张牌
            // 常见设置种子方式：获取系统当前时间
            Random r = new Random(20191224);
            int j = r.nextInt(i);

            // 将i和j位置的牌进行交换
            Swap(cards, i, j);
        }
    }

    private void Swap(List<Card> cards, int i, int j){
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }
}
public class Test20191221 {
    public static void main(String[] args) {
        CardDeam cd = new CardDeam();

        // 构造一幅扑克牌
        List<Card> L = cd.BuyDeck();

        // 打印扑克牌
        System.out.println(L);

        cd.shuffleCard(L);
        System.out.println(L);

        // 3个人---每个人摸5张牌 抓牌
        List<List<Card>> hands = new ArrayList<>();
        for(int i = 0; i < 3; ++i)
            hands.add(new ArrayList<>());

        for(int i = 0; i < 5; ++i){
            // 3个人一次摸牌
            for(int j = 0; j < 3; ++j){
                // 从L中依次获取一张牌---》
                Card card = L.remove(L.size()-1);
                // 将该张牌放置到对应人的手中
                hands.get(j).add(card);
            }
        }

        // 打印每个人手中的牌
        for(int i = 0; i < hands.size(); ++i){
            System.out.println(hands.get(i));
        }
        // 牌摞摞中剩余什么牌
        System.out.println(L.size());
        System.out.println(L);
    }
}
