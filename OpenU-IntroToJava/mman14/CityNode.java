/**
 * This program represents the actions that can be preformed on a node with City type.
 *
 * @author Amit kreda 
 * @version 17.06.23
 */
public class CityNode
{
    private City _city;//the city
    private CityNode _next;//the next element pointer
    
    /**
     * Constructs a new city with all City parameters and sets the next node to be null
     * 
     * @param c The city's data and parameters.
     */
    public CityNode(City c){
        _city=new City(c);
        _next=null;
    }
    /**
     * Constructs a new city with all City parameters and implements the next node in the list.
     * 
     * @param c The city's data and parameters.
     * @param next The next node in the list.
     */
    public CityNode (City c, CityNode next) {
        _city=new City(c);;
        _next=next;
    }
       /**
     * Copy constructor that implements a new city and implements the next node in the list.
     * 
     * @param c The cityNode to copy.
     */
    public CityNode (CityNode c){
         _city=new City(c._city);
         _next=c._next;
    }
         /**
     * Returns a city object representing the city's data and parameters.
     * 
     * @return The city's data and parameters.
     */
    public City getCity(){
        return new City(_city);
    }
      /**
     * Returns the next city in the list.
     * 
     * @return The next node in the list
     */
    public CityNode getNext(){
        return _next;
    }
     /**
     * Changes the city data.
     * 
     * @param c The city's new data.
     */
    public void setCity(City c){
        _city=new City(c);
    }
     /**
     * Changes the next city in the list
     * 
     * @param next The new next city.
     */
    public void setNext(CityNode next){
        _next=next;
    }
    
    
}
