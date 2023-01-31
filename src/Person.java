import java.time.Year;
import java.util.Objects;

/**
 * @author Dinesh Adhikari
 *
 *
 */

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private Integer YOB;

    static private int IDSeed = 1;

    public static void setIDSeed(int IDSeed) {Person.IDSeed = IDSeed;}

    public static int getIDSeed(){return IDSeed;}

    public Person(String ID,String firstName, String lastName,String title, Integer YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, Integer YOB)
    {
        this.ID = this.genID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    private String genID()
    {
        String newID = "" + IDSeed;
        while (newID.length() < 8)
        {
            newID = "0" + newID;
        }
        IDSeed++;
        return newID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYOB() {
        return YOB;
    }

    public void setYOB(Integer YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ID='" + ID + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**
     * Method to get the full name from the Person Object
     *
     * @return return the first nd last names as a full name String
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    /**
     * Method to get the foraml name from the Person Object
     *
     * @return the title, first, and last arranged as a formal name String
     */
    public String getFormalName()
    {
        return title + " " + firstName + " " + lastName;
    }

    //

    /**
     * Get the age as an int assuming that it is for the current year
     *
     * @return the current age
     *
     */
    public int getAge()
    {
        return Integer.parseInt(Year.now().toString()) - YOB;
    }

    /**
     *
     * @param year the year that you want to sue to determine the age of that time
     * @return
     */
    public int getAge(int year)
    {
        return year - YOB;

    }

    /**
     * @return Retruns the object data in CSV format
     */
    public String toCSVRecord()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(ID, person.ID) && Objects.equals(title, person.title) && Objects.equals(YOB, person.YOB);
    }


    /**
     * XML Data for Person
     * <Person>
     *     <ID>ID</ID>
     *     <firstName>firstName</firstName>
     *     <LastName>lastName</LastName>
     *     <title>title</title>
     *     <YOB>YOB</YOB>
     * </Person>
     *
     */
    public String toXMLRecord()
    {
        String retString = "";

        retString = "<IDNum>" + this.ID + "</IDNum>";
        retString += "<firstName>" + this.firstName + "</firstName>";
        retString += "<lastName>" + this.lastName + "</lastName>";
        retString += "<title>" + this.title + "</title>";
        retString += "<YOB>" + this.YOB + "</YOB>";

        return retString;

    }

    /**
     *
     * @return The object data in JSON format
     */
    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';  // Assign the double quote char to a variable
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + this.ID + DQ + ",";
        retString += DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + this.lastName + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + this.title +DQ + ";";
        retString += " " + DQ + "YOB"  + DQ + ":" + this.YOB + "}";

        return retString;
    }
}




