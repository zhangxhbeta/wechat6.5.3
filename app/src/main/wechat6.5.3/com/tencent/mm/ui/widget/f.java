package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.bi.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mmdb.FileUtils;

public final class f implements OnGlobalLayoutListener {
    public static int pbR = 0;
    public static int pbS = 1;
    public static int pbT = 2;
    private ViewTreeObserver Qt;
    private RecyclerView Zq;
    private View fhF;
    private View hy;
    private View iWo;
    public c jXn;
    public d jXo;
    private l jXp;
    private Context mContext;
    private boolean oUW = false;
    private android.support.design.widget.c pbH;
    private d pbI;
    private l pbJ;
    private LinearLayout pbK;
    private LinearLayout pbL;
    private b pbM;
    private boolean pbN = false;
    private boolean pbO = false;
    private int pbP;
    private BottomSheetBehavior pbQ;
    private int pbU = 4;
    private int pbV = (this.pbU * 3);
    private int pbW = 6;
    private int pbX;
    private boolean pbY;
    public boolean pbZ;
    public boolean pca;
    private boolean pcb = false;
    private boolean pcc = false;
    public boolean pcd = false;
    private boolean pce = false;
    private boolean pcf = false;
    private int pcg = 0;
    a pch;

    public interface a {
    }

    public class b extends android.support.v7.widget.RecyclerView.a<a> {
        OnItemClickListener Xp;
        final /* synthetic */ f pci;

        public class a extends s implements OnClickListener {
            TextView dID;
            ImageView dQZ;
            TextView gtw;
            RadioButton pcj;
            ImageView pck;
            final /* synthetic */ b pcl;

            public a(b bVar, View view) {
                this.pcl = bVar;
                super(view);
                view.setOnClickListener(this);
                this.dID = (TextView) view.findViewById(com.tencent.mm.bi.a.c.title);
                this.dQZ = (ImageView) view.findViewById(com.tencent.mm.bi.a.c.icon);
                if (bVar.pci.pbO) {
                    this.gtw = (TextView) view.findViewById(com.tencent.mm.bi.a.c.pfe);
                    this.pcj = (RadioButton) view.findViewById(com.tencent.mm.bi.a.c.pfg);
                    this.pck = (ImageView) view.findViewById(com.tencent.mm.bi.a.c.divider);
                }
            }

            public final void onClick(View view) {
                if (this.pcl.Xp != null) {
                    this.pcl.Xp.onItemClick(null, view, getPosition(), (long) getPosition());
                }
            }
        }

        public b(f fVar) {
            this.pci = fVar;
        }

        public final /* synthetic */ s a(ViewGroup viewGroup, int i) {
            View inflate = this.pci.pbX == f.pbR ? LayoutInflater.from(this.pci.mContext).inflate(com.tencent.mm.bi.a.d.pfj, viewGroup, false) : this.pci.pbX == f.pbT ? LayoutInflater.from(this.pci.mContext).inflate(com.tencent.mm.bi.a.d.pfk, viewGroup, false) : LayoutInflater.from(this.pci.mContext).inflate(com.tencent.mm.bi.a.d.pfl, viewGroup, false);
            return new a(this, inflate);
        }

        public final /* synthetic */ void a(s sVar, int i) {
            a aVar = (a) sVar;
            m mVar;
            if (i < this.pci.jXp.size()) {
                if (this.pci.pcg >= this.pci.jXp.size()) {
                    this.pci.pcg = 0;
                }
                mVar = (m) this.pci.jXp.nWF.get(i);
                aVar.dID.setText(mVar.getTitle());
                if (mVar.getIcon() != null) {
                    aVar.dQZ.setVisibility(0);
                    aVar.dQZ.setImageDrawable(mVar.getIcon());
                } else if (this.pci.pce) {
                    aVar.dQZ.setVisibility(4);
                } else {
                    aVar.dQZ.setVisibility(8);
                }
                if (this.pci.pbO) {
                    if (be.D(mVar.nWG)) {
                        aVar.gtw.setVisibility(8);
                    } else {
                        aVar.gtw.setVisibility(0);
                        aVar.gtw.setText(mVar.nWG);
                    }
                    if (mVar.mVW) {
                        aVar.pcj.setVisibility(8);
                        aVar.dID.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peL));
                        aVar.gtw.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peL));
                    } else {
                        aVar.dID.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peK));
                        aVar.gtw.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peM));
                        aVar.pcj.setVisibility(0);
                        if (this.pci.pcg == i) {
                            aVar.pcj.setChecked(true);
                        } else {
                            aVar.pcj.setChecked(false);
                        }
                    }
                    aVar.pck.setVisibility(0);
                }
            } else if (this.pci.pbJ.size() > 0 && i < this.pci.jXp.size() + this.pci.pbJ.size()) {
                mVar = (m) this.pci.pbJ.nWF.get(i - this.pci.jXp.size());
                aVar.dID.setText(mVar.getTitle());
                if (this.pci.pcg >= this.pci.jXp.size() + this.pci.pbJ.size()) {
                    this.pci.pcg = 0;
                }
                if (mVar.getIcon() != null) {
                    aVar.dQZ.setVisibility(0);
                    aVar.dQZ.setImageDrawable(mVar.getIcon());
                } else {
                    aVar.dQZ.setVisibility(8);
                }
                if (this.pci.pbO) {
                    if (be.D(mVar.nWG)) {
                        aVar.gtw.setVisibility(8);
                    } else {
                        aVar.gtw.setVisibility(0);
                        aVar.gtw.setText(mVar.nWG);
                    }
                    if (mVar.mVW) {
                        aVar.pcj.setVisibility(8);
                        aVar.dID.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peL));
                        aVar.gtw.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peL));
                    } else {
                        aVar.dID.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peK));
                        aVar.gtw.setTextColor(this.pci.mContext.getResources().getColor(com.tencent.mm.bi.a.a.peM));
                        aVar.pcj.setVisibility(0);
                        if (this.pci.pcg == i) {
                            aVar.pcj.setChecked(true);
                        } else {
                            aVar.pcj.setChecked(false);
                        }
                    }
                    aVar.pck.setVisibility(0);
                }
            } else if (this.pci.pbN) {
                aVar.dID.setText(com.tencent.mm.bi.a.f.pfo);
                aVar.dQZ.setImageResource(e.pfn);
            }
        }

        public final int getItemCount() {
            if (this.pci.pbN) {
                return (this.pci.jXp.size() + this.pci.pbJ.size()) + 1;
            }
            return this.pci.jXp.size() + this.pci.pbJ.size();
        }
    }

    public final void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hy;
            if (view == null || !view.isShown()) {
                bKi();
            } else if (isShowing() && this.oUW != azQ()) {
                bKi();
            }
        }
    }

    public f(Context context, int i, boolean z) {
        int N;
        this.pbX = i;
        this.mContext = context;
        this.pbY = z;
        this.pcf = false;
        if (this.mContext instanceof Activity) {
            ViewGroup viewGroup = (ViewGroup) ((Activity) this.mContext).getWindow().getDecorView();
            if (viewGroup.getChildCount() > 0) {
                this.hy = viewGroup.getChildAt(0);
            } else {
                this.hy = viewGroup;
            }
        }
        Context context2 = this.mContext;
        this.jXp = new l();
        this.pbJ = new l();
        this.pbH = new android.support.design.widget.c(context2);
        this.fhF = View.inflate(context2, com.tencent.mm.bi.a.d.pfi, null);
        this.pbK = (LinearLayout) this.fhF.findViewById(com.tencent.mm.bi.a.c.pfd);
        this.pbL = (LinearLayout) this.fhF.findViewById(com.tencent.mm.bi.a.c.pfb);
        this.iWo = this.fhF.findViewById(com.tencent.mm.bi.a.c.pff);
        this.Zq = (RecyclerView) this.fhF.findViewById(com.tencent.mm.bi.a.c.pfc);
        this.Zq.Ys = true;
        this.oUW = azQ();
        if (this.pbX == pbR) {
            if (this.oUW) {
                this.pbU = 7;
                this.pbV = this.pbU * 2;
                this.pbP = com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peQ) + com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.pfa);
            } else {
                this.pbP = com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peP) + com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.pfa);
            }
            if (this.pbY) {
                this.pbP += com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.pfa);
            }
        } else if (this.pbX == pbT) {
            this.pbO = true;
            N = com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peX);
            if (this.oUW) {
                this.pbW = 2;
                this.pbP = ((int) (((double) N) * 2.5d)) + com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peW);
            } else {
                this.pbW = 3;
                this.pbP = ((int) (((double) N) * 3.5d)) + com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peW);
            }
            if (this.pbY) {
                this.pbP += com.tencent.mm.bd.a.fromDPToPix(this.mContext, 88);
            }
        } else {
            N = com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peY);
            if (this.oUW) {
                this.pbW = 4;
                this.pbP = ((int) (((double) N) * 4.5d)) + com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peW);
            } else {
                this.pbW = 6;
                this.pbP = ((int) (((double) N) * 6.5d)) + com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peW);
            }
            if (this.pbY) {
                this.pbP += com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.pfa);
            }
        }
        if (this.pbY && this.iWo != null && this.pcf) {
            this.iWo.setVisibility(0);
        }
        if (this.pbX == pbR) {
            this.Zq.a(new GridLayoutManager(this.mContext, this.pbU));
            int N2 = com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.peZ);
            N = com.tencent.mm.bd.a.N(this.mContext, com.tencent.mm.bi.a.b.pfa);
            if (this.pbY) {
                N = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 0);
            }
            this.Zq.setPadding(N2, N, N2, 0);
        } else {
            this.Zq.a(new LinearLayoutManager());
        }
        this.pbM = new b(this);
        this.pbM.Xp = new OnItemClickListener(this) {
            final /* synthetic */ f pci;

            {
                this.pci = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.pci.jXp.size()) {
                    if (this.pci.jXo != null) {
                        this.pci.jXo.c(this.pci.jXp.getItem(i), i);
                    }
                } else if (this.pci.pbJ.size() > 0 && i < this.pci.jXp.size() + this.pci.pbJ.size() && this.pci.pbI != null) {
                    this.pci.pbI.c(this.pci.pbJ.getItem(i - this.pci.jXp.size()), i);
                }
                if (!this.pci.pcb) {
                    this.pci.bKi();
                }
                this.pci.pcc = true;
                this.pci.pcg = i;
                this.pci.pbM.Zi.notifyChanged();
            }
        };
        this.Zq.a(this.pbM);
        this.Zq.setOverScrollMode(1);
        this.pbH.setContentView(this.fhF);
        this.pbQ = BottomSheetBehavior.i((View) this.fhF.getParent());
        this.pbQ.g(this.pbP);
        this.pbQ.fi = new android.support.design.widget.BottomSheetBehavior.a(this) {
            final /* synthetic */ f pci;

            {
                this.pci = r1;
            }

            public final void k(int i) {
            }

            public final void d(float f) {
                if (this.pci.iWo != null && !this.pci.pcf) {
                    if (this.pci.Zq.canScrollVertically(-1) && this.pci.pbY && f != 0.0f) {
                        this.pci.iWo.setVisibility(0);
                    } else {
                        this.pci.iWo.setVisibility(4);
                    }
                }
            }
        };
        this.pbH.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ f pci;

            {
                this.pci = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.pci.pbH = null;
            }
        });
    }

    public final void dd(View view) {
        if (this.pbK != null && this.pbY) {
            this.pbK.setVisibility(0);
            this.pbK.removeAllViews();
            this.pbK.setGravity(17);
            this.pbK.addView(view, -1, -2);
        }
    }

    public final void c(CharSequence charSequence, int i) {
        if (this.pbK != null && this.pbY) {
            this.pbK.setVisibility(0);
            this.pbK.removeAllViews();
            this.pbK.setGravity(i);
            View inflate = LayoutInflater.from(this.mContext).inflate(com.tencent.mm.bi.a.d.pfm, null);
            TextView textView = (TextView) inflate.findViewById(com.tencent.mm.bi.a.c.pfh);
            textView.setText(charSequence);
            textView.setGravity(i | 80);
            this.pbK.addView(inflate, -1, -2);
        }
    }

    public final void bKh() {
        this.oUW = azQ();
        if (this.jXn != null) {
            this.jXn.a(this.jXp);
        }
        if (this.pbH != null) {
            LayoutParams layoutParams = (LayoutParams) this.fhF.getLayoutParams();
            int size = this.jXp.size();
            if (this.pbN) {
                size++;
            } else if (this.pbJ.size() > 0) {
                size += this.pbJ.size();
            }
            if (this.pbX == pbR) {
                if (this.pbM.getItemCount() > this.pbV) {
                    layoutParams.height = this.pbP;
                }
            } else if (size > this.pbW) {
                layoutParams.height = this.pbP;
            }
            if (this.oUW && this.hy != null) {
                Rect rect = new Rect();
                this.hy.getWindowVisibleDisplayFrame(rect);
                layoutParams.width = rect.right;
            }
            this.fhF.setLayoutParams(layoutParams);
            if (!(this.pbJ == null || this.pbM == null)) {
                this.pbM.Zi.notifyChanged();
            }
            if (VERSION.SDK_INT >= 21) {
                this.pbH.getWindow().addFlags(Integer.MIN_VALUE);
            }
            if (this.pbZ && VERSION.SDK_INT >= 23 && this.pbH != null) {
                this.pbH.getWindow().getDecorView().setSystemUiVisibility(9216);
                this.pbH.getWindow().setStatusBarColor(0);
            }
            if (this.pca) {
                this.pbH.getWindow().addFlags(1024);
            }
            if (this.pcd) {
                this.pbH.getWindow().setFlags(8, 8);
                this.pbH.getWindow().addFlags(131200);
                this.pbH.getWindow().getDecorView().setSystemUiVisibility(6);
            } else {
                this.pbH.getWindow().clearFlags(8);
                this.pbH.getWindow().clearFlags(131072);
                this.pbH.getWindow().clearFlags(FileUtils.S_IWUSR);
                this.pbH.getWindow().getDecorView().setSystemUiVisibility(0);
            }
            if (this.pbQ != null) {
                this.pbQ.fa = false;
            }
            if (this.pch != null) {
                this.pbH.setOnDismissListener(new OnDismissListener(this) {
                    final /* synthetic */ f pci;

                    {
                        this.pci = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                    }
                });
            }
            if (this.hy != null) {
                boolean z = this.Qt == null;
                this.Qt = this.hy.getViewTreeObserver();
                if (z) {
                    this.Qt.addOnGlobalLayoutListener(this);
                }
            }
            this.pbH.show();
        }
    }

    public final void bKi() {
        if (this.Qt != null) {
            if (!this.Qt.isAlive()) {
                this.Qt = this.hy.getViewTreeObserver();
            }
            this.Qt.removeGlobalOnLayoutListener(this);
            this.Qt = null;
        }
        if (this.pbH != null) {
            if (this.pbQ != null) {
                this.pbQ.fa = true;
            }
            this.pbH.dismiss();
        }
    }

    public final boolean isShowing() {
        if (this.pbH == null || !this.pbH.isShowing()) {
            return false;
        }
        return true;
    }

    private boolean azQ() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return true;
        }
        return false;
    }
}
