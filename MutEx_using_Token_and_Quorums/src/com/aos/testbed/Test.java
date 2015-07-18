package com.aos.testbed;

import java.util.concurrent.PriorityBlockingQueue;

import com.aos.client.TestClient;
import com.aos.common.QueueObject;
import com.aos.server.TestServer;

public class Test 
{
	public static void main(String args[])
	{		
		PriorityBlockingQueue<QueueObject> sharedQueue = new PriorityBlockingQueue<QueueObject>();
		
		int[] node1Quorum = {1,2,3}; 
		
		System.out.println("Initiating Sequence");
		TestServer node1Server = new TestServer(1,sharedQueue,node1Quorum,true);
		TestClient node1Client = new TestClient(1,sharedQueue,node1Quorum,true);
				
		node1Server.start();

		try
		{
			Thread.sleep(50*1000);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
		node1Client.start();
	}
}
