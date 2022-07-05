import ISPack.CPISDocumentTxn;
import ISPack.ISUtil.JPDBRecoverDocData;
import ISPack.ISUtil.JPISException;
import ISPack.ISUtil.JPISIsIndex;

import java.io.File;
import java.io.IOException;

public class UploadImage {
    public static void main(String[] args) throws JPISException, IOException {

        try {
            File initialFile = new File("C:\\Users\\Administrator\\Downloads\\FolderDataSummaryReport.pdf");
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

            CPISDocumentTxn.AddDocument_MT( null, "197.232.113.230", (short) 900, "syscraftltd", (short) 1, documentName, oDocDBData, "1", isIndex );
        } catch (JPISException e) {
            System.out.printf("here",e);
            throw new RuntimeException(e);
        }
    } ;
}
