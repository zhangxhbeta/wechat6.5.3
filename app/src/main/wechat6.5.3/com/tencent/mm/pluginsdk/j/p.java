package com.tencent.mm.pluginsdk.j;

import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class p {
    public final int aZk;
    public final int action;
    public final String content;
    public final int errorCode;
    public final int lCN;
    public final String title;
    public final int type;
    public final String url;

    public p(int i, int i2, String str) {
        String str2;
        Exception exception;
        int i3;
        Exception exception2;
        String str3;
        int i4;
        String str4;
        int i5 = 0;
        String str5 = SQLiteDatabase.KeyEmpty;
        int i6 = 5;
        String str6 = SQLiteDatabase.KeyEmpty;
        String str7 = SQLiteDatabase.KeyEmpty;
        try {
            Map q = bf.q(str, "e");
            if (q == null) {
                throw new IllegalArgumentException("values == null");
            }
            int intValue = Integer.valueOf((String) q.get(".e.ShowType")).intValue();
            try {
                i5 = Integer.valueOf((String) q.get(".e.Action")).intValue();
                i6 = Integer.valueOf((String) q.get(".e.DispSec")).intValue();
                str2 = (String) q.get(".e.Title");
            } catch (Exception e) {
                exception = e;
                str2 = str7;
                str7 = str6;
                i3 = i6;
                i6 = i5;
                i5 = intValue;
                exception2 = exception;
                v.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
                str3 = str5;
                i4 = i6;
                str4 = str3;
                this.errorCode = i2;
                this.aZk = i;
                this.type = i5;
                this.action = i4;
                this.content = str4;
                this.lCN = i3;
                this.title = str2;
                this.url = str7;
            }
            try {
                str7 = (String) q.get(".e.Url");
                try {
                    i4 = i5;
                    i5 = intValue;
                    int i7 = i6;
                    str4 = (String) q.get(".e.Content");
                    i3 = i7;
                } catch (Exception e2) {
                    exception = e2;
                    i3 = i6;
                    i6 = i5;
                    i5 = intValue;
                    exception2 = exception;
                    v.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
                    str3 = str5;
                    i4 = i6;
                    str4 = str3;
                    this.errorCode = i2;
                    this.aZk = i;
                    this.type = i5;
                    this.action = i4;
                    this.content = str4;
                    this.lCN = i3;
                    this.title = str2;
                    this.url = str7;
                }
            } catch (Exception e3) {
                exception = e3;
                str7 = str6;
                i3 = i6;
                i6 = i5;
                i5 = intValue;
                exception2 = exception;
                v.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
                str3 = str5;
                i4 = i6;
                str4 = str3;
                this.errorCode = i2;
                this.aZk = i;
                this.type = i5;
                this.action = i4;
                this.content = str4;
                this.lCN = i3;
                this.title = str2;
                this.url = str7;
            }
            this.errorCode = i2;
            this.aZk = i;
            this.type = i5;
            this.action = i4;
            this.content = str4;
            this.lCN = i3;
            this.title = str2;
            this.url = str7;
        } catch (Exception e4) {
            exception2 = e4;
            str2 = str7;
            str7 = str6;
            i3 = 5;
            i6 = 0;
            v.e("MicroMsg.UnifyErrorProcessor", exception2.toString());
            str3 = str5;
            i4 = i6;
            str4 = str3;
            this.errorCode = i2;
            this.aZk = i;
            this.type = i5;
            this.action = i4;
            this.content = str4;
            this.lCN = i3;
            this.title = str2;
            this.url = str7;
        }
    }
}
