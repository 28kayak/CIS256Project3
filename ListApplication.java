
public class ListApplication
{

	
	public static void main(String[] args)
	{
		
		SuperList superbag = new SuperList();
		//System.out.println(superbag.toString());

		
		superbag.insertFront("kaya");
		System.out.println(superbag.toString());
		superbag.insertFront("kaori");
		System.out.println(superbag.toString());
		superbag.insertFront("keisuke");
		System.out.println(superbag.toString());
		superbag.removeOne("kaori");
		System.out.println(superbag.toString());
		superbag.insertRear("‚«‚å‚¤‚à‚°‚ñ‚«");
		System.out.println(superbag.toString());
		superbag.insertRear("‚ ‚µ‚½‚à‚°‚ñ‚«");
		System.out.println(superbag.toString());
		//System.out.println("return String=" + superbag.removeFirst());
		//System.out.println(superbag.toString());
		
		String [] result1 = superbag.removeN(0);
		for(int index = 0; index < result1.length; index++)
		{
			System.out.println("result =" + result1[index]);
		}
		System.out.println("before report" + superbag.toString());
		System.out.println("first data=" + superbag.reportFirst());
		System.out.println("position =" + superbag.reportWhere("keisuke"));
		
		System.out.println("length Is " + superbag.lengthIs());
	//System.out.println("null ="null);
	StringNode bag= new StringNode("initString",null);
		bag.addNodeAfter("First");
		System.out.println(bag.toStringNode());
		bag.addNodeAfter("Second");
		System.out.println(bag.toStringNode());
		bag.addNodeAfter("Third");
		System.out.println(bag.toStringNode());
	
		StringNode first = new StringNode("initString2",null);
		System.out.println("init   = "+first.toStringNode());
		first.addNodeAfter("ichi");
		System.out.println("add 10 = "+first.toStringNode());
		first.addNodeAfter("ni");
		System.out.println("add 20 = "+first.toStringNode());
		first.addNodeAfter("san");
		System.out.println("add 30 = "+first.toStringNode());
		//IntNode lastNode = IntNode.listSearch(bag.getHead(), 10);
		
		StringNode lastNode=StringNode.getLast(first);
		System.out.println("last = "+lastNode.toStringNode());
		

		lastNode.addNodeAfter("last");
		//System.out.println("searched + 100 = "+searchedNode.toString2());
		System.out.println("first  = "+first.toStringNode());
		//bag.addMany(2,34,5,67,7);
		//bag.toString();
		//bag.grab();
		
		//test of addToEnd(IntNode, data)
		StringNode.addToEnd(first,"end");
		System.out.println("addtoend = "+first.toStringNode());
		
		//test of position(IntNode, data)
		System.out.println("position of 0 = "+StringNode.position(first, "ichi"));
		System.out.println("position of 30 = "+StringNode.position(first, "ni"));
		System.out.println("position of 40 = "+StringNode.position(first, "yon"));
		System.out.println("position of 1000 = "+StringNode.position(first, "end"));


		StringNode node = new StringNode(null, null);
		System.out.println(node.toStringNode());
		node.addNodeAfter("Keisuke");
		
		System.out.println(node.toStringNode());
		node.addNodeAfter("Kaori");
		//System.out.println(node.toStringNode());
		node.addNodeAfter("Midori");
		System.out.println(node.toStringNode());
		StringNode node2 = new StringNode(null, null);
		node2.addNodeAfter("Keisuke");
		node2.addNodeAfter("Kaori1");
		node2.addNodeAfter("Midori");
		System.out.println("equals =" + node.equals(node2));
		
	}

}
