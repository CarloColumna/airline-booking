/*
 * This class contains all the common operations that involve retreiving data from the database, 
 * saving data to the database or updating existing database data 
 * for all three tables (Location, Flight and Booking)
 */
package uflybookingsystem;




public class DatabaseOperations {
    
    //method that gets all the information from the Location table
    public static ArrayList<Location> GetAllLocations(){

    }
    
    // this method returns all the data from the Flight table in the uFly database
    public static ArrayList<Flight> GetAllFlights(String departure, String destination){

    }
    
    //this method obtains all the information from the Flight table based on the departure and destination airports as well as travel date
    public static ArrayList<Flight> GetAllFlightsForLocation(String departure, String destination, java.util.Date travelDate){
  
    }
    
    //this method adds booking passed as a parameter to the Booking table in the uFly database
    //note that Booking number is set as an incrementing field, so it doesn't need to be set
    public static void AddBooking(Booking booking){
    
    }
    
    //this method obtains the flight based on the flightNumber parameter
    public static Flight getFlightByFLightNumber(String flightNumber){
   
    }
    
     //this method obtains the flight based on the flightNumber parameter
   public static Location getLocationByAirportCode(String airportCode){
	try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Location "
                    + "WHERE AirportCode = '" + airportCode + "'")){
            
            while (resultSet.next()) {
            	Location location = new Location();
            	location.setCity(resultSet.getString("City"));
            	location.setAirportCode(resultSet.getString("AirportCode"));
            	return location;
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
        return null;
    }
    
    //this method adds location passed as a parameter to the Location table in the uFly database
    public static void AddLocation(Location location){
	try (Connection connection = DbConnector.connectToDb();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT City, AirportCode from Location")){
            
            resultSet.moveToInsertRow();
            resultSet.updateString("City", location.getCity());
            resultSet.updateString("AirportCode", location.getAirportCode());
            resultSet.insertRow();
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        } 
    }
     
    //this method adds a flight passed as a parameter to the Flight table in the uFly database
    public static void AddFlight(Flight flight){
     
    }

    
    //this method updates the location to the one passed to it as a parameter where the airport codes are matching
    public static void UpdateLocation(Location location){
        
    }
    
    //this method updates the flight to the one passed to it as a parameter where the flight numbers are matching
    public static void UpdateFlight(Flight flight){
        
    }
}
