package com.lurran.algorithms.algorithms;

import com.lurran.algorithms.dataStructrue.Stack;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2021/9/21 3:17 下午
 */
public class Calculator extends Stack {


    public static void main(String[] args) {
        String expression="3+2*6-2";
        Calculator numStack=new Calculator();
        Calculator operStack=new Calculator();
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';
        while (true){
            ch=expression.substring(index,index+1).charAt(0);
            if (operStack.isOper(ch)){
                if (operStack.isEmpty()){
                    operStack.push(ch);
                    // operStack.pop();
                }else {
                    if (operStack.priority(ch) <= operStack.priority((char) operStack.peak())) {
                        num1=(int)numStack.pop();
                        num2=(int)numStack.pop();
                        System.out.println("为小于是时候");
                        for (Object o : operStack) {
                            System.out.println(o);
                        }
                        oper=(char)operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                        System.out.println("为大于是时候");
                        for (Object o : operStack) {
                            System.out.println(o);
                        }
                    }
                }
            }else {
                numStack.push(ch-48);
            }
            index++;
            if (index>=expression.length()){
                break;
            }
        }
        while (true){
            if (operStack.isEmpty()){
                System.out.println(numStack.peak());
                break;
            }
            num1=(int)numStack.pop();
            num2=(int)numStack.pop();
            oper=(char) operStack.pop();
            res=numStack.cal(num1,num2,oper);
            numStack.push(res);
            //operStack.push(ch);
        }
        System.out.println(expression+"的结果为："+numStack.peak());
    }


    public int priority(int oper){
        if (oper=='*' || oper== '/'){
            return 1;
        }else if (oper=='+' || oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }
    public boolean isOper(char val){
        return val=='+' || val=='-' || val=='*' || val=='/';
    }

    public int cal(int num1,int num2,int oper){
        int result=0;
        switch (oper){
            case '+':
                result=num1+num2;
                break;
            case '-':
                result=num2-num1;
                break;
            case '*':
                result=num1*num2;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                break;
        }
        return result;
    }



}
