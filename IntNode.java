//An IntNode provide a node for a linked list with integer data in each node
public class IntNode
{
	private int data;
	private IntNode link; 
	
	public IntNode(int initialData, IntNode initialLink)
	{
		data = initialData;
		link = initialLink;
	}
	public void addNodeAfter(int item)
	{
		link = new IntNode(item,link);
	}
	public int getData()
	{
		return data;
	}
	public IntNode getLink()
	{
		return link;
	}
	public static IntNode listCopy(IntNode source)
	{
		IntNode copyHead;
		IntNode copyTail;
		//handle the special case of the empty list
		if(source == null)
		{
			return null;
		}
		//make the 1st node for the newly created list
		copyHead = new IntNode(source.data, null);
		copyTail = copyHead;
		//make the rest of the nodes for the newly created list
		while(source.link != null)
		{
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		//return the head reference for the new list
		return copyHead;
		
	}
	public static IntNode[] listCopyWithTail(IntNode source)
	{
		IntNode copyHead;
		IntNode copyTail;
		IntNode[] answer = new IntNode[2];
		
		//Handle the 1st node for the empty list
		if(source == null)
		{
			return answer;
		}
		//make the 1st node for the newly created list
		copyHead = new IntNode(source.data, null);
		copyTail = copyHead;
		//make the rest of the nodes for the newly created list
		while(source.link != null)
		{
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		//Return the head and tail references
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
				
	}
	public static int listLength(IntNode head)
	{
		IntNode cursor;
		int answer;
		
		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			answer++;
		}
		return answer;
	}
	public static IntNode[] listPart(IntNode start, IntNode end)
	{
		IntNode copyHead;
		IntNode copyTail;
		IntNode cursor;
		IntNode[] answer = new IntNode[2];
		//make the first node for the newly created list. 
		//Notice that this will cause a NullPointerException if start is null.
		copyHead = new IntNode(start.data, null);
		copyTail = copyHead;
		cursor = start;
		//make the rest of the nodes for the newly created list
		while(cursor != end)
		{
			cursor = cursor.link;
			if(cursor == null)
			{
				throw new IllegalArgumentException("End node was not found on the list");
			}
			copyTail.addNodeAfter(cursor.data);
			copyTail = copyTail.link;
		}
		//return the head and tail references
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}
	public static IntNode listPosirion(IntNode head, int position)
	{
		IntNode cursor;
		int i;
		if(position <= 0)
		{
			throw new IllegalArgumentException("position is not positive");
		}
		cursor = head;
		for(i = 1; (i < position)&&(cursor != null); i++)
		{
			cursor = cursor.link;
		}
		return cursor;
	}
	public static IntNode listSearch(IntNode head, int target)
	{
		IntNode cursor;
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			if(target == cursor.data)
			{
				return cursor;
			}
		}
		return null;
	}
	public void removeNodeAfter()
	{
		link = link.link;
	}
	public void setData(int newData)
	{
		data= newData;
	}
	public void setLink(IntNode newLink)
	{
		link = newLink;
	}
	public static int position(IntNode head, int target)
	{
		IntNode cursor;
		int position=-1;
		
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			position++;
			if(target == cursor.data)
			{
				return position;
			}
		}
		return -1;
	}
	public static IntNode getLast(IntNode head)
	{
		IntNode cursor;
		IntNode previouscursor;
		int answer;
		previouscursor=head;
		answer = 0;
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			previouscursor = cursor;
			answer++;
		}
		return previouscursor;
	}
	public static IntNode addToEnd(IntNode head,int item)
	{
		IntNode cursor;
		IntNode previouscursor;
		
		previouscursor=head;
		
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			previouscursor = cursor;
		}
		
		previouscursor.link = new IntNode(item,  null);
		return head;
	}
	public String toString2()
	{
		if (this.link==null)
			return "(data:"+String.valueOf(data)+" , link:null)";
		else
			return "(data:"+String.valueOf(data)+" , link:"+this.link.toString2()+")";
		
	}
}//class
