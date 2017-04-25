package com.tencent.mm.b;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

public final class i {
    public String aQl;
    private Map<String, a> aQm = new HashMap();
    public int versionCode;

    public static class a {
        String aQn;
        public String aQo;
        public String aQp;
        public int size;
        public String url;

        public a(String str, String str2, String str3, String str4, int i) {
            this.aQn = str;
            this.aQo = str2;
            this.aQp = str3;
            this.size = i;
            this.url = str4;
        }
    }

    private i(String str, int i) {
        if (str == null) {
            this.aQl = "http://dldir1.qq.com/weixin/android/";
        } else {
            this.aQl = str;
        }
        this.versionCode = i;
    }

    public final a bd(String str) {
        return (a) this.aQm.get(str);
    }

    public static i be(String str) {
        Map q = f.q(str, "patchupdate");
        if (q == null) {
            return null;
        }
        i iVar = new i((String) q.get(".patchupdate.$base"), j.bf((String) q.get(".patchupdate.$versioncode")));
        int bf = j.bf((String) q.get(".patchupdate.$count"));
        int i = 0;
        while (i < bf) {
            Object obj;
            String str2 = ".patchupdate.item" + (i > 0 ? Integer.valueOf(i) : SQLiteDatabase.KeyEmpty);
            a aVar = new a((String) q.get(new StringBuilder(String.valueOf(str2)).append(".$old").toString()), (String) q.get(new StringBuilder(String.valueOf(str2)).append(".$new").toString()), (String) q.get(new StringBuilder(String.valueOf(str2)).append(".$patch").toString()), (String) q.get(new StringBuilder(String.valueOf(str2)).append(".$url").toString()), j.bf((String) q.get(new StringBuilder(String.valueOf(str2)).append(".$size").toString())));
            if (aVar.aQn == null || aVar.aQo == null || aVar.aQp == null || aVar.url == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                iVar.aQm.put(aVar.aQn, aVar);
            }
            i++;
        }
        return iVar;
    }
}
