package com.tencent.mm.plugin.multitalk.b;

import android.database.Cursor;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "MultiTalkMember"), "CREATE INDEX IF NOT EXISTS idx_MultiTalkMember  on MultiTalkMember  (  wxGroupId )"};

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "MultiTalkMember", null);
    }

    public final c ch(String str, String str2) {
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "' and userName ='" + str2 + "'", new String[0]);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToNext()) {
                    c cVar = new c();
                    cVar.field_memberUuid = (long) rawQuery.getInt(0);
                    cVar.field_wxGroupId = rawQuery.getString(1);
                    cVar.field_userName = rawQuery.getString(2);
                    cVar.field_inviteUserName = rawQuery.getString(3);
                    cVar.field_memberId = rawQuery.getLong(4);
                    cVar.field_status = rawQuery.getInt(5);
                    cVar.field_createTime = rawQuery.getLong(6);
                    v.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMember get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", new Object[]{Long.valueOf(cVar.field_memberUuid), cVar.field_wxGroupId, cVar.field_userName, cVar.field_inviteUserName, Long.valueOf(cVar.field_memberId), Integer.valueOf(cVar.field_status), Long.valueOf(cVar.field_createTime)});
                    if (rawQuery == null) {
                        return cVar;
                    }
                    rawQuery.close();
                    return cVar;
                }
            } catch (Exception e) {
                v.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (Throwable th) {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return null;
    }

    public final LinkedList<c> wU(String str) {
        Cursor rawQuery = rawQuery("select memberUuid, wxGroupId, userName, inviteUserName, memberId, status,createTime  from MultiTalkMember  where wxGroupId = '" + str + "'", new String[0]);
        LinkedList<c> linkedList = new LinkedList();
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                c cVar = new c();
                cVar.field_memberUuid = (long) rawQuery.getInt(0);
                cVar.field_wxGroupId = rawQuery.getString(1);
                cVar.field_userName = rawQuery.getString(2);
                cVar.field_inviteUserName = rawQuery.getString(3);
                cVar.field_memberId = rawQuery.getLong(4);
                cVar.field_status = rawQuery.getInt(5);
                cVar.field_createTime = rawQuery.getLong(6);
                v.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "getMultiTalkMemberList get value for memberUuid = %s, wxGroupId = %s, userName = %s, inviteUserName = %s, memberId = %d, status = %d,createTime = %d", new Object[]{Long.valueOf(cVar.field_memberUuid), cVar.field_wxGroupId, cVar.field_userName, cVar.field_inviteUserName, Long.valueOf(cVar.field_memberId), Integer.valueOf(cVar.field_status), Long.valueOf(cVar.field_createTime)});
                linkedList.add(cVar);
            } catch (Exception e) {
                v.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", e.toString());
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

    public final boolean a(c cVar) {
        long j = cVar.field_memberUuid;
        Cursor rawQuery = rawQuery("select * from MultiTalkMember where memberUuid = '" + j + "' and wxGroupId = '" + cVar.field_wxGroupId + "'", new String[0]);
        boolean b;
        try {
            if (rawQuery.getCount() == 0) {
                b = b(cVar);
                v.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "insert ret " + b + " for memberUuid = " + j);
                return b;
            }
            b = a(cVar, new String[0]);
            v.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "update ret " + b + " for memberUuid = " + j);
            rawQuery.close();
            return b;
        } catch (Exception e) {
            b = e.toString();
            v.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", b);
            return false;
        } finally {
            rawQuery.close();
        }
    }

    public final boolean ci(String str, String str2) {
        v.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str + ",member = " + str2);
        try {
            super.dF("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\" and userName = \"" + str2 + "\"");
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str + ",member = " + str2);
            return false;
        }
    }

    public final boolean hc(String str) {
        v.i("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete where wxGroupId = " + str);
        try {
            super.dF("MultiTalkMember", "delete from MultiTalkMember where wxGroupId = \"" + str + "\"");
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.MultiTalk.storage.MultiTalkMemberStorage", "delete fail for wxGroupId = " + str);
            return false;
        }
    }
}
