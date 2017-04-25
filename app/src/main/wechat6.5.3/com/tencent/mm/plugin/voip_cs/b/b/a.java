package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.bdc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;

public final class a {
    public v2protocal gGO = new v2protocal(this.gGP);
    private ac gGP = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ a kEN;

        public final void handleMessage(Message message) {
            if (message == null) {
                super.handleMessage(message);
                return;
            }
            v.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
            a aVar;
            switch (message.arg1) {
                case 1:
                case 4:
                    return;
                case 3:
                    v.d("MicroMsg.VoipCSEngine", "start dev!");
                    return;
                case 5:
                    v.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        v.i("MicroMsg.VoipCSEngine", "channel broken...");
                        b.bed().kDy = 1;
                    } else if (message.arg2 == 5) {
                        v.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                        b.bed().kDy = 6;
                    } else {
                        v.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                        b.bed().kDy = 5;
                    }
                    aVar = this.kEN;
                    v.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                    b.bed().aKG = 1;
                    if (aVar.kEM != null) {
                        aVar.kEM.ber();
                        return;
                    }
                    return;
                case 6:
                    v.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                    c bed = b.bed();
                    v.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                    bed.kDB = 1;
                    aVar = this.kEN;
                    v.i("MicroMsg.VoipCSEngine", "channel connect!");
                    if (aVar.gGR) {
                        v.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                        return;
                    }
                    aVar.gGR = true;
                    v.i("MicroMsg.VoipCSEngine", "start engine");
                    aVar.gGO.setInactive();
                    v.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                    if (!aVar.gGR) {
                        v.d("MicroMsg.VoipCSEngine", "channel not connect now");
                    }
                    aVar.gGO.setActive();
                    int startEngine = aVar.gGO.startEngine();
                    if (startEngine == 0) {
                        v.i("MicroMsg.VoipCSEngine", "start engine suc!");
                        int[] iArr = new int[]{b.beb().gGO.kwJ, b.beb().gGO.kwK};
                        ByteBuffer allocate = ByteBuffer.allocate(8);
                        allocate.asIntBuffer().put(iArr);
                        if (b.beb().gGO.setAppCmd(34, allocate.array(), 2) < 0) {
                            v.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                        }
                        b.bed().kDz = 1;
                    } else {
                        v.i("MicroMsg.VoipCSEngine", "start engine fail!");
                        b.bed().kDz = 0;
                    }
                    if (aVar.kEM != null && b.bec().kEe != 2) {
                        aVar.kEM.atQ();
                        b.bec().kEe = 2;
                        return;
                    }
                    return;
                case 8:
                    byte[] bArr = (byte[]) message.obj;
                    a aVar2 = this.kEN;
                    try {
                        bdc com_tencent_mm_protocal_c_bdc = (bdc) new bdc().az(bArr);
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + com_tencent_mm_protocal_c_bdc.mZd);
                        switch (com_tencent_mm_protocal_c_bdc.mZd) {
                            case 3:
                                if (com_tencent_mm_protocal_c_bdc.mZe != null) {
                                    Object obj = com_tencent_mm_protocal_c_bdc.mZe.lVU;
                                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipCSEngine", "steve: remote new network type:" + obj);
                                    int appCmd = aVar2.gGO.setAppCmd(302, obj, 4);
                                    if (appCmd < 0) {
                                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + appCmd + ", [roomid=" + aVar2.gGO.kvI + ", roomkey=" + aVar2.gGO.gFH + "]");
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                return;
                            default:
                                return;
                        }
                    } catch (Exception e) {
                        com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                        return;
                    }
                    com.tencent.mm.plugin.voip.b.a.cS("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                    return;
                case 100:
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                    return;
                case 101:
                    com.tencent.mm.plugin.voip.b.a.a((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                    return;
                default:
                    return;
            }
        }
    };
    public boolean gGQ = false;
    public boolean gGR = false;
    public a kEM = null;

    public interface a {
        void atQ();

        void ber();
    }

    public static int CU(String str) {
        String[] split = str.split("\\.");
        return be.getInt(split[3], 0) + (((be.getInt(split[0], 0) << 24) + (be.getInt(split[1], 0) << 16)) + (be.getInt(split[2], 0) << 8));
    }
}
