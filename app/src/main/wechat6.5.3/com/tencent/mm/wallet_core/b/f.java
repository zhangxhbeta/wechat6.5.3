package com.tencent.mm.wallet_core.b;

import com.tencent.mm.a.o;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.wallet_core.e.a.g;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f extends g {
    public boolean boF = true;
    private int piw = 0;
    private a pix = null;

    public interface a {
        void bhs();
    }

    private static void Z(Map<String, String> map) {
        ak.yW();
        String string = o.getString(c.ww());
        String deviceID = p.getDeviceID(aa.getContext());
        byte[] bArr = new byte[16];
        byte[] bytes = m.bLf().getBytes();
        int i = 0;
        int i2 = 0;
        do {
            bArr[i2] = bytes[i];
            i2++;
            i++;
            if (i >= bytes.length) {
                i = 0;
                continue;
            }
        } while (i2 < 16);
        String str = new String(bArr);
        String Kg = z.Kg(string + deviceID);
        String Kg2 = z.Kg(string + Kg + new String(bArr));
        v.i("MicroMsg.NetSceneGendigitalcert", "salt " + new String(bArr));
        v.i("MicroMsg.NetSceneGendigitalcert", "crt_csr uin: %s: devideid: %s crt: %s", new Object[]{string, deviceID, Kg2});
        String certApplyCSR = a.bKZ().getCertApplyCSR(Kg2);
        try {
            map.put("sn_salt", com.tencent.mm.compatible.util.p.encode(str));
            map.put("crt_csr", com.tencent.mm.compatible.util.p.encode(certApplyCSR));
            map.put("crt_device_id", Kg);
            map.put("device_os", d.cmW);
            map.put("device_name", d.lWd);
        } catch (Exception e) {
        }
    }

    public f(String str, int i, String str2) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.piw = 1;
        Z(hashMap);
        hashMap.put(Columns.TYPE, com.tencent.mm.compatible.util.p.encode("1"));
        hashMap.put("true_name", com.tencent.mm.compatible.util.p.encode(str2));
        hashMap.put("id_no", com.tencent.mm.compatible.util.p.encode(str));
        hashMap.put("id_type", com.tencent.mm.compatible.util.p.encode(String.valueOf(i)));
        u(hashMap);
        aa(hashMap2);
    }

    public f(String str, String str2, a aVar, boolean z) {
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        this.boF = z;
        this.piw = 2;
        Z(hashMap);
        hashMap.put(Columns.TYPE, com.tencent.mm.compatible.util.p.encode("2"));
        hashMap.put("crt_sms", com.tencent.mm.compatible.util.p.encode(str));
        hashMap.put("reqkey", com.tencent.mm.compatible.util.p.encode(str2));
        this.pix = aVar;
        u(hashMap);
        aa(hashMap2);
    }

    public final int aed() {
        return 1580;
    }

    public final int zg() {
        return 1580;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/gendigitalcert";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneGendigitalcert", "errCode %d errMsg %s", new Object[]{Integer.valueOf(i), str});
        try {
            String optString = jSONObject.optString("crt_crt");
            String optString2 = jSONObject.optString("crt_no");
            com.tencent.mm.plugin.report.service.g.iuh.a(414, 0, 1, true);
            boolean importCert = a.bKZ().importCert(optString2, optString);
            p.PO(optString2);
            if (importCert) {
                com.tencent.mm.plugin.report.service.g.iuh.a(414, 1, 1, true);
                v.i("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt success");
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.a(414, 2, 1, true);
                v.e("MicroMsg.NetSceneGendigitalcert", "importCert crt_crt fail");
            }
            if (this.piw == 1) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13731, new Object[]{Integer.valueOf(3)});
            } else if (this.piw == 2) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13731, new Object[]{Integer.valueOf(7)});
            }
            v.i("MicroMsg.NetSceneGendigitalcert", "_crt_crt %s _crt_no %s", new Object[]{z.Kg(optString), optString2});
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneGendigitalcert", e, "", new Object[0]);
        }
    }

    public final void a(c cVar) {
        a.bKZ().bLa();
        if (cVar.errCode != 0) {
            if (this.piw == 1) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13731, new Object[]{Integer.valueOf(4)});
            } else if (this.piw == 2) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13731, new Object[]{Integer.valueOf(8)});
            }
        }
        if (this.pix == null) {
            return;
        }
        if (!this.boF || cVar.errCode == 0) {
            this.pix.bhs();
        }
    }

    public final boolean aEQ() {
        return this.boF;
    }
}
