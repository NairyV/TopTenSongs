package src;
/**
 * @author John Nairy Vardanyan
 * @version May 7, 2020
 * Class: CSC 20
 * Professor: Abida Mukkaram
 * Java Files: ChartHelper.java, LinkNode.java, TopTenList.java, TopTenMain.java
 * Text Files: Songs.txt
 */
import java.io.*;
import java.util.*;

public class TopTenList{
public final static int MAX=10;
private
LinkNode front=null;
LinkNode current=null;
int count=0;
  public TopTenList(){
   front=null;
  }
  public TopTenList(String fileName)throws FileNotFoundException{
    Scanner file = new Scanner (new File(fileName));
    while (file.hasNextLine()){
      count++;
      String name=file.nextLine().trim();
      LinkNode element = new LinkNode(count,name);
      //System.out.println(name);
      if (front ==null )
         {
           front= element;
           current=element;
         }
      else current.setNext(element);
      current=element;
      //System.out.println(current.getSong());
    }

  }
  void printChart(){
    System.out.println("\n***** TOP TEN CHART **********\n");
    current=front;

   
    for (int i=1;i<=count;i++){    
      System.out.printf("%4d%26s\n",current.getPosition(),current.getSong());
      current = current.getNext();
    }
    
  }

 String getSong(int position){
   String name ="ERROR";
   LinkNode t =front;
    if (position <1 || position > count)
     return name;
    else {
      for (int i=1;i<position;i++)
          t=t.getNext();
      name = t.getSong();
      return name;
    }
 }
 int getPosition(String song){
   current =front;
   int pos =0;
   while(current!=null){
      if (current.getSong().equalsIgnoreCase(song))
          pos = current.getPosition();
      current=current.getNext();
   }
      
   return pos;
 }
 void adjustPosition(LinkNode e,int position){
   if (e!=null)
    while (e!=null){
      e.setPosition(e.getPosition()+position);
      e=e.getNext();
    }
 }
/**
 * 
 * @param position gets the position to delete the song
 * @return
 */
 boolean deleteSong(int position){
	 current = front; // Sets starting point to head of node
	 LinkNode pos = null;
	 if(position <= 0) { // If position is less than 1, output error and return false
		 System.out.println("\n Invalid entry");
		 return false;
	 }
	if (position == 1) {
		 count--;
		 front = front.next;
		 adjustPosition(front,-1);
		} else {
		    while (current.next != null) { //While has value, continue
		        if (current.next.position == position) {
		        	count--;
		        	current.next = current.next.next;
		            pos = current.next; // gets the node it ended on to sort position
		        } else {
		        	current = current.next;
		        }
		    }
		    while(pos!=null) { //sorts position
		    	pos.setPosition(pos.getPosition()-1);
		    	pos = pos.next;
		    }	
		}
   return true;
 }
 /**
  * 
  * @param position to input in song position
  * @param song is the name of the song
  */
 boolean insertSong(int position,String song){
	 current = front;
	 LinkNode element = new LinkNode(position,song); // new node with position and song
	 int pos = MAX - position;
	 if(front.position == position) {
		 count++;
		 element.next = front;
		 front = element;
		 adjustPosition(front,0);
	 } else {
		 while(current.next != null) {
		 if(current.next.position == position) {
			count++;
			element.next = current.next; // connects the new node to its proper position
			current.next = element;
			break;
		 }
		 current = current.next;
		 }
	 }
	 if(current.getPosition() != position) { // gets the node after the new node
		 current = current.next;
	 }
	 adjustPosition(current.next,1); // adjusts the position
	 if(count > MAX) { // If count is greater than the max amount, call deleteSong method to remove
		 //last element
		deleteSong(count);
	 }
	 return true; //change this as needed
 }
 /**
  * Method moves song to a new position in the last
  * @param oldPosition
  * @param newPosition
  */
 boolean moveSong(int oldPosition, int newPosition){
   current = front;
   String oldSong = getSong(oldPosition); //gets song names
   String newSong = getSong(newPosition);
   System.out.println(oldSong);
   System.out.println(newSong);
   /**
    * Sets song name to its new position if the position is found in the List
    */
   if(oldPosition == 1) {
	   front.songName = newSong;
   } else {
	   while(current.next!=null) {
		   if(current.next.position == oldPosition) {
			   current.next.songName = newSong;
		   }
		   current = current.next;
	   }
   }
   /**
    * Same as above
    */
   current = front;
   if(newPosition == 1) {
	   front.songName = oldSong;
   } else {
	   while(current.next!=null) {
		   if(current.next.position == newPosition) {
			   current.next.songName = oldSong;
		   }
		   current = current.next;
	   }
   }
   
   return true; //change this as needed
 }

}