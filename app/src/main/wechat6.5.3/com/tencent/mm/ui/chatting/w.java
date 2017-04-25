package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class w {

    private static class a implements com.tencent.mm.sdk.platformtools.ap.a {
        private Set<Long> omD;
        private p omE;
        private dq omF;

        public a(Set<Long> set, p pVar, dq dqVar) {
            this.omD = set;
            this.omE = pVar;
            this.omF = dqVar;
        }

        public final boolean AZ() {
            Set<Long> set = this.omD;
            List linkedList = new LinkedList();
            for (Long l : set) {
                ak.yW();
                bx ek = c.wJ().ek(l.longValue());
                if (ek.field_msgId == l.longValue()) {
                    b.daJ.r(ek);
                }
                linkedList.add(l);
                com.tencent.mm.sdk.c.b kwVar = new kw();
                kwVar.bmf.type = 3;
                kwVar.bmf.bao = l.longValue();
                com.tencent.mm.sdk.c.a.nhr.z(kwVar);
            }
            aw.w(linkedList);
            return true;
        }

        public final boolean Ba() {
            if (this.omE != null) {
                this.omE.dismiss();
                if (this.omF != null) {
                    this.omF.xd(com.tencent.mm.ui.chatting.dq.a.oyc);
                }
            }
            return true;
        }
    }

    public static void a(Context context, Set<Long> set, dq dqVar) {
        if (context == null) {
            v.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, context is null");
        } else if (set == null || set.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeDelMsg", "do delete msg fail, select ids is empty");
        } else {
            context.getString(2131231164);
            ct.orh.c(new a(set, g.a(context, context.getString(2131232283), false, null), dqVar));
            com.tencent.mm.plugin.report.service.g.iuh.h(10811, Integer.valueOf(4), Integer.valueOf(set.size()));
        }
    }
}
