package com.example.demo.Controller;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@Getter
@Setter
@RequiredArgsConstructor
public class HelloLombok {

    private String hello;
    private int lombok;

    public static void main(String[] args[]) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setHello("핼로");
        helloLombok.setLombok(5);

        //HelloLombok helloLombok2 = new HelloLombok("빠이", 3);
        //private String hello를 final로 선언하면 이런 식으로 값을 할당-생성이 가능

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());

    }

}