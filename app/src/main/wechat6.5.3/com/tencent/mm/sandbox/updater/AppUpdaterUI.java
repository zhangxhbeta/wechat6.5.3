package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI nfA = null;
    private Button emS;
    private h iji = null;
    private i nfB;
    private f nfC = new f(this) {
        final /* synthetic */ AppUpdaterUI nfE;

        {
            this.nfE = r1;
        }

        public final void bY(int i, int i2) {
            this.nfE.nfz.setText(this.nfE.getString(2131235718) + ((int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i))) + "%");
        }

        public final void bsl() {
            v.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (this.nfE.iji != null) {
                this.nfE.iji.dismiss();
            }
            if (!this.nfE.isFinishing()) {
                AppUpdaterUI.c(this.nfE);
            }
        }

        public final void bsm() {
            if (this.nfE.iji != null) {
                this.nfE.iji.dismiss();
            }
            if (!this.nfE.isFinishing()) {
                AppUpdaterUI.d(this.nfE);
            }
        }

        public final void aRx() {
            if (!this.nfE.isFinishing()) {
                this.nfE.nfz.setText(2131235718);
                this.nfE.nfz.setEnabled(false);
            }
        }

        public final void Bg(String str) {
            if (this.nfE.iji != null) {
                this.nfE.iji.dismiss();
            }
            if (!this.nfE.isFinishing()) {
                v.d("MicroMsg.AppUpdaterUI", str);
                if (str != null) {
                    AppUpdaterUI.a(this.nfE, str);
                    this.nfE.nfz.setEnabled(false);
                }
            }
        }

        public final void a(c cVar) {
            if (!this.nfE.isFinishing()) {
                if (cVar instanceof c) {
                    g.iuh.a(405, 67, 1, true);
                    v.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                    if (this.nfE.iji != null) {
                        this.nfE.iji.setMessage(this.nfE.getString(2131232933, new Object[]{this.nfE.nfB.desc, this.nfE.getString(2131235715), be.aw((long) this.nfE.nfB.size)}));
                    }
                    if (this.nfE.nfB.ngN) {
                        g.iuh.a(405, 68, 1, true);
                        AppUpdaterUI.a(this.nfE, cVar);
                        return;
                    }
                    return;
                }
                g.iuh.a(405, 69, 1, true);
                com.tencent.mm.ui.base.g.a(this.nfE, 2131235716, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 nfF;

                    {
                        this.nfF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        v.d("MicroMsg.AppUpdaterUI", "go to WebView");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.nfF.nfE.startActivity(intent);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 nfF;

                    {
                        this.nfF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    };
    private OnClickListener nfD = new OnClickListener(this) {
        final /* synthetic */ AppUpdaterUI nfE;

        {
            this.nfE = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppUpdaterUI.g(this.nfE);
        }
    };
    private OnClickListener nfw = new OnClickListener(this) {
        final /* synthetic */ AppUpdaterUI nfE;

        {
            this.nfE = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            v.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
            if (this.nfE.nfB.jHv == 1) {
                h.R(this.nfE, 6);
            }
            if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
                v.e("MicroMsg.AppUpdaterUI", "no sdcard.");
                this.nfE.iji.dismiss();
                AppUpdaterUI.c(this.nfE);
            } else if ((this.nfE.nfB.aPY & 1) != 0) {
                v.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
                Uri parse = Uri.parse(this.nfE.nfB.aQa);
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (parse == null || addFlags == null || !be.m(this.nfE, addFlags)) {
                    v.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                    this.nfE.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                } else {
                    v.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                    this.nfE.startActivity(addFlags);
                }
                this.nfE.bsk();
            } else {
                String yO = c.yO(this.nfE.nfB.aZy);
                v.d("MicroMsg.AppUpdaterUI", yO);
                if (yO != null) {
                    v.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                    h.Q(this.nfE, 8);
                    if (this.nfE.nfB.ngN) {
                        h.Q(this.nfE, 0);
                    } else {
                        h.Q(this.nfE, 9);
                    }
                    this.nfE.nfB.T(1, true);
                    this.nfE.nfC.Bg(yO);
                    return;
                }
                v.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", Integer.valueOf(this.nfE.nfB.jHv));
                v.d("MicroMsg.AppUpdaterUI", "current updateType : %s", Integer.valueOf(this.nfE.nfB.nfp));
                if (this.nfE.nfB.jHv == 0) {
                    this.nfE.nfB.bsA();
                } else if (this.nfE.nfB.jHv == 1) {
                    v.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                    this.nfE.bsk();
                    Intent intent = new Intent(this.nfE.getIntent());
                    intent.setClass(this.nfE, UpdaterService.class);
                    intent.putExtra("intent_extra_run_in_foreground", true);
                    this.nfE.startService(intent);
                } else {
                    v.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
                }
            }
        }
    };
    private Button nfz;

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final c cVar) {
        v.d("MicroMsg.AppUpdaterUI", "showDownloadFullPackAlert()");
        h a = com.tencent.mm.ui.base.g.a((Context) appUpdaterUI, appUpdaterUI.getString(2131232932, new Object[]{be.aw((long) appUpdaterUI.nfB.size)}), appUpdaterUI.getString(2131231164), new OnClickListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.d("MicroMsg.AppUpdaterUI", "click download button");
                h.Q(this.nfE, 11);
                if (cVar != null) {
                    cVar.deleteTempFile();
                }
                i e = this.nfE.nfB;
                e.ngP = true;
                e.bsA();
            }
        });
        a.setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            {
                this.nfE = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                v.d("MicroMsg.AppUpdaterUI", "click cancel button");
                h.Q(this.nfE, 12);
                AppUpdaterUI.i(this.nfE);
            }
        });
        a.setCanceledOnTouchOutside(false);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final String str) {
        g.iuh.a(405, 70, 1, true);
        new ac().postDelayed(new Runnable(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            public final void run() {
                this.nfE.startActivity(be.KA(str));
                this.nfE.bsk();
            }
        }, 300);
    }

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        v.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        g.iuh.a(405, 65, 1, true);
        com.tencent.mm.ui.base.g.a((Context) appUpdaterUI, appUpdaterUI.getString(2131235720), appUpdaterUI.getString(2131231164), new OnClickListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            {
                this.nfE = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppUpdaterUI.i(this.nfE);
            }
        }).setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            {
                this.nfE = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(this.nfE);
            }
        });
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        v.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        g.iuh.a(405, 66, 1, true);
        com.tencent.mm.ui.base.g.a((Context) appUpdaterUI, appUpdaterUI.getString(2131235723), appUpdaterUI.getString(2131231164), new OnClickListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            {
                this.nfE = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppUpdaterUI.i(this.nfE);
            }
        }).setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI nfE;

            {
                this.nfE = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(this.nfE);
            }
        });
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        v.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.nfB.ngR) {
            com.tencent.mm.ui.base.g.b(appUpdaterUI, 2131231566, 2131231164, new OnClickListener(appUpdaterUI) {
                final /* synthetic */ AppUpdaterUI nfE;

                {
                    this.nfE = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    v.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (this.nfE.iji != null && this.nfE.iji.isShowing()) {
                        this.nfE.iji.dismiss();
                    }
                    h.Q(this.nfE, 6);
                    this.nfE.nfB.cancel();
                    this.nfE.nfB.T(2, true);
                    this.nfE.bsk();
                }
            }, new OnClickListener(appUpdaterUI) {
                final /* synthetic */ AppUpdaterUI nfE;

                {
                    this.nfE = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.nfE.iji != null && !this.nfE.iji.isShowing()) {
                        this.nfE.iji.show();
                    }
                }
            });
            return;
        }
        if (appUpdaterUI.nfB.jHv == 1) {
            h.R(appUpdaterUI, 7);
        }
        h.Q(appUpdaterUI, 6);
        appUpdaterUI.nfB.T(2, true);
        appUpdaterUI.bsk();
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        appUpdaterUI.nfB.cancel();
        appUpdaterUI.nfB.T(2, true);
        appUpdaterUI.bsk();
    }

    public static AppUpdaterUI bsi() {
        return nfA;
    }

    public static void bsj() {
        if (nfA != null) {
            nfA.bsk();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.e(hashCode(), this);
        MMActivity.ed(this);
        if (AppInstallerUI.bsh() != null && !AppInstallerUI.bsh().isFinishing()) {
            v.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
        } else if (nfA == null || nfA.isFinishing() || nfA == this) {
            nfA = this;
            setContentView(2130903518);
            this.nfB = a.ngY;
            if (!this.nfB.S(getIntent())) {
                v.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                bsk();
            } else if (this.nfB.nfp != TbsLog.TBSLOG_CODE_SDK_INIT || this.nfB.nfS == null || this.nfB.nfS.length <= 0) {
                String string;
                v.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.nfB.nfS);
                a aVar = new a(this);
                aVar.wm(2131232931);
                aVar.jk(true);
                aVar.c(new OnCancelListener(this) {
                    final /* synthetic */ AppUpdaterUI nfE;

                    {
                        this.nfE = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppUpdaterUI.g(this.nfE);
                    }
                });
                if (this.nfB.ngN) {
                    string = getString(2131232933, new Object[]{this.nfB.desc, getString(2131235719), be.aw((long) this.nfB.ngM.size)});
                } else {
                    v.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(2131232933, new Object[]{this.nfB.desc, getString(2131235715), be.aw((long) this.nfB.size)});
                }
                int i = this.nfB.nfp != 1 ? 2131235711 : 2131235714;
                aVar.Oq(string);
                aVar.wp(2131235722).a(false, this.nfw);
                aVar.wq(i);
                this.iji = aVar.RX();
                this.iji.setCanceledOnTouchOutside(false);
                this.nfz = this.iji.getButton(-1);
                this.emS = this.iji.getButton(-2);
                this.iji.show();
                if (this.nfB.jHv == 1) {
                    h.R(this, 5);
                }
                i iVar = this.nfB;
                f fVar = this.nfC;
                if (fVar != null && !iVar.ngI.contains(fVar)) {
                    iVar.ngI.add(fVar);
                }
            } else {
                v.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ AppUpdaterUI nfE;

                    {
                        this.nfE = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.g.a(this.nfE, this.nfE.nfB.desc, this.nfE.getString(2131231164), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass7 nfG;

                            {
                                this.nfG = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.nfG.nfE.nfB.nfS[0]));
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                aa.getContext().startActivity(intent);
                                this.nfG.nfE.bsk();
                            }
                        }).setOnCancelListener(new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass7 nfG;

                            {
                                this.nfG = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.nfG.nfE.bsk();
                            }
                        });
                    }
                }, 100);
            }
        } else {
            v.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            v.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
        }
    }

    protected void onDestroy() {
        v.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.f(hashCode(), this);
        if (this.nfB != null) {
            i iVar = this.nfB;
            iVar.ngI.remove(this.nfC);
        }
        if (nfA == this) {
            nfA = null;
        }
        super.onDestroy();
    }

    private void bsk() {
        if (this.iji != null && this.iji.isShowing()) {
            this.iji.dismiss();
        }
        finish();
    }
}
