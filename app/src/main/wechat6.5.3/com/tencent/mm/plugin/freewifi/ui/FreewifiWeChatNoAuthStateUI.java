package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@Deprecated
public class FreewifiWeChatNoAuthStateUI extends FreeWifiNoAuthStateUI {
    private int bcb;
    private String gcX;
    private String gcY;

    protected final String apQ() {
        return getString(2131232984);
    }

    public final void a(State state) {
        v.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.tH(this.ssid) && this.gaY) {
            apT();
            this.gaY = false;
            this.gcX = d.aoW();
            this.gcY = d.aoY();
            this.bcb = d.aoX();
            v.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.bcb), this.gcX, this.gcY});
            new a(this.fZD, this.gcX, this.gcY, this.bcb, this.aPW, m.s(getIntent())).b(new e(this) {
                final /* synthetic */ FreewifiWeChatNoAuthStateUI gda;

                {
                    this.gda = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(640, this);
                    v.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        v.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap ok");
                        dq apx = ((a) kVar).apx();
                        if (apx != null) {
                            v.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf});
                            this.gda.bmJ = apx.mbH;
                            this.gda.fZF = apx.efy;
                            this.gda.gcD = apx.gln;
                            this.gda.gcE = apx.mex;
                            this.gda.gcF = apx.mey;
                            this.gda.bCj = apx.cHf;
                            this.gda.gcG = apx.mez;
                        }
                        d.a(this.gda.ssid, 2, this.gda.getIntent());
                        return;
                    }
                    v.e("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.gda.bcb), this.gda.gcX, this.gda.gcY});
                    d.a(this.gda.ssid, -2014, this.gda.getIntent());
                    d.tJ(this.gda.gcY);
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int apP() {
        j.api();
        int tG = d.tG(this.ssid);
        v.i("MicroMsg.FreeWifi.FreewifiWeChatNoAuthStateUI", "get connect state = %d", new Object[]{Integer.valueOf(tG)});
        if (tG == 0) {
            return -2014;
        }
        return tG;
    }
}
