package com.tencent.mm.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.f.a.a.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.h.h;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ac extends j implements ar, com.tencent.mm.storage.au.a {
    public static final String[] cic = new String[]{f.a(com.tencent.mm.j.a.chq, "rconversation"), f.a(com.tencent.mm.j.a.chq, "rbottleconversation"), "CREATE TABLE IF NOT EXISTS conversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "CREATE TABLE IF NOT EXISTS bottleconversation ( unReadCount INTEGER, status INT, isSend INT, createTime LONG, username VARCHAR(40), content TEXT, reserved TEXT );", "DROP INDEX IF EXISTS rconversation_unreadcount_index ", "DROP INDEX IF EXISTS multi_index ", "CREATE INDEX IF NOT EXISTS rconversation_multi_index ON  rconversation ( unReadCount,parentRef )", "CREATE INDEX IF NOT EXISTS rbottleconversation_unreadcount_index ON  rbottleconversation ( unReadCount )"};
    public final com.tencent.mm.sdk.h.d cie;
    public c nuA;
    com.tencent.mm.plugin.f.a.a.c nuB = this;
    a nuC = new a();
    d nuD = new d();
    private h<b, ab> nuE = new h<b, ab>(this) {
        final /* synthetic */ ac nuG;

        {
            this.nuG = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((b) obj).a((ab) obj2, this.nuG);
        }
    };
    public h<b, ab> nuF = new h<b, ab>(this) {
        final /* synthetic */ ac nuG;

        {
            this.nuG = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((b) obj).a((ab) obj2, this.nuG);
        }
    };

    public interface b {
        void a(ab abVar, ac acVar);
    }

    public interface c {
        String a(int i, String str, String str2, int i2, Context context);

        void a(at atVar, PString pString, PString pString2, PInt pInt, boolean z);
    }

    private static class a extends com.tencent.mm.av.a<com.tencent.mm.plugin.f.a.a.b> implements com.tencent.mm.plugin.f.a.a.b {
        private a() {
        }

        public final void a(at atVar, boolean z, com.tencent.mm.storage.au.c cVar, ab abVar) {
            final at atVar2 = atVar;
            final boolean z2 = z;
            final com.tencent.mm.storage.au.c cVar2 = cVar;
            final ab abVar2 = abVar;
            a(new com.tencent.mm.av.a.a<com.tencent.mm.plugin.f.a.a.b>(this) {
                final /* synthetic */ a nuK;

                public final /* synthetic */ void an(Object obj) {
                    ((com.tencent.mm.plugin.f.a.a.b) obj).a(atVar2, z2, cVar2, abVar2);
                }
            });
        }
    }

    private static class d extends com.tencent.mm.av.a<g> implements g {
        private d() {
        }

        public final void a(ac acVar, String str, at atVar, ab abVar, boolean z, int i, int i2, com.tencent.mm.storage.au.c cVar) {
            final ac acVar2 = acVar;
            final String str2 = str;
            final at atVar2 = atVar;
            final ab abVar2 = abVar;
            final boolean z2 = z;
            final int i3 = i;
            final int i4 = i2;
            final com.tencent.mm.storage.au.c cVar2 = cVar;
            a(new com.tencent.mm.av.a.a<g>(this) {
                final /* synthetic */ d nuP;

                public final /* synthetic */ void an(Object obj) {
                    ((g) obj).a(acVar2, str2, atVar2, abVar2, z2, i3, i4, cVar2);
                }
            });
        }
    }

    public ac(com.tencent.mm.sdk.h.d dVar) {
        byte b;
        Assert.assertTrue(dVar instanceof com.tencent.mm.bg.g);
        Cursor rawQuery = dVar.rawQuery("PRAGMA table_info( rconversation)", null);
        while (rawQuery.moveToNext()) {
            int columnIndex = rawQuery.getColumnIndex("name");
            if (columnIndex >= 0) {
                if ("flag".equalsIgnoreCase(rawQuery.getString(columnIndex))) {
                    b = (byte) 1;
                    break;
                }
            }
        }
        b = (byte) 0;
        rawQuery.close();
        List<String> a = f.a(com.tencent.mm.j.a.chq, "rconversation", dVar);
        a.addAll(f.a(com.tencent.mm.j.a.chq, "rbottleconversation", dVar));
        for (String dF : a) {
            dVar.dF("rconversation", dF);
        }
        if (b == (byte) 0) {
            dVar.dF("rconversation", "update rconversation set flag = conversationTime");
        }
        this.cie = dVar;
    }

    public static String Me(String str) {
        v.v("MicroMsg.ConversationStorage", "talker :" + str);
        if (u.ew(str)) {
            return "rbottleconversation";
        }
        return "rconversation";
    }

    public final void a(b bVar, Looper looper) {
        this.nuF.a(bVar, looper);
    }

    public final void a(b bVar) {
        this.nuE.a(bVar, null);
    }

    public final void b(b bVar) {
        this.nuE.remove(bVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.storage.au r21, com.tencent.mm.storage.au.c r22) {
        /*
        r20 = this;
        if (r22 != 0) goto L_0x000c;
    L_0x0002:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "null notifyInfo";
        com.tencent.mm.sdk.platformtools.v.f(r2, r3);
    L_0x000b:
        return;
    L_0x000c:
        r0 = r22;
        r4 = r0.bdo;
        r7 = 0;
        r0 = r20;
        r6 = r0.Mh(r4);
        r0 = r21;
        r5 = r0.MI(r4);
        if (r6 != 0) goto L_0x002f;
    L_0x001f:
        r6 = new com.tencent.mm.storage.ab;
        r6.<init>(r4);
        r2 = com.tencent.mm.storage.u.ew(r4);
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r2 = 1;
        r6.dg(r2);
    L_0x002e:
        r7 = 1;
    L_0x002f:
        r0 = r20;
        r2 = r0.nuC;
        r0 = r22;
        r2.a(r5, r7, r0, r6);
        r2 = "MicroMsg.ConversationStorage";
        r3 = "dkevent user:%s func:%s cnt:%d ";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r0 = r22;
        r10 = r0.bdo;
        r8[r9] = r10;
        r9 = 1;
        r0 = r22;
        r10 = r0.nws;
        r8[r9] = r10;
        r9 = 2;
        r0 = r22;
        r10 = r0.nwu;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r8);
        r3 = 0;
        r2 = 0;
        if (r22 == 0) goto L_0x008f;
    L_0x0061:
        r0 = r22;
        r8 = r0.nws;
        r9 = "delete";
        r8 = r8.equals(r9);
        if (r8 == 0) goto L_0x008f;
    L_0x006e:
        r0 = r22;
        r8 = r0.nww;
        if (r8 <= 0) goto L_0x0078;
    L_0x0074:
        r0 = r22;
        r2 = r0.nww;
    L_0x0078:
        r8 = "MicroMsg.ConversationStorage";
        r9 = "notify delete count %d ";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r0 = r22;
        r12 = r0.nww;
        r12 = java.lang.Integer.valueOf(r12);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.v.i(r8, r9, r10);
    L_0x008f:
        r9 = r2;
        if (r22 == 0) goto L_0x0474;
    L_0x0092:
        r0 = r22;
        r2 = r0.nws;
        r8 = "insert";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x0474;
    L_0x009f:
        r0 = r22;
        r2 = r0.nwv;
        if (r2 <= 0) goto L_0x0471;
    L_0x00a5:
        r0 = r22;
        r2 = r0.nwv;
    L_0x00a9:
        r3 = "MicroMsg.ConversationStorage";
        r8 = "notify insert all count %d ";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r0 = r22;
        r12 = r0.nwv;
        r12 = java.lang.Integer.valueOf(r12);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.v.i(r3, r8, r10);
        r8 = r2;
    L_0x00c1:
        if (r5 == 0) goto L_0x01f8;
    L_0x00c3:
        r2 = r5.field_msgId;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x01f8;
    L_0x00cb:
        r0 = r22;
        r2 = r0.nwu;
        r3 = 1;
        if (r2 != r3) goto L_0x010e;
    L_0x00d2:
        r0 = r22;
        r2 = r0.nwt;
        r3 = 0;
        r2 = r2.get(r3);
        r2 = (com.tencent.mm.storage.at) r2;
        r2 = r2.field_msgId;
        r10 = r5.field_msgId;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x010e;
    L_0x00e5:
        r3 = "MicroMsg.ConversationStorage";
        r10 = "Warning ! getLastMsg may wrong , lastid:%d  insertlist:%d";
        r2 = 2;
        r11 = new java.lang.Object[r2];
        r2 = 0;
        r12 = r5.field_msgId;
        r12 = java.lang.Long.valueOf(r12);
        r11[r2] = r12;
        r12 = 1;
        r0 = r22;
        r2 = r0.nwt;
        r13 = 0;
        r2 = r2.get(r13);
        r2 = (com.tencent.mm.storage.at) r2;
        r14 = r2.field_msgId;
        r2 = java.lang.Long.valueOf(r14);
        r11[r12] = r2;
        com.tencent.mm.sdk.platformtools.v.w(r3, r10, r11);
    L_0x010e:
        r2 = r5.field_flag;
        r10 = r6.field_lastSeq;
        r12 = r5.field_msgSeq;
        r3 = r6.field_UnDeliverCount;
        r14 = (long) r3;
        r3 = "MicroMsg.ConversationStorage";
        r16 = "summerbadcr check last message flag[%d], newseq[%d] oldseq[%d], undeliverCount[%d]";
        r17 = 4;
        r0 = r17;
        r0 = new java.lang.Object[r0];
        r17 = r0;
        r18 = 0;
        r19 = java.lang.Integer.valueOf(r2);
        r17[r18] = r19;
        r18 = 1;
        r19 = java.lang.Long.valueOf(r10);
        r17[r18] = r19;
        r18 = 2;
        r19 = java.lang.Long.valueOf(r12);
        r17[r18] = r19;
        r18 = 3;
        r19 = java.lang.Long.valueOf(r14);
        r17[r18] = r19;
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.i(r3, r0, r1);
        r0 = r22;
        r3 = r0.nws;
        r16 = "insert";
        r0 = r16;
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x0161;
    L_0x015b:
        r0 = r22;
        r3 = r0.nwu;
        if (r3 > 0) goto L_0x017c;
    L_0x0161:
        r0 = r22;
        r3 = r0.nws;
        r16 = "update";
        r0 = r16;
        r3 = r3.equals(r0);
        if (r3 == 0) goto L_0x026f;
    L_0x0170:
        r3 = r6.field_unReadCount;
        r0 = r22;
        r0 = r0.nwu;
        r16 = r0;
        r3 = r3 + r16;
        if (r3 < 0) goto L_0x026f;
    L_0x017c:
        r3 = r6.field_unReadCount;
        r0 = r22;
        r0 = r0.nwu;
        r16 = r0;
        r3 = r3 + r16;
        r6.df(r3);
        r3 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r3 <= 0) goto L_0x01e6;
    L_0x018d:
        r3 = "MicroMsg.ConversationStorage";
        r16 = "summerbadcr insert or update reset lastseq[%d]";
        r17 = 1;
        r0 = r17;
        r0 = new java.lang.Object[r0];
        r17 = r0;
        r18 = 0;
        r19 = java.lang.Long.valueOf(r12);
        r17[r18] = r19;
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.i(r3, r0, r1);
        r16 = 0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 <= 0) goto L_0x026a;
    L_0x01b0:
        r3 = r2 & 2;
        if (r3 != 0) goto L_0x026a;
    L_0x01b4:
        r3 = "MicroMsg.ConversationStorage";
        r16 = "summerbadcr insert or update reset lastseq but undeliver flag not match[%d, %d, %d, %d]";
        r17 = 4;
        r0 = r17;
        r0 = new java.lang.Object[r0];
        r17 = r0;
        r18 = 0;
        r12 = java.lang.Long.valueOf(r12);
        r17[r18] = r12;
        r12 = 1;
        r10 = java.lang.Long.valueOf(r10);
        r17[r12] = r10;
        r10 = 2;
        r11 = java.lang.Long.valueOf(r14);
        r17[r10] = r11;
        r10 = 3;
        r2 = java.lang.Integer.valueOf(r2);
        r17[r10] = r2;
        r0 = r16;
        r1 = r17;
        com.tencent.mm.sdk.platformtools.v.i(r3, r0, r1);
    L_0x01e6:
        r2 = r5.bwo();
        if (r2 == 0) goto L_0x01f8;
    L_0x01ec:
        r2 = r5.field_isSend;
        r3 = 1;
        if (r2 != r3) goto L_0x01f8;
    L_0x01f1:
        r2 = r5.field_createTime;
        r6.field_sightTime = r2;
        r2 = 1;
        r6.bCX = r2;
    L_0x01f8:
        r0 = r22;
        r2 = r0.nws;
        r3 = "insert";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0307;
    L_0x0205:
        r0 = r22;
        r2 = r0.nwt;
        r2 = r2.size();
        if (r2 <= 0) goto L_0x0307;
    L_0x020f:
        r0 = r22;
        r2 = r0.bdo;
        r2 = com.tencent.mm.model.m.dE(r2);
        if (r2 == 0) goto L_0x0307;
    L_0x0219:
        r10 = com.tencent.mm.model.k.xF();
        r0 = r22;
        r2 = r0.nwt;
        r11 = r2.iterator();
    L_0x0225:
        r2 = r11.hasNext();
        if (r2 == 0) goto L_0x0307;
    L_0x022b:
        r2 = r11.next();
        r2 = (com.tencent.mm.storage.at) r2;
        r3 = r2.field_isSend;
        r12 = 1;
        if (r3 == r12) goto L_0x0253;
    L_0x0236:
        r3 = r2.bwm();
        if (r3 != 0) goto L_0x0246;
    L_0x023c:
        r3 = r2.field_type;
        r12 = 503316529; // 0x1e000031 float:6.776303E-21 double:2.48671406E-315;
        if (r3 != r12) goto L_0x02e6;
    L_0x0243:
        r3 = 1;
    L_0x0244:
        if (r3 == 0) goto L_0x0253;
    L_0x0246:
        r3 = r2.Mw(r10);
        if (r3 == 0) goto L_0x02e9;
    L_0x024c:
        r3 = r6.field_atCount;
        r3 = r3 + 1;
        r6.dl(r3);
    L_0x0253:
        r2 = r2.field_content;
        r3 = "sysmsg";
        r2 = com.tencent.mm.b.f.q(r2, r3);
        r3 = com.tencent.mm.storage.at.V(r2);
        if (r3 == 0) goto L_0x02f8;
    L_0x0262:
        r2 = r6.field_UnReadInvite;
        r2 = r2 + 1;
        r6.do(r2);
        goto L_0x0225;
    L_0x026a:
        r6.u(r12);
        goto L_0x01e6;
    L_0x026f:
        if (r9 <= 0) goto L_0x01e6;
    L_0x0271:
        r2 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));
        if (r2 >= 0) goto L_0x01e6;
    L_0x0275:
        r2 = com.tencent.mm.plugin.f.a.a.d.class;
        r2 = com.tencent.mm.kernel.g.f(r2);
        r2 = (com.tencent.mm.plugin.f.a.a.d) r2;
        r2 = r2.azI();
        r3 = r6.field_username;
        r2 = r2.T(r3, r10);
        r2 = r2.field_msgId;
        r14 = 0;
        r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1));
        if (r2 != 0) goto L_0x01e6;
    L_0x028f:
        r2 = com.tencent.mm.plugin.f.a.a.d.class;
        r2 = com.tencent.mm.kernel.g.f(r2);
        r2 = (com.tencent.mm.plugin.f.a.a.d) r2;
        r2 = r2.azI();
        r3 = r6.field_username;
        r14 = r2.Ni(r3);
        r2 = "MicroMsg.ConversationStorage";
        r3 = "summerbadcr delete reset lastseq[%d, %d], lastMsgSeq[%d]";
        r16 = 3;
        r0 = r16;
        r0 = new java.lang.Object[r0];
        r16 = r0;
        r17 = 0;
        r18 = java.lang.Long.valueOf(r10);
        r16[r17] = r18;
        r17 = 1;
        r18 = java.lang.Long.valueOf(r12);
        r16[r17] = r18;
        r17 = 2;
        r18 = java.lang.Long.valueOf(r14);
        r16[r17] = r18;
        r0 = r16;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r0);
        r6.u(r12);
        r2 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r2 <= 0) goto L_0x01e6;
    L_0x02d3:
        r2 = com.tencent.mm.plugin.f.a.a.d.class;
        r2 = com.tencent.mm.kernel.g.f(r2);
        r2 = (com.tencent.mm.plugin.f.a.a.d) r2;
        r2 = r2.xw();
        r3 = r6.field_username;
        r2.Q(r3, r14);
        goto L_0x01e6;
    L_0x02e6:
        r3 = 0;
        goto L_0x0244;
    L_0x02e9:
        r3 = r2.Mx(r10);
        if (r3 == 0) goto L_0x0253;
    L_0x02ef:
        r3 = r6.field_atCount;
        r3 = r3 + 4096;
        r6.dl(r3);
        goto L_0x0253;
    L_0x02f8:
        r2 = com.tencent.mm.storage.at.W(r2);
        if (r2 == 0) goto L_0x0225;
    L_0x02fe:
        r2 = r6.field_UnReadInvite;
        r2 = r2 + 4096;
        r6.do(r2);
        goto L_0x0225;
    L_0x0307:
        r10 = "MicroMsg.ConversationStorage";
        r11 = "summerbadcr updateConversation talker[%s] msgseq[%d],newConv[%b],newMsgInsertCount[%d], deleteCount[%d], tid[%d]";
        r2 = 6;
        r12 = new java.lang.Object[r2];
        r2 = 0;
        r12[r2] = r4;
        r13 = 1;
        if (r5 == 0) goto L_0x0360;
    L_0x0316:
        r2 = r5.field_msgSeq;
    L_0x0318:
        r2 = java.lang.Long.valueOf(r2);
        r12[r13] = r2;
        r2 = 2;
        r3 = java.lang.Boolean.valueOf(r7);
        r12[r2] = r3;
        r2 = 3;
        r3 = java.lang.Integer.valueOf(r8);
        r12[r2] = r3;
        r2 = 4;
        r3 = java.lang.Integer.valueOf(r9);
        r12[r2] = r3;
        r2 = 5;
        r3 = java.lang.Thread.currentThread();
        r14 = r3.getId();
        r3 = java.lang.Long.valueOf(r14);
        r12[r2] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r10, r11, r12);
        r0 = r20;
        r2 = r0.nuE;
        r2.bg(r6);
        r0 = r20;
        r2 = r0.nuE;
        r2.Ls();
        if (r4 != 0) goto L_0x0363;
    L_0x0355:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "talker == null";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);
        goto L_0x000b;
    L_0x0360:
        r2 = -1;
        goto L_0x0318;
    L_0x0363:
        r2 = r6.field_username;
        r2 = r4.equals(r2);
        if (r2 != 0) goto L_0x0376;
    L_0x036b:
        r2 = "MicroMsg.ConversationStorage";
        r3 = "process message for conversation failed: inconsist username";
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);
        goto L_0x000b;
    L_0x0376:
        if (r5 == 0) goto L_0x041e;
    L_0x0378:
        r2 = r5.field_msgId;
        r10 = 0;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x041e;
    L_0x0380:
        r2 = "MicroMsg.ConversationStorage";
        r3 = new java.lang.StringBuilder;
        r10 = "onNotifyChange   msgId:";
        r3.<init>(r10);
        r10 = r5.field_msgId;
        r3 = r3.append(r10);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.v(r2, r3);
        r6.M(r5);
        r0 = r20;
        r2 = r0.nuB;
        if (r2 == 0) goto L_0x03a8;
    L_0x03a1:
        r0 = r20;
        r2 = r0.nuB;
        r2.a(r5, r6);
    L_0x03a8:
        r2 = 1;
        r10 = r5.field_createTime;
        r2 = a(r6, r2, r10);
        r6.t(r2);
        if (r7 == 0) goto L_0x0414;
    L_0x03b4:
        r2 = com.tencent.mm.plugin.f.a.a.d.class;
        r2 = com.tencent.mm.kernel.g.f(r2);
        r2 = (com.tencent.mm.plugin.f.a.a.d) r2;
        r2 = r2.wH();
        r2 = r2.LX(r4);
        if (r2 == 0) goto L_0x03de;
    L_0x03c6:
        r3 = r2.field_username;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r3 != 0) goto L_0x03de;
    L_0x03ce:
        r2 = r2.tP();
        if (r2 == 0) goto L_0x03de;
    L_0x03d4:
        r2 = 2;
        r10 = 0;
        r2 = a(r6, r2, r10);
        r6.t(r2);
    L_0x03de:
        a(r6, r9, r8);
        r2 = r5.bwo();
        if (r2 == 0) goto L_0x040c;
    L_0x03e7:
        r2 = r5.field_createTime;
        r6.s(r2);
    L_0x03ec:
        r0 = r20;
        r0.d(r6);
    L_0x03f1:
        r0 = r20;
        r2 = r0.nuF;
        r2.bg(r6);
        r0 = r20;
        r2 = r0.nuF;
        r2.Ls();
        r0 = r20;
        r2 = r0.nuD;
        r3 = r20;
        r10 = r22;
        r2.a(r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x000b;
    L_0x040c:
        r2 = com.tencent.mm.sdk.platformtools.be.Ni();
        r6.s(r2);
        goto L_0x03ec;
    L_0x0414:
        a(r6, r9, r8);
        r2 = 1;
        r0 = r20;
        r0.a(r6, r4, r2);
        goto L_0x03f1;
    L_0x041e:
        r2 = "MicroMsg.ConversationStorage";
        r3 = new java.lang.StringBuilder;
        r10 = "update null conversation with talker ";
        r3.<init>(r10);
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.v.i(r2, r3);
        if (r7 != 0) goto L_0x0443;
    L_0x0436:
        r6.bvG();
        a(r6, r9, r8);
        r2 = 1;
        r0 = r20;
        r0.a(r6, r4, r2);
        goto L_0x03f1;
    L_0x0443:
        r2 = com.tencent.mm.plugin.f.a.a.d.class;
        r2 = com.tencent.mm.kernel.g.f(r2);
        r2 = (com.tencent.mm.plugin.f.a.a.d) r2;
        r2 = r2.azI();
        r2 = r2.MW(r4);
        if (r2 <= 0) goto L_0x03f1;
    L_0x0455:
        r2 = r5.bwo();
        if (r2 == 0) goto L_0x0469;
    L_0x045b:
        r2 = r5.field_createTime;
        r6.s(r2);
    L_0x0460:
        a(r6, r9, r8);
        r0 = r20;
        r0.d(r6);
        goto L_0x03f1;
    L_0x0469:
        r2 = com.tencent.mm.sdk.platformtools.be.Ni();
        r6.s(r2);
        goto L_0x0460;
    L_0x0471:
        r2 = r3;
        goto L_0x00a9;
    L_0x0474:
        r8 = r3;
        goto L_0x00c1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.ac.a(com.tencent.mm.storage.au, com.tencent.mm.storage.au$c):void");
    }

    public static long a(ab abVar, int i, long j) {
        if (abVar == null) {
            return 0;
        }
        if (j == 0) {
            j = be.Ni();
        }
        switch (i) {
            case 2:
                return a(abVar, j) | 4611686018427387904L;
            case 3:
                return a(abVar, j) & -4611686018427387905L;
            case 4:
                return a(abVar, j) & 4611686018427387904L;
            case 5:
                return a(abVar, j) | 1152921504606846976L;
            case 6:
                return a(abVar, j) & -1152921504606846977L;
            case 7:
                return a(abVar, j) & 1152921504606846976L;
            default:
                return a(abVar, j);
        }
    }

    private static long a(ab abVar, long j) {
        return (abVar.field_flag & -72057594037927936L) | (72057594037927935L & j);
    }

    private static long c(ab abVar) {
        if (abVar != null) {
            return a(abVar, abVar.field_conversationTime);
        }
        return be.Ni() & 72057594037927935L;
    }

    public final void Mf(String str) {
        v.w("MicroMsg.ConversationStorage", "delChatContact username:%s  stack:%s", str, af.btA());
        if (this.cie.delete(Me(str), "username=?", new String[]{str}) != 0) {
            b(5, this, str);
        }
    }

    public final boolean Mg(String str) {
        v.w("MicroMsg.ConversationStorage", "deleteMessageEndByName nameTag:%s  stack:%s", str, af.btA());
        boolean dF = this.cie.dF("rconversation", "delete from " + Me(str) + " where username like '%" + str + "'");
        if (dF) {
            b(5, this, str);
        }
        return dF;
    }

    public final ab Mh(String str) {
        Cursor query = this.cie.query(Me(str), null, "username=?", new String[]{str}, null, null, null);
        if (query.getCount() <= 0) {
            v.w("MicroMsg.ConversationStorage", "get null with username:" + str);
            query.close();
            return null;
        }
        query.moveToFirst();
        ab abVar = new ab();
        abVar.b(query);
        query.close();
        return abVar;
    }

    public final void N(at atVar) {
        String str = atVar.field_talker;
        boolean z = false;
        ab Mh = Mh(str);
        if (Mh == null || Mh.field_conversationTime <= atVar.field_createTime || Mh.field_conversationTime == Long.MAX_VALUE) {
            if (Mh == null) {
                Mh = new ab(str);
                z = true;
            }
            Mh.di(atVar.field_isSend);
            Mh.df(Mh.field_unReadCount);
            Mh.M(atVar);
            Mh.ct(Integer.toString(atVar.field_type));
            Mh.t((Mh.field_flag & 4611686018427387904L) | (atVar.field_createTime & 72057594037927935L));
            if (z) {
                d(Mh);
                return;
            } else {
                a(Mh, str, true);
                return;
            }
        }
        v.i("MicroMsg.ConversationStorage", "updateConvFromLastMsg ignore(maybe the system time is bigger than normal)");
    }

    public final long d(ab abVar) {
        String ma = be.ma(abVar.field_username);
        if (ma.length() <= 0) {
            v.e("MicroMsg.ConversationStorage", "insert conversation failed, username empty");
            return -1;
        }
        abVar.t(c(abVar));
        e(abVar);
        long insert = this.cie.insert(Me(ma), null, abVar.py());
        if (insert != -1) {
            b(2, this, abVar.field_username);
        } else {
            v.e("MicroMsg.ConversationStorage", "insert failed return -1, table:%s", Me(ma));
        }
        return insert;
    }

    public static void a(ab abVar, int i, int i2) {
        if (!((com.tencent.mm.plugin.f.a.a.d) com.tencent.mm.kernel.g.f(com.tencent.mm.plugin.f.a.a.d.class)).azI().MX(abVar.field_username)) {
            return;
        }
        if (be.ma(abVar.field_username).length() <= 0) {
            v.e("MicroMsg.ConversationStorage", "countMsg conversation failed, username empty");
            return;
        }
        if (abVar.field_msgCount == 0) {
            abVar.de(((com.tencent.mm.plugin.f.a.a.d) com.tencent.mm.kernel.g.f(com.tencent.mm.plugin.f.a.a.d.class)).azI().MY(abVar.field_username));
            v.i("MicroMsg.ConversationStorage", "getMsgCount from message table");
        } else if (i > 0) {
            abVar.de(abVar.field_msgCount - i);
            if (abVar.field_msgCount < 0) {
                v.e("MicroMsg.ConversationStorage", "msg < 0 ,some path must be ignore!");
                abVar.de(0);
            }
        } else if (i2 > 0) {
            abVar.de(abVar.field_msgCount + i2);
        }
        v.i("MicroMsg.ConversationStorage", "countMsg %d talker :%s deleteCount:%d insertCount:%d", Integer.valueOf(abVar.field_msgCount), abVar.field_username, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void bvH() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.cie.update("rconversation", contentValues, null, null);
    }

    public final void Mi(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgCount", Integer.valueOf(0));
        this.cie.update("rconversation", contentValues, "username=?", new String[]{str});
    }

    public final boolean Mj(String str) {
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.ConversationStorage", "update conversation failed");
            return false;
        }
        com.tencent.mm.e.b.af Mh = Mh(str);
        if (Mh == null) {
            return true;
        }
        if (Mh.field_unReadCount == 0 && Mh.field_unReadMuteCount == 0 && str.equals(Mh.field_username)) {
            b(str, 1048576, false, Mh.field_attrflag);
            ContentValues contentValues = new ContentValues();
            contentValues.put("UnReadInvite", Integer.valueOf(0));
            if (this.cie.update(Me(str), contentValues, "username= ?", new String[]{be.lZ(str)}) <= 0) {
                return true;
            }
            b(3, this, str);
            return true;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("unReadCount", Integer.valueOf(0));
        contentValues2.put("unReadMuteCount", Integer.valueOf(0));
        contentValues2.put("UnReadInvite", Integer.valueOf(0));
        contentValues2.put("atCount", Integer.valueOf(0));
        contentValues2.put("attrflag", Integer.valueOf(Mh.field_attrflag & -1048577));
        int update = this.cie.update(Me(str), contentValues2, "username= ?", new String[]{be.lZ(str)});
        if (update > 0) {
            b(3, this, str);
        }
        if (update <= 0) {
            return false;
        }
        return true;
    }

    public final boolean b(String str, int i, boolean z, int i2) {
        if (be.kS(str)) {
            return false;
        }
        if (Mh(str) == null) {
            return true;
        }
        int i3;
        if (z) {
            i3 = i2 | i;
        } else {
            i3 = (i ^ -1) & i2;
        }
        if (i3 == i2) {
            return false;
        }
        boolean dF = this.cie.dF("rconversation", "update " + Me(str) + " set attrflag = " + i3 + " where username = \"" + be.lZ(str) + "\"");
        if (!dF) {
            return dF;
        }
        b(3, this, str);
        return dF;
    }

    public final int a(ab abVar, String str) {
        return a(abVar, str, true);
    }

    public final int a(ab abVar, String str, boolean z) {
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.ConversationStorage", "update conversation failed");
            return 0;
        }
        if (z) {
            abVar.t(c(abVar));
        }
        e(abVar);
        int update = this.cie.update(Me(str), abVar.py(), "username=?", new String[]{str});
        if (update != 0) {
            b(3, this, str);
            return update;
        }
        v.e("MicroMsg.ConversationStorage", "update failed return 0,  table:%s", Me(str));
        return update;
    }

    private static void e(ab abVar) {
        if (abVar != null && abVar.field_unReadCount > 0) {
            v.d("MicroMsg.ConversationStorage", "jacks check attrFlag & cancel mark");
            if ((abVar.field_attrflag & 1048576) != 0) {
                abVar.df(abVar.field_unReadCount - 1);
                abVar.dk(abVar.field_attrflag & -1048577);
            }
        }
    }

    private long bvI() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = 0;
        Cursor rawQuery = this.cie.rawQuery("select max(conversationTime) as conversationTime from rconversation", null);
        while (rawQuery.moveToNext()) {
            j = rawQuery.getLong(0);
        }
        rawQuery.close();
        v.d("MicroMsg.ConversationStorage", "latestConversationTime = %s, cost = %d", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return j;
    }

    public final boolean Mk(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.ConversationStorage", "setMoveUp conversation failed");
        } else {
            ab Mh = Mh(str);
            if (Mh == null) {
                v.e("MicroMsg.ConversationStorage", "setMoveUp conv == null");
            } else {
                z = this.cie.dF("rconversation", "update " + Me(Mh.field_username) + " set flag = " + a(Mh, 1, bvI() + 1) + " where username = \"" + be.lZ(Mh.field_username) + "\"");
                if (z) {
                    b(3, this, Mh.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Ml(String str) {
        boolean z = false;
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.ConversationStorage", "setPlacedTop conversation failed");
        } else {
            ab abVar;
            if (Mh(str) == null) {
                abVar = new ab(str);
                abVar.s(System.currentTimeMillis());
                d(abVar);
                v.i("MicroMsg.ConversationStorage", "setPlacedTop username = " + str);
            }
            abVar = Mh(str);
            if (abVar != null) {
                z = this.cie.dF("rconversation", "update " + Me(abVar.field_username) + " set flag = " + a(abVar, 2, 0) + " where username = \"" + be.lZ(abVar.field_username) + "\"");
                if (z) {
                    b(3, this, abVar.field_username);
                }
            }
        }
        return z;
    }

    public final boolean Mm(String str) {
        if (str != null && str.length() > 0) {
            return f(Mh(str));
        }
        v.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation failed");
        return false;
    }

    public final boolean f(ab abVar) {
        if (abVar == null) {
            v.e("MicroMsg.ConversationStorage", "unSetPlacedTop conversation null");
            return false;
        }
        boolean dF = this.cie.dF("rconversation", "update " + Me(abVar.field_username) + " set flag = " + a(abVar, 3, abVar.field_conversationTime) + " where username = \"" + be.lZ(abVar.field_username) + "\"");
        if (!dF) {
            return dF;
        }
        b(3, this, abVar.field_username);
        return dF;
    }

    public final boolean Mn(String str) {
        if (str != null && str.length() > 0) {
            return g(Mh(str));
        }
        v.e("MicroMsg.ConversationStorage", "isPlacedTop failed");
        return false;
    }

    public static boolean g(ab abVar) {
        if (abVar == null) {
            v.e("MicroMsg.ConversationStorage", "isPlacedTop failed, conversation null");
            return false;
        } else if (a(abVar, 4, 0) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final Cursor b(String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from rconversation where ");
        if (com.tencent.mm.j.a.cht == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(be.lZ(str2)).append("' ");
        }
        stringBuilder.append(be.ma(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc, conversationTime").append(" desc");
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }

    public final List<String> bvJ() {
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select rconversation.username from rconversation").append(",rcontact where ");
        stringBuilder.append("rconversation.username = rcontact.username");
        stringBuilder.append(be.ma(be.ma(m.crA)));
        stringBuilder.append(" and ( verifyFlag & 8 ) = 0");
        stringBuilder.append(" and ( rconversation.parentRef is null  or ").append("rconversation.parentRef = '' ) ");
        for (String append : m.crG) {
            stringBuilder.append(" and rconversation.username != '").append(append).append("'");
        }
        stringBuilder.append(" order by sightTime desc, flag").append(" desc, conversationTime desc");
        Cursor rawQuery = this.cie.rawQuery(stringBuilder.toString(), null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        v.d("MicroMsg.ConversationStorage", "user list:%s", arrayList);
        return arrayList;
    }

    public final Cursor a(String str, List<String> list, String str2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType, flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where ");
        if (com.tencent.mm.j.a.cht == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(be.lZ(str2)).append("' ");
        }
        stringBuilder.append(be.ma(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        stringBuilder.append(" order by flag desc");
        v.d("MicroMsg.ConversationStorage", "getNecessaryCursor sql " + stringBuilder.toString());
        return this.cie.aH(stringBuilder.toString(), z);
    }

    public final Cursor a(ArrayList<String> arrayList, String str, List<String> list, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select unReadCount, status, isSend, conversationTime, username, content, msgType,flag, digest, digestUser, attrflag, editingMsg, atCount, unReadMuteCount, UnReadInvite");
        stringBuilder.append(" from rconversation where (");
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != arrayList.size() - 1) {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "' OR ");
            } else {
                stringBuilder.append("username = '" + ((String) arrayList.get(i)) + "'");
            }
        }
        stringBuilder.append(") and ");
        if (com.tencent.mm.j.a.cht == str2) {
            stringBuilder.append(" ( parentRef is null  or ").append("parentRef = '' ) ");
        } else if ("*".equals(str2)) {
            stringBuilder.append(" 1 = 1 ");
        } else {
            stringBuilder.append("parentRef = '").append(be.lZ(str2)).append("' ");
        }
        stringBuilder.append(be.ma(str));
        if (list != null && list.size() > 0) {
            for (String append : list) {
                stringBuilder.append(" and rconversation.username").append(" != '").append(append).append("'");
            }
        }
        v.d("MicroMsg.ConversationStorage", "getNecessaryCursorByNames sql " + stringBuilder.toString());
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }

    public final Cursor b(String str, List<String> list, boolean z, String str2) {
        String str3 = " ";
        String str4 = " ";
        if (str2 != null && str2.length() > 0) {
            str4 = " and rconversation.username = rcontact.username ";
        }
        String str5 = "select unReadCount, status, isSend, conversationTime, rconversation.username, content, rconversation.msgType, rconversation.flag, rconversation.digest, rconversation.digestUser, rconversation.hasTrunc, rcontact.nickname from rconversation,rcontact" + str3 + " where rconversation.username" + " = rcontact.username" + str4 + be.ma(str);
        str4 = SQLiteDatabase.KeyEmpty;
        if (list != null && list.size() > 0) {
            str3 = str4;
            for (String str42 : list) {
                str3 = str3 + " and rconversation.username != '" + str42 + "'";
            }
            str42 = str3;
        }
        str42 = str5 + str42;
        if (z) {
            str42 = str42 + " and ( verifyFlag & 8 ) = 0";
        }
        if (str2 != null && str2.length() > 0) {
            str42 = str42 + (" and ( rconversation.username like '%" + str2 + "%' or content like '%" + str2 + "%' or rcontact.nickname" + " like '%" + str2 + "%' or rcontact.alias" + " like '%" + str2 + "%' or rcontact.pyInitial" + " like '%" + str2 + "%' or rcontact.quanPin" + " like '%" + str2 + "%' or rcontact.conRemark" + " like '%" + str2 + "%'  ) ");
        }
        if (str2 == null || str2.equals(SQLiteDatabase.KeyEmpty)) {
            str42 = str42 + " order by flag desc, conversationTime desc";
        } else {
            str42 = str42 + " order by rconversation.username like \"%@chatroom\" asc";
        }
        v.d("MicroMsg.ConversationStorage", "getSearchCursor sql " + str42);
        return this.cie.rawQuery(str42, null);
    }

    public final void ai(LinkedList<String> linkedList) {
        v.w("MicroMsg.ConversationStorage", "deleteConversations   stack:%s", af.btA());
        if (linkedList.isEmpty()) {
            v.w("MicroMsg.ConversationStorage", "deleteConversation:namelist is null");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = (String) linkedList.poll();
        stringBuilder.append("delete from rconversation where ");
        stringBuilder.append("username='").append(str).append('\'');
        while (!linkedList.isEmpty()) {
            stringBuilder.append(" or username='").append((String) linkedList.poll()).append('\'');
        }
        v.i("MicroMsg.ConversationStorage", "deleteConversations:sql is %s", stringBuilder.toString());
        this.cie.dF("rconversation", stringBuilder.toString());
    }

    public final List<String> bvK() {
        List linkedList = new LinkedList();
        List<String> linkedList2 = new LinkedList();
        String str = "select username from rconversation";
        int i = 0;
        while (i < linkedList.size()) {
            String str2 = str + (i > 0 ? " and " : " where ") + "username != \"" + be.lZ((String) linkedList.get(i)) + "\"";
            i++;
            str = str2;
        }
        Cursor rawQuery = this.cie.rawQuery(str + " order by flag desc, conversationTime desc", null);
        while (rawQuery.moveToNext()) {
            linkedList2.add(rawQuery.getString(rawQuery.getColumnIndex("username")));
        }
        rawQuery.close();
        return linkedList2;
    }

    public final Cursor g(List<String> list, int i) {
        String str = "select username from rconversation";
        int i2 = 0;
        while (i2 < list.size()) {
            String str2 = str + (i2 > 0 ? " and " : " where ") + "username != \"" + be.lZ((String) list.get(i2)) + "\"";
            i2++;
            str = str2;
        }
        return this.cie.rawQuery(str + " order by flag desc, conversationTime desc limit 50 offset " + i, null);
    }

    public final Cursor bvL() {
        return this.cie.rawQuery("select * from rbottleconversation order by flag desc, conversationTime desc", null);
    }

    public final boolean Mo(String str) {
        boolean z;
        Cursor query = this.cie.query(Me(str), null, "username=?", new String[]{str}, null, null, null);
        if (query.getCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        query.close();
        return z;
    }

    public final Cursor Mp(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT username, unReadCount");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE username LIKE '%@chatroom' ");
        stringBuilder.append(be.ma(str));
        stringBuilder.append(" AND unReadCount > 0");
        return this.cie.rawQuery(stringBuilder.toString(), null);
    }

    public final String bvM() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = 'officialaccounts").append("'");
        stringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
        stringBuilder.append(" LIMIT 1 ");
        v.i("MicroMsg.ConversationStorage", "get last conversation user, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.cie.rawQuery(r1, null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            String string = rawQuery.getString(0);
            rawQuery.close();
            return string;
        }
        rawQuery.close();
        return null;
    }

    public final int Mq(String str) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        v.i("MicroMsg.ConversationStorage", "get enterprise conversation count, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.cie.rawQuery(r1, null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }

    public final String Mr(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT rconversation.username");
        stringBuilder.append(" FROM rconversation");
        stringBuilder.append(" WHERE parentRef = '").append(str).append("'");
        stringBuilder.append(" ORDER BY conversationTime DESC, conversationTime").append(" DESC ");
        stringBuilder.append(" LIMIT 1 ");
        v.i("MicroMsg.ConversationStorage", "get last enterprise conversation user, sql is %s", stringBuilder.toString());
        Cursor rawQuery = this.cie.rawQuery(r1, null);
        if (rawQuery == null) {
            return null;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            String string = rawQuery.getString(0);
            rawQuery.close();
            return string;
        }
        rawQuery.close();
        return null;
    }

    public final int fv(String str) {
        int i = 0;
        Cursor rawQuery = this.cie.rawQuery("select sum(unReadCount) from rconversation,rcontact where rconversation.username = rcontact.username" + be.ma(str), null);
        if (rawQuery.getCount() > 0) {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        return i;
    }

    public static ab bvN() {
        Cursor b = ((com.tencent.mm.plugin.f.a.a.d) com.tencent.mm.kernel.g.f(com.tencent.mm.plugin.f.a.a.d.class)).wK().b(m.crA, null, "officialaccounts");
        if (b == null) {
            return null;
        }
        ab abVar;
        if (b.getCount() <= 0 || !b.moveToFirst()) {
            abVar = null;
        } else {
            abVar = new ab();
            abVar.b(b);
        }
        b.close();
        return abVar;
    }

    public static ab Ms(String str) {
        Cursor b = ((com.tencent.mm.plugin.f.a.a.d) com.tencent.mm.kernel.g.f(com.tencent.mm.plugin.f.a.a.d.class)).wK().b(m.crA, null, str);
        if (b == null) {
            return null;
        }
        ab abVar;
        if (b.getCount() <= 0 || !b.moveToFirst()) {
            abVar = null;
        } else {
            abVar = new ab();
            abVar.b(b);
        }
        b.close();
        return abVar;
    }

    public final void c(String[] strArr, String str) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update rconversation");
        stringBuilder.append(" set parentRef = '").append(be.ma(str)).append("' where 1 != 1 ");
        for (i = 0; i <= 0; i++) {
            stringBuilder.append(" or username = '").append(strArr[0]).append("'");
        }
        v.d("MicroMsg.ConversationStorage", "update sql: %s", stringBuilder.toString());
        if (this.cie.dF("rconversation", stringBuilder.toString())) {
            for (i = 0; i <= 0; i++) {
                b(3, this, strArr[0]);
            }
        }
    }

    public static String ao(int i, String str) {
        if (be.kS(str)) {
            return null;
        }
        switch (i) {
            case 49:
                Map q = bf.q(str, "msg");
                if (q == null) {
                    return null;
                }
                v.d("MicroMsg.ConversationStorage", "[oneliang][parseConversationMsgContentTitle] title:%s", (String) q.get(".msg.appmsg.title"));
                return (String) q.get(".msg.appmsg.title");
            default:
                return null;
        }
    }

    protected final boolean EP() {
        if (this.cie != null && !this.cie.buA()) {
            return true;
        }
        String str = "MicroMsg.ConversationStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.cie == null ? "null" : Boolean.valueOf(this.cie.buA());
        v.w(str, str2, objArr);
        return false;
    }

    public final int Mt(String str) {
        int i = -1;
        if (str != null && str.length() > 0) {
            Cursor rawQuery = this.cie.rawQuery("select msgCount from rconversation where username=" + com.tencent.mm.bg.g.dM(str), null);
            if (rawQuery.getCount() != 0) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        return i;
    }
}
