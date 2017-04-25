package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.al;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class SetPwdUI extends MMActivity implements e {
    public String bax = null;
    private ProgressDialog dwR = null;
    public boolean iPt = true;
    private String nMs;
    private String nMt;
    public are nMu = null;

    protected enum a {
        ;

        public static int[] bBj() {
            return (int[]) nMB.clone();
        }

        static {
            nMx = 1;
            nMy = 2;
            nMz = 3;
            nMA = 4;
            nMB = new int[]{nMx, nMy, nMz, nMA};
        }
    }

    protected abstract String bAU();

    protected abstract String bAV();

    protected abstract boolean p(int i, int i2, String str);

    protected abstract void vU(int i);

    public void onCreate(Bundle bundle) {
        ak.vy().a(bAW(), (e) this);
        super.onCreate(bundle);
        this.bax = getIntent().getStringExtra("setpwd_ticket");
        byte[] KG = be.KG(al.zc().getString("_auth_key", SQLiteDatabase.KeyEmpty));
        dn dnVar = new dn();
        if (be.bl(KG)) {
            this.nMu = new are().ba(new byte[0]);
        } else {
            this.nMu = new are().ba(KG);
            try {
                dnVar.az(KG);
            } catch (Throwable e) {
                v.a("MicroMsg.SetPwdUI", e, "summersetpwd Failed parse autoauthkey buf", new Object[0]);
            }
        }
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ SetPwdUI nMv;

            {
                this.nMv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nMv.nMs = this.nMv.bAU();
                this.nMv.nMt = this.nMv.bAV();
                if (!be.kS(this.nMv.nMs)) {
                    if (!this.nMv.nMs.equals(this.nMv.nMt)) {
                        this.nMv.vU(a.nMx);
                    } else if (this.nMv.nMs.length() > 16) {
                        this.nMv.vU(a.nMy);
                    } else if (be.Ku(this.nMv.nMs)) {
                        g.f(this.nMv, 2131234409, 2131234430);
                    } else if (be.Kz(this.nMv.nMs)) {
                        this.nMv.axg();
                        if (be.kS(this.nMv.bax)) {
                            SetPwdUI setPwdUI = this.nMv;
                            ak.yW();
                            setPwdUI.bax = (String) c.vf().get(77830, null);
                        }
                        final k a = this.nMv.a(this.nMv.nMs, this.nMv.bax, this.nMv.nMu);
                        ak.vy().a(a, 0);
                        this.nMv.dwR = this.nMv.a(this.nMv, this.nMv.getString(2131231164), this.nMv.getString(2131234376), new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 nMw;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(a);
                            }
                        });
                        if (this.nMv.bAY() && !this.nMv.iPt) {
                            v.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 0");
                            com.tencent.mm.plugin.report.service.g.iuh.h(11868, Integer.valueOf(0));
                        }
                    } else if (this.nMv.nMs.length() < 8 || this.nMv.nMs.length() >= 16) {
                        this.nMv.vU(a.nMz);
                    } else {
                        this.nMv.vU(a.nMA);
                    }
                }
                return true;
            }
        }, b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SetPwdUI nMv;

            {
                this.nMv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.nMv.bAY() && this.nMv.iPt) {
                    v.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                    com.tencent.mm.plugin.report.service.g.iuh.h(11868, Integer.valueOf(1));
                }
                this.nMv.axg();
                this.nMv.setResult(0);
                this.nMv.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        ak.vy().b(bAW(), (e) this);
        super.onDestroy();
    }

    protected ProgressDialog a(Context context, String str, String str2, OnCancelListener onCancelListener) {
        return g.a(context, str2, true, onCancelListener);
    }

    protected int bAW() {
        return 383;
    }

    protected k a(String str, String str2, are com_tencent_mm_protocal_c_are) {
        return new ad(str, str2, com_tencent_mm_protocal_c_are);
    }

    public final void a(int i, int i2, String str, k kVar) {
        aua com_tencent_mm_protocal_c_aua = null;
        if (kVar.getType() == bAW()) {
            if (this.dwR != null) {
                this.dwR.dismiss();
                this.dwR = null;
            }
            if (kVar.getType() == 383 && i == 0 && i2 == 0) {
                Toast.makeText(this, getString(2131232928), 0).show();
                ad adVar = (ad) kVar;
                if (!(adVar.cif == null || adVar.cif.czl.czs == null)) {
                    com_tencent_mm_protocal_c_aua = (aua) adVar.cif.czl.czs;
                }
                if (!(com_tencent_mm_protocal_c_aua == null || com_tencent_mm_protocal_c_aua.mdV == null)) {
                    byte[] toByteArray = com_tencent_mm_protocal_c_aua.mdV.mQw.toByteArray();
                    Editor edit = aa.getContext().getSharedPreferences("auth_info_key_prefs", 4).edit();
                    edit.putBoolean("key_auth_info_prefs_created", true);
                    edit.putInt("key_auth_update_version", d.lWh);
                    edit.putString("_auth_key", be.bn(toByteArray));
                    ak.yW();
                    edit.putInt("_auth_uin", c.ww());
                    edit.commit();
                }
                setResult(-1);
            }
            if (!p(i, i2, str)) {
                Toast.makeText(this, getString(2131232927, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }

    protected final boolean k(int i, int i2, String str) {
        if (com.tencent.mm.plugin.a.a.drq.a(this.nDR.nEl, i, i2, str)) {
            return true;
        }
        return false;
    }

    public boolean bAY() {
        return false;
    }

    public void onBackPressed() {
        if (this.iPt) {
            if (bAY()) {
                v.d("MicroMsg.SetPwdUI", "cpan settpassword cancel 11868 1");
                com.tencent.mm.plugin.report.service.g.iuh.h(11868, Integer.valueOf(1));
            }
            super.onBackPressed();
        }
    }
}
