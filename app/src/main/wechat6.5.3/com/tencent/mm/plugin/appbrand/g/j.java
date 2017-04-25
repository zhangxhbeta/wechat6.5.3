package com.tencent.mm.plugin.appbrand.g;

import com.tencent.mm.plugin.appbrand.l.d.d;
import com.tencent.mm.plugin.appbrand.l.f.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;

public final class j {
    public static ah dMH = null;
    public com.tencent.mm.plugin.appbrand.l.a.a dMG;

    class AnonymousClass2 implements com.tencent.mm.sdk.platformtools.ah.a {
        final /* synthetic */ a dMI;
        final /* synthetic */ j dMJ;

        public AnonymousClass2(j jVar, a aVar) {
            this.dMJ = jVar;
            this.dMI = aVar;
        }

        public final boolean oU() {
            v.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            this.dMI.nw("connect response time out");
            this.dMJ.dMG.close();
            return false;
        }
    }

    class AnonymousClass3 implements com.tencent.mm.sdk.platformtools.ah.a {
        final /* synthetic */ a dMI;
        final /* synthetic */ j dMJ;

        public AnonymousClass3(j jVar, a aVar) {
            this.dMJ = jVar;
            this.dMI = aVar;
        }

        public final boolean oU() {
            v.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            this.dMI.nw("connect response time out");
            this.dMJ.dMG.close();
            return false;
        }
    }

    public interface a {
        void Qa();

        void Qb();

        void Qc();

        void a(ByteBuffer byteBuffer);

        void nw(String str);

        void nx(String str);

        void ny(String str);
    }

    class AnonymousClass1 extends com.tencent.mm.plugin.appbrand.l.a.a {
        final /* synthetic */ a dMI;
        final /* synthetic */ j dMJ;
        private d fVr = null;
        final /* synthetic */ String val$url;

        public AnonymousClass1(j jVar, URI uri, com.tencent.mm.plugin.appbrand.l.b.a aVar, Map map, int i, String str, a aVar2) {
            this.dMJ = jVar;
            this.val$url = str;
            this.dMI = aVar2;
            super(uri, aVar, map, i);
        }

        public final void QT() {
            v.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened", new Object[]{this.val$url});
            j.QI();
            this.dMI.Qa();
        }

        public final void nQ(String str) {
            String str2 = "MicroMsg.AppBrandNetworkWebSocket";
            String str3 = "url is %s ,socket onmessage length :%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.val$url;
            objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
            v.i(str2, str3, objArr);
            this.dMI.nx(str);
        }

        public final void z(int i, String str) {
            v.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d", new Object[]{this.val$url, str, Integer.valueOf(i)});
            j.QI();
            if (i == -1 || i == -2 || i == -3) {
                this.dMI.nw(str);
            } else {
                this.dMI.Qb();
            }
        }

        public final void c(Exception exception) {
            v.e("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,error is %s", new Object[]{this.val$url, exception.toString()});
            this.dMI.nw("exception " + exception.getMessage());
        }

        public final void b(ByteBuffer byteBuffer) {
            String str = "MicroMsg.AppBrandNetworkWebSocket";
            String str2 = "url is %s , socket onMessage buffer length : %d";
            Object[] objArr = new Object[2];
            objArr[0] = this.val$url;
            objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.position() : -1);
            v.i(str, str2, objArr);
            this.dMI.a(byteBuffer);
        }

        public final void c(d dVar) {
            if (dVar.SC() != com.tencent.mm.plugin.appbrand.l.d.d.a.CONTINUOUS && !dVar.SA()) {
                this.fVr = dVar;
            } else if (dVar.SC() == com.tencent.mm.plugin.appbrand.l.d.d.a.CONTINUOUS && this.fVr != null) {
                if (this.fVr.Sz().position() > 10485760) {
                    v.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                    this.fVr = null;
                    return;
                }
                try {
                    this.fVr.e(dVar);
                } catch (Exception e) {
                    v.e("MicroMsg.AppBrandNetworkWebSocket", e.getMessage());
                }
                if (dVar.SA()) {
                    if (this.fVr.SC() == com.tencent.mm.plugin.appbrand.l.d.d.a.BINARY) {
                        b(this.fVr.Sz());
                    } else if (this.fVr.SC() == com.tencent.mm.plugin.appbrand.l.d.d.a.TEXT) {
                        try {
                            nQ(be.ma(b.n(this.fVr.Sz())));
                        } catch (Exception e2) {
                            v.e("MicroMsg.AppBrandNetworkWebSocket", e2.getMessage());
                        }
                    }
                    this.fVr = null;
                }
            }
        }
    }

    public final void QS() {
        if (this.dMG != null) {
            try {
                v.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                this.dMG.close();
            } catch (Exception e) {
                v.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
            }
        }
    }

    public static void QI() {
        v.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
        if (dMH != null) {
            dMH.QI();
        }
        dMH = null;
    }
}
