package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.a.k;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public final class w {
    private static final Pattern nin;
    private byte[] key;
    private final x<String, String> nio = new x(FileUtils.S_IRUSR);
    public final bb nip;

    static {
        String str = "⍆[0-9]+@";
        nin = Pattern.compile(((char) (str.charAt(0) ^ 56506)) + str.substring(1));
    }

    public w(String str) {
        try {
            this.key = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            this.key = str.getBytes();
        }
        this.nip = new bb(str);
    }

    public final String bF(String str, int i) {
        String substring = str.substring(0, i);
        if (this.nio.bc(substring)) {
            return (String) this.nio.get(substring);
        }
        int indexOf = str.indexOf(64, 1);
        int i2 = indexOf + 1;
        try {
            String str2 = new String(k.b(Base64.decode(str.substring(i2, Integer.parseInt(str.substring(1, indexOf)) + i2), 0), this.key), "UTF-8");
            this.nio.put(substring, str2);
            return str2;
        } catch (Throwable e) {
            v.a("MicroMsg.LogDecryptor", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return "[TD]" + substring;
        }
    }
}
