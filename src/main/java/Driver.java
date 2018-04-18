/**********************
 Hambartzum Gamburian
 Driver.java
 **********************/

import java.util.*;

public class Driver {

    public static void main(String[] args) {

        //Creating the PQ using Heap Implementation of type PrintJob
        PQ_Heap<PrintJob> queue = new PQ_Heap<PrintJob>();

        //Auto incrementing job number variable declaration
        int jobN = 1;

        //Creating the PrintJob objects
        PrintJob instructor, ta, student;

        //User input
        Scanner input = new Scanner(System.in);

        String cmd = "";

        while(!cmd.equals("4")) {

            //Prompt menu
            System.out.println("\nPrinter queue\n=============\n1. Add Job\n2. Print Job\n3. View Jobs\n4. Exit");
            System.out.print("Enter Choice Using Numbers: ");

            //User input
            cmd = input.nextLine();
            System.out.println();

            switch(cmd) {
                case "1": System.out.print("Instructor (I or i), TA (T or t), or Student (S or s): ");
                    //Lowercase to not worry about capitalization
                    cmd = input.nextLine().toLowerCase();
                    System.out.println();

                    if (cmd.equals("i")) {
                        //Create the instructor PrintJob object
                        instructor = new PrintJob(3, jobN);
                        //Adding to priority queue
                        queue.add(instructor);
                        //Incrementing job number for next use
                        jobN++;
                        System.out.println("Successfully added instructor print job to the queue.");
                    }

                    else if (cmd.equals("t")) {
                        //Create the ta PrintJob object
                        ta = new PrintJob(2, jobN);
                        //Adding to priority queue
                        queue.add(ta);
                        //Incrementing job number for next use
                        jobN++;
                        System.out.println("Successfully added TA print job to the queue.");
                    }

                    else if (cmd.equals("s")) {
                        //Create the student PrintJob object
                        student = new PrintJob(1, jobN);
                        //Adding to priority queue
                        queue.add(student);
                        //Incrementing job number for next use
                        jobN++;
                        System.out.println("Successfully added student print job to the queue.");
                    }

                    else {
                        System.out.println("Unknown character entered.");
                    }
                    break;

                case "2": if(queue.isEmpty()) {
                    System.out.println("No print jobs in queue.");
                }

                else { //Make sure it's not empty
                    System.out.println("Now printing " + queue.remove());
                }
                    break;

                case "3": if(queue.isEmpty()) {
                    System.out.println("No print jobs in queue.");
                }

                else { //Make sure it's not empty
                    System.out.println(queue.viewValues());
                }
                    break;
                //If user inputs anything else besides "I", "i", "T", "t", "S", "s", or "4"
                //prompt with this error string and start from beginning of while loop
                default: if (!cmd.equals("4")) {
                    System.out.println("Unrecognized command, please try again.");
                }
                    break;

            }

        }
        //Quitting
        System.out.println("Thank you for printing with us. Exitting Program...");

    }

}