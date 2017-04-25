package com.tencent.mm.plugin.scanner.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.ic;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.scanner.a.h;
import com.tencent.mm.plugin.scanner.a.k;
import com.tencent.mm.plugin.scanner.b.o;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProductUI extends MMPreference implements com.tencent.mm.platformtools.j.a, e {
    private c bYe;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ProductUI izN;

        {
            this.izN = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (z) {
                v.i("MicroMsg.scanner.ProductUI", "getLocation suc");
                if (this.izN.izv != null) {
                    v.i("MicroMsg.scanner.ProductUI", "do getActionInfoScene, lng=" + f + ", lat=" + f2);
                    ak.vy().a(new com.tencent.mm.plugin.scanner.a.c(this.izN.fdU, k.bg(this.izN.izv.iEd), this.izN.cVh, this.izN.izD, (double) f, (double) f2), 0);
                }
                if (this.izN.bYe != null) {
                    this.izN.bYe.c(this.izN.bYl);
                }
                if (!this.izN.cCU) {
                    this.izN.cCU = true;
                    n.a(2011, f, f2, (int) d2);
                }
                return false;
            }
            v.w("MicroMsg.scanner.ProductUI", "getLocation fail");
            return false;
        }
    };
    private long bao;
    private boolean cCU = false;
    private int cVh;
    private com.tencent.mm.sdk.c.c dHB = new com.tencent.mm.sdk.c.c<id>(this) {
        final /* synthetic */ ProductUI izN;

        {
            this.izN = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            switch (((id) bVar).bif.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    if (this.izN.dxf != null) {
                        this.izN.aLB();
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private TextView dtB;
    protected ProgressDialog dwR = null;
    protected f dxf;
    private String fdU;
    private List<MusicPreference> hCP;
    private boolean izA = false;
    private HashMap<String, Boolean> izB;
    private com.tencent.mm.plugin.scanner.ui.e.a izC;
    private String izD;
    private boolean izE = false;
    private String izF;
    private boolean izG = false;
    private boolean izH = false;
    private boolean izI = false;
    private com.tencent.mm.plugin.scanner.history.a.a izJ;
    private com.tencent.mm.model.bo.b izK = new com.tencent.mm.model.bo.b(this) {
        final /* synthetic */ ProductUI izN;

        {
            this.izN = r1;
        }

        public final void a(com.tencent.mm.v.d.a aVar) {
            String a = m.a(aVar.czu.mbW);
            v.i("MicroMsg.scanner.ProductUI", "lo-scanner-onRecieveMsg");
            com.tencent.mm.plugin.scanner.b.n.a a2 = this.izN.izv;
            if (!(a2 == null || be.kS(a))) {
                Map q = bf.q(a, "sysmsg");
                a = (String) q.get(".sysmsg.scanproductinfo.product.id");
                if (be.kS(a2.field_productid) || !a2.field_productid.equals(a)) {
                    v.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: product id not match, productId=" + be.ma(a) + ", target=" + a2.field_productid);
                } else {
                    List i = com.tencent.mm.plugin.scanner.a.a.i(q, ".sysmsg.scanproductinfo.product");
                    Map hashMap = new HashMap();
                    for (int i2 = 0; i2 < i.size(); i2++) {
                        List list = ((com.tencent.mm.plugin.scanner.a.a) i.get(i2)).cZq;
                        if (list != null) {
                            for (int i3 = 0; i3 < list.size(); i3++) {
                                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) list.get(i3);
                                if (aVar2 != null) {
                                    hashMap.put(aVar2.apU, aVar2);
                                }
                            }
                        }
                    }
                    v.i("MicroMsg.ProductUpdateLogic", "lo-scanner-doUpdateActionLogicByNewXml: toUpdateSize=" + hashMap.size());
                    k.a(a2.iEd, hashMap);
                }
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass9 izS;

                {
                    this.izS = r1;
                }

                public final void run() {
                    this.izS.izN.b(this.izS.izN.izv);
                }
            });
        }
    };
    private com.tencent.mm.plugin.scanner.ui.MusicPreference.a izL = new com.tencent.mm.plugin.scanner.ui.MusicPreference.a(this) {
        final /* synthetic */ ProductUI izN;

        {
            this.izN = r1;
        }

        public final void d(MusicPreference musicPreference) {
            if (musicPreference == null) {
                v.e("MicroMsg.scanner.ProductUI", "onMusicPrefClick, musicPref == null");
            } else if (be.kS(musicPreference.ivK) && be.kS(musicPreference.ivL)) {
                v.w("MicroMsg.scanner.ProductUI", "wifiurl = null,  wapurl = null");
                if (!be.kS(musicPreference.ivM)) {
                    this.izN.yV(musicPreference.ivM);
                }
            } else {
                if (ProductUI.yS(String.format("%s_cd_%s", new Object[]{musicPreference.ivK, musicPreference.dnU}))) {
                    com.tencent.mm.ai.b.HB();
                    v.d("MicroMsg.scanner.ProductUI", "isTheSameId, playMusicId : [%s]", new Object[]{r1});
                } else if (musicPreference.getTitle() == null) {
                    v.e("MicroMsg.scanner.ProductUI", "onPlayBtnClick, getTitle() == null");
                    return;
                } else {
                    String str;
                    int i = -1;
                    if (this.izN.izz == null) {
                        str = null;
                    } else {
                        str = this.izN.izz.MU();
                    }
                    String format = String.format("%s_cd_%s", new Object[]{musicPreference.ivK, musicPreference.dnU});
                    List arrayList = new ArrayList();
                    int i2 = 0;
                    for (MusicPreference musicPreference2 : this.izN.hCP) {
                        int i3;
                        String format2 = String.format("%s_cd_%s", new Object[]{musicPreference2.ivK, musicPreference2.dnU});
                        if (format.equals(format2)) {
                            i3 = i2;
                        } else {
                            i3 = i;
                        }
                        arrayList.add(com.tencent.mm.ai.b.a(5, str, musicPreference2.getTitle().toString(), "", musicPreference2.ivM, musicPreference2.ivL, musicPreference2.ivK, format2, com.tencent.mm.plugin.scanner.b.xq(), str, "wx482a4001c37e2b74"));
                        i2++;
                        i = i3;
                    }
                    if (i >= 0) {
                        ic icVar = new ic();
                        icVar.bhZ.action = 0;
                        icVar.bhZ.bed = arrayList;
                        icVar.bhZ.bic = i;
                        com.tencent.mm.sdk.c.a.nhr.z(icVar);
                    } else {
                        return;
                    }
                }
                this.izN.aLB();
            }
        }
    };
    private boolean izM = true;
    private ImageView izm;
    private ImageView izn;
    private View izo;
    private TextView izp;
    private ImageView izq;
    private View izr;
    private TextView izs;
    private LinearLayout izt;
    private ImageView izu;
    private com.tencent.mm.plugin.scanner.b.n.a izv;
    private View izw;
    private int izx = 0;
    private int izy;
    private a izz;
    private long mStartTime;

    public static final class a implements i {
        private com.tencent.mm.plugin.scanner.b.n.a izv;

        public a(com.tencent.mm.plugin.scanner.b.n.a aVar) {
            this.izv = aVar;
        }

        public final String MU() {
            return com.tencent.mm.plugin.scanner.b.aKP().cr(this.izv.field_thumburl, "@S");
        }

        public final String MV() {
            if (this.izv == null) {
                return "";
            }
            return this.izv.field_thumburl;
        }

        public final String MW() {
            if (this.izv == null) {
                return "";
            }
            return this.izv.field_thumburl;
        }

        public final String MX() {
            if (this.izv == null) {
                return "";
            }
            return this.izv.field_thumburl;
        }

        public final boolean MY() {
            return false;
        }

        public final boolean MZ() {
            return false;
        }

        public final Bitmap a(Bitmap bitmap, com.tencent.mm.platformtools.i.a aVar) {
            if (com.tencent.mm.platformtools.i.a.doT == aVar) {
                try {
                    d.a(bitmap, 100, CompressFormat.PNG, MU(), false);
                } catch (Throwable e) {
                    v.a("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
                }
            }
            return bitmap;
        }

        public final void Nb() {
        }

        public final void H(String str, boolean z) {
        }

        public final void a(com.tencent.mm.platformtools.i.a aVar, String str) {
        }

        public final Bitmap Na() {
            if (aa.getContext() == null) {
                return null;
            }
            return BitmapFactory.decodeResource(aa.getContext().getResources(), 2130838791);
        }
    }

    private final class b {
        int Rg = ProductUI.u(this.izN);
        final /* synthetic */ ProductUI izN;
        ProductScrollView izT = ((ProductScrollView) this.izN.findViewById(2131758585));
        boolean izU;
        private com.tencent.mm.plugin.scanner.ui.ProductScrollView.a izV = new com.tencent.mm.plugin.scanner.ui.ProductScrollView.a(this) {
            final /* synthetic */ b izW;

            {
                this.izW = r1;
            }

            public final void aks() {
                float f = 1.0f;
                b bVar = this.izW;
                int scrollY = bVar.izT.getScrollY();
                float x = scrollY < 0 ? -1.0f : (scrollY >= bVar.izN.izy - bVar.Rg || ((float) bVar.izN.izy) == 0.0f) ? 1.0f : (((float) scrollY) * 1.37f) / ((float) bVar.izN.izy);
                v.v("MicroMsg.ProductUI.HeaderEffectHelper", "rate=" + x);
                if (x != 1.0f) {
                    bVar.izU = false;
                } else if (!bVar.izU) {
                    bVar.izU = true;
                } else {
                    return;
                }
                if (bVar.izN.izt != null) {
                    float f2 = (1.0f - x) - 0.2f;
                    if (f2 <= 0.0f) {
                        f2 = 0.0f;
                    }
                    if (x == 0.0f) {
                        f2 = 1.0f;
                    }
                    ProductUI.i(bVar.izN.izt, f2);
                }
                if (bVar.izN.izw != null) {
                    if (x == 0.0f) {
                        f = 0.0f;
                    } else if (x >= 0.0f) {
                        x += 0.2f;
                        if (x <= 1.0f) {
                            f = x;
                        }
                    }
                    ProductUI.i(bVar.izN.izw, f);
                }
            }
        };

        public b(ProductUI productUI) {
            this.izN = productUI;
        }
    }

    static /* synthetic */ void b(ProductUI productUI, com.tencent.mm.plugin.scanner.b.n.a aVar) {
        if (aVar == null || be.kS(aVar.field_thumburl)) {
            v.e("MicroMsg.scanner.ProductUI", "product == null || Util.isNullOrNil(product.field_thumburl)");
            return;
        }
        try {
            productUI.izo.setBackgroundColor(Color.parseColor(aVar.field_headermask));
            if (!be.kS(aVar.field_headermask) && aVar.field_headermask.length() == 9) {
                productUI.izw.setBackgroundColor(Color.parseColor("#" + aVar.field_headermask.substring(3, 9)));
            }
        } catch (Exception e) {
            v.w("MicroMsg.scanner.ProductUI", "parse maskColor wrong");
        }
        v.e("MicroMsg.scanner.ProductUI", "begin to get the url " + aVar.field_thumburl);
        Bitmap a = j.a(productUI.izz);
        if (a != null) {
            productUI.izm.setImageBitmap(a);
            productUI.izm.setBackgroundDrawable(null);
            productUI.izm.setBackgroundColor(-1);
            productUI.izA = true;
            productUI.aLA();
        } else {
            productUI.izm.setImageBitmap(null);
        }
        if (!be.kS(aVar.field_headerbackgroundurl)) {
            a = j.a(new o(aVar.field_headerbackgroundurl));
            if (a != null && !a.isRecycled()) {
                productUI.izn.setImageBitmap(a);
            }
        }
    }

    static /* synthetic */ void j(ProductUI productUI) {
        if (productUI.izv == null) {
            return;
        }
        if (!be.kS(productUI.izv.field_detailurl)) {
            productUI.Z(10000, productUI.izv.field_detailurl);
            productUI.yV(productUI.izv.field_detailurl);
        } else if (!be.kS(productUI.izv.field_xml) && productUI.izE) {
            productUI.Z(10001, "");
            Intent intent = new Intent();
            intent.setClass(productUI, ProductFurtherInfoUI.class);
            intent.putExtra("key_Product_xml", productUI.izv.field_xml);
            intent.putExtra("key_title", productUI.izF);
            productUI.startActivity(intent);
        }
    }

    static /* synthetic */ void l(ProductUI productUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(productUI.getString(2131236668));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(productUI.getString(2131236667));
        linkedList2.add(Integer.valueOf(1));
        if (!productUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            linkedList.add(productUI.getString(2131234180));
            linkedList2.add(Integer.valueOf(2));
        } else if (productUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true)) {
            str = productUI.getString(2131231020);
            linkedList.add(productUI.getString(2131232639));
            linkedList2.add(Integer.valueOf(3));
        } else {
            str = "";
        }
        if (!(productUI.izv == null || TextUtils.isEmpty(productUI.izv.field_exposeurl))) {
            linkedList.add(productUI.getString(2131232028));
            linkedList2.add(Integer.valueOf(4));
        }
        g.a(productUI, "", linkedList, linkedList2, str, false, new g.d(productUI) {
            final /* synthetic */ ProductUI izN;

            {
                this.izN = r1;
            }

            public final void bw(int i, int i2) {
                if (this.izN.izv != null) {
                    Intent intent;
                    switch (i2) {
                        case -1:
                            g.a(this.izN.nDR.nEl, this.izN.nDR.nEl.getString(2131231021), null, null, this.izN.nDR.nEl.getString(2131231020), new g.d(this) {
                                final /* synthetic */ AnonymousClass6 izP;

                                {
                                    this.izP = r1;
                                }

                                public final void bw(int i, int i2) {
                                    switch (i2) {
                                        case -1:
                                            bm bmVar = new bm();
                                            bmVar.aYY.aZa = this.izP.izN.getIntent().getLongExtra("key_favorite_local_id", -1);
                                            com.tencent.mm.sdk.c.a.nhr.z(bmVar);
                                            v.d("MicroMsg.scanner.ProductUI", "do del fav product, local id %d, result %B", new Object[]{Long.valueOf(bmVar.aYY.aZa), Boolean.valueOf(bmVar.aYZ.aYN)});
                                            if (bmVar.aYZ.aYN) {
                                                this.izP.izN.finish();
                                                return;
                                            }
                                            return;
                                        default:
                                            v.d("MicroMsg.scanner.ProductUI", "do del cancel");
                                            return;
                                    }
                                }
                            });
                            return;
                        case 0:
                            com.tencent.mm.plugin.report.service.g.iuh.h(11446, new Object[]{this.izN.izv.field_productid, Integer.valueOf(2)});
                            intent = new Intent();
                            intent.putExtra("KContentObjDesc", this.izN.izv.field_subtitle);
                            intent.putExtra("Ksnsupload_title", this.izN.izv.field_title);
                            intent.putExtra("Ksnsupload_link", this.izN.izv.field_shareurl);
                            intent.putExtra("Ksnsupload_appname", com.tencent.mm.plugin.scanner.b.n.A(this.izN, this.izN.izv.field_type));
                            intent.putExtra("Ksnsupload_appid", com.tencent.mm.plugin.scanner.a.i.oV(this.izN.izv.field_functionType));
                            intent.putExtra("Ksnsupload_imgurl", this.izN.izv.field_thumburl);
                            v.i("MicroMsg.scanner.ProductUI", "product.field_thumburl : " + this.izN.izv.field_thumburl);
                            if (this.izN.izz != null) {
                                intent.putExtra("KsnsUpload_imgPath", this.izN.izz.MU());
                            } else {
                                v.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                            }
                            intent.putExtra("Ksnsupload_type", 3);
                            intent.putExtra("KUploadProduct_UserData", com.tencent.mm.plugin.scanner.b.n.c(this.izN.izv));
                            intent.putExtra("KUploadProduct_subType", this.izN.izv.field_type);
                            String fz = com.tencent.mm.model.o.fz("scan_product");
                            com.tencent.mm.model.o.yx().n(fz, true).l("prePublishId", "scan_product");
                            intent.putExtra("reportSessionId", fz);
                            com.tencent.mm.ay.c.b(this.izN, "sns", ".ui.SnsUploadUI", intent);
                            return;
                        case 1:
                            com.tencent.mm.plugin.report.service.g.iuh.h(11446, new Object[]{this.izN.izv.field_productid, Integer.valueOf(1)});
                            String a = com.tencent.mm.plugin.scanner.a.i.a(this.izN.nDR.nEl, this.izN.izv);
                            Intent intent2 = new Intent();
                            intent2.putExtra("Retr_Msg_content", a);
                            intent2.putExtra("Retr_Msg_Type", 2);
                            if (this.izN.izz != null) {
                                intent2.putExtra("Retr_Msg_thumb_path", this.izN.izz.MU());
                            } else {
                                v.e("MicroMsg.scanner.ProductUI", "imgGetStrategy is null");
                            }
                            intent2.putExtra("Retr_go_to_chattingUI", false);
                            intent2.putExtra("Retr_show_success_tips", true);
                            com.tencent.mm.plugin.scanner.a.drp.l(intent2, this.izN);
                            return;
                        case 2:
                            com.tencent.mm.plugin.report.service.g.iuh.h(11446, new Object[]{this.izN.izv.field_productid, Integer.valueOf(3)});
                            ProductUI.p(this.izN);
                            return;
                        case 3:
                            intent = new Intent();
                            intent.putExtra("key_fav_scene", 2);
                            intent.putExtra("key_fav_item_id", this.izN.getIntent().getLongExtra("key_favorite_local_id", -1));
                            com.tencent.mm.ay.c.b(this.izN.nDR.nEl, "favorite", ".ui.FavTagEditUI", intent);
                            return;
                        case 4:
                            intent = new Intent();
                            intent.putExtra("rawUrl", this.izN.izv.field_exposeurl);
                            com.tencent.mm.ay.c.b(this.izN.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }

    static /* synthetic */ void p(ProductUI productUI) {
        if (productUI.izv == null) {
            v.w("MicroMsg.scanner.ProductUI", "do favorite, but product is null");
            return;
        }
        bp bpVar = new bp();
        qf qfVar = new qf();
        qg qgVar = new qg();
        qe qeVar = new qe();
        qgVar.Jn(com.tencent.mm.model.k.xF());
        qgVar.Jo(com.tencent.mm.model.k.xF());
        qgVar.uN(8);
        qgVar.dV(be.Ni());
        qgVar.Jt(com.tencent.mm.plugin.scanner.a.i.oV(productUI.izv.field_functionType));
        qeVar.Jg(productUI.izv.field_title);
        qeVar.Jh(productUI.izv.field_subtitle);
        qeVar.uK(productUI.izv.field_type);
        qeVar.Jj(com.tencent.mm.plugin.scanner.b.n.c(productUI.izv));
        qeVar.Ji(productUI.izv.field_thumburl);
        bpVar.aZd.title = productUI.izv.field_title;
        bpVar.aZd.desc = productUI.izv.field_subtitle;
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 10;
        qfVar.a(qgVar);
        qfVar.b(qeVar);
        bpVar.aZd.aZl = 11;
        bpVar.aZd.aXH = productUI;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    static /* synthetic */ int u(ProductUI productUI) {
        TypedValue typedValue = new TypedValue();
        return productUI.getTheme().resolveAttribute(2130772045, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, productUI.getResources().getDisplayMetrics()) : 0;
    }

    protected final int getLayoutId() {
        return 2130904174;
    }

    public final int Oo() {
        return 2131099706;
    }

    public final int YA() {
        return 2130904181;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = be.Nh();
        this.cVh = getIntent().getIntExtra("key_ProductUI_getProductInfoScene", 0);
        j.b(this);
        ak.yU().a("scanproductinfo", this.izK, true);
        NI();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(1063, this);
        ak.vy().a(1068, this);
    }

    protected void onPause() {
        ak.vy().b(1063, this);
        ak.vy().b(1068, this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c(this);
        ak.yU().b("scanproductinfo", this.izK, true);
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        if (this.bYe != null) {
            this.bYe.c(this.bYl);
        }
        Z(10100, (be.Nh() - this.mStartTime));
        super.onDestroy();
    }

    protected final void NI() {
        View customView;
        vD(2131234781);
        this.dxf = this.ocZ;
        if (cU().cV() != null) {
            cU().cV().setBackgroundDrawable(null);
            customView = cU().cV().getCustomView();
        } else {
            customView = null;
        }
        if (customView != null) {
            customView = customView.findViewById(2131755264);
            if (customView != null) {
                customView.setBackgroundColor(-1);
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProductUI izN;

            {
                this.izN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.izN.cVh == 4) {
                    this.izN.setResult(0);
                }
                this.izN.finish();
                return true;
            }
        });
        this.dtB = (TextView) findViewById(2131758602);
        this.izn = (ImageView) findViewById(2131758594);
        this.izo = findViewById(2131758595);
        this.izq = (ImageView) findViewById(2131758604);
        this.izw = findViewById(2131758587);
        this.izt = (LinearLayout) findViewById(2131758596);
        this.izu = (ImageView) findViewById(2131758607);
        this.izr = findViewById(2131758603);
        i(this.izw, 0.0f);
        if (com.tencent.mm.bd.a.dt(this.nDR.nEl)) {
            this.dtB.setTextSize(0, ((float) this.nDR.nEl.getResources().getDimensionPixelSize(2131493025)) * 1.25f);
        } else {
            this.dtB.setTextSize(0, (float) com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493025));
        }
        this.izp = (TextView) findViewById(2131758605);
        this.izs = (TextView) findViewById(2131758586);
        this.izB = new HashMap();
        this.izC = new com.tencent.mm.plugin.scanner.ui.e.a(this) {
            final /* synthetic */ ProductUI izN;

            {
                this.izN = r1;
            }

            public final void a(String str, Boolean bool) {
                if (str != null && str.length() > 0) {
                    this.izN.izB.put(str, bool);
                }
            }

            public final Boolean yQ(String str) {
                if (str == null || str.length() <= 0) {
                    return null;
                }
                return (Boolean) this.izN.izB.get(str);
            }

            public final void aLy() {
                if (this.izN.dxf != null) {
                    this.izN.dxf.notifyDataSetChanged();
                }
            }
        };
        this.izJ = new com.tencent.mm.plugin.scanner.history.a.a();
        this.izJ.field_ScanTime = System.currentTimeMillis();
        this.izJ.field_scene = this.cVh;
        String stringExtra;
        String yT;
        if (this.cVh == 5) {
            this.izG = true;
            stringExtra = getIntent().getStringExtra("key_Qrcode_Url");
            yT = yT(stringExtra);
            this.izJ.field_qrcodeUrl = stringExtra;
            this.izJ.field_productId = yT;
            k(yT, stringExtra, false);
        } else if (this.cVh == 4) {
            stringExtra = getIntent().getStringExtra("key_product_id");
            yT = getIntent().getStringExtra("key_Qrcode_Url");
            if (be.kS(stringExtra)) {
                v.e("MicroMsg.scanner.ProductUI", "jsapi jump finish productId null");
                finish();
                return;
            }
            k(stringExtra, yT, false);
        } else {
            this.izI = getIntent().getBooleanExtra("key_is_from_barcode", false);
            this.izG = getIntent().getBooleanExtra("key_need_add_to_history", false);
            stringExtra = getIntent().getStringExtra("key_Product_xml");
            if (be.kS(stringExtra)) {
                stringExtra = getIntent().getStringExtra("key_Product_ID");
                if (be.kS(stringExtra)) {
                    v.e("MicroMsg.scanner.ProductUI", "normal finish productId null");
                    finish();
                    return;
                }
                k(stringExtra, null, false);
            } else {
                int intExtra = getIntent().getIntExtra("key_Product_funcType", 0);
                this.izv = com.tencent.mm.plugin.scanner.a.i.aN(stringExtra, intExtra);
                if (this.izv == null) {
                    v.e("MicroMsg.scanner.ProductUI", "initView(), product == null");
                    finish();
                    return;
                }
                this.fdU = this.izv.field_productid;
                this.izD = this.izv.field_extinfo;
                if (!this.izG || TextUtils.isEmpty(this.fdU)) {
                    v.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.izG + " mProductId:" + this.fdU);
                } else {
                    this.izJ.field_xmlContent = stringExtra;
                    this.izJ.field_qrcodeUrl = this.izD;
                    this.izJ.field_productId = this.fdU;
                    this.izJ.field_funcType = intExtra;
                    aLF();
                }
                com.tencent.mm.plugin.scanner.b.n.a aVar = this.izv;
                getIntent().getBooleanExtra("key_ProductUI_addToDB", true);
                a(aVar);
                if (intExtra != 0 || be.kS(this.izv.field_productid)) {
                    aLE();
                } else {
                    k(this.izv.field_productid, this.izv.field_extinfo, true);
                }
            }
        }
        findViewById(2131758592).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI izN;

            {
                this.izN = r1;
            }

            public final void onClick(View view) {
                ProductUI.j(this.izN);
            }
        });
        findViewById(2131758606).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI izN;

            {
                this.izN = r1;
            }

            public final void onClick(View view) {
                ProductUI.j(this.izN);
            }
        });
        this.izr.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProductUI izN;

            {
                this.izN = r1;
            }

            public final void onClick(View view) {
                if (this.izN.izv != null && !be.kS(this.izN.izv.field_certificationurl)) {
                    this.izN.Z(10002, this.izN.izv.field_certificationurl);
                    this.izN.yV(this.izN.izv.field_certificationurl);
                }
            }
        });
        b bVar = new b(this);
    }

    private void a(final com.tencent.mm.plugin.scanner.b.n.a aVar) {
        if (aVar == null) {
            v.e("MicroMsg.scanner.ProductUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        if (!be.kS(aVar.field_thumburl)) {
            this.izz = new a(aVar);
        }
        this.izy = this.nDR.nEl.getResources().getDimensionPixelSize(2131493547);
        if (this.izv != null && (this.izv.field_type == 1 || this.izv.field_type == 2)) {
            this.izy = this.nDR.nEl.getResources().getDimensionPixelSize(2131493548);
            LayoutParams layoutParams = this.izn.getLayoutParams();
            layoutParams.height = this.izy;
            this.izn.setLayoutParams(layoutParams);
            layoutParams = this.izo.getLayoutParams();
            layoutParams.height = this.izy;
            this.izt.setLayoutParams(layoutParams);
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131758593);
            LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
            layoutParams2.height = this.izy;
            relativeLayout.setLayoutParams(layoutParams2);
            layoutParams = this.izt.getLayoutParams();
            layoutParams.height = this.izy;
            this.izt.setLayoutParams(layoutParams);
        }
        if (be.kS(aVar.field_introtitle) || be.kS(aVar.field_introlink)) {
            this.izs.setVisibility(8);
        } else {
            this.izs.setText(aVar.field_introtitle);
            this.izs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProductUI izN;

                public final void onClick(View view) {
                    this.izN.Z(10003, aVar.field_introlink);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aVar.field_introlink);
                    intent.putExtra("geta8key_scene", this.izN.aLC());
                    com.tencent.mm.ay.c.b(this.izN.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            this.izs.setVisibility(0);
        }
        this.izx = this.izv.field_functionType;
        if (aVar.field_xmlType == 3) {
            this.dtB.setText(aVar.field_title);
            if (be.kS(aVar.field_certification)) {
                this.izp.setText(aVar.field_source);
                this.izq.setVisibility(8);
                this.izr.setOnClickListener(null);
                this.izr.setBackgroundDrawable(null);
                this.izr.setFocusable(false);
            } else {
                this.izp.setText(aVar.field_certification);
                this.izq.setVisibility(0);
            }
            if (aVar.field_type == 1 || aVar.field_type == 2) {
                this.izm = (ImageView) findViewById(2131758598);
                findViewById(2131758598).setVisibility(0);
                findViewById(2131758599).setVisibility(8);
            } else {
                this.izm = (ImageView) findViewById(2131758599);
                findViewById(2131758599).setVisibility(0);
                findViewById(2131758598).setVisibility(8);
            }
            if (!be.kS(aVar.field_playurl)) {
                ImageView imageView = (ImageView) findViewById(2131758600);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ProductUI izN;

                    public final void onClick(View view) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.parse(aVar.field_playurl), "video/*");
                        this.izN.startActivity(intent);
                    }
                });
            }
            a(0, 2130838681, new OnMenuItemClickListener(this) {
                final /* synthetic */ ProductUI izN;

                {
                    this.izN = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    ProductUI.l(this.izN);
                    return true;
                }
            });
        } else if (aVar.field_xmlType == 4) {
            this.izm = (ImageView) findViewById(2131758599);
            findViewById(2131758599).setVisibility(0);
            findViewById(2131758598).setVisibility(8);
            this.izm.setImageResource(2131165886);
            this.izm.setBackgroundResource(2131165886);
            this.dtB.setText(2131234758);
            this.izp.setText(null);
        }
        v.v("MicroMsg.scanner.ProductUI", "start postToMainThread initBodyView");
        ad.o(new Runnable(this) {
            final /* synthetic */ ProductUI izN;

            public final void run() {
                this.izN.b(aVar);
                ProductUI.b(this.izN, aVar);
            }
        });
    }

    private void aLA() {
        this.bao = getIntent().getLongExtra("key_ProductUI_chatting_msgId", 0);
        if (this.bao > 0 && ak.uz()) {
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek(this.bao);
            if (ek.field_msgId > 0) {
                ek.cI(this.izz.MU());
                ak.yW();
                com.tencent.mm.model.c.wJ().a(this.bao, ek);
            }
        }
    }

    private void b(com.tencent.mm.plugin.scanner.b.n.a aVar) {
        if (aVar != null && aVar.iEd != null && aVar.iEd.size() != 0 && this.dxf != null) {
            this.dxf.removeAll();
            for (int i = 0; i < aVar.iEd.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a) aVar.iEd.get(i);
                if (!(aVar2 == null || aVar2.cZq == null || aVar2.cZq.size() == 0 || aVar2.ivF == 1 || !aVar2.ivH)) {
                    if (i != 0) {
                        Preference preference = new Preference(this);
                        preference.setLayoutResource(2130904172);
                        this.dxf.a(preference);
                    }
                    if (!be.kS(aVar2.title) && (aVar2.type == 6 || aVar2.type == 7)) {
                        CategoryWithTitlePreference categoryWithTitlePreference = new CategoryWithTitlePreference(this);
                        categoryWithTitlePreference.setTitle(aVar2.title);
                        this.dxf.a(categoryWithTitlePreference);
                    }
                    int i2;
                    com.tencent.mm.plugin.scanner.a.a.a aVar3;
                    if (aVar2.type == 6) {
                        List arrayList = new ArrayList();
                        for (i2 = 0; i2 < aVar2.cZq.size(); i2++) {
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.cZq.get(i2);
                            if (aVar3.type == 10) {
                                arrayList.add(aVar3);
                            }
                        }
                        if (arrayList.size() > 0) {
                            h hVar = new h(this);
                            hVar.setKey((i * 100));
                            hVar.hRB = arrayList;
                            this.dxf.a(hVar);
                        }
                    } else {
                        i2 = 0;
                        while (i2 < aVar2.cZq.size()) {
                            String str = ((i * 100) + i2);
                            aVar3 = (com.tencent.mm.plugin.scanner.a.a.a) aVar2.cZq.get(i2);
                            if (aVar3.type == 11) {
                                this.izE = true;
                                this.izF = aVar3.name;
                            }
                            if (aVar3.aXx != 2) {
                                if (aVar3.aXx != 1) {
                                    if (aVar3.type == 5) {
                                        MusicPreference musicPreference = new MusicPreference(this);
                                        musicPreference.setKey(str);
                                        musicPreference.setTitle(aVar3.name);
                                        musicPreference.ivK = aVar3.ivK;
                                        musicPreference.ivL = aVar3.ivL;
                                        musicPreference.ivM = aVar3.ivM;
                                        if (yS(String.format("%s_cd_%s", new Object[]{aVar3.ivK, str}))) {
                                            musicPreference.fi(true);
                                        } else {
                                            musicPreference.fi(false);
                                        }
                                        musicPreference.iyS = this.izL;
                                        this.dxf.a(musicPreference);
                                        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
                                        if (this.hCP == null) {
                                            this.hCP = new ArrayList();
                                        }
                                        if (this.izM) {
                                            this.hCP.add(musicPreference);
                                        }
                                    } else if (aVar3.type == 6) {
                                        e eVar = new e(this);
                                        eVar.setKey(str);
                                        eVar.mTitle = aVar3.name;
                                        eVar.setSummary(aVar3.desc);
                                        this.dxf.a(eVar);
                                        eVar.iyG = this.izC;
                                    } else if (aVar3.type == 12) {
                                        f fVar = new f(this);
                                        fVar.setKey(str);
                                        fVar.ffl = aVar3.thumburl;
                                        fVar.dxf = this.dxf;
                                        this.dxf.a(fVar);
                                    } else if (aVar3.type == 2) {
                                        CharSequence charSequence = yU(aVar3.username) ? aVar3.ivS : aVar3.ivR;
                                        a aVar4 = new a(this);
                                        aVar4.setKey(str);
                                        aVar4.setTitle(charSequence);
                                        aVar4.setSummary(aVar3.desc);
                                        aVar4.ixe = aVar3.cqK;
                                        this.dxf.a(aVar4);
                                    } else if (aVar3.type == 22) {
                                        d dVar = new d(this);
                                        dVar.setKey(str);
                                        if (!be.kS(aVar3.cID)) {
                                            dVar.iyu = aVar3.cID + ":";
                                        }
                                        dVar.gjc = aVar3.content;
                                        dVar.iyt = aVar3.thumburl;
                                        this.dxf.a(dVar);
                                    } else {
                                        a aVar5 = new a(this);
                                        aVar5.setKey(str);
                                        aVar5.setTitle(aVar3.name);
                                        aVar5.setSummary(aVar3.desc);
                                        aVar5.ixe = aVar3.cqK;
                                        aVar5.fyK = aVar3.iconUrl;
                                        this.dxf.a(aVar5);
                                    }
                                    if (!(i2 >= aVar2.cZq.size() - 1 || aVar3.type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.cZq.get(i2 + 1)).type == 12 || ((com.tencent.mm.plugin.scanner.a.a.a) aVar2.cZq.get(i2 + 1)).aXx == 1 || !a(i2, aVar2.cZq))) {
                                        this.dxf.a(new g(this));
                                    }
                                } else if (!be.kS(aVar3.ivI)) {
                                    b bVar = new b(this);
                                    bVar.setKey(str);
                                    bVar.ffl = aVar3.ivI;
                                    bVar.dxf = this.dxf;
                                    this.dxf.a(bVar);
                                }
                            }
                            i2++;
                        }
                    }
                }
            }
            this.dxf.notifyDataSetChanged();
            v.d("MicroMsg.scanner.ProductUI", "initBodyView finish");
            if (this.hCP != null) {
                this.izM = false;
            }
        }
    }

    private static boolean a(int i, LinkedList<com.tencent.mm.plugin.scanner.a.a.a> linkedList) {
        if (linkedList != null) {
            for (int i2 = i + 1; i2 < linkedList.size(); i2++) {
                if (((com.tencent.mm.plugin.scanner.a.a.a) linkedList.get(i2)).aXx != 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void aLB() {
        if (this.izv != null && this.izv.iEd != null && this.izv.iEd.size() != 0 && this.dxf != null) {
            for (int i = 0; i < this.izv.iEd.size(); i++) {
                com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.izv.iEd.get(i);
                if (!(aVar == null || aVar.cZq == null || aVar.cZq.size() == 0)) {
                    for (int i2 = 0; i2 < aVar.cZq.size(); i2++) {
                        if (((com.tencent.mm.plugin.scanner.a.a.a) aVar.cZq.get(i2)).type == 5) {
                            MusicPreference musicPreference = (MusicPreference) this.dxf.Ow(((i * 100) + i2));
                            if (musicPreference != null) {
                                if (yS(String.format("%s_cd_%s", new Object[]{r1.ivK, r6}))) {
                                    musicPreference.fi(true);
                                } else {
                                    musicPreference.fi(false);
                                }
                            }
                        }
                    }
                }
            }
            this.dxf.notifyDataSetChanged();
        }
    }

    public final boolean a(f fVar, Preference preference) {
        v.i("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.dnU});
        if (this.izv == null || this.izv.iEd == null) {
            v.e("MicroMsg.scanner.ProductUI", "product == null || product.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.dnU).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            v.v("MicroMsg.scanner.ProductUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.izv.iEd.size()) {
                v.w("MicroMsg.scanner.ProductUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.izv.iEd.size())});
                return false;
            }
            com.tencent.mm.plugin.scanner.a.a aVar = (com.tencent.mm.plugin.scanner.a.a) this.izv.iEd.get(i);
            if (aVar == null) {
                v.w("MicroMsg.scanner.ProductUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.cZq.size()) {
                v.w("MicroMsg.scanner.ProductUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.cZq.size())});
                return false;
            } else {
                com.tencent.mm.plugin.scanner.a.a.a aVar2 = (com.tencent.mm.plugin.scanner.a.a.a) aVar.cZq.get(i2);
                if (aVar2 == null) {
                    v.w("MicroMsg.scanner.ProductUI", "action == null");
                    return false;
                }
                v.i("MicroMsg.scanner.ProductUI", "action.type = [%s]", new Object[]{Integer.valueOf(aVar2.type)});
                String str = null;
                Intent intent = new Intent();
                switch (aVar2.type) {
                    case 1:
                    case 3:
                    case com.tencent.mm.plugin.appbrand.jsapi.bf.CTRL_INDEX /*22*/:
                        str = aVar2.cZp;
                        if (!be.kS(aVar2.cZp)) {
                            yV(aVar2.cZp);
                            break;
                        }
                        break;
                    case 2:
                    case 4:
                        str = aVar2.username;
                        if (!be.kS(aVar2.username)) {
                            Object obj = aVar2.username;
                            Intent intent2;
                            if (!yU(obj)) {
                                if (!TextUtils.isEmpty(obj)) {
                                    intent2 = new Intent();
                                    intent2.putExtra("Contact_User", obj);
                                    intent2.putExtra("force_get_contact", true);
                                    intent2.putExtra("Contact_Scene", aLD());
                                    com.tencent.mm.plugin.scanner.a.drp.d(intent2, this);
                                    break;
                                }
                                v.v("MicroMsg.scanner.ProductUI", "username is null");
                                break;
                            }
                            intent2 = new Intent();
                            intent2.putExtra("Chat_User", obj);
                            intent2.putExtra("finish_direct", true);
                            intent2.putExtra("add_scene", aLD());
                            com.tencent.mm.plugin.scanner.a.drp.e(intent2, this.nDR.nEl);
                            break;
                        }
                        break;
                    case 5:
                        str = aVar2.ivM;
                        intent.putExtra("rawUrl", aVar2.ivM);
                        intent.putExtra("geta8key_scene", aLC());
                        com.tencent.mm.plugin.scanner.a.drp.j(intent, this);
                        com.tencent.mm.ai.b.HB();
                        aLB();
                        break;
                    case 6:
                    case 7:
                    case 10:
                        break;
                    case 8:
                        str = aVar2.ivO;
                        intent.putExtra("key_card_id", aVar2.ivQ);
                        intent.putExtra("key_card_ext", aVar2.ivP);
                        intent.putExtra("key_from_scene", 9);
                        com.tencent.mm.ay.c.b(this, "card", ".ui.CardDetailUI", intent);
                        break;
                    case 9:
                        str = aVar2.ivO;
                        if (!be.kS(aVar2.ivO)) {
                            intent.putExtra("key_product_id", aVar2.ivO);
                            intent.putExtra("key_product_scene", 12);
                            com.tencent.mm.ay.c.b(this, "product", ".ui.MallProductUI", intent);
                            break;
                        }
                        break;
                    case 11:
                        intent.setClass(this, ProductFurtherInfoUI.class);
                        intent.putExtra("key_Product_xml", this.izv.field_xml);
                        intent.putExtra("key_title", aVar2.name);
                        startActivity(intent);
                        break;
                    case 12:
                        str = aVar2.cZp;
                        if (!be.kS(aVar2.cZp)) {
                            yV(aVar2.cZp);
                            break;
                        }
                        break;
                    case 21:
                        str = aVar2.ivG;
                        intent.setClass(this, ProductPurchaseAreaUI.class);
                        intent.putExtra("key_Product_xml", this.izv.field_xml);
                        intent.putExtra("referkey", aVar2.ivG);
                        intent.putExtra("key_Product_funcType", this.izx);
                        startActivity(intent);
                        break;
                    default:
                        v.d("MicroMsg.scanner.ProductUI", "Default go url:" + aVar2.cZp);
                        if (!be.kS(aVar2.cZp)) {
                            yV(aVar2.cZp);
                            break;
                        }
                        break;
                }
                ak.vy().a(new h(this.izv.field_productid, aVar2.ivN, aVar2.type, str, aVar.cZq.size(), aVar2.aXx), 0);
                return true;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.scanner.ProductUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            v.a("MicroMsg.scanner.ProductUI", e, "", new Object[0]);
            return false;
        }
    }

    private static boolean yS(String str) {
        ajr HE = com.tencent.mm.ai.b.HE();
        if (HE != null && HE.mJV == 5 && str.equals(HE.mJW) && com.tencent.mm.ai.b.HC()) {
            return true;
        }
        return false;
    }

    private void Z(int i, String str) {
        if (this.izv != null) {
            ak.vy().a(new h(this.izv.field_productid, "", i, str, 0, 0), 0);
        }
    }

    public final void k(final String str, final Bitmap bitmap) {
        if (!be.kS(str) && this.izv != null && bitmap != null && !bitmap.isRecycled()) {
            v.d("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
            ad.o(new Runnable(this) {
                final /* synthetic */ ProductUI izN;

                public final void run() {
                    if (str.equals(this.izN.izv.field_thumburl) && this.izN.izm != null) {
                        v.i("MicroMsg.scanner.ProductUI", "onGetPictureFinish: notifyKey=" + str);
                        try {
                            this.izN.izm.setImageBitmap(bitmap);
                            this.izN.izm.setBackgroundDrawable(null);
                            this.izN.izm.setBackgroundColor(-1);
                            this.izN.aLA();
                            this.izN.izA = true;
                        } catch (Exception e) {
                            v.e("MicroMsg.scanner.ProductUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                        }
                    }
                    if (str.equals(this.izN.izv.field_headerbackgroundurl) && this.izN.izn != null) {
                        this.izN.izn.setImageBitmap(bitmap);
                    }
                }
            });
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar == null) {
            v.w("MicroMsg.scanner.ProductUI", "scene == null");
        } else if (kVar.getType() == 1063) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.scanner.a.d dVar = (com.tencent.mm.plugin.scanner.a.d) kVar;
                hg hgVar = (dVar.cif == null || dVar.cif.czl.czs == null) ? null : (hg) dVar.cif.czl.czs;
                if (hgVar == null) {
                    v.w("MicroMsg.scanner.ProductUI", "onSceneEnd productInfo == null");
                    return;
                } else if (hgVar.mib != null) {
                    v.d("MicroMsg.scanner.ProductUI", "onSceneEnd  productInfo.DescXML != null");
                    com.tencent.mm.plugin.scanner.b.n.a aN = com.tencent.mm.plugin.scanner.a.i.aN(hgVar.mib, this.izx);
                    if (this.izv != null && this.izv.field_xml != null && aN != null && aN.field_xml != null && !this.izv.field_xml.equals(aN.field_xml)) {
                        this.izv = aN;
                        a(this.izv);
                    } else if (!(aN == null || aN.field_xml == null)) {
                        this.izv = aN;
                        a(this.izv);
                    }
                    if (this.dwR != null && this.dwR.isShowing()) {
                        this.dwR.dismiss();
                    }
                    aLE();
                    if (!this.izG || this.izH || TextUtils.isEmpty(this.fdU)) {
                        v.i("MicroMsg.scanner.ProductUI", "shouldAddToHistory:" + this.izG + " mProductId:" + this.fdU + "  hasAddToHistory:" + this.izH);
                        return;
                    }
                    this.izJ.field_xmlContent = hgVar.mib;
                    this.izJ.field_funcType = this.izx;
                    aLF();
                    return;
                } else {
                    return;
                }
            }
            v.e("MicroMsg.scanner.ProductUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar.getType() == 1068 && i == 0 && i2 == 0) {
            List list = ((he) ((com.tencent.mm.plugin.scanner.a.c) kVar).cif.czl.czs).mia;
            if (this.izv != null && k.a(this.izv.iEd, k.bh(list))) {
                b(this.izv);
            }
        }
    }

    private static String yT(String str) {
        String str2 = null;
        if (!be.kS(str)) {
            try {
                str2 = Uri.parse(str).getQueryParameter("p");
            } catch (Exception e) {
                v.w("MicroMsg.scanner.ProductUI", str + ";" + e.getLocalizedMessage());
            }
        }
        return str2;
    }

    private void k(String str, String str2, boolean z) {
        this.fdU = str;
        this.izD = str2;
        final com.tencent.mm.plugin.scanner.a.d dVar = new com.tencent.mm.plugin.scanner.a.d(str, this.cVh, str2);
        ak.vy().a(dVar, 0);
        if (!z) {
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            getString(2131231164);
            this.dwR = g.a(actionBarActivity, getString(2131234767), new OnCancelListener(this) {
                final /* synthetic */ ProductUI izN;

                public final void onCancel(DialogInterface dialogInterface) {
                    v.d("MicroMsg.scanner.ProductUI", "User cancel");
                    ak.vy().c(dVar);
                }
            });
        }
    }

    private static boolean yU(String str) {
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || ((int) LX.chr) <= 0 || !com.tencent.mm.i.a.ei(LX.field_type)) {
            return false;
        }
        return true;
    }

    private int aLC() {
        if (this.izx == 4) {
            return 11;
        }
        if (this.izx == 3) {
            return 12;
        }
        return 0;
    }

    private void yV(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("jsapi_args_appid", com.tencent.mm.plugin.scanner.a.i.oV(this.izx));
        intent.putExtra("jsapiargs", bundle);
        intent.putExtra("rawUrl", str);
        intent.putExtra("pay_channel", 3);
        intent.putExtra("geta8key_scene", aLC());
        com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
    }

    private int aLD() {
        if (this.izx == 3) {
            return 47;
        }
        return 49;
    }

    private void aLE() {
        if (this.izv != null) {
            v.i("MicroMsg.scanner.ProductUI", "doUpdateActionLogic, flag=:" + this.izv.field_getaction);
            if ((this.izv.field_getaction & 2) > 0) {
                this.bYe = c.FY();
                if (this.bYe != null) {
                    this.bYe.b(this.bYl);
                }
            } else if ((this.izv.field_getaction & 1) > 0) {
                ak.vy().a(new com.tencent.mm.plugin.scanner.a.c(this.fdU, k.bg(this.izv.iEd), this.cVh, this.izD, 0.0d, 0.0d), 0);
            }
        }
    }

    private static void i(View view, float f) {
        Animation alphaAnimation = new AlphaAnimation(f, f);
        alphaAnimation.setDuration(0);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    private void aLF() {
        if (com.tencent.mm.plugin.scanner.b.j.aLX()) {
            boolean a;
            com.tencent.mm.plugin.scanner.history.a.a aVar = new com.tencent.mm.plugin.scanner.history.a.a();
            aVar.field_productId = this.fdU;
            if (com.tencent.mm.plugin.scanner.b.aKQ().b(aVar, new String[0])) {
                a = com.tencent.mm.plugin.scanner.b.aKQ().a(this.izJ, new String[0]);
            } else {
                a = com.tencent.mm.plugin.scanner.b.aKQ().b(this.izJ);
            }
            if (a) {
                v.i("MicroMsg.scanner.ProductUI", "mHistoryItem insert success!");
                this.izH = true;
                return;
            }
            v.e("MicroMsg.scanner.ProductUI", "mHistoryItem insert fail!");
            return;
        }
        v.e("MicroMsg.scanner.ProductUI", "mHistoryItem ScanHistoryUtil.shouldShowHistoryList() is false!");
    }
}
