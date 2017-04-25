package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends ContentObserver {
    private boolean cAv = false;
    private ContentResolver kRR;
    private boolean kRS = false;
    private boolean kRT = false;
    a kRU;
    private long kRV = 0;
    String[] kRW;
    private Context mContext;

    public interface a {
        void Ds(String str);
    }

    public e(Context context) {
        super(ac.fetchFreeHandler());
        this.mContext = context;
    }

    public final void start() {
        this.kRS = false;
        this.kRT = false;
        this.cAv = false;
        boolean a = com.tencent.mm.pluginsdk.i.a.a((Activity) this.mContext, "android.permission.READ_SMS", 128, "", "");
        v.i("MicroMsg.SmsVerifyObserver", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this.mContext});
        try {
            long j;
            Uri parse = Uri.parse("content://sms/inbox");
            this.kRR = this.mContext.getContentResolver();
            String str = "( ";
            if (this.kRW != null) {
                int i = 0;
                while (i < this.kRW.length) {
                    String str2 = i == this.kRW.length + -1 ? str + " body like \"%" + this.kRW[i] + "%\" ) " : str + "body like \"%" + this.kRW[i] + "%\" or ";
                    i++;
                    str = str2;
                }
                v.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
            } else {
                str = "";
            }
            Cursor query = this.kRR.query(parse, new String[]{"date"}, str, null, "date desc limit 1");
            if (query == null || query.getCount() <= 0) {
                j = 0;
            } else {
                query.moveToFirst();
                j = query.getLong(0);
            }
            if (query != null) {
                query.close();
            }
            this.kRV = j;
            this.mContext.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, this);
        } catch (Throwable e) {
            v.a("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    public final void stop() {
        if (this.mContext != null) {
            try {
                this.mContext.getContentResolver().unregisterContentObserver(this);
            } catch (Throwable e) {
                v.a("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
            }
        }
        this.cAv = true;
    }

    public final void onChange(boolean z) {
        String str = null;
        super.onChange(z);
        try {
            if (!this.kRS && !this.cAv && !this.kRT) {
                Uri parse = Uri.parse("content://sms/inbox");
                this.kRR = this.mContext.getContentResolver();
                String[] strArr = new String[]{"body", "_id", "date"};
                String str2 = "( ";
                if (this.kRW != null) {
                    int i = 0;
                    while (i < this.kRW.length) {
                        str2 = i == this.kRW.length + -1 ? str2 + " body like \"%" + this.kRW[i] + "%\" ) " : str2 + "body like \"%" + this.kRW[i] + "%\" or ";
                        i++;
                    }
                    str = str2 + " and date > " + this.kRV + " ";
                    v.v("MicroMsg.SmsVerifyObserver", "sql where:" + str);
                }
                if (str != null && !str.equals("")) {
                    Cursor query = this.kRR.query(parse, strArr, str, null, "date desc");
                    if (query != null) {
                        int i2 = -1;
                        long j = 0;
                        while (query.moveToNext()) {
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
                        }
                        if (i2 >= 0) {
                            query.moveToPosition(i2);
                            str2 = ak(0, query.getString(query.getColumnIndex("body")));
                            if (!be.kS(str2) && str2.length() == 6) {
                                if (this.kRU != null) {
                                    this.kRU.Ds(str2);
                                }
                                this.kRT = true;
                            }
                        }
                        query.close();
                    }
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.SmsVerifyObserver", e, "", new Object[0]);
        }
    }

    private String ak(int i, String str) {
        while (i < str.length()) {
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                i++;
            }
            int i2 = i + 1;
            while (i2 < str.length() && Character.isDigit(str.charAt(i2))) {
                i2++;
            }
            String substring = str.substring(i, i2);
            v.v("MicroMsg.SmsVerifyObserver", "verify number from sms:" + substring);
            if (substring.length() == 6) {
                return substring;
            }
            i = i2 + 1;
        }
        return null;
    }
}
