package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.nfc.NfcAdapter;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a implements ag {
    private com.tencent.mm.plugin.nfc_open.b.a hIh;

    private static a aDV() {
        a aVar = (a) ak.yP().fY("plugin.nfc_open");
        if (aVar != null) {
            return aVar;
        }
        v.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
        aVar = new a();
        ak.yP().a("plugin.nfc_open", aVar);
        return aVar;
    }

    public final HashMap<Integer, c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }

    public final void aG(boolean z) {
        int i = 1800;
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new b();
        }
        boolean z2;
        if (aDV().hIh == null) {
            aDV().hIh = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        com.tencent.mm.plugin.nfc_open.b.a aVar = aDV().hIh;
        if (NfcAdapter.getDefaultAdapter(aa.getContext()) == null) {
            v.i("MicroMsg.CpuCardConfigManager", "Nfc not support no need update");
        } else if (aVar.hIj != null) {
            int i2 = aVar.hIj.mow;
            if (i2 >= 1800) {
                i = i2 > 604800 ? 604800 : i2;
            }
            v.i("MicroMsg.CpuCardConfigManager", "now=" + be.Nh() + ", lastUpdateTime=" + aVar.hIj.lastUpdateTime + ", updateFreq=" + i + ", configUpdateFreq=" + aVar.hIj.mow);
            if (be.Nh() - aVar.hIj.lastUpdateTime > ((long) i)) {
                z2 = true;
                if (z2) {
                    v.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
                    ak.vy().a(1561, aVar);
                    ak.vy().a(new com.tencent.mm.plugin.nfc_open.a.b(aVar.hIj.version), 0);
                }
                ak.yW();
                i = ((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqm, Integer.valueOf(0))).intValue();
                if (i == 0) {
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqn, Integer.valueOf(0))).intValue() != 1) {
                        eH(true);
                    } else {
                        eH(false);
                    }
                } else if (i != 1) {
                    eH(true);
                } else {
                    eH(false);
                }
                v.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
                e.a(new Runnable(this) {
                    final /* synthetic */ a hIi;

                    {
                        this.hIi = r1;
                    }

                    public final void run() {
                        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences(aa.bti(), 4);
                        boolean z = sharedPreferences.getBoolean("NFC_REPORT", false);
                        if (!z) {
                            int cm = com.tencent.mm.plugin.nfc.b.a.a.aDU().cm(aa.getContext());
                            if (cm == 0) {
                                g.iuh.h(12779, new Object[]{p.rJ(), Integer.valueOf(0)});
                            } else {
                                g.iuh.h(12779, new Object[]{p.rJ(), Integer.valueOf(1)});
                            }
                            sharedPreferences.edit().putBoolean("NFC_REPORT", true).commit();
                            v.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = " + cm);
                        }
                        v.i("MicroMsg.SubCoreCpuCard", "doNFCReport nfcReport = " + z + " NFC_REPORT = " + sharedPreferences.getBoolean("NFC_REPORT", false));
                    }
                }, getClass().getName());
            }
        }
        z2 = false;
        if (z2) {
            v.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            ak.vy().a(1561, aVar);
            ak.vy().a(new com.tencent.mm.plugin.nfc_open.a.b(aVar.hIj.version), 0);
        }
        ak.yW();
        i = ((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqm, Integer.valueOf(0))).intValue();
        if (i == 0) {
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.nqn, Integer.valueOf(0))).intValue() != 1) {
                eH(false);
            } else {
                eH(true);
            }
        } else if (i != 1) {
            eH(false);
        } else {
            eH(true);
        }
        v.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        e.a(/* anonymous class already generated */, getClass().getName());
    }

    private static void eH(boolean z) {
        if (z) {
            aa.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
        } else {
            aa.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        }
    }

    public final void th() {
    }
}
