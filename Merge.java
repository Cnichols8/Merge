import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Merge {

        public static void main(String[] args) throws FileNotFoundException {
            ArrayList<ArrayQueue> arrayQueue = new ArrayList<>(); //creating a new array list.
            ArrayList<ArrayList<String>> mainList = new ArrayList<>(); //creating another array list.
            ListQueue listQueue = new ListQueue(); //creating a new list to hold the final values after going through each file.
            int num = 0; //initializing num to zero.
            while (num < args.length) { //checking to see if the amount of numbers is less than the array length.
                num++; // incrementing num.
            }
            for (int i = 0; i < num; i++) { //walking through the data set.
                arrayQueue.add(new ArrayQueue()); // adding the data to the arrayQueue.
            } // end walking through data set.
            for (int i = 0; i < arrayQueue.size(); i++) {
                ArrayList<String> numList = new ArrayList<>(); //creating a new array list.
                Scanner sc = new Scanner(new File(args[i])); //reading in the args.
                while (sc.hasNextLine()) { //checking to see if the args has lines following the first set.
                    numList.add(sc.nextLine()); //adding the data from the file int the array list numList.
                }
                mainList.add(numList); //adding the data from numList into the array list of mainList.
            }
            for (int i = 0; i < mainList.size(); i++) { //walking through the data that is now in the mainList.
                while (arrayQueue.get(i).size < 10 && mainList.get(i).size() > 0) { //calling the class of arrayQueue and getting i then checking the size
// of the main list against the set capacity of 10 and checking to make sure mainList size is greater than 0.
                    arrayQueue.get(i).enqueue(mainList.get(i).get(0)); //calling the method enqueue from the ArrayQueue class and enqueueing the data
//into the array list of arrayQueue.
                    mainList.get(i).remove(0); // removing the data from the mainList because the data has been moved into the arrayQueue list.
                } //this while loop will continue to run until all pieces of data have been checked with the conditions within the while loop.
            }
             while (arrayQueue.size() > 0) { //checking if the array list arrayQueue is greater than zero.
                if (arrayQueue.size() == 1) {
                    listQueue.enqueue((arrayQueue.get(0).dequeue())); // enqueueing using the class ListQueue starting at
// at the index of zero then dequeue the data from the array list arrayQueue.
                    if (arrayQueue.get(0).size == 0 || mainList.get(0).size() == 0) { //checking the size of the array list
// at index 0 along with the mainList size at index zero. Both is making sure index zero equals zero.
                            mainList.remove(0); // removing the data from the index in mainList.
                            arrayQueue.remove(0); // removing the data from the index in arrayQueue.
                        }
                        else {
                            arrayQueue.get(0).enqueue(mainList.get(0).get(0)); //enqueuing into the newest array list leading
// into the removal of the data in the mainList.
                            mainList.get(0).remove(0); // removing at index after enqueueing into the newest array list.
                    }
                }
                else {
                    int arrayIndex = 0; //initializing arrayIndex, so we can use it in the later statements.
                    for (int i = 1; i < arrayQueue.size(); i++) { // walking through the data set in the arrayQueue list.
                        if (Integer.parseInt(arrayQueue.get(i).front()) <= Integer.parseInt(arrayQueue.get(arrayIndex).front())) { //finding the front of the data
// we have to use the parseInt because the data values are strings but to find the front we need the integer value.
                            arrayIndex = i; // arrayIndex to equal i as it goes through the walking of the data.
                        }
                        if (i == arrayQueue.size() - 1) {  // checking if i is equal to the array list of arrayQueue minus 1
                            String hold = arrayQueue.get(arrayIndex).dequeue(); //creating a holding value for the dequeue
//data to put into the final list from the data sets
                            listQueue.enqueue(hold); //enqueuing the data that the hold variable is holding on to.
// The data that hold is associated with is dequeued from the array list arrayQueue and sticks it into the listQueue for the final print out.
                            if (arrayQueue.get(arrayIndex).size == 0) { //checking if arrayIndex in arrayQueue is equal to 0.
                                if (mainList.get(arrayIndex).size() == 0) { //checking if arrayIndex in mainList is equal to 0.
                                    mainList.remove(arrayIndex); //totally removing the data from the mainList.
                                    arrayQueue.remove(arrayIndex); //totally removing the data from the arrayQueue.
                                }
                                else {
                                    arrayQueue.get(arrayIndex).enqueue(mainList.get(arrayIndex).get(0)); //enqueuing at the arrayIndex
// from the data associated with the mainList then in the following line removing the data since we have already moved it out.
                                    mainList.get(arrayIndex).remove(0); // removing at the arrayIndex
                                }
                            }
                        }
                    }
                }
            }
            while (listQueue.size != 0) { //checking if the size does NOT equal zero.
                System.out.println(listQueue.dequeue()); // printing out the result.
            }
        }
    }