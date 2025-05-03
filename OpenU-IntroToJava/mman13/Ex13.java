
/**
 * Write a description of class Ex13 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ex13
{
    /**this method calucltes  the number of minutes on the fastest route the driver can travel between two roads by moving from one road to the other at most once.                                                                                                                          
     * 
     * 
     * 
     * time complaxity-O(n).
     * because we have 2 loops that each of them runs until they reach the end of the arry.
     * in other words we have time comlaxity of 2n and its equals to O(n).
     * 
     * space complaxity-O(1).
     * because we used only constant number of variabels in this method.
     * 
     * 
     * @parm road1 array of integers that each element represents the length between cross section in the first road.
     * @parm road2 array of integers that each element represents the length between cross section in the second road.
     * 
     * @return the shortest road posible by moving from one road to the other at most once.
     * 
     * 
     */
    public static int shortestRoad(int[] road1,int[] road2){
        int sumAllRoad1=0;
        int sumAllRoad2=0;
        for(int index=0;index<road1.length;index++){//a loops that sums all the elements in the array
            sumAllRoad1+=road1[index];
            sumAllRoad2+=road2[index];
        }
        int min=Math.min(sumAllRoad1,sumAllRoad2);
        for(int index=0,sum1=0,sum2=0;index<road1.length;index++){// a loop that runs until end of the array and checks all the diffrent combinations that posible for the rider to switch roads
            sum1 += road1[index];
            sum2 += road2[index];
            
            sumAllRoad1-=road1[index];
            sumAllRoad2-=road2[index];
            min=Math.min(Math.min(sum2+sumAllRoad1,sumAllRoad2+sum1),min);//variabel that presents the minimum road that posible by checking what is the length of the road if he swutch roads now and comparing this road to the current minimum road 
        }
        return min;    //returns minimum road
    }
    
    
    /**this method finds the missing element in an arithmetic Series.
     * 
     * time complaxity-O(log n).
     * because we have 1 loop that runs all over the arry but each time we decrease the length of the arry by half.
     * space compaxity-O(1).
     * because we used only constant number of variabels in this method.
     * 
     * @parm arr array that represnt the invoice series, but one of the elements is missing.
     * @return the missing element.
     */
    public static int missingValue (int [] arr){
        int low =0;
        int high=arr.length;
        int n= arr.length;
        int d= (arr[n-1]-arr[0])/(n);//I came to this formula by(n is the last element): An=A1+(n-1)*d because we got a missing element we can write:An=A1+(n-1)*d+d =>An=A1+(n)*d/-A1 ==>An-A1=(n)*d==>(An-A1)/(n)=d 
        while(low<=high){//we are using binary search 
            int mid=(low+high)/2;
            if(arr[mid]!=arr[0]+(mid)*d&&arr[mid-1]==arr[0]+(mid-1)*d){//checking if the element in the index of mid is the missing element
                return (arr[mid]-d);
            }
            if(arr[mid]!=(arr[0]+(mid)*d)){//checking if we passed the missing element
                high=mid-1;
            }
            else if(arr[mid]==(arr[0]+(mid)*d)){//checking if we are before the missing element
                low=mid+1;
            }
        }
        return (arr[0]+arr[1])/2;//if we didn't find any mising element it means that there are only two elements in the given array, so the missing element is the averge of theme 
    }
    /**this method calculates the longest palindromic sequence in a given array.
     * @parm arr Is the array that the method runs on
     * @return The length of the largest palindromic sequence.
     */
    
    
    public static int longestPalindrome (int []arr){
        if(arr.length==0){
            return 0;
        }
        return longestPalindrome (arr,0,arr.length-1,1);
    }
    private static int longestPalindrome (int[] arr,int i,int end,int count){//longestpalindrome overload method that checks each subset of the given array to see if a subset is a palindrome
        if(i>=arr.length){//stop condtion
            return count;
        }
        if(end<=i){//stop condition
            return longestPalindrome(arr,i+1,arr.length-1,count);
        }
        if(isPalindrom(arr,i,i,end)){//checking if the subset of the elements of the array ןis Palindrom
            count=Math.max(count,end-i+1);
        }
        return longestPalindrome(arr,i,end-1,count);//The recursion step
    }
    public static boolean isPalindrom(int[] arr,int i,int start,int end){//checks if in the given array ther is a palindrom starting from i to end
        if((end+start)/2 <i-1){//stop condition
            return true;
        }
        if(arr[i]!=arr[end]){//stop condition
            return false;
        }
        return isPalindrom(arr,i+1,i+1,end-1);//The recursion step
    }
    /**The method should return true if there is a subset of the elements of the array whose sum is the sum of the elements
     * Its is equal to num, which fulfills the following conditions:
     *   1. Includes the members of the array without repetitions. It is forbidden to take a member from the array more than once.
     *   2. Does not include three adjacent members in the array. It is forbidden to enter a subgroup either
     *   the member at index i, both the member at index i+1 and the member at index i+2, for each i.
     *  
     * If there is no subset in the array that meets these conditions, the method will return the value false.
     * 
     * @parm arr is the array on which the method will operate. There are no more limitations.
     * @parm num is the integer number that the methode will operate. There are no more limitations.
     * 
     * @return boolean expression of the rules above.
     */
    public static boolean isSum (int[] arr, int num){
        return isSum(arr,num,0,0);
    }
    
    private static boolean isSum (int[] arr, int num,int i,int changed){//overload method of isSum that rins on the given array and each time it  subtract the elemnet in the place of i from num (if its posible, its not posible if we subtracted 2 elments in a row before ).
        changed=Math.max(changed,0);//if we subtracted too much from changed
        if(num==0){//stop condition
            return true;
        }
        if(i>=arr.length){//stop condition
            return false;
        }
        if(changed<2){//stop condition
            return isSum(arr,num,i+1,changed-1)||isSum(arr,num-arr[i],i+1,changed+1);//The recursion step, now we choose whether to take the element at the index of i.
        }
        return isSum(arr,num,i+1,changed-1);//The recursion step, we can't choose whiether to take the element in the at the index of i because of rule 2 
    }
}