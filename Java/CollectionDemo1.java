import java.util.Collection;
	import java.util.ArrayList;
	import java.util.Interator;
	
	public class CollectionDemo{
		Collection c = new ArrayList();
		c.add("java");
		c.add("world");
		c.add("hello");
		Iterator it = c.iterator();
		while(it.hasNext()){
			String s = (String) it.next();
			System.out.println(s);
		}
	}