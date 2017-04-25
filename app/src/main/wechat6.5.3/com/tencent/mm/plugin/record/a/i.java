package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.Vector;

public final class i extends f<g> {
    public static final String[] cic = new String[]{f.a(g.chq, "RecordCDNInfo")};
    d cie;
    private Vector<a> ipz = new Vector();

    public interface a {
        void a(int i, g gVar);
    }

    public final /* synthetic */ boolean a(long j, c cVar) {
        g gVar = (g) cVar;
        if (!super.a(j, gVar)) {
            return false;
        }
        b(1, gVar);
        return true;
    }

    public final /* synthetic */ boolean a(c cVar) {
        g gVar = (g) cVar;
        if (!super.a(gVar)) {
            return false;
        }
        b(1, gVar);
        return true;
    }

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        return b((g) cVar, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((g) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a((g) cVar, strArr);
    }

    public i(d dVar) {
        super(dVar, g.chq, "RecordCDNInfo", null);
        this.cie = dVar;
    }

    public final void a(final a aVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i ipB;

            public final void run() {
                if (!this.ipB.ipz.contains(aVar)) {
                    this.ipB.ipz.add(aVar);
                }
            }
        });
    }

    public final void b(final a aVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i ipB;

            public final void run() {
                this.ipB.ipz.remove(aVar);
            }
        });
    }

    private void b(final int i, final g gVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ i ipB;

            public final void run() {
                Iterator it = this.ipB.ipz.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(i, gVar);
                }
            }
        });
    }

    public final g yx(String str) {
        g gVar = null;
        Cursor rawQuery = this.cie.rawQuery("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null);
        if (rawQuery != null && rawQuery.moveToFirst()) {
            gVar = new g();
            gVar.b(rawQuery);
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return gVar;
    }

    public final boolean a(g gVar, String... strArr) {
        if (!super.c(gVar, strArr)) {
            return false;
        }
        b(0, gVar);
        return true;
    }

    public final boolean b(g gVar, String... strArr) {
        if (!super.a(gVar, strArr)) {
            return false;
        }
        b(1, gVar);
        return true;
    }

    public final boolean a(g gVar) {
        if (gVar != null) {
            v.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[]{gVar});
            if (!super.b(gVar)) {
                return false;
            }
            b(2, gVar);
            return true;
        }
        v.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        return false;
    }
}
