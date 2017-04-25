package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.mm.h.h;
import com.tencent.mm.i.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class u extends a implements Cloneable {
    public CharSequence nnS;
    public String nul = null;

    public u(String str) {
        super(str);
    }

    public static boolean LH(String str) {
        return str != null ? str.endsWith("@t.qq.com") : false;
    }

    public static boolean LI(String str) {
        return str != null ? str.endsWith("@qr") : false;
    }

    public static boolean LJ(String str) {
        return str != null ? str.endsWith("@qqim") : false;
    }

    public static boolean LK(String str) {
        return str != null ? str.endsWith("@fb") : false;
    }

    public static boolean ew(String str) {
        if (str != null) {
            return str.contains("@bottle:") || str.endsWith("@bottle");
        } else {
            return false;
        }
    }

    public static boolean vd(int i) {
        return (i & 8) > 0;
    }

    public static boolean dW(String str) {
        return str != null ? str.endsWith("@app") : false;
    }

    public static boolean LL(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.Contact", "Contact invisibleUsername username == null or nil");
            return false;
        }
        String z = ((h) g.f(h.class)).sV().z("HideWechatID", "idprefix");
        if (z == null) {
            z = "wx_;wxid_;gh_;a0;a1;a2;a3;a4;a5;a6;a7;a8;a9;q0;q1;q2;q3;q4;q5;q6;q7;q8;q9;qq0;qq1;qq2;qq3;qq4;qq5;qq6;qq7;qq8;qq9;f0;f1;f2;f3;f4;f5;f6;f7;f8;f9;F0;F1;F2;F3;F4;F5;F6;F7;F8;F9;";
        }
        String[] split = z.split(";");
        int i = 0;
        while (i < split.length) {
            if (split[i] != null && str.startsWith(split[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static String LM(String str) {
        if (ew(str)) {
            String[] split = str.split(":");
            if (split == null || split.length <= 0) {
                return str;
            }
            return split[0];
        } else if (str == null || !str.contains("@")) {
            return str + "@bottle";
        } else {
            return SQLiteDatabase.KeyEmpty;
        }
    }

    public final boolean bvm() {
        return (this.field_verifyFlag & 8) > 0;
    }

    public static int bvn() {
        return 16;
    }

    public static int bvo() {
        return 8;
    }

    public final boolean bvp() {
        return ((long) (((int) be.Nh()) - this.bCr)) > 86400;
    }

    public static String f(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex("username"));
    }

    public final void cl(String str) {
        super.cl(str);
        bvr();
    }

    public final String getCountryCode() {
        String str = this.bCq;
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        String[] split = str.split("_");
        if (split == null || split.length <= 0) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ma(split[0]);
    }

    public final String bvq() {
        String str = this.bCq;
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        String[] split = str.split("_");
        if (split == null || split.length < 2) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ma(split[1]);
    }

    public final String getCityCode() {
        String str = this.bCq;
        if (be.kS(str)) {
            return SQLiteDatabase.KeyEmpty;
        }
        String[] split = str.split("_");
        if (split == null || split.length < 3) {
            return SQLiteDatabase.KeyEmpty;
        }
        return be.ma(split[2]);
    }

    @Deprecated
    public final void cg(String str) {
        super.cg(str);
    }

    @Deprecated
    public final void ch(String str) {
        super.ch(str);
    }

    public final String getProvince() {
        return super.getProvince();
    }

    public final String getCity() {
        return super.getCity();
    }

    public final void bvr() {
        String str = this.bCq;
        if (!be.kS(str)) {
            String[] split = str.split("_");
            if (split.length <= 0) {
                return;
            }
            if (split.length > 2) {
                if (RegionCodeDecoder.Nn(split[0])) {
                    super.cg(RegionCodeDecoder.bxc().dP(split[0], split[1]));
                } else {
                    super.cg(RegionCodeDecoder.bxc().No(split[0]));
                }
                super.ch(RegionCodeDecoder.bxc().Z(split[0], split[1], split[2]));
            } else if (split.length == 2) {
                super.cg(RegionCodeDecoder.bxc().No(split[0]));
                super.ch(RegionCodeDecoder.bxc().dP(split[0], split[1]));
            } else {
                super.cg(RegionCodeDecoder.bxc().No(split[0]));
                super.ch(SQLiteDatabase.KeyEmpty);
            }
        }
    }

    public final u bvs() {
        try {
            return (u) super.clone();
        } catch (Throwable e) {
            v.a("MicroMsg.Contact", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.Contact", "clone Contact error. e: " + e.toString());
            return null;
        }
    }
}
