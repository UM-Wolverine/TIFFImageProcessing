package project1;

public class DList {
	
	protected int size = 0;
	protected DListNode head;
	protected DListNode tail;
	
	
	public DList(){
		head = null;
		tail = null;
	}
	public Boolean isEmpty(){
		return size == 0;
	}
	public int getLength(){
		return size;
	}
	public void insertEnd(int[] pix){
		DListNode newListNode = new DListNode(pix);
		if(isEmpty()){
			head = newListNode;
			
		}else if(tail.pix[0] == pix[0]){
			tail.pix[3]++;
			return;
		}else{
			
			tail.next = newListNode;
			newListNode.prev = tail;
		}
		tail = newListNode;
		size++;	
	}
	public void insertCurrFront(DListNode curr, int[] pix){
		DListNode newListNode = new DListNode(pix);
		if(curr == null){
			curr = newListNode;
		}
		else{
			if(curr == head){
				head.prev = newListNode;
				newListNode.next = head;
				head = newListNode;
				size++;
				return;
			}
			newListNode.next = curr;
			curr.prev.next = newListNode;
			newListNode.prev = curr.prev;
			curr.prev = newListNode;			
		}	
		
		size++;	
	}
	public void insertCurrAfter(DListNode curr, int[] pix){
		DListNode newListNode = new DListNode(pix);
		if(curr == null){
			curr = newListNode;
			
		}else{
			if(curr.next != null){
				if(curr.next.pix.equals(pix)){
					curr.next.pix[3]++;
					return;
				}
				newListNode.next = curr.next;
				curr.next.prev = newListNode;
				curr.next = newListNode;
				newListNode.prev = curr;
		
			}else{
				insertEnd(pix);
				return;
			}
		}
		size++;		
	}
	public void setCurrFront(DListNode curr, int[] pix) {
		if(curr.pix[0] == pix[0])
			return;
		if(curr.prev != null && curr.prev.pix[0] == pix[0]){
			curr.pix[3]--;
			curr.prev.pix[3]++;
		}
		else if(curr == head){
			curr.pix[3]--;
			inserFront(pix);
		}else{
			DListNode newListNode = new DListNode(pix);
			curr.pix[3]--;
			curr.prev.next = newListNode;
			newListNode.prev = curr.prev;
			newListNode.next = curr;
			curr.prev = newListNode;
		}
		
		if(curr.pix[3] == 0){
			if(curr.next == null){
				curr.prev.next = null;
				tail = curr.prev;
				return;
			}
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			curr = curr.next;
			if(curr != null && curr.pix[0] == pix[0]){
				curr.prev.pix[3]++;
				curr.prev.next = curr.next;
				if(curr.next != null){
					curr.next.prev = curr.prev;
				}
				curr = curr.next;
				size--;
			}
			size--;
		}
		
	}
	public void inserFront(int[] pix) {
		DListNode newListNode = new DListNode(pix);
		if(isEmpty()){
			head = newListNode;
			tail = head;
		}else{
			head.prev = newListNode;
			newListNode.next = head;
			head = newListNode;
		}
		size++;
	}
	public void setCurrAfter(DListNode curr, int[] pix) {
		if(curr.pix[0] == pix[0])
			return;
		if(curr.next != null && curr.next.pix[0] == pix[0]){
			curr.pix[3]--;
			curr.next.pix[3]++;
		}else if(curr.next == null){
			curr.pix[3]--;
			insertEnd(pix);
		}else{
			
			DListNode newListNode = new DListNode(pix);
			curr.pix[3]--;
			curr.next.prev = newListNode;
			newListNode.next = curr.next;
			newListNode.prev = curr;
			curr.next = newListNode;
		}
		if(curr.pix[3] == 0){
			if(curr.prev == null){
				curr.next.prev = null;
				head = curr.next;
				return;
			}
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
			curr = curr.prev;
			if(curr.prev != null && curr.prev.pix[0] == pix[0]){
				curr.next.pix[3]++;
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
				curr = curr.prev;
				size--;
			}
			size--;
		}
	}
	public void splitCurr(DListNode curr, int pixNumber, int[] pix) {
		if(curr.pix[0] == pix[0])
			return;
		int[] pixTemp = new int[4];
		pixTemp[0] = curr.pix[0];
		pixTemp[1] = curr.pix[1];
		pixTemp[2] = curr.pix[2];
		pixTemp[3] = curr.pix[3]-pixNumber;
		curr.pix[3] -= pixNumber;
		DListNode tempListNode = new DListNode(pixTemp);
		DListNode newListNode = new DListNode(pix);
		
		curr.next.prev = tempListNode;
		tempListNode.next = curr.next;
		tempListNode.prev = newListNode;
		newListNode.prev = curr;
		newListNode.next = tempListNode;
		curr.next = newListNode;
		if(curr == tail)
			tail = tempListNode;
	}
	
}
