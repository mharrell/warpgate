package Common;

import java.io.File;
import java.lang.System;



public class testSetup {




    public static void getTestFiles(){

        System.out.println("---Beginning Test Setup---");
        System.out.println("---Gathering Test Scenarios---");

        File folder = new File("TestCases/TMDB");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }

    }

}
