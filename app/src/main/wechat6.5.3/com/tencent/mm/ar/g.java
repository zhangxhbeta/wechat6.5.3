package com.tencent.mm.ar;

import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class g extends f<f> {
    public static final String[] cic = new String[]{f.a(f.chq, "fmessage_msginfo")};
    private static final String[] ddR = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageTalkerIndex ON fmessage_msginfo ( talker )"};
    d cie;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public g(d dVar) {
        super(dVar, f.chq, "fmessage_msginfo", ddR);
        this.cie = dVar;
    }

    public final f[] kF(String str) {
        f[] fVarArr = null;
        v.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo");
        Cursor rawQuery = this.cie.rawQuery("select *, rowid from fmessage_msginfo  where talker = '" + be.lZ(str) + "' order by createTime DESC limit 3", null);
        int count = rawQuery.getCount();
        if (count <= 0) {
            v.i("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo, cursor count = 0");
            rawQuery.close();
        } else {
            fVarArr = new f[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                fVarArr[(count - i) - 1] = new f();
                fVarArr[(count - i) - 1].b(rawQuery);
            }
            rawQuery.close();
        }
        return fVarArr;
    }

    public final f kG(String str) {
        f fVar = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageMsgInfoStorage", "getLastFMsg fail, talker is null");
        } else {
            Cursor rawQuery = this.cie.rawQuery("select * from fmessage_msginfo where talker = '" + be.lZ(str) + "' order by createTime DESC limit 1", null);
            fVar = new f();
            if (rawQuery.getCount() != 0) {
                rawQuery.moveToFirst();
                fVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return fVar;
    }

    public final f kH(String str) {
        f[] B = B(str, 1);
        if (B != null) {
            return B[0];
        }
        return null;
    }

    public final f[] B(String str, int i) {
        f[] fVarArr = null;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageMsgInfoStorage", "getLastRecvFMsg fail, talker is null");
        } else {
            Cursor rawQuery = this.cie.rawQuery("select * from fmessage_msginfo where isSend != 1 and talker = '" + be.lZ(str) + "' order by createTime DESC limit " + i, null);
            int count = rawQuery.getCount();
            if (count > 0) {
                fVarArr = new f[count];
                for (int i2 = 0; i2 < count; i2++) {
                    rawQuery.moveToPosition(i2);
                    fVarArr[(count - i2) - 1] = new f();
                    fVarArr[(count - i2) - 1].b(rawQuery);
                }
            }
            rawQuery.close();
        }
        return fVarArr;
    }

    public final boolean a(f fVar) {
        if (fVar == null) {
            v.e("MicroMsg.FMessageMsgInfoStorage", "insert fail, fmsgInfo is null");
            return false;
        } else if (!super.b(fVar)) {
            return false;
        } else {
            Lf(fVar.nmb);
            return true;
        }
    }

    public final ArrayList<f> Kv() {
        v.d("MicroMsg.FMessageMsgInfoStorage", new StringBuilder("getFMsgByType, type = 0").toString());
        ArrayList<f> arrayList = new ArrayList();
        Cursor rawQuery = this.cie.rawQuery(new StringBuilder("select *, rowid from fmessage_msginfo where type = 0").toString(), null);
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                f fVar = new f();
                fVar.b(rawQuery);
                arrayList.add(fVar);
                rawQuery.moveToNext();
            }
        }
        rawQuery.close();
        v.d("MicroMsg.FMessageMsgInfoStorage", "getFMsgByType, size = " + arrayList.size());
        return arrayList;
    }
}
