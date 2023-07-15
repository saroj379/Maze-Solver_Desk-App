/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mazesolver;

import java.util.List;

/**
 *
 * @author princ
 */
public class DepthFirst {
    public static boolean searchPath(int[][] maze , int x, int y, List<Integer> path){
        
        if(maze[y][x] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[y][x] == 0){
            maze[y][x] = 2;
            int dx = 0;
            int dy = -1;
            if(searchPath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = 0;
            dy = 1;
            if(searchPath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = 1;
            dy = 0;
            if(searchPath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = -1;
            dy = 0;
            if(searchPath(maze, x+dx, y+dy, path)){
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
