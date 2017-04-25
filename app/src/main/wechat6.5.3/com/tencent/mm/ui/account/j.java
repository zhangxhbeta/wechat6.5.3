package com.tencent.mm.ui.account;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j extends ContentObserver {
    private final Context context;
    private Pattern hDe = Pattern.compile("\\d{4,8}");
    private ContentResolver kRR;
    private final String[] kRW;
    private final a nMK;

    public interface a {
        void Oj(String str);

        void bAX();
    }

    public j(Context context, a aVar) {
        super(ac.fetchFreeHandler());
        if (context == null || aVar == null) {
            throw new NullPointerException("SmsContentObserver Construction");
        }
        this.context = context;
        this.kRW = context.getResources().getStringArray(2131296295);
        this.nMK = aVar;
    }

    public final void bBk() {
        this.context.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
    }

    public final void bBl() {
        this.context.getContentResolver().unregisterContentObserver(this);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (this.context instanceof Activity) {
            v.i("MicroMsg.SmsContentObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.READ_SMS", FileUtils.S_IWUSR, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.context);
            if (!com.tencent.mm.pluginsdk.i.a.a((Activity) this.context, "android.permission.READ_SMS", FileUtils.S_IWUSR, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                return;
            }
        }
        bBm();
    }

    public final void bBm() {
        Exception e;
        Cursor cursor;
        Throwable th;
        String str = null;
        Uri parse = Uri.parse("content://sms/inbox");
        this.kRR = this.context.getContentResolver();
        String[] strArr = new String[]{"body", "_id", "date"};
        String str2 = "( ";
        int i = 0;
        while (i < this.kRW.length) {
            str2 = i == this.kRW.length + -1 ? str2 + " body like \"%" + this.kRW[i] + "%\" ) " : str2 + "body like \"%" + this.kRW[i] + "%\" or ";
            i++;
        }
        String str3 = str2 + " and date > " + (System.currentTimeMillis() - 300000) + " ";
        v.v("MicroMsg.SmsContentObserver", "sql where:" + str3);
        if (str3 != null && !str3.equals(SQLiteDatabase.KeyEmpty)) {
            Cursor query;
            try {
                query = this.kRR.query(parse, strArr, str3, null, null);
                int i2 = -1;
                long j = 0;
                while (query.moveToNext()) {
                    try {
                        int position;
                        long j2 = query.getLong(2);
                        if (j2 > j) {
                            position = query.getPosition();
                        } else {
                            j2 = j;
                            position = i2;
                        }
                        i2 = position;
                        j = j2;
                    } catch (Exception e2) {
                        e = e2;
                        cursor = query;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                if (i2 >= 0) {
                    query.moveToPosition(i2);
                    Matcher matcher = this.hDe.matcher(query.getString(query.getColumnIndex("body")));
                    if (matcher.find()) {
                        str = matcher.group();
                    }
                    this.nMK.Oj(str);
                } else {
                    this.nMK.bAX();
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                try {
                    v.e("MicroMsg.SmsContentObserver", e.toString());
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    query = cursor;
                    query.close();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query = null;
                if (!(query == null || query.isClosed())) {
                    query.close();
                }
                throw th;
            }
        }
    }
}
