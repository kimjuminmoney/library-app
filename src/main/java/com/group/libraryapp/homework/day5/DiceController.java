package com.group.libraryapp.homework.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiceController {

    private static DiceController dc = new DiceController();

    public int inputRollNumber(){
        System.out.println("주사위 던질 횟수를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int inputMaxNumber(){
        System.out.println("주사위 최대값을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int diceRandom(int n){
        return (int)(Math.random() * n) + 1;
    }

    public List<Number> addListData(int max){
        List<Number> numberList = new ArrayList<>();
        for(int i = 1; i < max+1; i++){
            numberList.add(new Number(i,0));
        }
        return  numberList;
    }

    public void rollDiceProcess(List<Number> list, int rollNumber, int maxNumber){
        for(int i=0;i<rollNumber;i++){
            int tempNumber = dc.diceRandom(maxNumber);
            list.get(tempNumber-1).getCount();
        }
    }

    public static void main(String[] args) {
        int rollNumber = dc.inputRollNumber();
        int maxNumber = dc.inputMaxNumber();
        List<Number> list = dc.addListData(maxNumber);
        dc.rollDiceProcess(list,rollNumber,maxNumber);
        for(Number number : list){
            System.out.println(number.getNumber() + "번은 " + (number.getCount()-1) + "번 나왔습니다.");
        }
    }
}
