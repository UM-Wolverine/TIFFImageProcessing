package project1;

public class DListNode {
	int[] pix = new int[4];
	DListNode next;
	DListNode prev;

	DListNode(int[] pix){
		this.pix[0] = pix[0];
		this.pix[1] = pix[1];
		this.pix[2] = pix[2];
		this.pix[3] = pix[3];
		next = null;
		prev = null;
	}
	public int getRunLength(){
		return pix[3];
	}
}
