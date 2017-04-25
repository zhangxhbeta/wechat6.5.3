package com.tencent.mm.plugin.backup.moveui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.j;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.d.o;
import com.tencent.mm.plugin.backup.movemodel.d;
import com.tencent.mm.plugin.backup.movemodel.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.lang.reflect.Method;

public class BakMoveNewUI extends BakMoveBaseUI implements f, e {
    private boolean cvW = false;
    private boolean elX = false;
    private boolean elY = false;
    private int progress = -1;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("testMode", false)) {
            String str = q.dqM;
            int i = q.dqN;
            b.a(com.tencent.mm.plugin.backup.g.b.UT());
            b.a(com.tencent.mm.plugin.backup.g.b.UP());
            b.setMode(2);
            com.tencent.mm.plugin.backup.g.b.UP().connect(str, i);
        }
        com.tencent.mm.plugin.backup.g.b.UT().elc = this;
        com.tencent.mm.a.e.e(new File(com.tencent.mm.plugin.backup.g.b.Vj()));
        NI();
        try {
            Method method = WifiManager.class.getMethod("isWifiApEnabled", new Class[0]);
            WifiManager wifiManager = (WifiManager) getSystemService("wifi");
            com.tencent.mm.plugin.backup.g.b.UT().elk = ((Boolean) method.invoke(wifiManager, new Object[0])).booleanValue();
            v.d("MicroMsg.BakMoveNewUI", "new isWifiAp:%s", Boolean.valueOf(com.tencent.mm.plugin.backup.g.b.UT().elk));
        } catch (Exception e) {
            v.e("MicroMsg.BakMoveNewUI", "no such method WifiManager.isWifiApEnabled:%s", new af());
        }
    }

    public final void NI() {
        boolean z = true;
        g.iuh.a(103, 8, 1, false);
        String stringExtra = getIntent().getStringExtra("WifiName");
        String stringExtra2 = getIntent().getStringExtra("ip");
        v.i("MicroMsg.BakMoveNewUI", "initView thisWifi:%s, oldWifi:%s, oldIp:%s", com.tencent.mm.plugin.backup.g.g.bw(this), stringExtra, stringExtra2);
        if (!q.dqL && (stringExtra == null || !stringExtra.equals(r3))) {
            Intent intent = new Intent(aa.getContext(), BakMoveErrUI.class);
            intent.putExtra("wifiNameDifferentErr", true);
            intent.putExtra("WifiName", stringExtra);
            intent.addFlags(335544320);
            aa.getContext().startActivity(intent);
            finish();
        } else if (q.dqL || com.tencent.mm.plugin.backup.g.g.pf(stringExtra2)) {
            vD(2131231356);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ BakMoveNewUI elZ;

                {
                    this.elZ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.elZ.Wt();
                    return true;
                }
            });
            if (com.tencent.mm.plugin.backup.g.g.VA() < 30) {
                r1 = new Intent(aa.getContext(), BakMoveErrUI.class);
                r1.putExtra("battery_not_enough", true);
                r1.addFlags(335544320);
                aa.getContext().startActivity(r1);
                finish();
                return;
            }
            e UT = com.tencent.mm.plugin.backup.g.b.UT();
            v.i("MicroMsg.MoveRecoverServer", "makeAuth");
            UT.elb = false;
            UT.beE = 0;
            UT.recvSize = 0;
            UT.ebM = 0;
            UT.ebN = 0;
            UT.cAv = false;
            UT.ebT = true;
            UT.ebP = 0;
            UT.ebU.clear();
            b.a(1, UT);
            try {
                if (be.getInt(j.sU().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                    z = false;
                }
                UT.elj = z;
            } catch (Throwable e) {
                v.a("MicroMsg.MoveRecoverServer", e, "getInt", new Object[0]);
            }
            a jVar = new com.tencent.mm.plugin.backup.movemodel.j(com.tencent.mm.plugin.backup.g.b.Va(), com.tencent.mm.plugin.backup.g.b.Vb(), com.tencent.mm.plugin.backup.g.b.UV(), com.tencent.mm.plugin.backup.g.b.UZ());
            if (UT.elj) {
                o oVar = jVar.edT;
                oVar.efn |= d.ekW;
            }
            jVar.Uh();
            com.tencent.mm.plugin.backup.g.b.UT().eln = stringExtra2;
        } else {
            r1 = new Intent(aa.getContext(), BakMoveErrUI.class);
            r1.putExtra("complexWIFIErr", true);
            r1.addFlags(335544320);
            aa.getContext().startActivity(r1);
            finish();
        }
    }

    public void onDestroy() {
        com.tencent.mm.plugin.backup.g.b.UT().elc = null;
        com.tencent.mm.plugin.backup.g.b.UP().stop();
        b.clear();
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.BakMoveNewUI", "onSceneEnd type:%d, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    public final void onError(int i, String str) {
        if (this.cvW || this.elY) {
            v.i("MicroMsg.BakMoveNewUI", "onError isMergeing drop");
            return;
        }
        this.progress = -1;
        Intent intent = new Intent(aa.getContext(), BakMoveErrUI.class);
        intent.putExtra("err_type", i);
        intent.putExtra("err_info", str);
        intent.addFlags(335544320);
        aa.getContext().startActivity(intent);
        finish();
    }

    public final void b(long j, long j2, int i) {
        CharSequence string;
        this.elX = true;
        if (this.progress < 0) {
            this.elK.setText(2131231349);
            this.elI.setVisibility(0);
            this.elJ.setVisibility(0);
        }
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
        if (this.progress < i2) {
            if (this.progress > 0) {
                this.elH.setVisibility(0);
            }
            this.progress = i2;
            if (i <= 0) {
                this.elI.setText(com.tencent.mm.plugin.backup.g.g.aG(j) + "/" + com.tencent.mm.plugin.backup.g.g.aG(j2));
            } else {
                this.elI.setText(com.tencent.mm.plugin.backup.g.g.aG(j) + "/" + com.tencent.mm.plugin.backup.g.g.aG(j2) + "(" + com.tencent.mm.plugin.backup.g.g.aG((j2 - j) / ((long) i)) + "/s)");
            }
            this.elJ.setProgress(i2);
        }
    }

    public final void bn(int i, int i2) {
        this.elH.setText(2131231354);
        int i3 = (int) (i == 0 ? 0 : (((long) i) * 100) / ((long) i2));
        this.elI.setText(getString(2131231353, new Object[]{Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2)}));
        if (this.progress < i3) {
            this.progress = i3;
            this.elJ.setProgress(i3);
        }
    }

    public final void UB() {
        this.progress = -1;
        this.elK.setText(2131231355);
        this.elY = true;
    }

    public final void UC() {
        this.elX = false;
        this.elY = false;
        this.cvW = true;
        this.progress = -1;
        this.elH.setVisibility(0);
        this.elH.setText(getString(2131231352));
        this.elI.setVisibility(4);
        this.elJ.setVisibility(4);
        this.elK.setVisibility(4);
        this.elL.setVisibility(0);
        this.elL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveNewUI elZ;

            {
                this.elZ = r1;
            }

            public final void onClick(View view) {
                this.elZ.finish();
            }
        });
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
        com.tencent.mm.ui.base.g.a((Context) this, 2131231256, 0, 2131231010, 2131231357, null, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ BakMoveNewUI elZ;

            {
                this.elZ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.BakMoveNewUI", "try cancel");
                com.tencent.mm.plugin.backup.g.b.UT().il(30050107);
                com.tencent.mm.plugin.backup.g.b.UT().Wq();
                this.elZ.finish();
            }
        });
    }
}
