package com.tencent.mm.plugin.sns.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;

public class d {
    public c jqE;
    HandlerThread jqF;
    private String mName;

    public static class a {
        private d jqG;
        private long jqH;
        private int jqI;
        private String jqJ;
        private a jqK;
        private a jqL;
        private a jqM;

        a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            a(dVar, message, str, aVar, aVar2, aVar3);
        }

        public final void a(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            this.jqG = dVar;
            this.jqH = System.currentTimeMillis();
            this.jqI = message != null ? message.what : 0;
            this.jqJ = str;
            this.jqK = aVar;
            this.jqL = aVar2;
            this.jqM = aVar3;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("time=");
            Calendar.getInstance().setTimeInMillis(this.jqH);
            stringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[]{r0, r0, r0, r0, r0, r0}));
            stringBuilder.append(" processed=");
            stringBuilder.append(this.jqK == null ? "<null>" : this.jqK.getName());
            stringBuilder.append(" org=");
            stringBuilder.append(this.jqL == null ? "<null>" : this.jqL.getName());
            stringBuilder.append(" dest=");
            stringBuilder.append(this.jqM == null ? "<null>" : this.jqM.getName());
            stringBuilder.append(" what=");
            Object obj = this.jqG != null ? null : "";
            if (TextUtils.isEmpty(obj)) {
                stringBuilder.append(this.jqI);
                stringBuilder.append("(0x");
                stringBuilder.append(Integer.toHexString(this.jqI));
                stringBuilder.append(")");
            } else {
                stringBuilder.append(obj);
            }
            if (!TextUtils.isEmpty(this.jqJ)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.jqJ);
            }
            return stringBuilder.toString();
        }
    }

    private static class b {
        private Vector<a> jqN;
        private int jqO;
        private int jqP;
        private boolean jqQ;
        private int mCount;

        private b() {
            this.jqN = new Vector();
            this.jqO = 20;
            this.jqP = 0;
            this.mCount = 0;
            this.jqQ = false;
        }

        final synchronized boolean aTr() {
            return this.jqQ;
        }

        final synchronized void OE() {
            this.jqN.clear();
        }

        final synchronized void b(d dVar, Message message, String str, a aVar, a aVar2, a aVar3) {
            this.mCount++;
            if (this.jqN.size() < this.jqO) {
                this.jqN.add(new a(dVar, message, str, aVar, aVar2, aVar3));
            } else {
                a aVar4 = (a) this.jqN.get(this.jqP);
                this.jqP++;
                if (this.jqP >= this.jqO) {
                    this.jqP = 0;
                }
                aVar4.a(dVar, message, str, aVar, aVar2, aVar3);
            }
        }
    }

    private static class c extends Handler {
        private static final Object jqT = new Object();
        private d jqG;
        private boolean jqR;
        private boolean jqS;
        private Message jqU;
        private b jqV;
        private boolean jqW;
        private c[] jqX;
        private int jqY;
        private c[] jqZ;
        private int jra;
        private a jrb;
        private b jrc;
        private HashMap<c, c> jrd;
        private c jre;
        private c jrf;
        private ArrayList<Message> jrg;

        private class c {
            boolean aWr;
            final /* synthetic */ c jrh;
            c jri;
            c jrj;

            private c(c cVar) {
                this.jrh = cVar;
            }

            public final String toString() {
                return "state=" + this.jri.getName() + ",active=" + this.aWr + ",parent=" + (this.jrj == null ? "null" : this.jrj.jri.getName());
            }
        }

        private class a extends c {
            final /* synthetic */ c jrh;

            private a(c cVar) {
                this.jrh = cVar;
            }

            public final boolean i(Message message) {
                this.jrh.jqG;
                return true;
            }
        }

        private class b extends c {
            final /* synthetic */ c jrh;

            private b(c cVar) {
                this.jrh = cVar;
            }

            public final boolean i(Message message) {
                return false;
            }
        }

        public static /* synthetic */ void b(c cVar) {
            int i = 0;
            for (c cVar2 : cVar.jrd.values()) {
                int i2 = 0;
                c cVar3;
                while (cVar3 != null) {
                    cVar3 = cVar3.jrj;
                    i2++;
                }
                if (i >= i2) {
                    i2 = i;
                }
                i = i2;
            }
            if (cVar.jqS) {
                cVar.jqX = new c[i];
                cVar.jqZ = new c[i];
                cVar.aTu();
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, jqT));
            } else {
                cVar.jqX = new c[i];
                cVar.jqZ = new c[i];
                cVar.aTu();
                cVar.sendMessageAtFrontOfQueue(cVar.obtainMessage(-2, jqT));
            }
        }

        public static /* synthetic */ void b(c cVar, c cVar2) {
            if (cVar.jqS) {
                new StringBuilder("setInitialState: initialState=").append(cVar2.getName());
            }
            cVar.jre = cVar2;
        }

        public final void handleMessage(Message message) {
            if (!this.jqR) {
                if (this.jqS) {
                    new StringBuilder("handleMessage: E msg.what=").append(message.what);
                }
                this.jqU = message;
                c cVar = null;
                if (this.jqW) {
                    cVar = j(message);
                } else if (!this.jqW && this.jqU.what == -2 && this.jqU.obj == jqT) {
                    this.jqW = true;
                    qs(0);
                } else {
                    throw new RuntimeException("StateMachine.handleMessage: The start method not called, received msg: " + message);
                }
                a(cVar, message);
            }
        }

        private void a(c cVar, Message message) {
            b bVar;
            a aVar = this.jqX[this.jqY].jri;
            boolean z = message.obj != jqT;
            if (this.jqV.aTr()) {
                if (this.jrf != null) {
                    this.jqV.b(this.jqG, this.jqU, "", cVar, aVar, this.jrf);
                }
            } else if (z) {
                this.jqV.b(this.jqG, this.jqU, "", cVar, aVar, this.jrf);
            }
            c cVar2 = this.jrf;
            c cVar3;
            if (cVar2 != null) {
                bVar = cVar2;
                while (true) {
                    this.jra = 0;
                    c cVar4 = (c) this.jrd.get(bVar);
                    do {
                        c[] cVarArr = this.jqZ;
                        int i = this.jra;
                        this.jra = i + 1;
                        cVarArr[i] = cVar4;
                        cVar4 = cVar4.jrj;
                        if (cVar4 == null) {
                            break;
                        }
                    } while (!cVar4.aWr);
                    if (this.jqS) {
                        new StringBuilder("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=").append(this.jra).append(",curStateInfo: ").append(cVar4);
                    }
                    a(cVar4);
                    qs(aTt());
                    aTs();
                    if (bVar == this.jrf) {
                        break;
                    }
                    cVar3 = this.jrf;
                }
                this.jrf = null;
            } else {
                cVar3 = cVar2;
            }
            if (bVar != null && bVar == this.jrc) {
                if (this.jqG.jqF != null) {
                    getLooper().quit();
                    this.jqG.jqF = null;
                }
                this.jqG.jqE = null;
                this.jqG = null;
                this.jqU = null;
                this.jqV.OE();
                this.jqX = null;
                this.jqZ = null;
                this.jrd.clear();
                this.jre = null;
                this.jrf = null;
                this.jrg.clear();
                this.jqR = true;
            }
        }

        private final c j(Message message) {
            c cVar = this.jqX[this.jqY];
            if (this.jqS) {
                new StringBuilder("processMsg: ").append(cVar.jri.getName());
            }
            Object obj = (message.what == -1 && message.obj == jqT) ? 1 : null;
            if (obj != null) {
                a(this.jrc);
            } else {
                while (!cVar.jri.i(message)) {
                    cVar = cVar.jrj;
                    if (cVar == null) {
                        if (this.jqG.jqE.jqS) {
                            new StringBuilder(" - unhandledMessage: msg.what=").append(message.what);
                        }
                    } else if (this.jqS) {
                        new StringBuilder("processMsg: ").append(cVar.jri.getName());
                    }
                }
            }
            if (cVar != null) {
                return cVar.jri;
            }
            return null;
        }

        private final void a(c cVar) {
            while (this.jqY >= 0 && this.jqX[this.jqY] != cVar) {
                c cVar2 = this.jqX[this.jqY].jri;
                if (this.jqS) {
                    new StringBuilder("invokeExitMethods: ").append(cVar2.getName());
                }
                cVar2.exit();
                this.jqX[this.jqY].aWr = false;
                this.jqY--;
            }
        }

        private final void qs(int i) {
            while (i <= this.jqY) {
                if (this.jqS) {
                    new StringBuilder("invokeEnterMethods: ").append(this.jqX[i].jri.getName());
                }
                this.jqX[i].jri.enter();
                this.jqX[i].aWr = true;
                i++;
            }
        }

        private final void aTs() {
            for (int size = this.jrg.size() - 1; size >= 0; size--) {
                Message message = (Message) this.jrg.get(size);
                if (this.jqS) {
                    new StringBuilder("moveDeferredMessageAtFrontOfQueue; what=").append(message.what);
                }
                sendMessageAtFrontOfQueue(message);
            }
            this.jrg.clear();
        }

        private final int aTt() {
            int i = this.jqY + 1;
            int i2 = i;
            for (int i3 = this.jra - 1; i3 >= 0; i3--) {
                if (this.jqS) {
                    new StringBuilder("moveTempStackToStateStack: i=").append(i3).append(",j=").append(i2);
                }
                this.jqX[i2] = this.jqZ[i3];
                i2++;
            }
            this.jqY = i2 - 1;
            if (this.jqS) {
                new StringBuilder("moveTempStackToStateStack: X mStateStackTop=").append(this.jqY).append(",startingIndex=").append(i).append(",Top=").append(this.jqX[this.jqY].jri.getName());
            }
            return i;
        }

        private final void aTu() {
            if (this.jqS) {
                new StringBuilder("setupInitialStateStack: E mInitialState=").append(this.jre.getName());
            }
            c cVar = (c) this.jrd.get(this.jre);
            this.jra = 0;
            while (cVar != null) {
                this.jqZ[this.jra] = cVar;
                cVar = cVar.jrj;
                this.jra++;
            }
            this.jqY = -1;
            aTt();
        }

        private final c a(c cVar, c cVar2) {
            if (this.jqS) {
                new StringBuilder("addStateInternal: E state=").append(cVar.getName()).append(",parent=");
            }
            c cVar3 = (c) this.jrd.get(cVar);
            if (cVar3 == null) {
                cVar3 = new c();
                this.jrd.put(cVar, cVar3);
            }
            if (cVar3.jrj == null || cVar3.jrj == null) {
                cVar3.jri = cVar;
                cVar3.jrj = null;
                cVar3.aWr = false;
                if (this.jqS) {
                    new StringBuilder("addStateInternal: X stateInfo: ").append(cVar3);
                }
                return cVar3;
            }
            throw new RuntimeException("state already added");
        }

        private c(Looper looper, d dVar) {
            super(looper);
            this.jqR = false;
            this.jqS = false;
            this.jqV = new b();
            this.jqY = -1;
            this.jrb = new a();
            this.jrc = new b();
            this.jrd = new HashMap();
            this.jrg = new ArrayList();
            this.jqG = dVar;
            a(this.jrb, null);
            a(this.jrc, null);
        }

        private final void a(a aVar) {
            this.jrf = (c) aVar;
            if (this.jqS) {
                new StringBuilder("transitionTo: destState=").append(this.jrf.getName());
            }
        }
    }

    public d(String str, Looper looper) {
        this.mName = str;
        this.jqE = new c(looper, this);
    }

    public final void a(c cVar) {
        this.jqE.a(cVar, null);
    }

    public final void a(a aVar) {
        this.jqE.a(aVar);
    }

    public final void qr(int i) {
        c cVar = this.jqE;
        if (cVar != null) {
            cVar.sendMessage(Message.obtain(this.jqE, i));
        }
    }
}
