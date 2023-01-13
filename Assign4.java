/**
@author Hridika Banik <a 
href="mailto:hridika.banik@ucalgary.ca">firstname.lastname@ucalgary.ca</a>
@version 1.6
@since 1.0
UCID: 30123716
Tutorial number: T05
TA Name: Roghayeh Heidari
*/
import java.io.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Assign4 {
    
    public static void main(String[] args) throws IOException { 
        if (args.length != 4) {
            System.out.println("Arguments are of invalid number. Enter again.");
            System.exit(1);
        }
        String inputFile = args[0] + ".txt"; 
        String query = args[1] + ".txt";
        String output1 = args[2] + ".txt" ;
        String output2 = args[3] + ".txt" ;
        BufferedReader filename = null;
        FileReader file2 = null;
        FileWriter writedfs = null;
        FileWriter writebfs = null;
        BufferedWriter buffer1 = null;
        BufferedWriter buffer2 = null;
        Graph graph = new Graph(inputFile);


        try {
            file2 = new FileReader(query);
            filename = new BufferedReader(file2);
            writedfs = new FileWriter(output1);
            writebfs = new FileWriter(output2);
            buffer1 = new BufferedWriter(writedfs);
            buffer2 = new BufferedWriter(writebfs);
            String str = new String();

        buffer1.write("Depth-First Traversal");
        buffer1.append("\n");
        buffer2.write("Breath-First Traversal");
        buffer2.append("\n");

        while ((str = filename.readLine()) != null) {
        String f[] = str.split("\t");
        int start = Integer.parseInt(f[0]);
        int end = Integer.parseInt(f[1]);
        
        graph.dft(start,end);
        String b = graph.getdfsResult();
        buffer1.append("Path of "+"["+str+ "]").append("\n");
        buffer1.append(b). append("\n");
        graph.clearStringBuilder(); 
        graph.bft(start,end);
        String c = graph.getbfsResult();
        buffer2.append("Path of "+"["+str+ "]").append("\n");
        buffer2.append(c).append("\n");  
        graph.clearStringBuilder(); 
            }

        buffer1.close();
        buffer2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
        
}
