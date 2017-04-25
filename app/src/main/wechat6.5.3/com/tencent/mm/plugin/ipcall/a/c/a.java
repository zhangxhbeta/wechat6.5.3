package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.beh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    public v2protocal gGO = new v2protocal(this.gGP);
    private ac gGP = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ a gGU;

        public final void handleMessage(Message message) {
            if (message == null || message.what != 59998) {
                super.handleMessage(message);
                return;
            }
            v.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
            a aVar;
            switch (message.arg1) {
                case 3:
                    v.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                    return;
                case 4:
                    v.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                    aVar = this.gGU;
                    v.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                    if (aVar.gGT != null) {
                        aVar.gGT.atP();
                        return;
                    }
                    return;
                case 5:
                    v.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        v.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                        a.a(this.gGU, 34);
                        return;
                    } else if (message.arg2 == 1) {
                        v.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                        a.a(this.gGU, 20);
                        return;
                    } else if (message.arg2 == 5) {
                        v.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                        a.a(this.gGU, 30);
                        return;
                    } else {
                        return;
                    }
                case 6:
                    aVar = this.gGU;
                    v.d("MicroMsg.IPCallEngineManager", "channel connect!");
                    if (aVar.gGR) {
                        v.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                        return;
                    }
                    v.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[]{Integer.valueOf(aVar.gGO.startEngine())});
                    if (aVar.gGO.startEngine() == 0) {
                        aVar.gGO.kwg = 0;
                    } else {
                        aVar.gGO.kwg = 1;
                    }
                    aVar.gGO.setInactive();
                    aVar.gGR = true;
                    if (aVar.gGT != null) {
                        aVar.gGT.atQ();
                        return;
                    }
                    return;
                case 9:
                    v.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                    return;
                case 10:
                    v.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                    v.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                    g aum = i.aum();
                    v.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                    if (aum.blA) {
                        v.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                        return;
                    }
                    aum.gFc = true;
                    if (aum.gFa != null) {
                        aum.gFa.gFQ = 2;
                        ak.vy().a(new l(aum.gFa.gFG, aum.gFa.gFH, aum.gFa.auB(), aum.gFa.gFI, true), 0);
                    }
                    aum.lX(2);
                    return;
                default:
                    return;
            }
        }
    };
    private boolean gGQ = false;
    public boolean gGR = false;
    public boolean gGS = false;
    public a gGT = null;

    public interface a {
        void atP();

        void atQ();

        void lT(int i);
    }

    static /* synthetic */ void a(a aVar, int i) {
        v.d("MicroMsg.IPCallEngineManager", "channel connect failed!");
        if (aVar.gGT != null) {
            aVar.gGT.lT(i);
        }
    }

    public final void auF() {
        v.d("MicroMsg.IPCallEngineManager", "setChannelActiveAfterAccept");
        if (!this.gGR) {
            v.d("MicroMsg.IPCallEngineManager", "channel not connect now");
        }
        this.gGO.setActive();
    }

    public final void auG() {
        if (this.gGQ) {
            v.d("MicroMsg.IPCallEngineManager", "requestChannelConnect, already request channel connect");
            return;
        }
        v.i("MicroMsg.IPCallEngineManager", "requestChannelConnect");
        c cVar = i.aum().gFa;
        if (cVar != null) {
            if (cVar.emi != null) {
                beh O = com.tencent.mm.plugin.ipcall.b.c.O(cVar.emi);
                this.gGO.c(O, O, com.tencent.mm.plugin.ipcall.b.c.O(cVar.gGf));
            }
            v.d("MicroMsg.IPCallEngineManager", "finish set svr addr");
            this.gGO.kvM = cVar.gGa;
            this.gGO.kwB = cVar.gGd;
            if (cVar.gGe != null) {
                this.gGO.kwC = cVar.gGe.toByteArray();
            }
            if (cVar.gGb != null) {
                this.gGO.kvN = cVar.gGb.toByteArray();
            }
            this.gGO.gFG = cVar.gFG;
            this.gGO.gFH = cVar.gFH;
            this.gGO.gFO = cVar.gFO;
            this.gGO.kvP = cVar.gFY;
            this.gGO.kvO = cVar.gFZ;
            this.gGO.kvQ = cVar.gGg;
            v.d("MicroMsg.IPCallEngineManager", "setConfigConnect, ret: %d", new Object[]{Integer.valueOf(this.gGO.setConfigConnect(this.gGO.kvH, (long) this.gGO.gFG, this.gGO.gFO, this.gGO.gFH, this.gGO.field_peerId, 1, this.gGO.kvO, this.gGO.kvP, this.gGO.kvM, this.gGO.kvN == null ? 0 : this.gGO.kvN.length, this.gGO.kvN, this.gGO.kvQ, 0, 0, this.gGO.kwB, this.gGO.kwC))});
            if (this.gGO.setConfigConnect(this.gGO.kvH, (long) this.gGO.gFG, this.gGO.gFO, this.gGO.gFH, this.gGO.field_peerId, 1, this.gGO.kvO, this.gGO.kvP, this.gGO.kvM, this.gGO.kvN == null ? 0 : this.gGO.kvN.length, this.gGO.kvN, this.gGO.kvQ, 0, 0, this.gGO.kwB, this.gGO.kwC) < 0) {
                v.e("MicroMsg.IPCallEngineManager", "setConfigConnect failed, ret: %d", new Object[]{Integer.valueOf(r2)});
                if (this.gGT != null) {
                    this.gGT.lT(21);
                }
            }
            this.gGQ = true;
        }
    }

    public final void lY(int i) {
        if (this.gGR) {
            v.d("MicroMsg.IPCallEngineManager", "setDtmfPayloadType: %d", new Object[]{Integer.valueOf(i)});
            if (this.gGO.SetDTMFPayload(i) < 0) {
                v.i("MicroMsg.IPCallEngineManager", "setDtmfPayloadType failed, ret: %d", new Object[]{Integer.valueOf(this.gGO.SetDTMFPayload(i))});
            }
        }
    }

    public final void auH() {
        this.gGR = false;
        this.gGQ = false;
        this.gGS = false;
    }
}
