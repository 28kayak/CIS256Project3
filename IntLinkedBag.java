//An InteLinkedBag is a collection of int numbers
public class IntLinkedBag implements Cloneable 
{
	private IntNode head;
	private int manyNodes;
	
	
	//initialize an empty bag
	public IntLinkedBag()
	{
		head = null;
		manyNodes = 0;
	}
	//add a new element to this bag
	public void add(int element)
	{
		head = new IntNode(element, head);
		manyNodes++;
	}
	//add the contents of another bag to this bag
	//precondition--parameter added is not null.otherwise, NullPointerException is thrown
	public void addAll(IntLinkedBag addend)
	{
		IntNode[] copyInfo;
		if(addend.manyNodes > 0)
		{
			copyInfo = IntNode.listCopyWithTail(addend.head);
			copyInfo[1].setLink(head);//Link the tail of copy to my own head
			head = copyInfo[0];
			manyNodes += addend.manyNodes;
		}
		
	}
	//add new elements to this bag. If the new elements would take this bag beyond its current capacity,
	//then the capacity is increased before adding the new elements
	public void addMany(int... elements)
	{
		for(int i: elements)
		{
			add(i);//activate the ordinary add method for each integer in the elements array
		}
	}
	//generate a copy of this bag
	public IntLinkedBag clone()
	{
		//Clone a nIntLinkedBag object
		IntLinkedBag answer;
		try
		{
			answer = (IntLinkedBag) super.clone();
		}
		catch(CloneNotSupportedException e)
		{
			//if it happen, mean super.clone is not available
			throw new RuntimeException("this class does not implement Cloneable");
		}
		answer.head = IntNode.listCopy(head);
		return answer;
	}
	//Accessor method to count the number of occurrence of a particular element in this bag
	public int countOccurrences(int target)
	{
		int answer;
		IntNode cursor;
		answer = 0;
		cursor = IntNode.listSearch(head, target);
		while(cursor != null)
		{//each time that cursor is not null, we have another occurrence of target, 
			//so we add one to answer and then move cursor to the next occurrence of the target.
			answer++;
			cursor = cursor.getLink();
			cursor = IntNode.listSearch(cursor, target);
		}
		return answer;
	}
	//Accessor method to retrieve a random element from this bag
	public int grab()
	{
		int i;
		IntNode cursor;
		if(manyNodes == 0)
		{
			throw new IllegalStateException("Bag sixe is zero");
		}
		i = (int)(Math.random() * manyNodes) +1;
		cursor = IntNode.listPosirion(head, i);
		return cursor.getData();
	}
	//remove one copy of a specified element from this bag.
	public boolean remove(int target)
	{
		boolean remove = false;
		IntNode targetNode;//the node that contains the target
		targetNode = IntNode.listSearch(head, target);
		if(targetNode == null)//the target was not found
		{
			remove = false;
		}
		else
		{
			//copy the head data to targetNode and then remove the extra copy of the head data
			targetNode.setData(head.getData());
			head = head.getLink();
			manyNodes--;
			remove = true;
		}
		return remove;
	}
	//determine the number of elements in this bag
	public int size()
	{
		return manyNodes;
	}
	//create a new bag that contains all the elements from two other bags
	public static IntLinkedBag union(IntLinkedBag b1, IntLinkedBag b2)
	{
		//the precondition--neither b1 nor b2 is null
		//if one of them is null, then addAll method will throw a NullPointerEcseption
		IntLinkedBag answer = new IntLinkedBag();
		
		answer.addAll(b1);
		answer.addAll(b2);
		return answer;
	}
	public String toString()
	{
		String text;
		
		text = "TOSTRING ‚¾‚æ"; 
		return text;
	}
	public String toString2()
	{
		return ("manyNode:"+String.valueOf(this.manyNodes)+" head:"+this.head.toString2());

	}
}//class
