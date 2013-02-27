
public class SuperList
{
	private StringNode head;
	private int manyNodes;
	
	SuperList()
	{
		head = null;
		manyNodes = 0;
	}
	boolean isEmpty()
	{
		if(manyNodes == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	boolean isFull()
	{
		try
		{
				SuperList list = new SuperList();
		}catch(Exception ex)
		{
			return true;
		}
		return false;
	}
	void insertFront(String newItem)
	{
		head = new StringNode(newItem, head);
		manyNodes++;
	}
	void insertRear(String newItem)
	{
		if(isFull())
		{
			throw new ListExseption("The list is full");
		}
		else
		{
			StringNode.addToEnd(head, newItem);
			manyNodes++;
		}
	}
	boolean removeOne(String item)
	{
		boolean remove = false;
		StringNode targetNode;//the node that contains the target
		targetNode = StringNode.listSearch(head, item);
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

	String removeFirst()
	{
		StringNode first;
		String firstData = "";
		if(isEmpty())
		{
			System.out.println("Nothing to remove since the list is empty");
		}
		else
		{
			 firstData = head.getData();
			//first = StringNode.listCopy(head.getLink());//get the second link
			head = head.getLink(); 
			//head = first;//replace it 
			
			 manyNodes--;
			 
		}
		return firstData;
	}

	String[] removeN(int N)
	{
		String [] result = new String[N];
		for(int index = 0; index < result.length; index++)
		{
			result[index] = "";
		}
		String firstData = "";
		
		for(int index = 0; index < N && head != null ; index++)
		{
			firstData = head.getData();//get the second link
			result[index] = firstData;
			head = head.getLink();
			manyNodes--;
		}
		return result;
	}

	String reportFirst()
	{
		return  head.getData();
	}

	int reportWhere(String item)
	{
		int where =0;
		where =StringNode.position(this.head, item);
		return where;
	}
	
	int lengthIs()
	{
		return StringNode.listLength(this.head);
	}
	
	public boolean equals(Object aList)
	{
		if(this.getClass() == aList.getClass())
		{
			if(this.manyNodes == ((SuperList)aList).manyNodes)
			{
				return this.equals(((SuperList)aList));
			}
			else
			{
				return false;
			}
		}
		else
		{
				return false;
		}
	
		
	}

	public String toString()
	{
		if(head == null)
		{
			return ("manyNode:"+String.valueOf(this.manyNodes)+" head: null"); 
		}
		else
		{
			return ("manyNode:"+String.valueOf(this.manyNodes) +" head:"+this.head.toStringNode ());
		}	
	}

}
