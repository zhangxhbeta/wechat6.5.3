package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.r;
import android.util.Log;
import com.google.android.gms.c.au;
import com.google.android.gms.c.av;
import com.google.android.gms.c.be;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.a.AnonymousClass1;
import com.google.android.gms.common.api.u;
import com.google.android.gms.common.api.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.c.d;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.l;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.o;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.sdk.platformtools.aa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class a implements b {
    private c lbS;

    public a() {
        boolean z;
        c cVar = null;
        boolean z2 = true;
        com.google.android.gms.common.api.c.a aVar = new com.google.android.gms.common.api.c.a(aa.getContext());
        com.google.android.gms.common.api.a aVar2 = o.aBK;
        aVar.akK.put(aVar2, null);
        aVar.akE.addAll(aVar2.ja().jc());
        if (aVar.akK.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        w.b(z, "must call addApi() to add at least one API");
        if (aVar.akM >= 0) {
            c oVar = new com.google.android.gms.common.api.o(aVar.mContext.getApplicationContext(), aVar.akP, aVar.jk(), aVar.akQ, aVar.akR, aVar.akK, aVar.akS, aVar.akT, aVar.akM, -1);
            u a = u.a(aVar.akL);
            if (a == null) {
                new Handler(aVar.mContext.getMainLooper()).post(new AnonymousClass1(aVar, oVar));
            } else {
                aVar.a(a, oVar);
            }
            cVar = oVar;
        } else if (aVar.akN >= 0) {
            android.support.v4.app.q.a c = v.c(aVar.akL);
            int i = aVar.akN;
            if (c.aG() != null) {
                a bK = c.bK(i);
                if (bK != null) {
                    cVar = bK.amE;
                }
            }
            if (cVar == null) {
                cVar = new com.google.android.gms.common.api.o(aVar.mContext.getApplicationContext(), aVar.akP, aVar.jk(), aVar.akQ, aVar.akR, aVar.akK, aVar.akS, aVar.akT, -1, aVar.akN);
            }
            i = aVar.akN;
            c.c cVar2 = aVar.akO;
            w.h(cVar, "GoogleApiClient instance cannot be null");
            if (c.amC.indexOfKey(i) >= 0) {
                z2 = false;
            }
            w.a(z2, "Already managing a GoogleApiClient with id " + i);
            c.amC.put(i, new b(cVar, cVar2));
            if (c.aG() != null) {
                r.DEBUG = false;
                c.aJ().a(i, c);
            }
        } else {
            cVar = new com.google.android.gms.common.api.o(aVar.mContext, aVar.akP, aVar.jk(), aVar.akQ, aVar.akR, aVar.akK, aVar.akS, aVar.akT, -1, -1);
        }
        this.lbS = cVar;
    }

    public final boolean isAvailable() {
        return h.bhP() || h.bhO();
    }

    private c bhR() {
        if (!this.lbS.isConnected()) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Wear.GlobalConnection", "connect to google api client");
            if (!this.lbS.a(TimeUnit.SECONDS).iY()) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.Wear.GlobalConnection", "google api client connect error, code=%d, ", Integer.valueOf(this.lbS.a(TimeUnit.SECONDS).akn));
            }
        }
        return this.lbS;
    }

    public final byte[] a(Asset asset) {
        d dVar = (d) o.aEf.a(bhR(), asset).jn();
        if (dVar.jo().iY()) {
            return b.d(dVar.getInputStream());
        }
        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.Wear.GlobalConnection", "read asset data not success errorCode=%d | errorMsg=%s", Integer.valueOf(dVar.jo().akn), dVar.jo().alf);
        return null;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a r(String str, byte[] bArr) {
        HashSet bhS = bhS();
        com.tencent.mm.plugin.wear.model.a.b.a aVar = new com.tencent.mm.plugin.wear.model.a.b.a();
        Iterator it = bhS.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wear.model.a.b.a aVar2;
            String str2 = (String) it.next();
            if (bhR().isConnected()) {
                com.tencent.mm.plugin.wear.model.a.b.a aVar3 = new com.tencent.mm.plugin.wear.model.a.b.a();
                Status jo = ((j.b) o.aEh.a(bhR(), str2, str, bArr).b(TimeUnit.SECONDS)).jo();
                if (!jo.iY()) {
                    aVar3.aJW = 131072;
                    aVar3.biS = jo.alf;
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.Wear.GlobalConnection", "send message not success errorCode=%d | errorMsg=%s", Integer.valueOf(jo.akn), jo.alf);
                }
                String str3 = "MicroMsg.Wear.GlobalConnection";
                String str4 = "send Message %s %s %d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                objArr[1] = str;
                objArr[2] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                com.tencent.mm.sdk.platformtools.v.d(str3, str4, objArr);
                aVar2 = aVar3;
            } else {
                aVar2 = new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
            }
            if (aVar2.aJW != 0) {
                return aVar2;
            }
        }
        return aVar;
    }

    public final HashSet<String> bhS() {
        HashSet<String> hashSet = new HashSet();
        com.google.android.gms.wearable.m.a aVar = (com.google.android.gms.wearable.m.a) o.aEi.a(bhR()).jn();
        if (aVar != null) {
            for (l id : aVar.mA()) {
                hashSet.add(id.getId());
            }
        }
        return hashSet;
    }

    public final com.tencent.mm.plugin.wear.model.a.b.a s(String str, byte[] bArr) {
        if (!bhR().isConnected()) {
            return new com.tencent.mm.plugin.wear.model.a.b.a((byte) 0);
        }
        n nVar = new n(PutDataRequest.at(str));
        nVar.aEb.putLong("key_timestamp", System.currentTimeMillis());
        nVar.aEb.a("key_data", Asset.h(bArr));
        com.google.android.gms.wearable.h hVar = nVar.aEb;
        av avVar = new av();
        List arrayList = new ArrayList();
        avVar.aAh = au.a(hVar, arrayList);
        com.google.android.gms.c.au.a aVar = new com.google.android.gms.c.au.a(avVar, arrayList);
        nVar.aEc.aDR = be.c(aVar.aAf);
        int size = aVar.aAg.size();
        int i = 0;
        while (i < size) {
            String num = Integer.toString(i);
            Asset asset = (Asset) aVar.aAg.get(i);
            if (num == null) {
                throw new IllegalStateException("asset key cannot be null: " + asset);
            } else if (asset == null) {
                throw new IllegalStateException("asset cannot be null: key=" + num);
            } else {
                if (Log.isLoggable("DataMap", 3)) {
                    new StringBuilder("asPutDataRequest: adding asset: ").append(num).append(" ").append(asset);
                }
                nVar.aEc.b(num, asset);
                i++;
            }
        }
        o.aEf.a(bhR(), nVar.aEc);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.Wear.GlobalConnection", "send data request path=%s | length=%d", r0.mUri.getPath(), Integer.valueOf(r0.aDR.length));
        return new com.tencent.mm.plugin.wear.model.a.b.a();
    }

    public final boolean g(Uri uri) {
        o.aEf.a(bhR(), uri);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.Wear.GlobalConnection", "delete data item %s", uri);
        return true;
    }

    public final boolean bhT() {
        if (bhR().isConnected() && bhS().size() != 0) {
            return true;
        }
        return false;
    }

    public final void finish() {
        this.lbS.disconnect();
    }
}
