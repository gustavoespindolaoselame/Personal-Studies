package com.example.springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutowiredLivro {
    private final AutowiredGenero genero;
    
    @Autowired
    public AutowiredLivro(AutowiredGenero genero){
        this.genero = genero;
    }

    public void getGenero(){
        System.out.println(this.genero.getType());
    }
}
