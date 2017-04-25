package com.tencent.mm.ui.chatting.gallery;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.support.v7.app.ActionBarActivity;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.as.n;
import com.tencent.mm.as.p;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.ai;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.w;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(3)
public class ImageGalleryUI extends MMActivity implements OnClickListener, com.tencent.mm.sdk.platformtools.ah.a {
    public long bao;
    protected String bdo;
    protected String biB;
    private l eIV;
    Bundle eIW;
    private boolean eIX = false;
    g eIY;
    int eIZ = 0;
    int eJa = 0;
    int eJb = 0;
    int eJc = 0;
    public long ezh;
    private d fNB = new d(this) {
        final /* synthetic */ ImageGalleryUI oCl;

        {
            this.oCl = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            bx bGt;
            n lp;
            switch (menuItem.getItemId()) {
                case 0:
                    bGt = this.oCl.ozG.bGt();
                    if (bGt == null || !bGt.bwn()) {
                        this.oCl.ozG.xt(this.oCl.ggz.xB);
                        return;
                    }
                    lp = p.lp(bGt.field_imgPath);
                    if (lp.status == 199 || lp.status == 199) {
                        this.oCl.ozG.xt(this.oCl.ggz.xB);
                        return;
                    }
                    this.oCl.oBW = p.e(bGt.field_msgId, 1);
                    this.oCl.ozG.xy(this.oCl.ggz.xB);
                    return;
                case 1:
                    bGt = this.oCl.ozG.bGt();
                    if (bGt == null || !bGt.bwn()) {
                        List arrayList = new ArrayList();
                        arrayList.add(this.oCl.ozG.bGt());
                        b.daJ.v((at) arrayList.get(0));
                        b.c(this.oCl.nDR.nEl, arrayList);
                        return;
                    }
                    lp = p.lp(bGt.field_imgPath);
                    if (lp.status == 199 || lp.status == 199) {
                        List arrayList2 = new ArrayList();
                        arrayList2.add(this.oCl.ozG.bGt());
                        b.c(this.oCl.nDR.nEl, arrayList2);
                        return;
                    }
                    this.oCl.oBW = p.e(bGt.field_msgId, 2);
                    this.oCl.ozG.xy(this.oCl.ggz.xB);
                    return;
                case 2:
                    if (c.EH("favorite")) {
                        this.oCl.ozG.xv(this.oCl.ggz.xB);
                        return;
                    }
                    return;
                case 3:
                    v.i("MicroMsg.ImageGalleryUI", "request deal QBAR string");
                    bl blVar = new bl();
                    blVar.aYU.aXH = this.oCl;
                    blVar.aYU.aXG = this.oCl.jFv;
                    blVar.aYU.aYV = this.oCl.lla;
                    blVar.aYU.aYW = this.oCl.llb;
                    ImageGalleryUI.a(this.oCl, blVar);
                    com.tencent.mm.sdk.c.a.nhr.z(blVar);
                    return;
                case 4:
                    this.oCl.ozG.xu(this.oCl.ggz.xB);
                    return;
                case 5:
                    ImageGalleryUI.w(this.oCl);
                    return;
                default:
                    return;
            }
        }
    };
    protected MMViewPager ggz;
    private boolean hlh;
    private String jFs;
    private String jFv;
    private com.tencent.mm.sdk.c.c jFx = new com.tencent.mm.sdk.c.c<kv>(this) {
        final /* synthetic */ ImageGalleryUI oCl;

        {
            this.oCl = r2;
            this.nhz = kv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kv kvVar = (kv) bVar;
            if (this.oCl.eIV == null || this.oCl.jFs == null) {
                v.e("MicroMsg.ImageGalleryUI", "not in recoging");
            } else if (kvVar == null || !(kvVar instanceof kv)) {
                v.e("MicroMsg.ImageGalleryUI", "receive invalid callbak");
            } else if (kvVar == null || kvVar.bme.filePath.equals(this.oCl.jFs)) {
                v.i("MicroMsg.ImageGalleryUI", "recog result: " + kvVar.bme.bfz);
                if (!be.kS(kvVar.bme.bfz)) {
                    this.oCl.jFv = kvVar.bme.bfz;
                    this.oCl.lla = kvVar.bme.aYV;
                    this.oCl.llb = kvVar.bme.aYW;
                    this.oCl.jQ(false);
                }
                this.oCl.jFs = null;
            } else {
                v.e("MicroMsg.ImageGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jFy = new com.tencent.mm.sdk.c.c<ir>(this) {
        final /* synthetic */ ImageGalleryUI oCl;

        {
            this.oCl = r2;
            this.nhz = ir.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ir irVar = (ir) bVar;
            if (irVar != null && (irVar instanceof ir)) {
                v.i("MicroMsg.ImageGalleryUI", "notify Event: %d", Integer.valueOf(irVar.bjg.bje));
                if (irVar.bjg.aXH == this.oCl && irVar.bjg.aXG.equals(this.oCl.jFv)) {
                    switch (irVar.bjg.bje) {
                        case 0:
                        case 1:
                        case 2:
                            break;
                        case 3:
                            this.oCl.finish();
                            break;
                        default:
                            break;
                    }
                }
                v.e("MicroMsg.ImageGalleryUI", "not the same");
            } else {
                v.e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            }
            return false;
        }
    };
    private ImageView jKJ;
    int jMg;
    int jMh;
    int jMi = 0;
    private float jMj = 1.0f;
    private int jMk = 0;
    private int jMl = 0;
    public boolean lKa = false;
    private int lla;
    private int llb;
    private boolean lvx = true;
    private ac mHandler = new ac();
    private b.b oBC;
    private RelativeLayout oBD;
    private RelativeLayout oBE;
    private ImageView oBF;
    private RelativeLayout oBG;
    private View oBH;
    private FrameLayout oBI;
    View oBJ;
    Button oBK;
    Button oBL;
    View oBM;
    private View oBN;
    protected VideoPlayerSeekBar oBO;
    private MultiTouchImageView oBP;
    int oBQ = 0;
    int oBR = 0;
    ArrayList<Integer> oBS = new ArrayList();
    protected boolean oBT = false;
    protected boolean oBU = false;
    private boolean oBV;
    private String oBW = null;
    public a oBX;
    private View oBY;
    private CheckBox oBZ;
    private View oCa;
    private int oCb = 0;
    private e oCc = new e(this) {
        final /* synthetic */ ImageGalleryUI oCl;
        private boolean oCm = false;

        {
            this.oCl = r2;
        }

        public final void a(int i, float f, int i2) {
        }

        public final void W(int i) {
            if (this.oCl.ozG != null) {
                View wA = this.oCl.ozG.wA(i);
                if (wA == null) {
                    v.e("MicroMsg.ImageGalleryUI", "onPageSelected the view is null, position = %s ", Integer.valueOf(i));
                }
                ImageGalleryUI.p(this.oCl);
                this.oCl.oCb = i;
                if (this.oCl.ozG != null) {
                    this.oCl.ozG.bGv();
                    bx xs = this.oCl.ozG.xs(i);
                    if (!((!b.aH(xs) && !b.aK(xs)) || wA == null || wA.getTag() == null)) {
                        ((j) wA.getTag()).oDl.bCO();
                    }
                    if (xs != null) {
                        this.oCl.eE(xs.field_msgId);
                    }
                    if (this.oCl.ozG != null) {
                        com.tencent.mm.ae.d e = this.oCl.ozG.e(xs, false);
                        if (b.a(xs, e)) {
                            e = com.tencent.mm.ae.e.a(e);
                            int i2 = e.cyu;
                            v.d("MicroMsg.ImageGalleryUI", "jacks loading hd from imgInfo : %d, time: %d", Integer.valueOf(Math.max(1, (int) (i2 != 0 ? ((((long) e.offset) * 100) / ((long) i2)) - 1 : 0))), Long.valueOf(System.currentTimeMillis()));
                            this.oCl.xN(r0);
                        } else if (xs == null || xs.bwn() || !this.oCl.ozG.aM(xs)) {
                            this.oCl.dm(true);
                        } else {
                            this.oCl.dm(false);
                        }
                    } else {
                        v.e("MicroMsg.ImageGalleryUI", "[arthurdan.ImageGallery] Notice!!! adapter is null");
                    }
                    if (xs == null) {
                        v.e("MicroMsg.ImageGalleryUI", "update footer fail, msg is null, position = " + i);
                    } else {
                        this.oCl.ba(xs);
                        this.oCl.bGK();
                    }
                }
                if (this.oCl.ozG != null) {
                    this.oCl.ozG.W(i);
                }
            }
        }

        public final void X(int i) {
            v.d("MicroMsg.ImageGalleryUI", "onPageScrollStateChanged: %d", Integer.valueOf(i));
            if (i == 2) {
                this.oCm = true;
                this.oCl.bGX();
                this.oCl.bGT();
                this.oCl.bGU();
            }
            if (i == 0) {
                if (this.oCm) {
                    this.oCl.bGW();
                }
                this.oCm = false;
            }
            if (this.oCl.ozG != null) {
                b e = this.oCl.ozG;
                if (e.ozM != null) {
                    d dVar = e.ozM;
                    dVar.xe = i;
                    if (dVar.oBc != null) {
                        dVar.oBc.X(i);
                    }
                }
            }
        }
    };
    boolean oCd = false;
    ah oCe = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ ImageGalleryUI oCl;

        {
            this.oCl = r1;
        }

        public final boolean oU() {
            if (this.oCl.oCd) {
                this.oCl.bGO();
            }
            return false;
        }
    }, false);
    private HashMap<Long, String> oCf = new HashMap();
    private boolean oCg = false;
    private boolean oCh = false;
    private ah oCi;
    private boolean oCj = false;
    private boolean oCk = false;
    private boolean onc = false;
    protected boolean otW = false;
    private HashSet<Long> ovC = new HashSet();
    public b ozG;
    private final boolean ozQ = false;

    public interface a {
        void g(Boolean bool);
    }

    static /* synthetic */ void a(ImageGalleryUI imageGalleryUI, bl blVar) {
        int i;
        String str;
        int i2 = 2;
        v.i("MicroMsg.ImageGalleryUI", "talker: %s, chatroom: %s", imageGalleryUI.bdo, imageGalleryUI.biB);
        String str2 = SQLiteDatabase.KeyEmpty;
        if (!be.kS(imageGalleryUI.biB) && m.dE(imageGalleryUI.biB)) {
            v.d("MicroMsg.ImageGalleryUI", "is chatroom: %s", imageGalleryUI.biB);
            i = 2;
            str = imageGalleryUI.biB;
        } else if (be.kS(imageGalleryUI.bdo)) {
            v.e("MicroMsg.ImageGalleryUI", "unknow source");
            str = str2;
            i = -1;
        } else {
            if (m.eD(imageGalleryUI.bdo)) {
                v.d("MicroMsg.ImageGalleryUI", "is biz: %s", imageGalleryUI.bdo);
                i2 = 4;
            } else if (m.dE(imageGalleryUI.bdo)) {
                v.d("MicroMsg.ImageGalleryUI", "taler is chatroom: %s", imageGalleryUI.bdo);
            } else {
                v.d("MicroMsg.ImageGalleryUI", "is single chat: %s", imageGalleryUI.bdo);
                i2 = 1;
            }
            i = i2;
            str = imageGalleryUI.bdo;
        }
        blVar.aYU.aYX = i;
        blVar.aYU.aHM = str;
    }

    static /* synthetic */ void g(ImageGalleryUI imageGalleryUI) {
        v.i("MicroMsg.ImageGalleryUI", "%d handle single click event.", Integer.valueOf(imageGalleryUI.hashCode()));
        if (imageGalleryUI.bGL()) {
            try {
                if (imageGalleryUI.ozG.bGu().bHf().oDa.getVisibility() == 0) {
                    v.d("MicroMsg.ImageGalleryUI", "%d handle single click event, it is loading video, don't show toolbar", Integer.valueOf(imageGalleryUI.hashCode()));
                    return;
                }
            } catch (Exception e) {
            }
            if (imageGalleryUI.oCd) {
                imageGalleryUI.bGO();
                return;
            } else {
                imageGalleryUI.bGN();
                return;
            }
        }
        imageGalleryUI.onBackPressed();
    }

    static /* synthetic */ void l(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.bGL()) {
            try {
                if (imageGalleryUI.ozG.bGu().bHf().oCY.getVisibility() == 0) {
                    imageGalleryUI.ozG.bGu().bHf().oCY.setVisibility(8);
                    imageGalleryUI.oCg = true;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.oCd) {
            imageGalleryUI.bGO();
            imageGalleryUI.oCh = true;
        }
    }

    static /* synthetic */ void p(ImageGalleryUI imageGalleryUI) {
        final View a = imageGalleryUI.a(imageGalleryUI.ozG, imageGalleryUI.ggz);
        imageGalleryUI.ggz.nZp = new MMViewPager.b(imageGalleryUI) {
            final /* synthetic */ ImageGalleryUI oCl;

            public final void x(float f, float f2) {
                float f3 = 1.0f;
                float height = 1.0f - (f2 / ((float) this.oCl.ggz.getHeight()));
                if (height <= 1.0f) {
                    f3 = height;
                }
                this.oCl.jMj = f3;
                if (a != null) {
                    if (f == 0.0f && f2 == 0.0f) {
                        ImageGalleryUI.q(this.oCl);
                    } else {
                        ImageGalleryUI.l(this.oCl);
                    }
                    a.setPivotX((float) (this.oCl.ggz.getWidth() / 2));
                    a.setPivotY((float) (this.oCl.ggz.getHeight() / 2));
                    a.setScaleX(f3);
                    a.setScaleY(f3);
                    a.setTranslationX(f);
                    a.setTranslationY(f2);
                    this.oCl.jKJ.setAlpha(f3);
                    return;
                }
                v.d("MicroMsg.ImageGalleryUI", "runDragAnimation contentView is null !!");
            }

            public final void y(float f, float f2) {
                this.oCl.jMk = (int) f;
                this.oCl.jMl = (int) f2;
            }
        };
    }

    static /* synthetic */ void q(ImageGalleryUI imageGalleryUI) {
        if (imageGalleryUI.bGL() && imageGalleryUI.oCg) {
            try {
                if (imageGalleryUI.ozG.bGu().bHf().oCY.getVisibility() == 8) {
                    imageGalleryUI.ozG.bGu().bHf().oCY.setVisibility(0);
                    imageGalleryUI.oCg = false;
                }
            } catch (Exception e) {
            }
        }
        if (imageGalleryUI.oCh) {
            imageGalleryUI.bGN();
            imageGalleryUI.oCh = false;
        }
    }

    static /* synthetic */ void w(ImageGalleryUI imageGalleryUI) {
        v.i("MicroMsg.ImageGalleryUI", "enterPositionAtChatRecords-->talker:%s,magId:%d", imageGalleryUI.bdo, Long.valueOf(imageGalleryUI.ozG.xs(imageGalleryUI.oCb).field_msgId));
        Intent intent = new Intent(imageGalleryUI.nDR.nEl, ChattingUI.class);
        intent.putExtra("Chat_User", imageGalleryUI.bGJ());
        intent.putExtra("finish_direct", true);
        intent.putExtra("show_search_chat_content_result", true);
        intent.putExtra("key_is_biz_chat", imageGalleryUI.lKa);
        intent.putExtra("key_biz_chat_id", imageGalleryUI.ezh);
        ak.yW();
        intent.putExtra("need_hight_item", ((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(true))).booleanValue());
        intent.putExtra("msg_local_id", r4);
        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
        imageGalleryUI.startActivity(intent);
        if (imageGalleryUI.oBT) {
            com.tencent.mm.plugin.report.service.g.iuh.a(219, 16, 1, true);
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.a(219, 17, 1, true);
        }
    }

    protected void onPause() {
        v.i("MicroMsg.ImageGalleryUI", "on pause");
        super.onPause();
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        if (!(isFinishing() || this.ozG == null)) {
            this.ozG.bGw();
        }
        if (this.jFv != null) {
            com.tencent.mm.sdk.c.b adVar = new ad();
            adVar.aXF.aXH = this;
            adVar.aXF.aXG = this.jFv;
            com.tencent.mm.sdk.c.a.nhr.z(adVar);
            this.jFv = null;
            this.llb = 0;
            this.lla = 0;
        }
    }

    final ImageGalleryUI bGG() {
        if (this.oBJ == null) {
            this.oBJ = ((ViewStub) findViewById(2131757453)).inflate();
            this.oBK = (Button) this.oBJ.findViewById(2131756565);
            this.oBL = (Button) this.oBJ.findViewById(2131757458);
            this.oBM = this.oBJ.findViewById(2131757459);
        }
        return this;
    }

    protected final ImageGalleryUI bGH() {
        if (this.oBN == null) {
            this.oBN = ((ViewStub) findViewById(2131757454)).inflate();
            this.oBO = (VideoPlayerSeekBar) findViewById(2131757461);
            this.oBO.g((OnClickListener) this);
        }
        return this;
    }

    private ImageGalleryUI bGI() {
        if (this.oBG == null) {
            this.oBG = (RelativeLayout) ((ViewStub) findViewById(2131757450)).inflate();
            this.oBH = findViewById(2131757456);
        }
        return this;
    }

    private static void F(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    private static int cV(View view) {
        if (view != null) {
            return view.getVisibility();
        }
        return 8;
    }

    public final boolean Sk() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        long currentTimeMillis = System.currentTimeMillis();
        this.lvx = true;
        super.onCreate(bundle);
        if (com.tencent.mm.compatible.util.d.dW(19)) {
            getWindow().setFlags(201327616, 201327616);
            this.hlh = true;
        } else {
            getWindow().setFlags(1024, 1024);
            this.hlh = false;
        }
        NI();
        this.eIW = bundle;
        com.tencent.mm.sdk.c.a.nhr.e(this.jFx);
        com.tencent.mm.sdk.c.a.nhr.e(this.jFy);
        v.d("MicroMsg.ImageGalleryUI", "ImageGallery onCreate spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    protected void onResume() {
        super.onResume();
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        if (!(this.lvx || this.ozG == null)) {
            xJ(this.ggz.xB);
        }
        this.lvx = false;
        if (this.ozG != null) {
            this.ozG.bGx();
        }
    }

    public void onStart() {
        this.oBU = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        Bundle bundle = this.eIW;
        if (!this.eIX) {
            this.eIX = true;
            if (VERSION.SDK_INT >= 12) {
                this.eIZ = getIntent().getIntExtra("img_gallery_top", 0);
                this.eJa = getIntent().getIntExtra("img_gallery_left", 0);
                this.eJb = getIntent().getIntExtra("img_gallery_width", 0);
                this.eJc = getIntent().getIntExtra("img_gallery_height", 0);
                if (this.eIZ == 0 && this.eJa == 0 && this.eJb == 0 && this.eJc == 0) {
                    at xs = this.ozG.xs(this.ggz.xB);
                    if (xs != null) {
                        com.tencent.mm.sdk.c.b aiVar = new ai();
                        aiVar.aXT.aXd = xs;
                        com.tencent.mm.sdk.c.a.nhr.z(aiVar);
                        this.eJb = aiVar.aXU.aXX;
                        this.eJc = aiVar.aXU.aXY;
                        this.eJa = aiVar.aXU.aXV;
                        this.eIZ = aiVar.aXU.aXW;
                    }
                }
                this.eIY.m(this.eJa, this.eIZ, this.eJb, this.eJc);
                if (bundle == null) {
                    this.ggz.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ ImageGalleryUI oCl;

                        {
                            this.oCl = r1;
                        }

                        public final boolean onPreDraw() {
                            this.oCl.ggz.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.oCl.jMg = this.oCl.ggz.getWidth();
                            this.oCl.jMh = this.oCl.ggz.getHeight();
                            if (this.oCl.ozG.bGt().bwo()) {
                                this.oCl.jMh = (int) ((((float) this.oCl.jMg) / ((float) this.oCl.eJb)) * ((float) this.oCl.eJc));
                            }
                            if (this.oCl.ozG.bGt().bwj()) {
                                this.oCl.oBP = this.oCl.ozG.lo(this.oCl.ggz.xB);
                            }
                            if (this.oCl.oBP != null) {
                                this.oCl.jMh = (int) ((((float) this.oCl.jMg) / ((float) this.oCl.oBP.imageWidth)) * ((float) this.oCl.oBP.imageHeight));
                                if (this.oCl.jMh > this.oCl.ggz.getHeight()) {
                                    this.oCl.jMh = this.oCl.ggz.getHeight();
                                }
                            }
                            this.oCl.eIY.du(this.oCl.jMg, this.oCl.jMh);
                            if (!this.oCl.oBU) {
                                ImageGalleryUI.l(this.oCl);
                                this.oCl.oCg = false;
                                this.oCl.eIY.a(this.oCl.ggz, this.oCl.jKJ, new g.b(this) {
                                    final /* synthetic */ AnonymousClass16 oCn;

                                    {
                                        this.oCn = r1;
                                    }

                                    public final void onAnimationStart() {
                                        if (this.oCn.oCl.oBX != null) {
                                            this.oCn.oCl.oBX.g(Boolean.valueOf(true));
                                        }
                                    }

                                    public final void onAnimationEnd() {
                                        this.oCn.oCl.mHandler.post(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass1 oCo;

                                            {
                                                this.oCo = r1;
                                            }

                                            public final void run() {
                                                if (this.oCo.oCn.oCl.oBX != null) {
                                                    this.oCo.oCn.oCl.oBX.g(Boolean.valueOf(false));
                                                }
                                            }
                                        });
                                    }
                                });
                            }
                            ImageGalleryUI.p(this.oCl);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onDestroy() {
        v.i("MicroMsg.ImageGalleryUI", "%d image gallery ui on destroy", Integer.valueOf(hashCode()));
        if (this.ozG != null) {
            this.ozG.detach();
            this.ozG = null;
        }
        bGX();
        this.oCe.QI();
        com.tencent.mm.sdk.c.a.nhr.f(this.jFx);
        com.tencent.mm.sdk.c.a.nhr.f(this.jFy);
        if (this.oBO != null) {
            this.oBO.g(null);
        }
        this.oBO = null;
        super.onDestroy();
    }

    public void onBackPressed() {
        v.i("MicroMsg.ImageGalleryUI", "onBackPressed");
        if (this.oBT) {
            xK(1);
            return;
        }
        try {
            a.oBx.detach();
            abE();
        } catch (Exception e) {
            v.e("MicroMsg.ImageGalleryUI", e.getMessage());
        }
    }

    private String bGJ() {
        return (this.biB == null || this.biB.length() <= 0) ? this.bdo : this.biB;
    }

    protected final void NI() {
        this.eIY = new g(this.nDR.nEl);
        this.oCi = new ah(this, false);
        this.eIX = false;
        this.bdo = getIntent().getStringExtra("img_gallery_talker");
        this.oBT = getIntent().getBooleanExtra("img_gallery_enter_from_grid", false);
        this.otW = getIntent().getBooleanExtra("img_gallery_enter_from_chatting_ui", false);
        this.oBV = getIntent().getBooleanExtra("img_gallery_enter_from_appbrand_service_chatting_ui", false);
        this.onc = getIntent().getBooleanExtra("show_search_chat_content_result", false);
        this.lKa = getIntent().getBooleanExtra("key_is_biz_chat", false);
        this.ezh = getIntent().getLongExtra("key_biz_chat_id", -1);
        Assert.assertTrue("MicroMsg.ImageGalleryUI initView, talker is null, stack = " + be.bur(), this.bdo != null);
        this.biB = getIntent().getStringExtra("img_gallery_chatroom_name");
        this.oBU = getIntent().getBooleanExtra("img_gallery_back_from_grid", false);
        this.oBW = getIntent().getStringExtra("img_gallery_enter_video_opcode");
        boolean booleanExtra = getIntent().getBooleanExtra("img_gallery_is_restransmit_after_download", false);
        String stringExtra = getIntent().getStringExtra("img_gallery_directly_send_name");
        this.bao = getIntent().getLongExtra("img_gallery_msg_id", 0);
        long longExtra = getIntent().getLongExtra("img_gallery_msg_svr_id", 0);
        if (this.bao > 0 || longExtra != 0) {
            if (this.bao == 0) {
                ak.yW();
                this.bao = com.tencent.mm.model.c.wJ().S(bGJ(), longExtra).field_msgId;
            }
            ak.yW();
            if (com.tencent.mm.model.c.wJ().ek(this.bao).field_msgId <= 0) {
                v.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.bao + ", msgSvrId = " + longExtra + ", stack = " + be.bur());
                finish();
                return;
            }
            this.ozG = new b(this, this.bao, bGJ(), this.lKa, this.ezh, booleanExtra, stringExtra, Boolean.valueOf(this.oBU));
            this.ozG.ozQ = false;
            this.ozG.ozK = getIntent().getBooleanExtra("start_chatting_ui", true);
            this.ozG.ozP = new b.c(this) {
                final /* synthetic */ ImageGalleryUI oCl;

                {
                    this.oCl = r1;
                }

                public final void abH() {
                    if (this.oCl.ozG != null) {
                        this.oCl.bGK();
                        this.oCl.ozG.W(100000);
                    }
                }
            };
            this.oBD = (RelativeLayout) findViewById(2131756564);
            this.oBE = (RelativeLayout) findViewById(2131757449);
            this.oBF = (ImageView) findViewById(2131757451);
            this.oBF.setOnClickListener(this);
            Display defaultDisplay = getWindowManager().getDefaultDisplay();
            v.d("MicroMsg.ImageGalleryUI", "%d is vertical screen orient %d [%d, %d]", Integer.valueOf(hashCode()), Integer.valueOf(defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0), Integer.valueOf(defaultDisplay.getWidth()), Integer.valueOf(defaultDisplay.getHeight()));
            if (((defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 0) == 0 ? null : 1) != null) {
                bGY();
            } else {
                bGZ();
            }
            this.jKJ = (ImageView) findViewById(2131755841);
            this.jKJ.setLayerType(2, null);
            this.ggz = (MMViewPager) findViewById(2131755843);
            this.ggz.setLayerType(2, null);
            this.ggz.setVerticalFadingEdgeEnabled(false);
            this.ggz.setHorizontalFadingEdgeEnabled(false);
            this.ggz.nZl = this.oCc;
            this.ggz.nZj = new MMViewPager.e(this) {
                final /* synthetic */ ImageGalleryUI oCl;

                {
                    this.oCl = r1;
                }

                public final void abF() {
                    ImageGalleryUI.g(this.oCl);
                }

                public final void aqZ() {
                    this.oCl.abE();
                }
            };
            this.ggz.nZk = new MMViewPager.c(this) {
                final /* synthetic */ ImageGalleryUI oCl;

                {
                    this.oCl = r1;
                }

                public final void amC() {
                    this.oCl.jQ(true);
                }
            };
            this.ggz.yb(1);
            WxViewPager wxViewPager = this.ggz;
            int i = wxViewPager.xI;
            wxViewPager.xI = 50;
            int width = wxViewPager.getWidth();
            wxViewPager.q(width, width, 50, i);
            wxViewPager.requestLayout();
            this.ggz.a(this.ozG);
            xJ(100000);
            this.ggz.Z(100000);
            this.ggz.postDelayed(new Runnable(this) {
                final /* synthetic */ ImageGalleryUI oCl;

                {
                    this.oCl = r1;
                }

                public final void run() {
                    if (this.oCl.ozG != null) {
                        if (a.oBx.oBv && this.oCl.oBZ != null) {
                            this.oCl.oBZ.setChecked(a.oBx.aZ(this.oCl.ozG.bGt()));
                            this.oCl.oCa.setOnClickListener(this.oCl);
                        }
                        if (this.oCl.ggz.xB == 100000) {
                            this.oCl.bGW();
                            b.b aN = b.aN(this.oCl.ozG.xs(100000));
                            if (!this.oCl.oBU && aN == b.b.video) {
                                this.oCl.ozG.xx(100000);
                            }
                            if (aN == b.b.sight) {
                                this.oCl.ozG.xB(100000);
                            }
                        }
                    }
                }
            }, 0);
            if (a.oBx.oBv) {
                this.oBY = ((ViewStub) findViewById(2131757448)).inflate();
                this.oBY.setVisibility(0);
                this.oBZ = (CheckBox) this.oBY.findViewById(2131757446);
                this.oCa = this.oBY.findViewById(2131757447);
                return;
            }
            return;
        }
        v.e("MicroMsg.ImageGalleryUI", " initView, msgId is invalid, msgId = " + this.bao + ", msgSvrId = " + longExtra + ", stack = " + be.bur());
        finish();
    }

    private View a(b bVar, MMViewPager mMViewPager) {
        View view;
        String str = "MicroMsg.ImageGalleryUI";
        String str2 = "get current view adapter is null %b, gallery is null %b";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(bVar == null);
        objArr[1] = Boolean.valueOf(mMViewPager == null);
        v.d(str, str2, objArr);
        if (bVar == null || mMViewPager == null) {
            v.w("MicroMsg.ImageGalleryUI", "%d get current view but adapter or gallery is null", Integer.valueOf(hashCode()));
            view = null;
        } else if (bVar.bGt() == null) {
            return null;
        } else {
            if (bVar.bGt().bwj() || bVar.bGt().bwr()) {
                view = bVar.lo(mMViewPager.xB);
            } else {
                if (bVar.bGt().bwn() || bVar.bGt().bwo()) {
                    view = bVar.xw(mMViewPager.xB);
                }
                view = null;
            }
        }
        return view;
    }

    private void abE() {
        int i;
        int i2;
        v.i("MicroMsg.ImageGalleryUI", "runExitAnimation");
        int width = this.ggz.getWidth() / 2;
        int height = this.ggz.getHeight() / 2;
        if (this.oBT) {
            ak.yW();
            height = com.tencent.mm.model.c.wJ().ab(bGJ(), this.ozG.bGt().field_msgId) + this.ozG.ozI.xC(this.ggz.xB);
            com.tencent.mm.sdk.c.b fpVar = new fp();
            fpVar.beU.beX = height;
            com.tencent.mm.sdk.c.a.nhr.z(fpVar);
            i = fpVar.beV.aXX;
            i2 = fpVar.beV.aXY;
            width = fpVar.beV.aXV;
            height = fpVar.beV.aXW;
        } else {
            bx xs = this.ozG.xs(this.ggz.xB);
            if (xs != null) {
                com.tencent.mm.sdk.c.b aiVar = new ai();
                aiVar.aXT.aXd = xs;
                com.tencent.mm.sdk.c.a.nhr.z(aiVar);
                i = aiVar.aXU.aXX;
                i2 = aiVar.aXU.aXY;
                width = aiVar.aXU.aXV;
                height = aiVar.aXU.aXW;
            } else {
                i2 = 0;
                i = 0;
            }
            if (width == 0 && r0 == 0) {
                width = this.ggz.getWidth() / 2;
                height = this.ggz.getHeight() / 2;
            } else if (xs != null) {
                if (xs.field_isSend == 0) {
                    this.oBQ = com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 5);
                }
                if (xs.field_isSend == 1) {
                    this.oBR = com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 5);
                }
            }
        }
        this.jMg = this.ggz.getWidth();
        this.jMh = this.ggz.getHeight();
        if (!(this.ozG == null || this.ozG.bGt() == null)) {
            if (this.ozG.bGt().bwo() || this.ozG.bGt().bwn()) {
                this.jMh = (int) ((((float) this.jMg) / ((float) i)) * ((float) i2));
            }
            if (this.ozG.bGt().bwj() || this.ozG.bGt().bwr()) {
                this.oBP = this.ozG.lo(this.ggz.xB);
            }
        }
        if (this.oBP != null) {
            this.jMh = (int) ((((float) this.jMg) / ((float) this.oBP.imageWidth)) * ((float) this.oBP.imageHeight));
            if (this.jMh > this.ggz.getHeight()) {
                if (((double) this.jMh) < ((double) this.ggz.getHeight()) * 1.5d) {
                    if (this.oBT) {
                        this.jMi = this.jMh - this.ggz.getHeight();
                    } else {
                        i2 = (i2 * this.ggz.getHeight()) / this.jMh;
                    }
                }
                this.jMh = this.ggz.getHeight();
            }
        }
        g gVar = this.eIY;
        int i3 = this.oBQ;
        int i4 = this.oBR;
        gVar.jCH = i3;
        gVar.jCI = i4;
        gVar.jCJ = 0;
        gVar.jCK = 0;
        this.eIY.jCG = this.jMi;
        this.eIY.du(this.jMg, this.jMh);
        this.eIY.m(width, height, i, i2);
        View view = this.ggz;
        View a = a(this.ozG, this.ggz);
        if (a == null) {
            a = view;
        } else if (((double) this.jMj) != 1.0d) {
            this.eIY.oSK = 1.0f / this.jMj;
            if (!(this.jMk == 0 && this.jMl == 0)) {
                this.eIY.dv(((int) (((float) (this.ggz.getWidth() / 2)) * (1.0f - this.jMj))) + this.jMk, (int) (((float) ((this.ggz.getHeight() / 2) + this.jMl)) - (((float) (this.jMh / 2)) * this.jMj)));
            }
        }
        this.eIY.a(a, this.jKJ, new g.b(this) {
            final /* synthetic */ ImageGalleryUI oCl;

            {
                this.oCl = r1;
            }

            public final void onAnimationStart() {
                ImageGalleryUI.F(this.oCl.oBE, 8);
                ImageGalleryUI.F(this.oCl.oBD, 8);
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass18 oCp;

                    {
                        this.oCp = r1;
                    }

                    public final void run() {
                        if (this.oCp.oCl.oBP != null) {
                            this.oCp.oCl.oBP.bCO();
                        }
                    }
                }, 20);
            }

            public final void onAnimationEnd() {
                this.oCl.mHandler.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass18 oCp;

                    {
                        this.oCp = r1;
                    }

                    public final void run() {
                        this.oCp.oCl.finish();
                        this.oCp.oCl.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    protected final void jQ(boolean z) {
        if (this.ozG != null && this.oCb >= 0) {
            at xs = this.ozG.xs(this.oCb);
            int aV = this.ozG.ozM.aV(xs);
            if (aV == 5 || aV == 6) {
                v.w("MicroMsg.ImageGalleryUI", "jacks fail downloaded img, return");
            } else if (this.ozG.aM(xs)) {
                v.w("MicroMsg.ImageGalleryUI", "jacks downloading, return");
            } else if (b.aI(xs) && i.bb(xs) == null) {
                v.w("MicroMsg.ImageGalleryUI", "video info is null, return now.");
            } else {
                final List arrayList = new ArrayList();
                final List arrayList2 = new ArrayList();
                if (!this.oBV) {
                    arrayList.add(Integer.valueOf(0));
                    arrayList2.add(getString(2131234560));
                }
                if (c.EH("favorite") && !this.oBV) {
                    arrayList.add(Integer.valueOf(2));
                    arrayList2.add(getString(2131234180));
                }
                if (b.aH(xs) || b.aL(xs)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(2131234725));
                } else if (b.aI(xs) || b.aJ(xs)) {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(2131234728));
                } else {
                    arrayList.add(Integer.valueOf(1));
                    arrayList2.add(getString(2131234727));
                }
                if (b.aH(xs) || b.aJ(xs)) {
                    com.tencent.mm.sdk.c.b cpVar = new cp();
                    cpVar.bay.bao = xs.field_msgId;
                    com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                    if (cpVar.baz.aZW || com.tencent.mm.pluginsdk.model.app.g.G(this.nDR.nEl, xs.field_type)) {
                        arrayList.add(Integer.valueOf(4));
                        arrayList2.add(getString(2131231834));
                    }
                }
                if (!(this.jFv == null || this.oBV)) {
                    arrayList.add(Integer.valueOf(3));
                    arrayList2.add(getString(2131234352));
                }
                if (!(this.onc || this.lKa || a.oBx.oBv || this.oBV)) {
                    arrayList.add(Integer.valueOf(5));
                    arrayList2.add(getString(2131231801));
                }
                if (this.eIV == null) {
                    this.eIV = new l(this.nDR.nEl);
                }
                this.eIV.jXn = new com.tencent.mm.ui.base.n.c(this) {
                    final /* synthetic */ ImageGalleryUI oCl;

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.setHeaderTitle(SQLiteDatabase.KeyEmpty);
                        for (int i = 0; i < arrayList.size(); i++) {
                            lVar.d(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                        }
                    }
                };
                this.eIV.jXo = this.fNB;
                this.eIV.d(new OnCancelListener(this) {
                    final /* synthetic */ ImageGalleryUI oCl;

                    {
                        this.oCl = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        v.d("MicroMsg.ImageGalleryUI", "cancel menu");
                        com.tencent.mm.sdk.c.b aeVar = new ae();
                        aeVar.aXI.filePath = this.oCl.jFs;
                        com.tencent.mm.sdk.c.a.nhr.z(aeVar);
                        this.oCl.eIV = null;
                        this.oCl.jFs = null;
                        this.oCl.jFv = null;
                        this.oCl.lla = this.oCl.llb = 0;
                    }
                });
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, this.eIV.aXZ());
                if ((b.aH(xs) || b.aL(xs)) && true == z && ak.vy().BJ() != 0 && !this.oBV) {
                    String str = null;
                    if (b.aH(xs)) {
                        com.tencent.mm.ae.d e = this.ozG.e(xs, true);
                        if (e != null) {
                            str = d.a(xs, e, false);
                        }
                    } else {
                        str = b.aR(xs);
                    }
                    if (str != null) {
                        com.tencent.mm.sdk.c.b ktVar = new kt();
                        ktVar.bmc.filePath = str;
                        this.jFs = str;
                        com.tencent.mm.sdk.c.a.nhr.z(ktVar);
                    }
                }
            }
        }
    }

    public final void dm(boolean z) {
        int i = 8;
        if (!z || this.oBD.getVisibility() != 0) {
            if (z || this.oBD.getVisibility() != 8) {
                RelativeLayout relativeLayout = this.oBD;
                if (z) {
                    i = 0;
                }
                relativeLayout.setVisibility(i);
                this.oBD.startAnimation(AnimationUtils.loadAnimation(this.nDR.nEl, z ? 2130968586 : 2130968587));
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903787;
    }

    protected final void PK() {
        super.PK();
    }

    private void bGK() {
        if (this.ozG != null && this.ozG.bGs() && bGI().oBG != null) {
            if (a.oBx.oBv) {
                bGI().oBG.setVisibility(8);
            } else if (this.onc || this.oBV) {
                bGI().oBG.setVisibility(8);
            } else {
                v.d("MicroMsg.ImageGalleryUI", "%d show enter grid is video %b", Integer.valueOf(hashCode()), Boolean.valueOf(bGL()));
                F(bGI().oBG, 0);
                F(bGI().oBH, 0);
                bGW();
            }
        }
    }

    private static boolean d(at atVar, com.tencent.mm.ae.d dVar) {
        try {
            if (b.b(atVar, dVar) == 0 && dVar.Gp() && !atVar.bwv()) {
                return true;
            }
        } catch (NullPointerException e) {
            v.e("MicroMsg.ImageGalleryUI", "error:" + e);
        }
        return false;
    }

    public final void xJ(int i) {
        ba(this.ozG.xs(i));
    }

    private boolean bGL() {
        if (this.oBC == b.b.video) {
            return true;
        }
        return false;
    }

    protected final void bGM() {
        if (this.oCd) {
            this.oCe.ea(4000);
        }
    }

    public final void bGN() {
        v.i("MicroMsg.ImageGalleryUI", "show video tool bar");
        dm(true);
        jR(true);
        F(this.oBJ, 8);
        F(bGH().oBN, 0);
        F(this.oBF, 0);
        bGI().oBG.clearAnimation();
        F(bGI().oBH, 8);
        F(bGI().oBG, 0);
        bGX();
        this.oCd = true;
        bGM();
    }

    public final void bGO() {
        v.i("MicroMsg.ImageGalleryUI", "hide video tool bar");
        jR(false);
        F(bGH().oBN, 8);
        F(this.oBF, 8);
        if (bGL()) {
            bGX();
            bGI().oBG.setVisibility(8);
        }
        this.oCd = false;
    }

    private void jR(boolean z) {
        v.d("MicroMsg.ImageGalleryUI", "switch tool bar bg %b", Boolean.valueOf(z));
        if (z) {
            this.oBE.setBackgroundResource(2130838417);
            this.oBD.setBackgroundResource(2130838416);
            return;
        }
        cW(this.oBE);
        cW(this.oBD);
    }

    private static void cW(View view) {
        if (com.tencent.mm.compatible.util.d.dW(16)) {
            view.setBackground(null);
        } else {
            view.setBackgroundDrawable(null);
        }
    }

    public final synchronized void ba(at atVar) {
        int i = 0;
        synchronized (this) {
            this.oBC = b.aN(atVar);
            v.i("MicroMsg.ImageGalleryUI", "updateFooterInfo currGalleryType : " + this.oBC);
            if (a.oBx.oBv && this.oBZ != null) {
                this.oBZ.setChecked(a.oBx.aZ(atVar));
            }
            switch (this.oBC) {
                case video:
                    bGO();
                    F(this.oBJ, 8);
                    jS(true);
                    n bb = i.bb(atVar);
                    if (bb != null) {
                        bGH().oBO.pz(bb.dhK);
                        try {
                            if (!(this.ozG.bGu() == null || this.ozG.bGu().oCZ == null)) {
                                i = this.ozG.bGu().oCZ.getCurrentPosition() / 1000;
                            }
                        } catch (Throwable e) {
                            v.a("MicroMsg.ImageGalleryUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                        bGH().oBO.py(i);
                        break;
                    }
                    break;
                case image:
                    com.tencent.mm.ae.d e2 = this.ozG.e(atVar, false);
                    bGO();
                    bGK();
                    i = this.ggz.xB;
                    if (!d(atVar, e2) || atVar.bwv() || !e2.Go()) {
                        F(this.oBJ, 8);
                        break;
                    }
                    bGG().oBK.setVisibility(0);
                    bGG().oBL.setVisibility(8);
                    bGG().oBM.setVisibility(8);
                    String str = (String) this.oCf.get(Long.valueOf(e2.cLu));
                    if (str == null) {
                        Map q = bf.q(e2.cLF, "msg");
                        if (q == null) {
                            v.e("MicroMsg.ImageGalleryUI", "parse cdnInfo failed. [%s]", e2.cLF);
                            i = -1;
                        } else {
                            i = be.getInt((String) q.get(".msg.img.$hdlength"), 0);
                        }
                        long j = (long) i;
                        if (j < 0) {
                            str = SQLiteDatabase.KeyEmpty;
                        } else {
                            BigDecimal bigDecimal = new BigDecimal(j);
                            float floatValue = bigDecimal.divide(new BigDecimal(1048576), 2, 0).floatValue();
                            if (floatValue > 1.0f) {
                                str = ((int) floatValue) + "M";
                            } else {
                                str = ((int) bigDecimal.divide(new BigDecimal(1024), 2, 0).floatValue()) + "K";
                            }
                        }
                        this.oCf.put(Long.valueOf(e2.cLu), str);
                    }
                    bGG().oBK.setText(getString(2131232248, new Object[]{str}));
                    F(this.oBJ, 0);
                    break;
                case appimage:
                    bGO();
                    bGK();
                    break;
                case sight:
                    bGO();
                    bGK();
                    F(this.oBJ, 8);
                    this.ozG.xB(this.ggz.xB);
                    break;
            }
        }
    }

    private void xK(int i) {
        v.i("MicroMsg.ImageGalleryUI", "enterGrid source : " + i);
        if (this.ozG == null) {
            v.w("MicroMsg.ImageGalleryUI", "try to enterGrid, but adapter is NULL");
            return;
        }
        com.tencent.mm.plugin.report.service.g.iuh.a(219, 13, 1, true);
        int aij = this.ozG.aij();
        bx bGt = this.ozG.bGt();
        if (bGt == null) {
            v.e("MicroMsg.ImageGalleryUI", "msgInfo is null");
            return;
        }
        ak.yW();
        int ab = com.tencent.mm.model.c.wJ().ab(bGJ(), bGt.field_msgId) + this.ozG.ozI.xC(this.ggz.xB);
        if (this.oBT) {
            abE();
            return;
        }
        finish();
        Intent intent = new Intent();
        intent.setClass(this.nDR.nEl, ImageGalleryGridUI.class);
        intent.addFlags(67108864);
        intent.putExtra("kintent_intent_source", i);
        intent.putExtra("kintent_talker", bGJ());
        intent.putExtra("kintent_image_count", aij);
        intent.putExtra("kintent_image_index", ab);
        intent.putExtra("key_biz_chat_id", this.ezh);
        intent.putExtra("key_is_biz_chat", this.lKa);
        startActivity(intent);
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        if (actionBarActivity != null && (actionBarActivity instanceof Activity)) {
            actionBarActivity.overridePendingTransition(2130968641, 2130968642);
        }
    }

    public final int bGP() {
        return this.ggz.xB;
    }

    public void onClick(View view) {
        boolean z = false;
        if (this.ozG != null) {
            if (view.getId() == 2131757450) {
                xK(0);
            } else if (view.getId() == 2131756565) {
                b bVar = this.ozG;
                bVar.ozM.xG(this.ggz.xB);
            } else if (view.getId() == 2131757458) {
                this.ozG.xA(this.ggz.xB);
                xJ(this.ggz.xB);
                bGT();
                bGU();
                bGW();
            } else if (view.getId() == 2131755284) {
                onBackPressed();
            } else if (view.getId() == 2131757451) {
                onBackPressed();
            } else if (view.getId() == 2131757447) {
                CheckBox checkBox = this.oBZ;
                if (!this.oBZ.isChecked()) {
                    z = true;
                }
                checkBox.setChecked(z);
                if (this.oBZ.isChecked()) {
                    a.oBx.aX(this.ozG.bGt());
                } else {
                    a.oBx.aY(this.ozG.bGt());
                }
            } else if (view.getId() == 2131759269) {
                this.ozG.xx(this.ggz.xB);
            }
        }
    }

    public final void jS(boolean z) {
        try {
            bGH().oBO.fA(!z);
        } catch (Exception e) {
            v.e("MicroMsg.ImageGalleryUI", "set video state iv error : " + e.toString());
        }
    }

    public final boolean bGQ() {
        return bGH().oBO.bee;
    }

    public final void xL(final int i) {
        if (bGH().oBN != null) {
            bGH().oBN.post(new Runnable(this) {
                final /* synthetic */ ImageGalleryUI oCl;

                public final void run() {
                    if (this.oCl.ozG != null) {
                        b e = this.oCl.ozG;
                        e.ozN.pause(i);
                    }
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 82 || keyEvent.getAction() != 1) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.eIV != null) {
            this.eIV.dismiss();
            this.eIV = null;
            return true;
        }
        jQ(true);
        return true;
    }

    final void bGR() {
        if (bGI().oBG != null && !this.oCj) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeOutEnterGirdBtn: %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.oBG.getVisibility() == 0);
            v.d(str, str2, objArr);
            Animation xM = xM(SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD);
            xM.setFillAfter(false);
            xM.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageGalleryUI oCl;

                {
                    this.oCl = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    ImageGalleryUI.F(this.oCl.bGI().oBG, 8);
                    this.oCl.oCj = false;
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            bGI().oBG.startAnimation(xM);
            this.oCj = true;
        }
    }

    final void bGS() {
        if (bGI().oBI != null && !this.oCk) {
            bGI().oBI.startAnimation(xM(SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD));
            this.oCk = true;
        }
    }

    private void bGT() {
        if (bGI().oBG != null && this.oCj && !bGL()) {
            boolean z;
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInEnterGirdBtn: %B %s";
            Object[] objArr = new Object[2];
            if (bGI().oBG.getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = be.bur();
            v.d(str, str2, objArr);
            bGI().oBG.startAnimation(bGV());
            this.oCj = false;
        }
    }

    private void bGU() {
        boolean z = true;
        if (bGI().oBI != null && this.oCk) {
            String str = "MicroMsg.ImageGalleryUI";
            String str2 = "fadeInPositionAtChatRecordBtn: %B";
            Object[] objArr = new Object[1];
            if (bGI().oBI.getVisibility() != 0) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.d(str, str2, objArr);
            bGI().oBI.startAnimation(bGV());
            this.oCk = false;
        }
    }

    private static Animation bGV() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    static Animation xM(int i) {
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration((long) i);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new AccelerateInterpolator(10.0f));
        return alphaAnimation;
    }

    public final boolean oU() {
        bGR();
        bGS();
        return false;
    }

    protected final void bGW() {
        Object obj = (cV(this.oBJ) == 0 && cV(this.oBK) == 0) ? 1 : null;
        if (obj == null && this.ozG != null) {
            v.d("MicroMsg.ImageGalleryUI", "jacks start Hide Timer");
            this.oCi.ea(4000);
        }
    }

    private void bGX() {
        v.d("MicroMsg.ImageGalleryUI", "jacks stop Hide Timer");
        this.oCi.QI();
    }

    public final void xN(int i) {
        dm(true);
        bGO();
        bGG().oBJ.setVisibility(0);
        bGG().oBK.setVisibility(8);
        bGG().oBL.setVisibility(0);
        bGG().oBM.setVisibility(8);
        bGR();
        bGS();
        bGG().oBL.setText(i + "%");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        try {
            if (bGL() && com.tencent.mm.compatible.b.d.rg()) {
                if (i == 25) {
                    ak.yX().dO(com.tencent.mm.compatible.b.d.rh());
                } else if (i == 24) {
                    ak.yX().dN(com.tencent.mm.compatible.b.d.rh());
                }
            }
        } catch (Throwable e) {
            v.a("MicroMsg.ImageGalleryUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.e("MicroMsg.ImageGalleryUI", "image gallery ui on key down error. " + e.toString());
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void finish() {
        this.ovC.clear();
        super.finish();
    }

    public final int eD(long j) {
        if (be.kS(this.oBW)) {
            return 0;
        }
        try {
            int c = p.c(j, this.oBW);
            if (c == -1) {
                this.oBW = null;
                c = 0;
            }
            v.d("MicroMsg.ImageGalleryUI", "get enter video op code %d %s", Integer.valueOf(c), this.oBW);
            return c;
        } catch (Exception e) {
            v.e("MicroMsg.ImageGalleryUI", "get enter video op code error : " + e.toString());
            return 0;
        }
    }

    public final void eE(long j) {
        if (!be.kS(this.oBW) && j != 0 && p.c(j, this.oBW) == -1) {
            this.oBW = null;
            v.d("MicroMsg.ImageGalleryUI", "reset enter video op code %s", this.oBW);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            v.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is vertical screen", Integer.valueOf(hashCode()));
            bGY();
        } else if (configuration.orientation == 2) {
            v.d("MicroMsg.ImageGalleryUI", "%d image gallery ui is horizontal screen", Integer.valueOf(hashCode()));
            bGZ();
        }
    }

    private void bGY() {
        v.i("MicroMsg.ImageGalleryUI", "%d handleVerticalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.hlh), Boolean.valueOf(w.eo(this)), Integer.valueOf(w.en(this)));
        if (this.hlh && r0) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oBD.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, r1);
            this.oBD.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.oBE.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, 0, layoutParams.bottomMargin);
            this.oBE.setLayoutParams(layoutParams);
        }
    }

    private void bGZ() {
        boolean eo = w.eo(this);
        int en = w.en(this);
        v.i("MicroMsg.ImageGalleryUI", "%d handleHorizontalUI image gallery ui isNavigationBarTint %b isNavBarVisibility %b navBarHeight %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.hlh), Boolean.valueOf(eo), Integer.valueOf(en));
        if (this.hlh && eo) {
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.oBD.getLayoutParams());
            layoutParams.addRule(12);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, en, 0);
            this.oBD.setLayoutParams(layoutParams);
            layoutParams = new RelativeLayout.LayoutParams(this.oBE.getLayoutParams());
            layoutParams.addRule(10);
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, en, layoutParams.bottomMargin);
            this.oBE.setLayoutParams(layoutParams);
        }
    }
}
