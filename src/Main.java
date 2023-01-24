public class Main
{
    public static void main(String[] args)
    {
        Person Dinesh = new Person("Dinesh", "Adhikari", "000001", "Mr.", 2003);

        System.out.println(Dinesh);
        System.out.println(Dinesh.getFullName());
        System.out.println(Dinesh.getFormalName());
        System.out.println("Current age is " + Dinesh.getAge());
        System.out.println("Current at 19 " + Dinesh.getAge(2009));


    }



}