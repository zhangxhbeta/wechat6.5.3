package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject.HelpCenter;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.plugin.order.model.a.a {
    public c hPr;

    static /* synthetic */ void a(Context context, String str, MallTransactionObject mallTransactionObject) {
        String ah;
        Intent intent = new Intent();
        Uri parse = Uri.parse(str);
        String str2 = mallTransactionObject.eWA;
        String deviceID = p.getDeviceID(context);
        String str3 = "bssid";
        String str4 = d.cmW;
        String str5 = Build.MODEL;
        String rY = p.rY();
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                ah = be.ah(connectionInfo.getBSSID(), "");
                v.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", new Object[]{parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", ah).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", rY).build().toString()});
                intent.putExtra("rawUrl", ah);
                intent.putExtra("geta8key_username", k.xF());
                com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
        }
        ah = str3;
        v.i("MicroMsg.DefaultOrderPrefFactory", "new url %s", new Object[]{parse.buildUpon().appendQueryParameter("trans_id", str2).appendQueryParameter("deviceid", deviceID).appendQueryParameter("bssid", ah).appendQueryParameter("deviceType", str4).appendQueryParameter("deviceName", str5).appendQueryParameter("ostype", rY).build().toString()});
        intent.putExtra("rawUrl", ah);
        intent.putExtra("geta8key_username", k.xF());
        com.tencent.mm.ay.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        CharSequence string;
        u LX;
        f fVar2;
        List<Preference> arrayList = new ArrayList();
        Object obj = mallTransactionObject.aTg == 2 ? 1 : null;
        if (!(be.kS(mallTransactionObject.hNi) || be.kS(mallTransactionObject.dDo))) {
            d dVar = new d(context);
            dVar.fyK = mallTransactionObject.dDo;
            dVar.mName = mallTransactionObject.hNi;
            dVar.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ a hPt;

                public final void onClick(View view) {
                    if (!be.kS(mallTransactionObject.hNh)) {
                        e.L(context, mallTransactionObject.hNh);
                    }
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        i iVar = new i(context);
        iVar.hPT = e.d(mallTransactionObject.eWz, mallTransactionObject.hNg);
        if (obj != null) {
            string = context.getString(2131236230);
        } else if (mallTransactionObject.hMR == 11) {
            string = context.getString(2131236260);
        } else {
            string = context.getString(2131236229);
        }
        iVar.setTitle(string);
        if (!be.kS(mallTransactionObject.hMY)) {
            iVar.xG(mallTransactionObject.hMY);
        }
        arrayList.add(iVar);
        boolean z = false;
        if (mallTransactionObject.eWz != mallTransactionObject.hNm) {
            h hVar = new h(context);
            hVar.hPP = false;
            hVar.hPQ = true;
            arrayList.add(hVar);
            f fVar3 = new f(context);
            fVar3.setContent(e.d(mallTransactionObject.hNm, mallTransactionObject.hNg));
            fVar3.setTitle(2131236252);
            arrayList.add(fVar3);
            z = true;
        }
        if (!(mallTransactionObject.eWz == mallTransactionObject.hNm || be.kS(mallTransactionObject.hNl))) {
            g gVar = new g(context);
            gVar.setTitle(2131236240);
            gVar.ezq = fVar;
            String[] split = mallTransactionObject.hNl.split("\n");
            if (split.length == 1) {
                gVar.hPI = split[0];
            } else {
                gVar.hPI = context.getString(2131236241, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.hNm - mallTransactionObject.eWz, mallTransactionObject.hNg)});
                gVar.a(split, TruncateAt.MIDDLE);
            }
            arrayList.add(gVar);
        }
        h hVar2 = new h(context);
        hVar2.hPP = z;
        hVar2.hPQ = true;
        arrayList.add(hVar2);
        if (obj == null && !be.kS(mallTransactionObject.hNv)) {
            ak.yW();
            LX = com.tencent.mm.model.c.wH().LX(mallTransactionObject.hNv);
            if (LX != null && ((int) LX.chr) > 0) {
                String tU = LX.tU();
                f fVar4 = new f(context);
                fVar4.setTitle(2131236263);
                fVar4.setContent(tU);
                arrayList.add(fVar4);
            }
        }
        if (!(mallTransactionObject.hMR != 31 || obj == null || be.kS(mallTransactionObject.hNC))) {
            ak.yW();
            LX = com.tencent.mm.model.c.wH().LX(mallTransactionObject.hNC);
            if (LX != null && ((int) LX.chr) > 0) {
                tU = LX.tU();
                fVar4 = new f(context);
                fVar4.setTitle(2131236250);
                fVar4.setContent(tU);
                arrayList.add(fVar4);
            }
        }
        if (!be.kS(mallTransactionObject.desc)) {
            if (obj != null) {
                fVar2 = new f(context);
                if (mallTransactionObject.hMR == 32 || mallTransactionObject.hMR == 33 || mallTransactionObject.hMR == 31) {
                    fVar2.setTitle(2131236234);
                } else {
                    fVar2.setTitle(2131236250);
                }
                fVar2.setContent(mallTransactionObject.desc);
                arrayList.add(fVar2);
            } else {
                fVar2 = new f(context);
                if (mallTransactionObject.hMR == 31) {
                    fVar2.setTitle(2131236256);
                } else {
                    fVar2.setTitle(2131236238);
                }
                if (be.kS(mallTransactionObject.hMW)) {
                    fVar2.setContent(mallTransactionObject.desc);
                } else {
                    tU = context.getString(2131236233);
                    fVar2.a(mallTransactionObject.desc + " " + tU, mallTransactionObject.desc.length() + 1, tU.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener(this) {
                        final /* synthetic */ a hPt;

                        public final void onClick(View view) {
                            fVar2.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.hMW);
                            fVar.notifyDataSetChanged();
                        }
                    });
                }
                arrayList.add(fVar2);
            }
        }
        if (!be.kS(mallTransactionObject.hNG)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236274);
            fVar2.setContent(mallTransactionObject.hNG);
            arrayList.add(fVar2);
        }
        if (!be.kS(mallTransactionObject.hNF)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236275);
            fVar2.setContent(mallTransactionObject.hNF);
            arrayList.add(fVar2);
        }
        if (!TextUtils.isEmpty(mallTransactionObject.hNx)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236232);
            fVar2.setContent(mallTransactionObject.hNx);
            arrayList.add(fVar2);
        }
        if (!be.kS(mallTransactionObject.hMV)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236251);
            fVar2.setContent(mallTransactionObject.hMV);
            arrayList.add(fVar2);
        }
        if (!be.kS(mallTransactionObject.hNa)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236264);
            if (mallTransactionObject.hMR != 31 || k.xF().equals(mallTransactionObject.hNv) || mallTransactionObject.hNw <= 0 || be.kS(mallTransactionObject.hNv) || be.kS(mallTransactionObject.eWA)) {
                fVar2.setContent(mallTransactionObject.hNa);
                if (!be.kS(mallTransactionObject.hNb)) {
                    fVar2.xF(mallTransactionObject.hNb);
                }
            } else {
                tU = context.getString(2131234538);
                fVar2.a(mallTransactionObject.hNa + " " + tU, mallTransactionObject.hNa.length() + 1, (tU.length() + mallTransactionObject.hNa.length()) + 1, new OnClickListener(this) {
                    final /* synthetic */ a hPt;

                    public final void onClick(View view) {
                        g.b(context, context.getString(2131234483), context.getString(2131231139), context.getString(2131234537), context.getString(2131231010), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 hPw;

                            {
                                this.hPw = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("transaction_id", mallTransactionObject.eWA);
                                intent.putExtra("receiver_name", mallTransactionObject.hNv);
                                intent.putExtra("resend_msg_from_flag", 1);
                                com.tencent.mm.ay.c.b(context, "remittance", ".ui.RemittanceResendMsgUI", intent);
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass3 hPw;

                            {
                                this.hPw = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                });
            }
            arrayList.add(fVar2);
        }
        fVar2 = new f(context);
        fVar2.setTitle(2131236237);
        fVar2.setContent(e.yB(mallTransactionObject.cLB));
        arrayList.add(fVar2);
        if (!be.kS(mallTransactionObject.hNe)) {
            fVar3 = new f(context);
            fVar3.setTitle(2131236253);
            String str = mallTransactionObject.hNe;
            if (!be.kS(mallTransactionObject.hNf)) {
                str = str + "(" + mallTransactionObject.hNf + ")";
            }
            fVar3.setContent(str);
            arrayList.add(fVar3);
        }
        if (!be.kS(mallTransactionObject.eWA)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236270);
            fVar2.setContent(mallTransactionObject.eWA);
            arrayList.add(fVar2);
        }
        if (!be.kS(mallTransactionObject.hNd)) {
            fVar2 = new f(context);
            fVar2.setTitle(2131236261);
            if (mallTransactionObject.hMR == 8) {
                fVar2.setContent(context.getString(2131236262));
                c cVar = new c(context);
                final Bitmap b = com.tencent.mm.bb.a.a.b(context, mallTransactionObject.hNd, 5, 0);
                cVar.hPA = e.PV(mallTransactionObject.hNd);
                cVar.cxY = b;
                cVar.mOnClickListener = new OnClickListener(this) {
                    final /* synthetic */ a hPt;

                    public final void onClick(View view) {
                        if (this.hPt.hPr != null) {
                            a aVar = this.hPt;
                            Bitmap bitmap = b;
                            String str = mallTransactionObject.hNd;
                            if (aVar.hPr != null) {
                                aVar.hPr.eb(str, str);
                                aVar.hPr.hLA = bitmap;
                                aVar.hPr.hLB = bitmap;
                                aVar.hPr.bLv();
                            }
                            this.hPt.hPr.r(view, true);
                        }
                    }
                };
                arrayList.add(fVar2);
                arrayList.add(cVar);
            } else {
                fVar2.setContent(mallTransactionObject.hNd);
                arrayList.add(fVar2);
            }
        }
        obj = mallTransactionObject.hMG.size() == 0 ? null : 1;
        if (obj != null || (be.kS(mallTransactionObject.hNq) && be.kS(mallTransactionObject.hNh) && be.kS(mallTransactionObject.hMJ))) {
            hVar = new h(context);
            hVar.hPP = true;
            hVar.hPR = false;
            arrayList.add(hVar);
        } else {
            hVar = new h(context);
            hVar.hPP = true;
            arrayList.add(hVar);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        if (obj != null) {
            j jVar = new j(context);
            if (mallTransactionObject.hMH == 1) {
                if (!(be.kS(mallTransactionObject.hNq) && be.kS(mallTransactionObject.hNh) && be.kS(mallTransactionObject.hMJ))) {
                    if (be.kS(mallTransactionObject.hNr)) {
                        jVar.hPU = context.getString(2131236268);
                    } else {
                        jVar.hPU = mallTransactionObject.hNr;
                    }
                    jVar.hPV = new OnClickListener(this) {
                        final /* synthetic */ a hPt;

                        public final void onClick(View view) {
                            List linkedList = new LinkedList();
                            List linkedList2 = new LinkedList();
                            if (!be.kS(mallTransactionObject.hNh)) {
                                linkedList2.add(Integer.valueOf(0));
                                linkedList.add(context.getString(2131236266));
                            }
                            if (!be.kS(mallTransactionObject.hMJ)) {
                                linkedList2.add(Integer.valueOf(1));
                                linkedList.add(context.getString(2131236267));
                            }
                            if (!be.kS(mallTransactionObject.hNq)) {
                                linkedList2.add(Integer.valueOf(2));
                                linkedList.add(context.getString(2131236269));
                            }
                            if (linkedList2.size() == 1) {
                                com.tencent.mm.plugin.order.model.a.a(((Integer) linkedList2.get(0)).intValue(), context, mallTransactionObject);
                                return;
                            }
                            g.a(context, null, linkedList, linkedList2, null, true, new g.d(this) {
                                final /* synthetic */ AnonymousClass5 hPx;

                                {
                                    this.hPx = r1;
                                }

                                public final void bw(int i, int i2) {
                                    com.tencent.mm.plugin.order.model.a.a(i2, context, mallTransactionObject);
                                }
                            });
                        }
                    };
                }
            } else if (!be.kS(mallTransactionObject.hNr)) {
                jVar.hPU = mallTransactionObject.hNr;
                jVar.hPV = new OnClickListener(this) {
                    final /* synthetic */ a hPt;

                    public final void onClick(View view) {
                        a.a(context, mallTransactionObject.hNq, mallTransactionObject);
                    }
                };
            }
            jVar.hMG = mallTransactionObject.hMG;
            jVar.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ a hPt;

                public final void onClick(View view) {
                    if (view.getTag() != null && (view.getTag() instanceof HelpCenter)) {
                        a.a(context, ((HelpCenter) view.getTag()).url, mallTransactionObject);
                    }
                }
            };
            hVar = new h(context);
            hVar.hPP = true;
            arrayList.add(hVar);
            arrayList.add(jVar);
        }
        return arrayList;
    }
}
