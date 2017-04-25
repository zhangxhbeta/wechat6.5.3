package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.ah.b;
import com.tencent.mm.as.u;
import com.tencent.mm.e.a.kz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.ui.f;
import com.tencent.mm.pluginsdk.j.k;
import com.tencent.mm.pluginsdk.j.l;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements l {
    private List<k> cJC = new ArrayList();
    private ac handler = new ac(Looper.getMainLooper());
    private LinkedList<String> hzE = null;
    private LinkedList<String> hzF = new LinkedList();
    private LinkedList<String> hzG = new LinkedList();

    public final LinkedList<String> aCr() {
        if (this.hzG == null) {
            this.hzG = new LinkedList();
        }
        return this.hzG;
    }

    public final synchronized void a(k kVar) {
        this.cJC.add(kVar);
    }

    public final synchronized void b(k kVar) {
        this.cJC.remove(kVar);
    }

    public final void wG(final String str) {
        if (m.dE(str) && wI(str)) {
            v.i("MicroMsg.MultiTalkRoomListMsg", "isKicked! now clean banner and check if i am in multitalk.");
            ak.yW();
            c.vf().get(2, null);
            if (o.aCG().hzq != null && o.aCG().hzq.ptc.equals(str)) {
                v.i("MicroMsg.MultiTalkRoomListMsg", "yes i am now in multitalk so i exit now!");
                o.aCG().c(false, false, false);
            }
            this.handler.postDelayed(new Runnable(this) {
                final /* synthetic */ g hzI;

                public final void run() {
                    this.hzI.wP(str);
                    kz kzVar = new kz();
                    kzVar.bmv.type = 2;
                    a.nhr.z(kzVar);
                }
            }, 2000);
        }
    }

    public final boolean wH(String str) {
        b Rk = o.aCC().Rk(str);
        if (Rk == null || Rk.field_wxGroupId == null || !Rk.field_wxGroupId.equals(str)) {
            return false;
        }
        if (System.currentTimeMillis() - Rk.field_createTime <= 21600000) {
            return true;
        }
        v.i("MicroMsg.MultiTalkRoomListMsg", "wxGroupId:" + str + ",is out of time 6 hours..");
        wP(str);
        return false;
    }

    public final boolean wI(String str) {
        if (this.hzE == null) {
            aCv();
        }
        if (this.hzE == null || !this.hzE.contains(str)) {
            return false;
        }
        return true;
    }

    public final List<String> wJ(String str) {
        List<com.tencent.mm.plugin.multitalk.b.c> wU = o.aCD().wU(str);
        List linkedList = new LinkedList();
        for (com.tencent.mm.plugin.multitalk.b.c cVar : wU) {
            linkedList.add(cVar.field_userName);
        }
        return linkedList;
    }

    public final boolean ce(String str, String str2) {
        if (o.aCD().ch(str, str2) != null) {
            return true;
        }
        return false;
    }

    public final boolean hc(String str) {
        if (this.hzE != null) {
            v.i("MicroMsg.MultiTalkRoomListMsg", "removewxGroupIdInMap:" + str);
            this.hzE.remove(str);
        } else {
            aCv();
        }
        return o.aCC().hc(str);
    }

    public final boolean aCc() {
        return o.aCG().aCc();
    }

    public final boolean aCe() {
        return o.aCG().aCe();
    }

    public final int aCs() {
        return o.aCG().hzs;
    }

    public final boolean aCt() {
        return o.aCG().aCc() && (o.aCG().hzp == e.Starting || o.aCG().hzp == e.Creating);
    }

    public final boolean wK(String str) {
        f bbx = d.bbx();
        if (bbx != null && bbx.kzJ && str.equals(bbx.kzH) && bbx.kzG != null) {
            com.tencent.mm.plugin.voip.ui.g gVar = d.bbx().kzG;
            if (gVar.getVisibility() == 0 && gVar.isShown()) {
                return true;
            }
        }
        return false;
    }

    public final boolean aCu() {
        return com.tencent.mm.plugin.voip.b.d.bdz() || o.aCG().aCe() || o.aCG().aCc() || o.aCG().aCd();
    }

    public final String cf(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.c ch = o.aCD().ch(str, str2);
        if (ch != null) {
            return ch.field_inviteUserName;
        }
        return null;
    }

    public final String er(String str) {
        return com.tencent.mm.model.l.er(str);
    }

    public final boolean bj(Context context) {
        return u.bj(context);
    }

    public final boolean wL(String str) {
        b Rk = o.aCC().Rk(str);
        if (Rk != null) {
            return com.tencent.wecall.talkroom.model.a.bPi().b(Rk.field_groupId, Rk.field_roomId, Rk.field_roomKey, 1);
        }
        return false;
    }

    public final void wM(String str) {
        if (this.hzF == null) {
            this.hzF = new LinkedList();
            if (!this.hzF.contains(str)) {
                this.hzF.add(str);
            }
        } else if (!this.hzF.contains(str)) {
            this.hzF.add(str);
        }
    }

    public final boolean wN(String str) {
        b Rk = o.aCC().Rk(str);
        if (Rk != null) {
            return o.aCF().hyY.wN(Rk.field_groupId);
        }
        return false;
    }

    public final boolean wO(String str) {
        b Rk = o.aCC().Rk(str);
        if (Rk != null) {
            return o.aCF().hyY.a(Rk.field_groupId, Rk.field_roomId, Rk.field_roomKey, Rk.field_routeId);
        }
        return false;
    }

    public final int cg(String str, String str2) {
        com.tencent.mm.plugin.multitalk.b.c ch = o.aCD().ch(str, str2);
        if (ch != null) {
            return ch.field_status;
        }
        return 30;
    }

    public final void wP(String str) {
        if (h.isNullOrEmpty(str)) {
            v.e("MicroMsg.MultiTalkRoomListMsg", "cleanBanner failure ! wxGroupId is null or empty!");
            return;
        }
        v.i("MicroMsg.MultiTalkRoomListMsg", "cleanBanner  wxGroupId = %s", new Object[]{str});
        hc(str);
        o.aCD().hc(str);
        wS(str);
    }

    public final void a(String str, aw awVar) {
        v.i("MicroMsg.MultiTalkRoomListMsg", "showBanner  wxGroupId = %s", new Object[]{str});
        if (awVar != null) {
            aq[] aqVarArr = awVar.pre;
            if (aqVarArr != null && aqVarArr.length > 0) {
                o.aCD().hc(str);
                for (aq aqVar : aqVarArr) {
                    com.tencent.mm.plugin.multitalk.b.c cVar = new com.tencent.mm.plugin.multitalk.b.c();
                    cVar.field_wxGroupId = str;
                    cVar.field_inviteUserName = aqVar.psq;
                    cVar.field_memberUuid = (long) aqVar.lYf;
                    cVar.field_userName = aqVar.prp;
                    cVar.field_status = aqVar.status;
                    if (!o.aCD().a(cVar)) {
                        v.e("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, aqVar.prp, Long.valueOf(cVar.field_memberUuid), cVar.field_inviteUserName});
                    }
                    v.i("MicroMsg.MultiTalkRoomListMsg", "save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, aqVar.prp, Long.valueOf(cVar.field_memberUuid), cVar.field_inviteUserName});
                }
            }
        }
        if (b(str, awVar)) {
            v.i("MicroMsg.MultiTalkRoomListMsg", "addwxGroupIdInMap:" + str);
            if (this.hzE == null) {
                aCv();
                if (this.hzE != null) {
                    this.hzE.add(str);
                }
            } else if (!this.hzE.contains(str)) {
                this.hzE.add(str);
            }
        }
        wS(str);
    }

    public final void wQ(String str) {
        if (this.hzF == null) {
            this.hzF = new LinkedList();
        } else {
            this.hzF.remove(str);
        }
    }

    public final boolean wR(String str) {
        if (this.hzF == null) {
            return false;
        }
        return this.hzF.contains(str);
    }

    final void wS(final String str) {
        for (final k kVar : this.cJC) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ g hzI;

                public final void run() {
                    kVar.Gg(str);
                }
            });
        }
    }

    public final b Rk(String str) {
        return o.aCC().Rk(str);
    }

    public final void aCv() {
        LinkedList aCK = o.aCC().aCK();
        v.i("MicroMsg.MultiTalkRoomListMsg", "setMultitalkingwxGroupIdMap reset!");
        this.hzE = new LinkedList();
        Iterator it = aCK.iterator();
        while (it.hasNext()) {
            this.hzE.add(((b) it.next()).field_wxGroupId);
        }
        kz kzVar = new kz();
        kzVar.bmv.type = 1;
        a.nhr.z(kzVar);
    }

    private static boolean b(String str, aw awVar) {
        int i = 0;
        if (awVar == null) {
            return false;
        }
        b bVar = new b();
        bVar.field_wxGroupId = str;
        bVar.field_groupId = awVar.lEs;
        bVar.field_roomId = awVar.kty;
        bVar.field_roomKey = awVar.ktz;
        bVar.field_routeId = awVar.ppV;
        bVar.field_inviteUserName = awVar.psK;
        aq[] aqVarArr = awVar.pre;
        if (aqVarArr.length > 0) {
            i = aqVarArr.length;
        }
        bVar.field_memberCount = i;
        bVar.field_createTime = System.currentTimeMillis();
        if (o.aCC().Rk(str) == null) {
            return o.aCC().a(bVar);
        }
        return o.aCC().b(bVar);
    }

    static boolean c(String str, aw awVar) {
        if (awVar == null) {
            return false;
        }
        aq[] aqVarArr = awVar.pre;
        List linkedList = new LinkedList();
        for (aq aqVar : aqVarArr) {
            linkedList.add(aqVar.prp);
        }
        ak.yW();
        String str2 = (String) c.vf().get(2, null);
        if (str2 == null) {
            v.i("MicroMsg.MultiTalkRoomListMsg", "myUserName is null , go save delete all logic.");
            b(str, awVar);
            return true;
        }
        boolean z;
        List<com.tencent.mm.plugin.multitalk.b.c> wU = o.aCD().wU(str);
        LinkedList linkedList2 = new LinkedList();
        com.tencent.mm.plugin.multitalk.b.c cVar = null;
        for (com.tencent.mm.plugin.multitalk.b.c cVar2 : wU) {
            com.tencent.mm.plugin.multitalk.b.c cVar22;
            linkedList2.add(cVar22.field_userName);
            if (!cVar22.field_userName.equals(str2)) {
                cVar22 = cVar;
            }
            cVar = cVar22;
        }
        if (cVar == null || !linkedList.contains(str2)) {
            z = true;
        } else {
            z = true;
            for (aq aqVar2 : aqVarArr) {
                if (!(aqVar2.prp == null || !aqVar2.prp.equals(str2) || aqVar2.status == cVar.field_status)) {
                    com.tencent.mm.plugin.multitalk.b.c cVar3 = new com.tencent.mm.plugin.multitalk.b.c();
                    cVar3.field_wxGroupId = str;
                    cVar3.field_inviteUserName = aqVar2.psq;
                    cVar3.field_memberUuid = (long) aqVar2.lYf;
                    cVar3.field_userName = aqVar2.prp;
                    cVar3.field_status = aqVar2.status;
                    if (!o.aCD().a(cVar3)) {
                        v.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, aqVar2.prp, Long.valueOf(cVar3.field_memberUuid), cVar3.field_inviteUserName});
                        z = false;
                    }
                    v.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers update myself success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, aqVar2.prp, Long.valueOf(cVar3.field_memberUuid), cVar3.field_inviteUserName});
                }
            }
        }
        boolean z2 = z;
        for (aq aqVar3 : aqVarArr) {
            if (!linkedList2.contains(aqVar3.prp)) {
                com.tencent.mm.plugin.multitalk.b.c cVar4 = new com.tencent.mm.plugin.multitalk.b.c();
                cVar4.field_wxGroupId = str;
                cVar4.field_inviteUserName = aqVar3.psq;
                cVar4.field_memberUuid = (long) aqVar3.lYf;
                cVar4.field_userName = aqVar3.prp;
                cVar4.field_status = aqVar3.status;
                if (!o.aCD().a(cVar4)) {
                    v.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember failure! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, aqVar3.prp, Long.valueOf(cVar4.field_memberUuid), cVar4.field_inviteUserName});
                    z2 = false;
                }
                v.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers save multiTalkMember success! wxGroupId = %s,userName = %s,field_memberUuid = %d,multiTalkMember.field_inviteUserName = %s", new Object[]{str, aqVar3.prp, Long.valueOf(cVar4.field_memberUuid), cVar4.field_inviteUserName});
            }
        }
        Iterator it = linkedList2.iterator();
        z = z2;
        while (it.hasNext()) {
            str2 = (String) it.next();
            if (!linkedList.contains(str2)) {
                if (o.aCD().ci(str, str2)) {
                    v.i("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete success for wxGroupId = " + str + ", username = " + str2);
                } else {
                    z = false;
                    v.e("MicroMsg.MultiTalkRoomListMsg", "updateMultiTalkMembers delete fail for wxGroupId = " + str + ", username = " + str2);
                }
            }
            z = z;
        }
        return z;
    }
}
