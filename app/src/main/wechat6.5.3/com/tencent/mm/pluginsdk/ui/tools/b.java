package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class b {

    private static class a {
        List<String> kgD;

        private a() {
            this.kgD = new ArrayList();
        }

        final String bqO() {
            if (this.kgD == null || this.kgD.size() == 0) {
                return SQLiteDatabase.KeyEmpty;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (String append : this.kgD) {
                stringBuffer.append(append);
                stringBuffer.append(";");
            }
            return stringBuffer.toString();
        }

        final void yP(String str) {
            this.kgD = new ArrayList();
            if (str != null && str.length() != 0) {
                for (Object add : str.split(";")) {
                    this.kgD.add(add);
                }
            }
        }
    }

    public static boolean HS(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
            return false;
        }
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            v.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a();
        aVar.yP((String) vf.get(69121, null));
        if (!aVar.kgD.contains(str)) {
            aVar.kgD.add(str);
        }
        vf.set(69121, aVar.bqO());
        return true;
    }

    public static boolean HT(String str) {
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
            return false;
        }
        ak.yW();
        r vf = c.vf();
        if (vf == null) {
            v.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
            return false;
        }
        a aVar = new a();
        aVar.yP((String) vf.get(69121, null));
        if (aVar.kgD.contains(str)) {
            aVar.kgD.remove(str);
        }
        vf.set(69121, aVar.bqO());
        return true;
    }
}
