package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ac extends v {
    private static final String[] lAP = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ac(List<String> list) {
        a aVar = new a();
        aVar.czn = new sf();
        aVar.czo = new sg();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        this.fut = aVar.Bv();
        sf sfVar = (sf) this.fut.czk.czs;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            for (String str : list) {
                if (!be.kS(str)) {
                    linkedList.add(m.lY(str));
                }
            }
        }
        sfVar.mwg = linkedList;
        sfVar.eet = linkedList.size();
    }

    public final int getType() {
        return 7;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((sg) this.fut.czl.czs).mwh;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    go goVar = (go) it.next();
                    if (goVar != null) {
                        a(g.aC(goVar.glj, false), goVar);
                    }
                }
                return;
            }
            return;
        }
        v.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, go goVar) {
        boolean z;
        int i = 0;
        if (fVar == null) {
            fVar = new f();
            fVar.field_appId = goVar.glj;
            z = true;
        } else {
            z = false;
        }
        v.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", goVar.glj, Integer.valueOf(goVar.gkH), Long.valueOf(goVar.mhy));
        v.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_status), Integer.valueOf(fVar.field_appInfoFlag));
        if (!fVar.bnl() || be.kS(fVar.field_appName)) {
            fVar.field_appName = goVar.gkB;
        }
        if (!fVar.bnl() || be.kS(fVar.field_appName_en)) {
            fVar.field_appName_en = goVar.mhk;
        }
        if (!fVar.bnl() || be.kS(fVar.field_appName_tw)) {
            fVar.field_appName_tw = goVar.mhm;
        }
        fVar.field_appDiscription = goVar.mdJ;
        fVar.field_appDiscription_en = goVar.mhl;
        fVar.field_appDiscription_tw = goVar.mhn;
        fVar.field_appWatermarkUrl = goVar.mhr;
        fVar.field_packageName = goVar.maX;
        fVar.field_signature = p.GE(goVar.mhs);
        v.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", goVar.mhs, fVar.field_signature);
        fVar.field_appType = goVar.mdQ;
        if (!be.kS(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            fVar.field_appType = "," + fVar.field_appType;
        }
        fVar.field_appInfoFlag = goVar.gkH;
        fVar.field_appVersion = goVar.mht;
        fVar.bD(goVar.mdS);
        fVar.field_appWatermarkUrl = goVar.mhr;
        if (!(be.kS(goVar.mhw) || be.kS(goVar.mhx))) {
            v.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", fVar.field_appName, goVar.mhw, goVar.mhx);
            fVar.bE(goVar.mhw);
            fVar.bH(goVar.mhx);
        }
        fVar.bI(goVar.maY);
        fVar.field_svrAppSupportContentType = goVar.mhy;
        if (goVar.mhu > fVar.bxp) {
            fVar.bxq = 1;
            fVar.bwK = true;
        }
        fVar.bxp = goVar.mhu;
        fVar.bwK = true;
        String str = goVar.maX;
        String str2 = goVar.maX;
        int i2 = (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? true : 0;
        if (i2 != 0) {
            v.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + goVar.maX + "appid: " + fVar.field_appId);
        }
        if (fVar.bnk()) {
            b.HT(fVar.field_appId);
        }
        i bnB = am.bnB();
        if (z) {
            fVar.field_status = i2 != 0 ? 3 : 4;
            fVar.field_modifyTime = System.currentTimeMillis();
            fVar.field_appIconUrl = goVar.mhp;
            if (fVar.field_appId != null) {
                while (i < lAP.length) {
                    if (fVar.field_appId.equals(lAP[i])) {
                        fVar.field_status = -1;
                        break;
                    }
                    i++;
                }
            }
            if (bnB.m(fVar)) {
                am.bnz().bz(fVar.field_appId, 1);
                am.bnz().bz(fVar.field_appId, 2);
                am.bnz().bz(fVar.field_appId, 3);
                am.bnz().bz(fVar.field_appId, 4);
                am.bnz().bz(fVar.field_appId, 5);
                return;
            }
            v.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            return;
        }
        fVar.field_status = i2 != 0 ? 3 : fVar.field_status;
        if (fVar.field_appId != null) {
            for (Object equals : lAP) {
                if (fVar.field_appId.equals(equals)) {
                    fVar.field_status = -1;
                    break;
                }
            }
        }
        z = (fVar == null || fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? true : (goVar == null || goVar.mhv == null || goVar.mhv.length() == 0) ? false : !fVar.field_appIconUrl.equals(goVar.mhp);
        if (z) {
            v.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", fVar.field_appIconUrl, goVar.mhp);
            fVar.field_appIconUrl = goVar.mhp;
            am.bnz().bz(fVar.field_appId, 1);
            am.bnz().bz(fVar.field_appId, 2);
            am.bnz().bz(fVar.field_appId, 3);
            am.bnz().bz(fVar.field_appId, 4);
            am.bnz().bz(fVar.field_appId, 5);
        }
        v.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + bnB.a(fVar, new String[0]) + ", appid = " + goVar.glj);
    }

    public final byte[] arW() {
        try {
            return ((com.tencent.mm.v.b.b) this.fut.Bx()).zf();
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ap(byte[] bArr) {
        if (bArr == null) {
            v.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            return;
        }
        try {
            this.fut.czl.y(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            v.a("MicroMsg.NetSceneGetAppInfoList", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
