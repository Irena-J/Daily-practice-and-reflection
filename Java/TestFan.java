public class Fan{
	final static int SLOW =1;
	final static int MIDIUM = 2;
	final static int FAST = 3;
	private int speed =SLOW;
	private boolean on=false;
	private double radius=5;
	private String color="blue";
	public Fan(){
		public int getSpeed(){
			return speed;
		}
		public void setSpeed(){
			this.speed=speed;
		}
		public boolean getOn(){
			return on;
		}
		public void setOn(){
			this.on=on;
		}
		public double getRadius(){
			return radius;
		}
		public void setRadius(){
			this.radius=radius;
		}
		public String getColor(){
			return color;
		}
		public String setColor(){
			this.color=color;
		}
		public String toString(){
			if(on=true){
				return "风速:"+this.getSpeed()+"颜色:"+this.getColor()+"半径:"+this.getRadius();
		    else
				return "fan is off"+this.getSpeed()+"颜色:"+this.getColor()+"半径:"+this.getRadius();
			}
		}
	}
}
public class TestFan{
	public sattic void main(){
	Fan one = new Fan();
	Fan another = new Fan();
	one.setSpeed(3)
	one.setColor(10)
	one.setColor("yellow")
	one.toString(true)
	anoter.setSpeed(2)
	anoter.setRadius(5)
	anoter.setColor("blue")
	anoter.toString(flase)
	system.out.println("第一个:"+one.toString()+"第二个:"+another.toString());
	
	
	
	}
}