package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public abstract class a {
    private final String TAG;
    private LayoutInflater dY;
    protected TextView eXB;
    private final int eYA;
    private final int eYB;
    private final int eYC;
    private int[] eYD;
    private int eYE;
    public f eYF;
    protected View eYG;
    protected ImageView eYH;
    protected ImageView eYI;
    protected TextView eYJ;
    protected TextView eYK;
    protected ProgressBar eYL;
    protected ViewGroup eYM;
    protected View eYN;
    protected TextView eYO;
    protected ImageView eYP;
    protected View eYQ;
    protected ProgressBar eYR;
    protected TextView eYS;
    protected TextView eYT;
    protected FrameLayout eYU;
    protected View eYV;
    private View eYz;
    public int kB;
    Context mContext;

    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] eYY = new int[a.aeF().length];

        static {
            try {
                eYY[a.eYZ - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                eYY[a.eZa - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                eYY[a.eZb - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] aeF() {
            return (int[]) eZc.clone();
        }

        static {
            eYZ = 1;
            eZa = 2;
            eZb = 3;
            eZc = new int[]{eYZ, eZa, eZb};
        }
    }

    protected abstract boolean aeA();

    protected abstract void aeo();

    protected abstract int[] aep();

    protected abstract int aeq();

    public a(Context context, View view) {
        this(context, view, a.eYZ);
    }

    private a(Context context, View view, int i) {
        this.TAG = "MicroMsg.emoji.BaseEmojiItemHolder";
        this.eYA = 2130903476;
        this.eYB = 2130903495;
        this.eYC = 2130903496;
        this.eYD = new int[]{-1, -1};
        this.eYE = -1;
        this.mContext = context;
        this.dY = LayoutInflater.from(this.mContext);
        if (view == null) {
            switch (AnonymousClass2.eYY[i - 1]) {
                case 1:
                    view = jA(2130903476);
                    break;
                case 2:
                    view = jA(2130903496);
                    break;
                case 3:
                    view = jA(2130903495);
                    break;
                default:
                    view = jA(2130903476);
                    break;
            }
        }
        this.eYV = view;
        if (view != null) {
            this.eYz = view;
            this.eYG = this.eYz.findViewById(2131756639);
            this.eYI = (ImageView) this.eYz.findViewById(2131756652);
            this.eYH = (ImageView) this.eYz.findViewById(2131756640);
            this.eXB = (TextView) this.eYz.findViewById(2131756643);
            this.eYJ = (TextView) this.eYz.findViewById(2131756645);
            this.eYK = (TextView) this.eYz.findViewById(2131756644);
            this.eYL = (ProgressBar) this.eYz.findViewById(2131756649);
            this.eYN = this.eYz.findViewById(2131756642);
            this.eYM = (ViewGroup) this.eYz.findViewById(2131756646);
            this.eYO = (TextView) this.eYz.findViewById(2131756647);
            this.eYP = (ImageView) this.eYz.findViewById(2131756648);
            this.eYQ = this.eYz.findViewById(2131756650);
            this.eYR = (ProgressBar) this.eYz.findViewById(2131756651);
            this.eYS = (TextView) this.eYz.findViewById(2131756637);
            this.eYT = (TextView) this.eYz.findViewById(2131756706);
            this.eYU = (FrameLayout) this.eYz.findViewById(2131756638);
        }
        aeo();
        if (i == a.eYZ) {
            int[] aep = aep();
            if (this.eYH != null && aep[0] >= 0 && aep[1] >= 0 && !(aep[0] == this.eYD[0] && aep[1] == this.eYD[1])) {
                LayoutParams layoutParams = this.eYH.getLayoutParams();
                layoutParams.width = aep[0];
                layoutParams.height = aep[1];
                this.eYH.setLayoutParams(layoutParams);
                this.eYD = aep;
            }
            int aeq = aeq();
            if (!(this.eYz == null || aeq < 0 || this.eYE == aeq)) {
                this.eYz.setMinimumHeight(aeq);
                if (this.eYG != null) {
                    this.eYG.setMinimumHeight(aeq);
                }
            }
        }
        view.setTag(this);
    }

    private View jA(int i) {
        if (this.dY == null || i <= 0) {
            return null;
        }
        return this.dY.inflate(i, null);
    }

    public final void setTitle(String str) {
        this.eXB.setText(str);
    }

    public final void aer() {
        this.eXB.setText(2131232422);
    }

    public final ImageView aes() {
        return this.eYH;
    }

    public final void aet() {
        this.eYH.setImageResource(2130838375);
    }

    public final ImageView aeu() {
        return this.eYI;
    }

    public final void jB(int i) {
        this.eYI.setVisibility(i);
    }

    public final void aev() {
        this.eYI.setImageResource(2130838175);
    }

    public final void jC(int i) {
        this.eYN.setVisibility(i);
    }

    public final void aew() {
        this.eYJ.setVisibility(8);
        this.eYK.setVisibility(8);
    }

    public final void qV(String str) {
        this.eYJ.setText(str);
    }

    public final void qW(String str) {
        if (be.kS(str)) {
            this.eYK.setVisibility(8);
            return;
        }
        this.eYK.setVisibility(0);
        this.eYK.setText(str);
    }

    public final void a(final com.tencent.mm.plugin.emoji.model.f.a aVar) {
        if (this.eYN != null) {
            this.eYN.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a eYX;

                public final void onClick(View view) {
                    if (this.eYX.a(aVar, view)) {
                        this.eYX.b(aVar, view);
                    }
                }
            });
        }
    }

    protected boolean a(com.tencent.mm.plugin.emoji.model.f.a aVar, View view) {
        return true;
    }

    protected void b(com.tencent.mm.plugin.emoji.model.f.a aVar, View view) {
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final String aex() {
        return (this.eYF == null || this.eYF.fai == null) ? null : this.eYF.fai.mdM;
    }

    public final int aey() {
        return (this.eYF == null ? null : Integer.valueOf(this.eYF.mStatus)).intValue();
    }

    public final String aez() {
        return (this.eYF == null || this.eYF.fai == null) ? null : this.eYF.fai.mqg;
    }

    public final int getProgress() {
        return this.eYF == null ? 0 : this.eYF.rT;
    }

    protected final void aeB() {
        this.eYL.setVisibility(8);
        this.eYM.setVisibility(8);
        this.eYN.setEnabled(false);
        this.eYP.setVisibility(8);
        this.eYR.setVisibility(0);
        this.eYR.setProgress(getProgress());
        if (this.eYQ == null) {
            this.eYR.setVisibility(0);
        } else {
            this.eYQ.setVisibility(0);
        }
    }

    private void aeC() {
        this.eYL.setVisibility(8);
        this.eYM.setBackgroundResource(2130837799);
        this.eYM.setVisibility(0);
        this.eYN.setEnabled(true);
        this.eYO.setText("");
        if (this.eYQ == null) {
            this.eYR.setVisibility(4);
        } else {
            this.eYQ.setVisibility(4);
        }
        this.eYO.setVisibility(0);
        this.eYO.setText(2131232376);
        this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131690182));
        this.eYP.setVisibility(8);
    }

    public void aeD() {
        if (this.eYF != null && aeA()) {
            this.eYO.setVisibility(8);
            this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131690144));
            switch (aey()) {
                case 0:
                    aeC();
                    return;
                case 3:
                    aeC();
                    return;
                case 4:
                case 12:
                    this.eYL.setVisibility(8);
                    this.eYM.setBackgroundResource(2130837802);
                    this.eYM.setVisibility(0);
                    if (this.eYQ == null) {
                        this.eYR.setVisibility(4);
                    } else {
                        this.eYQ.setVisibility(4);
                    }
                    this.eYN.setEnabled(true);
                    this.eYP.setVisibility(4);
                    this.eYO.setVisibility(0);
                    if (this.eYF.fai != null) {
                        this.eYO.setText(this.eYF.fai.mqg);
                        return;
                    }
                    return;
                case 6:
                    aeB();
                    return;
                case 7:
                    if (this.eYF.fam) {
                        v.d("MicroMsg.emoji.BaseEmojiItemHolder", "jacks use emoji");
                        this.eYL.setVisibility(8);
                        this.eYM.setBackgroundResource(2130837799);
                        this.eYM.setVisibility(0);
                        this.eYM.setTag(aex());
                        this.eYN.setEnabled(true);
                        this.eYO.setVisibility(0);
                        this.eYO.setText(2131232424);
                        this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131690182));
                        this.eYP.setVisibility(4);
                        if (this.eYQ == null) {
                            this.eYR.setVisibility(4);
                            return;
                        } else {
                            this.eYQ.setVisibility(4);
                            return;
                        }
                    } else if (this.eYF.fao && e.bx(this.eYF.fai.mqi, 64)) {
                        this.eYM.setVisibility(0);
                        this.eYM.setBackgroundResource(2130837801);
                        this.eYO.setVisibility(0);
                        this.eYO.setText(2131232395);
                        this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131690182));
                        this.eYP.setVisibility(4);
                        this.eYN.setEnabled(true);
                        if (this.eYQ == null) {
                            this.eYR.setVisibility(4);
                            return;
                        } else {
                            this.eYQ.setVisibility(4);
                            return;
                        }
                    } else {
                        this.eYL.setVisibility(8);
                        this.eYM.setVisibility(0);
                        this.eYM.setBackgroundResource(2130837802);
                        this.eYO.setVisibility(0);
                        this.eYO.setText(2131232378);
                        this.eYO.setTextColor(this.mContext.getResources().getColorStateList(2131689549));
                        this.eYP.setVisibility(4);
                        this.eYN.setEnabled(false);
                        if (this.eYQ == null) {
                            this.eYR.setVisibility(4);
                            return;
                        } else {
                            this.eYQ.setVisibility(4);
                            return;
                        }
                    }
                case 8:
                    this.eYL.setVisibility(8);
                    this.eYM.setBackgroundDrawable(null);
                    this.eYM.setVisibility(0);
                    this.eYN.setEnabled(false);
                    this.eYO.setVisibility(0);
                    this.eYO.setText(2131232379);
                    this.eYP.setVisibility(4);
                    if (this.eYQ == null) {
                        this.eYR.setVisibility(4);
                        return;
                    } else {
                        this.eYQ.setVisibility(4);
                        return;
                    }
                case 10:
                    this.eYL.setVisibility(8);
                    this.eYM.setBackgroundResource(2130837802);
                    this.eYM.setVisibility(0);
                    this.eYO.setVisibility(0);
                    this.eYO.setText(2131232390);
                    this.eYP.setVisibility(4);
                    this.eYN.setEnabled(true);
                    if (this.eYQ == null) {
                        this.eYR.setVisibility(4);
                        return;
                    } else {
                        this.eYQ.setVisibility(4);
                        return;
                    }
                case 11:
                    this.eYL.setVisibility(0);
                    this.eYM.setBackgroundResource(2130837802);
                    this.eYM.setVisibility(0);
                    this.eYO.setVisibility(0);
                    this.eYO.setText("");
                    this.eYN.setEnabled(false);
                    this.eYP.setVisibility(4);
                    if (this.eYQ == null) {
                        this.eYR.setVisibility(4);
                        return;
                    } else {
                        this.eYQ.setVisibility(4);
                        return;
                    }
                default:
                    v.w("MicroMsg.emoji.BaseEmojiItemHolder", "unknow product status:%d", new Object[]{Integer.valueOf(aey())});
                    return;
            }
        }
    }

    public final View aeE() {
        return this.eYV;
    }
}
