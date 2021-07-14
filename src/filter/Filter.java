/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filter;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author Erlkonig
 */
public class Filter {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Gesture> Gestures=new ArrayList<>();
        Gesture curGest;
        
        for(int g=0;g<Parameters.getAmGest();g++){
            curGest=new Gesture(Input.getGestureName(g),Input.getMatrix(g));
            Gestures.add(curGest);
        }
        
        for(Gesture Current:Gestures){
            double[][] cur=Current.getMatrix();
                for(int i=0;i<Parameters.getReGest();i++){
                    Kalman.execute(cur[i]);}
                }
    }
    
}
