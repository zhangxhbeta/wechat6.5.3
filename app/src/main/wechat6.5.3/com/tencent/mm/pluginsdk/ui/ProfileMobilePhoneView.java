package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.k;
import java.util.List;
import junit.framework.Assert;

public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView eXB;
    public LinearLayout lHA;
    public boolean lHB;
    public String lHr;
    public String lHs;
    public String[] lHt;
    private Context mContext;

    private static class a extends BaseAdapter {
        private List<String> grq = null;
        private Context mContext = null;

        private class a {
            TextView dID;
            final /* synthetic */ a lHE;

            private a(a aVar) {
                this.lHE = aVar;
            }
        }

        public a(Context context, List<String> list) {
            Assert.assertTrue(context != null);
            this.mContext = context;
            this.grq = list;
        }

        public final int getCount() {
            return this.grq == null ? 0 : this.grq.size();
        }

        public final Object getItem(int i) {
            return this.grq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130903335, viewGroup, false);
                a aVar = new a();
                aVar.dID = (TextView) view.findViewById(2131755226);
                view.setTag(aVar);
                obj = aVar;
            } else {
                obj = view.getTag();
            }
            ((a) obj).dID.setText(str);
            return view;
        }
    }

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        final k kVar = new k(profileMobilePhoneView.mContext);
        kVar.eGK = new a(profileMobilePhoneView.mContext, be.g(!profileMobilePhoneView.lHB ? new String[]{profileMobilePhoneView.mContext.getResources().getString(2131231864)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(2131231864), profileMobilePhoneView.mContext.getResources().getString(2131231865)}));
        kVar.lSE = new OnItemClickListener(profileMobilePhoneView) {
            final /* synthetic */ ProfileMobilePhoneView lHC;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (kVar != null) {
                    kVar.dismiss();
                }
                Intent intent;
                if (i == 0) {
                    Integer[] numArr;
                    g gVar;
                    Object[] objArr;
                    g gVar2;
                    Integer[] numArr2;
                    int i2;
                    if (be.kS(this.lHC.lHr)) {
                        numArr = new Object[1];
                        gVar = g.iuh;
                        objArr = numArr;
                    } else {
                        g gVar3 = g.iuh;
                        numArr = new Object[1];
                        if (this.lHC.lHr.equals(str.trim())) {
                            gVar2 = gVar3;
                            numArr2 = numArr;
                            Integer[] numArr3 = numArr;
                            i2 = 1;
                            Integer[] numArr4 = numArr3;
                            numArr2[0] = Integer.valueOf(i2);
                            gVar2.h(12043, r2);
                            intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse("tel:" + str));
                            this.lHC.getContext().startActivity(intent);
                        }
                        gVar = gVar3;
                        numArr2 = numArr;
                    }
                    gVar2 = gVar;
                    Object[] objArr2 = objArr;
                    numArr2 = numArr;
                    i2 = 0;
                    numArr2[0] = Integer.valueOf(i2);
                    gVar2.h(12043, objArr2);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse("tel:" + str));
                    try {
                        this.lHC.getContext().startActivity(intent);
                    } catch (Throwable e) {
                        v.a("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
                    }
                } else if (1 == i) {
                    g.iuh.h(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", str);
                    c.b(this.lHC.mContext, "ipcall", ".ui.IPCallDialUI", intent);
                }
            }
        };
        kVar.setCancelable(true);
        kVar.show();
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lHB = false;
        this.mContext = context;
    }

    public final int aGY() {
        return 2130904199;
    }

    public final void init() {
        this.eXB = (TextView) findViewById(2131758664);
        this.lHA = (LinearLayout) findViewById(2131758665);
        for (int i = 0; i < 5; i++) {
            this.lHA.getChildAt(i).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ProfileMobilePhoneView lHC;

                {
                    this.lHC = r1;
                }

                public final void onClick(View view) {
                    ProfileMobilePhoneView.a(this.lHC, ((TextView) view).getText().toString());
                }
            });
        }
    }

    @Deprecated
    public final boolean H(u uVar) {
        return false;
    }

    public final boolean aGZ() {
        if (this.eXB != null) {
            LayoutParams layoutParams = this.eXB.getLayoutParams();
            layoutParams.width = com.tencent.mm.bd.a.N(getContext(), 2131493077);
            this.eXB.setLayoutParams(layoutParams);
        }
        if (this.lHA != null) {
            int i;
            View childAt;
            int i2;
            int i3;
            if (be.kS(this.lHr) || !be.KT(this.lHr).booleanValue()) {
                if (!(this.lHr == null || be.KT(this.lHr).booleanValue())) {
                    v.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", new Object[]{this.lHr});
                }
                i = 0;
                boolean z = false;
            } else {
                childAt = this.lHA.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.lHr);
                }
                i = 1;
                i2 = 1;
            }
            if (be.kS(this.lHs)) {
                i3 = i2;
            } else {
                this.lHt = this.lHs.split(",");
                setVisibility(0);
                i3 = i2;
                while (i3 < this.lHt.length + i) {
                    childAt = this.lHA.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        ((TextView) childAt).setText(this.lHt[i3 - i]);
                    }
                    i3++;
                }
            }
            while (i3 < 5) {
                this.lHA.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i != 1 && be.kS(this.lHs)) {
                setVisibility(8);
            }
        }
        return false;
    }
}
