package aps4;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author megas
 */
public class Janela extends JFrame {
    private static Main m = new Main();
            JPanel jp = new JPanel();
        //JFrame janela = new JFrame();
        JTextArea jt = new JTextArea(10,40);
        
        
        
        
        
        
     public Janela(){

       
        setTitle("Ordenação");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(800, 550);
	setLocationRelativeTo(null);
	setResizable(false);
	setVisible(true);
        jp.add(jt);
        add(jp);
        jt.setText("m");
    }
}
