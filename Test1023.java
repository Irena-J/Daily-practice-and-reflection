class Test{
    String name;
	String Na;
	String id;
    int a;
	public Test(String myNa){
		Na = myNa;
	}
    public Test(String myname,String myid){
		name = myname;
		id = myid;
	}
	public void getName(){
		System.out.println(this.name);
	}
	public void getNa(){
		System.out.println(this.Na);
	}
}
public class Test1023{
    public static void main(String[] args){
    Test Te1 = new Test("ha","haa");
	Test Te2 = new Test("xi");
	Te1.getName();
	Te2.getNa();
	Te1.getNa();
    }
}