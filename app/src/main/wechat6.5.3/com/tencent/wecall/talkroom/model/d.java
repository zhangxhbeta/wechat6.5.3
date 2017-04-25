package com.tencent.wecall.talkroom.model;

import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.b.a.a;
import com.tencent.pb.common.b.a.a.aq;
import com.tencent.pb.common.b.a.a.ar;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.h;

public final class d {
    private String jWJ;
    aq pHQ;
    private ar pHR;

    public d(aq aqVar) {
        a(aqVar);
    }

    public d(aq aqVar, ar arVar) {
        a(aqVar);
        if (arVar == null) {
            c.i("tagorewang:TalkRoomMember", "set null profile");
            return;
        }
        this.pHR = arVar;
    }

    public final void a(aq aqVar) {
        if (aqVar == null) {
            c.i("tagorewang:TalkRoomMember", "set null info");
            return;
        }
        this.pHQ = aqVar;
    }

    public final String bPw() {
        if (this.pHQ != null) {
            return this.pHQ.prp;
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final String getDisplayName() {
        try {
            String str = this.jWJ;
            if (str == null || str.trim().length() == 0) {
                return str;
            }
            char[] toCharArray = str.trim().toCharArray();
            int i = 0;
            for (char c : toCharArray) {
                i = c >= '¡' ? i + 2 : i + 1;
            }
            if (i <= 10) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                i = toCharArray[i2] >= '¡' ? i + 2 : i + 1;
                if (i + 1 > 10) {
                    break;
                }
                stringBuilder.append(toCharArray[i2]);
            }
            stringBuilder.append('…');
            return stringBuilder.toString();
        } catch (Exception e) {
            c.i("tagorewang:TalkRoomMember", "getDisplayName err: ", e);
            return this.jWJ;
        }
    }

    public final int getState() {
        if (this.pHQ == null) {
            return 0;
        }
        return this.pHQ.status;
    }

    public final int bPx() {
        if (this.pHQ == null) {
            return -1;
        }
        return this.pHQ.gGl;
    }

    public final String toString() {
        int i = 0;
        if (this.pHQ != null) {
            i = this.pHQ.lYf;
        } else if (this.pHR != null) {
            i = this.pHR.lYf;
        }
        if (this.pHQ == null || this.pHR == null) {
            return "invlaid TalkRoomMember which uuid is " + i;
        }
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        aq aqVar = this.pHQ;
        if (aqVar == null) {
            str = "null";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(aqVar.lYf);
            stringBuilder.append(" openClientId:").append(aqVar.psh);
            stringBuilder.append(" invite uuid: ").append(aqVar.psd);
            stringBuilder.append(" member id:").append(aqVar.gGl);
            stringBuilder.append(" status: ").append(aqVar.status);
            stringBuilder.append(" reason: ").append(aqVar.bhB);
            str = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(str).append(" ");
        ar arVar = this.pHR;
        if (arVar == null) {
            str = "null";
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(arVar.lYf);
            stringBuilder3.append(" user name: ").append(arVar.username);
            stringBuilder3.append(" head url: ").append(arVar.inG);
            str = stringBuilder3.toString();
        }
        stringBuilder.append(str);
        return stringBuilder2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        return h.equals(bPw(), ((d) obj).bPw());
    }

    public final int hashCode() {
        String bPw = bPw();
        return bPw == null ? 0 : bPw.hashCode();
    }

    public final boolean bPy() {
        return h.equals(a.bMo(), bPw());
    }
}
