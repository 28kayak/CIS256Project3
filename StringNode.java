
public class StringNode 
{
	private String data;
	private StringNode link;
	
	public StringNode(String initialData, StringNode initialLink)
	{
		data = initialData;
		link = initialLink;
	}
	public void addNodeAfter(String item)
	{
		link = new StringNode(item, link);
	}
	public String getData()
	{
		return data;
	}
	public StringNode getLink()
	{
		return link;
	}
	public static StringNode listCopy(StringNode source)
	{
		StringNode copyHead;
		StringNode copyTail;
		
		if(source == null)
		{
			return null;
		}
		//make the first node for the empty list
		copyHead = new StringNode(source.data, null);
		copyTail = copyHead;
		//make the rest nodes for the newly created list
		while(source.link != null)
		{
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		//return the head reference for the new list
		return copyHead;
	}
	public static StringNode[] listCopyWithTail(StringNode source)
	{
		StringNode copyHead;
		StringNode copyTail;
		StringNode[] answer = new StringNode[2];
		
		//Handle the special case of the empty list
		if(source == null)
		{
			return answer;//this ans has two null reference
		}
		//make the first node for the newly created list
		copyHead = new StringNode(source.data, null);
		copyTail = copyHead;
		
		//make the rest of the nodes for the newly created list
		while(source.link != null)
		{
			copyTail = copyTail.link;
		}
		//return the head and tail references 
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}
	public static int listLength(StringNode head)
	{
		StringNode cursor;
		int answer;
		
		answer = 0;
		for(cursor = head; cursor != null ; cursor = cursor.link)
		{
			answer++;
		}
		return answer;
	}
	public static StringNode[] listPart(StringNode start, StringNode end)
	{
		StringNode copyHead;
		StringNode copyTail;
		StringNode cursor;
		StringNode [] answer = new StringNode[2];
		
		copyHead = new StringNode(start.data, null);
		copyTail = copyHead;
		cursor = start;
		
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
	public static StringNode listPosition(StringNode head, int position)
	{
		StringNode cursor;
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
	public static StringNode listSearch(StringNode head, String target)
	{
		StringNode cursor;
		
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			if(target.equals(cursor.data))
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
	public void setData(String newData)
	{
		data = newData;
	}
	public void setLink(StringNode newLink)
	{
		link = newLink;
	}
	//added method
	public static StringNode addToEnd(StringNode head, String newVal)
	{
		StringNode cursor;
		StringNode previouscursor;
		
		previouscursor=head;
		
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			previouscursor = cursor;
		}
		
		previouscursor.link = new StringNode(newVal,  null);
		return head;
		
	}
	public static int position(StringNode head, String newVal)
	{
		StringNode cursor;
		int position = -1;
		for(cursor = head; cursor != null; cursor =cursor.link)
		{
			position++;
			if(newVal == cursor.data)
			{
				return position;
			}
			
		}
		return -1;
	}
	public String toStringNode()
	{
		if(this.link == null)
		{
			if(this.data == null)
			{
				return "lastnode:(null, null)";
			}
			else
			{	
				return "lastnode:(" + data + ",null)";//the last node
			}
		}
		else 
		{
			return "nodes:(" + data + ", "+ this.link.toStringNode() + ")";
		}
	}
	public static StringNode getLast(StringNode head)
	{
		StringNode cursor;
		StringNode previouscursor;
		previouscursor=head;
		
		for(cursor = head; cursor != null; cursor = cursor.link)
		{
			previouscursor = cursor;
		}
		return previouscursor;
	}
	public boolean equals(StringNode node)
	{
		StringNode cursor1;
		StringNode cursor2;
		boolean equals = false;
		if(StringNode.listLength(this) == StringNode.listLength(node))
		{
			System.out.println("length is same");
			cursor1 = node.link;
			cursor2 = this.link;
			for(int index =0; index < StringNode.listLength(this.link); index++)
			{	System.out.println(index);
			
				if(cursor1.getData().equals(cursor2.getData()))
				{
					System.out.println("getData() is ture") ;
				}
				else
				{
					System.out.println("getData() is false");
					return equals = false;
				}
				cursor1 = cursor1.link;
				cursor2 = cursor2.link;
			}
			return equals = true;
		}
		else
		{
			System.out.println("length is not same");
			System.out.println("cursor1=" + StringNode.listLength(this.link));
			System.out.println("cursor2=" + StringNode.listLength(node));
			return equals = false;
		}
		
	}
}//class
