package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@Deprecated
public class FreewifiActivateWeChatNoAuthStateUI extends FreeWifiActivateNoAuthStateUI {
    private int bcb;
    private String gcX;
    private String gcY;

    protected final String apQ() {
        return getString(2131232984);
    }

    public final void a(State state) {
        v.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.tH(this.ssid) && this.gaY) {
            apT();
            this.gaY = false;
            this.gcX = d.aoW();
            this.gcY = d.aoY();
            this.bcb = d.aoX();
            v.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "now has connect the ap, check from server rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.bcb), this.gcX, this.gcY});
            new a(this.fZD, this.gcX, this.gcY, this.bcb, this.aPW, m.s(getIntent())).b(new e(this) {
                final /* synthetic */ FreewifiActivateWeChatNoAuthStateUI gcZ;

                {
                    this.gcZ = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(640, this);
                    v.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        v.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap ok");
                        d.a(this.gcZ.ssid, 2, this.gcZ.getIntent());
                        return;
                    }
                    v.e("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "check ap failed ： rssi is :  %d, mac : %s, ssid is : %s", new Object[]{Integer.valueOf(this.gcZ.bcb), this.gcZ.gcX, this.gcZ.gcY});
                    this.gcZ.ku(-2014);
                    d.tJ(this.gcZ.gcY);
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
        v.i("MicroMsg.FreeWifi.FreewifiActivateWeChatNoAuthStateUI", "get connect state = %d", new Object[]{Integer.valueOf(tG)});
        if (tG == 0) {
            return -2014;
        }
        return tG;
    }
}
