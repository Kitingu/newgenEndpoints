//import ISPack.CImageServer;
//import Jdts.DataObject.JPDBShort;
//
//import java.util.Vector;
//
//public class ExampleOne {
//    public static void main(String[] args) throws Exception {
//        Vector RepList = new Vector();
//
//        JPDBShort NewVolumeId = new JPDBShort();
//
//        CImageServer imageServer = null;
//
//        try
//
//        {
//
//            imageServer=new CImageServer(null,"192.168.37.5",(short) 3333);
//
//        }
//
//        catch(ISPack.ISUtil.JPISException ex)
//
//        {
//
//            throw new Exception(ex.getMessage());
//
//        }
//
//        int iReturn = imageServer.JPISRegisterConnection(cabinetName, siteId);
//
//        if(iReturn !=1)
//
//            throw new Exception("Error"+ iReturn);
//
//        iReturn = imageServer.JPISCreateVolume ( cabinetName,
//
//                siteId,
//
//                sVolumeName,
//
//                blockSize,
//
//                sLabel ,
//
//                'A',
//
//                (short)0,
//
//                RepList,
//
//                NewVolumeId);
//
//        if(iReturn !=1)
//
//        {
//
//            imageServer.JPISUnRegisterConnection();
//
//            throw new Exception("Error"+ iReturn);
//
//        }
//
//        imageServer.JPISUnRegisterConnection();
//
//
//    }
//}
