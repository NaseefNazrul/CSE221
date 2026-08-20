
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;

// THIS IS NOT PART OF THE ASSIGNMENT 
// made this to learn some new methods and syntaxes as there are no limits

public class LEARNING_LIBRARIES {
    public static void main(String[] args) throws Exception{



        int[] arr = new int[2];
        Arrays.fill(arr, -1); // This basicaly fills the array with -1: {-1,-1}


        // queue
        Queue<Integer> queue = new ArrayDeque<>(); // Queue
        queue.offer(1); // enqueue
        int x = queue.poll(); // dequeue
        boolean check = queue.isEmpty(); // isEmpty or not



        // Stack
        Deque<Integer> stack = new ArrayDeque<>(); // Stack
        stack.push(10); // push
        int z = stack.pop(); // pop
        boolean check2 = stack.isEmpty(); // isEmpty or not



        // ArrayList
        ArrayList<Integer> arr_list = new ArrayList<>(); // Dynamic array
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // Making Adjacent Lists graph
        arr_list.add(1); // appending
        arr_list.get(0); // return element from index
        arr_list.set(0,2); // set another element in index 0 (2 in this case)
        for (int y : arr_list) { // looping through the array_list
                System.out.println(y);
            }
        arr_list.size(); // Size

        

        StringBuilder sb = new StringBuilder(); // Faster when concatenating strings
        sb.append("I ").append(" hate").append(" this").append(" course."); // way to concatenate
        // Much superior than using string + string to concatenate
        // Be careful of the return types of using in a method
        // use this as a static variable



        // Some assignmets wont allow this but holy these are so helpful 
        Collections.reverse(arr_list); // reverses
        Collections.sort(arr_list); // sorts
        COllections.swap(arr_list,index1,index2) // swap
        // There are a lot more, use AI to explore them
    }
}