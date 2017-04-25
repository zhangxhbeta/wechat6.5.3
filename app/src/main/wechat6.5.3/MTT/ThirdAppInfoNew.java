package MTT;

import com.tencent.mmdb.database.SQLiteDatabase;

public final class ThirdAppInfoNew implements Cloneable {
    public int iCoreType = 0;
    public long iPv = 0;
    public int localCoreVersion = 0;
    public String sAndroidID = SQLiteDatabase.KeyEmpty;
    public String sAppName = SQLiteDatabase.KeyEmpty;
    public String sAppSignature = SQLiteDatabase.KeyEmpty;
    public String sAppVersionName = SQLiteDatabase.KeyEmpty;
    public String sGuid = SQLiteDatabase.KeyEmpty;
    public String sImei = SQLiteDatabase.KeyEmpty;
    public String sImsi = SQLiteDatabase.KeyEmpty;
    public String sLc = SQLiteDatabase.KeyEmpty;
    public String sMac = SQLiteDatabase.KeyEmpty;
    public String sQua2 = SQLiteDatabase.KeyEmpty;
    public String sTime = SQLiteDatabase.KeyEmpty;
    public long sWifiConnectedTime = 0;
}
