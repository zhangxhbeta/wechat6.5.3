package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.platformtools.l;
import com.tencent.mm.plugin.a.b;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.e.a.c;
import com.tencent.mm.ui.e.a.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

public class FacebookLoginUI extends MMPreference implements e {
    private String bpX = SQLiteDatabase.KeyEmpty;
    private String ivg;
    private ProgressDialog nHO;
    private OnCancelListener nHP;
    private c nIr;
    private String nIs = SQLiteDatabase.KeyEmpty;
    private s nIt;
    private b nIu;
    boolean nIv = true;

    private final class a implements com.tencent.mm.ui.e.a.c.a {
        final /* synthetic */ FacebookLoginUI nIw;

        private a(FacebookLoginUI facebookLoginUI) {
            this.nIw = facebookLoginUI;
        }

        public final void k(Bundle bundle) {
            this.nIw.nHO = ProgressDialog.show(this.nIw, this.nIw.getString(2131231164), this.nIw.getString(2131232607), true);
            this.nIw.nHO.setOnCancelListener(this.nIw.nHP);
            this.nIw.nIs = this.nIw.nIr.oed;
            v.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", "facebook@wechat_auth", Integer.valueOf(this.nIw.nIs.length()), this.nIw.nIs.substring(0, 4));
            this.nIw.nIt = new s("facebook@wechat_auth", this.nIw.nIs, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0, SQLiteDatabase.KeyEmpty, true, false);
            ak.vy().a(this.nIw.nIt, 0);
            FacebookLoginUI.jd(true);
            b.mj(ak.uR() + "," + this.nIw.getClass().getName() + ",L14," + ak.dR("L14") + ",2");
        }

        public final void a(d dVar) {
            v.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + dVar.oNt);
            g.A(this.nIw, dVar.getMessage(), this.nIw.getString(2131232029));
            FacebookLoginUI.jd(false);
            b.mj(ak.uR() + "," + this.nIw.getClass().getName() + ",L14," + ak.dR("L14") + ",2");
        }

        public final void a(com.tencent.mm.ui.e.a.b bVar) {
            v.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
            g.A(this.nIw, bVar.getMessage(), this.nIw.getString(2131232029));
            FacebookLoginUI.jd(false);
            b.mj(ak.uR() + "," + this.nIw.getClass().getName() + ",L14," + ak.dR("L14") + ",2");
        }

        public final void onCancel() {
            v.d("MicroMsg.FacebookLoginUI", "onCancel");
            FacebookLoginUI.jd(false);
            b.mj(ak.uR() + "," + this.nIw.getClass().getName() + ",L14," + ak.dR("L14") + ",2");
        }
    }

    static /* synthetic */ void jd(boolean z) {
        int i = z ? 19 : 20;
        ak.yT().set(i, Integer.valueOf(be.a((Integer) ak.yT().get(i), 0) + 1));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131230720);
        com.tencent.mm.plugin.a.a.drq.oz();
        this.ivg = b.Oa();
        NI();
        ak.vy().a(701, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(701, (e) this);
    }

    protected void onResume() {
        super.onResume();
        b.b(true, ak.uR() + "," + getClass().getName() + ",L100_200_FB," + ak.dR("L100_200_FB") + ",1");
        b.mh("L100_200_FB");
    }

    public void onPause() {
        super.onPause();
        b.b(false, ak.uR() + "," + getClass().getName() + ",L100_200_FB," + ak.dR("L100_200_FB") + ",2");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        b.mi(this.ivg);
        finish();
    }

    private void bAO() {
        try {
            if (this.nIr != null) {
                this.nIr.eI(this);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.FacebookLoginUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        b.mj(ak.uR() + "," + getClass().getName() + ",L14," + ak.dR("L14") + ",1");
        this.nIr = new c("290293790992170");
        this.nIr.a((Activity) this, FacebookAuthUI.nIg, new a());
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", Integer.valueOf(kVar.hashCode()), Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.nHO != null) {
            this.nHO.dismiss();
            this.nHO = null;
        }
        if (be.bm((Context) this) && (kVar instanceof s)) {
            boolean z;
            this.bpX = ((s) kVar).Jh();
            if (kVar.getType() == 701 && i == 4 && (i2 == -16 || i2 == -17)) {
                ak.vy().a(new ay(new com.tencent.mm.model.ay.a(this) {
                    final /* synthetic */ FacebookLoginUI nIw;

                    {
                        this.nIw = r1;
                    }

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            com.tencent.mm.network.c BU = eVar.BU();
                            byte[] bArr = new byte[0];
                            ak.yW();
                            BU.i(bArr, com.tencent.mm.model.c.ww());
                        }
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                ak.unhold();
                l.lX(SQLiteDatabase.KeyEmpty);
                com.tencent.mm.modelsimple.d.aX(this);
                l.a(this, new Runnable(this) {
                    final /* synthetic */ FacebookLoginUI nIw;

                    {
                        this.nIw = r1;
                    }

                    public final void run() {
                        ak.yW();
                        Intent ak;
                        if ((be.a((Integer) com.tencent.mm.model.c.vf().get(65833, null), 0) > 0 ? 1 : 0) != 0) {
                            ak = com.tencent.mm.plugin.a.a.drp.ak(this.nIw);
                            ak.addFlags(67108864);
                            Intent intent = new Intent(this.nIw.nDR.nEl, BindMContactIntroUI.class);
                            intent.putExtra("key_upload_scene", 1);
                            MMWizardActivity.b(this.nIw, intent, ak);
                        } else {
                            ak = com.tencent.mm.plugin.a.a.drp.ak(this.nIw);
                            ak.addFlags(67108864);
                            this.nIw.startActivity(ak);
                            b.mj(ak.uR() + "," + this.nIw.getClass().getName() + ",L14," + ak.dR("L14") + ",4");
                        }
                        this.nIw.finish();
                    }
                }, false, 2);
            } else if (i2 == -106) {
                l.D(this, str);
            } else if (i2 == -217) {
                l.a(this, ((s) kVar).Jg(), i2);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.nIu == null) {
                    this.nIu = new b(this) {
                        final /* synthetic */ FacebookLoginUI nIw;

                        {
                            this.nIw = r1;
                        }

                        public final k a(k kVar, String str) {
                            return new s("facebook@wechat_auth", this.nIw.nIs, ((s) kVar).Ji(), str, ((s) kVar).Fw(), ((s) kVar).Jj(), 0, SQLiteDatabase.KeyEmpty, true, false);
                        }
                    };
                }
                SecurityImage.b bVar = this.nIu;
                byte[] Fv = ((s) kVar).Fv();
                bVar.nHH = kVar;
                if (bVar.nFq == null) {
                    bVar.nFq = com.tencent.mm.ui.applet.SecurityImage.a.a(this, 0, Fv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, new com.tencent.mm.ui.account.b.AnonymousClass1(bVar, this), null, new OnDismissListener(bVar) {
                        final /* synthetic */ b nHI;

                        {
                            this.nHI = r1;
                        }

                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.nHI.nFq = null;
                        }
                    }, bVar);
                } else {
                    bVar.nFq.a(0, Fv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                }
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            g.f(this.nDR.nEl, 2131232627, 2131231164);
                            z = true;
                            break;
                        case -75:
                            l.bl(this.nDR.nEl);
                            z = true;
                            break;
                        case -72:
                            g.f(this.nDR.nEl, 2131234451, 2131231164);
                            z = true;
                            break;
                        case -30:
                            if (com.tencent.mm.protocal.d.lWk) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.bpX);
                                intent.putExtra("showShare", false);
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("needRedirect", false);
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.lWt);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.lWq);
                                com.tencent.mm.plugin.a.a.drp.j(intent, (Context) this);
                            }
                            z = true;
                            break;
                        case -9:
                            g.f(this, 2131233556, 2131233557);
                            z = true;
                            break;
                        case -7:
                            g.f(this.nDR.nEl, 2131232626, 2131231164);
                            z = true;
                            break;
                        case -1:
                            if (ak.vy().BJ() == 5) {
                                g.f(this, 2131234021, 2131234020);
                                z = true;
                                break;
                            }
                        case -4:
                        case -3:
                            g.f(this, 2131232483, 2131233557);
                            z = true;
                            break;
                    }
                }
                z = com.tencent.mm.plugin.a.a.drq.a(this.nDR.nEl, i, i2, str);
                if (!z) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                        if (dm != null && dm.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(2131232858, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }

    protected final void NI() {
        this.nIr = new c("290293790992170");
        this.nHP = new OnCancelListener(this) {
            final /* synthetic */ FacebookLoginUI nIw;

            {
                this.nIw = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.nIw.nIt != null) {
                    ak.vy().c(this.nIw.nIt);
                }
            }
        };
        bAO();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FacebookLoginUI nIw;

            {
                this.nIw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nIw.goBack();
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        v.i(str, str2, objArr);
        if (i2 == -1 && i == 1024 && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(be.kS(stringExtra));
            if (!be.kS(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            v.i(str2, str3, objArr2);
            if (intExtra == -217) {
                bAO();
                return;
            }
        }
        this.nIr.d(i, i2, intent);
    }

    public final int Oo() {
        return 2131099694;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str == null) {
            v.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (!str.equals("facebook_auth_bind_btn")) {
            return false;
        } else {
            bAO();
            return true;
        }
    }
}
