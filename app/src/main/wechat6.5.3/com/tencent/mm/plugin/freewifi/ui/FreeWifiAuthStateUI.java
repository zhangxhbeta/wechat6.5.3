package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@Deprecated
public class FreeWifiAuthStateUI extends FreeWifiStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        v.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void NI() {
        super.NI();
        vD(2131232984);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        v.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.tH(this.ssid)) {
            apT();
            apV();
        }
    }

    protected final void apN() {
        j.apo().a(this.ssid, new b(this) {
            final /* synthetic */ FreeWifiAuthStateUI gbf;

            {
                this.gbf = r1;
            }

            public final void az(String str, int i) {
                v.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.gbf.fZD, d.aoW()});
                if (!be.kS(str)) {
                    String str2 = str;
                    new a(this.gbf.fZD, this.gbf.ssid, r3, this.gbf.gaW, str2, "", i, m.s(this.gbf.getIntent())).b(new e(this) {
                        final /* synthetic */ AnonymousClass1 gbg;

                        {
                            this.gbg = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                            this.gbg.gbf.gaY = false;
                            if (i == 0 && i2 == 0) {
                                a aVar = (a) kVar;
                                v.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "authUrl : %s", new Object[]{aVar.apr()});
                                dq apx = aVar.apx();
                                if (apx != null) {
                                    v.i("MicroMsg.FreeWifi.FreeWifiAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf});
                                    this.gbg.gbf.bmJ = apx.mbH;
                                    this.gbg.gbf.fZF = apx.efy;
                                    this.gbg.gbf.gcD = apx.gln;
                                    this.gbg.gbf.gcE = apx.mex;
                                    this.gbg.gbf.gcF = apx.mey;
                                    this.gbg.gbf.bCj = apx.cHf;
                                    this.gbg.gbf.gcG = apx.mez;
                                }
                                j.apo().a(this.gbg.gbf.ssid, r0, this.gbg.gbf.getIntent());
                            } else if (i2 == -2014) {
                                d.a(this.gbg.gbf.ssid, -2014, this.gbg.gbf.getIntent());
                            } else {
                                d.a(this.gbg.gbf.ssid, 3, this.gbg.gbf.getIntent());
                            }
                        }
                    });
                }
            }
        }, this.aPW, getIntent());
    }

    protected final void apO() {
        apS();
        d.tI(this.ssid);
    }

    protected final int apP() {
        j.api();
        return d.tG(this.ssid);
    }
}
