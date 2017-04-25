package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.ae.f;
import com.tencent.mm.al.b;
import com.tencent.mm.al.n;
import com.tencent.mm.ar.m;
import com.tencent.mm.as.o;
import com.tencent.mm.bg.g;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.p;
import com.tencent.mm.storage.r;

public final class z {
    d cDi;
    b cUy;
    String cachePath;
    public String cka;
    g ckb = null;
    r ckd;
    az cke;
    public p crb;
    o dht;
    u djz;
    aa ejZ;
    au eka;
    ac ekb;
    f ekc;
    com.tencent.mm.storage.a.f ekd;
    ay eke;
    m ekf;
    com.tencent.mm.u.g ekg;
    l ekh;
    n eki;
    k ekj;
    i ekk;
    c ekl;
    com.tencent.mm.bg.f ekm = null;
    public int uin = 0;

    public final void wB() {
        if (this.ckb != null) {
            this.ckb.wB();
            this.ckb = null;
        }
        if (this.ekm != null) {
            com.tencent.mm.bg.f fVar = this.ekm;
            com.tencent.mm.bg.f.nxG = be.bur().toString();
            if (fVar.nxs != null) {
                fVar.nxs.close();
                fVar.nxs = null;
            }
            this.ekm = null;
        }
    }

    public final r vf() {
        if (this.uin != 0) {
            return this.ckd;
        }
        throw new com.tencent.mm.model.b();
    }

    public final aa wH() {
        if (this.uin != 0) {
            return this.ejZ;
        }
        throw new com.tencent.mm.model.b();
    }

    public final au wJ() {
        if (this.uin != 0) {
            return this.eka;
        }
        throw new com.tencent.mm.model.b();
    }

    public final ac wK() {
        if (this.uin != 0) {
            return this.ekb;
        }
        throw new com.tencent.mm.model.b();
    }

    public final f GH() {
        if (this.uin != 0) {
            return this.ekc;
        }
        throw new com.tencent.mm.model.b();
    }

    public final com.tencent.mm.storage.a.f We() {
        if (this.uin != 0) {
            return this.ekd;
        }
        throw new com.tencent.mm.model.b();
    }

    public final o KV() {
        if (this.uin != 0) {
            return this.dht;
        }
        throw new com.tencent.mm.model.b();
    }

    public final String wY() {
        if (this.uin != 0) {
            return this.cka + "emoji/";
        }
        throw new com.tencent.mm.model.b();
    }

    public final c Wf() {
        if (this.uin != 0) {
            return this.ekl;
        }
        throw new com.tencent.mm.model.b();
    }
}
