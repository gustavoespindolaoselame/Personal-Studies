package com.example.springdi;

public class EletricMotor implements Motor{
    @Override
    public String getType(){
        return "Eletric";
    }
}