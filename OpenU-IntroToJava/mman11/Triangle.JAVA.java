
/*
The class triangle receives 3 numbers from the user and tells the user:
does these numbers are the side of a triangle or not.
If they are side of triangle the class will check if they (the 3 numbers) are sides of:
equilateral triangle , isosceles triangle , right-angle triangle or common triangle. and will print the type of the triangle.
If these numbers aren't triangle, the class will print the text "The numbers: (and the values ​​of these numbers) cannot represent a triangle". 
 * The author is Amit Kreda.
 * The date the program was written 17.03.2023
 */
import java.util.Scanner;
import java.lang.Math;
public class Triangle
{
    public static void main(String[]args)
    {
        int lenSide1,lenSide2,lenSide3;
        System.out.println("Enter the value of the first side of the triangle");//telling the user what input to enter
        Scanner input = new Scanner(System.in);
        lenSide1= input.nextInt();//getting input from the user
        System.out.println("Enter the value of the second side of the triangle");//telling the user what input to enter
        lenSide2= input.nextInt();//getting input from the user
        System.out.println("Enter the value of the third side of the triangle");//telling the user what input to enter
        lenSide3= input.nextInt();//getting input from the user
        
        if (lenSide1 > 0 && lenSide2 > 0 && lenSide3 > 0 && ( lenSide1 + lenSide2>lenSide3 && lenSide1+lenSide3>lenSide2 && lenSide3+lenSide2>lenSide1))//checking if the 3 numbers we got from the user can be sides triangle .
        {
            if (lenSide1 == lenSide2 && lenSide3 == lenSide2)//checking if the 3 numbers represent a equilateral triangle by comparing the value of the sides of the triangle to each other and with the The transition rule we will get that the sides are equle or not. 
            
                System.out.println("The numbers: "+lenSide1+", "+lenSide2+" and "+lenSide3+" represent a equilateral triangle");//printing that the three number represent a equilateral triangle 
                
            else if (lenSide1 == lenSide2 || lenSide3 == lenSide2 || lenSide3 == lenSide1)//checking if the 3 numbers represent an isosceles triangle by compareing the values of the sides to each other so that will be a a pair of two equle sides.
            
                    System.out.println("The numbers: "+lenSide1+", "+lenSide2+" and "+lenSide3+" represent an isosceles triangle");//printing that the three numbers represnt an isosceles triangle
                        
                 else if((Math.pow(lenSide1,2) + Math.pow(lenSide2,2) == Math.pow(lenSide3,2))||(Math.pow(lenSide3,2) + Math.pow(lenSide2,2) == Math.pow(lenSide1,2))||          
                 (Math.pow(lenSide1,2) + Math.pow(lenSide2,2) == Math.pow(lenSide3,2)))//checking with Pythagorean theorem if the triangle is right angle triangle.
                         
                            System.out.println("The numbers: "+lenSide1+", "+lenSide2+" and "+lenSide3+" represent a right-angle triangle");//printing that the three numbers represent three sides of right-angle triangle. 
                       else      //the last option  that left is common triangle, so we don't nees to check anything 
                            System.out.println("The numbers: "+lenSide1+", "+lenSide2+" and "+lenSide3+" represent a common triangle");//printing that the three numbers represent three sides of a common triangle.
        }//end of the if that checks if the 3 numbers are sides od triangle
        else
            System.out.println("The numbers: "+lenSide1+", "+lenSide2+" and "+lenSide3+" cannot represent a triangle");//printing to the user that the 3 number can't represent a triangle.
    }//end of main
}//end of the class


