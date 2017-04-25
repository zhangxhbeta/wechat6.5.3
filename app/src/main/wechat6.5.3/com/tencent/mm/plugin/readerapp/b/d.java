package com.tencent.mm.plugin.readerapp.b;

import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.km;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class d extends c<km> {
    public d() {
        this.nhz = km.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        km kmVar = (km) bVar;
        switch (kmVar.blJ.opType) {
            case 3:
                boolean a;
                km.b bVar2 = kmVar.blK;
                bp bpVar = kmVar.blJ.blL;
                int i = kmVar.blJ.blM;
                v.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", new Object[]{Integer.valueOf(i), kmVar.blJ.blN});
                List b = g.aJg().b((long) i, 20);
                if (!b.isEmpty()) {
                    v.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String ah = be.ah(r1, "");
                    for (int i2 = 0; i2 < b.size(); i2++) {
                        if (ah.equals(((bc) b.get(i2)).zG())) {
                            a = b.a(bpVar, (bc) b.get(i2), i2);
                            bVar2.aYN = a;
                            break;
                        }
                    }
                }
                bpVar.aZd.aZk = 2131232653;
                a = false;
                bVar2.aYN = a;
            case 4:
                g.aJg().eR(kmVar.blJ.blO);
                break;
        }
        return false;
    }
}
