package com.tencent.mm.model;

import com.tencent.mm.e.b.ab;
import com.tencent.mm.i.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class l {
    private static Set<String> crz = new HashSet();

    public static String ep(String str) {
        ak.yW();
        ab LX = c.wH().LX(str);
        if (LX == null || be.kS(LX.field_nickname)) {
            return str;
        }
        return LX.field_nickname;
    }

    public static String D(String str, String str2) {
        if (be.kS(str2)) {
            return er(str);
        }
        String et = et(str);
        if (!be.kS(et)) {
            return et;
        }
        o LC = ak.yW().wO().LC(str2);
        et = LC == null ? null : LC.er(str);
        if (be.kS(et)) {
            return er(str);
        }
        return et;
    }

    public static String eq(String str) {
        if (str == null || str.length() <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        ak.yW();
        ab LX = c.wH().LX(str);
        v.d("MicroMsg.ContactCommDisplay", "username: %s", str);
        if (LX == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && be.kS(LX.field_nickname)) {
            String er = ak.yW().wO().er(str);
            if (!be.kS(er)) {
                return er;
            }
        }
        if (LX.tT() == null || LX.tT().length() <= 0) {
            return str;
        }
        return LX.tT();
    }

    public static String er(String str) {
        if (str == null || str.length() <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        ak.yW();
        return a(c.wH().LX(str), str);
    }

    public static String es(String str) {
        if (m.dE(str)) {
            return str;
        }
        ak.yW();
        ab LX = c.wH().LX(str);
        if (LX == null) {
            return str;
        }
        if (!be.kS(LX.field_conRemarkPYFull)) {
            return LX.field_conRemarkPYFull;
        }
        if (!be.kS(LX.pF())) {
            return LX.pF();
        }
        if (be.kS(LX.pD())) {
            return str;
        }
        return LX.pD();
    }

    public static String a(u uVar, String str) {
        if (uVar == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && be.kS(uVar.field_nickname)) {
            String er = ak.yW().wO().er(str);
            if (!be.kS(er)) {
                return er;
            }
        }
        if (uVar.tU() == null || uVar.tU().length() <= 0) {
            return str;
        }
        return uVar.tU();
    }

    public static String a(u uVar, String str, boolean z) {
        if (uVar == null) {
            return str;
        }
        if (z && be.kS(uVar.field_nickname)) {
            return ak.yW().wO().er(str);
        }
        if (uVar.tU() != null && uVar.tU().length() > 0) {
            return uVar.tU();
        }
        if (be.kS(uVar.field_nickname) && m.fm(str)) {
            return a.dJ(str);
        }
        return str;
    }

    public static String c(u uVar) {
        String er = er(uVar.field_username);
        if (!m.dE(uVar.field_username) || !er.equals(uVar.field_username)) {
            return er;
        }
        List<String> LF = ak.yW().wO().LF(uVar.field_username);
        if (LF == null || LF.size() <= 0) {
            return aa.getResources().getString(2131230838);
        }
        List arrayList = new ArrayList();
        for (String er2 : LF) {
            arrayList.add(er(er2));
        }
        return "(" + be.b(arrayList, ", ") + ")";
    }

    public static String et(String str) {
        ak.yW();
        ab LX = c.wH().LX(str);
        if (LX == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (be.kS(LX.field_conRemark)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return LX.field_conRemark;
    }

    public static void c(Set<String> set) {
        crz = set;
    }

    public static String eu(String str) {
        if (crz.contains(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return str;
    }
}
