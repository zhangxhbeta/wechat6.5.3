package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.e.a.id;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import java.io.File;

public final class b implements com.tencent.mm.plugin.record.ui.h.b {
    private c dHB = new c<id>(this) {
        final /* synthetic */ b iqV;

        {
            this.iqV = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            id idVar = (id) bVar;
            if (idVar instanceof id) {
                switch (idVar.bif.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        this.iqV.handler.sendMessageAtFrontOfQueue(this.iqV.handler.obtainMessage(1));
                        break;
                }
            }
            return false;
        }
    };
    private OnClickListener fSC = new OnClickListener(this) {
        final /* synthetic */ b iqV;

        {
            this.iqV = r1;
        }

        public final void onClick(View view) {
            if (f.sj()) {
                com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                py pyVar = bVar.bdE.msM.msY;
                if (b.k(bVar.bdE)) {
                    v.i("MicroMsg.OtherViewWrapper", "same song, do release");
                    com.tencent.mm.ai.b.HB();
                    if (!this.iqV.iqT) {
                        this.iqV.handler.sendMessageAtFrontOfQueue(this.iqV.handler.obtainMessage(1));
                        return;
                    }
                    return;
                }
                String absolutePath;
                this.iqV.iqT = true;
                File file = new File(m.f(bVar.bdE, bVar.bao));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else if (bVar.bdE.aZh == null) {
                    absolutePath = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    ak.yW();
                    file = new File(stringBuilder.append(com.tencent.mm.model.c.xf()).append("web/").append(g.m(bVar.bdE.aZh.getBytes())).toString());
                    absolutePath = file.exists() ? file.getAbsolutePath() : "";
                }
                pw pwVar = bVar.bdE;
                String str = pwVar.title;
                String str2 = pwVar.desc;
                String str3 = pwVar.mrZ;
                String str4 = pwVar.msd;
                String str5 = pwVar.msb;
                String str6 = pwVar.luu;
                StringBuilder stringBuilder2 = new StringBuilder();
                ak.yW();
                com.tencent.mm.ai.b.b(com.tencent.mm.ai.b.a(6, null, str, str2, str3, str4, str5, str6, stringBuilder2.append(com.tencent.mm.model.c.xf()).append("web/").toString(), absolutePath, pyVar.appId));
                return;
            }
            s.ey(view.getContext());
        }
    };
    private int fSr = 0;
    ac handler;
    boolean iqT = false;
    OnClickListener iqU = new OnClickListener(this) {
        final /* synthetic */ b iqV;

        {
            this.iqV = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Context context;
            String str;
            Intent intent;
            Intent intent2;
            Context context2;
            switch (bVar.bdE.aKG) {
                case 4:
                case am.CTRL_INDEX /*15*/:
                    context = view.getContext();
                    if (be.kS(bVar.bdE.mrS) || bVar.bdE.msn <= 0) {
                        v.w("MicroMsg.OtherViewWrapper", "full md5[%s], fullsize[%d], start use url", new Object[]{bVar.bdE.msj, Long.valueOf(bVar.bdE.msn)});
                        str = bVar.bdE.mrZ;
                        if (be.kS(str)) {
                            str = bVar.bdE.msd;
                        }
                        if (be.kS(str)) {
                            v.w("MicroMsg.OtherViewWrapper", "go to video[webpage] error, url null, dataid[%s]", new Object[]{bVar.bdE.luu});
                            com.tencent.mm.ui.base.g.bf(context, context.getString(2131232718));
                            return;
                        }
                        Intent intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        if (bVar.aKG == 1) {
                            intent3.putExtra("is_favorite_item", true);
                            intent3.putExtra("fav_local_id", bVar.ipT.field_localId);
                            intent3.putExtra("key_detail_can_delete", false);
                            intent3.putExtra("geta8key_scene", 14);
                            v.d("MicroMsg.OtherViewWrapper", "go to video, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.ipT.field_id), Long.valueOf(bVar.ipT.field_localId), bVar.bdE.luu});
                        }
                        com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent3);
                        return;
                    } else if (bVar.aKG == 0) {
                        intent = new Intent(context, RecordMsgFileUI.class);
                        intent.putExtra("message_id", bVar.bao);
                        intent.putExtra("record_xml", bVar.bmh);
                        intent.putExtra("record_data_id", bVar.bdE.luu);
                        context.startActivity(intent);
                        return;
                    } else if (bVar.aKG == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.ipT.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.bdE.luu);
                        intent.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.ay.c.b(context, "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                        return;
                    } else {
                        return;
                    }
                case 5:
                    context = view.getContext();
                    if (bVar.bdE.msM == null) {
                        v.w("MicroMsg.OtherViewWrapper", "go to web page error, get data proto item null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context, context.getString(2131232717));
                        return;
                    }
                    Intent intent4;
                    py pyVar;
                    Intent intent5;
                    Bundle bundle;
                    pw pwVar = bVar.bdE;
                    if (pwVar != null) {
                        if (pwVar.msX) {
                            str = pwVar.canvasPageXml;
                        } else if (!(pwVar.msM == null || pwVar.msM.mtc == null || !pwVar.msM.mtc.msX)) {
                            str = pwVar.msM.mtc.canvasPageXml;
                        }
                        if (be.kS(str)) {
                            intent4 = new Intent();
                            intent4.putExtra("sns_landing_pages_xml", str);
                            intent4.putExtra("sns_landig_pages_from_source", 5);
                            intent4.putExtra("sns_landing_pages_share_thumb_url", bVar.bdE.coj);
                            intent4.addFlags(268435456);
                            intent4.putExtra("msg_id", bVar.bao);
                            com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent4);
                            return;
                        }
                        pyVar = bVar.bdE.msM.msY;
                        str = "";
                        if (bVar.bdE.msM.mtc != null) {
                            str = bVar.bdE.msM.mtc.mur;
                        }
                        if (pyVar != null && be.kS(r1)) {
                            str = pyVar.cZp;
                        }
                        if (be.kS(str)) {
                            str = bVar.bdE.mrZ;
                        }
                        if (be.kS(str)) {
                            intent5 = new Intent();
                            intent5.putExtra("rawUrl", str);
                            if (!(pyVar == null || be.kS(pyVar.aWH))) {
                                intent5.putExtra("srcDisplayname", l.er(pyVar.aWH));
                            }
                            intent5.putExtra("mode", 1);
                            if (bVar.aKG == 1) {
                                intent5.putExtra("is_favorite_item", true);
                                intent5.putExtra("fav_local_id", bVar.ipT.field_localId);
                                intent5.putExtra("key_detail_can_delete", false);
                                intent5.putExtra("geta8key_scene", 14);
                            }
                            bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", bVar.bdE.bnY);
                            intent5.putExtra("jsapiargs", bundle);
                            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent5);
                            return;
                        }
                        v.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context, context.getString(2131232717));
                        return;
                    }
                    str = null;
                    if (be.kS(str)) {
                        pyVar = bVar.bdE.msM.msY;
                        str = "";
                        if (bVar.bdE.msM.mtc != null) {
                            str = bVar.bdE.msM.mtc.mur;
                        }
                        str = pyVar.cZp;
                        if (be.kS(str)) {
                            str = bVar.bdE.mrZ;
                        }
                        if (be.kS(str)) {
                            intent5 = new Intent();
                            intent5.putExtra("rawUrl", str);
                            intent5.putExtra("srcDisplayname", l.er(pyVar.aWH));
                            intent5.putExtra("mode", 1);
                            if (bVar.aKG == 1) {
                                intent5.putExtra("is_favorite_item", true);
                                intent5.putExtra("fav_local_id", bVar.ipT.field_localId);
                                intent5.putExtra("key_detail_can_delete", false);
                                intent5.putExtra("geta8key_scene", 14);
                            }
                            bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", bVar.bdE.bnY);
                            intent5.putExtra("jsapiargs", bundle);
                            com.tencent.mm.ay.c.b(context, "webview", ".ui.tools.WebViewUI", intent5);
                            return;
                        }
                        v.w("MicroMsg.OtherViewWrapper", "go to web page error, url null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context, context.getString(2131232717));
                        return;
                    }
                    intent4 = new Intent();
                    intent4.putExtra("sns_landing_pages_xml", str);
                    intent4.putExtra("sns_landig_pages_from_source", 5);
                    intent4.putExtra("sns_landing_pages_share_thumb_url", bVar.bdE.coj);
                    intent4.addFlags(268435456);
                    intent4.putExtra("msg_id", bVar.bao);
                    com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent4);
                    return;
                case 6:
                    Context context3 = view.getContext();
                    if (context3 != null) {
                        qc qcVar;
                        py pyVar2;
                        if (bVar.bdE.msM != null) {
                            qcVar = bVar.bdE.msM.mta;
                            pyVar2 = bVar.bdE.msM.msY;
                        } else {
                            qcVar = null;
                            pyVar2 = null;
                        }
                        str = null;
                        if (pyVar2 != null) {
                            str = !be.kS(pyVar2.mtu) ? l.er(pyVar2.mtu) : l.er(pyVar2.bhM);
                        }
                        if (pyVar2 == null && bVar.aKG == 1) {
                            str = l.er(bVar.ipT.field_fromUser);
                        }
                        if (qcVar == null) {
                            v.w("MicroMsg.OtherViewWrapper", "go to location error, locItem null, dataid[%s]", new Object[]{bVar.bdE.luu});
                            com.tencent.mm.ui.base.g.bf(context3, context3.getString(2131232713));
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("kwebmap_slat", qcVar.lat);
                        intent2.putExtra("kwebmap_lng", qcVar.lng);
                        intent2.putExtra("kPoiName", qcVar.bkV);
                        intent2.putExtra("Kwebmap_locaion", qcVar.label);
                        if (qcVar.bhu >= 0) {
                            intent2.putExtra("kwebmap_scale", qcVar.bhu);
                        }
                        intent2.putExtra("kisUsername", str);
                        intent2.putExtra("kwebmap_from_to", true);
                        if (bVar.aKG == 1) {
                            intent2.putExtra("KFavLocSigleView", true);
                            intent2.putExtra("map_view_type", 2);
                            intent2.putExtra("kFavInfoLocalId", bVar.ipT.field_localId);
                            intent2.putExtra("kFavCanDel", false);
                            intent2.putExtra("kFavCanRemark", false);
                        } else if (bVar.aKG == 0) {
                            intent2.putExtra("map_view_type", 1);
                        }
                        com.tencent.mm.ay.c.b(context3, "location", ".ui.RedirectUI", intent2, 1002);
                        return;
                    }
                    return;
                case 7:
                    context2 = view.getContext();
                    intent2 = new Intent();
                    if (be.kS(bVar.bdE.mrZ)) {
                        v.w("MicroMsg.OtherViewWrapper", "go to music[webpage], web url is null, use data url instead, dataid[%s]", new Object[]{bVar.bdE.luu});
                        intent2.putExtra("rawUrl", bVar.bdE.msb);
                    } else {
                        intent2.putExtra("rawUrl", bVar.bdE.mrZ);
                    }
                    if (bVar.aKG == 1) {
                        intent2.putExtra("is_favorite_item", true);
                        intent2.putExtra("fav_local_id", bVar.ipT.field_localId);
                        intent2.putExtra("key_detail_can_delete", false);
                        v.d("MicroMsg.OtherViewWrapper", "start music webview, fav id %d, fav local id %d, data id %s", new Object[]{Integer.valueOf(bVar.ipT.field_id), Long.valueOf(bVar.ipT.field_localId), bVar.bdE.luu});
                    }
                    com.tencent.mm.ay.c.b(context2, "webview", ".ui.tools.WebViewUI", intent2);
                    return;
                case 8:
                    boolean z;
                    context = view.getContext();
                    if (bVar.aKG == 0) {
                        if (m.d(bVar.bdE, bVar.bao) && !a.b((Activity) context, m.c(bVar.bdE, bVar.bao), bVar.bdE.msh, 2)) {
                            z = false;
                        }
                        z = true;
                    } else {
                        if (bVar.aKG == 1) {
                            ez ezVar = new ez();
                            ezVar.bdQ.type = 14;
                            ezVar.bdQ.bdS = bVar.bdE;
                            com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                            if ((ezVar.bdR.ret == 1) && !a.b((Activity) context, d.a(bVar), bVar.bdE.msh, 2)) {
                                z = false;
                            }
                        }
                        z = true;
                    }
                    if (!z) {
                        return;
                    }
                    if (bVar.aKG == 0) {
                        intent = new Intent(context, RecordMsgFileUI.class);
                        intent.putExtra("message_id", bVar.bao);
                        intent.putExtra("record_xml", bVar.bmh);
                        intent.putExtra("record_data_id", bVar.bdE.luu);
                        context.startActivity(intent);
                        return;
                    } else if (bVar.aKG != 1) {
                        return;
                    } else {
                        if (m.h(bVar.bdE, bVar.bao)) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.ipT.field_localId);
                            com.tencent.mm.ay.c.b(context, "favorite", ".ui.detail.FavoriteImgDetailUI", intent);
                            return;
                        }
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.ipT.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.bdE.luu);
                        intent.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.ay.c.b(context, "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                        return;
                    }
                case 10:
                    context2 = view.getContext();
                    if (bVar.bdE.msM == null || bVar.bdE.msM.mte == null) {
                        v.w("MicroMsg.OtherViewWrapper", "go to product error, get data proto item null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232712));
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_Product_xml", bVar.bdE.msM.mte.info);
                    if (bVar.aKG == 1) {
                        intent2.putExtra("key_is_favorite_item", true);
                        intent2.putExtra("key_favorite_local_id", bVar.ipT.field_localId);
                        intent2.putExtra("key_can_delete_favorite_item", false);
                        intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    }
                    com.tencent.mm.ay.c.b(context2, "scanner", ".ui.ProductUI", intent2);
                    return;
                case 11:
                    context2 = view.getContext();
                    if (bVar.bdE.msM == null || bVar.bdE.msM.mte == null) {
                        v.w("MicroMsg.OtherViewWrapper", "go to mall product error, get data proto item null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232712));
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_product_info", bVar.bdE.msM.mte.info);
                    if (bVar.aKG == 1) {
                        intent2.putExtra("key_product_scene", 4);
                    }
                    com.tencent.mm.ay.c.b(context2, "product", ".ui.MallProductUI", intent2);
                    return;
                case an.CTRL_INDEX /*14*/:
                    context2 = view.getContext();
                    if (bVar.bdE.msM == null || bVar.bdE.msM.mtg == null) {
                        v.w("MicroMsg.OtherViewWrapper", "go to tv error, get data proto item null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232712));
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_TV_xml", bVar.bdE.msM.mtg.info);
                    if (bVar.aKG == 1) {
                        intent2.putExtra("key_is_favorite_item", true);
                        intent2.putExtra("key_favorite_local_id", bVar.ipT.field_localId);
                        intent2.putExtra("key_can_delete_favorite_item", false);
                    }
                    com.tencent.mm.ay.c.b(context2, "shake", ".ui.TVInfoUI", intent2);
                    return;
                case 16:
                    context2 = view.getContext();
                    if (bVar.bdE.msM == null) {
                        v.w("MicroMsg.OtherViewWrapper", "go to friend card error, get data proto item null, dataid[%s]", new Object[]{bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232712));
                        return;
                    }
                    String str2 = bVar.bdE.desc;
                    ak.yW();
                    at.a MU = com.tencent.mm.model.c.wJ().MU(str2);
                    if (MU == null) {
                        v.w("MicroMsg.OtherViewWrapper", "go to friend card error, parse content fail,[%s], dataid[%s]", new Object[]{str2, bVar.bdE.luu});
                        com.tencent.mm.ui.base.g.bf(context2, context2.getString(2131232712));
                        return;
                    }
                    Intent intent6 = new Intent();
                    intent6.putExtra("Contact_User", MU.lct);
                    intent6.putExtra("Contact_Alias", MU.bLc);
                    intent6.putExtra("Contact_Nick", MU.cID);
                    intent6.putExtra("Contact_QuanPin", MU.cIF);
                    intent6.putExtra("Contact_PyInitial", MU.cIE);
                    intent6.putExtra("Contact_Uin", MU.hWq);
                    intent6.putExtra("Contact_Mobile_MD5", MU.nvG);
                    intent6.putExtra("Contact_full_Mobile_MD5", MU.nvH);
                    intent6.putExtra("Contact_QQNick", MU.bwI());
                    intent6.putExtra("User_From_Fmessage", false);
                    intent6.putExtra("Contact_Scene", MU.scene);
                    intent6.putExtra("Contact_FMessageCard", true);
                    intent6.putExtra("Contact_RemarkName", MU.cIJ);
                    intent6.putExtra("Contact_VUser_Info_Flag", MU.ldy);
                    intent6.putExtra("Contact_VUser_Info", MU.bCp);
                    intent6.putExtra("Contact_BrandIconURL", MU.hUf);
                    intent6.putExtra("Contact_Province", MU.getProvince());
                    intent6.putExtra("Contact_City", MU.getCity());
                    intent6.putExtra("Contact_Sex", MU.bBZ);
                    intent6.putExtra("Contact_Signature", MU.bCj);
                    intent6.putExtra("Contact_ShowUserName", false);
                    intent6.putExtra("Contact_KSnsIFlag", 0);
                    com.tencent.mm.ay.c.b(context2, "profile", ".ui.ContactInfoUI", intent6);
                    com.tencent.mm.az.a.uy(MU.scene);
                    return;
                default:
                    return;
            }
        }
    };
    private h.a iql;

    public b(h.a aVar, ac acVar) {
        this.iql = aVar;
        this.handler = acVar;
    }

    public final View cq(Context context) {
        View inflate = View.inflate(context, 2130904257, null);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(context, 75);
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
        return inflate;
    }

    private static String getAppName(Context context, String str) {
        com.tencent.mm.model.ab.b bVar = ab.a.csc;
        if (bVar != null) {
            return bVar.n(context, str);
        }
        return "";
    }

    public static boolean k(pw pwVar) {
        ajr HE = com.tencent.mm.ai.b.HE();
        return HE != null && HE.mJV == 6 && be.ah(pwVar.luu, "").equals(HE.mJW) && com.tencent.mm.ai.b.HC();
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        TextView textView = (TextView) view.findViewById(2131755226);
        TextView textView2 = (TextView) view.findViewById(2131757325);
        TextView textView3 = (TextView) view.findViewById(2131758848);
        MMImageView mMImageView = (MMImageView) view.findViewById(2131755225);
        ImageView imageView = (ImageView) view.findViewById(2131758847);
        imageView.setVisibility(8);
        View findViewById = view.findViewById(2131758844);
        findViewById.setVisibility(0);
        findViewById.setTag(bVar);
        findViewById.setOnClickListener(this.iqU);
        View findViewById2 = view.findViewById(2131758846);
        findViewById2.setVisibility(8);
        h.a.a aVar = new h.a.a();
        if (bVar.aKG == 0) {
            aVar.iqn = bVar.bao;
        } else if (bVar.aKG == 1) {
            aVar.iqn = bVar.ipT.field_localId;
        }
        aVar.bdF = mMImageView;
        aVar.bdE = bVar.bdE;
        aVar.height = this.fSr;
        aVar.width = this.fSr;
        pw pwVar;
        CharSequence appName;
        pw pwVar2;
        switch (bVar.bdE.aKG) {
            case 4:
            case am.CTRL_INDEX /*15*/:
                pwVar = bVar.bdE;
                if (be.kS(pwVar.title)) {
                    int i2 = pwVar.aKG;
                    textView.setText(2131232752);
                } else {
                    textView.setText(pwVar.title);
                }
                if (pwVar.duration <= 0) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(textView2.getContext().getString(2131232753, new Object[]{Integer.valueOf(pwVar.duration)}));
                }
                if (pwVar.msM == null) {
                    v.w("MicroMsg.OtherViewWrapper", "video, get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                    textView3.setVisibility(8);
                } else {
                    py pyVar = pwVar.msM.msY;
                    if (!be.kS(pyVar.appId)) {
                        appName = getAppName(textView3.getContext(), pyVar.appId);
                        if (be.kS(appName)) {
                            textView3.setVisibility(8);
                        } else {
                            textView3.setVisibility(0);
                            textView3.setText(appName);
                        }
                    }
                }
                imageView.setVisibility(0);
                imageView.setImageResource(2130839379);
                aVar.bdG = 2131165244;
                this.iql.a(aVar);
                break;
            case 5:
                pw pwVar3 = bVar.bdE;
                CharSequence charSequence = "";
                qp qpVar = null;
                if (!(pwVar3 == null || pwVar3.msM == null)) {
                    qpVar = pwVar3.msM.mtc;
                }
                if (qpVar != null) {
                    charSequence = qpVar.title;
                }
                if (be.kS(charSequence) && pwVar3 != null) {
                    charSequence = pwVar3.title;
                }
                if (be.kS(charSequence)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                }
                textView2.setVisibility(8);
                appName = "";
                if (qpVar != null) {
                    appName = be.KI(qpVar.mur);
                }
                py pyVar2 = null;
                if (!(pwVar3 == null || pwVar3.msM == null)) {
                    pyVar2 = pwVar3.msM.msY;
                }
                if (pyVar2 != null) {
                    if (!be.kS(pyVar2.appId)) {
                        appName = be.ah(getAppName(textView3.getContext(), pyVar2.appId), "");
                    } else if (!be.kS(pyVar2.aWH)) {
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(pyVar2.aWH);
                        if (LX == null || !LX.field_username.equals(pyVar2.aWH)) {
                            ab.a.crZ.a(pyVar2.aWH, "", null);
                        } else {
                            appName = LX.tU();
                        }
                    }
                    if (be.kS(appName) || appName.equals(pyVar2.aWH)) {
                        appName = be.KI(pyVar2.cZp);
                    }
                }
                if (be.kS(appName)) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setText(appName);
                    textView3.setVisibility(0);
                }
                aVar.bdG = 2130837647;
                this.iql.a(aVar);
                break;
            case 6:
                pwVar2 = bVar.bdE;
                if (pwVar2.msM == null) {
                    v.w("MicroMsg.OtherViewWrapper", "location, get data proto item null, dataid[%s]", new Object[]{pwVar2.luu});
                    textView.setText(2131232684);
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    qc qcVar = pwVar2.msM.mta;
                    if (be.kS(qcVar.bkV)) {
                        textView.setText(qcVar.label);
                        textView2.setText(2131232684);
                        textView3.setText("");
                    } else {
                        textView.setText(qcVar.bkV);
                        textView2.setText(qcVar.label);
                        textView3.setText(2131232684);
                    }
                }
                mMImageView.setImageResource(2131165231);
                break;
            case 7:
                textView.setText(bVar.bdE.title);
                textView2.setText(bVar.bdE.desc);
                imageView.setTag(bVar);
                imageView.setOnClickListener(this.fSC);
                imageView.setImageResource(2130838735);
                imageView.setVisibility(0);
                if (k(bVar.bdE)) {
                    imageView.setImageResource(2130838733);
                }
                textView3.setVisibility(8);
                aVar.bdG = 2131165232;
                this.iql.a(aVar);
                break;
            case 8:
                pwVar2 = bVar.bdE;
                textView.setText(pwVar2.title);
                if (pwVar2.mso) {
                    textView2.setVisibility(0);
                    textView2.setText(String.format("%.2f", new Object[]{Float.valueOf(((float) pwVar2.msn) / 1024.0f)}) + "KB");
                } else {
                    textView2.setVisibility(8);
                }
                textView3.setVisibility(8);
                mMImageView.setImageResource(com.tencent.mm.pluginsdk.c.Ga(bVar.bdE.msh));
                break;
            case 10:
                pwVar = bVar.bdE;
                if (pwVar.msM == null) {
                    v.w("MicroMsg.OtherViewWrapper", "product, get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    qe qeVar = pwVar.msM.mte;
                    textView.setText(qeVar.title);
                    textView2.setText(qeVar.desc);
                    textView3.setText(be.ah(getAppName(textView3.getContext(), pwVar.msM.msY.appId), textView3.getContext().getString(2131232706)));
                }
                aVar.bdG = 2131165241;
                this.iql.a(aVar);
                break;
            case 11:
                pwVar = bVar.bdE;
                if (pwVar.msM == null) {
                    v.w("MicroMsg.OtherViewWrapper", "mall product, get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    qe qeVar2 = pwVar.msM.mte;
                    textView.setText(qeVar2.title);
                    textView2.setText(qeVar2.desc);
                    textView.setSingleLine(false);
                    textView.setMaxLines(2);
                    textView3.setVisibility(8);
                }
                aVar.bdG = 2131165241;
                aVar.bdE = null;
                this.iql.a(aVar);
                break;
            case an.CTRL_INDEX /*14*/:
                pwVar = bVar.bdE;
                if (pwVar.msM == null || pwVar.msM.mtg == null) {
                    v.w("MicroMsg.OtherViewWrapper", "tv, get data proto item null, dataid[%s]", new Object[]{pwVar.luu});
                    textView.setText("");
                    textView2.setText("");
                    textView3.setText("");
                } else {
                    qj qjVar = pwVar.msM.mtg;
                    textView.setText(qjVar.title);
                    textView2.setText(qjVar.desc);
                    textView3.setText(be.ah(getAppName(textView3.getContext(), pwVar.msM.msY.appId), textView3.getContext().getString(2131232748)));
                }
                aVar.bdG = 2131165241;
                aVar.bdE = null;
                this.iql.a(aVar);
                break;
            case 16:
                pwVar2 = bVar.bdE;
                ak.yW();
                at.a MU = com.tencent.mm.model.c.wJ().MU(pwVar2.desc);
                if (MU == null) {
                    v.e("MicroMsg.OtherViewWrapper", "parse possible friend msg failed");
                }
                textView.setText(e.a(textView.getContext(), MU.cID, textView.getTextSize()));
                textView2.setVisibility(8);
                textView3.setText(2131232671);
                textView3.setVisibility(0);
                String str = MU.lct;
                if (!be.kS(str)) {
                    com.tencent.mm.pluginsdk.ui.a.b.m(mMImageView, str);
                    break;
                } else {
                    mMImageView.setImageResource(2130838080);
                    break;
                }
            default:
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
                return;
        }
        textView3.setVisibility(8);
    }

    public final void destroy() {
        v.d("MicroMsg.OtherViewWrapper", "do destroy");
        this.iql = null;
        this.handler = null;
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        this.iqT = false;
    }
}
