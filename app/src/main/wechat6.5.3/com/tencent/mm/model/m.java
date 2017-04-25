package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.af;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class m {
    public static final String crA = aa.j("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String crB = aa.j("rconversation.username", new String[]{"@t.qq.com"});
    public static final String crC = aa.j("rconversation.username", new String[]{"@qqim"});
    public static final String crD = aa.j("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String crE = aa.j("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String crF = aa.j("rconversation.username", new String[]{"@app"});
    public static final String[] crG = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "googlecontact", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    public static boolean ev(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            return true;
        }
        return false;
    }

    public static boolean dE(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static boolean ew(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@bottle");
    }

    public static boolean ex(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qqim");
    }

    public static boolean ey(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@lbsroom");
    }

    public static boolean d(u uVar) {
        if (uVar != null && be.ma(uVar.field_username).endsWith("@chatroom") && a.ei(uVar.field_type)) {
            return true;
        }
        return false;
    }

    public static boolean ez(String str) {
        return "gh_43f2581f6fd6".equals(str);
    }

    public static boolean eA(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.endsWith("@chatroom")) {
            return false;
        }
        ab LX = ((d) g.f(d.class)).wH().LX(str);
        if (LX == null || !a.ei(LX.field_type)) {
            return false;
        }
        return true;
    }

    public static boolean eB(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@stranger");
    }

    public static List<String> yp() {
        aa wH = ((d) g.f(d.class)).wH();
        Cursor rawQuery = wH.cie.rawQuery("select username from rcontact where " + aa.bvC(), null);
        List linkedList = new LinkedList();
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    linkedList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        return linkedList;
    }

    public static List<u> yq() {
        List<u> arrayList = new ArrayList();
        aa wH = ((d) g.f(d.class)).wH();
        Cursor rawQuery = wH.cie.rawQuery("select * ,rowid from rcontact  where " + aa.bvD(), null);
        if (rawQuery.moveToFirst()) {
            do {
                u uVar = new u();
                uVar.b(rawQuery);
                arrayList.add(uVar);
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    public static boolean eC(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return a.ei(((d) g.f(d.class)).wH().LX(str).field_type);
    }

    public static boolean eD(String str) {
        if (be.kS(str)) {
            return false;
        }
        ab LX = ((d) g.f(d.class)).wH().LX(str);
        if (LX == null) {
            return false;
        }
        return u.vd(LX.field_verifyFlag);
    }

    public static boolean eG(int i) {
        return u.vd(i);
    }

    public static void e(u uVar) {
        Assert.assertTrue(uVar != null);
        ab LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (!(LX == null || be.kS(LX.field_username))) {
            ab abVar = LX;
        }
        uVar.tt();
        r(uVar);
    }

    public static void k(String str, boolean z) {
        ab LX = ((d) g.f(d.class)).wH().LX(str);
        if (LX != null && !be.kS(LX.field_username)) {
            if (z) {
                LX.tC();
            } else {
                LX.tD();
            }
            q(LX);
        }
    }

    public static void f(u uVar) {
        Assert.assertTrue(uVar != null);
        ab LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (!(LX == null || be.kS(LX.field_username))) {
            ab abVar = LX;
        }
        uVar.tr();
        r(uVar);
    }

    public static void g(u uVar) {
        Assert.assertTrue(uVar != null);
        u LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (LX == null || be.kS(LX.field_username)) {
            LX = uVar;
        }
        LX.ts();
        r(LX);
        af Mh = ((d) g.f(d.class)).wK().Mh(uVar.field_username);
        if (Mh != null && "@blacklist".equals(Mh.field_parentRef)) {
            ((d) g.f(d.class)).wK().c(new String[]{Mh.field_username}, SQLiteDatabase.KeyEmpty);
        }
    }

    public static void h(u uVar) {
        Assert.assertTrue(uVar != null);
        u LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (LX == null || be.kS(LX.field_username)) {
            LX = uVar;
        }
        LX.tC();
        LX.cP(uVar.tm());
        q(LX);
    }

    public static void i(u uVar) {
        Assert.assertTrue(uVar != null);
        u LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (LX == null || be.kS(LX.field_username)) {
            LX = uVar;
        }
        LX.tD();
        LX.cP(uVar.tm());
        q(LX);
    }

    public static void j(u uVar) {
        Assert.assertTrue(uVar != null);
        u LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (LX == null || be.kS(LX.field_username)) {
            LX = uVar;
        }
        LX.ty();
        LX.cP(uVar.tm());
        r(LX);
    }

    public static void k(u uVar) {
        Assert.assertTrue(uVar != null);
        u LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (LX == null || be.kS(LX.field_username)) {
            LX = uVar;
        }
        LX.tz();
        LX.cP(uVar.tm());
        r(LX);
    }

    public static void l(String str, boolean z) {
        Assert.assertTrue(!be.kS(str));
        ab LX = ((d) g.f(d.class)).wH().LX(str);
        if (LX != null && !be.kS(LX.field_username)) {
            LX.setType(LX.field_type | 2048);
            r(LX);
            if (z) {
                ((d) g.f(d.class)).wK().Ml(str);
            }
        }
    }

    public static void eE(String str) {
        com.tencent.mm.storage.ab Mh = ((d) g.f(d.class)).wK().Mh(str);
        boolean z = false;
        if (Mh == null) {
            com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab();
            abVar.bvG();
            abVar.setUsername(str);
            Mh = abVar;
            z = true;
        }
        Mh.s(System.currentTimeMillis());
        if (z) {
            ((d) g.f(d.class)).wK().d(Mh);
        } else {
            ((d) g.f(d.class)).wK().a(Mh, str, true);
        }
    }

    public static void m(String str, boolean z) {
        Assert.assertTrue(!be.kS(str));
        ab LX = ((d) g.f(d.class)).wH().LX(str);
        if (LX != null && !be.kS(LX.field_username)) {
            LX.setType(LX.field_type & -2049);
            r(LX);
            if (z) {
                ((d) g.f(d.class)).wK().Mm(str);
            }
        }
    }

    public static void l(u uVar) {
        Assert.assertTrue(uVar != null);
        ab LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (!(LX == null || be.kS(LX.field_username))) {
            ab abVar = LX;
        }
        uVar.tA();
        r(uVar);
    }

    public static void m(u uVar) {
        Assert.assertTrue(uVar != null);
        ab LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        if (!(LX == null || be.kS(LX.field_username))) {
            ab abVar = LX;
        }
        uVar.tB();
        r(uVar);
    }

    public static void n(u uVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", uVar != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) uVar.chr) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (uVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        uVar.tp();
        ((d) g.f(d.class)).wH().a(uVar.field_username, uVar);
    }

    public static void o(u uVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(uVar != null);
        if (((int) uVar.chr) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (uVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        uVar.tp();
        ((d) g.f(d.class)).wH().a(uVar.field_username, uVar);
        r(uVar);
    }

    public static void b(u uVar, String str) {
        u LX = ((d) g.f(d.class)).wH().LX(uVar.field_username);
        boolean z = (LX == null || str == null) ? false : true;
        Assert.assertTrue(z);
        LX.bQ(str);
        r(LX);
    }

    public static void p(u uVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(uVar != null);
        if (((int) uVar.chr) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (uVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        uVar.tR();
        r(uVar);
    }

    private static void q(u uVar) {
        Assert.assertTrue(uVar != null);
        if (((int) uVar.chr) == 0) {
            ((d) g.f(d.class)).wH().O(uVar);
            ((d) g.f(d.class)).wH().LX(uVar.field_username);
        }
        ((d) g.f(d.class)).wH().a(uVar.field_username, uVar);
        com.tencent.mm.ba.a com_tencent_mm_protocal_c_ajg = new ajg();
        com_tencent_mm_protocal_c_ajg.mJq = uVar.field_username;
        if (uVar.tO()) {
            com_tencent_mm_protocal_c_ajg.mJC = 1;
        } else {
            com_tencent_mm_protocal_c_ajg.mJC = 2;
        }
        ((d) g.f(d.class)).wG().b(new j.a(52, com_tencent_mm_protocal_c_ajg));
    }

    public static void r(u uVar) {
        Assert.assertTrue(uVar != null);
        if (((int) uVar.chr) == 0) {
            ((d) g.f(d.class)).wH().O(uVar);
            ((d) g.f(d.class)).wH().LX(uVar.field_username);
        }
        ((d) g.f(d.class)).wH().a(uVar.field_username, uVar);
        s(uVar);
    }

    public static void s(u uVar) {
        v.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", uVar.field_username, uVar.field_conRemark, Integer.valueOf(uVar.field_type));
        ais com_tencent_mm_protocal_c_ais = new ais();
        com.tencent.mm.ba.a com_tencent_mm_protocal_c_ais2 = new ais();
        com_tencent_mm_protocal_c_ais2.moM = new arf().JF(be.ma(uVar.field_username));
        com_tencent_mm_protocal_c_ais2.mEj = new arf().JF(be.ma(uVar.field_nickname));
        com_tencent_mm_protocal_c_ais2.moC = new arf().JF(be.ma(uVar.pE()));
        com_tencent_mm_protocal_c_ais2.moD = new arf().JF(be.ma(uVar.pF()));
        com_tencent_mm_protocal_c_ais2.cHc = uVar.bBZ;
        com_tencent_mm_protocal_c_ais2.mnV = 36735;
        com_tencent_mm_protocal_c_ais2.mnW = uVar.field_type;
        com_tencent_mm_protocal_c_ais2.mIO = new arf().JF(be.ma(uVar.field_conRemark));
        com_tencent_mm_protocal_c_ais2.mIP = new arf().JF(be.ma(uVar.field_conRemarkPYShort));
        com_tencent_mm_protocal_c_ais2.mIQ = new arf().JF(be.ma(uVar.field_conRemarkPYFull));
        com_tencent_mm_protocal_c_ais2.mob = uVar.bCe;
        com_tencent_mm_protocal_c_ais2.mIX = new arf().JF(be.ma(uVar.field_domainList));
        com_tencent_mm_protocal_c_ais2.mof = uVar.bCh;
        com_tencent_mm_protocal_c_ais2.cHg = uVar.bCi;
        com_tencent_mm_protocal_c_ais2.cHf = be.ma(uVar.bCj);
        com_tencent_mm_protocal_c_ais2.cHe = be.ma(uVar.getCityCode());
        com_tencent_mm_protocal_c_ais2.cHd = be.ma(uVar.bvq());
        com_tencent_mm_protocal_c_ais2.mFw = be.ma(uVar.bCo);
        com_tencent_mm_protocal_c_ais2.mFy = uVar.field_weiboFlag;
        com_tencent_mm_protocal_c_ais2.mIT = 0;
        com_tencent_mm_protocal_c_ais2.mbY = new are();
        com_tencent_mm_protocal_c_ais2.cHl = be.ma(uVar.getCountryCode());
        com_tencent_mm_protocal_c_ais2.moP = uVar.field_contactLabelIds;
        ((d) g.f(d.class)).wG().b(new j.a(2, com_tencent_mm_protocal_c_ais2));
    }

    public static void eF(String str) {
        if (!be.kS(str)) {
            u LX = ((d) g.f(d.class)).wH().LX(str);
            if (LX != null) {
                LX.tn();
                ((d) g.f(d.class)).wH().a(str, LX);
            }
        }
    }

    public static int[] a(String str, String str2, List<String> list, String str3) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((d) g.f(d.class)).wH().b(str, str2, str3, (List) list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((d) g.f(d.class)).wH().c(str, str2, str3, list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] u(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cf = ((d) g.f(d.class)).wH().cf(list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (cf.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] cg = ((d) g.f(d.class)).wH().cg(list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cg == null) {
            return null;
        }
        Assert.assertTrue(cf.length == cg.length);
        int[] iArr = new int[cg.length];
        int i2 = 0;
        int i3 = 0;
        while (i < cf.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += cg[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        int i = 0;
        int[] b = ((d) g.f(d.class)).wH().b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            return null;
        }
        int[] iArr;
        int i2;
        Cursor rawQuery = ((d) g.f(d.class)).wH().cie.rawQuery(("select count(*) from rcontact " + aa.e(str, str2, list) + aa.E(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (i2 = 0; i2 < count; i2++) {
                rawQuery.moveToPosition(i2);
                iArr[i2] = rawQuery.getInt(0);
            }
        } else {
            iArr = null;
        }
        rawQuery.close();
        if (iArr == null) {
            return null;
        }
        Assert.assertTrue(b.length == iArr.length);
        int[] iArr2 = new int[iArr.length];
        int i3 = 0;
        i2 = 0;
        while (i < b.length) {
            int i4 = i2 + 1;
            iArr2[i2] = i3;
            i3 += iArr[i];
            i++;
            i2 = i4;
        }
        return iArr2;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((d) g.f(d.class)).wH().b(str, str2, strArr, (List) list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr2[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr2[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr2[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr2;
    }

    public static String[] a(String str, String str2, String str3, List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((d) g.f(d.class)).wH().b(str, str2, str3, (List) list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr;
    }

    public static String[] v(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] cf = ((d) g.f(d.class)).wH().cf(list);
        v.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (cf.length <= 0) {
            return null;
        }
        String[] strArr = new String[cf.length];
        for (int i2 : cf) {
            int i22;
            char c = (char) i22;
            if (c == '{') {
                i22 = i + 1;
                strArr[i] = "#";
                i = i22;
            } else if (c == ' ') {
                i22 = i + 1;
                strArr[i] = "$";
                i = i22;
            } else {
                i22 = i + 1;
                strArr[i] = String.valueOf(c);
                i = i22;
            }
        }
        return strArr;
    }

    public static boolean eG(String str) {
        return str != null ? str.equalsIgnoreCase("qqmail") : false;
    }

    public static boolean eH(String str) {
        return str != null ? str.equalsIgnoreCase("fmessage") : false;
    }

    public static boolean eI(String str) {
        return str != null ? str.equalsIgnoreCase("tmessage") : false;
    }

    public static boolean eJ(String str) {
        return str != null ? str.equalsIgnoreCase("floatbottle") : false;
    }

    public static boolean eK(String str) {
        return str != null ? str.equalsIgnoreCase("qmessage") : false;
    }

    public static boolean eL(String str) {
        return str != null ? str.equalsIgnoreCase("facebookapp") : false;
    }

    public static boolean eM(String str) {
        return str != null ? str.equalsIgnoreCase("masssendapp") : false;
    }

    public static boolean yr() {
        return false;
    }

    public static boolean eN(String str) {
        return str != null ? str.equalsIgnoreCase("feedsapp") : false;
    }

    public static boolean eO(String str) {
        return "qqsync".equalsIgnoreCase(str);
    }

    public static boolean eP(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773");
        } else {
            return false;
        }
    }

    public static boolean eQ(String str) {
        return str != null ? str.equalsIgnoreCase("lbsapp") : false;
    }

    public static boolean eR(String str) {
        return str != null ? str.equalsIgnoreCase("shakeapp") : false;
    }

    public static boolean eS(String str) {
        return str != null ? str.equalsIgnoreCase("medianote") : false;
    }

    public static boolean eT(String str) {
        return str != null ? str.equalsIgnoreCase("newsapp") : false;
    }

    public static boolean eU(String str) {
        return str != null ? str.equalsIgnoreCase("voipapp") : false;
    }

    public static boolean eV(String str) {
        return str != null ? str.equalsIgnoreCase("voicevoipapp") : false;
    }

    public static boolean eW(String str) {
        return str != null ? str.equalsIgnoreCase("voiceinputapp") : false;
    }

    public static boolean eX(String str) {
        return str != null ? str.equalsIgnoreCase("linkedinplugin") : false;
    }

    public static boolean eY(String str) {
        return fa(str);
    }

    public static boolean eZ(String str) {
        return str != null ? str.equalsIgnoreCase("gh_43f2581f6fd6") : false;
    }

    public static boolean fa(String str) {
        return str != null ? str.equalsIgnoreCase("gh_22b87fa7cb3c") : false;
    }

    public static boolean fb(String str) {
        return str != null ? str.equalsIgnoreCase("blogapp") : false;
    }

    public static boolean fc(String str) {
        return str != null ? str.equalsIgnoreCase("officialaccounts") : false;
    }

    public static boolean fd(String str) {
        return str != null ? str.equalsIgnoreCase("helper_entry") : false;
    }

    public static boolean fe(String str) {
        return str != null ? str.equalsIgnoreCase("qqfriend") : false;
    }

    public static boolean ff(String str) {
        return str != null ? str.equalsIgnoreCase("googlecontact") : false;
    }

    public static boolean fg(String str) {
        return "filehelper".equalsIgnoreCase(str);
    }

    public static boolean fh(String str) {
        return str != null ? str.equalsIgnoreCase("pc_share") : false;
    }

    public static boolean fi(String str) {
        return str != null ? str.equalsIgnoreCase("notifymessage") : false;
    }

    public static boolean fj(String str) {
        return str != null ? str.equalsIgnoreCase("notification_messages") : false;
    }

    public static boolean fk(String str) {
        if (fl(str) || fn(str) || fc(str) || fd(str)) {
            return true;
        }
        return false;
    }

    public static boolean fl(String str) {
        g.vx();
        String str2 = (String) g.vw().vf().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            return false;
        }
        return true;
    }

    public static boolean fm(String str) {
        return str != null ? str.equalsIgnoreCase("appbrandcustomerservicemsg") : false;
    }

    public static boolean fn(String str) {
        for (String equalsIgnoreCase : crG) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean fo(String str) {
        if (fn(str) || u.LJ(str) || u.LH(str) || u.ew(str)) {
            return true;
        }
        return false;
    }

    public static int fp(String str) {
        Assert.assertTrue(be.ma(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 1;
        }
        if (u.LH(toLowerCase)) {
            return 11;
        }
        if (u.LJ(toLowerCase)) {
            return 36;
        }
        return u.ew(toLowerCase) ? 1 : 1;
    }

    public static int fq(String str) {
        Assert.assertTrue(be.ma(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 3;
        }
        if (u.LH(toLowerCase)) {
            return 13;
        }
        if (u.LJ(toLowerCase)) {
            return 39;
        }
        if (u.ew(toLowerCase)) {
            return 3;
        }
        if (toLowerCase.contains("@")) {
            return 3;
        }
        return 3;
    }

    public static boolean fr(String str) {
        if (((d) g.f(d.class)).wH().LX(str).bCh != 1) {
            return false;
        }
        return true;
    }

    public static boolean fs(String str) {
        u LX = ((d) g.f(d.class)).wH().LX(str);
        if (LX == null || !LX.tM()) {
            return false;
        }
        return true;
    }

    public static boolean ft(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            return true;
        }
        return false;
    }

    public static String fu(String str) {
        if (ft(str)) {
            return str.replace("http://t.qq.com/", SQLiteDatabase.KeyEmpty).replace("t.qq.com/", SQLiteDatabase.KeyEmpty);
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public static boolean t(u uVar) {
        return (uVar.field_weiboFlag & 1) != 0;
    }

    public static boolean ys() {
        if (!k.yn()) {
            return false;
        }
        ax Nr = ((d) g.f(d.class)).wN().Nr("@t.qq.com");
        if (Nr == null || be.kS(Nr.name)) {
            return false;
        }
        return true;
    }

    public static boolean yt() {
        if (!k.yn()) {
            return false;
        }
        ax Nr = ((d) g.f(d.class)).wN().Nr("@t.qq.com");
        if (Nr == null || be.ma(Nr.name).length() == 0) {
            return false;
        }
        return true;
    }

    public static List<u> yu() {
        List<u> linkedList = new LinkedList();
        aa wH = ((d) g.f(d.class)).wH();
        String str = "select * ,rowid from rcontact " + aa.bvB() + " AND " + aa.nux + " AND " + aa.nuw + aa.bvA();
        v.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = wH.cie.rawQuery(str, null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return linkedList;
        }
        rawQuery.moveToFirst();
        do {
            u uVar = new u();
            uVar.b(rawQuery);
            linkedList.add(uVar);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        v.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        return linkedList;
    }

    public static List<String> yv() {
        List<String> linkedList = new LinkedList();
        aa wH = ((d) g.f(d.class)).wH();
        String str = "select * ,rowid from rcontact " + aa.bvB() + " AND type & 256" + " !=0 " + aa.bvz();
        v.v("MicroMsg.ContactStorage", str);
        Cursor rawQuery = wH.cie.rawQuery(str, null);
        if (rawQuery.getCount() == 0) {
            rawQuery.close();
            return linkedList;
        }
        rawQuery.moveToFirst();
        do {
            ab uVar = new u();
            uVar.b(rawQuery);
            linkedList.add(uVar.field_username);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        v.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        return linkedList;
    }

    public static boolean a(com.tencent.mm.storage.ab abVar) {
        String str = abVar.field_username;
        if (fn(str) || fl(str) || fc(str) || fd(str) || abVar.field_conversationTime == -1) {
            return false;
        }
        if (eD(str)) {
            return true;
        }
        return true;
    }

    public static boolean b(com.tencent.mm.storage.ab abVar) {
        String str = abVar.field_username;
        if (fc(str) || fm(str)) {
            return false;
        }
        return true;
    }

    public static int yw() {
        return ((d) g.f(d.class)).wH().b(crG, k.xF(), "weixin", "helper_entry", "filehelper");
    }
}
