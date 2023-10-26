import java.net.*;
import java.io.*;
class ServerChatApp{
	public static void main(String args[])
	{
	   try{
	       ServerSocket objSS =  new ServerSocket(5000);
	       Socket objS = objSS.accept();
	       DataInputStream objDIS= new DataInputStream(objS.getInputStream());
	       DataOutputStream objDOS= new DataOutputStream(objS.getOutputStream());
	       BufferedReader objBR = new BufferedReader(new InputStreamReader(System.in));
           String strIP="";
           String strOP="";
           while(!strIP.equals("Q")){
                strIP= objDIS.readUTF();
                System.out.println("Client says:"+strIP);
                strOP=objBR.readLine();
                objDOS.writeUTF(strOP);
                objDOS.flush();
           }
           objDIS.close();
           objDOS.close();
           objS.close();
           objSS.close();
	  	  }
	  	   catch(Exception ex)
	  	   {
	  	   System.err.println(ex);
	  	   }
	}
}