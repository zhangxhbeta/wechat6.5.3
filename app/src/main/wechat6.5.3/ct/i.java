package ct;

import android.text.TextUtils;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.Deflater;

public final class i {
    boolean a;

    public i(boolean z) {
        this.a = z;
    }

    public static au a(String str) {
        if (str == null) {
            return null;
        }
        as k = as.k();
        if (k == null) {
            return null;
        }
        long time = new Date().getTime();
        String a = bc.a();
        if (a == null) {
            a = "null";
        }
        Map hashMap = new HashMap();
        hashMap.put("A23", d(k.e()));
        au auVar = new au();
        auVar.c(str);
        auVar.a(time);
        auVar.a(hashMap);
        auVar.b(k.a());
        auVar.a(a);
        return auVar;
    }

    public static aw a(bi biVar) {
        bb bbVar = new bb(biVar);
        try {
            bbVar.j();
        } catch (Exception e) {
            bbVar.b = -2;
            bbVar.c = be.a(e);
        }
        return bbVar;
    }

    public static String a(au auVar) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        long currentTimeMillis = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(currentTimeMillis);
        stringBuilder.append(stringBuilder2.append(simpleDateFormat.format(instance.getTime())).append("|").toString());
        stringBuilder.append("INFO|");
        stringBuilder.append(p.b + "|");
        as k = as.k();
        if (k != null) {
            stringBuilder.append(as.k().c() + "|");
        } else {
            stringBuilder.append("unknow|");
        }
        stringBuilder.append("beacon|");
        stringBuilder.append("1.8.1|");
        String e = auVar.e();
        try {
            e = URLEncoder.encode(auVar.e(), "utf-8");
        } catch (UnsupportedEncodingException e2) {
        }
        stringBuilder.append(e + "|");
        stringBuilder.append("qua|");
        stringBuilder.append("upload_ip|");
        stringBuilder.append("unknown|");
        stringBuilder.append(auVar.d() + "|");
        stringBuilder.append(auVar.g() + "|");
        stringBuilder.append(auVar.a() + "|");
        stringBuilder.append(au.c() + "|");
        stringBuilder.append(au.b() + "|");
        stringBuilder.append(a(auVar.h()) + "|");
        stringBuilder2 = new StringBuilder();
        long f = auVar.f();
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(f);
        stringBuilder.append(stringBuilder2.append(simpleDateFormat2.format(instance2.getTime())).append("|").toString());
        stringBuilder.append("upload_time|");
        if (k != null) {
            stringBuilder.append(k.b() + "\n");
        } else {
            stringBuilder.append("unknow\n");
        }
        return stringBuilder.toString();
    }

    private static String a(Map map) {
        if (map == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : keySet) {
            stringBuffer.append("&");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append((String) map.get(str));
        }
        String str2 = stringBuffer.substring(1);
        stringBuffer.setLength(0);
        return str2;
    }

    public static HashMap a(ap apVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("B50", apVar.d);
        hashMap.put("B51", c(apVar.g));
        hashMap.put("B69", c(apVar.e));
        hashMap.put("B52", apVar.h);
        hashMap.put("B53", c(apVar.j));
        hashMap.put("B54", apVar.k);
        hashMap.put("B55", apVar.m);
        hashMap.put("B56", apVar.n);
        if (!TextUtils.isEmpty(apVar.o)) {
            hashMap.put("B57", c(apVar.o));
        }
        if (!(TextUtils.isEmpty(apVar.p) || apVar.p.equals("null"))) {
            hashMap.put("B58", c(apVar.p));
        }
        return hashMap;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[FileUtils.S_IRUSR];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.finish();
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean b(String str) {
        Throwable th;
        boolean z = false;
        Socket socket;
        try {
            socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(str, 80), 5000);
                if (socket.isConnected()) {
                    z = true;
                }
                try {
                    socket.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            socket = null;
            if (socket != null) {
                socket.close();
            }
            throw th;
        }
        return z;
    }

    private static String c(String str) {
        return !TextUtils.isEmpty(str) ? str.replace('\n', ' ').replace('\r', ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D") : SQLiteDatabase.KeyEmpty;
    }

    private static String d(String str) {
        String str2 = SQLiteDatabase.KeyEmpty;
        if (!TextUtils.isEmpty(str)) {
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str2;
    }
}
