//Required for the functions to operate such as Hashmap, scanner and Map.
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibrarySystem {

//Map to store all Patrons, calling the Patron class within the Map
    private Map<String, Patron> patrons_List;

//Constructor in this class to initializes the Patrons map as an empty hashmap
    public LibrarySystem(){
    patrons_List = new HashMap<>();
    }

//Add patrons to the list through text file, it adds Patrons to the Patrons_list map through their user ID as a key.
    public void Addpatron(Patron patron_add){
    patrons_List.put(patron_add.getDigit_ID_number(),patron_add);
    System.out.println("Patron " + patron_add.getName() + " has been added to the list.");
    }

//Add patrons to the list through text file
    private  void AddPersonFromCLI() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Patron ID (7 digits): ");
//Be sure make new variables for the object
        String User_ID = sc.nextLine();

//This if statement is to keep the User ID to a minimum
        if (User_ID.length() != 7) {
            System.out.println("Error: ID must be exactly 7 digits.");
            return;
        }

//Add the questions for collecting Patron information from user through the command line to make a Patron object
        System.out.print("Enter Patrons Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patrons Address: ");
        String Address = sc.nextLine();

        System.out.print("Enter Patrons Overdue Fine Amount ($0 - $250): ");
        double fine_amount = sc.nextDouble();

//This if statement for the constraint of the fine amounts.
        if (fine_amount < 0.00 || fine_amount > 250.00) {
            System.out.print("Error: Overdue fine must be between $0 and $250.");
            return;
        }

//By taking the information from the questions asked, the information is now added to the object and then into the other
//method
        Patron Patron_add = new Patron(User_ID, name, Address, fine_amount);
        Addpatron(Patron_add);
    }

//This method removes a patron by their ID. It checks if the ID exists in the patrons map.
    public Boolean RemovePatron(String id){
    if(patrons_List.containsKey(id)){
        patrons_List.remove(id);
        System.out.println("Patron with ID [" + id + "] has been removed from the list.");
        return true;
    }else{
        System.out.println("No Patron with ID [" + id + "] matches with one Patron in the list.");
        return false;
     }
    }

//This method removes a patron by their ID, as entered by the user through the command line.
    private void RemovePatronThroughCLI(){
        Scanner sc = new Scanner(System.in);
        System.out.println("To remove Patron please enter the Patron ID: ");
        String user_Id_Removal = sc.nextLine();

        if (user_Id_Removal.length() != 7) {
            System.out.println("Error: ID must be exactly 7 digits.");
            return;
        }
//Call upon the Boolean RemovePatron method to give the typed up user ID
        RemovePatron(user_Id_Removal);
    }

//Display the patron list
    public void DisplayPatrons() {
        if (patrons_List.isEmpty()) {
            System.out.println("No Patrons within the list to display.");
        } else {
            for (Patron patrons_display : patrons_List.values()) {
                patrons_display.Display_Patron_Info();

            }
        }
    }

//This method is a placeholder for loading patrons from a file
    public void LoadPatronsFromCLI(String filename){
    System.out.println("Loading patrons from file: " + filename);
    }

//This method displays a menu that allows the user to interact with the system.
    public void ShowMenu() {
        Scanner sc = new Scanner(System.in);
        int Option;

        do {
            System.out.println("\nLibrary System Menu:");
            System.out.println("1. Add Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. Display All Patrons");
            System.out.println("4. Exit");
            System.out.print("Enter your option by the number associated: ");
            Option = sc.nextInt();
            System.out.print("\n");

//Using the switch for the menu so user can enter the option they choose by using the number associated in  the print
// above.
            switch (Option) {
            //Adding Patron
            case 1:
            AddPersonFromCLI();
            break;

            //Removing Patron
            case 2:
            RemovePatronThroughCLI();
            break;

            //Displaying Patrons
            case 3:
            DisplayPatrons();
            break;

            //Exiting the menu
            case 4:
            System.out.println("Exiting Menu...");
            break;

            //incase there is a miss input of any other numbers then what is given.
            default:
            System.out.println("That number inputted was invalid. Please re-enter the option offered above.");
            }
        }while (Option != 4) ;
    }

//This is the entry point of the program. It creates an instance of LibrarySystem and starts the menu.
    public static void main (String[]args){
        LibrarySystem Librarysystem = new LibrarySystem();
            Librarysystem.ShowMenu();
    }//main
}//class
