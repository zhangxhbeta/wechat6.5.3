package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.location.ui.h.c;
import com.tencent.mm.plugin.location.ui.impl.TrackPoint;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public final class i implements c, com.tencent.mm.plugin.location.ui.k.a {
    private Context context;
    private String eQR = "";
    private d gUC;
    private ViewGroup gVb;
    private View gVc;
    private h gVd;
    private j gVe;
    private ArrayList<String> gVf;
    private String gVg = "";
    private boolean gVh = false;
    public a gVi;

    public interface a {
        void vQ(String str);
    }

    public i(Context context, ViewGroup viewGroup, View view, String str, d dVar) {
        this.gVb = viewGroup;
        this.gVc = view;
        this.context = context;
        this.gVf = new ArrayList();
        this.eQR = str;
        this.gUC = dVar;
        init();
    }

    private void init() {
        v.d("MicroMsg.ShareHeaderMgr", "init ShareHeaderMgr, roomname=%s", new Object[]{this.eQR});
        this.gVd = new h(this.context, this.gVc, this.eQR);
        this.gVd.gUS = this;
        this.gVe = new j(this.context, this.gVb, this.eQR);
        for (String add : l.awj().vH(this.eQR)) {
            this.gVf.add(add);
        }
    }

    public final void H(ArrayList<String> arrayList) {
        v.d("MicroMsg.ShareHeaderMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        this.gVd.H(arrayList);
        j jVar = this.gVe;
        v.d("MicroMsg.ShareHeaderMsgMgr", "onRefreshMemberList, size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (jVar.gVk.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        it = jVar.gVk.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        if (jVar.gVw) {
            jVar.gVw = false;
            if (arrayList2.size() > 0) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    jVar.gVk.add((String) it2.next());
                }
            }
            jVar.dW(false);
            return;
        }
        if (arrayList2.size() > 0) {
            str = (String) arrayList2.get(0);
            jVar.gVk.add(str);
            if (!be.kS(com.tencent.mm.model.l.er(str))) {
                jVar.mHandler.removeMessages(3);
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = str;
                jVar.mHandler.sendMessage(obtain);
                jVar.dW(true);
            }
        }
        if (arrayList3.size() > 0) {
            str = (String) arrayList3.get(0);
            if (!be.kS(str) && jVar.gVk.indexOf(str) != -1) {
                jVar.gVk.remove(jVar.gVk.indexOf(str));
                if (!be.kS(com.tencent.mm.model.l.er(str))) {
                    obtain = Message.obtain();
                    obtain.what = 4;
                    obtain.obj = str;
                    jVar.mHandler.sendMessage(obtain);
                    jVar.dW(true);
                }
            }
        }
    }

    public final void vQ(String str) {
        if (this.gVi != null) {
            this.gVi.vQ(str);
        }
    }

    public final void awI() {
        v.d("MicroMsg.ShareHeaderMgr", "onMyselfTalking");
        this.gVh = true;
        String xF = k.xF();
        this.gVd.awE();
        this.gVd.vN(xF);
        j jVar = this.gVe;
        v.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfTalking");
        jVar.mHandler.removeMessages(6);
        jVar.mHandler.removeMessages(5);
        Message obtain = Message.obtain();
        obtain.what = 6;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        View viewByItag = this.gUC.getViewByItag(xF);
        if (viewByItag instanceof TrackPoint) {
            viewByItag.bringToFront();
            this.gUC.invalidate();
        }
        this.gVg = xF;
    }

    public final void vR(String str) {
        v.d("MicroMsg.ShareHeaderMgr", "onCurTalkerChange, username = %s", new Object[]{str});
        if (!this.gVh) {
            this.gVg = str;
            h hVar = this.gVd;
            String str2 = this.gVg;
            v.i("MicroMsg.ShareHeaderAvatarViewMgr", "onCurMemberChange, username=%s", new Object[]{str2});
            if (be.kS(str2)) {
                hVar.awE();
            } else {
                hVar.awE();
                hVar.vN(str2);
            }
            j jVar = this.gVe;
            str2 = this.gVg;
            v.d("MicroMsg.ShareHeaderMsgMgr", "onCurMemberChange, curMember=%s", new Object[]{str2});
            if (be.kS(str2)) {
                jVar.gVB = false;
                jVar.mHandler.removeMessages(10);
                Message obtain = Message.obtain();
                obtain.what = 10;
                jVar.mHandler.sendMessage(obtain);
                jVar.dW(true);
            } else {
                if (!be.kS(com.tencent.mm.model.l.er(str2))) {
                    jVar.gVB = true;
                    jVar.mHandler.removeMessages(5);
                    Message obtain2 = Message.obtain();
                    obtain2.what = 5;
                    obtain2.obj = str2;
                    jVar.mHandler.sendMessageAtFrontOfQueue(obtain2);
                }
                jVar.dW(true);
            }
            View viewByItag = this.gUC.getViewByItag(this.gVg);
            if (viewByItag instanceof TrackPoint) {
                viewByItag.bringToFront();
                this.gUC.invalidate();
            }
        }
    }

    public final void awJ() {
        v.i("MicroMsg.ShareHeaderMgr", "onMyselfFinishTalking");
        h hVar = this.gVd;
        String xF = k.xF();
        v.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberFinishTalking, username=%s", new Object[]{xF});
        if (hVar.gUR.vP(xF)) {
            hVar.gUR.vO(xF).awH();
            hVar.gUR.notifyDataSetChanged();
            hVar.gUQ.invalidate();
        }
        j jVar = this.gVe;
        v.d("MicroMsg.ShareHeaderMsgMgr", "onMyselfFinishTalking");
        jVar.mHandler.removeMessages(9);
        jVar.mHandler.removeMessages(10);
        Message obtain = Message.obtain();
        obtain.what = 9;
        jVar.mHandler.sendMessage(obtain);
        this.gVg = "";
        this.gVh = false;
    }

    public final void awK() {
        j jVar = this.gVe;
        v.d("MicroMsg.ShareHeaderMsgMgr", "onPrepareTalking");
        jVar.mHandler.removeMessages(8);
        Message obtain = Message.obtain();
        obtain.what = 8;
        jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
    }

    public final void vS(String str) {
        j jVar = this.gVe;
        v.d("MicroMsg.ShareHeaderMsgMgr", "onTalkConflict, username=%s", new Object[]{str});
        if (!be.kS(str) && !be.kS(com.tencent.mm.model.l.er(str))) {
            jVar.gVB = true;
            jVar.mHandler.removeMessages(7);
            Message obtain = Message.obtain();
            obtain.what = 7;
            jVar.mHandler.sendMessageAtFrontOfQueue(obtain);
        }
    }
}
