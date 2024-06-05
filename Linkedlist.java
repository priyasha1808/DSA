/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;
import java.util.*;
/**
 *
 * @author priya
 */
class Llist{
    Node head;
    class Node{
        int data;
        Node next;
        
        Node(int val){
            data = val;
            next = null;
        }
    }
    Llist(){
        head = null;
    }
    
    public void insertAtBegin(int val){
        Node newnode = new Node(val);
        if(head==null){
            head = newnode;
        }
        else{
            newnode.next=head;
            head=newnode;
        }
    }
    
    public void display(){
        Node temp = head;
        System.out.println("**************************");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println(" ");
        System.out.println("**************************");
    }
    
    public void insertAtPos(int val,int pos){
        Node newnode = new Node(val);
        Node temp = head;
        if(pos==0)
        {
            insertAtBegin(val);
            return;
        }
        for(int i=0;i<pos-1;i++)
        {
            temp = temp.next;
            if(temp==null){
                throw new IllegalArgumentException("invalid position");
            }
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }
    
    public void deleteAtPos(int pos){
        if(head==null){
            throw new IndexOutOfBoundsException("deletion in empty list");
        }
        if(pos==0){
            head=head.next;
            return ;
        }
        
        Node prev = null;
        Node temp = head;
        for(int i=1;i<pos;i++){
            prev = temp;
            temp=temp.next;
        }
        prev.next = temp.next;
        
    }
    
    public void getIndex(int pos){
        
        if(head==null){
            System.out.println("list empty");
            return ;
        }
        if(pos>=0){
            Node temp =head;
            for(int i=1;i<pos;i++){
                temp=temp.next;
            }
            if(temp==null){
                throw new IndexOutOfBoundsException();
            }
            System.out.println("the value is"+temp.data);
        }
        else{
            System.out.println("invalid position");
        }
    }
    
    public void updateAtPos(int val,int pos){
        if(head==null){
            System.out.println("list empty");
            return ;
        }
        if(pos>=0){
            Node temp =head;
            for(int i=1;i<pos;i++){
                temp=temp.next;
            }
            if(temp==null){
                throw new IndexOutOfBoundsException();
            }
            temp.data=val;
        }
        else{
            System.out.println("invalid position");
        }
        
    }
    
    public void deleteAtEnd(){
        if(head==null){
            System.out.println("list empty");
            return;
        }
        if(head.next==null){
            head=null;
            return ;
        }
        Node temp =head;
        Node prev = null;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
    }
    
    public void insertAtEnd(int val){
        Node newnode = new Node(val);
        if(head==null){
            head= newnode;
        }
        else{
            Node temp= head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next = newnode;
        }
    }
    
    public void search(int val){
        Node temp = head;
        int count=-1,flag=0;
        while(temp!=null){
            count++;
            
            if(temp.data==val){
                System.out.println("value found at "+count+"th index");
                flag=1;
                return;
            } 
            temp=temp.next;
        }
        if(flag==0){
            System.out.println("value not found");
        }
    }
}
public class Linkedlist {
    public static void main(String args[]){
        Llist l = new Llist();
        Scanner in = new Scanner(System.in);
        int choice;
        int flag=1,val;
        while(flag==1){
            System.out.println("1. insert at beginning");
            System.out.println("2. display");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. get data in index");
            System.out.println("6. update at position");
            System.out.println("7. delete at end");
            System.out.println("8. insert at end");
            System.out.println("9. search value");
            System.out.println("10. exit");
            System.out.println("enter choice");
            choice = in.nextInt();
            switch(choice){
                case 1:
                    System.out.println("enter the value");
                    val = in.nextInt();
                    l.insertAtBegin(val);
                    break;
                case 2:
                    l.display();
                    break;
                case 3:
                    System.out.println("enter position");
                    int pos = in.nextInt();
                    System.out.println("enter value");
                    val = in.nextInt();
                    l.insertAtPos(val,pos);
                    break;
                case 4:
                    System.out.println("enter position");
                    pos=in.nextInt();
                    l.deleteAtPos(pos);
                    break;
                case 5:
                    System.out.println("enter position");
                    pos = in.nextInt();
                    l.getIndex(pos);
                    break;
                case 6:
                    System.out.println("enter position");
                    pos = in.nextInt();
                    System.out.println("enter value");
                    val = in.nextInt();
                    l.updateAtPos(val,pos);
                    break;
                case 7:
                    l.deleteAtEnd();
                    break;
                case 8:
                    System.out.println("enter value");
                    val = in.nextInt();
                    l.insertAtEnd(val);
                    break;
                case 9:
                    System.out.println("enter value");
                    val = in.nextInt();
                    l.search(val);
                    break;
                case 10:
                    flag=0;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
            
    }
}
