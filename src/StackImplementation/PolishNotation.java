package StackImplementation;

import java.util.Stack;

public class PolishNotation{
    int MAX = 50;
    Node top = null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    String postfix = "";
    String infix;
    long stack[] = new long[MAX];
    int tp = -1;
    PolishNotation(String s){
        this.infix = s;
    }
    void infix_to_postfix(){
        int i,p=0;
        char next;
        char symbol;
        Stack<Character> stk = new Stack<>();
        for(i=0;i<infix.length();i++){
            symbol = infix.charAt(i);
            if(!white_space(symbol)){
                switch (symbol){
                    case  '(':
                        stk.push(symbol);
                        break;
                    case ')':
                        while((next = stk.pop()) != '(')
                            postfix += next;
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                    case '%':
                    case '^':
                        while (!stk.isEmpty() && priority(stk.peek())>=priority(symbol))
                            postfix += stk.pop();
                        stk.push(symbol);
                        break;
                    default:
                        postfix += symbol;
                }
            }
            while(!stk.isEmpty())
                postfix += stk.pop();
        }
    }
    long eval_val(){
        long a,b,temp=0L,result;
        for(int i=0;i<postfix.length();i++){
            if(postfix.charAt(i) <= '9' && postfix.charAt(i) >= '0')
                push(postfix.charAt(i)-'0');
            else{
                a = pop();
                b = pop();
                switch(postfix.charAt(i)){
                    case '+':
                        temp = a+b;
                        break;
                    case '-':
                        temp = b-a;
                        break;
                    case '*':
                        temp = b*a;
                        break;
                    case '/':
                        temp = b/a;
                        break;
                    case '%':
                        temp = b%a;
                        break;
                    case '^':
                        temp = (long)Math.pow(b,a);
                }
                push(temp);
            }
        }
        result = pop();
        return result;
    }
    int priority(char symbol){
        switch (symbol){
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }
    boolean isEmpty(){
        if(tp == -1)
            return true;
        else
            return false;
    }
    boolean white_space(char symbol){
        if(symbol == ' ' || symbol == '\t')
            return true;
        else
            return false;
    }
    void push(long symbol){
        if(tp > MAX){
            System.out.println("Stack Overflow");
            return ;
        }
        stack[++tp] = symbol;
    }
    long pop(){
        if(isEmpty()){
            System.out.println("Stack Underflow");
            return -1L;
        }
        return stack[tp--];
    }
}