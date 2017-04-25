package com.tencent.mm.plugin.tmassistant.a;

import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.fd;
import com.tencent.mm.e.a.ff;
import com.tencent.mm.e.a.fg;
import com.tencent.mm.e.a.fh;
import com.tencent.mm.e.a.fi;
import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.model.downloader.e.a;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.sdk.c.c;
import java.util.HashMap;

public final class b implements ag {
    private a kmH;
    private c kmI = new c<fd>(this) {
        final /* synthetic */ b kmN;

        {
            this.kmN = r2;
            this.nhz = fd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fd fdVar = (fd) bVar;
            a baF = this.kmN.baF();
            a aVar = new a();
            aVar.GQ(fdVar.beo.beq);
            aVar.GR(fdVar.beo.aST);
            aVar.GS(fdVar.beo.ber);
            aVar.tE(fdVar.beo.fileType);
            aVar.setAppId(fdVar.beo.appId);
            aVar.hO(fdVar.beo.bes);
            aVar.hP(fdVar.beo.bet);
            aVar.lCn.lCl = fdVar.beo.beu;
            aVar.GT(fdVar.beo.packageName);
            aVar.hQ(fdVar.beo.bev);
            fdVar.bep.bew = baF.a(aVar.lCn);
            return true;
        }
    };
    private c kmJ = new c<fh>(this) {
        final /* synthetic */ b kmN;

        {
            this.kmN = r2;
            this.nhz = fh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fh fhVar = (fh) bVar;
            fhVar.beG.count = this.kmN.baF().dm(fhVar.beF.bew);
            return true;
        }
    };
    private c kmK = new c<fg>(this) {
        final /* synthetic */ b kmN;

        {
            this.kmN = r2;
            this.nhz = fg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fg fgVar = (fg) bVar;
            f dn = this.kmN.baF().dn(fgVar.beB.bew);
            fgVar.beC.url = dn.url;
            fgVar.beC.status = dn.status;
            fgVar.beC.path = dn.path;
            fgVar.beC.aZy = dn.aZy;
            fgVar.beC.beD = dn.beD;
            fgVar.beC.beE = dn.beE;
            return true;
        }
    };
    private c kmL = new c<ff>(this) {
        final /* synthetic */ b kmN;

        {
            this.kmN = r2;
            this.nhz = ff.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ff ffVar = (ff) bVar;
            ffVar.beA.aXR = this.kmN.baF().do(ffVar.bez.bew);
            return true;
        }
    };
    private c kmM = new c<fi>(this) {
        final /* synthetic */ b kmN;

        {
            this.kmN = r2;
            this.nhz = fi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fi fiVar = (fi) bVar;
            fiVar.beI.aXR = this.kmN.baF().dp(fiVar.beH.bew);
            return true;
        }
    };

    public final a baF() {
        if (this.kmH == null) {
            this.kmH = new a();
        }
        return this.kmH;
    }

    public final void aG(boolean z) {
        com.tencent.mm.sdk.c.a.nhr.e(this.kmI);
        com.tencent.mm.sdk.c.a.nhr.e(this.kmJ);
        com.tencent.mm.sdk.c.a.nhr.e(this.kmK);
        com.tencent.mm.sdk.c.a.nhr.e(this.kmL);
        com.tencent.mm.sdk.c.a.nhr.e(this.kmM);
    }

    public final void th() {
        com.tencent.mm.sdk.c.a.nhr.f(this.kmI);
        com.tencent.mm.sdk.c.a.nhr.f(this.kmJ);
        com.tencent.mm.sdk.c.a.nhr.f(this.kmK);
        com.tencent.mm.sdk.c.a.nhr.f(this.kmL);
        com.tencent.mm.sdk.c.a.nhr.f(this.kmM);
    }

    public final HashMap<Integer, g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aH(boolean z) {
    }
}
