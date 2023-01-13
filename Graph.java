import java.io.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class Graph{
    int breadthfirst;
    int depthfirst;
    private int[][] adjMatrix;
    private int[] vertices;
    private boolean[] x;
    private StringBuilder string = new StringBuilder();
    private StringBuilder text = new StringBuilder();
    
    BufferedReader files1 = null;
    FileReader files2 = null;

    public Graph(String inputFile){

        try{
            files2 = new FileReader(inputFile);
            files1 = new BufferedReader(files2);
            String s = new String();
            int i = 0;
            while((s = files1.readLine()) != null){
                s = s.replaceAll("\t","");
                char[] k = s.toCharArray();
				if (i == 0){
					adjMatrix = new int[k.length][k.length];
				}
                for(int j= 0;j < k.length; j++){
                    int b = Integer.parseInt(String.valueOf(k[j]));
                    adjMatrix[i][j] = b; 
                }
                i++;
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        int num = adjMatrix.length;
        vertices = new int[num];
        x = new boolean[num];
        for (int i = 0; i < num ; i++){
            vertices[i] = i;
            x[i] = false;
        }  
    }
    public void  bft(int start, int end) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		x[start] = true;
        text.append(vertices[start]+" , ");

		while (!queue.isEmpty()) {
			int v = queue.poll();
            x[v] =true;
			breadthfirst = v;
			for (int u = 0; u < vertices.length; u++) {
                if(breadthfirst != end){
				if (adjMatrix[v][u] == 1 && !x[u]) {
					queue.add(u);
					x[u] = true;
                    breadthfirst = u;
                    if(breadthfirst == end){
                        while (!queue.isEmpty()) {
                            queue.poll();
                        }
                        text.append(vertices[u]);}
                else{
                    text.append(vertices[u]+" , ");
                }
				}
                }
            
			}
		}
	}
    public void  dft(int start,int end) {
       
       depthfirst = start;
        if(depthfirst == end){
		string = string.append(vertices[start]);}
        else{
        string = string.append(vertices[start]+" , ");
        }
		x[start] = true;
        depthfirst = start;
		for (int j = 0; j < vertices.length ; j++) {
            if(depthfirst!= end){
			if (adjMatrix[start][j] == 1 && !x[j] && start != end) {
                dft(j, end);

			}
		}
        else{
            return;
        }
    }
}
public String getdfsResult(){
    return this.string.toString();
}
public void clearStringBuilder(){
    this.text.setLength(0);
    this.string.setLength(0);
    this.breadthfirst = 0;
    this.depthfirst = 0;
    int num1 = adjMatrix.length;
        vertices = new int[num1];
        x = new boolean[num1];
        for (int i = 0; i < num1 ; i++){
            vertices[i] = i;
            x[i] = false;}
}
public String getbfsResult(){ return this.text.toString(); }
    public static void main(String[] args) {
        String inputFile = args[0] + ".txt"; 
        String query = args[1] + ".txt";
        String output1 = args[2] + ".txt" ;
        String output2 = args[3] + ".txt" ;

        Graph graph = new Graph(inputFile);
         graph.dft(0,11);
         String b = graph.getdfsResult();
         System.out.println(b);
         graph.clearStringBuilder();
         graph.dft(1,15);
         String c = graph.getdfsResult();
        System.out.println(c);
        
    }
}