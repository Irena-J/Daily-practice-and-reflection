public class Outer {
	 static class Inner{
		int value;
	}
	private static void change(Inner Out1, Inner Out2) {
		int temp=Out1.value;
		Out1.value=Out2.value;
		Out2.value=temp;
	}
	public static void main(String[] args) {
		Outer.Inner Out1 =new Outer.Inner();
		Outer.Inner Out2 =new Outer.Inner();
		Out1.value=1;
		Out2.value=2;
		System.out.println("change before:"+Out1.value+" "+Out2.value);
		change(Out1,Out2);
		System.out.println("change after:"+Out1.value+" "+Out2.value);
	}
}