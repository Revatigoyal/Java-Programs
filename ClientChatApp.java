import java.net.*;
import java.io.*;
class ClientChatApp{
	public static void main(String args[])
	{
	    try{
	        Socket objs = new Socket("192.168.0.102",5000);
	        DataInputStream objDIS =new DataInputStream(objs.getInputStream());
            DataOutputStream objDOS =new DataOutputStream(objs.getOutputStream());
            BufferedReader objBR =new BufferedReader(new InputStreamReader(System.in));
            String strIP="";
            String strOP="";
            while(!strIP.equals("Q"))
            {
               strIP= objDIS.readUTF();
               System.out.println("CLient says:"+strIP);
               strOP = objBR.readLine();
               objDOS.writeUTF(strOP);
               objDOS.flush();
            }
            objDIS.close();
            objDOS.close();
            objs.close();
	    }
	    catch(Exception ex)
	    {
	       System.err.println(ex);
	    }
	}
}