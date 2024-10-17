package com.example.springdi;

public interface Motor {
    default Boolean isOn(){
        System.out.println("Motor Is On");
        return true;
    }
    String getType();
}