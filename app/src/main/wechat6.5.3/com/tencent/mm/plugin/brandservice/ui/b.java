package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.ui.base.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.asf;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;

public final class b extends c {
    private static com.tencent.mm.plugin.brandservice.ui.base.a.b exM;
    CharSequence dtS;
    protected CharSequence exA;
    protected boolean exD;
    protected boolean exE;
    protected String exN;
    protected String iconUrl;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.a.a.a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public TextView euh;
        public TextView exF;
        public View exH;
        public TextView exI;
        public View exL;
    }

    public b(Object obj, String str) {
        super(6, obj);
        this.exN = str;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.b Yn() {
        if (exM == null) {
            exM = new com.tencent.mm.plugin.brandservice.ui.base.a.b(this) {
                final /* synthetic */ b exO;

                {
                    this.exO = r1;
                }

                public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
                    if (!(aVar instanceof b)) {
                        return false;
                    }
                    String str;
                    String str2;
                    b bVar = (b) aVar;
                    asf com_tencent_mm_protocal_c_asf = (asf) aVar.data;
                    if (com_tencent_mm_protocal_c_asf.mEj != null) {
                        str = com_tencent_mm_protocal_c_asf.mEj.mQy;
                    } else {
                        str = null;
                    }
                    if (com_tencent_mm_protocal_c_asf.moM != null) {
                        str2 = com_tencent_mm_protocal_c_asf.moM.mQy;
                    } else {
                        str2 = null;
                    }
                    if (be.kS(str2)) {
                        v.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
                        return false;
                    }
                    c cVar;
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(str2);
                    Intent intent = new Intent();
                    if (com.tencent.mm.i.a.ei(LX.field_type)) {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Scene", 55);
                    } else {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_asf.cHh);
                        intent.putExtra("Contact_Nick", str);
                        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_asf.cHf);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_asf.cHl, com_tencent_mm_protocal_c_asf.cHd, com_tencent_mm_protocal_c_asf.cHe));
                        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_asf.cHc);
                        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_asf.mFv);
                        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_asf.mFu);
                        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_asf.mFy);
                        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_asf.mFw);
                        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_asf.mFx);
                        intent.putExtra("Contact_Scene", 55);
                        if (com_tencent_mm_protocal_c_asf.mFB != null) {
                            try {
                                intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_asf.mFB.toByteArray());
                            } catch (Throwable e) {
                                v.a("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.a.drp.d(intent, context);
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof c)) {
                        cVar = null;
                    } else {
                        cVar = (c) objArr[0];
                    }
                    com.tencent.mm.plugin.brandservice.ui.c.b YG = bVar.YG();
                    if (YG == null || cVar == null) {
                        return true;
                    }
                    YG.a(cVar, aVar, 1, str2, bVar.YH(), bVar.getPosition());
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, 2130904310, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
                    int i = 0;
                    if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
                        v.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        v.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
                    } else if (aVar2.data instanceof asf) {
                        int i2;
                        a aVar3 = (a) aVar;
                        b bVar = (b) aVar2;
                        aVar3.username = bVar.username;
                        aVar3.iconUrl = bVar.iconUrl;
                        com.tencent.mm.plugin.brandservice.ui.base.d.a.a(aVar3.dtX, bVar.username, bVar.iconUrl);
                        aVar3.euh.setText(bVar.dtS, BufferType.SPANNABLE);
                        View view = aVar3.exL;
                        if (bVar.exE) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        view.setVisibility(i2);
                        View view2 = aVar3.exH;
                        if (!bVar.exD) {
                            i = 8;
                        }
                        view2.setVisibility(i);
                        aVar3.exI.setText(bVar.exA, BufferType.SPANNABLE);
                        com.tencent.mm.plugin.brandservice.a.a.b(aVar3.exF, bVar.exN);
                    } else {
                        v.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        a aVar2 = (a) aVar;
                        aVar2.dtX = (ImageView) view.findViewById(2131756803);
                        aVar2.euh = (TextView) view.findViewById(2131759003);
                        aVar2.exF = (TextView) view.findViewById(2131755332);
                        aVar2.exL = view.findViewById(2131759005);
                        aVar2.exH = view.findViewById(2131759006);
                        aVar2.exI = (TextView) view.findViewById(2131759008);
                    }
                }
            };
        }
        return exM;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a Yo() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
        if (!this.ezH) {
            if (context == null || aVar == null || this.data == null) {
                v.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                v.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            } else if (this.data instanceof asf) {
                asf com_tencent_mm_protocal_c_asf = (asf) this.data;
                try {
                    this.dtS = e.a(context, com_tencent_mm_protocal_c_asf.mEj != null ? com_tencent_mm_protocal_c_asf.mEj.toString() : "", ((a) aVar).euh.getTextSize());
                } catch (Exception e) {
                    this.dtS = "";
                }
                this.iconUrl = com_tencent_mm_protocal_c_asf.mlZ;
                this.username = com_tencent_mm_protocal_c_asf.moM.toString();
            } else {
                v.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            }
        }
    }
}
