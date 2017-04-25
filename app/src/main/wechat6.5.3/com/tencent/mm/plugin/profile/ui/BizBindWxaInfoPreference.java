package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.a.b;
import com.tencent.mm.t.a.c;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class BizBindWxaInfoPreference extends Preference {
    private static int hTI = a.fromDPToPix(aa.getContext(), 13);
    private static int hTJ = aa.getResources().getDimensionPixelSize(2131493166);
    private TextView eXB;
    private OnClickListener fCb;
    List<WxaEntryInfo> hTA;
    private View hTB;
    private ImageView hTC;
    private TextView hTD;
    private LinearLayout hTE;
    private ViewGroup hTF;
    private View hTG;
    private OnClickListener hTH;
    private volatile boolean hTy;
    volatile boolean hTz;

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public BizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected final void onBindView(final View view) {
        this.hTB = view.findViewById(2131756438);
        this.hTC = (ImageView) view.findViewById(2131756439);
        this.eXB = (TextView) view.findViewById(2131755634);
        this.hTD = (TextView) view.findViewById(2131756442);
        this.hTG = view.findViewById(2131756441);
        this.hTE = (LinearLayout) view.findViewById(2131756440);
        this.hTF = (ViewGroup) view.findViewById(2131756437);
        this.hTy = true;
        this.hTz = this.hTA != null;
        aGB();
        view.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
            final /* synthetic */ BizBindWxaInfoPreference hTK;

            public final boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                this.hTK.aGB();
                return true;
            }
        });
        super.onBindView(view);
    }

    private void init() {
        this.fCb = new OnClickListener(this) {
            final /* synthetic */ BizBindWxaInfoPreference hTK;

            {
                this.hTK = r1;
            }

            public final void onClick(View view) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof String)) {
                    ok okVar = new ok();
                    okVar.bpu.userName = (String) tag;
                    okVar.bpu.scene = 1020;
                    okVar.bpu.aWP = (String) tag;
                    com.tencent.mm.sdk.c.a.nhr.z(okVar);
                }
            }
        };
        this.hTH = new OnClickListener(this) {
            final /* synthetic */ BizBindWxaInfoPreference hTK;

            {
                this.hTK = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.hTK.mContext, BizBindWxaInfoUI.class);
                intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(this.hTK.hTA));
                this.hTK.mContext.startActivity(intent);
            }
        };
    }

    final void aGB() {
        if (this.hTy && this.hTA != null && this.hTz && this.hTF.getMeasuredWidth() != 0) {
            WxaEntryInfo wxaEntryInfo;
            this.hTz = false;
            if (this.hTA.isEmpty()) {
                wxaEntryInfo = null;
            } else {
                wxaEntryInfo = (WxaEntryInfo) this.hTA.get(0);
            }
            if (wxaEntryInfo != null) {
                a(wxaEntryInfo, this.hTC, this.eXB);
            }
            this.hTD.setText(this.mContext.getString(2131232001, new Object[]{Integer.valueOf(this.hTA.size())}));
            List list = this.hTA;
            this.hTE.removeAllViews();
            if (!list.isEmpty()) {
                int size = list.size();
                int measuredWidth = (this.hTF.getMeasuredWidth() - this.hTF.getPaddingLeft()) - this.hTF.getPaddingRight();
                int i = measuredWidth / (hTJ + hTI);
                if (i > size) {
                    this.hTG.setVisibility(8);
                } else {
                    this.hTG.setVisibility(0);
                    i = (measuredWidth - this.hTG.getMeasuredWidth()) / (hTJ + hTI);
                }
                measuredWidth = Math.min(i, size);
                if (measuredWidth > 1) {
                    for (size = 0; size < measuredWidth; size++) {
                        wxaEntryInfo = (WxaEntryInfo) list.get(size);
                        View imageView = new ImageView(this.mContext);
                        imageView.setLayoutParams(new LayoutParams(hTJ + hTI, hTJ));
                        imageView.setPadding(0, 0, hTI, 0);
                        this.hTE.addView(imageView);
                        a(wxaEntryInfo, imageView, null);
                    }
                }
                v.i("MicroMsg.BizBindWxaInfoPreference", "attachItemToContainer(size : %s)", new Object[]{Integer.valueOf(list.size())});
            }
            if (this.hTA.size() == 1) {
                this.hTB.setVisibility(0);
                this.hTF.setTag(((WxaEntryInfo) this.hTA.get(0)).username);
                this.hTF.setOnClickListener(this.fCb);
                return;
            }
            this.hTB.setVisibility(8);
            this.hTF.setTag(null);
            this.hTF.setOnClickListener(this.hTH);
        }
    }

    private static void a(WxaEntryInfo wxaEntryInfo, ImageView imageView, TextView textView) {
        if (wxaEntryInfo != null) {
            imageView.setTag(wxaEntryInfo.username);
            if (imageView != null) {
                b.AL().a(imageView, wxaEntryInfo.iconUrl, com.tencent.mm.t.a.a.AK(), c.cxH);
            }
            if (textView != null) {
                textView.setText(be.ma(wxaEntryInfo.title));
            }
        }
    }
}
