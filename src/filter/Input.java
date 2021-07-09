package filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Erlkonig
 */
public class Input {
    private static final String[] gestureFiles={"E:\\3\\Filter\\cyl_ch1.txt",
                                        "E:\\3\\Filter\\hook_ch1.txt",
                                        "E:\\3\\Filter\\lat_ch1.txt",
                                        "E:\\3\\Filter\\palm_ch1.txt",
                                        "E:\\3\\Filter\\spher_ch1.txt",
                                        "E:\\3\\Filter\\tip_ch1.txt"
                                        };

public static double[][] getMatrix(int i) throws FileNotFoundException{
    double[][] matrix = new double[Parameters.getReGest()][Parameters.getAtGest()];
        
    System.out.println(gestureFiles[i]);
        Scanner sc = new Scanner(new FileReader(gestureFiles[i]));
            for(int j = 0; j< Parameters.getReGest(); j++)
            {
                for(int k = 0; k < Parameters.getAtGest(); k++) 
                    {
                        matrix[i][k] = sc.nextDouble();
                    }
            }
    return matrix; 
}

    public static String getGestureName(int i) {
        File f=new File(gestureFiles[i]);
         System.out.println(gestureFiles[i]);
    
        return f.getName();
    }

}
    

