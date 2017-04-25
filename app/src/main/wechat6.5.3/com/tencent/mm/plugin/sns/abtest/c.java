package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.e.a.nm;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static boolean jaH = false;
    private static com.tencent.mm.sdk.c.c jaQ = new com.tencent.mm.sdk.c.c<nm>() {
        {
            this.nhz = nm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nm nmVar = (nm) bVar;
            if (nmVar instanceof nm) {
                boolean z = nmVar.boE.boF;
                long j = nmVar.boE.beL;
                v.d("MicroMsg.SellerABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
                if (j != 0 && c.jbt.contains(Long.valueOf(j))) {
                    c.i(j, z);
                }
            }
            return false;
        }
    };
    private static String jbs = "0";
    private static Set<Long> jbt = new HashSet();
    private static OnClickListener jbu;

    static /* synthetic */ void aq(Context context, String str) {
        k Bp = ad.aSE().Bp(str);
        if (Bp != null) {
            String str2 = Bp.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str2);
            intent.putExtra("sns_permission_snsinfo_svr_id", Bp.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }

    static /* synthetic */ void i(long j, boolean z) {
        if (jaH) {
            f.Aj().ga("6").cvX = 3;
            f.Aj().ga("6").bfz = (z ? 2 : 1) + "|" + j;
            e.a(f.Aj().ga("6"));
            v.d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(3), r0});
        }
    }

    public static void aQQ() {
        if (f.Aj().ga("6") != null) {
            jbs = f.Aj().ga("6").value;
            v.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[]{jbs});
            jaH = true;
            a.nhr.e(jaQ);
            jbu = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() instanceof k) {
                        k kVar = (k) view.getTag();
                        if (kVar != null && !be.kS(kVar.aUq())) {
                            c.aq(view.getContext(), kVar.aUq());
                        }
                    }
                }
            };
        }
    }

    public static void aQR() {
        jbu = null;
        a.nhr.f(jaQ);
        if (jaH) {
            f.Aj().ga("6").cvX = 2;
            f.Aj().ga("6").bfz = jbt.size();
            e.a(f.Aj().ga("6"));
            v.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[]{Integer.valueOf(2), jbt.size()});
        }
        jbs = "0";
        jaH = false;
        jbt.clear();
    }

    public static void b(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (jaH) {
            cVar.kaH = false;
            cVar.kaF = (ViewStub) view.findViewById(2131759498);
            cVar.kaF.setVisibility(8);
        }
    }
}
