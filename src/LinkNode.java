package src;
/**
 * @author John Nairy Vardanyan
 * @version May 7, 2020
 * Class: CSC 20
 * Professor: Abida Mukkaram
 * Java Files: ChartHelper.java, LinkNode.java, TopTenList.java, TopTenMain.java
 * Text Files: Songs.txt
 */
public class LinkNode{
    int position;
    String songName;
    LinkNode next;
    public LinkNode(int pos,String song){
      position =pos;
      songName=song;
      next=null;
  
    }
    void addSong(String song){
      songName=song;
    }
    void addPosition(int pos){
      position =pos;
    }
    int getPosition(){
      return position;
  }
    void setPosition(int newpos){
       position=newpos;
    }
    String getSong(){
       return songName;
    }
    void setNext(LinkNode e){
       next=e;
    }
    LinkNode getNext(){
       return next;
    }
  }