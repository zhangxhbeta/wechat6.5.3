package com.tencent.mm.ar;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.d;
import java.util.ArrayList;

public final class a {
    public static ArrayList<String> kx(String str) {
        ArrayList<String> arrayList = new ArrayList();
        h[] C = l.KE().C(str, 10);
        if (C != null) {
            for (h hVar : C) {
                arrayList.add(hVar.field_sayhicontent);
            }
        }
        v.d("MicroMsg.ExposeDataLogic", "get lbs sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> ky(String str) {
        ArrayList<String> arrayList = new ArrayList();
        j[] D = l.KF().D(str, 10);
        if (D != null) {
            for (j jVar : D) {
                arrayList.add(jVar.field_sayhicontent);
            }
        }
        v.d("MicroMsg.ExposeDataLogic", "get shake sayhi msg content");
        return arrayList;
    }

    public static ArrayList<String> kz(String str) {
        ArrayList<String> arrayList = new ArrayList();
        ak.yW();
        Cursor MQ = c.wJ().MQ(str);
        if (!(MQ == null || MQ.getCount() == 0)) {
            if (MQ.moveToFirst()) {
                int i = 0;
                while (!MQ.isAfterLast()) {
                    at atVar = new at();
                    atVar.b(MQ);
                    MQ.moveToNext();
                    if (atVar.bwm()) {
                        arrayList.add(atVar.field_content);
                    } else {
                        arrayList.add("");
                    }
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
            }
            MQ.close();
        }
        return arrayList;
    }

    public static ArrayList<String> w(int i, String str) {
        ArrayList<String> arrayList = new ArrayList();
        f[] B = l.KC().B(str, 10);
        if (B != null) {
            for (f fVar : B) {
                if (fVar.field_type == 1) {
                    arrayList.add(be.ma(d.MB(fVar.field_msgContent).content));
                }
            }
        }
        v.d("MicroMsg.ExposeDataLogic", "getFMessageContent,scene:%d", new Object[]{Integer.valueOf(i)});
        return arrayList;
    }

    public static ArrayList<at> b(long[] jArr) {
        ArrayList<at> arrayList = new ArrayList();
        if (jArr != null) {
            for (long ek : jArr) {
                ak.yW();
                arrayList.add(c.wJ().ek(ek));
            }
        }
        return arrayList;
    }
}
