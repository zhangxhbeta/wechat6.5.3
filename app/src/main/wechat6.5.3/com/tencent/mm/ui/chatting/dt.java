package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class dt {
    private u bhV = null;
    private Context context;
    private SimpleDateFormat fXP = new SimpleDateFormat("yyyy-MM-dd");
    List<at> omM;
    private String oyI = null;
    String oyJ = null;
    ArrayList<Uri> oyK = new ArrayList();

    public dt(Context context, List<at> list, u uVar) {
        this.context = context;
        this.omM = list;
        this.bhV = uVar;
    }

    public final String bGp() {
        String str = "MicroMsg.OtherMailHistoryExporter";
        String str2 = "export: history is null? %B, selectItems.size = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.oyJ == null);
        objArr[1] = Integer.valueOf(this.omM.size());
        v.d(str, str2, objArr);
        if (this.oyJ != null) {
            return this.oyJ;
        }
        this.oyK.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bGq());
        stringBuilder.append("\n\n");
        for (at atVar : this.omM) {
            if (this.oyI == null) {
                this.oyI = eB(atVar.field_createTime);
                stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.oyI}));
                stringBuilder.append("\n");
            } else {
                str = eB(atVar.field_createTime);
                if (!str.equals(this.oyI)) {
                    this.oyI = str;
                    stringBuilder.append(String.format("—————  %s  —————\n\n", new Object[]{this.oyI}));
                    stringBuilder.append("\n");
                }
            }
            String str3;
            if (atVar.bwm()) {
                if (!atVar.bwm()) {
                    str3 = null;
                } else if (atVar.field_isSend == 1) {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aB(atVar), atVar.field_content});
                } else if (this.bhV.field_username.endsWith("@chatroom")) {
                    str3 = aw.fK(atVar.field_content) != -1 ? String.format("%s\n\n%s\n\n", new Object[]{aB(atVar), atVar.field_content.substring(aw.fK(atVar.field_content) + 1).trim()}) : null;
                } else {
                    str3 = String.format("%s\n\n%s\n\n", new Object[]{aB(atVar), atVar.field_content});
                }
                stringBuilder.append(str3);
            } else if (atVar.bwj()) {
                if (atVar.bwj()) {
                    long j = atVar.field_msgId;
                    long j2 = atVar.field_msgSvrId;
                    str = dj.ez(j);
                    if (be.kS(str)) {
                        str = dj.eA(j2);
                    }
                    v.d("MicroMsg.OtherMailHistoryExporter", "hdPath[%s]", str);
                    if (!be.kS(str)) {
                        this.oyK.add(Uri.parse("file://" + str));
                        str = String.format("[%s: %s(%s)]", new Object[]{this.context.getString(2131232315), new File(str).getName(), this.context.getString(2131232311)});
                        str3 = String.format("%s\n\n%s\n\n", new Object[]{aB(atVar), str});
                        stringBuilder.append(str3);
                    }
                }
                str3 = null;
                stringBuilder.append(str3);
            } else {
                if (atVar.bwb()) {
                    str = String.format("[%s]", new Object[]{this.context.getString(2131232320)});
                } else if (atVar.bwf()) {
                    str = atVar.field_isSend == 1 ? this.context.getString(2131232318) : this.context.getString(2131232317);
                } else if (atVar.bwl()) {
                    b hqVar = new hq();
                    hqVar.bhv.bhq = 1;
                    hqVar.bhv.aXd = atVar;
                    a.nhr.z(hqVar);
                    str = String.format("[%s]", new Object[]{hqVar.bhw.bhy});
                } else {
                    if (atVar.bvY()) {
                        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(atVar.field_content));
                        if (dV != null) {
                            switch (dV.type) {
                                case 4:
                                case 6:
                                    com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                                    if (Gu != null) {
                                        File file = new File(Gu.field_fileFullPath);
                                        if (file.exists()) {
                                            this.oyK.add(Uri.fromFile(file));
                                            break;
                                        }
                                    }
                                    break;
                            }
                            f aC = g.aC(dV.appId, true);
                            if (aC == null) {
                                str = SQLiteDatabase.KeyEmpty;
                            } else {
                                String str4 = aC.field_appName;
                                str = 6 == dV.type ? String.format("[%s: %s(%s)]", new Object[]{this.context.getString(2131232310), str4, this.context.getString(2131232311)}) : String.format("[%s: %s]", new Object[]{this.context.getString(2131232310), str4});
                            }
                        }
                    } else if (atVar.bwk()) {
                        ak.yW();
                        str = c.wJ().MU(atVar.field_content).cID;
                        str = String.format("[%s: %s]", new Object[]{this.context.getString(2131232312), str});
                    } else if (atVar.bwn()) {
                        r7 = new Object[3];
                        k.KV();
                        r7[1] = new File(o.lc(atVar.field_imgPath)).getName();
                        r7[2] = this.context.getString(2131232311);
                        str = String.format("[%s: %s(%s)]", r7);
                        k.KV();
                        File file2 = new File(o.lc(atVar.field_imgPath));
                        if (file2.exists()) {
                            this.oyK.add(Uri.fromFile(file2));
                        }
                    } else if (atVar.bwp() || atVar.bwq()) {
                        str = String.format("[%s]", new Object[]{this.context.getString(2131232313)});
                    }
                    str = null;
                }
                v.i("MicroMsg.OtherMailHistoryExporter", "formatOtherMsg, msgStr = %s", str);
                stringBuilder.append(String.format("%s\n\n%s\n\n", new Object[]{aB(atVar), str}));
            }
        }
        stringBuilder.append("\n\n");
        this.oyJ = stringBuilder.toString();
        return this.oyJ;
    }

    private String bGq() {
        String str;
        if (this.bhV.field_username.endsWith("@chatroom")) {
            if (be.kS(this.bhV.field_nickname)) {
                List<String> ej = i.ej(this.bhV.field_username);
                str = SQLiteDatabase.KeyEmpty;
                String str2 = str;
                for (String str3 : ej) {
                    str2 = str2 + l.er(str3) + ", ";
                }
                str3 = str2.substring(0, str2.length() - 2);
            } else {
                str3 = this.bhV.tT();
            }
            return String.format(this.context.getString(2131234906), new Object[]{str3});
        }
        str3 = this.context.getString(2131234907);
        Object[] objArr = new Object[2];
        objArr[0] = this.bhV.tT();
        ak.yW();
        objArr[1] = c.vf().get(4, null);
        return String.format(str3, objArr);
    }

    private String aB(at atVar) {
        String str;
        String str2 = null;
        if (this.bhV.field_username.endsWith("@chatroom")) {
            str = atVar.field_content;
            int fK = aw.fK(str);
            if (fK != -1) {
                str2 = l.er(str.substring(0, fK).trim());
            }
        } else {
            str2 = l.er(atVar.field_talker);
        }
        if (atVar.field_isSend == 1) {
            v.i("MicroMsg.OtherMailHistoryExporter", "isSend");
            str2 = com.tencent.mm.model.k.xH();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(atVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private String eB(long j) {
        return this.fXP.format(new Date(j));
    }
}
