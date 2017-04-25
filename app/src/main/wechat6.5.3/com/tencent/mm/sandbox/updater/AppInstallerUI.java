package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI nfv = null;
    private String aZy;
    private String desc;
    private h iji = null;
    private int jHv;
    private h nfu = null;
    private OnClickListener nfw = new OnClickListener(this) {
        final /* synthetic */ AppInstallerUI nfx;

        {
            this.nfx = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            v.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
            if (this.nfx.jHv == 2) {
                h.R(this.nfx, 3);
            }
            String yO = c.yO(this.nfx.aZy);
            v.d("MicroMsg.AppInstallerUI", yO);
            if (yO != null) {
                a.ngY.T(1, true);
                g.iuh.a(405, 72, 1, true);
                new ac().postDelayed(new Runnable(this.nfx, yO) {
                    final /* synthetic */ AppInstallerUI nfx;

                    public final void run() {
                        this.nfx.startActivity(be.KA(r5));
                        this.nfx.finish();
                    }
                }, 300);
                return;
            }
            g.iuh.a(405, 73, 1, true);
            v.e("MicroMsg.AppInstallerUI", "pack not found!");
            com.tencent.mm.ui.base.g.bf(this.nfx, this.nfx.getString(2131235713));
            h.bsz();
            this.nfx.finish();
        }
    };

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        v.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.iji != null && appInstallerUI.iji.isShowing()) {
            appInstallerUI.iji.dismiss();
        }
        if (appInstallerUI.nfu == null || !appInstallerUI.nfu.isShowing()) {
            appInstallerUI.nfu = com.tencent.mm.ui.base.g.a((Context) appInstallerUI, 2131231567, 2131231164, 2131231568, 2131232232, false, new OnClickListener(appInstallerUI) {
                final /* synthetic */ AppInstallerUI nfx;

                {
                    this.nfx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
                    if (this.nfx.iji != null && this.nfx.iji.isShowing()) {
                        this.nfx.iji.dismiss();
                    }
                    a.ngY.T(2, true);
                    if (this.nfx.jHv == 2) {
                        h.R(this.nfx, 4);
                    }
                    g.iuh.a(405, 74, 1, true);
                    h.bsu();
                    this.nfx.finish();
                }
            }, new OnClickListener(appInstallerUI) {
                final /* synthetic */ AppInstallerUI nfx;

                {
                    this.nfx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.iuh.a(405, 75, 1, true);
                    if (this.nfx.iji != null && !this.nfx.iji.isShowing()) {
                        this.nfx.iji.show();
                    }
                }
            });
            return;
        }
        v.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
    }

    public static AppInstallerUI bsh() {
        return nfv;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.AppInstallerUI", "onCreate");
        com.tencent.mm.sandbox.c.e(hashCode(), this);
        MMActivity.ed(this);
        if (AppUpdaterUI.bsi() != null && !AppUpdaterUI.bsi().isFinishing()) {
            v.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
        } else if (nfv == null || nfv.isFinishing() || nfv == this) {
            nfv = this;
            this.aZy = h.Nd();
            if (be.kS(this.aZy) || c.yO(this.aZy) == null) {
                finish();
                return;
            }
            this.desc = h.bsr();
            this.jHv = h.bss();
            setContentView(2130903518);
            a aVar = new a(this);
            aVar.wm(2131232931);
            aVar.jk(true);
            aVar.c(new OnCancelListener(this) {
                final /* synthetic */ AppInstallerUI nfx;

                {
                    this.nfx = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppInstallerUI.a(this.nfx);
                }
            });
            aVar.Oq(getString(2131232934, new Object[]{this.desc}));
            aVar.wp(2131233297).a(false, this.nfw);
            aVar.wq(2131235711).b(null);
            this.iji = aVar.RX();
            this.iji.setCanceledOnTouchOutside(false);
            this.iji.show();
            g.iuh.a(405, 71, 1, true);
            if (this.jHv == 2) {
                h.e(this, 2, h.bst() + 1);
            }
        } else {
            v.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
        }
    }

    protected void onDestroy() {
        v.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.iji != null && this.iji.isShowing()) {
            this.iji.dismiss();
        }
        if (this.nfu != null && this.nfu.isShowing()) {
            this.nfu.dismiss();
        }
        if (nfv == this) {
            nfv = null;
        }
        com.tencent.mm.sandbox.c.f(hashCode(), this);
        super.onDestroy();
    }
}
