package com.tencent.mm.modelbiz.a;

import com.tencent.mm.modelbiz.u;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class k extends f<j> {
    public static final String[] cic = new String[]{f.a(j.chq, "BizChatUserInfo")};
    final h<a, b> cBg = new h<a, b>(this) {
        final /* synthetic */ k cEc;

        {
            this.cEc = r1;
        }

        protected final /* bridge */ /* synthetic */ void o(Object obj, Object obj2) {
        }
    };
    Map<String, String> cDH = new HashMap();
    public d cie;

    public interface a {

        public enum a {
            ;

            static {
                cEd = 1;
                cEe = 2;
                cEf = 3;
                cEg = new int[]{cEd, cEe, cEf};
            }
        }

        public static class b {
            public int cEh;
            public j cEi;
            public String userId;
        }
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(d dVar) {
        super(dVar, j.chq, "BizChatUserInfo", null);
        this.cie = dVar;
        dVar.dF("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.cDH.clear();
    }

    public final j ig(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            return null;
        }
        c jVar = new j();
        jVar.field_userId = str;
        super.b(jVar, new String[0]);
        return jVar;
    }

    public final boolean a(j jVar) {
        v.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (jVar == null) {
            v.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b(jVar);
        if (!b) {
            return b;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.cEh = a.cEd;
        bVar.cEi = jVar;
        this.cBg.bg(bVar);
        this.cBg.Ls();
        return b;
    }

    public final boolean b(j jVar) {
        v.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (jVar == null) {
            v.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            return false;
        }
        if (jVar == null || be.kS(jVar.field_userName)) {
            v.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            jVar.field_userNamePY = com.tencent.mm.platformtools.c.lT(jVar.field_userName);
        }
        boolean a = super.a((c) jVar);
        if (!a) {
            return a;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.cEh = a.cEf;
        bVar.cEi = jVar;
        this.cBg.bg(bVar);
        this.cBg.Ls();
        return a;
    }

    public final j ih(String str) {
        if (str == null) {
            v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            return null;
        }
        String ii = ii(str);
        if (ii != null) {
            return ig(ii);
        }
        v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
        return null;
    }

    public final String ii(String str) {
        if (str == null) {
            v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            return null;
        }
        v.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", str);
        if (this.cDH.containsKey(str) && this.cDH.get(str) != null) {
            return (String) this.cDH.get(str);
        }
        f ie = u.DD().ie(str);
        if (ie != null) {
            v.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", str, ie.field_userId);
            this.cDH.put(str, ie.field_userId);
            return ie.field_userId;
        }
        v.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", str);
        return null;
    }

    public final void c(j jVar) {
        v.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        j ig = ig(jVar.field_userId);
        if (ig == null) {
            a(jVar);
        } else if (!be.kS(jVar.field_userName) && !jVar.field_userName.equals(ig.field_userName)) {
            ig.field_userName = jVar.field_userName;
            b(ig);
        }
    }

    public static String a(String[] strArr, List<String> list) {
        if (strArr == null || strArr.length == 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder(" 1=1 ");
        String str = SQLiteDatabase.KeyEmpty;
        if (list != null && list.size() > 0) {
            String str2 = str;
            for (String str3 : list) {
                str2 = str2 + " and userId != '" + str3 + "'";
            }
            str3 = str2;
        }
        stringBuilder.append(str3);
        stringBuilder.append(" and ");
        stringBuilder.append("userId in(");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(" '").append(strArr[i]).append("' ");
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}
