package com.tencent.mm.plugin.nfc_open.b;

import android.content.ComponentName;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

public final class a implements e {
    public aki hIj;

    public a() {
        init();
    }

    private void init() {
        this.hIj = new aki();
        ak.yW();
        String str = (String) c.vf().get(com.tencent.mm.storage.t.a.nqh, null);
        if (be.kS(str)) {
            this.hIj.mov = new LinkedList();
            this.hIj.lastUpdateTime = 0;
            this.hIj.mow = 86400;
            this.hIj.version = 0;
            return;
        }
        try {
            this.hIj.az(str.getBytes("ISO-8859-1"));
        } catch (Exception e) {
            v.w("MicroMsg.CpuCardConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
            this.hIj.mov = new LinkedList();
            this.hIj.lastUpdateTime = 0;
            this.hIj.mow = 86400;
            this.hIj.version = 0;
        }
    }

    private void a(aki com_tencent_mm_protocal_c_aki) {
        if (!ak.uz()) {
            v.i("MicroMsg.CpuCardConfigManager", "setConfig account not ready");
        } else if (com_tencent_mm_protocal_c_aki != null) {
            v.i("MicroMsg.CpuCardConfigManager", "setConfig config");
            this.hIj = com_tencent_mm_protocal_c_aki;
            try {
                String str = new String(this.hIj.toByteArray(), "ISO-8859-1");
                ak.yW();
                c.vf().a(com.tencent.mm.storage.t.a.nqh, str);
            } catch (UnsupportedEncodingException e) {
                v.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e.getLocalizedMessage());
            } catch (IOException e2) {
                v.w("MicroMsg.CpuCardConfigManager", "save config exp, " + e2.getLocalizedMessage());
            }
        }
    }

    private aki aDW() {
        if (this.hIj == null) {
            init();
        }
        return this.hIj;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ak.vy().b(1561, this);
        if (kVar instanceof b) {
            aki aDW = aDW();
            aDW.lastUpdateTime = be.Nh();
            if (i == 0 && i2 == 0) {
                lu luVar = (lu) ((b) kVar).cif.czl.czs;
                if (luVar != null) {
                    aDW.mow = luVar.mow;
                    aDW.mox = luVar.mox;
                    ak.yW();
                    if (((Integer) c.vf().get(com.tencent.mm.storage.t.a.nqm, Integer.valueOf(0))).intValue() == 0) {
                        if (luVar.mox == 1) {
                            aa.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
                        } else {
                            aa.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
                        }
                    }
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.nqn, Integer.valueOf(luVar.mox));
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.nqq, luVar.kLC);
                    if (aDW.version == luVar.version) {
                        v.i("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd no config change return version = " + luVar.version);
                        a(aDW);
                        return;
                    }
                    aDW.version = luVar.version;
                    if (luVar.mov == null || luVar.mov.isEmpty()) {
                        aDW.mov.clear();
                    } else {
                        if (aDW.mov == null) {
                            aDW.mov = new LinkedList();
                        } else {
                            aDW.mov.clear();
                        }
                        for (int i3 = 0; i3 < luVar.mov.size(); i3++) {
                            it itVar = new it();
                            itVar.lYG = ((it) luVar.mov.get(i3)).lYG;
                            itVar.mke = ((it) luVar.mov.get(i3)).mke;
                            v.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd sflag=" + be.f(Integer.valueOf(itVar.mke)) + ", url=" + be.ma(itVar.lYG));
                            if (itVar.mkd == null) {
                                itVar.mkd = new LinkedList();
                            } else {
                                itVar.mkd.clear();
                            }
                            for (int i4 = 0; i4 < ((it) luVar.mov.get(i3)).mkd.size(); i4++) {
                                lv lvVar = new lv();
                                if (lvVar.moy == null) {
                                    lvVar.moy = new LinkedList();
                                } else {
                                    lvVar.moy.clear();
                                }
                                for (int i5 = 0; i5 < ((lv) ((it) luVar.mov.get(i3)).mkd.get(i4)).moy.size(); i5++) {
                                    ky kyVar = new ky();
                                    kyVar.aWW = ((ky) ((lv) ((it) luVar.mov.get(i3)).mkd.get(i4)).moy.get(i5)).aWW;
                                    kyVar.hbw = ((ky) ((lv) ((it) luVar.mov.get(i3)).mkd.get(i4)).moy.get(i5)).hbw;
                                    v.d("MicroMsg.CpuCardConfigManager", "nfc-onSceneEnd cmd=" + be.ma(kyVar.aWW) + ", answer=" + be.ma(kyVar.hbw));
                                    lvVar.moy.add(kyVar);
                                }
                                itVar.mkd.add(lvVar);
                            }
                            aDW.mov.add(itVar);
                        }
                    }
                }
            }
            a(aDW);
        }
    }
}
