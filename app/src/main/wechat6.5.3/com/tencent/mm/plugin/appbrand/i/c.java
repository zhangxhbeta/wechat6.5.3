package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public final class c {
    public static boolean aT(String str, String str2) {
        InputStream open;
        OutputStream outputStream = null;
        try {
            open = aa.getContext().getAssets().open(str2);
        } catch (Throwable e) {
            v.a("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            v.e("MicroMsg.WxaFTSSearchLogic", "file inputStream is null.");
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            outputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            v.a("MicroMsg.WxaFTSSearchLogic", e2, "", new Object[0]);
        }
        if (outputStream != null) {
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr, 0, read);
                }
                return true;
            } catch (Throwable e22) {
                v.a("MicroMsg.WxaFTSSearchLogic", e22, "", new Object[0]);
                return false;
            } finally {
                e.c(open);
                e.a(outputStream);
            }
        } else {
            e.c(open);
            return false;
        }
    }

    public static String Ii() {
        File file = new File(com.tencent.mm.compatible.util.e.cnh.replace("/data/user/0", "/data/data"), "wxa_fts/res");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int RM() {
        return Integer.valueOf(o(new File(Ii(), "config.conf")).getProperty("version", "0")).intValue();
    }

    public static Properties o(File file) {
        InputStream fileInputStream;
        Throwable e;
        Properties properties = new Properties();
        if (file.isFile()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    e.c(fileInputStream);
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.a("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
                        e.c(fileInputStream);
                        return properties;
                    } catch (Throwable th) {
                        e = th;
                        e.c(fileInputStream);
                        throw e;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
                v.a("MicroMsg.WxaFTSSearchLogic", e, "", new Object[0]);
                e.c(fileInputStream);
                return properties;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                e.c(fileInputStream);
                throw e;
            }
        }
        return properties;
    }

    public static String l(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(Ii());
        stringBuffer.append("/app.html?");
        for (Entry entry : map.entrySet()) {
            stringBuffer.append("&");
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
        }
        return stringBuffer.toString();
    }
}
