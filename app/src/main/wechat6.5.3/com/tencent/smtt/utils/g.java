package com.tencent.smtt.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public final class g {
    private static OutputStream pxK = null;

    public static synchronized void a(File file, String str, byte[] bArr, String str2) {
        byte[] bArr2 = null;
        synchronized (g.class) {
            byte[] eg = eg(str, str2);
            if (eg != null) {
                str2 = null;
                bArr2 = eg;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (pxK == null) {
                    pxK = new BufferedOutputStream(new FileOutputStream(file, true));
                }
                if (str2 != null) {
                    pxK.write(str2.getBytes());
                } else {
                    pxK.write(bArr);
                    pxK.write(bArr2);
                    pxK.write(new byte[]{(byte) 10, (byte) 10});
                }
                if (pxK != null) {
                    pxK.flush();
                }
            } catch (Throwable th) {
                new StringBuilder("file.getAbsolutePath=").append(file.getAbsolutePath()).append(" append=true");
            }
        }
    }

    public static String bNV() {
        return String.valueOf(System.currentTimeMillis());
    }

    private static byte[] eg(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    private static byte[] eh(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return instance.update(bytes);
        } catch (Throwable th) {
            new StringBuilder("encrypt exception:").append(th.getMessage());
            return null;
        }
    }

    public static byte[] ei(String str, String str2) {
        try {
            Object eh = eh(str, str2);
            String format = String.format("%03d", new Object[]{Integer.valueOf(eh.length)});
            Object obj = new byte[(eh.length + 3)];
            obj[0] = (byte) format.charAt(0);
            obj[1] = (byte) format.charAt(1);
            obj[2] = (byte) format.charAt(2);
            System.arraycopy(eh, 0, obj, 3, eh.length);
            return obj;
        } catch (Exception e) {
            return null;
        }
    }
}
