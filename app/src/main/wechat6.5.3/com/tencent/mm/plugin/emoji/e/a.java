package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class a extends ah {
    private static int fdD = 0;
    private static a fdE;
    private static p fdF;
    private static e fdG = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                a.fdD = 0;
                a.afC().ea(50);
                return;
            }
            a.afC().afE();
        }
    };

    public static class a implements com.tencent.mm.sdk.platformtools.ah.a {
        public a() {
            a.fdD = 0;
        }

        public final boolean oU() {
            if (a.fdD >= 100) {
                a.fdD = 0;
                v.d("MicroMsg.emoji.EmojiTuziTool", "insert tuzi");
                b bVar = g.afx().fci;
                com.tencent.mm.storage.a.a aVar = new com.tencent.mm.storage.a.a();
                aVar.field_productID = com.tencent.mm.plugin.emoji.h.a.ail();
                aVar.field_packName = "emoji_custom_all";
                aVar.field_type = com.tencent.mm.storage.a.a.TYPE_SYSTEM;
                aVar.field_sort = 2;
                aVar.field_packType = 4;
                aVar.field_packFlag = 1;
                aVar.field_lastUseTime = System.currentTimeMillis();
                bVar.a(aVar);
                g.afz().d(com.tencent.mm.plugin.emoji.h.a.ail(), 7, a.fdD, "");
                a.afF();
                return false;
            }
            g.afz().d(com.tencent.mm.plugin.emoji.h.a.ail(), 6, a.fdD, "");
            a.afH();
            return true;
        }
    }

    static /* synthetic */ int afH() {
        int i = fdD + 2;
        fdD = i;
        return i;
    }

    public static final a afC() {
        if (fdE == null) {
            synchronized (a.class) {
                if (fdE == null) {
                    fdE = new a();
                }
            }
        } else {
            fdE.QI();
        }
        return fdE;
    }

    public static void afD() {
        fdD = 0;
        fdF = new p("com.tencent.xin.emoticon.tusiji", 1);
        ak.vy().a(fdF, 0);
        ak.vy().a(413, fdG);
        v.d("MicroMsg.emoji.MockTuziDownloading", "add listener");
    }

    public final void afE() {
        QI();
        g.afz().d(com.tencent.mm.plugin.emoji.h.a.ail(), 3, fdD, "");
        afF();
    }

    public static void afF() {
        if (fdF != null) {
            ak.vy().c(fdF);
        }
        ak.vy().b(413, fdG);
        v.d("MicroMsg.emoji.MockTuziDownloading", "remove listener");
    }

    private a() {
        super(new a(), true);
    }
}
