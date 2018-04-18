/**********************
 Hambartzum Gamburian
 PrintJob.java
 **********************/

public class PrintJob implements Comparable<PrintJob> {

    //Declaring PrintJob object variables
    private int userID;
    private String userName;
    private int jobNumber;

    //Creating the PrintJob object
    public PrintJob(int newUserID, int newJobNumber) {
        userID = newUserID;
        jobNumber = newJobNumber;

        //Assigning names based on userID given in object creation
        switch(userID) {
            case 1: userName = "Student"; break;
            case 2: userName = "TA"; break;
            case 3: userName = "Instructor"; break;
        }
    }

    public String getUserName() {
        return userName;
    }

    public int getUserID() {
        return userID;
    }

    public int getJobNumber() {
        return jobNumber;
    }

    public String toString() {
        return "Job #" + jobNumber + ": " + userName;
    }

    //CompareTo() method, which is used by my PQ_Heap Class when sifting up or down
    //This is how the priority is assigned in the priority queue/heap
    public int compareTo(PrintJob another) {
        if(getUserID() == another.getUserID()) {
            return 0;
        }

        else if(getUserID() > another.getUserID()) {
            return 1;
        }

        else {
            return -1;
        }
    }


}