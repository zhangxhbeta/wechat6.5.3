package com.tencent.mm.ar;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.e.b.bu;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class i extends f<h> {
    public static final String[] cic = new String[]{f.a(h.chq, "LBSVerifyMessage")};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((h) cVar);
    }

    public i(d dVar) {
        super(dVar, h.chq, "LBSVerifyMessage", bu.btd);
        this.cie = dVar;
    }

    public final int Kw() {
        Cursor rawQuery = this.cie.rawQuery("select count(*) from " + getTableName() + " where status != 4", null);
        if (rawQuery.getCount() != 1) {
            rawQuery.close();
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public final int getCount() {
        Cursor rawQuery = this.cie.rawQuery("select count(*) from " + getTableName(), null);
        if (rawQuery.getCount() != 1) {
            rawQuery.close();
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public final h Kx() {
        Cursor rawQuery = this.cie.rawQuery("SELECT * FROM " + getTableName() + " where status != 4 ORDER BY createtime DESC LIMIT 1", null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() != 1) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        h hVar = new h();
        hVar.b(rawQuery);
        rawQuery.close();
        return hVar;
    }

    public final void Ky() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(4));
        if (this.cie.update(getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            Ls();
        }
    }

    public final void kI(String str) {
        int delete = this.cie.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            Ls();
        }
        v.i("MicroMsg.LBSVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void kJ(String str) {
        int delete = this.cie.delete(getTableName(), "sayhiuser = '" + str + "' or sayhiencryptuser='" + str + "'", null);
        if (delete > 0) {
            Ls();
        }
        v.i("MicroMsg.LBSVerifyMessageStorage", "delByUserName = " + delete);
    }

    public final void Kz() {
        this.cie.delete(getTableName(), null, null);
    }

    public final void a(bm bmVar, at.d dVar) {
        v.d("MicroMsg.LBSVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + bmVar.eeO + ", id = " + bmVar.mcb);
        h hVar = new h();
        hVar.field_content = m.a(bmVar.mbW);
        hVar.field_createtime = be.Nh();
        hVar.field_imgpath = SQLiteDatabase.KeyEmpty;
        hVar.field_sayhicontent = dVar.content;
        hVar.field_sayhiuser = dVar.lct;
        hVar.field_scene = dVar.scene;
        hVar.field_status = bmVar.eeO > 3 ? bmVar.eeO : 3;
        hVar.field_svrid = bmVar.mcb;
        hVar.field_talker = m.a(bmVar.mbU);
        hVar.field_type = bmVar.gll;
        hVar.field_isSend = 0;
        hVar.field_sayhiencryptuser = dVar.nvR;
        hVar.field_ticket = dVar.hUb;
        hVar.field_flag = 1;
        a(hVar);
        b.r(hVar.field_sayhiencryptuser, 3);
    }

    public final boolean a(h hVar) {
        if (hVar == null) {
            v.e("MicroMsg.LBSVerifyMessageStorage", "insert fail, lbsMsg is null");
            return false;
        } else if (!super.b(hVar)) {
            return false;
        } else {
            Lf(hVar.nmb);
            return true;
        }
    }

    public final h[] kK(String str) {
        h[] hVarArr = null;
        v.d("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage");
        Cursor rawQuery = this.cie.rawQuery("select *, rowid from LBSVerifyMessage  where sayhiuser = '" + be.lZ(str) + "' or sayhiencryptuser = '" + be.lZ(str) + "' order by createtime DESC limit 3", null);
        int count = rawQuery.getCount();
        if (count <= 0) {
            v.i("MicroMsg.LBSVerifyMessageStorage", "getLastLBSVerifyMessage, cursor count = 0");
            rawQuery.close();
        } else {
            hVarArr = new h[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                hVarArr[(count - i) - 1] = new h();
                hVarArr[(count - i) - 1].b(rawQuery);
            }
            rawQuery.close();
        }
        return hVarArr;
    }

    public final h kL(String str) {
        h hVar = null;
        v.d("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage");
        Cursor rawQuery = this.cie.rawQuery("select *, rowid from LBSVerifyMessage  where (sayhiuser = '" + be.lZ(str) + "' or sayhiencryptuser = '" + be.lZ(str) + "') and flag=1 order by createtime DESC limit 1", null);
        if (rawQuery.getCount() > 0) {
            hVar = new h();
            rawQuery.moveToPosition(0);
            hVar.b(rawQuery);
        } else {
            v.i("MicroMsg.LBSVerifyMessageStorage", "getLBSVerifyMessage, cursor count = 0");
        }
        rawQuery.close();
        return hVar;
    }

    public final h kM(String str) {
        h[] C = C(str, 1);
        if (C != null) {
            return C[0];
        }
        return null;
    }

    public final h[] C(String str, int i) {
        h[] hVarArr = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.LBSVerifyMessageStorage", "getLastRecvLbsMsg fail, talker is null");
        } else {
            Cursor rawQuery = this.cie.rawQuery("select * from LBSVerifyMessage where isSend = 0 and (sayhiuser = '" + be.lZ(str) + "' or sayhiencryptuser = '" + be.lZ(str) + "') order by createTime DESC limit " + i, null);
            int count = rawQuery.getCount();
            if (count > 0) {
                hVarArr = new h[count];
                for (int i2 = 0; i2 < count; i2++) {
                    rawQuery.moveToPosition(i2);
                    hVarArr[(count - i2) - 1] = new h();
                    hVarArr[(count - i2) - 1].b(rawQuery);
                }
            }
            rawQuery.close();
        }
        return hVarArr;
    }

    public static long kN(String str) {
        h hVar = null;
        long j = 0;
        if (str != null) {
            i KE = l.KE();
            Cursor rawQuery = KE.cie.rawQuery("SELECT * FROM " + KE.getTableName() + " ORDER BY createtime DESC LIMIT 1", null);
            if (rawQuery != null) {
                if (rawQuery.getCount() != 1) {
                    rawQuery.close();
                } else {
                    rawQuery.moveToFirst();
                    hVar = new h();
                    hVar.b(rawQuery);
                    rawQuery.close();
                }
            }
            if (hVar != null) {
                j = hVar.field_createtime + 1;
            }
        }
        long Nh = be.Nh();
        return j > Nh ? j : Nh;
    }
}
