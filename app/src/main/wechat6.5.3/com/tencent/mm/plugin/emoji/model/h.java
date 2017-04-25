package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.e.a.bz;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class h {
    c fdA = new c<qw>(this) {
        final /* synthetic */ h fdC;

        {
            this.fdC = r2;
            this.nhz = qw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qw qwVar = (qw) bVar;
            switch (qwVar.bsA.aYt) {
                case 1:
                    this.fdC.fdx.addAll(be.g(qwVar.bsA.bsB));
                    this.fdC.fdy.addAll(this.fdC.fdx);
                    this.fdC.afB();
                    break;
            }
            return false;
        }
    };
    c fdB = new c<bz>(this) {
        final /* synthetic */ h fdC;

        {
            this.fdC = r2;
            this.nhz = bz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bz bzVar = (bz) bVar;
            if (this.fdC.fdx.contains(bzVar.aZx.aZy)) {
                this.fdC.fdz.remove(bzVar.aZx.aZy);
                if (bzVar.aZx.aZz) {
                    v.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", new Object[]{bzVar.aZx.aZy});
                    g.afx().fci.NA(bzVar.aZx.aZy);
                    ak.vy().a(new p(bzVar.aZx.aZy, 2), 0);
                } else {
                    v.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", new Object[]{bzVar.aZx.aZy});
                }
                this.fdC.afB();
            }
            return false;
        }
    };
    Set<String> fdx;
    Set<String> fdy;
    Set<String> fdz;

    public h() {
        a.nhr.e(this.fdA);
        a.nhr.e(this.fdB);
        this.fdx = Collections.synchronizedSet(new HashSet());
        this.fdy = Collections.synchronizedSet(new HashSet());
        this.fdz = Collections.synchronizedSet(new HashSet());
    }

    final void afB() {
        while (!this.fdy.isEmpty()) {
            if (this.fdz.isEmpty()) {
                Iterator it = this.fdy.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.fdy.remove(str);
                    com.tencent.mm.storage.a.a aI = g.afx().fci.aI(str, true);
                    if (aI == null || (aI.field_flag & 256) <= 0) {
                        v.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[]{str});
                        this.fdz.add(str);
                        ak.vy().a(new g(str, ""), 0);
                        return;
                    }
                    v.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[]{str});
                } else {
                    return;
                }
            }
            v.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[]{this.fdz.toString()});
            return;
        }
        v.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
    }
}
