package com.tencent.mm.plugin.qqmail.b;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class q {
    private static SparseArray<String> ibp = null;
    private Map<String, String> iaK = new HashMap();
    public j ibk;
    public c ibl;
    private e ibm;
    private Map<Long, d> ibn = new HashMap();
    private Map<Long, b> ibo = new HashMap();

    public static abstract class a {
        public abstract void onError(int i, String str);

        public abstract void onSuccess(String str, Map<String, String> map);

        public boolean onReady() {
            return true;
        }

        public void onProgress(int i) {
        }

        public void onComplete() {
        }
    }

    public static class c {
        public boolean ibv = false;
        public boolean ibw = true;
        public boolean ibx = true;

        public final void t(Bundle bundle) {
            bundle.putBoolean("qqmail_httpoptions_expired", this.ibv);
            bundle.putBoolean("qqmail_httpoptions_needcache", this.ibw);
            bundle.putBoolean("qqmail_httpoptions_needparse", this.ibx);
        }

        public final void u(Bundle bundle) {
            this.ibv = bundle.getBoolean("qqmail_httpoptions_expired");
            this.ibw = bundle.getBoolean("qqmail_httpoptions_needcache");
            this.ibx = bundle.getBoolean("qqmail_httpoptions_needparse");
        }
    }

    private class d {
        com.tencent.mm.plugin.qqmail.b.h.c ibA;
        Map<String, String> ibB;
        a ibC;
        final /* synthetic */ q ibr;
        c iby;
        com.tencent.mm.plugin.qqmail.b.h.b ibz;
        long id = System.currentTimeMillis();
        String uri;

        public d(q qVar, String str, com.tencent.mm.plugin.qqmail.b.h.b bVar, a aVar) {
            this.ibr = qVar;
            this.uri = str;
            this.ibz = bVar;
            this.ibC = aVar;
        }
    }

    private class b extends AsyncTask<d, Integer, d> implements com.tencent.mm.plugin.qqmail.b.h.a {
        final /* synthetic */ q ibr;
        private h ibs;
        d ibt;

        private b(q qVar) {
            this.ibr = qVar;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            d dVar = ((d[]) objArr)[0];
            if (!be.kS((String) dVar.ibz.iaK.get("skey"))) {
                if (!dVar.iby.ibv && dVar.iby.ibw) {
                    byte[] f = this.ibr.ibm.f(dVar.uri, dVar.ibz.iaJ);
                    String str = f == null ? null : new String(f);
                    if (str != null) {
                        dVar.ibA = new com.tencent.mm.plugin.qqmail.b.h.c(304, null, str);
                        if (dVar.iby.ibx || !(dVar.ibA.status == 304 || dVar.ibA.status == 200)) {
                            v.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.ibA.status)});
                        } else {
                            dVar.ibB = bf.q(dVar.ibA.content, "Response");
                        }
                    }
                }
                if (dVar.ibz.iaL != null) {
                    this.ibs = new f();
                } else {
                    this.ibs = new g();
                }
                dVar.ibA = this.ibs.a("https://", dVar.uri, dVar.ibz, this);
                if (dVar.ibA == null) {
                    return null;
                }
                if (dVar.iby.ibx) {
                }
                v.e("MicroMsg.NormalMailAppService", "http error, %d", new Object[]{Integer.valueOf(dVar.ibA.status)});
            }
            return dVar;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            d dVar = (d) obj;
            if (dVar != null) {
                if (be.kS((String) dVar.ibz.iaK.get("skey"))) {
                    dVar.ibC.onError(-5, "");
                } else if (dVar.ibA.status == 304) {
                    q.a(this.ibr, dVar);
                } else if (dVar.ibA.status == 200) {
                    q.a(this.ibr, dVar.ibA.iaK);
                    if (q.a(this.ibr, dVar) == 0 && dVar.iby.ibw) {
                        this.ibr.ibm.a(dVar.uri, dVar.ibz.iaJ, dVar.ibA.content.getBytes());
                    }
                } else {
                    dVar.ibC.onError(dVar.ibA.status, q.ow(dVar.ibA.status));
                }
                dVar.ibC.onComplete();
                this.ibr.ibn.remove(Long.valueOf(dVar.id));
                this.ibr.ibo.remove(Long.valueOf(dVar.id));
            }
        }

        protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
            this.ibt.ibC.onProgress(((Integer[]) objArr)[0].intValue());
        }

        public final boolean a(d dVar) {
            if (!dVar.ibC.onReady()) {
                return false;
            }
            this.ibt = dVar;
            super.execute(new d[]{dVar});
            return true;
        }

        public final void aHu() {
            publishProgress(new Integer[]{Integer.valueOf(0)});
        }

        protected final void onCancelled() {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ b ibu;

                {
                    this.ibu = r1;
                }

                public final void run() {
                    if (this.ibu.ibs != null) {
                        this.ibu.ibs.cancel();
                    }
                }

                public final String toString() {
                    return super.toString() + "|onCancelled";
                }
            });
            super.onCancelled();
        }
    }

    static /* synthetic */ int a(q qVar, d dVar) {
        if (dVar.iby.ibx) {
            com.tencent.mm.plugin.qqmail.b.h.c cVar = dVar.ibA;
            if (dVar.ibB == null) {
                dVar.ibC.onError(-1002, "format error");
                return -1002;
            }
            int i = be.getInt((String) dVar.ibB.get(".Response.error.code"), 0);
            if (i == 0) {
                dVar.ibC.onSuccess(cVar.content, dVar.ibB);
                return 0;
            }
            dVar.ibC.onError(i, W(i, (String) dVar.ibB.get(".Response.error.message")));
            return i;
        }
        dVar.ibC.onSuccess(dVar.ibA.content, null);
        return 0;
    }

    static /* synthetic */ void a(q qVar, Map map) {
        if (qVar.iaK != null && map != null) {
            for (String str : map.keySet()) {
                qVar.iaK.put(str, map.get(str));
            }
        }
    }

    public q(int i, String str) {
        h.setHost("qqmail.weixin.qq.com:443");
        h.setUserAgent("weixin/" + str + "/0x" + Integer.toHexString(i));
        reset();
    }

    public final long a(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 1, map, null, cVar, aVar);
    }

    public final long b(String str, Map<String, String> map, c cVar, a aVar) {
        return a(str, 0, map, null, cVar, aVar);
    }

    public static String aHA() {
        return "https://qqmail.weixin.qq.com:443";
    }

    public final long a(String str, int i, Map<String, String> map, com.tencent.mm.plugin.qqmail.b.h.d dVar, c cVar, a aVar) {
        if (map == null) {
            map = new HashMap();
        }
        map.put("appname", "qqmail_weixin");
        map.put("f", "xml");
        map.put("charset", ProtocolPackage.ServerEncoding);
        map.put("clientip", getLocalIp());
        final d dVar2 = new d(this, str, new com.tencent.mm.plugin.qqmail.b.h.b(i, map, getCookie(), dVar), aVar);
        dVar2.iby = cVar;
        ad.o(new Runnable(this) {
            final /* synthetic */ q ibr;

            public final void run() {
                b bVar = new b();
                this.ibr.ibn.put(Long.valueOf(dVar2.id), dVar2);
                this.ibr.ibo.put(Long.valueOf(dVar2.id), bVar);
                bVar.a(dVar2);
            }
        });
        return dVar2.id;
    }

    public final void cancel(long j) {
        b bVar = (b) this.ibo.get(Long.valueOf(j));
        if (bVar != null) {
            bVar.onCancelled();
            bVar.cancel(true);
        }
        this.ibo.remove(Long.valueOf(j));
        this.ibn.remove(Long.valueOf(j));
    }

    public final void reset() {
        h.xY(aHB());
        for (b cancel : this.ibo.values()) {
            cancel.cancel(true);
        }
        this.ibo.clear();
        this.ibn.clear();
        this.iaK.clear();
        ak.yW();
        String wZ = com.tencent.mm.model.c.wZ();
        this.ibk = new j(wZ + "addr/");
        this.ibl = new c(wZ + "draft/");
        this.ibm = new e(wZ + "http/", 0);
    }

    public static String aHB() {
        String str = e.cge;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    private static String getLocalIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
        }
        return null;
    }

    public final Map<String, String> getCookie() {
        Object obj;
        ak.yW();
        String str = (String) com.tencent.mm.model.c.vf().get(-1535680990, null);
        Map map = this.iaK;
        String str2 = "skey";
        if (str == null) {
            obj = "";
        } else {
            String str3 = str;
        }
        map.put(str2, obj);
        ak.yW();
        this.iaK.put(OpenSDKTool4Assistant.EXTRA_UIN, "o" + new o(be.n(com.tencent.mm.model.c.vf().get(9, null), 0)));
        v.d("MicroMsg.NormalMailAppService", "sKey:%b, uin:%d", new Object[]{Boolean.valueOf(be.kS(str)), Integer.valueOf(r1)});
        return this.iaK;
    }

    private static String ow(int i) {
        if (ibp == null) {
            ibp = new SparseArray();
            for (Field field : HttpURLConnection.class.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (name != null && name.startsWith("HTTP_") && Modifier.isPublic(modifiers) && Modifier.isFinal(modifiers) && Modifier.isStatic(modifiers)) {
                    try {
                        modifiers = field.getInt(Integer.valueOf(0));
                        StringBuilder stringBuilder = new StringBuilder();
                        String[] split = name.split("_");
                        if (split != null) {
                            for (int i2 = 1; i2 < split.length; i2++) {
                                stringBuilder.append(split[i2]).append(' ');
                            }
                            stringBuilder.append("error");
                        }
                        ibp.put(modifiers, stringBuilder.toString().toLowerCase());
                    } catch (Exception e) {
                    }
                }
            }
        }
        String str = (String) ibp.get(i);
        return str == null ? W(i, "request error") : str;
    }

    private static String W(int i, String str) {
        int i2 = 0;
        switch (i) {
            case -105:
            case -6:
                i2 = 2131234226;
                break;
            case -104:
                i2 = 2131234224;
                break;
            case -103:
                i2 = 2131234223;
                break;
            case -102:
                i2 = 2131234222;
                break;
            case -7:
                i2 = 2131234227;
                break;
            case -4:
            case -3:
                i2 = 2131234225;
                break;
            case -1:
                i2 = 2131234220;
                break;
        }
        if (i2 == 0) {
            return str;
        }
        return com.tencent.mm.bd.a.O(aa.getContext(), i2);
    }
}
