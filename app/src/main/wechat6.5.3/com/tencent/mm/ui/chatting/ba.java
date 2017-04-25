package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.ae.p;
import com.tencent.mm.bd.a;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.o;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.q.c;
import com.tencent.mm.q.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

final class ba extends b {
    public static final int oou = (a.dv(aa.getContext()) - ((int) (a.getDensity(aa.getContext()) * 60.0f)));
    public static final int oov = (((int) a.getDensity(aa.getContext())) * 180);
    private ChattingUI.a onG;
    private int ooy = 0;

    public ba() {
        super(65);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903294);
        l lVar = new l(this.eKg);
        lVar.eTg = (TextView) view.findViewById(2131755027);
        lVar.jRV = view.findViewById(2131756091);
        lVar.gfb = (CheckBox) view.findViewById(2131755022);
        lVar.fIV = view.findViewById(2131755026);
        lVar.ilK = (ImageView) view.findViewById(2131756093);
        lVar.dID = (TextView) view.findViewById(2131755226);
        lVar.fBO = (TextView) view.findViewById(2131755923);
        view.setTag(lVar);
        return view;
    }

    protected final boolean bEy() {
        return false;
    }

    public final void a(ad.a aVar, int i, ChattingUI.a aVar2, at atVar, String str) {
        this.onG = aVar2;
        l lVar = (l) aVar;
        c dZ = com.tencent.mm.q.a.a.dZ(atVar.field_content);
        List list = dZ.cqE;
        if (list.size() == 0) {
            lVar.jRV.setVisibility(8);
            return;
        }
        dl dlVar;
        CharSequence charSequence;
        lVar.jRV.setVisibility(0);
        d dVar = (d) list.get(0);
        if (t.kS(dVar.cqI)) {
            lVar.ilK.setVisibility(8);
        } else {
            lVar.ilK.setVisibility(0);
            String str2 = dVar.cqI;
            ImageView imageView = lVar.ilK;
            int i2 = atVar.field_type;
            if (p.GP()) {
                str2 = p.je(str2);
            }
            com.tencent.mm.ae.a.a GL = n.GL();
            com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
            aVar3.cPL = 2131689814;
            aVar3.cPs = true;
            aVar3 = aVar3.aI(oou, oov);
            aVar3.cPi = new az.b();
            aVar3.cPu = r.o(str2, i2, "@T");
            GL.b(str2, imageView, aVar3.GU(), new az.a());
        }
        lVar.dID.setText(dVar.title);
        Object OW = aVar2.OW(dVar.url);
        if (TextUtils.isEmpty(OW)) {
            dlVar = new dl(atVar, false, i, dVar.url, 6, false, aVar2.bFU(), dZ.bnR, dZ.bnS, dVar.title);
        } else {
            v.d("MicroMsg.ChattingItemBizVideoFrom", "productId:%s", OW);
            dlVar = new dl(atVar, false, i, dVar.url, 8, false, aVar2.bFU(), dZ.bnR, dZ.bnS, dVar.title, OW, null, false, false);
        }
        int i3 = dVar.cqM;
        if (i3 <= 0 || ((long) i3) >= 86400) {
            charSequence = null;
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(((long) i3) < 3600 ? "mm:ss" : "HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
            charSequence = simpleDateFormat.format(Long.valueOf(((long) i3) * 1000));
        }
        if (TextUtils.isEmpty(charSequence)) {
            lVar.fBO.setVisibility(8);
        } else {
            lVar.fBO.setVisibility(0);
            lVar.fBO.setText(charSequence);
        }
        dlVar.lfd = atVar.field_msgSvrId;
        dlVar.lfe = 0;
        lVar.jRV.setTag(dlVar);
        lVar.jRV.setOnClickListener(aVar2.onh.oqh);
        lVar.jRV.setOnLongClickListener(aVar2.onh.oqj);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        dl dlVar = (dl) view.getTag();
        if (dlVar == null) {
            return false;
        }
        this.ooy = dlVar.lfe;
        int i = dlVar.position;
        if (!(this.onG.bFL() || x.ad(atVar))) {
            contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, view.getContext().getString(2131234555));
        }
        if (com.tencent.mm.ay.c.EH("favorite")) {
            contextMenu.add(i, 125, 0, view.getContext().getString(2131234180));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, ChattingUI.a aVar, at atVar) {
        String a;
        o.b n;
        switch (menuItem.getItemId()) {
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                a = az.a(atVar, aVar.nDR.nEl, this.ooy);
                if (!t.kS(a)) {
                    Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", a);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.ooy);
                    intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                    a = atVar.field_talker;
                    String fz = o.fz(atVar.field_msgSvrId);
                    intent.putExtra("reportSessionId", fz);
                    n = o.yx().n(fz, true);
                    n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
                    n.l("preUsername", a);
                    n.l("preChatName", a);
                    n.l("preMsgIndex", Integer.valueOf(this.ooy));
                    n.l("sendAppMsgScene", Integer.valueOf(1));
                    aVar.startActivity(intent);
                    break;
                }
                break;
            case 114:
                a = az.a(atVar, aVar.nDR.nEl, 0);
                if (!t.kS(a)) {
                    dy.c(atVar, a, aVar.nDR.nEl);
                    break;
                }
                break;
            case 125:
                a = atVar.field_talker;
                String fz2 = o.fz(atVar.field_msgSvrId);
                n = o.yx().n(fz2, true);
                n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
                n.l("preUsername", a);
                n.l("preChatName", a);
                n.l("preMsgIndex", Integer.valueOf(this.ooy));
                n.l("sendAppMsgScene", Integer.valueOf(1));
                bp bpVar = new bp();
                bpVar.aZd.aZi = this.ooy;
                bpVar.aZd.aZj = fz2;
                bpVar.aZd.og = aVar;
                bpVar.aZd.aZl = 40;
                com.tencent.mm.pluginsdk.model.d.a(bpVar, atVar);
                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                if (bpVar.aZe.ret == 0) {
                    com.tencent.mm.modelstat.b.daJ.q(atVar);
                    break;
                }
                break;
        }
        return false;
    }

    public final boolean a(View view, ChattingUI.a aVar, at atVar) {
        return false;
    }
}
