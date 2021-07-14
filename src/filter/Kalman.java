package filter;

public class Kalman {
   
static double frand() 
{
    return 2*((Math.random()/(double)32767) - 0.5);//MAX Rand =32767 in cpp
} //random noise}  
public static void execute()
{       
        double x_last=0;   
        double p_last=0.02;
        double Q=0.018;
        double R=0.542;
        double kg;
        double x_mid;
        double x_now;
        double p_mid;
        double p_now;
        double z_real=0.56;
        double z_measure;
        double sumerror_kalman=0;
        double sumerror_measure=0;
        int i;
        x_last=z_real+frand()*0.03;
        x_mid=x_last;
        
        for(i=0;i<20;i++)
        {        x_mid=x_last;    //x_last=x(k-1|k-1),x_mid=x(k|k-1)
                                 p_mid=p_last+Q; //p_mid=p(k|k-1), p_last=p(k-1|k-1), Q=noise
                                 kg=p_mid/(p_mid+R); //kg is kalman filter, R is noise
                                 z_measure=z_real+frand()*0.03;//Measurement value
                                 x_now=x_mid+kg*(z_measure-x_mid);//estimated optimal value
                                 p_now=(1-kg)*p_mid;//covariance corresponding to the optimal value
                                 System.out.println("Real position:"+z_real); //Show true value
                 System.out.println("Mesaured position:"+z_measure+":"+Math.abs(z_real-z_measure)); //Display the measured value and the error between the true value and the measured value
                 System.out.println("Kalman position:"+x_now+":"+Math.abs(z_real - x_now)); //Show kalman estimates and errors between true and Kalman estimates
                 sumerror_kalman += Math.abs(z_real - x_now); //the cumulative error of the kalman estimate
                 sumerror_measure += Math.abs(z_real-z_measure); //cumulative error between true and measured values
                 p_last = p_now; //update the covariance value
                 x_last = x_now; //Update system status value
        }
                 System.out.println("overall measurement error:"+ sumerror_measure); //output measurement cumulative error
                         System.out.println("overall Kalman filter error:"+sumerror_kalman); //output kalman cumulative error
         System.out.println("Kalman error percentage:"+(100-(int)((sumerror_kalman/sumerror_measure)*100))); 
}
}
