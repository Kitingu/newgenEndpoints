import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.Socket;

public class IntegrationLogic {

    public static String mainFunction( String connectionString) throws IOException {
        Socket sock = new Socket ("192.168.37.5", 3333) 	;
        DataOutputStream oOut = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
        Integer strLen = connectionString.length();
        oOut.writeInt(strLen);
        byte[] SendStream = new byte[strLen];
        SendStream = connectionString.getBytes("8859_1");
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
        return stroutputXML;
    }
    public static String getTagValue(String xml, String tagName){
        return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
    }
    public static String InsertXml(String xmlString, String mainTag, String tagName, String tagValue) throws Exception {
        // --------- LOAD XML
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader(xmlString)));

        // --------- PROCESS
        NodeList fieldNodes = doc.getElementsByTagName(mainTag);

        for (int i = 0; i < fieldNodes.getLength(); i++) {
            NodeList children = fieldNodes.item(i).getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                String childNode = children.item(j).getNodeName();
                if (childNode.equalsIgnoreCase(tagName)) {
                    children.item(j).setTextContent(String.valueOf(tagValue));
                } else if (childNode.equalsIgnoreCase("lastName")) {
                    children.item(j).setTextContent(String.valueOf("Doe"));
                }
            }
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        String outputString = writer.getBuffer().toString();
//        System.out.println(writer.getBuffer().toString());
        return outputString;
    }

    public static void disconnectCabinet(String userDbId) throws Exception {
        String connectionString = "<?xml version=\"1.0\"?>\n" +
                "\n" +
                "<NGODisconnectCabinet_Input>\n" +
                "\n" +
                "  <Option>NGODisconnectCabinet</Option>\n" +
                "\n" +
                "  <CabinetName>syscraftltd</CabinetName>\n" +
                "\n" +
                "  <UserDBId></UserDBId>\n" +
                "\n" +
                "</NGODisconnectCabinet_Input>\n";
        String newString = InsertXml(connectionString,"NGODisconnectCabinet_Input","UserDBId",userDbId);
        mainFunction(newString);


        // TODO Auto-generated method stub

    }

    public static String connectCabinet() throws IOException {
        String connectionString = "<?xml version=\\\"1.0\\\"?> \\n\" +\n" +
                "                \"<NGOConnectCabinet_Input> \\n\" +\n" +
                "                \"<Option>NGOConnectCabinet</Option> \\n\" +\n" +
                "                \"<CabinetName>syscraftltd</CabinetName> \\n\" +\n" +
                "                \"<UserName>supervisor2</UserName> \\n\" +\n" +
                "                \"<UserPassword>supervisor351</UserPassword> \\n\" +\n" +
                "                \"<CurrentDateTime></CurrentDateTime> \\n\" +\n" +
                "                \"<UserExist>N</UserExist> \\n\" +\n" +
                "                \"<MainGroupIndex>0</MainGroupIndex> \\n\" +\n" +
                "                \"<UserType>U</UserType> \\n\" +\n" +
                "                \"<Locale>en-US</Locale> \\n\" +\n" +
                "                \"<ApplicationName>N</ApplicationName> \\n\" +\n" +
                "                \"<ApplicationInfo>null</ApplicationInfo> \\n\" +\n" +
                "                \"<Hook>Omnidocs Client</Hook> \\n\" +\n" +
                "                \"</NGOConnectCabinet_Input> ";
        String data = mainFunction(connectionString);
        String userId = getTagValue(data,"UserDBId");
        System.out.printf(userId);
        return userId;
    }

    public static void addFolder(String parentFolder) {
        String connectionString ="<?xml version=\\\"1.0\\\"?>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<NGOAddFolder_Input>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<Option>NGOAddFolder</Option>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<CabinetName>syscraftltd</CabinetName>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<UserDBId>93872458</UserDBId>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<Folder>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<ParentFolderIndex>+parentFolder+</ParentFolderIndex>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<FolderName>Another Folder from sockets</FolderName>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<CreationDateTime></CreationDateTime>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<AccessType>S</AccessType>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<ImageVolumeIndex>16</ImageVolumeIndex>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<FolderType>G</FolderType>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<Location>G</Location>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<Comment></Comment>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<Owner>2</Owner>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<LogGeneration>Y</LogGeneration>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<EnableFtsFlag>Y</ EnableFtsFlag>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"<DuplicateName>Y</DuplicateName>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"</Folder>\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"</NGOAddFolder_Input>\\n\" +\n" +
                "                \"\\n";

    }
    public static void main(String[] args) throws Exception {

        String userID = connectCabinet();
//        addFolder("35633");
        disconnectCabinet(userID);


    }
}
