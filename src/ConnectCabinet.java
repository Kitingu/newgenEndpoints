import java.io.*;
import java.net.*;
import java.util.Scanner;
public class ConnectCabinet {

    public static String connectCab(){
        String inputXMLString = "<?xml version=\"1.0\"?> \n" +
                "<NGOConnectCabinet_Input> \n" +
                "<Option>NGOConnectCabinet</Option> \n" +
                "<CabinetName>syscraftltd</CabinetName> \n" +
                "<UserName>supervisor2</UserName> \n" +
                "<UserPassword>supervisor351</UserPassword> \n" +
                "<CurrentDateTime></CurrentDateTime> \n" +
                "<UserExist>N</UserExist> \n" +
                "<MainGroupIndex>0</MainGroupIndex> \n" +
                "<UserType>U</UserType> \n" +
                "<Locale>en-US</Locale> \n" +
                "<ApplicationName>N</ApplicationName> \n" +
                "<ApplicationInfo>null</ApplicationInfo> \n" +
                "<Hook>Omnidocs Client</Hook> \n" +
                "</NGOConnectCabinet_Input> " ;
        String returnValue ="";
        try {
//            197.232.113.230/
            Socket sock = new Socket ("192.168.37.5", 3333) 	;
            DataOutputStream oOut = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
            Integer strLen = inputXMLString.length();
            oOut.writeInt(strLen);
            byte[] SendStream = new byte[strLen];
            SendStream = inputXMLString.getBytes("8859_1");
            oOut.writeInt(strLen);
            oOut.write(SendStream, 0, strLen);
            oOut.flush();
            DataInputStream oIn = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
            int length = 0;
            length = oIn.readInt();
            byte[] readStream = new byte[length];
            oIn.readFully(readStream);
            String stroutputXML = new String(readStream, "8859_1");
//            System.out.println(stroutputXML);
            sock.close();
            returnValue=stroutputXML;
            return stroutputXML ;
        }catch(Exception e) {System.out.println(e);}
        return returnValue;
    }
    public static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
    }
    public static void main(String[] args) {
        System.out.printf("printing now");
        String data = connectCab();
       String userId= getTagValue(data,"UserDBId");

        System.out.println(userId);
        //        searchFolder
//        addFolder


        }


}
