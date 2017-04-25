package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.model.y;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    List<WeakReference<a>> eAR = new ArrayList();
    public String eAS = "";
    public LinkedList<String> eAT = new LinkedList();
    public int eAU;
    private int eAV;
    public int eAW;
    private int eAX;
    private int eAY = 60;
    private boolean eAZ = false;
    private ah eBa = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c eBc;

        {
            this.eBc = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
            this.eBc.pG(this.eBc.eAS);
            this.eBc.ZJ();
            return true;
        }
    }, false);
    private ah eBb = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ c eBc;

        {
            this.eBc = r1;
        }

        public final boolean oU() {
            v.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            c cVar = this.eBc;
            v.i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (cVar.eAR != null) {
                for (int i = 0; i < cVar.eAR.size(); i++) {
                    WeakReference weakReference = (WeakReference) cVar.eAR.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.ZN();
                        }
                    }
                }
            }
            this.eBc.ZL();
            return true;
        }
    }, false);

    public interface a {
        void ZN();

        void onSuccess();

        void pF(String str);
    }

    public final void release() {
        ak.vy().b(577, this);
        this.eAT.clear();
        this.eAZ = false;
        this.eAS = "";
        this.eAU = 0;
        this.eAV = 0;
        this.eAW = 0;
        this.eAX = 0;
        ZK();
        ZM();
    }

    public final void a(a aVar) {
        if (this.eAR == null) {
            this.eAR = new ArrayList();
        }
        if (aVar != null) {
            this.eAR.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.eAR != null && aVar != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.eAR.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    private void onSuccess() {
        v.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onSuccess();
                    }
                }
            }
        }
    }

    private void pF(String str) {
        v.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.pF(str);
                    }
                }
            }
        }
    }

    public final boolean isEmpty() {
        if (this.eAT == null || this.eAT.size() == 0) {
            v.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return true;
        } else if (this.eAU < this.eAT.size()) {
            return false;
        } else {
            v.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            return true;
        }
    }

    public final void pG(String str) {
        if (this.eAZ) {
            v.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
        } else if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
        } else {
            v.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id " + str);
            this.eAZ = true;
            this.eAS = str;
            ak.vy().a(new y(this.eAS), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof y) {
                this.eAZ = false;
                v.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.eAS);
                y yVar = (y) kVar;
                this.eAV = yVar.eAV;
                this.eAW = yVar.eAW;
                this.eAX = yVar.eAX;
                if (yVar.eAT != null) {
                    this.eAT.clear();
                    this.eAT.addAll(yVar.eAT);
                    this.eAU = 0;
                }
                onSuccess();
                ZJ();
            }
        } else if (kVar instanceof y) {
            this.eAZ = false;
            v.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.eAS);
            pF(str);
        }
    }

    public final void ZJ() {
        ZK();
        v.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.eAV);
        if (this.eAV <= 0 || TextUtils.isEmpty(this.eAS)) {
            v.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            return;
        }
        this.eBa.ea((long) (this.eAV * BaseReportManager.MAX_READ_COUNT));
        v.i("MicroMsg.CardCodeMgr", "start request code timer!");
    }

    private void ZK() {
        v.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.eBa.btC()) {
            this.eBa.QI();
        }
    }

    public final void ZL() {
        ZM();
        v.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.eAX);
        if (this.eAX > 0) {
            this.eBb.ea((long) (this.eAX * BaseReportManager.MAX_READ_COUNT));
            v.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            return;
        }
        this.eBb.ea((long) (this.eAY * BaseReportManager.MAX_READ_COUNT));
        v.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    }

    public final void ZM() {
        v.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.eBb.btC()) {
            this.eBb.QI();
        }
    }
}
