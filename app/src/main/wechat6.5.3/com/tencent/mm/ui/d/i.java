package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.au;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public final class i extends b {
    private static Date nQN = null;
    public boolean hasInit = false;
    public Runnable nQO = new Runnable(this) {
        final /* synthetic */ i nQP;

        {
            this.nQP = r1;
        }

        public final void run() {
            final View findViewById = this.nQP.view.findViewById(2131757127);
            if (ak.getNetType(aa.getContext()) != 0) {
                findViewById.setVisibility(8);
                return;
            }
            com.tencent.mm.sdk.c.b auVar = new au();
            a.nhr.z(auVar);
            if (be.kS(auVar.aYw.aYB)) {
                findViewById.setVisibility(8);
                return;
            }
            ((TextView) this.nQP.view.findViewById(2131757128)).setText(auVar.aYw.aYB);
            final String str = auVar.aYw.aYy;
            Object obj = "0".equalsIgnoreCase(auVar.aYw.aYx) ? "0" : "1";
            final String str2 = auVar.aYw.aYz;
            final String str3 = auVar.aYw.ssid;
            final String str4 = auVar.aYw.bssid;
            final String str5 = auVar.aYw.aYA;
            v.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to show bar. pingEnabled = %s,  pingUrl= %s", obj, str);
            if ("1".equals(obj)) {
                com.tencent.mm.model.ak.vA().x(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nQT;

                    public final void run() {
                        Exception exception;
                        Writer stringWriter;
                        String stringWriter2;
                        g gVar;
                        Object[] objArr;
                        Throwable th;
                        v.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=it tries to ping. pingUrl= %s", str);
                        HttpURLConnection httpURLConnection = null;
                        try {
                            URL url = new URL(str);
                            long currentTimeMillis = System.currentTimeMillis();
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                            if (httpURLConnection2 != null) {
                                try {
                                    httpURLConnection2.setConnectTimeout(5000);
                                    httpURLConnection2.setReadTimeout(5000);
                                    httpURLConnection2.setInstanceFollowRedirects(false);
                                    httpURLConnection2.setUseCaches(false);
                                    httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                                    httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                                    int responseCode = httpURLConnection2.getResponseCode();
                                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                    g.iuh.h(12907, str3, str4, str5, str2, SQLiteDatabase.KeyEmpty, Long.valueOf(currentTimeMillis), Integer.valueOf(responseCode), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                    v.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=ping ended. http response code = %d, cost=%d ms", Integer.valueOf(responseCode), Long.valueOf(currentTimeMillis));
                                    if (200 == responseCode) {
                                        ad.o(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 nQU;

                                            {
                                                this.nQU = r1;
                                            }

                                            public final void run() {
                                                findViewById.setVisibility(0);
                                            }
                                        });
                                    } else if (302 == responseCode) {
                                        v.i("MicroMsg.FreeWifi.FreeWifiBanner", "desc=http response 302 location = %s", httpURLConnection2.getHeaderField("Location"));
                                    }
                                } catch (Exception e) {
                                    Exception exception2 = e;
                                    httpURLConnection = httpURLConnection2;
                                    exception = exception2;
                                    try {
                                        stringWriter = new StringWriter();
                                        exception.printStackTrace(new PrintWriter(stringWriter));
                                        stringWriter2 = stringWriter.toString();
                                        v.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
                                        if (stringWriter2 == null) {
                                            stringWriter2 = SQLiteDatabase.KeyEmpty;
                                        }
                                        gVar = g.iuh;
                                        objArr = new Object[10];
                                        objArr[0] = str3;
                                        objArr[1] = str4;
                                        objArr[2] = str5;
                                        objArr[3] = str2;
                                        objArr[4] = SQLiteDatabase.KeyEmpty;
                                        objArr[5] = Integer.valueOf(0);
                                        objArr[6] = Integer.valueOf(0);
                                        objArr[7] = SQLiteDatabase.KeyEmpty;
                                        objArr[8] = SQLiteDatabase.KeyEmpty;
                                        if (stringWriter2.length() > 1024) {
                                            stringWriter2 = stringWriter2.substring(0, 1024);
                                        }
                                        objArr[9] = stringWriter2;
                                        gVar.h(12907, objArr);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    httpURLConnection = httpURLConnection2;
                                    th = th4;
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                    }
                                    throw th;
                                }
                            }
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                        } catch (Exception e2) {
                            exception = e2;
                            stringWriter = new StringWriter();
                            exception.printStackTrace(new PrintWriter(stringWriter));
                            stringWriter2 = stringWriter.toString();
                            v.i("MicroMsg.FreeWifi.FreeWifiBanner", "ping encounter exception. " + stringWriter2);
                            if (stringWriter2 == null) {
                                stringWriter2 = SQLiteDatabase.KeyEmpty;
                            }
                            gVar = g.iuh;
                            objArr = new Object[10];
                            objArr[0] = str3;
                            objArr[1] = str4;
                            objArr[2] = str5;
                            objArr[3] = str2;
                            objArr[4] = SQLiteDatabase.KeyEmpty;
                            objArr[5] = Integer.valueOf(0);
                            objArr[6] = Integer.valueOf(0);
                            objArr[7] = SQLiteDatabase.KeyEmpty;
                            objArr[8] = SQLiteDatabase.KeyEmpty;
                            if (stringWriter2.length() > 1024) {
                                stringWriter2 = stringWriter2.substring(0, 1024);
                            }
                            objArr[9] = stringWriter2;
                            gVar.h(12907, objArr);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                        }
                    }
                });
            } else {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 nQT;

                    public final void run() {
                        findViewById.setVisibility(0);
                    }
                });
            }
        }
    };

    public i(Context context) {
        super(context);
        aqp();
    }

    public final int getLayoutId() {
        return 2130903670;
    }

    public void aqp() {
        if (this.view != null) {
            View findViewById = this.view.findViewById(2131757127);
            if (!this.hasInit) {
                this.hasInit = true;
                findViewById.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ i nQP;

                    {
                        this.nQP = r1;
                    }

                    public final void onClick(View view) {
                        Date date = new Date();
                        if (i.nQN == null || date.getTime() - i.nQN.getTime() >= 1000) {
                            i.nQN = date;
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_source", 2);
                            intent.addFlags(67108864);
                            c.b((Context) this.nQP.lKT.get(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    }
                });
                findViewById.setVisibility(8);
            }
        }
    }

    public final void destroy() {
    }
}
