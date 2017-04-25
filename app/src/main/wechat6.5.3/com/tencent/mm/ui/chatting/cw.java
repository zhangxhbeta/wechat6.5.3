package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.k;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.s;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.io.InputStream;

public final class cw implements k {
    private Context context;
    private u euW;
    private String onj;
    private boolean osE = true;
    private boolean osF = true;

    public cw(Context context, u uVar, String str) {
        this.context = context;
        this.euW = uVar;
        this.onj = str;
        if (u.ew(this.onj)) {
            this.osF = false;
        }
        if (u.LJ(this.onj)) {
            this.osE = false;
        }
        if (u.LH(this.onj)) {
            this.osE = false;
        }
        String str2 = (this.euW == null || !u.ew(this.euW.field_username)) ? this.euW == null ? null : this.euW.field_username : this.onj;
        if (m.ey(str2)) {
            this.osF = false;
        }
    }

    public final void n(c cVar) {
        ak.yW();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            s.ey(this.context);
        } else if (cVar != null) {
            int i;
            if (this.euW.field_username.equals("medianote") && (com.tencent.mm.model.k.xJ() & 16384) == 0) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i != 0) {
                cVar.field_start = 0;
                cVar.field_state = c.nxa;
                a.bmr().d(cVar);
                bx atVar = new at();
                atVar.setType(47);
                atVar.cH("medianote");
                atVar.di(1);
                if (cVar.bnk()) {
                    atVar.setContent(ag.a(com.tencent.mm.model.k.xF(), 0, false, cVar.EB(), false, SQLiteDatabase.KeyEmpty));
                }
                atVar.cI(cVar.EB());
                atVar.z(aw.fN(atVar.field_talker));
                atVar.dh(2);
                ak.yW();
                com.tencent.mm.model.c.wJ().R(atVar);
                return;
            }
            a.bmr().a(be.kS(this.onj) ? this.euW.field_username : this.onj, cVar, null);
        }
    }

    public final void o(c cVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wY()).append(cVar.EB()).toString();
            if (e.aR(stringBuilder2 + "_thumb")) {
                wXMediaMessage.thumbData = e.c(stringBuilder2 + "_thumb", 0, e.aQ(stringBuilder2 + "_thumb"));
            } else {
                try {
                    InputStream fileInputStream = new FileInputStream(stringBuilder2);
                    wXMediaMessage.setThumbImage(b.a(fileInputStream, 1.0f, 0, 0));
                    fileInputStream.close();
                } catch (Throwable e) {
                    v.a("MicroMsg.ChattingSmileyPanelImpl", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.ChattingSmileyPanelImpl", "sendAppMsgEmoji Fail cause there is no thumb");
                }
            }
            wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
            l.a(wXMediaMessage, cVar.field_app_id, null, this.onj, 1, cVar.EB());
            return;
        }
        s.ey(this.context);
    }

    public final boolean azG() {
        return this.osF;
    }

    public final boolean azH() {
        return this.osE;
    }
}
