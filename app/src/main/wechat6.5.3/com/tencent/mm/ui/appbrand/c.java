package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashSet;
import java.util.Set;

public final class c extends b implements OnClickListener {
    private static final Set<a> cbh = new HashSet();
    private static String nPA;
    private static String nPB;
    private static int nPC = -1;
    private static String nPz;
    private TextView gYO;
    private View nPw;
    private ImageView nPx;
    private final a nPy = new a(this) {
        final /* synthetic */ c nPD;

        {
            this.nPD = r1;
        }

        public final void L(String str, int i) {
            this.nPD.refresh();
        }
    };

    public interface a {
        void L(String str, int i);
    }

    private c(Context context) {
        super(context);
        if (this.view != null) {
            this.view.setOnClickListener(this);
            c(this.nPy);
            this.nPw = ((ViewGroup) this.view).getChildAt(0);
            this.gYO = (TextView) this.view.findViewById(2131756061);
            this.nPx = (ImageView) this.view.findViewById(2131756060);
            if (this.nPx != null) {
                this.nPx.setImageDrawable(com.tencent.mm.svg.b.a.c(this.nPx.getResources(), 2131166035));
            }
            setVisibility(8);
        }
    }

    public final int getLayoutId() {
        return 2130903280;
    }

    public final boolean refresh() {
        boolean z;
        if (this == null || !(this instanceof c)) {
            z = false;
        } else {
            z = (be.kS(nPA) || be.kS(nPz) || be.kS(nPB) || nPC < 0) ? false : true;
        }
        if (z) {
            setVisibility(0);
            if (this.gYO != null) {
                this.gYO.setText(nPA);
            }
        } else {
            setVisibility(8);
        }
        return true;
    }

    public final void setVisibility(int i) {
        if (this.nPw != null) {
            this.nPw.setVisibility(i);
        }
    }

    public final void destroy() {
        if (this.nPw != null) {
            ((ViewGroup) this.nPw).removeAllViews();
        }
        this.nPw = null;
        this.gYO = null;
        this.nPx = null;
        a aVar = this.nPy;
        if (aVar != null) {
            cbh.remove(aVar);
        }
    }

    public final void onClick(View view) {
        if (!be.kS(nPA) && !be.kS(nPB) && !be.kS(nPz) && nPC >= 0) {
            com.tencent.mm.sdk.c.b okVar = new ok();
            okVar.bpu.userName = nPz;
            okVar.bpu.appId = nPB;
            okVar.bpu.bpx = nPC;
            okVar.bpu.bpA = true;
            okVar.bpu.scene = 1022;
            com.tencent.mm.sdk.c.a.nhr.z(okVar);
        }
    }

    public static void aj(Intent intent) {
        Y(intent);
    }

    public static void Y(Intent intent) {
        if (intent != null) {
            String g = r.g(intent, "app_brand_back_to_wechat_key_display_name");
            String g2 = r.g(intent, "app_brand_back_to_wechat_key_appid");
            String g3 = r.g(intent, "app_brand_back_to_wechat_key_username");
            int a = r.a(intent, "app_brand_back_to_wechat_key_version_type", -1);
            if (!be.kS(g) && !be.kS(g2) && a >= 0) {
                nPA = g;
                nPB = g2;
                nPz = g3;
                nPC = a;
                intent.removeExtra("app_brand_back_to_wechat_key_display_name");
                intent.removeExtra("app_brand_back_to_wechat_key_appid");
                intent.removeExtra("app_brand_back_to_wechat_key_username");
                intent.removeExtra("app_brand_back_to_wechat_key_version_type");
                bBy();
            }
        }
    }

    public static b er(Context context) {
        return new c(context);
    }

    public static void b(Context context, String str, String str2, String str3, int i) {
        if (context == null) {
            context = aa.getContext();
        }
        context.startActivity(new Intent().setClassName(context, "com.tencent.mm.ui.LauncherUI").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING).putExtra("app_brand_back_to_wechat_key_username", str2).putExtra("app_brand_back_to_wechat_key_display_name", str).putExtra("app_brand_back_to_wechat_key_appid", str3).putExtra("app_brand_back_to_wechat_key_version_type", i));
    }

    public static boolean I(String str, int i) {
        return !be.kS(nPB) && !be.kS(str) && nPB.equals(str) && nPC == i;
    }

    public static void ca(String str, int i) {
        if (I(str, i)) {
            nPA = null;
            nPz = null;
            nPB = null;
            nPC = -1;
            bBy();
        }
    }

    private static void bBy() {
        ad.o(new Runnable() {
            public final void run() {
                for (a L : c.cbh) {
                    L.L(c.nPB, c.nPC);
                }
            }
        });
    }

    public static void c(a aVar) {
        if (aVar != null) {
            cbh.add(aVar);
        }
    }
}
