package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.as.j;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.e.a.mr;
import com.tencent.mm.e.a.n;
import com.tencent.mm.e.a.no;
import com.tencent.mm.e.a.np;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgRetransmitUI extends MMBaseActivity implements e {
    public String aST;
    public long bao;
    private String bdZ;
    private float bhs;
    public String blu;
    private int cLy = 0;
    private f cMP = null;
    private float cNt;
    private String cNu;
    private ProgressDialog dwR = null;
    long ezh;
    private String jGE;
    boolean lKa;
    private int length;
    private ac mHandler = new ac();
    public int msgType;
    public List<String> oWE;
    private String oWF = null;
    private boolean oWG = true;
    private boolean oWH = false;
    private h oWI;
    private int oWJ = 0;
    private int oWK = 0;
    private k oWL = null;
    private boolean oWM = false;
    private List<String> oWN = null;
    private int oWO = 0;
    private int oWP = 0;
    private boolean oWQ = false;
    private boolean oWR = false;
    private int oWS;
    private boolean oWT;
    private boolean oWU = true;
    private boolean oWV = true;
    private int oWW = 0;
    private int oWX;
    private String oWY;
    private String oWZ;
    private int oXa;
    private boolean oXb = true;
    boolean oXc = false;
    private boolean oiH = false;
    private int ooy = -1;
    private long startTime = 0;

    public static final class a extends AsyncTask<Object, Object, String> {
        public String aST;
        public String bNo;
        public String bnY;
        public Context context;
        public int dgq;
        public int dhK;
        public Dialog dxy;
        private ac mHandler = new ac();
        public boolean oWH = false;
        public int oWJ;
        public boolean oXh;
        public String oXi;
        public boolean oXj = true;
        public boolean oXk = false;
        public boolean oXl = true;
        public ayk oXm = null;
        public b oXn = null;
        public String userName;

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            String lb = o.lb(com.tencent.mm.model.k.xF());
            com.tencent.mm.as.k.KV();
            String ld = o.ld(lb);
            if (this.oXl) {
                FileOp.p(o.lc(this.aST), o.lc(lb));
                FileOp.p(o.ld(this.aST), ld);
            } else {
                FileOp.p(this.aST, o.lc(lb));
                FileOp.p(this.oXi, ld);
            }
            return lb;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (this.dxy != null) {
                this.dxy.dismiss();
                this.dxy = null;
            }
            com.tencent.mm.as.k.KV();
            boolean aR = FileOp.aR(o.lc(str));
            com.tencent.mm.as.k.KV();
            String ld = o.ld(str);
            boolean aR2 = FileOp.aR(ld);
            if (this.oXh) {
                if (aR) {
                    FileOp.deleteFile(str);
                }
                if (aR2) {
                    FileOp.deleteFile(ld);
                }
            } else if (aR) {
                v.d("MicroMsg.MsgRetransmitUI", "dkvideo videoIsExport :" + this.oWJ + ", videoMsgType :43 videoType : " + this.dgq);
                p.a(str, this.dhK, this.userName, null, this.oWJ, SQLiteDatabase.KeyEmpty, 43, this.oXm, this.bnY);
                Object obj2 = p.lk(str) != 0 ? 1 : null;
                com.tencent.mm.as.k.KV();
                ld = o.lc(str);
                int i = (be.kS(this.aST) || !this.aST.contains("favorite")) ? be.kS(this.bNo) ? 6 : 3 : 7;
                j.KT().a(SQLiteDatabase.KeyEmpty, ld, this.userName, this.bNo, SQLiteDatabase.KeyEmpty, i, 2);
                g.iuh.h(10424, Integer.valueOf(43), Integer.valueOf(8), this.userName);
                if (this.oXn != null) {
                    b bVar = this.oXn;
                    ld = this.userName;
                    Object obj3 = obj2 == null ? 1 : null;
                    if (bVar.oXp != null && bVar.oXp.contains(ld)) {
                        bVar.oXp.remove(ld);
                        if (obj3 == null) {
                            bVar.aYN = false;
                        }
                        if (bVar.oXp.size() == 0) {
                            obj3 = 1;
                            if (obj3 != null) {
                                obj2 = this.oXn.aYN ? 1 : null;
                            } else {
                                return;
                            }
                        }
                    }
                    obj3 = null;
                    if (obj3 != null) {
                        if (this.oXn.aYN) {
                        }
                        obj2 = this.oXn.aYN ? 1 : null;
                    } else {
                        return;
                    }
                }
                if (this.oXj) {
                    Intent intent = new Intent(this.context, ChattingUI.class);
                    intent.addFlags(67108864);
                    intent.putExtra("Chat_User", this.userName);
                    this.context.startActivity(intent);
                }
                if (this.oWH && (this.context instanceof Activity)) {
                    com.tencent.mm.ui.snackbar.a.f((Activity) this.context, this.context.getString(obj2 == null ? 2131233278 : 2131234920));
                }
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ a oXo;

                    {
                        this.oXo = r1;
                    }

                    public final void run() {
                        if (this.oXo.oXk && (this.oXo.context instanceof Activity)) {
                            ((Activity) this.oXo.context).finish();
                        }
                    }
                }, 1800);
            } else if (this.context instanceof Activity) {
                com.tencent.mm.ui.snackbar.a.c((Activity) this.context, this.context.getResources().getString(2131234920), SQLiteDatabase.KeyEmpty);
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ a oXo;

                    {
                        this.oXo = r1;
                    }

                    public final void run() {
                        if (this.oXo.oXk && (this.oXo.context instanceof Activity)) {
                            ((Activity) this.oXo.context).finish();
                        }
                    }
                }, 1800);
            }
        }
    }

    private static final class b {
        boolean aYN;
        public List<String> oXp;

        private b() {
            this.oXp = null;
            this.aYN = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.i("MicroMsg.MsgRetransmitUI", "on activity create");
        this.startTime = be.Nh();
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.blu = getIntent().getStringExtra("Retr_Msg_content");
        this.bao = getIntent().getLongExtra("Retr_Msg_Id", -1);
        this.aST = getIntent().getStringExtra("Retr_File_Name");
        this.oWN = getIntent().getStringArrayListExtra("Retr_File_Path_List");
        boolean z = this.oWN != null && this.oWN.size() > 0;
        this.oWQ = z;
        this.cLy = getIntent().getIntExtra("Retr_Compress_Type", 0);
        this.oWK = getIntent().getIntExtra("Retr_Scene", 0);
        this.length = getIntent().getIntExtra("Retr_length", 0);
        this.oWJ = getIntent().getIntExtra("Retr_video_isexport", 0);
        this.oWF = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.oWG = getIntent().getBooleanExtra("Retr_go_to_chattingUI", true);
        this.oWU = getIntent().getBooleanExtra("Retr_start_where_you_are", true);
        Intent intent = getIntent();
        String str = "Multi_Retr";
        if (this.oWK == 0) {
            z = true;
        } else {
            z = false;
        }
        this.oWV = intent.getBooleanExtra(str, z);
        if (this.oWV) {
            this.oWU = true;
        }
        this.oWH = getIntent().getBooleanExtra("Retr_show_success_tips", this.oWU);
        this.oWR = getIntent().getBooleanExtra("Edit_Mode_Sigle_Msg", false);
        this.oiH = getIntent().getBooleanExtra("is_group_chat", false);
        this.ooy = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.bdZ = getIntent().getStringExtra("Retr_NewYear_Thumb_Path");
        this.oWS = getIntent().getIntExtra("Retr_MsgImgScene", 0);
        this.cNt = getIntent().getFloatExtra("Retr_Longtitude", -1000.0f);
        this.bhs = getIntent().getFloatExtra("Retr_Latitude", -1000.0f);
        this.cNu = getIntent().getStringExtra("Retr_AttachedContent");
        this.oWT = "gallery".equals(getIntent().getStringExtra("Retr_From"));
        this.jGE = getIntent().getStringExtra("reportSessionId");
        this.oWX = getIntent().getIntExtra("Retr_MsgFromScene", 0);
        this.oWY = getIntent().getStringExtra("Retr_MsgFromUserName");
        this.oWZ = getIntent().getStringExtra("Retr_MsgTalker");
        this.oXa = getIntent().getIntExtra("Retr_MsgAppBrandFromScene", 0);
        ak.vy().a((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
        if (!d.dW(19)) {
            setContentView(2130903185);
        }
        Intent intent2 = new Intent(this, SelectConversationUI.class);
        intent2.putExtra("scene", 8);
        intent2.putExtra("select_is_ret", true);
        if (this.oWV) {
            intent2.putExtra("mutil_select_is_ret", true);
        }
        switch (this.msgType) {
            case 2:
            case 6:
            case 7:
            case 14:
            case 15:
            case 16:
                intent2.putExtra("Retr_Big_File", getIntent().getBooleanExtra("Retr_Big_File", false));
                intent2.putExtra("Select_Conv_Type", 3);
                break;
            case 13:
                intent2.putExtra("Select_Conv_Type", 11);
                break;
            default:
                intent2.putExtra("Select_Conv_Type", 3);
                break;
        }
        intent2.putExtra("Retr_Msg_Type", this.msgType);
        intent2.putExtra("Retr_Msg_Id", this.bao);
        intent2.putExtra("Retr_Msg_content", this.blu);
        intent2.putExtra("image_path", this.aST);
        startActivityForResult(intent2, 0);
    }

    protected void onDestroy() {
        if (!this.oWM) {
            ak.vy().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
        }
        super.onDestroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bJF() {
        /*
        r15 = this;
        r6 = 2131755456; // 0x7f1001c0 float:1.9141792E38 double:1.053227136E-314;
        r7 = 2;
        r1 = 0;
        r4 = 1;
        r3 = 0;
        r0 = r15.oWK;
        switch(r0) {
            case 0: goto L_0x0023;
            case 1: goto L_0x0515;
            case 2: goto L_0x05c9;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = "MicroMsg.MsgRetransmitUI";
        r1 = "unknown scene %s";
        r2 = new java.lang.Object[r4];
        r4 = r15.oWK;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r0, r1, r2);
        r15.finish();
    L_0x0022:
        return;
    L_0x0023:
        r0 = r15.msgType;
        switch(r0) {
            case 0: goto L_0x007f;
            case 1: goto L_0x007f;
            case 2: goto L_0x003b;
            case 3: goto L_0x0028;
            case 4: goto L_0x008a;
            case 5: goto L_0x007f;
            case 6: goto L_0x003b;
            case 7: goto L_0x00ac;
            case 8: goto L_0x007f;
            case 9: goto L_0x00ca;
            case 10: goto L_0x003b;
            case 11: goto L_0x007f;
            case 12: goto L_0x003b;
            case 13: goto L_0x003b;
            case 14: goto L_0x003b;
            case 15: goto L_0x00a7;
            case 16: goto L_0x003b;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "unknown type %s";
        r5 = new java.lang.Object[r4];
        r6 = r15.msgType;
        r6 = java.lang.Integer.valueOf(r6);
        r5[r3] = r6;
        com.tencent.mm.sdk.platformtools.v.e(r0, r2, r5);
    L_0x003b:
        r0 = r4;
    L_0x003c:
        if (r0 == 0) goto L_0x0022;
    L_0x003e:
        r0 = r15.msgType;
        r2 = 11;
        if (r0 == r2) goto L_0x0048;
    L_0x0044:
        r0 = r15.msgType;
        if (r0 != r4) goto L_0x01ab;
    L_0x0048:
        r0 = r15.oWE;
        r2 = "MicroMsg.MsgRetransmitUI";
        r5 = "processVideoTransfer";
        com.tencent.mm.sdk.platformtools.v.i(r2, r5);
        r2 = 11;
        r5 = r15.msgType;
        if (r2 != r5) goto L_0x00e8;
    L_0x0059:
        r2 = r15.aST;
        r2 = com.tencent.mm.as.p.lr(r2);
        if (r2 == 0) goto L_0x00e8;
    L_0x0061:
        r0 = r15.getResources();
        r1 = 2131234920; // 0x7f081068 float:1.808602E38 double:1.052969957E-314;
        r0 = r0.getString(r1);
        r1 = "";
        com.tencent.mm.ui.snackbar.a.c(r15, r0, r1);
        r0 = r15.mHandler;
        r1 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$10;
        r1.<init>(r15);
        r2 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r0.postDelayed(r1, r2);
        goto L_0x0022;
    L_0x007f:
        r0 = r15.bJH();
        if (r0 != 0) goto L_0x003b;
    L_0x0085:
        r15.finish();
        r0 = r3;
        goto L_0x003c;
    L_0x008a:
        r0 = r15.blu;
        if (r0 == 0) goto L_0x0099;
    L_0x008e:
        r0 = r15.blu;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x003b;
    L_0x0099:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer text erro: content null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        r15.finish();
        r0 = r3;
        goto L_0x003c;
    L_0x00a7:
        r15.finish();
        r0 = r3;
        goto L_0x003c;
    L_0x00ac:
        r0 = r15.bJH();
        if (r0 != 0) goto L_0x00b7;
    L_0x00b2:
        r15.finish();
        r0 = r3;
        goto L_0x003c;
    L_0x00b7:
        r0 = r15.aST;
        if (r0 != 0) goto L_0x003b;
    L_0x00bb:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer fileName erro: fileName null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        r15.finish();
        r0 = r3;
        goto L_0x003c;
    L_0x00ca:
        r0 = r15.blu;
        if (r0 == 0) goto L_0x00d9;
    L_0x00ce:
        r0 = r15.blu;
        r2 = "";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x003b;
    L_0x00d9:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Transfer text erro: content null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        r15.finish();
        r0 = r3;
        goto L_0x003c;
    L_0x00e8:
        r6 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$b;
        r6.<init>();
        r2 = new java.util.LinkedList;
        r2.<init>();
        r6.oXp = r2;
        r2 = r6.oXp;
        r2.addAll(r0);
        r7 = r0.iterator();
    L_0x00fd:
        r0 = r7.hasNext();
        if (r0 == 0) goto L_0x0022;
    L_0x0103:
        r0 = r7.next();
        r0 = (java.lang.String) r0;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$a;
        r2.<init>();
        r5 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r15.getString(r5);
        r5 = 2131231151; // 0x7f0801af float:1.8078375E38 double:1.052968095E-314;
        r5 = r15.getString(r5);
        r8 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$6;
        r8.<init>(r15, r2);
        r5 = com.tencent.mm.ui.base.g.a(r15, r5, r4, r8);
        r15.dwR = r5;
        r2.context = r15;
        r5 = r15.aST;
        r2.aST = r5;
        r5 = r15.dwR;
        r2.dxy = r5;
        r5 = r15.oWJ;
        r2.oWJ = r5;
        r5 = r15.length;
        r2.dhK = r5;
        r5 = r15.msgType;
        r2.dgq = r5;
        r2.oXj = r3;
        r2.userName = r0;
        r2.oXk = r4;
        r5 = r15.oWH;
        r2.oWH = r5;
        r2.oXn = r6;
        r5 = r15.aST;
        r5 = com.tencent.mm.as.p.lp(r5);
        if (r5 == 0) goto L_0x0167;
    L_0x0150:
        r8 = r5.dhT;
        if (r8 == 0) goto L_0x0167;
    L_0x0154:
        r8 = "MicroMsg.MsgRetransmitUI";
        r9 = "msgRetrans streamvideo";
        com.tencent.mm.sdk.platformtools.v.d(r8, r9);
        r8 = r5.dhT;
        r2.oXm = r8;
        r5 = r5.Ld();
        r2.bNo = r5;
    L_0x0167:
        r5 = new java.lang.Object[r3];
        r2.execute(r5);
        r2 = com.tencent.mm.model.bl.zQ();
        r5 = com.tencent.mm.model.bl.cvn;
        r2.b(r5, r1);
        r8 = r15.bao;
        r10 = -1;
        r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r2 == 0) goto L_0x0022;
    L_0x017d:
        com.tencent.mm.model.ak.yW();
        r2 = com.tencent.mm.model.c.wJ();
        r8 = r15.bao;
        r8 = r2.ek(r8);
        r9 = com.tencent.mm.model.m.dE(r0);
        if (r9 == 0) goto L_0x01a3;
    L_0x0190:
        r2 = com.tencent.mm.ui.chatting.a.c.Chatroom;
    L_0x0192:
        r5 = r15.oWT;
        if (r5 == 0) goto L_0x01a6;
    L_0x0196:
        r5 = com.tencent.mm.ui.chatting.a.d.Full;
    L_0x0198:
        if (r9 == 0) goto L_0x01a9;
    L_0x019a:
        r0 = com.tencent.mm.model.i.el(r0);
    L_0x019e:
        com.tencent.mm.ui.chatting.a.a(r2, r5, r8, r0);
        goto L_0x00fd;
    L_0x01a3:
        r2 = com.tencent.mm.ui.chatting.a.c.Chat;
        goto L_0x0192;
    L_0x01a6:
        r5 = com.tencent.mm.ui.chatting.a.d.Samll;
        goto L_0x0198;
    L_0x01a9:
        r0 = r3;
        goto L_0x019e;
    L_0x01ab:
        r0 = r15.msgType;
        if (r0 != 0) goto L_0x01b7;
    L_0x01af:
        r0 = r15.oWE;
        r0 = r0.size();
        r15.oWW = r0;
    L_0x01b7:
        r0 = r15.oWE;
        r0 = r0.size();
        r2 = r15.oWE;
        r8 = r2.iterator();
        r5 = r0;
        r2 = r4;
    L_0x01c5:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x039c;
    L_0x01cb:
        r0 = r8.next();
        r0 = (java.lang.String) r0;
        r5 = r5 + -1;
        if (r5 != 0) goto L_0x01e5;
    L_0x01d5:
        r6 = r4;
    L_0x01d6:
        r9 = r15.msgType;
        switch(r9) {
            case 0: goto L_0x01e7;
            case 1: goto L_0x01db;
            case 2: goto L_0x01fc;
            case 3: goto L_0x01db;
            case 4: goto L_0x0201;
            case 5: goto L_0x0218;
            case 6: goto L_0x02f2;
            case 7: goto L_0x0310;
            case 8: goto L_0x0327;
            case 9: goto L_0x033a;
            case 10: goto L_0x034d;
            case 11: goto L_0x01db;
            case 12: goto L_0x0374;
            case 13: goto L_0x037a;
            case 14: goto L_0x0380;
            case 15: goto L_0x01db;
            case 16: goto L_0x01fc;
            default: goto L_0x01db;
        };
    L_0x01db:
        r0 = r2;
    L_0x01dc:
        r2 = r15.oWR;
        if (r2 == 0) goto L_0x01e3;
    L_0x01e0:
        com.tencent.mm.ui.chatting.y.jF(r6);
    L_0x01e3:
        r2 = r0;
        goto L_0x01c5;
    L_0x01e5:
        r6 = r3;
        goto L_0x01d6;
    L_0x01e7:
        r9 = com.tencent.mm.model.ak.vA();
        r9.btu();
        r9 = com.tencent.mm.model.ak.vA();
        r10 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$1;
        r10.<init>(r15, r0);
        r9.x(r10);
        r0 = r2;
        goto L_0x01dc;
    L_0x01fc:
        r0 = r15.PF(r0);
        goto L_0x01dc;
    L_0x0201:
        com.tencent.mm.model.k.xF();
        r2 = new com.tencent.mm.modelmulti.i;
        r9 = r15.blu;
        r10 = com.tencent.mm.model.m.fp(r0);
        r2.<init>(r0, r9, r10);
        r0 = com.tencent.mm.model.ak.vy();
        r0.a(r2, r3);
        r0 = r4;
        goto L_0x01dc;
    L_0x0218:
        r2 = r15.aST;
        if (r2 != 0) goto L_0x021e;
    L_0x021c:
        r0 = r3;
        goto L_0x01dc;
    L_0x021e:
        r2 = com.tencent.mm.pluginsdk.j.a.bmr();
        r9 = r15.aST;
        r9 = r2.rg(r9);
        if (r9 != 0) goto L_0x0293;
    L_0x022a:
        r2 = r3;
    L_0x022b:
        if (r9 == 0) goto L_0x02a2;
    L_0x022d:
        r10 = com.tencent.mm.h.b.sJ();
        if (r2 <= r10) goto L_0x02a2;
    L_0x0233:
        r0 = "MicroMsg.MsgRetransmitUI";
        r10 = "emoji is over size. md5:%s size:%d";
        r11 = new java.lang.Object[r7];
        r12 = r9.EB();
        r11[r3] = r12;
        r12 = r15.length;
        r12 = java.lang.Integer.valueOf(r12);
        r11[r4] = r12;
        com.tencent.mm.sdk.platformtools.v.i(r0, r10, r11);
        r15.oXb = r3;
        r15.oWH = r3;
        r0 = 2131232336; // 0x7f080650 float:1.8080778E38 double:1.0529686805E-314;
        r0 = r15.getString(r0);
        r10 = "";
        r11 = 2131233285; // 0x7f080a05 float:1.8082703E38 double:1.0529691494E-314;
        r11 = r15.getString(r11);
        r12 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$12;
        r12.<init>(r15);
        com.tencent.mm.ui.base.g.a(r15, r0, r10, r11, r12);
        r0 = r15.oWS;
        if (r0 != r4) goto L_0x0290;
    L_0x026d:
        r0 = com.tencent.mm.plugin.report.service.g.iuh;
        r10 = 13459; // 0x3493 float:1.886E-41 double:6.6496E-320;
        r11 = 4;
        r11 = new java.lang.Object[r11];
        r2 = java.lang.Integer.valueOf(r2);
        r11[r3] = r2;
        r2 = java.lang.Integer.valueOf(r4);
        r11[r4] = r2;
        r2 = r9.EB();
        r11[r7] = r2;
        r2 = 3;
        r9 = java.lang.Integer.valueOf(r4);
        r11[r2] = r9;
        r0.h(r10, r11);
    L_0x0290:
        r0 = r4;
        goto L_0x01dc;
    L_0x0293:
        r2 = r9.field_groupId;
        r10 = r9.EB();
        r2 = r9.dR(r2, r10);
        r2 = com.tencent.mm.a.e.aQ(r2);
        goto L_0x022b;
    L_0x02a2:
        r10 = r15.oWS;
        if (r10 != r4) goto L_0x02c9;
    L_0x02a6:
        r10 = com.tencent.mm.plugin.report.service.g.iuh;
        r11 = 13459; // 0x3493 float:1.886E-41 double:6.6496E-320;
        r12 = 4;
        r12 = new java.lang.Object[r12];
        r13 = java.lang.Integer.valueOf(r2);
        r12[r3] = r13;
        r13 = java.lang.Integer.valueOf(r3);
        r12[r4] = r13;
        r13 = r9.EB();
        r12[r7] = r13;
        r13 = 3;
        r14 = java.lang.Integer.valueOf(r4);
        r12[r13] = r14;
        r10.h(r11, r12);
    L_0x02c9:
        if (r9 == 0) goto L_0x02d7;
    L_0x02cb:
        r10 = com.tencent.mm.h.b.sH();
        if (r2 <= r10) goto L_0x02d7;
    L_0x02d1:
        com.tencent.mm.ui.chatting.x.b(r9, r0);
        r0 = r4;
        goto L_0x01dc;
    L_0x02d7:
        r2 = com.tencent.mm.pluginsdk.j.a.bmr();
        r9 = r15.aST;
        r0 = r2.l(r15, r0, r9);
        if (r0 == 0) goto L_0x02e6;
    L_0x02e3:
        r0 = r4;
        goto L_0x01dc;
    L_0x02e6:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "Retransmit emoji failed.";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        r0 = r3;
        goto L_0x01dc;
    L_0x02f2:
        r2 = r15.blu;
        r2 = com.tencent.mm.sdk.platformtools.be.KK(r2);
        r2 = com.tencent.mm.q.a.a.dV(r2);
        if (r2 != 0) goto L_0x030a;
    L_0x02fe:
        r0 = "MicroMsg.MsgRetransmitUI";
        r2 = "transfer app message error: app content null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        r0 = r3;
        goto L_0x01dc;
    L_0x030a:
        r15.a(r0, r2, r1);
        r0 = r4;
        goto L_0x01dc;
    L_0x0310:
        r2 = r15.aST;
        r9 = r15.length;
        r0 = com.tencent.mm.modelvoice.q.c(r0, r2, r9);
        r2 = new com.tencent.mm.modelvoice.f;
        r2.<init>(r0, r4);
        r0 = com.tencent.mm.model.ak.vy();
        r0.a(r2, r3);
        r0 = r4;
        goto L_0x01dc;
    L_0x0327:
        r9 = new com.tencent.mm.modelmulti.i;
        r10 = r15.blu;
        r11 = 42;
        r9.<init>(r0, r10, r11);
        r0 = com.tencent.mm.model.ak.vy();
        r0.a(r9, r3);
        r0 = r2;
        goto L_0x01dc;
    L_0x033a:
        r2 = new com.tencent.mm.modelmulti.i;
        r9 = r15.blu;
        r10 = 48;
        r2.<init>(r0, r9, r10);
        r0 = com.tencent.mm.model.ak.vy();
        r0.a(r2, r3);
        r0 = r4;
        goto L_0x01dc;
    L_0x034d:
        r9 = new com.tencent.mm.e.a.kw;
        r9.<init>();
        r10 = r9.bmf;
        r11 = 4;
        r10.type = r11;
        r10 = r9.bmf;
        com.tencent.mm.model.ak.yW();
        r11 = com.tencent.mm.model.c.wJ();
        r12 = r15.bao;
        r11 = r11.ek(r12);
        r10.bmk = r11;
        r10 = r9.bmf;
        r10.toUser = r0;
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r0.z(r9);
        r0 = r2;
        goto L_0x01dc;
    L_0x0374:
        com.tencent.mm.ui.chatting.y.k(r15, r0, r6);
        r0 = r2;
        goto L_0x01dc;
    L_0x037a:
        com.tencent.mm.ui.chatting.y.j(r15, r0, r6);
        r0 = r2;
        goto L_0x01dc;
    L_0x0380:
        r9 = new com.tencent.mm.e.a.nb;
        r9.<init>();
        r10 = r9.bop;
        r12 = r15.bao;
        r10.aYG = r12;
        r10 = r9.bop;
        r11 = r15.blu;
        r10.bgD = r11;
        r10 = r9.bop;
        r10.bgE = r0;
        r0 = com.tencent.mm.sdk.c.a.nhr;
        r0.z(r9);
        goto L_0x01db;
    L_0x039c:
        r0 = r15.oWE;
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r1 = r15.msgType;
        switch(r1) {
            case 0: goto L_0x03ae;
            case 1: goto L_0x0022;
            case 2: goto L_0x03ae;
            case 3: goto L_0x03a9;
            case 4: goto L_0x03ae;
            case 5: goto L_0x03ae;
            case 6: goto L_0x03ae;
            case 7: goto L_0x03ae;
            case 8: goto L_0x03ae;
            case 9: goto L_0x03ae;
            case 10: goto L_0x03ae;
            case 11: goto L_0x0022;
            case 12: goto L_0x03ae;
            case 13: goto L_0x03ae;
            case 14: goto L_0x03ae;
            case 15: goto L_0x03a9;
            case 16: goto L_0x03ae;
            default: goto L_0x03a9;
        };
    L_0x03a9:
        r15.finish();
        goto L_0x0022;
    L_0x03ae:
        r1 = r15.msgType;
        if (r1 == r7) goto L_0x03b8;
    L_0x03b2:
        r1 = r15.msgType;
        r5 = 16;
        if (r1 != r5) goto L_0x0442;
    L_0x03b8:
        r1 = r15.blu;
        r1 = com.tencent.mm.sdk.platformtools.be.KK(r1);
        r6 = com.tencent.mm.q.a.a.dV(r1);
        if (r6 == 0) goto L_0x0492;
    L_0x03c4:
        r1 = r6.type;
        r5 = 5;
        if (r1 != r5) goto L_0x0492;
    L_0x03c9:
        r1 = r6.url;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 != 0) goto L_0x0492;
    L_0x03d1:
        r5 = "";
        r1 = r6.url;	 Catch:{ UnsupportedEncodingException -> 0x0481 }
        r8 = "UTF-8";
        r1 = java.net.URLEncoder.encode(r1, r8);	 Catch:{ UnsupportedEncodingException -> 0x0481 }
        r5 = r1;
    L_0x03de:
        if (r2 == 0) goto L_0x048f;
    L_0x03e0:
        r1 = r4;
    L_0x03e1:
        r8 = "MicroMsg.MsgRetransmitUI";
        r9 = "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d";
        r10 = 6;
        r10 = new java.lang.Object[r10];
        r11 = 13378; // 0x3442 float:1.8747E-41 double:6.6096E-320;
        r11 = java.lang.Integer.valueOf(r11);
        r10[r3] = r11;
        r6 = r6.url;
        r10[r4] = r6;
        r12 = r15.startTime;
        r6 = java.lang.Long.valueOf(r12);
        r10[r7] = r6;
        r6 = 3;
        r11 = r15.oWX;
        r11 = java.lang.Integer.valueOf(r11);
        r10[r6] = r11;
        r6 = 4;
        r11 = java.lang.Integer.valueOf(r4);
        r10[r6] = r11;
        r6 = 5;
        r11 = java.lang.Integer.valueOf(r1);
        r10[r6] = r11;
        com.tencent.mm.sdk.platformtools.v.d(r8, r9, r10);
        r6 = com.tencent.mm.plugin.report.service.g.iuh;
        r8 = 13378; // 0x3442 float:1.8747E-41 double:6.6096E-320;
        r9 = 5;
        r9 = new java.lang.Object[r9];
        r9[r3] = r5;
        r10 = r15.startTime;
        r3 = java.lang.Long.valueOf(r10);
        r9[r4] = r3;
        r3 = r15.oWX;
        r3 = java.lang.Integer.valueOf(r3);
        r9[r7] = r3;
        r3 = 3;
        r4 = java.lang.Integer.valueOf(r4);
        r9[r3] = r4;
        r3 = 4;
        r1 = java.lang.Integer.valueOf(r1);
        r9[r3] = r1;
        r6.h(r8, r9);
    L_0x0442:
        if (r2 == 0) goto L_0x0510;
    L_0x0444:
        r1 = r15.oWH;
        if (r1 == 0) goto L_0x0452;
    L_0x0448:
        r1 = 2131233278; // 0x7f0809fe float:1.8082689E38 double:1.052969146E-314;
        r1 = r15.getString(r1);
        com.tencent.mm.ui.snackbar.a.f(r15, r1);
    L_0x0452:
        r1 = r15.oXb;
        if (r1 == 0) goto L_0x0462;
    L_0x0456:
        r1 = r15.mHandler;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$3;
        r2.<init>(r15);
        r4 = 1800; // 0x708 float:2.522E-42 double:8.893E-321;
        r1.postDelayed(r2, r4);
    L_0x0462:
        r1 = r15.oWG;
        if (r1 == 0) goto L_0x0022;
    L_0x0466:
        r1 = r15.oWU;
        if (r1 != 0) goto L_0x0022;
    L_0x046a:
        r1 = new android.content.Intent;
        r2 = com.tencent.mm.ui.chatting.ChattingUI.class;
        r1.<init>(r15, r2);
        r2 = 67108864; // 0x4000000 float:1.5046328E-36 double:3.31561842E-316;
        r1.addFlags(r2);
        r2 = "Chat_User";
        r1.putExtra(r2, r0);
        r15.startActivity(r1);
        goto L_0x0022;
    L_0x0481:
        r1 = move-exception;
        r8 = "MicroMsg.MsgRetransmitUI";
        r9 = "";
        r10 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.v.a(r8, r1, r9, r10);
        goto L_0x03de;
    L_0x048f:
        r1 = r7;
        goto L_0x03e1;
    L_0x0492:
        if (r2 != 0) goto L_0x0442;
    L_0x0494:
        if (r6 == 0) goto L_0x0442;
    L_0x0496:
        r1 = r6.type;
        r3 = 33;
        if (r1 != r3) goto L_0x0442;
    L_0x049c:
        r1 = new com.tencent.mm.e.a.n;
        r1.<init>();
        r3 = r1.aWO;
        r5 = r15.oXa;
        r3.scene = r5;
        r3 = r15.oXa;
        if (r7 != r3) goto L_0x0504;
    L_0x04ab:
        r3 = r1.aWO;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r8 = r15.oWZ;
        r5 = r5.append(r8);
        r8 = ":";
        r5 = r5.append(r8);
        r8 = r15.oWY;
        r5 = r5.append(r8);
        r5 = r5.toString();
        r3.aWP = r5;
    L_0x04cb:
        r3 = "@chatroom";
        r3 = r0.endsWith(r3);
        if (r3 == 0) goto L_0x050b;
    L_0x04d4:
        r3 = r1.aWO;
        r3.action = r7;
    L_0x04d8:
        r3 = r1.aWO;
        r4 = r6.cqo;
        r3.aWQ = r4;
        r3 = r1.aWO;
        r4 = r6.cqp;
        r3.aWH = r4;
        r3 = r1.aWO;
        r4 = r6.cqq;
        r3.appId = r4;
        r3 = r1.aWO;
        r4 = "";
        r3.aWR = r4;
        r3 = r1.aWO;
        r4 = com.tencent.mm.sdk.platformtools.be.Nh();
        r3.aWS = r4;
        r3 = r1.aWO;
        r3.aWT = r7;
        r3 = com.tencent.mm.sdk.c.a.nhr;
        r3.z(r1);
        goto L_0x0442;
    L_0x0504:
        r3 = r1.aWO;
        r5 = r15.oWZ;
        r3.aWP = r5;
        goto L_0x04cb;
    L_0x050b:
        r3 = r1.aWO;
        r3.action = r4;
        goto L_0x04d8;
    L_0x0510:
        r15.finish();
        goto L_0x0022;
    L_0x0515:
        r0 = r15.oWE;
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r1 = r15.bJH();
        if (r1 != 0) goto L_0x0528;
    L_0x0523:
        r15.finish();
        goto L_0x0022;
    L_0x0528:
        r1 = r15.msgType;
        switch(r1) {
            case 0: goto L_0x052f;
            case 1: goto L_0x059e;
            case 11: goto L_0x059e;
            default: goto L_0x052d;
        };
    L_0x052d:
        goto L_0x0022;
    L_0x052f:
        r1 = r15.oWN;
        if (r1 == 0) goto L_0x0543;
    L_0x0533:
        r1 = r15.oWN;
        r1 = r1.size();
        if (r1 <= 0) goto L_0x0543;
    L_0x053b:
        r1 = r15.oWN;
        r1 = r1.size();
        r15.oWP = r1;
    L_0x0543:
        r1 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$13;
        r1.<init>(r15);
        r15.cMP = r1;
        r1 = 2131233901; // 0x7f080c6d float:1.8083953E38 double:1.0529694537E-314;
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r5 = java.lang.Integer.valueOf(r4);
        r2[r3] = r5;
        r5 = r15.oWP;
        r5 = java.lang.Integer.valueOf(r5);
        r2[r4] = r5;
        r4 = java.lang.Integer.valueOf(r3);
        r2[r7] = r4;
        r1 = r15.getString(r1, r2);
        r2 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r2 = r15.getString(r2);
        r4 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$14;
        r4.<init>(r15);
        r1 = com.tencent.mm.ui.base.g.a(r15, r1, r2, r4);
        r15.oWI = r1;
        r1 = r15.oWI;
        r2 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$2;
        r2.<init>(r15);
        r1.setOnCancelListener(r2);
        r1 = r15.oWI;
        r1.setCanceledOnTouchOutside(r3);
        r1 = r15.oWI;
        r2 = -1;
        r1 = r1.getButton(r2);
        r2 = 2131231010; // 0x7f080122 float:1.8078089E38 double:1.0529680254E-314;
        r1.setText(r2);
        r1 = 3;
        r2 = r15.cMP;
        r15.a(r0, r1, r2);
        goto L_0x0022;
    L_0x059e:
        r1 = com.tencent.mm.network.aa.bk(r15);
        if (r1 != 0) goto L_0x05c0;
    L_0x05a4:
        r1 = 2131235789; // 0x7f0813cd float:1.8087782E38 double:1.0529703865E-314;
        r2 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
        r3 = 2131231107; // 0x7f080183 float:1.8078286E38 double:1.0529680733E-314;
        r4 = 2131231010; // 0x7f080122 float:1.8078089E38 double:1.0529680254E-314;
        r5 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$8;
        r5.<init>(r15, r0);
        r6 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$9;
        r6.<init>(r15);
        r0 = r15;
        com.tencent.mm.ui.base.g.a(r0, r1, r2, r3, r4, r5, r6);
        goto L_0x0022;
    L_0x05c0:
        r1 = r15.getIntent();
        r15.k(r1, r0);
        goto L_0x0022;
    L_0x05c9:
        r0 = r15.msgType;
        switch(r0) {
            case 2: goto L_0x05d0;
            case 16: goto L_0x05d0;
            default: goto L_0x05ce;
        };
    L_0x05ce:
        goto L_0x0022;
    L_0x05d0:
        r0 = r15.oWE;
        r0.get(r3);
        r0 = r15.getIntent();
        r0 = r0.getExtras();
        r2 = "_mmessage_appPackage";
        r0 = r0.getString(r2);
        r5 = new com.tencent.mm.pluginsdk.model.app.f;
        r5.<init>();
        r5.field_packageName = r0;
        r0 = com.tencent.mm.pluginsdk.model.app.am.bnB();
        r2 = new java.lang.String[r4];
        r4 = "packageName";
        r2[r3] = r4;
        r0.b(r5, r2);
        r0 = new com.tencent.mm.sdk.modelmsg.c$a;
        r2 = r15.getIntent();
        r2 = r2.getExtras();
        r0.<init>(r2);
        r4 = r0.nhM;
        r0 = new com.tencent.mm.ui.transmit.MsgRetransmitUI$7;
        r0.<init>(r15);
        r7 = new com.tencent.mm.ui.transmit.a;
        r7.<init>(r0);
        r0 = r4.thumbData;
        if (r0 != 0) goto L_0x063e;
    L_0x0616:
        r2 = r1;
    L_0x0617:
        r0 = r4.mediaObject;
        r0 = r0.type();
        switch(r0) {
            case 1: goto L_0x0646;
            case 2: goto L_0x0689;
            case 3: goto L_0x06a9;
            case 4: goto L_0x06d7;
            case 5: goto L_0x0735;
            case 6: goto L_0x0706;
            case 7: goto L_0x0764;
            default: goto L_0x0620;
        };
    L_0x0620:
        r0 = "MicroMsg.SendAppMessage";
        r1 = new java.lang.StringBuilder;
        r2 = "unkown app message type, skipped, type=";
        r1.<init>(r2);
        r2 = r4.mediaObject;
        r2 = r2.type();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x0022;
    L_0x063e:
        r0 = r4.thumbData;
        r0 = com.tencent.mm.sdk.platformtools.d.bc(r0);
        r2 = r0;
        goto L_0x0617;
    L_0x0646:
        r0 = 2130903133; // 0x7f03005d float:1.7413075E38 double:1.0528060326E-314;
        r2 = android.view.View.inflate(r15, r0, r1);
        r0 = r2.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r3 = r4.title;
        r0.setText(r3);
    L_0x0658:
        r0 = 2131755459; // 0x7f1001c3 float:1.9141798E38 double:1.0532271376E-314;
        r0 = r2.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r3 = com.tencent.mm.pluginsdk.model.app.g.a(r15, r5, r1);
        r0.setText(r3);
        r0 = 2131231149; // 0x7f0801ad float:1.807837E38 double:1.052968094E-314;
        r3 = r15.getString(r0);
        r0 = 2131231010; // 0x7f080122 float:1.8078089E38 double:1.0529680254E-314;
        r4 = r15.getString(r0);
        r5 = new com.tencent.mm.ui.transmit.a$1;
        r5.<init>(r7);
        r6 = new com.tencent.mm.ui.transmit.a$2;
        r6.<init>(r7);
        r0 = r15;
        r0 = com.tencent.mm.ui.base.g.a(r0, r1, r2, r3, r4, r5, r6);
        r7.iji = r0;
        goto L_0x0022;
    L_0x0689:
        r0 = 2130903132; // 0x7f03005c float:1.7413073E38 double:1.052806032E-314;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = 2131755457; // 0x7f1001c1 float:1.9141794E38 double:1.0532271366E-314;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = r3.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r2 = r4.title;
        r0.setText(r2);
        r2 = r3;
        goto L_0x0658;
    L_0x06a9:
        r0 = 2130903131; // 0x7f03005b float:1.7413071E38 double:1.0528060316E-314;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = 2131755457; // 0x7f1001c1 float:1.9141794E38 double:1.0532271366E-314;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = r3.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r2 = 2131755458; // 0x7f1001c2 float:1.9141796E38 double:1.053227137E-314;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0658;
    L_0x06d7:
        r0 = 2130903131; // 0x7f03005b float:1.7413071E38 double:1.0528060316E-314;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = 2131755457; // 0x7f1001c1 float:1.9141794E38 double:1.0532271366E-314;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = r3.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r2 = 2131755458; // 0x7f1001c2 float:1.9141796E38 double:1.053227137E-314;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0658;
    L_0x0706:
        r0 = 2130903131; // 0x7f03005b float:1.7413071E38 double:1.0528060316E-314;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = 2131755457; // 0x7f1001c1 float:1.9141794E38 double:1.0532271366E-314;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = r3.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r2 = 2131755458; // 0x7f1001c2 float:1.9141796E38 double:1.053227137E-314;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0658;
    L_0x0735:
        r0 = 2130903131; // 0x7f03005b float:1.7413071E38 double:1.0528060316E-314;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = 2131755457; // 0x7f1001c1 float:1.9141794E38 double:1.0532271366E-314;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = r3.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r2 = 2131755458; // 0x7f1001c2 float:1.9141796E38 double:1.053227137E-314;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0658;
    L_0x0764:
        r0 = 2130903131; // 0x7f03005b float:1.7413071E38 double:1.0528060316E-314;
        r3 = android.view.View.inflate(r15, r0, r1);
        r0 = 2131755457; // 0x7f1001c1 float:1.9141794E38 double:1.0532271366E-314;
        r0 = r3.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0.setImageBitmap(r2);
        r0 = r3.findViewById(r6);
        r0 = (android.widget.TextView) r0;
        r2 = 2131755458; // 0x7f1001c2 float:1.9141796E38 double:1.053227137E-314;
        r2 = r3.findViewById(r2);
        r2 = (android.widget.TextView) r2;
        r6 = r4.title;
        r0.setText(r6);
        r0 = r4.description;
        r2.setText(r0);
        r2 = r3;
        goto L_0x0658;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.bJF():void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str;
        if (i2 != -1) {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(this.blu));
            if (dV != null && dV.type == 5 && dV.url != null) {
                v.d("MicroMsg.MsgRetransmitUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), dV.url, Long.valueOf(this.startTime), Integer.valueOf(this.oWX), Integer.valueOf(1), Integer.valueOf(3));
                str = SQLiteDatabase.KeyEmpty;
                try {
                    str = URLEncoder.encode(dV.url, "UTF-8");
                } catch (Throwable e) {
                    v.a("MicroMsg.MsgRetransmitUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                g.iuh.h(13378, str, Long.valueOf(this.startTime), Integer.valueOf(this.oWX), Integer.valueOf(1), Integer.valueOf(3));
            } else if (dV != null && dV.type == 33) {
                com.tencent.mm.sdk.c.b nVar = new n();
                nVar.aWO.scene = this.oWX;
                if (2 == this.oWX) {
                    nVar.aWO.aWP = this.oWZ + ":" + this.oWY;
                } else {
                    nVar.aWO.aWP = this.oWZ;
                }
                nVar.aWO.aWQ = dV.cqo;
                nVar.aWO.aWH = dV.cqp;
                nVar.aWO.appId = dV.cqq;
                nVar.aWO.action = 1;
                nVar.aWO.aWR = SQLiteDatabase.KeyEmpty;
                nVar.aWO.aWS = be.Nh();
                nVar.aWO.aWT = 3;
                com.tencent.mm.sdk.c.a.nhr.z(nVar);
            }
            finish();
        } else if (i != 0) {
            v.e("MicroMsg.MsgRetransmitUI", "onActivityResult, unknown requestCode = " + i);
        } else {
            this.oWE = be.g(intent.getStringExtra("Select_Conv_User").split(","));
            Object stringExtra = intent.getStringExtra("custom_send_text");
            this.lKa = intent.getBooleanExtra("key_is_biz_chat", false);
            if (this.lKa) {
                this.ezh = intent.getLongExtra("key_biz_chat_id", -1);
            }
            int intExtra = intent.getIntExtra("Retr_Msg_Type", -1);
            if (intExtra != -1) {
                v.i("MicroMsg.MsgRetransmitUI", "summerbig replace msgType %d->%d", Integer.valueOf(this.msgType), Integer.valueOf(intExtra));
                this.msgType = intExtra;
            }
            v.i("MicroMsg.MsgRetransmitUI", "summersafecdn onActivityResult doRetransmit msgType[%d], iScene[%d], size[%d]", Integer.valueOf(this.msgType), Integer.valueOf(this.oWK), Integer.valueOf(this.oWE.size()));
            bJF();
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str2 : this.oWE) {
                    com.tencent.mm.sdk.c.b mrVar = new mr();
                    mrVar.boa.bob = str2;
                    mrVar.boa.content = stringExtra;
                    mrVar.boa.type = m.fp(str2);
                    mrVar.boa.flags = 0;
                    com.tencent.mm.sdk.c.a.nhr.z(mrVar);
                }
            }
        }
    }

    private boolean PF(String str) {
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(this.blu));
        v.d("MicroMsg.MsgRetransmitUI", "summerbig processAppMessageTransfer msgContent[%s], content[%s]", this.blu, dV);
        if (dV == null) {
            v.e("MicroMsg.MsgRetransmitUI", "transfer app message error: app content null");
            return false;
        }
        ak.yW();
        bx ek = c.wJ().ek(this.bao);
        if (ek.bwa() || ek.bvZ()) {
            x.a(this, str, this.blu, ek.field_isSend, this.oiH);
        } else {
            byte[] bArr = null;
            if (this.oWF != null) {
                try {
                    bArr = FileOp.c(this.oWF, 0, -1);
                    if (!bq(bArr)) {
                        return false;
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.MsgRetransmitUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                }
            } else if (!(this.ooy >= 0 || ek.field_imgPath == null || ek.field_imgPath.equals(SQLiteDatabase.KeyEmpty))) {
                try {
                    bArr = FileOp.c(com.tencent.mm.ae.n.GH().w(ek.field_imgPath, true), 0, -1);
                    if (!bq(bArr)) {
                        return false;
                    }
                } catch (Exception e2) {
                    v.e("MicroMsg.MsgRetransmitUI", "send appmsg to %s, error:%s", str, e2.getLocalizedMessage());
                }
            }
            a(str, dV, bArr);
        }
        return true;
    }

    private void a(String str, com.tencent.mm.q.a.a aVar, byte[] bArr) {
        v.d("MicroMsg.MsgRetransmitUI", "summerbig send toUser[%s], attachid[%s]", str, aVar.aXa);
        com.tencent.mm.pluginsdk.model.app.b GD = l.GD(aVar.aXa);
        String str2 = SQLiteDatabase.KeyEmpty;
        if (!(GD == null || GD.field_fileFullPath == null || GD.field_fileFullPath.equals(SQLiteDatabase.KeyEmpty))) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            str2 = stringBuilder.append(c.xd()).append("da_").append(be.Ni()).toString();
            FileOp.p(GD.field_fileFullPath, str2);
            v.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath[%s]， finish[%b]", str2, Boolean.valueOf(GD.bnj()));
        }
        final com.tencent.mm.q.a.a a = com.tencent.mm.q.a.a.a(aVar);
        a.coe = 3;
        if (!be.kS(str2) || (aVar.cof == 0 && aVar.cob <= 26214400)) {
            l.a(a, aVar.appId, aVar.appName, str, str2, bArr, this.jGE);
            return;
        }
        v.i("MicroMsg.MsgRetransmitUI", "summerbig send attachPath is null islargefilemsg[%d], attachlen[%d]", Integer.valueOf(aVar.cof), Integer.valueOf(aVar.cob));
        final com.tencent.mm.q.a.a aVar2 = aVar;
        final String str3 = str;
        final byte[] bArr2 = bArr;
        ak.vy().a(new y(aVar, null, str, new com.tencent.mm.pluginsdk.model.app.y.a(this) {
            final /* synthetic */ MsgRetransmitUI oXd;

            public final void a(String str, String str2, String str3, String str4, String str5, long j) {
                v.i("MicroMsg.MsgRetransmitUI", "summerbig CheckBigFile callback new md5[%s], aesKey[%s], signature[%s], old aeskey[%s], faesKey[%s], fsignature[%s]", str, be.KW(str2), be.KW(str3), be.KW(aVar2.cop), be.KW(str4), be.KW(str5));
                if (be.kS(str3)) {
                    com.tencent.mm.ui.base.g.A(this.oXd, this.oXd.getString(2131232229), SQLiteDatabase.KeyEmpty);
                    this.oXd.finish();
                    return;
                }
                l.a(a, aVar2.appId, aVar2.appName, str3, SQLiteDatabase.KeyEmpty, bArr2, this.oXd.jGE, str3);
            }
        }), 0);
    }

    private boolean bJH() {
        ak.yW();
        if (c.isSDCardAvailable()) {
            return true;
        }
        v.e("MicroMsg.MsgRetransmitUI", "sdcard is not available, type = " + this.msgType);
        s.ey(this);
        return false;
    }

    private void k(Intent intent, String str) {
        if (this.oWQ) {
            this.oWP = this.oWN.size();
            ArrayList parcelableArrayList = intent.getExtras().getParcelableArrayList("android.intent.extra.STREAM");
            if (parcelableArrayList == null || parcelableArrayList.size() <= 0) {
                finish();
                return;
            }
            Iterator it = parcelableArrayList.iterator();
            while (it.hasNext()) {
                it.next();
                if (!this.oXc) {
                    PG(str);
                } else {
                    return;
                }
            }
            return;
        }
        this.oWP = 1;
        PG(str);
    }

    private void PG(String str) {
        v.i("MicroMsg.MsgRetransmitUI", "sendMultiVedeo");
        final Object hVar = new com.tencent.mm.pluginsdk.model.h(this, null, getIntent(), str, 1, new com.tencent.mm.pluginsdk.model.h.a(this) {
            final /* synthetic */ MsgRetransmitUI oXd;

            {
                this.oXd = r1;
            }

            public final void bmV() {
                if (this.oXd.dwR != null) {
                    this.oXd.dwR.dismiss();
                    this.oXd.dwR = null;
                }
                this.oXd.finish();
            }
        });
        com.tencent.mm.sdk.i.e.a(hVar, "ChattingUI_importMultiVideo");
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a((Context) this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ MsgRetransmitUI oXd;

            public final void onCancel(DialogInterface dialogInterface) {
                hVar.bmS();
                this.oXd.oXc = true;
                this.oXd.finish();
            }
        });
    }

    private void a(String str, int i, f fVar) {
        String str2;
        String xF = com.tencent.mm.model.k.xF();
        String str3 = SQLiteDatabase.KeyEmpty;
        ak.yW();
        bx ek = c.wJ().ek(this.bao);
        if (ek.field_msgId == this.bao) {
            str3 = ek.field_content;
        }
        if (str3 != null || ek.field_msgSvrId <= 0) {
            str2 = str3;
        } else {
            str2 = com.tencent.mm.ae.n.GH().ah(ek.field_msgSvrId).cLF;
        }
        if (!be.kS(this.aST)) {
            this.oWO = 1;
            this.oWP = 1;
            if (PH(this.aST)) {
                if (com.tencent.mm.model.k.a(this.aST, str, this.cLy == 0)) {
                    this.cLy = 1;
                } else {
                    this.cLy = 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                g.iuh.a(106, 96, 1, false);
                this.oWL = new k(i, xF, str, this.aST, this.cLy, fVar, 0, str2, SQLiteDatabase.KeyEmpty, true, 2130837922, this.oWS, this.cNt, this.bhs);
                if (this.oWK == 1) {
                    this.oWL.Gx();
                }
                ak.vy().a(this.oWL, 0);
                this.oWM = true;
                v.d("MicroMsg.MsgRetransmitUI", "summersafecdn jacks consumption: %d, compressType:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.cLy));
                bl.zQ().b(bl.cvm, null);
            }
        } else if (this.oWQ) {
            this.oWO++;
            if (PH((String) this.oWN.get(0))) {
                if (com.tencent.mm.model.k.a((String) this.oWN.get(0), str, this.cLy == 0)) {
                    this.cLy = 1;
                } else {
                    this.cLy = 0;
                }
                v.d("MicroMsg.MsgRetransmitUI", "summersafecdn multiSendType compressType:%d", Integer.valueOf(this.cLy));
                this.oWL = new k(i, xF, str, (String) this.oWN.get(0), this.cLy, fVar, 0, str2, SQLiteDatabase.KeyEmpty, true, 2130837922);
                if (this.oWK == 1) {
                    this.oWL.Gx();
                }
                this.oWM = true;
                ak.vy().a(this.oWL, 0);
                bl.zQ().b(bl.cvm, null);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean PH(java.lang.String r6) {
        /*
        r5 = 7;
        r1 = 1;
        r0 = 0;
        r2 = "MicroMsg.MsgRetransmitUI";
        r3 = "isImage called, fn:%s, scene:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r4[r0] = r6;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r2, r3, r4);
        r2 = 0;
        r2 = com.tencent.mm.modelsfs.FileOp.openRead(r6);	 Catch:{ FileNotFoundException -> 0x0051, all -> 0x006a }
        r3 = new com.tencent.mm.sdk.platformtools.MMBitmapFactory$DecodeResultLogger;	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r4 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r2, r3);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        if (r4 != 0) goto L_0x004a;
    L_0x0027:
        r4 = r3.getDecodeResult();	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r5 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r1 = "MicroMsg.MsgRetransmitUI";
        r4 = "try to send illegal image.";
        com.tencent.mm.sdk.platformtools.v.w(r1, r4);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r1 = 7;
        r1 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper.getKVStatString(r6, r1, r3);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r3 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        r4 = 12712; // 0x31a8 float:1.7813E-41 double:6.2806E-320;
        r3.Y(r4, r1);	 Catch:{ FileNotFoundException -> 0x007a, all -> 0x006a }
        if (r2 == 0) goto L_0x0049;
    L_0x0046:
        r2.close();	 Catch:{ Exception -> 0x0071 }
    L_0x0049:
        return r0;
    L_0x004a:
        if (r2 == 0) goto L_0x004f;
    L_0x004c:
        r2.close();	 Catch:{ Exception -> 0x0073 }
    L_0x004f:
        r0 = r1;
        goto L_0x0049;
    L_0x0051:
        r1 = move-exception;
        r1 = r2;
    L_0x0053:
        r2 = "MicroMsg.MsgRetransmitUI";
        r3 = "fn:%s not found.";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0077 }
        r5 = 0;
        r4[r5] = r6;	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.v.w(r2, r3, r4);	 Catch:{ all -> 0x0077 }
        if (r1 == 0) goto L_0x0049;
    L_0x0064:
        r1.close();	 Catch:{ Exception -> 0x0068 }
        goto L_0x0049;
    L_0x0068:
        r1 = move-exception;
        goto L_0x0049;
    L_0x006a:
        r0 = move-exception;
    L_0x006b:
        if (r2 == 0) goto L_0x0070;
    L_0x006d:
        r2.close();	 Catch:{ Exception -> 0x0075 }
    L_0x0070:
        throw r0;
    L_0x0071:
        r1 = move-exception;
        goto L_0x0049;
    L_0x0073:
        r0 = move-exception;
        goto L_0x004f;
    L_0x0075:
        r1 = move-exception;
        goto L_0x0070;
    L_0x0077:
        r0 = move-exception;
        r2 = r1;
        goto L_0x006b;
    L_0x007a:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0053;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.transmit.MsgRetransmitUI.PH(java.lang.String):boolean");
    }

    private static boolean bq(byte[] bArr) {
        v.i("MicroMsg.MsgRetransmitUI", "isImage called, data[0-4]:[%d,%d,%d,%d,%d], scene:%d", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Integer.valueOf(6));
        DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
        if (MMBitmapFactory.checkIsImageLegal(bArr, decodeResultLogger) || decodeResultLogger.getDecodeResult() < 2000) {
            return true;
        }
        v.w("MicroMsg.MsgRetransmitUI", "try to send illegal image.");
        g.iuh.Y(12712, KVStatHelper.getKVStatString(bArr, 6, decodeResultLogger));
        return false;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() == MMGIFException.D_GIF_ERR_CLOSE_FAILED) {
            k kVar2 = (k) kVar;
            if (getIntent().getBooleanExtra("Retr_FromMainTimeline", false)) {
                String stringExtra = getIntent().getStringExtra("Retr_KSnsId");
                com.tencent.mm.sdk.c.b noVar;
                if (m.dE(kVar2.bob)) {
                    noVar = new no();
                    noVar.boH.boC = stringExtra;
                    com.tencent.mm.sdk.c.a.nhr.z(noVar);
                } else {
                    noVar = new np();
                    noVar.boI.boC = stringExtra;
                    com.tencent.mm.sdk.c.a.nhr.z(noVar);
                }
            }
            if (this.oWN == null || this.oWN.size() <= 1) {
                if (this.oWI != null) {
                    this.oWI.dismiss();
                    this.oWI = null;
                }
                this.oWW--;
                if (this.oWW <= 0 || !this.oWV) {
                    this.oWM = false;
                    ak.vy().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (e) this);
                    if (this.oWK != 0) {
                        if (this.oWG && !this.oWU) {
                            Intent intent = new Intent(this, ChattingUI.class);
                            intent.addFlags(67108864);
                            intent.putExtra("Chat_User", kVar2.bob);
                            startActivity(intent);
                        }
                        finish();
                        return;
                    }
                    return;
                }
                return;
            }
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this, getString(2131233899, new Object[]{this.oWN.get(0)}), 1).show();
            }
            this.oWN.remove(0);
            a(kVar2.bob, 3, this.cMP);
        }
    }
}
