package com.tencent.mm.plugin.music.a;

import android.os.Looper;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public final class f implements e {
    public int hCO;
    public List<String> hCP;
    public e hCQ = new e();
    public com.tencent.mm.plugin.music.a.b.a hCR;
    public boolean hCS;
    public int mode = 1;

    private class a implements Runnable {
        final /* synthetic */ f hCT;

        private a(f fVar) {
            this.hCT = fVar;
        }

        public final void run() {
            List list;
            long currentTimeMillis = System.currentTimeMillis();
            this.hCT.hCS = true;
            ajr aCX = this.hCT.aCX();
            List arrayList = new ArrayList();
            ic icVar;
            switch (aCX.mJV) {
                case 1:
                    icVar = new ic();
                    icVar.bhZ.action = -5;
                    com.tencent.mm.sdk.c.a.nhr.z(icVar);
                    list = icVar.bia.bed;
                    break;
                case 4:
                    icVar = new ic();
                    icVar.bhZ.action = -4;
                    com.tencent.mm.sdk.c.a.nhr.z(icVar);
                    list = icVar.bia.bed;
                    break;
                case 6:
                    ez ezVar = new ez();
                    ezVar.bdQ.type = 18;
                    com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                    list = ezVar.bdR.bed;
                    break;
                case 8:
                    icVar = new ic();
                    icVar.bhZ.action = -6;
                    icVar.bhZ.bib = aCX;
                    com.tencent.mm.sdk.c.a.nhr.z(icVar);
                    list = icVar.bia.bed;
                    break;
                default:
                    list = null;
                    break;
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    ajr com_tencent_mm_protocal_c_ajr = (ajr) list.get(i);
                    i.aDe().m(com_tencent_mm_protocal_c_ajr);
                    arrayList.add(h.i(com_tencent_mm_protocal_c_ajr));
                }
            }
            v.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask run time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            this.hCT.hCS = false;
            Runnable bVar = new b();
            bVar.hCU = arrayList;
            ad.o(bVar);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ f hCT;
        List<String> hCU;

        private b(f fVar) {
            this.hCT = fVar;
        }

        public final void run() {
            String i = h.i(this.hCT.aCX());
            int i2 = this.hCT.hCO;
            int i3 = 0;
            for (int i4 = 0; i4 < this.hCU.size(); i4++) {
                if (((String) this.hCU.get(i4)).equals(i)) {
                    i2 = i4;
                    i3 = 1;
                }
            }
            if (i3 != 0) {
                int i5;
                for (i5 = i2 + 1; i5 < this.hCU.size(); i5++) {
                    this.hCT.hCP.add(this.hCU.get(i5));
                }
                for (i5 = 0; i5 < i2; i5++) {
                    this.hCT.hCP.add(this.hCU.get(i5));
                }
                v.i("MicroMsg.Music.MusicPlayerManager", "GetMusicWrapperListTask currentMusicSize=%d currentMusicIndex=%d", new Object[]{Integer.valueOf(this.hCT.hCP.size()), Integer.valueOf(this.hCT.hCO)});
                id idVar = new id();
                idVar.bif.action = 5;
                com.tencent.mm.sdk.c.a.nhr.z(idVar);
            }
        }
    }

    public f() {
        ak.vy().a(520, this);
        this.hCP = new ArrayList();
    }

    public final void f(ajr com_tencent_mm_protocal_c_ajr) {
        if (com_tencent_mm_protocal_c_ajr == null && this.hCP.size() == 0) {
            v.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null && musicList's size is 0");
            return;
        }
        if (com_tencent_mm_protocal_c_ajr != null) {
            this.hCP.clear();
            this.hCP.add(h.i(com_tencent_mm_protocal_c_ajr));
            this.hCO = 0;
            i.aDe().m(com_tencent_mm_protocal_c_ajr);
            if (this.mode == 2) {
                aCY();
            }
        }
        this.hCQ.b(aCW());
    }

    public final synchronized void d(List<ajr> list, boolean z) {
        if (list != null) {
            if (list.size() != 0) {
                if (z) {
                    this.hCP.clear();
                }
                for (ajr com_tencent_mm_protocal_c_ajr : list) {
                    this.hCP.add(h.i(com_tencent_mm_protocal_c_ajr));
                    i.aDe().m(com_tencent_mm_protocal_c_ajr);
                }
            }
        }
        v.i("MicroMsg.Music.MusicPlayerManager", "appendMusicList error");
    }

    public final com.tencent.mm.ai.a aCW() {
        if (this.hCP.size() <= this.hCO) {
            return null;
        }
        return i.aDe().xe((String) this.hCP.get(this.hCO));
    }

    public final ajr aCX() {
        if (this.hCP.size() <= this.hCO) {
            return null;
        }
        com.tencent.mm.ai.a xe = i.aDe().xe((String) this.hCP.get(this.hCO));
        return xe != null ? xe.HA() : null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.music.a.b.a aVar = (com.tencent.mm.plugin.music.a.b.a) kVar;
            yk ykVar = aVar.hDp;
            String str2 = aVar.big.field_musicId;
            if (ykVar != null && str2 != null) {
                for (String str3 : this.hCP) {
                    if (str3.equals(str2)) {
                        str2 = m.b(ykVar.mAn);
                        String b = m.b(ykVar.mAo);
                        String b2 = m.b(ykVar.mAm);
                        com.tencent.mm.plugin.music.a.d.a aDe = i.aDe();
                        boolean z = aVar.pRh;
                        com.tencent.mm.ai.a xe = aDe.xe(str3);
                        if (xe == null) {
                            v.e("MicroMsg.Music.MusicStorage", "updateMusicWithLyricResponse can not find music %s", new Object[]{str3});
                        } else {
                            if (!be.kS(str2)) {
                                xe.field_songAlbumUrl = str2;
                            }
                            xe.field_songHAlbumUrl = b;
                            xe.field_songLyric = b2;
                            aDe.a(xe, new String[]{"songAlbumUrl", "songHAlbumUrl", "songLyric"});
                            aDe.hDD.put(str3, xe);
                            aDe.g(xe, z);
                        }
                        v.i("MicroMsg.Music.MusicPlayerManager", "get response %s %s %s", new Object[]{str2, b, b2});
                        if (!be.kS(b)) {
                            id idVar = new id();
                            idVar.bif.action = 6;
                            idVar.bif.big = aVar.big;
                            com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void aCY() {
        com.tencent.mm.sdk.i.e.a(new a(), "music_get_list_task");
    }

    public final boolean aCZ() {
        return this.hCP.size() > 0 && this.mode == 2;
    }
}
