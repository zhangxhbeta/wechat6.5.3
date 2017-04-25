package com.tencent.mm.ar;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.bg.g;
import com.tencent.mm.e.a.iv;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.util.ArrayList;
import java.util.List;

public final class c extends f<b> implements a {
    public static final String[] cic = new String[]{f.a(b.chq, "fmessage_conversation")};
    private static final String[] ddR = new String[]{"CREATE INDEX IF NOT EXISTS  fmessageConversationTalkerIndex ON fmessage_conversation ( talker )", "CREATE INDEX IF NOT EXISTS  fmconversation_isnew_Index ON fmessage_conversation ( isNew )"};
    private final int aRG = 1;
    public d cie;
    private Runnable ddS = new Runnable(this) {
        final /* synthetic */ c ddT;

        {
            this.ddT = r1;
        }

        public final void run() {
            v.v("MicroMsg.FMessageConversationStorage", "onNotifyChange, newCount update to = %d", Integer.valueOf(this.ddT.Kr()));
            ak.yW();
            com.tencent.mm.model.c.vf().set(143618, Integer.valueOf(r0));
        }
    };
    protected Context mContext = null;

    public c(d dVar) {
        super(dVar, b.chq, "fmessage_conversation", ddR);
        this.cie = dVar;
        this.mContext = aa.getContext();
    }

    public final Cursor Kp() {
        return this.cie.rawQuery("select * from fmessage_conversation  ORDER BY lastModifiedTime DESC", null);
    }

    public final int getCount() {
        int i = 0;
        Cursor rawQuery = this.cie.rawQuery("select count(*) from fmessage_conversation", null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        v.d("MicroMsg.FMessageConversationStorage", "getCount = " + i);
        return i;
    }

    public final boolean A(String str, int i) {
        if (str == null || str.length() == 0) {
            v.w("MicroMsg.FMessageConversationStorage", "updateState fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.h.c kB = kB(str);
        if (kB == null) {
            v.w("MicroMsg.FMessageConversationStorage", "updateState fail, get fail, talker = " + str);
            return false;
        } else if (i == kB.field_state) {
            v.d("MicroMsg.FMessageConversationStorage", "updateState, no need to update");
            return true;
        } else {
            kB.field_state = i;
            kB.field_lastModifiedTime = System.currentTimeMillis();
            if (!super.a(kB, new String[0])) {
                return false;
            }
            Lf(str);
            return true;
        }
    }

    public final boolean Kq() {
        if (this.cie.dF("fmessage_conversation", "update fmessage_conversation set isNew = 0")) {
            v.d("MicroMsg.FMessageConversationStorage", "clearAllNew success");
            Ls();
            return true;
        }
        v.e("MicroMsg.FMessageConversationStorage", "clearAllNew fail");
        return false;
    }

    public final int Kr() {
        int i = 0;
        Cursor rawQuery = this.cie.rawQuery(String.format("select count(*) from %s where %s = 1 and %s < 2", new Object[]{"fmessage_conversation", "isNew", "fmsgIsSend"}), null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        v.d("MicroMsg.FMessageConversationStorage", "getNewCount = " + i);
        return i;
    }

    public final List<String> Ks() {
        Cursor rawQuery = this.cie.rawQuery(String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[]{"contentNickname", "fmessage_conversation", Integer.valueOf(2)}), null);
        List<String> arrayList = new ArrayList();
        if (rawQuery.moveToFirst()) {
            do {
                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("contentNickname")));
            } while (rawQuery.moveToNext());
        }
        rawQuery.close();
        return arrayList;
    }

    public final boolean kA(String str) {
        if (str == null || str.length() == 0) {
            v.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, talker is null");
            return false;
        }
        com.tencent.mm.sdk.h.c kB = kB(str);
        if (kB == null || !str.equals(kB.field_talker)) {
            v.w("MicroMsg.FMessageConversationStorage", "unsetNew fail, conversation does not exist, talker = " + str);
            return false;
        }
        kB.field_isNew = 0;
        return super.a(kB, new String[0]);
    }

    public final b kB(String str) {
        if (str == null || str.length() == 0) {
            v.w("MicroMsg.FMessageConversationStorage", "get fail, talker is null");
            return null;
        }
        com.tencent.mm.sdk.h.c bVar = new b();
        bVar.field_talker = str;
        if (super.b(bVar, new String[0])) {
            return bVar;
        }
        v.i("MicroMsg.FMessageConversationStorage", "get fail, maybe not exist, talker = " + str);
        return null;
    }

    public final b kC(String str) {
        b bVar = null;
        if (str == null || str.length() == 0) {
            v.w("MicroMsg.FMessageConversationStorage", "get fail, encryptTalker is null");
        } else {
            Cursor rawQuery = this.cie.rawQuery("select * from fmessage_conversation  where encryptTalker=" + g.dM(str), null);
            if (rawQuery.getCount() != 0) {
                bVar = new b();
                rawQuery.moveToFirst();
                bVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return bVar;
    }

    public final void a(String str, i iVar) {
        int i = 0;
        if (str == null || str.length() == 0) {
            v.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, id is null");
            return;
        }
        long j;
        try {
            j = be.getLong(str, 0);
        } catch (Exception e) {
            v.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            v.w("MicroMsg.FMessageConversationStorage", "onNotifyChange fail, sysRowId is invalid");
            return;
        }
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            v.e("MicroMsg.FMessageConversationStorage", "onNotifyChange, account not ready, can not insert fmessageconversation");
            return;
        }
        com.tencent.mm.sdk.h.c fVar = new f();
        if (l.KC().b(j, fVar)) {
            v.d("MicroMsg.FMessageConversationStorage", "onNotifyChange succ, sysRowId = " + j);
            com.tencent.mm.sdk.h.c kB = l.KD().kB(fVar.field_talker);
            if (kB == null) {
                v.i("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation does not exist, insert a new one, talker = " + fVar.field_talker);
                com.tencent.mm.sdk.h.c bVar = new b();
                if (fVar.field_type == 0) {
                    at.a My = at.a.My(fVar.field_msgContent);
                    bVar.field_displayName = My.getDisplayName();
                    if (My.scene == 4 && My.bwI() != null) {
                        bVar.field_displayName = My.bwI();
                    }
                    bVar.field_addScene = My.scene;
                    bVar.field_isNew = 1;
                    bVar.field_contentFromUsername = My.lct;
                    bVar.field_contentNickname = My.cID;
                    bVar.field_contentPhoneNumMD5 = My.nvG;
                    bVar.field_contentFullPhoneNumMD5 = My.nvH;
                    v.i("MicroMsg.FMessageConversationStorage", "push, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                } else if (fVar.Ku()) {
                    at.d MB = at.d.MB(fVar.field_msgContent);
                    bVar.field_displayName = MB.getDisplayName();
                    bVar.field_addScene = MB.scene;
                    bVar.field_isNew = 1;
                    bVar.field_contentFromUsername = MB.lct;
                    bVar.field_contentNickname = MB.cID;
                    bVar.field_contentVerifyContent = MB.content;
                    v.i("MicroMsg.FMessageConversationStorage", "receive, new friend Username: " + bVar.field_contentFromUsername + "new friend Nickname: " + bVar.field_contentNickname);
                }
                bVar.field_lastModifiedTime = System.currentTimeMillis();
                bVar.field_state = 0;
                bVar.field_talker = fVar.field_talker;
                bVar.field_encryptTalker = fVar.field_encryptTalker;
                bVar.field_fmsgSysRowId = j;
                bVar.field_fmsgIsSend = fVar.field_isSend;
                bVar.field_fmsgType = fVar.field_type;
                bVar.field_fmsgContent = fVar.field_msgContent;
                if (fVar.Ku()) {
                    i = fVar.field_type;
                }
                bVar.field_recvFmsgType = i;
                v.i("MicroMsg.FMessageConversationStorage", "field_fmsgContent: " + bVar.field_fmsgContent);
                l.KD().b(bVar);
            } else {
                v.d("MicroMsg.FMessageConversationStorage", "onNotifyChange, fmessage conversation has existed, talker = " + fVar.field_talker);
                if (fVar.Ku()) {
                    kB.field_isNew = 1;
                }
                kB.field_lastModifiedTime = System.currentTimeMillis();
                kB.field_encryptTalker = fVar.field_encryptTalker;
                kB.field_fmsgSysRowId = j;
                kB.field_fmsgIsSend = fVar.field_isSend;
                kB.field_fmsgType = fVar.field_type;
                kB.field_fmsgContent = fVar.field_msgContent;
                if (fVar.Ku()) {
                    kB.field_recvFmsgType = fVar.field_type;
                    v.i("MicroMsg.FMessageConversationStorage", "field_recvFmsgType: " + kB.field_recvFmsgType);
                }
                if (fVar.field_type == 0) {
                    at.a My2 = at.a.My(fVar.field_msgContent);
                    kB.field_contentFromUsername = My2.lct;
                    kB.field_contentNickname = My2.cID;
                    kB.field_contentPhoneNumMD5 = My2.nvG;
                    kB.field_contentFullPhoneNumMD5 = My2.nvH;
                    v.i("MicroMsg.FMessageConversationStorage", "TYPE_SYSTEM_PUSH, new friend Username: " + kB.field_contentFromUsername + "new friend Nickname: " + kB.field_contentNickname);
                } else if (fVar.Ku()) {
                    if ((fVar.field_isSend >= 2 ? 1 : 0) == 0) {
                        at.d MB2 = at.d.MB(fVar.field_msgContent);
                        kB.field_contentVerifyContent = MB2.content;
                        kB.field_contentFromUsername = MB2.lct;
                        kB.field_contentNickname = MB2.cID;
                        v.i("MicroMsg.FMessageConversationStorage", "field_contentVerifyContent: " + kB.field_contentVerifyContent + " receive, new friend Username: " + kB.field_contentFromUsername + " new friend Nickname: " + kB.field_contentNickname);
                        String str2 = kB.field_contentFromUsername;
                        String str3 = kB.field_contentNickname;
                        b ivVar = new iv();
                        ivVar.bjm.userName = str2;
                        ivVar.bjm.aGX = str3;
                        ivVar.bjm.type = 1;
                        com.tencent.mm.sdk.c.a.nhr.z(ivVar);
                    }
                }
                l.KD().a(kB, new String[0]);
                if (Kr() == 0) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(340225, Long.valueOf(System.currentTimeMillis()));
                }
            }
            Kt();
            return;
        }
        v.w("MicroMsg.FMessageConversationStorage", "onNotifyChange, get fail, id = " + j);
    }

    public final void Kt() {
        ad.B(this.ddS);
        ad.g(this.ddS, 500);
    }

    public final boolean kD(String str) {
        if (str == null || str.length() == 0) {
            v.w("MicroMsg.FMessageConversationStorage", "deleteByTalker fail, talker is null");
            return false;
        }
        if (!this.cie.dF("fmessage_conversation", "delete from fmessage_conversation where talker = '" + be.lZ(str) + "'")) {
            return false;
        }
        v.d("MicroMsg.FMessageConversationStorage", "deleteByTalker success, talker = " + str);
        Lf(str);
        return true;
    }
}
