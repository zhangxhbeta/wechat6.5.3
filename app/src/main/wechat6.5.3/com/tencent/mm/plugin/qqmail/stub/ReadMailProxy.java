package com.tencent.mm.plugin.qqmail.stub;

import android.os.Bundle;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.qqmail.b.q;
import com.tencent.mm.plugin.qqmail.b.x;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.b;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.downloader.l;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class ReadMailProxy extends a {
    private q.a ibC;
    private q.a icp;
    private b icq;
    private c icr;
    private l ics = new l(this) {
        final /* synthetic */ ReadMailProxy icu;

        {
            this.icu = r1;
        }

        public final void onTaskStarted(long j, String str) {
            this.icu.CLIENT_CALL("onTaskStarted", Long.valueOf(j), str);
        }

        public final void onTaskRemoved(long j) {
            this.icu.CLIENT_CALL("onTaskRemoved", Long.valueOf(j));
        }

        public final void g(long j, String str) {
            this.icu.CLIENT_CALL("onTaskFinished", Long.valueOf(j));
        }

        public final void q(long j, int i) {
            this.icu.CLIENT_CALL("onTaskFailed", Long.valueOf(j));
        }

        public final void onTaskPaused(long j) {
            this.icu.CLIENT_CALL("onTaskPaused", Long.valueOf(j));
        }

        public final void bV(long j) {
        }

        public final void bW(long j) {
        }
    };
    private j.a ict = new j.a(this) {
        final /* synthetic */ ReadMailProxy icu;

        {
            this.icu = r1;
        }

        public final void hm(int i) {
            this.icu.CLIENT_CALL("onGetQQMailUnreadSuccess", Integer.valueOf(i));
        }

        public final void aHL() {
            this.icu.CLIENT_CALL("onGetQQMailUnreadFailed", new Object[0]);
        }
    };

    public ReadMailProxy(d dVar, q.a aVar) {
        super(dVar);
        this.ibC = aVar;
        this.icp = new q.a(this) {
            final /* synthetic */ ReadMailProxy icu;

            {
                this.icu = r1;
            }

            public final boolean onReady() {
                return ((Boolean) this.icu.CLIENT_CALL("onReady", new Object[0])).booleanValue();
            }

            public final void onSuccess(String str, Map<String, String> map) {
                this.icu.CLIENT_CALL("onSuccess", str, map);
            }

            public final void onError(int i, String str) {
                this.icu.CLIENT_CALL("onError", Integer.valueOf(i), str);
            }

            public final void onComplete() {
                this.icu.CLIENT_CALL("onComplete", new Object[0]);
            }
        };
    }

    public ReadMailProxy(d dVar, q.a aVar, b bVar, c cVar) {
        super(dVar);
        this.ibC = aVar;
        this.icq = bVar;
        this.icr = cVar;
        this.icp = new q.a(this) {
            final /* synthetic */ ReadMailProxy icu;

            {
                this.icu = r1;
            }

            public final boolean onReady() {
                return ((Boolean) this.icu.CLIENT_CALL("onReady", new Object[0])).booleanValue();
            }

            public final void onSuccess(String str, Map<String, String> map) {
                this.icu.CLIENT_CALL("onSuccess", str, map);
            }

            public final void onError(int i, String str) {
                this.icu.CLIENT_CALL("onError", Integer.valueOf(i), str);
            }

            public final void onComplete() {
                this.icu.CLIENT_CALL("onComplete", new Object[0]);
            }
        };
    }

    @e
    public boolean onReady() {
        if (this.ibC == null) {
            return true;
        }
        return this.ibC.onReady();
    }

    @e
    public void onSuccess(String str, Map<String, String> map) {
        if (this.ibC != null) {
            this.ibC.onSuccess(str, map);
        }
    }

    @e
    public void onError(int i, String str) {
        if (this.ibC != null) {
            this.ibC.onError(i, str);
        }
    }

    @e
    public void onComplete() {
        if (this.ibC != null) {
            this.ibC.onComplete();
        }
    }

    @e
    public void onTaskStarted(long j, String str) {
        if (this.icq != null) {
            b bVar = this.icq;
            v.d("MicroMsg.ReadMailUI", "onTaskStarted id:%d, saveFilePath:%s", new Object[]{Long.valueOf(j), str});
            bVar.igZ.cnm = aa.getContext().getSharedPreferences("QQMAIL", 4);
            if (bVar.igZ.cnm != null) {
                bVar.igZ.cnm.edit().putString("qqmail_downloadpath", str).commit();
            }
        }
    }

    @e
    public void onTaskRemoved(long j) {
        if (this.icq != null) {
            v.d("MicroMsg.ReadMailUI", "onTaskRemoved id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskPaused(long j) {
        if (this.icq != null) {
            v.d("MicroMsg.ReadMailUI", "onTaskPaused id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFinished(long j) {
        if (this.icq != null) {
            v.d("MicroMsg.ReadMailUI", "onTaskFinished id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @e
    public void onTaskFailed(long j) {
        if (this.icq != null) {
            v.d("MicroMsg.ReadMailUI", "onTaskFailed id:%d", new Object[]{Long.valueOf(j)});
        }
    }

    @f
    public long get(String str, Map map, Bundle bundle) {
        boolean uP = ak.uP();
        v.d("MicroMsg.ReadMailProxy", "get, needSetUin = " + uP);
        final q.c cVar = new q.c();
        cVar.u(bundle);
        if (!uP) {
            return x.aHG().b(str, map, cVar, this.icp);
        }
        final String str2 = str;
        final Map map2 = map;
        return ((Long) new az<Long>(this, Long.valueOf(0)) {
            final /* synthetic */ ReadMailProxy icu;

            protected final /* synthetic */ Object run() {
                return Long.valueOf(x.aHG().b(str2, map2, cVar, this.icu.icp));
            }
        }.c(new ac())).longValue();
    }

    @f
    public long post(String str, Map map, Bundle bundle) {
        boolean uP = ak.uP();
        v.d("MicroMsg.ReadMailProxy", "post, needSetUin = " + uP);
        final q.c cVar = new q.c();
        cVar.u(bundle);
        if (!uP) {
            return x.aHG().a(str, map, cVar, this.icp);
        }
        final String str2 = str;
        final Map map2 = map;
        return ((Long) new az<Long>(this, Long.valueOf(0)) {
            final /* synthetic */ ReadMailProxy icu;

            protected final /* synthetic */ Object run() {
                return Long.valueOf(x.aHG().a(str2, map2, cVar, this.icu.icp));
            }
        }.c(new ac())).longValue();
    }

    @f
    public void cancel(final long j) {
        new ac().post(new Runnable(this) {
            final /* synthetic */ ReadMailProxy icu;

            public final void run() {
                x.aHG().cancel(j);
            }
        });
    }

    @f
    public boolean isSDCardAvailable() {
        boolean uM = ak.uM();
        v.d("MicroMsg.ReadMailProxy", "isSDCardAvailable, needSetUin = " + uM);
        if (uM) {
            return ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                final /* synthetic */ ReadMailProxy icu;

                protected final /* synthetic */ Object run() {
                    ak.yW();
                    return Boolean.valueOf(com.tencent.mm.model.c.isSDCardAvailable());
                }
            }.c(new ac())).booleanValue();
        }
        ak.yW();
        return com.tencent.mm.model.c.isSDCardAvailable();
    }

    @f
    public String getMsgContent(final long j) {
        boolean uM = ak.uM();
        v.d("MicroMsg.ReadMailProxy", "getMsgContent, needSetUin = " + uM);
        if (uM) {
            return (String) new az<String>(this) {
                final /* synthetic */ ReadMailProxy icu;

                protected final /* synthetic */ Object run() {
                    ak.yW();
                    return com.tencent.mm.model.c.wJ().ek(j).field_content;
                }
            }.c(new ac());
        }
        ak.yW();
        return com.tencent.mm.model.c.wJ().ek(j).field_content;
    }

    @f
    public void replaceMsgContent(final long j, final String str) {
        new ac().post(new Runnable(this) {
            final /* synthetic */ ReadMailProxy icu;

            public final void run() {
                ak.yW();
                at ek = com.tencent.mm.model.c.wJ().ek(j);
                ek.setContent(ek.field_content.replaceFirst("<digest>.*</digest>", "<digest>" + str + "</digest>"));
                ak.yW();
                com.tencent.mm.model.c.wJ().a(j, ek);
            }
        });
    }

    @f
    public Map getCookie() {
        boolean uM = ak.uM();
        v.d("MicroMsg.ReadMailProxy", "getCookie, needSetUin = " + uM);
        if (uM) {
            return (Map) new az<Map>(this) {
                final /* synthetic */ ReadMailProxy icu;

                {
                    this.icu = r4;
                }

                protected final /* synthetic */ Object run() {
                    return x.aHG().getCookie();
                }
            }.c(new ac());
        }
        return x.aHG().getCookie();
    }

    @f
    public void deleteMsgById(long j) {
        ak.yW();
        com.tencent.mm.model.c.wJ().em(j);
    }

    @f
    public String getUserBindEmail() {
        boolean uM = ak.uM();
        v.d("MicroMsg.ReadMailProxy", "getUserBindEmail, needSetUin = " + uM);
        if (uM) {
            return (String) new az<String>(this) {
                final /* synthetic */ ReadMailProxy icu;

                {
                    this.icu = r4;
                }

                protected final /* synthetic */ Object run() {
                    return k.getUserBindEmail();
                }
            }.c(new ac());
        }
        return k.getUserBindEmail();
    }

    @f
    public void addDownloadCallback() {
        com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.c(this.ics);
    }

    @f
    public void removeDownloadCallback() {
        com.tencent.mm.pluginsdk.model.downloader.d.bnK();
        com.tencent.mm.pluginsdk.model.downloader.a.bnH();
    }

    @f
    public long downloadQQMailApp(String str, String str2) {
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            com.tencent.mm.pluginsdk.model.downloader.e.a aVar = new com.tencent.mm.pluginsdk.model.downloader.e.a();
            aVar.GQ(toURL.toString());
            aVar.GR("qqmail.apk");
            aVar.GS(str2);
            aVar.hO(true);
            aVar.tE(1);
            return com.tencent.mm.pluginsdk.model.downloader.d.bnK().a(aVar.lCn);
        } catch (Throwable e) {
            v.e("MicroMsg.ReadMailProxy", "dz[download qq mail error:%s]", new Object[]{e.toString()});
            v.a("MicroMsg.ReadMailProxy", e, "", new Object[0]);
            return -1;
        }
    }

    @f
    public int removeDownloadQQMailAppTask(long j) {
        return com.tencent.mm.pluginsdk.model.downloader.d.bnK().dm(j);
    }

    @f
    public String getBindUin() {
        ak.yW();
        return new o(be.f((Integer) com.tencent.mm.model.c.vf().get(9, null))).toString();
    }

    @f
    public Integer showMailAppRecommend() {
        if (com.tencent.mm.sdk.platformtools.f.aPW == 1) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(be.getInt(com.tencent.mm.h.j.sV().z("MailApp", "ShowMailAppRecommend"), 0));
    }

    @f
    public String getMailAppEnterUlAndroid() {
        return com.tencent.mm.h.j.sV().getMailAppEnterUlAndroid();
    }

    @f
    public String getMailAppRedirectUrlAndroid() {
        return com.tencent.mm.h.j.sV().sS();
    }

    @f
    public Integer getMailAppDownloadStatus(long j) {
        return Integer.valueOf(com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(j).status);
    }

    @f
    public double getMailAppDownloadProgress(long j) {
        com.tencent.mm.pluginsdk.model.downloader.f dn = com.tencent.mm.pluginsdk.model.downloader.d.bnK().dn(j);
        if (dn.beE <= 0) {
            return 0.0d;
        }
        return (1.0d * ((double) dn.beD)) / ((double) dn.beE);
    }

    @f
    public void reportKvState(int i, int i2) {
        g.iuh.h(i, new Object[]{Integer.valueOf(i2)});
    }

    @f
    public void reportKvStates(int i, int i2, int i3) {
        g.iuh.h(i, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    @f
    public void getUnreadMailCount() {
        j.a(this.ict);
    }

    @f
    public Object getUneradMailCountFromConfig() {
        ak.yW();
        return com.tencent.mm.model.c.vf().get(t.a.npq, Integer.valueOf(-1));
    }
}
