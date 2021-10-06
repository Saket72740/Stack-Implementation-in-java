package StackImplementation;

public class MyStack<E> {
    int size = 0;
    Node<E> top = null;
    class Node<E>{
        E data;
        Node next;
        Node(E d){
            this.data = d;
            next = null;
        }
    }
    boolean isEmpty(){
        if(top == null)
            return true;
        else
            return false;
    }
    void push(E data){
        Node<E> newNode = new Node<E>(data);
        size++;
        if(top == null) {
            top = newNode;
            return ;
        }
        newNode.next = top;
        top = newNode;
    }
    E pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            return null;
        }
        size--;
        Node<E> temp = top;
        top = top.next;
        return temp.data;
    }
    E DisplayTop(){
        return top.data;
    }
    void Display(){
        Node<E> temp;
        for(temp = top; temp.next != null; temp = temp.next){
            System.out.print(temp.data + " ");
        }
        System.out.println(temp.data);
    }
}
