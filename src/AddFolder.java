import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class AddFolder {
    public static void main(String[] args) {
        String inputXMLString = "<?xml version=\"1.0\"?>\n" +
                "\n" +
                "<NGOAddFolder_Input>\n" +
                "\n" +
                "<Option>NGOAddFolder</Option>\n" +
                "\n" +
                "<CabinetName>syscraftltd</CabinetName>\n" +
                "\n" +
                "<UserDBId>93872458</UserDBId>\n" +
                "\n" +
                "<Folder>\n" +
                "\n" +
                "<ParentFolderIndex>35633</ParentFolderIndex>\n" +
                "\n" +
                "<FolderName>Another Folder from sockets</FolderName>\n" +
                "\n" +
                "<CreationDateTime></CreationDateTime>\n" +
                "\n" +
                "<AccessType>S</AccessType>\n" +
                "\n" +
                "<ImageVolumeIndex>16</ImageVolumeIndex>\n" +
                "\n" +
                "<FolderType>G</FolderType>\n" +
                "\n" +
                "<Location>G</Location>\n" +
                "\n" +
                "<Comment></Comment>\n" +
                "\n" +
                "<Owner>2</Owner>\n" +
                "\n" +
                "<LogGeneration>Y</LogGeneration>\n" +
                "\n" +
                "<EnableFtsFlag>Y</ EnableFtsFlag>\n" +
                "\n" +
                "<DuplicateName>Y</DuplicateName>\n" +
                "\n" +
                "</Folder>\n" +
                "\n" +
                "</NGOAddFolder_Input>\n" +
                "\n" ;
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

//output
//<NGOAddFolder_Output>
//<Option>NGOAddFolder</Option>
//<Status>0</Status><UserDBId>93872458</UserDBId><LoginUserIndex>2</LoginUserIndex><LoginUserRights>11111111111</LoginUserRights><Folder>
//<FolderIndex>36634</FolderIndex><ParentFolderIndex>35633</ParentFolderIndex><FolderName>Another Folder from sockets</FolderName><OwnerIndex>2</OwnerIndex><CreationDateTime>2022-06-30 11:07:31.457</CreationDateTime><RevisedDateTime>2022-06-30 11:07:31.457</RevisedDateTime><AccessDateTime>2022-06-30 11:07:31.457</AccessDateTime><DataDefinitionIndex>0</DataDefinitionIndex><AccessType>S</AccessType><ImageVolumeIndex>16</ImageVolumeIndex><FolderType>G</FolderType><FolderLock>N</FolderLock><Location>G</Location><DeletedDateTime>2122-06-30 11:07:31.457</DeletedDateTime><VersionFlag>Y</VersionFlag><ExpiryDateTime>2122-06-30 11:07:31.457</ExpiryDateTime><Comment></Comment><FinalizedFlag>N</FinalizedFlag><FinalizedDateTime>2122-06-30 11:07:31.457</FinalizedDateTime><ACLMoreFlag>N</ACLMoreFlag><EnableFTSFlag>N</EnableFTSFlag><OwnerInheritance>N</OwnerInheritance><ISSecureFlag>N</ISSecureFlag><Hierarchy>0.35633.</Hierarchy><Owner>Supervisor2</Owner><LockByUser>NULL</LockByUser><FinalizedBy>NULL</FinalizedBy><OwnerType>U</OwnerType><NoOfSubFolders>0</NoOfSubFolders><NoOfDocuments>0</NoOfDocuments><NoOfReferencedDocuments>0</NoOfReferencedDocuments></Folder>
//</NGOAddFolder_Output>