package com.example.springdi;

public class Carro {
    private Motor motor;

    public void motorTest(){
        System.out.println(this.motor.getType());
    }
    
    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Carro(Motor motor){
        this.motor=motor;
    }
}