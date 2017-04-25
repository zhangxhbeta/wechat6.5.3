package com.tenpay.android.wechat;

import android.content.Context;
import com.tenpay.android.jni.Encrypt;
import java.lang.reflect.Field;
import java.security.MessageDigest;

public class TenpayUtil {
    public static String signWith3Des(String str) {
        if (str == null) {
            return null;
        }
        return new Encrypt().desedeEncode(md5HexDigest(str));
    }

    public static String md5HexDigest(String str) {
        int i = 0;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            char[] cArr2 = new char[32];
            int i2 = 0;
            while (i < 16) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
            }
            return new String(cArr2);
        } catch (Exception e) {
            return null;
        }
    }

    public static final int[] getResourceDeclareStyleableIntArray(Context context, String str) {
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static final int getResourceDeclareStyleableIndex(Context context, String str) {
        int i = 0;
        try {
            for (Field field : Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    i = field.getInt(null);
                    break;
                }
            }
        } catch (Throwable th) {
        }
        return i;
    }

    public static boolean invalidateID(String str) {
        if (str == null || str.length() != 18) {
            return false;
        }
        int[] iArr = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        int i = 0;
        int i2 = 0;
        while (i < str.length() - 1) {
            try {
                i2 += Integer.parseInt(str.substring(i, i + 1)) * iArr[i];
                i++;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        i = i2 % 11;
        char charAt = str.charAt(17);
        if (i == 2) {
            if (!(charAt == 'X' || charAt == 'x')) {
                return false;
            }
        } else if (charAt != cArr[i]) {
            return false;
        }
        return true;
    }
}
