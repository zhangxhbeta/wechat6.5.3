package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.o;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class NewTaskUI extends MMBaseActivity implements e {
    static NewTaskUI oUa;
    private ProgressDialog dwR = null;
    private SecurityImage nFq = null;
    private i oUb = new i();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.NewTaskUI", "onCreate :%d", Integer.valueOf(hashCode()));
        setContentView(2130903145);
        ak.vy().a(701, (e) this);
        oUa = this;
        final k sVar = new s(0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
        ak.vy().a(sVar, 0);
        getString(2131231164);
        this.dwR = g.a((Context) this, getString(2131233565), true, new OnCancelListener(this) {
            final /* synthetic */ NewTaskUI oUd;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(sVar);
            }
        });
    }

    public void onDestroy() {
        v.i("MicroMsg.NewTaskUI", "onDestroy :%d", Integer.valueOf(hashCode()));
        if (equals(oUa)) {
            oUa = null;
        }
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (this.nFq != null) {
            this.nFq.dismiss();
        }
        ak.vy().b(701, (e) this);
        super.onDestroy();
    }

    public static NewTaskUI bJr() {
        return oUa;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (i == 4 && i2 == -3) {
            v.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", Boolean.valueOf(ak.uz()));
            if (o.a(oUa, i, i2, new Intent().setClass(oUa, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (kVar instanceof s) {
                s sVar = (s) kVar;
                this.oUb.nJM = sVar.Ji();
                this.oUb.nJL = sVar.Fv();
                this.oUb.nJJ = sVar.Fw();
                this.oUb.nJK = sVar.Jj();
                v.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.oUb.nJJ + " img len" + this.oUb.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
            }
            if (this.nFq == null) {
                this.nFq = a.a(this, this.oUb.nJM, this.oUb.nJL, this.oUb.nJJ, this.oUb.nJK, new OnClickListener(this) {
                    final /* synthetic */ NewTaskUI oUd;

                    {
                        this.oUd = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + this.oUd.oUb.nJJ + " img len" + this.oUd.oUb.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
                        if (this.oUd.nFq == null) {
                            v.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
                            return;
                        }
                        final k sVar = new s(this.oUd.oUb.nJM, this.oUd.nFq.bBA(), this.oUd.nFq.nJJ, this.oUd.nFq.nJK);
                        ak.vy().a(sVar, 0);
                        NewTaskUI newTaskUI = this.oUd;
                        Context context = this.oUd;
                        this.oUd.getString(2131231164);
                        newTaskUI.dwR = g.a(context, this.oUd.getString(2131233565), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass2 oUe;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(sVar);
                            }
                        });
                    }
                }, new OnCancelListener(this) {
                    final /* synthetic */ NewTaskUI oUd;

                    {
                        this.oUd = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (NewTaskUI.oUa != null) {
                            NewTaskUI.oUa = null;
                            this.oUd.finish();
                        }
                    }
                }, new OnDismissListener(this) {
                    final /* synthetic */ NewTaskUI oUd;

                    {
                        this.oUd = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.oUd.nFq = null;
                    }
                }, this.oUb);
                return;
            }
            v.d("MicroMsg.NewTaskUI", "imgSid:" + this.oUb.nJJ + " img len" + this.oUb.nJL.length + " " + com.tencent.mm.compatible.util.g.sm());
            this.nFq.a(this.oUb.nJM, this.oUb.nJL, this.oUb.nJJ, this.oUb.nJK);
            return;
        }
        oUa = null;
        finish();
    }
}
