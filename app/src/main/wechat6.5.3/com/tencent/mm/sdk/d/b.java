package com.tencent.mm.sdk.d;

import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public abstract class b {
    protected final String fWL = "weixin/android";

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ac evc;
        final /* synthetic */ b nhC;
        final /* synthetic */ c nhD;
        final /* synthetic */ b nhE;

        public AnonymousClass1(b bVar, b bVar2, c cVar, ac acVar) {
            this.nhE = bVar;
            this.nhC = bVar2;
            this.nhD = cVar;
            this.evc = acVar;
        }

        public final void run() {
            this.nhE.a(this.nhC, this.nhD);
            if (this.evc != null) {
                this.evc.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 nhF;

                    {
                        this.nhF = r1;
                    }

                    public final void run() {
                        this.nhF.nhD.onComplete();
                    }
                });
            } else {
                this.nhD.onComplete();
            }
        }
    }

    public static class a {
        public String filePath;
    }

    public static class b {
        public int dMN;
        public String host;
        public int iaI = 0;
        public Map<String, String> iaJ = null;
        public Map<String, String> iaK = null;
        public String nhG;
        public a nhH = null;
        public String uri;

        public final String getUrl() {
            StringBuilder stringBuilder = new StringBuilder();
            if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
                stringBuilder.append(this.nhG + this.host);
            }
            stringBuilder.append(this.uri);
            if (this.iaJ == null) {
                return stringBuilder.toString();
            }
            stringBuilder.append('?');
            Object obj = 1;
            for (String str : this.iaJ.keySet()) {
                stringBuilder.append(obj != null ? "" : "&").append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode(be.ma((String) this.iaJ.get(str)), "utf-8"));
                obj = null;
            }
            return stringBuilder.toString();
        }

        public final String toString() {
            try {
                return getUrl();
            } catch (Throwable e) {
                v.a("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
                return "";
            }
        }
    }

    public static class c {
        public String content;
        public Map<String, String> iaK;
        public a nhH;
        public int status;

        public c(int i, Map<String, String> map, String str) {
            this.status = 0;
            this.status = 0;
            this.iaK = null;
            this.content = str;
        }

        public String toString() {
            return "Response status:" + this.status + ", cookie:" + (this.iaK != null ? this.iaK : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
        }

        public void onComplete() {
        }
    }

    public abstract void a(b bVar, c cVar);

    public static Map<String, String> xZ(String str) {
        Map<String, String> hashMap = new HashMap();
        if (!(str == null || str.length() == 0)) {
            for (String split : str.split(";")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }
}
