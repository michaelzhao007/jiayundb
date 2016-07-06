package com.jiayun.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.jiayun.internal.BTree;
import com.jiayun.internal.BTree.Entry;

public class Server {
	public static void main(String[] args) throws IOException {
	   BTree tree = new BTree();
       ServerSocket server = new ServerSocket(9999);
       Socket clientSocket = null;
       try {
    	   clientSocket = server.accept();
       }
       catch (IOException e) 
       { 
        System.err.println("Accept failed."); 
        System.exit(1); 
       } 
       

       PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), 
                                         true); 
       BufferedReader in = new BufferedReader( 
               new InputStreamReader( clientSocket.getInputStream()));
       
       String inputLine; 

       while ((inputLine = in.readLine()) != null) 
           { 
    	    String[] token = inputLine.split(" ");
    	    if(token.length > 1) {
               tree.insert(new Entry(token[0], token[1])); 
               out.println("success insert");
    	    }
    	    else if(token.length == 1) {
    	    	String str = (String) tree.get(token[0]);
    	    	if(str!=null) out.println(str);
    	    }
            if (inputLine.equals("Bye.")) 
                break; 
           } 

       out.close(); 
       in.close(); 
       clientSocket.close(); 
       server.close(); 
	}
}
