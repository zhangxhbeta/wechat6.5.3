package com.qq.wx.voice.embed.recognizer;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Grammar {
    public static String mData = null;
    public static String mDataPath = null;
    public static String mSo = null;
    private f a;
    private a b;
    private boolean c;
    private boolean d;
    private ArrayList e;

    public Grammar() {
        this.a = null;
        this.b = new a();
        this.c = false;
        this.d = false;
        this.e = null;
        this.a = new f();
    }

    private String a() {
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            ((d) this.e.get(i2)).aGZ = a(((d) this.e.get(i2)).userName);
            ((d) this.e.get(i2)).aHa = a(((d) this.e.get(i2)).aGX);
            ((d) this.e.get(i2)).aHb = a(((d) this.e.get(i2)).aGY);
        }
        StringBuffer stringBuffer = new StringBuffer(SQLiteDatabase.KeyEmpty);
        while (i < this.e.size()) {
            String str = ((d) this.e.get(i)).aGZ;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            str = ((d) this.e.get(i)).aHa;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            str = ((d) this.e.get(i)).aHb;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("\n");
                }
                stringBuffer.append(str);
            }
            i++;
        }
        return stringBuffer.toString();
    }

    private static String a(String str) {
        return new String(str).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", SQLiteDatabase.KeyEmpty).replaceAll("0", "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll("3", "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
    }

    public int begin() {
        return GrammarNative.begin();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int checkFiles(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3.c;
        if (r1 == 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        if (r4 == 0) goto L_0x000e;
    L_0x0008:
        if (r5 == 0) goto L_0x000e;
    L_0x000a:
        if (r6 == 0) goto L_0x000e;
    L_0x000c:
        if (r7 != 0) goto L_0x0011;
    L_0x000e:
        r0 = -303; // 0xfffffffffffffed1 float:NaN double:NaN;
        goto L_0x0005;
    L_0x0011:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 24;
        if (r1 < r2) goto L_0x002c;
    L_0x0017:
        r1 = r3.a;
        r2 = "/vendor/lib/";
        r1 = r1.e(r2, r6, r7);
        if (r1 >= 0) goto L_0x0028;
    L_0x0022:
        r1 = r3.a;
        r1 = r1.b(r4, r5, r6, r7);
    L_0x0028:
        if (r1 >= 0) goto L_0x0045;
    L_0x002a:
        r0 = r1;
        goto L_0x0005;
    L_0x002c:
        r1 = "/system/lib";
        r1 = r5.compareTo(r1);
        if (r1 == 0) goto L_0x003e;
    L_0x0035:
        r1 = "/system/lib/";
        r1 = r5.compareTo(r1);
        if (r1 != 0) goto L_0x0022;
    L_0x003e:
        r1 = r3.a;
        r1 = r1.e(r5, r6, r7);
        goto L_0x0028;
    L_0x0045:
        r1 = r3.a;
        r1 = r1.b;
        mDataPath = r1;
        r1 = "libwxvoiceembed.bin";
        mData = r1;
        r1 = "libwxvoiceembed.so";
        mSo = r1;
        r1 = 1;
        r3.c = r1;
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.wx.voice.embed.recognizer.Grammar.checkFiles(android.content.Context, java.lang.String, java.lang.String, java.lang.String):int");
    }

    public int end() {
        return GrammarNative.end();
    }

    public int getResult(a aVar) {
        int result = GrammarNative.getResult(this);
        if (result < 0) {
            return result;
        }
        aVar.text = this.b.text;
        if (this.b.name == null) {
            aVar.name = null;
            return 0;
        }
        int i = 0;
        while (i < this.e.size()) {
            if (((d) this.e.get(i)).aGZ.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                return 0;
            } else if (((d) this.e.get(i)).aHa.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                return 0;
            } else if (((d) this.e.get(i)).aHb.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                return 0;
            } else {
                i++;
            }
        }
        return 0;
    }

    public int init(ArrayList arrayList) {
        if (this.d) {
            return 0;
        }
        if (arrayList == null) {
            return -303;
        }
        try {
            System.load(mDataPath + "/" + mSo);
            this.e = arrayList;
            String a = a();
            try {
                if (GrammarNative.init(mDataPath.getBytes(), mData.getBytes(), a.toString().getBytes("GBK")) < 0) {
                    new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                    return -101;
                }
                this.d = true;
                return 0;
            } catch (UnsupportedEncodingException e) {
                new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                return -101;
            }
        } catch (Exception e2) {
            return -205;
        }
    }

    public void onGetResult(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr != null) {
            try {
                this.b.text = new String(bArr, "GBK");
            } catch (UnsupportedEncodingException e) {
                return;
            }
        }
        this.b.text = null;
        if (bArr3 != null) {
            this.b.name = new String(bArr3, "GBK");
            return;
        }
        this.b.name = null;
    }

    public int recognize(byte[] bArr, int i) {
        return GrammarNative.recognize(bArr, i);
    }

    public int update(ArrayList arrayList) {
        if (arrayList == null) {
            return -303;
        }
        this.e = arrayList;
        try {
            return GrammarNative.update(a().getBytes("GBK")) >= 0 ? 0 : -106;
        } catch (UnsupportedEncodingException e) {
            return -106;
        }
    }
}
