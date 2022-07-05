import java.io.*;
import java.net.*;

public class GetDocument {
//473177574
    public static void main(String[] args) {
        String inputXMLString = "<?xml version=\"1.0\"?> \n" +
                "<NGOGetDocumentProperty_Input> \n" +
                "<Option>NGOGetDocumentProperty</Option> \n" +
                "<CabinetName>syscraftltd</CabinetName> \n" +
                "<UserDBId>-473177574</UserDBId> \n" +
                "<CurrentDateTime></CurrentDateTime> \n" +
                "<DocumentIndex>30342</DocumentIndex> \n" +
                "<ParentFolderIndex>35633</ParentFolderIndex> \n" +
                "<VersionNo></VersionNo> \n" +
                "<DataAlsoFlag>N</DataAlsoFlag> \n" +
                "<ThumbNailAlsoFlag>Y<28279/ThumbNailAlsoFlag> \n" +
                "</NGOGetDocumentProperty_Input> " ;
        try {

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
            System.out.println("output data:  " + stroutputXML);
//            sock.close();
        }catch(Exception e) {System.out.println("output error:  " + e);}


    }

}
