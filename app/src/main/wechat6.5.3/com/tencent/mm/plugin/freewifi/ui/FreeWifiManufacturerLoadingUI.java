package com.tencent.mm.plugin.freewifi.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.freewifi.b;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

public class FreeWifiManufacturerLoadingUI extends MMActivity {
    private ah aSW;
    private String bssid;
    private ImageView gcb;
    private TextView gcc;
    private Button gcd;
    private final int gce = 1;
    private final int gcf = 2;
    private final int gcg = 3;
    private int[] gch = new int[]{2130838252, 2130838253, 2130838254, 2130838255, 2130838256};
    ac gci = new ac(this) {
        final /* synthetic */ FreeWifiManufacturerLoadingUI gck;
        int i = 0;

        {
            this.gck = r2;
        }

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (this.i >= this.gck.gch.length) {
                    this.i = 0;
                }
                this.gck.gcb.setImageResource(this.gck.gch[this.i]);
                this.i++;
            } else if (message.what == 2) {
                this.gck.gcb.setImageResource(this.gck.gch[this.gck.gch.length - 1]);
            } else if (message.what == 3 && message.obj != null && (message.obj instanceof String)) {
                this.gck.gcc.setText(message.obj.toString());
            }
            super.handleMessage(message);
        }
    };
    ac gcj = new ac();
    private String ssid;

    static /* synthetic */ void b(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI, final String str) {
        freeWifiManufacturerLoadingUI.P(0, "");
        freeWifiManufacturerLoadingUI.tS(freeWifiManufacturerLoadingUI.getString(2131232974));
        freeWifiManufacturerLoadingUI.aqd();
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "opening url : " + str);
        ad.o(new Runnable(freeWifiManufacturerLoadingUI) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI gck;

            public final void run() {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_bottom", false);
                intent.putExtra("allow_wx_schema_url", true);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("stastic_scene", 7);
                intent.putExtra("neverBlockLocalRequest", true);
                if (FreeWifiManufacturerLoadingUI.g(this.gck)) {
                    c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
    }

    static /* synthetic */ void f(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        Intent intent = new Intent();
        intent.putExtra("free_wifi_channel_id", 10);
        intent.setClass(freeWifiManufacturerLoadingUI, FreeWifiSuccUI.class);
        freeWifiManufacturerLoadingUI.startActivity(intent);
        freeWifiManufacturerLoadingUI.finish();
        freeWifiManufacturerLoadingUI.overridePendingTransition(2130968680, 2130968677);
    }

    static /* synthetic */ boolean g(FreeWifiManufacturerLoadingUI freeWifiManufacturerLoadingUI) {
        String bf = bf(aa.getContext());
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "topActivityName : " + bf);
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "getClas().getName()=" + freeWifiManufacturerLoadingUI.getClass().getName());
        boolean z = bf != null && bf.equals(freeWifiManufacturerLoadingUI.getClass().getName());
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ret = " + z);
        return z;
    }

    static /* synthetic */ String i(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readLine = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(readLine);
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 != null) {
                stringBuilder.append(readLine2);
            } else {
                v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body=" + stringBuilder.toString());
                return m.tA(readLine);
            }
        }
    }

    private void aqd() {
        if (this.aSW != null) {
            this.aSW.QI();
        }
        this.gci.sendEmptyMessage(2);
    }

    protected final int getLayoutId() {
        return 2130903662;
    }

    public void finish() {
        aqd();
        super.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232984);
        this.ssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid");
        this.bssid = getIntent().getStringExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid");
        this.gcb = (ImageView) findViewById(2131757100);
        this.gcc = (TextView) findViewById(2131757101);
        this.gcd = (Button) findViewById(2131757102);
        this.gcd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI gck;

            {
                this.gck = r1;
            }

            public final void onClick(View view) {
                this.gck.gcj.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 gcl;

                    {
                        this.gcl = r1;
                    }

                    public final void run() {
                        this.gcl.gck.gcd.setVisibility(4);
                    }
                }, 0);
                this.gck.aqe();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI gck;

            {
                this.gck = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gck.finish();
                return true;
            }
        });
        aqe();
    }

    public final void aqe() {
        this.gci.sendEmptyMessage(1);
        if (this.aSW != null) {
            this.aSW.QI();
        }
        this.aSW = new ah(new a(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI gck;

            {
                this.gck = r1;
            }

            public final boolean oU() {
                this.gck.gci.sendEmptyMessage(1);
                return true;
            }
        }, true);
        this.aSW.ea(200);
        final String str = this.ssid;
        j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ FreeWifiManufacturerLoadingUI gck;
            private int gcm = 0;
            private final int gcn = 5;

            public final void run() {
                Context context = aa.getContext();
                if (context == null) {
                    this.gck.P(1151, "Wechat hasn't started completely. Wait 5 seconds and retry.");
                    return;
                }
                if (!(m.aoF() && m.tB("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str))) {
                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "It starts to connect portal ssid " + str);
                    this.gck.tS(this.gck.getString(2131232975));
                    int aon = new b(str, context).aon();
                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "connectRet=" + aon);
                    if (aon != 0) {
                        this.gck.P(aon, "An attempt to switch to special portal ap failed. connectRet=" + aon);
                        return;
                    }
                }
                aqg();
            }

            private void aqf() {
                v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "_httpRequestForPortalUrl retry.");
                this.gcm++;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    v.e("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "sleep exception. " + e.getMessage());
                }
                aqg();
            }

            private void aqg() {
                Exception exception;
                Writer stringWriter;
                Throwable th;
                String aov = b.fWU.aov();
                v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http request url : " + aov);
                this.gck.tS(this.gck.getString(2131232971));
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(aov).openConnection();
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.setConnectTimeout(5000);
                            httpURLConnection2.setReadTimeout(5000);
                            httpURLConnection2.setInstanceFollowRedirects(false);
                            httpURLConnection2.setUseCaches(false);
                            httpURLConnection2.setRequestProperty("Pragma", "no-cache");
                            httpURLConnection2.setRequestProperty("Cache-Control", "no-cache");
                            int responseCode = httpURLConnection2.getResponseCode();
                            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "http resp code = " + responseCode);
                            String i;
                            if (200 == responseCode) {
                                if (m.tB("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI").equals(str)) {
                                    i = FreeWifiManufacturerLoadingUI.i(httpURLConnection2.getInputStream());
                                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "response body first line content=" + i);
                                    if (i.indexOf("wxwifiecho") == -1) {
                                        FreeWifiManufacturerLoadingUI.b(this.gck, aov);
                                        if (httpURLConnection2 != null) {
                                            httpURLConnection2.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                    this.gck.P(0, "");
                                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "already connected.");
                                    this.gck.P(0, "");
                                    this.gck.tS(this.gck.getString(2131232970));
                                    this.gck.aqd();
                                    FreeWifiManufacturerLoadingUI.f(this.gck);
                                } else {
                                    this.gck.P(1150, "Target ssid is not connected.");
                                }
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            } else if (302 == responseCode) {
                                v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "desc=http response 302 location = %s", new Object[]{httpURLConnection2.getHeaderField("Location")});
                                i = httpURLConnection2.getHeaderField("Location");
                                if (m.ty(i)) {
                                    this.gck.P(1146, "AP cannot response portal url properly.");
                                    if (httpURLConnection2 != null) {
                                        httpURLConnection2.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                FreeWifiManufacturerLoadingUI.b(this.gck, i);
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            } else {
                                this.gck.P(1149, "Ap response code is neither 200 nor 302.");
                                if (httpURLConnection2 != null) {
                                    httpURLConnection2.disconnect();
                                    return;
                                }
                                return;
                            }
                        } catch (Exception e) {
                            Exception exception2 = e;
                            httpURLConnection = httpURLConnection2;
                            exception = exception2;
                            try {
                                stringWriter = new StringWriter();
                                exception.printStackTrace(new PrintWriter(stringWriter));
                                v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
                                if (exception instanceof UnknownHostException) {
                                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.gcm), Integer.valueOf(5)});
                                    if (this.gcm < 5) {
                                        aqf();
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                            return;
                                        }
                                        return;
                                    }
                                }
                                this.gck.P(1153, "An attempt to connect to ap failed.");
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
                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection is null. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.gcm), Integer.valueOf(5)});
                    if (this.gcm < 5) {
                        aqf();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                            return;
                        }
                        return;
                    }
                    this.gck.P(1148, "An attempt to connect to ap failed.");
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Exception e2) {
                    exception = e2;
                    stringWriter = new StringWriter();
                    exception.printStackTrace(new PrintWriter(stringWriter));
                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "ping encounter exception. " + stringWriter.toString());
                    if (exception instanceof UnknownHostException) {
                        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "httpUrlConnection throws exception. _httpRequestForPortalUrl _retryCount=%d, MaxRetryCount=%d", new Object[]{Integer.valueOf(this.gcm), Integer.valueOf(5)});
                        if (this.gcm < 5) {
                            aqf();
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                    }
                    this.gck.P(1153, "An attempt to connect to ap failed.");
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        });
    }

    private void P(int i, String str) {
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "errcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (i != 0) {
            aqd();
            if (i == 1154) {
                tS(getString(2131232973) + "(031" + k.b.ManufacturerConnectLoading.fXM + "-" + Math.abs(i) + ")");
                return;
            }
            tS(getString(2131232972) + "(031" + k.b.ManufacturerConnectLoading.fXM + "-" + Math.abs(i) + ")");
            this.gcj.postDelayed(new Runnable(this) {
                final /* synthetic */ FreeWifiManufacturerLoadingUI gck;

                {
                    this.gck = r1;
                }

                public final void run() {
                    this.gck.gcd.setVisibility(0);
                }
            }, 0);
        }
    }

    private void tS(String str) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = str;
        this.gci.sendMessage(obtain);
    }

    private static String bf(Context context) {
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", "top activity name =" + className);
            return className;
        } catch (Throwable e) {
            v.a("MicroMsg.FreeWifi.FreeWifiManufacturerLoadingUI", e, "", new Object[0]);
            return "(null)";
        }
    }
}
