package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.pb.common.c.h;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class b extends f<com.tencent.mm.ah.b> {
    public static final String[] cic = new String[]{f.a(com.tencent.mm.ah.b.chq, "MultiTalkInfo"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkInfo_key  on MultiTalkInfo  (  wxGroupId )"};
    public static LinkedHashMap<String, Class> gaM = new LinkedHashMap<String, Class>() {
        {
            put("wxGroupId", String.class);
            put("groupId", String.class);
            put("roomId", Integer.TYPE);
            put("roomKey", Long.TYPE);
            put("routeId", Integer.TYPE);
            put("createTime", Long.TYPE);
        }
    };

    public final com.tencent.mm.ah.b Rk(java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00d1 in list [B:7:0x00ce]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r2 = 1;
        r3 = 0;
        r0 = "MicroMsg.MultiTalk.storage.MultiTalkInfoStorage";
        r1 = "getMultiTaklInfo for wxGroupId = %s";
        r2 = new java.lang.Object[r2];
        r2[r3] = r9;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = new java.lang.StringBuilder;
        r1 = "select wxGroupId, groupId, roomId, roomKey, routeId, inviteUserName,memberCount,createTime,state from MultiTalkInfo where wxGroupId = '";
        r0.<init>(r1);
        r0 = r0.append(r9);
        r1 = "'";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = new java.lang.String[r3];
        r1 = r8.rawQuery(r0, r1);
        if (r1 == 0) goto L_0x00d2;
    L_0x002e:
        r0 = r1.moveToNext();	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        if (r0 == 0) goto L_0x00d2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
    L_0x0034:
        r0 = new com.tencent.mm.ah.b;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.<init>();	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 0;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_wxGroupId = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 1;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_groupId = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_roomId = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 3;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getLong(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_roomKey = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 4;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_routeId = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 5;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_inviteUserName = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_memberCount = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 7;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getLong(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_createTime = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = 8;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = r1.getInt(r2);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0.field_state = r2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r2 = "MicroMsg.MultiTalk.storage.MultiTalkInfoStorage";	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r3 = "getMultiTalkInfo got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d,inviteUser=%s,memberCount=%d, createTime=%d,field_state=%d";	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4 = 9;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 0;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_wxGroupId;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 1;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_groupId;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 2;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_roomId;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 3;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_roomKey;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 4;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_routeId;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 5;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_inviteUserName;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_memberCount;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 7;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_createTime;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r5 = 8;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = r0.field_state;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        if (r1 == 0) goto L_0x00d1;
    L_0x00ce:
        r1.close();
    L_0x00d1:
        return r0;
    L_0x00d2:
        if (r1 == 0) goto L_0x00d7;
    L_0x00d4:
        r1.close();
    L_0x00d7:
        r0 = 0;
        goto L_0x00d1;
    L_0x00d9:
        r0 = move-exception;
        r2 = "MicroMsg.MultiTalk.storage.MultiTalkInfoStorage";	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r4 = "getMultiTalkInfo error! ";	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        com.tencent.mm.sdk.platformtools.v.e(r2, r0);	 Catch:{ Exception -> 0x00d9, all -> 0x00fb }
        if (r1 == 0) goto L_0x00f9;
    L_0x00f6:
        r1.close();
    L_0x00f9:
        r0 = 0;
        goto L_0x00d1;
    L_0x00fb:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0101;
    L_0x00fe:
        r1.close();
    L_0x0101:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.b.Rk(java.lang.String):com.tencent.mm.ah.b");
    }

    public b(d dVar) {
        super(dVar, com.tencent.mm.ah.b.chq, "MultiTalkInfo", null);
    }

    public final LinkedList<com.tencent.mm.ah.b> aCK() {
        Cursor rawQuery = rawQuery("select wxGroupId, groupId, roomId, roomKey, routeId, createTime from MultiTalkInfo", new String[0]);
        LinkedList<com.tencent.mm.ah.b> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                com.tencent.mm.ah.b bVar = new com.tencent.mm.ah.b();
                bVar.field_wxGroupId = rawQuery.getString(0);
                bVar.field_groupId = rawQuery.getString(1);
                bVar.field_roomId = rawQuery.getInt(2);
                bVar.field_roomKey = rawQuery.getLong(3);
                bVar.field_routeId = rawQuery.getInt(4);
                bVar.field_createTime = rawQuery.getLong(5);
                v.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList got value for wxGroupId = %s, groupId=%s, roomId = %d, roomKey = %d, routeId = %d, createTime=%d", new Object[]{bVar.field_wxGroupId, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), Long.valueOf(bVar.field_createTime)});
                linkedList.add(bVar);
            } catch (Exception e) {
                v.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "getMultiTalkInfoList error!");
                return linkedList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return linkedList;
    }

    public final boolean a(com.tencent.mm.ah.b bVar) {
        String str = bVar.field_wxGroupId;
        if (h.ty(str)) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. multiTalkInfo wxGroupId is empty!");
            return false;
        }
        v.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d", new Object[]{str, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), bVar.field_inviteUserName, Integer.valueOf(bVar.field_memberCount), Long.valueOf(bVar.field_createTime)});
        try {
            boolean b = b(bVar);
            v.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "insert ret " + b + " for id=%s" + str);
            return b;
        } catch (Exception e) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            return false;
        }
    }

    public final boolean b(com.tencent.mm.ah.b bVar) {
        String str = bVar.field_wxGroupId;
        if (h.ty(str)) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. multiTalkInfo wxGroupId is empty!");
            return false;
        }
        v.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update. wxGroupId=%s, groupId=%s, roomId =%d, roomKey =%d, routeId =%d, inviteUser=%s,memberCount=%d,createTime=%d,state=%d", new Object[]{str, bVar.field_groupId, Integer.valueOf(bVar.field_roomId), Long.valueOf(bVar.field_roomKey), Integer.valueOf(bVar.field_routeId), bVar.field_inviteUserName, Integer.valueOf(bVar.field_memberCount), Long.valueOf(bVar.field_createTime), Integer.valueOf(bVar.field_state)});
        try {
            boolean a = a(bVar, new String[]{"wxGroupId"});
            v.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "update ret " + a + " for id=%s" + str);
            return a;
        } catch (Exception e) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "save mulitalTalk failure!" + e.toString());
            return false;
        }
    }

    public final boolean hc(String str) {
        v.i("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete id = %s", new Object[]{str});
        try {
            super.dF("MultiTalkInfo", "delete from MultiTalkInfo where wxGroupId = \"" + str + "\"");
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkInfoStorage", "delete fail for wxGroupId = " + str);
            return false;
        }
    }
}
