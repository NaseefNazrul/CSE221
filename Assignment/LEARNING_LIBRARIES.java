import java.util.*;
import java.io.*;

// THIS IS NOT PART OF THE ASSIGNMENT 
// Just use AI the way u wanna for syntax no one rly cares 
// Just a rough note you can check it out
// made this to learn some new methods and syntaxes as there are no limits

public class LEARNING_LIBRARIES {
    // Learn how to work with static variables
    private static String static_variable = "SataaaAndaagiii";

    public static void main(String[] args) throws Exception{
        // The way to take input, memorize this shit no other way

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Basically takes the input as a whole
        PrintWriter pw = new PrintWriter(System.out); // Printing methods, faster than System.out.print()

        pw.println("Advising sucks");
        pw.close(); // Put this near the end please dont forget 

        StringTokenizer st = new StringTokenizer(br.readLine()); // takes a single line from br.readLine()
        String temp = st.nextToken(); // basically takes an element till theres a space between the line example: 1 2 3 4 --> will give 1


//-------------------------------------------------------------------------------------------------------
        
        int[] arr = new int[2];
        Arrays.fill(arr, -1); // This basicaly fills the array with -1: {-1,-1}


//-------------------------------------------------------------------------------------------------------
        // queue
        Queue<Integer> queue = new ArrayDeque<>(); // Queue
        queue.offer(1); // enqueue
        int x = queue.poll(); // dequeue
        boolean check = queue.isEmpty(); // isEmpty or not


//-------------------------------------------------------------------------------------------------------
        // Stack
        Deque<Integer> stack = new ArrayDeque<>(); // Stack
        stack.push(10); // push
        int z = stack.pop(); // pop
        boolean check2 = stack.isEmpty(); // isEmpty or not


//-------------------------------------------------------------------------------------------------------
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

        
//-------------------------------------------------------------------------------------------------------
        // Alternative to string concatenation
        StringBuilder sb = new StringBuilder(); // Faster when concatenating strings
        sb.append("I ").append(" hate").append(" this").append(" course."); // way to concatenate
        // Much superior than using string + string to concatenate
        // Be careful of the return types of using in a method
        // use this as a static variable


//-------------------------------------------------------------------------------------------------------
        // Some assignmets wont allow this but holy these are so helpful 
        Collections.reverse(arr_list); // reverses
        Collections.sort(arr_list); // sorts
        COllections.swap(arr_list,index1,index2); // swap
        // There are a lot more, use AI to explore them

//-------------------------------------------------------------------------------------------------------
        // Min-heap sorted by distance (index 0)
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); // I dont really know what the (a, b) -> Long.compare(a[0], b[0]) even means but apparantly its a comparator and you shouldnt touch it mukhosto kor shesh
        // Push source node with distance 0
        pq.offer(new long[]{0, sourceNode});
        // Push updated neighbor distance inside your loop
        pq.offer(new long[]{newDistance, neighborNode});
    }
}