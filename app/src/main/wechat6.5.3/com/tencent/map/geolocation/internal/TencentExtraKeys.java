package com.tencent.map.geolocation.internal;

import android.location.Location;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class TencentExtraKeys {
    public static final boolean ALLOW_GPS_CALMAN = false;
    public static final boolean ALLOW_QUICK_SCAN = false;
    public static final boolean ALLOW_START_TENCENTMAP = false;
    public static final boolean DAEMON_UPLOAD = true;
    public static final TencentLog DEFAULT_TENCENT_LOG = new TencentLog() {
        public final void println(String str, int i, @NonNull String str2) {
            if (i != 4) {
            }
        }

        public final String getDirString() {
            return null;
        }
    };
    public static final boolean DIDI_INTERNAL = false;
    public static final boolean LIST_UPLOAD = true;
    public static final String LOCATION_KEY_ADMIN_LEVEL1 = "admin_level_1";
    public static final String LOCATION_KEY_ADMIN_LEVEL2 = "admin_level_2";
    public static final String LOCATION_KEY_ADMIN_LEVEL3 = "admin_level_3";
    public static final String LOCATION_KEY_LOCALITY = "locality";
    public static final String LOCATION_KEY_NATION = "nation";
    public static final String LOCATION_KEY_ROUTE = "route";
    public static final String LOCATION_KEY_SUBLOCALITY = "sublocality";
    public static final String LOCATION_SOURCE_CELL = "cell";
    public static final String LOCATION_SOURCE_GPS = "gps";
    public static final String LOCATION_SOURCE_WIFI = "wifi";
    public static boolean MOCK_LOCATION_FILTER = true;
    public static final String RAW_DATA = "raw_data";
    public static final String REQUEST_RAW_DATA = "request_raw_data";
    public static final boolean STRICT_CELL_FILTER = true;
    public static final boolean TENCENT_INTERNAL = true;
    public static final boolean TRY_NLP = false;
    private static File sLogDir;
    private static TencentLog sTencentLog;
    private static List<TencentLog> sTencentLogs = new ArrayList();

    public static void enableMockLocationFilter(boolean z) {
        MOCK_LOCATION_FILTER = z;
    }

    public static byte[] getRawData(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra().getByteArray(RAW_DATA);
    }

    public static TencentLocation setRawData(TencentLocation tencentLocation, byte[] bArr) {
        tencentLocation.getExtra().putByteArray(RAW_DATA, bArr);
        return tencentLocation;
    }

    public static String getRawQuery(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return tencentLocation.getExtra().getString("raw_query");
    }

    public static void setRawQuery(TencentLocation tencentLocation, String str) {
        if (tencentLocation != null) {
            tencentLocation.getExtra().putString("raw_query", str);
        }
    }

    public static Location getRawGps(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return null;
        }
        return (Location) tencentLocation.getExtra().getParcelable("raw_gps");
    }

    public static void setRawGps(TencentLocation tencentLocation, Location location) {
        if (tencentLocation != null) {
            try {
                tencentLocation.getExtra().putParcelable("raw_gps", location);
            } catch (Exception e) {
            }
        }
    }

    public static TencentLocationRequest setRequestRawData(TencentLocationRequest tencentLocationRequest, boolean z) {
        if (tencentLocationRequest != null) {
            tencentLocationRequest.getExtras().putBoolean(REQUEST_RAW_DATA, z);
        }
        return tencentLocationRequest;
    }

    public static boolean isRequestRawData(TencentLocationRequest tencentLocationRequest) {
        if (tencentLocationRequest == null) {
            return false;
        }
        return tencentLocationRequest.getExtras().getBoolean(REQUEST_RAW_DATA);
    }

    public static boolean isAllowedLevel(int i) {
        switch (i) {
            case 0:
            case 1:
            case 3:
            case 4:
                return true;
            default:
                return i == 7;
        }
    }

    public static String getLocationSource(TencentLocation tencentLocation) {
        if (tencentLocation == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        boolean isFromGps = TencentLocationUtils.isFromGps(tencentLocation);
        boolean isFromNetwork = TencentLocationUtils.isFromNetwork(tencentLocation);
        int i = tencentLocation.getExtra().getInt("wifi_ap_num");
        if (isFromGps) {
            return "gps";
        }
        if (!isFromNetwork || i < 3) {
            return "cell";
        }
        return "wifi";
    }

    public static void loadLibrary(String str) {
        System.load(str);
    }

    @Deprecated
    public static synchronized void setTencentLog(TencentLog tencentLog) {
        synchronized (TencentExtraKeys.class) {
            sTencentLog = tencentLog;
            sTencentLogs.add(tencentLog);
        }
    }

    public static synchronized void addTencentLog(TencentLog tencentLog) {
        synchronized (TencentExtraKeys.class) {
            if (!sTencentLogs.contains(tencentLog)) {
                sTencentLogs.add(tencentLog);
            }
        }
    }

    public static synchronized boolean removeTencentLog(TencentLog tencentLog) {
        boolean remove;
        synchronized (TencentExtraKeys.class) {
            remove = sTencentLogs.remove(tencentLog);
        }
        return remove;
    }

    @Nullable
    @Deprecated
    public static synchronized TencentLog getTencentLog() {
        TencentLog tencentLog;
        synchronized (TencentExtraKeys.class) {
            tencentLog = sTencentLog;
        }
        return tencentLog;
    }

    public static synchronized List<TencentLog> getTencentLogs() {
        List<TencentLog> list;
        synchronized (TencentExtraKeys.class) {
            list = sTencentLogs;
        }
        return list;
    }

    @Deprecated
    public static synchronized boolean isDebugEnabled() {
        boolean z;
        synchronized (TencentExtraKeys.class) {
            z = sTencentLog != null;
        }
        return z;
    }

    public static synchronized void setLogDir(File file) {
        synchronized (TencentExtraKeys.class) {
            sLogDir = file;
        }
    }

    public static synchronized File getLogDir() {
        File file;
        synchronized (TencentExtraKeys.class) {
            file = sLogDir;
        }
        return file;
    }
}
