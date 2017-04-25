package com.tencent.mm.plugin.accountsync.b;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static a dwt = new a();
    private Map<String, String> dwu;

    public final Map<String, String> bp(Context context) {
        try {
            String k = be.k(context.getAssets().open("config/EmailAddress.xml"));
            if (be.kS(k)) {
                return null;
            }
            Map q = bf.q(k, "config");
            if (q == null || q.isEmpty()) {
                v.d("MicroMsg.EmailFormater", "values null");
                return null;
            } else if (this.dwu != null) {
                return this.dwu;
            } else {
                this.dwu = new HashMap();
                int i = 0;
                while (true) {
                    k = ".config.format" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i));
                    if (q.get(k) == null) {
                        return this.dwu;
                    }
                    String str = k + ".emaildomain";
                    String str2 = k + ".loginpage";
                    k = (String) q.get(str);
                    str = (String) q.get(str2);
                    if (!(be.kS(k) || be.kS(str))) {
                        this.dwu.put(k, str);
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            v.e("MicroMsg.EmailFormater", "parse email failed:[%s]", e.getMessage());
            return null;
        }
    }
}
