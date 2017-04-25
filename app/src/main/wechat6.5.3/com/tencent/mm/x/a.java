package com.tencent.mm.x;

import com.tencent.mm.a.f;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class a {
    private static int cEn = 0;
    private static int cEo = 0;

    public static class a {
        private static final f<Integer, a> cqx = new f(100);
        public String bhM;
        public String cEp;
        public String cEq;
        public String cEr;
        public String cEs;
        public String cEt;
        public String cEu;
        public String cEv;
        public String cEw;
        public String cEx;
        public String toUser;

        public static final a ij(String str) {
            if (be.kS(str)) {
                v.e("MicroMsg.BrandQALogic", "empty xml to parse");
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            a aVar = (a) cqx.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map q = bf.q(str, "qamsg");
            if (q == null) {
                v.e("MicroMsg.BrandQALogic", "parse msg failed");
                return null;
            }
            try {
                a aVar2 = new a();
                aVar2.bhM = (String) q.get(".qamsg.$fromUser");
                aVar2.cEp = (String) q.get(".qamsg.$fromNickname");
                aVar2.toUser = (String) q.get(".qamsg.$title");
                aVar2.cEq = (String) q.get(".qamsg.question.$id");
                aVar2.cEr = (String) q.get(".qamsg.question.$fromUser");
                aVar2.cEs = (String) q.get(".qamsg.question.content");
                aVar2.cEt = (String) q.get(".qamsg.answer.$id");
                aVar2.cEu = (String) q.get(".qamsg.answer.$fromUser");
                aVar2.cEv = (String) q.get(".qamsg.answer.content");
                aVar2.cEt = (String) q.get(".qamsg.answer1.$id");
                aVar2.cEw = (String) q.get(".qamsg.answer1.$fromUser");
                aVar2.cEx = (String) q.get(".qamsg.answer1.content");
                cqx.k(Integer.valueOf(hashCode), aVar2);
                return aVar2;
            } catch (Throwable e) {
                v.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                v.a("MicroMsg.BrandQALogic", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return null;
            }
        }
    }

    public static String a(a aVar) {
        if (aVar == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        stringBuilder.append(be.ma(aVar.cEx));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(be.ma(aVar.cEv));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(be.ma(aVar.cEs));
        return stringBuilder.toString();
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        if (!k.eo(aVar.bhM)) {
            stringBuilder.append(aVar.cEp);
            stringBuilder.append(": ");
        }
        String str = be.kS(aVar.cEx) ? be.kS(aVar.cEv) ? aVar.cEs : aVar.cEv : aVar.cEx;
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
