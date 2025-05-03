
/**
 *This class represents a Date object
 *
 * @author amit kreda
 * @version 22/4/2023
 */

public class Date
{
    private int _day;
    private int _month;
    private int _year;
    private final int JANUARY =1;
    private final int FEBRUARY =2;
    private final int MARCH =3;
    private final int APRIL =4;
    private final int MAY =5;
    private final int JUNE =6;
    private final int JULY =7;
    private final int AUGUST =8;
    private final int SEPTEMBER =9;
    private final int OCTOBER =10;
    private final int NOVEMBER =11;
    private final int DECEMBER =12;
    private final int DEFUALT_DAY=1;
    private final int DEFUALT_MONTH=1;
    private final int DEFUALT_YEAR=2000;
    private final int NUM_OF_DAYS_IN_BIG_MONTHES=31;
    private final int NUM_OF_DAYS_IN_MIDDLE_MONTHES=30;
    private final int NUM_OF_DAYS_IN_SMALL_MONTHES=28;
    private final int MIN_NUM_OF_DAYS=1;
    private final int MIN_YEAR = 999;
    private final int MAX_YEAR = 10000;
    /**If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     *@param day  the day in the month (1-31)
     *@param month  the month in the year (1-12)
     *@param year  the year (4 digits)
     */
    public Date(int day ,int month ,int year)
    {
        if (checkDate(day, month, year)){//checking if its valid date using the private methode checkDate 
            _day = day;
            _month = month;
            _year = year;
        }
        else{
           _day = DEFUALT_DAY;
           _month = DEFUALT_MONTH;
           _year = DEFUALT_YEAR;
        }
    }
    
    /**Copy constructor
     * @param other the date to be copied
     */
    public Date(Date other){
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }
    
    /**Gets the year
     * @return  the year
     */
    public int getYear(){
        return _year;
    }
    
    /**Gets the month
     * @return  the month
     */
    public int getMonth(){
        return _month;
    }
    
    /**Gets the day
     * @return  the day
     */
    public int getDay(){
        return _day;
    }
    
    /**Sets the day (only if date remains valid)
     * @param dayToSet Sets the day (only if date remains valid)
     */
    public void setDay(int dayToSet){
        if(checkDate(dayToSet,_month,_year))
            _day=dayToSet;
    }
    
    /**Sets the month (only if date remains valid)
     * @param monthToSet Sets the month (only if date remains valid)
     */
    public void setMonth(int monthToSet){
        if(checkDate(_day,monthToSet,_year))
            _month=monthToSet;
    }
    
    /**Sets the year (only if date remains valid)
     * @param yearToSet Sets the year (only if date remains valid)
     */
    public void setYear(int yearToSet){
        if(checkDate(_day,_month,yearToSet))
            _year=yearToSet;
    }
    
    /**Check if two dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same
     */
    public boolean equals(Date other){
        return this._day==other._day && this._month==other._month && this._year==other._year; 
    }
    
    /**Check if this date is before other date
     * @param other date to compare this date to
     * @return true if this date is before other date
     */
    public boolean before(Date other){
        //cheching if this Date has less days that passed since the beginning of the Christian counting of years than the given Date by using the pruvate method calculateDate 
        return (calculateDate(this._day,this._month,this._year) < calculateDate(other._day,other._month,other._year));
    }
    
    /**Check if this date is after other date
     * @param other date to compare this date to
     * @return true if this date is after other date
     */
    public boolean after(Date other){
        return other.before(this);
    }
    
    /**Calculates the difference in days between this date and other date
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference(Date other){
        //calculats the difference in days between this date and other Date by By subtracting the number of days that have passed from the beginning of the count to the given date from the number of days that have passed from the start of the count to the current date 
        return Math.abs(calculateDate(this._day ,this._month ,this._year) - calculateDate(other._day ,other._month ,other._year));
    }
    /**Returns a String that represents this date
     * @return  String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
     */
    
    public String toString(){
        return _day/10+""+_day%10+"/"+_month/10+_month%10+"/"+_year;
    }
    
    /**Calculate the date of tomorrow
     * @return the date of tomorrow
     */
    
    public Date tomorrow(){
        Date otherDate = new Date(this);
        if (checkDate(otherDate._day+1,otherDate._month,otherDate._year))
            otherDate._day++;
        else {
            if (checkDate(MIN_NUM_OF_DAYS,otherDate._month+1,otherDate._year)){
                otherDate._day =MIN_NUM_OF_DAYS;
                otherDate._month++;
            
            }
            else{
                otherDate._day=MIN_NUM_OF_DAYS;
                otherDate._month = JANUARY;
                otherDate._year++;
            }
        }
        return otherDate;
    }
    //checks if the given date is valid
    private boolean checkDate(int day,int month,int year){
        if (year > MIN_YEAR && year < MAX_YEAR){
            switch(month){
                case (JANUARY):
                case (MARCH):
                case (MAY):
                case(JULY):
                case(AUGUST):
                case(OCTOBER):
                case(DECEMBER):
                   return(MIN_NUM_OF_DAYS <= day && day <= NUM_OF_DAYS_IN_BIG_MONTHES);
                case (APRIL):
                case (JUNE):
                case (SEPTEMBER):
                case (NOVEMBER):
                    return(MIN_NUM_OF_DAYS<=day && day<=NUM_OF_DAYS_IN_MIDDLE_MONTHES);
                case(FEBRUARY):
                    return(MIN_NUM_OF_DAYS<=day && day <=NUM_OF_DAYS_IN_SMALL_MONTHES);
                default:
                    return false;
                }
            }
        else
            return false;
        }
    // computes the day number since the beginning of the Christian counting of years
    private int calculateDate ( int day, int month, int year){
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
         }
    }
