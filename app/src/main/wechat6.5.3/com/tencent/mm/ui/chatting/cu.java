package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.a.l;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.downloader.d;
import com.tencent.mm.pluginsdk.model.downloader.f;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class cu {
    SharedPreferences cnm;
    LinearLayout fqo = null;
    long fwR = -1;
    String igJ;
    String igK;
    String igL;
    Context mContext;
    String orA = null;
    String orB;
    OnClickListener orC = new OnClickListener(this) {
        final /* synthetic */ cu orF;

        {
            this.orF = r1;
        }

        public final void onClick(View view) {
            new Intent().putExtra("composeType", 1);
            c.w(this.orF.mContext, "qqmail", ".ui.ComposeUI");
        }
    };
    OnClickListener orD = new OnClickListener(this) {
        final /* synthetic */ cu orF;

        {
            this.orF = r1;
        }

        public final void onClick(View view) {
            cu cuVar;
            switch (this.orF.orx) {
                case NEED_INSTALL:
                    g.iuh.h(11288, Integer.valueOf(7));
                    cuVar = this.orF;
                    v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                    be.i(cuVar.orA, cuVar.mContext);
                    return;
                case DOWNLOADING:
                    cuVar = this.orF;
                    v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                    d.bnK().dm(cuVar.fwR);
                    cuVar.bEP();
                    return;
                case NEED_DOWNLOAD:
                    g.iuh.h(11288, Integer.valueOf(6));
                    cu cuVar2 = this.orF;
                    if (!ak.isConnected(cuVar2.mContext)) {
                        com.tencent.mm.ui.base.g.a(cuVar2.mContext, com.tencent.mm.bd.a.O(cuVar2.mContext, 2131231747), SQLiteDatabase.KeyEmpty, com.tencent.mm.bd.a.O(cuVar2.mContext, 2131231742), null);
                        return;
                    } else if (ak.isWifi(cuVar2.mContext)) {
                        com.tencent.mm.ui.base.g.a(cuVar2.mContext, 2131231745, 0, 2131231740, 2131231739, new DialogInterface.OnClickListener(cuVar2) {
                            final /* synthetic */ cu orF;

                            {
                                this.orF = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                cu.b(this.orF);
                            }
                        }, null);
                        return;
                    } else {
                        com.tencent.mm.ui.base.g.a(cuVar2.mContext, 2131231744, 0, 2131231740, 2131231739, new DialogInterface.OnClickListener(cuVar2) {
                            final /* synthetic */ cu orF;

                            {
                                this.orF = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                cu.b(this.orF);
                            }
                        }, null);
                        return;
                    }
                case INSTALLED:
                    Intent launchIntentForPackage;
                    g.iuh.h(11288, Integer.valueOf(5));
                    cu cuVar3 = this.orF;
                    v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                    v.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", cuVar3.orB);
                    if (be.kS(cuVar3.orB)) {
                        launchIntentForPackage = cuVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    } else {
                        launchIntentForPackage = new Intent();
                        launchIntentForPackage.setData(Uri.parse(cuVar3.orB));
                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (VERSION.SDK_INT >= 11) {
                            launchIntentForPackage.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                        }
                        if (!be.m(cuVar3.mContext, launchIntentForPackage)) {
                            launchIntentForPackage = cuVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                        }
                    }
                    v.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", launchIntentForPackage);
                    cuVar3.mContext.startActivity(launchIntentForPackage);
                    return;
                case NO_URL:
                    if (this.orF.orz) {
                        cu.a(this.orF);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private com.tencent.mm.pluginsdk.ui.tools.j.a orE = new com.tencent.mm.pluginsdk.ui.tools.j.a(this) {
        final /* synthetic */ cu orF;

        {
            this.orF = r1;
        }

        public final void hm(int i) {
            this.orF.ory = i;
            this.orF.bEQ();
        }

        public final void aHL() {
            this.orF.orv.setText(2131231750);
        }
    };
    ChatFooterCustom ors;
    FrameLayout ort;
    FrameLayout oru;
    TextView orv;
    ImageView orw;
    a orx = a.DEFAULT;
    int ory = -1;
    public boolean orz;

    private enum a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL
    }

    static /* synthetic */ void a(cu cuVar) {
        v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        com.tencent.mm.ui.base.g.a(cuVar.mContext, com.tencent.mm.bd.a.O(cuVar.mContext, 2131231746), SQLiteDatabase.KeyEmpty, com.tencent.mm.bd.a.O(cuVar.mContext, 2131231742), null);
    }

    static /* synthetic */ void b(cu cuVar) {
        v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        e.a(new Runnable(cuVar) {
            final /* synthetic */ cu orF;

            {
                this.orF = r1;
            }

            public final void run() {
                Throwable th;
                Throwable th2;
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.orF.igJ).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.connect();
                        this.orF.igK = httpURLConnection2.getHeaderField("Location");
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                        if (headerFieldInt <= 0) {
                            v.e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                            inputStream.close();
                        } else {
                            byte[] bArr = new byte[headerFieldInt];
                            inputStream.read(bArr);
                            inputStream.close();
                            byte[] a = l.a(Base64.decode(bArr, 0), l.m(this.orF.mContext, "rsa_public_key_forwx.pem"));
                            this.orF.igL = new String(a);
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass5 orG;

                                {
                                    this.orG = r1;
                                }

                                public final void run() {
                                    if (be.kS(this.orG.orF.igK) || be.kS(this.orG.orF.igL)) {
                                        cu.a(this.orG.orF);
                                        return;
                                    }
                                    cu cuVar = this.orG.orF;
                                    v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
                                    com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
                                    aVar.GQ(cuVar.igK);
                                    aVar.GR(cuVar.mContext.getResources().getString(2131232305));
                                    aVar.GS(cuVar.igL);
                                    aVar.hO(true);
                                    aVar.tE(1);
                                    cuVar.fwR = d.bnK().a(aVar.lCn);
                                    if (cuVar.fwR > 0) {
                                        cuVar.cnm = cuVar.mContext.getSharedPreferences("QQMAIL", 4);
                                        cuVar.cnm.edit().putLong("qqmail_downloadid", cuVar.fwR).apply();
                                        cuVar.bEP();
                                    }
                                }
                            });
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable e) {
                        th = e;
                        httpURLConnection = httpURLConnection2;
                        th2 = th;
                        try {
                            v.a("MicroMsg.ChattingQQMailFooterHandler", th2, SQLiteDatabase.KeyEmpty, new Object[0]);
                            cu.a(this.orF);
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
                    v.a("MicroMsg.ChattingQQMailFooterHandler", th2, SQLiteDatabase.KeyEmpty, new Object[0]);
                    cu.a(this.orF);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                }
            }
        }, "QQMailDownloadUrlAndMD5");
    }

    public cu(ChatFooterCustom chatFooterCustom) {
        this.mContext = chatFooterCustom.getContext();
        this.ors = chatFooterCustom;
    }

    final void bEO() {
        if (this.orx == a.INSTALLED) {
            this.orw.setImageResource(2131165849);
        } else {
            this.orw.setImageResource(2131165850);
        }
    }

    public final void bEP() {
        a aVar;
        if (!p.o(this.mContext, "com.tencent.androidqqmail")) {
            this.cnm = this.mContext.getSharedPreferences("QQMAIL", 4);
            this.fwR = this.cnm.getLong("qqmail_downloadid", -1);
            if (this.fwR >= 0) {
                f dn = d.bnK().dn(this.fwR);
                int i = dn.status;
                this.orA = dn.path;
                switch (i) {
                    case 1:
                        aVar = a.DOWNLOADING;
                        break;
                    case 3:
                        if (!com.tencent.mm.a.e.aR(this.orA)) {
                            if (!be.kS(this.igJ)) {
                                aVar = a.NEED_DOWNLOAD;
                                break;
                            } else {
                                aVar = a.NO_URL;
                                break;
                            }
                        }
                        aVar = a.NEED_INSTALL;
                        break;
                    default:
                        if (!be.kS(this.igJ)) {
                            aVar = a.NEED_DOWNLOAD;
                            break;
                        } else {
                            aVar = a.NO_URL;
                            break;
                        }
                }
            }
            aVar = be.kS(this.igJ) ? a.NO_URL : a.NEED_DOWNLOAD;
        } else {
            aVar = a.INSTALLED;
        }
        this.orx = aVar;
        bEO();
        v.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", this.orx.toString());
        switch (this.orx) {
            case NEED_INSTALL:
                this.orv.setText(2131231743);
                return;
            case DOWNLOADING:
                this.orv.setText(2131231741);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                j.a(this.orE);
                return;
            default:
                j.a(this.orE);
                return;
        }
    }

    final void bEQ() {
        if (this.ory == 0) {
            this.orv.setText(2131231750);
        } else if (this.ory > 99) {
            this.orv.setText(2131231749);
        } else {
            this.orv.setText(String.format(com.tencent.mm.bd.a.O(this.mContext, 2131231748), new Object[]{Integer.valueOf(this.ory)}));
        }
    }
}
