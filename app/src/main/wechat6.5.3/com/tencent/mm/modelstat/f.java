package com.tencent.mm.modelstat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public final class f {
    private final String bmq;
    private a dcs = null;

    public static class a {
        public int aYp = 0;
        public int dct = 0;
        boolean dcu = false;
        public String extraInfo = SQLiteDatabase.KeyEmpty;
        public String ispName = SQLiteDatabase.KeyEmpty;
    }

    public f(String str) {
        this.bmq = str;
    }

    public final a Kb() {
        a aVar = null;
        if (this.dcs != null) {
            return this.dcs;
        }
        a aVar2;
        String str = this.bmq + "mobileinfo.ini";
        File file = new File(str);
        if (file.exists()) {
            com.tencent.mm.sdk.h.a aVar3 = new com.tencent.mm.sdk.h.a(str);
            aVar2 = new a();
            aVar2.dct = be.f(aVar3.Lc("ispCode"));
            aVar2.ispName = aVar3.getValue("ispName");
            aVar2.aYp = be.f(aVar3.Lc("subType"));
            aVar2.extraInfo = aVar3.getValue("extraInfo");
            long lastModified = file.lastModified();
            if (10011 == q.dqj && q.dqk > 0) {
                lastModified = be.Ni() - ((long) q.dqk);
                v.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig DK_TEST_MOBILEINFOFILE_MODTIME val:%d lm:%d", Integer.valueOf(q.dqk), Long.valueOf(lastModified));
                q.dqk = 0;
            }
            if (lastModified > 0 && be.ay(lastModified) > 259200000) {
                v.w("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig  diff:%d file:%s cache expired remove!", Long.valueOf(be.ay(lastModified)), str);
                aVar2.dcu = true;
            }
            v.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig MobileInfo subType:%d ispCode:%d ispName:%s extraInfo:%s expired:%b", Integer.valueOf(aVar2.aYp), Integer.valueOf(aVar2.dct), aVar2.ispName, aVar2.extraInfo, Boolean.valueOf(aVar2.dcu));
        } else {
            v.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readConfig file not exist :%s", str);
            aVar2 = null;
        }
        this.dcs = aVar2;
        if (this.dcs == null || this.dcs.dcu) {
            Context context = aa.getContext();
            if (context == null) {
                v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem MMApplicationContext is null");
            } else {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem ConnectivityManager is null");
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem getActiveNetworkInfo is null");
                    } else if (activeNetworkInfo.getType() == 1) {
                        v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem net type is wifi");
                    } else {
                        aVar = new a();
                        aVar.aYp = activeNetworkInfo.getSubtype();
                        aVar.dct = ak.getISPCode(context);
                        aVar.ispName = ak.getISPName(context);
                        aVar.extraInfo = activeNetworkInfo.getExtraInfo();
                        v.i("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem subType:%d ispCode:%d ispName:%s extraInfo:%s", Integer.valueOf(aVar.aYp), Integer.valueOf(aVar.dct), aVar.ispName, aVar.extraInfo);
                    }
                }
            }
            if (aVar == null) {
                v.v("MicroMsg.MobileInfoStorage ReportDataFlow", "readInfoBySystem failed , use old.");
                return this.dcs;
            }
            this.dcs = aVar;
            aVar2 = this.dcs;
            if (aVar2 == null) {
                v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig info is null");
            } else if (be.kS(str)) {
                v.e("MicroMsg.MobileInfoStorage ReportDataFlow", "saveConfig path is null");
            } else {
                com.tencent.mm.sdk.h.a aVar4 = new com.tencent.mm.sdk.h.a(str);
                aVar4.bH("ispCode", aVar2.dct);
                aVar4.dD("ispName", aVar2.ispName);
                aVar4.bH("subType", aVar2.aYp);
                aVar4.dD("extraInfo", aVar2.extraInfo);
            }
            return this.dcs;
        }
        v.v("MicroMsg.MobileInfoStorage ReportDataFlow", "checkInfo mobile info cache Read file succ.");
        return this.dcs;
    }
}
