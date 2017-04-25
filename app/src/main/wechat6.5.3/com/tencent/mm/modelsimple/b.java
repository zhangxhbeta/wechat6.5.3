package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b implements Runnable {
    private String bhj;
    private Account cYi;
    private a cYj;
    private Looper cYk;
    private Context mContext;
    private String username;

    public class a {
        private final String TAG = "MicroMsg.BatchOperation";
        private final ContentResolver cYl;
        ArrayList<ContentProviderOperation> cYm;
        final /* synthetic */ b cYn;

        public a(b bVar, ContentResolver contentResolver) {
            this.cYn = bVar;
            this.cYl = contentResolver;
            this.cYm = new ArrayList();
        }

        public final void a(ContentProviderOperation contentProviderOperation) {
            this.cYm.add(contentProviderOperation);
        }

        public final void execute() {
            if (this.cYm.size() == 0) {
                v.d("MicroMsg.BatchOperation", "no batch operation");
            } else if (com.tencent.mm.pluginsdk.i.a.aP(this.cYn.mContext, "android.permission.READ_CONTACTS")) {
                try {
                    this.cYl.applyBatch("com.android.contacts", this.cYm);
                } catch (OperationApplicationException e) {
                    v.e("MicroMsg.BatchOperation", "apply batch operation failed", e.toString());
                } catch (RemoteException e2) {
                    v.e("MicroMsg.BatchOperation", "apply batch operation failed", e2.toString());
                } catch (Exception e3) {
                    v.e("MicroMsg.BatchOperation", "apply batch operation failed", e3.toString());
                }
                this.cYm.clear();
            } else {
                v.e("MicroMsg.BatchOperation", "no contact permission");
            }
        }
    }

    public b(Context context, Account account) {
        this(context, account, null, null);
    }

    public b(Context context, Account account, String str) {
        this(context, account, str, null);
    }

    public b(Context context, Account account, String str, String str2) {
        this.mContext = context;
        this.cYi = account;
        this.username = str;
        this.bhj = str2;
        v.i("MicroMsg.ContactsOperations", "username = " + str + ", " + str2);
    }

    public final void run() {
        Looper.prepare();
        this.cYk = Looper.myLooper();
        v.i("MicroMsg.ContactsOperations", "start time:" + System.currentTimeMillis());
        if (be.kS(this.username) && be.kS(this.bhj)) {
            IP();
        } else if (be.kS(this.bhj)) {
            r0 = ah.FL().iA(this.username);
            if (!(r0 == null || be.kS(r0.cHb))) {
                kd(r0.cHb);
            }
            quit();
        } else {
            r0 = ah.FL().iA(this.username);
            com.tencent.mm.modelfriend.b iA = (r0 == null || be.kS(r0.cHb)) ? ah.FL().iA(this.bhj) : r0;
            if (iA == null || be.kS(iA.cHb)) {
                v.d("MicroMsg.ContactsOperations", "query addrupload is null " + this.username);
            } else {
                try {
                    if (com.tencent.mm.pluginsdk.i.a.aP(this.mContext, "android.permission.READ_CONTACTS")) {
                        Cursor query = this.mContext.getContentResolver().query(RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.cYi.name).appendQueryParameter("account_type", this.cYi.type).build(), new String[]{"sync1", "_id"}, "deleted=\"0\" AND sync1=\"" + iA.cHb + "\"", null, null);
                        if (query == null || query.getCount() == 0) {
                            String EG = be.kS(iA.ED()) ? iA.EG() : iA.ED();
                            this.cYj = new a(this, this.mContext.getContentResolver());
                            b(EG, iA.EJ(), iA.cHb, this.username);
                            this.cYj.execute();
                        }
                        if (query != null) {
                            query.close();
                        }
                    } else {
                        v.e("MicroMsg.ContactsOperations", "no contact permission");
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.ContactsOperations", e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                }
            }
            quit();
        }
        v.i("MicroMsg.ContactsOperations", "end time:" + System.currentTimeMillis());
        Looper.loop();
    }

    private void quit() {
        if (this.cYk != null) {
            this.cYk.quit();
        }
    }

    private synchronized void IP() {
        Throwable e;
        Object obj;
        ab LX;
        if (ak.uz()) {
            List<com.tencent.mm.modelfriend.b> iC = ah.FL().iC("select  *  from addr_upload2 where ( addr_upload2.username IS NOT NULL AND addr_upload2.status!=\"0\" AND addr_upload2.username!=\"" + be.lZ(SQLiteDatabase.KeyEmpty) + "\" )");
            if (iC.size() == 0) {
                v.e("MicroMsg.ContactsOperations", "there is no wechat friend in this phone");
                quit();
            } else {
                Map hashMap = new HashMap();
                Uri build = RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", this.cYi.name).appendQueryParameter("account_type", this.cYi.type).build();
                if (com.tencent.mm.pluginsdk.i.a.aP(this.mContext, "android.permission.READ_CONTACTS")) {
                    Cursor query;
                    String username;
                    try {
                        query = this.mContext.getContentResolver().query(build, new String[]{"sync1", "_id"}, "deleted=\"0\"", null, null);
                        if (query == null) {
                            try {
                                v.e("MicroMsg.ContactsOperations", "query get no user");
                            } catch (Exception e2) {
                                e = e2;
                                v.a("MicroMsg.ContactsOperations", e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                if (query != null) {
                                    query.close();
                                }
                                if (!ke("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                                }
                                obj = null;
                                this.cYj = new a(this, this.mContext.getContentResolver());
                                for (com.tencent.mm.modelfriend.b bVar : iC) {
                                    username = bVar.getUsername();
                                    ak.yW();
                                    LX = c.wH().LX(username);
                                    if (LX == null) {
                                    }
                                    kd(bVar.cHb);
                                }
                                this.cYj.execute();
                                quit();
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (ke("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video") || ke("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip")) {
                                obj = null;
                            } else {
                                obj = 1;
                            }
                            this.cYj = new a(this, this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar2 : iC) {
                                username = bVar2.getUsername();
                                ak.yW();
                                LX = c.wH().LX(username);
                                if (LX == null && com.tencent.mm.i.a.ei(LX.field_type)) {
                                    String EG = be.kS(bVar2.ED()) ? bVar2.EG() : bVar2.ED();
                                    String EJ = bVar2.EJ();
                                    String str = bVar2.cHb;
                                    String str2 = LX.bCj;
                                    if (hashMap.get(str) == null || r2 != null) {
                                        if (hashMap.get(str) != null) {
                                            kd(str);
                                        }
                                        b(EG, EJ, str, username);
                                    }
                                    this.cYj.execute();
                                } else {
                                    kd(bVar2.cHb);
                                }
                            }
                            this.cYj.execute();
                            quit();
                        } else {
                            if (query.moveToFirst()) {
                                do {
                                    hashMap.put(query.getString(0), Long.valueOf(query.getLong(1)));
                                } while (query.moveToNext());
                            }
                            if (query != null) {
                                query.close();
                            }
                            if (ke("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                            }
                            obj = null;
                            this.cYj = new a(this, this.mContext.getContentResolver());
                            for (com.tencent.mm.modelfriend.b bVar22 : iC) {
                                username = bVar22.getUsername();
                                ak.yW();
                                LX = c.wH().LX(username);
                                if (LX == null) {
                                }
                                kd(bVar22.cHb);
                            }
                            this.cYj.execute();
                            quit();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        query = null;
                        v.a("MicroMsg.ContactsOperations", e, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                        if (query != null) {
                            query.close();
                        }
                        if (ke("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video")) {
                        }
                        obj = null;
                        this.cYj = new a(this, this.mContext.getContentResolver());
                        for (com.tencent.mm.modelfriend.b bVar222 : iC) {
                            username = bVar222.getUsername();
                            ak.yW();
                            LX = c.wH().LX(username);
                            if (LX == null) {
                            }
                            kd(bVar222.cHb);
                        }
                        this.cYj.execute();
                        quit();
                    }
                }
                v.e("MicroMsg.ContactsOperations", "no contact permission");
            }
        } else {
            v.d("MicroMsg.ContactsOperations", "account not ready, quit this operation");
            quit();
        }
    }

    private void b(String str, String str2, String str3, String str4) {
        v.d("MicroMsg.ContactsOperations", "add wechat contact: displayname:" + str + ", phoneNum:" + str2 + ", " + str3 + ", username:" + str4);
        Builder newInsert = ContentProviderOperation.newInsert(RawContacts.CONTENT_URI);
        newInsert.withValue("account_name", this.cYi.name);
        newInsert.withValue("account_type", this.cYi.type);
        newInsert.withValue("sync1", str3);
        this.cYj.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/name");
        newInsert.withValue("data1", str);
        this.cYj.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(2131230720));
        newInsert.withValue("data3", this.mContext.getString(2131232219));
        newInsert.withValue("data4", str3);
        this.cYj.a(newInsert.build());
        if ("1".equals(j.sU().getValue("VOIPCallType"))) {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(2131230720));
            newInsert.withValue("data3", this.mContext.getString(2131232221));
            newInsert.withValue("data4", str3);
            this.cYj.a(newInsert.build());
        } else {
            newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
            newInsert.withValueBackReference("raw_contact_id", 0);
            newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip");
            newInsert.withValue("data1", str2);
            newInsert.withValue("data2", this.mContext.getString(2131230720));
            newInsert.withValue("data3", this.mContext.getString(2131232220));
            newInsert.withValue("data4", str3);
            this.cYj.a(newInsert.build());
        }
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(2131230720));
        newInsert.withValue("data3", this.mContext.getString(2131232222));
        newInsert.withValue("data4", str3);
        this.cYj.a(newInsert.build());
        newInsert = ContentProviderOperation.newInsert(Data.CONTENT_URI);
        newInsert.withValueBackReference("raw_contact_id", 0);
        newInsert.withValue("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction");
        newInsert.withValue("data1", str2);
        newInsert.withValue("data2", this.mContext.getString(2131230720));
        newInsert.withValue("data3", SQLiteDatabase.KeyEmpty);
        newInsert.withValue("data4", str3);
        this.cYj.a(newInsert.build());
    }

    private void kd(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.ContactsOperations", "delete wechat contact fail, phoneNum5 is null");
        } else if (com.tencent.mm.pluginsdk.i.a.aP(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id", "_id"}, "(mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ? or mimetype= ?) AND data4 = ?", new String[]{"vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile", "vnd.android.cursor.item/vnd.com.tencent.mm.plugin.sns.timeline", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voip.video", "vnd.android.cursor.item/vnd.com.tencent.mm.chatting.voiceaction", str}, null);
            } catch (Throwable e) {
                v.e("MicroMsg.ContactsOperations", "query fail, match error %s \n %s", e.getMessage(), be.e(e));
                query = null;
            }
            if (query == null) {
                v.e("MicroMsg.ContactsOperations", "get null cursor");
                return;
            }
            try {
                if (query.moveToFirst()) {
                    do {
                        int columnIndex = query.getColumnIndex("contact_id");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : SQLiteDatabase.KeyEmpty;
                        columnIndex = query.getColumnIndex("_id");
                        String string2 = columnIndex >= 0 ? query.getString(columnIndex) : SQLiteDatabase.KeyEmpty;
                        if (!(be.kS(string) || be.kS(string2))) {
                            this.mContext.getContentResolver().delete(Data.CONTENT_URI, "_id = ?", new String[]{string2});
                            this.mContext.getContentResolver().delete(RawContacts.CONTENT_URI, "contact_id = ? AND account_type = ?", new String[]{string, "com.tencent.mm.account"});
                        }
                    } while (query.moveToNext());
                }
            } catch (Exception e2) {
                v.e("MicroMsg.ContactsOperations", "delete wechat contact failed : " + e2.getMessage());
            }
            query.close();
        } else {
            v.e("MicroMsg.ContactsOperations", "no contact permission");
        }
    }

    private boolean ke(String str) {
        Exception e;
        boolean z = false;
        if (com.tencent.mm.pluginsdk.i.a.aP(this.mContext, "android.permission.READ_CONTACTS")) {
            Cursor query;
            try {
                boolean z2;
                query = this.mContext.getContentResolver().query(Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype= ?", new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            v.d("MicroMsg.ContactsOperations", "has minetype:" + str);
                            z2 = true;
                            z = z2;
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        v.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                        z = true;
                        if (query != null) {
                            query.close();
                        }
                        return z;
                    }
                }
                z2 = false;
                z = z2;
            } catch (Exception e3) {
                e = e3;
                query = null;
                v.e("MicroMsg.ContactsOperations", "hasMIMEType search failed : " + e.getMessage());
                z = true;
                if (query != null) {
                    query.close();
                }
                return z;
            }
            if (query != null) {
                query.close();
            }
        } else {
            v.e("MicroMsg.ContactsOperations", "no contact permission");
        }
        return z;
    }
}
