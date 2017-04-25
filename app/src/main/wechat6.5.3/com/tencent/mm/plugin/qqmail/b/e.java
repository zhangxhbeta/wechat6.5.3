package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class e {
    public static int iax = 100;
    private int caG = iax;
    public String iay = null;

    public e(String str, int i) {
        v.i("Msg.Plugin.HttpRequestCache", "HttpRequestCache constructor, path = " + str + ", maxCount = " + i);
        this.iay = str;
        File file = new File(this.iay);
        if (!file.exists()) {
            file.mkdir();
        }
        if (i <= 0) {
            i = iax;
        }
        this.caG = i;
    }

    public final byte[] f(String str, Map<String, String> map) {
        if (str == null || str.length() == 0) {
            v.e("Msg.Plugin.HttpRequestCache", "getCache, invalid argument");
            return null;
        }
        String g = g(str, map);
        byte[] readFromFile = readFromFile(this.iay + g);
        if (readFromFile == null) {
            v.i("Msg.Plugin.HttpRequestCache", "readFromFile fail, cipherText is null, read error or cache not exist");
            return null;
        }
        byte[] decrypt = decrypt(readFromFile, xX(g));
        if (decrypt != null) {
            return decrypt;
        }
        v.e("Msg.Plugin.HttpRequestCache", "decrypt fail, plaintText is null");
        return null;
    }

    public final boolean a(String str, Map<String, String> map, byte[] bArr) {
        if (str == null || str.length() == 0 || bArr == null || bArr.length == 0) {
            v.e("Msg.Plugin.HttpRequestCache", "setCache, invalid argument");
            return false;
        }
        aHt();
        String g = g(str, map);
        byte[] encrypt = encrypt(bArr, xX(g));
        if (encrypt != null) {
            return p(this.iay + g, encrypt);
        }
        v.e("Msg.Plugin.HttpRequestCache", "encrypt fail, cipherText is null");
        return false;
    }

    private static String g(String str, Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                stringBuffer.append(str2);
                stringBuffer.append(str3);
            }
        }
        return g.m(stringBuffer.toString().getBytes());
    }

    private static byte[] xX(String str) {
        return g.m(str.toString().getBytes()).substring(8, 16).getBytes();
    }

    public final void aHt() {
        int length;
        int i = 0;
        String[] list = new File(this.iay).list();
        if (list != null) {
            length = list.length;
        } else {
            length = 0;
        }
        if (length >= this.caG) {
            String[] list2 = new File(this.iay).list();
            File file = null;
            int length2 = list2.length;
            while (i < length2) {
                file = new File(list2[i]);
                file.lastModified();
                i++;
            }
            if (file.exists()) {
                file.delete();
            }
        }
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            v.a("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            v.a("Msg.Plugin.HttpRequestCache", e, "", new Object[0]);
            return null;
        }
    }

    public static byte[] readFromFile(String str) {
        Throwable e;
        Throwable e2;
        FileInputStream fileInputStream;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            int length = (int) file.length();
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[length];
                if (fileInputStream.read(bArr) != length) {
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e3) {
                        v.a("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                        return null;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Throwable e22) {
                    v.a("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                }
                return bArr;
            } catch (Exception e4) {
                e3 = e4;
                try {
                    v.a("Msg.Plugin.HttpRequestCache", e3, "", new Object[0]);
                    if (fileInputStream != null) {
                        return null;
                    }
                    try {
                        fileInputStream.close();
                        return null;
                    } catch (Throwable e32) {
                        v.a("Msg.Plugin.HttpRequestCache", e32, "", new Object[0]);
                        return null;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e322) {
                            v.a("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e322 = e5;
            fileInputStream = null;
            v.a("Msg.Plugin.HttpRequestCache", e322, "", new Object[0]);
            if (fileInputStream != null) {
                return null;
            }
            fileInputStream.close();
            return null;
        } catch (Throwable e3222) {
            fileInputStream = null;
            e22 = e3222;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static boolean p(String str, byte[] bArr) {
        Throwable e;
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    v.a("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                try {
                    v.a("Msg.Plugin.HttpRequestCache", e2, "", new Object[0]);
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e22) {
                        v.a("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            v.a("Msg.Plugin.HttpRequestCache", e4, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            fileOutputStream = null;
            v.a("Msg.Plugin.HttpRequestCache", e22, "", new Object[0]);
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
    }
}
