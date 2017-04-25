package com.tencent.mm.plugin.notification.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.app.w.d;
import com.tencent.mm.e.a.ip;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.plugin.notification.c.e;
import com.tencent.mm.plugin.notification.ui.FailSendMsgNotification;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class a<T> implements c {
    protected boolean hIA;
    protected ArrayList<Long> hIB;
    protected ArrayList<Long> hIC;
    protected ArrayList<Long> hID;
    private ArrayList<ah> hIE;
    private ah hIF;
    private c hIG;
    public b hIy;
    protected FailSendMsgNotification hIz;
    public Context mContext;

    public abstract String H(int i, int i2, int i3);

    public abstract void K(ArrayList<Long> arrayList);

    public abstract void aEo();

    public abstract long aQ(T t);

    public abstract ArrayList<Long> aR(T t);

    public abstract String ca(int i, int i2);

    public abstract String cb(int i, int i2);

    public abstract void cn(long j);

    public abstract boolean co(long j);

    public abstract int getType();

    public abstract String nG(int i);

    static /* synthetic */ void a(a aVar) {
        v.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, mMsgList.size:%d", new Object[]{Integer.valueOf(aVar.hIy.hIJ.size())});
        aVar.aEg();
        if (VERSION.SDK_INT >= 16) {
            aVar.hIz.xp(aVar.nG(aVar.hIy.hIJ.size()));
        }
        v.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistBeforeResend, after check, mMsgList.size:%d", new Object[]{Integer.valueOf(aVar.hIy.hIJ.size())});
    }

    static /* synthetic */ void a(a aVar, long j) {
        while (!aVar.co(j)) {
            aVar.hIC.add(Long.valueOf(j));
            v.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, msg:%d not exist", new Object[]{Long.valueOf(j)});
            aVar.aEc();
            j = aVar.hIy.aEs();
            if (j == -1) {
                v.e("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg error, finalMsgId is -1, may be resend finish");
                if (aVar.hIB.size() + aVar.hIC.size() >= aVar.hIy.hIJ.size()) {
                    v.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, resend finish");
                    aVar.aEd();
                    return;
                }
                return;
            }
        }
        v.d("MicroMsg.AbstractSendMsgFailNotification", "tryResendNextMsg, finalMsgId:%d", new Object[]{Long.valueOf(j)});
        aVar.cn(j);
        ah ahVar = new ah(new com.tencent.mm.sdk.platformtools.ah.a(aVar) {
            final /* synthetic */ a hIH;

            public final boolean oU() {
                if (!(this.hIH.hIB.contains(Long.valueOf(j)) || this.hIH.hIC.contains(Long.valueOf(j)) || !this.hIH.hIy.cq(j))) {
                    v.i("MicroMsg.AbstractSendMsgFailNotification", "msg:%d send timeout, move this message to fail list, continue send next message", new Object[]{Long.valueOf(j)});
                    this.hIH.hIC.add(Long.valueOf(j));
                    this.hIH.hID.add(Long.valueOf(j));
                    if (this.hIH.hIB.size() + this.hIH.hIC.size() >= this.hIH.hIy.hIJ.size()) {
                        this.hIH.aEd();
                    } else {
                        this.hIH.cm(this.hIH.hIy.aEs());
                    }
                }
                return true;
            }
        }, false);
        ahVar.ea(1800000);
        aVar.hIE.add(ahVar);
    }

    public a() {
        this.hIy = null;
        this.hIz = null;
        this.hIA = false;
        this.mContext = null;
        this.hIB = null;
        this.hIC = null;
        this.hID = null;
        this.hIE = new ArrayList();
        this.hIF = null;
        this.hIG = new c<pq>(this) {
            final /* synthetic */ a hIH;

            {
                this.hIH = r2;
                this.nhz = pq.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                pq pqVar = (pq) bVar;
                a aVar = this.hIH;
                long j = pqVar.bqU.bqV;
                v.i("MicroMsg.AbstractSendMsgFailNotification", "updateMsgIdInMsgList, oldMsgId:%d, newMsgId:%d", new Object[]{Long.valueOf(j), Long.valueOf(pqVar.bqU.bqW)});
                if (aVar.hIy.cq(j)) {
                    b bVar2 = aVar.hIy;
                    int indexOf = bVar2.hIJ.indexOf(Long.valueOf(j));
                    if (indexOf != -1) {
                        bVar2.hIJ.set(indexOf, Long.valueOf(r4));
                    }
                }
                return false;
            }
        };
        this.hIy = new b();
        this.hIz = new FailSendMsgNotification(getType());
        this.hIA = false;
        this.mContext = aa.getContext();
        this.hIB = new ArrayList();
        this.hIC = new ArrayList();
        this.hID = new ArrayList();
        this.hIz.hJs = new com.tencent.mm.plugin.notification.ui.a(this) {
            final /* synthetic */ a hIH;

            {
                this.hIH = r1;
            }

            public final void aEp() {
                v.d("MicroMsg.AbstractSendMsgFailNotification", "onClickResendButton");
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 hII;

                    {
                        this.hII = r1;
                    }

                    public final void run() {
                        g.iuh.h(11425, new Object[]{Integer.valueOf(this.hII.hIH.getType()), Integer.valueOf(3), Integer.valueOf(0), Integer.valueOf(0)});
                        this.hII.hIH.aEm();
                        a.a(this.hII.hIH);
                        this.hII.hIH.aEf();
                    }
                });
            }

            public final void aEq() {
                v.d("MicroMsg.AbstractSendMsgFailNotification", "onClickOmitButton");
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 hII;

                    {
                        this.hII = r1;
                    }

                    public final void run() {
                        g.iuh.h(11425, new Object[]{Integer.valueOf(this.hII.hIH.getType()), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                        this.hII.hIH.aEm();
                        this.hII.hIH.aEi();
                        this.hII.hIH.auH();
                        this.hII.hIH.hIz.dismiss();
                    }
                });
            }
        };
        this.hIz.hJt = new com.tencent.mm.plugin.notification.ui.b(this) {
            final /* synthetic */ a hIH;

            {
                this.hIH = r1;
            }

            public final void aEr() {
                g.iuh.h(11425, new Object[]{Integer.valueOf(this.hIH.getType()), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
                this.hIH.aEm();
                this.hIH.aEo();
                if (!this.hIH.hIA) {
                    this.hIH.hIz.dismiss();
                }
            }
        };
        this.hIz.hJu = new com.tencent.mm.plugin.notification.ui.c(this) {
            final /* synthetic */ a hIH;

            {
                this.hIH = r1;
            }

            public final void onDismiss() {
                this.hIH.auH();
            }
        };
        aEa();
    }

    private void aEa() {
        this.hIF = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ a hIH;

            {
                this.hIH = r1;
            }

            public final boolean oU() {
                if (!this.hIH.hIA) {
                    return false;
                }
                v.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, before check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.hIH.hIy.hIJ.size()), Integer.valueOf(this.hIH.hIB.size()), Integer.valueOf(this.hIH.hIC.size())});
                this.hIH.aEg();
                v.i("MicroMsg.AbstractSendMsgFailNotification", "mCheckMsgExistTimer, after check msgList.size:%d, successList.size:%d, failedList.size:%d", new Object[]{Integer.valueOf(this.hIH.hIy.hIJ.size()), Integer.valueOf(this.hIH.hIB.size()), Integer.valueOf(this.hIH.hIC.size())});
                if (this.hIH.hIy.hIJ.size() > 0) {
                    this.hIH.aEc();
                    return true;
                }
                this.hIH.aEd();
                return true;
            }
        }, true);
    }

    public final void aO(T t) {
        if (t != null) {
            v.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, msgId:%d, msgList:%s, isResending:%b", new Object[]{Long.valueOf(aQ(t)), aEj(), Boolean.valueOf(this.hIA)});
            if (this.hIA) {
                if (this.hIy.cq(aQ(t)) && !this.hIC.contains(Long.valueOf(aQ(t)))) {
                    this.hIC.add(Long.valueOf(aQ(t)));
                }
                if (!this.hIy.cq(aQ(t))) {
                    v.d("MicroMsg.AbstractSendMsgFailNotification", "sending msg, another fail msg");
                    this.hIy.cp(aQ(t));
                }
                aEc();
                v.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgFail, successlist.size:%d, faillist.size:%d", new Object[]{Integer.valueOf(this.hIB.size()), Integer.valueOf(this.hIC.size())});
                if (this.hIB.size() + this.hIC.size() < this.hIy.hIJ.size()) {
                    long aEs = this.hIy.aEs();
                    if (aEs == -1) {
                        v.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    v.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[]{Long.valueOf(aEs)});
                    aEn();
                    cm(aEs);
                    return;
                }
                aEd();
            } else if (this.hID.contains(Long.valueOf(aQ(t)))) {
                this.hID.remove(Long.valueOf(aQ(t)));
            } else if (t == null) {
                v.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgObj is null");
            } else {
                Collection aR = aR(t);
                if (aR == null || aR.size() <= 0) {
                    v.e("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, cannot get history fail msg");
                    return;
                }
                auH();
                b bVar = this.hIy;
                if (aR != null && aR.size() > 0) {
                    bVar.hIJ.addAll(aR);
                }
                aEn();
                v.d("MicroMsg.AbstractSendMsgFailNotification", "showNotificationAfterSendFail, msgList.size:%d, msgList:%s", new Object[]{Integer.valueOf(this.hIy.hIJ.size()), aEj()});
                g.iuh.h(11426, new Object[]{Integer.valueOf(getType())});
                ad.g(new Runnable(this) {
                    final /* synthetic */ a hIH;

                    {
                        this.hIH = r1;
                    }

                    public final void run() {
                        this.hIH.aEb();
                    }
                }, 1000);
            }
        }
    }

    private void aEb() {
        v.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, isInForeground:%b", new Object[]{Boolean.valueOf(e.aEz())});
        this.hIz.hJw = nG(this.hIy.hIJ.size());
        this.hIz.aEE();
        if (!e.aEz() && !this.hIz.hJB) {
            this.hIz.hJv = nG(this.hIy.hIJ.size());
            this.hIz.aED();
            this.hIz.aEC();
            v.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, first show notification");
            this.hIz.show();
            com.tencent.mm.sdk.c.a.nhr.f(this.hIG);
            com.tencent.mm.sdk.c.a.nhr.e(this.hIG);
        } else if (this.hIz.hJB) {
            this.hIz.aED();
            this.hIz.aEC();
            v.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, update notification content text");
            this.hIz.xp(nG(this.hIy.hIJ.size()));
            com.tencent.mm.sdk.c.a.nhr.f(this.hIG);
            com.tencent.mm.sdk.c.a.nhr.e(this.hIG);
        } else {
            v.d("MicroMsg.AbstractSendMsgFailNotification", "showInitNotification, not show or update notification, isForeground:%b", new Object[]{Boolean.valueOf(e.aEz())});
        }
    }

    public final void aP(T t) {
        v.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSucess, msgId:%d, msgList:%s", new Object[]{Long.valueOf(aQ(t)), aEj()});
        if (this.hIy.cq(aQ(t))) {
            long aQ = aQ(t);
            if (this.hID.contains(Long.valueOf(aQ)) && this.hIC.contains(Long.valueOf(aQ))) {
                v.i("MicroMsg.AbstractSendMsgFailNotification", "receive send msg success event from a timout message, remvoe it from the fail list");
                this.hID.remove(Long.valueOf(aQ));
                this.hIC.remove(Long.valueOf(aQ));
            }
            if (this.hIA) {
                this.hIB.add(Long.valueOf(aQ));
                aEc();
                v.d("MicroMsg.AbstractSendMsgFailNotification", "processSendMsgSuccess, successlist.size:%d, faillist.size:%d", new Object[]{Integer.valueOf(this.hIB.size()), Integer.valueOf(this.hIC.size())});
                if (this.hIB.size() + this.hIC.size() < this.hIy.hIJ.size()) {
                    aQ = this.hIy.aEs();
                    if (aQ == -1) {
                        v.e("TAG", "resend error, next msg id is -1");
                        return;
                    }
                    v.d("MicroMsg.AbstractSendMsgFailNotification", "continue resend, nextId:%d", new Object[]{Long.valueOf(aQ)});
                    aEn();
                    cm(aQ);
                    return;
                }
                aEd();
                return;
            }
            this.hIy.remove(aQ(t));
            if (this.hIy.hIJ.size() == 0) {
                this.hIz.dismiss();
                auH();
                com.tencent.mm.plugin.notification.c.a.nI(getType());
                return;
            }
            v.d("MicroMsg.AbstractSendMsgFailNotification", "maybe the user manually resend the message, update init wording");
            this.hIz.xp(nG(this.hIy.hIJ.size()));
        }
    }

    private void aEc() {
        if (VERSION.SDK_INT >= 16) {
            this.hIz.hJw = nG(this.hIy.hIJ.size());
            if (this.hIC.size() <= 0) {
                this.hIz.xp(ca(this.hIy.hIJ.size(), this.hIB.size() + this.hIC.size()));
            } else {
                this.hIz.xp(H(this.hIy.hIJ.size(), this.hIB.size() + this.hIC.size(), this.hIC.size()));
            }
        }
    }

    private void aEd() {
        this.hIA = false;
        v.d("MicroMsg.AbstractSendMsgFailNotification", "finish resend, msgList.size:%d, mFailList.size:%d, mSuccessList.size:%d", new Object[]{Integer.valueOf(this.hIy.hIJ.size()), Integer.valueOf(this.hIC.size()), Integer.valueOf(this.hIB.size())});
        v.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, before check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[]{Integer.valueOf(this.hIy.hIJ.size()), Integer.valueOf(this.hIB.size()), Integer.valueOf(this.hIC.size())});
        aEg();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.hIB.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            if (!co(l.longValue())) {
                arrayList.add(l);
            }
        }
        it = arrayList.iterator();
        while (it.hasNext()) {
            this.hIB.remove((Long) it.next());
        }
        arrayList.clear();
        it = this.hIC.iterator();
        while (it.hasNext()) {
            l = (Long) it.next();
            if (!co(l.longValue())) {
                arrayList.add(l);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.hIC.remove((Long) it2.next());
        }
        v.d("MicroMsg.AbstractSendMsgFailNotification", "checkMsgExistAfterResend, after check, mMsgList.size:%d, mSuccessList.size:%d, mFailList.size:%d", new Object[]{Integer.valueOf(this.hIy.hIJ.size()), Integer.valueOf(this.hIB.size()), Integer.valueOf(this.hIC.size())});
        if (this.hIC.size() <= 0 || VERSION.SDK_INT < 16) {
            com.tencent.mm.plugin.notification.c.a.nI(getType());
        }
        g.iuh.h(11425, new Object[]{Integer.valueOf(getType()), Integer.valueOf(0), Integer.valueOf(this.hIB.size()), Integer.valueOf(this.hIC.size())});
        if (VERSION.SDK_INT >= 16) {
            this.hIz.aED();
            this.hIz.hJw = nG(this.hIy.hIJ.size());
            FailSendMsgNotification failSendMsgNotification = this.hIz;
            this.hIy.hIJ.size();
            failSendMsgNotification.xp(cb(this.hIB.size(), this.hIC.size()));
            this.hIz.aEC();
            if (this.hIC.size() > 0) {
                this.hIz.aEE();
                this.hIz.show();
                aEl();
                aEn();
            }
        }
        ip ipVar = new ip();
        ipVar.bjc.type = getType();
        com.tencent.mm.sdk.c.a.nhr.z(ipVar);
        if (this.hIF != null) {
            this.hIF.QI();
        } else {
            v.e("MicroMsg.AbstractSendMsgFailNotification", "stopCheckMsgExistTimer error, timer is null");
        }
        aEh();
        com.tencent.mm.sdk.c.a.nhr.f(this.hIG);
        aEe();
    }

    public void aEe() {
    }

    public final void aEf() {
        v.d("MicroMsg.AbstractSendMsgFailNotification", "resendAllMsg, mMsgList.size:%d", new Object[]{Integer.valueOf(this.hIy.hIJ.size())});
        this.hIA = true;
        if (VERSION.SDK_INT >= 16) {
            FailSendMsgNotification failSendMsgNotification = this.hIz;
            failSendMsgNotification.hJD = false;
            failSendMsgNotification.hJp = new d(failSendMsgNotification.mContext);
            failSendMsgNotification.aEB();
            failSendMsgNotification.show();
            v.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, removeActionButton");
            failSendMsgNotification = this.hIz;
            failSendMsgNotification.hJp.j(2, true);
            failSendMsgNotification.hJC = true;
            failSendMsgNotification.show();
            v.d("MicroMsg.FailSendMsgNotification", "FailSendMsgNotification, setLockInNotificationBar");
            this.hIz.xp(ca(this.hIy.hIJ.size(), 0));
        }
        this.hIy.currentIndex = 0;
        aEh();
        com.tencent.mm.sdk.c.a.nhr.f(this.hIG);
        com.tencent.mm.sdk.c.a.nhr.e(this.hIG);
        cm(this.hIy.aEs());
        if (this.hIF != null) {
            this.hIF.ea(300000);
        } else {
            v.e("MicroMsg.AbstractSendMsgFailNotification", "startCheckMsgExistTimer error, timer is null");
        }
    }

    void aEg() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.hIy.hIJ.size(); i++) {
            long j = this.hIy.get(i);
            if (!co(j)) {
                arrayList.add(Long.valueOf(j));
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.hIy.remove(((Long) it.next()).longValue());
            }
        }
    }

    final void cm(final long j) {
        ad.g(new Runnable(this) {
            final /* synthetic */ a hIH;

            public final void run() {
                a.a(this.hIH, j);
            }
        }, 200);
    }

    private void aEh() {
        Iterator it = this.hIE.iterator();
        while (it.hasNext()) {
            ((ah) it.next()).QI();
        }
        this.hIE.clear();
        this.hID.clear();
    }

    public final void aEi() {
        v.d("MicroMsg.AbstractSendMsgFailNotification", "omitFailMsg, size:%d", new Object[]{Integer.valueOf(this.hIy.hIJ.size())});
        if (this.hIy.hIJ.size() > 0) {
            b bVar = this.hIy;
            ArrayList arrayList = new ArrayList();
            Iterator it = bVar.hIJ.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Long) it.next()).longValue()));
            }
            K(arrayList);
        }
    }

    private void auH() {
        this.hIy.clear();
        this.hIA = false;
        this.hIB.clear();
        this.hIC.clear();
        aEh();
    }

    private String aEj() {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < this.hIy.hIJ.size(); i++) {
            stringBuilder.append(this.hIy.get(i) + ", ");
        }
        return stringBuilder.toString();
    }

    public final FailSendMsgNotification aEk() {
        return this.hIz;
    }

    private void aEl() {
        this.hIy.currentIndex = 0;
        if (this.hIB.size() > 0) {
            Iterator it = this.hIB.iterator();
            while (it.hasNext()) {
                this.hIy.remove(((Long) it.next()).longValue());
            }
        }
        this.hIB.clear();
        this.hIC.clear();
    }

    protected final void aEm() {
        if (this.hIy == null || this.hIy.hIJ.size() == 0) {
            v.d("MicroMsg.AbstractSendMsgFailNotification", "autoResumeFromCrash");
            com.tencent.mm.plugin.notification.c.a.a nH = com.tencent.mm.plugin.notification.c.a.nH(getType());
            if (nH == null) {
                v.e("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, cacheObj is null");
                return;
            }
            if (this.hIF == null) {
                aEa();
            }
            b bVar = nH.hIL;
            Collection collection = nH.hIN;
            Collection collection2 = nH.hIO;
            int i = nH.hIM;
            if (collection.size() == 0 && collection2.size() == 0 && i == 0) {
                v.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, not start resend");
                this.hIy.clear();
                this.hIy = bVar;
                this.hIB.clear();
                this.hIC.clear();
                aEb();
            } else if (collection.size() + collection2.size() >= bVar.hIJ.size()) {
                v.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, resendFinish");
                aEd();
            } else {
                v.d("MicroMsg.AbstractSendMsgFailNotification", "resetNotificationAfterCrash, currently resending");
                this.hIy.clear();
                this.hIy = bVar;
                this.hIy.currentIndex = i;
                this.hIB.clear();
                this.hIB.addAll(collection);
                this.hIC.clear();
                this.hIC.addAll(collection2);
                aEc();
            }
        }
    }

    private void aEn() {
        com.tencent.mm.plugin.notification.c.a.a(getType(), new com.tencent.mm.plugin.notification.c.a.a(this.hIy, this.hIy.currentIndex, this.hIB, this.hIC));
    }
}
