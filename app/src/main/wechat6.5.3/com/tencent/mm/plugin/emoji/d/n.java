package com.tencent.mm.plugin.emoji.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.emoji.a;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreTopicUI;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class n {
    public static void a(Context context, ol olVar, int i, int i2, int i3, String str, int i4) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        if (olVar != null) {
            intent.putExtra("extra_id", olVar.mdM);
            intent.putExtra("extra_name", olVar.mqd);
            intent.putExtra("extra_copyright", olVar.mqn);
            intent.putExtra("extra_coverurl", olVar.mql);
            intent.putExtra("extra_description", olVar.mqe);
            intent.putExtra("extra_price", olVar.mqg);
            intent.putExtra("extra_type", olVar.mqh);
            intent.putExtra("extra_flag", olVar.mqi);
            intent.putExtra("preceding_scence", i4);
            intent.putExtra("call_by", 1);
            intent.putExtra("check_clickflag", false);
            intent.putExtra("download_entrance_scene", i);
            if (i2 != -1) {
                intent.putExtra("extra_status", i2);
            }
            if (i3 != -1) {
                intent.putExtra("extra_progress", -1);
            }
            if (!be.kS(str)) {
                intent.putExtra("to_talker_name", str);
            }
        } else {
            v.i("MicroMsg.emoji.EmojiUINavigatorMgr", "get detail intent failed. summary is null.");
        }
        context.startActivity(intent);
    }

    private static void a(Context context, oc ocVar, int i, int i2) {
        Intent intent = new Intent();
        intent.setClass(context, EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", ocVar.mdM);
        intent.putExtra("extra_name", ocVar.aXz);
        intent.putExtra("extra_description", ocVar.gkC);
        intent.putExtra("preceding_scence", i2);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", i);
        intent.putExtra("check_clickflag", true);
        context.startActivity(intent);
    }

    public static void a(Context context, oc ocVar, boolean z) {
        if (ocVar == null) {
            v.i("MicroMsg.emoji.EmojiUINavigatorMgr", "banner is null. do nothing");
            return;
        }
        String str;
        int i;
        String str2;
        String str3;
        String str4;
        Intent intent;
        switch (ocVar.mpW) {
            case 0:
                v.i("MicroMsg.emoji.EmojiUINavigatorMgr", "MM_EMOTION_BANNER_SET_NULL do nothing");
                g.iuh.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(ocVar.aRI), ocVar.aXz, Integer.valueOf(0), Integer.valueOf(0)});
                return;
            case 1:
                if (z) {
                    a(context, ocVar, 15, 8);
                } else {
                    a(context, ocVar, 3, 5);
                }
                g.iuh.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(ocVar.aRI), ocVar.aXz, Integer.valueOf(0), Integer.valueOf(4)});
                return;
            case 2:
                String str5 = ocVar.mpU;
                str = ocVar.aXz;
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", str5);
                intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, str);
                a.drp.j(intent2, context);
                g.iuh.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(ocVar.aRI), ocVar.aXz, Integer.valueOf(0), Integer.valueOf(3)});
                return;
            case 3:
                i = ocVar.aRI;
                str = ocVar.aXz;
                str2 = ocVar.gkC;
                str3 = ocVar.gnp;
                str4 = ocVar.mpV;
                intent = new Intent();
                intent.setClass(context, EmojiStoreTopicUI.class);
                intent.putExtra("topic_id", i);
                intent.putExtra("topic_name", str);
                intent.putExtra("topic_ad_url", str4);
                intent.putExtra("topic_icon_url", str3);
                intent.putExtra("topic_desc", str2);
                if (z) {
                    intent.putExtra("extra_scence", 15);
                } else {
                    intent.putExtra("extra_scence", 3);
                }
                context.startActivity(intent);
                g.iuh.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(ocVar.aRI), ocVar.aXz, Integer.valueOf(0), Integer.valueOf(2)});
                return;
            case 4:
                i = ocVar.aRI;
                str = ocVar.aXz;
                str2 = ocVar.gkC;
                str3 = ocVar.gnp;
                str4 = ocVar.mpV;
                intent = new Intent();
                intent.putExtra("set_id", i);
                intent.putExtra("headurl", str4);
                intent.putExtra("set_title", str);
                intent.putExtra("set_iconURL", str3);
                intent.putExtra("set_desc", str2);
                intent.setClass(context, EmojiStoreV2SingleProductUI.class);
                context.startActivity(intent);
                g.iuh.h(13223, new Object[]{Integer.valueOf(1), Integer.valueOf(ocVar.aRI), ocVar.aXz, Integer.valueOf(0), Integer.valueOf(1)});
                return;
            default:
                v.i("MicroMsg.emoji.EmojiUINavigatorMgr", "Unkown type do nothing. SetType:%d", new Object[]{Integer.valueOf(ocVar.mpW)});
                return;
        }
    }
}
