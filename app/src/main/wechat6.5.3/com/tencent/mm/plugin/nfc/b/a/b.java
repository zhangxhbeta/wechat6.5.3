package com.tencent.mm.plugin.nfc.b.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.v;

public final class b implements d {
    private IsoDep hIe;

    public b(Tag tag) {
        if (tag == null) {
            v.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            throw new IllegalStateException("tag is null");
        } else {
            this.hIe = IsoDep.get(tag);
        }
    }

    public final boolean connect() {
        if (!this.hIe.isConnected()) {
            this.hIe.connect();
        }
        return true;
    }

    public final void close() {
        if (this.hIe.isConnected()) {
            this.hIe.close();
        }
    }

    public final boolean isConnected() {
        return this.hIe.isConnected();
    }

    public final c a(a aVar) {
        if (this.hIe == null) {
            v.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            throw new IllegalStateException("IsoDep is null");
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.hIe.transceive(aVar.getBytes()));
            if (cVar2.hHO.length == 0) {
                return cVar;
            }
            if (cVar2.hHO.length - 2 <= 0) {
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
                aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.hHW.clone());
            }
        }
    }
}
