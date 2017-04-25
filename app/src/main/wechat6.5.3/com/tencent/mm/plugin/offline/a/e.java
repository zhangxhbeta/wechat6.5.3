package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends k implements j {
    private b cif;
    private com.tencent.mm.v.e cii;

    public abstract void a(int i, JSONObject jSONObject);

    public abstract int aed();

    public final void u(Map<String, String> map) {
        int zg;
        int i = 0;
        if (this.cif == null) {
            a aVar = new a();
            aVar.czn = new azm();
            aVar.czo = new azn();
            String uri = getUri();
            zg = zg();
            aVar.uri = uri;
            aVar.czm = zg;
            aVar.czp = 185;
            aVar.czq = 1000000185;
            this.cif = aVar.Bv();
        }
        azm com_tencent_mm_protocal_c_azm = (azm) this.cif.czk.czs;
        com_tencent_mm_protocal_c_azm.mDi = aed();
        com_tencent_mm_protocal_c_azm.mDj = 1;
        Object[] toArray = map.keySet().toArray();
        Arrays.sort(toArray);
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        for (Object obj : toArray) {
            Object obj2;
            uri = (String) map.get(obj2);
            if (!be.kS(uri)) {
                if (i2 != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj2);
                stringBuilder.append("=");
                stringBuilder.append(uri);
                i2 = 1;
            }
        }
        String signWith3Des = TenpayUtil.signWith3Des(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        zg = 0;
        while (i < toArray.length) {
            int i3;
            obj2 = toArray[i];
            uri = (String) map.get(obj2);
            if (be.kS(uri)) {
                i3 = zg;
            } else {
                if (zg != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(obj2);
                stringBuilder.append("=");
                stringBuilder.append(p.encode(uri));
                i3 = 1;
            }
            i++;
            zg = i3;
        }
        stringBuilder.append(zg != 0 ? "&" : "");
        stringBuilder.append("WCPaySign");
        stringBuilder.append("=");
        stringBuilder.append(signWith3Des);
        com_tencent_mm_protocal_c_azm.mDk = new are().ba(stringBuilder.toString().getBytes());
    }

    public final int getType() {
        return 385;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.v.e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aed() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        azn com_tencent_mm_protocal_c_azn = (azn) ((b) pVar).czl.czs;
        if (i2 != 0 || i3 != 0) {
            Map q = bf.q(str, "e");
            if (q != null) {
                v.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = (String) q.get(".e.Content");
            }
        } else if (com_tencent_mm_protocal_c_azn.mDm == 0) {
            try {
                JSONObject jSONObject = new JSONObject(m.b(com_tencent_mm_protocal_c_azn.mDl));
                int i4 = jSONObject.getInt("retcode");
                String str2 = com_tencent_mm_protocal_c_azn.mNg;
                if (be.kS(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i5 = com_tencent_mm_protocal_c_azn.mNf;
                if (i4 == 0 && i5 == 0) {
                    a(i4, jSONObject);
                } else {
                    v.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : " + i5);
                    if (i5 == 0) {
                        i3 = DownloadResult.CODE_UNDEFINED;
                    } else {
                        i3 = i5;
                    }
                    v.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : " + str2);
                    str = str2;
                    i2 = 1000;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneTenpayOfflineBase", e, "", new Object[0]);
                str = aa.getContext().getString(2131236155);
                i3 = 2;
                i2 = 1000;
            }
        } else {
            str = com_tencent_mm_protocal_c_azn.mDn;
            i3 = 2;
            i2 = 1000;
        }
        if (i2 != 0) {
            v.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aed() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        }
        this.cii.a(i2, i3, str, this);
        v.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + aed() + ", errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int zg() {
        return 385;
    }
}
