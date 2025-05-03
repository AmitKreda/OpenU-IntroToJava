
/**
 * Represents a point in the cartzian system
 *
 * @author amit kreda
 * @version 22/04/2023
 */

public class Point
{
    private int _x;
    private int _y;
    private int MIN_X_VALUE = 0;
    private int MIN_Y_VALUE =0;
    /**
     * Constructs a point.
     * If the new point has a negative value (if x or y is negative) it will be changed to 0.
     * @param x Point's x coordinate in Integers.
     * @param y Point's y coordinate in Integers.
     */
    public Point(int x, int y)
    {
        _x =Math.max(x,MIN_X_VALUE);//the max method will take the largest number between x and 0, in other words if x is negative then the value of _x will be 0.If it is positive the value of _x will be x
        _y = Math.max(y,MIN_Y_VALUE);//the max method will take the largest number between y and 0, in other words if y is negative then the value of _y will be 0.If it is positive the value of _y will be y
    }
    /**Copy contractor. 
     * Copies the coordinates of another point to the current point
     * @param other other Point object that will be copied to the current object 
     */
    public Point(Point other)
    {
        this._y=other._y;
        this._x=other._x;
    }
    /** returns the x value of the point
     * @return Point's x value
     */
    public int getX(){
        return _x;
    }
    /** returns the y value of the point
     * @return Point's y value
     */
    public int getY(){
        return _y;
    }
    /**
     * sets the y coordinate of this Point to the new given coordinate  
     *
     * @param  num New y coordinate
     */
    
    public void setY(int num)
    {
        if (num>=MIN_Y_VALUE)
            _y=num;
    }
    /**
     * sets the x coordinate of this Point to the new given coordinate  
     *
     * @param  num New x coordinate
     */
    public void setX(int num)
    {
        if (num>=MIN_X_VALUE)
            _x=num;
    }
    /**
    *Return a string representation of this point.
     * @return String representation of Point's x and y coordinate using the ordered pair method
     */
    
    public String toString(){
        return "("+_x+","+_y+")";
    }
    /**gets a Point object and checks if the two Points(this point and the new point) have equal x and y coordinates 
     * @param other other Point object
     * 
     * @return a boolean expression that says if the points are on the same x and y coordinates
     */
    public boolean equals(Point other){
        return this._x==other._x && this._y==other._y;
    }
    /**Gets a point object and checks if the new point has a y value greater than the current point
     * @param other other Point object
     * 
     * @return a boolean expression that tells if the current point has a higher y value
     * than the given point (if the current point is above the given point)
     */
    public boolean isAbove(Point other){
        return this._y > other._y;
    }
    /**Gets a point object and Checks if this point is below a received point.
     * @param other other Point object
     * 
     * @return a boolean expression that tells if the current point is below the given point
     */
    public boolean isUnder(Point other){
        return other.isAbove(this);
    }
    /**Gets a point object and checks if the new point has a x value lower than the current point
     * @param other other Point object
     * 
     * @return a boolean expression that tells if the current point has a lower x value
     * than the given point (if the current point is to the left of the given point)
     */
    public boolean isLeft(Point other){
        return this._x < other._x;
    }
    /**Gets a point object and checks if the given point is to the left of the given point
     * @param other other Point object
     * 
     * @return a boolean expression that tells if the current point is to the right of the given point
     */
    public boolean isRight(Point other){
        return other.isLeft(this);
    }
    /**Moves the point according to given parameters. If after the point has been moved it is outside the first quadrant, the movement will not occur
     * @param deltaX the distance on the that the point will move 
     * 
     * @return a boolean expression that tells if the current point is to the right of the given point
     */
    public void move(int deltaX, int deltaY){
        if (checkPoint(_x+deltaX,_y+deltaY)){
            _x+=deltaX;
            _y+=deltaY;
        }
    }
    /**Return a new point in between this point and the received point.
    *@param p the received point
    *
    *@return new Point in between this point and the received point
     */
    public Point middle(Point p){
        int middelX=(int)((this._x + p._x)/2);
        int middleY=(int)((this._y + p._x)/2);
        return new Point(middelX, middleY);
    
    }
    /**Check the distance between this point and a received point.
     * @param p The point to check distance from
     * @return double representing the distance
     */
    public double distance(Point p){
        return Math.sqrt(Math.pow((p._x - this._x),2) + Math.pow((p._y - this._y),2));
    }
    //A private method that checks whether the point is in the first quarter or not
    private boolean checkPoint(int x, int y){  
        return x>=MIN_X_VALUE && y>=MIN_Y_VALUE;
    }
    
}





















