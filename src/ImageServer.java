import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ImageServer {
    public static void main(String[] args) {
//        searchFolder
//        addFolder

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
        try {

            Socket sock = new Socket ("127.0.0.1", 3333) 	;
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
            System.out.println(stroutputXML);
            sock.close();
        }catch(Exception e) {System.out.println(e);}
    }
}
