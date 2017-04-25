package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ao;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.ar;
import com.tencent.pb.common.b.a.a.r;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TalkRoom extends MultiTalkGroup {
    ao pHI;
    Map<String, d> pHJ = new ConcurrentHashMap();

    static class a implements Comparator<d> {
        a() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return 0;
        }
    }

    public static TalkRoom a(String str, String str2, Integer num, int i, long j, ao aoVar, aq[] aqVarArr, ar[] arVarArr) {
        c.d("tagorewang:TalkRoom:create", "create groupId: ", str, " tmpId: ", str2);
        TalkRoom talkRoom = new TalkRoom(str, num, aoVar);
        talkRoom.QI(str2);
        zE(i);
        eK(j);
        int length = aqVarArr == null ? 0 : aqVarArr.length;
        int length2 = arVarArr == null ? 0 : arVarArr.length;
        for (int i2 = 0; i2 != length; i2++) {
            aq aqVar = aqVarArr[i2];
            if (aqVar == null) {
                c.i("tagorewang:TalkRoom:create", "null member info, index: ", Integer.valueOf(i2));
            } else {
                ar arVar = null;
                int i3 = 0;
                while (i3 != length2) {
                    arVar = arVarArr[i3];
                    if (arVar != null && arVar.lYf == aqVar.lYf) {
                        c.d("tagorewang:TalkRoom:create", "member info: ", aqVar, " profile: ", arVar);
                        break;
                    }
                    i3++;
                    arVar = null;
                }
                talkRoom.a(new d(aqVar, arVar));
            }
        }
        c.d("tagorewang:TalkRoom:create", "did create");
        return talkRoom;
    }

    public static TalkRoom a(TalkRoom talkRoom, String str, String str2, Integer num, int i, long j, ao aoVar, aq[] aqVarArr, ar[] arVarArr) {
        if (talkRoom == null) {
            c.i("tagorewang:TalkRoom:update", "updateAll null");
            return null;
        }
        c.d("tagorewang:TalkRoom:update", "updateAll groupId: ", str, " tmpId: ", str2);
        talkRoom.b(str, num);
        talkRoom.QI(str2);
        zE(i);
        eK(j);
        talkRoom.b(aoVar);
        int length = aqVarArr == null ? 0 : aqVarArr.length;
        int length2 = arVarArr == null ? 0 : arVarArr.length;
        if (length == 0 && length2 == 0) {
            c.i("tagorewang:TalkRoom:update", "updateAll null VoiceGroupMem or VoiceGroupUsrProfile array.");
            return talkRoom;
        }
        Set<String> hashSet = new HashSet(talkRoom.pHJ.keySet());
        hashSet.remove(com.tencent.pb.b.a.a.bMo());
        for (int i2 = 0; i2 != length; i2++) {
            aq aqVar = aqVarArr[i2];
            if (aqVar == null) {
                c.i("tagorewang:TalkRoom:update", "null member info, index: ", Integer.valueOf(i2));
            } else {
                d QJ = talkRoom.QJ(aqVar.prp);
                if (QJ == null) {
                    c.d("tagorewang:TalkRoom:update", "add new member");
                    QJ = new d(aqVar);
                    talkRoom.a(QJ);
                } else {
                    QJ.a(aqVar);
                }
                hashSet.remove(QJ.bPw());
            }
        }
        for (String str3 : hashSet) {
            c.d("tagorewang:TalkRoom:update", "keyset", str3);
            c.d("tagorewang:TalkRoom", "remove", talkRoom.pHJ.remove(str3));
        }
        if (hashSet.size() > 0) {
            c.i("tagorewang:TalkRoom:update", "updateAll not update uuid keyset.size(): ", Integer.valueOf(hashSet.size()));
        }
        c.d("tagorewang:TalkRoom:update", "did updateAll");
        return talkRoom;
    }

    public TalkRoom(String str, Integer num, ao aoVar) {
        b(str, num);
        b(aoVar);
    }

    public static boolean bPk() {
        return false;
    }

    private void QI(String str) {
        if (j.QW(str)) {
            this.ptb = str;
        }
    }

    public final int bPl() {
        return this.ppl == 0 ? 0 : this.ppl;
    }

    private void b(String str, Integer num) {
        if (!TextUtils.isEmpty(str)) {
            if (j.QW(str)) {
                this.ptb = str;
            } else {
                this.pta = str;
            }
            if (num != null) {
                this.ppl = num.intValue();
            }
        }
    }

    public static int bPm() {
        return j.bPQ();
    }

    private static void zE(int i) {
        c.d("tagorewang:TalkRoom", "setRoomId: ", Integer.valueOf(i));
    }

    public static long bcC() {
        return j.bPR();
    }

    private static void eK(long j) {
        c.d("tagorewang:TalkRoom", "setRoomKey: ", Long.valueOf(j));
    }

    private static r a(ao aoVar) {
        if (aoVar != null) {
            try {
                if (aoVar.prJ != null) {
                    byte[] bArr = aoVar.prJ;
                    return (r) e.a(new r(), bArr, bArr.length);
                }
            } catch (Exception e) {
                c.i("tagorewang:TalkRoom", "toPlayItemInfo err: ", e);
                return null;
            }
        }
        return null;
    }

    private String bPn() {
        if (this.pHI == null || TextUtils.isEmpty(this.pHI.name)) {
            List arrayList = new ArrayList(this.pHJ.values());
            arrayList.remove(this.pHJ.get(com.tencent.pb.b.a.a.bMo()));
            List cK = cK(arrayList);
            c.h("tagorewang:TalkRoom", "getOtherMembers size: ", Integer.valueOf(cK.size()), " all size: ", Integer.valueOf(this.pHJ.size()));
            StringBuilder stringBuilder = new StringBuilder();
            if (cK != null) {
                int size = cK.size();
                for (int i = 0; i != size; i++) {
                    try {
                        stringBuilder.append(((d) cK.get(i)).getDisplayName());
                        if (i != size - 1) {
                            stringBuilder.append('、');
                        }
                    } catch (Exception e) {
                        c.i("tagorewang:TalkRoom", "updateRoomNameIfEmpty err and continue: ", e);
                    }
                }
            }
            if (stringBuilder.toString().length() > 0) {
                return stringBuilder.toString();
            }
        }
        if (this.pHI != null && !TextUtils.isEmpty(this.pHI.name)) {
            return this.pHI.name;
        }
        c.i("tagorewang:TalkRoom", "updateRoomNameIfEmpty still empty, groupId: ", this.pta, " tmpId: ", this.ptb);
        return null;
    }

    private void b(ao aoVar) {
        if (aoVar != null) {
            try {
                this.ptc = aoVar.prP;
                this.ptd = aoVar.prO;
                if (!(this.pHI == null || aoVar.bdW == 0)) {
                    r a = a(aoVar);
                    r a2 = a(this.pHI);
                    if (a == null) {
                        aoVar.prJ = this.pHI.prJ;
                    } else if (a.pqI == 0 || a.pqI != a2.pqI) {
                        c.i("tagorewang:TalkRoom", "setRoomInfo bad id: ", Integer.valueOf(a2.pqI), " -> ", Integer.valueOf(a.pqI));
                        aoVar.prJ = this.pHI.prJ;
                    }
                }
                this.pHI = aoVar;
            } catch (Exception e) {
                c.i("tagorewang:TalkRoom", "setRoomInfo assert failed: ", e);
                this.pHI = aoVar;
            }
        }
    }

    public final void a(d dVar) {
        this.pHJ.put(dVar.bPw(), dVar);
    }

    public final List<d> bPo() {
        List<d> cK = cK(new ArrayList(this.pHJ.values()));
        d bPq = bPq();
        cK.remove(bPq);
        cK.add(0, bPq);
        bPq = (d) this.pHJ.get(Integer.valueOf(90100));
        if (bPq != null) {
            cK.remove(bPq);
            cK.add(bPq);
        }
        return cK;
    }

    public final List<d> bPp() {
        return new ArrayList(this.pHJ.values());
    }

    private static List<d> cK(List<d> list) {
        if (!list.isEmpty()) {
            Collections.sort(list, new a());
        }
        return list;
    }

    public final d QJ(String str) {
        return (d) this.pHJ.get(str);
    }

    public final d bPq() {
        return (d) this.pHJ.get(com.tencent.pb.b.a.a.bMo());
    }

    public final List<aq> bPr() {
        List<aq> arrayList = new ArrayList();
        for (Entry value : this.pHJ.entrySet()) {
            arrayList.add(((d) value.getValue()).pHQ);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String bPn;
            stringBuilder.append("groupId: ").append(this.pta);
            stringBuilder.append(" tmpId: ").append(this.ptb);
            stringBuilder.append(" routeId: ").append(this.ppl);
            StringBuilder append = stringBuilder.append(" room name: ");
            if (this.pHI == null || TextUtils.isEmpty(this.pHI.name)) {
                bPn = bPn();
            } else {
                bPn = this.pHI.name;
            }
            append.append(bPn);
        } catch (Exception e) {
            stringBuilder.append(" broken by " + e.getMessage());
        }
        return stringBuilder.toString();
    }
}
