package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.v;

public final class c implements d {
    private NfcA hIf;

    public c(Tag tag) {
        this.hIf = NfcA.get(tag);
    }

    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        if (this.hIf == null) {
            v.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            throw new IllegalStateException("NfcA is null");
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.hIf.transceive(aVar.getBytes()));
            if (cVar2.hHO.length == 0) {
                return cVar;
            }
            if (cVar2.hHO.length - 2 < 0) {
                return cVar2;
            }
            if (cVar2.aDS() == (short) 108) {
                aVar.nE(cVar2.aDT());
            } else {
                if (cVar == null) {
                    cVar = cVar2;
                } else {
                    cVar.a(cVar2);
                }
                if (cVar2.aDS() != (short) 97) {
                    return cVar;
                }
                if (cVar2.aDT() != (short) 0) {
                    aVar = new a((byte[]) b.hHW.clone());
                } else {
                    cVar.hHO[cVar.hHO.length - 1] = (byte) -112;
                    return cVar;
                }
            }
        }
    }

    public final boolean connect() {
        if (!this.hIf.isConnected()) {
            this.hIf.connect();
        }
        return true;
    }

    public final void close() {
        if (this.hIf.isConnected()) {
            this.hIf.close();
        }
    }

    public final boolean isConnected() {
        return this.hIf.isConnected();
    }
}
