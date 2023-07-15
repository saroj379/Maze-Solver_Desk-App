/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mazesolver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author princ
 */
public class NewJava extends JFrame{
    // 1 -> obstacles, 0 -> patj, 9 -> destination to reach
    private int[][]maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,1,1,0,0,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path = new ArrayList<>();
    JFrame jFrame;
    JButton Run, Reset;
    
    
    // constructor
    public NewJava(){
        jFrame = new JFrame();
        Run = new JButton("RUN");
        Run.setBounds(44,320,100,30);
//        
        Reset = new JButton("CLOSE");
        Reset.setBounds(350, 300, 100,30);

        setTitle("Maze Solver");
        setSize(500, 400);
        jFrame.getContentPane().setBackground(Color.PINK);
        setLocation(400, 150);
        
        jFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                int opt = JOptionPane.showConfirmDialog(jFrame, "Do you want to exit?");
                System.out.print(opt);
                if(opt == JOptionPane.YES_OPTION) jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        
        this.add(Run);
        this.add(Reset);
        
        this.setLayout(null);
        
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        DepthFirst.searchPath(maze, 1,1, path);
        System.out.print(path);
        
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(50, 50);
        for(int i=0; i<maze.length; i++){
            for(int j=0; j<maze[i].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1: color = Color.BLACK;
                            break;
                    case 9: color = Color.red;
                            break;
                    default : color = Color.WHITE;
                            break;
                }
                
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.red);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        
        for(int i=0; i<path.size(); i+=2){
            int pathX = path.get(i);
            int pathY = path.get(i+1);
            
//            System.out.println("X cordinates :" + pathX);
//            System.out.println("Y cordinates :" + pathY);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*pathX, 30*pathY, 20, 20);
        }
    }
    
    public static void main(String[] args){
        NewJava nj = new NewJava();
        nj.setVisible(true);
    }
}
