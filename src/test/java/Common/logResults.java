package Common;

public class logResults {

    public static int fail = 0, pass = 0;


    public static void showResults(){
        System.out.println("\n\n\n---Testing Has Concluded---\n");
        System.out.println("Tests run: " + (fail + pass));
        System.out.println("Tests passed: " + pass);
        System.out.println("Tests failed: " + fail);
    }


    public static void logFailure(String message){
        fail++;
        System.out.println(message);
    }

    public static void logPassing(String message){
        pass++;
        System.out.println(message);
    }


}
