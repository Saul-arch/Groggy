package org.example;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        JFrame framePrincipal = new JFrame();
        JFrame framePrincipalSplash = new JFrame();
        JPanel pnlContentSplash = new JPanel();
        Splash hilo1;
        JLabel lblImgSplash = new JLabel();
        File rutaSplash = new File("C:\\Users\\pc\\IdeaProjects\\Sistema_ventas\\Imagenes\\splash.svg");
        FlatSVGIcon imgSplash = new FlatSVGIcon(rutaSplash);

        lblImgSplash.setSize(1500, 800);
        lblImgSplash.setLocation(0,0);
        lblImgSplash.setLayout(null);
        lblImgSplash.setIcon(imgSplash);
        lblImgSplash.setVisible(true);

        pnlContentSplash.setSize(1512, 882);
        pnlContentSplash.setLocation(0,0);
        pnlContentSplash.setLayout(null);
        pnlContentSplash.add(lblImgSplash);
        pnlContentSplash.setBackground(Color.white);

        framePrincipal.setSize(1512, 882);
        framePrincipal.setLocationRelativeTo(null);
        framePrincipal.setTitle("Sistema de ventas Grroggy");
        framePrincipal.setResizable(false);
        framePrincipal.setLayout(null);
        framePrincipal.setBackground(Color.decode("#F5F5F5"));
        framePrincipal.setVisible(false);
        framePrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        framePrincipalSplash.setSize(1512, 882);
        framePrincipalSplash.setLocationRelativeTo(null);
        framePrincipalSplash.setTitle("Sistema de ventas Grroggy");
        framePrincipalSplash.setResizable(false);
        framePrincipalSplash.setLayout(null);
        framePrincipalSplash.setBackground(Color.decode("#F5F5F5"));
        framePrincipalSplash.add(pnlContentSplash);
        framePrincipalSplash.setVisible(true);
        framePrincipalSplash.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        hilo1 = new Splash(framePrincipal);
        hilo1.start();
        while (hilo1.senal){
            System.out.println("Sigue");
            if (hilo1.senal){


            }else{

            }
        }
        System.out.println("termino");
        framePrincipalSplash.dispose();
        framePrincipal.setVisible(true);


    }


}