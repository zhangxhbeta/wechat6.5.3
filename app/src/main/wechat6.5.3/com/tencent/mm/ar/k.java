package com.tencent.mm.ar;

import android.database.Cursor;
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

public final class k extends f<j> {
    public static final String[] btd = new String[]{"CREATE INDEX IF NOT EXISTS  shakeverifymessage_unread_index ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_statusIndex ON shakeverifymessage ( status )", "CREATE INDEX IF NOT EXISTS shakeverifymessage_createtimeIndex ON shakeverifymessage ( createtime )"};
    public static final String[] cic = new String[]{f.a(j.chq, "shakeverifymessage")};
    public d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((j) cVar);
    }

    public k(d dVar) {
        super(dVar, j.chq, "shakeverifymessage", btd);
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

    public final j KA() {
        Cursor rawQuery = this.cie.rawQuery("SELECT * FROM " + getTableName() + " ORDER BY createtime DESC LIMIT 1", null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() != 1) {
            rawQuery.close();
            return null;
        }
        rawQuery.moveToFirst();
        j jVar = new j();
        jVar.b(rawQuery);
        rawQuery.close();
        return jVar;
    }

    public final void kI(String str) {
        int delete = this.cie.delete(getTableName(), "svrid = '" + str + "'", null);
        if (delete > 0) {
            Ls();
        }
        v.i("MicroMsg.ShakeVerifyMessageStorage", "delBySvrId = " + delete);
    }

    public final void Kz() {
        this.cie.delete(getTableName(), null, null);
    }

    public final void a(bm bmVar, at.d dVar) {
        v.d("MicroMsg.ShakeVerifyMessageStorage", "saveToVerifyStg, cmdAM, status = " + bmVar.eeO + ", id = " + bmVar.mcb);
        j jVar = new j();
        jVar.field_content = m.a(bmVar.mbW);
        jVar.field_createtime = be.Nh();
        jVar.field_imgpath = SQLiteDatabase.KeyEmpty;
        jVar.field_sayhicontent = dVar.content;
        jVar.field_sayhiuser = dVar.lct;
        jVar.field_scene = dVar.scene;
        jVar.field_status = bmVar.eeO > 3 ? bmVar.eeO : 3;
        jVar.field_svrid = bmVar.mcb;
        jVar.field_talker = m.a(bmVar.mbU);
        jVar.field_type = bmVar.gll;
        jVar.field_isSend = 0;
        a(jVar);
        b.r(jVar.field_sayhiuser, 3);
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            v.e("MicroMsg.ShakeVerifyMessageStorage", "insert fail, shakeMsg is null");
            return false;
        } else if (!super.b(jVar)) {
            return false;
        } else {
            Lf(jVar.nmb);
            return true;
        }
    }

    public final j kO(String str) {
        j[] D = D(str, 1);
        if (D != null) {
            return D[0];
        }
        return null;
    }

    public final j[] D(String str, int i) {
        j[] jVarArr = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.ShakeVerifyMessageStorage", "getLastRecvShakeMsg fail, talker is null");
        } else {
            Cursor rawQuery = this.cie.rawQuery("select * from ShakeVerifyMessage where isSend = 0 and sayhiuser = '" + be.lZ(str) + "' order by createTime DESC limit " + i, null);
            int count = rawQuery.getCount();
            if (count > 0) {
                jVarArr = new j[count];
                for (int i2 = 0; i2 < count; i2++) {
                    rawQuery.moveToPosition(i2);
                    jVarArr[(count - i2) - 1] = new j();
                    jVarArr[(count - i2) - 1].b(rawQuery);
                }
            }
            rawQuery.close();
        }
        return jVarArr;
    }

    public final j[] kP(String str) {
        j[] jVarArr = null;
        v.d("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage");
        Cursor rawQuery = this.cie.rawQuery("select *, rowid from ShakeVerifyMessage  where sayhiuser = '" + be.lZ(str) + "' order by createtime DESC limit 3", null);
        int count = rawQuery.getCount();
        if (count <= 0) {
            v.i("MicroMsg.ShakeVerifyMessageStorage", "getLastShakeVerifyMessage, cursor count = 0");
            rawQuery.close();
        } else {
            jVarArr = new j[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                jVarArr[(count - i) - 1] = new j();
                jVarArr[(count - i) - 1].b(rawQuery);
            }
            rawQuery.close();
        }
        return jVarArr;
    }

    public static long kN(String str) {
        long j = 0;
        if (str != null) {
            j KA = l.KF().KA();
            if (KA != null) {
                j = KA.field_createtime + 1;
            }
        }
        long Nh = be.Nh();
        return j > Nh ? j : Nh;
    }
}
