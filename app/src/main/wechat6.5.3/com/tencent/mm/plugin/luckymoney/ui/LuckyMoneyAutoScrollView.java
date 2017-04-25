package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class LuckyMoneyAutoScrollView extends RelativeLayout implements b {
    private View dtW;
    private RelativeLayout hdE;
    private RelativeLayout hdF;
    private RelativeLayout hdG;
    LuckyMoneyAutoScrollItem hdH;
    LuckyMoneyAutoScrollItem hdI;
    LuckyMoneyAutoScrollItem hdJ;
    ImageView hdK;
    ImageView hdL;
    ImageView hdM;
    private String hdN;
    private String hdO;
    private String hdP;
    boolean hdQ;
    private a hdR;
    private Context mContext;

    public interface a {
        void aye();
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.hdN = "0";
        this.hdO = "0";
        this.hdP = "0";
        this.hdQ = false;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(2130903882, this);
        this.dtW = inflate;
        this.hdH = (LuckyMoneyAutoScrollItem) inflate.findViewById(2131757757);
        this.hdI = (LuckyMoneyAutoScrollItem) inflate.findViewById(2131757760);
        this.hdJ = (LuckyMoneyAutoScrollItem) inflate.findViewById(2131757763);
        this.hdK = (ImageView) inflate.findViewById(2131757755);
        this.hdL = (ImageView) inflate.findViewById(2131757759);
        this.hdM = (ImageView) inflate.findViewById(2131757762);
        this.hdE = (RelativeLayout) inflate.findViewById(2131757756);
        this.hdF = (RelativeLayout) inflate.findViewById(2131757758);
        this.hdG = (RelativeLayout) inflate.findViewById(2131757761);
    }

    public LuckyMoneyAutoScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void wc(String str) {
        v.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: setting text: %s", new Object[]{str});
        this.hdN = str.substring(0, 1);
        this.hdO = str.substring(2, 3);
        this.hdP = str.substring(3, 4);
        this.hdH.hdu = be.getInt(this.hdN, 0);
        this.hdI.hdu = be.getInt(this.hdO, 0);
        this.hdJ.hdu = be.getInt(this.hdP, 0);
        this.hdK.setImageResource(((Integer) LuckyMoneyAutoScrollItem.hdy.get(be.getInt(this.hdN, 0))).intValue());
        this.hdL.setImageResource(((Integer) LuckyMoneyAutoScrollItem.hdy.get(be.getInt(this.hdO, 0))).intValue());
        this.hdM.setImageResource(((Integer) LuckyMoneyAutoScrollItem.hdy.get(be.getInt(this.hdP, 0))).intValue());
        this.hdK.setVisibility(4);
        this.hdL.setVisibility(4);
        this.hdM.setVisibility(4);
        this.hdH.hdx = this;
        this.hdI.hdx = this;
        this.hdJ.hdx = this;
        v.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: first: %s, second :%s, third: %s", new Object[]{this.hdN, this.hdO, this.hdP});
    }

    public final void a(a aVar) {
        this.hdR = aVar;
        ad.o(new Runnable(this) {
            final /* synthetic */ LuckyMoneyAutoScrollView hdS;

            {
                this.hdS = r1;
            }

            public final void run() {
                this.hdS.hdH.ayc();
                this.hdS.hdI.ayc();
                this.hdS.hdJ.ayc();
            }
        });
    }

    public final void ayd() {
        if (!this.hdQ) {
            this.hdQ = true;
            ad.o(new Runnable(this) {
                final /* synthetic */ LuckyMoneyAutoScrollView hdS;

                {
                    this.hdS = r1;
                }

                public final void run() {
                    this.hdS.hdH.setVisibility(8);
                    this.hdS.hdI.setVisibility(8);
                    this.hdS.hdJ.setVisibility(8);
                    this.hdS.hdK.setVisibility(0);
                    this.hdS.hdL.setVisibility(0);
                    this.hdS.hdM.setVisibility(0);
                    if (this.hdS.hdR != null) {
                        this.hdS.hdR.aye();
                    }
                }
            });
        }
    }

    public final void bN(int i, int i2) {
        if (i > 0 && i2 > 0) {
            LayoutParams layoutParams = (LayoutParams) this.dtW.getLayoutParams();
            layoutParams.height = i2;
            this.dtW.setLayoutParams(layoutParams);
            this.dtW.invalidate();
            layoutParams = (LayoutParams) this.hdE.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hdE.setLayoutParams(layoutParams);
            this.hdE.invalidate();
            layoutParams = (LayoutParams) this.hdF.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.hdF.setLayoutParams(layoutParams);
            this.hdF.invalidate();
            layoutParams = (LayoutParams) this.hdG.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            layoutParams.leftMargin = 0;
            this.hdG.setLayoutParams(layoutParams);
            this.hdG.invalidate();
        }
    }
}
