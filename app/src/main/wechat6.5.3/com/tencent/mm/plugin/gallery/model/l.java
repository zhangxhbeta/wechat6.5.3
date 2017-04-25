package com.tencent.mm.plugin.gallery.model;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g.a;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.g.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashSet;

public final class l {
    private int dFH = 3;
    public HashSet<a> get = new HashSet();
    public HashSet<b> geu = new HashSet();
    public g gev;
    public int gew = 1;

    public final void lh(int i) {
        this.gew = i;
        aqK();
    }

    public final void aqK() {
        v.i("MicroMsg.MediaQueryService", "initQueryType: %d", new Object[]{Integer.valueOf(this.gew)});
        switch (this.gew) {
            case 1:
                this.gev = new i();
                return;
            case 2:
                this.gev = new n();
                return;
            case 3:
                this.gev = new h();
                return;
            default:
                this.gev = new i();
                return;
        }
    }

    public final void li(int i) {
        v.i("MicroMsg.MediaQueryService", "setQuerySource, %d, %s", new Object[]{Integer.valueOf(i), be.bur()});
        this.dFH = i;
    }

    public final int aqL() {
        v.i("MicroMsg.MediaQueryService", "getQuerySource, %d, %s", new Object[]{Integer.valueOf(this.dFH), be.bur()});
        return this.dFH;
    }

    public final int aqM() {
        v.i("MicroMsg.MediaQueryService", "getQueryType, %d, %s", new Object[]{Integer.valueOf(this.gew), be.bur()});
        return this.gew;
    }

    public final void a(a aVar) {
        this.get.remove(aVar);
    }

    public final void aA(final String str, final int i) {
        if (this.gev == null) {
            v.f("MicroMsg.MediaQueryService", "media query not init, init again");
            aqK();
        }
        e aqo = c.aqo();
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ l gex;

            public final void run() {
                this.gex.gev.a(str, i, new c(this) {
                    final /* synthetic */ AnonymousClass2 gez;

                    {
                        this.gez = r1;
                    }

                    public final void C(ArrayList<MediaItem> arrayList) {
                        l lVar = this.gez.gex;
                        b[] bVarArr = new b[lVar.geu.size()];
                        lVar.geu.toArray(bVarArr);
                        for (b C : bVarArr) {
                            C.C(arrayList);
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|queryMediaInAlbums";
            }
        };
        if (aqo.gdU == null) {
            aqo.gdU = new ac(aqo.gdR.getLooper());
        }
        aqo.gdU.post(anonymousClass2);
    }
}
