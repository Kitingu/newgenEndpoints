import ISPack.CPISDocumentTxn;
import ISPack.ISUtil.JPDBRecoverDocData;
import ISPack.ISUtil.JPISException;
import ISPack.ISUtil.JPISIsIndex;
import Jdts.Client.JtsConnection;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
//import java.net.Socket;
//import java.nio.file.Path;
//import java.nio.file.Paths;


public class JPISndex {

    public static void main(String[] args) throws JPISException, IOException {

            try {
//
                File initialFile = new File("C:\\Users\\user\\Downloads\\BN.pdf");
                String documentName  = initialFile.getAbsolutePath();

                JPDBRecoverDocData oDocDBData = new JPDBRecoverDocData();


                oDocDBData.getClass().getDeclaredFields();
                oDocDBData.m_strCabinetName="syscraftltd";
                oDocDBData.m_cCabinetType ='S';
                oDocDBData.m_strDocumentName="Document Name";
                oDocDBData.m_cDocumentType= 'I'; // I N A
                oDocDBData.m_nDocumentSize=0;
                oDocDBData.m_strKeywordList="adsgh";
                oDocDBData.m_strPysicalLocation=documentName;
                oDocDBData.m_strGlobalIndexes="";
                oDocDBData.m_strCrtBy_AppName="pdf";
                oDocDBData.m_strFolderName="AddFolderTest";
                oDocDBData.m_strOwnerName="supervisor2";
                oDocDBData.m_strDataDefName="Registration_2";
                oDocDBData.m_strDDI_Data="";
                oDocDBData.m_sVolumeId=(short)1;
                oDocDBData.m_nDocIndex=(short)1;








                System.out.printf("then here \n");
                JPISIsIndex isIndex = new JPISIsIndex();
                System.out.println("args = " + isIndex);
                System.out.printf("why are we here");
//                System.out.printf(CPISDocumentTxn.AddDocument1_MT(null, "192.168.37.5", (short) 900, "syscraftltd", (short) 1, documen, oDocDBData, "1", isIndex));
                CPISDocumentTxn.AddDocument_MT( null, "192.168.37.5", (short) 900, "syscraftltd", (short) 1, documentName, oDocDBData, "1", isIndex );
            } catch (JPISException e) {
                System.out.printf("here",e);
                throw new RuntimeException(e);
            }
        } ;
    };







//        String inputXMLString = "<?xml version=\\\"1.0\\\"?> \\n\" + \n" +
//                "\t\t\t\t\"<NGOAddDocument_Input> \\n\" + \n" +
//                "\t\t\t\t\"<Option>NGOAddDocument</Option> \\n\" + \n" +
//                "\t\t\t\t\"<CabinetName>syscraftltd</CabinetName> \\n\" + \n" +
//                "\t\t\t\t\"<UserDBId>-1606304563</UserDBId> \\n\" + \n" +
//                "\t\t\t\t\"<GroupIndex></GroupIndex> \\n\" + \n" +
//                "\t\t\t\t\"<Document> \\n\" + \n" +
//                "\t\t\t\t\"<ParentFolderIndex>35633</ParentFolderIndex> \\n\" + \n" +
//                "\t\t\t\t\"<NoOfPages>1</NoOfPages> \\n\" + \n" +
//                "\t\t\t\t\"<AccessType>S</AccessType> \\n\" + \n" +
//                "\t\t\t\t\"<DocumentName>cr1</DocumentName> \\n\" + \n" +
//                "\t\t\t\t\"<CreationDateTime>1999-10-22 9:10:52.0</CreationDateTime> \\n\" + \n" +
//                "\t\t\t\t\"<ExpiryDateTime></ExpiryDateTime> \\n\" + \n" +
//                "\t\t\t\t\"<VersionFlag>N</VersionFlag> \\n\" + \n" +
//                "\t\t\t\t\"<DocumentType>I</DocumentType> \\n\" + \n" +
//                "\t\t\t\t\"<DocumentSize>255</DocumentSize> \\n\" + \n" +
//                "\t\t\t\t\"<CreatedByApp></CreatedByApp> \\n\" + \n" +
//                "\t\t\t\t\"<CreatedByAppName></CreatedByAppName> \\n\" + \n" +
//                "\t\t\t\t\"<ISIndex>0#0#</ISIndex> \\n\" + \n" +
//                "\t\t\t\t\"<TextISIndex>0#0</TextISIndex> \\n\" + \n" +
//                "\t\t\t\t\"<FTSDocumentIndex></FTSDocumentIndex> \\n\" + \n" +
//                "\t\t\t\t\"<ODMADocumentIndex></ODMADocumentIndex> \\n\" + \n" +
//                "\t\t\t\t\"<Comment></Comment> \\n\" + \n" +
//                "\t\t\t\t\"<Author></Author> \\n\" + \n" +
//                "\t\t\t\t\"<OwnerIndex>3</OwnerIndex> \\n\" + \n" +
//                "\t\t\t\t\"<EnableLog>Y</EnableLog> \\n\" + \n" +
//                "\t\t\t\t\"<FTSFlag>PP</FTSFlag> \\n\" + \n" +
//                "\t\t\t\t\"<NameLength></NameLength> \\n\" + \n" +
//                "\t\t\t\t\"<DataDefinition> \\n\" + \n" +
//                "\t\t\t\t\"<DataDefName></DataDefName> \\n\" + \n" +
//                "\t\t\t\t\"</DataDefinition> \\n\" + \n" +
//                "\t\t\t\t\"<ImageData>000010100100011001101111011100100110110100001001000010100100001001001110001011110011001000001001001011010000100101000010010011100010110101000010010001110100001101011000010110000100011100110110010110100000101000101000011100100010110000110100001010010000101001010100010010000100010100001001010100100100010101000111010010010101001101010100010100100100000101010100010010010100111101001110000010010100111101000110000010010100001001010101010100110100100101001110010001010101001101010011000010010100111001000001010011010100010101010011000010010100000101000011010101000010110000001001010000110100000101010000001011100000100100110100001110010011100100001010010100110101010001000001010101000100010101001101010001010100111001010100000010010100111101000110000010010101000001000001010100100101010001001001010000110101010101001100010000010101001001010011000010100010100001010000011011000110010101100001011100110110010100001001011100100110010101100001011001000000100101100011011000010111001001100101011001100111010101101100011011000111100100001001011101000110100001100101000010010110111001101111011101000110010101110011000010010110111101110110011001010111001001101100011001010110000101100110001010010000101000110001000010100010111000001001000010100100001001110101011100110110100101101110011001010111001101110011000010010110111001100001011011010110010100111010000010010000101001000010010011100010110101000010010001110100001101011000010110000100011100110110010110100000101000110010000010100010111000001001000010100100111001100001011101000111010101110010011001010000100101101111011001100000100101100010011101010111001101101001011011100110010101110011011100110011101000001001000010100100001101101111011011100111001101110101011011000111010001100001011011100110001101111001000010100011001100001010001011100000100100001010010000010110010001100100011100100110010101110011011100110000100101101111011001100000100101110100011010000110010100001001011100000111001001101001011011100110001101101001011100000110000101101100000010010111000001101100011000010110001101100101000010010110111101100110000010010110001001110101011100110110100101101110011001010111001101110011001110100000100101000010011101010110100101101100011001000110100101101110011001110010111101010000011011000110111101110100000010010100111001101111001011110100100001101111011101010111001101100101000010010100111001110101011011010110001001100101011100100011101000001001000010100100110101100010011011110110110001110101000010010100110101100001011011000111010100001010000010010000101000101100000010010101001101110100011100100110010101100101011101000011101000001001000010100100101101101001011010010110110001110101000010010100110101101111011100110110000100001010011000100111010101101001011011000110010001101001011011100110011100001010000010010000101000101100000010010101000001101000011011110110111001100101000010010100111001110101011011010110001001100101011100100011101000001001000010100010101100110001001100000011011100110001001101010011001100110101001101110011100000110110001101110000101000110100000010100010111000001001000010100101000001101111011100110111010001100001011011000000100101100001011001000110010001110010011001010111001101110011001110100000100100001010010100000010111001001111001011100000100101000010010011110101100000001001001100100011001100110100001101010000100100001010001011010000100100001010001110010011000000110001001100000011000000001001001011010000100101001101010000010100001101001000010000010100101101001111010100110000100100001010001011100000101000110101000010100010111000001001000010100100000101100100011001000111001001100101011100110111001100001001011011110110011000001001011000010110111001111001000010010110111101110100011010000110010101110010000010010111000001101100011000010110001101100101000010010110111101100110000010010110001001110101011100110110100101101110011001010111001101110011001110100010100001000010011100100110000101101110011000110110100000001001010011110110011001100110011010010110001101100101000010010111010101101110011001000110010101110010000010010000101001110100011010000110010100001001011000010110001001101111011101100110010100001001011011100110000101101101011001010010100100001010001101100000101000101110000010010000101001010000011000010111001001110100011010010110001101110101011011000110000101110010011100110000100101101111011001100000100101110000011100100110111101110000011100100110100101100101011101000110111101110010000010010110111101110010000010010111000001100001011100100111010001101110011001010111001001110011000010010010110100001010010001100111010101101100011011000000100101001110011000010110110101100101000010100100111001100001011101000110100101101111011011100110000101101100011010010111010001111001000010010110000101101110011001000000101001000011011010010111010001101001011110100110010101101110011100110110100001101001011100000000101001000100011000010111010001100101000010010110111101100110000010100100001001101001011100100111010001101000000010100100011101100101011011100110010001100101011100100000101001010101011100110111010101100001011011000000100101010000011011000110000101100011011001010000100101101111011001100000101001010010011001010111001101101001011001000110010101101110011000110110010100001010010011110111010001101000011001010111001000001001010000100111010101110011011010010110111001100101011100110111001100001010010011110111001000001001010011110110001101100011011101010111000001100001011101000110100101101111011011100000101001010011011010010110011101101110011000010111010001110101011100100110010100001010010000100100010101001110010001010100010001001001010000110101010000001010010011010101011101000101010011100100010001010111010000010000101001001011010010010101010001001001010011100100011101010101000010100100101101100101011011100111100101100001011011100000101000110001001110010011100100110011001011010011000000111001001011010000101000110001001100010000101001001101000010100100111001100001011010010111001001101111011000100110100100001010010100110110111101100110011101000111011101100001011100100110010100001001010001000110010101110110000010100101001101010100010000010101010001010101010101000100111101010010010110010000100101000100010001010100001101001100010000010101001001000001010101000100100101001111010011100000101000101000010101010110111001100100011001010111001000001001011100110110010101100011011101000110100101101111011011100000100100110111001010010000101000101000011101000110111100001001011000100110010100001001011011010110000101100100011001010000100101101111011011100110110001111001000010010110100101101110000010010110001101100001011100110110010101110011000010010111011101101000011001010111001001100101000010010110000101101100011011000000100101110000011000010111001001110100011011100110010101110010011100110000100101100100011011110000100101101110011011110111010000001001011100110110100101100111011011100000100100001010011000010110001001101111011101100110010100001001011100110111010001100001011101000110010101101101011001010110111001110100001010010000101001001001001011000000100100001010001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100000100100001010011011110110011000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110001011100010111000101110000010010000101001100100011011110000100101110011011011110110110001100101011011010110111001101100011110010000100101100001011011100110010000001010011100110110100101101110011000110110010101110010011001010110110001111001000010010110010001100101011000110110110001100001011100100110010100001001011101000110100001100001011101000000100101110100011010000110010100001001011100000110000101110010011101000110100101100011011101010110110001100001011100100111001100001001011100110110010101110100000010010000101001101111011101010111010000001001011010000110010101110010011001010110100101101110000010010110000101110010011001010000100101110100011100100111010101100101000010010110000101101110011001000000100101100011011011110111001001110010011001010110001101110100000010010110000101101110011001000000100101001001000010010110110101100001011010110110010100001001011101000110100001101001011100110000100101100100011001010110001101101100011000010111001001100001011101000110100101101111011011100000100100001010011000110110111101101110011100110110001101101001011001010110111001110100011010010110111101110101011100110110110001111001000010100110001001100101011011000110100101100101011101100110100101101110011001110000100101110100011010000110010100001001011100110110000101101101011001010000100101110100011011110000100101100010011001010000100101110100011100100111010101100101000010010110000101101110011001000000100101100001011000110110001101101111011100100110010001101001011011100110011100001001000010100111010001101111000010010111010001101000011001010000100101001111011000010111010001101000011100110000100101100001011011100110010000001001010100110111010001100001011101000111010101110100011011110111001001111001000010010100010001100101011000110110110001100001011100100110000101110100011010010110111101101110011100110000100101000001011000110111010000101110000010010100010001100101011000110110110001100001011100100110010101100100000010010000101001100001011101000010111000101110001011100010111000101110001011100010111000101110001011100010111000001001010101000110100001101001011100110010111000101110001011100010111000001001011001000110000101111001000010100110111101100110001011100010111000101110001011100010111000101110001011100010111000101100001100100011000000101110001011100010111000001010010000100100010101000110010011110101001001000101000010010100110101000101000010100101001101101001011001110110111001100001011101000111010101110010011001010101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111101011111010111110101111100001010010011010110000101100111011010010111001101110100011100100110000101110100011001010000100101101111011100100000100101100011011011110110110101101101011010010111001101110011011010010110111101101110011001010111001000001001011001100110111101110010000010010100111101100001011101000110100001110011</ImageData> \\n\" + \n" +
//                "\t\t\t\t\"</Document> \\n\" + \n" +
//                "\t\t\t\t\"<TextAlsoFlag>Y</TextAlsoFlag> \\n\" + \n" +
//                "\t\t\t\t\"<DuplicateName>Y</DuplicateName> \\n\" + \n" +
//                "\t\t\t\t\"<Data></Data> \\n\" + \n" +
//                "\t\t\t\t\"<ThumbNailFlag>N</ ThumbNailFlag> \\n\" + \n" +
//                "\t\t\t\t\"<ValidateDocumentImage>Y</ValidateDocumentImage> \\n\" + \n" +
//                "\t\t\t\t\"</NGOAddDocument_Input> \\n\" + \n" +
//                "\t\t\t\t\" ";

//                System.out.printf(targetStream);
//                String docPath = documentName.normalize().toString();

//        try {
//
//            Socket sock = new Socket("192.168.37.5", 3333);
//            DataOutputStream oOut = new DataOutputStream(new BufferedOutputStream(sock.getOutputStream()));
//            Integer strLen = inputXMLString.length();
//            oOut.writeInt(strLen);
//            byte[] SendStream = new byte[strLen];
//            SendStream = inputXMLString.getBytes("8859_1");
//            oOut.writeInt(strLen);
//            oOut.write(SendStream, 0, strLen);
//            oOut.flush();
//            DataInputStream oIn = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
//            int length = 0;
//            length = oIn.readInt();
//            byte[] readStream = new byte[length];
//            oIn.readFully(readStream);
//            String stroutputXML = new String(readStream, "8859_1");
//            System.out.println("output data:  " + stroutputXML);

//                String pathString= documentName.normalize().toString();
//                 File initialFile = new File("src/main/resources/sample.txt");
//    InputStream targetStream = new FileInputStream(initialFile);