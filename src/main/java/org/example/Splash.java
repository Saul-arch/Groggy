package org.example;

public class Splash extends Thread{
    Thread hilo1;


    public void run(){

        for (int i = 0; i < 5; i++){
            System.out.println("Contando");

            try{
                Thread.currentThread().sleep(5000);
            }catch (Exception e){
                System.out.println(e);
            }
        }

    }
}