package com.tencent.mm.plugin.emoji.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;

public class d {
    public static d faR;
    public ArrayList<String> faS = new ArrayList();
    public boolean faT = true;
    public boolean faU = false;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ c faV;
        final /* synthetic */ d faW;

        AnonymousClass1(d dVar, c cVar) {
            this.faW = dVar;
            this.faV = cVar;
        }

        public final void run() {
            if (this.faV != null && !this.faV.bxL()) {
                v.i("MicroMsg.emoji.EmojiFileCheckerMgr", "chatting emoji broken. try to recover:%s", new Object[]{this.faV.EB()});
                d.a(this.faV, true);
            }
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ c faV;
        final /* synthetic */ d faW;
        final /* synthetic */ Context val$context;

        AnonymousClass2(d dVar, c cVar, Context context) {
            this.faW = dVar;
            this.faV = cVar;
            this.val$context = context;
        }

        public final void run() {
            if (this.faV != null && !this.faV.bxL()) {
                if (be.kS(this.faV.field_groupId)) {
                    v.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emoji broken. try to recover:%s", new Object[]{this.faV.EB()});
                    d.a(this.faV, false);
                    return;
                }
                d.a(this.faW, this.val$context, this.faV);
            }
        }
    }

    static /* synthetic */ void a(d dVar, Context context, final c cVar) {
        if (context != null && cVar != null && !dVar.faS.contains(cVar.field_groupId)) {
            if (!aeT() || dVar.faU) {
                if (aeT()) {
                    dVar.b(cVar, false);
                    v.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{cVar.field_groupId});
                    return;
                }
                dVar.b(cVar, true);
                v.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in wifi netword:%s", new Object[]{cVar.field_groupId});
            } else if (dVar.faT) {
                g.a(context, context.getString(2131232394), "", new OnClickListener(dVar) {
                    final /* synthetic */ d faW;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.faW.b(cVar, false);
                        this.faW.faU = true;
                        v.i("MicroMsg.emoji.EmojiFileCheckerMgr", "smiley pannel emotion broken. try to recover in mobile netword:%s", new Object[]{cVar.field_groupId});
                    }
                }, new OnClickListener(dVar) {
                    final /* synthetic */ d faW;

                    {
                        this.faW = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.faW.faU = false;
                    }
                });
                dVar.faT = false;
            } else {
                v.i("MicroMsg.emoji.EmojiFileCheckerMgr", "has alert recover.");
            }
        }
    }

    public static d aeS() {
        if (faR == null) {
            synchronized (d.class) {
                faR = new d();
            }
        }
        return faR;
    }

    public static void a(c cVar, boolean z) {
        if (cVar != null) {
            cVar.field_reserved4 = 0;
            com.tencent.mm.plugin.emoji.model.g.afx().fch.s(cVar);
            com.tencent.mm.plugin.emoji.model.g.afr().h(cVar);
            if (z) {
                com.tencent.mm.plugin.report.service.g.iuh.a(231, 0, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.a(231, 1, 1, false);
            }
        }
    }

    private void b(c cVar, boolean z) {
        if (this.faS == null) {
            this.faS = new ArrayList();
        }
        this.faS.add(cVar.field_groupId);
        ak.vy().a(new com.tencent.mm.plugin.emoji.e.g(cVar.field_groupId), 0);
        if (z) {
            com.tencent.mm.plugin.report.service.g.iuh.a(231, 3, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(231, 2, 1, false);
        }
    }

    private static boolean aeT() {
        return com.tencent.mm.sdk.platformtools.ak.is3G(aa.getContext()) || com.tencent.mm.sdk.platformtools.ak.is4G(aa.getContext()) || com.tencent.mm.sdk.platformtools.ak.is2G(aa.getContext());
    }
}
