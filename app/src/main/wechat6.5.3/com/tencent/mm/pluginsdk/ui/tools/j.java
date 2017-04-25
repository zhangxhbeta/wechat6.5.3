package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class j {

    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ a lTV;

        AnonymousClass2(a aVar) {
            this.lTV = aVar;
        }

        public final void run() {
            this.lTV.aHL();
        }
    }

    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ a lTV;

        AnonymousClass3(a aVar) {
            this.lTV = aVar;
        }

        public final void run() {
            this.lTV.aHL();
        }
    }

    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ a lTV;

        AnonymousClass4(a aVar) {
            this.lTV = aVar;
        }

        public final void run() {
            this.lTV.aHL();
        }
    }

    static class AnonymousClass5 implements Runnable {
        final /* synthetic */ a lTV;
        final /* synthetic */ int lTW;

        AnonymousClass5(a aVar, int i) {
            this.lTV = aVar;
            this.lTW = i;
        }

        public final void run() {
            this.lTV.hm(this.lTW);
        }
    }

    public interface a {
        void aHL();

        void hm(int i);
    }

    public static void a(final a aVar) {
        ak.vA().x(new Runnable() {
            public final void run() {
                try {
                    a aVar = aVar;
                    v.i("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount]");
                    ak.yW();
                    String str = (String) c.vf().get(-1535680990, SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    long longValue = new o(be.f((Integer) c.vf().get(9, null))).longValue();
                    if (be.kS(str) || longValue == 0) {
                        ak.yW();
                        c.vf().a(com.tencent.mm.storage.t.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1));
                        v.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadEmailCountAndSet: authkey or uin is null]");
                        ad.o(new AnonymousClass2(aVar));
                        return;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://qqmail.weixin.qq.com/cgi-bin/getunreadmailcount?f=xml&appname=qqmail_weixin&charset=utf-8&clientip=0").openConnection();
                    httpURLConnection.setConnectTimeout(15000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestProperty("Cookie", String.format("skey=%s;uin=o%d;", new Object[]{str, Long.valueOf(longValue)}));
                    if (httpURLConnection.getResponseCode() >= SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD) {
                        httpURLConnection.disconnect();
                        v.w("MicroMsg.QQMailUnreadHelper", "dz[getUnreadCount http 300]");
                        ad.o(new AnonymousClass3(aVar));
                        return;
                    }
                    Map q = bf.q(be.e(httpURLConnection.getInputStream()), "Response");
                    int i = (q == null || be.getInt((String) q.get(".Response.error.code"), -1) != 0) ? -1 : be.getInt((String) q.get(".Response.result.UnreadCount"), -1);
                    if (i < 0) {
                        ad.o(new AnonymousClass4(aVar));
                        return;
                    }
                    ak.yW();
                    c.vf().a(com.tencent.mm.storage.t.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(i));
                    ad.o(new AnonymousClass5(aVar, i));
                } catch (Throwable e) {
                    v.a("MicroMsg.QQMailUnreadHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.QQMailUnreadHelper", "getUnreadCountAsync exception");
                }
            }
        });
    }
}
