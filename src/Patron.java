public class Patron {

//These are the Variables used for the Patrons information
    private String digit_ID_number;
    private String name;
    private String address;
    private double fine_amounts;

//Constructor for how information will be inputted (//4567891-Avery Jones-1919 Pine Lance Blvd. Oviedo, FL 32478-1.36)
    public Patron(String digit_ID_number, String name, String address, double fine_amounts) {
        this.digit_ID_number = digit_ID_number;
        this.name = name;
        this.address = address;
        this.fine_amounts = fine_amounts;
    }

//Getters
    public String getDigit_ID_number() {
        return digit_ID_number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getFine_amounts() {
        return fine_amounts;
    }

//Setters
    public void setDigit_ID_number(String digit_ID_number) {
        this.digit_ID_number = digit_ID_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFine_amounts(double fine_amounts) {
        this.fine_amounts = fine_amounts;
    }

//Display Patron Info (//4567891-Avery Jones-1919 Pine Lance Blvd. Oviedo, FL 32478-1.36)
    public void Display_Patron_Info(){
        System.out.println( digit_ID_number + "-" + name + "-" + address + "-" + fine_amounts );
    }
}
