package com.tencent.mm.plugin.wear.model.service;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.i;
import com.google.android.gms.wearable.k;
import com.google.android.gms.wearable.l;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.wear.a.b;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.sdk.platformtools.v;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author = 100, fComment = "checked", lastDate = "20141125", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class WearDataLayerService extends WearableListenerService {
    public void onCreate() {
        super.onCreate();
        v.i("MicroMsg.Wear.WearDataLayerService", "onCreate");
    }

    public void onDestroy() {
        v.i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
        super.onDestroy();
    }

    public final void a(e eVar) {
        v.d("MicroMsg.Wear.WearDataLayerService", "onDataChanged");
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.getType() == 1) {
                Uri uri = dVar.mx().getUri();
                if (b.DP(uri.getPath())) {
                    f mx = dVar.mx();
                    if (mx == null) {
                        throw new IllegalStateException("provided dataItem is null");
                    }
                    Asset as = new i(mx).aEb.as("key_data");
                    if (as != null) {
                        try {
                            v.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(new a().a(as).length));
                            com.tencent.mm.plugin.wear.model.b.a.A(aQ(r0));
                        } catch (Throwable e) {
                            v.a("MicroMsg.Wear.WearDataLayerService", e, "decode data error", new Object[0]);
                        }
                    }
                    new a().g(uri);
                } else {
                    continue;
                }
            }
        }
        eVar.release();
    }

    private static Bundle aQ(byte[] bArr) {
        Bundle bundle = new Bundle();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        bundle.putInt("key_connecttype", dataInputStream.readInt());
        bundle.putInt("key_sessionid", dataInputStream.readInt());
        bundle.putInt("key_funid", dataInputStream.readInt());
        int readInt = dataInputStream.readInt();
        if (readInt > 0 && readInt < bArr.length) {
            byte[] bArr2 = new byte[readInt];
            dataInputStream.readFully(bArr2);
            bundle.putByteArray("key_data", bArr2);
        } else if (readInt >= bArr.length) {
            throw new IOException("contentLength too large " + readInt);
        }
        v.i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(readInt));
        return bundle;
    }

    public final void a(k kVar) {
        v.d("MicroMsg.Wear.WearDataLayerService", "onMessageReceived");
        if (b.DP(kVar.getPath())) {
            try {
                v.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(kVar.getData().length));
                com.tencent.mm.plugin.wear.model.b.a.A(aQ(r0));
            } catch (Throwable e) {
                v.a("MicroMsg.Wear.WearDataLayerService", e, "decode message error", new Object[0]);
            }
        }
    }

    public final void a(l lVar) {
        v.d("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", lVar.getId());
    }

    public final void b(l lVar) {
        v.d("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", lVar.getId());
    }
}
