package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.f.a.a.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class n {
    private static final List<a> crH = new ArrayList();

    public interface a {
        boolean a(String str, String str2, PInt pInt);
    }

    private static int a(String str, Cursor cursor) {
        int i;
        long Nj = be.Nj();
        if (cursor == null || cursor.getCount() <= 0) {
            i = 0;
        } else {
            cursor.moveToFirst();
            i = cursor.getInt(0);
        }
        if (cursor != null) {
            cursor.close();
        }
        v.d("MicroMsg.ConversationLogic", "unreadcheck unRead getTotalUnread %d", Integer.valueOf(i));
        if (i <= 0) {
            return 0;
        }
        Cursor Mp = ((d) g.f(d.class)).wK().Mp(str);
        if (Mp == null) {
            v.w("MicroMsg.ConversationLogic", "cursor is null, return");
            v.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(be.az(Nj)));
            return i;
        }
        Mp.moveToFirst();
        while (!Mp.isAfterLast()) {
            int i2;
            ab LX = ((d) g.f(d.class)).wH().LX(Mp.getString(0));
            if (LX == null || LX.bCh != 0) {
                i2 = i;
            } else {
                i2 = i - Mp.getInt(1);
                v.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", LX.field_username, Integer.valueOf(i2));
            }
            Mp.moveToNext();
            i = i2;
        }
        v.i("MicroMsg.ConversationLogic", "unreadcheck  result talker count is %d", Integer.valueOf(i));
        Mp.close();
        v.i("MicroMsg.ConversationLogic", "unreadcheck get count use %d ms", Long.valueOf(be.az(Nj)));
        return Math.max(0, i);
    }

    public static int fv(String str) {
        return a(str, null);
    }

    public static int a(String str, List<String> list) {
        if (g.uz()) {
            long Nj = be.Nj();
            ac wK = ((d) g.f(d.class)).wK();
            v.i("MicroMsg.ConversationStorage", "getTotalUnreadCursor filter[%s] [%s]", str, be.bur());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select sum(unReadCount) from rconversation").append(", rcontact");
            stringBuilder.append(" where rconversation.unReadCount").append(" > 0 AND (rconversation.parentRef").append(" is ").append(com.tencent.mm.j.a.cht).append(" or parentRef = '' ) AND ").append("rconversation.username = ").append("rcontact.username").append(be.ma(str)).append(" AND ( type & 512").append(" ) == 0 AND rcontact.").append("username != 'officialaccounts'");
            if (!(list == null || list.isEmpty())) {
                for (String append : list) {
                    stringBuilder.append(" AND rconversation.username").append(" != '").append(append).append("'");
                }
            }
            v.v("MicroMsg.ConversationStorage", "get total unread with black list, sql is %s", stringBuilder.toString());
            Cursor rawQuery = wK.cie.rawQuery(append, null);
            int a = a(str, rawQuery);
            rawQuery.close();
            v.i("MicroMsg.ConversationLogic", "get count with black list use %d ms", Long.valueOf(be.az(Nj)));
            return a;
        }
        v.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        return 0;
    }

    public static int E(String str, String str2) {
        if (g.uz()) {
            int i;
            ac wK = ((d) g.f(d.class)).wK();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select unReadCount");
            stringBuilder.append(" from rconversation where username").append(" = '").append(str).append("' AND ( parentRef is ").append(com.tencent.mm.j.a.cht).append(" or parentRef = '' ) ").append(be.ma(str2));
            Cursor rawQuery = wK.cie.rawQuery(stringBuilder.toString(), null);
            if (rawQuery == null || rawQuery.getCount() <= 0) {
                i = 0;
            } else {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            }
            if (rawQuery == null) {
                return i;
            }
            rawQuery.close();
            return i;
        }
        v.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        return 0;
    }

    public static int fw(String str) {
        if (g.uz()) {
            int i;
            long Nj = be.Nj();
            ac wK = ((d) g.f(d.class)).wK();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT COUNT(rconversation.username)");
            stringBuilder.append(" FROM rconversation, rcontact");
            stringBuilder.append(" WHERE unReadCount > 0");
            stringBuilder.append(" AND rconversation.username = rcontact.username");
            stringBuilder.append(be.ma(str));
            stringBuilder.append(" AND ( type & 512").append(" ) == 0");
            stringBuilder.append(" AND ( attrflag & 2097152 ) == 0");
            stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.j.a.cht).append(" or parentRef = '' ) ");
            stringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
            v.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
            Cursor rawQuery = wK.cie.rawQuery(r1, null);
            if (rawQuery.getCount() > 0) {
                rawQuery.moveToFirst();
                i = rawQuery.getInt(0);
            } else {
                i = 0;
            }
            rawQuery.close();
            if (i <= 0) {
                return 0;
            }
            rawQuery = ((d) g.f(d.class)).wK().Mp(str);
            if (rawQuery == null) {
                v.w("MicroMsg.ConversationLogic", "cursor is null, return");
                v.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(be.az(Nj)));
                return i;
            }
            rawQuery.moveToFirst();
            while (!rawQuery.isAfterLast()) {
                ab LX = ((d) g.f(d.class)).wH().LX(rawQuery.getString(0));
                int i2 = (LX == null || LX.bCh != 0) ? i : i - 1;
                rawQuery.moveToNext();
                i = i2;
            }
            v.i("MicroMsg.ConversationLogic", "result talker count is %d", Integer.valueOf(i));
            rawQuery.close();
            v.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(be.az(Nj)));
            return Math.max(0, i);
        }
        v.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        return 0;
    }

    public static List<String> o(String str, int i) {
        List<String> list = null;
        if (g.uz()) {
            ac wK = ((d) g.f(d.class)).wK();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SELECT rconversation.username");
            stringBuilder.append(" FROM rconversation, rcontact");
            stringBuilder.append(" WHERE unReadCount > 0");
            stringBuilder.append(" AND rconversation.username = rcontact.username");
            stringBuilder.append(be.ma(str));
            stringBuilder.append(" AND ( type & 512").append(" ) == 0");
            stringBuilder.append(" AND ( ( parentRef is ").append(com.tencent.mm.j.a.cht).append(" or parentRef = '' ) ");
            stringBuilder.append(" AND rcontact.username").append(" != 'officialaccounts')");
            stringBuilder.append(" ORDER BY flag DESC, conversationTime").append(" DESC ");
            v.i("MicroMsg.ConversationStorage", "get total unread talker, sql is %s", stringBuilder.toString());
            Cursor rawQuery = wK.cie.rawQuery(r2, null);
            if (rawQuery.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    v.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", rawQuery.getString(0));
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
                list = arrayList;
            }
            rawQuery.close();
            if (list != null) {
                rawQuery = ((d) g.f(d.class)).wK().Mp(str);
                if (rawQuery != null) {
                    rawQuery.moveToFirst();
                    while (!rawQuery.isAfterLast()) {
                        ab LX = ((d) g.f(d.class)).wH().LX(rawQuery.getString(0));
                        if (LX != null && LX.bCh == 0) {
                            v.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", LX.tT());
                            list.remove(LX.tT());
                        }
                        rawQuery.moveToNext();
                    }
                    rawQuery.close();
                }
            }
        } else {
            v.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        return list;
    }

    public static int F(String str, String str2) {
        if (be.kS(str)) {
            return 0;
        }
        if ("notification_messages".equals(str)) {
            return 8;
        }
        if (str2 != null && str2.endsWith("@chatroom")) {
            return 2;
        }
        int i;
        PInt pInt = new PInt();
        synchronized (crH) {
            int i2 = 0;
            boolean z = false;
            while (i2 < crH.size()) {
                boolean a;
                a aVar = (a) crH.get(i2);
                if (aVar != null) {
                    a = aVar.a(str, str2, pInt);
                    if (a) {
                        z = a;
                        i = pInt.value;
                        break;
                    }
                } else {
                    a = z;
                }
                i2++;
                z = a;
            }
            i = 0;
        }
        if (z) {
            return i;
        }
        return 1;
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        synchronized (crH) {
            crH.add(aVar);
        }
    }
}
