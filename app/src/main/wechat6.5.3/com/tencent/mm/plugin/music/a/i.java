package com.tencent.mm.plugin.music.a;

import android.content.ClipboardManager;
import android.media.AudioManager;
import android.os.Looper;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.ai.d;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.ic.b;
import com.tencent.mm.e.b.ca;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.music.a.d.a;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.List;

public final class i implements ag {
    AudioManager cba;
    private c hDf;
    private f hDg;
    private a hDh;
    public ClipboardManager hDi;
    private c hDj = new c<ic>(this) {
        final /* synthetic */ i hDk;

        {
            this.hDk = r2;
            this.nhz = ic.class.getName().hashCode();
        }

        private static boolean a(ic icVar) {
            int i;
            int i2;
            switch (icVar.bhZ.action) {
                case -3:
                    icVar.bia.aXR = i.aDd().hCQ.HC();
                    break;
                case ai.CTRL_INDEX /*-2*/:
                    icVar.bia.bib = i.aDd().aCX();
                    break;
                case -1:
                    i.aDd().hCQ.XV();
                    break;
                case 0:
                    i.aDd().f(icVar.bhZ.bib);
                    break;
                case 1:
                    i.aDd().hCQ.pause();
                    i.aDg().aCU();
                    break;
                case 2:
                    i.aDd().hCQ.resume();
                    break;
                case 3:
                    f aDd = i.aDd();
                    ajr com_tencent_mm_protocal_c_ajr = icVar.bhZ.bib;
                    if (com_tencent_mm_protocal_c_ajr == null) {
                        v.i("MicroMsg.Music.MusicPlayerManager", "shake music item is null");
                        break;
                    }
                    aDd.hCP.clear();
                    aDd.hCP.add(h.i(com_tencent_mm_protocal_c_ajr));
                    aDd.hCO = 0;
                    i.aDe().m(com_tencent_mm_protocal_c_ajr);
                    break;
                case 4:
                    f aDd2 = i.aDd();
                    List list = icVar.bhZ.bed;
                    int i3 = icVar.bhZ.bic;
                    if (list != null && list.size() != 0 && i3 < list.size()) {
                        aDd2.hCP.clear();
                        for (i = 0; i < list.size(); i++) {
                            ajr com_tencent_mm_protocal_c_ajr2 = (ajr) list.get(i);
                            aDd2.hCP.add(h.i(com_tencent_mm_protocal_c_ajr2));
                            i.aDe().m(com_tencent_mm_protocal_c_ajr2);
                        }
                        aDd2.hCO = i3;
                        aDd2.mode = 2;
                        aDd2.hCQ.b(aDd2.aCW());
                        break;
                    }
                    v.i("MicroMsg.Music.MusicPlayerManager", "music wrapper list error");
                    break;
                case 5:
                    i.aDd().d(icVar.bhZ.bed, icVar.bhZ.bid);
                    break;
                case 6:
                    f aDd3 = i.aDd();
                    ajr com_tencent_mm_protocal_c_ajr3 = icVar.bhZ.bib;
                    if (com_tencent_mm_protocal_c_ajr3 != null) {
                        String i4 = h.i(com_tencent_mm_protocal_c_ajr3);
                        boolean z;
                        if (aDd3.hCP != null) {
                            i2 = 0;
                            while (i2 < aDd3.hCP.size()) {
                                if (i4.equals(aDd3.hCP.get(i2))) {
                                    aDd3.hCO = i2;
                                    i2 = 1;
                                    if (aDd3.hCP.size() > 1 && com_tencent_mm_protocal_c_ajr3.mKo) {
                                        aDd3.mode = 2;
                                    }
                                } else {
                                    i2++;
                                }
                            }
                            z = false;
                            aDd3.mode = 2;
                            break;
                        }
                        z = false;
                        if (i2 == 0) {
                            aDd3.f(com_tencent_mm_protocal_c_ajr3);
                            break;
                        }
                        aDd3.f(null);
                        break;
                    }
                    v.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                    break;
                case 7:
                    icVar.bia.aXR = i.aDd().hCQ.fR(icVar.bhZ.position);
                    break;
                case 8:
                    b bVar = icVar.bia;
                    e eVar = i.aDd().hCQ;
                    int duration = eVar.getDuration();
                    i2 = eVar.hCC != null ? eVar.hCC.aDi() : -1;
                    eVar.HC();
                    if (eVar.HC()) {
                        i = 1;
                    } else {
                        if (eVar.hCI && (eVar.hCG || eVar.hCF)) {
                            i = 1;
                        } else {
                            boolean z2 = false;
                        }
                        i = i != 0 ? 0 : 2;
                    }
                    v.i("MicroMsg.Music.MusicPlayer", "get music status = %d", new Object[]{Integer.valueOf(i)});
                    int aCV = eVar.aCV();
                    if (duration <= 0) {
                        aCV = 0;
                    }
                    if (eVar.hCH != null) {
                        d dVar = eVar.hCH;
                        dVar.lr = duration;
                        dVar.kB = i2;
                        dVar.mStatus = i;
                        dVar.cSU = aCV;
                    } else {
                        eVar.hCH = new d(duration, i2, i, aCV);
                    }
                    bVar.bie = eVar.hCH;
                    break;
                case 9:
                    icVar.bia.aXR = i.aDd().hCQ.hCI;
                    break;
            }
            return false;
        }
    };

    public static i aDc() {
        i iVar = (i) ak.yP().fY("plugin.music");
        if (iVar != null) {
            return iVar;
        }
        iVar = new i();
        ak.yP().a("plugin.music", iVar);
        return iVar;
    }

    public final HashMap<Integer, g.c> ti() {
        HashMap<Integer, g.c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("Music".hashCode()), new g.c(this) {
            final /* synthetic */ i hDk;

            {
                this.hDk = r1;
            }

            public final String[] pS() {
                return new String[]{f.a(ca.pz(), "Music")};
            }
        });
        return hashMap;
    }

    public static f aDd() {
        if (aDc().hDg == null) {
            aDc().hDg = new f();
        }
        return aDc().hDg;
    }

    public static a aDe() {
        if (aDc().hDh == null) {
            i aDc = aDc();
            ak.yW();
            aDc.hDh = new a(com.tencent.mm.model.c.wE());
        }
        return aDc().hDh;
    }

    public static AudioManager aDf() {
        if (aDc().cba == null) {
            aDc().cba = (AudioManager) aa.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        return aDc().cba;
    }

    public static c aDg() {
        if (aDc().hDf == null) {
            aDc().hDf = new c();
        }
        return aDc().hDf;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.a.nhr.e(this.hDj);
        new ac(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ i hDk;

            {
                this.hDk = r1;
            }

            public final void run() {
                v.i("MicroMsg.Music.SubCoreMusic", "init audioManager %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
                i.aDc().cba = (AudioManager) aa.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
        });
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        if (this.hDg != null) {
            f fVar = this.hDg;
            fVar.hCQ.XV();
            fVar.hCP.clear();
            ak.vy().b(520, fVar);
        }
        this.hDg = null;
        this.hDf = null;
        this.hDh = null;
        this.cba = null;
        this.hDi = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.hDj);
    }
}
