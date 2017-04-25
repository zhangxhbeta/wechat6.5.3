package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.d;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class bb {
    private final d nlu;
    private x<String, String> nlv = new x(FileUtils.S_IRUSR);

    public bb(String str) {
        this.nlu = new d(str);
    }

    public final String decryptTag(String str) {
        try {
            if (str.startsWith("!")) {
                if (this.nlv.aI(str)) {
                    return (String) this.nlv.get(str);
                }
                String substring = str.substring(1);
                try {
                    String[] split = substring.split("@");
                    if (split.length > 1) {
                        String str2 = split[0];
                        int intValue = Integer.valueOf(split[0]).intValue();
                        String substring2 = substring.substring(str2.length() + 1, (str2.length() + 1) + intValue);
                        String str3 = this.nlu.aP(substring2) + substring.substring(intValue + (str2.length() + 1));
                        this.nlv.put(str, str3);
                        return str3;
                    }
                    str = substring;
                } catch (Throwable e) {
                    str = substring;
                    Throwable th = e;
                    v.a("MicroMsg.TagDecrypter", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                    str = "[td]" + str;
                    return str;
                }
            }
        } catch (Exception e2) {
            th = e2;
            v.a("MicroMsg.TagDecrypter", th, SQLiteDatabase.KeyEmpty, new Object[0]);
            str = "[td]" + str;
            return str;
        }
        return str;
    }
}
