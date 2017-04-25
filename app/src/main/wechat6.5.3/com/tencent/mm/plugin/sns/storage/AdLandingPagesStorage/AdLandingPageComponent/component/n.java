package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.lang.ref.WeakReference;

public final class n extends k implements e {
    private RelativeLayout hsA;
    Button jyf;
    SnsTextProgressBar jyg;
    a jyh;
    b jyi;
    private OnClickListener jyj = new OnClickListener(this) {
        final /* synthetic */ n jyk;

        {
            this.jyk = r1;
        }

        public final void onClick(View view) {
            this.jyk.jyh.qr(0);
        }
    };

    private class b extends BroadcastReceiver {
        final /* synthetic */ n jyk;

        private b(n nVar) {
            this.jyk = nVar;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                Object schemeSpecificPart;
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyk.jxU).tX)) {
                        this.jyk.jyh.qr(3);
                    }
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyk.jxU).tX)) {
                        this.jyk.jyh.qr(4);
                    }
                }
            }
        }
    }

    class a extends com.tencent.mm.plugin.sns.h.d {
        final /* synthetic */ n jyk;
        com.tencent.mm.plugin.sns.h.c jyl = new c(this);
        com.tencent.mm.plugin.sns.h.c jym = new g(this);
        com.tencent.mm.plugin.sns.h.c jyn = new e(this);
        com.tencent.mm.plugin.sns.h.c jyo = new h(this);
        com.tencent.mm.plugin.sns.h.c jyp = new i(this);
        com.tencent.mm.plugin.sns.h.c jyq = new f(this);
        com.tencent.mm.plugin.sns.h.c jyr = new b(this);
        com.tencent.mm.plugin.sns.h.c jys = new a(this);
        com.tencent.mm.plugin.sns.h.c jyt = new d(this);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b jyu = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b(this) {
            final /* synthetic */ a jyv;

            {
                this.jyv = r1;
            }

            public final String aTz() {
                return ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).jup;
            }

            public final String aTA() {
                return ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).juo;
            }
        };

        class a extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            a(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                this.jyv.jyk.jyg.setVisibility(8);
                this.jyv.jyk.jyf.setEnabled(false);
                this.jyv.jyk.jyf.setText(!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).jvg) ? ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).jvg : "暂不支持安卓手机");
                this.jyv.jyk.jyf.setVisibility(0);
            }
        }

        class b extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            b(a aVar) {
                this.jyv = aVar;
            }

            public final boolean i(Message message) {
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.jyv.a(this.jyv.jyn);
                        return true;
                    case 5:
                        com.tencent.mm.ui.base.g.bf(this.jyv.jyk.context, "下载失败");
                        this.jyv.a(this.jyv.jyq);
                        return true;
                    case 6:
                        this.jyv.a(this.jyv.jyl);
                        return true;
                    case 10:
                        this.jyv.a(this.jyv.jym);
                        return true;
                    default:
                        return false;
                }
            }

            public final void enter() {
                super.enter();
                ak.vy().a(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.a(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).channelId), 0);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ);
                this.jyv.jyk.jyf.setVisibility(8);
                this.jyv.jyk.jyg.setVisibility(0);
                this.jyv.jyk.jyg.setProgress(0);
                v.i("LogStateTransitionState", "appid %s, channelId %s", new Object[]{((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).channelId});
            }
        }

        class c extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a jyw;

            private class a implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a {
                final /* synthetic */ c jyx;

                private a(c cVar) {
                    this.jyx = cVar;
                }

                public final void qt(int i) {
                    com.tencent.mm.plugin.sns.h.d dVar = this.jyx.jyv.jyk.jyh;
                    c cVar = dVar.jqE;
                    if (cVar != null) {
                        cVar.sendMessage(Message.obtain(dVar.jqE, 1, i, 0));
                    }
                }

                public final void aTw() {
                    v.i("LogStateTransitionState", "paused");
                    this.jyx.jyv.jyk.jyh.qr(7);
                }

                public final void aTx() {
                    this.jyx.jyv.jyk.jyh.qr(9);
                }

                public final void aTy() {
                    this.jyx.jyv.jyk.jyh.qr(8);
                }
            }

            c(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                String str;
                byte b = (byte) 0;
                super.enter();
                this.jyv.jyk.jyf.setVisibility(8);
                this.jyv.jyk.jyg.setVisibility(0);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Be(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                    aVar = c.jvc;
                    if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Ap(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                        if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).downloadUrl)) {
                            this.jyv.a(this.jyv.jyr);
                            return;
                        }
                        aVar = c.jvc;
                        if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bd(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                            this.jyv.jyk.jyg.setProgress(100);
                            this.jyv.a(this.jyv.jyo);
                            return;
                        }
                        aVar = c.jvc;
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ);
                        this.jyw = new a();
                        aVar = c.jvc;
                        String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ;
                        str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX;
                        String str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).aZy;
                        String str4 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).downloadUrl;
                        String str5 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).jvd;
                        boolean z = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).jve;
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar2 = this.jyw;
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b bVar = this.jyv.jyu;
                        com.tencent.mm.pluginsdk.model.downloader.e.a aVar3 = new com.tencent.mm.pluginsdk.model.downloader.e.a();
                        aVar3.setAppId(str2);
                        aVar3.GT(str);
                        aVar3.GS(str3);
                        aVar3.GQ(str4);
                        aVar3.GR(str5);
                        aVar3.hO(z);
                        aVar.juZ.put(Long.valueOf(com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar3.lCn)), new WeakReference(aVar2));
                        aVar.jva.put(str2, new WeakReference(bVar));
                        return;
                    }
                }
                if (this.jyw == null) {
                    this.jyw = new a();
                }
                SnsTextProgressBar snsTextProgressBar = this.jyv.jyk.jyg;
                aVar = c.jvc;
                com.tencent.mm.pluginsdk.model.downloader.f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ);
                snsTextProgressBar.setProgress(GN.beE != 0 ? (int) ((GN.beD * 100) / GN.beE) : 0);
                aVar = c.jvc;
                str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ;
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a aVar4 = this.jyw;
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b bVar2 = this.jyv.jyu;
                com.tencent.mm.pluginsdk.model.downloader.f GN2 = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(str);
                if (GN2 != null) {
                    if (aVar4 != null) {
                        aVar.juZ.put(Long.valueOf(GN2.id), new WeakReference(aVar4));
                    }
                    if (bVar2 != null) {
                        aVar.jva.put(str, new WeakReference(bVar2));
                    }
                    b = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dp(GN2.id);
                }
                if (b == (byte) 0) {
                    aVar = c.jvc;
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bf(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ);
                    this.jyv.a(this.jyv.jyl);
                }
            }

            public final boolean i(Message message) {
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                        com.tencent.mm.pluginsdk.model.downloader.f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ);
                        if (com.tencent.mm.pluginsdk.model.downloader.d.bnK().do(GN != null ? GN.id : Long.MAX_VALUE)) {
                            aVar = c.jvc;
                            if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Be(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                                this.jyv.a(this.jyv.jyn);
                            }
                        }
                        return true;
                    case 1:
                        int i = message.arg1;
                        if (i >= 0) {
                            this.jyv.jyk.jyg.setProgress(i);
                        }
                        return true;
                    case 3:
                        this.jyv.a(this.jyv.jyp);
                        return true;
                    case 7:
                        this.jyv.a(this.jyv.jyn);
                        return true;
                    case 8:
                        com.tencent.mm.ui.base.g.bf(this.jyv.jyk.context, "下载失败");
                        this.jyv.a(this.jyv.jyq);
                        return true;
                    case 9:
                        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).jve) {
                            c.jvc.b(4, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).aZy, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).downloadUrl);
                        }
                        this.jyv.a(this.jyv.jyo);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class d extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            d(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a a = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU);
                Object obj = (a.jvf == 0 || a.jvf == 2) ? 1 : null;
                if (obj != null) {
                    this.jyv.a(this.jyv.jym);
                } else {
                    this.jyv.a(this.jyv.jys);
                }
            }
        }

        class e extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            e(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                this.jyv.jyk.jyg.setVisibility(8);
                this.jyv.jyk.jyf.setVisibility(0);
                this.jyv.jyk.jyf.setText("继续下载");
            }

            public final boolean i(Message message) {
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.jyv.a(this.jyv.jyl);
                        return true;
                    case 3:
                        this.jyv.a(this.jyv.jyp);
                        return true;
                    case 8:
                        com.tencent.mm.ui.base.g.bf(this.jyv.jyk.context, "下载失败");
                        this.jyv.a(this.jyv.jyq);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class f extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            f(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                this.jyv.jyk.jyg.setVisibility(8);
                this.jyv.jyk.jyf.setVisibility(0);
                this.jyv.jyk.jyf.setText("重新下载");
            }

            public final boolean i(Message message) {
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.jyv.a(this.jyv.jyr);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class g extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            g(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                if (this.jyv.jyk.jyi == null) {
                    this.jyv.jyk.jyi = new b();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addDataScheme("package");
                    this.jyv.jyk.context.registerReceiver(this.jyv.jyk.jyi, intentFilter);
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.ar(this.jyv.jyk.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX)) {
                    this.jyv.a(this.jyv.jyp);
                    return;
                }
                aVar = c.jvc;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bd(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                    this.jyv.a(this.jyv.jyo);
                    return;
                }
                aVar = c.jvc;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Ap(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                    this.jyv.a(this.jyv.jyl);
                    return;
                }
                aVar = c.jvc;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Be(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                    this.jyv.a(this.jyv.jyn);
                    return;
                }
                this.jyv.jyk.jyg.setVisibility(8);
                this.jyv.jyk.jyf.setVisibility(0);
                this.jyv.jyk.jyf.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).title);
            }

            public final boolean i(Message message) {
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.jyv.a(this.jyv.jyr);
                        return true;
                    case 3:
                        this.jyv.a(this.jyv.jyp);
                        return true;
                    case 11:
                        this.jyv.a(this.jyv.jym);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class h extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;
            private boolean jyy;

            h(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bd(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                    this.jyv.jyk.jyg.setVisibility(8);
                    this.jyv.jyk.jyf.setVisibility(0);
                    this.jyv.jyk.jyf.setText("安装应用");
                    this.jyy = true;
                    return;
                }
                this.jyv.a(this.jyv.jym);
            }

            public final boolean i(Message message) {
                boolean z = false;
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                        Context context = this.jyv.jyk.context;
                        Object obj = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ;
                        if (!(context == null || TextUtils.isEmpty(obj))) {
                            com.tencent.mm.pluginsdk.model.downloader.f GN = com.tencent.mm.pluginsdk.model.downloader.d.bnK().GN(obj);
                            if (!(GN == null || GN.status != 3 || TextUtils.isEmpty(GN.path))) {
                                Uri fromFile = Uri.fromFile(new File(GN.path));
                                aVar.x(4, GN.id);
                                z = p.c(context, fromFile);
                            }
                        }
                        if (z) {
                            this.jyy = true;
                            return true;
                        }
                        com.tencent.mm.ui.base.g.bf(this.jyv.jyk.context, "安装失败");
                        this.jyv.a(this.jyv.jyq);
                        return true;
                    case 2:
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar2 = c.jvc;
                        if (!com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.Bd(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ)) {
                            this.jyv.a(this.jyv.jym);
                        }
                        return true;
                    case 3:
                        if (this.jyy) {
                            this.jyy = false;
                            c.jvc.b(5, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).bmJ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).aZy, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).downloadUrl);
                        }
                        this.jyv.a(this.jyv.jyp);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class i extends com.tencent.mm.plugin.sns.h.b {
            final /* synthetic */ a jyv;

            i(a aVar) {
                this.jyv = aVar;
            }

            public final void enter() {
                super.enter();
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
                if (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.ar(this.jyv.jyk.context, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jyv.jyk.jxU).tX)) {
                    this.jyv.jyk.jyg.setVisibility(8);
                    this.jyv.jyk.jyf.setVisibility(0);
                    this.jyv.jyk.jyf.setText("打开应用");
                    return;
                }
                this.jyv.a(this.jyv.jyo);
            }

            public final boolean i(Message message) {
                v.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (this.jyv.jyk.aUa()) {
                            return true;
                        }
                        com.tencent.mm.ui.base.g.bf(this.jyv.jyk.context, "打开失败");
                        this.jyv.a(this.jyv.jyp);
                        return true;
                    case 4:
                        this.jyv.a(this.jyv.jym);
                        return true;
                    default:
                        return false;
                }
            }
        }

        protected a(n nVar, String str) {
            this.jyk = nVar;
            super(str, Looper.getMainLooper());
            a(this.jym);
            a(this.jyl);
            a(this.jyn);
            a(this.jyo);
            a(this.jyp);
            a(this.jyq);
            a(this.jyr);
            a(this.jys);
            a(this.jyt);
            c.b(this.jqE, this.jyt);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a aVar = c.jvc;
            String str2 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) nVar.jxU).bmJ;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.b bVar = this.jyu;
            if (str2 != null && str2.length() != 0 && bVar != null) {
                aVar.jva.put(str2, new WeakReference(bVar));
            }
        }
    }

    public n(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar, ViewGroup viewGroup) {
        super(context, aVar, viewGroup);
        ak.vy().a(1210, this);
        this.jyh = new a(this, "apkStateMachine");
    }

    protected final void aTS() {
        this.hsA.setPadding((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).jvK, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).jvI, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).jvL, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).jvJ);
        this.jyf.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).title);
        this.jyh.qr(11);
    }

    @TargetApi(17)
    public final View aTM() {
        this.jya = 0;
        View view = this.dtW;
        this.hsA = (RelativeLayout) view.findViewById(2131755452);
        this.jyf = (Button) view.findViewById(2131756255);
        this.jyf.setOnClickListener(this.jyj);
        this.jyg = (SnsTextProgressBar) view.findViewById(2131759234);
        this.jyg.setProgress(0);
        this.jyg.setVisibility(8);
        this.jyg.setOnClickListener(this.jyj);
        c cVar = this.jyh.jqE;
        if (cVar != null) {
            c.b(cVar);
        }
        return view;
    }

    protected final int aGY() {
        return 2130904417;
    }

    public final void aTO() {
        super.aTO();
        this.jyh.qr(2);
    }

    public final void aTU() {
        super.aTU();
        if (this.jyi != null) {
            this.context.unregisterReceiver(this.jyi);
            this.jyi = null;
        }
        ak.vy().b(1210, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i2 != 0) {
            v.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "net scene fail , errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            this.jyh.qr(5);
            return;
        }
        jm jmVar = (jm) ((com.tencent.mm.v.b) kVar.BD()).czl.czs;
        if (jmVar != null && !TextUtils.isEmpty(jmVar.mlU)) {
            v.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + jmVar.mlU);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", jmVar.mlU);
            intent.putExtra("showShare", true);
            c.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            this.jyh.qr(10);
        } else if (jmVar == null || jmVar.mlT == null) {
            v.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
            this.jyh.qr(5);
        } else {
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).jvd = jmVar.mlT.mlK;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).aZy = jmVar.mlT.mlI;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).downloadUrl = jmVar.mlT.mlJ;
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).fileSize = (long) jmVar.mlT.mlN;
            this.jyh.qr(6);
        }
    }

    public final boolean aUa() {
        if (this.context == null || TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).bmJ) || TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).tX)) {
            return false;
        }
        Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).tX);
        if (launchIntentForPackage == null) {
            return false;
        }
        this.context.startActivity(launchIntentForPackage);
        c.jvc.b(9, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).bmJ, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).tX, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).aZy, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) this.jxU).downloadUrl);
        return true;
    }
}
