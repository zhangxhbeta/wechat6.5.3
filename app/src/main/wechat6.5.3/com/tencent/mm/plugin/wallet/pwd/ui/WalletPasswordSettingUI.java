package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.bd;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet.a.k;
import com.tencent.mm.plugin.wallet.pwd.a.b;
import com.tencent.mm.plugin.wallet_core.b.l;
import com.tencent.mm.plugin.wallet_core.b.q;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.wallet_core.b.p;

@a(19)
public class WalletPasswordSettingUI extends MMPreference implements e {
    private boolean cNC;
    private f dxf;
    private ac handler = new ac(new ac.a(this) {
        final /* synthetic */ WalletPasswordSettingUI kKV;

        {
            this.kKV = r1;
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    g.a(this.kKV, false, this.kKV.getResources().getString(2131232830), "", this.kKV.getResources().getString(2131231107), this.kKV.getResources().getString(2131231010), new OnClickListener(this.kKV) {
                        final /* synthetic */ WalletPasswordSettingUI kKV;

                        {
                            this.kKV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final bd bdVar = new bd();
                            bdVar.bpT = new Runnable(this) {
                                final /* synthetic */ AnonymousClass3 kKW;

                                public final void run() {
                                    if (bdVar.aYI == null) {
                                        return;
                                    }
                                    if (bdVar.aYI.aYJ == 0) {
                                        this.kKW.kKV.hi(false);
                                        ak.vy().a(new l(null), 0);
                                        return;
                                    }
                                    WalletPasswordSettingUI.d(this.kKW.kKV);
                                    g.A(this.kKW.kKV, this.kKW.kKV.getResources().getString(2131232831), "");
                                }
                            };
                            com.tencent.mm.sdk.c.a.nhr.a(bdVar, this.kKV.getMainLooper());
                        }
                    }, new OnClickListener(this.kKV) {
                        final /* synthetic */ WalletPasswordSettingUI kKV;

                        {
                            this.kKV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            WalletPasswordSettingUI.d(this.kKV);
                        }
                    });
                    break;
                case 2:
                    WalletPasswordSettingUI.b(this.kKV);
                    break;
            }
            return false;
        }
    });
    CheckBoxPreference kKL;
    CheckBoxPreference kKM;
    private IconPreference kKN;
    private Preference kKO;
    private String kKP;
    private String kKQ;
    private String kKR;
    private u kKS;
    private boolean kKT = false;
    private int kKU = 0;

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        walletPasswordSettingUI.hi(false);
        final j.g gVar = j.a.lxX;
        g.a(walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(2131236321), "", walletPasswordSettingUI.getResources().getString(gVar.anw() ? 2131236320 : 2131231107), walletPasswordSettingUI.getString(2131231010), true, new OnClickListener(walletPasswordSettingUI) {
            final /* synthetic */ WalletPasswordSettingUI kKV;

            public final void onClick(DialogInterface dialogInterface, int i) {
                v.i("MicroMsg.mmui.MMPreference", "user click the button to set system fingerprint");
                gVar.bK(this.kKV);
            }
        }, new OnClickListener(walletPasswordSettingUI) {
            final /* synthetic */ WalletPasswordSettingUI kKV;

            {
                this.kKV = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void d(WalletPasswordSettingUI walletPasswordSettingUI) {
        boolean z = true;
        j.g gVar = j.a.lxX;
        k.beN();
        ab beO = k.beO();
        boolean isChecked = walletPasswordSettingUI.kKM.isChecked();
        boolean z2 = beO.bgx() && gVar.anm();
        if (isChecked != z2) {
            if (!(beO.bgx() && gVar.anm())) {
                z = false;
            }
            walletPasswordSettingUI.hi(z);
        }
    }

    public final int Oo() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(385, this);
        this.cNC = getIntent().getBooleanExtra("key_is_from_system", false);
        if (this.cNC) {
            v.i("MicroMsg.mmui.MMPreference", "hy: enter password setting from system setting");
            com.tencent.mm.pluginsdk.g.a.O(this);
        }
        NI();
        if (b.aZc()) {
            ak.vy().a(new b(), 0);
            this.kKT = true;
        } else {
            u uVar;
            ak.yW();
            this.kKQ = (String) c.vf().get(t.a.nsF, "");
            com.tencent.mm.plugin.wallet_core.c.g bfZ = com.tencent.mm.plugin.wallet_core.model.k.bfZ();
            if (!be.kS("wallet_open_auto_pay")) {
                Cursor rawQuery = bfZ.cie.rawQuery("select * from WalletPrefInfo where pref_key=?", new String[]{r2});
                if (rawQuery != null) {
                    if (rawQuery.getCount() == 0) {
                        rawQuery.close();
                    } else {
                        rawQuery.moveToFirst();
                        uVar = new u();
                        uVar.b(rawQuery);
                        rawQuery.close();
                        this.kKS = uVar;
                        if (this.kKS == null && this.kKS.field_is_show == 1 && !be.kS(this.kKS.field_pref_url)) {
                            v.i("MicroMsg.mmui.MMPreference", "deduct info from cache is not null");
                            this.kKP = this.kKS.field_pref_url;
                            cW(this.kKS.field_pref_title, this.kKS.field_pref_url);
                        } else if (this.kKS != null) {
                            v.i("MicroMsg.mmui.MMPreference", "deduct info from cache is null");
                        } else {
                            v.i("MicroMsg.mmui.MMPreference", "mOpenAutoPayPrefInfo.field_is_show = " + this.kKS.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + be.kS(this.kKS.field_pref_url));
                        }
                    }
                }
            }
            uVar = null;
            this.kKS = uVar;
            if (this.kKS == null) {
            }
            if (this.kKS != null) {
                v.i("MicroMsg.mmui.MMPreference", "mOpenAutoPayPrefInfo.field_is_show = " + this.kKS.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + be.kS(this.kKS.field_pref_url));
            } else {
                v.i("MicroMsg.mmui.MMPreference", "deduct info from cache is null");
            }
        }
        ak.yW();
        this.kKU = ((Integer) c.vf().get(t.a.nuf, Integer.valueOf(0))).intValue();
        ak.yW();
        this.kKR = (String) c.vf().get(t.a.nua, "");
        if (be.kS(this.kKR)) {
            q.a(true, null);
        } else {
            this.kKO.setTitle(this.kKR);
            q.a(false, null);
        }
        if (this.kKU == 0) {
            this.dxf.aO("wallet_delay_transfer_date", true);
        }
    }

    private void cW(String str, String str2) {
        this.kKN.setTitle(str);
        if (be.kS(str2)) {
            this.dxf.aO("wallet_open_auto_pay", true);
            v.e("MicroMsg.mmui.MMPreference", "deduct_url is null");
            return;
        }
        this.dxf.aO("wallet_open_auto_pay", false);
    }

    protected void onResume() {
        super.onResume();
        if (com.tencent.mm.pluginsdk.g.a.bmM()) {
            finish();
        } else {
            bfz();
        }
    }

    protected final void NI() {
        Fd(com.tencent.mm.model.k.xT() ? getString(2131236323) : getString(2131236322));
        com.tencent.mm.wallet_core.ui.e.i(this);
        this.dxf = this.ocZ;
        this.dxf.addPreferencesFromResource(bfw());
        this.kKN = (IconPreference) this.dxf.Ow("wallet_open_auto_pay");
        this.kKO = this.dxf.Ow("wallet_delay_transfer_date");
        ak.yW();
        if (!((Boolean) c.vf().get(t.a.nsw, Boolean.valueOf(false))).booleanValue()) {
            this.kKN.cc("new", 2130839356);
            this.kKN.wH(0);
            ak.yW();
            c.vf().a(t.a.nsw, Boolean.valueOf(true));
        }
        this.kKL = (CheckBoxPreference) this.dxf.Ow("wallet_open_gesture_password");
        this.kKM = (CheckBoxPreference) this.dxf.Ow("wallet_fingerprint_switch");
        bfz();
        this.dxf.aO("nfc_idpay", true);
        this.dxf.aO("wallet_open_auto_pay", true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletPasswordSettingUI kKV;

            {
                this.kKV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kKV.finish();
                return true;
            }
        });
    }

    public int bfw() {
        return 2131099744;
    }

    public void bfx() {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, null, null);
    }

    public void bfy() {
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, null, null);
    }

    private void hi(boolean z) {
        this.cnm.edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.kKM.ocf = z;
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if ("wallet_modify_password".equals(preference.dnU)) {
            bfx();
            com.tencent.mm.wallet_core.ui.e.yD(24);
            return true;
        } else if ("wallet_forget_password".equals(preference.dnU)) {
            bfy();
            com.tencent.mm.wallet_core.ui.e.yD(25);
            return true;
        } else if ("wallet_open_gesture_password".equals(preference.dnU)) {
            if (((CheckBoxPreference) preference).isChecked()) {
                com.tencent.mm.pluginsdk.g.a.P(this);
                return true;
            } else if (!com.tencent.mm.ay.c.EH("gesture")) {
                v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
                return true;
            } else if (com.tencent.mm.pluginsdk.g.a.ati()) {
                r1 = new Intent();
                r1.setAction("action.verify_pattern");
                r1.addFlags(131072);
                r1.putExtra("next_action", "next_action.switch_off_pattern");
                r1.setPackage(aa.getPackageName());
                com.tencent.mm.ay.c.b(this, "gesture", ".ui.GestureGuardLogicUI", r1);
                return true;
            } else {
                v.d("MicroMsg.GestureGuardManager", "try to enter close gesture password process while gesture password has been switched off.");
                return true;
            }
        } else if ("wallet_modify_gesture_password".equals(preference.dnU)) {
            if (!com.tencent.mm.ay.c.EH("gesture")) {
                v.d("MicroMsg.GestureGuardManager", "Plugin gesture is not installed.");
                return true;
            } else if (com.tencent.mm.pluginsdk.g.a.ati()) {
                r1 = new Intent();
                r1.setAction("action.verify_pattern");
                r1.addFlags(131072);
                r1.putExtra("next_action", "next_action.modify_pattern");
                r1.setPackage(aa.getPackageName());
                com.tencent.mm.ay.c.b(this, "gesture", ".ui.GestureGuardLogicUI", r1);
                return true;
            } else {
                v.d("MicroMsg.GestureGuardManager", "try to enter modify gesture password process while gesture password has been switched off.");
                return true;
            }
        } else if ("wallet_realname_verify".equals(preference.dnU)) {
            if (!com.tencent.mm.plugin.wallet_core.model.k.bga().bgv()) {
                v.i("MicroMsg.mmui.MMPreference", "go to RealNameVerifyProcess");
                Bundle bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
                return true;
            } else if (be.kS(this.kKQ)) {
                v.e("MicroMsg.mmui.MMPreference", "mRealnameUrl is null");
                return true;
            } else {
                v.i("MicroMsg.mmui.MMPreference", "jump to mRealnameUrl");
                r2 = new Intent();
                r2.putExtra("rawUrl", this.kKQ);
                r2.putExtra("showShare", false);
                com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", r2);
                return true;
            }
        } else if ("wallet_fingerprint_switch".equals(preference.dnU)) {
            ak.yW();
            c.vf().a(t.a.npY, Boolean.valueOf(true));
            if (this.kKM.isChecked()) {
                if (this.cNC) {
                    com.tencent.mm.pluginsdk.f.a.tr(2);
                } else {
                    com.tencent.mm.pluginsdk.f.a.tr(1);
                }
                j.g gVar = j.a.lxX;
                if (gVar == null || !gVar.ann()) {
                    this.handler.obtainMessage(2).sendToTarget();
                    return true;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putInt("open_scene", 1);
                com.tencent.mm.wallet_core.a.b(this, "FingerprintAuth", bundle2);
                return true;
            }
            this.handler.obtainMessage(1).sendToTarget();
            return true;
        } else {
            if ("wallet_open_auto_pay".equals(preference.dnU)) {
                if (be.kS(this.kKP)) {
                    v.e("MicroMsg.mmui.MMPreference", "mDeductUrl is null");
                } else {
                    v.i("MicroMsg.mmui.MMPreference", "mDeductUrl is not null,jump!");
                    r2 = new Intent();
                    r2.putExtra("rawUrl", this.kKP);
                    r2.putExtra("showShare", false);
                    com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", r2);
                    this.kKN.wH(8);
                    return true;
                }
            }
            if ("wallet_digitalcert".equals(preference.dnU)) {
                if (!this.kKT) {
                    ak.vy().a(new b(), 0);
                }
                com.tencent.mm.ay.c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
                return true;
            } else if (!"wallet_delay_transfer_date".equals(preference.dnU)) {
                return false;
            } else {
                startActivity(new Intent(this, WalletDelayTransferSettingUI.class));
                return true;
            }
        }
    }

    public void bfz() {
        boolean z;
        if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgs() || com.tencent.mm.plugin.wallet_core.model.k.bga().bgw()) {
            this.dxf.aO("wallet_modify_password", true);
            this.dxf.aO("wallet_forget_password", true);
            this.dxf.aO("wallet_fingerprint_switch", true);
            this.dxf.aO("wallet_open_gesture_password", true);
            this.dxf.aO("wallet_modify_gesture_password", true);
            this.dxf.aO("wallet_realname_verify", false);
            this.dxf.Ow("wallet_realname_verify").setSummary(2131236313);
        } else if (com.tencent.mm.plugin.wallet_core.model.k.bga().bgv()) {
            this.dxf.aO("wallet_modify_password", false);
            this.dxf.aO("wallet_forget_password", false);
            this.dxf.aO("wallet_fingerprint_switch", false);
            this.dxf.aO("wallet_open_gesture_password", false);
            this.dxf.aO("wallet_modify_gesture_password", false);
            this.dxf.aO("wallet_realname_verify", false);
            this.dxf.Ow("wallet_realname_verify").setSummary(2131236319);
        } else {
            v.e("MicroMsg.mmui.MMPreference", "unknow reg state");
        }
        p.bLj();
        ak.yW();
        if (((Integer) c.vf().get(t.a.ntp, Integer.valueOf(0))).intValue() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.dxf.aO("wallet_digitalcert", false);
            if (p.bLj().bLk()) {
                this.dxf.Ow("wallet_digitalcert").setSummary(2131236301);
            } else {
                this.dxf.Ow("wallet_digitalcert").setSummary(2131236302);
            }
        } else {
            this.dxf.aO("wallet_digitalcert", true);
        }
        if (!com.tencent.mm.ay.c.EH("fingerprint")) {
            v.e("MicroMsg.mmui.MMPreference", "plugin fingerprinthad not been installed");
            this.dxf.aO("wallet_fingerprint_switch", true);
        } else if (com.tencent.mm.plugin.wallet.b.a.bfA()) {
            v.i("MicroMsg.mmui.MMPreference", "isSupportFingeprint is true");
            k.beN();
            ab beO = k.beO();
            if (beO == null || !beO.bgx()) {
                this.kKM.ocf = false;
                this.kKM.odB = false;
            } else {
                this.kKM.ocf = true;
                this.kKM.odB = false;
            }
            this.kKM.setSummary(2131236307);
            this.dxf.aO("wallet_fingerprint_switch", false);
            ak.yW();
            c.vf().a(t.a.npW, Boolean.valueOf(true));
            ak.yW();
            c.vf().a(t.a.npX, Boolean.valueOf(true));
            ak.yW();
            Object obj = c.vf().get(t.a.npY, Boolean.valueOf(false));
            if (obj != null) {
                z = ((Boolean) obj).booleanValue();
            } else {
                z = false;
            }
            if (z) {
                this.kKM.sl(8);
            } else {
                this.kKM.bh(getString(2131231102), 2130839356);
                this.kKM.sl(0);
            }
        } else {
            this.dxf.aO("wallet_fingerprint_switch", true);
        }
        if (!com.tencent.mm.ay.c.EH("gesture")) {
            this.dxf.aO("wallet_open_gesture_password", true);
            this.dxf.aO("wallet_modify_gesture_password", true);
        } else if (this.kKL != null && this.dxf != null) {
            if (com.tencent.mm.pluginsdk.g.a.ati()) {
                this.kKL.ocf = true;
                this.kKL.odB = false;
                this.kKL.setSummary("");
                this.dxf.aO("wallet_modify_gesture_password", false);
            } else {
                this.kKL.ocf = false;
                this.kKL.odB = false;
                this.kKL.setSummary(2131236312);
                this.dxf.aO("wallet_modify_gesture_password", true);
            }
            ak.yW();
            long longValue = ((Long) c.vf().get(147457, null)).longValue();
            int i = 2131236165;
            if ((16 & longValue) != 0) {
                i = 2131236164;
            } else if ((longValue & 32) != 0) {
                i = 2131236163;
            }
            this.dxf.Ow("wallet_delay_transfer_date").setSummary(i);
            this.dxf.notifyDataSetChanged();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (i == 0 && i2 == 0) {
            if (kVar instanceof b) {
                bfz();
                b bVar = (b) kVar;
                v.i("MicroMsg.mmui.MMPreference", "isShowDeduct=" + bVar.kJX);
                this.kKQ = bVar.kKb;
                if (bVar.kJX == 1) {
                    this.kKP = bVar.kJY;
                    cW(be.ah(bVar.kKa, getString(2131236345)), bVar.kJY);
                    return;
                }
                this.dxf.aO("wallet_open_auto_pay", true);
            } else if (kVar instanceof q) {
                this.kKR = ((q) kVar).kLC;
                this.kKU = ((q) kVar).kLH;
                if (this.kKU == 0) {
                    this.dxf.aO("wallet_delay_transfer_date", true);
                    return;
                }
                if (be.kS(this.kKR)) {
                    v.i("MicroMsg.mmui.MMPreference", "use hardcode wording");
                } else {
                    this.kKO.setTitle(this.kKR);
                }
                this.dxf.aO("wallet_delay_transfer_date", false);
            }
        } else if (kVar instanceof q) {
            v.i("MicroMsg.mmui.MMPreference", "net error, use hardcode wording");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(385, this);
    }
}
