/**
 * This class represents a country, which has a list of cities.
 * 
 * @author amit kreda
 * @version 17/06/2023
 */
public class Country
{
    CityNode _head;
    private String _name;
 /**
   * Constructs a new instance of the Country class with the specified country
   * name, and an empty list of cities.
   * 
   * @param name The name of the country.
   */
    public Country(String name)
    {
        _name=name;
        _head=null;
    }
 /**
   * This method  is adding a new city to the list of cities in the country within the
   * correct place.
   * The list is sorted by established date on the city and then by the city name
   * (if the dates equals).
   * 
   * @param name           The name of the city to add.
   * @param day     The day the city was established.
   * @param month   The month the city was established.
   * @param year    The year the city was established.
   * @param xCenter        The x-coordinate of the city center.
   * @param yCenter        The y-coordinate of the city center.
   * @param xStation    The x-coordinate of the central station.
   * @param yStation    The y-coordinate of the central station.
   * @param numOfResidents     The number of residents in the city.
   * @param numOfNeighborhoods The number of neighborhoods in the city.
   * @return false if the city didn't added, otherwise return true.
   */
    public boolean addCity(String name, int day, int month, int year,int xCenter, int yCenter, int xStation, int yStation,long numOfResidents, int numOfNeighborhoods){
        CityNode city =new CityNode( new City(name, day,month,year,xCenter,yCenter,xStation,yStation,numOfResidents,numOfNeighborhoods));
        CityNode current =_head;
        if(_head==null){//if the list is empty, we add the city to the head
            _head=city;
            return true;
        }
        if(isInTheList(city.getCity().getCityName())){//if is in the list , return false
            return false;
        }
         if (city.getCity().getDateEstablished().before(_head.getCity().getDateEstablished())) {//checking if we need to put the city before the head
          city.setNext(_head);
          _head = city;
          return true;
        }
        if (city.getCity().getDateEstablished().equals(_head.getCity().getDateEstablished())&& _head.getCity().getCityName().compareTo(city.getCity().getCityName()) < 0) {//checking if we need to put the city after the head
            add(city,_head);
            return true;
        }else{
            if(city.getCity().getDateEstablished().equals(_head.getCity().getDateEstablished())&& _head.getCity().getCityName().compareTo(city.getCity().getCityName()) > 0){//checking if we need to put the city before the head
            city.setNext(_head);
            _head = city;
            return true;
            }
        }
        while (current.getNext()!=null){//searching where to put the new CityNode.
            if(city.getCity().getDateEstablished().before(current.getNext().getCity().getDateEstablished())){//if the date of city is after the element the while loop runs on, it means that city is between the previous element and the current element
                add(city,current);
                return true;
            }
            if(current.getNext().getCity().getDateEstablished().equals(city.getCity().getDateEstablished())){//checking if the dates are equal, if they do, we will move until the name of the city is lexogrefy smaller then the element
                while (current.getNext()!=null&&current.getNext().getCity().getDateEstablished().equals(city.getCity().getDateEstablished())&&city.getCity().getCityName().compareTo(city.getCity().getCityName())>0){
                    current=current.getNext();    
                }
                add(city,current);
                return true;
            }
            current=current.getNext();
        }
        add(city,current);//if we got to here it means that we needs to add the city to the end of the list
        return true;
    }
/**
   * Returns the total number of residents in all the citys.
   * in other words, returns the total number of residents in the country.
   * 
   * @return The total number of residents in the country.
   */
    public long getNumOfResidents(){
        CityNode current =_head;
        int sum=0;
        while(current != null){//runs on all the list and adding the num if residents to sum
            sum+=current.getCity().getNumOfResidents();
            current=current.getNext();
        }
        return sum;
    }
/**
   * Calculates and returns the longest distance between any two cities in the
   * country.
   * 
   * @return The longest distance between any two cities in the country.
   */
    public double longestDistance(){
        CityNode current =_head;
        double max=0;
        if(_head==null){
            return 0;
        }
        while(current.getNext() != null){
            CityNode temp =current.getNext();
            while(temp != null){//checking the longest distance between temp and current
                max=Math.max(current.getCity().getCityCenter().distance(temp.getCity().getCityCenter()),max);
                temp=temp.getNext();
            }
            current=current.getNext();
        }
        return max;
    }
 /**
   * Calculates and returns the number of cities located north of a given city.
   * 
   * @param cityName The name of the city to compare against.
   * @return The number of cities located north of the given city. Returns -1 if
   *         the given city is not found.
   */
    public int numCitiesNorthOf(String cityName){
        CityNode temp=_head;
        int numOfCities=0;
        boolean found= false;
        Point cityCenter=new Point(0,0);
        if (_head == null)
              return -1;
        while(temp != null){//checking if the city  existing in the list
            if(temp.getCity().getCityName().equals(cityName)){
                cityCenter=new Point(temp.getCity().getCityCenter());
                found=true;
            }
            temp=temp.getNext();
        }
        temp=_head;//Reset to the beginning
        if(!found){
            return -1;
        }
        while(temp != null){
            if(temp.getCity().getCityCenter().isAbove(cityCenter)){//checking who is the northest city
                numOfCities++;
            }
            temp=temp.getNext();
        }
        return numOfCities;
    }
      /**
   * Finds and returns the southernmost city in the country, if more than one city
   * is southest, returns the oldest one.
   * 
   * @return The southernmost city in the country. Returns null if the country has
   *         no cities.
   */
    public City southernmostCity(){
        CityNode current =_head;
        City southest = null;
        if(_head==null){
            return null;
        }
        southest = _head.getCity();
        while(current != null){
            if(current.getCity().getCityCenter().isUnder(southest.getCityCenter())){//checking who is the southest city
                southest=new City(current.getCity());
            }
            else if(current.getCity().getCityCenter().equals(southest.getCityCenter())){//if equals checking who is younger
                    if(current.getCity().getDateEstablished().before(southest.getDateEstablished())){
                        southest=new City(current.getCity());
                    }
            }
            current= current.getNext();
        }
        return new City(southest);
    }
      /**
   * Returns the name of the country.
   * 
   * @return The name of the country.
   */
    public String getCountryName(){
        return _name;
    }
    /**
   * Returns the number of cities in the country.
   * 
   * @return The number of cities in the country.
   */
    public int getNumOfCities(){
        int count=0;
        CityNode current =_head;
        while(current != null){
            count++;
            current=current.getNext();
        }
        return count;
    }
     /**
   * Checks if any cities in the country were established before or after the
   * given dates.
   * 
   * @param date1 The first date to compare.
   * @param date2 The second date to compare.
   * @return True if any cities were established before or after the given dates,
   *         false otherwise.
   */
    public boolean wereCitiesEstablishedBeforeOrAfter(Date date1, Date date2){
        CityNode current =_head;
        while(current != null){
            if(!current.getCity().cityEstablishedBetweenDates(date1, date2)){
                return true;
            }
            current=current.getNext();
        }
        return false;
    }
    /**
   * Unifies two cities into a single city by combining their information, removes
   * the youngest city form the list and sets the olded city to the unified one.
   * 
   * @param cityName1  The name of the first city.
   * @param cityName2 The name of the second city.
   * @return The unified city.
   */
    public City unifyCities(String cityName1,String cityName2){
        boolean found1=false;
        boolean found2=false;
        CityNode current1 =_head;
        CityNode current2 =_head;
        CityNode prevCurrent1 =_head;
        CityNode prevCurrent2 =_head;
        Date date;
        String name=cityName1+"-"+cityName2;; 
        int noOfNeighborhoods;
        long numOfResidents;
        Point center;
        Point centeralStation;
        while(!found1){//searching the element in the list
            if(current1.getCity().getCityName().equals(cityName1)){
                found1=true;
                break;
            }
            prevCurrent1=current1;
            current1=current1.getNext();
        }
        while(!found2){//searching the element in the list
            if(current2.getCity().getCityName().equals(cityName2)){
                found2=true;
                break;
            }
            prevCurrent1=current2;
            current2=current2.getNext();
        }
        if(current1.getCity().getDateEstablished().before(current2.getCity().getDateEstablished())){//searching what is the first date
                date=new Date(current1.getCity().getDateEstablished());
        }
        else{
                date=new Date(current2.getCity().getDateEstablished());
        }
        numOfResidents=current1.getCity().getNumOfResidents()+current2.getCity().getNumOfResidents();//summing the two numOfResidents
        noOfNeighborhoods =current1.getCity().getNumOfNeighborhoods()+current2.getCity().getNumOfNeighborhoods();//summing the num of residents
        center = current1.getCity().getCityCenter().middle(current2.getCity().getCityCenter());//taking the center of the new city
        if(current1.getCity().getCentralStation().isLeft(current2.getCity().getCentralStation())){//searching what is the central statiom of the new city
            centeralStation=new Point(current1.getCity().getCentralStation());
        }
        else if(current2.getCity().getCentralStation().isLeft(current1.getCity().getCentralStation())){//searching what is the central statiom of the new city
            centeralStation=new Point(current2.getCity().getCentralStation());
        }
        else{
            if(date.equals(current1.getCity().getDateEstablished())){//searching what is the central statiom of the new city
                centeralStation=new Point(current2.getCity().getCentralStation());
                City city=new City(name,date.getDay(),date.getMonth(),date.getYear(),center.getX(),center.getY(),centeralStation.getX(),centeralStation.getY(),numOfResidents,noOfNeighborhoods);
                current2.setCity(city);
                delete(prevCurrent1,current1);//deleting the youngest city 
            }
            else{//searching what is the central statiom of the new city
                centeralStation=new Point(current1.getCity().getCentralStation());
                City city=new City(name,date.getDay(),date.getMonth(),date.getYear(),center.getX(),center.getY(),centeralStation.getX(),centeralStation.getY(),numOfResidents,noOfNeighborhoods);
                current1.setCity(city);
                delete(prevCurrent2,current2);//deleting the youngest city
            }
        }
        City city=new City(name,date.getDay(),date.getMonth(),date.getYear(),center.getX(),center.getY(),centeralStation.getX(),centeralStation.getY(),numOfResidents,noOfNeighborhoods);//creating the unifyed city
        return  city;//returning th city 
    }
      /**
   * Calculates the maximum difference in establishment dates between any two
   * cities in the country.
   * 
   * @return The maximum difference in establishment dates, or -1 if the country
   *         has no cities, or 0 if there is only one city.
   */
    public int establishMaxDiff(){
        CityNode current=_head;
        if(current==null){
            return -1;
        }
        if(current.getNext()==null){
            return 0;
        }
        while(current.getNext()!=null){//getting the last element
            current=current.getNext();
        }
        return current.getCity().getDateEstablished().difference(_head.getCity().getDateEstablished());//the diffrence between the last num and the first num is the biggest difrrence because the list is sorted
    }
     /**
   * Returns a string representation of the country and its cities.
   * 
   * @return A string representation of the country and its cities.
   */
    public String toString(){
        String str="";
        CityNode current=_head;
        if(_head==null){
            return "There are no cities in this country.";
        }
        while(current!=null){//runing on the list and using toString of city class.
            str+="\n\n"+current.getCity().toString();
            current= current.getNext();
        }
        return "cities of "+_name+":"+str;
    }
    private void delete(CityNode prevElement,CityNode elementToDelete){//deletes an element from the list
        if(elementToDelete==_head){
            _head=_head.getNext();
        }
        else{
            prevElement.setNext(elementToDelete.getNext());
        }
    }
    private boolean isInTheList(String cityToFind){//returns boolean exprssion  does the city is in the list 
        CityNode temp = _head;
        while (temp != null) {
            if (temp.getCity().getCityName().equals(cityToFind)){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    private void add(CityNode nodeToAdd,CityNode nodeBefore){//adding the element to the list,not including cases when placeing the element before _head
        CityNode temp=nodeBefore.getNext();
        nodeBefore.setNext(nodeToAdd);
        nodeToAdd.setNext(temp);
    }
}

