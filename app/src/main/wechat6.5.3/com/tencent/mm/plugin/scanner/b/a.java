package com.tencent.mm.plugin.scanner.b;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.plugin.scanner.b.n.b;
import com.tencent.mm.plugin.scanner.b.n.c;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.c.hi;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a implements e {
    public Activity bij;
    public ProgressDialog dwR;

    class AnonymousClass1 implements OnCancelListener {
        final /* synthetic */ f iBI;
        final /* synthetic */ a iCN;

        public AnonymousClass1(a aVar, f fVar) {
            this.iCN = aVar;
            this.iBI = fVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.iCN.aLL();
            ak.vy().c(this.iBI);
        }
    }

    final void aLL() {
        ak.vy().b(1061, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.BarcodeStringHandler", "onSceneEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        aLL();
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i == 4 && i2 == -4) {
            g.a(this.bij, 2131234276, 2131231164, null);
            return;
        }
        Object obj;
        switch (i) {
            case 1:
                if (ak.vy().BK()) {
                    i.u(this.bij, ak.vy().getNetworkServerIp(), String.valueOf(i2));
                } else if (aa.bk(this.bij)) {
                    i.dl(this.bij);
                } else {
                    Toast.makeText(this.bij, this.bij.getString(2131232874, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), 1).show();
                }
                obj = 1;
                break;
            case 2:
                Toast.makeText(this.bij, this.bij.getString(2131232875), 1).show();
                obj = 1;
                break;
            default:
                obj = null;
                break;
        }
        if (obj != null) {
            return;
        }
        if (i == 4 && i2 == -2004) {
            g.f(this.bij, 2131234269, 2131231164);
        } else if (i != 0 || i2 != 0) {
            Toast.makeText(this.bij, this.bij.getString(2131232920, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        } else if (kVar.getType() == 1061) {
            hi aKS = ((f) kVar).aKS();
            if (aKS == null) {
                v.e("MicroMsg.BarcodeStringHandler", "onSceneEnd(), getResp() == null");
                return;
            }
            v.d("MicroMsg.BarcodeStringHandler", "onSceneEnd() ScanBarcode Type = %s", new Object[]{Integer.valueOf(aKS.efm)});
            if (!be.kS(aKS.mib)) {
                Context context = this.bij;
                String str2 = aKS.mib;
                int i3 = ((f) kVar).aYV;
                int i4 = ((f) kVar).aYW;
                e eVar = new e();
                int yY = n.yY(str2);
                v.d("MicroMsg.Scanner.ScanXmlHelper", "processReturnXml(), xmlType = [%s]", new Object[]{Integer.valueOf(yY)});
                Intent intent;
                if (yY == 1) {
                    c yZ = n.yZ(str2);
                    if (yZ == null || be.kS(yZ.username)) {
                        v.w("MicroMsg.Scanner.ScanXmlHelper", "xmlUser null");
                        obj = 2;
                    } else {
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(yZ.username);
                        if (LX == null || ((int) LX.chr) <= 0) {
                            eVar.a(context, yZ.username, 2, i3, i4, null);
                            obj = 1;
                        } else {
                            intent = new Intent();
                            intent.putExtra("Contact_User", LX.field_username);
                            intent.setFlags(65536);
                            com.tencent.mm.plugin.scanner.a.drp.d(intent, context);
                            obj = null;
                        }
                    }
                } else if (yY == 2) {
                    b za = n.za(str2);
                    if (za == null || be.kS(za.cZp)) {
                        v.w("MicroMsg.Scanner.ScanXmlHelper", "xmlurl null");
                        obj = 2;
                    } else {
                        v.d("MicroMsg.Scanner.ScanXmlHelper", "xmlurl.link: [%s]", new Object[]{za.cZp});
                        Intent intent2 = new Intent();
                        intent2.putExtra("rawUrl", za.cZp);
                        intent2.setFlags(65536);
                        com.tencent.mm.plugin.scanner.a.drp.j(intent2, context);
                        obj = null;
                    }
                } else if (yY == 3 || yY == 4) {
                    v.d("MicroMsg.Scanner.ScanXmlHelper", "funcType = [%s], addProductToDB = [%s]", new Object[]{Integer.valueOf(4), Boolean.valueOf(true)});
                    intent = new Intent();
                    intent.setClass(context, ProductUI.class);
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", str2);
                    intent.putExtra("key_Product_funcType", 4);
                    intent.putExtra("key_ProductUI_addToDB", true);
                    intent.putExtra("key_need_add_to_history", true);
                    intent.putExtra("key_is_from_barcode", true);
                    context.startActivity(intent);
                    obj = null;
                } else {
                    v.w("MicroMsg.Scanner.ScanXmlHelper", "wrong xmlType");
                    v.v("MicroMsg.Scanner.ScanXmlHelper", "wrong xml : [%s]", new Object[]{str2});
                    obj = 2;
                }
                switch (obj) {
                    case null:
                        v.i("MicroMsg.BarcodeStringHandler", "onSceneEnd PROCESS_XML_RETURN_TYPE_OK");
                        return;
                    case 1:
                        v.i("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_SEARCH_CONTACT");
                        return;
                    case 2:
                        v.e("MicroMsg.BarcodeStringHandler", "onSceneEnd() PROCESS_XML_RETURN_TYPE_WRONG");
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
