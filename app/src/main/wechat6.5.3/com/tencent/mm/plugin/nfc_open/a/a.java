package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.a.j;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<j> {
    public a() {
        this.nhz = j.class.getName().hashCode();
    }

    private static boolean a(j jVar) {
        if ((jVar instanceof j) && jVar.aWx != null) {
            int i = jVar.aWx.actionCode;
            Context context = jVar.aWx.context;
            Bundle bundle = new Bundle();
            String str;
            switch (i) {
                case 4001:
                    bundle.putInt("status", com.tencent.mm.plugin.nfc.b.a.a.aDU().cl(context));
                    break;
                case 4002:
                    bundle.putInt("status", com.tencent.mm.plugin.nfc.b.a.a.aDU().cm(context));
                    break;
                case 4003:
                    str = jVar.aWx.aWz;
                    if (!be.kS(str)) {
                        try {
                            bundle.putString("result", com.tencent.mm.plugin.nfc.b.a.a.aDU().a(new com.tencent.mm.plugin.nfc.a.a(str)).toString());
                            break;
                        } catch (Throwable e) {
                            v.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                            v.a("MicroMsg.ApduEngineFuncListener", e, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                    v.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                    break;
                case 4004:
                    try {
                        str = jVar.aWx.aWz;
                        boolean z = jVar.aWx.aWA;
                        boolean z2 = jVar.aWx.aWB;
                        if (be.kS(str)) {
                            v.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        }
                        String[] split = str.split("\\|");
                        List<com.tencent.mm.plugin.nfc.b.a> arrayList = new ArrayList();
                        for (String str2 : split) {
                            if (be.kS(str2)) {
                                v.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                            } else {
                                String[] split2 = str2.split(":");
                                if (split2 == null || split2.length < 2) {
                                    v.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                } else {
                                    int i2 = be.getInt(split2[0], 0);
                                    arrayList.add(new com.tencent.mm.plugin.nfc.b.a(i2, String.valueOf(i2), new com.tencent.mm.plugin.nfc.a.a(split2[1])));
                                }
                            }
                        }
                        com.tencent.mm.plugin.nfc.b.a.a.aDU().a(arrayList, z, z2);
                        StringBuilder stringBuilder = new StringBuilder();
                        for (com.tencent.mm.plugin.nfc.b.a aVar : arrayList) {
                            if (aVar.hHY == null) {
                                bundle.putString("result", stringBuilder.toString());
                                break;
                            }
                            stringBuilder.append(aVar.id);
                            stringBuilder.append(":");
                            stringBuilder.append(aVar.hHY.toString());
                            stringBuilder.append("|");
                        }
                        bundle.putString("result", stringBuilder.toString());
                    } catch (Throwable e2) {
                        v.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                        v.a("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case 4005:
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.nfc.c.a.ax(com.tencent.mm.plugin.nfc.b.a.a.aDU().hIa));
                    break;
                case 4008:
                    bundle.putString("info", com.tencent.mm.plugin.nfc.b.a.a.aDU().getInfo());
                    break;
            }
            jVar.aWy.aWC = bundle;
        }
        return false;
    }
}
