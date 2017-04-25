package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.preference.HeadImgNewPreference;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalInfoUI extends MMPreference implements b {
    private int bBZ = -1;
    private f dxf;
    private boolean edL;

    public final int Oo() {
        return 2131099729;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.edL = getIntent().getBooleanExtra("KEnterFromBanner", false);
            a.drq.c(this);
        }
    }

    public void onDestroy() {
        v.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (ak.uz()) {
            ak.yW();
            c.vf().b(this);
        }
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235088);
        ak.yW();
        c.vf().a(this);
        this.dxf = this.ocZ;
        ((DialogPreference) this.dxf.Ow("settings_sex")).ock = new Preference.a(this) {
            final /* synthetic */ SettingsPersonalInfoUI iMz;

            {
                this.iMz = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    this.iMz.bBZ = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    this.iMz.bBZ = 2;
                }
                return false;
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPersonalInfoUI iMz;

            {
                this.iMz = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMz.axg();
                this.iMz.finish();
                return true;
            }
        });
    }

    public void onResume() {
        boolean z;
        boolean z2 = true;
        aNc();
        XP();
        ak.yW();
        String str = (String) c.vf().get(4, null);
        if (str != null && str.length() > 0) {
            this.dxf.Ow("settings_name").setSummary(e.a(this, str));
        }
        ak.yW();
        DialogPreference dialogPreference = (DialogPreference) this.dxf.Ow("settings_sex");
        switch (be.a((Integer) c.vf().get(12290, null), 0)) {
            case 1:
                dialogPreference.setValue("male");
                break;
            case 2:
                dialogPreference.setValue("female");
                break;
            default:
                dialogPreference.setValue("unknown");
                break;
        }
        bf zO = bf.zO();
        this.dxf.Ow("settings_district").setSummary(l.eu(be.ma(zO.getProvince())) + " " + be.ma(zO.getCity()));
        aNn();
        this.dxf.aO("settings_address", be.He());
        if ((k.xQ() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        String value = j.sU().getValue("LinkedinPluginClose");
        int i = (be.kS(value) || Integer.valueOf(value).intValue() == 0) ? true : 0;
        if (!z || i == 0) {
            this.dxf.aO("settings_linkedin", true);
        } else {
            Preference Ow = this.dxf.Ow("settings_linkedin");
            ak.yW();
            if (be.kS((String) c.vf().get(286721, null))) {
                z2 = false;
            }
            if (!z2) {
                Ow.setSummary(getString(2131235041));
            } else if ((k.xJ() & 4194304) == 0) {
                Ow.setSummary(getString(2131235042));
            } else {
                Ow.setSummary(getString(2131235043));
            }
        }
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        bf zO = bf.zO();
        if (this.bBZ != -1) {
            zO.bBZ = this.bBZ;
        }
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.j.a(1, bf.a(zO)));
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.d("MicroMsg.SettingsPersonalInfoUI", "key = " + str);
        String xF = k.xF();
        if (str.equals("settings_change_avatar")) {
            return a.drq.c(this);
        }
        if (str.equals("settings_username") && be.kS(k.xG()) && u.LL(xF)) {
            q(SettingsAliasUI.class);
            return true;
        } else if (str.equals("settings_name")) {
            r1 = new Intent();
            r1.setClass(this, SettingsModifyNameUI.class);
            startActivity(r1);
            return true;
        } else if (str.equals("settings_district")) {
            v.i("MicroMsg.SettingsPersonalInfoUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                return aNo();
            }
            return false;
        } else if (str.equals("settings_signature")) {
            this.nDR.nEl.startActivity(new Intent(this, EditSignatureUI.class));
            return true;
        } else {
            if (str.equals("settings_qrcode")) {
                g.iuh.h(11264, new Object[]{Integer.valueOf(2)});
                this.nDR.nEl.startActivity(new Intent(this, SelfQRCodeUI.class));
            } else if (str.equals("settings_address")) {
                Intent intent = new Intent();
                intent.putExtra("launch_from_webview", false);
                com.tencent.mm.ay.c.a(this.nDR.nEl, "address", ".ui.WalletSelectAddrUI", intent, true);
                return true;
            } else if (str.equals("settings_linkedin")) {
                r1 = new Intent();
                r1.putExtra("oversea_entry", true);
                com.tencent.mm.ay.c.b(this, "accountsync", "com.tencent.mm.ui.bindlinkedin.BindLinkedInUI", r1);
                return true;
            }
            return false;
        }
    }

    private void aNc() {
        Preference Ow = this.dxf.Ow("settings_username");
        CharSequence xG = k.xG();
        if (be.kS(xG)) {
            xG = k.xF();
            if (u.LL(xG)) {
                Ow.setSummary(getString(2131235086));
                return;
            } else {
                Ow.setSummary(xG);
                return;
            }
        }
        Ow.setSummary(xG);
    }

    private void XP() {
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.dxf.Ow("settings_change_avatar");
        String xF = k.xF();
        headImgNewPreference.lPB = null;
        if (headImgNewPreference.dQZ != null) {
            com.tencent.mm.pluginsdk.ui.a.b.m(headImgNewPreference.dQZ, xF);
        } else {
            headImgNewPreference.lPB = xF;
        }
        if (xF == null) {
            headImgNewPreference.lPC = false;
        } else {
            headImgNewPreference.lPC = true;
        }
        headImgNewPreference.lwQ = new OnClickListener(this) {
            final /* synthetic */ SettingsPersonalInfoUI iMz;

            {
                this.iMz = r1;
            }

            public final void onClick(View view) {
                this.iMz.nDR.nEl.startActivity(new Intent(this.iMz, PreviewHdHeadImg.class));
            }
        };
    }

    private void aNn() {
        Preference Ow = this.dxf.Ow("settings_signature");
        ak.yW();
        CharSequence ma = be.ma((String) c.vf().get(12291, null));
        if (ma.length() <= 0) {
            ma = getString(2131235144);
        }
        Ow.setSummary(e.a(this, ma));
    }

    private boolean aNo() {
        com.tencent.mm.plugin.setting.a.drp.b(new Intent(), this.nDR.nEl);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            String a;
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        n.AX();
                        intent2.putExtra("CropImage_OutputPath", d.s(k.xF() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        h hVar = com.tencent.mm.plugin.setting.a.drp;
                        ak.yW();
                        hVar.a(this, intent, intent2, c.wP(), 4, null);
                        return;
                    }
                    return;
                case 3:
                    Context applicationContext = getApplicationContext();
                    ak.yW();
                    a = com.tencent.mm.pluginsdk.ui.tools.l.a(applicationContext, intent, c.wP());
                    if (a != null) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("CropImageMode", 1);
                        intent3.putExtra("CropImage_OutputPath", a);
                        intent3.putExtra("CropImage_ImgPath", a);
                        com.tencent.mm.plugin.setting.a.drp.a(this, intent3, 4);
                        return;
                    }
                    return;
                case 4:
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ SettingsPersonalInfoUI iMz;

                        {
                            this.iMz = r1;
                        }

                        public final void run() {
                            pe peVar = new pe();
                            peVar.bqy.bqA = true;
                            com.tencent.mm.sdk.c.a.nhr.z(peVar);
                        }
                    });
                    if (intent != null) {
                        a = intent.getStringExtra("CropImage_OutputPath");
                        if (a == null) {
                            v.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                            return;
                        } else {
                            new com.tencent.mm.pluginsdk.model.n(this.nDR.nEl, a).a(1, new Runnable(this) {
                                final /* synthetic */ SettingsPersonalInfoUI iMz;

                                {
                                    this.iMz = r1;
                                }

                                public final void run() {
                                    v.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(ak.uz()), k.xF()});
                                    if (ak.uz()) {
                                        ai.cse.fG(com.tencent.mm.u.b.r(k.xF(), false));
                                    }
                                    this.iMz.XP();
                                    if (this.iMz.edL) {
                                        g.iuh.h(11002, new Object[]{Integer.valueOf(4), Integer.valueOf(4)});
                                    }
                                }
                            });
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3 || i == 2 || i == 4) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ SettingsPersonalInfoUI iMz;

                {
                    this.iMz = r1;
                }

                public final void run() {
                    pe peVar = new pe();
                    peVar.bqy.bqA = true;
                    com.tencent.mm.sdk.c.a.nhr.z(peVar);
                }
            });
        }
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        int n = be.n(obj, 0);
        v.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(n), jVar});
        ak.yW();
        if (jVar != c.vf() || n <= 0) {
            v.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", new Object[]{Integer.valueOf(n), jVar});
            return;
        }
        if (12291 == n) {
            aNn();
        }
        aNc();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.SettingsPersonalInfoUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aNo();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsPersonalInfoUI iMz;

                        {
                            this.iMz = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.iMz.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SettingsPersonalInfoUI iMz;

                        {
                            this.iMz = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
