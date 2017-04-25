package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.b.a.a;
import com.tencent.pb.common.b.a.a.ao;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.ar;
import com.tencent.pb.common.c.f;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c {
    private static boolean DEBUG = false;
    public static boolean pHL = false;
    private static final f<c> pHM = new f<c>() {
        protected final /* synthetic */ Object bMm() {
            return new c();
        }
    };
    Map<String, TalkRoom> pHN;
    Map<String, String> pHO;
    g pHP;

    public static c bPu() {
        return (c) pHM.get();
    }

    private c() {
        this.pHN = new HashMap();
        this.pHO = new HashMap();
        com.tencent.pb.common.c.c.d("TalkRoomManager", "asyncLoadCache");
    }

    public final boolean aT(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "isGroupActiveExceptMySelf groupid is null");
            return false;
        }
        TalkRoom QK = QK(str);
        if (QK == null) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "isGroupActiveExceptMySelf talkRoom is null");
            return false;
        }
        List<d> bPo = QK.bPo();
        if (bPo == null) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "isGroupActiveExceptMySelf TalkRoomMember list is null");
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        for (d dVar : bPo) {
            if (dVar != null) {
                boolean z4;
                TalkRoom.bPk();
                if (dVar.getState() != 10) {
                    z4 = z2;
                    z2 = z3;
                } else if (dVar.bPy()) {
                    z4 = true;
                    z2 = z3;
                } else {
                    z4 = z2;
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
                if (z4 && z2) {
                    com.tencent.pb.common.c.c.i("TalkRoomManager", "isGroupActiveExceptMySelf is true");
                    return true;
                }
                z3 = z2;
                z2 = z4;
            }
        }
        return false;
    }

    public final TalkRoom QK(String str) {
        TalkRoom talkRoom = (TalkRoom) this.pHN.get(str);
        if (talkRoom != null || !j.QW(str)) {
            return talkRoom;
        }
        return (TalkRoom) this.pHN.get((String) this.pHO.get(str));
    }

    public final int QL(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "getSelfMemberId invalid groupId");
            return -1;
        }
        TalkRoom QK = QK(str);
        if (QK == null) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "getSelfMemberId TalkRoom is null  groupId: ", str);
            return -1;
        }
        d QJ = QK.QJ(a.bMo());
        if (QJ != null) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "getSelfMemberId TalkRoomMember is not null groupId: ", str, " uuid: ", a.bMo(), " memberId: ", Integer.valueOf(QJ.bPx()));
            return QJ.bPx();
        }
        com.tencent.pb.common.c.c.i("TalkRoomManager", "getSelfMemberId TalkRoomMember is null");
        return -1;
    }

    public final int QM(String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "getRountIdByGrouId invalid groupId");
            return 0;
        }
        TalkRoom QK = QK(str);
        if (QK != null) {
            return QK.bPl();
        }
        com.tencent.pb.common.c.c.i("TalkRoomManager", "getRountIdByGrouId TalkRoom is null  groupId: ", str);
        return 0;
    }

    public final boolean a(String str, String str2, int i, int i2, String... strArr) {
        com.tencent.pb.common.c.c.d("TalkRoomManager", "newTmpGroup groupId: ", str);
        if (!j.QW(str)) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "newTmpGroup invalid clientGroupId");
            return false;
        } else if (strArr == null || strArr.length == 0) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "newTmpGroup empty uuid array");
            return false;
        } else {
            try {
                ao aoVar = new ao();
                aoVar.bdW = 0;
                aoVar.prP = str2;
                aoVar.prO = a.bMo();
                TalkRoom talkRoom = new TalkRoom(str, null, aoVar);
                int length = strArr.length;
                for (int i3 = 0; i3 != length; i3++) {
                    String str3 = strArr[i3];
                    aq aqVar = new aq();
                    aqVar.prp = str3;
                    aqVar.psq = a.bMo();
                    aqVar.status = 20;
                    aqVar.gGl = -1;
                    aqVar.pse = (int) (System.currentTimeMillis() / 1000);
                    talkRoom.a(new d(aqVar, new ar()));
                }
                this.pHN.put(str, talkRoom);
                bPv();
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.i("TalkRoomManager", "newTmpGroup err: ", e);
                return false;
            }
        }
    }

    static void bPv() {
        com.tencent.pb.common.c.c.d("TalkRoomManager", "asyncWriteBackCache");
    }

    public static boolean QN(String str) {
        TalkRoom QK = bPu().QK(str);
        if (QK == null) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "isMySelfExit talkRoom is null");
            return true;
        }
        d bPq = QK.bPq();
        if (bPq == null || 20 == bPq.getState()) {
            return true;
        }
        return false;
    }

    public static int QO(String str) {
        TalkRoom QK = bPu().QK(str);
        if (QK == null) {
            com.tencent.pb.common.c.c.i("TalkRoomManager", "getMySelfReason talkRoom is null groupId: ", str);
            return 0;
        }
        int i;
        d bPq = QK.bPq();
        if (bPq == null || bPq.pHQ == null) {
            i = 0;
        } else {
            i = bPq.pHQ.bhB;
        }
        com.tencent.pb.common.c.c.i("TalkRoomManager", "getMySelfReason groupId: ", str, " reason: ", Integer.valueOf(i));
        return i;
    }

    public final MultiTalkGroup QP(String str) {
        TalkRoom QK = QK(str);
        if (QK == null) {
            return null;
        }
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.pta = QK.pta;
        multiTalkGroup.ptb = QK.ptb;
        multiTalkGroup.ppl = QK.ppl;
        multiTalkGroup.ptc = QK.ptc;
        multiTalkGroup.ptd = QK.ptd;
        List arrayList = new ArrayList();
        List<d> bPp = QK.bPp();
        if (bPp.size() > 0) {
            for (d dVar : bPp) {
                if (dVar != null) {
                    MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
                    multiTalkGroupMember.ptf = dVar.bPw();
                    multiTalkGroupMember.ptg = dVar.pHQ != null ? dVar.pHQ.psq : SQLiteDatabase.KeyEmpty;
                    multiTalkGroupMember.bhB = dVar.pHQ != null ? dVar.pHQ.bhB : 0;
                    multiTalkGroupMember.status = dVar.getState();
                    int i = (dVar.pHQ == null || dVar.pHQ.pse == 0) ? 0 : dVar.pHQ.pse;
                    multiTalkGroupMember.pse = i;
                    arrayList.add(multiTalkGroupMember);
                }
            }
        }
        multiTalkGroup.pte = arrayList;
        return multiTalkGroup;
    }
}
