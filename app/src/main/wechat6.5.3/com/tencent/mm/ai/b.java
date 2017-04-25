package com.tencent.mm.ai;

import android.content.Context;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    public static final void rb() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 1;
        a.nhr.z(icVar);
    }

    public static final void rc() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 2;
        a.nhr.z(icVar);
    }

    public static final void HB() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = -1;
        a.nhr.z(icVar);
    }

    public static final void a(ajr com_tencent_mm_protocal_c_ajr) {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 6;
        icVar.bhZ.bib = com_tencent_mm_protocal_c_ajr;
        a.nhr.z(icVar);
    }

    public static boolean HC() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = -3;
        a.nhr.z(icVar);
        return icVar.bia.aXR;
    }

    public static boolean HD() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 9;
        a.nhr.z(icVar);
        return icVar.bia.aXR;
    }

    public static ajr HE() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = -2;
        a.nhr.z(icVar);
        return icVar.bia.bib;
    }

    public static void b(ajr com_tencent_mm_protocal_c_ajr) {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 0;
        icVar.bhZ.bib = com_tencent_mm_protocal_c_ajr;
        a.nhr.z(icVar);
    }

    public static void c(ajr com_tencent_mm_protocal_c_ajr) {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 3;
        icVar.bhZ.bib = com_tencent_mm_protocal_c_ajr;
        a.nhr.z(icVar);
    }

    public static ajr a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        ajr com_tencent_mm_protocal_c_ajr = new ajr();
        com_tencent_mm_protocal_c_ajr.mJV = i;
        com_tencent_mm_protocal_c_ajr.mKb = str;
        com_tencent_mm_protocal_c_ajr.mJY = str2;
        com_tencent_mm_protocal_c_ajr.mJZ = str3;
        com_tencent_mm_protocal_c_ajr.mKe = str4;
        com_tencent_mm_protocal_c_ajr.mKd = str5;
        com_tencent_mm_protocal_c_ajr.mKc = str6;
        com_tencent_mm_protocal_c_ajr.mKh = str8;
        com_tencent_mm_protocal_c_ajr.glj = str10;
        com_tencent_mm_protocal_c_ajr.mKg = str9;
        com_tencent_mm_protocal_c_ajr.mJW = str7;
        com_tencent_mm_protocal_c_ajr.mJX = 0.0f;
        com_tencent_mm_protocal_c_ajr.mKa = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_ajr.mfh = 1;
        com_tencent_mm_protocal_c_ajr.mKf = null;
        com_tencent_mm_protocal_c_ajr.mfo = str7;
        return com_tencent_mm_protocal_c_ajr;
    }

    public static ajr a(String str, azr com_tencent_mm_protocal_c_azr, int i) {
        String str2 = null;
        if (com_tencent_mm_protocal_c_azr == null || com_tencent_mm_protocal_c_azr.mWq == null || com_tencent_mm_protocal_c_azr.mWq.mom == null || com_tencent_mm_protocal_c_azr.mWq.mom.size() <= 0) {
            return null;
        }
        aib com_tencent_mm_protocal_c_aib = (aib) com_tencent_mm_protocal_c_azr.mWq.mom.get(0);
        if (com_tencent_mm_protocal_c_aib == null) {
            return null;
        }
        ajr com_tencent_mm_protocal_c_ajr = new ajr();
        com_tencent_mm_protocal_c_ajr.mJV = i;
        com_tencent_mm_protocal_c_ajr.mJW = com_tencent_mm_protocal_c_azr.gID;
        com_tencent_mm_protocal_c_ajr.mJX = 0.0f;
        com_tencent_mm_protocal_c_ajr.mKa = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_ajr.mKb = com_tencent_mm_protocal_c_aib.mHP;
        com_tencent_mm_protocal_c_ajr.mKg = null;
        com_tencent_mm_protocal_c_ajr.mfh = 1;
        com_tencent_mm_protocal_c_ajr.mKf = null;
        com_tencent_mm_protocal_c_ajr.mJY = com_tencent_mm_protocal_c_aib.aXz;
        com_tencent_mm_protocal_c_ajr.mJZ = com_tencent_mm_protocal_c_aib.gkC;
        if (com_tencent_mm_protocal_c_azr.mWq != null) {
            str2 = com_tencent_mm_protocal_c_azr.mWq.glb;
        }
        com_tencent_mm_protocal_c_ajr.mKe = str2;
        com_tencent_mm_protocal_c_ajr.mKd = com_tencent_mm_protocal_c_aib.mHT;
        com_tencent_mm_protocal_c_ajr.mKc = com_tencent_mm_protocal_c_aib.glb;
        com_tencent_mm_protocal_c_ajr.mKi = com_tencent_mm_protocal_c_aib.mHQ;
        com_tencent_mm_protocal_c_ajr.mfo = com_tencent_mm_protocal_c_aib.gID;
        com_tencent_mm_protocal_c_ajr.mKh = str;
        com_tencent_mm_protocal_c_ajr.glj = com_tencent_mm_protocal_c_azr.mWp.gID;
        com_tencent_mm_protocal_c_ajr.mKn = com_tencent_mm_protocal_c_azr.gln;
        return com_tencent_mm_protocal_c_ajr;
    }

    public static h q(Context context, int i) {
        h.a aVar = new h.a(context);
        aVar.wm(2131231164);
        aVar.wn(i);
        aVar.wp(2131233930).a(null);
        aVar.jk(true);
        h RX = aVar.RX();
        RX.show();
        return RX;
    }

    public static boolean d(ajr com_tencent_mm_protocal_c_ajr) {
        if (com_tencent_mm_protocal_c_ajr == null) {
            return false;
        }
        switch (com_tencent_mm_protocal_c_ajr.mJV) {
            case 1:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static boolean fR(int i) {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 7;
        icVar.bhZ.position = i;
        a.nhr.z(icVar);
        return icVar.bia.aXR;
    }

    public static d HF() {
        com.tencent.mm.sdk.c.b icVar = new ic();
        icVar.bhZ.action = 8;
        a.nhr.z(icVar);
        return icVar.bia.bie;
    }
}
