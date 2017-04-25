package com.tencent.mm.plugin.sns.f;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.e;
import com.tencent.mm.plugin.sns.e.p;
import com.tencent.mm.plugin.sns.e.r;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.ui.SnsCommentUI;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    private boolean aZW = true;
    private int jcr = -1;
    public final int joU = 14;
    private com.tencent.mm.plugin.sns.ui.b.b joV;
    private FrameLayout joW;
    AbsoluteLayout joX = null;
    protected Animation joY;
    protected Animation joZ;
    boolean jpa = false;
    int[] jpb = new int[]{2131235354, 2131235355, 2131235356, 2131235357};
    private int[] jpc = new int[]{2131165223, 2131165225, 2131165224, 2131165222};
    private int[] jpd = this.jpb;
    private int[] jpe;
    private int[] jpf;
    Map<Long, b> jpg = new HashMap();
    private Map<Long, b> jph = new HashMap();
    private HashSet<Long> jpi = new HashSet();
    h jpj = null;
    private HashMap<Long, Boolean> jpk = new HashMap();
    Context mContext;

    class a {
        View jby = null;
        long jdG;
        final /* synthetic */ b jpo;
        String jpq;
        com.tencent.mm.plugin.sns.storage.b jpr;

        public a(b bVar, String str, View view, long j, com.tencent.mm.plugin.sns.storage.b bVar2) {
            this.jpo = bVar;
            this.jpq = str;
            this.jby = view;
            this.jpr = bVar2;
            this.jdG = j;
        }
    }

    static class b {
        long cZw;
        StringBuffer jps = new StringBuffer();
        String jpt;
        long jpu;
        long jpv;
        String jpw;
        String jpx;

        public b(long j, String str, String str2, String str3, String str4) {
            this.jpt = str;
            this.jpw = str2;
            this.jpx = str3;
            this.cZw = j;
            this.jpu = System.currentTimeMillis();
            this.jps.append("1:0:" + str4);
        }

        public b(long j, String str, String str2, String str3) {
            this.jpt = str;
            this.jpw = str2;
            this.jpx = str3;
            this.cZw = j;
            this.jpu = System.currentTimeMillis();
            this.jps.append("0:0:");
        }

        public final void AU(String str) {
            v.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult " + str);
            if (this.jps.length() != 0) {
                this.jps.append("|");
            }
            this.jps.append(str);
        }

        public final void qq() {
            this.jpv = System.currentTimeMillis();
            v.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.cZw + " uxinfo:" + this.jpt + " actionresult: " + this.jps + " " + this.jpu + " " + this.jpv);
            g.iuh.h(11988, new Object[]{this.jpx, this.jpw, "", "", i.cE(this.cZw), this.jpt, this.jps, Long.valueOf(this.jpu / 1000), Long.valueOf(this.jpv / 1000)});
        }
    }

    static /* synthetic */ void a(b bVar, View view, View view2) {
        view.getTag();
        view2.setVisibility(0);
        bVar.jpa = true;
        bVar.joY.setAnimationListener(new AnimationListener(bVar) {
            final /* synthetic */ b jpo;

            {
                this.jpo = r1;
            }

            public final void onAnimationStart(Animation animation) {
                this.jpo.jpa = true;
            }

            public final void onAnimationEnd(Animation animation) {
                this.jpo.jpa = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view2.startAnimation(bVar.joY);
    }

    public final void a(int i, String str, long j, String str2, azr com_tencent_mm_protocal_c_azr, boolean z, bc bcVar) {
        if (z && this.aZW && this.jpj != null && bcVar != null) {
            this.jpi.add(Long.valueOf(j));
            this.jph.put(Long.valueOf(j), new b(j, this.jpj.jpw, this.jpj.jpx, bcVar.aYl()));
        }
    }

    public final void a(int i, String str, long j, String str2, azr com_tencent_mm_protocal_c_azr, boolean z) {
        if (z && this.aZW) {
            if (this.jpi.contains(Long.valueOf(j))) {
                boolean z2 = false;
                if (this.jpk.containsKey(Long.valueOf(j))) {
                    z2 = ((Boolean) this.jpk.get(Long.valueOf(j))).booleanValue();
                }
                if (z2) {
                    b bVar = (b) this.jph.get(Long.valueOf(j));
                    if (bVar != null) {
                        bVar.qq();
                    }
                }
            }
            this.jph.remove(Long.valueOf(j));
            this.jpi.remove(Long.valueOf(j));
        }
    }

    public final void a(b bVar) {
        this.jpg.remove(Long.valueOf(bVar.cZw));
        bVar.qq();
    }

    public b(Context context, com.tencent.mm.plugin.sns.ui.b.b bVar, FrameLayout frameLayout) {
        g aSw = ad.aSw();
        h hVar = new h();
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100007");
        if (Ls.isValid()) {
            Map buX = Ls.buX();
            if (buX != null) {
                v.i("MicroMsg.SnsABTestStrategy", "snsabtest feed " + Ls.field_expId + " " + Ls.field_layerId + " " + Ls.field_startTime + " " + Ls.field_endTime);
                hVar.d(Ls.field_layerId, Ls.field_expId, buX);
            }
        } else {
            v.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
            hVar = null;
        }
        aSw.jql = hVar;
        this.jpj = ad.aSw().aTp();
        if (this.jpj != null) {
            this.jpe = this.jpj.jqn;
            if (!this.jpj.aTq()) {
                this.aZW = false;
            }
        }
        this.mContext = context;
        this.joV = bVar;
        this.joW = frameLayout;
        this.joY = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.joY = AnimationUtils.loadAnimation(context, 2130968611);
        this.joZ = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, 1, 1.0f, 1, 0.0f);
        this.joZ = AnimationUtils.loadAnimation(context, 2130968612);
    }

    public final int cd(View view) {
        if (this.jpa) {
            return 0;
        }
        if (this.joX != null) {
            if (this.joX.getTag() instanceof a) {
                final View view2 = ((a) this.joX.getTag()).jby;
                this.jpa = true;
                view2.startAnimation(this.joZ);
                this.joZ.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ b jpo;

                    public final void onAnimationStart(Animation animation) {
                        this.jpo.jpa = true;
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        if (view2 != null) {
                            view2.clearAnimation();
                            view2.setVisibility(8);
                            this.jpo.aTn();
                        }
                        this.jpo.jpa = false;
                    }
                });
            } else {
                aTn();
            }
            return 0;
        } else if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.b)) {
            return 0;
        } else {
            if (!this.aZW || this.jpj == null) {
                return 2;
            }
            boolean booleanValue;
            int i;
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            long j = bVar.jdG;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.jdF.jYM;
            if (this.jpk.containsKey(Long.valueOf(j))) {
                booleanValue = ((Boolean) this.jpk.get(Long.valueOf(j))).booleanValue();
            } else if (this.jpj == null) {
                booleanValue = false;
            } else if (bVar2 == null) {
                booleanValue = false;
            } else {
                for (i = 0; i < this.jpj.jpZ.size(); i++) {
                    if (be.kS(a((a) this.jpj.jpZ.get(i), bVar2.juL))) {
                        this.jpk.put(Long.valueOf(j), Boolean.valueOf(false));
                        booleanValue = false;
                        break;
                    }
                }
                this.jpk.put(Long.valueOf(j), Boolean.valueOf(true));
                booleanValue = true;
            }
            if (!booleanValue) {
                return 2;
            }
            int length;
            int i2;
            String str = bVar.bap;
            this.jpg.put(Long.valueOf(bVar.jdG), new b(bVar.jdG, bVar.jdF.aYl(), this.jpj.jpw, this.jpj.jpx, this.mContext.getString(2131235364)));
            if (this.jpi.contains(Long.valueOf(bVar.jdG))) {
                this.jpi.remove(Long.valueOf(bVar.jdG));
            }
            this.joX = new AbsoluteLayout(this.mContext);
            this.joX.setId(2131755095);
            LayoutParams layoutParams = new LayoutParams(-1, -1);
            this.joW.addView(this.joX);
            final View inflate = q.em(this.mContext).inflate(2130903084, null);
            r12 = new TextView[3];
            ImageView[] imageViewArr = new ImageView[]{(TextView) inflate.findViewById(2131755299), (TextView) inflate.findViewById(2131755301), (TextView) inflate.findViewById(2131755303)};
            imageViewArr[0] = (ImageView) inflate.findViewById(2131755300);
            imageViewArr[1] = (ImageView) inflate.findViewById(2131755302);
            imageViewArr[2] = (ImageView) inflate.findViewById(2131755304);
            i = 0;
            if (!r.cM(bVar.jdG)) {
                for (int i3 : this.jpe) {
                    if (i3 == 3) {
                        i++;
                    }
                }
            }
            int i32 = 0;
            for (int i22 : this.jpe) {
                if (i22 == 0) {
                    i32++;
                }
            }
            if (i32 + i > 0) {
                length = (this.jpe.length - i32) - i;
                if (length == 0) {
                    return 2;
                }
                this.jpf = new int[length];
            } else {
                this.jpf = new int[this.jpe.length];
            }
            length = 0;
            i32 = 0;
            while (length < this.jpe.length) {
                if (this.jpe[length] != 0 && (i <= 0 || this.jpe[length] != 3)) {
                    this.jpf[i32] = this.jpe[length];
                    i32++;
                }
                length++;
            }
            if (r.cL(bVar.jdG)) {
                for (length = 0; length < this.jpf.length; length++) {
                    if (this.jpf[length] == 3) {
                        this.jpf[length] = 4;
                        break;
                    }
                }
            }
            i = 0;
            int fromDPToPix = ((com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12) * 2) + (com.tencent.mm.bd.a.fromDPToPix(this.mContext, 8) * 2)) + com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12);
            for (int i4 = 0; i4 < this.jpf.length; i4++) {
                int i5;
                i32 = this.jpf[i4];
                i22 = this.jpf[i4] - 1;
                r12[i4].setText(this.jpd[i22]);
                TextView textView = r12[i4];
                Paint paint = new Paint();
                String charSequence = textView.getText().toString();
                paint.setTextSize(textView.getTextSize());
                length = ((int) paint.measureText(charSequence, 0, charSequence.length())) + fromDPToPix;
                if (length > i) {
                    i5 = length;
                } else {
                    i5 = i;
                }
                r12[i4].setCompoundDrawablePadding(com.tencent.mm.bd.a.fromDPToPix(this.mContext, 8));
                r12[i4].setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(this.jpc[i22]), null, null, null);
                if (i22 == 1) {
                    imageViewArr[i4].setVisibility(0);
                } else {
                    imageViewArr[i4].setVisibility(8);
                }
                r12[i4].setTag(bVar);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                final View view3 = view;
                r12[i4].setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b jpo;

                    public final void onClick(View view) {
                        b bVar = this.jpo;
                        int i = i32;
                        com.tencent.mm.plugin.sns.data.b bVar2 = bVar3;
                        View view2 = inflate;
                        AbsoluteLayout absoluteLayout = this.jpo.joX;
                        v.d("MicroMsg.AdNotLikeAbTestHelper", "processFristButtonClick " + i + " " + bVar2.jdG);
                        b bVar3 = (b) bVar.jpg.get(Long.valueOf(bVar2.jdG));
                        if (bVar3 != null) {
                            bVar3.AU("1:" + (i == 4 ? 3 : i) + ":" + bVar.mContext.getString(bVar.jpb[i - 1]));
                        }
                        if (i == 1) {
                            k Bq = ad.aSE().Bq(bVar2.bap);
                            if (Bq != null) {
                                if (Bq.qC(32)) {
                                    com.tencent.mm.plugin.sns.storage.a aUo = Bq.aUo();
                                    String str = aUo == null ? "" : aUo.jbF;
                                    g.iuh.h(11855, new Object[]{Integer.valueOf(1), Integer.valueOf(3), str});
                                }
                                ad.aSF().delete(Bq.field_snsId);
                                ad.aSH().cX(Bq.field_snsId);
                                ak.vy().a(new p(Bq.field_snsId, 8), 0);
                                bVar.a(bVar3);
                                bVar.aTn();
                            }
                        } else if (i == 2) {
                            bVar.a(view2, absoluteLayout, bVar2);
                        } else if (i == 3) {
                            if (!r.cL(bVar2.jdG)) {
                                r.cJ(bVar2.jdG);
                            }
                            bVar.a(bVar3);
                            bVar.aTn();
                        } else if (i == 4) {
                            if (r.cL(bVar2.jdG)) {
                                r.cK(bVar2.jdG);
                            }
                            bVar.a(bVar3);
                            bVar.aTn();
                        }
                    }
                });
                i = i5;
            }
            for (length = 0; length < this.jpf.length; length++) {
                r12[length].setMaxWidth(i);
            }
            for (length = this.jpf.length; length < 3; length++) {
                r12[length].setVisibility(8);
            }
            Rect rect = new Rect();
            length = com.tencent.mm.pluginsdk.e.da(this.mContext);
            int[] aYm = bVar.jdF.aYm();
            v.d("MicroMsg.AdNotLikeAbTestHelper", "addCommentView getLocationInWindow " + aYm[0] + "  " + aYm[1] + " height: " + length);
            i += com.tencent.mm.bd.a.fromDPToPix(this.mContext, 12);
            i22 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 17.0f);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 2.0f);
            this.jcr = com.tencent.mm.pluginsdk.e.db(this.mContext);
            ViewGroup.LayoutParams layoutParams2 = new AbsoluteLayout.LayoutParams(i, -2, (aYm[0] - i) - a, ((aYm[1] - this.jcr) - length) + i22);
            this.joX.setTag(new a(this, str, inflate, bVar.jdG, bVar.jdF.jYM));
            this.joX.addView(inflate, layoutParams2);
            inflate.setVisibility(8);
            this.jpa = true;
            final View view4 = view;
            new ac().post(new Runnable(this) {
                final /* synthetic */ b jpo;

                public final void run() {
                    b.a(this.jpo, view4, inflate);
                }
            });
            return 1;
        }
    }

    final void a(View view, AbsoluteLayout absoluteLayout, com.tencent.mm.plugin.sns.data.b bVar) {
        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.removeAllViews();
        if (this.jpj != null && bVar.jdF != null && bVar.jdF.jYM != null) {
            int i;
            com.tencent.mm.plugin.sns.storage.b bVar2 = bVar.jdF.jYM;
            Paint paint = new Paint(1);
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 12.0f);
            int a2 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 10.0f);
            int a3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 150.0f);
            List<TextView> linkedList = new LinkedList();
            float a4 = (((float) com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 17.0f)) * com.tencent.mm.bd.a.ds(this.mContext)) + ((float) (a2 * 2));
            int i2 = (int) a4;
            int i3 = 0;
            for (i = 0; i < this.jpj.jpZ.size(); i++) {
                a aVar = (a) this.jpj.jpZ.get(i);
                final View textView = new TextView(this.mContext);
                textView.setPadding(a, a2, a, a2);
                textView.setTextSize(1, 14.0f * com.tencent.mm.bd.a.ds(this.mContext));
                textView.setTextColor(this.mContext.getResources().getColor(2131690018));
                Object a5 = a(aVar, bVar2.juL);
                textView.setText(a5);
                paint.setTextSize(textView.getTextSize());
                viewGroup.addView(textView);
                i3 = Math.max(i3, ((int) paint.measureText(a5)) + (a * 2));
                textView.setTag(Integer.valueOf(i));
                linkedList.add(textView);
                final com.tencent.mm.plugin.sns.data.b bVar3 = bVar;
                textView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ b jpo;

                    public final void onClick(View view) {
                        int intValue = ((Integer) view.getTag()).intValue();
                        b bVar = (b) this.jpo.jpg.get(Long.valueOf(bVar3.jdG));
                        int i = ((a) this.jpo.jpj.jpZ.get(intValue)).joP;
                        if (bVar != null) {
                            bVar.AU("3:" + i + ":" + textView.getText());
                        }
                        if (((a) this.jpo.jpj.jpZ.get(intValue)).joT == 1) {
                            Intent intent = new Intent();
                            intent.setClass(this.jpo.mContext, SnsCommentUI.class);
                            intent.putExtra("sns_comment_type", 2);
                            intent.putExtra("sns_id", bVar3.jdG);
                            intent.putExtra("sns_uxinfo", bVar.jpt);
                            intent.putExtra("action_st_time", bVar.jpu);
                            intent.putExtra("sns_actionresult", bVar.jps.toString());
                            ((MMActivity) this.jpo.mContext).startActivity(intent);
                            this.jpo.jpg.remove(Long.valueOf(bVar3.jdG));
                            this.jpo.aTn();
                            return;
                        }
                        this.jpo.a(bVar);
                        this.jpo.aTn();
                    }
                });
            }
            v.i("MicroMsg.AdNotLikeAbTestHelper", "w h " + i3 + " " + i2);
            if (i3 < a3) {
                i3 = a3;
            }
            for (TextView textView2 : linkedList) {
                ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
                layoutParams.width = i3;
                layoutParams.height = (int) a4;
                textView2.setLayoutParams(layoutParams);
            }
            Rect rect = new Rect();
            int da = com.tencent.mm.pluginsdk.e.da(this.mContext);
            int[] aYm = bVar.jdF.aYm();
            i = (aYm[0] - i3) - com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext, 2.0f);
            int i4 = ((aYm[1] - this.jcr) - da) + i2;
            bc bcVar = bVar.jdF;
            absoluteLayout.updateViewLayout(view, new AbsoluteLayout.LayoutParams(-2, -2, i, i4 - (bcVar.jYI != null ? bcVar.jYI.getHeight() : 0)));
        }
    }

    private static String a(a aVar, Map<String, String> map) {
        if (aVar == null) {
            return "";
        }
        String str;
        if (u.bsV()) {
            str = aVar.joQ;
        } else if (u.bsW()) {
            str = aVar.joR;
        } else {
            str = aVar.joS;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '$') {
                if (stringBuffer2.length() == 0) {
                    stringBuffer2.append(charAt);
                } else if (stringBuffer2.charAt(stringBuffer2.length() - 1) == '$') {
                    stringBuffer.append('$');
                    stringBuffer2 = new StringBuffer();
                } else {
                    String str2 = (String) map.get(stringBuffer2.substring(1));
                    if (str2 == null) {
                        return "";
                    }
                    stringBuffer.append(str2);
                }
            } else if (stringBuffer2.length() == 0) {
                stringBuffer.append(charAt);
            } else {
                stringBuffer2.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public final boolean aTn() {
        boolean z = false;
        if (this.joX != null) {
            if (this.joX.getTag() instanceof a) {
                b bVar = (b) this.jpg.get(Long.valueOf(((a) this.joX.getTag()).jdG));
                if (bVar != null) {
                    boolean z2 = (bVar.jps == null || bVar.jps.length() == 0) ? false : true;
                    if (z2) {
                        if (!(bVar.jps == null || bVar.jps.length() == 0 || !bVar.jps.toString().startsWith("1:0"))) {
                            z = true;
                        }
                        if (z) {
                            bVar.AU("2:0:");
                        }
                        a(bVar);
                    } else {
                        bVar.AU("2:0:");
                        a(bVar);
                    }
                }
            }
            this.joW.removeView(this.joX);
            this.joX = null;
            return true;
        }
        this.jpa = false;
        return false;
    }
}
