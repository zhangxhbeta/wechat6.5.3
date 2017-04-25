package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wallet_core.b.q;
import com.tencent.mm.protocal.c.ajd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class WalletDelayTransferSettingUI extends MMPreference implements e {
    private f dxf;
    private long iKb;
    private String ism;
    private Preference kKd;
    private Preference kKe;
    private Preference kKf;
    private Preference kKg;
    private String kKh;
    private int kKi = 0;
    private String mTitle;

    public void onCreate(Bundle bundle) {
        boolean a;
        super.onCreate(bundle);
        this.dxf = this.ocZ;
        this.dxf.addPreferencesFromResource(2131099743);
        ak.yW();
        this.iKb = ((Long) c.vf().get(147457, null)).longValue();
        NI();
        ak.vy().a(385, this);
        ak.yW();
        this.kKh = (String) c.vf().get(a.nub, "");
        ak.yW();
        this.mTitle = (String) c.vf().get(a.nua, "");
        ak.yW();
        this.ism = (String) c.vf().get(a.nud, "");
        ak.yW();
        this.kKi = ((Integer) c.vf().get(a.nue, Integer.valueOf(0))).intValue();
        if (be.kS(this.kKh) || be.kS(this.mTitle) || be.kS(this.ism)) {
            a = q.a(true, null);
        } else {
            this.kKg.setTitle(this.kKh);
            Fd(this.mTitle);
            bfr();
            a = q.a(false, null);
        }
        com.tencent.mm.wallet_core.ui.e.i(this);
        if (!a) {
            v.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            ak.vy().b(385, this);
        }
    }

    private void bfr() {
        if (this.kKi != 1 || be.kS(this.ism)) {
            this.nDR.bAi();
        } else {
            a(0, 2130839531, new OnMenuItemClickListener(this) {
                final /* synthetic */ WalletDelayTransferSettingUI kKj;

                {
                    this.kKj = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.wallet_core.ui.e.l(this.kKj.nDR.nEl, this.kKj.ism, false);
                    return false;
                }
            });
        }
    }

    protected final void NI() {
        this.kKd = this.dxf.Ow("wallet_transfer_realtime");
        this.kKe = this.dxf.Ow("wallet_transfer_2h");
        this.kKf = this.dxf.Ow("wallet_transfer_24h");
        this.kKg = this.dxf.Ow("wallet_transfer_title_tips");
        bfs();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletDelayTransferSettingUI kKj;

            {
                this.kKj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kKj.finish();
                return false;
            }
        });
    }

    protected void onDestroy() {
        int i = 1;
        super.onDestroy();
        v.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", new Object[]{Long.valueOf(this.iKb)});
        if (!op(16)) {
            i = op(32) ? 2 : 0;
        }
        ajd com_tencent_mm_protocal_c_ajd = new ajd();
        com_tencent_mm_protocal_c_ajd.itI = i;
        ak.yW();
        c.wG().b(new j.a(205, com_tencent_mm_protocal_c_ajd));
        ak.vy().b(385, this);
    }

    public final int Oo() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if ("wallet_transfer_realtime".equals(str)) {
            this.iKb &= -17;
            this.iKb &= -33;
        } else if ("wallet_transfer_2h".equals(str)) {
            this.iKb &= -33;
            this.iKb |= 16;
        } else if ("wallet_transfer_24h".equals(str)) {
            this.iKb &= -17;
            this.iKb |= 32;
        }
        bfs();
        ak.yW();
        c.vf().set(147457, Long.valueOf(this.iKb));
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof q) {
            if (i == 0 && i2 == 0) {
                this.kKh = ((q) kVar).kLD;
                this.mTitle = ((q) kVar).kLC;
                this.ism = ((q) kVar).kLF;
                this.kKi = ((q) kVar).kLG;
                if (be.kS(this.kKh)) {
                    v.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.kKg.setTitle(2131236166);
                } else {
                    this.kKg.setTitle(this.kKh);
                }
                if (be.kS(this.mTitle)) {
                    v.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    vD(2131236286);
                } else {
                    Fd(this.mTitle);
                }
                bfr();
            } else {
                v.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.kKg.setTitle(2131236166);
                vD(2131236286);
            }
            this.dxf.notifyDataSetChanged();
            return;
        }
        v.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
    }

    private boolean op(int i) {
        return (this.iKb & ((long) i)) != 0;
    }

    private void bfs() {
        if (op(16)) {
            this.kKd.setWidgetLayoutResource(2130904060);
            this.kKe.setWidgetLayoutResource(2130904059);
            this.kKf.setWidgetLayoutResource(2130904060);
        } else if (op(32)) {
            this.kKd.setWidgetLayoutResource(2130904060);
            this.kKe.setWidgetLayoutResource(2130904060);
            this.kKf.setWidgetLayoutResource(2130904059);
        } else {
            this.kKd.setWidgetLayoutResource(2130904059);
            this.kKe.setWidgetLayoutResource(2130904060);
            this.kKf.setWidgetLayoutResource(2130904060);
        }
    }
}
