package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelsearch.i;
import com.tencent.mm.plugin.brandservice.ui.base.c;
import com.tencent.mm.protocal.c.asg;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.protocal.c.md;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import java.util.List;

public final class a extends c {
    private static b exz;
    protected CharSequence exA;
    protected CharSequence exB;
    protected CharSequence exC;
    protected boolean exD;
    protected boolean exE;
    protected String iconUrl;
    protected CharSequence nickName;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.a.a.a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public TextView exF;
        public TextView exG;
        public View exH;
        public TextView exI;
        public TextView exJ;
        public TextView exK;
        View exL;
    }

    public static class b extends com.tencent.mm.plugin.brandservice.ui.base.a.b {
        public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
            if (!(aVar instanceof a)) {
                return false;
            }
            a aVar2 = (a) aVar;
            if (aVar.data instanceof id) {
                id idVar = (id) aVar.data;
                if (idVar.mjh == null || idVar.mjh.miO == null) {
                    v.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return false;
                }
                String str;
                int i;
                int i2 = 0;
                c cVar = null;
                String str2 = "";
                if (objArr != null) {
                    c cVar2;
                    if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                        cVar2 = null;
                    } else {
                        cVar2 = (c) objArr[0];
                    }
                    if (objArr.length > 2 && (objArr[2] instanceof Integer)) {
                        i2 = ((Integer) objArr[2]).intValue();
                    }
                    if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                        cVar = cVar2;
                        str = str2;
                        i = i2;
                    } else {
                        i = i2;
                        c cVar3 = cVar2;
                        str = (String) objArr[3];
                        cVar = cVar3;
                    }
                } else {
                    str = str2;
                    i = 0;
                }
                String str3 = idVar.mjh.gkT;
                asg com_tencent_mm_protocal_c_asg = idVar.mjh.miO;
                String str4 = com_tencent_mm_protocal_c_asg.mEj != null ? com_tencent_mm_protocal_c_asg.mEj.mQy : null;
                String str5 = com_tencent_mm_protocal_c_asg.moM != null ? com_tencent_mm_protocal_c_asg.moM.mQy : null;
                if (be.kS(str5)) {
                    v.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                    return false;
                }
                int i3;
                i.jF(str5);
                if (be.kS(str3)) {
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(str5);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("Contact_Ext_Args_Search_Id", str);
                    bundle.putInt("Contact_Ext_Args_Index", aVar2.YH());
                    bundle.putString("Contact_Ext_Args_Query_String", "");
                    bundle.putInt("Contact_Scene", i);
                    intent.putExtra("Contact_Ext_Args", bundle);
                    intent.putExtra("Contact_User", str5);
                    intent.putExtra("Contact_Scene", i);
                    if (!com.tencent.mm.i.a.ei(LX.field_type)) {
                        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_asg.cHh);
                        intent.putExtra("Contact_Nick", str4);
                        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_asg.cHf);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_asg.cHl, com_tencent_mm_protocal_c_asg.cHd, com_tencent_mm_protocal_c_asg.cHe));
                        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_asg.cHc);
                        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_asg.mFv);
                        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_asg.mFu);
                        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_asg.mFy);
                        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_asg.mFw);
                        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_asg.mFx);
                        if (com_tencent_mm_protocal_c_asg.mQX != null) {
                            try {
                                intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_asg.mQX.toByteArray());
                            } catch (Throwable e) {
                                v.a("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.a.drp.d(intent, context);
                    i3 = 1;
                } else {
                    i3 = 8;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                }
                com.tencent.mm.plugin.brandservice.ui.c.b YG = aVar2.YG();
                if (!(YG == null || cVar == null)) {
                    YG.a(cVar, aVar, i3, str5, aVar2.YH(), aVar2.getPosition());
                }
                return true;
            }
            v.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
            return false;
        }

        public final View b(Context context, View view) {
            if (view == null) {
                return View.inflate(context, 2130904310, null);
            }
            return view;
        }

        public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
            int i = 8;
            if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
                v.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                v.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (aVar2 instanceof a) {
                a aVar3 = (a) aVar;
                a aVar4 = (a) aVar2;
                aVar3.username = aVar4.username;
                aVar3.iconUrl = aVar4.iconUrl;
                com.tencent.mm.plugin.brandservice.ui.base.d.a.a(aVar3.dtX, aVar4.username, aVar4.iconUrl);
                aVar3.exH.setVisibility(aVar4.exD ? 0 : 8);
                View view = aVar3.exL;
                if (aVar4.exE) {
                    i = 0;
                }
                view.setVisibility(i);
                com.tencent.mm.plugin.brandservice.a.a.b(aVar3.exG, aVar4.nickName);
                boolean b = com.tencent.mm.plugin.brandservice.a.a.b(aVar3.exK, aVar4.exC);
                boolean b2 = com.tencent.mm.plugin.brandservice.a.a.b(aVar3.exJ, aVar4.exB);
                if (com.tencent.mm.plugin.brandservice.a.a.b(aVar3.exI, aVar4.exA)) {
                    if (b || b2) {
                        aVar3.exI.setMaxLines(1);
                    } else {
                        aVar3.exI.setMaxLines(2);
                    }
                }
                v.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[]{aVar4.nickName, aVar4.exB});
            } else {
                v.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }

        public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
            if (view != null && aVar != null && (aVar instanceof a)) {
                a aVar2 = (a) aVar;
                aVar2.exF = (TextView) view.findViewById(2131755332);
                aVar2.exL = view.findViewById(2131759005);
                aVar2.dtX = (ImageView) view.findViewById(2131756803);
                aVar2.exG = (TextView) view.findViewById(2131759003);
                aVar2.exH = view.findViewById(2131759006);
                aVar2.exJ = (TextView) view.findViewById(2131759010);
                aVar2.exI = (TextView) view.findViewById(2131759008);
                aVar2.exK = (TextView) view.findViewById(2131759007);
            }
        }
    }

    public a(Object obj) {
        super(5, obj);
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.b Yn() {
        if (exz == null) {
            exz = new b();
        }
        return exz;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a Yo() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
        ExtInfo.c cVar = null;
        if (!this.ezH) {
            if (context == null || aVar == null || this.data == null) {
                v.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                v.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (this.data instanceof id) {
                a aVar2 = (a) aVar;
                id idVar = (id) this.data;
                if (idVar.mjh == null || idVar.mjh.miO == null) {
                    v.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return;
                }
                BizInfo bizInfo;
                asg com_tencent_mm_protocal_c_asg = idVar.mjh.miO;
                hz hzVar = idVar.mjh.miL;
                if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                    this.ezU = (List) objArr[1];
                }
                this.username = com_tencent_mm_protocal_c_asg.moM.mQy;
                this.iconUrl = com_tencent_mm_protocal_c_asg.mlZ;
                this.exB = hzVar == null ? "" : hzVar.miV;
                String str = com_tencent_mm_protocal_c_asg.mEj == null ? null : com_tencent_mm_protocal_c_asg.mEj.mQy;
                try {
                    List list = this.ezU;
                    aVar2.exG.getTextSize();
                    this.nickName = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list);
                } catch (Exception e) {
                    this.nickName = "";
                }
                String str2 = com_tencent_mm_protocal_c_asg.moM.mQy;
                md mdVar = com_tencent_mm_protocal_c_asg.mQX;
                if (mdVar != null) {
                    bizInfo = new BizInfo();
                    bizInfo.field_username = str2;
                    com.tencent.mm.plugin.brandservice.a.a.a(bizInfo, mdVar);
                } else {
                    bizInfo = null;
                }
                if (!(bizInfo == null || bizInfo.aX(false) == null)) {
                    cVar = bizInfo.aX(false).CS();
                }
                if (cVar != null) {
                    boolean z;
                    if (!bizInfo.aX(false).CU() || be.kS(cVar.cCt)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.exE = z;
                    this.exD = com_tencent_mm_protocal_c_asg.mFu != 0;
                }
                v.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asg.mFu)});
                String str3 = com_tencent_mm_protocal_c_asg.cHh;
                if (this.ezU.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.ezU.get(0)).toLowerCase())) {
                    try {
                        List list2 = this.ezU;
                        aVar2.exK.getTextSize();
                        this.exC = com.tencent.mm.plugin.brandservice.a.a.b(context, str3, list2);
                        this.exC = TextUtils.concat(new CharSequence[]{context.getResources().getString(2131234841), this.exC});
                    } catch (Exception e2) {
                        this.exC = "";
                    }
                }
                if (this.exC == null || this.exC.length() == 0 || this.exB == null || this.exB.length() == 0) {
                    try {
                        str = com_tencent_mm_protocal_c_asg.cHf;
                        List list3 = this.ezU;
                        aVar2.exI.getTextSize();
                        this.exA = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list3);
                    } catch (Exception e3) {
                        this.exA = "";
                    }
                }
                v.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[]{this.nickName, this.exB});
                this.ezH = true;
            } else {
                v.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }
    }
}
