package com.tencent.mm.pluginsdk.model.downloader;

import com.tencent.mm.e.a.fd;
import com.tencent.mm.e.a.fe;
import com.tencent.mm.e.a.ff;
import com.tencent.mm.e.a.fg;
import com.tencent.mm.e.a.fh;
import com.tencent.mm.e.a.fi;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.downloader.a.AnonymousClass2;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

final class k extends i {
    private c cwi = new c<fe>(this) {
        final /* synthetic */ k lCv;

        {
            this.lCv = r2;
            this.nhz = fe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fe feVar = (fe) bVar;
            switch (feVar.bex.bey) {
                case 1:
                    this.lCv.lCa.q(feVar.bex.id, feVar.bex.path);
                    break;
                case 2:
                    this.lCv.lCa.dE(feVar.bex.id);
                    break;
                case 4:
                    this.lCv.lCa.v(feVar.bex.id, feVar.bex.errCode);
                    break;
                case 5:
                    this.lCv.lCa.dD(feVar.bex.id);
                    break;
                case 6:
                    a aVar = this.lCv.lCa;
                    long j = feVar.bex.id;
                    v.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), feVar.bex.path);
                    ad.o(new AnonymousClass2(aVar, j, r1));
                    break;
                case 7:
                    this.lCv.lCa.dF(feVar.bex.id);
                    break;
                case MMGIFException.D_GIF_ERR_OPEN_FAILED /*101*/:
                    d bnK = d.bnK();
                    bnK.lBV = bnK.bnM();
                    break;
            }
            return true;
        }
    };

    public k(a aVar) {
        super(aVar);
        a.nhr.e(this.cwi);
    }

    public final long a(e eVar) {
        b fdVar = new fd();
        fdVar.beo.beq = eVar.lCg;
        fdVar.beo.aST = eVar.mFileName;
        fdVar.beo.ber = eVar.lCh;
        fdVar.beo.fileType = eVar.lCi;
        fdVar.beo.appId = eVar.dzg;
        fdVar.beo.bes = eVar.lCj;
        fdVar.beo.bet = eVar.lCk;
        fdVar.beo.beu = eVar.lCl;
        fdVar.beo.packageName = eVar.gpe;
        fdVar.beo.bev = eVar.lCm;
        a.nhr.z(fdVar);
        return fdVar.bep.bew;
    }

    public final int dm(long j) {
        b fhVar = new fh();
        fhVar.beF.bew = j;
        a.nhr.z(fhVar);
        return fhVar.beG.count;
    }

    public final f dn(long j) {
        b fgVar = new fg();
        fgVar.beB.bew = j;
        a.nhr.z(fgVar);
        f fVar = new f();
        fVar.id = j;
        fVar.url = fgVar.beC.url;
        fVar.status = fgVar.beC.status;
        fVar.path = fgVar.beC.path;
        fVar.aZy = fgVar.beC.aZy;
        fVar.beD = fgVar.beC.beD;
        fVar.beE = fgVar.beC.beE;
        return fVar;
    }

    public final boolean do(long j) {
        b ffVar = new ff();
        ffVar.bez.bew = j;
        a.nhr.z(ffVar);
        return ffVar.beA.aXR;
    }

    public final boolean dp(long j) {
        b fiVar = new fi();
        fiVar.beH.bew = j;
        a.nhr.z(fiVar);
        return fiVar.beI.aXR;
    }
}
