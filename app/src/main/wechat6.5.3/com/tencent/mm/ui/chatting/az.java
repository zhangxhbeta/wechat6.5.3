package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ae.a.b.e;
import com.tencent.mm.ae.a.c.g;
import com.tencent.mm.ae.n;
import com.tencent.mm.ae.p;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.q.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

final class az extends com.tencent.mm.ui.chatting.ad.b {
    public static final int oou = (com.tencent.mm.bd.a.dv(aa.getContext()) - ((int) (com.tencent.mm.bd.a.getDensity(aa.getContext()) * 60.0f)));
    public static final int oov = (((int) com.tencent.mm.bd.a.getDensity(aa.getContext())) * 167);
    public static final int oow = (((int) com.tencent.mm.bd.a.getDensity(aa.getContext())) * 50);
    private int ilF = 0;
    private int ilG = 0;
    private com.tencent.mm.ui.chatting.ChattingUI.a onG;
    private boolean oox = false;
    private int ooy = 0;
    private long ooz = 0;

    public static class a implements g {
        public final void jk(String str) {
            v.d("MicroMsg.ChattingItemBizFrom", "onImageLoadStart, url: %s", str);
            com.tencent.mm.plugin.report.service.g.iuh.a(86, 0, 1, false);
        }

        public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
            if (bVar.cPY == 2) {
                boolean z;
                v.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, url:%s, contentType: %s", str, bVar.bsL);
                if (p.GP() && !be.kS(bVar.bsL) && p.jf(str) && bVar.bsL.equals("image/webp")) {
                    z = true;
                } else {
                    z = false;
                }
                v.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, isDownloadWebp: %b, status: %d", Boolean.valueOf(z), Integer.valueOf(bVar.status));
                switch (bVar.status) {
                    case 0:
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(86, 13, 1, false);
                            return;
                        }
                        return;
                    case 1:
                        com.tencent.mm.plugin.report.service.g.iuh.a(86, 2, 1, false);
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(86, 15, 1, false);
                            return;
                        }
                        return;
                    case 3:
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(86, 14, 1, false);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static class b implements com.tencent.mm.ae.a.c.b {
        public final com.tencent.mm.ae.a.d.b ji(String str) {
            v.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", str);
            try {
                com.tencent.mm.ae.a.d.b bVar;
                long currentTimeMillis = System.currentTimeMillis();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(20000);
                if (p.jf(str)) {
                    httpURLConnection.setRequestProperty("Referer", p.fL(d.lWh));
                }
                if (httpURLConnection.getResponseCode() >= SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
                    httpURLConnection.disconnect();
                    v.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
                    bVar = null;
                } else {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    bVar = new com.tencent.mm.ae.a.d.b(e.g(inputStream), httpURLConnection.getContentType(), (byte) 0);
                }
                if (bVar == null) {
                    return bVar;
                }
                boolean z;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (p.GP() && !be.kS(bVar.bsL) && p.jf(str) && bVar.bsL.equals("image/webp")) {
                    z = true;
                } else {
                    z = false;
                }
                v.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", Boolean.valueOf(z));
                long j = currentTimeMillis2 - currentTimeMillis;
                v.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", Long.valueOf(j));
                com.tencent.mm.plugin.report.service.g.iuh.a(86, 4, j, false);
                if (!z) {
                    return bVar;
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(86, 17, j, false);
                return bVar;
            } catch (Exception e) {
                v.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e.toString());
                return new com.tencent.mm.ae.a.d.b(null, null, (byte) 0);
            }
        }
    }

    public az() {
        super(26);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view == null || view.getTag() == null || ((com.tencent.mm.ui.chatting.ad.a) view.getTag()).type != this.eKg) {
            view = new bd(layoutInflater, 2130903300);
            q qVar = new q(this.eKg);
            qVar.eTg = (TextView) view.findViewById(2131755027);
            qVar.onB = view.findViewById(2131755025);
            qVar.ihk = (LinearLayout) view.findViewById(2131756091);
            qVar.olD.ilI = view.findViewById(2131756098);
            qVar.olD.dID = (TextView) qVar.olD.ilI.findViewById(2131755226);
            qVar.olD.grr = (TextView) qVar.olD.ilI.findViewById(2131756099);
            qVar.olD.ilK = (ImageView) qVar.olD.ilI.findViewById(2131756093);
            qVar.olD.olE = qVar.olD.ilI.findViewById(2131756100);
            qVar.olD.olF = (TextView) qVar.olD.ilI.findViewById(2131756101);
            qVar.olD.imf = (TextView) qVar.olD.ilI.findViewById(2131756104);
            qVar.olD.olG = (TextView) qVar.ihk.findViewById(2131756105);
            qVar.olD.ilM = (ProgressBar) view.findViewById(2131756102);
            qVar.olD.ilN = view.findViewById(2131756103);
            qVar.gfb = (CheckBox) view.findViewById(2131755022);
            qVar.fIV = view.findViewById(2131755026);
            qVar.oks = (TextView) view.findViewById(2131756107);
            qVar.okI = (ChattingItemFooter) view.findViewById(2131756106);
            view.setTag(qVar);
        }
        eC(layoutInflater.getContext());
        return view;
    }

    private void eC(Context context) {
        this.ilF = context.getResources().getDimensionPixelSize(2131493199);
        this.ilG = context.getResources().getDimensionPixelSize(2131493030);
    }

    protected final boolean bEy() {
        return false;
    }

    public final void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str) {
        this.onG = aVar2;
        eC(aVar2.nDR.nEl);
        q qVar = (q) aVar;
        for (p pVar : qVar.ilV) {
            if (qVar.ilV.indexOf(pVar) != qVar.ilV.size() - 1) {
                ef.D(pVar.ilI, 1);
            } else {
                ef.D(pVar.ilI, 2);
            }
            qVar.ihk.removeView(pVar.ilI);
        }
        qVar.ilV.clear();
        c dZ = com.tencent.mm.q.a.a.dZ(atVar.field_content);
        String str2 = dZ.bNm;
        if (str2 == null || str2.length() == 0) {
            qVar.oks.setVisibility(8);
        } else {
            qVar.oks.setVisibility(0);
            ad.b(aVar2, qVar.oks, (Object) dl.Pa(str2));
        }
        List list = dZ.cqE;
        int size = list.size();
        if (size == 0) {
            qVar.ihk.setVisibility(8);
            qVar.olD.ilI.setVisibility(8);
            return;
        }
        int size2;
        qVar.ihk.setVisibility(0);
        qVar.olD.ilI.setVisibility(0);
        boolean b = qVar.okI.b(dZ.cou, atVar.field_talker, true);
        LayoutInflater layoutInflater = aVar2.bzo().getLayoutInflater();
        for (size2 = qVar.ilV.size() + 2; size2 < size; size2++) {
            View xp = ef.xp(1);
            if (xp == null) {
                xp = layoutInflater.inflate(2130903301, null);
            }
            qVar.cL(xp);
        }
        if (size > 1) {
            if (b) {
                xp = ef.xp(1);
                if (xp == null) {
                    xp = layoutInflater.inflate(2130903301, null);
                }
                qVar.cL(xp);
            } else {
                xp = ef.xp(2);
                if (xp == null) {
                    xp = layoutInflater.inflate(2130903302, null);
                }
                qVar.cL(xp);
            }
            qVar.olD.ilI.setBackgroundResource(2130839020);
            qVar.olD.ilI.setPadding(this.ilG, this.ilG, this.ilG, this.ilF);
            this.oox = true;
        } else {
            if (b) {
                qVar.olD.ilI.setBackgroundResource(2130839020);
                qVar.olD.ilI.setPadding(this.ilG, this.ilG, this.ilG, this.ilF);
            } else {
                qVar.olD.ilI.setBackgroundResource(2130839022);
                qVar.olD.ilI.setPadding(this.ilG, this.ilG, this.ilG, 0);
            }
            this.oox = false;
        }
        for (size2 = 0; size2 < qVar.ilV.size(); size2++) {
            ((p) qVar.ilV.get(size2)).ilI.setVisibility(8);
        }
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.mm.q.d dVar = (com.tencent.mm.q.d) list.get(i2);
            Object OW;
            dl dlVar;
            if (i2 == 0) {
                TextView textView;
                int i3;
                TextView textView2 = qVar.olD.olG;
                int i4 = size > 1 ? 8 : t.kS(dVar.url) ? 4 : 0;
                textView2.setVisibility(i4);
                qVar.olD.dID.setVisibility(size > 1 ? 8 : 0);
                qVar.olD.grr.setVisibility(size > 1 ? 8 : 0);
                qVar.olD.olF.setVisibility(size > 1 ? 0 : 8);
                qVar.olD.ilM.setVisibility(8);
                qVar.olD.ilN.setVisibility(8);
                if (t.kS(dVar.cqI)) {
                    qVar.olD.olE.setVisibility(8);
                    qVar.olD.ilK.setVisibility(8);
                    qVar.olD.olF.setVisibility(8);
                    qVar.olD.dID.setVisibility(0);
                    qVar.olD.imf.setVisibility(t.kS(dVar.cqK) ? 8 : 0);
                    textView = qVar.olD.imf;
                    i3 = 0;
                    i4 = size > 1 ? this.ilF : 0;
                } else {
                    qVar.olD.olE.setVisibility(0);
                    qVar.olD.ilK.setVisibility(0);
                    str2 = dVar.cqI;
                    ImageView imageView = qVar.olD.ilK;
                    int i5 = atVar.field_type;
                    if (p.GP()) {
                        str2 = p.je(str2);
                    }
                    com.tencent.mm.ae.a.a GL = n.GL();
                    com.tencent.mm.ae.a.a.c.a aVar3 = new com.tencent.mm.ae.a.a.c.a();
                    aVar3.cPL = 2131689814;
                    aVar3.cPs = true;
                    aVar3 = aVar3.aI(oou, oov);
                    aVar3.cPi = new b();
                    aVar3.cPu = r.o(str2, i5, "@T");
                    GL.b(str2, imageView, aVar3.GU(), new a());
                    textView2 = qVar.olD.imf;
                    i4 = (size > 1 || t.kS(dVar.cqK)) ? 8 : 0;
                    textView2.setVisibility(i4);
                    textView = qVar.olD.imf;
                    i3 = 0;
                    i4 = this.ilG;
                }
                textView.setPadding(i3, i4, 0, 0);
                qVar.olD.imf.setText(dVar.cqK);
                qVar.olD.dID.setText(dVar.title);
                qVar.olD.grr.setText(o.F(aVar2.getString(2131232866), dVar.time));
                qVar.olD.olF.setText(dVar.title);
                qVar.olD.olF.setContentDescription(dVar.title);
                if (!(dVar.cqL == 0 || dVar.cqL == 1)) {
                    qVar.olD.olF.setVisibility(4);
                }
                OW = aVar2.OW(dVar.url);
                if (TextUtils.isEmpty(OW)) {
                    dlVar = new dl(atVar, false, i, dVar.url, 6, this.oox, aVar2.bFU(), dZ.bnR, dZ.bnS, dVar.title);
                } else {
                    v.d("MicroMsg.ChattingItemBizFrom", "productId:%s", OW);
                    dlVar = new dl(atVar, false, i, dVar.url, 8, this.oox, aVar2.bFU(), dZ.bnR, dZ.bnS, dVar.title, OW, null, false, true);
                }
                dlVar.lfd = atVar.field_msgSvrId;
                dlVar.lfe = 0;
                qVar.olD.ilI.setTag(dlVar);
                qVar.olD.ilI.setOnClickListener(aVar2.onh.oqh);
                qVar.olD.ilI.setOnLongClickListener(aVar2.onh.oqj);
            } else {
                p pVar2 = (p) qVar.ilV.get(i2 - 1);
                pVar2.dID.setText(dVar.title);
                pVar2.ilM.setVisibility(8);
                pVar2.ilN.setVisibility(8);
                pVar2.dID.setTextColor(aVar2.getResources().getColor(2131689547));
                if (t.kS(dVar.cqI)) {
                    pVar2.ilJ.setVisibility(8);
                } else {
                    pVar2.ilK.setVisibility(0);
                    str2 = dVar.cqI;
                    if (p.GP()) {
                        str2 = p.je(dVar.cqI);
                    }
                    com.tencent.mm.ae.a.a GL2 = n.GL();
                    ImageView imageView2 = pVar2.ilK;
                    com.tencent.mm.ae.a.a.c.a aVar4 = new com.tencent.mm.ae.a.a.c.a();
                    aVar4.cPu = r.o(str2, atVar.field_type, "@S");
                    aVar4.cPs = true;
                    aVar4.cPi = new b();
                    aVar4.cPL = 2131689814;
                    GL2.a(str2, imageView2, aVar4.aI(oow, oow).GU(), new a());
                    if (dVar.cqL == 0 || dVar.cqL == 1) {
                        pVar2.ilJ.setVisibility(0);
                    } else {
                        pVar2.ilJ.setVisibility(8);
                        pVar2.dID.setTextColor(aVar2.getResources().getColor(2131689792));
                    }
                }
                if (!t.kS(dVar.cqK) && dVar.type == 3) {
                    pVar2.olC.setText(dVar.cqK);
                    pVar2.olC.setVisibility(0);
                }
                pVar2.ilI.setVisibility(0);
                OW = aVar2.OW(dVar.url);
                if (TextUtils.isEmpty(OW)) {
                    dlVar = new dl(atVar, false, i, dVar.url, 6, this.oox, aVar2.bFU(), dZ.bnR, dZ.bnS);
                } else {
                    v.d("MicroMsg.ChattingItemBizFrom", "productId:%s", OW);
                    dlVar = new dl(atVar, false, i, dVar.url, 8, this.oox, aVar2.bFU(), dZ.bnR, dZ.bnS, dVar.title, OW, null, false, true);
                }
                dlVar.lfd = atVar.field_msgSvrId;
                dlVar.lfe = i2;
                pVar2.ilI.setTag(dlVar);
                pVar2.ilI.setOnClickListener(aVar2.onh.oqh);
                pVar2.ilI.setOnLongClickListener(aVar2.onh.oqj);
            }
        }
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

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        this.ooz = t.Nh();
        String a;
        com.tencent.mm.model.o.b n;
        switch (menuItem.getItemId()) {
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                a = a(atVar, aVar.nDR.nEl, this.ooy);
                if (!t.kS(a)) {
                    Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                    intent.putExtra("Retr_Msg_content", a);
                    intent.putExtra("Retr_Msg_Type", 2);
                    intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.ooy);
                    intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                    intent.putExtra("Retr_MsgFromScene", 1);
                    a = atVar.field_talker;
                    String fz = com.tencent.mm.model.o.fz(atVar.field_msgSvrId);
                    intent.putExtra("reportSessionId", fz);
                    n = com.tencent.mm.model.o.yx().n(fz, true);
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
                a = a(atVar, aVar.nDR.nEl, 0);
                if (!t.kS(a)) {
                    dy.c(atVar, a, aVar.nDR.nEl);
                    break;
                }
                break;
            case 125:
                a = atVar.field_talker;
                String fz2 = com.tencent.mm.model.o.fz(atVar.field_msgSvrId);
                n = com.tencent.mm.model.o.yx().n(fz2, true);
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
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(a(atVar, aVar.nDR.nEl, this.ooy));
                    if (!(dV == null || dV.type != 5 || dV.url == null)) {
                        v.d("MicroMsg.ChattingItemBizFrom", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), dV.url, Long.valueOf(this.ooz), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                        a = SQLiteDatabase.KeyEmpty;
                        try {
                            a = URLEncoder.encode(dV.url, "UTF-8");
                        } catch (Throwable e) {
                            v.a("MicroMsg.ChattingItemBizFrom", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.g.iuh.h(13378, a, Long.valueOf(this.ooz), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                        break;
                    }
                }
                break;
        }
        return false;
    }

    protected static String a(at atVar, Context context, int i) {
        if (context == null) {
            v.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
            return null;
        } else if (atVar == null) {
            v.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
            return null;
        } else {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                try {
                    c dZ = com.tencent.mm.q.a.a.dZ(atVar.field_content);
                    List list = dZ.cqE;
                    if (list != null && list.size() > 0 && i < list.size()) {
                        com.tencent.mm.q.d dVar = (com.tencent.mm.q.d) list.get(i);
                        com.tencent.mm.q.a.a aVar = new com.tencent.mm.q.a.a();
                        aVar.title = dVar.title;
                        aVar.description = dVar.cqK;
                        aVar.bXP = "view";
                        aVar.type = 5;
                        aVar.url = dVar.url;
                        aVar.bnR = dZ.bnR;
                        aVar.bnS = dZ.bnS;
                        aVar.bNm = dZ.bNm;
                        aVar.thumburl = dVar.cqI;
                        if (t.kS(aVar.thumburl)) {
                            h gQ = com.tencent.mm.u.n.Bo().gQ(atVar.field_talker);
                            if (gQ != null) {
                                aVar.thumburl = gQ.Be();
                            }
                        }
                        return com.tencent.mm.q.a.a.b(aVar);
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.ChattingItemBizFrom", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.ChattingItemBizFrom", "retransmit app msg error : %s", e.getLocalizedMessage());
                }
                return null;
            }
            s.ey(context);
            return null;
        }
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        return false;
    }
}
