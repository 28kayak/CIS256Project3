
public class IntLinkedListMain
{
	public static void main(String [] args)
	{
		IntLinkedBag bag = new IntLinkedBag();
		
		bag.add(10);
		System.out.println(bag.toString2());
		bag.add(20);
		System.out.println(bag.toString2());
		bag.add(30);
		System.out.println(bag.toString2());
		
		IntNode first = new IntNode(0,null);
		System.out.println("init   = "+first.toString2());
		first.addNodeAfter(10);
		System.out.println("add 10 = "+first.toString2());
		first.addNodeAfter(20);
		System.out.println("add 20 = "+first.toString2());
		first.addNodeAfter(30);
		System.out.println("add 30 = "+first.toString2());
		//IntNode lastNode = IntNode.listSearch(bag.getHead(), 10);
		
		IntNode lastNode=IntNode.getLast(first);
		System.out.println("last = "+lastNode.toString2());
		

		lastNode.addNodeAfter(100);
		//System.out.println("searched + 100 = "+searchedNode.toString2());
		System.out.println("first  = "+first.toString2());
		//bag.addMany(2,34,5,67,7);
		//bag.toString();
		//bag.grab();
		
		//test of addToEnd(IntNode, data)
		IntNode.addToEnd(first,1000);
		System.out.println("addtoend = "+first.toString2());
		
		//test of position(IntNode, data)
		System.out.println("position of 0 = "+IntNode.position(first, 0));
		System.out.println("position of 30 = "+IntNode.position(first, 30));
		System.out.println("position of 40 = "+IntNode.position(first, 40));
		System.out.println("position of 1000 = "+IntNode.position(first, 1000));
		
	}
}
