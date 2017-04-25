package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.protocal.c.abh;
import com.tencent.mm.protocal.c.an;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.protocal.c.bcv;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.protocal.c.jg;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.protocal.c.nd;
import com.tencent.mm.protocal.c.ne;
import com.tencent.mm.protocal.c.qt;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    public static ArrayList<ShareCardInfo> ql(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardInfoParser", "parseShareCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_list");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                v.e("MicroMsg.CardInfoParser", "parseShareCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<ShareCardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                ShareCardInfo shareCardInfo = new ShareCardInfo();
                a(shareCardInfo, optJSONObject);
                arrayList.add(shareCardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(ShareCardInfo shareCardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
            return;
        }
        try {
            a(shareCardInfo, new JSONObject(str).optJSONObject("share_card"));
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
            v.e("MicroMsg.CardInfoParser", e.getMessage());
        }
    }

    public static void a(ShareCardInfo shareCardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserShareCardItemJson json is null");
            return;
        }
        shareCardInfo.field_card_id = qn(jSONObject.optString("card_id"));
        shareCardInfo.field_card_tp_id = qn(jSONObject.optString("card_tp_id"));
        shareCardInfo.field_app_id = jSONObject.optString("app_id");
        shareCardInfo.field_consumer = jSONObject.optString("consumer");
        shareCardInfo.field_share_time = (long) jSONObject.optInt("share_time");
        shareCardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        shareCardInfo.field_status = jSONObject.optInt("state_flag");
        shareCardInfo.field_updateSeq = jSONObject.optLong("sequence");
        shareCardInfo.field_from_username = jSONObject.optString("from_user_name");
        shareCardInfo.field_begin_time = jSONObject.optLong("begin_time");
        shareCardInfo.field_end_time = (long) jSONObject.optInt("end_time");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        shareCardInfo.eCw = h(optJSONObject);
        shareCardInfo.eCv = i(optJSONObject2);
        shareCardInfo.eCx = j(optJSONObject3);
        if (shareCardInfo.eCw != null) {
            shareCardInfo.a(shareCardInfo.eCw);
        }
        if (shareCardInfo.eCv != null) {
            jc jcVar = shareCardInfo.eCv;
            shareCardInfo.eCv = jcVar;
            try {
                shareCardInfo.field_cardTpInfoData = jcVar.toByteArray();
            } catch (Exception e) {
                v.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            shareCardInfo.field_end_time = (long) optJSONObject2.optInt("end_time");
            shareCardInfo.field_begin_time = (long) optJSONObject2.optInt("begin_time");
        }
        if (shareCardInfo.eCx != null) {
            auu com_tencent_mm_protocal_c_auu = shareCardInfo.eCx;
            shareCardInfo.eCx = com_tencent_mm_protocal_c_auu;
            try {
                shareCardInfo.field_shareInfoData = com_tencent_mm_protocal_c_auu.toByteArray();
            } catch (Throwable e2) {
                v.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                v.a("MicroMsg.ShareCardInfo", e2, "", new Object[0]);
            }
        }
        shareCardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    public static ArrayList<CardInfo> qm(String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardInfoParser", "parseCardArray jsonContent is null");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("card_array");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                v.e("MicroMsg.CardInfoParser", "parseCardArray cardItemListJson is null");
                return null;
            }
            ArrayList<CardInfo> arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                CardInfo cardInfo = new CardInfo();
                a(cardInfo, optJSONObject);
                arrayList.add(cardInfo);
            }
            return arrayList;
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
            return null;
        }
    }

    public static void a(CardInfo cardInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            v.e("MicroMsg.CardInfoParser", "parserCardItemJson jsonContent is null");
            return;
        }
        try {
            a(cardInfo, new JSONObject(str));
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
    }

    private static void a(CardInfo cardInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserCardItemJson json is null");
            return;
        }
        cardInfo.field_card_id = qn(jSONObject.optString("card_id"));
        cardInfo.field_card_tp_id = qn(jSONObject.optString("card_tp_id"));
        cardInfo.field_delete_state_flag = jSONObject.optInt("state_flag");
        cardInfo.field_updateTime = (long) jSONObject.optInt("update_time");
        cardInfo.field_updateSeq = jSONObject.optLong("sequence");
        cardInfo.field_from_username = jSONObject.optString("from_username");
        cardInfo.field_begin_time = jSONObject.optLong("begin_time", 0);
        cardInfo.field_end_time = jSONObject.optLong("end_time", 0);
        cardInfo.eBP = jSONObject.optString("encrypt_code");
        JSONObject optJSONObject = jSONObject.optJSONObject("card_data_info");
        JSONObject optJSONObject2 = jSONObject.optJSONObject("card_tp_info");
        JSONObject optJSONObject3 = jSONObject.optJSONObject("share_info");
        cardInfo.eCw = h(optJSONObject);
        cardInfo.eCv = i(optJSONObject2);
        cardInfo.eCx = j(optJSONObject3);
        if (cardInfo.eCv != null) {
            jc jcVar = cardInfo.eCv;
            cardInfo.eCv = jcVar;
            try {
                cardInfo.field_cardTpInfoData = jcVar.toByteArray();
            } catch (Exception e) {
                v.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            }
            cardInfo.field_block_mask = Integer.toString(cardInfo.eCv.mkU);
            cardInfo.field_card_type = cardInfo.eCv.eBL;
            if (TextUtils.isEmpty(cardInfo.field_card_tp_id)) {
                cardInfo.field_card_tp_id = cardInfo.eCv.eBK;
            }
            if (cardInfo.field_begin_time == 0 && optJSONObject2 != null) {
                cardInfo.field_begin_time = optJSONObject2.optLong("begin_time");
            }
            if (cardInfo.field_end_time == 0 && optJSONObject2 != null) {
                cardInfo.field_end_time = optJSONObject2.optLong("end_time");
            }
        }
        if (cardInfo.eCw != null) {
            cardInfo.a(cardInfo.eCw);
            cardInfo.field_status = cardInfo.eCw.status;
        }
        if (cardInfo.eCx != null) {
            auu com_tencent_mm_protocal_c_auu = cardInfo.eCx;
            cardInfo.eCx = com_tencent_mm_protocal_c_auu;
            try {
                cardInfo.field_shareInfoData = com_tencent_mm_protocal_c_auu.toByteArray();
            } catch (Throwable e2) {
                v.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[]{e2.getMessage()});
                v.a("MicroMsg.CardInfo", e2, "", new Object[0]);
            }
        }
        cardInfo.field_local_updateTime = (long) ((int) (System.currentTimeMillis() / 1000));
    }

    private static String qn(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return "";
        }
        return str;
    }

    private static iu h(JSONObject jSONObject) {
        LinkedList linkedList = null;
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserCardDataInfo json is null");
            return null;
        }
        iu iuVar = new iu();
        try {
            iuVar.status = jSONObject.optInt(DownloadInfo.STATUS);
            iuVar.mkg = jSONObject.optInt("init_balance");
            iuVar.mkh = jSONObject.optInt("init_bonus");
            JSONArray optJSONArray = jSONObject.optJSONArray("cell_list0");
            if (optJSONArray != null) {
                iuVar.mki = i(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list1");
            if (optJSONArray != null) {
                iuVar.mkj = i(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("cell_list2");
            if (optJSONArray != null) {
                iuVar.mkk = i(optJSONArray);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("acceptors");
            if (optJSONArray2 != null) {
                if (!(optJSONArray2 == null || optJSONArray2.length() == 0)) {
                    LinkedList linkedList2 = new LinkedList();
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        linkedList2.add((String) optJSONArray2.get(i));
                    }
                    linkedList = linkedList2;
                }
                iuVar.mkl = linkedList;
            }
            iuVar.mkm = jSONObject.optInt("avail_num");
            iuVar.mkn = jSONObject.optInt("code_type");
            iuVar.code = jSONObject.optString("code");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("secondary_fields");
            if (optJSONArray3 != null) {
                iuVar.mko = j(optJSONArray3);
            }
            iuVar.mkp = jSONObject.optLong("stock_num");
            iuVar.mkq = jSONObject.optInt("limit_num");
            iuVar.mkr = jSONObject.optString("user_report_url");
            JSONObject optJSONObject = jSONObject.optJSONObject("third_field");
            if (optJSONObject != null) {
                iuVar.mks = k(optJSONObject);
            }
            iuVar.mkt = k(jSONObject.optJSONArray("action_sheets"));
            optJSONObject = jSONObject.optJSONObject("card_list_field");
            if (optJSONObject != null) {
                iuVar.mku = k(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("operate_field");
            if (optJSONObject != null) {
                iuVar.mkv = k(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("limit_field");
            if (optJSONObject != null) {
                iuVar.mkw = k(optJSONObject);
            }
            optJSONObject = jSONObject.optJSONObject("detail_table");
            if (optJSONObject != null) {
                iuVar.mkx = n(optJSONObject);
            }
            iuVar.mky = jSONObject.optString("background_pic_url");
            optJSONObject = jSONObject.optJSONObject("gifting_info_cell");
            if (optJSONObject != null) {
                iuVar.mkz = k(optJSONObject);
            }
            iuVar.mkA = jSONObject.optString("sign_number");
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return iuVar;
    }

    private static LinkedList<jg> i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<jg> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            jg jgVar = new jg();
            jgVar.title = jSONObject.optString("title");
            jgVar.eBN = jSONObject.optString("sub_title");
            jgVar.eEL = jSONObject.optString("tips");
            jgVar.url = jSONObject.optString("url");
            jgVar.mlB = jSONObject.optLong("show_flag");
            linkedList.add(jgVar);
        }
        return linkedList;
    }

    public static jc i(JSONObject jSONObject) {
        an anVar = null;
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserCardTpInfo json is null");
            return null;
        }
        jc jcVar = new jc();
        try {
            iw iwVar;
            bcv com_tencent_mm_protocal_c_bcv;
            qt qtVar;
            jcVar.eBK = jSONObject.optString("card_tp_id");
            jcVar.eBM = jSONObject.optString("logo_url");
            jcVar.bmJ = jSONObject.optString("appid");
            jcVar.mkK = jSONObject.optString("app_username");
            jcVar.mkL = jSONObject.optInt("card_category");
            jcVar.eBL = jSONObject.optInt("card_type");
            jcVar.eCD = jSONObject.optString("brand_name");
            jcVar.title = jSONObject.optString("title");
            jcVar.eBN = jSONObject.optString("sub_title");
            jcVar.coN = jSONObject.optString("color");
            jcVar.hbX = jSONObject.optString("notice");
            jcVar.mkM = jSONObject.optString("service_phone");
            jcVar.mkP = jSONObject.optString("image_text_url");
            jcVar.mkQ = jSONObject.optString("source_icon");
            jcVar.aHM = jSONObject.optString("source");
            JSONArray optJSONArray = jSONObject.optJSONArray("primary_fields");
            if (optJSONArray != null) {
                jcVar.mkN = j(optJSONArray);
            }
            optJSONArray = jSONObject.optJSONArray("introduce_fields");
            if (optJSONArray != null) {
                jcVar.mkO = j(optJSONArray);
            }
            jcVar.mkR = jSONObject.optInt("shop_count");
            jcVar.mkS = jSONObject.optString("limit_wording");
            jcVar.eCC = jSONObject.optString("card_type_name");
            jcVar.mkT = jSONObject.optString("h5_show_url");
            jcVar.mkU = jSONObject.optInt("block_mask");
            jcVar.mkV = jSONObject.optString("middle_icon");
            jcVar.mkW = jSONObject.optString("accept_wording");
            jcVar.mkX = jSONObject.optLong("control_flag");
            jcVar.mkY = jSONObject.optString("advertise_wording");
            jcVar.mkZ = jSONObject.optString("advertise_url");
            jcVar.mla = jSONObject.optString("public_service_name");
            JSONObject optJSONObject = jSONObject.optJSONObject("announcement");
            if (optJSONObject == null) {
                v.e("MicroMsg.CardInfoParser", "parserannoucement json is null");
                iwVar = null;
            } else {
                iwVar = new iw();
                iwVar.type = optJSONObject.optInt(Columns.TYPE);
                iwVar.text = optJSONObject.optString("text");
                iwVar.url = optJSONObject.optString("url");
                iwVar.iOT = optJSONObject.optInt("endtime");
                iwVar.mkB = optJSONObject.optInt("create_time");
                iwVar.mkC = optJSONObject.optString("thumb_url");
            }
            jcVar.mlb = iwVar;
            jcVar.mlc = jSONObject.optString("public_service_tip");
            jcVar.mld = jSONObject.optString("primary_sub_title");
            jcVar.mle = jSONObject.optInt("gen_type");
            jcVar.mlf = l(jSONObject.optJSONObject("detail_struct"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("use_condition");
            if (optJSONObject2 == null) {
                v.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
                com_tencent_mm_protocal_c_bcv = null;
            } else {
                int i;
                azb m;
                com_tencent_mm_protocal_c_bcv = new bcv();
                com_tencent_mm_protocal_c_bcv.title = optJSONObject2.optString("title");
                JSONArray optJSONArray2 = optJSONObject2.optJSONArray("outer_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    v.e("MicroMsg.CardInfoParser", "parserUseCondition outer_tag_list is null");
                } else {
                    com_tencent_mm_protocal_c_bcv.mYD = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        m = m(optJSONArray2.optJSONObject(i));
                        if (m != null) {
                            com_tencent_mm_protocal_c_bcv.mYD.add(m);
                        }
                    }
                }
                optJSONArray2 = optJSONObject2.optJSONArray("inner_tag_list");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    v.e("MicroMsg.CardInfoParser", "parserUseCondition inner_tag_list is null");
                } else {
                    com_tencent_mm_protocal_c_bcv.mYE = new LinkedList();
                    for (i = 0; i < optJSONArray2.length(); i++) {
                        m = m(optJSONArray2.optJSONObject(i));
                        if (m != null) {
                            com_tencent_mm_protocal_c_bcv.mYE.add(m);
                        }
                    }
                }
                JSONArray optJSONArray3 = optJSONObject2.optJSONArray("detail_field");
                if (optJSONArray3 == null || optJSONArray3.length() <= 0) {
                    v.e("MicroMsg.CardInfoParser", "parserUseCondition detail_field is null");
                } else {
                    com_tencent_mm_protocal_c_bcv.mYF = j(optJSONArray3);
                }
            }
            jcVar.mlg = com_tencent_mm_protocal_c_bcv;
            optJSONObject = jSONObject.optJSONObject("follow_box");
            if (optJSONObject == null) {
                v.e("MicroMsg.CardInfoParser", "parserFollowBox json is null");
                qtVar = null;
            } else {
                qtVar = new qt();
                qtVar.text = optJSONObject.optString("text");
                qtVar.muE = optJSONObject.optInt("follow");
                v.i("MicroMsg.CardInfoParser", "follow:" + qtVar.muE + "　text:" + qtVar.text);
            }
            jcVar.mlh = qtVar;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("guidance");
            if (optJSONObject3 == null) {
                v.e("MicroMsg.CardInfoParser", "parserActionSheet json is null");
            } else {
                anVar = new an();
                anVar.text = optJSONObject3.optString("text");
                anVar.url = optJSONObject3.optString("url");
            }
            jcVar.mli = anVar;
            jcVar.mlj = jSONObject.optInt("need_direct_jump", 0);
            jcVar.mlk = jSONObject.optInt("is_acceptable", 0);
            jcVar.mll = jSONObject.optString("unacceptable_wording");
            jcVar.mlm = jSONObject.optInt("has_hongbao", 0);
            jcVar.mln = jSONObject.optString("accept_ui_title");
            jcVar.mlo = jSONObject.optInt("show_accept_view", 0);
            JSONObject optJSONObject4 = jSONObject.optJSONObject("brand_field");
            if (optJSONObject4 != null) {
                jcVar.mlp = k(optJSONObject4);
            }
            jcVar.mlq = jSONObject.optString("shop_name");
            optJSONObject4 = jSONObject.optJSONObject("pay_and_qrcode_field");
            if (optJSONObject4 != null) {
                jcVar.mlr = k(optJSONObject4);
            }
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
        }
        return jcVar;
    }

    private static LinkedList<ld> j(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        LinkedList<ld> linkedList = new LinkedList();
        for (int i = 0; i < jSONArray.length(); i++) {
            ld k = k(jSONArray.getJSONObject(i));
            if (k != null) {
                linkedList.add(k);
            }
        }
        return linkedList;
    }

    private static auu j(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserShareInfo json is null");
            return null;
        }
        auu com_tencent_mm_protocal_c_auu = new auu();
        com_tencent_mm_protocal_c_auu.mSm = jSONObject.optString("gift_msg_title");
        return com_tencent_mm_protocal_c_auu;
    }

    private static LinkedList<an> k(JSONArray jSONArray) {
        LinkedList<an> linkedList = new LinkedList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    an anVar = new an();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    anVar.text = jSONObject.optString("text");
                    anVar.url = jSONObject.optString("url");
                    linkedList.add(anVar);
                } catch (Throwable e) {
                    v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
                }
            }
        }
        return linkedList;
    }

    private static ld k(JSONObject jSONObject) {
        abh com_tencent_mm_protocal_c_abh = null;
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserThirdFiled json is null");
            return null;
        }
        ld ldVar = new ld();
        ldVar.title = jSONObject.optString("title");
        ldVar.eBO = jSONObject.optString("aux_title");
        ldVar.eBN = jSONObject.optString("sub_title");
        ldVar.url = jSONObject.optString("url");
        ldVar.mlB = jSONObject.optLong("show_flag");
        ldVar.mnE = jSONObject.optString("primary_color");
        ldVar.mnF = jSONObject.optString("secondary_color");
        ldVar.eBZ = jSONObject.optString("icon_url");
        JSONObject optJSONObject = jSONObject.optJSONObject("gifting_info");
        if (optJSONObject != null) {
            if (optJSONObject == null) {
                v.e("MicroMsg.CardInfoParser", "parserGiftInfo json is null");
            } else {
                v.d("MicroMsg.CardInfoParser", "parserGitfInfo:%s", new Object[]{optJSONObject});
                com_tencent_mm_protocal_c_abh = new abh();
                com_tencent_mm_protocal_c_abh.lZR = o.ba(optJSONObject.optString("biz_uin"));
                com_tencent_mm_protocal_c_abh.lZS = optJSONObject.optString("order_id");
            }
            ldVar.mnG = com_tencent_mm_protocal_c_abh;
        }
        return ldVar;
    }

    private static nd l(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserDetailStruct json is null");
            return null;
        }
        nd ndVar = new nd();
        ndVar.title = jSONObject.optString("title");
        ndVar.url = jSONObject.optString("url");
        ndVar.desc = jSONObject.optString("abstract");
        ndVar.hQW = jSONObject.optString("detail");
        ndVar.mpc = jSONObject.optString("ad_title");
        JSONArray optJSONArray = jSONObject.optJSONArray("icon_url_list");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            v.e("MicroMsg.CardInfoParser", "parserDetailStruct icon_url_list is null");
        } else {
            LinkedList linkedList = new LinkedList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                Object obj = "";
                try {
                    obj = optJSONArray.getString(i);
                } catch (Throwable e) {
                    v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
                    v.e("MicroMsg.CardInfoParser", "getMessage:" + e.getMessage());
                }
                linkedList.add(obj);
            }
            ndVar.mpb = linkedList;
        }
        return ndVar;
    }

    private static azb m(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserUseCondition json is null");
            return null;
        }
        azb com_tencent_mm_protocal_c_azb = new azb();
        com_tencent_mm_protocal_c_azb.tag = jSONObject.optString("tag");
        com_tencent_mm_protocal_c_azb.coN = jSONObject.optString("color");
        return com_tencent_mm_protocal_c_azb;
    }

    private static ne n(JSONObject jSONObject) {
        if (jSONObject == null) {
            v.e("MicroMsg.CardInfoParser", "parserDetailTable json is null");
            return null;
        }
        ne neVar = new ne();
        neVar.title = jSONObject.optString("title");
        neVar.eBN = jSONObject.optString("sub_title");
        neVar.mpd = jSONObject.optInt("show_num", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("rows");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            v.e("MicroMsg.CardInfoParser", "parserDetailTable jsonArray is  null");
            return neVar;
        }
        try {
            neVar.mpe = j(optJSONArray);
            return neVar;
        } catch (Throwable e) {
            v.a("MicroMsg.CardInfoParser", e, "", new Object[0]);
            v.e("MicroMsg.CardInfoParser", e.getMessage());
            return neVar;
        }
    }
}
