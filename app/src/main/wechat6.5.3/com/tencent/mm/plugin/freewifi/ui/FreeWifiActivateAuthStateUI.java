package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.g.b;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

@Deprecated
public class FreeWifiActivateAuthStateUI extends FreeWifiActivateStateUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.bbT != 2) {
            d.a(this.ssid, 1, getIntent());
        }
        v.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now it is from qrcode, try to auth");
    }

    protected final void NI() {
        super.NI();
        this.gaV = (Button) findViewById(2131757099);
        this.gaV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiActivateAuthStateUI gaN;

            {
                this.gaN = r1;
            }

            public final void onClick(View view) {
                String string = this.gaN.getString(2131232961);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                c.b(this.gaN, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        vD(2131232984);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(State state) {
        v.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.tH(this.ssid)) {
            apT();
            apV();
        }
    }

    protected final void apN() {
        j.apo().a(this.ssid, new b(this) {
            final /* synthetic */ FreeWifiActivateAuthStateUI gaN;

            {
                this.gaN = r1;
            }

            public final void az(String str, int i) {
                v.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "get ap auth data : %s, url : %s, mac : %s", new Object[]{str, this.gaN.fZD, d.aoW()});
                if (!be.kS(str)) {
                    String str2 = str;
                    new a(this.gaN.fZD, this.gaN.ssid, r3, this.gaN.gaW, str2, "", i, m.s(this.gaN.getIntent())).b(new e(this) {
                        final /* synthetic */ AnonymousClass2 gaO;

                        {
                            this.gaO = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                            this.gaO.gaN.gaY = false;
                            if (i == 0 && i2 == 0) {
                                v.i("MicroMsg.FreeWifi.FreeWifiActivateAuthStateUI", "authUrl : %s", new Object[]{((a) kVar).apr()});
                                j.apo().a(this.gaO.gaN.ssid, r0, this.gaO.gaN.getIntent());
                            } else if (i2 == -2014) {
                                d.a(this.gaO.gaN.ssid, -2014, this.gaO.gaN.getIntent());
                            } else {
                                d.a(this.gaO.gaN.ssid, 3, this.gaO.gaN.getIntent());
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
