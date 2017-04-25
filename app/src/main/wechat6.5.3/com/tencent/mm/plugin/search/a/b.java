package com.tencent.mm.plugin.search.a;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.as.u;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.b.ax;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public final class b extends ax {
    public static com.tencent.mm.sdk.h.c.a chq;
    public static final SparseArray<a> iEn;

    static class a {
        int iEo;
        String iEp;
        boolean iEq;
        int id;
        String uri;
        String username;

        public a(int i, int i2, String str, String str2, String str3) {
            this(i, i2, str, str2, str3, (byte) 0);
        }

        public a(int i, int i2, String str, String str2, String str3, byte b) {
            this.id = i;
            this.iEo = i2;
            this.uri = str;
            this.iEp = str2;
            this.username = str3;
        }
    }

    static {
        com.tencent.mm.sdk.h.c.a aVar = new com.tencent.mm.sdk.h.c.a();
        aVar.ddU = new Field[11];
        aVar.bXK = new String[12];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "featureId";
        aVar.nmd.put("featureId", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" featureId INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "featureId";
        aVar.bXK[1] = "title";
        aVar.nmd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "titlePY";
        aVar.nmd.put("titlePY", "TEXT");
        stringBuilder.append(" titlePY TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "titleShortPY";
        aVar.nmd.put("titleShortPY", "TEXT");
        stringBuilder.append(" titleShortPY TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "tag";
        aVar.nmd.put("tag", "TEXT");
        stringBuilder.append(" tag TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "actionType";
        aVar.nmd.put("actionType", "INTEGER default '0' ");
        stringBuilder.append(" actionType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[6] = "url";
        aVar.nmd.put("url", "TEXT");
        stringBuilder.append(" url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "helpUrl";
        aVar.nmd.put("helpUrl", "TEXT");
        stringBuilder.append(" helpUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[8] = "updateUrl";
        aVar.nmd.put("updateUrl", "TEXT");
        stringBuilder.append(" updateUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "androidUrl";
        aVar.nmd.put("androidUrl", "TEXT");
        stringBuilder.append(" androidUrl TEXT");
        stringBuilder.append(", ");
        aVar.bXK[10] = "iconPath";
        aVar.nmd.put("iconPath", "TEXT");
        stringBuilder.append(" iconPath TEXT");
        aVar.bXK[11] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
        SparseArray sparseArray = new SparseArray();
        iEn = sparseArray;
        sparseArray.put(19, new a(19, -1, ".ui.SnsTimeLineUI", "sns", ""));
        iEn.put(30, new a(19, -1, ".ui.BaseScanUI", "scanner", "", (byte) 0));
        iEn.put(18, new a(18, -1, ".ui.ShakeReportUI", "shake", ""));
        iEn.put(17, new a(17, -1, ".ui.NearbyFriendsIntroUI", "nearby", ""));
        iEn.put(16, new a(16, -1, ".ui.BottleBeachUI", "bottle", ""));
        iEn.put(31, new a(31, -1, ".ui.GameCenterUI", "game", ""));
        iEn.put(20, new a(20, -1, ".plugin.profile.ui.ContactInfoUI", "", "voiceinputapp"));
        iEn.put(21, new a(21, -1, ".plugin.profile.ui.ContactInfoUI", "", "linkedinplugin"));
        iEn.put(26, new a(26, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqfriend"));
        iEn.put(29, new a(29, -1, ".plugin.profile.ui.ContactInfoUI", "", "voipapp"));
        iEn.put(22, new a(22, 32, ".ui.QConversationUI", "qmessage", "qmessage"));
        iEn.put(23, new a(23, 1, ".ui.chatting.ChattingUI", "", "qqmail"));
        iEn.put(1, new a(1, -1, ".ui.MallIndexUI", "mall", ""));
        iEn.put(24, new a(24, 8, ".ui.chatting.ChattingUI", "", "weibo"));
        iEn.put(25, new a(25, -1, ".plugin.profile.ui.ContactInfoUI", "", "qqsync"));
        iEn.put(27, new a(27, 65536, ".ui.MassSendHistoryUI", "masssend", "masssendapp"));
        iEn.put(28, new a(28, 524288, ".ui.ReaderAppUI", "readerapp", "newsapp"));
        iEn.put(32, new a(32, -1, ".ui.v2.EmojiStoreV2UI", "emoji", ""));
        iEn.put(33, new a(33, -1, ".ui.FavoriteIndexUI", "favorite", ""));
        iEn.put(34, new a(34, -1, ".ui.MallIndexUI", "mall", ""));
        iEn.put(35, new a(35, -1, ".moveui.BakMoveUI", "backup", ""));
        iEn.put(38, new a(38, 16, ".ui.chatting.ChattingUI", "", "medianote"));
        iEn.put(39, new a(39, -1, ".ui.chatting.ChattingUI", "", "filehelper"));
        iEn.put(6, new a(6, -1, ".ui.LuckyMoneyIndexUI", "luckymoney", ""));
        iEn.put(41, new a(41, -1, ".ui.WalletOfflineEntranceUI", "offline", ""));
        iEn.put(42, new a(42, -1, ".ui.CollectMainUI", "collect", ""));
        iEn.put(40, new a(40, -1, ".balance.ui.WalletBalanceManagerUI", "wallet", ""));
    }

    private static boolean ao(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", str);
        c.b(context, "profile", ".ui.ContactInfoUI", intent);
        return true;
    }

    public static boolean B(Context context, int i) {
        if (iEn.indexOfKey(i) < 0) {
            return false;
        }
        if (i == 30 && (u.bi(context) || com.tencent.mm.ah.a.aT(context))) {
            return false;
        }
        a aVar = (a) iEn.get(i);
        if (aVar.iEo != -1 && (k.xQ() & aVar.iEo) != 0) {
            return ao(context, aVar.username);
        }
        if (!be.kS(aVar.iEp)) {
            Intent intent = new Intent();
            if (i == 28) {
                intent.putExtra(Columns.TYPE, 20);
            }
            if (i == 1) {
                intent.putExtra("key_native_url", "wxpay://bizmall/mobile_recharge");
            }
            intent.putExtra("animation_pop_in", aVar.iEq);
            if (i == 32) {
                g.iuh.h(12065, new Object[]{Integer.valueOf(6)});
            }
            if (i == 6) {
                intent.putExtra("pay_channel", 15);
            }
            if (i == 31) {
                intent.putExtra("game_report_from_scene", 4);
            }
            c.b(context, aVar.iEp, aVar.uri, intent);
            com.tencent.mm.ui.base.b.x(context, intent);
            return true;
        } else if (aVar.uri.equals(".ui.chatting.ChattingUI")) {
            String str = aVar.username;
            ak.yW();
            if (com.tencent.mm.i.a.ei(com.tencent.mm.model.c.wH().LX(str).field_type)) {
                Intent intent2 = new Intent();
                intent2.putExtra("Chat_User", str);
                intent2.putExtra("finish_direct", true);
                c.a(context, ".ui.chatting.ChattingUI", intent2);
            } else {
                ao(context, str);
            }
            return true;
        } else if (aVar.uri.equals(".plugin.profile.ui.ContactInfoUI")) {
            return ao(context, aVar.username);
        } else {
            v.e("MicroMsg.Feature", "Error URI of android feature");
            return false;
        }
    }

    public b() {
        this.field_featureId = 0;
        this.field_title = "";
        this.field_titlePY = "";
        this.field_titleShortPY = "";
        this.field_tag = "";
        this.field_actionType = 0;
        this.field_url = "";
        this.field_helpUrl = "";
        this.field_updateUrl = "";
        this.field_androidUrl = "";
        this.field_iconPath = "";
    }

    protected final com.tencent.mm.sdk.h.c.a tl() {
        return chq;
    }

    public final String toString() {
        return "Feature [field_featureId=" + this.field_featureId + ", field_title=" + this.field_title + ", field_titlePY=" + this.field_titlePY + ", field_titleShortPY=" + this.field_titleShortPY + ", field_tag=" + this.field_tag + ", field_actionType=" + this.field_actionType + ", field_url=" + this.field_url + ", field_helpUrl=" + this.field_helpUrl + ", field_updateUrl=" + this.field_updateUrl + ", field_androidUrl=" + this.field_androidUrl + ", field_iconPath=" + this.field_iconPath + "]";
    }
}
