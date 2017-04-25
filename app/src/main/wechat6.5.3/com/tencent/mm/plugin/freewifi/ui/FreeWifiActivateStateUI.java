package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public abstract class FreeWifiActivateStateUI extends MMActivity implements a, b {
    protected int aPW;
    private int baO = 1;
    protected int bbT;
    protected String fZD;
    private FreeWifiStateView gaR;
    private TextView gaS;
    private TextView gaT;
    private Button gaU;
    protected Button gaV;
    protected String gaW;
    protected FreeWifiNetworkReceiver gaX;
    protected boolean gaY = false;
    private boolean gaZ = false;
    private ah gba = new ah(new ah.a(this) {
        final /* synthetic */ FreeWifiActivateStateUI gbd;

        {
            this.gbd = r1;
        }

        public final boolean oU() {
            if (!be.kS(this.gbd.ssid)) {
                this.gbd.baO = this.gbd.apP();
                v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.gbd.ssid, Integer.valueOf(this.gbd.baO)});
                this.gbd.gbb.QI();
                if (this.gbd.baO != 2) {
                    this.gbd.apT();
                    this.gbd.apR();
                    d.a(this.gbd.ssid, 3, this.gbd.getIntent());
                }
            }
            return false;
        }
    }, false);
    private ah gbb = new ah(new ah.a(this) {
        final /* synthetic */ FreeWifiActivateStateUI gbd;

        {
            this.gbd = r1;
        }

        public final boolean oU() {
            if (!d.tH(this.gbd.ssid)) {
                return true;
            }
            this.gbd.a(State.CONNECTED);
            this.gbd.gbb.QI();
            return false;
        }
    }, true);
    private g.a gbc = new g.a(this) {
        final /* synthetic */ FreeWifiActivateStateUI gbd;

        {
            this.gbd = r1;
        }

        public final void a(String str, i iVar) {
            this.gbd.baO = this.gbd.apP();
            this.gbd.ku(this.gbd.baO);
        }
    };
    protected String ssid;

    protected abstract void apN();

    protected abstract void apO();

    protected abstract int apP();

    static /* synthetic */ void d(FreeWifiActivateStateUI freeWifiActivateStateUI) {
        if (freeWifiActivateStateUI.gaX == null) {
            freeWifiActivateStateUI.apU();
        }
        freeWifiActivateStateUI.gaX.fYU = freeWifiActivateStateUI;
        d.aoV();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r9);
        r0 = r8.getIntent();
        r3 = "free_wifi_ssid";
        r0 = r0.getStringExtra(r3);
        r8.ssid = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_mid";
        r0 = r0.getStringExtra(r3);
        r8.gaW = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_url";
        r0 = r0.getStringExtra(r3);
        r8.fZD = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_source";
        r0 = r0.getIntExtra(r3, r1);
        r8.bbT = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_channel_id";
        r0 = r0.getIntExtra(r3, r2);
        r8.aPW = r0;
        r0 = r8.bbT;
        switch(r0) {
            case 1: goto L_0x00a3;
            case 2: goto L_0x006b;
            case 3: goto L_0x00a3;
            case 4: goto L_0x00a3;
            case 5: goto L_0x00a3;
            default: goto L_0x004d;
        };
    L_0x004d:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x0101;
    L_0x0055:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x005e:
        r8.NI();
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r1 = r8.gbc;
        r0.c(r1);
        return;
    L_0x006b:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r0 = r0.apL();
        if (r0 == 0) goto L_0x0099;
    L_0x0075:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.gaW = r3;
        r0 = r0.field_url;
        r8.fZD = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.gaW;
        r4[r1] = r5;
        r5 = r8.fZD;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        goto L_0x004d;
    L_0x0099:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        goto L_0x004d;
    L_0x00a3:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x00b5;
    L_0x00ab:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x005e;
    L_0x00b5:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r3 = r8.ssid;
        r0 = r0.tP(r3);
        if (r0 != 0) goto L_0x011e;
    L_0x00c1:
        r0 = new com.tencent.mm.plugin.freewifi.g.c;
        r0.<init>();
        r3 = r8.ssid;
        r3 = com.tencent.mm.sdk.platformtools.z.Kg(r3);
        r0.field_ssidmd5 = r3;
        r3 = r8.ssid;
        r0.field_ssid = r3;
        r0.field_connectState = r1;
        r3 = r0;
        r0 = r1;
    L_0x00d6:
        r4 = r8.fZD;
        r3.field_url = r4;
        r4 = r8.gaW;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        if (r0 == 0) goto L_0x00f6;
    L_0x00ed:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r0.b(r3);
        goto L_0x004d;
    L_0x00f6:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r4 = new java.lang.String[r2];
        r0.a(r3, r4);
        goto L_0x004d;
    L_0x0101:
        r0 = "MicroMsg.FreeWifi.FreeWifiActivateStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r2 = r8.gaW;
        r4[r1] = r2;
        r1 = r8.bbT;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        goto L_0x005e;
    L_0x011e:
        r3 = r0;
        r0 = r2;
        goto L_0x00d6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiActivateStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int NO() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
        if (!be.kS(this.ssid)) {
            apV();
        }
    }

    protected void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiActivateStateUI gbd;

            {
                this.gbd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gbd.goBack();
                return true;
            }
        });
        this.gaR = (FreeWifiStateView) findViewById(2131757110);
        this.gaS = (TextView) findViewById(2131757111);
        this.gaT = (TextView) findViewById(2131757112);
        if (this.bbT == 3) {
            this.gaT.setText(getString(2131233838, new Object[]{this.ssid}));
        } else {
            this.gaT.setText(getString(2131231989, new Object[]{this.ssid}));
        }
        this.gaU = (Button) findViewById(2131757113);
        this.gaU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiActivateStateUI gbd;

            {
                this.gbd = r1;
            }

            public final void onClick(View view) {
                if (this.gbd.apP() == 2) {
                    this.gbd.finish();
                    return;
                }
                d.a(this.gbd.ssid, 1, this.gbd.getIntent());
                this.gbd.gaY = false;
                this.gbd.apV();
            }
        });
        this.gaV = (Button) findViewById(2131757099);
        this.gaV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiActivateStateUI gbd;

            {
                this.gbd = r1;
            }

            public final void onClick(View view) {
                String string = this.gbd.getString(2131232961);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                c.b(this.gbd.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final void apR() {
        if (this.gaX != null) {
            v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister wifi state change receiver");
            this.gaX.fYU = null;
        }
    }

    protected final void apS() {
        if (this.gaX == null) {
            apU();
        }
        this.gaX.fYV = this;
    }

    protected final void apT() {
        if (this.gaX != null) {
            v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now unregister network changed receiver");
            this.gaX.fYV = null;
        }
    }

    private void apU() {
        this.gaX = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.gaX, intentFilter);
    }

    protected final void apV() {
        if (d.isWifiEnabled()) {
            this.baO = apP();
            v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now before connect, the connect state : %d", new Object[]{Integer.valueOf(this.baO)});
            if (this.baO != 2) {
                this.gba.ea(60000);
                this.gbb.ea(1000);
                if (d.tH(this.ssid)) {
                    v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "start auth now, isAuting : %b", new Object[]{Boolean.valueOf(this.gaY)});
                    if (this.gaY) {
                        v.d("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now it is authing");
                        return;
                    }
                    this.gba.ea(60000);
                    this.gbb.ea(1000);
                    apN();
                    this.gaY = true;
                    return;
                }
                j.apm().aoU().post(new Runnable(this) {
                    final /* synthetic */ FreeWifiActivateStateUI gbd;

                    {
                        this.gbd = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.gbd.ssid});
                        this.gbd.apO();
                    }
                });
                return;
            }
            ku(this.baO);
            return;
        }
        this.gba.ea(60000);
        this.gbb.ea(1000);
        v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "wifi is not enable, enable it");
        j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ FreeWifiActivateStateUI gbd;

            {
                this.gbd = r1;
            }

            public final void run() {
                FreeWifiActivateStateUI.d(this.gbd);
            }
        });
    }

    protected final void ku(int i) {
        this.gaR.setOnClickListener(null);
        v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -2014:
                this.gba.QI();
                this.gbb.QI();
                this.gaR.setImageResource(2130838262);
                this.gaR.setState(3);
                this.gaS.setText(2131232966);
                this.gaS.setVisibility(0);
                this.gaT.setText(2131232967);
                this.gaT.setVisibility(0);
                break;
            case 1:
                this.gaR.setImageResource(2130838263);
                this.gaR.setState(1);
                this.gaS.setText(2131231986);
                break;
            case 2:
                this.gaR.setImageResource(2130838261);
                this.gaR.setState(2);
                this.gaS.setText(2131231985);
                this.gaU.setVisibility(0);
                this.gaU.setText(2131232942);
                this.gba.QI();
                this.gbb.QI();
                if (this.bbT == 1 || this.bbT == 5 || this.bbT == 4) {
                    this.gaU.setVisibility(4);
                    final com.tencent.mm.plugin.freewifi.g.c tP = j.apj().tP(this.ssid);
                    if (!(tP == null || be.kS(tP.field_showUrl) || this.gaZ)) {
                        this.gaZ = true;
                        ad.g(new Runnable(this) {
                            final /* synthetic */ FreeWifiActivateStateUI gbd;

                            public final void run() {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", tP.field_showUrl + "&lang=" + u.d(this.gbd.getSharedPreferences(aa.bti(), 0)));
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("stastic_scene", 7);
                                c.b(this.gbd, "webview", ".ui.tools.WebViewUI", intent);
                                v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "jump to ad page after auth success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
                                this.gbd.finish();
                            }
                        }, 1000);
                    }
                }
                c.qq();
                return;
            case 3:
                this.gaR.setImageResource(2130838263);
                this.gaR.setState(3);
                this.gaR.fBq = 2;
                this.gaS.setText(2131231990);
                this.gaU.setVisibility(0);
                this.gaU.setText(2131232980);
                this.gba.QI();
                this.gbb.QI();
                return;
            default:
                this.gaR.setImageResource(2130838263);
                this.gaS.setText(2131231986);
                if (this.bbT != 3) {
                    this.gaT.setText(getString(2131231989, new Object[]{this.ssid}));
                    break;
                }
                this.gaT.setText(getString(2131233838, new Object[]{this.ssid}));
                break;
        }
        this.gaU.setVisibility(8);
    }

    protected final int getLayoutId() {
        return 2130903667;
    }

    protected void onDestroy() {
        super.onDestroy();
        j.apj().d(this.gbc);
        apR();
        apT();
        if (this.gaX != null) {
            unregisterReceiver(this.gaX);
        }
        this.gba.QI();
        this.gbb.QI();
        j.apm().release();
    }

    public final void kY(int i) {
        v.i("MicroMsg.FreeWifi.FreeWifiActivateStateUI", "now wifi state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 3:
                apR();
                apV();
                return;
            default:
                return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        finish();
        if (getIntent().getBooleanExtra("free_wifi_jump_to_main_ui", false)) {
            com.tencent.mm.plugin.freewifi.g.drp.i(new Intent(), this);
        }
    }
}
