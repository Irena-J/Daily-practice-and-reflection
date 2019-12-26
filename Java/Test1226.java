//1、集合存储元素并遍历(加入泛型并可以实现增强for)

import java.lang.Iterable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
class Card{
	String suit;
	int rank;
	

	public Card(String suit,int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public String toString(){
		return "suit:"+suit+"rank:"+rank;
	}
	
}


class Test1226{
	public static void main(String[] args){
		List<Card> L1 = new ArrayList<Card>();
		
		Card c1 = new Card("♥",1);
		Card c2 = new Card("♦",2);
		Card c3 = new Card("♣",3);
		Card c4 = new Card("♠",4);
		
		L1.add(c1);
		L1.add(c2);
		L1.add(c3);
		L1.add(c4);
		
		//用迭代器实现
		Iterator<Card> it = L1.iterator();
		while(it.hasNext()){
			Card ret = it.next();
			System.out.println(ret);
		}
		//增强for
		for(Card L2 : L1){
			System.out.println(L2);
		}
	}
}




