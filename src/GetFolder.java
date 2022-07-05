import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class GetFolder {
    //473177574
    public static void main(String[] args) {
        String inputXMLString = "<?xml version=\"1.0\"?>\n" +
                "\n" +
                "<NGOGetFolderProperty_Input>\n" +
                "\n" +
                "  <Option>NGOGetFolderProperty</Option>\n" +
                "\n" +
                "  <CabinetName>syscraftltd</CabinetName>\n" +
                "\n" +
                "  <UserDBId>-473177574</UserDBId>\n" +
                "\n" +
                "  <CurrentDateTime></CurrentDateTime>\n" +
                "\n" +
                "  <FolderIndex>35633</FolderIndex>\n" +
                "\n" +
                "  <DataAlsoFlag>N</DataAlsoFlag> // get the folder data as well\n" +
                "\n" +
                "</NGOGetFolderProperty_Input>\n" +
                "\n" ;
        try {
//http://197.232.113.230/
            Socket sock = new Socket ("197.232.113.230", 3333) 	;
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
            System.out.println("output data:  " + stroutputXML);
//            sock.close();
        }catch(Exception e) {System.out.println("output error:  " + e);}


    }
}
