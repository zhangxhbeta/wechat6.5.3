package com.tencent.mm.plugin.shake.c.a;

import android.text.TextUtils;
import com.tencent.mm.e.a.mz;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public final class f {
    public List<WeakReference<a>> eAR;
    private String iOR;

    public interface a {
        void aNX();
    }

    public static class c {
    }

    public static class b extends c {
        protected int iOS = 0;
        protected int iOT = 0;
        protected String iOU = "";
        protected int iOV = 0;
        protected int iOW = 0;
        protected int iOX = 7;
        protected String iOY = "";
    }

    public static class d extends c {
        protected String iOZ;
        protected String iPa;
        protected String iPb;
    }

    public f() {
        this.eAR = new ArrayList();
        this.iOR = "";
        this.iOR = com.tencent.mm.plugin.shake.c.c.a.aOj();
    }

    public final void e(String str, long j, int i) {
        d dVar = null;
        v.i("MicroMsg.ShakeCardMsgMgr", "msg_id is " + j);
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is empty");
            return;
        }
        Map q;
        if (i == 0) {
            b bVar;
            v.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_ENTRANCE");
            q = bf.q(str, "sysmsg");
            if (q != null) {
                b bVar2 = new b();
                String str2 = (String) q.get(".sysmsg.begintime");
                if (TextUtils.isEmpty(str2) || !qw(str2)) {
                    v.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml begintime is " + str2);
                    bVar2.iOS = 0;
                } else {
                    bVar2.iOS = Integer.valueOf(str2).intValue();
                }
                str2 = (String) q.get(".sysmsg.endtime");
                if (TextUtils.isEmpty(str2) || !qw(str2)) {
                    v.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml endtime is " + str2);
                    bVar2.iOT = 0;
                } else {
                    bVar2.iOT = Integer.valueOf(str2).intValue();
                }
                bVar2.iOU = (String) q.get(".sysmsg.entrancename");
                str2 = (String) q.get(".sysmsg.activitytype");
                if (TextUtils.isEmpty(str2) || !qw(str2)) {
                    bVar2.iOV = 1;
                } else {
                    bVar2.iOV = Integer.valueOf(str2).intValue();
                }
                v.i("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml activitytype is " + str2);
                str2 = (String) q.get(".sysmsg.flowcontrollevelmin");
                if (TextUtils.isEmpty(str2) || !qw(str2)) {
                    v.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmin is " + str2);
                    bVar2.iOW = 0;
                } else {
                    bVar2.iOW = Integer.valueOf(str2).intValue();
                }
                bVar2.iOY = (String) q.get(".sysmsg.shakecardentrancetip");
                str2 = (String) q.get(".sysmsg.flowcontrollevelmax");
                if (TextUtils.isEmpty(str2) || !qw(str2)) {
                    v.e("MicroMsg.ShakeCardMsgMgr", "parseEntrancedMsgFromMsgXml flowcontrollevelmax is " + str2);
                    bVar2.iOX = 0;
                } else {
                    bVar2.iOX = Integer.valueOf(str2).intValue();
                }
                bVar = bVar2;
            }
            if (bVar == null) {
                v.e("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg == null");
            } else {
                v.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg msg");
                if (!com.tencent.mm.plugin.shake.c.c.a.aNJ()) {
                    v.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg isShakeCardEntranceOpen is false");
                }
                v.i("MicroMsg.ShakeCardMsgMgr", "saveEntranceMsg begintime:" + bVar.iOS + "  endtime:" + bVar.iOT + "  flowlevelmin:" + bVar.iOW + "  flowlevelmax:" + bVar.iOX + " entrancename:" + bVar.iOU + " activitytype:" + bVar.iOV);
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nop, Integer.valueOf(bVar.iOS));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noq, Integer.valueOf(bVar.iOT));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nor, bVar.iOU);
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nov, Integer.valueOf(bVar.iOV));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nos, Integer.valueOf(bVar.iOW));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.not, Integer.valueOf(bVar.iOX));
                ak.yW();
                com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nou, bVar.iOY);
            }
            aNW();
        } else if (i == 1) {
            v.i("MicroMsg.ShakeCardMsgMgr", "onReceive() msgText is MSG_TYPE_RED_DOT");
            q = bf.q(str, "sysmsg");
            if (q != null) {
                d dVar2 = new d();
                dVar2.iOZ = (String) q.get(".sysmsg.reddotid");
                dVar2.iPa = (String) q.get(".sysmsg.reddotdesc");
                dVar2.iPb = (String) q.get(".sysmsg.reddottext");
                dVar = dVar2;
            }
            if (dVar == null) {
                v.e("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg == null");
            } else {
                v.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg msg reddotid is " + dVar.iOZ);
                v.i("MicroMsg.ShakeCardMsgMgr", "saveRedDotMsg pre reddotid is " + this.iOR);
                if (TextUtils.isEmpty(dVar.iOZ)) {
                    v.i("MicroMsg.ShakeCardMsgMgr", "msg.reddotid is empty");
                } else if (TextUtils.isEmpty(this.iOR)) {
                    v.i("MicroMsg.ShakeCardMsgMgr", "redDotId is empty, msg.reddotid is not empty");
                    com.tencent.mm.p.c.us().t(262154, true);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.now, dVar.iOZ);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nox, dVar.iPa);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noy, dVar.iPb);
                    Yj();
                } else if (!this.iOR.equals(dVar.iOZ)) {
                    v.i("MicroMsg.ShakeCardMsgMgr", "redDotId and msg.reddotid is not empty, but no equals");
                    com.tencent.mm.p.c.us().t(262154, true);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.now, dVar.iOZ);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.nox, dVar.iPa);
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noy, dVar.iPb);
                    Yj();
                } else if (this.iOR.equals(dVar.iOZ)) {
                    v.i("MicroMsg.ShakeCardMsgMgr", "redDotId equals msg.reddotid");
                }
            }
            aNW();
        }
        com.tencent.mm.plugin.shake.c.c.a.aNI();
    }

    private static void aNW() {
        com.tencent.mm.sdk.c.a.nhr.z(new mz());
    }

    private static boolean qw(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    private void Yj() {
        if (this.eAR != null) {
            for (int i = 0; i < this.eAR.size(); i++) {
                WeakReference weakReference = (WeakReference) this.eAR.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.aNX();
                    }
                }
            }
        }
    }
}
