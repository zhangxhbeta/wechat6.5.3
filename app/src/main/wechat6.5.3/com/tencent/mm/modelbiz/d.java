package com.tencent.mm.modelbiz;

import android.database.Cursor;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d extends f<BizInfo> {
    public static final String[] btd = new String[]{"CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) "};
    public static Map<String, String> cCF = new HashMap();
    public static final String[] cic = new String[]{f.a(BizInfo.chq, "bizinfo")};
    private final h<a, b> cBg = new h<a, b>(this) {
        final /* synthetic */ d cCG;

        {
            this.cCG = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };

    public interface a {

        public enum a {
            ;

            static {
                cCH = 1;
                cCI = 2;
                cCJ = 3;
                cCK = new int[]{cCH, cCI, cCJ};
            }
        }

        public static class b {
            public boolean cBJ;
            public String cBj;
            public int cCL;
            public BizInfo cCM;
        }

        void a(b bVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return e((BizInfo) cVar);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return d((BizInfo) cVar);
    }

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, BizInfo.chq, "bizinfo", btd);
    }

    public final void a(a aVar) {
        this.cBg.a(aVar, null);
    }

    public final void b(a aVar) {
        if (this.cBg != null) {
            this.cBg.remove(aVar);
        }
    }

    public final BizInfo ho(String str) {
        c bizInfo = new BizInfo();
        bizInfo.field_username = str;
        super.b(bizInfo, new String[0]);
        return bizInfo;
    }

    public final void hp(String str) {
        c bizInfo = new BizInfo();
        bizInfo.field_username = str;
        String[] strArr = new String[]{"username"};
        v.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.c(bizInfo, strArr)), str);
        b bVar = new b();
        bVar.cBj = str;
        bVar.cCL = a.cCI;
        bVar.cCM = bizInfo;
        this.cBg.bg(bVar);
        this.cBg.Ls();
    }

    public final void c(BizInfo bizInfo) {
        String[] strArr = new String[]{"username"};
        v.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", Boolean.valueOf(super.c(bizInfo, strArr)), bizInfo.field_username);
        b bVar = new b();
        bVar.cBj = bizInfo.field_username;
        bVar.cCL = a.cCI;
        bVar.cCM = bizInfo;
        this.cBg.bg(bVar);
        this.cBg.Ls();
    }

    public final boolean d(BizInfo bizInfo) {
        bizInfo.field_updateTime = System.currentTimeMillis();
        bizInfo.Cu();
        v.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", bizInfo.field_username, bizInfo.field_brandList, Integer.valueOf(bizInfo.field_brandFlag), bizInfo.field_brandInfo, bizInfo.field_extInfo, bizInfo.field_brandIconURL, Long.valueOf(bizInfo.field_updateTime));
        ExtInfo aX = bizInfo.aX(false);
        if (aX != null) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.a CR = aX.CR();
            if (CR != null) {
                bizInfo.field_specialType = CR.cCd;
            }
        }
        boolean b = super.b(bizInfo);
        if (b && !m.dE(bizInfo.field_username)) {
            b bVar = new b();
            bVar.cBj = bizInfo.field_username;
            bVar.cBJ = bizInfo.Cv();
            bVar.cCL = a.cCH;
            bVar.cCM = bizInfo;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return b;
    }

    public final boolean e(BizInfo bizInfo) {
        bizInfo.field_updateTime = System.currentTimeMillis();
        bizInfo.Cu();
        ExtInfo aX = bizInfo.aX(false);
        if (aX != null) {
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.a CR = aX.CR();
            if (CR != null) {
                bizInfo.field_specialType = CR.cCd;
            }
        }
        boolean a = super.a((c) bizInfo);
        if (a && !m.dE(bizInfo.field_username)) {
            b bVar = new b();
            bVar.cBj = bizInfo.field_username;
            bVar.cBJ = bizInfo.Cv();
            bVar.cCL = a.cCJ;
            bVar.cCM = bizInfo;
            this.cBg.bg(bVar);
            this.cBg.Ls();
        }
        return a;
    }

    public final List<String> fg(int i) {
        v.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[]{"username", "bizinfo", "acceptType", Integer.valueOf(i)}));
        long Nj = be.Nj();
        Cursor rawQuery = rawQuery(r0, new String[0]);
        List<String> linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            v.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(be.az(Nj)));
            ak.yW();
            return com.tencent.mm.model.c.wH().ce(linkedList);
        }
        v.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", Integer.valueOf(i), Long.valueOf(be.az(Nj)));
        return linkedList;
    }

    public final int fh(int i) {
        List fg = fg(i);
        if (be.bP(fg)) {
            return 0;
        }
        return fg.size();
    }

    public static String Db() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static String Dc() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("rcontact.type & ").append(2048).append(" desc, ");
        stringBuffer.append("rcontact.showHead asc, ");
        stringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(").append("rcontact.conRemarkPYFull) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(").append("rcontact.conRemark) ");
        stringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
        stringBuffer.append(" upper(rcontact.quanPin) asc, ");
        stringBuffer.append(" upper(rcontact.nickname) asc, ");
        stringBuffer.append(" upper(rcontact.username) asc ");
        return stringBuffer.toString();
    }

    public static void a(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.username").append(" ");
    }

    public static void b(StringBuilder stringBuilder) {
        stringBuilder.append("select bizinfo.brandIconURL");
        stringBuilder.append(", bizinfo.type");
        stringBuilder.append(", bizinfo.status");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.brandFlag");
        stringBuilder.append(", bizinfo.extInfo");
        stringBuilder.append(", rcontact.username");
        stringBuilder.append(", rcontact.conRemark");
        stringBuilder.append(", rcontact.quanPin");
        stringBuilder.append(", rcontact.nickname");
        stringBuilder.append(", rcontact.alias");
        stringBuilder.append(", rcontact.type").append(" ");
    }

    public static void c(StringBuilder stringBuilder) {
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(u.bvo()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
    }

    public static void d(StringBuilder stringBuilder) {
        stringBuilder.append(" and bizinfo.type").append(" = 3 ");
    }

    public static void a(StringBuilder stringBuilder, String str) {
        stringBuilder.append(" and bizinfo.type").append(" = 3");
        stringBuilder.append(" and bizinfo.enterpriseFather").append(" = '").append(str).append("' ");
    }

    public static void a(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.bitFlag").append(" & 1) ");
        stringBuilder.append(z ? "!=" : "==").append(" 0 ");
    }

    public static void b(StringBuilder stringBuilder, boolean z) {
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) ");
        stringBuilder.append(z ? "==" : "!=").append(" 0 ");
    }

    public static Cursor s(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        a(stringBuilder, false);
        b(stringBuilder, true);
        stringBuilder.append(" and (bizinfo.acceptType").append(" & ").append(i).append(") > 0 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(Db());
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", stringBuilder.toString());
        ak.yW();
        return com.tencent.mm.model.c.wE().rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor hq(String str) {
        String str2;
        List<String> hr = hr(str);
        List arrayList = new ArrayList();
        for (String str22 : hr) {
            if (!be.kS(ho(str22).CE())) {
                arrayList.add(str22);
            }
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        stringBuilder.append(" and (");
        for (int i = 0; i < arrayList.size(); i++) {
            str22 = (String) arrayList.get(i);
            if (i > 0) {
                stringBuilder.append(" or ");
            }
            stringBuilder.append("rcontact.username = '").append(str22).append("'");
        }
        stringBuilder.append(") order by ");
        stringBuilder.append(Dc());
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", stringBuilder.toString());
        ak.yW();
        return com.tencent.mm.model.c.wE().rawQuery(stringBuilder.toString(), null);
    }

    public static List<String> Dd() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rcontact.username");
        stringBuilder.append(", bizinfo.enterpriseFather");
        stringBuilder.append(", bizinfo.bitFlag").append(" & 1");
        c(stringBuilder);
        d(stringBuilder);
        stringBuilder.append(" and (");
        stringBuilder.append(" (bizinfo.bitFlag").append(" & 1) != 0");
        stringBuilder.append(" or ");
        stringBuilder.append(" (bizinfo.acceptType").append(" & 128) > 0 ");
        stringBuilder.append(" and (bizinfo.brandFlag").append(" & 1) == 0) ");
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", stringBuilder.toString());
        ak.yW();
        Cursor rawQuery = com.tencent.mm.model.c.wE().rawQuery(r0, null);
        List<String> linkedList = new LinkedList();
        if (rawQuery == null) {
            return linkedList;
        }
        if (rawQuery.moveToFirst()) {
            do {
                if ((rawQuery.getInt(2) > 0 ? 1 : 0) != 0) {
                    linkedList.add(rawQuery.getString(0));
                } else {
                    linkedList.add(rawQuery.getString(1));
                }
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        ak.yW();
        return com.tencent.mm.model.c.wH().ce(linkedList);
    }

    public static Cursor u(String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        b(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        b(stringBuilder, true);
        if (z) {
            a(stringBuilder, false);
        }
        stringBuilder.append(" order by ");
        stringBuilder.append(Dc());
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", stringBuilder.toString());
        ak.yW();
        return com.tencent.mm.model.c.wE().rawQuery(stringBuilder.toString(), null);
    }

    public static List<String> hr(String str) {
        List<String> list = null;
        StringBuilder stringBuilder = new StringBuilder();
        a(stringBuilder);
        c(stringBuilder);
        a(stringBuilder, str);
        v.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", stringBuilder.toString());
        ak.yW();
        Cursor rawQuery = com.tencent.mm.model.c.wE().rawQuery(r1, null);
        if (rawQuery != null) {
            list = new LinkedList();
            if (rawQuery.moveToFirst()) {
                do {
                    list.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return list;
    }

    public static String hs(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
            return null;
        } else if (cCF == null || !cCF.containsKey(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            a(stringBuilder);
            c(stringBuilder);
            a(stringBuilder, str);
            a(stringBuilder, true);
            v.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", stringBuilder.toString());
            ak.yW();
            Cursor rawQuery = com.tencent.mm.model.c.wE().rawQuery(r0, null);
            if (rawQuery == null) {
                return null;
            }
            if (rawQuery.moveToFirst()) {
                r0 = rawQuery.getString(0);
                cCF.put(str, r0);
                rawQuery.close();
                return r0;
            }
            rawQuery.close();
            return null;
        } else {
            r0 = (String) cCF.get(str);
            if (be.kS(r0) || !m.eC(r0)) {
                return null;
            }
            return r0;
        }
    }

    public static List<String> fi(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select bizinfo.username");
        stringBuilder.append(" from rcontact, bizinfo");
        stringBuilder.append(" where bizinfo.specialType").append(" = 1");
        stringBuilder.append(" and rcontact.username").append(" = bizinfo.username");
        stringBuilder.append(" and (rcontact.verifyFlag").append(" & ").append(u.bvo()).append(") != 0 ");
        stringBuilder.append(" and (rcontact.type").append(" & 1) != 0 ");
        v.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", stringBuilder.toString());
        ak.yW();
        Cursor rawQuery = com.tencent.mm.model.c.wE().rawQuery(r0, null);
        List<String> linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(rawQuery.getColumnIndex("username")));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public static boolean ht(String str) {
        boolean z = false;
        if (!be.kS(str) && e.hD(str)) {
            BizInfo hw = e.hw(str);
            if (!(hw.aX(false) == null || hw.aX(false).CZ() == null || be.kS(hw.CF()))) {
                ak.yW();
                com.tencent.mm.model.c.wK();
                af Ms = ac.Ms(hw.CF());
                if (Ms != null && Ms.field_username.equals(str) && Ms.field_unReadCount > 0) {
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mj(hw.CF());
                }
            }
            ak.yW();
            Cursor MR = com.tencent.mm.model.c.wJ().MR(str);
            MR.moveToFirst();
            while (!MR.isAfterLast()) {
                bx atVar = new at();
                atVar.b(MR);
                atVar.dh(4);
                v.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + atVar.field_msgSvrId + " status = " + atVar.field_status);
                MR.moveToNext();
                z = true;
            }
            MR.close();
            if (z) {
                ak.yW();
                com.tencent.mm.model.c.wK().Mj(str);
                ak.yW();
                com.tencent.mm.model.c.wJ().MP(str);
            }
        }
        return z;
    }

    public static void hu(String str) {
        if (!be.kS(str) && e.hD(str)) {
            ak.oH().db(str);
            ak.oH().oz();
        }
    }

    public static void hv(String str) {
        if (!be.kS(str) && e.hD(str)) {
            ak.oH().db(SQLiteDatabase.KeyEmpty);
        }
    }
}
