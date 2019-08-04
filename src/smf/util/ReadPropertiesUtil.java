package smf.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesUtil {

    public static DatosUserSesion getDatosUserSesion(String pathSys) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(pathSys));

        String userid = properties.getProperty("userid");
        String tdvid = properties.getProperty("tdvid");

        DatosUserSesion datosUserSesion = new DatosUserSesion();
        datosUserSesion.setTdvId(Integer.valueOf(tdvid));
        datosUserSesion.setUserId(Integer.valueOf(userid));

        return datosUserSesion;
    }
}
