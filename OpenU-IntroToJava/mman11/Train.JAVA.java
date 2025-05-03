
/*
 * the class gets the speed and the time travel of 2 trains and Calculates the distance difference between the trains.
 * The class gets from the user four differnt inputs ,the input have two part .(a part for each train) in each part we ask from the user to enter the speed and the travel duration,
 * after we get the input of the duration and the speed of the train we calculate the distance each train made.
 * In the end of the class we print and calculates the Absolute value of the distance difference of train 1 and train 2.
 * The author is Amit Kreda
 * The date the program was written 17.03.2023
 */
import java.util.Scanner;
import java.lang.Math;
public class Train
{
    public static void main(String[]args)
    {
        int trainSpeed1,trainTravelTime1,trainSpeed2,trainTravelTime2;//Declaring the type of variables
        double distanceTrainMade1,distanceTrainMade2;//Declaring the type of variables
        final double HOUR = 60.0;//Set a constant variable for the number of minutes in an hour
        System.out.println("enter the speed of the first train");//asking from the user to enter the speed of the first train
        Scanner input = new Scanner(System.in);// creating input
        trainSpeed1=input.nextInt();// getting the speed of the first train
        System.out.println("enter the duration time that the first train has traveled");//asks the user to enter the time that the first train has traveled
        trainTravelTime1=input.nextInt();// getting the speed of the first train
        
        distanceTrainMade1=(trainTravelTime1/HOUR)*trainSpeed1;//caculating the distance train 2 made with the given formula
        
        System.out.println("enter the speed of the second train");//asking from the user to enter the speed of the seconf train
        trainSpeed2=input.nextInt();// getting the speed of the second train
        System.out.println("enter the duration time that the second train has traveled");//asks the user to enter the time that the second train has traveled
        trainTravelTime2=input.nextInt();// getting the speed of the second train
        
        distanceTrainMade2=(trainTravelTime2/HOUR)*trainSpeed2;//caculating the distance train 2 made 
        System.out.println("The distance between the trains is "+Math.abs(distanceTrainMade1-distanceTrainMade2)+"km");/*calculates the Absolute value of the distance difference
                                                                                                                        of train 1 and train 2 and printing it*/
    }
}
