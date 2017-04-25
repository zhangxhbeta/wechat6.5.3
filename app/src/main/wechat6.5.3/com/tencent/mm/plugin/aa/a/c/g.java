package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.model.m;
import com.tencent.mm.plugin.aa.a.c.f.AnonymousClass1;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.protocal.c.o;
import com.tencent.mm.protocal.c.t;
import com.tencent.mm.sdk.platformtools.v;

public class g implements com.tencent.mm.vending.c.b<f> {
    protected f dtr;
    public final c dts;
    public final a dtt;
    public final d dtu;
    public final b dtv;
    public final e dtw;

    public class a implements com.tencent.mm.vending.h.e<o, Long> {
        final /* synthetic */ g dtx;

        public a(g gVar) {
            this.dtx = gVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            Long l = (Long) obj;
            com.tencent.mm.vending.app.a aVar = this.dtx.dtr;
            long longValue = l.longValue();
            String stringExtra = aVar.pgh.getStringExtra("bill_no");
            String stringExtra2 = aVar.pgh.getStringExtra("chatroom");
            int i = aVar.pgh.getIntExtra("enter_scene", 0) == 1 ? com.tencent.mm.plugin.aa.a.a.drS : com.tencent.mm.plugin.aa.a.a.drT;
            v.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", new Object[]{Long.valueOf(longValue), stringExtra, stringExtra2});
            if (m.dE(stringExtra2)) {
                com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).c(aVar.dto.dsq));
            } else {
                com.tencent.mm.vending.g.g.bKJ().bo(Boolean.valueOf(false));
            }
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class b implements com.tencent.mm.vending.h.e<Boolean, Void> {
        final /* synthetic */ g dtx;

        public b(g gVar) {
            this.dtx = gVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.app.a aVar = this.dtx.dtr;
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(aVar.pgh.getStringExtra("bill_no"), Integer.valueOf(aVar.pgh.getIntExtra("enter_scene", 0) == 1 ? com.tencent.mm.plugin.aa.a.a.drU : com.tencent.mm.plugin.aa.a.a.drV), aVar.pgh.getStringExtra("chatroom")).c(aVar.dtp.dst));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class c implements com.tencent.mm.vending.h.e<t, Void> {
        final /* synthetic */ g dtx;

        public c(g gVar) {
            this.dtx = gVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.app.a aVar = this.dtx.dtr;
            String stringExtra = aVar.pgh.getStringExtra("bill_no");
            int intExtra = aVar.pgh.getIntExtra("enter_scene", 0);
            v.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", new Object[]{stringExtra, Integer.valueOf(intExtra), aVar.pgh.getStringExtra("chatroom")});
            com.tencent.mm.vending.g.g.a(com.tencent.mm.vending.g.g.a(stringExtra, Integer.valueOf(intExtra), r3).c(aVar.dtn.dsc));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class d implements com.tencent.mm.vending.h.e<Void, com.tencent.mm.vending.j.d<String, String, String>> {
        final /* synthetic */ g dtx;

        public d(g gVar) {
            this.dtx = gVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            com.tencent.mm.vending.app.a aVar = this.dtx.dtr;
            String str = (String) dVar.get(1);
            h.b(str, aVar.pgh.getStringExtra("chatroom"), aVar.pgh.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
            return phb;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public class e implements com.tencent.mm.vending.h.e<Boolean, Void> {
        final /* synthetic */ g dtx;

        public e(g gVar) {
            this.dtx = gVar;
        }

        public final /* synthetic */ Object aq(Object obj) {
            com.tencent.mm.vending.app.a aVar = this.dtx.dtr;
            String stringExtra = aVar.pgh.getStringExtra("bill_no");
            String stringExtra2 = aVar.pgh.getStringExtra("chatroom");
            int intExtra = aVar.pgh.getIntExtra("enter_scene", 0);
            v.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
            com.tencent.mm.vending.g.b bKJ = com.tencent.mm.vending.g.g.bKJ();
            bKJ.bKI();
            new com.tencent.mm.plugin.aa.a.a.a(stringExtra, stringExtra2, intExtra).Bt().a(new AnonymousClass1(aVar, bKJ));
            return null;
        }

        public final String Ns() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object Nr() {
        return this.dtr;
    }

    public g() {
        this(new f());
    }

    private g(f fVar) {
        this.dts = new c(this);
        this.dtt = new a(this);
        this.dtu = new d(this);
        this.dtv = new b(this);
        this.dtw = new e(this);
        this.dtr = fVar;
    }
}
