/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsa;
import java.util.*;

/**
 *
 * @author priya
 */

class DynamicArray<T>{
    static final int initialcapacity = 3;
    private int capacity;
    private int size;
    private T arr[];
    @SuppressWarnings("unchecked")
    DynamicArray(){
        size=0;
        arr = (T[]) new Object[initialcapacity];
        capacity= initialcapacity;
    }
    
    public void add(T data){
        if(size==capacity)
            expandArray();
        arr[size++]=data;
    }
    
    private void expandArray(){
        capacity *= 2;
        arr = java.util.Arrays.copyOf(arr,capacity);
    }
    
    public void display(){
        int i;
        System.out.println("***********************");
        System.out.println("DATA");
        System.out.println("***********************");
        for(i=0;i<size;i++){
            System.out.println(arr[i]);
        }
        System.out.println("************************");
    }
    
    public void addAtPos(T val,int pos){
        int i;
        if(size==capacity)
            expandArray();
        for(i=size-1;i>=pos;i--){
            arr[i+1]=arr[i];
        }
        arr[pos]=val;
        size++;
    }
    
    public void delAtPos(int pos){
        int i;
        if(size==0)
            System.out.println("list empty");
        else{
            for(i=pos+1;i<size;i++)
            {
                arr[i-1]=arr[i];
            }
            size--;
        }
        
        if(capacity>initialcapacity && capacity > 3*size){
            shrinkArray();
        }
    }
    
    private void shrinkArray(){
        capacity /= 2;
        arr = java.util.Arrays.copyOf(arr,capacity);
    }
    
    public void delEnd(){
        if(size==0){
            System.out.println("list empty");
        }
        else
            arr[size--]=null;
    }
    
    public void delBegin(){
        int i;
        if(size==0){
            System.out.println("list empty");
        }
        else{
           for(i=1;i<size;i++){
            arr[i-1]=arr[i];
           }   
           size--; 
        }   
    }
    
    public void getIndex(int index){
        if(index>=size || index<0){
            System.out.println("invalid index");
        }
        else{
            System.out.println("the data is"+arr[index]);         
        }     
    }
    
    public void updateIndex(int index,T val){
        if(index>=size || index<0){
            System.out.println("invalid index");
        }
        else{
            arr[index]=val;
        }
    }
    
    public void search(T val){
        int i;
        int flag=0;
        for(i=0;i<size;i++)
        {
            if(arr[i]==val){
                System.out.println("element found at "+i+"th index");
                flag=1;
            }
        }
        if(flag==0){
            System.out.println("element not found");
        }
    }
    
    public void clear(){
        int i;
        for(i=0;i<size;i++)
        {
            arr[i]=null;
        }
        size=0;
        shrinkArray();
    }
    
    public void details(){
        System.out.println("size :"+size);
        System.out.println("capacity :"+capacity);
    }
}
public class DSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DynamicArray<Integer> list = new DynamicArray<Integer>();
        int choice,flag=1,val;
        while(flag==1){
            System.out.println("1. insert ");
            System.out.println("2. insert at gn position");
            System.out.println("3. display");
            System.out.println("4. delete at gn position");
            System.out.println("5. delete at end");
            System.out.println("6. delete from beginning");
            System.out.println("7. Get value in index");
            System.out.println("8. update value in index");
            System.out.println("9. search a value");
            System.out.println("10. clear the list");
            System.out.println("11. details about list");
            System.out.println("12. exit");
            System.out.println("enter ur choice:");
            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter the data");
                    val = in.nextInt();
                    list.add(val);
                    break;
                case 2:
                    System.out.println("enter position");
                    int pos = in.nextInt();
                    System.out.println("Enter the data");
                    val = in.nextInt();
                    list.addAtPos(val,pos);
                    break;
                case 3:
                    list.display();
                    break;
                case 4:
                    System.out.println("enter position");
                    pos = in.nextInt();
                    list.delAtPos(pos);
                    break;
                case 5:
                    list.delEnd();
                    break;
                case 6:
                    list.delBegin();
                    break;
                case 7:
                    System.out.println("enter the index");
                    int index = in.nextInt();
                    list.getIndex(index);
                    break;
                case 8:
                    System.out.println("enter the index");
                    index = in.nextInt();
                    System.out.println("enter new value");
                    val = in.nextInt();
                    list.updateIndex(index,val);
                    break;
                case 9:
                    System.out.println("enter the data to be searched");
                    val = in.nextInt();
                    list.search(val);
                    break;
                case 10:
                    list.clear();
                    break;
                case 11:
                    list.details();
                    break;
                case 12:
                    flag=0;
                    break;
                default:
                    System.out.println("enter valid choice");
                    break;
            }
        }
        
      
      
    }
    
}
