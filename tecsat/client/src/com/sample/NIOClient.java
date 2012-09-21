package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class NIOClient {

    SelectionKey selkey=null;
    Selector sckt_manager=null;
    public static void coreClient()
    {

        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        SocketChannel sc = null;
        try
        { sc = SocketChannel.open();
        sc.configureBlocking(false);       
        sc.connect(new InetSocketAddress(8964));  
        while (!sc.finishConnect())
        {   
        } 

        System.out.println("Enter the text");
        String HELLO_REQUEST =stdin.readLine().toString();

        System.out.println("Sending a request to HelloServer");    
        ByteBuffer buffer = ByteBuffer.wrap(HELLO_REQUEST.getBytes());    
        sc.write(buffer); 


        } 
        catch (IOException e) 
        {          
            e.printStackTrace();    
        }
        finally
        {       
            if (sc != null)
            {            
                try 
                {             
                    sc.close();            
                }
                catch (Exception e)
                {           
                    e.printStackTrace();       
                }       
            } 
        }   }

    public static void main(String args[]) {
        coreClient();

    }
}