package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.freewifi.d.l;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;

public class FreeWifiPcUI extends MMActivity {
    private String appId;
    private String bax;
    private Button emR;
    private String fZF;
    private String gbE;
    private Button gby;
    private TextView gcw;
    private int gcx;
    private p gcy = null;

    static /* synthetic */ void a(FreeWifiPcUI freeWifiPcUI, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_error_ui_error_msg", str);
        intent.putExtra("free_wifi_error_ui_error_msg_detail1", str2);
        intent.setClass(freeWifiPcUI, FreeWifiErrorUI.class);
        freeWifiPcUI.finish();
        freeWifiPcUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232984);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiPcUI gcz;

            {
                this.gcz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gcz.goBack();
                return true;
            }
        });
        this.appId = getIntent().getStringExtra("free_wifi_appid");
        this.gcx = getIntent().getIntExtra("ConstantsFreeWifi.FREE_WIFI_PC_ENCRYPTED_SHOPID", 0);
        this.bax = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_PC_TICKET");
        this.fZF = getIntent().getStringExtra("free_wifi_app_nickname");
        this.gbE = getIntent().getStringExtra("free_wifi_privacy_url");
        this.gcw = (TextView) findViewById(2131757106);
        this.emR = (Button) findViewById(2131757107);
        this.gcw.setText("由" + this.fZF + "提供");
        this.emR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiPcUI gcz;

            {
                this.gcz = r1;
            }

            public final void onClick(View view) {
                this.gcz.emR.setClickable(false);
                final ah ahVar = new ah(new a(this) {
                    final /* synthetic */ AnonymousClass2 gcA;

                    {
                        this.gcA = r1;
                    }

                    public final boolean oU() {
                        this.gcA.gcz.gcy = g.a(this.gcA.gcz.nDR.nEl, this.gcA.gcz.getString(2131231988), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 gcB;

                            {
                                this.gcB = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        return true;
                    }
                }, false);
                ahVar.ea(2000);
                k.a aoy = k.aoy();
                aoy.fWY = String.valueOf(this.gcz.gcx);
                aoy.fWZ = this.gcz.appId;
                aoy.fXa = this.gcz.bax;
                aoy.fXc = b.SetPcLoginUserInfo.fXM;
                aoy.fXd = b.SetPcLoginUserInfo.name;
                aoy.aoA().aoz();
                v.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=It starts NetSceneSetPcLoginUserInfo.shopid=%d, appid=%s, ticket=%s", new Object[]{m.s(this.gcz.getIntent()), Integer.valueOf(m.t(this.gcz.getIntent())), Integer.valueOf(this.gcz.gcx), this.gcz.appId, this.gcz.bax});
                new l(this.gcz.appId, this.gcz.gcx, this.gcz.bax).b(new e(this) {
                    final /* synthetic */ AnonymousClass2 gcA;

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        ahVar.QI();
                        if (i == 0 && i2 == 0) {
                            this.gcA.gcz.finish();
                        } else if (!m.bG(i, i2) || m.ty(str)) {
                            FreeWifiPcUI.a(this.gcA.gcz, this.gcA.gcz.getString(2131232955), this.gcA.gcz.getString(2131232956));
                        } else {
                            FreeWifiPcUI.a(this.gcA.gcz, str + "(" + m.a(m.u(this.gcA.gcz.getIntent()), b.SetPcLoginUserInfoReturn, i2) + ")", "");
                        }
                        k.a aoy = k.aoy();
                        aoy.fWY = String.valueOf(this.gcA.gcz.gcx);
                        aoy.fWZ = this.gcA.gcz.appId;
                        aoy.fXa = this.gcA.gcz.bax;
                        aoy.fXc = b.SetPcLoginUserInfoReturn.fXM;
                        aoy.fXd = b.SetPcLoginUserInfoReturn.name;
                        aoy.bpc = i2;
                        aoy.aoA().aoz();
                        v.i("MicroMsg.FreeWifi.FreeWifiPcUI", "sessionKey=%s, step=%d, method=setOnClickListener, desc=NetSceneSetPcLoginUserInfo returns.shopid=%d, appid=%s, ticket=%s", new Object[]{m.s(this.gcA.gcz.getIntent()), Integer.valueOf(m.t(this.gcA.gcz.getIntent())), Integer.valueOf(this.gcA.gcz.gcx), this.gcA.gcz.appId, this.gcA.gcz.bax});
                    }
                });
            }
        });
        this.gby = (Button) findViewById(2131757108);
        this.gby.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiPcUI gcz;

            {
                this.gcz = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gcz.gbE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                c.b(this.gcz.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
    }

    protected final int NO() {
        return 1;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.freewifi.g.drp.i(new Intent(), this);
        finish();
    }

    protected final int getLayoutId() {
        return 2130903665;
    }
}
