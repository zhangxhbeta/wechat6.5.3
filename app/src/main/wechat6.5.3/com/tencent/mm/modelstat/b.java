package com.tencent.mm.modelstat;

import android.os.Looper;
import com.tencent.mm.e.a.mu;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP;
import com.tencent.mm.plugin.report.kvdata.log_13835;
import com.tencent.mm.plugin.report.kvdata.log_13913;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.Locale;

public final class b {
    public static b daJ = new b();
    public log_13835 daI;
    private c daK = new c<mu>(this) {
        final /* synthetic */ b daN;

        {
            this.daN = r2;
            this.nhz = mu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            mu muVar = (mu) bVar;
            if (muVar instanceof mu) {
                this.daN.p(muVar.boe.aXd);
            }
            return false;
        }
    };
    private int daL = 1;
    private int daM = 1;
    private boolean hasInit = false;

    public enum a {
        OP_Chatting(1),
        OP_Msg(2);
        
        public int value;

        private a(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    public enum b {
        UnKnownType(0),
        expourse(1),
        click(2),
        send(3),
        fav(4),
        revoke(5),
        delete(6),
        voiceToText(7),
        translate(8),
        translateHidden(9),
        doubleClickText(10),
        imageSaveToLocal(11),
        playMusic(12),
        stopMusic(13);
        
        public int value;

        private b(int i) {
            this.value = 0;
            this.value = i;
        }
    }

    private b() {
        com.tencent.mm.sdk.c.a.nhr.d(this.daK);
    }

    public final boolean bc(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.ChattingOperationUitl", "check error:%s", be.bur().toString());
            com.tencent.mm.ba.a com_tencent_mm_plugin_report_kvdata_log_13913 = new log_13913();
            com_tencent_mm_plugin_report_kvdata_log_13913.scene_ = 1;
            com_tencent_mm_plugin_report_kvdata_log_13913.error_ = r2;
            g.iuh.a(13913, com_tencent_mm_plugin_report_kvdata_log_13913);
            return false;
        }
        if (!(this.daI == null || this.daI.currChatName_.equals(str))) {
            qq();
        }
        if (this.daI == null) {
            this.daI = new log_13835();
            this.daI.currChatName_ = str;
        }
        return true;
    }

    public final void qq() {
        if (JV()) {
            if (!(this.daI == null || this.daI.oplist_.isEmpty())) {
                if (this.daM != 0) {
                    v.i("MicroMsg.ChattingOperationUitl", "report imOperation(13835)");
                    g.iuh.a(13835, this.daI);
                }
                if (this.daL != 0) {
                    String str;
                    if (this.daI == null) {
                        str = SQLiteDatabase.KeyEmpty;
                    } else {
                        String str2 = ",";
                        Iterator it = this.daI.oplist_.iterator();
                        int i = 1;
                        while (it.hasNext()) {
                            StringBuilder append;
                            IMBehavior iMBehavior = (IMBehavior) it.next();
                            if (i == 0) {
                                str2 = str2 + "|";
                            }
                            str2 = str2 + iMBehavior.opType + "#";
                            if (iMBehavior.opType == 1) {
                                append = new StringBuilder().append(str2);
                                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                                str = SQLiteDatabase.KeyEmpty;
                                if (iMBehaviorChattingOP.changeUnread != 0) {
                                    str = str + "changeUnread=" + iMBehaviorChattingOP.changeUnread;
                                }
                                if (iMBehaviorChattingOP.changeTop != 0) {
                                    str = str + "changeTop=" + iMBehaviorChattingOP.changeTop;
                                }
                                if (iMBehaviorChattingOP.changeNotifyStatus != 0) {
                                    str = str + "changeNotifyStatus=" + iMBehaviorChattingOP.changeNotifyStatus;
                                }
                                if (iMBehaviorChattingOP.changeSaveAddress != 0) {
                                    str = str + "changeSaveAddress=" + iMBehaviorChattingOP.changeSaveAddress;
                                }
                                if (iMBehaviorChattingOP.expose != 0) {
                                    str = str + "expose=" + iMBehaviorChattingOP.expose;
                                }
                            } else {
                                append = new StringBuilder().append(str2);
                                if (iMBehavior.msgOp.msgType == 49) {
                                    str = String.format(Locale.US, "msgType=%d&msgOpType=%d&appMsgInnerType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.appMsgInnerType), Integer.valueOf(iMBehavior.msgOp.count)});
                                } else {
                                    str = String.format(Locale.US, "msgType=%d&msgOpType=%d&count=%d", new Object[]{Integer.valueOf(iMBehavior.msgOp.msgType), Integer.valueOf(iMBehavior.msgOp.msgOpType), Integer.valueOf(iMBehavior.msgOp.count)});
                                }
                            }
                            str2 = append.append(str).toString();
                            i = 0;
                        }
                        str = str2 + "," + this.daI.currChatName_;
                    }
                    v.i("MicroMsg.ChattingOperationUitl", "report imOperation(13748) reportStr:%s", str);
                    g.iuh.Y(13748, str);
                }
            }
            this.daI = null;
        }
    }

    public final void C(String str, boolean z) {
        int i = 1;
        if (JV()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeUnread = i;
            qq();
            if (bc(str)) {
                this.daI.oplist_.add(iMBehavior);
                qq();
            }
        }
    }

    public final void c(boolean z, String str, boolean z2) {
        int i = 1;
        if (JV()) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z2) {
                i = 2;
            }
            iMBehaviorChattingOP.changeTop = i;
            if (z) {
                qq();
            }
            if (bc(str)) {
                this.daI.oplist_.add(iMBehavior);
                if (z) {
                    qq();
                }
            }
        }
    }

    public final void D(String str, boolean z) {
        int i = 1;
        if (JV() && bc(str)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 1;
            iMBehavior.chattingOp = new IMBehaviorChattingOP();
            IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
            if (!z) {
                i = 2;
            }
            iMBehaviorChattingOP.changeSaveAddress = i;
            this.daI.oplist_.add(iMBehavior);
        }
    }

    public final void a(at atVar, b bVar) {
        if (bc(atVar.field_talker)) {
            IMBehavior iMBehavior = new IMBehavior();
            iMBehavior.opType = 2;
            iMBehavior.msgOp = new IMBehaviorMsgOP();
            iMBehavior.msgOp.msgType = atVar.field_type & 65535;
            if (atVar.bvY()) {
                com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(atVar.field_content, atVar.field_reserved);
                iMBehavior.msgOp.appMsgInnerType = B == null ? 0 : B.type;
            }
            iMBehavior.msgOp.msgOpType = bVar.value;
            iMBehavior.msgOp.count = 1;
            if (iMBehavior.opType == a.OP_Chatting.value) {
                this.daI.oplist_.add(iMBehavior);
                return;
            }
            Iterator it = this.daI.oplist_.iterator();
            while (it.hasNext()) {
                IMBehavior iMBehavior2 = (IMBehavior) it.next();
                if (iMBehavior2.opType == a.OP_Msg.value) {
                    IMBehaviorMsgOP iMBehaviorMsgOP = iMBehavior2.msgOp;
                    IMBehaviorMsgOP iMBehaviorMsgOP2 = iMBehavior.msgOp;
                    int i = (iMBehaviorMsgOP.msgOpType == iMBehaviorMsgOP2.msgOpType && iMBehaviorMsgOP.msgType == iMBehaviorMsgOP2.msgType && iMBehaviorMsgOP.appMsgInnerType == iMBehaviorMsgOP2.appMsgInnerType) ? 1 : 0;
                    if (i != 0) {
                        IMBehaviorMsgOP iMBehaviorMsgOP3 = iMBehavior2.msgOp;
                        iMBehaviorMsgOP3.count++;
                        return;
                    }
                }
            }
            this.daI.oplist_.add(iMBehavior);
        }
    }

    public final void p(final at atVar) {
        new ac(Looper.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ b daN;

            public final void run() {
                b bVar = this.daN;
                at atVar = atVar;
                if (bVar.JV()) {
                    bVar.a(atVar, b.send);
                }
            }
        });
    }

    public final void q(at atVar) {
        if (JV()) {
            a(atVar, b.fav);
        }
    }

    public final void r(at atVar) {
        if (JV()) {
            a(atVar, b.delete);
        }
    }

    public final void s(at atVar) {
        if (JV()) {
            a(atVar, b.click);
        }
    }

    public final void t(at atVar) {
        if (JV()) {
            a(atVar, b.voiceToText);
        }
    }

    public final void a(at atVar, boolean z) {
        if (JV() && atVar.bwm()) {
            a(atVar, z ? b.translate : b.translateHidden);
        }
    }

    public final void u(at atVar) {
        if (JV() && atVar.bwm()) {
            a(atVar, b.doubleClickText);
        }
    }

    public final void v(at atVar) {
        if (JV()) {
            a(atVar, b.imageSaveToLocal);
        }
    }

    public final void b(at atVar, boolean z) {
        if (JV()) {
            a(atVar, z ? b.playMusic : b.stopMusic);
        }
    }

    public final boolean JV() {
        if (!this.hasInit) {
            this.hasInit = true;
            com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls("100148");
            if (Ls.isValid()) {
                this.daL = t.getInt((String) Ls.buX().get("needUploadData"), 1);
            }
            Ls = com.tencent.mm.model.c.c.Au().Ls("100149");
            if (Ls.isValid()) {
                this.daM = t.getInt((String) Ls.buX().get("needUploadData"), 1);
            }
        }
        return (this.daL == 0 && this.daM == 0) ? false : true;
    }
}
