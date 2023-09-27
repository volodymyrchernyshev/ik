package org.ik.recursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class BinaryStringsOfLengthN {



    @Test
    public void testSt(){
        System.out.println(numberOfWays("001101"));
    }

    static class Frame{
        String st;
        int i;
        public Frame(String st, int i){
            this.st = st;
            this.i=i;
        }

        @Override
        public String toString() {
            return "Frame{" +  "st='" + st + '\'' + ", i=" + i + '}';
        }
    }
    public long numberOfWays(String s) {


        Stack<Frame> stack = new Stack<>();
        stack.push(new Frame("", 0));
        stack.push(new Frame(""+s.charAt(0), 0));
        long ret = 0;
        while(!stack.isEmpty()){
            Frame frame = stack.pop();
            String st = frame.st;
            if(st.length() == 3){
                ret++;
                continue;
            }

            int i = frame.i +1;
            if(i >= s.length()){
                continue;
            }
            char c = s.charAt(i);

            if(st.isEmpty() || st.charAt(st.length() - 1) != c) {
                stack.push(new Frame(st + c, i));
            }
            stack.push(new Frame(st, i));
        }
        return ret;
    }


//    @Test
    public void test() {
        System.out.println(get_binary_strings(3));
    }

//    @Test
    public void testNoRecursion() {
        System.out.println(get_binary_stringsNoRecursion(10));
    }



    private ArrayList<String> get_binary_stringsNoRecursion(int n) {
        ArrayList<String> ret = new ArrayList<>();
        Stack<String> stack = new Stack();
        stack.push("0");
        stack.push("1");
        int maxStack = 0;
        while(!stack.isEmpty()){
            maxStack = Math.max(maxStack, stack.size());
            String str = stack.pop();
            if(str.length() == n){
                ret.add(str);
            } else {
                stack.push(str+"0");
                stack.push(str+"1");
            }
        }

        System.out.println("maxStack:" + maxStack );
        return ret;
    }

    enum OperationType {
        ZERO, ONE;
    }

    enum OperationState {
        IN, CLEANUP, APPEND1, APPEND0, OUT;
    }

    static class Operation {
        int index;
        OperationType type;
        OperationState state;

        public Operation(int index, OperationType type, OperationState state) {
            this.index = index;
            this.type = type;
            this.state = state;
        }

        @Override
        public String toString() {
            return "Operation{" + "index=" + index + ", type=" + type + ", state=" + state + '}';
        }
    }

    private ArrayList<String> get_binary_stringsNoRecursion5(int n) {
        ArrayList<String> ret = new ArrayList<>();
        Stack<Operation> stack = new Stack();
        StringBuilder slate = new StringBuilder();


        stack.push(new Operation(0, OperationType.ONE, OperationState.CLEANUP));
        stack.push(new Operation(0, OperationType.ONE, OperationState.APPEND1));



        for (int i = 0; i < 20 && !stack.isEmpty(); i++) {

            Operation op = stack.peek();
            if (op.index == n) {
                System.out.println(slate.toString());
                ret.add(slate.toString());
                stack.pop();
                stack.peek().state =  OperationState.OUT;
            } else if (op.state == OperationState.CLEANUP) {
                stack.pop();
                slate.delete(op.index, op.index + 1);
            }

        }
        return ret;
    }

    private ArrayList<String> get_binary_stringsNoRecursion3(int n) {

        ArrayList<String> ret = new ArrayList<>();

        Stack<Operation> stack = new Stack();

        createNewOps(stack, 0);
        StringBuilder slate = new StringBuilder();

        for (int i = 0; i < 20 && !stack.isEmpty(); i++) {
            System.out.println(stack);
            System.out.println("slate " + slate);
            Operation op = stack.peek();

            if (op.state == OperationState.CLEANUP) {
                stack.pop();
                slate.delete(op.index, op.index + 1);
                if(op.type == OperationType.ONE){
                    stack.peek().state = OperationState.OUT;
                }
            } else if (op.state == OperationState.OUT) {
                stack.pop();
            } else {
                //exit point
                if (op.index == n) {
                    System.out.println(slate.toString());
                    ret.add(slate.toString());
                    stack.pop();
                    stack.peek().state =  OperationState.OUT;
                }  else if (op.type == OperationType.ONE) {
                    slate.append('1');
                    stack.push(new Operation(op.index , OperationType.ONE, OperationState.CLEANUP));
                    stack.push(new Operation(op.index + 1, OperationType.ONE, OperationState.IN));
                } else if (op.type == OperationType.ZERO) {
                    slate.append('0');
                    stack.push(new Operation(op.index, OperationType.ZERO, OperationState.CLEANUP));
                    stack.push(new Operation(op.index + 1, OperationType.ZERO, OperationState.IN));
                }
            }
        }


        return ret;
    }

    private static void createNewOps(Stack<Operation> stack, int index) {
        stack.push(new Operation(index, OperationType.ONE, OperationState.CLEANUP));
        stack.push(new Operation(index, OperationType.ONE, OperationState.IN));
    }

    private ArrayList<String> get_binary_stringsNoRecursion2(int n) {

        ArrayList<String> ret = new ArrayList<>();

        Stack<Operation> stack = new Stack();

        stack.push(new Operation(0, OperationType.ONE, OperationState.IN));
        StringBuilder slate = new StringBuilder();

        for (int i = 0; i < 20 && !stack.isEmpty(); i++) {
            System.out.println(stack);
            Operation op = stack.peek();
            if (op.type == OperationType.ONE) {
                if (op.state == OperationState.IN) {
                    if (op.index >= n) {
                        //exit
                        System.out.println(slate.toString());
                        ret.add(slate.toString());
                        stack.pop();
                        stack.peek().state = OperationState.OUT;
                    } else {
                        stack.push(new Operation(op.index + 1, OperationType.ONE, OperationState.IN));
                        slate.append('1');
                    }
                } else {
                    stack.peek().type = OperationType.ZERO;
                    //stack.pop();
                    slate.delete(op.index, op.index + 1);
                    stack.push(new Operation(op.index + 1, OperationType.ZERO, OperationState.IN));
                    slate.append('0');
                }
            } else {
                if (op.state == OperationState.IN) {
                    if (op.index >= n) {
                        //exit
                        System.out.println(slate.toString());
                        ret.add(slate.toString());
                        stack.pop();
                        stack.peek().state = OperationState.OUT;
                    } else {
                        stack.push(new Operation(op.index + 1, OperationType.ONE, OperationState.IN));
                        slate.append('1');
                    }
                } else {
                    stack.pop();
                    slate.delete(op.index, op.index + 1);
                    stack.peek().state = OperationState.OUT;
                }
            }
        }
        return ret;
    }


    static ArrayList<String> get_binary_strings(Integer n) {
        ArrayList<String> ret = new ArrayList<>();
        get_binary_strings(ret, new StringBuilder(), 0, n);
        return ret;
    }

    static void get_binary_strings(ArrayList<String> ret, StringBuilder slate, int index, int n) {
        if (index == n) {
            ret.add(slate.toString());
            return;
        }
        slate.append("0");
        get_binary_strings(ret, slate, index + 1, n);
        slate.delete(index, index + 1);
        slate.append("1");
        get_binary_strings(ret, slate, index + 1, n);
        slate.delete(index, index + 1);
    }


}
