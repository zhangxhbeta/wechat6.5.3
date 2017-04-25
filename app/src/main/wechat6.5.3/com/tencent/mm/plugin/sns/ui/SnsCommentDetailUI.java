package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.ActionBarActivity;
import android.text.ClipboardManager;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.tencent.mm.e.a.fn;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.lh;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.od;
import com.tencent.mm.e.a.oe;
import com.tencent.mm.e.a.of;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.a.g;
import com.tencent.mm.plugin.sns.a.a.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ae;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.am;
import com.tencent.mm.plugin.sns.e.o;
import com.tencent.mm.plugin.sns.lucky.b.x;
import com.tencent.mm.plugin.sns.lucky.view.SnsDetailLuckyHeader;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.pluginsdk.ui.d.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.aic;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.v.e;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SnsCommentDetailUI extends MMActivity implements com.tencent.mm.plugin.sns.e.b.b, com.tencent.mm.pluginsdk.j.q.e.a, e {
    public static int jMS = 34;
    private String bYE;
    private String boC;
    private boolean dFB = false;
    private com.tencent.mm.sdk.c.c dHB = new com.tencent.mm.sdk.c.c<id>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            id idVar = (id) bVar;
            if (idVar instanceof id) {
                switch (idVar.bif.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.jNp.aWF();
                        break;
                }
            }
            return false;
        }
    };
    private int eKg;
    private int ehy = 0;
    private l eyZ;
    private ClipboardManager fRJ;
    private OnClickListener gsK = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r1;
        }

        public final void onClick(View view) {
            v.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            SnsCommentDetailUI.a(this.jNp, view);
        }
    };
    private p jEA = null;
    private SnsCommentFooter jEp;
    private al jEr;
    private b jEx;
    private com.tencent.mm.plugin.sns.f.b jEy;
    private OnTouchListener jFF = be.buq();
    private com.tencent.mm.plugin.sight.decode.ui.c jHl = null;
    LinearLayout jMA;
    LinearLayout jMB;
    private LinkedList<avr> jMC;
    private int jMD = -1;
    private boolean jME = false;
    private ao jMF;
    private String jMG;
    private aa jMH;
    private int jMI = 0;
    private ImageView jMJ;
    private i jMK;
    private String jML = "";
    private boolean jMM = false;
    private long jMN = 0;
    private bd jMO;
    private boolean jMP = false;
    private int jMQ;
    private int jMR = 103;
    public int jMT = 210;
    private g jMU;
    private com.tencent.mm.plugin.sns.ui.b.b jMV;
    private SnsTranslateResultView jMW;
    private boolean jMX = false;
    private Dialog jMY = null;
    private ae jMZ = new ae();
    private long jMp = 0;
    private long jMq = 0;
    private View jMr;
    private TextView jMs;
    private LinearLayout jMt;
    private SnsDetailLuckyHeader jMu;
    private ListView jMv;
    private View jMw;
    private b jMx;
    private ScaleAnimation jMy;
    private ScaleAnimation jMz;
    private com.tencent.mm.sdk.c.c jNa = new com.tencent.mm.sdk.c.c<od>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = od.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            od odVar = (od) bVar;
            if (odVar instanceof od) {
                String str = odVar.bpf.id;
                String str2 = odVar.bpf.bfz;
                String str3 = odVar.bpf.bpg;
                if (odVar.bpf.type == 1) {
                    SnsCommentDetailUI.a(this.jNp, str, str2, str3);
                } else if (odVar.bpf.type == 2) {
                    SnsCommentDetailUI.a(this.jNp, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jNb = new com.tencent.mm.sdk.c.c<oe>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = oe.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            oe oeVar = (oe) bVar;
            if (oeVar instanceof oe) {
                String str = oeVar.bph.id;
                if (oeVar.bph.type == 1) {
                    SnsCommentDetailUI.b(this.jNp, str);
                } else if (oeVar.bph.type == 2) {
                    SnsCommentDetailUI.c(this.jNp, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jNc = new com.tencent.mm.sdk.c.c<of>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = of.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            of ofVar = (of) bVar;
            if (ofVar instanceof of) {
                String str = ofVar.bpi.id;
                if (ofVar.bpi.type == 1) {
                    SnsCommentDetailUI.d(this.jNp, str);
                } else if (ofVar.bpi.type == 2) {
                    SnsCommentDetailUI.e(this.jNp, str);
                }
            }
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jNd = new com.tencent.mm.sdk.c.c<fp>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = fp.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            fp fpVar = (fp) bVar;
            if (fpVar instanceof fp) {
                SnsCommentDetailUI.a(this.jNp, fpVar.beU.beX, fpVar.beU.beW, fpVar);
            }
            return false;
        }
    };
    private c jNe = new c(this);
    private OnClickListener jNf = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r1;
        }

        public final void onClick(View view) {
            String str = (String) view.getTag();
            v.d("MicroMsg.SnsCommentDetailUI", "onCommentClick:" + str);
            Intent intent = new Intent();
            k f = this.jNp.gt(true);
            if (f.qC(32)) {
                ak.vy().a(new com.tencent.mm.plugin.sns.a.a.c(f.aUQ(), 1, 2, "", f.field_type == 1 ? 1 : 2), 0);
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 37);
                com.tencent.mm.plugin.sns.b.a.drp.d(intent, this.jNp);
                return;
            }
            intent.setClass(this.jNp, SnsUserUI.class);
            Intent e = ad.aSu().e(intent, str);
            if (e == null) {
                this.jNp.finish();
                return;
            }
            this.jNp.startActivity(e);
            if ((e.getFlags() & 67108864) != 0) {
                this.jNp.finish();
            }
        }
    };
    private OnClickListener jNg = new OnClickListener(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r1;
        }

        public final void onClick(View view) {
            v.e("MicroMsg.SnsCommentDetailUI", "scrollTopClickListener");
            this.jNp.aWE();
            if (this.jNp.jME) {
                this.jNp.gs(true);
            }
        }
    };
    private com.tencent.mm.sdk.c.c jNh = new com.tencent.mm.sdk.c.c<nv>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = nv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.jNp.aWD();
            return false;
        }
    };
    private com.tencent.mm.sdk.c.c jNi = new com.tencent.mm.sdk.c.c<fn>(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r2;
            this.nhz = fn.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            return false;
        }
    };
    boolean jNj = false;
    private LinearLayout jNk = null;
    private boolean jNl = false;
    PhotosContent jNm = null;
    public com.tencent.mm.model.ab.c.a jNn = new com.tencent.mm.model.ab.c.a(this) {
        final /* synthetic */ SnsCommentDetailUI jNp;

        {
            this.jNp = r1;
        }

        public final void p(String str, boolean z) {
            new ac(Looper.getMainLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass19 jNr;

                {
                    this.jNr = r1;
                }

                public final void run() {
                    this.jNr.jNp.aWD();
                }
            }, 500);
        }
    };
    private bc jNo = null;
    private LinearLayout jir;
    private int mScreenHeight;
    private int mScreenWidth;

    class AnonymousClass31 implements AnimationListener {
        boolean jNE = false;
        final /* synthetic */ LinearLayout jNF;
        final /* synthetic */ SnsCommentDetailUI jNp;

        AnonymousClass31(SnsCommentDetailUI snsCommentDetailUI, LinearLayout linearLayout) {
            this.jNp = snsCommentDetailUI;
            this.jNF = linearLayout;
        }

        public final void onAnimationEnd(Animation animation) {
            if (this.jNF != null) {
                this.jNF.setPressed(false);
            }
            if (!this.jNE) {
                this.jNE = true;
                if (this.jNp.jMw != null) {
                    this.jNp.jMw.clearAnimation();
                    this.jNp.jMw.setVisibility(8);
                }
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    class b extends BaseAdapter {
        Activity aXH;
        public LinkedList<avr> jNL;
        LinkedList<avr> jNM;
        final /* synthetic */ SnsCommentDetailUI jNp;

        class a {
            ImageView dtX;
            TextView dyL;
            TextView fBO;
            TextView hWx;
            final /* synthetic */ b jNN;
            SnsTranslateResultView jNO;
            Object jNP;
            avr jNQ;
            String userName;

            a(b bVar) {
                this.jNN = bVar;
            }
        }

        public b(SnsCommentDetailUI snsCommentDetailUI, LinkedList<avr> linkedList, LinkedList<avr> linkedList2, Activity activity) {
            this.jNp = snsCommentDetailUI;
            this.jNL = linkedList;
            this.jNM = linkedList2;
            this.aXH = activity;
        }

        public final int getCount() {
            int i = 0;
            if (this.jNM.size() > 0) {
                if (this.jNL != null) {
                    i = this.jNL.size();
                }
                return i + 1;
            } else if (this.jNL != null) {
                return this.jNL.size();
            } else {
                return 0;
            }
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence tU;
            CharSequence charSequence;
            String tU2;
            if (this.jNM.size() > 0) {
                if (i == 0) {
                    return this.jNp.jir;
                }
                i--;
            }
            avr com_tencent_mm_protocal_c_avr = (avr) this.jNL.get(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = q.em(this.aXH).inflate(2130904445, null);
                view.setOnTouchListener(this.jNp.jFF);
                a aVar2 = new a(this);
                aVar2.dtX = (ImageView) view.findViewById(2131759327);
                aVar2.dtX.setOnClickListener(this.jNp.jNf);
                aVar2.hWx = (TextView) view.findViewById(2131759328);
                aVar2.hWx.setOnTouchListener(new y());
                aVar2.hWx.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b jNN;

                    {
                        this.jNN = r1;
                    }

                    public final void onClick(View view) {
                        v.i("MicroMsg.SnsCommentDetailUI", "onClick nickTv");
                    }
                });
                aVar2.fBO = (TextView) view.findViewById(2131759329);
                aVar2.dyL = (TextView) view.findViewById(2131759330);
                aVar2.jNO = (SnsTranslateResultView) view.findViewById(2131759300);
                aVar2.jNO.setVisibility(8);
                if (this.jNp.eKg == 11) {
                    view.findViewById(2131759324).setBackgroundResource(2130838269);
                    aVar = aVar2;
                } else {
                    aVar = aVar2;
                }
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jNQ = com_tencent_mm_protocal_c_avr;
            aVar.userName = com_tencent_mm_protocal_c_avr.mdw;
            int i2 = this.jNp.eKg == 11 ? 3 : 2;
            if (i == 0 && this.jNM.isEmpty()) {
                if (this.jNp.eKg == 11) {
                    view.setBackgroundResource(2130838270);
                } else {
                    view.setBackgroundResource(2130839211);
                }
            } else if (this.jNp.eKg == 11) {
                view.setBackgroundResource(2130839215);
            } else {
                view.setBackgroundResource(2130839214);
            }
            if (i == 0) {
                view.findViewById(2131759326).setVisibility(0);
                view.findViewById(2131759325).setVisibility(8);
                if (this.jNp.eKg == 11) {
                    ((ImageView) view.findViewById(2131759326)).setImageResource(2131165589);
                }
            } else {
                view.findViewById(2131759326).setVisibility(4);
                view.findViewById(2131759325).setVisibility(0);
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar.dtX, com_tencent_mm_protocal_c_avr.mdw, true);
            aVar.dtX.setTag(com_tencent_mm_protocal_c_avr.mdw);
            u LX = this.jNp.jMH.LX(com_tencent_mm_protocal_c_avr.mdw);
            if (LX != null) {
                tU = LX.tU();
            } else {
                Object obj = com_tencent_mm_protocal_c_avr.mGq != null ? com_tencent_mm_protocal_c_avr.mGq : com_tencent_mm_protocal_c_avr.mdw;
            }
            CharSequence charSequence2 = null;
            int i3 = 0;
            if (be.kS(com_tencent_mm_protocal_c_avr.mTc)) {
                charSequence = tU;
            } else {
                LX = this.jNp.jMH.LX(com_tencent_mm_protocal_c_avr.mTc);
                tU2 = LX == null ? com_tencent_mm_protocal_c_avr.mTc : LX.tU();
                String str = tU + this.jNp.getString(2131235510);
                int length = str.length();
                charSequence = str + tU2;
                int i4 = length;
                charSequence2 = tU2;
                i3 = i4;
            }
            aVar.hWx.setText(charSequence, BufferType.SPANNABLE);
            com.tencent.mm.pluginsdk.ui.d.e.e(aVar.hWx, 2);
            charSequence = new f(aVar.hWx.getText());
            charSequence.a(new j(com_tencent_mm_protocal_c_avr.mdw, this.jNp.jMK, i2), tU, 0, 33);
            if (charSequence2 != null) {
                charSequence.a(new j(com_tencent_mm_protocal_c_avr.mTc, this.jNp.jMK, i2), charSequence2, i3, 33);
            }
            aVar.hWx.setText(charSequence, BufferType.SPANNABLE);
            aVar.fBO.setText(aw.k(this.aXH, ((long) com_tencent_mm_protocal_c_avr.hNS) * 1000));
            aVar.dyL.setText(com_tencent_mm_protocal_c_avr.hQP + " ");
            aVar.dyL.setText(aVar.dyL.getText(), BufferType.SPANNABLE);
            aVar.dyL.setVisibility(0);
            com.tencent.mm.pluginsdk.ui.d.e.e(aVar.dyL, 2);
            this.jNp.eyZ.a(view, this.jNp.jMV.kbI, this.jNp.jMV.kbv);
            tU2 = am.cB(this.jNp.boC, String.valueOf(com_tencent_mm_protocal_c_avr.mSN != 0 ? (long) com_tencent_mm_protocal_c_avr.mSN : com_tencent_mm_protocal_c_avr.mSQ));
            if (am.aU(tU2, 4) && aVar.jNO != null) {
                com.tencent.mm.plugin.sns.e.am.b AA = am.AA(tU2);
                if (AA != null) {
                    aVar.jNO.setVisibility(0);
                    if (!AA.cvW) {
                        aVar.jNO.ri(2);
                    } else if (AA.cyo) {
                        aVar.jNO.setVisibility(8);
                    } else {
                        aVar.jNO.a(AA, 2, AA.bfz, AA.cDd, AA.jnq);
                    }
                } else {
                    aVar.jNO.setVisibility(8);
                }
            }
            view.setClickable(true);
            v.d("MicroMsg.SnsCommentDetailUI", "position " + com_tencent_mm_protocal_c_avr.mdw + " self " + this.jNp.bYE + " commentid " + com_tencent_mm_protocal_c_avr.mSN + " snsid " + this.jNp.boC);
            if (this.jNp.bYE.equals(com_tencent_mm_protocal_c_avr.mdw)) {
                aVar.jNP = com_tencent_mm_protocal_c_avr;
            } else {
                aVar.jNP = new Object[]{Integer.valueOf(i), com_tencent_mm_protocal_c_avr, com_tencent_mm_protocal_c_avr.mdw, tU};
            }
            k kVar = new k(this.jNp.boC, com_tencent_mm_protocal_c_avr, com_tencent_mm_protocal_c_avr.mdw, com_tencent_mm_protocal_c_avr.hQP, aVar.dyL, 2);
            kVar.tag = aVar;
            view.setTag(kVar);
            view.setOnClickListener(this.jNp.gsK);
            return view;
        }
    }

    class c implements Runnable {
        int Cx = -1;
        int eLQ;
        private int jNR = -1;
        private int jNS = 10;
        final /* synthetic */ SnsCommentDetailUI jNp;
        private int offset = 0;

        c(SnsCommentDetailUI snsCommentDetailUI) {
            this.jNp = snsCommentDetailUI;
        }

        public final void run() {
            if (!this.jNp.jME) {
                this.jNS = 10;
            }
            this.jNp.jME = true;
            this.jNR = this.jNp.jEp.getTop();
            int i = this.jNR - this.eLQ;
            v.i("MicroMsg.SnsCommentDetailUI", "list.bottom: %d, listOriginalBottom: %d, footerTop: %d, commentFooter.getTop: %d, topSelection: %d", new Object[]{Integer.valueOf(this.jNp.jMv.getBottom()), Integer.valueOf(this.jNp.jMD), Integer.valueOf(this.jNR), Integer.valueOf(this.jNp.jEp.getTop()), Integer.valueOf(i)});
            if (i != this.offset || this.jNp.jMv.getBottom() >= this.jNp.jMD - 150) {
                int i2 = this.jNS;
                this.jNS = i2 - 1;
                if (i2 > 0) {
                    new ac().postDelayed(this, 100);
                    this.offset = i;
                    return;
                }
                this.offset = 0;
                this.jNS = 0;
                return;
            }
            this.jNp.jMv.setSelectionFromTop(this.jNp.jMv.getHeaderViewsCount() + this.Cx, i);
            this.jNS = 0;
            this.offset = 0;
        }
    }

    class a extends j {
        final /* synthetic */ SnsCommentDetailUI jNp;

        a(SnsCommentDetailUI snsCommentDetailUI) {
            this.jNp = snsCommentDetailUI;
        }

        public final void onClick(View view) {
            this.jNp.jMO.jYT.onClick(view);
        }

        public final void updateDrawState(TextPaint textPaint) {
            int color = this.jNp.getResources().getColor(2131690028);
            if (this.hsl) {
                textPaint.bgColor = color;
            } else {
                textPaint.bgColor = 0;
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, int i, int i2, fp fpVar) {
        if (i2 == -1) {
            k gt = snsCommentDetailUI.gt(false);
            if (gt != null) {
                azr aUp = gt.aUp();
                if (aUp.mWq.mol == 1 && aUp.mWq.mom.size() == 4 && i > 1) {
                    i++;
                }
                if (snsCommentDetailUI.jNm != null) {
                    TagImageView tagImageView = (TagImageView) snsCommentDetailUI.jNm.findViewById(ao.jQI[i]);
                    if (tagImageView != null) {
                        int[] iArr = new int[2];
                        tagImageView.getLocationInWindow(iArr);
                        fpVar.beV.aXV = iArr[0];
                        fpVar.beV.aXW = iArr[1];
                        fpVar.beV.aXX = tagImageView.getWidth();
                        fpVar.beV.aXY = tagImageView.getHeight();
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, View view) {
        a aVar = view.getTag() instanceof k ? (a) ((k) view.getTag()).tag : null;
        if (aVar == null) {
            return;
        }
        if (aVar.jNP instanceof avr) {
            if (snsCommentDetailUI.jME) {
                snsCommentDetailUI.gs(false);
            }
            final avr com_tencent_mm_protocal_c_avr = (avr) aVar.jNP;
            final CharSequence charSequence = aVar.dyL.getText().toString();
            ActionBarActivity actionBarActivity = snsCommentDetailUI.nDR.nEl;
            String[] strArr = new String[]{snsCommentDetailUI.nDR.nEl.getString(2131231773), snsCommentDetailUI.nDR.nEl.getString(2131231020)};
            snsCommentDetailUI.nDR.nEl.getString(2131231010);
            com.tencent.mm.ui.base.g.a(actionBarActivity, null, strArr, new com.tencent.mm.ui.base.g.c(snsCommentDetailUI) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            this.jNp.fRJ.setText(charSequence);
                            com.tencent.mm.ui.base.g.bf(this.jNp.nDR.nEl, this.jNp.nDR.nEl.getString(2131231016));
                            return;
                        case 1:
                            int i2;
                            String str = "MicroMsg.SnsCommentDetailUI";
                            StringBuilder append = new StringBuilder("del snsId:").append(this.jNp.boC).append(" commentId:");
                            if (com_tencent_mm_protocal_c_avr != null) {
                                i2 = com_tencent_mm_protocal_c_avr.mSN;
                            } else {
                                i2 = 0;
                            }
                            v.e(str, append.append(i2).toString());
                            final com.tencent.mm.plugin.sns.e.p pVar = new com.tencent.mm.plugin.sns.e.p(s.BK(this.jNp.boC), s.zG(this.jNp.boC) ? 4 : 6, com_tencent_mm_protocal_c_avr);
                            ak.vy().a(pVar, 0);
                            SnsCommentDetailUI snsCommentDetailUI = this.jNp;
                            Object obj = this.jNp;
                            this.jNp.getString(2131231164);
                            snsCommentDetailUI.jEA = com.tencent.mm.ui.base.g.a(obj, this.jNp.getString(2131235388), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass36 jNK;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    ak.vy().c(pVar);
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            });
        } else if (aVar.jNP instanceof Object[]) {
            final Object[] objArr = (Object[]) aVar.jNP;
            SnsCommentFooter snsCommentFooter = snsCommentDetailUI.jEp;
            boolean z = !(snsCommentFooter.jkg == null || snsCommentFooter.jkg.mdw == null || !snsCommentFooter.jkg.mdw.equals((String) objArr[2])) || snsCommentFooter.aWJ();
            if (z) {
                snsCommentDetailUI.jEp.a(snsCommentDetailUI.getString(2131235510) + objArr[3], (avr) objArr[1]);
                snsCommentDetailUI.jEp.gu(true);
                int intValue = ((Integer) objArr[0]).intValue();
                if (ah.n(com.tencent.mm.plugin.sns.storage.f.Bq(snsCommentDetailUI.jMG)).mTk.size() > 0) {
                    intValue++;
                    if (intValue > snsCommentDetailUI.jMx.getCount()) {
                        intValue = snsCommentDetailUI.jMx.getCount() - 1;
                    }
                }
                snsCommentDetailUI.jNe.Cx = intValue;
                snsCommentDetailUI.jNe.eLQ = view.getHeight();
                snsCommentDetailUI.jNe.run();
                return;
            }
            String[] strArr2 = new String[]{snsCommentDetailUI.getString(2131235510) + objArr[3]};
            snsCommentDetailUI.getString(2131231010);
            com.tencent.mm.ui.base.g.a(snsCommentDetailUI, null, strArr2, new com.tencent.mm.ui.base.g.c(snsCommentDetailUI) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            this.jNp.jEp.aWM();
                            this.jNp.jEp.a(this.jNp.getString(2131235510) + objArr[3], (avr) objArr[1]);
                            this.jNp.jEp.gu(true);
                            this.jNp.jNe.Cx = ((Integer) objArr[0]).intValue();
                            this.jNp.jNe.run();
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str) {
        am.aS(str, 4);
        if (snsCommentDetailUI.jMx != null) {
            snsCommentDetailUI.jMx.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, avr com_tencent_mm_protocal_c_avr) {
        if (str != null && !str.trim().equals("") && s.BM(snsCommentDetailUI.boC)) {
            k Bp = com.tencent.mm.plugin.sns.storage.f.Bp(snsCommentDetailUI.boC);
            avr a = com.tencent.mm.plugin.sns.e.ak.a.a(Bp, Bp.qC(32) ? 8 : 2, str, com_tencent_mm_protocal_c_avr, true);
            if (ah.m(Bp) != null) {
                b bVar = snsCommentDetailUI.jMx;
                bVar.jNL.add(a);
                bVar.notifyDataSetChanged();
                new ac().postDelayed(new Runnable(bVar) {
                    final /* synthetic */ b jNN;

                    {
                        this.jNN = r1;
                    }

                    public final void run() {
                        this.jNN.jNp.jMv.setSelection((this.jNN.jNp.jMv.getHeaderViewsCount() + this.jNN.jNL.size()) - 1);
                    }
                }, 60);
            }
        }
    }

    static /* synthetic */ void a(SnsCommentDetailUI snsCommentDetailUI, String str, String str2, String str3) {
        k gt = snsCommentDetailUI.gt(false);
        if (gt != null && gt.aUq().equals(str)) {
            if (be.kS(str2)) {
                snsCommentDetailUI.jMW.setVisibility(8);
            } else {
                am.aS(str, 4);
                com.tencent.mm.plugin.sns.e.am.b AA = am.AA(str);
                snsCommentDetailUI.jMW.setVisibility(0);
                snsCommentDetailUI.jMW.a(AA, 1, str2, str3, AA.jnq);
            }
            snsCommentDetailUI.jMs.setTag(new ap(snsCommentDetailUI.boC, gt.aUL(), true, false, 2));
        }
    }

    static /* synthetic */ void b(SnsCommentDetailUI snsCommentDetailUI, String str) {
        if (snsCommentDetailUI.gt(false).aUq().equals(str)) {
            snsCommentDetailUI.jMW.setVisibility(0);
            snsCommentDetailUI.jMW.ri(1);
        }
    }

    static /* synthetic */ void c(SnsCommentDetailUI snsCommentDetailUI, String str) {
        am.aS(str, 4);
        if (snsCommentDetailUI.jMx != null) {
            snsCommentDetailUI.jMx.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void d(SnsCommentDetailUI snsCommentDetailUI, String str) {
        k gt = snsCommentDetailUI.gt(false);
        if (gt.aUq().equals(str)) {
            am.aT(str, 4);
            snsCommentDetailUI.jMW.setVisibility(8);
            snsCommentDetailUI.jMs.setTag(new ap(snsCommentDetailUI.boC, gt.aUL(), true, false, 2));
        }
    }

    static /* synthetic */ void e(SnsCommentDetailUI snsCommentDetailUI, String str) {
        am.aT(str, 4);
        if (snsCommentDetailUI.jMx != null) {
            snsCommentDetailUI.jMx.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void r(SnsCommentDetailUI snsCommentDetailUI) {
        snsCommentDetailUI.jEp.isShown();
        int count = snsCommentDetailUI.jMx.getCount() - 1;
        if (ah.m(com.tencent.mm.plugin.sns.storage.f.Bp(snsCommentDetailUI.boC)).mTk.size() > 0) {
            count++;
            if (count > snsCommentDetailUI.jMx.getCount()) {
                count = snsCommentDetailUI.jMx.getCount() - 1;
            }
        }
        snsCommentDetailUI.jNe.Cx = count;
        snsCommentDetailUI.jNe.run();
    }

    static /* synthetic */ void s(SnsCommentDetailUI snsCommentDetailUI) {
        int i = 1;
        if (s.BM(snsCommentDetailUI.boC)) {
            k Bp = com.tencent.mm.plugin.sns.storage.f.Bp(snsCommentDetailUI.boC);
            if (Bp.field_likeFlag == 0) {
                Bp.field_likeFlag = 1;
                com.tencent.mm.plugin.sns.storage.f.a(Bp.aUq(), Bp);
                if (Bp.qC(32)) {
                    i = 7;
                }
                com.tencent.mm.plugin.sns.e.ak.a.a(Bp, i, "");
                snsCommentDetailUI.jMx.notifyDataSetChanged();
            } else {
                Bp.field_likeFlag = 0;
                com.tencent.mm.plugin.sns.storage.f.a(Bp.aUq(), Bp);
                com.tencent.mm.plugin.sns.e.ak.a.Ay(Bp.aUq());
            }
            awa m = ah.m(com.tencent.mm.plugin.sns.storage.f.Bp(snsCommentDetailUI.boC));
            if (m != null) {
                snsCommentDetailUI.jMC = m.mTk;
                snsCommentDetailUI.e(m.mTk, m.mTn.isEmpty());
                b bVar = snsCommentDetailUI.jMx;
                bVar.jNM = m.mTk;
                bVar.notifyDataSetChanged();
            }
        }
    }

    private static boolean e(LinkedList<avr> linkedList, LinkedList<avr> linkedList2) {
        if (linkedList == null || linkedList2 == null) {
            return false;
        }
        if (linkedList.size() != linkedList2.size()) {
            return false;
        }
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            if (!((avr) linkedList.get(i)).mdw.equals(((avr) linkedList2.get(i)).mdw)) {
                return false;
            }
        }
        return true;
    }

    private void gs(boolean z) {
        this.jME = false;
        if (this.jEp.aWJ()) {
            this.jEp.aWM();
            this.jEp.BZ(getString(2131235571));
        }
        this.jEp.gu(false);
        if (z) {
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.jMv);
        }
    }

    private k gt(boolean z) {
        if (ak.uM()) {
            ak.yY();
        }
        k Bp;
        if (be.kS(this.jMG)) {
            Bp = com.tencent.mm.plugin.sns.storage.f.Bp(this.boC);
            if (Bp == null) {
                finish();
                return null;
            }
            this.jMG = Bp.aUL();
            return Bp;
        }
        Bp = com.tencent.mm.plugin.sns.storage.f.Bq(this.jMG);
        if (Bp == null) {
            if (z) {
                Toast.makeText(this, 2131235486, 0).show();
            }
            finish();
            return null;
        }
        this.boC = Bp.aUq();
        return Bp;
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        com.tencent.mm.pluginsdk.e.f(this);
        super.onCreate(bundle);
        ad.aSu().a(5, "@__weixintimtline", (com.tencent.mm.pluginsdk.j.q.e.a) this);
        this.fRJ = (ClipboardManager) getSystemService("clipboard");
        this.jMp = System.currentTimeMillis();
        this.eyZ = new l(this);
        this.jMO = new bd(this, new com.tencent.mm.plugin.sns.ui.bd.a(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            {
                this.jNp = r1;
            }

            public final void aWG() {
                this.jNp.aWF();
            }
        }, 1, this.jMZ);
        this.jMV = new com.tencent.mm.plugin.sns.ui.b.b(this, this, this.jMZ) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            public final void b(View view, int i, int i2, int i3) {
            }

            public final void aY(Object obj) {
                this.jNp.aWE();
                this.jNp.jEr.a((View) obj, 2, null);
            }

            public final void aVv() {
            }

            public final void ch(View view) {
            }

            public final void cg(View view) {
            }

            public final void cf(View view) {
            }

            public final void ci(View view) {
                this.jNp.jEx.ce(view);
            }

            public final void aVw() {
                this.jNp.jEx.aTn();
                Intent intent = new Intent();
                intent.putExtra("result_finish", true);
                this.jNp.setResult(-1, intent);
                this.jNp.finish();
            }
        };
        FrameLayout frameLayout = (FrameLayout) findViewById(2131759318);
        this.jEy = new com.tencent.mm.plugin.sns.f.b(this, this.jMV, frameLayout);
        this.jEx = new b(this, this.jMV, frameLayout, this.jEy);
        this.jMV.aYq();
        this.boC = be.ah(getIntent().getStringExtra("INTENT_SNSID"), "");
        if (be.kS(this.boC)) {
            this.boC = s.A("sns_table_", getIntent().getLongExtra("INTENT_SNSID", 0));
        }
        this.jMG = be.ah(getIntent().getStringExtra("INTENT_SNS_LOCAL_ID"), "");
        if (be.kS(this.jMG)) {
            int intExtra = getIntent().getIntExtra("INTENT_SNS_LOCAL_ID", -1);
            if (intExtra != -1) {
                this.jMG = s.A("sns_table_", (long) intExtra);
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("INTENT_SNS_TIMELINEOBJECT");
        if (byteArrayExtra != null) {
            azr com_tencent_mm_protocal_c_azr = new azr();
            try {
                com_tencent_mm_protocal_c_azr.az(byteArrayExtra);
                if (ad.aSE().dd(new BigInteger(com_tencent_mm_protocal_c_azr.gID).longValue()) == null) {
                    v.i("MicroMsg.SnsCommentDetailUI", "info is null, can insert to sns info");
                    k kVar = new k();
                    kVar.field_snsId = new BigInteger(com_tencent_mm_protocal_c_azr.gID).longValue();
                    try {
                        kVar.field_content = com_tencent_mm_protocal_c_azr.toByteArray();
                    } catch (Exception e) {
                    }
                    kVar.field_createTime = com_tencent_mm_protocal_c_azr.hNS;
                    kVar.field_userName = com_tencent_mm_protocal_c_azr.gln;
                    kVar.field_type = com_tencent_mm_protocal_c_azr.mWq.mol;
                    kVar.aUI();
                    awa com_tencent_mm_protocal_c_awa = new awa();
                    com_tencent_mm_protocal_c_awa.mTg = new are();
                    try {
                        kVar.field_attrBuf = com_tencent_mm_protocal_c_awa.toByteArray();
                    } catch (IOException e2) {
                    }
                    ad.aSE().b(kVar);
                    v.i("MicroMsg.FTS.SnsComment", "insert sns obj use time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                } else {
                    v.i("MicroMsg.SnsCommentDetailUI", "info is not null, can not insert to sns info");
                }
            } catch (IOException e3) {
            }
        }
        k gt = gt(true);
        v.i("MicroMsg.SnsCommentDetailUI", "onCreate()  snsId : " + this.boC + " localSnsId: " + this.jMG);
        if (gt != null) {
            v.i("MicroMsg.SnsCommentDetailUI", "commentdetail %s", new Object[]{be.ah(gt.field_userName, "")});
        }
        if (s.BM(this.boC)) {
            if (!s.zG(this.boC)) {
                ak.vy().a(new com.tencent.mm.plugin.sns.e.k(s.BK(this.boC), 0), 0);
            } else if (gt == null) {
                ak.vy().a(new o(s.BK(this.boC)), 0);
            } else if (!m.eB(gt.field_userName)) {
                ak.vy().a(new o(s.BK(this.boC)), 0);
            }
        }
        ak.vy().a(210, this);
        ak.vy().a(218, this);
        ak.vy().a(213, this);
        ak.vy().a(682, this);
        ak.vy().a(214, this);
        ak.vy().a(683, this);
        this.jMH = ad.aSs();
        this.jEr = new al(this);
        this.jMF = new ao(this.nDR.nEl);
        this.jMK = new i(this, 1, this.jMZ);
        if (gt != null) {
            this.eKg = as.c(gt.aUp());
        }
        if (gt != null && gt.qC(32)) {
            this.jMU = new g(2);
            as.c(gt.aUp());
        }
        NI();
        if (gt != null && gt.qC(32)) {
            this.jMU.a(0, gt.aUL(), gt.aUQ(), gt.aUH(), this.jMr, gt.field_snsId, this.jNo, ah.m(gt), this.eKg);
        }
        if (this.jMr != null) {
            com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) this.jMr.findViewById(2131755052);
            if (gt.aUp().mWq.mol == 15 && (aVar instanceof SightPlayImageView)) {
                z = ((SightPlayImageView) aVar).iUW.aPe();
            }
            com.tencent.mm.plugin.sns.a.a.j.a(gt, true, z);
        }
        if (this.jMv != null) {
            this.jMv.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                {
                    this.jNp = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (this.jNp.jEx != null) {
                        this.jNp.jEx.aTn();
                    }
                    return false;
                }
            });
            com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
            com.tencent.mm.sdk.c.a.nhr.e(this.jNa);
            com.tencent.mm.sdk.c.a.nhr.e(this.jNb);
            com.tencent.mm.sdk.c.a.nhr.e(this.jNc);
            com.tencent.mm.sdk.c.a.nhr.e(this.jNd);
            com.tencent.mm.sdk.c.a.nhr.e(this.jNh);
            com.tencent.mm.sdk.c.a.nhr.e(this.jNi);
            com.tencent.mm.pluginsdk.e.g(this);
        }
    }

    public void onDestroy() {
        ad.aSu().a(this, 5);
        ak.vy().b(210, this);
        ak.vy().b(218, this);
        ak.vy().b(213, this);
        ak.vy().b(214, this);
        ak.vy().b(683, this);
        ak.vy().b(682, this);
        ad.aSB().M(this);
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        if (this.jMK != null) {
            this.jMK.aXH = null;
        }
        y.aVR();
        if (this.jEp != null) {
            this.jEp.ayA();
        }
        k gt = gt(false);
        if (!(this.jMU == null || gt == null || !gt.qC(32))) {
            this.jMU.u(0, gt.aUL(), gt.aUQ());
            com.tencent.mm.plugin.sns.storage.a aUo = gt.aUo();
            String str = aUo == null ? "" : aUo.jpt;
            i aSy = ad.aSy();
            Object[] objArr = new Object[1];
            objArr[0] = com.tencent.mm.plugin.sns.a.a.f.a(gt.field_snsId, com.tencent.mm.plugin.sns.data.i.cE(gt.field_snsId), str, Long.valueOf(this.jMp), Long.valueOf(System.currentTimeMillis()));
            aSy.h(12012, objArr);
            com.tencent.mm.modelsns.a gi = com.tencent.mm.modelsns.a.gi(732);
            gi.kj(com.tencent.mm.plugin.sns.data.i.cE(gt.field_snsId)).kj(str).kj(this.jMp).kj(System.currentTimeMillis());
            gi.JF();
        }
        this.jMV.afF();
        com.tencent.mm.sdk.c.a.nhr.f(this.jNa);
        com.tencent.mm.sdk.c.a.nhr.f(this.jNb);
        com.tencent.mm.sdk.c.a.nhr.f(this.jNc);
        com.tencent.mm.sdk.c.a.nhr.f(this.jNd);
        com.tencent.mm.sdk.c.a.nhr.f(this.jNh);
        com.tencent.mm.sdk.c.a.nhr.f(this.jNi);
        super.onDestroy();
    }

    public void onResume() {
        ad.aSz().a((com.tencent.mm.plugin.sns.e.b.b) this);
        if (this.jEp != null) {
            SnsCommentFooter snsCommentFooter = this.jEp;
            if (s.BM(this.boC)) {
                if (snsCommentFooter.jNU != null) {
                    snsCommentFooter.jNU.setEnabled(true);
                }
                if (snsCommentFooter.jNT != null) {
                    snsCommentFooter.jNT.setEnabled(true);
                }
            } else {
                if (snsCommentFooter.jNU != null) {
                    snsCommentFooter.jNU.setEnabled(false);
                }
                if (snsCommentFooter.jNT != null) {
                    snsCommentFooter.jNT.setEnabled(false);
                }
            }
        }
        pn pnVar = new pn();
        pnVar.bqP.bqQ = 0;
        pnVar.bqP.bqR = 1;
        pnVar.bqP.bqS = 0;
        pnVar.bqP.type = 0;
        com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        if (this.jMU != null) {
            this.jMU.onResume();
        }
        super.onResume();
    }

    public void onPause() {
        ad.aSz().b((com.tencent.mm.plugin.sns.e.b.b) this);
        super.onPause();
        new pn().bqP.type = 1;
        if (this.jHl != null) {
            this.jHl.dismiss();
            this.jHl = null;
        }
        if (this.jMU != null) {
            this.jMU.evC = be.Nj();
        }
    }

    protected final int getLayoutId() {
        return 2130904443;
    }

    protected final void NI() {
        vD(2131235385);
        AnonymousClass17 anonymousClass17 = new OnClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            {
                this.jNp = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.a(this.jNp.jMv);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            {
                this.jNp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.jNp.jEp != null) {
                    this.jNp.jEp.gu(false);
                }
                this.jNp.finish();
                return true;
            }
        });
        this.bYE = com.tencent.mm.model.k.xF();
        if (ad.aSn()) {
            finish();
        }
        final k gt = gt(true);
        if (gt == null) {
            v.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.boC);
            finish();
            return;
        }
        boolean z;
        v.i("MicroMsg.SnsCommentDetailUI", "snsId: " + this.boC + "localId " + this.jMG + "  username:" + gt.field_userName);
        if (!s.BM(this.boC) && gt.aUN()) {
            aic aUD = gt.aUD();
            findViewById(2131759319).setVisibility(0);
            TextView textView = (TextView) findViewById(2131759320);
            switch (aUD.mIt) {
                case 201:
                    if (be.kS(aUD.mIB)) {
                        textView.setText(2131235504);
                    } else {
                        textView.setText(aUD.mIB);
                    }
                    findViewById(2131759321).setVisibility(8);
                    z = false;
                    break;
                case 210:
                    if (be.kS(aUD.mIB)) {
                        textView.setText(2131235506);
                    } else {
                        textView.setText(aUD.mIB);
                    }
                    findViewById(2131759321).setVisibility(8);
                    z = false;
                    break;
                case 211:
                    if (be.kS(aUD.mIB)) {
                        textView.setText(2131235505);
                    } else {
                        textView.setText(aUD.mIB);
                    }
                    findViewById(2131759321).setVisibility(8);
                    z = true;
                    break;
                default:
                    if (be.kS(aUD.mIB)) {
                        textView.setText(2131235507);
                    } else {
                        textView.setText(aUD.mIB);
                    }
                    findViewById(2131759321).setVisibility(0);
                    z = true;
                    break;
            }
        }
        findViewById(2131759319).setVisibility(8);
        z = false;
        if (z) {
            findViewById(2131759319).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                public final void onClick(View view) {
                    if (!gt.qC(32)) {
                        ah.qh(gt.jBI);
                        ah.qf(gt.jBI);
                        ad.aSA().aTe();
                        Intent intent = new Intent();
                        this.jNp.setResult(-1, intent);
                        if (this.jNp.dFB) {
                            intent.putExtra("sns_gallery_force_finish", true);
                        }
                        this.jNp.finish();
                        this.jNp.finish();
                    }
                }
            });
        }
        this.jMv = (ListView) findViewById(2131759322);
        this.jMv.post(new Runnable(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            {
                this.jNp = r1;
            }

            public final void run() {
                this.jNp.jMD = this.jNp.jMv.getBottom();
                v.d("MicroMsg.SnsCommentDetailUI", "listOriginalBottom: " + this.jNp.jMD);
            }
        });
        this.jMv.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            {
                this.jNp = r1;
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 1) {
                    this.jNp.axg();
                }
            }
        });
        if ((this.eKg != 2 && this.eKg != 9) || !gt.qC(32)) {
            this.jMr = q.em(this.nDR.nEl).inflate(2130904444, null);
        } else if (gt.aUm().juN == 1) {
            this.jMr = q.em(this.nDR.nEl).inflate(2130904441, null);
        } else {
            this.jMr = q.em(this.nDR.nEl).inflate(2130904444, null);
        }
        this.jMr.setOnClickListener(this.jNg);
        this.jMv.addHeaderView(this.jMr);
        z = aWD();
        if (z) {
            k gt2 = gt(false);
            if (gt2 != null) {
                this.eKg = as.c(gt2.aUp());
            }
            if (this.eKg == 11 && com.tencent.mm.model.k.xF().equals(gt.field_userName)) {
                this.jMu = new SnsDetailLuckyHeader(this);
                this.jMu.setLayoutParams(new LayoutParams(-1, -2));
                this.jMu.setOnClickListener(this.jNg);
            }
            this.jMt = new LinearLayout(this.nDR.nEl);
            this.jMt.setLayoutParams(new LayoutParams(-1, -2));
            this.jMt.setOnClickListener(this.jNg);
            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 2.0f);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 1);
            LinearLayout linearLayout = new LinearLayout(this.nDR.nEl);
            linearLayout.setBackgroundResource(2130839218);
            linearLayout.setLayoutParams(layoutParams);
            this.jir = linearLayout;
            if ((gt.field_localPrivate & 1) != 0) {
                findViewById(2131759323).setVisibility(8);
                View textView2 = new TextView(this);
                textView2.setLayoutParams(new LayoutParams(-1, -2));
                textView2.setText(getString(2131235391));
                textView2.setTextColor(getResources().getColor(2131689547));
                textView2.setGravity(17);
                textView2.setPadding(0, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 7.0f), 0, 0);
                this.jMv.addFooterView(textView2);
            }
            if (this.jMu != null) {
                this.jMX = true;
                this.jMv.addHeaderView(this.jMu);
            }
            awa m = ah.m(gt);
            if (m == null) {
                this.jMt.setVisibility(8);
                this.jMx = new b(this, new LinkedList(), new LinkedList(), this);
            } else {
                this.jMC = m.mTk;
                e(m.mTk, m.mTn.isEmpty());
                if (this.jMu != null) {
                    this.jMu.a(gt, this.jMV);
                }
                this.jMx = new b(this, m.mTn, m.mTk, this);
            }
            this.jMv.addHeaderView(this.jMt);
            this.jMv.setAdapter(this.jMx);
            this.jEp = (SnsCommentFooter) findViewById(2131759323);
            this.jEp.jNX = new a(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                public final void aWH() {
                    if (x.Ac(gt.aUL())) {
                        if (!this.jNp.jEp.hhO) {
                            SnsCommentDetailUI.r(this.jNp);
                        }
                    } else if (this.jNp.jMY == null || !this.jNp.jMY.isShowing()) {
                        this.jNp.jMY = com.tencent.mm.plugin.sns.lucky.ui.b.e(this.jNp.nDR.nEl, this.jNp.jNm.qQ(0));
                    }
                }
            };
            this.jEp.jNY = new d(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                {
                    this.jNp = r1;
                }

                public final void aEU() {
                    if (!this.jNp.jEp.hhO) {
                        SnsCommentDetailUI.r(this.jNp);
                    }
                }
            };
            gt2 = gt(true);
            if (!(gt2 == null || gt2.aUK())) {
                this.jEp.setVisibility(8);
            }
            this.jEp.aWK();
            this.jEp.aWL();
            this.jEp.a(new c(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                public final void BP(String str) {
                    if (x.Ac(gt.aUL())) {
                        SnsCommentDetailUI.a(this.jNp, str, this.jNp.jEp.aWN());
                        this.jNp.jEp.gu(false);
                        v.i("MicroMsg.SnsCommentDetailUI", "comment send imp!");
                        return;
                    }
                    com.tencent.mm.plugin.sns.lucky.ui.b.e(this.jNp.nDR.nEl, this.jNp.jNm.qQ(0));
                }
            });
            SnsCommentFooter snsCommentFooter = this.jEp;
            b anonymousClass15 = new b(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                {
                    this.jNp = r1;
                }

                public final void aWI() {
                    SnsCommentDetailUI.s(this.jNp);
                    if (this.jNp.jMv.getFirstVisiblePosition() > 1 || this.jNp.jMv.getLastVisiblePosition() <= 0) {
                        com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c.b(this.jNp.jMv, 1);
                    }
                }
            };
            int i = gt.field_likeFlag;
            snsCommentFooter.jNT.setVisibility(0);
            snsCommentFooter.jNT.setOnClickListener(new com.tencent.mm.plugin.sns.ui.SnsCommentFooter.AnonymousClass7(snsCommentFooter, anonymousClass15));
            this.jEp.aWO();
            this.jMM = getIntent().getBooleanExtra("INTENT_FROMSUI", false);
            if (this.jMM) {
                this.jMN = getIntent().getLongExtra("INTENT_FROMSUI_COMMENTID", 0);
                if (!(this.jMN == 0 || this.jMx.jNL == null)) {
                    int i2 = 0;
                    while (i2 < this.jMx.jNL.size()) {
                        avr com_tencent_mm_protocal_c_avr = (avr) this.jMx.jNL.get(i2);
                        if ((com_tencent_mm_protocal_c_avr.mSN != 0 ? (long) com_tencent_mm_protocal_c_avr.mSN : com_tencent_mm_protocal_c_avr.mSQ) == this.jMN) {
                            this.jMv.setSelection(i2);
                            u LX = this.jMH.LX(com_tencent_mm_protocal_c_avr.mdw);
                            String tU = LX != null ? LX.tU() : com_tencent_mm_protocal_c_avr.mGq != null ? com_tencent_mm_protocal_c_avr.mGq : com_tencent_mm_protocal_c_avr.mdw;
                            this.jEp.a(getString(2131235510) + tU, com_tencent_mm_protocal_c_avr);
                        } else {
                            i2++;
                        }
                    }
                }
            }
            if (this.jMM) {
                new ac().post(new Runnable(this) {
                    final /* synthetic */ SnsCommentDetailUI jNp;

                    {
                        this.jNp = r1;
                    }

                    public final void run() {
                        this.jNp.axg();
                    }
                });
            }
            this.jMW = (SnsTranslateResultView) this.jMr.findViewById(2131759300);
            this.jMW.ae(((TextView) this.jMr.findViewById(2131755458)).getTextSize());
            this.jMW.iBv.setBackgroundResource(2130839207);
            this.jMW.iBv.setTag(new ap(this.boC, gt.aUL(), false, true, 2));
            this.eyZ.a(this.jMW.iBv, this.jMV.kby, this.jMV.kbv);
            if (am.aU(this.boC, 4)) {
                com.tencent.mm.plugin.sns.e.am.b AA = am.AA(this.boC);
                if (AA == null || !AA.cvW) {
                    this.jMW.setVisibility(8);
                    return;
                }
                this.jMW.setVisibility(0);
                this.jMW.a(null, 1, AA.bfz, AA.cDd, false);
                return;
            }
            this.jMW.setVisibility(8);
            return;
        }
        v.i("MicroMsg.SnsCommentDetailUI", "error isOk setheader " + z);
        finish();
    }

    private LinearLayout qU(int i) {
        if (this.jNk == null) {
            this.jNk = (LinearLayout) q.em(this).inflate(i, null);
            return this.jNk;
        }
        this.jNj = true;
        return this.jNk;
    }

    private static boolean aWC() {
        return (com.tencent.mm.plugin.sns.e.ak.a.aTb() & 1) <= 0;
    }

    final boolean aWD() {
        final k gt = gt(true);
        if (gt == null) {
            return false;
        }
        v.i("MicroMsg.SnsCommentDetailUI", "setheader " + this.jMr.toString());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        bzS().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.mScreenWidth = this.mScreenHeight < this.mScreenWidth ? this.mScreenHeight : this.mScreenWidth;
        this.jMQ = ad.aSK();
        final azr aUp = gt.aUp();
        this.eKg = as.c(aUp);
        ImageView imageView = (ImageView) this.jMr.findViewById(2131759292);
        if (imageView == null || gt == null) {
            v.e("MicroMsg.SnsCommentDetailUI", "unknow error ? " + (imageView == null) + " " + (gt == null));
            return false;
        }
        ((MaskImageButton) imageView).oTP = gt.aUL();
        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, gt.getUserName(), true);
        imageView.setTag(gt.getUserName());
        imageView.setOnClickListener(this.jMV.kbw);
        TextView textView = (TextView) this.jMr.findViewById(2131756539);
        u LX = this.jMH.LX(gt.getUserName());
        v.i("MicroMsg.SnsCommentDetailUI", "snsinfo username " + gt.getUserName() + " " + gt.aUq() + " " + gt.aUE());
        if (LX == null) {
            return false;
        }
        String aUL;
        int hashCode;
        String aUL2;
        String str;
        if (LX.tS() == 0) {
            v.i("MicroMsg.SnsCommentDetailUI", "getContact %s", new Object[]{gt.getUserName()});
            com.tencent.mm.model.ab.a.yF().a(gt.getUserName(), "", this.jNn);
        }
        CharSequence ah = be.ah(LX == null ? gt.getUserName() : LX.tU(), "");
        if (gt.aUT() && be.kS(ah)) {
            com.tencent.mm.plugin.sns.storage.b aUm = gt.aUm();
            if (!(aUm == null || be.kS(aUm.cID))) {
                ah = aUm.cID;
            }
        }
        ah.length();
        int i = this.eKg == 11 ? 3 : 2;
        CharSequence fVar = new f(com.tencent.mm.pluginsdk.ui.d.e.a(this, ah));
        fVar.f(new j(new com.tencent.mm.plugin.sns.data.a(gt.aUT(), LX.getUsername(), gt.aUL(), 2), this.jMK, i), ah);
        textView.setOnTouchListener(new y());
        textView.setText(fVar, BufferType.SPANNABLE);
        ((TextView) this.jMr.findViewById(2131759299)).setText("");
        this.jNo = new bc(this.jMr);
        if (gt.aUT()) {
            this.jNo.p(Long.valueOf(gt.field_snsId), new com.tencent.mm.plugin.sns.data.b(this.jNo, 0, this.jMG, gt.field_snsId));
            this.jNo.a(gt.aUm(), gt.aUo());
            this.jNo.a(this.jMV.kbF, this.jMV.kbS);
            this.jNo.setVisibility(0);
        } else {
            this.jNo.setVisibility(8);
        }
        String str2 = aUp.mWn;
        this.jMs = (TextView) this.jMr.findViewById(2131755458);
        this.jMs.setTag(new ap(this.boC, gt.aUL(), true, false, 2));
        this.eyZ.a(this.jMs, this.jMV.kby, this.jMV.kbv);
        if (str2 == null || str2.equals("")) {
            this.jMs.setVisibility(8);
        } else {
            this.jMs.setText(str2 + " ");
            com.tencent.mm.pluginsdk.ui.d.e.e(this.jMs, 2);
            this.jMs.setVisibility(0);
        }
        as.d(aUp);
        ViewStub viewStub = (ViewStub) this.jMr.findViewById(2131759294);
        if (!this.jNl) {
            if (this.eKg == 2) {
                viewStub.setLayoutResource(2130904510);
            } else if (this.eKg == 3) {
                viewStub.setLayoutResource(2130904507);
            } else if (this.eKg == 4) {
                viewStub.setLayoutResource(2130904508);
            } else if (this.eKg == 5) {
                viewStub.setLayoutResource(2130904509);
            } else if (this.eKg != 6) {
                if (this.eKg == 1 || this.eKg == 0) {
                    viewStub.setLayoutResource(2130904476);
                } else if (this.eKg == 9) {
                    viewStub.setLayoutResource(2130904474);
                } else if (this.eKg == 11) {
                    viewStub.setLayoutResource(2130904453);
                }
            }
            if (this.eKg == 2 || this.eKg == 3 || this.eKg == 4 || this.eKg == 5) {
                this.jNm = (PhotosContent) viewStub.inflate();
            } else if (this.eKg == 9) {
                viewStub.inflate();
            } else if (this.eKg == 11) {
                this.jNm = (PhotosContent) viewStub.inflate();
            } else {
                viewStub.setVisibility(8);
            }
            this.jNl = true;
        }
        if (this.eKg != 6) {
            TagImageView tagImageView;
            float a;
            float a2;
            int width;
            float f;
            ao aoVar;
            PhotosContent photosContent;
            int i2;
            if (this.eKg == 2 || this.eKg == 3 || this.eKg == 4 || this.eKg == 5) {
                if (this.jNm != null) {
                    this.jNm.aWi();
                    for (int i3 = 0; i3 < ao.jQE[this.eKg]; i3++) {
                        tagImageView = (TagImageView) this.jNm.findViewById(ao.jQI[i3]);
                        this.jNm.a(tagImageView);
                        tagImageView.setOnClickListener(this.jMV.jIT);
                        this.eyZ.a(tagImageView, this.jMV.kbJ, this.jMV.kbv);
                    }
                    this.jNm.qP(this.jMQ);
                    final List linkedList = new LinkedList();
                    if (gt.aUT() && this.eKg == 2) {
                        final com.tencent.mm.plugin.sns.storage.b aUm2 = gt.aUm();
                        if (aUm2 != null && aUm2.juP > 0.0f && aUm2.juQ > 0.0f) {
                            a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm2.juP, 1, aUm2.juR, aUm2.juS);
                            a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm2.juQ, 1, aUm2.juR, aUm2.juS);
                            if (aUm2.juO == 0) {
                                width = ((WindowManager) bzS().getSystemService("window")).getDefaultDisplay().getWidth();
                                if (a >= ((float) (((width - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)))) {
                                    a2 = (float) (((width - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12));
                                    f = (float) ((int) ((aUm2.juQ * a2) / aUm2.juP));
                                } else {
                                    f = a2;
                                    a2 = a;
                                }
                                aid com_tencent_mm_protocal_c_aid = new aid();
                                com_tencent_mm_protocal_c_aid.mID = a2;
                                com_tencent_mm_protocal_c_aid.lHK = f;
                                com_tencent_mm_protocal_c_aid.mIE = com_tencent_mm_protocal_c_aid.mID * com_tencent_mm_protocal_c_aid.lHK;
                                linkedList.add(com_tencent_mm_protocal_c_aid);
                            } else if (aUm2.juO == 1) {
                                width = (((((WindowManager) bzS().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12);
                                r3 = (int) ((((float) width) * aUm2.juQ) / aUm2.juP);
                                r4 = new aid();
                                if (width > 0) {
                                    a = (float) width;
                                }
                                r4.mID = a;
                                if (r3 > 0) {
                                    a2 = (float) r3;
                                }
                                r4.lHK = a2;
                                r4.mIE = r4.mID * r4.lHK;
                                linkedList.add(r4);
                            } else if (aUm2.juO == 2) {
                                width = ((((WindowManager) bzS().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12);
                                r3 = (int) ((((float) width) * aUm2.juQ) / aUm2.juP);
                                r4 = new aid();
                                if (width > 0) {
                                    a = (float) width;
                                }
                                r4.mID = a;
                                if (r3 > 0) {
                                    a2 = (float) r3;
                                }
                                r4.lHK = a2;
                                r4.mIE = r4.mID * r4.lHK;
                                linkedList.add(r4);
                            }
                        }
                        if (!be.kS(aUm2.juU)) {
                            final PhotosContent photosContent2 = this.jNm;
                            final TagImageView qQ = this.jNm.qQ(0);
                            d.a("adId", aUm2.juU, false, 41, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a(this) {
                                final /* synthetic */ SnsCommentDetailUI jNp;

                                public final void aRx() {
                                }

                                public final void aTV() {
                                }

                                public final void Bg(String str) {
                                    MaskImageView maskImageView = (MaskImageView) photosContent2.findViewById(2131759488);
                                    if (maskImageView != null) {
                                        maskImageView.setVisibility(0);
                                        maskImageView.setImageBitmap(BitmapFactory.decodeFile(str));
                                        float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm2.juV, 1, aUm2.juR, aUm2.juS);
                                        float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm2.juW, 1, aUm2.juR, aUm2.juS);
                                        float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm2.juX, 1, aUm2.juR, aUm2.juS);
                                        float a4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm2.juY, 1, aUm2.juR, aUm2.juS);
                                        ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) a, (int) a2);
                                        layoutParams.setMargins((int) ((((float) qQ.getRight()) - a3) - a), (int) ((((float) qQ.getBottom()) - a4) - a2), 0, 0);
                                        maskImageView.setLayoutParams(layoutParams);
                                    }
                                }
                            });
                        }
                    }
                    this.jMr.addOnAttachStateChangeListener(new OnAttachStateChangeListener(this) {
                        final /* synthetic */ SnsCommentDetailUI jNp;
                        boolean jNv = false;

                        public final void onViewAttachedToWindow(View view) {
                            v.i("MicroMsg.SnsCommentDetailUI", "onViewAttachedToWindow infoHeader %s", new Object[]{Boolean.valueOf(this.jNv)});
                            if (this.jNv) {
                                this.jNv = false;
                                if (aUp != null && gt != null && this.jNp.jNm != null) {
                                    ao v = this.jNp.jMF;
                                    PhotosContent photosContent = this.jNp.jNm;
                                    azr com_tencent_mm_protocal_c_azr = aUp;
                                    String aUL = gt.aUL();
                                    int hashCode = this.jNp.hashCode();
                                    int u = this.jNp.eKg;
                                    gt.qC(32);
                                    v.a(photosContent, com_tencent_mm_protocal_c_azr, aUL, hashCode, u, -1, false, com.tencent.mm.storage.ak.nvw, linkedList);
                                }
                            }
                        }

                        public final void onViewDetachedFromWindow(View view) {
                            v.i("MicroMsg.SnsCommentDetailUI", "onViewDetachedFromWindow infoHeader");
                            this.jNv = true;
                        }
                    });
                    aoVar = this.jMF;
                    photosContent = this.jNm;
                    aUL = gt.aUL();
                    hashCode = hashCode();
                    i2 = this.eKg;
                    gt.qC(32);
                    aoVar.a(photosContent, aUp, aUL, hashCode, i2, -1, false, com.tencent.mm.storage.ak.nvw, linkedList);
                } else {
                    v.e("MicroMsg.SnsCommentDetailUI", "the imagesKeeper is null,when viewtype = " + this.eKg + ",stub is " + viewStub.toString());
                }
            } else if (this.eKg == 11) {
                this.jNm.aWi();
                tagImageView = (TagImageView) this.jNm.findViewById(2131759363);
                this.jNm.a(tagImageView);
                tagImageView.setOnClickListener(this.jMV.jIT);
                aUL2 = gt.aUL();
                List arrayList = new ArrayList();
                arrayList.add(tagImageView);
                am amVar = new am();
                amVar.bde = aUL2;
                amVar.index = 0;
                amVar.jOH = arrayList;
                amVar.jMd = true;
                if (tagImageView != null) {
                    tagImageView.setTag(amVar);
                }
                textView = (TextView) this.jMr.findViewById(2131759308);
                if (com.tencent.mm.model.k.xF().equals(aUp.gln)) {
                    textView.setVisibility(8);
                } else {
                    awa n = ah.n(gt);
                    if (n.mTz == null || n.mTz.mTY == 0) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(getString(2131233679, new Object[]{Integer.valueOf(n.mTz.mTY)}));
                        textView.setVisibility(0);
                    }
                }
                aic aUD = gt.aUD();
                if (aUD == null) {
                    v.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo is null " + gt.aUL());
                } else if (com.tencent.mm.model.k.xF().equals(aUp.gln)) {
                    aoVar = this.jMF;
                    photosContent = this.jNm;
                    aUL = gt.aUL();
                    hashCode = hashCode();
                    i2 = this.eKg;
                    gt.qC(32);
                    aoVar.a(photosContent, aUp, aUL, hashCode, i2, -1, false, com.tencent.mm.storage.ak.nvw, true);
                } else if (x.h(gt)) {
                    aoVar = this.jMF;
                    photosContent = this.jNm;
                    aUL = gt.aUL();
                    hashCode = hashCode();
                    i2 = this.eKg;
                    gt.qC(32);
                    aoVar.a(photosContent, aUp, aUL, hashCode, i2, -1, false, com.tencent.mm.storage.ak.nvw, false);
                } else if (aUD.hav == 0) {
                    aoVar = this.jMF;
                    photosContent = this.jNm;
                    aUL = gt.aUL();
                    hashCode = hashCode();
                    i2 = this.eKg;
                    gt.qC(32);
                    aoVar.a(photosContent, aUp, aUL, hashCode, i2, -1, false, com.tencent.mm.storage.ak.nvw, true);
                } else {
                    v.e("MicroMsg.SnsCommentDetailUI", "mediaPostInfo.hbStatus is " + aUD.hav);
                }
            } else if (this.eKg == 9) {
                Pair create;
                ViewGroup.LayoutParams layoutParams;
                aib com_tencent_mm_protocal_c_aib;
                boolean z;
                final ah ahVar = new ah();
                View view = this.jMr;
                r9 = view.findViewById(2131756148);
                com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(2131755052);
                ahVar.jKm = r9;
                ahVar.jzs = (ImageView) view.findViewById(2131755281);
                ahVar.jzr = (MMPinProgressBtn) view.findViewById(2131758183);
                ahVar.jzt = (TextView) view.findViewById(2131759209);
                ahVar.jKn = (TextView) view.findViewById(2131759208);
                ahVar.iWn = aVar;
                ahVar.a(aUp, 0, gt.aUL(), gt.aUT());
                ahVar.jzt.setVisibility(8);
                ahVar.iWn.aU(ahVar);
                r9.setTag(ahVar);
                ahVar.jKm.setOnClickListener(this.jMV.kbQ);
                this.eyZ.a(r9, this.jMV.kbL, this.jMV.kbv);
                Pair a3 = com.tencent.mm.modelsns.d.a(aUp, ahVar.iWn.aOZ(), gt.aUT());
                if (gt.aUT()) {
                    com.tencent.mm.plugin.sns.storage.b aUm3 = gt.aUm();
                    if (aUm3 != null && aUm3.juP > 0.0f && aUm3.juQ > 0.0f) {
                        a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm3.juP, 1, aUm3.juR, aUm3.juS);
                        a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) aUm3.juQ, 1, aUm3.juR, aUm3.juS);
                        if (aUm3.juO == 0) {
                            width = ((WindowManager) bzS().getSystemService("window")).getDefaultDisplay().getWidth();
                            if (a >= ((float) (((width - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)))) {
                                a2 = (float) (((width - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12));
                                f = (float) ((int) ((aUm3.juQ * a2) / aUm3.juP));
                            } else {
                                f = a2;
                                a2 = a;
                            }
                            create = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) f));
                        } else if (aUm3.juO == 1) {
                            width = (((((WindowManager) bzS().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12);
                            create = Pair.create(Integer.valueOf(width), Integer.valueOf((int) ((((float) width) * aUm3.juQ) / aUm3.juP)));
                        } else if (aUm3.juO == 2) {
                            width = ((((WindowManager) bzS().getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.bd.a.fromDPToPix(bzS(), 50)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12)) - com.tencent.mm.bd.a.fromDPToPix(bzS(), 12);
                            create = Pair.create(Integer.valueOf(width), Integer.valueOf((int) ((((float) width) * aUm3.juQ) / aUm3.juP)));
                        }
                        if (create != null) {
                            aVar.co(((Integer) create.first).intValue(), ((Integer) create.second).intValue());
                            layoutParams = ahVar.jKn.getLayoutParams();
                            layoutParams.width = ((Integer) create.first).intValue();
                            layoutParams.height = ((Integer) create.second).intValue();
                            ahVar.jKn.setLayoutParams(layoutParams);
                        }
                        if (aUp.mWq != null || aUp.mWq.mom.size() <= 0) {
                            com_tencent_mm_protocal_c_aib = null;
                        } else {
                            com_tencent_mm_protocal_c_aib = (aib) aUp.mWq.mom.get(0);
                        }
                        if (gt.aUT()) {
                            ahVar.iWn.a(new com.tencent.mm.plugin.sight.decode.a.b.e(this) {
                                final /* synthetic */ SnsCommentDetailUI jNp;

                                public final void d(com.tencent.mm.plugin.sight.decode.a.b bVar, int i) {
                                    if (i != -1 && this.jNp.jMU != null) {
                                        this.jNp.jMU.cC(gt.field_snsId);
                                    }
                                }
                            });
                            if (!this.jMU.cD(gt.field_snsId)) {
                                ahVar.iWn.a(new com.tencent.mm.plugin.sight.decode.a.b.f(this) {
                                    final /* synthetic */ SnsCommentDetailUI jNp;

                                    public final void b(com.tencent.mm.plugin.sight.decode.a.b bVar, long j) {
                                        if (this.jNp.jMU != null) {
                                            int aPi = (int) bVar.aPi();
                                            this.jNp.jMU.n(gt.field_snsId, be.Nj());
                                            this.jNp.jMU.s(gt.field_snsId, aPi);
                                            if (j >= 3) {
                                                this.jNp.jMU.m(gt.field_snsId, gt.field_snsId);
                                                ahVar.iWn.a(null);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                        if (aUp.mWq != null && aUp.mWq.mom.size() > 0) {
                            ad.aSB();
                            if (!com.tencent.mm.plugin.sns.e.g.v(com_tencent_mm_protocal_c_aib)) {
                                if (ad.aSB().w(com_tencent_mm_protocal_c_aib)) {
                                    ahVar.jzs.setVisibility(0);
                                    ahVar.jzr.setVisibility(8);
                                    ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                                } else if (ad.aSB().x(com_tencent_mm_protocal_c_aib)) {
                                    ahVar.jzs.setVisibility(8);
                                    ahVar.jzr.setVisibility(8);
                                } else if (gt.aUT() || ad.aSB().l(gt) > 5) {
                                    ad.aSB().z(com_tencent_mm_protocal_c_aib);
                                    ahVar.jzs.setVisibility(0);
                                    ahVar.jzr.setVisibility(8);
                                    ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                                } else {
                                    ahVar.jzs.setVisibility(8);
                                    ahVar.jzr.setVisibility(8);
                                }
                                if (ahVar.iWn.aPa()) {
                                    v.d("MicroMsg.SnsCommentDetailUI", "play video error " + com_tencent_mm_protocal_c_aib.gID + " " + com_tencent_mm_protocal_c_aib.glb + " " + com_tencent_mm_protocal_c_aib.mHP);
                                    ad.aSB().z(com_tencent_mm_protocal_c_aib);
                                    ahVar.jzs.setVisibility(0);
                                    ahVar.jzr.setVisibility(8);
                                    ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                                }
                            } else if (ad.aSB().y(com_tencent_mm_protocal_c_aib)) {
                                ahVar.jzs.setVisibility(8);
                                ahVar.jzr.setVisibility(0);
                                ahVar.jzr.bKj();
                            } else if (gt.aUT() || ad.aSB().l(gt) != 5) {
                                ad.aSB().z(com_tencent_mm_protocal_c_aib);
                                ahVar.jzs.setVisibility(0);
                                ahVar.jzr.setVisibility(8);
                                ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                            } else {
                                ad.aSB().B(com_tencent_mm_protocal_c_aib);
                                ahVar.jzs.setVisibility(8);
                                ahVar.jzr.setVisibility(0);
                                ahVar.jzr.bKj();
                            }
                            aVar.aU(ahVar);
                            ad.aSB().a(gt, com_tencent_mm_protocal_c_aib, aVar, hashCode(), 0, com.tencent.mm.storage.ak.nvw, gt.aUT());
                            r9.setTag(ahVar);
                            if (this.jMU != null) {
                                z = gt.aUT() ? ad.aSB().l(gt) != 5 : ad.aSB().k(gt) != 5;
                                this.jMU.j(gt.field_snsId, z);
                            }
                        }
                    }
                }
                create = a3;
                if (create != null) {
                    aVar.co(((Integer) create.first).intValue(), ((Integer) create.second).intValue());
                    layoutParams = ahVar.jKn.getLayoutParams();
                    layoutParams.width = ((Integer) create.first).intValue();
                    layoutParams.height = ((Integer) create.second).intValue();
                    ahVar.jKn.setLayoutParams(layoutParams);
                }
                if (aUp.mWq != null) {
                }
                com_tencent_mm_protocal_c_aib = null;
                if (gt.aUT()) {
                    ahVar.iWn.a(/* anonymous class already generated */);
                    if (this.jMU.cD(gt.field_snsId)) {
                        ahVar.iWn.a(/* anonymous class already generated */);
                    }
                }
                ad.aSB();
                if (!com.tencent.mm.plugin.sns.e.g.v(com_tencent_mm_protocal_c_aib)) {
                    if (ad.aSB().w(com_tencent_mm_protocal_c_aib)) {
                        ahVar.jzs.setVisibility(0);
                        ahVar.jzr.setVisibility(8);
                        ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                    } else if (ad.aSB().x(com_tencent_mm_protocal_c_aib)) {
                        ahVar.jzs.setVisibility(8);
                        ahVar.jzr.setVisibility(8);
                    } else {
                        if (gt.aUT()) {
                        }
                        ad.aSB().z(com_tencent_mm_protocal_c_aib);
                        ahVar.jzs.setVisibility(0);
                        ahVar.jzr.setVisibility(8);
                        ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                    }
                    if (ahVar.iWn.aPa()) {
                        v.d("MicroMsg.SnsCommentDetailUI", "play video error " + com_tencent_mm_protocal_c_aib.gID + " " + com_tencent_mm_protocal_c_aib.glb + " " + com_tencent_mm_protocal_c_aib.mHP);
                        ad.aSB().z(com_tencent_mm_protocal_c_aib);
                        ahVar.jzs.setVisibility(0);
                        ahVar.jzr.setVisibility(8);
                        ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                    }
                } else if (ad.aSB().y(com_tencent_mm_protocal_c_aib)) {
                    ahVar.jzs.setVisibility(8);
                    ahVar.jzr.setVisibility(0);
                    ahVar.jzr.bKj();
                } else {
                    if (gt.aUT()) {
                    }
                    ad.aSB().z(com_tencent_mm_protocal_c_aib);
                    ahVar.jzs.setVisibility(0);
                    ahVar.jzr.setVisibility(8);
                    ahVar.jzs.setImageDrawable(com.tencent.mm.bd.a.a(this, 2131165914));
                }
                aVar.aU(ahVar);
                ad.aSB().a(gt, com_tencent_mm_protocal_c_aib, aVar, hashCode(), 0, com.tencent.mm.storage.ak.nvw, gt.aUT());
                r9.setTag(ahVar);
                if (this.jMU != null) {
                    if (gt.aUT()) {
                        if (ad.aSB().l(gt) != 5) {
                        }
                    }
                    this.jMU.j(gt.field_snsId, z);
                }
            } else if (this.eKg == 0) {
                r0 = (LinearLayout) this.jMr.findViewById(2131759293);
                View qU = qU(2130904475);
                if (!this.jNj) {
                    r0.removeView(this.jNm);
                    r0.addView(qU, 3);
                    if (qU.getLayoutParams() != null) {
                        r0 = new LinearLayout.LayoutParams(qU.getLayoutParams());
                    } else {
                        r0 = new LinearLayout.LayoutParams(-1, -2);
                    }
                    r0.setMargins(r0.leftMargin, com.tencent.mm.bd.a.fromDPToPix(this, 12), r0.rightMargin, r0.bottomMargin);
                    qU.setLayoutParams(r0);
                }
                if (aUp.mWq.mom.isEmpty()) {
                    qU.setVisibility(8);
                } else {
                    r1 = (aib) aUp.mWq.mom.get(0);
                    MMImageView mMImageView = (MMImageView) qU.findViewById(2131759412);
                    ad.aSB().b(r1, mMImageView, 2131165232, hashCode(), com.tencent.mm.storage.ak.nvw);
                    this.jMJ = (ImageView) qU.findViewById(2131757389);
                    this.jMJ.setOnTouchListener(this.jFF);
                    this.jML = aUp.gID;
                    aWF();
                    mMImageView.setTag(new p(aUp, this.jMG, getIntent().getBooleanExtra("SNS_FROM_MUSIC_ITEM", false)));
                    mMImageView.setOnClickListener(this.jMO.jZb);
                    CharSequence charSequence = r1.gkC;
                    if (!be.kS(charSequence)) {
                        ((TextView) qU.findViewById(2131759415)).setText(charSequence);
                    }
                    ah = r1.aXz;
                    if (!be.kS(ah)) {
                        ((TextView) qU.findViewById(2131759414)).setText(new SpannableString(ah), BufferType.SPANNABLE);
                    }
                    qU.setTag(new p(aUp, this.jMG));
                    this.eyZ.a(qU, this.jMV.kbK, this.jMV.kbv);
                    qU.setOnClickListener(this.jMO.jRS);
                    com.tencent.mm.plugin.sns.data.i.b(mMImageView, this);
                }
            } else {
                Object obj;
                CharSequence Cf;
                Object obj2;
                String str3;
                r0 = (LinearLayout) this.jMr.findViewById(2131759293);
                r9 = qU(2130904473);
                if (!this.jNj) {
                    r0.removeView(this.jNm);
                    r0.addView(r9, 3);
                    if (r9.getLayoutParams() != null) {
                        r0 = new LinearLayout.LayoutParams(r9.getLayoutParams());
                    } else {
                        r0 = new LinearLayout.LayoutParams(-1, -2);
                    }
                    r0.setMargins(r0.leftMargin, com.tencent.mm.bd.a.fromDPToPix(this, 12), r0.rightMargin, r0.bottomMargin);
                    r9.setLayoutParams(r0);
                }
                this.eyZ.a(r9, this.jMV.kbK, this.jMV.kbv);
                if (aUp.mWq.mol == 9) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jYV);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 10) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jYX);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 17) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jYY);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 22) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jYZ);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 23) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jZa);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 14) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jYW);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 12) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jZe);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 13) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMO.jZf);
                        obj = null;
                    }
                    obj = null;
                } else if (aUp.mWq.mol == 15) {
                    if (aUp.mWq.mom.size() > 0) {
                        r9.setTag(new p(aUp, this.jMG));
                        r9.setOnClickListener(this.jMV.kbR);
                        obj = null;
                    }
                    obj = null;
                } else {
                    r9.setTag(new p(aUp, this.jMG));
                    r9.setOnClickListener(this.jMO.jRS);
                    if ((aUp.cog & 1) > 0) {
                        int i4 = 1;
                    }
                    obj = null;
                }
                if (aWC()) {
                    Cf = as.Cf(aUp.mWq.glb);
                } else {
                    obj2 = "";
                }
                String str4 = aUp.mWq.aXz;
                r9.findViewById(2131757389).setVisibility(8);
                View view2 = (MMImageView) r9.findViewById(2131759412);
                if (!aUp.mWq.mom.isEmpty()) {
                    view2.setVisibility(0);
                    r1 = (aib) aUp.mWq.mom.get(0);
                    if (aUp.mWq.mol == 15) {
                        ((ImageView) r9.findViewById(2131757389)).setImageResource(2130838735);
                        ((ImageView) r9.findViewById(2131757389)).setVisibility(0);
                        ad.aSB().b(r1, view2, 2131165244, hashCode(), com.tencent.mm.storage.ak.bvR().vf(aUp.hNS));
                        str3 = str4;
                    } else if (aUp.mWq.mol == 5) {
                        str4 = as.Cf(r1.glb);
                        String str5 = r1.aXz;
                        r9.findViewById(2131757389).setVisibility(0);
                        ad.aSB().b(r1, view2, 2131165244, hashCode(), com.tencent.mm.storage.ak.nvw);
                        str3 = str5;
                        obj2 = str4;
                    } else if (aUp.mWq.mol == 18) {
                        r9.findViewById(2131757389).setVisibility(0);
                        ((ImageView) r9.findViewById(2131757389)).setImageResource(2130839379);
                        view2.setVisibility(0);
                        ad.aSB().b(r1, view2, 2131165244, hashCode(), com.tencent.mm.storage.ak.nvw);
                        str3 = str4;
                    } else {
                        ad.aSB().b(r1, view2, hashCode(), com.tencent.mm.storage.ak.nvw);
                        str3 = str4;
                    }
                } else if (aUp.mWq.mol == 18) {
                    ((ImageView) r9.findViewById(2131757389)).setVisibility(0);
                    ((ImageView) r9.findViewById(2131757389)).setImageResource(2130839379);
                    view2.setVisibility(0);
                    ad.aSB().a(view2, -1, 2131165244, hashCode());
                    str3 = str4;
                } else {
                    view2.setVisibility(0);
                    ad.aSB().a(view2, -1, 2131165247, hashCode());
                    str3 = str4;
                }
                com.tencent.mm.plugin.sns.data.i.b(view2, this);
                if (aUp.mWq.mol == 15) {
                    Cf = "";
                    ah = getString(2131235409);
                } else {
                    Object obj3 = str3;
                }
                if (be.kS(Cf)) {
                    r9.findViewById(2131759415).setVisibility(8);
                } else {
                    r9.findViewById(2131759415).setVisibility(0);
                    ((TextView) r9.findViewById(2131759415)).setText(Cf);
                }
                textView = (TextView) r9.findViewById(2131759414);
                if (be.kS(ah)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    if (obj != null) {
                        textView.setText(com.tencent.mm.plugin.sns.data.i.a(ah, bzS(), textView));
                    } else {
                        CharSequence spannableString = new SpannableString(ah);
                        textView.setText("", BufferType.SPANNABLE);
                        textView.setText(spannableString);
                    }
                }
            }
        }
        textView = (TextView) this.jMr.findViewById(2131759302);
        if (gt.aUT()) {
            com.tencent.mm.plugin.sns.storage.a aUo = gt.aUo();
            if (aUo != null) {
                spannableString = aUo.juh;
                aUL2 = aUo.jui;
                textView.setTag(gt.aUL());
                if (!be.kS(spannableString)) {
                    if (be.kS(aUL2)) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(0);
                        if (!be.kS(spannableString)) {
                            textView.setTextColor(-11048043);
                            textView.setClickable(true);
                            textView.setText(spannableString);
                        }
                    }
                    textView.setText(spannableString);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                }
            }
            textView.setVisibility(8);
        } else {
            ah = aUp.mWo == null ? null : aUp.mWo.cHe;
            spannableString = aUp.mWo == null ? null : aUp.mWo.gUr;
            textView.setTag(gt.aUL());
            if (be.kS(ah) && be.kS(spannableString)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                if (be.kS(spannableString)) {
                    textView.setText(ah);
                    textView.setClickable(false);
                    textView.setTextColor(-9211021);
                } else {
                    textView.setTextColor(-11048043);
                    textView.setClickable(true);
                    if (gt.field_snsId != 0 || be.kS(ah)) {
                        textView.setText(spannableString);
                    } else {
                        textView.setText(ah + "·" + spannableString);
                    }
                }
            }
        }
        textView.setOnClickListener(this.jMV.kbP);
        ((TextView) this.jMr.findViewById(2131759304)).setText(aw.k(bzS(), ((long) gt.aUE()) * 1000));
        AsyncTextView asyncTextView = (AsyncTextView) this.jMr.findViewById(2131759305);
        asyncTextView.setOnClickListener(this.jMV.kbT);
        asyncTextView.setVisibility(8);
        if (gt.aUT()) {
            com.tencent.mm.plugin.sns.storage.a aUo2 = gt.aUo();
            asyncTextView.setTag(gt.aUL());
            if (aUo2.juj == com.tencent.mm.plugin.sns.storage.a.jtV) {
                if (be.kS(aUo2.juk)) {
                    asyncTextView.setVisibility(8);
                } else {
                    asyncTextView.setText(aUo2.juk);
                    asyncTextView.setVisibility(0);
                }
            } else if (aUo2.juj == com.tencent.mm.plugin.sns.storage.a.jtW) {
                if (be.kS(aUo2.juk)) {
                    asyncTextView.setVisibility(8);
                } else {
                    str = "";
                    Iterator it = aUo2.jum.iterator();
                    while (it.hasNext()) {
                        aUL2 = (String) it.next();
                        u LW = this.jMH.LW(aUL2);
                        if (LW != null) {
                            str = str + LW.tU();
                        } else {
                            str = str + aUL2;
                        }
                        if (aUo2.jum.getLast() != aUL2) {
                            str = str + ",";
                        }
                    }
                    ah = String.format(aUo2.juk, new Object[]{str});
                    asyncTextView.getTextSize();
                    fVar = new f(com.tencent.mm.pluginsdk.ui.d.e.b(this, ah, 1));
                    fVar.f(null, ah);
                    TextPaint paint = asyncTextView.getPaint();
                    if (com.tencent.mm.bd.a.P(this, (int) Layout.getDesiredWidth(fVar, 0, fVar.length(), paint)) > this.jMT) {
                        while (str.length() > 1) {
                            str = str.substring(0, str.length() - 2);
                            fVar = String.format(aUo2.juk, new Object[]{str + "..."});
                            asyncTextView.getTextSize();
                            CharSequence fVar2 = new f(com.tencent.mm.pluginsdk.ui.d.e.b(this, fVar, 1));
                            fVar2.f(null, fVar);
                            hashCode = com.tencent.mm.bd.a.P(this, (int) Layout.getDesiredWidth(fVar2, 0, fVar2.length(), paint));
                            asyncTextView.setText(fVar2, BufferType.SPANNABLE);
                            asyncTextView.setVisibility(0);
                            if (hashCode <= this.jMT) {
                                break;
                            }
                        }
                    }
                    asyncTextView.setText(fVar, BufferType.SPANNABLE);
                    asyncTextView.setVisibility(0);
                }
            }
            if (asyncTextView.getVisibility() != 8 && be.kS(aUo2.jul)) {
                asyncTextView.setTextColor(getResources().getColor(2131690050));
                asyncTextView.setOnClickListener(null);
            }
        }
        textView = (TextView) this.jMr.findViewById(2131759307);
        textView.setOnTouchListener(new y());
        aUL2 = com.tencent.mm.plugin.sns.b.a.drq.n(this, aUp.mWp.gID);
        as.a(aUp, (Context) this);
        if (com.tencent.mm.plugin.sns.b.a.drq.bo(aUL2)) {
            textView.setVisibility(0);
            spannableString = new SpannableString(getString(2131235382) + aUL2);
            spannableString.setSpan(new a(this), 0, spannableString.length(), 33);
            textView.setText(spannableString, BufferType.SPANNABLE);
            if (aUp.mWp == null || !com.tencent.mm.pluginsdk.model.app.g.Gw(aUp.mWp.gID)) {
                textView.setTextColor(getResources().getColor(2131690050));
                textView.setOnTouchListener(null);
            }
            textView.setTag(aUp);
        } else {
            textView.setVisibility(8);
        }
        textView = (TextView) this.jMr.findViewById(2131759309);
        if (gt.getUserName().equals(this.bYE) && (gt.isValid() || gt.aUN())) {
            textView.setVisibility(0);
            textView.setTag(gt.aUL() + ";" + gt.aUq());
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                {
                    this.jNp = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.ui.base.g.a(this.jNp, 2131235549, 2131231164, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass25 jNz;

                        {
                            this.jNz = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            v.d("MicroMsg.SnsCommentDetailUI", "to del by localId " + this.jNz.jNp.jMG);
                            k Bq = com.tencent.mm.plugin.sns.storage.f.Bq(this.jNz.jNp.jMG);
                            if (Bq == null) {
                                v.e("MicroMsg.SnsCommentDetailUI", "try to del item fail can not get snsinfo by localid %s", new Object[]{this.jNz.jNp.jMG});
                            } else if (!Bq.qC(32)) {
                                if (Bq.field_snsId == 0) {
                                    ad.aSE().qH(Bq.jBI);
                                } else {
                                    ad.aSD().cP(Bq.field_snsId);
                                    ak.vy().a(new com.tencent.mm.plugin.sns.e.p(Bq.field_snsId, 1), 0);
                                    ad.aSE().delete(Bq.field_snsId);
                                    ad.aSH().cX(Bq.field_snsId);
                                }
                                Intent intent = new Intent();
                                intent.putExtra("sns_gallery_op_id", s.BL(this.jNz.jNp.jMG));
                                this.jNz.jNp.setResult(-1, intent);
                                if (this.jNz.jNp.dFB && !Bq.isValid()) {
                                    intent.putExtra("sns_gallery_force_finish", true);
                                }
                                azr aUp = Bq.aUp();
                                if (aUp != null) {
                                    String str = aUp.mWp == null ? null : aUp.mWp.gID;
                                    if (!be.kS(str) && com.tencent.mm.plugin.sns.b.a.drq.bp(str)) {
                                        String bn = com.tencent.mm.plugin.sns.b.a.drq.bn(str);
                                        lh lhVar = new lh();
                                        lhVar.bmD.appId = str;
                                        lhVar.bmD.bmE = aUp.gln;
                                        lhVar.bmD.aRm = bn;
                                        com.tencent.mm.sdk.c.a.nhr.z(lhVar);
                                    }
                                }
                                this.jNz.jNp.finish();
                            }
                        }
                    }, null);
                }
            });
        } else {
            textView.setVisibility(8);
        }
        textView = (TextView) this.jMr.findViewById(2131759303);
        awa m = ah.m(gt);
        if (m == null) {
            textView.setVisibility(8);
        } else {
            if (m.mTq.size() > 0) {
                if (!this.bYE.equals(m.mdw)) {
                    textView.setVisibility(8);
                    Iterator it2 = m.mTq.iterator();
                    while (it2.hasNext()) {
                        if (this.bYE.equals(((avr) it2.next()).mdw)) {
                            textView.setVisibility(0);
                            ah = getString(2131235565);
                            textView.setVisibility(0);
                            textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, ah, textView.getTextSize()));
                            break;
                        }
                    }
                }
                textView.setVisibility(0);
                Iterator it3 = m.mTq.iterator();
                aUL = "";
                Object obj4 = null;
                while (it3.hasNext()) {
                    Object obj5;
                    StringBuilder append;
                    avr com_tencent_mm_protocal_c_avr = (avr) it3.next();
                    if (obj4 == null) {
                        str = aUL + "  ";
                        obj5 = 1;
                    } else {
                        Object obj6 = obj4;
                        str = aUL + ",  ";
                        obj5 = obj6;
                    }
                    if (com_tencent_mm_protocal_c_avr.mGq != null) {
                        append = new StringBuilder().append(str);
                        aUL2 = com_tencent_mm_protocal_c_avr.mGq;
                    } else {
                        u LX2 = this.jMH.LX(com_tencent_mm_protocal_c_avr.mdw);
                        append = new StringBuilder().append(str);
                        aUL2 = LX2 == null ? com_tencent_mm_protocal_c_avr.mdw : LX2.tU();
                    }
                    obj4 = obj5;
                    aUL = append.append(aUL2).toString();
                }
                textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, getString(2131235564, new Object[]{aUL}), textView.getTextSize()));
            } else {
                textView.setVisibility(8);
            }
            if (m == null || this.bYE == null || !this.bYE.equals(m.mdw) || ((m.mTr != 3 || m.mTw == null) && (m.mTr != 5 || m.mIw == null))) {
                this.jMr.findViewById(2131759306).setVisibility(8);
            } else {
                this.jMr.findViewById(2131759306).setVisibility(0);
                this.jMr.findViewById(2131759306).setTag(Integer.valueOf(gt.jBI));
                this.jMr.findViewById(2131759306).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsCommentDetailUI jNp;

                    {
                        this.jNp = r1;
                    }

                    public final void onClick(View view) {
                        try {
                            int intValue = ((Integer) view.getTag()).intValue();
                            Intent intent = new Intent();
                            intent.putExtra("sns_label_sns_info", intValue);
                            com.tencent.mm.plugin.sns.b.a.drp.y(intent, this.jNp);
                        } catch (Exception e) {
                        }
                    }
                });
            }
        }
        this.jMy = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.jMy.setDuration(150);
        this.jMz = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.jMz.setDuration(150);
        this.jMw = this.jMr.findViewById(2131755294);
        this.jMw.setVisibility(8);
        this.jMA = (LinearLayout) this.jMr.findViewById(2131759313);
        this.jMA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            public final void onClick(View view) {
                if (x.Ac(gt.aUL())) {
                    this.jNp.jEp.gu(true);
                    this.jNp.jMw.setVisibility(8);
                    SnsCommentDetailUI.r(this.jNp);
                    return;
                }
                com.tencent.mm.plugin.sns.lucky.ui.b.e(this.jNp.nDR.nEl, this.jNp.jNm.qQ(0));
            }
        });
        this.jMA.setOnTouchListener(this.jFF);
        this.jMB = (LinearLayout) this.jMr.findViewById(2131759310);
        this.jMB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            {
                this.jNp = r1;
            }

            public final void onClick(View view) {
                SnsCommentDetailUI snsCommentDetailUI = this.jNp;
                LinearLayout linearLayout = (LinearLayout) view;
                ImageView imageView = (ImageView) linearLayout.findViewById(2131759311);
                Animation scaleAnimation = new ScaleAnimation(0.9f, DownloadHelper.SAVE_FATOR, 0.9f, DownloadHelper.SAVE_FATOR, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(400);
                scaleAnimation.setStartOffset(100);
                scaleAnimation.setRepeatCount(0);
                imageView.clearAnimation();
                imageView.startAnimation(scaleAnimation);
                scaleAnimation.setAnimationListener(new AnonymousClass31(snsCommentDetailUI, linearLayout));
                SnsCommentDetailUI.s(this.jNp);
            }
        });
        this.jMB.setOnTouchListener(this.jFF);
        ImageButton imageButton = (ImageButton) this.jMr.findViewById(2131759316);
        k gt2 = gt(true);
        if (!(gt2 == null || (gt2.aUG() & 1) == 0)) {
            imageButton.setVisibility(8);
        }
        if (!(gt2 == null || gt2.aUK())) {
            imageButton.setVisibility(8);
        }
        final ImageView imageView2 = (ImageView) this.jMB.findViewById(2131759311);
        final ImageView imageView3 = (ImageView) this.jMA.findViewById(2131759314);
        final TextView textView2 = (TextView) this.jMB.findViewById(2131759312);
        final TextView textView3 = (TextView) this.jMA.findViewById(2131759315);
        if (this.eKg == 11) {
            this.jMr.findViewById(2131755294).setBackgroundResource(2130838272);
            imageButton.setImageResource(2130838511);
            imageView2.setImageResource(2130838512);
            imageView3.setImageResource(2130838513);
            textView2.setTextColor(getResources().getColor(2131690033));
            textView3.setTextColor(getResources().getColor(2131690033));
            this.jMB.setBackgroundResource(2130838595);
            this.jMA.setBackgroundResource(2130838596);
        }
        final k kVar = gt;
        imageButton.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentDetailUI jNp;

            public final void onClick(View view) {
                v.d("MicroMsg.SnsCommentDetailUI", "showComment click" + this.jNp.jMw.getVisibility());
                azr aUp = kVar.aUp();
                if (aUp != null && aUp.mWq.mol == 21 && !x.Ac(kVar.aUL())) {
                    com.tencent.mm.plugin.sns.lucky.ui.b.e(this.jNp.nDR.nEl, this.jNp.jNm.qQ(0));
                } else if (this.jNp.jMw.getVisibility() == 0) {
                    this.jNp.aWE();
                } else {
                    this.jNp.jMw.setVisibility(0);
                    this.jNp.jMw.startAnimation(this.jNp.jMy);
                    if (this.jNp.eKg == 11) {
                        this.jNp.jMr.findViewById(2131755294).setBackgroundResource(2130838272);
                    }
                    if (s.BM(this.jNp.boC)) {
                        this.jNp.jMA.setEnabled(true);
                        imageView2.setImageResource(2130838276);
                        this.jNp.jMB.setEnabled(true);
                        textView2.setTextColor(this.jNp.getResources().getColor(2131690127));
                        textView3.setTextColor(this.jNp.getResources().getColor(2131690127));
                        k Bp = com.tencent.mm.plugin.sns.storage.f.Bp(this.jNp.boC);
                        if (this.jNp.eKg == 11) {
                            imageView2.setImageResource(2130838512);
                            imageView3.setImageResource(2130838513);
                            textView2.setTextColor(this.jNp.getResources().getColor(2131690033));
                            textView3.setTextColor(this.jNp.getResources().getColor(2131690033));
                        } else {
                            imageView2.setImageResource(2130838276);
                            textView2.setTextColor(this.jNp.getResources().getColor(2131690127));
                            textView3.setTextColor(this.jNp.getResources().getColor(2131690127));
                        }
                        if (Bp.field_likeFlag == 0) {
                            textView2.setText(this.jNp.getString(2131235460));
                            return;
                        } else {
                            textView2.setText(this.jNp.getString(2131235422));
                            return;
                        }
                    }
                    this.jNp.jMA.setEnabled(false);
                    this.jNp.jMB.setEnabled(false);
                    textView2.setText(this.jNp.getString(2131235460));
                    textView2.setTextColor(this.jNp.getResources().getColor(2131690026));
                    textView3.setTextColor(this.jNp.getResources().getColor(2131690026));
                    if (this.jNp.eKg == 11) {
                        imageView2.setImageResource(2131165575);
                    } else {
                        imageView2.setImageResource(2131165578);
                    }
                }
            }
        });
        return true;
    }

    private void aWE() {
        if (this.jMw != null && this.jMw.getVisibility() != 8) {
            this.jMw.startAnimation(this.jMz);
            this.jMz.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ SnsCommentDetailUI jNp;

                {
                    this.jNp = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    v.d("MicroMsg.SnsCommentDetailUI", "onAnimationEnd");
                    if (this.jNp.jMw != null) {
                        this.jNp.jMw.clearAnimation();
                        this.jNp.jMw.setVisibility(8);
                    }
                }
            });
        }
    }

    private void aWF() {
        if (this.jMJ != null) {
            this.jMJ.setPressed(false);
            if (bd.yS(this.jML)) {
                this.jMJ.setImageResource(2130838733);
            } else {
                this.jMJ.setImageResource(2130838735);
            }
        }
    }

    private boolean e(List<avr> list, boolean z) {
        int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 32.0f);
        int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 6.0f);
        int a3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 10.0f);
        int a4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this, 17.0f);
        if (this.jMt == null) {
            return false;
        }
        int i;
        v.d("MicroMsg.SnsCommentDetailUI", "guess size %d %f", new Object[]{Integer.valueOf(((WindowManager) this.nDR.nEl.getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(2131493168))});
        float f = ((float) i) - (f * 2.0f);
        if (list.size() <= 0) {
            if (this.jMt.getParent() != null) {
                this.jMt.setVisibility(8);
            }
            this.jMt.removeAllViews();
            this.jMt.setVisibility(8);
            this.jir.setVisibility(8);
            return false;
        }
        this.jMt.getParent();
        this.jMt.removeAllViews();
        this.jMt.setVisibility(0);
        if (this.eKg != 11) {
            this.jMt.setBackgroundResource(2130838268);
        } else if (this.jMX) {
            k gt = gt(false);
            if (gt == null) {
                this.jMt.setBackgroundResource(2130838270);
            } else if (this.bYE.equals(gt.field_userName)) {
                this.jMt.setBackgroundResource(2130838271);
            } else {
                this.jMt.setBackgroundResource(2130838270);
            }
        } else {
            this.jMt.setBackgroundResource(2130838270);
        }
        this.jMt.setPadding(0, a2, 0, a2);
        View imageView = new ImageView(this.nDR.nEl);
        if (this.eKg == 11) {
            imageView.setImageResource(2131165585);
        } else {
            imageView.setImageResource(2131165584);
        }
        imageView.setPadding(a3, a4, a3, 0);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        imageView.setLayoutParams(layoutParams);
        imageView.setClickable(false);
        imageView.setFocusable(false);
        this.jMt.addView(imageView);
        a3 = com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, jMS);
        i = ((int) (f - ((float) a3))) / (a2 + a);
        if (((int) (f - ((float) a3))) % (a2 + a) > a) {
            i++;
        }
        v.d("MicroMsg.SnsCommentDetailUI", "guess size %d", new Object[]{Integer.valueOf(i)});
        View gVar = new g(this.nDR.nEl);
        gVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        gVar.jEl = i;
        for (a3 = 0; a3 < list.size(); a3++) {
            avr com_tencent_mm_protocal_c_avr = (avr) list.get(a3);
            View touchImageView = new TouchImageView(this.nDR.nEl);
            touchImageView.setScaleType(ScaleType.FIT_XY);
            touchImageView.setImageResource(2130838279);
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a, a);
            layoutParams2.setMargins(0, a2, a2, 0);
            touchImageView.setLayoutParams(layoutParams2);
            touchImageView.setTag(com_tencent_mm_protocal_c_avr.mdw);
            com.tencent.mm.pluginsdk.ui.a.b.b(touchImageView, com_tencent_mm_protocal_c_avr.mdw, true);
            touchImageView.setOnClickListener(this.jNf);
            gVar.addView(touchImageView);
        }
        this.jMt.addView(gVar);
        this.jir.setVisibility(z ? 8 : 0);
        return true;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        k Bp = com.tencent.mm.plugin.sns.storage.f.Bp(this.boC);
        awa m = ah.m(Bp);
        e(m.mTk, m.mTn.isEmpty());
        if (this.jMu != null) {
            this.jMu.a(Bp, this.jMV);
        }
        if (this.jNm != null) {
            this.jMQ = ad.aSK();
            this.jNm.qP(this.jMQ);
        }
    }

    public final void Aa(String str) {
    }

    public final void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsCommentDetailUI", "onAcvityResult requestCode:" + i);
        if (i == 15) {
            if (this.jMV != null && this.jMV.kbv != null) {
                this.jMV.kbv.onActivityResult(i, i2, intent);
            }
        } else if (i == 16) {
            v.i("MicroMsg.SnsCommentDetailUI", "REQUEST_CODE_FOR_FULLSCREEN");
            fn fnVar = new fn();
            fnVar.beS.scene = 1;
            com.tencent.mm.sdk.c.a.nhr.z(fnVar);
        } else if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        Cursor managedQuery = managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() == 218 && this.jEA != null) {
            this.jEA.dismiss();
        }
        if (i == 0 && i2 == 0) {
            k Bp = com.tencent.mm.plugin.sns.storage.f.Bp(this.boC);
            if (Bp == null) {
                v.e("MicroMsg.SnsCommentDetailUI", "invalid pcid:" + this.boC);
                finish();
                return;
            }
            v.d("MicroMsg.SnsCommentDetailUI", "snsId: " + this.boC + "  username:" + Bp.field_userName);
            if (this.jMr == null) {
                v.e("MicroMsg.SnsCommentDetailUI", "fatal error! Sns onSceneEnd before initView and infoHeader is null!");
                finish();
                return;
            }
            aWD();
            awa m = ah.m(Bp);
            v.i("MicroMsg.SnsCommentDetailUI", "onsceneend " + m.mTk.size() + " " + m.mTn.size());
            if (m != null) {
                if (!e(this.jMC, m.mTk)) {
                    e(m.mTk, m.mTn.isEmpty());
                    this.jMC = m.mTk;
                }
                if (this.jMu != null) {
                    this.jMu.a(Bp, this.jMV);
                }
                b bVar = this.jMx;
                LinkedList linkedList = m.mTn;
                LinkedList linkedList2 = m.mTk;
                bVar.jNL = linkedList;
                bVar.jNM = linkedList2;
                this.jMx.notifyDataSetChanged();
            }
        }
    }

    public final void a(boolean z, boolean z2, String str, boolean z3) {
    }

    public final void b(boolean z, String str, boolean z2) {
    }

    public final void aj(String str, boolean z) {
    }

    public final void aRG() {
        if (this.nDR.nEB == 2) {
            v.i("MicroMsg.SnsCommentDetailUI", "keybaordhide! ");
            this.jME = false;
            if (this.jEp.hhN) {
                this.jEp.hhN = false;
            } else if (this.jEp.aWJ()) {
                this.jEp.aWM();
                this.jEp.BZ(getString(2131235571));
            }
        } else if (this.nDR.nEB == 1) {
            aWE();
        }
    }
}
