package com.tencent.mm.plugin.emoji.b;

import com.tencent.mm.e.a.jx;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.e.r;
import com.tencent.mm.plugin.emoji.g.a.d;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<jx> {
    public a() {
        this.nhz = jx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z;
        aeP();
        ak.yW();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noN, Long.valueOf(0))).longValue() > 86400000) {
            int i = 1;
        } else {
            z = false;
        }
        if (i != 0) {
            ak.vy().a(new e(), 0);
        }
        ct(false);
        cs(false);
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noG, Boolean.valueOf(false))).booleanValue()) {
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noE, null);
            long longValue = (obj == null || !(obj instanceof Long)) ? 0 : ((Long) obj).longValue();
            if (System.currentTimeMillis() - longValue > 86400000) {
                i = 1;
                if (i != 0) {
                    ak.vy().a(new m(8, 15), 0);
                }
                ak.yW();
                if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noQ, Long.valueOf(0))).longValue() > 86400000) {
                    i = g.afx().fch.iC(false);
                    com.tencent.mm.plugin.report.service.g.iuh.h(11597, new Object[]{Integer.valueOf(i)});
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noQ, Long.valueOf(System.currentTimeMillis()));
                }
                return false;
            }
        }
        z = false;
        if (i != 0) {
            ak.vy().a(new m(8, 15), 0);
        }
        ak.yW();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noQ, Long.valueOf(0))).longValue() > 86400000) {
            i = g.afx().fch.iC(false);
            com.tencent.mm.plugin.report.service.g.iuh.h(11597, new Object[]{Integer.valueOf(i)});
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noQ, Long.valueOf(System.currentTimeMillis()));
        }
        return false;
    }

    public static void cs(boolean z) {
        long j;
        ak.yW();
        Object obj = com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noD, null);
        if (obj == null || !(obj instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) obj).longValue();
        }
        if ((System.currentTimeMillis() - j > 86400000) || z) {
            v.i("MicroMsg.emoji.EmojiPostTaskListener", "uploadStoreEmoji need upload:%b", new Object[]{Boolean.valueOf(g.afx().fci.bxz())});
            if (g.afx().fci.bxz() || z) {
                ak.vy().a(new r(g.afx().fci.bxB(), 1), 0);
                return;
            }
            ak.yW();
            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noG, Boolean.valueOf(true));
        }
    }

    public static void ct(boolean z) {
        ak.yW();
        boolean z2;
        if (be.a((Boolean) com.tencent.mm.model.c.vf().get(348165, null), false)) {
            long j;
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(348166, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                int i = 1;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (i != 0 || z) {
            ArrayList bxR = g.afx().fch.bxR();
            if (bxR.size() > 0) {
                v.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji uploadEmojiList:%d", new Object[]{Integer.valueOf(bxR.size())});
                List arrayList = new ArrayList();
                int size = bxR.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(new d((String) bxR.get(i2)));
                    v.i("MicroMsg.emoji.EmojiPostTaskListener", "try to sync emoji upload Emoji:%s", new Object[]{bxR.get(i2)});
                }
                g.afu().feA.al(arrayList);
                g.afu().feA.afU();
            } else {
                v.i("MicroMsg.emoji.EmojiPostTaskListener", "no things need to upload.");
                ak.yW();
                com.tencent.mm.model.c.vf().set(348165, Boolean.valueOf(false));
            }
            ak.yW();
            com.tencent.mm.model.c.vf().set(348166, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static void aeP() {
        ak.yW();
        boolean a = be.a((Boolean) com.tencent.mm.model.c.vf().get(348162, null), false);
        ak.yW();
        boolean z;
        if (be.a((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noC, null), false) || !a) {
            z = false;
        } else {
            long j;
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(348163, null);
            if (obj == null || !(obj instanceof Long)) {
                j = 0;
            } else {
                j = ((Long) obj).longValue();
            }
            if (System.currentTimeMillis() - j > 3600000) {
                int i = 1;
            } else {
                z = false;
            }
        }
        if (i != 0) {
            v.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start do backup emoji.");
            ArrayList arrayList = (ArrayList) g.afx().fch.bxN();
            if (arrayList.size() <= 0) {
                v.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] no local emoji need not to backup ");
                ak.yW();
                com.tencent.mm.model.c.vf().set(348162, Boolean.valueOf(false));
                return;
            }
            ak.yW();
            com.tencent.mm.model.c.vf().set(348163, Long.valueOf(System.currentTimeMillis()));
            v.i("MicroMsg.emoji.EmojiPostTaskListener", "[cpan] start backup local emoji ");
            if (arrayList.size() > 50) {
                int size = arrayList.size();
                v.i("MicroMsg.emoji.EmojiPostTaskListener", "count:%d", new Object[]{Integer.valueOf(size / 50)});
                for (int i2 = 0; i2 <= r6; i2++) {
                    ArrayList arrayList2 = new ArrayList();
                    int i3 = i2 * 50;
                    int i4 = ((i2 + 1) * 50) + -1 >= size ? size : (i2 + 1) * 50;
                    v.i("MicroMsg.emoji.EmojiPostTaskListener", "start index:%d to index:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                    if (i4 > i3) {
                        arrayList2.addAll(arrayList.subList(i3, i4));
                        ak.vy().a(new com.tencent.mm.plugin.emoji.e.d(arrayList2), 0);
                    }
                }
                return;
            }
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.d(arrayList), 0);
        }
    }
}
