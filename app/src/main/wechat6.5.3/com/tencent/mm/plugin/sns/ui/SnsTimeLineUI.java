package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.bg;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.in;
import com.tencent.mm.e.a.is;
import com.tencent.mm.e.a.ix;
import com.tencent.mm.e.a.iy;
import com.tencent.mm.e.a.jd;
import com.tencent.mm.e.a.lo;
import com.tencent.mm.e.a.ng;
import com.tencent.mm.e.a.nj;
import com.tencent.mm.e.a.nk;
import com.tencent.mm.e.a.no;
import com.tencent.mm.e.a.np;
import com.tencent.mm.e.a.nq;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.e.a.og;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.e.a.px;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.sns.a.a.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.aq;
import com.tencent.mm.plugin.sns.e.as;
import com.tencent.mm.plugin.sns.e.p;
import com.tencent.mm.plugin.sns.e.r;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.QFadeImageView;
import com.tencent.mm.v.e;
import com.tencent.mm.vending.h.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SnsTimeLineUI extends WxPresenterActivity implements ae, s, com.tencent.mm.pluginsdk.j.q.e.a, e {
    private static final Set<Activity> jVu = new HashSet();
    private ActionBar FG;
    private String dRA;
    private long evC = 0;
    private int hEx = 0;
    private boolean jEu = false;
    private boolean jGc;
    protected g jMU = new g(1);
    private ag jUA;
    private au jUB;
    private LinearLayout jUC;
    private QFadeImageView jUD;
    private boolean jUE = false;
    private boolean jUF = false;
    private h jUG;
    private a jUH;
    private TestTimeForSns jUI;
    private int jUJ = 0;
    private boolean jUK = false;
    private String jUL = "";
    private com.tencent.mm.plugin.sns.i.a jUM = new com.tencent.mm.plugin.sns.i.a();
    private as jUN = new as();
    private aq jUO = new aq();
    private String jUP;
    private boolean jUQ;
    private int jUR;
    private ay jUS;
    private Runnable jUT = new Runnable(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final void run() {
            au a = this.jVD.jUB;
            if (a != null) {
                a.jWl.aXn();
                a.jWl.notifyVendingDataChange();
            }
        }
    };
    private c jUU = new c<px>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = px.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.jVD.vF().u(com.tencent.mm.plugin.sns.k.c.b.class);
            return false;
        }
    };
    private boolean jUV = false;
    private c jUW = new c<ix>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = ix.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((ix) bVar) instanceof ix) {
                this.jVD.jUy.kcp.b(this.jVD.dRA, this.jVD.jUQ, this.jVD.jGc, this.jVD.jUR);
                this.jVD.jUB.notifyDataSetChanged();
            }
            return false;
        }
    };
    private c jUX = new c<iy>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = iy.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.jVD.jUB.notifyDataSetChanged();
            return false;
        }
    };
    private c jUY = new c<in>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = in.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.jVD.jUV = true;
            return false;
        }
    };
    private c jUZ = new c<is>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = is.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            is isVar = (is) bVar;
            this.jVD.jrl = true;
            this.jVD.jUM.jrl = this.jVD.jrl;
            SnsTimeLineUI.a(this.jVD, isVar.bji.position);
            return false;
        }
    };
    private final long jUw = 300;
    private long jUx = SystemClock.elapsedRealtime();
    private com.tencent.mm.plugin.sns.k.b jUy = ((com.tencent.mm.plugin.sns.k.b) i(com.tencent.mm.plugin.sns.k.b.class));
    private com.tencent.mm.plugin.sns.k.a jUz = this.jUy.aYx();
    private ax jVA = null;
    private OnClickListener jVB = new OnClickListener(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.jVD.jUx < 300) {
                SnsTimeLineUI.D(this.jVD);
            }
            this.jVD.jUx = SystemClock.elapsedRealtime();
            ad.aqz().removeCallbacks(this.jVD.jVq);
            this.jVD.jVq.run();
        }
    };
    private boolean jVC = false;
    private c jVa = new c<og>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = og.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (this.jVD.jUG != null) {
                com.tencent.mm.plugin.sns.i.b bVar2 = this.jVD.jUG.jEo.jmQ;
                bVar2.jrO++;
                this.jVD.jUG.jEo.jmQ.fY(false);
            }
            return false;
        }
    };
    private c jVb = new c<nj>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = nj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nj njVar = (nj) bVar;
            if (this.jVD.jUG != null) {
                com.tencent.mm.plugin.sns.i.b bVar2 = this.jVD.jUG.jEo.jmQ;
                String str = njVar.boA.boB;
                bVar2.jte.add(njVar.boA.boC);
                bVar2.jtm.add(str);
                bVar2.jrP = bVar2.jtm.size();
            }
            return false;
        }
    };
    private c jVc = new c<nw>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = nw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nw nwVar = (nw) bVar;
            if (this.jVD.jUG != null) {
                com.tencent.mm.plugin.sns.i.b bVar2;
                if (nwVar.boQ.boR) {
                    bVar2 = this.jVD.jUG.jEo.jmQ;
                    bVar2.jto.add(nwVar.boQ.username);
                    bVar2.jrR = bVar2.jto.size();
                } else {
                    bVar2 = this.jVD.jUG.jEo.jmQ;
                    bVar2.jtp.add(nwVar.boQ.username);
                    bVar2.jrS = bVar2.jtp.size();
                }
            }
            return false;
        }
    };
    private c jVd = new c<nv>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = nv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            this.jVD.jUB.jWl.notifyVendingDataChange();
            return false;
        }
    };
    private c jVe = new c<fp>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = fp.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            fp fpVar = (fp) bVar;
            SnsTimeLineUI.a(this.jVD, fpVar.beU.beX, fpVar.beU.beW, fpVar);
            return false;
        }
    };
    private c jVf = new c<com.tencent.mm.e.a.e>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = com.tencent.mm.e.a.e.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            boolean z = true;
            com.tencent.mm.e.a.e eVar = (com.tencent.mm.e.a.e) bVar;
            if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                com.tencent.mm.plugin.sns.i.b bVar2 = this.jVD.jUG.jEo.jmQ;
                boolean z2 = eVar.aWq.aWr;
                String str = eVar.aWq.className;
                if (str.toLowerCase().indexOf("sns") < 0 && str.toLowerCase().indexOf("sightuploadui") < 0 && !str.contains("WebViewUI")) {
                    z = false;
                }
                if (!z) {
                    v.d("MicroMsg.SnsBrowseInfoHelper", "handleActivityStatusChanged, not sns scene, className" + str + ",_active=" + z2);
                } else if (!z2) {
                    bVar2.jst = System.currentTimeMillis();
                } else if (bVar2.jst > 0) {
                    bVar2.jss += System.currentTimeMillis() - bVar2.jst;
                    bVar2.jst = 0;
                }
            }
            return false;
        }
    };
    private c jVg = new c<ng>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = ng.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                this.jVD.jUG.jEo.jmQ.gh(true);
            }
            return false;
        }
    };
    private c jVh = new c<nk>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = nk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nk nkVar = (nk) bVar;
            if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                this.jVD.jUG.jEo.jmQ.cH(nkVar.boD.bap, nkVar.boD.boC);
            }
            return false;
        }
    };
    private c jVi = new c<no>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = no.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            no noVar = (no) bVar;
            if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                com.tencent.mm.plugin.sns.i.b bVar2 = this.jVD.jUG.jEo.jmQ;
                bVar2.jtk.add(noVar.boH.boC);
            }
            return false;
        }
    };
    private c jVj = new c<np>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = np.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            np npVar = (np) bVar;
            if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                com.tencent.mm.plugin.sns.i.b bVar2 = this.jVD.jUG.jEo.jmQ;
                bVar2.jtj.add(npVar.boI.boC);
            }
            return false;
        }
    };
    private c jVk = new c<nq>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r2;
            this.nhz = nq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            nq nqVar = (nq) bVar;
            if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                com.tencent.mm.plugin.sns.i.b bVar2 = this.jVD.jUG.jEo.jmQ;
                bVar2.jtg.add(nqVar.boJ.boC);
            }
            return false;
        }
    };
    private long jVl = 0;
    boolean jVm = false;
    Runnable jVn = new Runnable(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final void run() {
            if (this.jVD.jUB != null && this.jVD.jVm) {
                ad.aSB().pause();
            }
        }
    };
    Runnable jVo = new Runnable(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final void run() {
            if (this.jVD.jUB != null && !this.jVD.jVm) {
                v.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[]{Integer.valueOf(this.jVD.jUS.gMx.getFirstVisiblePosition() - this.jVD.jUS.gMx.getHeaderViewsCount())});
                ad.aSB().start();
                this.jVD.jUB.jWk.aXB();
            }
        }
    };
    private Handler jVp = ((com.tencent.mm.vending.h.b) d.phY.pif).mHandler;
    private Runnable jVq = new Runnable(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final void run() {
            this.jVD.bAc();
            this.jVD.aXH();
            this.jVD.Fd(this.jVD.getString(2131235562));
            this.jVD.jVl = 0;
            this.jVD.hEx = this.jVD.jUS.gMx.getFirstVisiblePosition();
        }
    };
    private com.tencent.mm.plugin.sns.ui.ay.a jVr = new com.tencent.mm.plugin.sns.ui.ay.a(this) {
        final /* synthetic */ SnsTimeLineUI jVD;
        private int jVE = 0;
        private int jVF = 0;

        {
            this.jVD = r2;
        }

        public final void aXK() {
            this.jVD.jUy.kcq.b(this.jVD.dRA, this.jVD.jUQ, false, this.jVD.jUR);
            v.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
            if (this.jVD.jVp == null) {
                v.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
            } else if (this.jVD.jUG != null) {
                this.jVD.jVp.removeCallbacks(this.jVD.jUT);
                this.jVD.jVp.postDelayed(this.jVD.jUT, 3000);
            }
        }

        public final ListView aXL() {
            if (this.jVD.jUG.gMx == null) {
                this.jVD.jUG.gMx = (ListView) this.jVD.findViewById(2131759452);
            }
            return this.jVD.jUG.gMx;
        }

        public final MMPullDownView aXM() {
            return (MMPullDownView) this.jVD.findViewById(2131759451);
        }

        public final int getType() {
            return 1;
        }

        public final void a(int i, List<Integer> list, List<Integer> list2) {
            int i2 = 1;
            if (i > 0) {
                k qG = ad.aSE().qG(i);
                if (qG != null) {
                    if (qG.field_pravited > 0) {
                        Toast.makeText(this.jVD, 2131235423, 1).show();
                    }
                    if (qG.field_pravited == 1) {
                        i2 = 0;
                    }
                }
            }
            if (i2 != 0) {
                BackwardSupportUtil.c.a(this.jVD.jUS.gMx);
            }
            if (this.jVD.jUB != null) {
                this.jVD.jUB.jWl.notifyVendingDataChange();
            }
        }

        public final boolean aXN() {
            return this.jVD.jEu;
        }

        public final void aXO() {
            this.jVD.aVG();
            if (this.jVD.jUD != null) {
                v.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
                this.jVD.jUD.setVisibility(0);
            }
            this.jVD.jUy.kcp.b(this.jVD.dRA, this.jVD.jUQ, this.jVD.jGc, this.jVD.jUR);
        }

        public final void aXP() {
            this.jVD.aVG();
        }

        public final void aXQ() {
            int firstVisiblePosition = this.jVD.jUS.gMx.getFirstVisiblePosition();
            int lastVisiblePosition = this.jVD.jUS.gMx.getLastVisiblePosition();
            if (firstVisiblePosition != this.jVE || lastVisiblePosition != this.jVF) {
                com.tencent.mm.plugin.sns.i.a.a aVar;
                this.jVE = firstVisiblePosition;
                this.jVF = lastVisiblePosition;
                v.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s ", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition)});
                com.tencent.mm.plugin.sns.i.a f = this.jVD.jUM;
                as asVar = this.jVD.jUB.jWk;
                firstVisiblePosition = com.tencent.mm.modelsns.b.cZO;
                if (firstVisiblePosition == 2) {
                    aVar = null;
                } else if (firstVisiblePosition != 4 || f.jrl) {
                    long nanoTime = System.nanoTime();
                    com.tencent.mm.plugin.sns.i.a.a aVar2 = new com.tencent.mm.plugin.sns.i.a.a();
                    aVar2.jrm = System.currentTimeMillis();
                    aVar2.mScreenHeight = f.mScreenHeight;
                    aVar2.mScreenWidth = f.mScreenWidth;
                    lastVisiblePosition = f.jrk.getTop();
                    firstVisiblePosition = f.jrk.getHeight();
                    if (lastVisiblePosition < 0) {
                        firstVisiblePosition += lastVisiblePosition;
                    }
                    aVar2.jro = firstVisiblePosition;
                    lastVisiblePosition = f.dyx.getFirstVisiblePosition() - 1;
                    int lastVisiblePosition2 = f.dyx.getLastVisiblePosition() - 1;
                    aVar2.jrn = lastVisiblePosition;
                    aVar2.dWm = lastVisiblePosition2;
                    int count = asVar.getCount();
                    boolean z = false;
                    if (f.dyx.getChildAt(0) != null) {
                        z = f.dyx.getChildAt(0) instanceof SnsHeader;
                    }
                    v.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[]{Integer.valueOf(lastVisiblePosition), Integer.valueOf(lastVisiblePosition2), Boolean.valueOf(z)});
                    firstVisiblePosition = z ? 1 : 0;
                    int childCount = f.dyx.getChildCount();
                    int i = lastVisiblePosition;
                    while (i <= lastVisiblePosition2) {
                        if (i < count && i >= 0) {
                            if (firstVisiblePosition >= childCount) {
                                v.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(childCount)});
                            } else {
                                if (aVar2.jrp == null) {
                                    aVar2.jrp = new LinkedList();
                                }
                                com.tencent.mm.plugin.sns.i.a.b bVar = new com.tencent.mm.plugin.sns.i.a.b();
                                aVar2.jrp.add(bVar);
                                View childAt = f.dyx.getChildAt(firstVisiblePosition);
                                lastVisiblePosition = firstVisiblePosition + 1;
                                firstVisiblePosition = childAt.getTop();
                                int left = childAt.getLeft();
                                int height = childAt.getHeight();
                                int width = childAt.getWidth();
                                k qK = asVar.qK(i);
                                bVar.jrw = i.g(qK);
                                bVar.jru = qK.field_type;
                                bVar.jrv = qK.qC(32);
                                bVar.jrq = firstVisiblePosition;
                                bVar.jrr = left;
                                bVar.jrs = height;
                                bVar.jrt = width;
                                if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c))) {
                                    com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
                                    if (cVar.kaD && cVar.jDC != null) {
                                        int top = cVar.jDC.getTop();
                                        left = cVar.jDC.getLeft();
                                        height = cVar.kav.getHeight();
                                        width = cVar.kav.getWidth();
                                        int top2 = cVar.kaw.getTop() + top;
                                        int left2 = cVar.kaw.getLeft() + left;
                                        int height2 = cVar.kaw.getHeight();
                                        int width2 = cVar.kaw.getWidth();
                                        v.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[]{Integer.valueOf(cVar.position), Integer.valueOf(i), Integer.valueOf(lastVisiblePosition)});
                                        if (cVar.jbw.mTi != 0) {
                                            bVar.jry = cVar.jbw.mTi;
                                            bVar.jrz = top;
                                            bVar.jrA = left;
                                            bVar.jrB = width;
                                            bVar.jrC = height;
                                        }
                                        if (cVar.jbw.mTl != 0) {
                                            bVar.jrx = cVar.jbw.mTl;
                                            bVar.jrE = left2;
                                            bVar.jrD = top2;
                                            bVar.jrF = width2;
                                            bVar.jrG = height2;
                                        }
                                    }
                                }
                                firstVisiblePosition = lastVisiblePosition;
                            }
                        }
                        i++;
                    }
                    v.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
                    aVar = aVar2;
                } else {
                    aVar = null;
                }
                com.tencent.mm.vending.g.g.bKO().d(new com.tencent.mm.vending.c.a<Void, Void>(this) {
                    final /* synthetic */ AnonymousClass14 jVH;

                    public final /* synthetic */ Object aq(Object obj) {
                        Void voidR = (Void) obj;
                        if (aVar != null) {
                            com.tencent.mm.plugin.sns.i.a.a aVar = aVar;
                            com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(501);
                            gh.cZE = aVar.jrm;
                            gh.gk(aVar.mScreenWidth).gk(aVar.mScreenHeight);
                            gh.gk(aVar.jro);
                            gh.gk(0);
                            gh.gk(aVar.jrn);
                            gh.gk(aVar.dWm);
                            gh.JF();
                            if (aVar.jrp != null) {
                                for (com.tencent.mm.plugin.sns.i.a.b bVar : aVar.jrp) {
                                    com.tencent.mm.modelsns.a gh2 = com.tencent.mm.modelsns.a.gh(502);
                                    gh2.cZE = aVar.jrm;
                                    gh2.kj(bVar.jrw).gk(bVar.jru).bg(bVar.jrv).gk(bVar.jrr).gk(bVar.jrq).gk(bVar.jrt).gk(bVar.jrs);
                                    gh2.JF();
                                    v.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", new Object[]{Integer.valueOf(bVar.jrq), Integer.valueOf(bVar.jrr), Integer.valueOf(bVar.jrt), Integer.valueOf(bVar.jrs)});
                                    v.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", new Object[]{Integer.valueOf(bVar.jrz), Integer.valueOf(bVar.jrA), Integer.valueOf(bVar.jrC), Integer.valueOf(bVar.jrB)});
                                    v.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", new Object[]{Integer.valueOf(bVar.jrD), Integer.valueOf(bVar.jrE), Integer.valueOf(bVar.jrG), Integer.valueOf(bVar.jrF)});
                                    if (bVar.jry != 0) {
                                        gh2 = com.tencent.mm.modelsns.a.gh(503);
                                        gh2.cZE = aVar.jrm;
                                        gh2.kj(bVar.jrw).gk(bVar.jru).bg(bVar.jrv).gk(bVar.jry).gk(bVar.jrA).gk(bVar.jrz).gk(bVar.jrB).gk(bVar.jrC);
                                        gh2.JF();
                                    }
                                    if (bVar.jrx != 0) {
                                        gh2 = com.tencent.mm.modelsns.a.gh(504);
                                        gh2.cZE = aVar.jrm;
                                        gh2.kj(bVar.jrw).gk(bVar.jru).bg(bVar.jrv).gk(bVar.jrx).gk(bVar.jrE).gk(bVar.jrD).gk(bVar.jrF).gk(bVar.jrG);
                                        gh2.JF();
                                    }
                                }
                            }
                            gh = com.tencent.mm.modelsns.a.gh(506);
                            gh.cZE = aVar.jrm;
                            gh.JF();
                        }
                        return voidR;
                    }
                });
            }
        }

        public final void J(int i, boolean z) {
            if (this.jVD.jUB != null) {
                this.jVD.jUB.jWl.notifyVendingDataChange();
            }
            if (!z) {
                this.jVD.vF().u(com.tencent.mm.plugin.sns.k.c.b.class);
            }
        }

        public final void gw(boolean z) {
            SnsTimeLineUI snsTimeLineUI = this.jVD;
            snsTimeLineUI.jVm = z;
            ac aqz = ad.aqz();
            com.tencent.mm.plugin.sns.e.g aSB = ad.aSB();
            com.tencent.mm.plugin.sns.e.b aSz = ad.aSz();
            if (z) {
                if (aSB.jiL || aSz.jiL) {
                    aqz.removeCallbacks(snsTimeLineUI.jVn);
                    aqz.removeCallbacks(snsTimeLineUI.jVo);
                    aqz.postDelayed(snsTimeLineUI.jVn, 0);
                }
            } else if (!aSB.jiL || !aSz.jiL) {
                aqz.removeCallbacks(snsTimeLineUI.jVn);
                aqz.removeCallbacks(snsTimeLineUI.jVo);
                aqz.postDelayed(snsTimeLineUI.jVo, 0);
            }
        }
    };
    private com.tencent.mm.vending.app.a.b jVs = new com.tencent.mm.vending.app.a.b<com.tencent.mm.plugin.sns.k.c.b>(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final /* synthetic */ void aB(Object obj) {
            com.tencent.mm.plugin.sns.k.c.b bVar = (com.tencent.mm.plugin.sns.k.c.b) obj;
            if (bVar.kct > 0) {
                SnsTimeLineUI.a(this.jVD, bVar);
                this.jVD.jUC.findViewById(2131759367).setVisibility(0);
            } else {
                this.jVD.jUC.findViewById(2131759367).setVisibility(8);
            }
            if (this.jVD.jUS.jrk != null && this.jVD.jUS.jrk.aWQ()) {
                this.jVD.jUC.setVisibility(0);
            } else if (bVar.kct == 0) {
                this.jVD.jUC.setVisibility(8);
            }
            if (this.jVD.jUB != null && this.jVD.jUI.hasDrawed()) {
                this.jVD.jUB.jWl.notifyVendingDataChange();
                v.i("MicroMsg.SnsTimeLineUI", "has not show view, pass");
            }
        }
    };
    boolean jVt = true;
    private OnMenuItemClickListener jVv = new OnMenuItemClickListener(this) {
        final /* synthetic */ SnsTimeLineUI jVD;

        {
            this.jVD = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (this.jVD.jUA == null || !this.jVD.jUA.jJG) {
                this.jVD.axg();
                this.jVD.finish();
                return false;
            }
            this.jVD.jUA.gq(true);
            this.jVD.aXE();
            return true;
        }
    };
    private View jVw;
    private ImageView jVx;
    private View jVy;
    private MenuItem jVz;
    private boolean jrl = false;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;

    class a extends Animation {
        ListView gMx;
        final /* synthetic */ SnsTimeLineUI jVD;
        float jVP;
        float jVQ;
        float jVR = -1.0f;
        float jVS;
        float jVT = 0.0f;
        private float jVU;
        boolean jVV;
        int jVW;
        boolean jVX = false;
        int jVY = 0;
        float jVZ = 0.0f;
        float jWa = 0.0f;

        public a(SnsTimeLineUI snsTimeLineUI, ListView listView) {
            this.jVD = snsTimeLineUI;
            this.gMx = listView;
        }

        public final void aXU() {
            v.d("MicroMsg.SnsTimeLineUI", "animtest playLoading");
            if (this.jVD.jUD.getVisibility() == 0) {
                init();
                this.jVT = this.jVR + 20.0f;
                LayoutParams layoutParams = (LayoutParams) this.jVD.jUD.getLayoutParams();
                layoutParams.y = (int) this.jVR;
                this.jVD.jUD.setLayoutParams(layoutParams);
                aXV();
            }
        }

        public final void aXV() {
            if (this.jVD.jUD.getVisibility() == 0) {
                init();
                this.jVD.jUD.clearAnimation();
                this.jVD.jUD.startAnimation(this);
                if (this.jVT >= this.jVR) {
                    setDuration(20000);
                    this.jVV = false;
                    return;
                }
                setDuration(600);
                this.jVV = true;
            }
        }

        final void init() {
            if (this.jVR == -1.0f || ((double) this.jVQ) < 0.1d) {
                this.jVR = (float) BackwardSupportUtil.b.a(this.jVD, 25.0f);
                this.jVP = (float) (this.jVD.jUD.getWidth() / 2);
                this.jVQ = (float) (this.jVD.jUD.getHeight() / 2);
                this.jVS = (this.jVQ * -2.0f) - 3.0f;
                v.d("MicroMsg.SnsTimeLineUI", "MIN_Y" + this.jVS);
                this.jVT = this.jVS;
                if (!this.jVX) {
                    v.i("MicroMsg.SnsTimeLineUI", "initState");
                    this.jVY = ((LayoutParams) this.jVD.jUD.getLayoutParams()).y;
                    this.jVZ = this.jVR;
                    this.jWa = this.jVT;
                }
                this.jVX = true;
            }
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            if (this.jVD.jUD.getVisibility() == 0) {
                float duration = ((float) getDuration()) * (f - this.jVU);
                if (duration >= 2.0f) {
                    this.jVU = f;
                    this.jVD.jUD.setImageResource(2131165587);
                    this.jVD.jUD.a(com.tencent.mm.ui.widget.QImageView.a.ped);
                    if (((float) getDuration()) * f >= ((float) (getDuration() - 600)) || this.jVV) {
                        LayoutParams layoutParams = (LayoutParams) this.jVD.jUD.getLayoutParams();
                        this.jVT = ((float) layoutParams.y) - (duration / 3.0f);
                        layoutParams.y = (int) this.jVT;
                        this.jVD.jUD.setLayoutParams(layoutParams);
                    } else {
                        this.jVD.jUD.mMatrix.postRotate(duration / 2.5f, this.jVP, this.jVQ);
                    }
                    this.jVD.jUD.invalidate();
                }
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.jVU = 0.0f;
            this.jVT = this.jVR;
        }
    }

    static /* synthetic */ void B(SnsTimeLineUI snsTimeLineUI) {
        int i = 1;
        if (snsTimeLineUI.jUJ <= 3) {
            int firstVisiblePosition = snsTimeLineUI.jUS.gMx.getFirstVisiblePosition();
            if (System.currentTimeMillis() - snsTimeLineUI.jVl > 1000 || firstVisiblePosition > snsTimeLineUI.hEx) {
                snsTimeLineUI.jVl = 0;
                snsTimeLineUI.hEx = snsTimeLineUI.jUS.gMx.getFirstVisiblePosition();
            }
            snsTimeLineUI.jVl = System.currentTimeMillis();
            if (snsTimeLineUI.hEx - firstVisiblePosition >= 10 && firstVisiblePosition > 10) {
                v.i("MicroMsg.SnsTimeLineUI", "showTopTip %d", new Object[]{Integer.valueOf(snsTimeLineUI.jUJ)});
                if (snsTimeLineUI.jUJ <= 3) {
                    com.tencent.mm.ui.k kVar = snsTimeLineUI.nDR;
                    if (kVar.FG == null || kVar.FG.getCustomView() == null || kVar.FG.getCustomView().findViewById(2131755288) == null) {
                        i = 0;
                    }
                    if (i == 0) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(snsTimeLineUI.nDR.nEl, 2130968643);
                        CharSequence string = snsTimeLineUI.getString(2131235381);
                        com.tencent.mm.ui.k kVar2 = snsTimeLineUI.nDR;
                        if (kVar2.FG != null) {
                            kVar2.FG.cN();
                            TextView textView = (TextView) kVar2.FG.getCustomView().findViewById(2131755288);
                            if (textView != null) {
                                textView.clearAnimation();
                                if (loadAnimation != null) {
                                    textView.startAnimation(loadAnimation);
                                }
                                if (!be.kS(string)) {
                                    textView.setText(string);
                                }
                            }
                        }
                        snsTimeLineUI.nDR.bAi();
                        snsTimeLineUI.vH(16908332);
                        snsTimeLineUI.aXF();
                        snsTimeLineUI.jUJ++;
                        ad.aqz().removeCallbacks(snsTimeLineUI.jVq);
                        ad.aqz().postDelayed(snsTimeLineUI.jVq, 4000);
                    }
                }
            }
        }
    }

    static /* synthetic */ void D(SnsTimeLineUI snsTimeLineUI) {
        v.i("MicroMsg.SnsTimeLineUI", "double click");
        BackwardSupportUtil.c.a(snsTimeLineUI.jUS.gMx);
        snsTimeLineUI.jUD.setVisibility(0);
        snsTimeLineUI.jVq.run();
        snsTimeLineUI.jUG.aVu();
        snsTimeLineUI.aVG();
        new ac().postDelayed(new Runnable(snsTimeLineUI) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void run() {
                this.jVD.jUS.gMx.setSelection(0);
                a y = this.jVD.jUH;
                if (y.jVX) {
                    LayoutParams layoutParams = (LayoutParams) y.jVD.jUD.getLayoutParams();
                    layoutParams.y = y.jVY;
                    y.jVD.jUD.setLayoutParams(layoutParams);
                    y.jVR = y.jVZ;
                    y.jVT = y.jWa;
                }
                this.jVD.jUH.aXU();
                this.jVD.jUy.kcp.b(this.jVD.dRA, this.jVD.jUQ, this.jVD.jGc, this.jVD.jUR);
            }
        }, 300);
    }

    static /* synthetic */ void G(SnsTimeLineUI snsTimeLineUI) {
        snsTimeLineUI.aXI();
        if (!(snsTimeLineUI.jUG == null || snsTimeLineUI.jUG.jEo == null)) {
            snsTimeLineUI.jUG.jEo.jmQ.fY(true);
        }
        final com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(705);
        gh.gl(gh.cZD).kk(System.currentTimeMillis()).gl(gh.cZF).gl(1);
        snsTimeLineUI.jVA = new ax(snsTimeLineUI);
        snsTimeLineUI.jVA.jXn = new n.c(snsTimeLineUI) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void a(l lVar) {
                ak.yW();
                if (((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.ntE, Integer.valueOf(0))).intValue() == 1) {
                    lVar.d(2, this.jVD.getString(2131235513));
                }
                if (q.drg) {
                    lVar.d(2, this.jVD.getString(2131235513));
                } else {
                    lVar.d(3, this.jVD.getString(2131231049));
                }
                lVar.d(1, this.jVD.getString(2131231054));
            }
        };
        snsTimeLineUI.jVA.b(3, snsTimeLineUI.nDR.nEl.getString(2131231052));
        snsTimeLineUI.jVA.jXo = new n.d(snsTimeLineUI) {
            final /* synthetic */ SnsTimeLineUI jVD;

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                        com.tencent.mm.plugin.sns.i.e.jtT.b(gh);
                        gh.JF();
                        this.jVD.jUS.jXM = gh;
                        this.jVD.jUS.rj(1);
                        return;
                    case 2:
                        this.jVD.aXJ();
                        return;
                    case 3:
                        if (!com.tencent.mm.ah.a.aT(this.jVD)) {
                            v.d("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.jVD, "android.permission.CAMERA", 18, "", "")), be.bur(), this.jVD});
                            if (com.tencent.mm.pluginsdk.i.a.a(this.jVD, "android.permission.CAMERA", 18, "", "")) {
                                v.d("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.jVD, "android.permission.RECORD_AUDIO", 18, "", "")), be.bur(), this.jVD});
                                if (com.tencent.mm.pluginsdk.i.a.a(this.jVD, "android.permission.RECORD_AUDIO", 18, "", "")) {
                                    com.tencent.mm.plugin.report.service.g.iuh.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                                    com.tencent.mm.pluginsdk.ui.tools.l.u(this.jVD.nDR.nEl, new Intent());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        snsTimeLineUI.jVA.aXZ();
    }

    static /* synthetic */ void I(SnsTimeLineUI snsTimeLineUI) {
        snsTimeLineUI.bAc();
        snsTimeLineUI.nDR.bAi();
        snsTimeLineUI.jVz.setVisible(false);
        snsTimeLineUI.a(snsTimeLineUI.jVv, 2131165204);
        snsTimeLineUI.Fd("");
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i) {
        com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(507);
        int firstVisiblePosition = snsTimeLineUI.jUS.gMx.getFirstVisiblePosition() - 1;
        int lastVisiblePosition = snsTimeLineUI.jUS.gMx.getLastVisiblePosition() - 1;
        int count = snsTimeLineUI.jUB.getCount();
        while (firstVisiblePosition <= lastVisiblePosition) {
            if (firstVisiblePosition < count && firstVisiblePosition >= 0 && firstVisiblePosition != i) {
                if (i > firstVisiblePosition) {
                    String g = i.g(snsTimeLineUI.jUG.jpB.qK(firstVisiblePosition));
                    if (gh.JB()) {
                        if (gh.cZL.length() != 0) {
                            gh.cZL.append("||" + g);
                        } else if (be.kS(g)) {
                            gh.cZL.append(" ");
                        } else {
                            gh.cZL.append(g);
                        }
                    }
                } else {
                    gh.kj(i.g(snsTimeLineUI.jUG.jpB.qK(firstVisiblePosition)));
                }
            }
            firstVisiblePosition++;
        }
        gh.JF();
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, int i, int i2, fp fpVar) {
        int firstVisiblePosition = snsTimeLineUI.jUG.gMx.getFirstVisiblePosition();
        int headerViewsCount = snsTimeLineUI.jUG.gMx.getHeaderViewsCount();
        k qK = snsTimeLineUI.jUG.jpB.qK(i2);
        if (qK != null) {
            azr aUp = qK.aUp();
            if (aUp.mWq.mol == 1 && aUp.mWq.mom.size() == 4 && i > 1) {
                i++;
            }
        } else {
            v.e("MicroMsg.SnsTimeLineUI", "snsInfo is null");
        }
        View childAt = snsTimeLineUI.jUG.gMx.getChildAt((i2 - firstVisiblePosition) + headerViewsCount);
        if (childAt != null && childAt.getTag() != null && (childAt.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c)) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) childAt.getTag();
            if (cVar.kaA != null) {
                TagImageView qQ = cVar.kaA.qQ(i);
                if (qQ != null) {
                    int[] iArr = new int[2];
                    qQ.getLocationInWindow(iArr);
                    fpVar.beV.aXV = iArr[0];
                    fpVar.beV.aXW = iArr[1];
                    fpVar.beV.aXX = qQ.getWidth();
                    fpVar.beV.aXY = qQ.getHeight();
                }
            }
        }
    }

    static /* synthetic */ void a(SnsTimeLineUI snsTimeLineUI, com.tencent.mm.plugin.sns.k.c.b bVar) {
        snsTimeLineUI.jUC.setVisibility(0);
        ((TextView) snsTimeLineUI.findViewById(2131759369)).setText(snsTimeLineUI.getResources().getQuantityString(2131361820, bVar.kct, new Object[]{Integer.valueOf(bVar.kct)}));
        com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) snsTimeLineUI.findViewById(2131759368), bVar.kcs);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        v.i("MicroMsg.SnsTimeLineUI", "dispatchKeyEvent %s", new Object[]{keyEvent.toString()});
        int i2 = this.nDR.nEB;
        h hVar = this.jUG;
        if (keyEvent.getKeyCode() == 4 && hVar.jEp.getVisibility() == 0) {
            hVar.jEp.setVisibility(8);
            i = 1;
        }
        if (i == 0 || i2 != 2) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public final void a(final boolean z, final boolean z2, final String str, boolean z3) {
        this.jVp.removeCallbacks(this.jUT);
        com.tencent.mm.vending.g.g.bKO().d(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            public final /* synthetic */ Object aq(Object obj) {
                Void voidR = (Void) obj;
                au a = this.jVD.jUB;
                if (a != null) {
                    a.jWl.jJv = str;
                    at atVar = a.jWl;
                    atVar.looperCheckForVending();
                    v.i("MicroMsg.SnsTimeLineVendingSide", "resetSize %s", new Object[]{Boolean.valueOf(atVar.jWf)});
                    if (!atVar.jWf) {
                        atVar.fHQ = atVar.k(0, atVar.fHQ);
                    }
                    a.jWl.notifyVendingDataChange();
                }
                return voidR;
            }
        }).e(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            public final /* synthetic */ Object aq(Object obj) {
                Void voidR = (Void) obj;
                this.jVD.jUS.jXH = z2;
                if (z2) {
                    this.jVD.jUS.go(false);
                } else if (z) {
                    this.jVD.jUy.kcq.b("@__weixintimtline", this.jVD.jUQ, this.jVD.jGc, 0);
                }
                return voidR;
            }
        });
    }

    public final void b(final boolean z, final String str, boolean z2) {
        this.jVp.removeCallbacks(this.jUT);
        com.tencent.mm.vending.g.g.bKO().d(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            public final /* synthetic */ Object aq(Object obj) {
                Void voidR = (Void) obj;
                au a = this.jVD.jUB;
                if (a != null) {
                    a.jWl.jJv = str;
                    a.jWl.aXn();
                    a.jWl.notifyVendingDataChange();
                }
                return voidR;
            }
        }).e(new com.tencent.mm.vending.c.a<Void, Void>(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            public final /* synthetic */ Object aq(Object obj) {
                Void voidR = (Void) obj;
                this.jVD.jUS.jXH = z;
                v.d("MicroMsg.SnsTimeLineUI", "onNpSize %s", new Object[]{Boolean.valueOf(z)});
                if (z) {
                    this.jVD.jUS.go(false);
                }
                return voidR;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        int i;
        int i2 = 1;
        getIntent().setExtrasClassLoader(getClass().getClassLoader());
        com.tencent.mm.pluginsdk.e.f(this);
        super.onCreate(bundle);
        com.tencent.mm.bh.a.byo();
        this.jUz.a(com.tencent.mm.plugin.sns.k.c.b.class, this.jVs);
        this.jUz.a(this);
        com.tencent.mm.plugin.sns.k.c.a aVar = (com.tencent.mm.plugin.sns.k.c.a) this.jUz.t(com.tencent.mm.plugin.sns.k.c.a.class);
        this.dRA = aVar.dRA;
        this.jUP = aVar.jUP;
        this.jUQ = aVar.jUQ;
        this.jGc = aVar.jGc;
        this.jUR = aVar.jUR;
        String str = aVar.gpi;
        String str2 = aVar.jXL;
        this.jUS = new ay(this);
        this.jUS.jXK = this.jVr;
        ak.oH().dB(2);
        com.tencent.mm.plugin.sns.ui.widget.c.aYt().kcf = 0;
        com.tencent.mm.plugin.sns.ui.widget.a.aYr().kcf = 0;
        com.tencent.mm.modelsns.b bVar = com.tencent.mm.modelsns.b.cZP;
        com.tencent.mm.modelsns.b.JG();
        this.jUG = new h(this, getIntent().getBooleanExtra("is_sns_notify_open", true) ? 1 : 0, be.ah(getIntent().getStringExtra("new_feed_id"), ""), getIntent().getIntExtra("sns_unread_count", 0));
        this.jEu = getIntent().getBooleanExtra("sns_resume_state", true);
        if (ad.aSn()) {
            this.jEu = false;
        } else if (this.jEu) {
            this.jEu = ad.aSJ().aWl();
        }
        this.jUE = this.jEu;
        this.jUS.a(this.jUP, this.dRA, str, str2, this.jUQ, this.jGc, this.jUR);
        this.jUS.onCreate();
        com.tencent.mm.plugin.sns.f.c aSv = ad.aSv();
        List arrayList = new ArrayList();
        for (com.tencent.mm.storage.c cVar : com.tencent.mm.model.c.c.Au().Lt("10001").values()) {
            com.tencent.mm.plugin.sns.f.d dVar = new com.tencent.mm.plugin.sns.f.d();
            if (cVar == null) {
                v.i("MicroMsg.SnsABTestStrategy", "abtest is null");
            } else if (cVar.isValid()) {
                Map buX = cVar.buX();
                if (buX != null) {
                    v.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + cVar.field_expId + " " + cVar.field_layerId + " " + cVar.field_startTime + " " + cVar.field_endTime);
                    dVar.d(cVar.field_layerId, cVar.field_expId, buX);
                    if (!dVar.aZW || dVar.jpZ == null || dVar.jpZ.size() <= 0) {
                        z = false;
                    } else {
                        i = 1;
                    }
                    if (i != 0) {
                        arrayList.add(dVar);
                    }
                }
            } else {
                v.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            }
        }
        aSv.jpz = arrayList;
        aSv.jpC.clear();
        aSv.jpD.clear();
        aSv.jpF.clear();
        aSv.jku = null;
        if (!(aSv.jpz == null || aSv.jpz.size() == 0)) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            str2 = stringBuilder.append(com.tencent.mm.model.c.xp()).append("ws_1100004").toString();
            v.i("MicroMsg.SnSABTestMgr", "filepath to list  " + str2);
            byte[] c = FileOp.c(str2, 0, -1);
            if (c != null) {
                try {
                    aSv.jku = (com.tencent.mm.plugin.sns.g.c) new com.tencent.mm.plugin.sns.g.c().az(c);
                    v.i("MicroMsg.SnSABTestMgr", "fileToList " + (System.currentTimeMillis() - currentTimeMillis));
                    if (aSv.jku == null) {
                        v.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId parser error");
                    } else {
                        v.i("MicroMsg.SnSABTestMgr", "igNoreAbTestId size " + aSv.jku.jqp.size());
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.SnSABTestMgr", e, "", new Object[0]);
                    FileOp.deleteFile(str2);
                }
            }
        }
        this.FG = cU().cV();
        ak.vy().a(213, this);
        ak.vy().a(682, this);
        ak.vy().a(218, this);
        ak.vy().a(211, this);
        ak.vy().a(683, this);
        NI();
        com.tencent.mm.plugin.sns.f.c aSv2 = ad.aSv();
        ListView listView = this.jUS.gMx;
        as asVar = this.jUB.jWk;
        aSv2.jpA = listView;
        aSv2.jpB = asVar;
        ak.vy().a(291, ad.aSv());
        this.jUF = getIntent().getBooleanExtra("sns_timeline_NeedFirstLoadint", false);
        this.jUG.fRJ = (ClipboardManager) getSystemService("clipboard");
        if (ad.aSn()) {
            this.jEu = false;
        } else if (this.jEu) {
            this.jEu = ad.aSJ().aWl();
        }
        com.tencent.mm.vending.app.a aVar2 = this.jUz;
        aVar2.jWl = this.jUB.jWl;
        aVar2.pga.a(aVar2.jWl);
        if (this.jEu) {
            this.jUF = false;
            i = ad.aSJ().position;
            this.jUB.jWl.fHQ = ad.aSJ().fHQ;
            this.jUB.jWl.jJv = ad.aSJ().jJv;
            this.jUB.jWl.jWf = true;
            this.jUB.sW();
            if (i >= this.jUB.getCount()) {
                i = this.jUB.getCount() - 1;
                v.e("MicroMsg.SnsTimeLineUI", "error position %s", new Object[]{Integer.valueOf(this.jUB.getCount())});
            }
            this.jUS.gMx.setAdapter(this.jUB);
            v.d("MicroMsg.SnsTimeLineUI", "resume position %s", new Object[]{Integer.valueOf(ad.aSJ().jJw)});
            this.jUS.gMx.setSelectionFromTop(i, ad.aSJ().jJw);
            this.jUD.setVisibility(4);
        } else {
            this.jUS.gMx.setAdapter(this.jUB);
            this.jUD.setVisibility(0);
            this.jUB.sW();
        }
        int count = this.jUB.getCount();
        i = this.jUS.gMx.getFirstVisiblePosition();
        if (i < count) {
            this.jUL = i.g(this.jUB.qK(i));
        }
        ak.yW();
        this.jUJ = ((Integer) com.tencent.mm.model.c.vf().get(327776, Integer.valueOf(0))).intValue();
        this.jUG.jEw = new be(this, this.jUB.jWk, this.jUG.joW);
        this.jUG.jEy = new com.tencent.mm.plugin.sns.f.b(this, this.jUB.jWk.joV, this.jUG.joW);
        this.jUG.jEx = new b(this, this.jUB.jWk.joV, this.jUG.joW, this.jUG.jEy);
        if (this.jUO != null) {
            this.jUO.a(this.jUG.jEy);
        }
        if (count > 0) {
            k qK = this.jUB.qK(0);
            if (!(this.jUG.jEo == null || this.jUG.jEo.jmQ == null)) {
                this.jUG.jEo.jmQ.jrI = qK.field_snsId;
            }
            com.tencent.mm.plugin.sns.i.d dVar2 = com.tencent.mm.plugin.sns.i.d.jtP;
            if (dVar2.cNA != 0) {
                if (dVar2.jtQ.isEmpty()) {
                    dVar2.bYA.setLong(2, be.Nh());
                }
                v.i("MicroMsg.SnsReportHelper", "enterTimeLine exposureFeedSize %d", new Object[]{Integer.valueOf(dVar2.jtQ.size())});
            }
        }
        com.tencent.mm.plugin.report.service.g.iuh.Y(13312, "1," + be.Ni());
        com.tencent.mm.sdk.c.a.nhr.e(this.jUU);
        if (getIntent().getBooleanExtra("is_need_resend_sns", false)) {
            com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                final /* synthetic */ SnsTimeLineUI jVD;

                {
                    this.jVD = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.base.g.b(this.jVD, this.jVD.getString(2131234092), "", this.jVD.getString(2131234093), this.jVD.getString(2131231010), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass20 jVL;

                        {
                            this.jVL = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.a.nhr.z(new lo());
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass20 jVL;

                        {
                            this.jVL = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.a.nhr.z(new jd());
                        }
                    });
                }
            }, 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(589825, Boolean.valueOf(false));
        }
        this.jUG.jEn = this.jMU;
        g gVar = this.jMU;
        count = this.jUS.jbB;
        View customView = this.FG.getCustomView();
        gVar.jbB = count;
        gVar.jcp = customView;
        gVar.aXH = this;
        com.tencent.mm.sdk.c.a.nhr.e(this.jUY);
        com.tencent.mm.sdk.c.a.nhr.e(this.jUZ);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVa);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVb);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVc);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVe);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVd);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVf);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVg);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVh);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVj);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVi);
        com.tencent.mm.sdk.c.a.nhr.e(this.jVk);
        com.tencent.mm.plugin.sns.abtest.c.aQQ();
        com.tencent.mm.plugin.sns.abtest.a.b((Context) this, this.jUG.joW);
        if (this.jUM != null) {
            com.tencent.mm.plugin.sns.i.a aVar3 = this.jUM;
            listView = this.jUS.gMx;
            SnsHeader snsHeader = this.jUS.jrk;
            aVar3.dyx = listView;
            aVar3.jrk = snsHeader;
        }
        if (!(this.jUG == null || this.jUG.jEo == null)) {
            com.tencent.mm.plugin.sns.i.b bVar2 = this.jUG.jEo.jmQ;
            v.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineCreate");
            bVar2.jrH = true;
            bVar2.jtE = System.currentTimeMillis();
        }
        z = getIntent().getBooleanExtra("enter_by_red", false);
        if (!(this.jUG == null || this.jUG.jEo == null)) {
            com.tencent.mm.plugin.sns.i.b bVar3 = this.jUG.jEo.jmQ;
            if (!z) {
                i2 = 0;
            }
            bVar3.jrU = i2;
        }
        ad.aSB().jjf.clear();
        com.tencent.mm.pluginsdk.e.g(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v.i("MicroMsg.SnsTimeLineUI", "onConfigurationChanged");
        com.tencent.mm.sdk.c.a.nhr.z(new bg());
        com.tencent.mm.pluginsdk.e.g(this);
        com.tencent.mm.plugin.sns.ui.widget.c.aYt().kcf = 0;
        com.tencent.mm.plugin.sns.ui.widget.a.aYr().kcf = 0;
        com.tencent.mm.kiss.widget.textview.c.clL.vK();
        this.jUB.jWk.aXw();
        this.jUB.jWl.resolvedClear();
    }

    public void onDestroy() {
        this.jUK = true;
        v.i("MicroMsg.SnsTimeLineUI", "timeline on destory");
        com.tencent.mm.sdk.c.a.nhr.f(this.jUY);
        com.tencent.mm.sdk.c.a.nhr.f(this.jUZ);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVa);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVb);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVc);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVe);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVd);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVf);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVg);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVh);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVi);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVj);
        com.tencent.mm.sdk.c.a.nhr.f(this.jVk);
        if (!(this.jUG == null || this.jUG.jEo == null)) {
            this.jUG.jEo.jmQ.jrV = this.jUV ? 1 : 0;
        }
        com.tencent.mm.plugin.sns.i.d dVar = com.tencent.mm.plugin.sns.i.d.jtP;
        if (dVar.cNA != 0) {
            v.i("MicroMsg.SnsReportHelper", "exitTimeline exposureFeedSize %d", new Object[]{Integer.valueOf(dVar.jtQ.size())});
            long j = dVar.bYA.getLong(2, 0);
            if (dVar.jtQ.isEmpty() || (dVar.jtQ.size() <= dVar.jtR && be.ax(j) <= ((long) dVar.jtS))) {
                dVar.bYA.set(3, dVar.jtQ);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : dVar.jtQ.keySet()) {
                    stringBuffer.append(str + "#" + dVar.jtQ.get(str) + "|");
                }
                stringBuffer.append("," + j + "," + be.Nh() + ",1");
                v.v("MicroMsg.SnsReportHelper", "report(13226) %d: %s", new Object[]{Integer.valueOf(13226), stringBuffer});
                com.tencent.mm.plugin.report.service.g.iuh.Y(13226, stringBuffer.toString());
                dVar.bYA.set(3, null);
                dVar.jtQ.clear();
                dVar.bYA.setLong(2, be.Nh());
            }
        }
        ak.yW();
        String str2 = (String) com.tencent.mm.model.c.vf().get(68377, null);
        int count = this.jUB.getCount();
        String str3 = "";
        k kVar = null;
        if (count > 0) {
            kVar = this.jUB.qK(count - 1);
            str3 = i.g(kVar);
        }
        if (!(this.jUG == null || this.jUG.jEo == null)) {
            com.tencent.mm.plugin.sns.i.b bVar = this.jUG.jEo.jmQ;
            int i = kVar == null ? -1 : kVar.field_createTime;
            v.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineDestroy");
            long currentTimeMillis = System.currentTimeMillis() - bVar.jtE;
            bVar.jrJ += currentTimeMillis;
            v.i("MicroMsg.SnsBrowseInfoHelper", "onTimelineEns passedtime: " + currentTimeMillis + " BrowseTime: " + bVar.jrJ + "BackgroundTime: " + bVar.jss);
            ad.aSo().post(new com.tencent.mm.plugin.sns.i.b.AnonymousClass2(bVar, i));
            bVar.jrH = false;
        }
        com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(704);
        if (gh.JB()) {
            gh.bg(this.jUV);
            gh.bg(!be.kS(str2));
            gh.kj(this.jUL);
            gh.kj(str3);
            gh.kj(str3);
            gh.gk(this.jUS.jXJ);
            gh.kj("");
            com.tencent.mm.modelsns.a.JE();
            gh.JF();
        }
        AdListView adListView = (AdListView) this.jUS.aXL();
        this.jUO.jnz.clear();
        ad.aSv().clean();
        ad.aSr().post(new Runnable(ad.aSy()) {
            final /* synthetic */ i jcR;

            {
                this.jcR = r1;
            }

            public final void run() {
                i.d(this.jcR);
            }
        });
        adListView.jCY.clear();
        adListView.jCY = null;
        adListView.jCZ.aRQ();
        adListView.jCZ = null;
        r.aRZ();
        if (!ad.aSn()) {
            this.jVp.removeCallbacks(this.jUT);
        }
        if (ak.uz()) {
            ak.vy().b(213, this);
            ak.vy().b(682, this);
            ak.vy().b(218, this);
            ak.vy().b(211, this);
            ak.vy().b(683, this);
            ak.yW();
            com.tencent.mm.model.c.vf().set(327776, Integer.valueOf(this.jUJ));
            ak.yW();
            com.tencent.mm.model.c.vf().set(589825, Boolean.valueOf(false));
        }
        if (this.jUG != null) {
            h hVar = this.jUG;
            hVar.jEz.afF();
            if (hVar.jEp != null) {
                hVar.jEp.ayA();
            }
            com.tencent.mm.sdk.c.a.nhr.f(hVar.jEB);
        }
        ad.aqz().removeCallbacks(this.jVq);
        if (this.jUB != null) {
            int i2;
            int firstVisiblePosition = this.jUS.gMx.getFirstVisiblePosition();
            i = 0;
            for (i2 = 0; i2 < this.jUS.gMx.getCount(); i2++) {
                View childAt = this.jUS.gMx.getChildAt(i2);
                if (childAt != null && this.jUS.gMx.getPositionForView(childAt) == firstVisiblePosition) {
                    int[] iArr = new int[2];
                    childAt.getLocationInWindow(iArr);
                    v.d("MicroMsg.SnsTimeLineUI", "this is the pos for view %d x %d y %d", new Object[]{Integer.valueOf(r4), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                    i = iArr[1];
                }
            }
            i2 = BackwardSupportUtil.b.a(this, 50.0f);
            if (!(ad.aSn() || this.jUz.aSu() == null)) {
                af aSJ = ad.aSJ();
                String str4 = this.jUB.jWl.fHQ;
                String str5 = this.jUB.jWl.jJv;
                long j2 = this.jUz.aSu().jne;
                int i3 = i - i2;
                aSJ.jJu = be.Nj();
                aSJ.fHQ = str4;
                aSJ.jJv = str5;
                aSJ.jne = j2;
                aSJ.position = firstVisiblePosition;
                aSJ.jJw = i3;
                v.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(aSJ.jJu), str4, str5, Long.valueOf(j2), Integer.valueOf(firstVisiblePosition), Integer.valueOf(aSJ.jJw)});
            }
            v.d("MicroMsg.SnsTimeLineUI", "top h %d", new Object[]{Integer.valueOf(i - i2)});
            com.tencent.mm.sdk.c.a.nhr.f(this.jUB.jWk.dHB);
            if (ad.aSn()) {
                v.e("MicroMsg.SnsTimeLineBaseAdapter", "is invalid to getSnsInfoStorage");
            } else {
                ad.aSB();
            }
            as asVar = this.jUB.jWk;
            if (asVar.jMK != null) {
                asVar.jMK.aXH = null;
            }
            com.tencent.mm.sdk.c.a.nhr.f(this.jUB.jWk.dHB);
            this.jUB.jWk.aXz();
        }
        aw.clean();
        com.tencent.mm.sdk.c.a.nhr.f(this.jUU);
        if (ak.uz()) {
            ad.aSB().jjf.clear();
        }
        if (this.jUA != null) {
            this.jUA.clean();
        }
        this.jUB = null;
        this.jUG = null;
        au.aXX();
        com.tencent.mm.plugin.sns.abtest.c.aQR();
        ak.vy().b(291, ad.aSv());
        com.tencent.mm.plugin.sns.abtest.a.clean();
        this.jUS.onDestroy();
        super.onDestroy();
        com.tencent.mm.kiss.widget.textview.c.clL.vK();
    }

    public void onResume() {
        int count;
        if (com.tencent.mm.sdk.b.b.bsI() && com.tencent.mm.sdk.b.b.bsG()) {
            jVu.add(this);
        }
        ay.onResume();
        super.onResume();
        this.evC = be.Nh();
        if (this.jVt) {
            this.jVt = false;
            count = this.jUB.getCount();
            if (getIntent().getBooleanExtra("is_from_find_more", false)) {
                com.tencent.mm.modelsns.a c = com.tencent.mm.modelsns.a.c(getIntent(), "enter_log");
                if (c != null) {
                    if (count > 0) {
                        String str;
                        k qK = this.jUB.qK(0);
                        if (qK == null) {
                            str = "0";
                        } else {
                            str = i.cE(qK.field_snsId);
                        }
                        c.kj(str);
                        if (qK == null) {
                            str = "0";
                        } else {
                            str = qK.field_createTime;
                        }
                        c.kj(str);
                        c.kj(String.valueOf(count));
                    } else {
                        c.kj("");
                        c.kj("");
                        c.kj("0");
                    }
                    c.JF();
                }
            }
        }
        if (this.mScreenWidth == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            com.tencent.mm.plugin.sns.i.a aVar = this.jUM;
            count = this.mScreenWidth;
            int i = this.mScreenHeight;
            aVar.mScreenWidth = count;
            aVar.mScreenHeight = i;
        }
        if (ad.aSn()) {
            finish();
        }
        ad.aSB().jjh = this.jUB.jWk;
        vF().u(com.tencent.mm.plugin.sns.k.c.b.class);
        r.a((ae) this);
        if (this.jUF) {
            this.jUD.post(new Runnable(this) {
                final /* synthetic */ SnsTimeLineUI jVD;

                {
                    this.jVD = r1;
                }

                public final void run() {
                    v.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + this.jVD.jUF);
                    if (this.jVD.jUF) {
                        this.jVD.jUF = false;
                        this.jVD.jUH.aXU();
                    }
                }
            });
        } else {
            a aVar2 = this.jUH;
            if (aVar2.jVD.jUD.getVisibility() == 0) {
                aVar2.init();
                LayoutParams layoutParams = (LayoutParams) aVar2.jVD.jUD.getLayoutParams();
                layoutParams.y = (int) aVar2.jVS;
                aVar2.jVD.jUD.setLayoutParams(layoutParams);
                aVar2.jVD.jUD.invalidate();
            }
        }
        pn pnVar = new pn();
        pnVar.bqP.bqQ = this.jUS.gMx.getFirstVisiblePosition();
        pnVar.bqP.bqR = this.jUS.gMx.getLastVisiblePosition();
        pnVar.bqP.bqS = this.jUS.gMx.getHeaderViewsCount();
        pnVar.bqP.type = 0;
        com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        if (!(this.jUG == null || this.jUG.jEn == null)) {
            this.jUG.jEn.onResume();
        }
        if (this.jUB != null) {
            as asVar = this.jUB.jWk;
            com.tencent.mm.sdk.c.a.nhr.e(asVar.jNb);
            com.tencent.mm.sdk.c.a.nhr.e(asVar.jNa);
            com.tencent.mm.sdk.c.a.nhr.e(asVar.jNc);
        }
        if (!(this.jUG == null || this.jUG.jEo == null)) {
            this.jUG.jEo.jmQ.fU(true);
            this.jUG.jEo.jmQ.fV(false);
            this.jUG.jEo.jmQ.fW(false);
            this.jUG.jEo.jmQ.fX(false);
            this.jUG.jEo.jmQ.gh(false);
            com.tencent.mm.plugin.sns.i.b bVar = this.jUG.jEo.jmQ;
            bVar.gf(false);
            bVar.gg(false);
            bVar.fZ(false);
            bVar.ge(false);
            bVar.gc(false);
            bVar.ge(false);
            bVar.gi(false);
            bVar.gd(false);
            bVar.ge(false);
            bVar.ga(false);
            bVar.gb(false);
        }
        com.tencent.mm.plugin.sns.e.g aSB = ad.aSB();
        aSB.jji = 0;
        aSB.jjj = 0;
        com.tencent.mm.sdk.c.a.nhr.e(this.jUX);
        com.tencent.mm.sdk.c.a.nhr.e(this.jUW);
    }

    private void aXE() {
        bAc();
        setRequestedOrientation(-1);
        aXH();
        this.jVz.setVisible(true);
        vD(2131235562);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        this.jUD.clearAnimation();
        r.b(this);
        ad.aSB().jjh = null;
        pn pnVar = new pn();
        pnVar.bqP.type = 1;
        com.tencent.mm.sdk.c.a.nhr.z(pnVar);
        if (this.jUA != null && this.jUA.aWn()) {
            aXE();
        }
        if (this.jUB != null) {
            as asVar = this.jUB.jWk;
            com.tencent.mm.sdk.c.a.nhr.f(asVar.jNb);
            com.tencent.mm.sdk.c.a.nhr.f(asVar.jNa);
            com.tencent.mm.sdk.c.a.nhr.f(asVar.jNc);
        }
        if (!(this.jUG == null || this.jUG.jEn == null)) {
            this.jUG.jEn.evC = be.Nj();
        }
        if (!(this.jUG == null || this.jUG.jEo == null)) {
            this.jUG.jEo.jmQ.fU(false);
        }
        com.tencent.mm.modelstat.d.d("SnsTimeLineUI", this.evC, be.Nh());
        ay.onPause();
        super.onPause();
        com.tencent.mm.sdk.c.a.nhr.f(this.jUX);
        com.tencent.mm.sdk.c.a.nhr.f(this.jUW);
    }

    protected final int getLayoutId() {
        return 2130904514;
    }

    protected final void NI() {
        this.jUS.jrk.setDrawingCacheEnabled(false);
        this.jUG.joW = (FrameLayout) findViewById(2131759318);
        vD(2131235562);
        int i = ad.aSJ().position;
        AdListView adListView = (AdListView) this.jUS.aXL();
        adListView.jCY = this.jMU;
        adListView.jCZ = this.jUN;
        adListView.jDa = this.jUO;
        this.jUO.a(ad.aSv());
        v.i("MicroMsg.SnsTimeLineUI", "oncreate firstPosition %d isToResume: " + this.jEu, new Object[]{Integer.valueOf(i)});
        this.jUD = (QFadeImageView) findViewById(2131759503);
        this.jUD.setImageResource(2131165587);
        this.jUH = new a(this, this.jUS.aXL());
        this.jUH.setInterpolator(new LinearInterpolator());
        this.jUH.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void onAnimationStart(Animation animation) {
                v.i("MicroMsg.SnsTimeLineUI", "refreshAnim start");
            }

            public final void onAnimationRepeat(Animation animation) {
                v.i("MicroMsg.SnsTimeLineUI", "refreshAnim repeat");
            }

            public final void onAnimationEnd(Animation animation) {
                v.i("MicroMsg.SnsTimeLineUI", "refreshAnim end");
            }
        });
        this.jUB = new au(this, this.jUS.aXL(), this.jUG.jEz, this.jUG, this.jUP);
        this.jUG.jEz.kbU = new com.tencent.mm.plugin.sns.ui.as.a(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final boolean aXD() {
                this.jVD.vF().u(com.tencent.mm.plugin.sns.k.c.b.class);
                return false;
            }
        };
        this.jUG.jpB = this.jUB.jWk;
        this.jUB.jWl.pfX = new com.tencent.mm.vending.a.b.a(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void aXR() {
                f.oR(14);
            }

            public final void aXS() {
                f.oS(14);
            }
        };
        this.jUI = (TestTimeForSns) this.jUG.joW;
        this.jUI.setListener(new com.tencent.mm.plugin.sns.ui.TestTimeForSns.a(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void oo() {
                v.i("MicroMsg.SnsTimeLineUI", "sns has drawed");
                this.jVD.jUI.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass26 jVM;

                    {
                        this.jVM = r1;
                    }

                    public final void run() {
                        if (this.jVM.jVD.jUB == null || this.jVM.jVD.jUI == null) {
                            v.i("MicroMsg.SnsTimeLineUI", "onViewDrawed is error");
                            return;
                        }
                        this.jVM.jVD.jUI.setListener(null);
                        this.jVM.jVD.jEu = this.jVM.jVD.jUE;
                        if (this.jVM.jVD.jUK) {
                            v.w("MicroMsg.SnsTimeLineUI", "too fast that it finish");
                            return;
                        }
                        if (this.jVM.jVD.jEu) {
                            ad.aSu().u(ad.aSJ().jne, -1);
                        }
                        if (!this.jVM.jVD.jEu) {
                            this.jVM.jVD.jUy.kcp.b(this.jVM.jVD.dRA, this.jVM.jVD.jUQ, this.jVM.jVD.jGc, this.jVM.jVD.jUR);
                        }
                        this.jVM.jVD.jEu = false;
                    }
                });
            }
        });
        this.jUS.gMx.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    this.jVD.aVG();
                    if (this.jVD.jUS.gMx != null && this.jVD.jUS.gMx.getFirstVisiblePosition() == 0) {
                        v.d("MicroMsg.SnsTimeLineUI", "refreshIv onTouch set refreshIv visible");
                        this.jVD.jUD.setVisibility(0);
                    }
                    this.jVD.jUH.aXV();
                }
                if (motionEvent.getAction() == 0) {
                    if (this.jVD.jUS.gMx != null && this.jVD.jUS.gMx.getFirstVisiblePosition() == 0) {
                        this.jVD.jUD.setVisibility(0);
                    }
                    this.jVD.jUG.aVu();
                    this.jVD.jUG.jEq.aYo();
                }
                if (this.jVD.jMU != null) {
                    this.jVD.jMU.aQU();
                }
                return false;
            }
        });
        this.jUS.gMx.post(new Runnable(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void run() {
                if (this.jVD.jUG != null) {
                    this.jVD.jUG.jEq.jMD = this.jVD.jUS.gMx.getBottom();
                    this.jVD.jUG.jEq.jZo = this.jVD.jUS.hkk.getTop();
                    this.jVD.jUH.jVW = this.jVD.jUS.jrk.getTop();
                }
            }
        });
        this.jUS.hkk.nXn = new MMPullDownView.f(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void ac(float f) {
                SnsTimeLineUI.B(this.jVD);
                if (this.jVD.jUS.jrk.getTop() >= this.jVD.jUH.jVW || f > 0.0f) {
                    a y = this.jVD.jUH;
                    if (y.gMx != null) {
                        if (y.gMx.getFirstVisiblePosition() == 0) {
                            y.jVD.jUD.setVisibility(0);
                        } else {
                            y.jVD.jUD.setVisibility(8);
                        }
                    }
                    if (y.jVD.jUD.getVisibility() == 0) {
                        y.jVD.jUD.clearAnimation();
                        y.init();
                        y.jVT -= f / 2.0f;
                        float f2 = y.jVT;
                        if (f2 < y.jVS) {
                            f2 = y.jVS;
                            y.jVT = y.jVS;
                        }
                        float f3 = f2 > y.jVR ? y.jVR : f2;
                        f2 = f3 == y.jVR ? f * 2.0f : 5.0f * f;
                        y.jVD.jUD.a(com.tencent.mm.ui.widget.QImageView.a.ped);
                        y.jVD.jUD.mMatrix.postRotate(f2, y.jVP, y.jVQ);
                        y.jVD.jUD.setImageResource(2131165587);
                        LayoutParams layoutParams = (LayoutParams) y.jVD.jUD.getLayoutParams();
                        layoutParams.y = (int) f3;
                        y.jVD.jUD.setLayoutParams(layoutParams);
                        y.jVD.jUD.invalidate();
                    }
                }
                this.jVD.jUG.aVu();
                this.jVD.aVG();
                this.jVD.jUG.jEq.aYo();
            }

            public final void aXT() {
                this.jVD.jUH.aXV();
            }
        };
        this.jUG.jEp = (SnsCommentFooter) findViewById(2131759323);
        this.jUG.jEp.post(new Runnable(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void run() {
                j.f(this.jVD);
            }
        });
        this.jUG.jEq = new bf(this.jUS.gMx, this.jUG.jEp);
        this.jUC = (LinearLayout) this.jUS.jrk.findViewById(2131759366);
        this.jUC.findViewById(2131759367).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void onClick(View view) {
                if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                    this.jVD.jUG.jEo.jmQ.fX(true);
                }
                com.tencent.mm.plugin.sns.k.c.b bVar = (com.tencent.mm.plugin.sns.k.c.b) this.jVD.vF().t(com.tencent.mm.plugin.sns.k.c.b.class);
                com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(725);
                gh.gk(bVar.kct);
                gh.JF();
                Intent intent = new Intent();
                intent.setClass(this.jVD, SnsMsgUI.class);
                this.jVD.startActivityForResult(intent, 13);
            }
        });
        SnsHeader snsHeader = this.jUS.jrk;
        OnClickListener anonymousClass32 = new OnClickListener(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.jVD, SnsUserUI.class);
                Intent e = ad.aSu().e(intent, this.jVD.jUP);
                if (e == null) {
                    this.jVD.finish();
                    return;
                }
                ak.yW();
                int a = be.a((Integer) com.tencent.mm.model.c.vf().get(68388, null), 0);
                ak.yW();
                com.tencent.mm.model.c.vf().set(68388, Integer.valueOf(a + 1));
                this.jVD.startActivity(e);
                if ((e.getFlags() & 67108864) != 0) {
                    this.jVD.finish();
                }
            }
        };
        if (!(snsHeader.jOu == null || snsHeader.jOu.dtz == null)) {
            snsHeader.jOu.dtz.setOnClickListener(anonymousClass32);
        }
        this.jUG.jEr = new al(this);
        aXH();
    }

    public final void aRG() {
        Object obj = 1;
        super.aRG();
        com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void run() {
                this.jVD.aVG();
            }
        });
        if (this.nDR.nEB == 2 && this.jUG != null && this.jUG.jEp != null) {
            if (this.jUG.jEp.state != 1) {
                obj = null;
            }
            if (obj == null) {
                v.i("MicroMsg.SnsTimeLineUI", "onKeyBoardStateChange find");
            }
        }
    }

    private void aXF() {
        P(new Runnable(this) {
            final /* synthetic */ SnsTimeLineUI jVD;

            {
                this.jVD = r1;
            }

            public final void run() {
                SnsTimeLineUI.D(this.jVD);
            }
        });
    }

    public final boolean aXG() {
        if (this.jUA == null) {
            return super.aXG();
        }
        return !this.jUA.jJG;
    }

    private void aXH() {
        aXF();
        a(this.jVv, 2130837595);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean onCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        this.jVz = menu.add(0, 0, 0, 2131235353);
        if (this.jVw == null) {
            int dimensionPixelSize;
            int height = cU().cV().getHeight();
            if (height == 0) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(2131493014) : getResources().getDimensionPixelSize(2131493015);
            } else {
                dimensionPixelSize = height;
            }
            int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this, 56);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(fromDPToPix, dimensionPixelSize);
            this.jVw = View.inflate(this, 2130904504, null);
            this.jVx = (ImageView) this.jVw.findViewById(2131755225);
            this.jVy = this.jVw.findViewById(2131755290);
            this.jVw.setLayoutParams(layoutParams);
            this.jVw.setBackgroundResource(2130837603);
            this.jVw.setMinimumHeight(dimensionPixelSize);
            this.jVw.setMinimumWidth(fromDPToPix);
            this.jVx.setImageResource(2131165361);
            this.jVw.setContentDescription(getString(2131235683));
            this.jVw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsTimeLineUI jVD;

                {
                    this.jVD = r1;
                }

                public final void onClick(View view) {
                    SnsTimeLineUI.G(this.jVD);
                }
            });
            this.jVw.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ SnsTimeLineUI jVD;

                {
                    this.jVD = r1;
                }

                public final boolean onLongClick(View view) {
                    if (!(this.jVD.jUG == null || this.jVD.jUG.jEo == null)) {
                        this.jVD.jUG.jEo.jmQ.fY(true);
                    }
                    ak.yW();
                    if (((Boolean) com.tencent.mm.model.c.vf().get(7490, Boolean.valueOf(true))).booleanValue()) {
                        this.jVD.startActivity(new Intent().setClass(this.jVD, SnsLongMsgUI.class));
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(7490, Boolean.valueOf(false));
                    } else {
                        Intent intent = new Intent();
                        intent.setClass(this.jVD, SnsUploadUI.class);
                        intent.putExtra("KSnsPostManu", true);
                        intent.putExtra("KTouchCameraTime", be.Nh());
                        intent.putExtra("sns_comment_type", 1);
                        intent.putExtra("Ksnsupload_type", 9);
                        com.tencent.mm.modelsns.a gh = com.tencent.mm.modelsns.a.gh(705);
                        gh.gl(gh.cZD).kk(System.currentTimeMillis()).gl(gh.cZF).gl(1);
                        gh = com.tencent.mm.plugin.sns.i.e.jtT.b(gh);
                        gh.JF();
                        gh.b(intent, "intent_key_StatisticsOplog");
                        this.jVD.startActivityForResult(intent, 9);
                    }
                    return true;
                }
            });
            this.jVw.post(new Runnable(this) {
                final /* synthetic */ SnsTimeLineUI jVD;

                {
                    this.jVD = r1;
                }

                public final void run() {
                    this.jVD.aR();
                }

                public final String toString() {
                    return super.toString() + "|supportInvalidateOptionsMenu";
                }
            });
        }
        android.support.v4.view.l.a(this.jVz, this.jVw);
        android.support.v4.view.l.a(this.jVz, 2);
        this.jVz.setVisible(true);
        aXI();
        return onCreateOptionsMenu;
    }

    private void aXI() {
        if (this.jVy != null) {
            this.jVy.setVisibility(8);
        }
    }

    private void aXJ() {
        if (!com.tencent.mm.ah.a.aT(this)) {
            v.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")), be.bur(), this});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 18, "", "")) {
                v.i("MicroMsg.SnsTimeLineUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")), be.bur(), this});
                if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 18, "", "")) {
                    setRequestedOrientation(1);
                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                        final /* synthetic */ SnsTimeLineUI jVD;

                        {
                            this.jVD = r1;
                        }

                        public final void run() {
                            if (this.jVD.jUA == null) {
                                this.jVD.jUA = new ag((RelativeLayout) this.jVD.findViewById(2131755452), this.jVD.jUG.joW, this.jVD, new com.tencent.mm.plugin.sns.ui.ag.a(this) {
                                    final /* synthetic */ AnonymousClass42 pRn;

                                    {
                                        this.pRn = r1;
                                    }

                                    public final void amF() {
                                        this.pRn.jVD.aXE();
                                    }
                                });
                            }
                            SnsTimeLineUI.I(this.jVD);
                            this.jVD.jUA.aWm();
                        }
                    });
                }
            }
        }
    }

    public final boolean cj(View view) {
        this.jUG.jEx.aTn();
        be beVar = this.jUG.jEw;
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.a.a.c) {
            com.tencent.mm.plugin.sns.ui.a.a.c cVar = (com.tencent.mm.plugin.sns.ui.a.a.c) view.getTag();
            String str = cVar.bap;
            if (beVar.jZj != null) {
                if (beVar.jZj.getTag() instanceof a) {
                    a aVar = (a) beVar.jZj.getTag();
                    if (aVar.jpq.equals(str)) {
                        beVar.cl(aVar.jby);
                        return true;
                    }
                    beVar.aVG();
                }
                beVar.jZj = null;
            }
            beVar.jZj = new SnsCommentShowAbLayout(beVar.mContext);
            com.tencent.mm.sdk.platformtools.k.bw(beVar.jZj);
            beVar.jZj.setId(2131755095);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            beVar.joW.addView(beVar.jZj);
            int a = BackwardSupportUtil.b.a(beVar.mContext, 192.0f);
            int a2 = BackwardSupportUtil.b.a(beVar.mContext, 76.0f);
            BackwardSupportUtil.b.a(beVar.mContext, 20.0f);
            int a3 = BackwardSupportUtil.b.a(beVar.mContext, 12.0f);
            int a4 = BackwardSupportUtil.b.a(beVar.mContext, 40.0f);
            View inflate = com.tencent.mm.ui.q.em(beVar.mContext).inflate(2130904442, null);
            Rect rect = new Rect();
            int[] iArr = new int[2];
            int da = com.tencent.mm.pluginsdk.e.da(beVar.mContext);
            view.getLocationInWindow(iArr);
            beVar.jcr = com.tencent.mm.pluginsdk.e.db(beVar.mContext);
            v.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + iArr[0] + "  " + iArr[1] + " height: " + da + " height_hardcode:" + a2 + " statusBarHeight: " + beVar.jcr);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2, (iArr[0] - a) + a3, ((iArr[1] - beVar.jcr) - da) - ((a4 / 2) - (view.getMeasuredHeight() / 2)));
            beVar.jZj.setTag(new a(beVar, str, inflate));
            beVar.jZj.addView(inflate, layoutParams2);
            if (cVar.eKg == 11) {
                inflate.findViewById(2131755294).setBackgroundResource(2130838272);
            }
            inflate.setVisibility(8);
            new ac().post(new com.tencent.mm.plugin.sns.ui.be.AnonymousClass1(beVar, view, inflate));
            return true;
        }
        v.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
        return false;
    }

    public final boolean aVG() {
        if (this.jUG == null || this.jUG.jEw == null) {
            return false;
        }
        if (!(this.jUG == null || this.jUG.jEx == null)) {
            this.jUG.jEx.aTn();
        }
        com.tencent.mm.plugin.sns.abtest.a.aQK();
        return this.jUG.jEw.aVG();
    }

    public final void yI() {
        vF().u(com.tencent.mm.plugin.sns.k.c.b.class);
    }

    public final void yJ() {
    }

    public final void yK() {
        if (!this.jVC) {
            v.v("MicroMsg.SnsTimeLineUI", "notifyHbReward imp");
            this.jVC = true;
            ad.aqz().postDelayed(new Runnable(this) {
                final /* synthetic */ SnsTimeLineUI jVD;

                {
                    this.jVD = r1;
                }

                public final void run() {
                    if (this.jVD.jUB != null) {
                        this.jVD.jUB.jWl.notifyVendingDataChange();
                    }
                    this.jVD.jVC = false;
                }
            }, 1000);
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SnsTimeLineUI", "uionSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + kVar.getType());
        if (kVar.getType() == 218) {
            p pVar = (p) kVar;
            if ((pVar.type == 1 || pVar.type == 6 || pVar.type == 4) && this.jUG.jEA != null) {
                this.jUG.jEA.dismiss();
            }
            if (pVar.type == 11) {
                if (this.jUS.dwg != null) {
                    this.jUS.dwg.dismiss();
                }
                if (this.jVx != null) {
                    this.jVx.setImageResource(2131165361);
                }
            }
        }
        if (this.jUB != null) {
            this.jUB.jWl.notifyVendingDataChange();
        }
        if (kVar.getType() == 211) {
            com.tencent.mm.plugin.sns.e.v vVar = (com.tencent.mm.plugin.sns.e.v) kVar;
            com.tencent.mm.modelsns.a gh;
            if (vVar.jjU) {
                gh = com.tencent.mm.modelsns.a.gh(727);
                gh.gk(this.jUB.getCount()).gk(vVar.Tr);
                gh.JF();
            } else {
                gh = com.tencent.mm.modelsns.a.gh(728);
                gh.gk(this.jUB.getCount()).gk(vVar.Tr).gk(0);
                gh.JF();
            }
            if (this.jUH != null) {
                this.jUF = false;
                Animation animation = this.jUH;
                v.i("MicroMsg.SnsTimeLineUI", "play end vis: %d, sumY %f MAX_Y %f", new Object[]{Integer.valueOf(animation.jVD.jUD.getVisibility()), Float.valueOf(animation.jVT), Float.valueOf(animation.jVR)});
                if (animation.jVD.jUD.getVisibility() == 0) {
                    animation.init();
                    if (animation.jVT >= animation.jVR) {
                        animation.jVD.jUD.clearAnimation();
                        animation.jVD.jUD.startAnimation(animation);
                        animation.setDuration(1200);
                        animation.jVV = false;
                    }
                }
            }
        }
    }

    protected void finalize() {
        v.d("MicroMsg.SnsTimeLineUI", "finalize");
        super.finalize();
    }

    public final void yL() {
        vF().u(com.tencent.mm.plugin.sns.k.c.b.class);
    }

    public void onBackPressed() {
        if (this.jUA == null || !this.jUA.jJG) {
            finish();
        } else if (!this.jUA.gq(false)) {
            aXE();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.v("MicroMsg.SnsTimeLineUI", "on ActivityResult, requestCode %d, resultCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 15) {
            if (this.jUG != null && this.jUG.jEz != null && this.jUG.jEz.kbv != null) {
                this.jUG.jEz.kbv.onActivityResult(i, i2, intent);
                com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                    final /* synthetic */ SnsTimeLineUI jVD;

                    {
                        this.jVD = r1;
                    }

                    public final void run() {
                        this.jVD.axg();
                    }
                }, 300);
            }
        } else if (i == 16) {
            v.i("MicroMsg.SnsTimeLineUI", "REQUEST_CODE_FOR_FULLSCREEN");
        } else {
            super.onActivityResult(i, i2, intent);
            this.jUS.onActivityResult(i, i2, intent);
            if (i == 11) {
                this.jUy.kcp.b(this.dRA, this.jUQ, this.jGc, this.jUR);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.SnsTimeLineUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    aXJ();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? 2131234160 : 2131234163;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SnsTimeLineUI jVD;

                        {
                            this.jVD = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.jVD.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ SnsTimeLineUI jVD;

                        {
                            this.jVD = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
