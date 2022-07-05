import ISPack. *;
import java.util.Vector;

import ISPack.ISUtil.JPISException;
import Jdts.Client.JtsConnection;
import Jdts.DataObject. *;

//import static ISPack.CPISReplication.cabinetName;

public class AddDocumentImage {
    static String cabinetName= "syscraftltd";
    static String sVolumeName ="sysvol";

    static short blockSize=50;

   static String sLabel="asdf";
    static short siteId = 1;
    public static void main(String[] args) throws Exception {
        Vector RepList = new Vector();

        JPDBShort NewVolumeId = new JPDBShort();

        CImageServer  imageServer = null;

        try

        {

            imageServer=new CImageServer(null,"192.168.37.5",(short) 3333);

        }

        catch(JPISException ex)

        {

            throw new Exception(ex.getMessage());

        }

        int iReturn = imageServer.JPISRegisterConnection(cabinetName, (short) siteId);

        if(iReturn !=1)

            throw new Exception("Error"+ iReturn);

        iReturn = imageServer.JPISCreateVolume ( cabinetName,

                siteId,

                sVolumeName,

                blockSize,

                sLabel ,

                'A',

                (short)0,

                RepList,

                NewVolumeId);

        if(iReturn !=1)

        {

            imageServer.JPISUnRegisterConnection();

            throw new Exception("Error"+ iReturn);

        }

        imageServer.JPISUnRegisterConnection();
    }

}
