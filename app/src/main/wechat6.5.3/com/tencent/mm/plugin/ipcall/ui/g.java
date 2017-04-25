package com.tencent.mm.plugin.ipcall.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.ipcall.a.d.j;
import com.tencent.mm.plugin.ipcall.a.e;
import com.tencent.mm.plugin.ipcall.a.e.d;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.pluginsdk.k.a.a.b.b;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.FlowLayout;
import com.tencent.mm.ui.base.PasterEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public final class g extends Dialog {
    View eEX;
    private int fPA = 2130838225;
    private int fPz = 2131689721;
    private ScrollView fzH;
    private int gLM = 0;
    private int gLN;
    private LinearLayout gLO;
    private LinearLayout gLP;
    private RelativeLayout gLQ;
    private RelativeLayout gLR;
    private RelativeLayout gLS;
    private ImageView gLT;
    private ImageView gLU;
    private ImageView gLV;
    private int gLW;
    private FrameLayout gLX;
    private FlowLayout gLY;
    private Button gLZ;
    private Button gMa;
    private PasterEditText gMb;
    private Button gMc;
    private Button gMd;
    private TextView gMe;
    private Animation gMf;
    private int gMg = 2130838222;
    private int gMh = 2131690128;
    private Context mContext;
    private ac mHandler = new ac();
    private ArrayList<a> mItemList;
    private OnClickListener mOnClickListener = new OnClickListener(this) {
        final /* synthetic */ g gMj;

        {
            this.gMj = r1;
        }

        public final void onClick(View view) {
            if (view == this.gMj.gLQ) {
                this.gMj.md(1);
            } else if (view == this.gMj.gLR) {
                this.gMj.md(2);
            } else if (view == this.gMj.gLS) {
                this.gMj.md(3);
            }
        }
    };
    private Activity pP;
    private CharSequence up;

    public static class a {
        public String gID;
        public String gIE;
        public boolean gMk;
    }

    static /* synthetic */ void a(g gVar, TextView textView) {
        a aVar = (a) textView.getTag();
        textView.setTextSize(0, gVar.getContext().getResources().getDimension(2131493451) * com.tencent.mm.bd.a.ds(gVar.getContext()));
        if (aVar.gMk) {
            textView.setBackgroundResource(gVar.gMg);
            textView.setTextColor(gVar.mContext.getResources().getColor(gVar.gMh));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        textView.setBackgroundResource(gVar.fPA);
        textView.setTextColor(gVar.mContext.getResources().getColor(gVar.fPz));
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }

    static /* synthetic */ void e(g gVar) {
        ak.vy().a(new j(gVar.gLN, gVar.gLW, gVar.mf(gVar.gLW)), 0);
        if (gVar.gLW == 3) {
            gVar.mg(2);
            return;
        }
        gVar.hide();
        gVar.mHandler.postDelayed(new Runnable(gVar) {
            final /* synthetic */ g gMj;

            {
                this.gMj = r1;
            }

            public final void run() {
                this.gMj.dismiss();
            }
        }, 1800);
        com.tencent.mm.ui.snackbar.a.f(gVar.pP, gVar.mContext.getString(2131233410));
        d.a(1, -1, gVar.gLW, gVar.me(gVar.gLW), 0, -1, -1);
    }

    public g(Activity activity, Context context, int i) {
        CharSequence format;
        super(context, 2131559263);
        setCancelable(false);
        this.mContext = context;
        this.gLN = i;
        this.pP = activity;
        this.eEX = View.inflate(this.mContext, 2130903830, null);
        this.gLO = (LinearLayout) this.eEX.findViewById(2131757612);
        this.gLP = (LinearLayout) this.eEX.findViewById(2131757624);
        this.gMf = AnimationUtils.loadAnimation(aa.getContext(), 2130968586);
        this.gMf.setDuration(200);
        this.gMf.setStartOffset(100);
        avk();
        this.gLQ = (RelativeLayout) this.eEX.findViewById(2131757613);
        this.gLR = (RelativeLayout) this.eEX.findViewById(2131757615);
        this.gLS = (RelativeLayout) this.eEX.findViewById(2131757617);
        this.gLQ.setOnClickListener(this.mOnClickListener);
        this.gLR.setOnClickListener(this.mOnClickListener);
        this.gLS.setOnClickListener(this.mOnClickListener);
        this.gLT = (ImageView) this.eEX.findViewById(2131757614);
        this.gLU = (ImageView) this.eEX.findViewById(2131757616);
        this.gLV = (ImageView) this.eEX.findViewById(2131757618);
        this.gLW = 0;
        md(this.gLW);
        this.gMc = (Button) this.eEX.findViewById(2131757627);
        this.gMd = (Button) this.eEX.findViewById(2131757628);
        this.gMe = (TextView) this.eEX.findViewById(2131757626);
        if (c.avE() != null) {
            format = String.format(this.mContext.getString(2131233431), new Object[]{r0.mCk});
        } else {
            format = null;
        }
        if (be.kS(format)) {
            this.gMe.setVisibility(4);
        } else {
            this.gMe.setVisibility(0);
            this.gMe.setText(format);
        }
        this.gMc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g gMj;

            {
                this.gMj = r1;
            }

            public final void onClick(View view) {
                this.gMj.dismiss();
                d.a(1, -1, this.gMj.gLW, this.gMj.me(this.gMj.gLW), 1, -1, 1);
            }
        });
        this.gMd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g gMj;

            {
                this.gMj = r1;
            }

            public final void onClick(View view) {
                this.gMj.dismiss();
                Intent intent = new Intent();
                intent.putExtra("IPCallShareCouponCardUI_KFrom", 2);
                intent.setClass(this.gMj.mContext, IPCallShareCouponCardUI.class);
                this.gMj.mContext.startActivity(intent);
                d.a(1, -1, this.gMj.gLW, this.gMj.me(this.gMj.gLW), 1, 1, -1);
            }
        });
        this.fzH = (ScrollView) this.eEX.findViewById(2131757611);
        final View childAt = ((ViewGroup) this.pP.findViewById(16908290)).getChildAt(0);
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
            final /* synthetic */ g gMj;

            public final void onGlobalLayout() {
                Rect rect = new Rect();
                childAt.getWindowVisibleDisplayFrame(rect);
                if (childAt.getRootView().getHeight() - (rect.bottom - rect.top) > 100) {
                    g gVar = this.gMj;
                    gVar.eEX.postDelayed(new Runnable(gVar) {
                        final /* synthetic */ g gMj;

                        {
                            this.gMj = r1;
                        }

                        public final void run() {
                            this.gMj.fzH.fullScroll(130);
                        }
                    }, 100);
                }
            }
        });
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.eEX);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        mg(0);
    }

    private void md(int i) {
        this.gLW = i;
        if (i == 0) {
            this.gLT.setVisibility(4);
            this.gLU.setVisibility(4);
            this.gLV.setVisibility(4);
            this.gMa.setEnabled(false);
            mg(0);
        } else if (i == 1) {
            this.gLT.setVisibility(0);
            this.gLU.setVisibility(4);
            this.gLV.setVisibility(4);
            this.gMa.setEnabled(true);
            mg(1);
        } else if (i == 2) {
            this.gLT.setVisibility(0);
            this.gLU.setVisibility(0);
            this.gLV.setVisibility(4);
            this.gMa.setEnabled(true);
            mg(1);
        } else if (i == 3) {
            this.gLT.setVisibility(0);
            this.gLU.setVisibility(0);
            this.gLV.setVisibility(0);
            this.gMa.setEnabled(true);
            mg(0);
        }
    }

    private void avk() {
        String cT;
        f fVar;
        this.gLX = (FrameLayout) this.eEX.findViewById(2131757619);
        this.gLY = (FlowLayout) this.eEX.findViewById(2131757621);
        this.gLZ = (Button) this.eEX.findViewById(2131757622);
        this.gMa = (Button) this.eEX.findViewById(2131757623);
        this.gMb = (PasterEditText) this.eEX.findViewById(2131756405);
        this.gLZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g gMj;

            {
                this.gMj = r1;
            }

            public final void onClick(View view) {
                this.gMj.dismiss();
                d.a(-1, 1, -1, "", 0, -1, -1);
            }
        });
        this.gMa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ g gMj;

            {
                this.gMj = r1;
            }

            public final void onClick(View view) {
                g.e(this.gMj);
            }
        });
        e auf = e.auf();
        if (auf.gEH == null) {
            v.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource try get cacheResUpdate");
            b.bnR();
            cT = com.tencent.mm.pluginsdk.k.a.a.b.cT(39, 1);
            if (be.kS(cT)) {
                v.i("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource get cacheResUpdate no filePath");
            } else {
                byte[] d = com.tencent.mm.a.e.d(cT, 0, -1);
                if (d != null) {
                    auf.at(d);
                } else {
                    v.e("MicroMsg.IPCallFeedbackConfigUpdater", "getCurrentLanugageResource file not exist");
                }
            }
        }
        if (auf.gEH != null) {
            String str;
            cT = u.e(aa.getContext().getSharedPreferences(aa.bti(), 0));
            if (!"language_default".equalsIgnoreCase(cT) || Locale.getDefault() == null) {
                str = cT;
            } else {
                str = Locale.getDefault().toString();
            }
            Iterator it = auf.gEH.iterator();
            while (it.hasNext()) {
                fVar = (f) it.next();
                if (str.equalsIgnoreCase(fVar.gIF)) {
                    v.i("MicroMsg.IPCallFeedbackConfigUpdater", "curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(auf.gEH.size())});
                    break;
                }
            }
            v.e("MicroMsg.IPCallFeedbackConfigUpdater", "no lanuage equal curLang, curLang: %s,resListCount: %s", new Object[]{str, Integer.valueOf(auf.gEH.size())});
        }
        fVar = null;
        if (fVar != null) {
            ArrayList arrayList = fVar.gIG;
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                com.tencent.mm.plugin.ipcall.a.g.e eVar = (com.tencent.mm.plugin.ipcall.a.g.e) it2.next();
                a aVar = new a();
                aVar.gID = eVar.gID;
                aVar.gIE = eVar.gIE;
                aVar.gMk = false;
                arrayList2.add(aVar);
            }
            this.mItemList = arrayList2;
            Iterator it3 = this.mItemList.iterator();
            while (it3.hasNext()) {
                a aVar2 = (a) it3.next();
                FlowLayout flowLayout = this.gLY;
                View textView = new TextView(getContext());
                textView.setTextSize(0, getContext().getResources().getDimension(2131493451) * com.tencent.mm.bd.a.ds(getContext()));
                textView.setBackgroundResource(this.fPA);
                textView.setTextColor(this.mContext.getResources().getColor(this.fPz));
                textView.setTag(aVar2);
                textView.setGravity(17);
                textView.setEllipsize(TruncateAt.END);
                textView.setSingleLine();
                textView.setText(aVar2.gIE);
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ g gMj;

                    {
                        this.gMj = r1;
                    }

                    public final void onClick(View view) {
                        a aVar = (a) view.getTag();
                        if (aVar.gMk) {
                            aVar.gMk = false;
                        } else {
                            aVar.gMk = true;
                        }
                        g.a(this.gMj, (TextView) view);
                    }
                });
                flowLayout.addView(textView);
            }
        }
    }

    private String me(int i) {
        String str = "";
        if (i == 3) {
            return "";
        }
        if (!be.kS(this.gMb.getText().toString().trim())) {
            str = "0";
        }
        if (this.mItemList == null) {
            return str;
        }
        Iterator it = this.mItemList.iterator();
        String str2 = str;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!aVar.gMk) {
                str = str2;
            } else if (str2.equals("")) {
                str2 = aVar.gID;
            } else {
                str = str2 + "_" + aVar.gID;
            }
            str2 = str;
        }
        return str2;
    }

    private LinkedList<bgg> mf(int i) {
        LinkedList<bgg> linkedList = new LinkedList();
        if (i == 3) {
            return linkedList;
        }
        String trim = this.gMb.getText().toString().trim();
        if (!be.kS(trim)) {
            bgg com_tencent_mm_protocal_c_bgg = new bgg();
            com_tencent_mm_protocal_c_bgg.aRI = 0;
            com_tencent_mm_protocal_c_bgg.hQP = trim;
            linkedList.add(com_tencent_mm_protocal_c_bgg);
        }
        if (this.mItemList != null) {
            Iterator it = this.mItemList.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.gMk) {
                    bgg com_tencent_mm_protocal_c_bgg2 = new bgg();
                    try {
                        com_tencent_mm_protocal_c_bgg2.aRI = be.getInt(aVar.gID, 0);
                        linkedList.add(com_tencent_mm_protocal_c_bgg2);
                    } catch (NumberFormatException e) {
                        v.e("MicroMsg.IPCallFeedbackDialog", "getFeedbackList error, id = " + aVar.gID);
                    }
                }
            }
        }
        return linkedList;
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.up = charSequence;
        } else {
            this.up = null;
        }
    }

    public final void show() {
        super.show();
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.IPCallFeedbackDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void mg(int i) {
        if (i == 0) {
            this.gLO.setVisibility(0);
            this.gLP.setVisibility(4);
            if (this.gLM == 1) {
                ((LayoutParams) this.gLX.getLayoutParams()).height = 0;
                this.gLX.requestLayout();
            }
            be.cw(this.eEX);
        } else if (i == 1) {
            this.gLO.setVisibility(0);
            this.gLP.setVisibility(4);
            if (this.gLM == 0) {
                ((LayoutParams) this.gLX.getLayoutParams()).height = -2;
                this.gLX.requestLayout();
                this.gLX.startAnimation(this.gMf);
            }
        } else if (i == 2) {
            this.gLO.setVisibility(4);
            this.gLP.setVisibility(0);
            be.cw(this.eEX);
        }
        this.gLM = i;
    }
}
