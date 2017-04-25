package com.tencent.mm.crash;

import android.app.IntentService;
import android.content.Intent;
import android.os.Build;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class CrashUploaderService extends IntentService {
    static final HashMap<String, Integer> chu;

    public CrashUploaderService() {
        super("CrashUploaderService");
    }

    static {
        HashMap hashMap = new HashMap(16);
        chu = hashMap;
        hashMap.put("exception", Integer.valueOf(CdnLogic.MediaType_FAVORITE_FILE));
        chu.put("anr", Integer.valueOf(CdnLogic.MediaType_FAVORITE_VIDEO));
        chu.put("handler", Integer.valueOf(10003));
        chu.put("sql", Integer.valueOf(10004));
        chu.put("permission", Integer.valueOf(10005));
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            File file;
            String stringExtra = intent.getStringExtra("INTENT_EXTRA_EXCEPTION_MSG");
            String stringExtra2 = intent.getStringExtra("INTENT_EXTRA_USER_NAME");
            String stringExtra3 = intent.getStringExtra("INTENT_EXTRA_SDCARD_PATH");
            String stringExtra4 = intent.getStringExtra("INTENT_EXTRA_DATA_PATH");
            String stringExtra5 = intent.getStringExtra("INTENT_EXTRA_UIN");
            int i = 0;
            try {
                i = Integer.decode(intent.getStringExtra("INTENT_EXTRA_CLIENT_VERSION")).intValue();
            } catch (Error e) {
            }
            String stringExtra6 = intent.getStringExtra("INTENT_EXTRA_DEVICE_TYPE");
            String stringExtra7 = intent.getStringExtra("INTENT_EXTRA_HOST");
            String stringExtra8 = intent.getStringExtra("INTENT_EXTRA_TAG");
            if (stringExtra8 == null || stringExtra8.length() == 0) {
                stringExtra8 = "exception";
            }
            String str = (stringExtra2 + "," + stringExtra6 + "_" + i + "_" + Build.CPU_ABI + ",") + "exception,time_" + be.Nh() + ",error_" + stringExtra;
            try {
                file = new File(stringExtra3);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (be.ay(file2.lastModified()) > 2592000000L) {
                                file2.delete();
                            }
                        }
                    }
                } else {
                    file.mkdirs();
                }
                j(stringExtra3 + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt", str, stringExtra5);
            } catch (Exception e2) {
            }
            file = new File(stringExtra4);
            if (!file.exists()) {
                file.mkdir();
            }
            stringExtra = stringExtra4 + stringExtra5;
            File file3 = new File(stringExtra);
            if (file3.length() > 262144) {
                file3.delete();
            }
            j(stringExtra, str, stringExtra5);
            byte[] d = e.d(stringExtra, 0, -1);
            if (!be.bl(d) && a(stringExtra2, d, i, stringExtra6, stringExtra7, r7)) {
                file3.delete();
            }
        }
    }

    private static void j(String str, String str2, String str3) {
        if (!new File(str).exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            if (be.kS(str3) || str3.equals("0")) {
                stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
            } else {
                stringBuilder.append("uin[" + str3 + "] ");
            }
            stringBuilder.append(v.btc());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            stringBuilder.append("\n");
            e.e(str, stringBuilder.toString().getBytes());
        }
        e.e(str, (str2 + "\n").getBytes());
    }

    private static boolean a(String str, byte[] bArr, int i, String str2, String str3, String str4) {
        String toLowerCase = g.m(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bArr.length)}).getBytes()).toLowerCase();
        byte[] k = q.k(bArr);
        PByteArray pByteArray = new PByteArray();
        c.a(pByteArray, k, toLowerCase.getBytes());
        StringBuilder append = new StringBuilder().append(str3).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(i)).append("&devicetype=").append(str2).append("&filelength=").append(r0).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=").append(be.f((Integer) chu.get(str4)));
        if (!(str == null || str.equals(SQLiteDatabase.KeyEmpty))) {
            append.append("&username=").append(str);
        }
        try {
            HttpClient defaultHttpClient = new DefaultHttpClient();
            HttpUriRequest httpPost = new HttpPost(append.toString());
            HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            v.i("MicroMsg.CrashUploaderService", be.e(defaultHttpClient.execute(httpPost).getEntity().getContent()));
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.CrashUploaderService", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }
}
