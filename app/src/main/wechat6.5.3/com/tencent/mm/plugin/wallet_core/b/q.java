package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.ak.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.wallet_core.c.f;
import com.tencent.mm.wallet_core.e.a.g;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class q extends g {
    private long dby;
    public String kLB;
    public String kLC;
    public String kLD;
    public String kLE;
    public String kLF;
    public int kLG;
    public int kLH;

    public q() {
        u(null);
    }

    public final int aed() {
        return 0;
    }

    public final int zg() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        v.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        v.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[]{jSONObject});
        this.kLB = jSONObject.optString("delay_confirm_wording");
        this.kLC = jSONObject.optString("delay_confirm_switch_wording");
        this.kLD = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.kLE = jSONObject.optString("delay_confirm_desc_url");
        this.kLG = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.dby = jSONObject.optLong("expire_time", 0) * 1000;
        this.kLH = jSONObject.optInt("delay_confirm_switch_flag", 0);
        ak.yW();
        r vf = c.vf();
        if (!be.kS(this.kLB)) {
            vf.a(a.ntZ, this.kLB);
        }
        if (!be.kS(this.kLC)) {
            vf.a(a.nua, this.kLC);
        }
        if (!be.kS(this.kLD)) {
            vf.a(a.nub, this.kLD);
        }
        if (!be.kS(this.kLE)) {
            try {
                this.kLF = URLDecoder.decode(this.kLE, "UTF-8");
                if (!be.kS(this.kLF)) {
                    vf.a(a.nud, this.kLF);
                }
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        vf.a(a.nue, Integer.valueOf(this.kLG));
        vf.a(a.nuc, Long.valueOf(this.dby));
        vf.a(a.nuf, Integer.valueOf(this.kLH));
        if (this.kLH == 0) {
            v.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            ajd com_tencent_mm_protocal_c_ajd = new ajd();
            com_tencent_mm_protocal_c_ajd.itI = 0;
            ak.yW();
            c.wG().b(new j.a(205, com_tencent_mm_protocal_c_ajd));
            vf.set(147457, Long.valueOf((((Long) vf.get(147457, null)).longValue() & -17) & -33));
        }
    }

    public static boolean a(boolean z, f fVar) {
        ak.yW();
        long longValue = ((Long) c.vf().get(a.nuc, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            v.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[]{Long.valueOf(longValue), Boolean.valueOf(z)});
            if (fVar != null) {
                fVar.a(new q(), false, true);
            } else {
                ak.vy().a(new q(), 0);
            }
            return true;
        }
        v.d("MicroMsg.NetSceneTransferWording", "not time");
        return false;
    }

    public final boolean aEQ() {
        return false;
    }
}
