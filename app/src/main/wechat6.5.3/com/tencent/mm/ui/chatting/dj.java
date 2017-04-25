package com.tencent.mm.ui.chatting;

import com.tencent.mm.a.e;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.n;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class dj {
    public static String ez(long j) {
        String f = f(n.GH().ai(j));
        return f != null ? f : null;
    }

    public static String eA(long j) {
        String f = f(n.GH().ah(j));
        return f != null ? f : null;
    }

    private static String f(d dVar) {
        if (dVar != null) {
            String str;
            if (dVar.Gp()) {
                str = dVar.cLv;
                if (str != null && e.aR(str)) {
                    return str;
                }
            }
            str = n.GH().l(dVar.cLv, null, null);
            if (str != null && e.aR(str)) {
                return str;
            }
            str = n.GH().l(dVar.cLx, null, null);
            if (str != null && e.aR(str)) {
                return str;
            }
        }
        return null;
    }

    public static String a(at atVar, a aVar) {
        String str = SQLiteDatabase.KeyEmpty;
        if (!(aVar == null || be.kS(aVar.aXa))) {
            b Gu = am.Wf().Gu(aVar.aXa);
            if (Gu != null && Gu.bnj() && e.aR(Gu.field_fileFullPath)) {
                str = Gu.field_fileFullPath;
            }
        }
        if (be.kS(str)) {
            if (atVar != null) {
                str = n.GH().w(atVar.field_imgPath, true);
            }
            v.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", str);
        } else {
            v.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", str);
        }
        return str;
    }
}
