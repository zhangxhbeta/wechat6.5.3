package com.tencent.mm.ui.account.mobile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.e.a.go;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.mobile.MobileVerifyUI.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class h implements b, e {
    private String cZU = null;
    private String nKT = SQLiteDatabase.KeyEmpty;
    private int nKU = 2;
    private MobileVerifyUI nOt;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] nOw = new int[a.bBu().length];

        static {
            try {
                nOw[a.nPe - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                nOw[a.nPf - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                nOw[a.nPg - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.nOt = mobileVerifyUI;
        this.cZU = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.nKT = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.nKU = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean vX(int i) {
        com.tencent.mm.sdk.c.b gnVar;
        String str;
        String str2;
        final k vVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (AnonymousClass3.nOw[i - 1]) {
            case 1:
                gnVar = new gn();
                gnVar.bfZ.context = this.nOt;
                a.nhr.z(gnVar);
                str = gnVar.bga.bgb;
                gnVar = new go();
                a.nhr.z(gnVar);
                str2 = gnVar.bgc.bgd;
                ak.vy().a(132, (e) this);
                vVar = new v(this.nOt.bhT, 2, this.nOt.nNt.getText().toString().trim(), SQLiteDatabase.KeyEmpty, str, str2);
                ak.vy().a(vVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ h nOA;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(vVar);
                        ak.vy().b(132, this.nOA);
                    }
                });
                break;
            case 2:
                ak.vy().a(132, (e) this);
                ak.vy().a(new v(this.nOt.bhT, 1, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty), 0);
                break;
            case 3:
                gnVar = new gn();
                gnVar.bfZ.context = this.nOt;
                a.nhr.z(gnVar);
                str = gnVar.bga.bgb;
                gnVar = new go();
                a.nhr.z(gnVar);
                str2 = gnVar.bgc.bgd;
                ak.vy().a(132, (e) this);
                vVar = new v(this.nOt.bhT, 2, this.nOt.nNt.getText().toString().trim(), SQLiteDatabase.KeyEmpty, str, str2);
                ak.vy().a(vVar, 0);
                mobileVerifyUI = this.nOt;
                context = this.nOt;
                this.nOt.getString(2131231164);
                mobileVerifyUI.dwR = g.a(context, this.nOt.getString(2131231440), true, new OnCancelListener(this) {
                    final /* synthetic */ h nOA;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(vVar);
                        ak.vy().b(132, this.nOA);
                    }
                });
                break;
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int i3 = 0;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.nOt.dwR != null) {
            this.nOt.dwR.dismiss();
            this.nOt.dwR = null;
        }
        if (kVar.getType() == 132) {
            ak.vy().b(132, (e) this);
            if (((v) kVar).AG() == 2 && i == 0 && i2 == 0) {
                ak.unhold();
                if (com.tencent.mm.pluginsdk.a.cY(this.nOt).size() != 0) {
                    i3 = 1;
                }
                Intent ak;
                if (this.nKT == null || !this.nKT.contains("1") || r0 == 0) {
                    ak = com.tencent.mm.plugin.a.a.drp.ak(this.nOt);
                    ak.addFlags(67108864);
                    this.nOt.startActivity(ak);
                    this.nOt.nOU = 4;
                    this.nOt.finish();
                    return;
                }
                com.tencent.mm.plugin.a.b.mi("R300_300_QQ");
                ak = new Intent(this.nOt, FindMContactAddUI.class);
                ak.addFlags(67108864);
                ak.putExtra("regsetinfo_ticket", this.cZU);
                ak.putExtra("regsetinfo_NextStep", this.nKT);
                ak.putExtra("regsetinfo_NextStyle", this.nKU);
                ak.putExtra("login_type", 1);
                Intent ak2 = com.tencent.mm.plugin.a.a.drp.ak(this.nOt);
                ak2.addFlags(67108864);
                MMWizardActivity.b(this.nOt, ak, ak2);
                this.nOt.finish();
            }
        } else if (!this.nOt.k(i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.nOt, this.nOt.getString(2131231444, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
