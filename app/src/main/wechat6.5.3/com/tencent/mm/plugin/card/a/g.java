package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class g implements e {
    private List<WeakReference<a>> eAR = new ArrayList();
    public ArrayList<String> eBo = new ArrayList();
    public ArrayList<String> eBp = new ArrayList();
    public ac eBq = new ac();
    public HashMap<String, Runnable> eBr = new LinkedHashMap();

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int cXv;
        final /* synthetic */ String eBs;
        final /* synthetic */ int eBt = 0;
        final /* synthetic */ int eBu = 0;
        final /* synthetic */ g eBv;

        AnonymousClass1(g gVar, String str, int i, int i2, int i3) {
            this.eBv = gVar;
            this.eBs = str;
            this.cXv = i3;
        }

        public final void run() {
            g.d(this.eBs, this.eBt, this.eBu, this.cXv);
            v.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.eBs + " system.time:" + System.currentTimeMillis());
        }
    }

    public interface a {
        void b(String str, b bVar);

        void be(String str, String str2);

        void pL(String str);
    }

    public static class b {
        public String eBA;
        public String eBw;
        public int eBx = 0;
        public String eBy;
        public int eBz;
    }

    public g() {
        ak.vy().a(907, this);
        this.eBo.clear();
        this.eBp.clear();
        this.eBr.clear();
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

    private void a(String str, b bVar) {
        v.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.eAR != null) {
            if (this.eBo.contains(str) || this.eBp.contains(str)) {
                for (int i = 0; i < this.eAR.size(); i++) {
                    WeakReference weakReference = (WeakReference) this.eAR.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            if (this.eBo.contains(str)) {
                                aVar.b(str, bVar);
                            } else if (this.eBp.contains(str)) {
                                aVar.pL(str);
                            }
                        }
                    }
                }
                return;
            }
            v.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
        }
    }

    private void bd(String str, String str2) {
        v.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.eAR != null) {
            if (!this.eBo.contains(str) || this.eBp.contains(str)) {
                v.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
                return;
            }
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.be(str, str2);
                    }
                }
            }
        }
    }

    private void pJ(String str) {
        v.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.eBo.contains(str) && !this.eBp.contains(str)) {
            this.eBo.remove(str);
            v.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is " + str);
        }
        if (!this.eBo.contains(str) && this.eBp.contains(str)) {
            this.eBp.remove(str);
            Runnable runnable = (Runnable) this.eBr.get(str);
            this.eBr.remove(str);
            this.eBq.removeCallbacks(runnable);
            v.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
            v.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
        }
    }

    private void pK(String str) {
        v.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.eBp.contains(str)) {
            this.eBp.remove(str);
            v.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
        }
        if (this.eBr.containsKey(str)) {
            v.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
            Runnable runnable = (Runnable) this.eBr.get(str);
            this.eBr.remove(str);
            this.eBq.removeCallbacks(runnable);
        }
    }

    public final void v(String str, int i, int i2) {
        v.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        pK(str);
        if (!this.eBo.contains(str)) {
            this.eBo.add(str);
        }
        d(str, i, 1, i2);
    }

    public final void aj(String str, int i) {
        v.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        pK(str);
        this.eBp.add(str);
        Runnable anonymousClass1 = new AnonymousClass1(this, str, 0, 0, i);
        this.eBq.postDelayed(anonymousClass1, (long) (be.getInt(j.sV().z("ShareCard", "UnMarkDelay"), 0) * BaseReportManager.MAX_READ_COUNT));
        this.eBr.put(str, anonymousClass1);
        v.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
    }

    static void d(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            v.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            return;
        }
        v.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        ak.vy().a(new f(str, i, i2, i3), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        f fVar;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof f) {
                fVar = (f) kVar;
                b bVar = new b();
                bVar.eBw = fVar.eBw;
                bVar.eBx = fVar.eBx;
                bVar.eBy = fVar.eBy;
                bVar.eBz = fVar.eBz;
                bVar.eBA = fVar.eBA;
                v.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.eEx);
                v.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.eBw + " mark_succ:" + bVar.eBx + " mark_card_id:" + bVar.eBy + " expire_time:" + bVar.eBz + " pay_qrcode_wording:" + bVar.eBA);
                a(fVar.eEx, bVar);
                pJ(fVar.eEx);
            }
        } else if (kVar instanceof f) {
            fVar = (f) kVar;
            v.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar.eEx);
            bd(fVar.eEx, str);
            pJ(fVar.eEx);
        }
    }
}
