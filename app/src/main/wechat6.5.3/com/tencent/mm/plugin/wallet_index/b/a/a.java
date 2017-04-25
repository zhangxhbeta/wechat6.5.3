package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class a {

    public interface a {
        void a(b bVar, c cVar);
    }

    public static c a(Intent intent, c cVar) {
        b sw;
        if (intent == null) {
            uB("Null data in IAB activity result.");
            sw = b.sw(-1002);
            if (cVar == null) {
                return null;
            }
            cVar.a(sw, null);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            v.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            v.d("MicroMsg.IabResolver", "Purchase data: " + stringExtra);
            v.d("MicroMsg.IabResolver", "Data signature: " + stringExtra2);
            v.d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                uB("BUG: either purchaseData or dataSignature is null.");
                sw = b.sw(-1008);
                if (cVar == null) {
                    return null;
                }
                cVar.a(sw, null);
                return null;
            }
            try {
                d dVar = new d("inapp", stringExtra, stringExtra2);
                stringExtra = dVar.fdU;
                v.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (cVar != null) {
                    cVar.a(b.sw(0), dVar);
                }
                return new c(stringExtra, dVar);
            } catch (Throwable e) {
                uB("Failed to parse purchase data.");
                v.a("MicroMsg.IabResolver", e, "", new Object[0]);
                sw = b.sw(-1002);
                if (cVar == null) {
                    return null;
                }
                cVar.a(sw, null);
                return null;
            }
        }
        uB("Purchase failed. Response: " + intExtra);
        sw = b.sw(intExtra);
        if (cVar == null) {
            return null;
        }
        cVar.a(sw, null);
        return null;
    }

    public final int a(Intent intent, a aVar) {
        c cVar = new c();
        int M = M(intent);
        v.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(M));
        if (M != 0) {
            aVar.a(b.sw(M), null);
            return M;
        } else if (intent.hasExtra("INAPP_PURCHASE_ITEM_LIST") && intent.hasExtra("INAPP_PURCHASE_DATA_LIST") && intent.hasExtra("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
            ArrayList stringArrayListExtra3 = intent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
            int i = 0;
            while (i < stringArrayListExtra2.size()) {
                try {
                    String str = (String) stringArrayListExtra2.get(i);
                    String str2 = (String) stringArrayListExtra3.get(i);
                    String str3 = "MicroMsg.IabResolver";
                    v.d(str3, "Sku is owned: " + ((String) stringArrayListExtra.get(i)));
                    d dVar = new d("inapp", str, str2);
                    if (TextUtils.isEmpty(dVar.cKN)) {
                        v.w("MicroMsg.IabResolver", "In-app billing warning: " + "BUG: empty/null token!");
                        v.d("MicroMsg.IabResolver", "Purchase data: " + str);
                    }
                    cVar.kXd.put(dVar.fdU, dVar);
                    i++;
                } catch (Throwable e) {
                    v.a("MicroMsg.IabResolver", e, "", new Object[0]);
                    aVar.a(b.sw(-1002), cVar);
                }
            }
            aVar.a(b.sw(0), cVar);
            return 0;
        } else {
            uB("Bundle returned from getPurchases() doesn't contain required fields.");
            aVar.a(b.sw(-1002), null);
            return -1002;
        }
    }

    private static void uB(String str) {
        v.e("MicroMsg.IabResolver", "In-app billing error: " + str);
    }

    public static int M(Intent intent) {
        if (intent == null) {
            uB("Intent with no response code, assuming OK (known issue)");
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            uB("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            uB("Unexpected type for intent response code.");
            uB(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }
}
