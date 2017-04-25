package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.nn;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.e;
import com.tencent.mm.ui.tools.g;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    private static int con = 0;
    private static int coo = 0;
    private Context context;
    List<com.tencent.mm.plugin.sns.g.b> cwd;
    private g eIY;
    private ac handler = new ac();
    boolean jMd = false;
    b jOI;
    Gallery jOJ;
    private boolean jOK = true;
    HashMap<Integer, Integer> jOL = new HashMap();
    HashMap<Integer, Long> jOM = new HashMap();
    HashMap<Integer, Long> jON = new HashMap();
    boolean jOO = false;
    boolean jOP = false;
    boolean jOQ = false;
    boolean jOR = false;
    boolean jOS = false;
    private boolean jOT = true;
    private boolean jOU = true;
    private float jOV = 1.0f;
    MMPageControlView jOW;
    Runnable jOX = null;
    private String jOY = "";
    private int jOZ = -1;
    int jPa = -1;
    private boolean jPb = false;
    long jPc = 0;
    private HashSet<String> jPd = new HashSet();
    private Map<String, Boolean> jPe;
    private int jPf = 0;
    private int jPg = 0;
    private boolean jPh = false;
    c jPi;
    private HashMap<String, k> jPj = new HashMap();
    int jPk = -1;
    HashSet<String> jPl = new HashSet();
    public int jPm = 0;
    public int jPn = 0;
    private HashMap<String, a> jPo = new HashMap();
    boolean jdE = false;
    ak jdP = ak.nvx;
    public String username;

    class a {
        final /* synthetic */ SnsInfoFlip jPp;
        int jPr = -1;
        long jPs = -1;
        long jPt = -1;
        String jPu;
        long jnE = -1;
        int jnF;
        int networkType;

        a(SnsInfoFlip snsInfoFlip) {
            this.jPp = snsInfoFlip;
        }
    }

    class b extends BaseAdapter {
        private Context context;
        private String cvi = "";
        private int jDn = 0;
        final /* synthetic */ SnsInfoFlip jPp;
        private boolean jPv = false;
        private boolean jPw = true;
        Map<String, WeakReference<View>> jPx = new HashMap();
        private String jPy;

        public b(SnsInfoFlip snsInfoFlip, Context context) {
            this.jPp = snsInfoFlip;
            this.context = context;
            this.jPv = f.aZy();
            this.jDn = snsInfoFlip.cwd.size();
            com.tencent.mm.modelcontrol.c.Eg();
            this.jPw = com.tencent.mm.modelcontrol.c.Ei();
        }

        public final int getCount() {
            return this.jPp.cwd == null ? 0 : this.jPp.cwd.size();
        }

        private void qY(int i) {
            aib com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i)).boL;
            ak a = ak.a(this.jPp.jdP, ((com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i)).cLB);
            if (com_tencent_mm_protocal_c_aib.efm == 2) {
                ad.aSB();
                boolean a2 = com.tencent.mm.plugin.sns.e.g.a(com_tencent_mm_protocal_c_aib, a);
                if (this.jPp.jMd && !a2) {
                    SnsInfoFlip.a(this.jPp, com_tencent_mm_protocal_c_aib.gID);
                }
            }
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i)).boL.efm == 6) {
                return 0;
            }
            return 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (((com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i)).boL.efm == 6) {
                String str = "MicroMsg.SnsInfoFlip";
                String str2 = "fill view online sight %d convert view is null %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(view == null);
                v.d(str, str2, objArr);
                com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i);
                if (bVar == null) {
                    v.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                    return view;
                }
                str2 = bVar.jqo;
                if (be.kS(str2)) {
                    v.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                    return view;
                }
                View onlineVideoView;
                WeakReference weakReference = (WeakReference) this.jPx.get(str2);
                if (weakReference == null || weakReference.get() == null) {
                    onlineVideoView = new OnlineVideoView(this.context);
                    this.jPx.put(str2, new WeakReference(onlineVideoView));
                } else {
                    onlineVideoView = (OnlineVideoView) weakReference.get();
                }
                if (be.dC(str2, this.jPy)) {
                    qZ(i);
                }
                v.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), bVar.jqo});
                return onlineVideoView;
            }
            d dVar;
            aib com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i)).boL;
            v.d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.jDn + " " + com_tencent_mm_protocal_c_aib.gID);
            if (i != this.jPp.jOZ && (this.jPp.jOJ instanceof MMGestureGallery)) {
                ((MMGestureGallery) this.jPp.jOJ).oTp = false;
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, 2130904452, null);
                dVar2.jPB = view.findViewById(2131759359);
                dVar2.gtf = (ProgressBar) view.findViewById(2131757495);
                dVar2.gXF = (TextView) view.findViewById(2131759361);
                dVar2.jPC = (FrameLayout) view.findViewById(2131759360);
                dVar2.bgv = (ImageView) view.findViewById(2131755052);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.position = i;
            ak a = ak.a(this.jPp.jdP, ((com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i)).cLB);
            view.setLayoutParams(new LayoutParams(-1, -1));
            dVar.gtf.setVisibility(8);
            dVar.gXF.setVisibility(8);
            dVar.jPC.setVisibility(0);
            Object obj = (be.kS(this.jPp.jOY) || !this.jPp.jOY.equals(com_tencent_mm_protocal_c_aib.gID)) ? null : 1;
            Bitmap a2 = ad.aSB().a(com_tencent_mm_protocal_c_aib, dVar.bgv, this.context.hashCode(), obj == null, a);
            if (a2 == null && this.jPp.jMd) {
                SnsInfoFlip.a(this.jPp, com_tencent_mm_protocal_c_aib.gID);
            }
            ViewGroup.LayoutParams layoutParams = dVar.bgv.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            dVar.bgv.setLayoutParams(layoutParams);
            int a3;
            int a4;
            if (a2 == null && com_tencent_mm_protocal_c_aib.gID != null && !com_tencent_mm_protocal_c_aib.gID.startsWith("pre_temp_extend_pic")) {
                ViewGroup.LayoutParams layoutParams2 = dVar.bgv.getLayoutParams();
                if (this.jPp.jPb) {
                    a3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 73.0f);
                    layoutParams2.height = a3;
                    layoutParams2.width = a3;
                    dVar.bgv.setLayoutParams(layoutParams);
                    dVar.gtf.setVisibility(0);
                    dVar.bgv.setVisibility(0);
                    ad.aSB().ca(dVar.bgv);
                    ad.aSB().b(com_tencent_mm_protocal_c_aib, dVar.bgv, 2130837719, this.context.hashCode(), a);
                } else {
                    a4 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 160.0f);
                    int a5 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 200.0f);
                    int a6 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 44.0f);
                    com.tencent.mm.plugin.sns.e.g aSB = ad.aSB();
                    String ab = i.ab(1, com_tencent_mm_protocal_c_aib.gID);
                    String str3 = com_tencent_mm_protocal_c_aib.gID;
                    n Ai = aSB.Ai(ab);
                    if (!i.b(Ai)) {
                        Ai = null;
                    }
                    layoutParams2.height = a4;
                    layoutParams2.width = a4;
                    if (Ai != null) {
                        double d;
                        double width = (double) Ai.bitmap.getWidth();
                        double height = (double) Ai.bitmap.getHeight();
                        if (width <= 0.0d || height <= 0.0d) {
                            width = (double) a4;
                            d = (double) a4;
                        } else {
                            d = Math.min(((double) a5) / width, ((double) a5) / height);
                            width *= d;
                            d *= height;
                            if (width < ((double) a6)) {
                                height = (1.0d * ((double) a6)) / width;
                                width *= height;
                                d *= height;
                            }
                            if (d < ((double) a6)) {
                                double d2 = (((double) a6) * 1.0d) / d;
                                width *= d2;
                                d *= d2;
                            }
                            if (width > ((double) a5)) {
                                width = (double) a5;
                            }
                            if (d > ((double) a5)) {
                                d = (double) a5;
                            }
                        }
                        layoutParams2.height = (int) d;
                        layoutParams2.width = (int) width;
                    }
                    dVar.bgv.setLayoutParams(layoutParams);
                    dVar.gtf.setVisibility(0);
                    dVar.bgv.setVisibility(0);
                    ad.aSB().ca(dVar.bgv);
                    ad.aSB().c(com_tencent_mm_protocal_c_aib, dVar.bgv, 2130837719, this.context.hashCode(), a);
                }
                SnsInfoFlip.coo = layoutParams2.width;
                SnsInfoFlip.con = layoutParams2.height;
                if (obj != null) {
                    dVar.gtf.setVisibility(8);
                }
            } else if (this.jPv) {
                dVar.gtf.setVisibility(8);
                if (a2 != null) {
                    if (this.jPp.jPh) {
                        return view;
                    }
                    v.i("MicroMsg.SnsInfoFlip", "update view ");
                    MultiTouchImageView multiTouchImageView = new MultiTouchImageView(this.context, a2.getWidth(), a2.getHeight());
                    multiTouchImageView.jOS = this.jPp.jOS;
                    multiTouchImageView.setLayoutParams(new LayoutParams(-1, -1));
                    ad.aSB().a(com_tencent_mm_protocal_c_aib, (View) multiTouchImageView, this.context.hashCode(), a);
                    multiTouchImageView.setImageBitmap(a2);
                    v.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{com_tencent_mm_protocal_c_aib.gID, this.jPp.jPe.get(com_tencent_mm_protocal_c_aib.gID), Integer.valueOf(multiTouchImageView.getId())});
                    if (!be.c((Boolean) this.jPp.jPe.get(com_tencent_mm_protocal_c_aib.gID))) {
                        return multiTouchImageView;
                    }
                    this.jPp.eIY = new g(this.jPp.getContext());
                    a4 = 0;
                    a3 = 0;
                    if (this.context instanceof Activity) {
                        a4 = ((Activity) this.context).getWindowManager().getDefaultDisplay().getWidth();
                        a3 = ((Activity) this.context).getWindowManager().getDefaultDisplay().getHeight();
                    }
                    this.jPp.jPf = a4 / 2;
                    this.jPp.jPg = a3 / 2;
                    int i2 = multiTouchImageView.imageWidth;
                    int i3 = multiTouchImageView.imageHeight;
                    int i4 = 0;
                    int i5;
                    if (a4 == 0 || a3 == 0) {
                        i5 = i2;
                        i2 = 0;
                        i4 = i5;
                    } else {
                        float f;
                        i2 = (int) ((((float) multiTouchImageView.imageHeight) / ((float) multiTouchImageView.imageWidth)) * ((float) a4));
                        float f2 = 1.0f;
                        if (i2 > a3) {
                            if (((double) i2) < ((double) a3) * 2.5d && !this.jPp.jPb) {
                                i4 = (int) ((((float) (i2 - a3)) / ((float) a4)) * ((float) SnsInfoFlip.coo));
                                f2 = ((float) (i2 + i4)) / ((float) a3);
                            }
                            i2 = i4;
                            f = f2;
                            i3 = a3;
                        } else {
                            i5 = i2;
                            i2 = 0;
                            f = 1.0f;
                            i3 = i5;
                        }
                        if (this.jPp.jPb) {
                            if (a4 < i3) {
                                SnsInfoFlip.con = (int) ((((float) i3) / ((float) a4)) * ((float) SnsInfoFlip.coo));
                            } else {
                                SnsInfoFlip.coo = (int) ((((float) a4) / ((float) i3)) * ((float) SnsInfoFlip.con));
                            }
                            f = 1.1f;
                        }
                        this.jPp.eIY.oSJ = f;
                        i4 = a4;
                    }
                    this.jPp.eIY.m(this.jPp.jPf - (SnsInfoFlip.coo / 2), (this.jPp.jPg - (((int) ((((float) a3) / ((float) a4)) * ((float) SnsInfoFlip.coo))) / 2)) - (i2 / 2), SnsInfoFlip.coo, SnsInfoFlip.con);
                    this.jPp.eIY.du(i4, i3);
                    this.jPp.eIY.jCL = br.CTRL_INDEX;
                    this.jPp.eIY.a(multiTouchImageView, null, new com.tencent.mm.ui.tools.g.b(this) {
                        final /* synthetic */ b jPA;

                        public final void onAnimationStart() {
                            ad.aSB().ca(dVar.bgv);
                        }

                        public final void onAnimationEnd() {
                            this.jPA.jPp.jPh = false;
                        }
                    });
                    this.jPp.jPe.put(com_tencent_mm_protocal_c_aib.gID, Boolean.valueOf(false));
                    return multiTouchImageView;
                }
            } else {
                dVar.gtf.setVisibility(8);
                ad.aSB().a(com_tencent_mm_protocal_c_aib, dVar.bgv, this.context.hashCode(), a);
                dVar.bgv.setImageBitmap(a2);
                dVar.bgv.setVisibility(0);
            }
            if (!this.jPw || !aa.bk(this.context)) {
                return view;
            }
            if (i - 1 >= 0) {
                qY(i - 1);
            }
            if (i + 1 >= this.jPp.jOI.getCount()) {
                return view;
            }
            qY(i + 1);
            return view;
        }

        public final void qZ(int i) {
            com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.jPp.cwd.get(i);
            if (bVar == null) {
                v.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
                return;
            }
            String str = bVar.jqo;
            if (be.kS(str)) {
                v.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
                return;
            }
            v.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", new Object[]{Integer.valueOf(i), str});
            WeakReference weakReference = (WeakReference) this.jPx.get(str);
            if (weakReference == null) {
                v.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
                this.jPy = str;
                return;
            }
            OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
            if (onlineVideoView == null) {
                v.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", new Object[]{str});
                this.jPy = str;
                return;
            }
            v.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str});
            this.jPy = null;
            v.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[]{Integer.valueOf(onlineVideoView.hashCode())});
            com.tencent.mm.sdk.c.a.nhr.e(onlineVideoView.jHN);
            onlineVideoView.a(bVar.boL, bVar.jqo, bVar.cLB);
            nn nnVar = new nn();
            nnVar.boG.bdn = 1;
            nnVar.boG.bde = str;
            com.tencent.mm.sdk.c.a.nhr.z(nnVar);
        }

        public final void aXc() {
            v.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", new Object[]{be.bur()});
            this.jPy = null;
            nn nnVar = new nn();
            nnVar.boG.bdn = 2;
            com.tencent.mm.sdk.c.a.nhr.z(nnVar);
        }

        public final Object getItem(int i) {
            if (i >= this.jPp.cwd.size() || i < 0) {
                return null;
            }
            return this.jPp.cwd.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final void notifyDataSetChanged() {
            this.jDn = this.jPp.cwd.size();
            v.d("MicroMsg.SnsInfoFlip", "items.size:" + this.jPp.cwd.size());
            this.jPp.invalidate();
            this.jPp.requestLayout();
            super.notifyDataSetChanged();
            if (this.jPp.cwd.size() <= 0 && this.jPp.jOX != null) {
                this.jPp.jOX.run();
            }
        }
    }

    public interface c {
        void ra(int i);
    }

    static class d {
        ImageView bgv;
        String bou = "";
        TextView gXF;
        ProgressBar gtf;
        View jPB;
        FrameLayout jPC;
        int position;

        d() {
        }
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str) {
        v.d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", new Object[]{str});
        if (!snsInfoFlip.jPo.containsKey(str)) {
            a aVar = new a(snsInfoFlip);
            aVar.jnF = snsInfoFlip.getCount();
            aVar.networkType = aWY();
            aVar.jPs = System.currentTimeMillis();
            aVar.jPu = str;
            snsInfoFlip.jPo.put(str, aVar);
            v.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        init(context);
    }

    public final boolean aVC() {
        return this.jMd;
    }

    private void init(final Context context) {
        this.jPc = System.currentTimeMillis();
        this.context = context;
        View inflate = inflate(context, 2130904455, this);
        if (f.aZy()) {
            inflate.findViewById(2131759373).setVisibility(0);
            this.jOJ = (Gallery) inflate.findViewById(2131759373);
        } else {
            inflate.findViewById(2131759372).setVisibility(0);
            this.jOJ = (Gallery) inflate.findViewById(2131759372);
        }
        if (this.jOJ instanceof MMGestureGallery) {
            this.jOJ.setSpacing(50);
            ((MMGestureGallery) this.jOJ).oTm = new MMGestureGallery.f(this) {
                final /* synthetic */ SnsInfoFlip jPp;

                public final void abF() {
                    if (context instanceof SnsBrowseUI) {
                        ((SnsBrowseUI) context).abE();
                    } else if (this.jPp.jOQ) {
                        ((MMActivity) context).finish();
                    } else {
                        this.jPp.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 jPq;

                            {
                                this.jPq = r1;
                            }

                            public final void run() {
                                if (this.jPq.jPp.jFm != null && this.jPq.jPp.jOR) {
                                    this.jPq.jPp.jFm.XJ();
                                }
                            }
                        });
                    }
                }
            };
            ((MMGestureGallery) this.jOJ).oTo = new e(this) {
                final /* synthetic */ SnsInfoFlip jPp;

                {
                    this.jPp = r1;
                }

                public final void aXb() {
                    if (this.jPp.jFm != null) {
                        this.jPp.jFm.aVF();
                    }
                }
            };
        }
        this.jOW = (MMPageControlView) findViewById(2131759374);
        this.jOW.nWL = 2130904522;
        this.jPe = new HashMap();
    }

    public final void qV(int i) {
        this.infoType = i;
    }

    public final com.tencent.mm.plugin.sns.g.b aWS() {
        if (this.jOJ == null) {
            return null;
        }
        return (com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem();
    }

    private static int b(String str, azr com_tencent_mm_protocal_c_azr) {
        Iterator it = com_tencent_mm_protocal_c_azr.mWq.mom.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((aib) it.next()).gID)) {
                return i;
            }
        }
        return 0;
    }

    private void a(aib com_tencent_mm_protocal_c_aib, int i, String str) {
        long j = 0;
        if (this.jOJ != null && (this.jOJ instanceof MMGestureGallery)) {
            float f;
            float f2;
            if (com_tencent_mm_protocal_c_aib.mHS != null) {
                f = com_tencent_mm_protocal_c_aib.mHS.lHK;
                f2 = com_tencent_mm_protocal_c_aib.mHS.mID;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            float f3;
            if (f <= 0.0f || f2 <= 0.0f) {
                Options JS = com.tencent.mm.sdk.platformtools.d.JS(com_tencent_mm_protocal_c_aib.gID.startsWith("Locall_path") ? al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.l(com_tencent_mm_protocal_c_aib) : al.cA(ad.xh(), com_tencent_mm_protocal_c_aib.gID) + i.b(com_tencent_mm_protocal_c_aib));
                if (JS != null) {
                    f3 = (float) JS.outWidth;
                    f2 = (float) JS.outHeight;
                }
            } else {
                f3 = f2;
                f2 = f;
            }
            if (f2 > 0.0f && r5 > 0.0f) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) this.jOJ;
                if (!this.jOS || ((double) r5) * 1.0d <= ((double) f2) * 2.0d) {
                    v.d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.nYU = false;
                } else {
                    v.d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.nYU = true;
                }
            }
        }
        if (this.jPi != null) {
            this.jPi.ra(i);
        }
        if (this.jOZ == -1) {
            this.jOZ = i;
        }
        this.jPa = 1;
        String str2 = com_tencent_mm_protocal_c_aib.gID;
        if (be.kS(str)) {
            this.jFm.cO((i + 1) + " / " + this.jOI.getCount(), null);
            return;
        }
        k kVar = (k) this.jPj.get(str);
        if (kVar == null) {
            kVar = ad.aSE().Bq(str);
            this.jPj.put(str, kVar);
        }
        k kVar2 = kVar;
        if (kVar2 != null) {
            String str3;
            if (com_tencent_mm_protocal_c_aib.efm == 2) {
                if (this.jOJ instanceof MMGestureGallery) {
                    ((MMGestureGallery) this.jOJ).oTp = false;
                }
            } else if (this.jOJ instanceof MMGestureGallery) {
                ((MMGestureGallery) this.jOJ).oTp = true;
            }
            if (com_tencent_mm_protocal_c_aib.efm != 6) {
                ad.aqz().post(new Runnable(this) {
                    final /* synthetic */ SnsInfoFlip jPp;

                    {
                        this.jPp = r1;
                    }

                    public final void run() {
                        this.jPp.jOI.aXc();
                    }
                });
            }
            v.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
            if (this.jPk != i) {
                this.jOL.put(Integer.valueOf(i), Integer.valueOf((this.jOL.containsKey(Integer.valueOf(i)) ? ((Integer) this.jOL.get(Integer.valueOf(i))).intValue() : 0) + 1));
                this.jOM.put(Integer.valueOf(i), Long.valueOf(be.Nj()));
                if (this.jPk >= 0) {
                    long longValue;
                    if (this.jOM.containsKey(Integer.valueOf(this.jPk))) {
                        longValue = ((Long) this.jOM.get(Integer.valueOf(this.jPk))).longValue();
                    } else {
                        longValue = 0;
                    }
                    if (longValue > 0) {
                        this.jOM.put(Integer.valueOf(this.jPk), Long.valueOf(0));
                        if (this.jON.containsKey(Integer.valueOf(this.jPk))) {
                            j = ((Long) this.jON.get(Integer.valueOf(this.jPk))).longValue();
                        }
                        longValue = be.az(longValue);
                        j += longValue;
                        this.jON.put(Integer.valueOf(this.jPk), Long.valueOf(j));
                        v.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.jPk + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                    }
                }
                if (this.jMd && this.jOI != null) {
                    com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.jOI.getItem(this.jPk);
                    if (bVar != null) {
                        str3 = bVar.boL.gID;
                        v.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", new Object[]{str3});
                        if (this.jPo.containsKey(str3)) {
                            a aVar = (a) this.jPo.get(str3);
                            aVar.networkType = aWY();
                            if (aVar.jPt != -1) {
                                aVar.jPr = 1;
                                aVar.jnE = aVar.jPt - aVar.jPs;
                                v.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", new Object[]{Long.valueOf(aVar.jnE)});
                            } else {
                                aVar.jPr = 2;
                                aVar.jPt = System.currentTimeMillis();
                                aVar.jnE = aVar.jPt - aVar.jPs;
                                v.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", new Object[]{Long.valueOf(aVar.jnE)});
                            }
                        }
                    }
                }
            }
            this.jPk = i;
            if (this.jFl != null) {
                this.jFl.BS(str);
            }
            int i2 = kVar2.field_createTime;
            azr aUp = kVar2.aUp();
            String k = aw.k(this.context, ((long) i2) * 1000);
            str3 = null;
            if (!(aUp == null || aUp.mWq == null || aUp.mWq.mom.size() <= 1)) {
                str3 = b(str2, aUp) + " / " + aUp.mWq.mom.size();
                this.jPa = b(str2, aUp);
            }
            this.jFm.cO(k, str3);
            this.jFm.aZ(str, i);
            if (this.jOI != null) {
                this.jOI.qZ(i);
            }
        }
    }

    public final void a(List<com.tencent.mm.plugin.sns.g.b> list, String str, int i, t tVar, com.tencent.mm.plugin.sns.ui.r.a aVar) {
        ad.aSz().a((com.tencent.mm.plugin.sns.e.b.b) this);
        this.cwd = list;
        this.jPb = this.cwd.size() > 1;
        ah.Au(str);
        this.jFl = tVar;
        this.jFm = aVar;
        this.jOI = new b(this, this.context);
        this.jOJ.setAdapter(this.jOI);
        if (i >= 0 && i < this.cwd.size()) {
            this.jOJ.setSelection(i);
            if (this.jOU) {
                this.jOU = false;
                aib com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.cwd.get(i)).boL;
                if (com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.mHS == null || com_tencent_mm_protocal_c_aib.mHS.lHK <= 0.0f) {
                    this.jOV = 1.0f;
                } else {
                    this.jOV = com_tencent_mm_protocal_c_aib.mHS.mID / com_tencent_mm_protocal_c_aib.mHS.lHK;
                }
            }
        }
        this.jOJ.setFadingEdgeLength(0);
        this.jOJ.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ SnsInfoFlip jPp;

            {
                this.jPp = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.jPp.jOI != null) {
                    if (this.jPp.jOO && this.jPp.jOI.getCount() > 1) {
                        this.jPp.jOW.setVisibility(0);
                        this.jPp.jOW.qw(i);
                    }
                    this.jPp.a(((com.tencent.mm.plugin.sns.g.b) this.jPp.jOI.getItem(i)).boL, i, ((com.tencent.mm.plugin.sns.g.b) this.jPp.jOI.getItem(i)).jqo);
                    if (view instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) view).bCO();
                    }
                    if ((this.jPp.jOJ instanceof MMGestureGallery) && (this.jPp.context instanceof SnsBrowseUI)) {
                        ((SnsBrowseUI) this.jPp.context).aWA();
                    }
                }
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        if (this.jOK) {
            this.jOJ.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ SnsInfoFlip jPp;

                {
                    this.jPp = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!this.jPp.jOK) {
                        return true;
                    }
                    String str = ((com.tencent.mm.plugin.sns.g.b) this.jPp.jOI.getItem(i)).jqo;
                    if (be.kS(str)) {
                        return false;
                    }
                    String str2 = ((com.tencent.mm.plugin.sns.g.b) this.jPp.jOI.getItem(i)).boL.gID;
                    this.jPp.d(al.cA(ad.xh(), str2) + i.k(((com.tencent.mm.plugin.sns.g.b) this.jPp.jOI.getItem(i)).boL), str, str2, true);
                    return true;
                }
            });
        }
        if (this.jOO && this.jOI.getCount() > 1) {
            this.jOW.setVisibility(0);
            this.jOW.dh(this.jOI.getCount(), i);
        }
    }

    public final long aVB() {
        com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem();
        String str = bVar == null ? "" : bVar.jqo;
        if (be.kS(str)) {
            return 0;
        }
        k Bq = ad.aSE().Bq(str);
        return Bq == null ? 0 : Bq.field_snsId;
    }

    public final int getPosition() {
        return this.jPa;
    }

    private void aWT() {
        if (this.jOJ.getSelectedItem() != null && this.jOI != null) {
            int selectedItemPosition = this.jOJ.getSelectedItemPosition();
            if (this.jOO && this.jOI.getCount() > 1) {
                this.jOW.setVisibility(0);
                this.jOW.qw(selectedItemPosition);
            }
            aib com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem()).boL;
            this.jPl.add(com_tencent_mm_protocal_c_aib.gID);
            String str = ((com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem()).jqo;
            String str2 = com_tencent_mm_protocal_c_aib.gID;
            if (be.kS(this.jOY) || !this.jOY.equals(str2)) {
                this.jOY = "";
            }
            a(com_tencent_mm_protocal_c_aib, selectedItemPosition, str);
        }
    }

    public final void aWU() {
        if (this.jOI != null) {
            v.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.jOI.notifyDataSetChanged();
            aWT();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.jOI != null) {
            this.jOI.aXc();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.jPh = true;
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.jPh = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void aWV() {
        v.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.jOI != null) {
            this.jOI.aXc();
            b bVar = this.jOI;
            v.i("MicroMsg.SnsInfoFlip", "adapter clear.");
            bVar.jPx.clear();
        }
        ad.aSz().b((com.tencent.mm.plugin.sns.e.b.b) this);
    }

    public final int aWW() {
        if (this.jOJ == null) {
            return -1;
        }
        this.cwd.remove(this.jOJ.getSelectedItemPosition());
        this.jOI.notifyDataSetChanged();
        aWT();
        return this.jOI.getCount();
    }

    public final int getCount() {
        if (this.jOI != null) {
            return this.jOI.getCount();
        }
        return 0;
    }

    public final aib aVD() {
        if (this.jOI != null) {
            int selectedItemPosition = this.jOJ.getSelectedItemPosition();
            if (this.cwd != null && selectedItemPosition < this.cwd.size()) {
                return ((com.tencent.mm.plugin.sns.g.b) this.cwd.get(selectedItemPosition)).boL;
            }
        }
        return null;
    }

    public final int aWX() {
        int i = 0;
        int i2 = 0;
        for (com.tencent.mm.plugin.sns.g.b bVar : this.cwd) {
            ad.aSB();
            if (FileOp.aR(com.tencent.mm.plugin.sns.e.g.C(bVar.boL))) {
                i2++;
            }
            int i3 = i + 1;
            if (i3 > 9) {
                break;
            }
            i = i3;
        }
        return i2;
    }

    public final void ai(String str, boolean z) {
        aib com_tencent_mm_protocal_c_aib;
        if (!z) {
            com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem()).boL;
            if (!(com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || !com_tencent_mm_protocal_c_aib.gID.equals(str))) {
                Toast.makeText(this.context, this.context.getString(2131235392), 0).show();
                this.jOY = str;
            }
        }
        this.jPn++;
        if (this.jMd) {
            v.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[]{str, Boolean.valueOf(z)});
            if (z && this.jPo.containsKey(str)) {
                a aVar = (a) this.jPo.get(str);
                aVar.jPt = System.currentTimeMillis();
                aVar.networkType = aWY();
                v.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.jPe.put(str, Boolean.valueOf(true));
            }
        }
        if (this.jOI != null && ((com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem()) != null) {
            com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem()).boL;
            if (com_tencent_mm_protocal_c_aib != null && com_tencent_mm_protocal_c_aib.gID != null && com_tencent_mm_protocal_c_aib.gID.equals(str)) {
                this.jOI.notifyDataSetChanged();
            }
        }
    }

    public final void aj(String str, boolean z) {
        v.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            aib com_tencent_mm_protocal_c_aib = ((com.tencent.mm.plugin.sns.g.b) this.jOJ.getSelectedItem()).boL;
            if (!(com_tencent_mm_protocal_c_aib == null || com_tencent_mm_protocal_c_aib.gID == null || !com_tencent_mm_protocal_c_aib.gID.equals(str))) {
                Toast.makeText(this.context, this.context.getString(2131235393), 0).show();
                this.jOY = str;
            }
        }
        if (this.jOI != null) {
            this.jOI.notifyDataSetChanged();
        }
    }

    private static int aWY() {
        Context context = com.tencent.mm.sdk.platformtools.aa.getContext();
        if (com.tencent.mm.sdk.platformtools.ak.is2G(context)) {
            return 1;
        }
        if (com.tencent.mm.sdk.platformtools.ak.is3G(context)) {
            return 2;
        }
        if (com.tencent.mm.sdk.platformtools.ak.is4G(context)) {
            return 3;
        }
        if (com.tencent.mm.sdk.platformtools.ak.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public final void aWZ() {
        for (a aVar : this.jPo.values()) {
            if (aVar.jPr != -1) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11601, new Object[]{Integer.valueOf(aVar.jnF), Integer.valueOf(aVar.jPr), Long.valueOf(aVar.jnE), Integer.valueOf(aVar.networkType)});
                v.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[]{Integer.valueOf(aVar.jnF), Integer.valueOf(aVar.jPr), Long.valueOf(aVar.jnE), Integer.valueOf(aVar.networkType)});
            } else if (aVar.jPs != -1) {
                if (aVar.jPt != -1) {
                    aVar.jPr = 1;
                } else {
                    aVar.jPr = 2;
                    aVar.jPt = System.currentTimeMillis();
                }
                aVar.jnE = aVar.jPt - aVar.jPs;
                com.tencent.mm.plugin.report.service.g.iuh.h(11601, new Object[]{Integer.valueOf(aVar.jnF), Integer.valueOf(aVar.jPr), Long.valueOf(aVar.jnE), Integer.valueOf(aVar.networkType)});
                v.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[]{Integer.valueOf(aVar.jnF), Integer.valueOf(aVar.jPr), Long.valueOf(aVar.jnE), Integer.valueOf(aVar.networkType)});
            }
        }
        this.jPo.clear();
    }
}
