package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.e.a.be;
import com.tencent.mm.e.a.fj;
import com.tencent.mm.e.a.nm;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;

public final class a {
    private static Context context = null;
    private static boolean jaH = false;
    private static String jaI = "0";
    private static OnClickListener jaJ = null;
    private static int jaK = -1;
    private static int jaL = -1;
    private static long jaM = 0;
    private static View jaN = null;
    private static b jaO = null;
    private static c jaP = null;
    private static com.tencent.mm.sdk.c.c jaQ = new com.tencent.mm.sdk.c.c<nm>() {
        {
            this.nhz = nm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nm nmVar = (nm) bVar;
            if (nmVar instanceof nm) {
                boolean z = nmVar.boE.boF;
                long j = nmVar.boE.beL;
                v.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
                if (!(j == 0 || a.jaM == 0 || a.jaM != j)) {
                    if (z) {
                        a.jaK = 4;
                    } else {
                        a.jaK = 3;
                    }
                    a.Ar();
                }
            }
            return false;
        }
    };
    private static com.tencent.mm.sdk.c.c jaR = new com.tencent.mm.sdk.c.c<fj>() {
        {
            this.nhz = fj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fj fjVar = (fj) bVar;
            if (fjVar instanceof fj) {
                boolean z = fjVar.beJ.beK;
                long j = fjVar.beJ.beL;
                v.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
                if (!(j == 0 || a.jaM == 0 || j != a.jaM)) {
                    if (z) {
                        a.jaK = 2;
                    } else {
                        a.jaK = 1;
                    }
                    a.Ar();
                }
            }
            return false;
        }
    };

    static /* synthetic */ void Ar() {
        if (jaH && jaM != 0) {
            String str = jaK + "|" + jaL + "|" + jaM;
            f.Aj().ga("7").cvX = 4;
            f.Aj().ga("7").bfz = str;
            e.a(f.Aj().ga("7"));
            v.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", new Object[]{Integer.valueOf(4), str});
        }
        jaL = -1;
        jaK = -1;
        jaM = 0;
    }

    static /* synthetic */ void a(View view, Context context, k kVar) {
        if (context != null) {
            if (kVar != null) {
                jaM = kVar.field_snsId;
            }
            b bVar = jaO;
            if (view != null && !bVar.jbn) {
                com.tencent.mm.sdk.c.a.nhr.z(new be());
                if (bVar.jbl) {
                    bVar.aQP();
                    return;
                }
                if (bVar.dQw == 0) {
                    bVar.dQw = com.tencent.mm.pluginsdk.e.db(context);
                }
                if (bVar.Rg == 0) {
                    bVar.Rg = com.tencent.mm.pluginsdk.e.da(context);
                }
                if (bVar.jbg == 0) {
                    bVar.jbg = view.getMeasuredHeight();
                    if (bVar.jbg <= 0) {
                        bVar.jbg = com.tencent.mm.bd.a.fromDPToPix(context, 15);
                    }
                }
                if (bVar.jbh <= 0) {
                    bVar.jbh = com.tencent.mm.bd.a.fromDPToPix(context, 8);
                }
                if (bVar.jbi <= 0) {
                    bVar.jbi = com.tencent.mm.bd.a.fromDPToPix(context, 3);
                }
                if (bVar.mScreenHeight == 0) {
                    bVar.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                    bVar.mScreenHeight -= bVar.Rg;
                    bVar.mScreenHeight -= bVar.dQw;
                }
                if (bVar.jbj == 0) {
                    bVar.jbj = com.tencent.mm.bd.a.fromDPToPix(context, br.CTRL_INDEX);
                }
                if (bVar.jbk == 0) {
                    bVar.jbk = com.tencent.mm.bd.a.fromDPToPix(context, 13);
                }
                bVar.jaZ = new NotInterestMenu(context);
                if (bVar.jaU != null) {
                    bVar.jaZ.jaU = bVar.jaU;
                }
                bVar.jaZ.jaV = bVar.jbb;
                bVar.jaZ.jaC = kVar;
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                v.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", new Object[]{Arrays.toString(iArr)});
                int i = (((iArr[1] - bVar.dQw) - bVar.Rg) + bVar.jbg) - bVar.jbh;
                v.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.dQw), Integer.valueOf(bVar.Rg), Integer.valueOf(bVar.jbg), Integer.valueOf(bVar.jbh)});
                v.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bVar.jbj), Integer.valueOf(bVar.mScreenHeight)});
                if (bVar.jbj + i <= bVar.mScreenHeight) {
                    bVar.jaZ.setBackgroundResource(2130838796);
                    bVar.jbo = true;
                } else {
                    bVar.jaZ.setBackgroundResource(2130838797);
                    i = (((iArr[1] - bVar.dQw) - bVar.Rg) - bVar.jbj) + bVar.jbi;
                    v.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", new Object[]{Integer.valueOf(iArr[1]), Integer.valueOf(i), Integer.valueOf(bVar.dQw), Integer.valueOf(bVar.Rg), Integer.valueOf(bVar.jbg), Integer.valueOf(bVar.jbi), Integer.valueOf(bVar.jbj)});
                    bVar.jbo = false;
                }
                if (bVar.jbm == null) {
                    bVar.jbm = new AbsoluteLayout(context);
                    LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bVar.jbm.setBackgroundDrawable(context.getResources().getDrawable(2130838121));
                    bVar.jbm.setPadding(bVar.jbk, 0, bVar.jbk, 0);
                    bVar.jbm.setLayoutParams(layoutParams);
                }
                if (bVar.jba != null) {
                    bVar.jba.addView(bVar.jbm);
                }
                bVar.jbm.addView(bVar.jaZ, new AbsoluteLayout.LayoutParams(-1, -2, 0, i));
                bVar.jaZ.setVisibility(4);
                if (bVar.jbo) {
                    bVar.jaZ.startAnimation(bVar.jbc);
                } else {
                    bVar.jaZ.startAnimation(bVar.jbd);
                }
            }
        }
    }

    static /* synthetic */ void b(Context context, k kVar) {
        if (kVar != null && context != null) {
            a(kVar);
            String str = kVar.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", kVar.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void c(Context context, k kVar) {
        if (kVar != null && context != null) {
            a(kVar);
            Intent intent = new Intent();
            v.i("MicroMsg.NotInteresetABTestManager", "expose id " + kVar.aUq());
            intent.putExtra("showShare", false);
            intent.putExtra("k_expose_msg_id", kVar == null ? 0 : kVar.field_snsId);
            intent.putExtra("k_username", kVar == null ? "" : kVar.field_userName);
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public static void b(Context context, ViewGroup viewGroup) {
        if (f.Aj().ga("7") != null) {
            jaH = true;
            jaI = f.Aj().ga("7").value;
            v.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", new Object[]{jaI});
            jaN = viewGroup;
            jaO = new b(viewGroup);
            context = context;
            com.tencent.mm.sdk.c.a.nhr.e(jaQ);
            com.tencent.mm.sdk.c.a.nhr.e(jaR);
            jaJ = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() instanceof k) {
                        a.a(view, view.getContext(), (k) view.getTag());
                    }
                }
            };
            jaP = new c() {
                public final void c(k kVar) {
                    a.a(a.context, kVar);
                }

                public final void d(k kVar) {
                    a.b(a.context, kVar);
                }

                public final void e(k kVar) {
                    a.c(a.context, kVar);
                }
            };
            jaO.jaU = jaP;
        }
    }

    public static void aQK() {
        if (jaO != null) {
            jaO.aQP();
        }
    }

    private static void a(k kVar) {
        boolean equals = jaI.equals("3");
        if (kVar.field_type == 1) {
            if (equals) {
                jaL = 5;
            } else {
                jaL = 0;
            }
        } else if (kVar.field_type == 2) {
            if (equals) {
                jaL = 4;
            } else {
                jaL = 1;
            }
        } else if (kVar.field_type == 15) {
            if (!equals) {
                jaL = 2;
            }
        } else if (!i.f(kVar)) {
        } else {
            if (equals) {
                jaL = 6;
            } else {
                jaL = 3;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, com.tencent.mm.plugin.sns.storage.k r7) {
        /*
        r0 = 2;
        r1 = 1;
        r2 = jaH;
        if (r2 == 0) goto L_0x004c;
    L_0x0006:
        if (r7 == 0) goto L_0x004c;
    L_0x0008:
        if (r6 == 0) goto L_0x004c;
    L_0x000a:
        r2 = r7.field_snsId;
        jaM = r2;
        a(r7);
        r2 = new android.content.Intent;
        r3 = com.tencent.mm.plugin.sns.ui.SnsNotInterestUI.class;
        r2.<init>(r6, r3);
        r3 = "sns_info_svr_id";
        r4 = jaM;
        r2.putExtra(r3, r4);
        r3 = "sns_info_not_interest_scene";
        r4 = jaH;
        if (r4 == 0) goto L_0x006a;
    L_0x0027:
        r4 = jaI;
        r4 = com.tencent.mm.sdk.platformtools.be.kS(r4);
        if (r4 != 0) goto L_0x006a;
    L_0x002f:
        r4 = jaI;
        r5 = "1";
        r4 = r4.equals(r5);
        if (r4 != 0) goto L_0x0045;
    L_0x003a:
        r4 = jaI;
        r5 = "2";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x004d;
    L_0x0045:
        r0 = r1;
    L_0x0046:
        r2.putExtra(r3, r0);
        r6.startActivity(r2);
    L_0x004c:
        return;
    L_0x004d:
        r4 = jaI;
        r5 = "3";
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x006a;
    L_0x0058:
        r4 = com.tencent.mm.plugin.sns.data.i.f(r7);
        if (r4 == 0) goto L_0x0060;
    L_0x005e:
        r0 = 4;
        goto L_0x0046;
    L_0x0060:
        r4 = r7.field_type;
        if (r4 != r1) goto L_0x0066;
    L_0x0064:
        r0 = 3;
        goto L_0x0046;
    L_0x0066:
        r1 = r7.field_type;
        if (r1 == r0) goto L_0x0046;
    L_0x006a:
        r0 = 0;
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.abtest.a.a(android.content.Context, com.tencent.mm.plugin.sns.storage.k):void");
    }

    public static void a(ContextMenu contextMenu, k kVar) {
        if (jaH && jaI.equals("3") && kVar != null && !kVar.qC(32) && !kVar.field_userName.equals(ad.aSk()) && kVar.field_type != 15) {
            contextMenu.add(0, 13, 0, 2131235428);
        }
    }

    public static void a(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (jaH && !com.tencent.mm.sdk.platformtools.be.kS(jaI) && !jaI.equals("0")) {
            cVar.kaV = (ImageView) view.findViewById(2131759491);
            cVar.kaV.setVisibility(8);
            cVar.kaW = false;
            if (!jaI.equals("3")) {
                cVar.kaV.setOnClickListener(jaJ);
            }
        }
    }

    public static void b(k kVar) {
        if (jaH) {
            jaM = kVar.field_snsId;
            a(kVar);
        }
    }

    public static void clean() {
        jaL = -1;
        jaK = -1;
        jaM = 0;
        jaJ = null;
        jaP = null;
        jaN = null;
        context = null;
        jaH = false;
        jaI = "0";
        e.gf("7");
        com.tencent.mm.sdk.c.a.nhr.f(jaQ);
        com.tencent.mm.sdk.c.a.nhr.f(jaR);
    }
}
