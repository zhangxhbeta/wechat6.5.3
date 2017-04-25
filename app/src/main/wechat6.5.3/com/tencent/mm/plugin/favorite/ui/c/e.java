package com.tencent.mm.plugin.favorite.ui.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.ai.b;
import com.tencent.mm.e.a.ja;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.p;
import com.tencent.mm.plugin.favorite.b.t;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteFileDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteImgDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteSightDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteTextDetailUI;
import com.tencent.mm.plugin.favorite.ui.detail.FavoriteVoiceDetailUI;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.pz;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.protocal.c.qe;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e {
    private static int[] fSx = new int[]{2131756248, 2131756249, 2131756250, 2131756251, 2131756252};

    public static void b(Context context, i iVar) {
        String str = null;
        if (context == null) {
            v.w("MicroMsg.FavItemLogic", "Context is null");
        } else if (iVar == null) {
            v.w("MicroMsg.FavItemLogic", "Fav item is null");
        } else {
            v.i("MicroMsg.FavItemLogic", "Handler favItemInfo id %d, type %d", new Object[]{Long.valueOf(iVar.field_localId), Integer.valueOf(iVar.field_type)});
            Intent intent;
            String str2;
            Intent intent2;
            String er;
            long j;
            switch (iVar.field_type) {
                case ai.CTRL_INDEX /*-2*/:
                    Toast.makeText(context, 2131232749, 0).show();
                    return;
                case 1:
                    Intent intent3 = new Intent(context, FavoriteTextDetailUI.class);
                    intent3.putExtra("key_detail_text", iVar.field_favProto.desc);
                    intent3.putExtra("key_detail_info_id", iVar.field_localId);
                    intent3.putExtra("key_detail_can_share_to_friend", iVar.aly());
                    intent3.putExtra("key_detail_time", iVar.field_updateTime);
                    intent3.putExtra("key_detail_create_time", iVar.field_sourceCreateTime <= 0 ? iVar.field_updateTime : iVar.field_sourceCreateTime);
                    context.startActivity(intent3);
                    return;
                case 2:
                    d(context, iVar);
                    return;
                case 3:
                    intent = new Intent(context, FavoriteVoiceDetailUI.class);
                    intent.putExtra("key_detail_info_id", iVar.field_localId);
                    intent.putExtra("key_detail_create_time", iVar.field_favProto.mtP.dhH);
                    context.startActivity(intent);
                    return;
                case 4:
                    c(context, iVar);
                    return;
                case 5:
                    List list;
                    qg qgVar;
                    String str3;
                    Bundle bundle;
                    Bundle bundle2;
                    if (iVar.field_favProto != null) {
                        if (iVar.field_favProto.mtc == null || be.kS(iVar.field_favProto.mtc.canvasPageXml)) {
                            list = iVar.field_favProto.mtR;
                            if (list != null && list.size() == 1) {
                                str2 = ((pw) list.get(0)).canvasPageXml;
                                if (be.kS(str2)) {
                                    qgVar = iVar.field_favProto.mtP;
                                    str2 = "";
                                    if (iVar.field_favProto.mtc != null) {
                                        str2 = iVar.field_favProto.mtc.mur;
                                    }
                                    if (qgVar != null && be.kS(r0)) {
                                        str2 = qgVar.cZp;
                                    }
                                    if (be.kS(str2)) {
                                        v.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                                        intent2 = new Intent();
                                        intent2.putExtra("rawUrl", str2);
                                        intent2.putExtra("is_favorite_item", true);
                                        intent2.putExtra("fav_local_id", iVar.field_localId);
                                        str3 = "favorite_control_argument";
                                        bundle = new Bundle();
                                        bundle.putBoolean("key_ctrl_flag_open_chat", iVar.aly());
                                        bundle.putBoolean("key_ctrl_flag_open_sns", iVar.alz());
                                        bundle.putBoolean("key_ctrl_flag_open_weibo", (iVar.field_favProto.mtl & 4) != 0);
                                        bundle.putBoolean("key_ctrl_flag_open_cplink", (iVar.field_favProto.mtl & 8) != 0);
                                        bundle.putBoolean("key_ctrl_flag_open_browser", (iVar.field_favProto.mtl & 16) != 0);
                                        bundle.putBoolean("key_ctrl_flag_open_weiyun", (iVar.field_favProto.mtl & 32) != 0);
                                        bundle.putBoolean("key_ctrl_flag_open_facebook", (iVar.field_favProto.mtl & 64) != 0);
                                        v.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                                        intent2.putExtra(str3, bundle);
                                        intent2.putExtra("sentUsername", iVar.field_fromUser);
                                        if (!(qgVar == null || be.kS(qgVar.aWH))) {
                                            intent2.putExtra("srcDisplayname", l.er(qgVar.aWH));
                                        }
                                        intent2.putExtra("mode", 1);
                                        intent2.putExtra("geta8key_scene", 14);
                                        bundle2 = new Bundle();
                                        bundle2.putString("key_snsad_statextstr", com.tencent.mm.plugin.favorite.b.v.n(iVar).bnY);
                                        intent2.putExtra("jsapiargs", bundle2);
                                        intent2.putExtra("from_scence", 4);
                                        str2 = "fav_" + k.xF() + "_" + iVar.field_id;
                                        intent2.putExtra("KPublisherId", str2);
                                        intent2.putExtra("pre_username", iVar.field_fromUser);
                                        intent2.putExtra("prePublishId", str2);
                                        intent2.putExtra("preUsername", iVar.field_fromUser);
                                        c.j(intent2, context);
                                        return;
                                    }
                                    return;
                                }
                                intent2 = new Intent();
                                intent2.putExtra("sns_landing_pages_xml", str2);
                                intent2.putExtra("sns_landig_pages_from_source", 7);
                                str3 = "sns_landing_pages_share_thumb_url";
                                if (iVar.field_favProto != null) {
                                    if (iVar.field_favProto.mtc != null || be.kS(iVar.field_favProto.mtc.canvasPageXml)) {
                                        list = iVar.field_favProto.mtR;
                                        if (list != null && list.size() == 1) {
                                            str = ((pw) list.get(0)).coj;
                                        }
                                    } else {
                                        str = iVar.field_favProto.mtc.bea;
                                    }
                                }
                                intent2.putExtra(str3, str);
                                intent2.putExtra("sns_landing_favid", k.xF() + "_" + iVar.field_id);
                                intent2.addFlags(268435456);
                                com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                                return;
                            }
                        }
                        str2 = iVar.field_favProto.mtc.canvasPageXml;
                        if (be.kS(str2)) {
                            qgVar = iVar.field_favProto.mtP;
                            str2 = "";
                            if (iVar.field_favProto.mtc != null) {
                                str2 = iVar.field_favProto.mtc.mur;
                            }
                            str2 = qgVar.cZp;
                            if (be.kS(str2)) {
                                v.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                                intent2 = new Intent();
                                intent2.putExtra("rawUrl", str2);
                                intent2.putExtra("is_favorite_item", true);
                                intent2.putExtra("fav_local_id", iVar.field_localId);
                                str3 = "favorite_control_argument";
                                bundle = new Bundle();
                                bundle.putBoolean("key_ctrl_flag_open_chat", iVar.aly());
                                bundle.putBoolean("key_ctrl_flag_open_sns", iVar.alz());
                                if ((iVar.field_favProto.mtl & 4) != 0) {
                                }
                                bundle.putBoolean("key_ctrl_flag_open_weibo", (iVar.field_favProto.mtl & 4) != 0);
                                if ((iVar.field_favProto.mtl & 8) != 0) {
                                }
                                bundle.putBoolean("key_ctrl_flag_open_cplink", (iVar.field_favProto.mtl & 8) != 0);
                                if ((iVar.field_favProto.mtl & 16) != 0) {
                                }
                                bundle.putBoolean("key_ctrl_flag_open_browser", (iVar.field_favProto.mtl & 16) != 0);
                                if ((iVar.field_favProto.mtl & 32) != 0) {
                                }
                                bundle.putBoolean("key_ctrl_flag_open_weiyun", (iVar.field_favProto.mtl & 32) != 0);
                                if ((iVar.field_favProto.mtl & 64) != 0) {
                                }
                                bundle.putBoolean("key_ctrl_flag_open_facebook", (iVar.field_favProto.mtl & 64) != 0);
                                v.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                                intent2.putExtra(str3, bundle);
                                intent2.putExtra("sentUsername", iVar.field_fromUser);
                                intent2.putExtra("srcDisplayname", l.er(qgVar.aWH));
                                intent2.putExtra("mode", 1);
                                intent2.putExtra("geta8key_scene", 14);
                                bundle2 = new Bundle();
                                bundle2.putString("key_snsad_statextstr", com.tencent.mm.plugin.favorite.b.v.n(iVar).bnY);
                                intent2.putExtra("jsapiargs", bundle2);
                                intent2.putExtra("from_scence", 4);
                                str2 = "fav_" + k.xF() + "_" + iVar.field_id;
                                intent2.putExtra("KPublisherId", str2);
                                intent2.putExtra("pre_username", iVar.field_fromUser);
                                intent2.putExtra("prePublishId", str2);
                                intent2.putExtra("preUsername", iVar.field_fromUser);
                                c.j(intent2, context);
                                return;
                            }
                            return;
                        }
                        intent2 = new Intent();
                        intent2.putExtra("sns_landing_pages_xml", str2);
                        intent2.putExtra("sns_landig_pages_from_source", 7);
                        str3 = "sns_landing_pages_share_thumb_url";
                        if (iVar.field_favProto != null) {
                            if (iVar.field_favProto.mtc != null) {
                                break;
                            }
                            list = iVar.field_favProto.mtR;
                            str = ((pw) list.get(0)).coj;
                            break;
                        }
                        intent2.putExtra(str3, str);
                        intent2.putExtra("sns_landing_favid", k.xF() + "_" + iVar.field_id);
                        intent2.addFlags(268435456);
                        com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                        return;
                    }
                    str2 = null;
                    if (be.kS(str2)) {
                        intent2 = new Intent();
                        intent2.putExtra("sns_landing_pages_xml", str2);
                        intent2.putExtra("sns_landig_pages_from_source", 7);
                        str3 = "sns_landing_pages_share_thumb_url";
                        if (iVar.field_favProto != null) {
                            if (iVar.field_favProto.mtc != null) {
                            }
                            list = iVar.field_favProto.mtR;
                            str = ((pw) list.get(0)).coj;
                        }
                        intent2.putExtra(str3, str);
                        intent2.putExtra("sns_landing_favid", k.xF() + "_" + iVar.field_id);
                        intent2.addFlags(268435456);
                        com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent2);
                        return;
                    }
                    qgVar = iVar.field_favProto.mtP;
                    str2 = "";
                    if (iVar.field_favProto.mtc != null) {
                        str2 = iVar.field_favProto.mtc.mur;
                    }
                    str2 = qgVar.cZp;
                    if (be.kS(str2)) {
                        v.d("MicroMsg.FavItemLogic", "start web view, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                        intent2 = new Intent();
                        intent2.putExtra("rawUrl", str2);
                        intent2.putExtra("is_favorite_item", true);
                        intent2.putExtra("fav_local_id", iVar.field_localId);
                        str3 = "favorite_control_argument";
                        bundle = new Bundle();
                        bundle.putBoolean("key_ctrl_flag_open_chat", iVar.aly());
                        bundle.putBoolean("key_ctrl_flag_open_sns", iVar.alz());
                        if ((iVar.field_favProto.mtl & 4) != 0) {
                        }
                        bundle.putBoolean("key_ctrl_flag_open_weibo", (iVar.field_favProto.mtl & 4) != 0);
                        if ((iVar.field_favProto.mtl & 8) != 0) {
                        }
                        bundle.putBoolean("key_ctrl_flag_open_cplink", (iVar.field_favProto.mtl & 8) != 0);
                        if ((iVar.field_favProto.mtl & 16) != 0) {
                        }
                        bundle.putBoolean("key_ctrl_flag_open_browser", (iVar.field_favProto.mtl & 16) != 0);
                        if ((iVar.field_favProto.mtl & 32) != 0) {
                        }
                        bundle.putBoolean("key_ctrl_flag_open_weiyun", (iVar.field_favProto.mtl & 32) != 0);
                        if ((iVar.field_favProto.mtl & 64) != 0) {
                        }
                        bundle.putBoolean("key_ctrl_flag_open_facebook", (iVar.field_favProto.mtl & 64) != 0);
                        v.i("MicroMsg.FavItemInfo", "get ctrl args=[%s]", new Object[]{bundle.toString()});
                        intent2.putExtra(str3, bundle);
                        intent2.putExtra("sentUsername", iVar.field_fromUser);
                        intent2.putExtra("srcDisplayname", l.er(qgVar.aWH));
                        intent2.putExtra("mode", 1);
                        intent2.putExtra("geta8key_scene", 14);
                        bundle2 = new Bundle();
                        bundle2.putString("key_snsad_statextstr", com.tencent.mm.plugin.favorite.b.v.n(iVar).bnY);
                        intent2.putExtra("jsapiargs", bundle2);
                        intent2.putExtra("from_scence", 4);
                        str2 = "fav_" + k.xF() + "_" + iVar.field_id;
                        intent2.putExtra("KPublisherId", str2);
                        intent2.putExtra("pre_username", iVar.field_fromUser);
                        intent2.putExtra("prePublishId", str2);
                        intent2.putExtra("preUsername", iVar.field_fromUser);
                        c.j(intent2, context);
                        return;
                    }
                    return;
                case 6:
                    qc qcVar = iVar.field_favProto.mta;
                    String str4 = iVar.field_favProto.gxy;
                    qg qgVar2 = iVar.field_favProto.mtP;
                    er = (qgVar2 == null || be.kS(qgVar2.mtu)) ? l.er(iVar.field_fromUser) : l.er(qgVar2.mtu);
                    ArrayList arrayList = new ArrayList();
                    if (iVar.field_tagProto.mub != null) {
                        arrayList.addAll(iVar.field_tagProto.mub);
                    }
                    c.a(iVar.field_localId, qcVar, er, str4, arrayList, context);
                    return;
                case 7:
                    String absolutePath;
                    qg qgVar3 = iVar.field_favProto.mtP;
                    pw n = com.tencent.mm.plugin.favorite.b.v.n(iVar);
                    File file = new File(com.tencent.mm.plugin.favorite.b.v.g(n));
                    if (file.exists()) {
                        absolutePath = file.getAbsolutePath();
                    } else if (n.aZh == null) {
                        absolutePath = "";
                    } else {
                        file = new File(com.tencent.mm.plugin.favorite.b.v.alQ() + g.m(n.aZh.getBytes()));
                        absolutePath = file.exists() ? file.getAbsolutePath() : "";
                    }
                    b.b(b.a(6, null, n.title, n.desc, n.mrZ, n.msd, n.msb, n.luu, com.tencent.mm.plugin.favorite.b.v.alS(), absolutePath, qgVar3.appId));
                    intent = new Intent();
                    intent.putExtra("key_scene", 2);
                    com.tencent.mm.ay.c.b(context, "music", ".ui.MusicMainUI", intent);
                    return;
                case 8:
                    pw n2 = com.tencent.mm.plugin.favorite.b.v.n(iVar);
                    if (com.tencent.mm.plugin.favorite.b.v.c(n2)) {
                        if (com.tencent.mm.plugin.favorite.b.v.d(n2)) {
                            d(context, iVar);
                            return;
                        } else if (!a.b((Activity) context, com.tencent.mm.plugin.favorite.b.v.f(n2), n2.msh, 2)) {
                            return;
                        }
                    }
                    intent = new Intent(context, FavoriteFileDetailUI.class);
                    intent.putExtra("key_detail_info_id", iVar.field_localId);
                    context.startActivity(intent);
                    return;
                case 10:
                    v.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                    j = iVar.field_localId;
                    er = iVar.field_favProto.mte.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_Product_xml", er);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    intent2.putExtra("key_ProductUI_getProductInfoScene", 3);
                    com.tencent.mm.ay.c.b(context, "scanner", ".ui.ProductUI", intent2);
                    return;
                case 11:
                    v.d("MicroMsg.FavItemLogic", "start product ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                    intent = new Intent();
                    intent.putExtra("key_product_scene", 4);
                    intent.putExtra("key_product_info", iVar.field_favProto.mte.info);
                    com.tencent.mm.ay.c.b(context, "product", ".ui.MallProductUI", intent);
                    return;
                case 12:
                case am.CTRL_INDEX /*15*/:
                    v.d("MicroMsg.FavItemLogic", "start tv ui, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                    j = iVar.field_localId;
                    er = iVar.field_favProto.mtg.info;
                    intent2 = new Intent();
                    intent2.putExtra("key_TV_getProductInfoScene", 3);
                    intent2.putExtra("key_is_favorite_item", true);
                    intent2.putExtra("key_favorite_local_id", j);
                    intent2.putExtra("key_TV_xml", er);
                    intent2.putExtra("key_can_delete_favorite_item", true);
                    com.tencent.mm.ay.c.b(context, "shake", ".ui.TVInfoUI", intent2);
                    return;
                case an.CTRL_INDEX /*14*/:
                    intent = new Intent();
                    intent.putExtra("key_detail_info_id", iVar.field_localId);
                    com.tencent.mm.ay.c.b(context, "record", ".ui.FavRecordDetailUI", intent);
                    return;
                case 16:
                    pw n3 = com.tencent.mm.plugin.favorite.b.v.n(iVar);
                    if (n3 == null || n3.msS == null || (be.kS(n3.msS.cqg) && be.kS(n3.msS.cqk))) {
                        c(context, iVar);
                        return;
                    }
                    v.i("MicroMsg.FavItemLogic", "it is ad sight.");
                    t.a(t.a.PlayIcon, iVar);
                    intent = new Intent(context, FavoriteSightDetailUI.class);
                    intent.putExtra("key_detail_info_id", iVar.field_localId);
                    context.startActivity(intent);
                    return;
                case 17:
                    str2 = com.tencent.mm.plugin.favorite.b.v.n(iVar).desc;
                    ak.yW();
                    at.a MU = com.tencent.mm.model.c.wJ().MU(str2);
                    if (MU != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("Contact_User", MU.lct);
                        intent4.putExtra("Contact_Alias", MU.bLc);
                        intent4.putExtra("Contact_Nick", MU.cID);
                        intent4.putExtra("Contact_QuanPin", MU.cIF);
                        intent4.putExtra("Contact_PyInitial", MU.cIE);
                        intent4.putExtra("Contact_Uin", MU.hWq);
                        intent4.putExtra("Contact_Mobile_MD5", MU.nvG);
                        intent4.putExtra("Contact_full_Mobile_MD5", MU.nvH);
                        intent4.putExtra("Contact_QQNick", MU.bwI());
                        intent4.putExtra("User_From_Fmessage", false);
                        intent4.putExtra("Contact_Scene", MU.scene);
                        intent4.putExtra("Contact_FMessageCard", true);
                        intent4.putExtra("Contact_RemarkName", MU.cIJ);
                        intent4.putExtra("Contact_VUser_Info_Flag", MU.ldy);
                        intent4.putExtra("Contact_VUser_Info", MU.bCp);
                        intent4.putExtra("Contact_BrandIconURL", MU.hUf);
                        intent4.putExtra("Contact_Province", MU.getProvince());
                        intent4.putExtra("Contact_City", MU.getCity());
                        intent4.putExtra("Contact_Sex", MU.bBZ);
                        intent4.putExtra("Contact_Signature", MU.bCj);
                        intent4.putExtra("Contact_ShowUserName", false);
                        intent4.putExtra("Contact_KSnsIFlag", 0);
                        com.tencent.mm.ay.c.b(context, "profile", ".ui.ContactInfoUI", intent4);
                        com.tencent.mm.az.a.uy(MU.scene);
                        return;
                    }
                    return;
                case 18:
                    v.i("MicroMsg.FavItemLogic", "click WNNoteItem, handleWNNoteItem");
                    jb jbVar = new jb();
                    jbVar.bjB.type = 3;
                    jbVar.bjB.bjy = 2;
                    com.tencent.mm.sdk.c.a.nhr.z(jbVar);
                    ja jaVar = new ja();
                    jaVar.bjr.field_localId = iVar.field_localId;
                    jaVar.bjr.bjt = iVar.field_xml;
                    jaVar.bjr.context = context;
                    jaVar.bjr.type = 2;
                    com.tencent.mm.sdk.c.a.nhr.z(jaVar);
                    return;
                default:
                    v.w("MicroMsg.FavItemLogic", "Do not match any type %d", new Object[]{Integer.valueOf(iVar.field_type)});
                    return;
            }
        }
    }

    public static boolean k(pw pwVar) {
        ajr HE = b.HE();
        return HE != null && HE.mJV == 6 && be.ah(pwVar.luu, "").equals(HE.mJW) && b.HC();
    }

    private static void c(Context context, i iVar) {
        boolean z;
        pw n = com.tencent.mm.plugin.favorite.b.v.n(iVar);
        pz pzVar = n.msS;
        if (pzVar == null || be.kS(pzVar.cqg)) {
            z = false;
        } else {
            t.a(t.a.EnterCompleteVideo, iVar);
            String g = com.tencent.mm.plugin.favorite.b.v.g(n);
            Intent intent = new Intent();
            intent.putExtra("IsAd", false);
            intent.putExtra("KStremVideoUrl", pzVar.cqg);
            intent.putExtra("StreamWording", pzVar.cqj);
            intent.putExtra("StremWebUrl", pzVar.cqk);
            intent.putExtra("KThumUrl", pzVar.cql);
            intent.putExtra("KSta_StremVideoAduxInfo", pzVar.cqm);
            intent.putExtra("KSta_StremVideoPublishId", pzVar.cqn);
            intent.putExtra("KSta_SourceType", 2);
            intent.putExtra("KSta_Scene", t.b.Fav.value);
            intent.putExtra("KSta_FromUserName", iVar.field_fromUser);
            intent.putExtra("KSta_FavID", iVar.field_id);
            intent.putExtra("KSta_SnsStatExtStr", n.bnY);
            intent.putExtra("KBlockFav", true);
            intent.putExtra("KMediaId", "fakeid_" + iVar.field_id);
            intent.putExtra("KThumbPath", g);
            intent.putExtra("KMediaVideoTime", pzVar.mtD);
            intent.putExtra("KMediaTitle", pzVar.cqi);
            com.tencent.mm.ay.c.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
            z = true;
        }
        if (!z) {
            if (be.kS(n.msj) || n.msn <= 0) {
                v.w("MicroMsg.FavItemLogic", "full md5[%s], fullsize[%d], start use url", new Object[]{n.msj, Long.valueOf(n.msn)});
                String str = com.tencent.mm.plugin.favorite.b.v.n(iVar).mrZ;
                if (be.kS(str)) {
                    str = com.tencent.mm.plugin.favorite.b.v.n(iVar).msd;
                }
                if (be.kS(str)) {
                    v.w("MicroMsg.FavItemLogic", "onClick video url null, return");
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("is_favorite_item", true);
                intent2.putExtra("fav_local_id", iVar.field_localId);
                intent2.putExtra("geta8key_scene", 14);
                v.d("MicroMsg.FavItemLogic", "start video webview, fav id %d, fav local id %d", new Object[]{Integer.valueOf(iVar.field_id), Long.valueOf(iVar.field_localId)});
                c.j(intent2, context);
                return;
            }
            Intent intent3 = new Intent(context, FavoriteFileDetailUI.class);
            intent3.putExtra("key_detail_info_id", iVar.field_localId);
            context.startActivity(intent3);
        }
    }

    public static void d(Context context, i iVar) {
        Intent intent = new Intent(context, FavoriteImgDetailUI.class);
        intent.putExtra("key_detail_info_id", iVar.field_localId);
        context.startActivity(intent);
    }

    public static String[] a(final i iVar, ac acVar) {
        String str = null;
        if (iVar == null) {
            v.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
            return null;
        }
        final pw n = com.tencent.mm.plugin.favorite.b.v.n(iVar);
        String[] strArr = new String[2];
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.favorite.b.v.b(iVar, n, true);
            }
        };
        qe qeVar;
        switch (iVar.field_type) {
            case 5:
                qp qpVar = iVar.field_favProto.mtc;
                if (n == null) {
                    if (qpVar != null) {
                        strArr[1] = qpVar.bea;
                        break;
                    }
                }
                String str2 = qpVar == null ? null : qpVar.bea;
                if (be.kS(str2)) {
                    str2 = n.aZh;
                }
                strArr[0] = com.tencent.mm.plugin.favorite.b.v.g(n);
                strArr[1] = str2;
                acVar.post(anonymousClass1);
                break;
                break;
            case 10:
                qeVar = iVar.field_favProto.mte;
                if (qeVar != null) {
                    strArr[1] = qeVar.bea;
                    break;
                }
                break;
            case 11:
                qeVar = iVar.field_favProto.mte;
                if (qeVar != null) {
                    strArr[1] = qeVar.bea;
                    break;
                }
                break;
            case an.CTRL_INDEX /*14*/:
            case 18:
                if (iVar.field_favProto.mtR != null) {
                    Iterator it = iVar.field_favProto.mtR.iterator();
                    while (it.hasNext()) {
                        pw pwVar = (pw) it.next();
                        if (pwVar.aKG == 2) {
                            str = com.tencent.mm.plugin.favorite.b.v.f(pwVar);
                            acVar.post(anonymousClass1);
                        } else if (pwVar.aKG == 15) {
                            str = com.tencent.mm.plugin.favorite.b.v.g(pwVar);
                            acVar.post(anonymousClass1);
                        }
                        strArr[0] = str;
                    }
                    strArr[0] = str;
                }
                strArr[1] = n.aZh;
                break;
            case am.CTRL_INDEX /*15*/:
                qj qjVar = iVar.field_favProto.mtg;
                if (qjVar != null) {
                    strArr[1] = qjVar.bea;
                    break;
                }
                break;
            default:
                if (n != null) {
                    strArr[0] = com.tencent.mm.plugin.favorite.b.v.g(n);
                    strArr[1] = n.aZh;
                    acVar.post(anonymousClass1);
                    break;
                }
                break;
        }
        v.d("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath thumbPath %s, thumbUrl %s, type %d", new Object[]{strArr[0], strArr[1], Integer.valueOf(iVar.field_type)});
        return strArr;
    }

    public static void a(com.tencent.mm.pluginsdk.ui.applet.c.c cVar, Context context, i iVar) {
        String str = null;
        if (iVar == null || context == null) {
            v.w("MicroMsg.FavItemLogic", "getDisplayInfo favItemInfo is null");
            return;
        }
        String absolutePath;
        qp qpVar;
        pw n = com.tencent.mm.plugin.favorite.b.v.n(iVar);
        if (iVar == null) {
            v.w("MicroMsg.FavItemLogic", "GetThumbUrlAndLocalPath favItemInfo is null");
        } else {
            pw n2 = com.tencent.mm.plugin.favorite.b.v.n(iVar);
            File file;
            qp qpVar2;
            if (5 == iVar.field_type) {
                file = new File(com.tencent.mm.plugin.favorite.b.v.g(n2));
                if (file.exists()) {
                    absolutePath = file.getAbsolutePath();
                } else {
                    qpVar2 = iVar.field_favProto.mtc;
                    absolutePath = qpVar2 == null ? null : qpVar2.bea;
                    if (be.kS(absolutePath)) {
                        absolutePath = n2.aZh;
                    }
                    absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(absolutePath);
                    if (be.kS(absolutePath)) {
                        absolutePath = Integer.valueOf(2131165247);
                    }
                }
            } else {
                if (11 == iVar.field_type || 10 == iVar.field_type) {
                    qe qeVar = iVar.field_favProto.mte;
                    if (qeVar != null) {
                        absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(qeVar.bea);
                        if (be.kS(absolutePath)) {
                            absolutePath = Integer.valueOf(2131165241);
                        }
                    }
                }
                if (15 == iVar.field_type || 12 == iVar.field_type) {
                    qj qjVar = iVar.field_favProto.mtg;
                    if (qjVar != null) {
                        absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(qjVar.bea);
                        if (be.kS(absolutePath)) {
                            absolutePath = Integer.valueOf(2131165241);
                        }
                    }
                }
                if (2 == iVar.field_type || 7 == iVar.field_type || 16 == iVar.field_type || 4 == iVar.field_type) {
                    file = new File(com.tencent.mm.plugin.favorite.b.v.g(n2));
                    if (!file.exists()) {
                        absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(n2.aZh);
                        if (be.kS(absolutePath)) {
                            com.tencent.mm.plugin.favorite.b.v.b(iVar, n2, true);
                            absolutePath = com.tencent.mm.plugin.favorite.b.v.g(n2);
                        }
                        if (be.kS(absolutePath)) {
                            switch (iVar.field_type) {
                                case 2:
                                    absolutePath = Integer.valueOf(2130837647);
                                    break;
                                case 7:
                                    absolutePath = Integer.valueOf(2131165232);
                                    break;
                                default:
                                    absolutePath = Integer.valueOf(2131165244);
                                    break;
                            }
                        }
                    }
                    absolutePath = file.getAbsolutePath();
                } else if (!(3 == iVar.field_type || 6 == iVar.field_type)) {
                    if (8 == iVar.field_type) {
                        absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.Ga(n2.msh));
                    } else if (17 == iVar.field_type) {
                        ak.yW();
                        r2 = com.tencent.mm.model.c.wJ().MU(n2.desc);
                        absolutePath = (r2.lct == null || r2.lct.length() == 0) ? Integer.valueOf(2130838080) : new SpannableString(r2.lct);
                    } else if (14 == iVar.field_type && iVar.field_favProto.mtR != null) {
                        Iterator it = iVar.field_favProto.mtR.iterator();
                        while (it.hasNext()) {
                            pw pwVar = (pw) it.next();
                            if (pwVar.aKG != 1) {
                                if (pwVar.aKG == 3) {
                                    absolutePath = Integer.valueOf(2131165246);
                                    break;
                                } else if (pwVar.aKG == 6) {
                                    absolutePath = Integer.valueOf(2131165231);
                                    break;
                                } else if (pwVar.aKG == 8) {
                                    absolutePath = Integer.valueOf(com.tencent.mm.pluginsdk.c.Ga(pwVar.msh));
                                    break;
                                } else if (pwVar.aKG == 2 || pwVar.aKG == 7 || pwVar.aKG == 15 || pwVar.aKG == 4) {
                                    file = new File(com.tencent.mm.plugin.favorite.b.v.g(pwVar));
                                    if (file.exists()) {
                                        absolutePath = file.getAbsolutePath();
                                    } else {
                                        String sV = com.tencent.mm.plugin.favorite.b.v.sV(pwVar.aZh);
                                        if (be.kS(sV)) {
                                            switch (pwVar.aKG) {
                                                case 2:
                                                    absolutePath = Integer.valueOf(2130837647);
                                                    break;
                                                case 7:
                                                    absolutePath = Integer.valueOf(2131165232);
                                                    break;
                                                default:
                                                    absolutePath = Integer.valueOf(2131165244);
                                                    break;
                                            }
                                        }
                                        absolutePath = sV;
                                    }
                                } else if (pwVar.aKG == 5) {
                                    File file2 = new File(com.tencent.mm.plugin.favorite.b.v.g(pwVar));
                                    if (file2.exists()) {
                                        absolutePath = file2.getAbsolutePath();
                                    } else {
                                        qpVar2 = pwVar.msM.mtc;
                                        absolutePath = qpVar2 == null ? null : qpVar2.bea;
                                        if (be.kS(absolutePath)) {
                                            absolutePath = n2.aZh;
                                        }
                                        absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(absolutePath);
                                        if (be.kS(absolutePath)) {
                                            absolutePath = Integer.valueOf(2131165247);
                                        }
                                    }
                                } else {
                                    if (pwVar.aKG == 10 || pwVar.aKG == 11) {
                                        qe qeVar2 = pwVar.msM.mte;
                                        if (qeVar2 != null) {
                                            absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(qeVar2.bea);
                                            if (be.kS(absolutePath)) {
                                                absolutePath = Integer.valueOf(2131165241);
                                            }
                                        }
                                    }
                                    if (pwVar.aKG == 12 || pwVar.aKG == 14) {
                                        qj qjVar2 = pwVar.msM.mtg;
                                        if (qjVar2 != null) {
                                            absolutePath = com.tencent.mm.plugin.favorite.b.v.sV(qjVar2.bea);
                                            if (be.kS(absolutePath)) {
                                                absolutePath = Integer.valueOf(2131165241);
                                            }
                                        }
                                    }
                                    if (pwVar.aKG == 16) {
                                        ak.yW();
                                        r2 = com.tencent.mm.model.c.wJ().MU(pwVar.desc);
                                        absolutePath = (r2.lct == null || r2.lct.length() == 0) ? Integer.valueOf(2130838080) : new SpannableString(r2.lct);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (absolutePath instanceof String) {
                if (absolutePath instanceof Integer) {
                    ((Integer) absolutePath).intValue();
                }
                absolutePath = null;
            } else {
                absolutePath = absolutePath;
            }
            qpVar = iVar.field_favProto.mtc;
            switch (iVar.field_type) {
                case 1:
                    cVar.Hw(iVar.field_favProto.desc);
                    cVar.bph();
                    return;
                case 2:
                    cVar.a(d.JV(absolutePath), 3);
                    return;
                case 4:
                    cVar.a(d.JV(absolutePath), 2);
                    return;
                case 5:
                    if (qpVar != null || be.kS(qpVar.title)) {
                        absolutePath = null;
                    } else {
                        absolutePath = qpVar.title;
                        str = qpVar.desc;
                    }
                    if (be.kS(absolutePath)) {
                        absolutePath = n.title;
                    }
                    if (be.kS(str)) {
                        str = n.desc;
                    }
                    cVar.Hw(new StringBuffer(context.getResources().getString(2131231171)).append(absolutePath).toString());
                    return;
                case 6:
                    cVar.Hw(context.getString(2131231086) + iVar.field_favProto.mta.label);
                    return;
                case 7:
                    if (!(qpVar == null || be.kS(qpVar.title))) {
                        str = qpVar.title;
                    }
                    if (be.kS(str)) {
                        str = n.title;
                    }
                    cVar.Hw(new StringBuffer(context.getResources().getString(2131231095)).append(str).toString());
                    return;
                case 8:
                    absolutePath = iVar.field_favProto.title;
                    if (be.kS(absolutePath)) {
                        absolutePath = n.title;
                    }
                    cVar.Hw(new StringBuffer(context.getResources().getString(2131231063)).append(absolutePath).toString());
                    return;
                case an.CTRL_INDEX /*14*/:
                    cVar.Hw(new StringBuffer(context.getResources().getString(2131231138)).append(p.a.a(context, iVar).title).toString());
                    return;
                case 16:
                    cVar.a(d.JV(absolutePath), 2);
                    return;
                case 18:
                    cVar.Hw(new StringBuffer(context.getResources().getString(2131231106)).append(p.a.a(context, iVar).desc.replaceAll("\n", " ")).toString());
                    return;
                default:
                    if (!(qpVar == null || be.kS(qpVar.title))) {
                        str = qpVar.title;
                    }
                    if (be.kS(str)) {
                        str = n.title;
                    }
                    cVar.Hw(new StringBuffer(context.getResources().getString(2131230904)).append(str).toString());
                    return;
            }
        }
        absolutePath = null;
        if (absolutePath instanceof String) {
            if (absolutePath instanceof Integer) {
                ((Integer) absolutePath).intValue();
            }
            absolutePath = null;
        } else {
            absolutePath = absolutePath;
        }
        qpVar = iVar.field_favProto.mtc;
        switch (iVar.field_type) {
            case 1:
                cVar.Hw(iVar.field_favProto.desc);
                cVar.bph();
                return;
            case 2:
                cVar.a(d.JV(absolutePath), 3);
                return;
            case 4:
                cVar.a(d.JV(absolutePath), 2);
                return;
            case 5:
                if (qpVar != null) {
                    break;
                }
                absolutePath = null;
                if (be.kS(absolutePath)) {
                    absolutePath = n.title;
                }
                if (be.kS(str)) {
                    str = n.desc;
                }
                cVar.Hw(new StringBuffer(context.getResources().getString(2131231171)).append(absolutePath).toString());
                return;
            case 6:
                cVar.Hw(context.getString(2131231086) + iVar.field_favProto.mta.label);
                return;
            case 7:
                str = qpVar.title;
                if (be.kS(str)) {
                    str = n.title;
                }
                cVar.Hw(new StringBuffer(context.getResources().getString(2131231095)).append(str).toString());
                return;
            case 8:
                absolutePath = iVar.field_favProto.title;
                if (be.kS(absolutePath)) {
                    absolutePath = n.title;
                }
                cVar.Hw(new StringBuffer(context.getResources().getString(2131231063)).append(absolutePath).toString());
                return;
            case an.CTRL_INDEX /*14*/:
                cVar.Hw(new StringBuffer(context.getResources().getString(2131231138)).append(p.a.a(context, iVar).title).toString());
                return;
            case 16:
                cVar.a(d.JV(absolutePath), 2);
                return;
            case 18:
                cVar.Hw(new StringBuffer(context.getResources().getString(2131231106)).append(p.a.a(context, iVar).desc.replaceAll("\n", " ")).toString());
                return;
            default:
                str = qpVar.title;
                if (be.kS(str)) {
                    str = n.title;
                }
                cVar.Hw(new StringBuffer(context.getResources().getString(2131230904)).append(str).toString());
                return;
        }
    }
}
