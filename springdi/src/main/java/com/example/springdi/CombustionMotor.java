package com.example.springdi;

public class CombustionMotor implements Motor{
    @Override
    public String getType(){
        return "Combustion";
    }
}