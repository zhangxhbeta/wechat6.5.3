package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.l;
import com.tencent.mm.plugin.qqmail.b.q;
import com.tencent.mm.plugin.qqmail.stub.QQMailStubProxyUI;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class ReadMailUI extends MMActivity implements OnCreateContextMenuListener {
    private static String igR = "var mail_css = document.createElement(\"style\");";
    private static String igS = "";
    private static String igT = "";
    private static float igU;
    private static int igV;
    private long bao = -1;
    private SharedPreferences cnm;
    private TextView fBO;
    private d gZK = new d(this);
    private long goV = -1;
    private ac handler;
    private String iaq;
    private String iav;
    private LinearLayout igA;
    private MailAttachListLinearLayout igB;
    private View igC;
    private TextView igD;
    private TextView igE;
    private View igF;
    private long igG = -1;
    private int igH;
    private int igI;
    private String igJ;
    private String igK;
    private String igL;
    private int igM = 0;
    private String igN;
    private ah igO;
    private int igP = 0;
    private int igQ = 0;
    private ReadMailProxy igW;
    private String igX;
    private int igY;
    private String ign;
    private MailMMWebView igo;
    private ProgressBar igp;
    private ImageView igq;
    private TextView igr;
    private MailAddrsViewControl igs;
    private MailAddrsViewControl igt;
    private MailAddrsViewControl igu;
    private TextView igv;
    private View igw;
    private LinearLayout igx;
    private TextView igy;
    private TextView igz;

    public class b {
        public final /* synthetic */ ReadMailUI igZ;

        public b(ReadMailUI readMailUI) {
            this.igZ = readMailUI;
        }
    }

    public class c {
        final /* synthetic */ ReadMailUI igZ;

        public c(ReadMailUI readMailUI) {
            this.igZ = readMailUI;
        }
    }

    private class a extends com.tencent.mm.plugin.qqmail.b.q.a {
        final /* synthetic */ ReadMailUI igZ;
        int ihg;

        public a(ReadMailUI readMailUI, int i) {
            this.igZ = readMailUI;
            this.ihg = i;
        }

        public final void onSuccess(String str, final Map<String, String> map) {
            v.d("MicroMsg.ReadMailUI", "onSuccess userData = %d", new Object[]{Integer.valueOf(this.ihg)});
            switch (this.ihg) {
                case 1:
                    ReadMailUI.a(this.igZ, new Runnable(this) {
                        final /* synthetic */ a ihi;

                        public final void run() {
                            if (this.ihi.igZ.ign.equals(this.ihi.igZ.iaq)) {
                                if (this.ihi.igZ.igu.ifn.size() == 0) {
                                    this.ihi.igZ.igu.a(ReadMailUI.a(map, ".Response.result.tolist", be.getInt((String) map.get(".Response.result.tolistlen"), 0)), true);
                                }
                                if (this.ihi.igZ.igt.ifn.size() == 0) {
                                    String[] b = ReadMailUI.a(map, ".Response.result.cclist", be.getInt((String) map.get(".Response.result.cclistlen"), 0));
                                    LinearLayout e = this.ihi.igZ.igx;
                                    int i = (b == null || b.length == 0) ? 8 : 0;
                                    e.setVisibility(i);
                                    this.ihi.igZ.igt.a(b, true);
                                }
                                String str = (String) map.get(".Response.result.content");
                                ReadMailUI.a(this.ihi.igZ, map);
                                String str2 = (String) map.get(".Response.result.tips.wording");
                                if (!be.kS(str2)) {
                                    if ("1".equals((String) map.get(".Response.result.tips.color"))) {
                                        this.ihi.igZ.igr.setBackgroundColor(-13627);
                                        this.ihi.igZ.igr.setTextColor(-7515315);
                                    }
                                    this.ihi.igZ.igr.setText(str2);
                                    ((View) this.ihi.igZ.igr.getParent()).setVisibility(0);
                                }
                                this.ihi.igZ.igo.loadDataWithBaseURL(q.aHA() + "?pageWidth=" + ReadMailUI.igU, "<html style=\"margin-top:" + ReadMailUI.igV + "px\">" + str + "</html>", "text/html", ProtocolPackage.ServerEncoding, null);
                            }
                        }
                    });
                    return;
                case 2:
                    this.igZ.handler.post(new Runnable(this) {
                        final /* synthetic */ a ihi;

                        {
                            this.ihi = r1;
                        }

                        public final void run() {
                            this.ihi.igZ.igz.setEnabled(false);
                            this.ihi.igZ.igz.setText(2131234340);
                            this.ihi.igZ.igz.setTextColor(-7829368);
                            this.ihi.igZ.igz.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bd.a.a(this.ihi.igZ, 2130839099), null, null, null);
                        }
                    });
                    break;
            }
            v.e("MicroMsg.ReadMailUI", "onSuccess, invalid userData = %d", new Object[]{Integer.valueOf(this.ihg)});
        }

        public final void onError(final int i, final String str) {
            v.d("MicroMsg.ReadMailUI", "onError errCode = %d, userData = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.ihg)});
            this.igZ.handler.post(new Runnable(this) {
                final /* synthetic */ a ihi;

                public final void run() {
                    if (!this.ihi.igZ.isFinishing()) {
                        Intent intent;
                        switch (this.ihi.ihg) {
                            case 1:
                                this.ihi.igZ.igq.setVisibility(0);
                                if (i == -5) {
                                    intent = new Intent(this.ihi.igZ, QQMailStubProxyUI.class);
                                    intent.addFlags(268435456);
                                    this.ihi.igZ.startActivityForResult(intent, 1);
                                    return;
                                }
                                if (i == -7) {
                                    this.ihi.igZ.igq.setVisibility(8);
                                    try {
                                        new ReadMailProxy(this.ihi.igZ.gZK, null).REMOTE_CALL("replaceMsgContent", Long.valueOf(this.ihi.igZ.bao), str);
                                    } catch (Exception e) {
                                        v.w("MicroMsg.ReadMailUI", "replaceMsgContent fail, ex = %s", new Object[]{e.getMessage()});
                                    }
                                }
                                if (i == -10005 && !ak.isConnected(this.ihi.igZ)) {
                                    Toast.makeText(this.ihi.igZ, this.ihi.igZ.getString(2131232875, new Object[]{Integer.valueOf(2), Integer.valueOf(i)}), 1).show();
                                }
                                this.ihi.igZ.igo.loadDataWithBaseURL(q.aHA(), str + "(" + i + ")", "text/html", ProtocolPackage.ServerEncoding, null);
                                return;
                            case 2:
                                if (i == -5) {
                                    intent = new Intent(this.ihi.igZ, QQMailStubProxyUI.class);
                                    intent.addFlags(268435456);
                                    this.ihi.igZ.startActivityForResult(intent, 2);
                                    return;
                                }
                                Toast.makeText(this.ihi.igZ, str, 1).show();
                                return;
                            default:
                                v.e("MicroMsg.ReadMailUI", "onError invalid userData = %d", new Object[]{Integer.valueOf(this.ihi.ihg)});
                                return;
                        }
                    }
                }
            });
        }

        public final boolean onReady() {
            this.igZ.handler.post(new Runnable(this) {
                final /* synthetic */ a ihi;

                {
                    this.ihi = r1;
                }

                public final void run() {
                    ReadMailUI.a(this.ihi.igZ, new HashMap());
                }
            });
            return true;
        }

        public final void onComplete() {
            this.igZ.handler.post(new Runnable(this) {
                final /* synthetic */ a ihi;

                {
                    this.ihi = r1;
                }

                public final void run() {
                    this.ihi.igZ.igp.setVisibility(8);
                    this.ihi.igZ.igG = -2;
                }
            });
        }
    }

    static /* synthetic */ void E(ReadMailUI readMailUI) {
        readMailUI.cnm = aa.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.cnm != null) {
            be.i(readMailUI.cnm.getString("qqmail_downloadpath", ""), readMailUI);
        }
    }

    static /* synthetic */ void F(ReadMailUI readMailUI) {
        Intent intent = new Intent();
        if (be.kS(readMailUI.igX)) {
            v.w("MicroMsg.ReadMailUI", "mQQMailSchemeForUnread is null");
            readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
            return;
        }
        v.d("MicroMsg.ReadMailUI", "qq mail scheme:%s", new Object[]{readMailUI.igX.replace("$uin$", (String) new ReadMailProxy(readMailUI.gZK, new a(readMailUI, 1)).REMOTE_CALL("getBindUin", new Object[0]))});
        intent.setData(Uri.parse(r0));
        intent.addFlags(268435456);
        if (VERSION.SDK_INT >= 11) {
            intent.addFlags(32768);
        }
        if (be.m(readMailUI, intent)) {
            readMailUI.startActivity(intent);
            return;
        }
        v.w("MicroMsg.ReadMailUI", "schema failed");
        readMailUI.startActivity(readMailUI.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail"));
    }

    static /* synthetic */ void J(ReadMailUI readMailUI) {
        try {
            new ReadMailProxy(readMailUI.gZK, null).REMOTE_CALL("deleteMsgById", Long.valueOf(readMailUI.bao));
        } catch (Exception e) {
            v.w("MicroMsg.ReadMailUI", "doDelete fail, ex = %s", new Object[]{e.getMessage()});
        }
        readMailUI.finish();
    }

    static /* synthetic */ void a(ReadMailUI readMailUI, final Runnable runnable) {
        CookieSyncManager.createInstance(readMailUI);
        final CookieManager instance = CookieManager.getInstance();
        instance.removeSessionCookie();
        readMailUI.handler.postDelayed(new Runnable(readMailUI) {
            final /* synthetic */ ReadMailUI igZ;

            public final void run() {
                Map map = null;
                if (!this.igZ.isFinishing()) {
                    try {
                        map = (Map) new ReadMailProxy(this.igZ.gZK, null).REMOTE_CALL("getCookie", new Object[0]);
                    } catch (Exception e) {
                        v.w("MicroMsg.ReadMailUI", "getCookie, ex = %s", new Object[]{e.getMessage()});
                    }
                    if (map != null) {
                        instance.setCookie(q.aHA(), "skey=" + ((String) map.get("skey")));
                        instance.setCookie(q.aHA(), "uin=" + ((String) map.get(OpenSDKTool4Assistant.EXTRA_UIN)));
                        instance.setCookie(q.aHA(), "svrid=" + ((String) map.get("svrid")));
                        CookieSyncManager.getInstance().sync();
                    }
                    if (!this.igZ.isFinishing() && this.igZ.igo != null) {
                        runnable.run();
                    }
                }
            }
        }, 500);
    }

    static /* synthetic */ void a(ReadMailUI readMailUI, Map map) {
        if (be.getInt(be.ah((String) map.get(".Response.result.attachlen"), "0"), 0) == 0) {
            readMailUI.igA.setVisibility(8);
            return;
        }
        readMailUI.igA.setVisibility(0);
        ((TextView) readMailUI.findViewById(2131758799)).setText(readMailUI.getString(2131234326, new Object[]{Integer.valueOf(r3)}));
        readMailUI.igB.removeAllViews();
        MailAttachListLinearLayout mailAttachListLinearLayout = readMailUI.igB;
        int i = be.getInt(be.ah((String) map.get(".Response.result.attachlen"), "0"), 0);
        if (i == 0) {
            v.i("MicroMsg.MailAttachListLinearLayout", "inflate, attachLen = 0");
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            StringBuffer stringBuffer = new StringBuffer(".Response.result.attachlist.item");
            if (i2 != 0) {
                stringBuffer.append(i2);
            }
            String stringBuffer2 = stringBuffer.toString();
            if (map.get(stringBuffer2) == null) {
                v.e("MicroMsg.MailAttachListLinearLayout", "item is null, itemKey = " + stringBuffer2);
                return;
            }
            View inflate = View.inflate(mailAttachListLinearLayout.context, 2130904241, null);
            if (i == 1 || i2 >= i - 1) {
                inflate.setBackgroundResource(2130838609);
            } else {
                inflate.setBackgroundResource(2130838608);
            }
            mailAttachListLinearLayout.addView(inflate);
            String str = (String) map.get(stringBuffer2 + ".name");
            long j = be.getLong((String) map.get(stringBuffer2 + ".size"), 0);
            ((TextView) inflate.findViewById(2131758810)).setText(str);
            ((TextView) inflate.findViewById(2131758811)).setText(be.aw(j));
            String str2 = (String) map.get(stringBuffer2 + ".path");
            String co = MailAttachListLinearLayout.co(str2, "mailid");
            map.get(stringBuffer2 + ".type");
            String str3 = "";
            try {
                str3 = URLDecoder.decode(MailAttachListLinearLayout.co(str2, "attachid"), ProtocolPackage.ServerEncoding);
            } catch (Throwable e) {
                v.a("MicroMsg.MailAttachListLinearLayout", e, "", new Object[0]);
            }
            mailAttachListLinearLayout.ifE.add(str);
            inflate.setOnClickListener(new com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout.AnonymousClass1(mailAttachListLinearLayout, str, co, str3, j, be.getInt(be.ah((String) map.get(stringBuffer2 + ".preview"), "0"), 0), str2));
            ((ImageView) inflate.findViewById(2131758809)).setImageResource(FileExplorerUI.HU(str));
            i2++;
        }
    }

    static /* synthetic */ void q(ReadMailUI readMailUI) {
        readMailUI.igz.setOnClickListener(new OnClickListener(readMailUI) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final void onClick(View view) {
                this.igZ.aIu();
            }
        });
        readMailUI.igq.setOnClickListener(new OnClickListener(readMailUI) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final void onClick(View view) {
                this.igZ.igq.setVisibility(8);
                this.igZ.a(new com.tencent.mm.plugin.qqmail.b.q.c());
            }
        });
        readMailUI.a(0, 2130838681, new OnMenuItemClickListener(readMailUI) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.igZ, null, this.igZ.getResources().getStringArray(2131296256), this.igZ.getResources().getString(2131234329), false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass11 ihe;

                    {
                        this.ihe = r1;
                    }

                    public final void gT(int i) {
                        int i2 = 0;
                        if (i == 3) {
                            ReadMailUI.J(this.ihe.igZ);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(this.ihe.igZ, ComposeUI.class);
                        intent.putExtra("mailid", this.ihe.igZ.iaq);
                        intent.putExtra("subject", this.ihe.igZ.iav);
                        String[] a = this.ihe.igZ.igs.a(false, this.ihe.igZ.gZK);
                        String[] a2 = this.ihe.igZ.igu.a(true, this.ihe.igZ.gZK);
                        String[] a3 = this.ihe.igZ.igt.a(true, this.ihe.igZ.gZK);
                        switch (i) {
                            case 0:
                                intent.putExtra("composeType", 2);
                                intent.putExtra("toList", a);
                                break;
                            case 1:
                                int i3;
                                intent.putExtra("composeType", 2);
                                String[] strArr = new String[(a.length + a2.length)];
                                int length = a.length;
                                int i4 = 0;
                                int i5 = 0;
                                while (i4 < length) {
                                    i3 = i5 + 1;
                                    strArr[i5] = a[i4];
                                    i4++;
                                    i5 = i3;
                                }
                                i3 = a2.length;
                                while (i2 < i3) {
                                    i4 = i5 + 1;
                                    strArr[i5] = a2[i2];
                                    i2++;
                                    i5 = i4;
                                }
                                intent.putExtra("toList", strArr);
                                intent.putExtra("ccList", a3);
                                break;
                            case 2:
                                intent.putExtra("composeType", 3);
                                break;
                            default:
                                return;
                        }
                        this.ihe.igZ.startActivity(intent);
                    }
                });
                return false;
            }
        });
        if (readMailUI.igG != -2) {
            String str;
            if (!(readMailUI.igG == -1 || readMailUI.igG == -2)) {
                try {
                    new ReadMailProxy(readMailUI.gZK, new a(readMailUI, 0)).REMOTE_CALL("cancel", Long.valueOf(readMailUI.igG));
                } catch (Exception e) {
                    v.w("MicroMsg.ReadMailUI", "render cancel, ex = %s", new Object[]{e.getMessage()});
                }
            }
            try {
                str = (String) new ReadMailProxy(readMailUI.gZK, null).REMOTE_CALL("getMsgContent", Long.valueOf(readMailUI.bao));
            } catch (Exception e2) {
                v.w("MicroMsg.ReadMailUI", "render, getMsgContent, ex = %s", new Object[]{e2.getMessage()});
                str = null;
            }
            Map q = bf.q(str, "msg");
            if (q == null) {
                v.e("MicroMsg.ReadMailUI", "render fail, maps is null");
                return;
            }
            readMailUI.Fd("");
            readMailUI.iaq = (String) q.get(".msg.pushmail.mailid");
            readMailUI.iav = (String) q.get(".msg.pushmail.content.subject");
            readMailUI.igs.a(new String[]{((String) q.get(".msg.pushmail.content.fromlist.item.name")) + " " + ((String) q.get(".msg.pushmail.content.fromlist.item.addr"))}, true);
            readMailUI.igu.a(a(q, ".msg.pushmail.content.tolist", be.getInt((String) q.get(".msg.pushmail.content.tolist.$count"), 0)), true);
            String[] a = a(q, ".msg.pushmail.content.cclist", be.getInt((String) q.get(".msg.pushmail.content.cclist.$count"), 0));
            LinearLayout linearLayout = readMailUI.igx;
            int i = (a == null || a.length == 0) ? 8 : 0;
            linearLayout.setVisibility(i);
            readMailUI.igt.a(a, true);
            readMailUI.igy.setText(readMailUI.iav);
            readMailUI.fBO.setText((CharSequence) q.get(".msg.pushmail.content.date"));
            readMailUI.igz.setEnabled(true);
            readMailUI.a(new com.tencent.mm.plugin.qqmail.b.q.c());
        }
    }

    static /* synthetic */ void s(ReadMailUI readMailUI) {
        readMailUI.cnm = aa.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.cnm != null) {
            long j = readMailUI.cnm.getLong("qqmail_info_report_time", -1);
            long currentTimeMillis = System.currentTimeMillis();
            if (j < 0 || currentTimeMillis - j > 86400000) {
                if (p.o(readMailUI, "com.tencent.androidqqmail")) {
                    int i = p.av(readMailUI, "com.tencent.androidqqmail").versionCode;
                    v.d("MicroMsg.ReadMailUI", "is intalled:%d, version:%d", new Object[]{Integer.valueOf(1), Integer.valueOf(i)});
                    new ReadMailProxy(readMailUI.gZK, null).REMOTE_CALL("reportKvStates", Integer.valueOf(11389), Integer.valueOf(1), Integer.valueOf(i));
                } else {
                    v.d("MicroMsg.ReadMailUI", "is intalled:%d", new Object[]{Integer.valueOf(0)});
                    readMailUI.cg(11389, 0);
                }
                readMailUI.cnm.edit().putLong("qqmail_info_report_time", currentTimeMillis).commit();
            }
        }
    }

    static /* synthetic */ void z(ReadMailUI readMailUI) {
        readMailUI.goV = ((Long) new ReadMailProxy(readMailUI.gZK, null).REMOTE_CALL("downloadQQMailApp", readMailUI.igK, readMailUI.igL)).longValue();
        if (readMailUI.goV <= 0) {
            v.e("MicroMsg.ReadMailUI", "doAddDownloadTask fail, downloadId = %d ", new Object[]{Long.valueOf(readMailUI.goV)});
            return;
        }
        readMailUI.cnm = aa.getContext().getSharedPreferences("QQMAIL", 4);
        if (readMailUI.cnm != null) {
            readMailUI.cnm.edit().putLong("qqmail_downloadid", readMailUI.goV).commit();
        }
        readMailUI.igQ = 1;
        readMailUI.igM = ((Integer) new ReadMailProxy(readMailUI.gZK, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(readMailUI.goV))).intValue();
        readMailUI.igC.setVisibility(0);
        readMailUI.aIx();
        readMailUI.aIt();
    }

    private void aIt() {
        switch (this.igQ) {
            case 0:
                this.igE.setText(2131234333);
                return;
            case 1:
                this.igE.setText(2131234331);
                return;
            case 2:
                this.igE.setText(2131234332);
                return;
            case 3:
                String str = "";
                if (this.igY > 99) {
                    str = "99+";
                } else if (this.igY > 0) {
                    str = Integer.toString(this.igY);
                }
                if (be.kS(str)) {
                    this.igE.setText(2131234334);
                    return;
                }
                this.igE.setText(String.format(com.tencent.mm.bd.a.O(this, 2131234335), new Object[]{str}));
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130904240;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new ac();
        this.bao = getIntent().getLongExtra("msgid", -1);
        this.igH = 0;
        this.igI = 0;
        NI();
        this.gZK.z(new Runnable(this) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final void run() {
                ReadMailUI.q(this.igZ);
                if (this.igZ.igI == 0) {
                    ReadMailUI.s(this.igZ);
                    if (!this.igZ.aIv()) {
                        this.igZ.aIw();
                    }
                    this.igZ.igW = new ReadMailProxy(this.igZ.gZK, null, new b(this.igZ), new c(this.igZ));
                    this.igZ.igW.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (this.igG != -1 && this.igG != -2) {
            try {
                new ReadMailProxy(this.gZK, new a(this, 0)).REMOTE_CALL("cancel", Long.valueOf(this.igG));
            } catch (Exception e) {
                v.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
    }

    protected void onStop() {
        super.onStop();
        this.igo.stopLoading();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.igW != null) {
            this.igW.REMOTE_CALL("removeDownloadCallback", new Object[0]);
        }
        this.gZK.release();
        this.igo.setVisibility(8);
        this.igo.destroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 1) {
                v.d("MicroMsg.ReadMailUI", "USER_DATA_READMAIL onAfterVerify");
                a(new com.tencent.mm.plugin.qqmail.b.q.c());
            } else if (i == 2) {
                v.d("MicroMsg.ReadMailUI", "USER_DATA_SETUNREAD onAfterVerify");
                aIu();
            }
        }
    }

    protected final void NI() {
        this.igs = (MailAddrsViewControl) findViewById(2131758789);
        this.igu = (MailAddrsViewControl) findViewById(2131758792);
        this.igt = (MailAddrsViewControl) findViewById(2131758794);
        this.igv = (TextView) findViewById(2131758790);
        this.igw = findViewById(2131758791);
        this.igx = (LinearLayout) findViewById(2131758793);
        this.igy = (TextView) findViewById(2131758795);
        this.fBO = (TextView) findViewById(2131758796);
        this.igz = (TextView) findViewById(2131758797);
        this.igA = (LinearLayout) findViewById(2131758798);
        this.igB = (MailAttachListLinearLayout) findViewById(2131758800);
        this.igp = (ProgressBar) findViewById(2131758807);
        this.igq = (ImageView) findViewById(2131758808);
        this.igr = (TextView) findViewById(2131758801);
        MMWebViewWithJsApi.eO(this);
        MMWebViewWithJsApi mMWebViewWithJsApi = (MMWebViewWithJsApi) findViewById(2131758802);
        mMWebViewWithJsApi.cfB = true;
        mMWebViewWithJsApi.pdG = mMWebViewWithJsApi.getX5WebViewExtension() != null;
        this.igo = (MailMMWebView) mMWebViewWithJsApi;
        this.igF = findViewById(2131758788);
        this.igC = findViewById(2131758803);
        this.igE = (TextView) findViewById(2131758806);
        this.igD = (TextView) findViewById(2131758804);
        this.igC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final void onClick(View view) {
                switch (this.igZ.igQ) {
                    case 0:
                        this.igZ.cg(11288, 2);
                        if (be.kS(this.igZ.igK) || be.kS(this.igZ.igL)) {
                            e.a(new Runnable(this.igZ) {
                                final /* synthetic */ ReadMailUI igZ;

                                {
                                    this.igZ = r1;
                                }

                                public final void run() {
                                    Throwable th;
                                    Throwable th2;
                                    HttpURLConnection httpURLConnection = null;
                                    try {
                                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.igZ.igJ).openConnection();
                                        try {
                                            httpURLConnection2.setInstanceFollowRedirects(false);
                                            httpURLConnection2.connect();
                                            this.igZ.igK = httpURLConnection2.getHeaderField("Location");
                                            InputStream inputStream = httpURLConnection2.getInputStream();
                                            int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                                            if (headerFieldInt <= 0) {
                                                v.e("MicroMsg.ReadMailUI", "error content-length");
                                                inputStream.close();
                                                httpURLConnection2.disconnect();
                                                if (httpURLConnection2 != null) {
                                                    httpURLConnection2.disconnect();
                                                    return;
                                                }
                                                return;
                                            }
                                            byte[] bArr = new byte[headerFieldInt];
                                            inputStream.read(bArr);
                                            inputStream.close();
                                            v.i("MicroMsg.ReadMailUI", "dz[mQQMailDownloadUrl:%s]", new Object[]{this.igZ.igK});
                                            this.igZ.igL = new String(l.a(Base64.decode(bArr, 0), l.m(this.igZ.getApplicationContext(), "rsa_public_key_forwx.pem")));
                                            v.i("MicroMsg.ReadMailUI", "dz[mQQMailMD5:%s]", new Object[]{this.igZ.igL});
                                            ad.o(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass3 ihb;

                                                {
                                                    this.ihb = r1;
                                                }

                                                public final void run() {
                                                    ReadMailUI.z(this.ihb.igZ);
                                                }
                                            });
                                            if (httpURLConnection2 != null) {
                                                httpURLConnection2.disconnect();
                                            }
                                        } catch (Throwable e) {
                                            th = e;
                                            httpURLConnection = httpURLConnection2;
                                            th2 = th;
                                            try {
                                                v.a("MicroMsg.ReadMailUI", th2, "", new Object[0]);
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                if (httpURLConnection != null) {
                                                    httpURLConnection.disconnect();
                                                }
                                                throw th2;
                                            }
                                        } catch (Throwable e2) {
                                            th = e2;
                                            httpURLConnection = httpURLConnection2;
                                            th2 = th;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th2;
                                        }
                                    } catch (Exception e3) {
                                        th2 = e3;
                                        v.a("MicroMsg.ReadMailUI", th2, "", new Object[0]);
                                        if (httpURLConnection != null) {
                                            httpURLConnection.disconnect();
                                        }
                                    }
                                }
                            }, "initQQMailDownloadUrlAndMD5");
                            return;
                        } else {
                            ReadMailUI.z(this.igZ);
                            return;
                        }
                    case 1:
                        this.igZ.cg(11288, 1);
                        int intValue = ((Integer) new ReadMailProxy(this.igZ.gZK, null).REMOTE_CALL("removeDownloadQQMailAppTask", Long.valueOf(this.igZ.goV))).intValue();
                        if (intValue == -1) {
                            v.e("MicroMsg.ReadMailUI", "cancel_download_task:fail_apilevel_too_low downloadId = %d", new Object[]{Long.valueOf(this.igZ.goV)});
                            return;
                        } else if (intValue <= 0) {
                            v.e("MicroMsg.ReadMailUI", "cancel_download_task:fail downloadId = %d", new Object[]{Long.valueOf(this.igZ.goV)});
                            return;
                        } else {
                            v.i("MicroMsg.ReadMailUI", "cancel_download_task:ok downloadId = %d", new Object[]{Long.valueOf(this.igZ.goV)});
                            this.igZ.igO.QI();
                            this.igZ.oB(0);
                            this.igZ.igQ = 0;
                            this.igZ.aIt();
                            return;
                        }
                    case 2:
                        this.igZ.cg(11288, 3);
                        ReadMailUI.E(this.igZ);
                        return;
                    case 3:
                        this.igZ.cg(11288, 4);
                        ReadMailUI.F(this.igZ);
                        return;
                    default:
                        return;
                }
            }
        });
        this.igv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final void onClick(View view) {
                if (this.igZ.igw.getVisibility() == 8) {
                    this.igZ.igv.setText(2131234324);
                    this.igZ.igw.setVisibility(0);
                    this.igZ.igw.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 ihc;

                        {
                            this.ihc = r1;
                        }

                        public final void run() {
                            this.ihc.igZ.igu.aIn();
                            this.ihc.igZ.igt.aIn();
                        }
                    });
                    this.igZ.igz.setVisibility(0);
                    return;
                }
                this.igZ.igv.setText(2131234325);
                this.igZ.igw.setVisibility(8);
                this.igZ.igz.setVisibility(8);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.igZ.finish();
                return true;
            }
        });
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        igU = ((float) displayMetrics.widthPixels) / displayMetrics.scaledDensity;
        igV = displayMetrics.heightPixels;
        this.igo.getSettings().setDefaultTextEncodingName(ProtocolPackage.ServerEncoding);
        this.igo.getSettings().setSupportZoom(false);
        this.igo.getSettings().setBuiltInZoomControls(false);
        this.igo.getSettings().setDisplayZoomControls(false);
        this.igo.getSettings().setLoadsImagesAutomatically(false);
        this.igo.getSettings().setUseWideViewPort(true);
        this.igo.bKn();
        MailMMWebView mailMMWebView = this.igo;
        View view = this.igF;
        if (view != null) {
            if (mailMMWebView.ifY != null) {
                mailMMWebView.removeView(mailMMWebView.ifY);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            mailMMWebView.ifY = new a(mailMMWebView, mailMMWebView.getContext());
            ((a) mailMMWebView.ifY).addView(view, new FrameLayout.LayoutParams(-1, -2));
            mailMMWebView.ifY.setBackgroundColor(-1);
            mailMMWebView.addView(mailMMWebView.ifY, layoutParams);
        }
        mailMMWebView = this.igo;
        view = this.igC;
        if (view != null) {
            if (mailMMWebView.ifZ != null) {
                mailMMWebView.removeView(mailMMWebView.ifZ);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            mailMMWebView.ifZ = new a(mailMMWebView, mailMMWebView.getContext());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            ((a) mailMMWebView.ifZ).addView(view, layoutParams3);
            mailMMWebView.addView(mailMMWebView.ifZ, layoutParams);
            mailMMWebView.ifZ.setVisibility(4);
        }
        Intent intent = this.nDR.nEl.getIntent();
        byte[] bArr = new byte[112];
        bArr[25] = (byte) 1;
        bArr[16] = (byte) 1;
        bArr[57] = (byte) 1;
        bArr[63] = (byte) 1;
        bArr[61] = (byte) 1;
        bArr[70] = (byte) 1;
        bArr[68] = (byte) 1;
        bArr[82] = (byte) 1;
        bArr[111] = (byte) 1;
        intent.putExtra("hardcode_jspermission", new JsapiPermissionWrapper(bArr));
        this.nDR.nEl.setIntent(intent);
        this.igo.setWebViewClient(new com.tencent.mm.plugin.webview.ui.tools.widget.b(this, this.igo) {
            final /* synthetic */ ReadMailUI igZ;

            public final boolean ym(String str) {
                v.d("MicroMsg.ReadMailUI", "url:%s", new Object[]{str});
                if (str != null && str.startsWith("mailto:")) {
                    String replace = str.trim().replace("mailto:", "");
                    Intent intent = new Intent(this.igZ, ComposeUI.class);
                    intent.putExtra("composeType", 4);
                    intent.putExtra("toList", new String[]{replace + " " + replace});
                    this.igZ.startActivity(intent);
                    return true;
                } else if (str != null && str.startsWith("tel:")) {
                    r1 = new Intent("android.intent.action.DIAL", Uri.parse(str));
                    r1.addFlags(268435456);
                    this.igZ.startActivity(r1);
                    return true;
                } else if (str == null || str.startsWith("data:")) {
                    return false;
                } else {
                    if (this.igZ.igo.ifX) {
                        this.igZ.igo.ifX = false;
                        return true;
                    } else if (!str.startsWith("http")) {
                        return false;
                    } else {
                        r1 = new Intent();
                        r1.putExtra("rawUrl", str);
                        com.tencent.mm.ay.c.b(this.igZ, "webview", ".ui.tools.WebViewUI", r1);
                        return true;
                    }
                }
            }

            public final void onLoadResource(WebView webView, String str) {
                v.d("MicroMsg.ReadMailUI", "load res:%s", new Object[]{str});
            }

            public final void a(WebView webView) {
                webView.evaluateJavascript("javascript:var meta = document.createElement(\"meta\");meta.name=\"viewport\";meta.id=\"viewport\";meta.content=\"initial-scale=1,user-scalable=yes,maximum-scale=3.0\";document.head.appendChild(meta);", null);
                webView.evaluateJavascript("javascript:" + ReadMailUI.igR, null);
                webView.evaluateJavascript("javascript:" + ReadMailUI.igS, null);
                webView.evaluateJavascript("javascript:" + ReadMailUI.igT, null);
                if (this.igZ.gZK.isConnected()) {
                    if (!this.igZ.aIv()) {
                        this.igZ.aIw();
                    }
                    this.igZ.igW = new ReadMailProxy(this.igZ.gZK, null, new b(this.igZ), new c(this.igZ));
                    this.igZ.igW.REMOTE_CALL("addDownloadCallback", new Object[0]);
                }
                new ac(this.igZ.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 ihd;

                    {
                        this.ihd = r1;
                    }

                    public final void run() {
                        this.ihd.igZ.igo.getSettings().setLoadsImagesAutomatically(true);
                        this.ihd.igZ.igo.getSettings().setSupportZoom(true);
                        this.ihd.igZ.igo.getSettings().setBuiltInZoomControls(true);
                        this.ihd.igZ.igo.aIr();
                        this.ihd.igZ.igo.aIs();
                    }
                }, 200);
                new ac(this.igZ.getMainLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass8 ihd;

                    {
                        this.ihd = r1;
                    }

                    public final void run() {
                        int contentHeight = (int) (((float) this.ihd.igZ.igo.getContentHeight()) * this.ihd.igZ.igo.getScale());
                        v.d("MicroMsg.ReadMailUI", this.ihd.igZ.igo.getContentHeight() + "," + this.ihd.igZ.igo.getHeight() + "," + this.ihd.igZ.igo.getScale());
                        if (Math.abs(contentHeight - this.ihd.igZ.igo.getHeight()) < 10) {
                            this.ihd.igZ.igo.eV(true);
                        }
                    }
                }, 400);
            }
        });
        if (igS.equals("")) {
            try {
                igS += be.e(getAssets().open("mail/lib.js"));
                igT += be.e(getAssets().open("mail/readmail.js"));
                igR += "mail_css.innerHTML='" + be.e(getAssets().open("mail/qmail_webview.css")) + "'; document.head.appendChild(mail_css);";
            } catch (Throwable e) {
                v.a("MicroMsg.ReadMailUI", e, "", new Object[0]);
                v.e("MicroMsg.ReadMailUI", "evaluateJavascript error " + e.getMessage());
            }
        }
        registerForContextMenu(this.igo);
        new com.tencent.mm.ui.tools.l(this).a(this.igo, this, null);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (view instanceof WebView) {
            final HitTestResult hitTestResult = ((WebView) view).getHitTestResult();
            if (hitTestResult.getType() == 5 || hitTestResult.getType() == 8) {
                boolean booleanValue;
                try {
                    booleanValue = ((Boolean) new ReadMailProxy(this.gZK, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                } catch (Exception e) {
                    v.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[]{e.getMessage()});
                    booleanValue = false;
                }
                if (booleanValue) {
                    contextMenu.setHeaderTitle(2131236680);
                    contextMenu.add(0, 0, 0, getString(2131234727)).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                        final /* synthetic */ ReadMailUI igZ;

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            boolean booleanValue;
                            String extra = hitTestResult.getExtra();
                            if (extra.contains("qqmail.weixin.qq.com") && !extra.contains("qqmail.weixin.qq.com:443")) {
                                extra = extra.replace("qqmail.weixin.qq.com", "qqmail.weixin.qq.com:443");
                            }
                            String replaceFirst = extra.replaceFirst("%p2p0", "%25p2p0");
                            try {
                                booleanValue = ((Boolean) new ReadMailProxy(this.igZ.gZK, null).REMOTE_CALL("isSDCardAvailable", new Object[0])).booleanValue();
                            } catch (Exception e) {
                                v.w("MicroMsg.ReadMailUI", "createContextMenu, isSDCardAvailable, ex = %s", new Object[]{e.getMessage()});
                                booleanValue = false;
                            }
                            s.a(this.igZ, replaceFirst, CookieManager.getInstance().getCookie(q.aHA()), booleanValue);
                            return true;
                        }
                    });
                } else {
                    return;
                }
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    private static String[] a(Map<String, String> map, String str, int i) {
        if (map.get(str) == null) {
            return null;
        }
        String[] strArr = new String[i];
        int i2 = 0;
        while (i2 < i) {
            String str2 = str + ".item" + (i2 > 0 ? Integer.valueOf(i2) : "");
            strArr[i2] = ((String) map.get(str2 + ".name")) + " " + ((String) map.get(str2 + ".addr"));
            i2++;
        }
        return strArr;
    }

    private void a(com.tencent.mm.plugin.qqmail.b.q.c cVar) {
        if (this.iaq == null || this.iaq.length() == 0) {
            v.e("MicroMsg.ReadMailUI", "doReadMail invalid argument");
            return;
        }
        this.igq.setVisibility(8);
        this.igp.setVisibility(0);
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.iaq);
        hashMap.put("texttype", "html");
        if (!(this.igG == -1 || this.igG == -2)) {
            try {
                new ReadMailProxy(this.gZK, new a(this, 0)).REMOTE_CALL("cancel", Long.valueOf(this.igG));
            } catch (Exception e) {
                v.w("MicroMsg.ReadMailUI", "cancel, ex = %s", new Object[]{e.getMessage()});
            }
        }
        this.ign = this.iaq;
        cVar.t(new Bundle());
        try {
            this.igG = ((Long) new ReadMailProxy(this.gZK, new a(this, 1)).REMOTE_CALL("get", "/cgi-bin/readmail", hashMap, new Bundle())).longValue();
        } catch (Exception e2) {
            v.w("MicroMsg.ReadMailUI", "doReadMail get fail, ex = %s", new Object[]{e2.getMessage()});
        }
    }

    private void aIu() {
        if (this.iaq == null || this.iaq.length() == 0) {
            v.e("MicroMsg.ReadMailUI", "doSetUnread invalid argument");
            return;
        }
        new HashMap().put("mailid", this.iaq);
        com.tencent.mm.plugin.qqmail.b.q.c cVar = new com.tencent.mm.plugin.qqmail.b.q.c();
        cVar.ibw = false;
        cVar.t(new Bundle());
        try {
            new ReadMailProxy(this.gZK, new a(this, 2)).REMOTE_CALL("get", "/cgi-bin/setmailunread", new HashMap(), new Bundle());
        } catch (Exception e) {
            v.w("MicroMsg.ReadMailUI", "doSetUnread, ex = %s", new Object[]{e.getMessage()});
        }
    }

    private boolean aIv() {
        this.igJ = (String) new ReadMailProxy(this.gZK, null).REMOTE_CALL("getMailAppRedirectUrlAndroid", new Object[0]);
        this.igX = (String) new ReadMailProxy(this.gZK, null).REMOTE_CALL("getMailAppEnterUlAndroid", new Object[0]);
        try {
            this.igY = ((Integer) new ReadMailProxy(this.gZK, null).REMOTE_CALL("getUneradMailCountFromConfig", new Object[0])).intValue();
        } catch (Throwable e) {
            this.igY = -1;
            v.a("MicroMsg.ReadMailUI", e, "getUneradMailCountFromConfig got an NullPointerException", new Object[0]);
        }
        new ReadMailProxy(this.gZK, null).REMOTE_CALL("getUnreadMailCount", new Object[0]);
        Integer num = (Integer) new ReadMailProxy(this.gZK, null).REMOTE_CALL("showMailAppRecommend", new Object[0]);
        if (num == null) {
            v.e("MicroMsg.ReadMailUI", "Remote server Proxy not ready");
            return true;
        }
        this.igI = 1;
        this.igH = num.intValue();
        if (be.kS(this.igX)) {
            return true;
        }
        if (p.o(this, "com.tencent.androidqqmail")) {
            this.igQ = 3;
            aIt();
            return true;
        }
        this.cnm = aa.getContext().getSharedPreferences("QQMAIL", 4);
        if (this.cnm == null) {
            return true;
        }
        this.goV = this.cnm.getLong("qqmail_downloadid", -1);
        this.igM = ((Integer) new ReadMailProxy(this.gZK, null).REMOTE_CALL("getMailAppDownloadStatus", Long.valueOf(this.goV))).intValue();
        this.igN = this.cnm.getString("qqmail_downloadpath", "");
        if (this.igM == 3 && com.tencent.mm.a.e.aR(this.igN)) {
            this.igQ = 2;
            aIt();
            if (this.igO != null) {
                this.igO.QI();
            }
            return true;
        } else if (this.igH == 1) {
            return false;
        } else {
            v.e("MicroMsg.ReadMailUI", "promote qq mail error:MailAppRecomend = %d", new Object[]{Integer.valueOf(this.igH)});
            return true;
        }
    }

    private void aIw() {
        if (be.kS(this.igJ)) {
            v.e("MicroMsg.ReadMailUI", "mQQMailRedirectUrl = null");
            return;
        }
        oB(0);
        v.i("MicroMsg.ReadMailUI", "status:%d", new Object[]{Integer.valueOf(this.igM)});
        switch (this.igM) {
            case 1:
            case 2:
                this.igQ = 1;
                aIx();
                aIt();
                return;
            case 3:
                if (!com.tencent.mm.a.e.aR(this.igN)) {
                    break;
                }
                return;
        }
        this.igQ = 0;
        oB(0);
        aIt();
    }

    private void oB(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.igD.getLayoutParams();
        layoutParams.width = i;
        this.igD.setLayoutParams(layoutParams);
    }

    private void aIx() {
        this.igO = new ah(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ ReadMailUI igZ;

            {
                this.igZ = r1;
            }

            public final boolean oU() {
                if (!this.igZ.gZK.isConnected()) {
                    return false;
                }
                double doubleValue = ((Double) new ReadMailProxy(this.igZ.gZK, null).REMOTE_CALL("getMailAppDownloadProgress", Long.valueOf(this.igZ.goV))).doubleValue();
                if (doubleValue == 1.0d) {
                    this.igZ.aIv();
                    return false;
                }
                int i;
                if (this.igZ.igP == 0) {
                    this.igZ.igP = this.igZ.igC.getWidth();
                    i = 0;
                } else {
                    i = (int) (((double) this.igZ.igP) * doubleValue);
                }
                this.igZ.oB(i);
                return true;
            }
        }, true);
        this.igO.ea(500);
    }

    private void cg(int i, int i2) {
        new ReadMailProxy(this.gZK, null).REMOTE_CALL("reportKvState", Integer.valueOf(i), Integer.valueOf(i2));
    }

    protected void onResume() {
        if (this.igH == 1 && !aIv()) {
            aIw();
        }
        super.onResume();
    }
}
