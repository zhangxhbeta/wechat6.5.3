package com.tencent.mm.plugin.nfc.b.a;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.plugin.nfc.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends b {
    private static a hIb = null;
    private Set<String> hIc;
    private d hId = null;

    public static a aDU() {
        if (hIb == null) {
            hIb = new a();
        }
        return hIb;
    }

    public final boolean a(Tag tag) {
        super.a(tag);
        this.hIc = new HashSet();
        for (String str : tag.getTechList()) {
            v.d("MicroMsg.ApduEngine", "[NFC]tech : " + str);
            this.hIc.add(str);
        }
        try {
            if (this.hId != null && this.hId.isConnected()) {
                this.hId.close();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ApduEngine", e, "", new Object[0]);
            v.e("MicroMsg.ApduEngine", e.toString());
        }
        if (this.hIc.contains(IsoDep.class.getName())) {
            this.hId = new b(tag);
            return true;
        } else if (this.hIc.contains(NfcA.class.getName())) {
            this.hId = new c(tag);
            return true;
        } else {
            v.i("MicroMsg.ApduEngine", "[NFC]ApduEngine not support this tag");
            return false;
        }
    }

    public final c a(com.tencent.mm.plugin.nfc.a.a aVar) {
        com.tencent.mm.plugin.nfc.b.a aVar2 = new com.tencent.mm.plugin.nfc.b.a(1, "def", aVar);
        a(aVar2);
        return aVar2.hHY;
    }

    private boolean a(com.tencent.mm.plugin.nfc.b.a aVar) {
        if (this.hId == null) {
            v.e("MicroMsg.ApduEngine", "[NFC]ApduEngine not ready !");
            throw new IllegalStateException("ApduEngine not ready !");
        } else if (aVar == null || aVar.hHX == null) {
            v.e("MicroMsg.ApduEngine", "[NFC]apdu is null !");
            throw new IllegalArgumentException("apdu is null !");
        } else {
            v.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] do cmd : " + aVar.hHX.toString());
            aVar.hHY = this.hId.a(aVar.hHX);
            c cVar = aVar.hHY;
            if (((short) (cVar.aDT() | (cVar.aDS() << 8))) == (short) -28672) {
                v.i("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> OK : " + aVar.hHY.toString());
                return true;
            }
            v.e("MicroMsg.ApduEngine", "[NFC][" + aVar.name + "] result==> fail : " + aVar.hHY.toString());
            return false;
        }
    }

    public final boolean a(List<com.tencent.mm.plugin.nfc.b.a> list, boolean z, boolean z2) {
        for (com.tencent.mm.plugin.nfc.b.a a : list) {
            boolean a2 = a(a);
            if (!a2 && z) {
                return false;
            }
            if (a2 && z2) {
                return false;
            }
        }
        return true;
    }

    public final int cl(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        if (defaultAdapter == null) {
            v.i("MicroMsg.ApduEngine", "[NFC] No nfc chip !");
            return 0;
        } else if (!defaultAdapter.isEnabled()) {
            return 1;
        } else {
            if (this.hId == null) {
                return 4;
            }
            try {
                if (this.hId == null || !this.hId.isConnected()) {
                    return 2;
                }
                return 3;
            } catch (IOException e) {
                v.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
                return 2;
            }
        }
    }

    public final int cm(Context context) {
        int cl = cl(context);
        if (cl != 3 && cl != 2) {
            return cl;
        }
        try {
            if (this.hId != null) {
                this.hId.connect();
                if (this.hId.isConnected()) {
                    return 3;
                }
            }
            return 2;
        } catch (IOException e) {
            v.e("MicroMsg.ApduEngine", "[NFC] IOException : " + e.toString());
            return 2;
        }
    }

    public final String getInfo() {
        if (this.hHZ == null) {
            v.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: tag null");
            return null;
        }
        long Ni = be.Ni();
        JSONObject jSONObject = new JSONObject();
        for (String str : this.hIc) {
            Object obj;
            if (str.equals(NfcA.class.getName())) {
                NfcA nfcA = NfcA.get(this.hHZ);
                if (nfcA == null) {
                    v.w("MicroMsg.ApduEngineNfcA", "lo-nfc-getInfoJsonObject: get nfcA null");
                    obj = null;
                } else {
                    try {
                        obj = new JSONObject();
                        obj.put("atqa", com.tencent.mm.plugin.nfc.c.a.ax(nfcA.getAtqa()));
                        obj.put("sak", com.tencent.mm.plugin.nfc.c.a.ax(com.tencent.mm.plugin.nfc.c.a.b(nfcA.getSak())));
                    } catch (JSONException e) {
                        v.w("MicroMsg.ApduEngine", "lo-nfc-getInfo: exp:+" + e.getLocalizedMessage());
                        return jSONObject.toString();
                    }
                }
                jSONObject.put(NfcA.class.getSimpleName(), obj);
            } else if (str.equals(IsoDep.class.getSimpleName())) {
                IsoDep isoDep = IsoDep.get(this.hHZ);
                if (isoDep == null) {
                    v.w("MicroMsg.ApduEngineIsoDep", "lo-nfc-getInfoJsonObject: get IsoDep null");
                    obj = null;
                } else {
                    obj = new JSONObject();
                    obj.put("hiLayerResponse", com.tencent.mm.plugin.nfc.c.a.ax(isoDep.getHiLayerResponse()));
                    obj.put("historicalBytes", com.tencent.mm.plugin.nfc.c.a.ax(isoDep.getHistoricalBytes()));
                }
                jSONObject.put(IsoDep.class.getName(), obj);
            }
        }
        v.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: cost=" + (be.Ni() - Ni));
        v.v("MicroMsg.ApduEngine", "lo-nfc-getInfo: res=" + jSONObject.toString());
        return jSONObject.toString();
    }
}
