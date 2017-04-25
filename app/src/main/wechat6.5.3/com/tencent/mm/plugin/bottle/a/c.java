package com.tencent.mm.plugin.bottle.a;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.g;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;

public final class c {
    private static int etg = 1;
    private static int eth = 1;

    public static int Xy() {
        return etg;
    }

    public static int Xz() {
        return eth;
    }

    public static void iu(int i) {
        etg = i;
    }

    public static void iv(int i) {
        eth = i;
    }

    public static int XA() {
        return g.xD();
    }

    public static int iw(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 3;
            case 3:
                return 34;
            case 4:
                return 43;
            default:
                return -1;
        }
    }

    public static String pw(String str) {
        if (be.kS(str)) {
            return null;
        }
        String[] split = str.split("@bottle:");
        if (split == null || split.length < 2) {
            return null;
        }
        return split[1];
    }

    public static void px(String str) {
        String[] strArr = null;
        a.drq.ow();
        ak.yW();
        if (com.tencent.mm.model.c.wJ().MW(str) == 1) {
            ak.yW();
            at MI = com.tencent.mm.model.c.wJ().MI(str);
            if (MI != null && MI.field_talker.equals(str)) {
                String pw = pw(str);
                if (!be.kS(pw)) {
                    a aVar;
                    Cursor rawQuery = i.XG().cuX.rawQuery("select bottleinfo1.parentclientid,bottleinfo1.childcount,bottleinfo1.bottleid,bottleinfo1.bottletype,bottleinfo1.msgtype,bottleinfo1.voicelen,bottleinfo1.content,bottleinfo1.createtime,bottleinfo1.reserved1,bottleinfo1.reserved2,bottleinfo1.reserved3,bottleinfo1.reserved4 from bottleinfo1   where bottleinfo1.bottleid = \"" + be.lZ(pw) + "\"", null);
                    if (rawQuery == null) {
                        aVar = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            strArr = new a();
                            strArr.eta = rawQuery.getString(0);
                            strArr.etb = rawQuery.getInt(1);
                            strArr.etc = rawQuery.getString(2);
                            strArr.etd = rawQuery.getInt(3);
                            strArr.msgType = rawQuery.getInt(4);
                            strArr.ete = rawQuery.getInt(5);
                            strArr.content = rawQuery.getString(6);
                            strArr.etf = rawQuery.getLong(7);
                            strArr.cuT = rawQuery.getInt(8);
                            strArr.cHX = rawQuery.getInt(9);
                            strArr.cuV = rawQuery.getString(10);
                            strArr.cuW = rawQuery.getString(11);
                        }
                        rawQuery.close();
                        aVar = strArr;
                    }
                    if (aVar != null && aVar.Xx().equals(pw) && aVar.etd == 1) {
                        at atVar = new at();
                        atVar.cH(str);
                        atVar.z(MI.field_createTime <= aVar.etf ? MI.field_createTime - 1 : aVar.etf);
                        atVar.setType(iw(aVar.msgType));
                        atVar.dh(2);
                        atVar.di(1);
                        if (atVar.field_type == 34) {
                            atVar.setContent(n.b(k.xF(), (long) aVar.ete, false));
                            String str2 = aVar.pO() + be.Ni();
                            if (j.dz(q.iU(aVar.pO()), q.iU(str2))) {
                                atVar.cI(str2);
                            } else {
                                v.e("MicroMsg.BottleLogic", "Copy Bottle Voice File Failed :" + aVar.pO());
                                return;
                            }
                        }
                        atVar.setContent(aVar.pO());
                        ak.yW();
                        com.tencent.mm.model.c.wJ().R(atVar);
                    }
                }
            }
        }
    }

    public static void XB() {
        String[] strArr;
        b XG = i.XG();
        Cursor rawQuery = XG.cuX.rawQuery("select distinct content , msgtype from bottleinfo1 where bottleinfo1.createtime < " + (be.Ni() - 7776000000L), null);
        int count = rawQuery.getCount();
        if (count > 0) {
            strArr = new String[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                if (rawQuery.getInt(1) == 3) {
                    strArr[i] = rawQuery.getString(0);
                } else {
                    strArr[i] = null;
                }
            }
        } else {
            strArr = null;
        }
        rawQuery.close();
        if (count > 0) {
            XG.cuX.delete("bottleinfo1", "createtime< ?", new String[]{String.valueOf(r6)});
        }
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                v.d("MicroMsg.BottleLogic", "delete path:" + q.iU(strArr[i2]));
                if (!be.kS(q.iU(strArr[i2]))) {
                    b.deleteFile(q.iU(strArr[i2]));
                }
            }
        }
    }

    public static String a(Context context, u uVar) {
        if (uVar == null) {
            return context.getString(2131231544);
        }
        if (!RegionCodeDecoder.Nn(uVar.getCountryCode())) {
            return context.getString(2131231544);
        }
        String city = uVar.getCity();
        if (!be.kS(city)) {
            return city;
        }
        city = l.eu(uVar.getProvince());
        if (!be.kS(city)) {
            return city;
        }
        RegionCodeDecoder.bxc();
        return RegionCodeDecoder.getLocName(uVar.getCountryCode());
    }

    public static String b(Context context, u uVar) {
        if (uVar == null) {
            return context.getString(2131231544);
        }
        String eu = l.eu(uVar.getProvince());
        if (RegionCodeDecoder.Nn(uVar.getCountryCode())) {
            if (be.kS(uVar.getCity())) {
                StringBuilder stringBuilder = new StringBuilder();
                RegionCodeDecoder.bxc();
                eu = stringBuilder.append(RegionCodeDecoder.getLocName(uVar.getCountryCode())).append(eu).toString();
            } else {
                eu = eu + uVar.getCity();
            }
        }
        return be.kS(eu) ? context.getString(2131231544) : eu;
    }
}
