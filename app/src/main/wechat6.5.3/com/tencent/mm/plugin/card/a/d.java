package com.tencent.mm.plugin.card.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements com.tencent.mm.plugin.card.a.i.a, com.tencent.mm.plugin.card.base.d, e {
    public WeakReference<Context> adL;
    public List<WeakReference<a>> eAR = new ArrayList();
    public HashMap<a, Boolean> eBd = new HashMap();
    public HashMap<String, Boolean> eBe = new HashMap();
    public HashMap<String, Boolean> eBf = new HashMap();
    public b eBg = null;
    public boolean eBh = false;
    public String eBi;

    public interface a {
        void ZS();

        void ZT();

        void f(b bVar);

        void pI(String str);
    }

    public final void release() {
        ak.vy().b(910, this);
        af.aar().b(this);
        b aaj = af.aaj();
        if (aaj.eAR != null && this != null) {
            for (int i = 0; i < aaj.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) aaj.eAR.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.base.d dVar = (com.tencent.mm.plugin.card.base.d) weakReference.get();
                    if (dVar != null && dVar.equals(this)) {
                        aaj.eAR.remove(weakReference);
                        break;
                    }
                }
            }
        }
        this.eAR.clear();
        this.eBd.clear();
        this.eBf.clear();
        this.eBh = false;
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

    public final void d(b bVar) {
        this.eBg = bVar;
        if (!(!this.eBh || this.eBg == null || bVar.Zz() == null || bVar.Zz().equals(this.eBg.Zz()))) {
            this.eBh = false;
        }
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.eBd.get(aVar);
                    if (!(aVar == null || bool == null || bool.booleanValue())) {
                        aVar.f(bVar);
                    }
                }
            }
        }
    }

    public final void a(a aVar, boolean z) {
        if (this.eBd == null) {
            this.eBd = new HashMap();
        }
        this.eBd.put(aVar, Boolean.valueOf(z));
    }

    public final void c(a aVar) {
        if (this.eBd == null) {
            this.eBd = new HashMap();
        }
        this.eBd.remove(aVar);
    }

    public final void ZG() {
        v.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.eBg == null) {
            v.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            return;
        }
        if (this.eBg.Zb()) {
            b qc = af.aas().qc(this.eBg.Zz());
        } else {
            Object pQ = af.aak().pQ(this.eBg.Zz());
        }
        if (qc != null && qc.Zw() != null && this.eBg != null && this.eBg.Zw() != null) {
            v.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[]{Integer.valueOf(this.eBg.Zw().status), Integer.valueOf(qc.Zw().status), Boolean.valueOf(this.eBh), Boolean.valueOf(this.eBg.Zb())});
            if (this.eBg.Zb()) {
                v.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[]{Integer.valueOf(((ShareCardInfo) this.eBg).field_status)});
            }
            if (qc.Zw().status != r2) {
                ZO();
                if (this.eBg.Zb() && !this.eBh && qc.Zw().status == 1) {
                    v.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.eBe.get(this.eBg.Zz());
                    if (bool == null || !bool.booleanValue()) {
                        v.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.adL.get();
                        v.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.eBg.Zz());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.eBg);
                        this.eBe.put(this.eBg.Zz(), Boolean.valueOf(true));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(281);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(281);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((int) (currentTimeMillis2 - currentTimeMillis));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        g gVar = g.iuh;
                        g.d(arrayList, true);
                    } else {
                        v.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    ZQ();
                } else if (this.eBg.Zb() && this.eBh) {
                    v.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    v.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    ZP();
                }
                v.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.eBg = qc;
            e(this.eBg);
        }
    }

    public final void Yj() {
        ZO();
    }

    public final void a(com.tencent.mm.plugin.card.model.g gVar) {
        v.i("MicroMsg.CardConsumedMgr", "onChange()");
        v.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.eBg == null) {
            v.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            ZP();
            return;
        }
        v.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.eBg.Za() && gVar.field_card_id != null && gVar.field_card_id.equals(this.eBg.Zz()) && gVar.eCV == 3) {
            v.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            ZP();
        } else if (!this.eBg.Zb()) {
            v.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            ZP();
        } else if (gVar.eCV == 3 || !(gVar.field_card_id == null || !gVar.field_card_id.equals(this.eBg.Zz()) || TextUtils.isEmpty(gVar.field_consumed_box_id))) {
            long currentTimeMillis = System.currentTimeMillis();
            v.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
            iu Zw;
            if (gVar.field_card_id != null && gVar.field_card_id.equals(this.eBg.Zz())) {
                b qc = af.aas().qc(this.eBg.Zz());
                if (!(qc == null || qc.Zw() == null)) {
                    int i = this.eBg.Zw().status;
                    v.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[]{Integer.valueOf(i), Integer.valueOf(qc.Zw().status), Integer.valueOf(((ShareCardInfo) this.eBg).field_status)});
                    if (qc.Zw().status != i) {
                        ZO();
                    } else if (i != 1) {
                        v.i("MicroMsg.CardConsumedMgr", "share card oldState status is " + i);
                        Zw = this.eBg.Zw();
                        Zw.status = 1;
                        ((ShareCardInfo) this.eBg).field_status = 1;
                        this.eBg.a(Zw);
                        j.g(this.eBg);
                    }
                }
            } else if (gVar.field_card_id != null) {
                b qc2 = af.aas().qc(gVar.field_card_id);
                if (qc2 == null || qc2.Zw() == null) {
                    v.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                } else {
                    v.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[]{Integer.valueOf(qc2.Zw().status), Integer.valueOf(qc2.field_status)});
                    if (qc2.Zw().status != 1) {
                        Zw = qc2.Zw();
                        Zw.status = 1;
                        qc2.field_status = 1;
                        qc2.a(Zw);
                        j.g(qc2);
                    }
                }
            }
            e(this.eBg);
            Boolean bool = (Boolean) this.eBe.get(this.eBg.Zz());
            if (bool == null || !bool.booleanValue()) {
                Context context = (Context) this.adL.get();
                v.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.eBg.Zz());
                com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.eBg);
                this.eBe.put(this.eBg.Zz(), Boolean.valueOf(true));
                long currentTimeMillis2 = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(281);
                iDKey.SetKey(30);
                iDKey.SetValue(1);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(281);
                iDKey2.SetKey(31);
                iDKey2.SetValue((int) (currentTimeMillis2 - currentTimeMillis));
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g gVar2 = g.iuh;
                g.d(arrayList, true);
            } else {
                v.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
            }
            ZQ();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (TextUtils.isEmpty(dVar.eDn)) {
                    v.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    pH(dVar.eDn);
                }
                this.eBh = false;
                v.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                ZP();
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.eBh = false;
            v.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            ZP();
        }
    }

    private void pH(String str) {
        v.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.eAR != null) {
            int i = 0;
            boolean z = false;
            while (i < this.eAR.size()) {
                boolean z2;
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.eBd.get(aVar);
                    if (!(aVar == null || bool == null || !bool.booleanValue())) {
                        aVar.pI(str);
                        z2 = true;
                        i++;
                        z = z2;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            }
            Boolean bool2 = (Boolean) this.eBe.get(this.eBg.Zz());
            if (z) {
                v.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
                this.eBi = "";
            } else if (bool2 != null && bool2.booleanValue()) {
                v.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
                this.eBi = str;
                this.eBf.put(this.eBg.Zz(), Boolean.valueOf(true));
            }
        }
    }

    private void e(b bVar) {
        v.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.f(bVar);
                    }
                }
            }
        }
    }

    private void ZO() {
        v.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.ZS();
                    }
                }
            }
        }
    }

    private void ZP() {
        v.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.ZT();
                    }
                }
            }
        }
    }

    private void ZQ() {
        v.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        ZR();
    }

    private synchronized void ZR() {
        if (this.eBh) {
            v.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
        } else {
            v.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.eBh = true;
            ak.vy().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.eBg.Zz(), "", ""), 0);
        }
    }
}
