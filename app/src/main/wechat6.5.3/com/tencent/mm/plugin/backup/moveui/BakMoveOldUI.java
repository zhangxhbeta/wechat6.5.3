package com.tencent.mm.plugin.backup.moveui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.plugin.backup.movemodel.b.b;
import com.tencent.mm.plugin.backup.movemodel.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.lang.reflect.Method;

public class BakMoveOldUI extends BakMoveBaseUI implements b, f, e {
    private boolean cvW = false;
    private boolean elX = false;
    private int progress = -2;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        com.tencent.mm.plugin.backup.g.b.UQ().elc = this;
        com.tencent.mm.plugin.backup.g.b.UQ().eld = this;
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            com.tencent.mm.plugin.backup.g.b.UQ().elk = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            v.d("MicroMsg.BakMoveOldUI", "old isWifiAp:%s", Boolean.valueOf(com.tencent.mm.plugin.backup.g.b.UQ().elk));
        } catch (Exception e) {
            v.e("MicroMsg.BakMoveOldUI", "no such method WifiManager.isWifiApEnabled:%s", new af());
        }
    }

    public final void NI() {
        vD(2131231343);
        this.elH.setVisibility(4);
        vD(2131231348);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveOldUI ema;

            {
                this.ema = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ema.Wt();
                return true;
            }
        });
    }

    public void onDestroy() {
        v.d("MicroMsg.BakMoveOldUI", " BakMoveOldUI onDestroy.");
        com.tencent.mm.plugin.backup.g.b.UQ().elc = null;
        com.tencent.mm.plugin.backup.g.b.UQ().eld = null;
        com.tencent.mm.plugin.backup.b.b.clear();
        super.onDestroy();
    }

    public final void onError(int i, String str) {
        v.d("MicroMsg.BakMoveOldUI", "onError errorType : " + i + " info : " + str);
        if (!this.cvW) {
            this.progress = -1;
            v.i("MicroMsg.BakMoveOldUI", "begin goto BakMoveErrUI");
            Intent intent = new Intent(aa.getContext(), BakMoveErrUI.class);
            intent.putExtra("err_type", i);
            intent.putExtra("err_info", str);
            intent.addFlags(335544320);
            aa.getContext().startActivity(intent);
            finish();
        }
    }

    public final void b(long j, long j2, int i) {
        CharSequence string;
        v.d("MicroMsg.BakMoveOldUI", "onNetProgress sucSize : " + j + " totalSize : " + j2 + " timeLeft : " + i);
        if (i < 60) {
            string = getString(2131231360);
        } else {
            string = getString(2131231359, new Object[]{Integer.valueOf((i / 60) + 1)});
        }
        this.elH.setText(string);
        if (j < 512000) {
            this.elH.setVisibility(4);
        } else {
            this.elH.setVisibility(0);
        }
        int i2 = (int) (j2 == 0 ? 0 : (100 * j) / j2);
        if (this.progress != i2) {
            if (this.progress > 0) {
                this.elH.setVisibility(0);
            }
            this.progress = i2;
            if (i <= 0) {
                this.elI.setText(g.aG(j) + "/" + g.aG(j2));
            } else {
                this.elI.setText(g.aG(j) + "/" + g.aG(j2) + "(" + g.aG((j2 - j) / ((long) i)) + "/s)");
            }
            this.elJ.setProgress(i2);
        }
    }

    public final void bn(int i, int i2) {
    }

    public final void UB() {
        v.d("MicroMsg.BakMoveOldUI", "begin to onNetFinish. ");
        this.cvW = true;
        this.elX = false;
        this.progress = -1;
        this.elH.setVisibility(0);
        this.elH.setText(2131231361);
        this.elJ.setVisibility(4);
        this.elI.setVisibility(4);
        this.elK.setText(2131231362);
    }

    public final void UC() {
    }

    public final void q(int i, long j) {
        this.elX = true;
        if (this.progress < i) {
            if (this.progress < 0) {
                this.elI.setVisibility(0);
            }
            this.progress = i;
            this.elI.setText(getString(2131231351, new Object[]{Integer.valueOf(this.progress), g.aG(j)}));
            this.elJ.setProgress(i);
        }
    }

    public final void Wh() {
        this.progress = -1;
        this.elI.setText(getString(2131231350));
    }

    public synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        if (i == 4) {
            Wt();
            z = true;
        } else {
            z = super.onKeyDown(i, keyEvent);
        }
        return z;
    }

    private void Wt() {
        if (!this.elX) {
            finish();
        }
        com.tencent.mm.ui.base.g.a((Context) this, 2131231256, 0, 2131231010, 2131231357, null, new OnClickListener(this) {
            final /* synthetic */ BakMoveOldUI ema;

            {
                this.ema = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.BakMoveOldUI", "try cancel");
                com.tencent.mm.plugin.backup.g.b.UQ().bl(false);
                this.ema.finish();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
    }
}
