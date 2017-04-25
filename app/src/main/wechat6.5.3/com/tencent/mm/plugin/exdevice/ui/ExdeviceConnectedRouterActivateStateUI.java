package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.c.a.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.storage.table.ClientInfoTable;

public class ExdeviceConnectedRouterActivateStateUI extends MMActivity {
    private String aRh;
    private String aZN;
    private String appId;
    private final int fBj = 90000;
    private ExdeviceConnectedRouterStateView fBk;
    private TextView fBl;
    private TextView fBm;
    private b<a> fBn = new b<a>(this) {
        final /* synthetic */ ExdeviceConnectedRouterActivateStateUI fBo;

        {
            this.fBo = r1;
        }

        public final /* synthetic */ void c(final int i, final int i2, String str, k kVar) {
            try {
                v.d("MicroMsg.ConnectedRouterActivateStateUi", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (this.fBo.isFinishing()) {
                    v.i("MicroMsg.ConnectedRouterActivateStateUi", "ExdeviceConnectedRouter destroyed.");
                } else {
                    this.fBo.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 fBp;

                        public final void run() {
                            if (i2 == 0 && (i == 0 || i == 4)) {
                                this.fBp.fBo.ku(2);
                            } else if (i != 4) {
                                this.fBp.fBo.ku(4);
                            } else if (i2 == 90000) {
                                this.fBp.fBo.ku(3);
                            } else {
                                this.fBp.fBo.ku(5);
                            }
                        }
                    });
                }
            } catch (Exception e) {
                v.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
            }
        }
    };
    private String frt;
    private String ssid;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.ConnectedRouterActivateStateUi", "create activity");
        vD(2131232531);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceConnectedRouterActivateStateUI fBo;

            {
                this.fBo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fBo.akh();
                return true;
            }
        });
        this.fBk = (ExdeviceConnectedRouterStateView) findViewById(2131756800);
        this.fBl = (TextView) findViewById(2131756801);
        this.fBm = (TextView) findViewById(2131756802);
        try {
            Uri parse = Uri.parse(getIntent().getStringExtra("key_connected_router"));
            this.aRh = parse.getQueryParameter("deviceid");
            this.aZN = parse.getQueryParameter("devicetype");
            this.frt = parse.getQueryParameter(ClientInfoTable.TABLE_NAME);
            this.appId = parse.getQueryParameter("appid");
            if (be.kS(this.aRh) || be.kS(this.aZN) || be.kS(this.frt) || be.kS(this.appId)) {
                v.e("MicroMsg.ConnectedRouterActivateStateUi", "loss param %s", new Object[]{parse.toString()});
                finish();
            }
            this.ssid = parse.getQueryParameter("ssid");
            v.d("MicroMsg.ConnectedRouterActivateStateUi", "uri: %s, deviceid: %s, devicetype: %s, clientinfo: %s. ssid: %s", new Object[]{parse.toString(), this.aRh, this.aZN, this.frt, this.ssid});
            if (this.ssid == null) {
                this.ssid = "";
            }
        } catch (Exception e) {
            v.d("MicroMsg.ConnectedRouterActivateStateUi", e.toString());
        }
        ku(1);
        ak.vy().a(new a(this.aRh, this.aZN, this.frt, this.appId, this.fBn), 0);
    }

    protected final int NO() {
        return 1;
    }

    protected void onResume() {
        super.onResume();
    }

    protected final void ku(int i) {
        this.fBk.setOnClickListener(null);
        v.d("MicroMsg.ConnectedRouterActivateStateUi", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.fBk.setImageResource(2131165430);
                this.fBk.setState(1);
                this.fBl.setText(2131232525);
                return;
            case 2:
                this.fBk.setImageResource(2131165431);
                this.fBk.setState(2);
                this.fBl.setText(getString(2131232529, new Object[]{this.ssid}));
                a(0, getString(2131232524), new OnMenuItemClickListener(this) {
                    final /* synthetic */ ExdeviceConnectedRouterActivateStateUI fBo;

                    {
                        this.fBo = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.fBo.akh();
                        return true;
                    }
                });
                return;
            case 3:
                this.fBk.setImageResource(2131165429);
                this.fBk.setState(3);
                this.fBk.fBq = 2;
                this.fBl.setText(2131232526);
                this.fBm.setText(getString(2131232527, new Object[]{this.ssid}));
                return;
            case 4:
                this.fBk.setImageResource(2131165429);
                this.fBk.setState(3);
                this.fBk.fBq = 2;
                this.fBl.setText(2131232526);
                this.fBm.setText(getString(2131232528));
                return;
            case 5:
                this.fBk.setImageResource(2131165429);
                this.fBk.setState(3);
                this.fBk.fBq = 2;
                this.fBl.setText(2131232526);
                this.fBm.setText(getString(2131232530));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130903548;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        akh();
        return true;
    }

    private void akh() {
        finish();
        Intent intent = new Intent();
        intent.putExtra("From_fail_notify", true);
        v.d("MicroMsg.ConnectedRouterActivateStateUi", "startMainUI");
        c.a(this, "com.tencent.mm.ui.LauncherUI", intent);
    }
}
