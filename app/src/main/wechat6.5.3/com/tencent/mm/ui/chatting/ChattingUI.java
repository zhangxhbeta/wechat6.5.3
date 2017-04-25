package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.provider.Settings.Secure;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ActionBarContainer;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.al.t;
import com.tencent.mm.as.n;
import com.tencent.mm.as.o;
import com.tencent.mm.booter.z;
import com.tencent.mm.e.a.ai;
import com.tencent.mm.e.a.bf;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.dc;
import com.tencent.mm.e.a.dx;
import com.tencent.mm.e.a.hn;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.e.a.hq;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.ih;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.im;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.jl;
import com.tencent.mm.e.a.jr;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.e.a.lb;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.e.a.ma;
import com.tencent.mm.e.a.mf;
import com.tencent.mm.e.a.ms;
import com.tencent.mm.e.a.nf;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.e.a.ph;
import com.tencent.mm.e.a.pi;
import com.tencent.mm.e.a.pj;
import com.tencent.mm.e.a.pk;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.e.a.q;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.i;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelbiz.a.x;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.encode.ui.ChattingSightContainerView;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.ab;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.SightCaptureResult;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.arc;
import com.tencent.mm.protocal.c.axz;
import com.tencent.mm.protocal.c.bn;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.sdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.sdk.modelmsg.WXEmojiObject;
import com.tencent.mm.sdk.modelmsg.WXFileObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.ServiceNotifySettingsUI;
import com.tencent.mm.ui.SingleChatInfoUI;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI;
import com.tencent.mm.ui.bizchat.BizChatroomInfoUI;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.CropImageNewUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.DrawedCallBackLinearLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.v.f;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"DefaultLocale", "ValidFragment"})
@TargetApi(11)
public class ChattingUI extends MMFragmentActivity {
    public p ojM;
    public ac ojN = new ac();

    public interface b {
        void bEB();
    }

    @TargetApi(11)
    public static class c {
        public static void a(ListView listView, int i, boolean z) {
            if (listView != null) {
                v.i("MicroMsg.ChattingUI", "setSelection position %s smooth %s", Integer.valueOf(i), Boolean.valueOf(z));
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }

        public static void a(ListView listView, int i, int i2, boolean z) {
            if (listView != null) {
                v.i("MicroMsg.ChattingUI", "setSelectionFromTop position %s smooth %s", Integer.valueOf(i), Boolean.valueOf(z));
                listView.setItemChecked(i, true);
                listView.setSelectionFromTop(i, i2);
            }
        }
    }

    public static class a extends p implements com.tencent.mm.ae.c.a, com.tencent.mm.ae.h.a, ad, k, com.tencent.mm.modelmulti.b.c, com.tencent.mm.platformtools.j.a, ab, j.k, j.v, com.tencent.mm.sdk.h.g.a, com.tencent.mm.sdk.h.j.b, com.tencent.mm.storage.ac.b, com.tencent.mm.storage.au.a, com.tencent.mm.v.e, f {
        public static boolean oqV = false;
        public static String osT;
        public static boolean otP = false;
        private static String ovH = "100134";
        private final com.tencent.mm.sdk.c.c bZd = new dx(com.tencent.mm.ui.chatting.dx.a.CHATTING_ITEM_VIDEO, null);
        protected u bhV;
        private String bhj = null;
        public boolean cSL = false;
        private com.tencent.mm.sdk.c.c dHB = new com.tencent.mm.sdk.c.c<id>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = id.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                switch (((id) bVar).bif.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        this.ovO.bCe();
                        break;
                }
                return false;
            }
        };
        int djS = -1;
        private com.tencent.mm.ui.base.p dwg = null;
        private com.tencent.mm.ui.tools.p eSv = null;
        private String enX = null;
        boolean evz = false;
        private BizInfo exj;
        private l eyZ;
        private ClipboardManager fRJ;
        private String filePath;
        public boolean gYg = true;
        protected com.tencent.mm.modelbiz.a.j hVf;
        private h hVo = null;
        @SuppressLint({"HandlerLeak"})
        private ac handler = new ac(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void handleMessage(Message message) {
                if (!this.ovO.isFinishing() && this.ovO.otk) {
                    this.ovO.otk = false;
                    this.ovO.bDM();
                    this.ovO.bCe();
                }
            }
        };
        protected ChatFooter hjH;
        private MMPullDownView hkk;
        protected com.tencent.mm.ui.base.n.d hkn = new com.tencent.mm.ui.base.n.d(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void c(final MenuItem menuItem, int i) {
                final at atVar = (at) this.ovO.onh.getItem(menuItem.getGroupId());
                if (atVar == null) {
                    v.e("MicroMsg.ChattingUI", "context item select failed, null msg");
                    return;
                }
                ad X = this.ovO.onh.X(atVar.field_type, atVar.field_isSend == 1);
                if (X != null) {
                    X.a(menuItem, this.ovO, atVar);
                }
                String str;
                String str2;
                int i2;
                Intent intent;
                Intent intent2;
                com.tencent.mm.ae.d dVar;
                List linkedList;
                String str3;
                com.tencent.mm.q.a.a dV;
                switch (menuItem.getItemId()) {
                    case 100:
                        if (atVar.bwb()) {
                            if (atVar.field_msgId == this.ovO.oqd.olq) {
                                this.ovO.oqd.jE(true);
                            }
                        } else if (atVar.bvY()) {
                            a.d(this.ovO, atVar);
                        } else if (atVar.bwn()) {
                            com.tencent.mm.pluginsdk.model.h.Gr(atVar.field_imgPath);
                        }
                        aw.L(atVar.field_msgId);
                        com.tencent.mm.modelstat.b.daJ.r(atVar);
                        v.i("MicroMsg.ChattingUI", "delete msg, id:%d", Long.valueOf(atVar.field_msgId));
                        if (!this.ovO.bhV.field_username.equals("medianote")) {
                            ak.yW();
                            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
                        }
                        if (atVar.field_status == 1 && atVar.field_isSend == 1) {
                            v.d("MicroMsg.ChattingUI", "delete a sending msg, publish SendMsgFailEvent");
                            com.tencent.mm.sdk.c.b msVar = new ms();
                            msVar.boc.aXd = atVar;
                            com.tencent.mm.sdk.c.a.nhr.z(msVar);
                            return;
                        }
                        return;
                    case MMGIFException.D_GIF_ERR_READ_FAILED /*102*/:
                        str = ((at) this.ovO.onh.getItem(menuItem.getGroupId())).field_content;
                        v.d("MicroMsg.ChattingUI", "groupId = " + menuItem.getGroupId() + ", content length: " + (str == null ? 0 : str.length()));
                        try {
                            this.ovO.fRJ.setText(this.ovO.xo(menuItem.getGroupId()));
                        } catch (Exception e) {
                            v.e("MicroMsg.ChattingUI", "clip.setText error ");
                        }
                        Toast.makeText(this.ovO.nDR.nEl, this.ovO.vN(2131231016), 0).show();
                        return;
                    case MMGIFException.D_GIF_ERR_NOT_GIF_FILE /*103*/:
                        if (atVar.bwb()) {
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                this.ovO.ap(atVar);
                                return;
                            } else {
                                s.ey(this.ovO.nDR.nEl);
                                return;
                            }
                        } else if (atVar.bwj()) {
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                this.ovO.aq(atVar);
                                return;
                            } else {
                                s.ey(this.ovO.nDR.nEl);
                                return;
                            }
                        } else if (atVar.bwp()) {
                            ak.yW();
                            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                this.ovO.ar(atVar);
                                return;
                            } else {
                                s.ey(this.ovO.nDR.nEl);
                                return;
                            }
                        } else if (atVar.bwm()) {
                            this.ovO.as(atVar);
                            return;
                        } else if (atVar.bwl()) {
                            this.ovO.av(atVar);
                            return;
                        } else if (atVar.bwq()) {
                            this.ovO.au(atVar);
                            return;
                        } else {
                            return;
                        }
                    case MMGIFException.D_GIF_ERR_NO_SCRN_DSCR /*104*/:
                        if (atVar.bwp() || atVar.bwq()) {
                            com.tencent.mm.storage.a.c rg;
                            if (atVar.bwp()) {
                                rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(atVar.field_imgPath);
                            } else {
                                ag Mv = ag.Mv(atVar.field_content);
                                com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(atVar.field_content, atVar.field_reserved);
                                if (B == null) {
                                    B = new com.tencent.mm.q.a.a();
                                    B.cod = Mv.aZy;
                                }
                                if (!be.kS(B.cod) && !B.cod.equals("-1")) {
                                    rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(B.cod);
                                } else {
                                    return;
                                }
                            }
                            str2 = atVar.field_talker;
                            if (m.dE(str2)) {
                                str = aw.fL(atVar.field_content);
                            } else {
                                str = str2;
                            }
                            if (com.tencent.mm.pluginsdk.j.a.bmr().a(this.ovO.nDR.nEl, rg, 0, str)) {
                                this.ovO.hjH.bqc();
                                return;
                            }
                            return;
                        }
                        return;
                    case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                        return;
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                        n kZ = com.tencent.mm.as.k.KV().kZ(atVar.field_imgPath);
                        if (kZ == null) {
                            v.e("MicroMsg.ChattingUI", "save video but videoInfo is null!");
                            return;
                        } else if (kZ.status == 199) {
                            com.tencent.mm.as.k.KV();
                            String lc = o.lc(atVar.field_imgPath);
                            if (kZ != null) {
                                i2 = 0;
                                if (m.dE(kZ.Ld())) {
                                    i2 = i.el(kZ.Ld());
                                }
                                g.iuh.a(106, 215, 1, false);
                                g.iuh.h(12084, Integer.valueOf(kZ.cyu), Integer.valueOf(kZ.dhK * 1000), Integer.valueOf(0), Integer.valueOf(2), kZ.Ld(), Integer.valueOf(i2), n.kY(kZ.Lg()), Long.valueOf(kZ.dhH));
                            }
                            str = com.tencent.mm.as.p.lq(lc);
                            if (be.kS(str)) {
                                Toast.makeText(this.ovO.nDR.nEl, this.ovO.vN(2131235794), 1).show();
                                return;
                            }
                            Toast.makeText(this.ovO.nDR.nEl, this.ovO.d(2131235795, str), 1).show();
                            com.tencent.mm.pluginsdk.ui.tools.l.c(str, this.ovO.nDR.nEl);
                            return;
                        } else {
                            ak.vA().x(new Runnable(this.ovO, kZ.getFileName(), 6) {
                                final /* synthetic */ a ovO;

                                public final void run() {
                                    com.tencent.mm.as.p.G(r3, r4);
                                }
                            });
                            intent = new Intent(this.ovO.nDR.nEl, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", atVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", atVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", atVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", atVar.field_talker);
                            intent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.as.p.e(atVar.field_msgId, 2));
                            this.ovO.startActivity(intent);
                            this.ovO.overridePendingTransition(0, 0);
                            return;
                        }
                    case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                        ak.yW();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            n lp = com.tencent.mm.as.p.lp(atVar.field_imgPath);
                            if (lp == null) {
                                v.e("MicroMsg.ChattingUI", "retransmit video but videoInfo is null!");
                                return;
                            } else if (lp.status == 199) {
                                intent2 = new Intent(this.ovO.nDR.nEl, MsgRetransmitUI.class);
                                intent2.putExtra("Retr_length", lp.dhK);
                                intent2.putExtra("Retr_File_Name", atVar.field_imgPath);
                                intent2.putExtra("Retr_video_isexport", lp.dhO);
                                intent2.putExtra("Retr_Msg_Id", atVar.field_msgId);
                                intent2.putExtra("Retr_From", "chattingui");
                                v.d("MicroMsg.ChattingUI", "dkvideo msg.getType():" + atVar.field_type);
                                if (atVar.bwo()) {
                                    intent2.putExtra("Retr_Msg_Type", 11);
                                } else {
                                    intent2.putExtra("Retr_Msg_Type", 1);
                                }
                                this.ovO.startActivity(intent2);
                                return;
                            } else if (atVar.bwn() || atVar.bwo()) {
                                ak.vA().x(/* anonymous class already generated */);
                                intent = new Intent(this.ovO.nDR.nEl, ImageGalleryUI.class);
                                intent.putExtra("img_gallery_msg_id", atVar.field_msgId);
                                intent.putExtra("img_gallery_msg_svr_id", atVar.field_msgSvrId);
                                intent.putExtra("img_gallery_talker", atVar.field_talker);
                                intent.putExtra("img_gallery_chatroom_name", atVar.field_talker);
                                intent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.as.p.e(atVar.field_msgId, 1));
                                this.ovO.startActivity(intent);
                                this.ovO.overridePendingTransition(0, 0);
                                return;
                            } else {
                                v.w("MicroMsg.ChattingUI", "retranmist video unknow status.");
                                return;
                            }
                        }
                        s.ey(this.ovO.nDR.nEl);
                        return;
                    case MMGIFException.D_GIF_ERR_DATA_TOO_BIG /*108*/:
                        intent = new Intent(this.ovO.nDR.nEl, MsgRetransmitUI.class);
                        str2 = this.ovO.xo(menuItem.getGroupId());
                        if (atVar.bwe()) {
                            intent.putExtra("Retr_Msg_content", str2);
                            intent.putExtra("Retr_Msg_Type", 6);
                        } else {
                            intent.putExtra("Retr_Msg_content", str2);
                            intent.putExtra("Retr_Msg_Type", 4);
                        }
                        this.ovO.startActivity(intent);
                        return;
                    case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                        ak.yW();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            com.tencent.mm.modelvoice.n nVar = new com.tencent.mm.modelvoice.n(atVar.field_content);
                            intent2 = new Intent(this.ovO.nDR.nEl, MsgRetransmitUI.class);
                            intent2.putExtra("Retr_File_Name", atVar.field_imgPath);
                            intent2.putExtra("Retr_length", (int) nVar.time);
                            v.d("MicroMsg.ChattingUI", "voice msg.getType():" + atVar.field_type);
                            intent2.putExtra("Retr_Msg_Type", 7);
                            this.ovO.startActivity(intent2);
                            return;
                        }
                        s.ey(this.ovO.nDR.nEl);
                        return;
                    case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                        ak.yW();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            dVar = null;
                            if (atVar.field_msgId > 0) {
                                dVar = com.tencent.mm.ae.n.GH().ai(atVar.field_msgId);
                            }
                            if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                                dVar = com.tencent.mm.ae.n.GH().ah(atVar.field_msgSvrId);
                            }
                            if (dVar == null) {
                                return;
                            }
                            if (dVar.offset < dVar.cyu || dVar.cyu == 0) {
                                intent = new Intent(this.ovO.nDR.nEl, ImageGalleryUI.class);
                                intent.putExtra("img_gallery_msg_id", atVar.field_msgId);
                                intent.putExtra("img_gallery_msg_svr_id", atVar.field_msgSvrId);
                                intent.putExtra("img_gallery_talker", atVar.field_talker);
                                intent.putExtra("img_gallery_chatroom_name", atVar.field_talker);
                                intent.putExtra("img_gallery_is_restransmit_after_download", true);
                                intent.putExtra("Retr_show_success_tips", true);
                                this.ovO.startActivity(intent);
                                return;
                            }
                            intent2 = new Intent(this.ovO.nDR.nEl, MsgRetransmitUI.class);
                            intent2.putExtra("Retr_File_Name", com.tencent.mm.ae.n.GH().l(com.tencent.mm.ae.e.c(dVar), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty));
                            intent2.putExtra("Retr_Msg_Id", atVar.field_msgId);
                            intent2.putExtra("Retr_Msg_Type", 0);
                            intent2.putExtra("Retr_show_success_tips", true);
                            if (atVar.field_isSend == 1) {
                                if (dVar.Gp()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                            } else if (dVar.Gp()) {
                                if (com.tencent.mm.a.e.aR(com.tencent.mm.ae.n.GH().l(com.tencent.mm.ae.e.a(dVar).cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty))) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                            } else {
                                i2 = 0;
                            }
                            intent2.putExtra("Retr_Compress_Type", i2);
                            this.ovO.startActivity(intent2);
                            return;
                        }
                        s.ey(this.ovO.nDR.nEl);
                        return;
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                        ak.yW();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            com.tencent.mm.ae.d ah;
                            dVar = null;
                            if (atVar.field_msgId > 0) {
                                dVar = com.tencent.mm.ae.n.GH().ai(atVar.field_msgId);
                            }
                            if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                                ah = com.tencent.mm.ae.n.GH().ah(atVar.field_msgSvrId);
                            } else {
                                ah = dVar;
                            }
                            if (ah != null) {
                                CharSequence l = com.tencent.mm.ae.n.GH().l(ah.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                if (com.tencent.mm.a.e.aR(l)) {
                                    com.tencent.mm.pluginsdk.j.c.a(this.ovO.nDR.nEl, this.ovO.vN(2131231122), l);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        s.ey(this.ovO.nDR.nEl);
                        return;
                    case MMGIFException.D_GIF_ERR_EOF_TOO_SOON /*113*/:
                        if (atVar.bwp() || atVar.bwq()) {
                            com.tencent.mm.storage.a.c rg2;
                            linkedList = new LinkedList();
                            linkedList.add(atVar);
                            y.a(this.ovO.nDR.nEl, linkedList, this.ovO.nQK, this.ovO.bhV.field_username, null);
                            if (atVar.bwp()) {
                                rg2 = com.tencent.mm.pluginsdk.j.a.bmr().rg(atVar.field_imgPath);
                            } else {
                                ag Mv2 = ag.Mv(atVar.field_content);
                                if (!be.kS(Mv2.aZy) && !Mv2.aZy.equals("-1")) {
                                    rg2 = com.tencent.mm.pluginsdk.j.a.bmr().rg(Mv2.aZy);
                                } else {
                                    return;
                                }
                            }
                            if (rg2 != null) {
                                str3 = this.ovO.bhV.field_username;
                                if (m.dE(str3)) {
                                    str = aw.fL(atVar.field_content);
                                } else {
                                    str = str3;
                                }
                                g.iuh.h(12789, Integer.valueOf(1), rg2.EB(), Integer.valueOf(0), rg2.field_designerID, rg2.field_groupId, str);
                                return;
                            }
                            return;
                        }
                        return;
                    case 114:
                        if (atVar.bwm()) {
                            dy.k(this.ovO.cf(atVar.field_content, atVar.field_isSend), this.ovO.nDR.nEl);
                        } else if (atVar.bwb()) {
                            Context context = this.ovO.nDR.nEl;
                            if (context == null) {
                                v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: context is null");
                            } else if (atVar == null) {
                                v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: msg is null");
                            } else {
                                ak.yW();
                                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                                    dy.a(dy.cx(com.tencent.mm.modelbiz.e.Df()), context, new com.tencent.mm.ui.chatting.dy.AnonymousClass4(atVar, context));
                                } else {
                                    s.ey(context);
                                    v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVoiceConnector: sd card not available");
                                }
                            }
                        } else if (atVar.bwj()) {
                            dy.a(atVar, this.ovO.nDR.nEl);
                        } else if (atVar.bwn()) {
                            dy.b(atVar, this.ovO.nDR.nEl);
                        } else if (atVar.bwl()) {
                            str3 = atVar.field_content;
                            r2 = this.ovO.nDR.nEl;
                            if (r2 == null) {
                                v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: context is null");
                            } else if (be.kS(str3)) {
                                v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptLocationConnector: locationXML is null");
                            } else {
                                dy.a(dy.cx(com.tencent.mm.modelbiz.e.Di()), r2, new com.tencent.mm.ui.chatting.dy.AnonymousClass7(str3, r2));
                            }
                        } else if (atVar.bwk()) {
                            str3 = atVar.field_content;
                            r2 = this.ovO.nDR.nEl;
                            if (r2 == null) {
                                v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: context is null");
                            } else if (be.kS(str3)) {
                                v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptPersonalCardConnector: locationXML is null");
                            } else {
                                dy.a(dy.cx(com.tencent.mm.modelbiz.e.Dk()), r2, new com.tencent.mm.ui.chatting.dy.AnonymousClass8(str3, r2));
                            }
                        } else if (atVar.bwp() || atVar.bwq()) {
                            dy.c(atVar, this.ovO.nDR.nEl);
                        }
                        v.i("MicroMsg.ChattingUI", "type is %d", Integer.valueOf(atVar.field_type));
                        return;
                    case 116:
                        bp bpVar = new bp();
                        com.tencent.mm.pluginsdk.model.d.a(bpVar, atVar);
                        bpVar.aZd.og = this.ovO;
                        bpVar.aZd.aZl = 43;
                        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                        if (bpVar.aZe.ret == 0) {
                            com.tencent.mm.modelstat.b.daJ.q(atVar);
                            if (atVar.bvY() || atVar.bvZ() || atVar.bwa()) {
                                str2 = com.tencent.mm.model.o.fz(atVar.field_msgSvrId);
                                com.tencent.mm.model.o.b n = com.tencent.mm.model.o.yx().n(str2, true);
                                n.l("prePublishId", "msg_" + atVar.field_msgSvrId);
                                n.l("preUsername", ad.a(atVar, this.ovO.onl, this.ovO.lKa));
                                n.l("preChatName", this.ovO.bEn());
                                n.l("preMsgIndex", Integer.valueOf(0));
                                n.l("sendAppMsgScene", Integer.valueOf(1));
                                com.tencent.mm.modelstat.o.a("adExtStr", n, atVar);
                                bpVar.aZd.aZj = str2;
                            }
                            dV = com.tencent.mm.q.a.a.dV(be.KK(atVar.field_content));
                            if (!(dV == null || dV.type != 5 || dV.url == null)) {
                                long Nh = be.Nh();
                                v.d("MicroMsg.ChattingUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), dV.url, Long.valueOf(Nh), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                                str3 = SQLiteDatabase.KeyEmpty;
                                try {
                                    str3 = URLEncoder.encode(dV.url, "UTF-8");
                                } catch (Throwable e2) {
                                    v.a("MicroMsg.ChattingUI", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                                g.iuh.h(13378, str3, Long.valueOf(Nh), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1));
                            }
                            this.ovO.ale();
                            a.a(com.tencent.mm.ui.chatting.a.c.Fav, com.tencent.mm.ui.chatting.a.d.Samll, atVar, 0);
                            return;
                        }
                        return;
                    case 122:
                        this.ovO.ao(atVar);
                        return;
                    case 123:
                        v.d("MicroMsg.ChattingUI", "[oneliang][longclick_menu_revoke] type:%d,item.getGroupId:%d", Integer.valueOf(atVar.field_type), Integer.valueOf(menuItem.getGroupId()));
                        this.ovO.ouq = menuItem.getGroupId();
                        a.e(this.ovO, atVar);
                        return;
                    case 124:
                        v.d("MicroMsg.ChattingUI", "longclick transalte type: %d isShowTranslated: %s", Integer.valueOf(atVar.field_type), Boolean.valueOf(atVar.bwy()));
                        ak.yW();
                        if (((Boolean) com.tencent.mm.model.c.vf().get(327712, Boolean.valueOf(false))).booleanValue()) {
                            a aVar = this.ovO;
                            menuItem.getGroupId();
                            a.f(aVar, atVar);
                            return;
                        }
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(327712, Boolean.valueOf(true));
                        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this.ovO.nDR.nEl);
                        aVar2.Oq(this.ovO.vN(2131231909));
                        aVar2.Op(this.ovO.vN(2131231910));
                        aVar2.wp(2131233285).a(new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass136 owX;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                a aVar = this.owX.ovO;
                                at atVar = atVar;
                                menuItem.getGroupId();
                                a.f(aVar, atVar);
                                dialogInterface.dismiss();
                            }
                        });
                        aVar2.RX().show();
                        return;
                    case 126:
                        if (atVar.bwl()) {
                            linkedList = new LinkedList();
                            linkedList.add(atVar);
                            y.a(this.ovO.nDR.nEl, linkedList, this.ovO.nQK, this.ovO.bhV.field_username, null);
                            return;
                        }
                        return;
                    case 127:
                        com.tencent.mm.storage.a.c rg3;
                        if (atVar.bwp()) {
                            rg3 = com.tencent.mm.pluginsdk.j.a.bmr().rg(atVar.field_imgPath);
                        } else {
                            ag Mv3 = ag.Mv(atVar.field_content);
                            if (!be.kS(Mv3.aZy) && !Mv3.aZy.equals("-1")) {
                                rg3 = com.tencent.mm.pluginsdk.j.a.bmr().rg(Mv3.aZy);
                            } else {
                                return;
                            }
                        }
                        if (rg3 != null) {
                            g.iuh.h(12789, Integer.valueOf(2), rg3.EB(), Integer.valueOf(0), rg3.field_designerID, rg3.field_groupId);
                        }
                        str = rg3 == null ? SQLiteDatabase.KeyEmpty : rg3.field_groupId;
                        if (!be.kS(str)) {
                            intent = new Intent();
                            intent.putExtra("preceding_scence", 3);
                            intent.putExtra("download_entrance_scene", 16);
                            intent.putExtra("extra_id", str);
                            com.tencent.mm.ay.c.b(this.ovO.nDR.nEl, "emoji", ".ui.EmojiStoreDetailUI", intent);
                            return;
                        }
                        return;
                    case FileUtils.S_IWUSR /*128*/:
                        dV = com.tencent.mm.q.a.a.dV(this.ovO.cf(atVar.field_content, atVar.field_isSend));
                        Intent intent3 = new Intent(this.ovO.nDR.nEl, ChattingSendDataToDeviceUI.class);
                        Object obj = 1;
                        if (dV != null && (dV.type == 6 || dV.type == 2)) {
                            com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                            if (Gu == null || !FileOp.aR(Gu.field_fileFullPath)) {
                                obj = null;
                            }
                        } else if (atVar.bwj()) {
                            com.tencent.mm.ae.n.GH();
                            if (be.kS(com.tencent.mm.ae.f.l(atVar))) {
                                obj = null;
                            }
                        } else if (atVar.bwn()) {
                            com.tencent.mm.as.k.KV();
                            if (!FileOp.aR(o.lc(atVar.field_imgPath))) {
                                obj = null;
                            }
                        } else if (atVar.bwo()) {
                            com.tencent.mm.as.k.KV();
                            if (!FileOp.aR(o.lc(atVar.field_imgPath))) {
                                obj = null;
                            }
                        }
                        if (obj == null) {
                            com.tencent.mm.ui.base.g.a(this.ovO.nDR.nEl, this.ovO.vN(2131232230), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass136 owX;

                                {
                                    this.owX = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, null);
                            return;
                        }
                        intent3.putExtra("exdevice_open_scene_type", 1);
                        intent3.putExtra("Retr_Msg_Id", atVar.field_msgId);
                        this.ovO.startActivity(intent3);
                        return;
                    case 129:
                        intent = new Intent(this.ovO.nDR.nEl, ImageGalleryUI.class);
                        intent.putExtra("img_gallery_msg_id", atVar.field_msgId);
                        intent.putExtra("img_gallery_msg_svr_id", atVar.field_msgSvrId);
                        intent.putExtra("img_gallery_talker", atVar.field_talker);
                        intent.putExtra("img_gallery_chatroom_name", atVar.field_talker);
                        intent.putExtra("img_gallery_enter_video_opcode", com.tencent.mm.as.p.e(atVar.field_msgId, 3));
                        this.ovO.startActivity(intent);
                        this.ovO.overridePendingTransition(0, 0);
                        return;
                    default:
                        return;
                }
            }
        };
        private h hks;
        private int iRy = 0;
        private OnCreateContextMenuListener ima = new OnCreateContextMenuListener(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                dl dlVar = (dl) view.getTag();
                if (dlVar != null) {
                    int i = dlVar.position;
                    at atVar = (at) this.ovO.onh.getItem(i);
                    if (atVar == null) {
                        v.e("MicroMsg.ChattingUI", "msg is null!");
                        return;
                    }
                    CharSequence d;
                    String str;
                    boolean z;
                    a aVar;
                    String str2;
                    if (u.ew(this.ovO.bEn())) {
                        d = this.ovO.d(2131231515, be.ma(this.ovO.bhV.getCity()).trim());
                    } else {
                        String tU = this.ovO.bhV.tU();
                        if (atVar.field_isSend == 1) {
                            ak.yW();
                            str = (String) com.tencent.mm.model.c.vf().get(4, SQLiteDatabase.KeyEmpty);
                        } else {
                            d = this.ovO.bhV.tU();
                            if (m.dE(tU)) {
                                d = com.tencent.mm.model.l.er(aw.fL(atVar.field_content));
                            }
                        }
                    }
                    contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(this.ovO.nDR.nEl, d));
                    cp cpVar = this.ovO.onh;
                    int i2 = atVar.field_type;
                    if (atVar.field_isSend == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ad X = cpVar.X(i2, z);
                    if (X != null) {
                        z = X.a(contextMenu, view, atVar);
                        if (u.LJ(this.ovO.bEn()) || u.LH(this.ovO.bEn())) {
                            v.i("MicroMsg.ChattingUI", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                            contextMenu.removeItem(116);
                        }
                        if (z) {
                            if (this.ovO.bFL()) {
                                contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
                            }
                            if (this.ovO.bFL() || this.ovO.bhV.bvm()) {
                                contextMenu.add(i, 122, 0, this.ovO.vN(2131231832));
                                return;
                            }
                            return;
                        }
                    }
                    if (atVar.bwj()) {
                        ak.yW();
                        if (com.tencent.mm.model.c.isSDCardAvailable()) {
                            contextMenu.add(i, 100, 0, this.ovO.vN(2131231828));
                            com.tencent.mm.ae.d dVar = null;
                            if (atVar.field_msgId > 0) {
                                dVar = com.tencent.mm.ae.n.GH().ai(atVar.field_msgId);
                            }
                            if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                                dVar = com.tencent.mm.ae.n.GH().ah(atVar.field_msgSvrId);
                            }
                            if (atVar.field_isSend == 1 || (dVar != null && atVar.field_isSend == 0 && dVar.offset >= dVar.cyu && dVar.cyu != 0)) {
                                contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, this.ovO.vN(2131234555));
                            }
                            String l = dVar == null ? SQLiteDatabase.KeyEmpty : com.tencent.mm.ae.n.GH().l(dVar.cLv, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                            if (dVar != null && com.tencent.mm.a.e.aR(l)) {
                                contextMenu.add(i, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 0, this.ovO.vN(2131231773));
                            }
                            if (atVar.field_status == 5) {
                                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, this.ovO.vN(2131231835));
                                str = com.tencent.mm.ae.e.c(com.tencent.mm.ae.n.GH().j(atVar));
                                aVar = this.ovO;
                                if (atVar.bwj()) {
                                    str2 = null;
                                } else {
                                    str2 = com.tencent.mm.ae.n.GH().l(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                                }
                                aVar.filePath = str2;
                            }
                        }
                    }
                    if (atVar.bwf()) {
                        contextMenu.add(i, 100, 0, this.ovO.vN(2131231829));
                    }
                    if (atVar.field_status == 5) {
                        contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, this.ovO.vN(2131231835));
                        str = com.tencent.mm.ae.e.c(com.tencent.mm.ae.n.GH().j(atVar));
                        aVar = this.ovO;
                        if (atVar.bwj()) {
                            str2 = com.tencent.mm.ae.n.GH().l(str, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                        } else {
                            str2 = null;
                        }
                        aVar.filePath = str2;
                    }
                }
            }
        };
        com.tencent.mm.plugin.wallet.a irY = null;
        private com.tencent.mm.plugin.sight.decode.ui.c jHl = null;
        private com.tencent.mm.model.ab.e khS = new com.tencent.mm.model.ab.e(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void g(String str, final long j) {
                v.d("MicroMsg.ChattingUI", "onVoiceRemind " + str + " time " + j);
                if (m.fa(ak.oH().qr())) {
                    com.tencent.mm.ui.base.g.a(this.ovO.nDR.nEl, false, str, this.ovO.nDR.nEl.getString(2131235835), this.ovO.nDR.nEl.getString(2131235832), this.ovO.nDR.nEl.getString(2131235834), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass66 owq;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ak.yW();
                            if (com.tencent.mm.model.c.wJ().X(ak.oH().qr(), j)) {
                                ak.yW();
                                final int j = com.tencent.mm.model.c.wJ().j(ak.oH().qr(), j, this.owq.ovO.onh.emv - this.owq.ovO.onh.getCount());
                                if (j >= 0 && this.owq.ovO.onh.getCount() > j) {
                                    this.owq.ovO.oth.post(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 owr;

                                        public final void run() {
                                            v.i("MicroMsg.ChattingUI", "position " + j);
                                            c.a(this.owr.owq.ovO.oth, j, false);
                                        }
                                    });
                                }
                            }
                        }
                    }, null);
                }
            }
        };
        public boolean lKa = false;
        private final com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c lMv = new com.tencent.mm.pluginsdk.ui.chat.ChatFooter.c(this) {
            final /* synthetic */ a ovO;
            private Animation own;
            private Animation owo;

            {
                this.ovO = r1;
            }

            public final boolean im(boolean z) {
                if (this.own == null) {
                    this.own = AnimationUtils.loadAnimation(this.ovO.nDR.nEl, 2130968646);
                    this.owo = AnimationUtils.loadAnimation(this.ovO.nDR.nEl, 2130968644);
                }
                if (z) {
                    v.i("MicroMsg.ChattingUI", "switchFooterToInput customFooter is %s", this.ovO.ote);
                    if (this.ovO.ote != null) {
                        this.ovO.ote.startAnimation(this.owo);
                    }
                    this.ovO.bEY();
                    this.ovO.hjH.startAnimation(this.own);
                    this.ovO.hjH.postInvalidateDelayed(this.own.getDuration());
                } else {
                    this.ovO.ale();
                    this.ovO.hjH.startAnimation(this.owo);
                    this.ovO.bEX();
                    if (this.ovO.ote != null) {
                        this.ovO.ote.startAnimation(this.own);
                        this.ovO.ote.postInvalidateDelayed(this.own.getDuration());
                    }
                }
                return false;
            }
        };
        boolean lMy = false;
        boolean nBc = false;
        private boolean nGj = false;
        protected boolean nQK = false;
        protected com.tencent.mm.modelbiz.a.c ogZ;
        private com.tencent.mm.modelbiz.a.d.a ohG = new com.tencent.mm.modelbiz.a.d.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.d.a.b bVar) {
                if (!this.ovO.lKa || bVar == null || bVar.cDF != this.ovO.bFS()) {
                    return;
                }
                if (this.ovO.bFD()) {
                    v.i("MicroMsg.ChattingUI", "onNotifyChange fragment not foreground, return");
                } else if (bVar.cDP != com.tencent.mm.modelbiz.a.d.a.a.cDM) {
                    v.i("MicroMsg.ChattingUI", "bizChatExtension bizChat change");
                    this.ovO.ogZ = com.tencent.mm.modelbiz.u.DA().Z(this.ovO.bFS());
                    if (this.ovO.otJ && this.ovO.ogZ.DO()) {
                        com.tencent.mm.modelbiz.u.DE();
                        com.tencent.mm.modelbiz.a.h.b(this.ovO.ogZ.field_bizChatServId, this.ovO.bEn(), true);
                    }
                    if (this.ovO.otJ) {
                        this.ovO.nGj = com.tencent.mm.modelbiz.a.e.d(this.ovO.ogZ);
                        this.ovO.bDN();
                    } else {
                        com.tencent.mm.modelbiz.a.j ig = com.tencent.mm.modelbiz.u.DC().ig(this.ovO.ogZ.field_bizChatServId);
                        if (ig != null) {
                            this.ovO.hVf = ig;
                        }
                    }
                    this.ovO.bDM();
                } else if (this.ovO.otJ) {
                    Toast.makeText(aa.getContext(), this.ovO.vN(2131234594), 1).show();
                    this.ovO.finish();
                }
            }
        };
        private ax olR;
        private com.tencent.mm.ui.base.o olt;
        public boolean onc = false;
        private long[] ond = null;
        protected cp onh;
        private String onj;
        public boolean onl = false;
        protected boolean onm = false;
        private o oqd = null;
        private cv orj;
        private int osU = -1;
        private View osV;
        private TextView osW;
        public boolean osX = false;
        public boolean osY = false;
        private int osZ = -1;
        private int otA = 0;
        private ah otB = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final boolean oU() {
                com.tencent.mm.modelcontrol.c.Eg();
                boolean Eh = com.tencent.mm.modelcontrol.c.Eh();
                int lastVisiblePosition = this.ovO.oth.getLastVisiblePosition() - this.ovO.oth.getHeaderViewsCount();
                int max = Math.max(this.ovO.oth.getFirstVisiblePosition() - this.ovO.oth.getHeaderViewsCount(), 0);
                int max2 = Math.max(Math.min(lastVisiblePosition, this.ovO.onh.getCount()), 0);
                v.d("MicroMsg.ChattingUI", "first: " + max + " last: " + max2);
                if (max2 < max) {
                    v.d("MicroMsg.ChattingUI", "start timer to wait listview refresh");
                    this.ovO.otB.ea(1000);
                } else {
                    com.tencent.mm.ae.n.GI().cLl = true;
                    for (int i = max; i <= max2; i++) {
                        at atVar = (at) this.ovO.onh.getItem(i);
                        if (atVar != null && atVar.field_isSend == 0 && atVar.bwj()) {
                            com.tencent.mm.ae.d ah = com.tencent.mm.ae.n.GH().ah(atVar.field_msgSvrId);
                            if (!(ah.Go() || atVar.bNy == 2)) {
                                if (atVar.bNy != 1) {
                                    if (Eh) {
                                        com.tencent.mm.modelcontrol.c.Eg();
                                        if (!com.tencent.mm.modelcontrol.c.h(atVar)) {
                                        }
                                    }
                                }
                                com.tencent.mm.modelcdntran.g.DZ().cFg.add("image_" + atVar.field_msgId);
                                com.tencent.mm.ae.n.GI().a(ah.cLu, atVar.field_msgId, Integer.valueOf(i), 2130837919, this.ovO);
                            }
                        }
                    }
                    com.tencent.mm.ae.n.GI().Gk();
                }
                return false;
            }
        }, false);
        private com.tencent.mm.ui.chatting.gallery.f otC = a.oBu;
        private int otD = 0;
        protected LinearLayout otE;
        protected LinearLayout otF;
        private h otG = null;
        private boolean otH = false;
        private boolean otI = false;
        public boolean otJ = false;
        public boolean otK = false;
        protected boolean otL = false;
        private boolean otM = false;
        private int otN = 0;
        private final com.tencent.mm.ui.bindqq.b otO = null;
        protected boolean otQ = true;
        protected boolean otR = false;
        protected Map<String, String> otS = new HashMap();
        private View otT;
        private boolean otU = false;
        public boolean otV = false;
        public boolean otW = false;
        private boolean otX = false;
        private boolean otY = false;
        private TextView otZ;
        public boolean ota = true;
        private boolean otb = false;
        private ac otc;
        private long otd = -1;
        protected ChatFooterCustom ote;
        private ArrayList<String> otf;
        private ArrayList<String> otg;
        ListView oth;
        private ChattingSightContainerView oti;
        private SparseBooleanArray otj = new SparseBooleanArray();
        private boolean otk = false;
        private ac otl = new ac();
        private boolean otm = false;
        private boolean otn = false;
        private boolean oto = true;
        private boolean otp = true;
        private cu otq;
        private cx otr;
        private String ots = null;
        private long ott = 0;
        private long otu = 0;
        private int otv = 0;
        private boolean otw = false;
        private boolean otx = false;
        private int oty = d.oxl;
        List<b> otz = new LinkedList();
        private com.tencent.mm.sdk.c.c ouA = new com.tencent.mm.sdk.c.c<pk>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = pk.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                pk pkVar = (pk) bVar;
                if (pkVar instanceof pk) {
                    final String str = pkVar.bqM.id;
                    final int i = pkVar.bqM.ret;
                    this.ovO.handler.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 ovP;

                        public final void run() {
                            if (i == 0) {
                                this.ovP.ovO.a(be.KM(str), com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translated);
                                this.ovP.ovO.ouy.c(new com.tencent.mm.sdk.platformtools.ap.a(this.ovP.ovO, be.KM(str)) {
                                    final /* synthetic */ a ovO;

                                    public final boolean Ba() {
                                        return false;
                                    }

                                    public final boolean AZ() {
                                        ak.yW();
                                        at ek = com.tencent.mm.model.c.wJ().ek(r4);
                                        ek.bwz();
                                        com.tencent.mm.modelstat.b.daJ.a(ek, true);
                                        ak.yW();
                                        com.tencent.mm.model.c.wJ().a(r4, ek);
                                        return false;
                                    }
                                });
                                return;
                            }
                            if (i == 3) {
                                com.tencent.mm.ui.base.g.bf(this.ovP.ovO.nDR.nEl, this.ovP.ovO.vN(2131231911));
                            } else if (i != 5) {
                                com.tencent.mm.ui.base.g.bf(this.ovP.ovO.nDR.nEl, this.ovP.ovO.vN(2131231906));
                            }
                            this.ovP.ovO.a(be.KM(str), com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate);
                            this.ovP.ovO.onh.notifyDataSetChanged();
                        }
                    }, (long) (i == 5 ? 2000 : 0));
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.c.c ouB = new com.tencent.mm.sdk.c.c<nf>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = nf.class.getName().hashCode();
            }

            private boolean a(nf nfVar) {
                byte[] bArr = nfVar.boy.data;
                if (bArr != null) {
                    bn bnVar = new bn();
                    try {
                        bnVar.az(bArr);
                        final String a = com.tencent.mm.platformtools.m.a(bnVar.mcd);
                        v.i("MicroMsg.ChattingUI", "summerbadcr SilenceNotifyEvent callback chatRoomId[%s], current talker[%s]", a, this.ovO.bhV.field_username);
                        if (!be.kS(a) && a.equals(this.ovO.bhV.field_username)) {
                            final int i = bnVar.mcc;
                            final int i2 = bnVar.mce;
                            ak.vA().x(new Runnable(this) {
                                final /* synthetic */ AnonymousClass13 ovU;

                                public final void run() {
                                    int i;
                                    int i2;
                                    long j;
                                    v.i("MicroMsg.ChattingUI", "summerbadcr SilenceNotifyEvent in chatting lastSeq[%d], undeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(i2));
                                    long j2 = (long) i;
                                    long j3 = (long) i;
                                    int i3 = i2;
                                    ak.yW();
                                    af Mh = com.tencent.mm.model.c.wK().Mh(a);
                                    if (Mh == null || Mh.field_lastSeq != ((long) i) || Mh.field_UnDeliverCount <= 1) {
                                        com.tencent.mm.plugin.report.b.itm.a(403, 4, 1, false);
                                        i = 0;
                                        i2 = i3;
                                        j = j2;
                                    } else {
                                        int i4 = Mh.field_UnDeliverCount;
                                        long j4 = Mh.field_firstUnDeliverSeq;
                                        if (Mh.field_lastSeq - j4 >= ((long) i4)) {
                                            v.i("MicroMsg.ChattingUI", "summerbadcr SilenceNotifyEvent in chatting change up [%d, %d, %d, %d]", Long.valueOf(j4), Long.valueOf(j3), Integer.valueOf(i4), Integer.valueOf(1));
                                            com.tencent.mm.plugin.report.b.itm.a(403, 2, 1, false);
                                            i = 1;
                                            i2 = i4;
                                            j = j4;
                                        } else {
                                            com.tencent.mm.plugin.report.b.itm.a(403, 4, 1, false);
                                            i = 0;
                                            i2 = i3;
                                            j = j2;
                                        }
                                    }
                                    this.ovU.ovO.osX = false;
                                    com.tencent.mm.modelmulti.o.Hp().a(new com.tencent.mm.modelmulti.b.a(a, (int) j, (int) j3, i2, i), this.ovU.ovO);
                                }
                            });
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.ChattingUI", e, "summerbadcr SilenceNotifyEvent callback parse:", new Object[0]);
                    }
                } else {
                    v.e("MicroMsg.ChattingUI", "summerbadcr silenceNotifyListener callback event data is null");
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.c.c ouC = new com.tencent.mm.sdk.c.c<ai>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = ai.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                ai aiVar = (ai) bVar;
                if (aiVar instanceof ai) {
                    a.a(this.ovO, aiVar.aXT.aXd, aiVar);
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.c.c ouD = new com.tencent.mm.sdk.c.c<q>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = q.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                final q qVar = (q) bVar;
                if (this.ovO.onh != null) {
                    if (qVar.aWZ.status == 1) {
                        if (this.ovO.handler != null) {
                            this.ovO.handler.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass34 ovX;

                                {
                                    this.ovX = r1;
                                }

                                public final void run() {
                                    this.ovX.ovO.onh.notifyDataSetChanged();
                                }
                            });
                        }
                    } else if (this.ovO.handler != null) {
                        this.ovO.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass34 ovX;

                            public final void run() {
                                cp cpVar = this.ovX.ovO.onh;
                                cp.M(qVar.aWZ.aXa, qVar.aWZ.aXb, qVar.aWZ.status);
                            }
                        });
                    }
                }
                return false;
            }
        };
        private com.tencent.mm.sdk.c.c ouE = new com.tencent.mm.sdk.c.c<lb>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = lb.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                if (!(this.ovO.handler == null || this.ovO.hjH == null)) {
                    this.ovO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass44 owe;

                        {
                            this.owe = r1;
                        }

                        public final void run() {
                            v.i("MicroMsg.ChattingUI", "reflesh smiley panel.");
                            this.owe.ovO.hjH.bqc();
                        }
                    });
                }
                return false;
            }
        };
        public com.tencent.mm.ui.tools.g.c ouF = new com.tencent.mm.ui.tools.g.c(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }
        };
        private com.tencent.mm.sdk.c.c ouG = new com.tencent.mm.sdk.c.c<ma>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = ma.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                final ma maVar = (ma) bVar;
                if (this.ovO.handler != null) {
                    this.ovO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass58 owl;

                        public final void run() {
                            int i;
                            ma maVar = maVar;
                            com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(maVar.bni.aZy);
                            if ((this.owl.ovO.bhV == null || be.kS(maVar.bni.bdo) || !(maVar.bni.bdo.equalsIgnoreCase(this.owl.ovO.bhV.field_username) || maVar.bni.bdo.equalsIgnoreCase(this.owl.ovO.bhV.field_encryptUsername))) && !be.kS(maVar.bni.bdo)) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (this.owl.ovO.ous != null && r0 != 0) {
                                com.tencent.mm.pluginsdk.ui.chat.d o = this.owl.ovO.ous;
                                o.fgM = rg;
                                if (o.lNF != null && o.lNF.isShowing()) {
                                    v.i("MicroMsg.emoji.EmotionRewardMagicBubble", "reward magic is showing.");
                                } else if (o.fgM == null || o.lNE == null || o.lNF == null) {
                                    v.i("MicroMsg.emoji.EmotionRewardMagicBubble", "some things is null.");
                                } else {
                                    if (rg != null && rg.bxE()) {
                                        o.lNE.a(rg.dR(rg.field_groupId, rg.EB()), 1, new com.tencent.mm.plugin.gif.e(o) {
                                            final /* synthetic */ d lNJ;

                                            {
                                                this.lNJ = r1;
                                            }

                                            public final void onAnimationEnd() {
                                                this.lNJ.lNF.dismiss();
                                            }

                                            public final void invalidate() {
                                            }
                                        });
                                    }
                                    o.lNF.setWidth((o.lNE.getIntrinsicWidth() * o.lNH) / o.lNE.getIntrinsicHeight());
                                    o.lNF.setHeight(o.lNH);
                                    v.i("MicroMsg.emoji.EmotionRewardMagicBubble", "width:%d height:%d", Integer.valueOf(o.lNE.getIntrinsicWidth()), Integer.valueOf(o.lNE.getIntrinsicHeight()));
                                    if (o.lNG != null) {
                                        int height = (o.lNF.getHeight() / 2) + ((o.lNG.getTop() - o.lNF.getHeight()) / 2);
                                        DisplayMetrics displayMetrics = o.mContext.getResources().getDisplayMetrics();
                                        i = displayMetrics.widthPixels > displayMetrics.heightPixels ? o.mContext.getResources().getDimensionPixelSize(2131493014) + o.lNI : o.mContext.getResources().getDimensionPixelSize(2131493015) + o.lNI;
                                        if (height >= i) {
                                            i = height;
                                        }
                                        o.lNF.showAtLocation(o.lNG, 0, 0, i);
                                    }
                                }
                            }
                        }
                    });
                }
                return false;
            }
        };
        int ouH;
        private final b ouI = new b(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final boolean bGj() {
                this.ovO.otm = true;
                this.ovO.otn = false;
                this.ovO.oto = true;
                if (this.ovO.oum == null) {
                    this.ovO.xi(2131756045);
                    this.ovO.oum = (RelativeLayout) this.ovO.findViewById(2131756314);
                    this.ovO.oun = (TextView) this.ovO.findViewById(2131756315);
                    this.ovO.oun.setText(2131231738);
                }
                this.ovO.oum.setVisibility(0);
                this.ovO.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass61 owm;

                    {
                        this.owm = r1;
                    }

                    public final void run() {
                        this.owm.ovO.bDM();
                        this.owm.ovO.bCe();
                    }
                }, 5000);
                return true;
            }
        };
        private AnimationSet ouJ;
        private final ah ouK = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final boolean oU() {
                this.ovO.onh.a(null, null);
                return true;
            }
        }, true);
        private final com.tencent.mm.u.d.a ouL = new com.tencent.mm.u.d.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void gM(final String str) {
                this.ovO.handler.postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass67 ows;

                    public final void run() {
                        if (!be.kS(this.ows.ovO.ovc) && !be.kS(str) && str.equals(this.ows.ovO.ovc)) {
                            this.ows.ovO.bFu();
                        }
                    }
                }, 1000);
            }
        };
        private com.tencent.mm.sdk.c.c ouM = new com.tencent.mm.sdk.c.c<ph>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = ph.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                ph phVar = (ph) bVar;
                if ((!(phVar instanceof ph) || this.ovO.bhV.field_username.equals(phVar.bqF.userName)) && this.ovO.bhV.field_username.toLowerCase().endsWith("@chatroom")) {
                    com.tencent.mm.ui.base.g.A(this.ovO.nDR.nEl, this.ovO.vN(2131235687), null);
                }
                return false;
            }
        };
        private final com.tencent.mm.sdk.h.g.a ouN = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                v.d("MicroMsg.ChattingUI", "onBGChange event:%s", str);
                if (str == null) {
                    return;
                }
                if (str.equals(this.ovO.bEn()) || str.equals("*")) {
                    this.ovO.bjR();
                }
            }
        };
        private final com.tencent.mm.sdk.h.g.a ouO = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                v.v("MicroMsg.ChattingUI", "app attach info watcher notify");
                this.ovO.onh.a(null, null);
            }
        };
        private final com.tencent.mm.sdk.h.g.a ouP = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                v.v("MicroMsg.ChattingUI", "app info watcher notify");
                this.ovO.onh.a(null, null);
            }
        };
        private final com.tencent.mm.sdk.h.g.a ouQ = new com.tencent.mm.sdk.h.g.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
                v.v("MicroMsg.ChattingUI", "roommember watcher notify " + str);
                if (this.ovO.otR) {
                    i.a(this.ovO.bEn(), this.ovO.otS);
                } else {
                    this.ovO.otS.clear();
                }
                if (!be.kS(str)) {
                    this.ovO.bDM();
                    this.ovO.bCe();
                    this.ovO.bDN();
                    this.ovO.jO(false);
                }
                this.ovO.onh.a(null, null);
            }
        };
        el ouR = new el(this);
        private ActionBarContainer ouS = null;
        public com.tencent.mm.ui.l ouT = null;
        private com.tencent.mm.ui.b ouU;
        private View ouV;
        private View ouW;
        private boolean ouX = false;
        private Runnable ouY = new Runnable(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void run() {
                if (this.ovO.ouX || this.ovO.xe != 0) {
                    v.w("MicroMsg.ChattingUI", "error state user has touch listview, not need to scroll to last. userTouched: %s state: %s", Boolean.valueOf(this.ovO.ouX), Integer.valueOf(this.ovO.xe));
                    return;
                }
                v.i("MicroMsg.ChattingUI", "first time in, scroll to last");
                this.ovO.jM(true);
            }
        };
        private com.tencent.mm.app.plugin.a.a ouZ;
        private ListView oua;
        private View oub;
        private long ouc = -1;
        private boolean oud = false;
        private long oue = 0;
        private ChattingFooterMoreBtnBar ouf;
        private ct oug;
        private ab ouh = null;
        boolean oui = false;
        private boolean ouj = true;
        private int ouk = 0;
        private ImageView oul;
        private RelativeLayout oum;
        private TextView oun;
        private String ouo;
        private List<String> oup = new LinkedList();
        private int ouq = -1;
        private com.tencent.mm.ui.bindqq.b our;
        private com.tencent.mm.pluginsdk.ui.chat.d ous;
        private com.tencent.mm.sdk.c.c ouu = new com.tencent.mm.sdk.c.c<com.tencent.mm.e.a.ah>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = com.tencent.mm.e.a.ah.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                com.tencent.mm.e.a.ah ahVar = (com.tencent.mm.e.a.ah) bVar;
                if ((ahVar instanceof com.tencent.mm.e.a.ah) && this.ovO.bhV != null && !be.kS(ahVar.aXS.username) && ahVar.aXS.username.equals(this.ovO.bhV.field_username)) {
                    this.ovO.bFc();
                }
                return false;
            }
        };
        private Runnable ouv = new Runnable(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void run() {
                this.ovO.bFw();
            }
        };
        private Runnable ouw = new Runnable(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void run() {
                this.ovO.bFd();
                this.ovO.hjH.lMy = false;
                this.ovO.hjH.lME = false;
                this.ovO.hjH.bpE();
                ChatFooter chatFooter = this.ovO.hjH;
                if (chatFooter.lMp != null) {
                    chatFooter.lMp.setVisibility(0);
                }
                ChatFooter chatFooter2 = this.ovO.hjH;
                if (chatFooter2.lMm != null) {
                    chatFooter2.lMm.setVisibility(0);
                    if (chatFooter2.lMj != null && chatFooter2.lMj.getVisibility() == 0) {
                        LayoutParams layoutParams = (LayoutParams) chatFooter2.lMj.getLayoutParams();
                        layoutParams.rightMargin = 0;
                        chatFooter2.lMj.setLayoutParams(layoutParams);
                    }
                }
            }
        };
        private com.tencent.mm.sdk.c.c oux = new com.tencent.mm.sdk.c.c<hn>(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
                this.nhz = hn.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                hn hnVar = (hn) bVar;
                if ((hnVar instanceof hn) && this.ovO.lMy && (hnVar.bhi.bhj == null || hnVar.bhi.bhj.equals(this.ovO.bhj))) {
                    if (hnVar.bhi.type == 1) {
                        com.tencent.mm.sdk.platformtools.ad.o(this.ovO.ouv);
                    } else if (hnVar.bhi.type == 2) {
                        this.ovO.lMy = false;
                        com.tencent.mm.sdk.platformtools.ad.o(this.ovO.ouw);
                    }
                }
                return false;
            }
        };
        private ap ouy = new ap(5, "msg-translate-update-worker");
        private HashMap<Long, com.tencent.mm.ui.chatting.ChattingTranslateView.a> ouz = new HashMap();
        public boolean ovA = false;
        private long ovB = 0;
        private HashSet<Long> ovC = new HashSet();
        private HashSet<Long> ovD = new HashSet();
        private HashSet<Long> ovE = new HashSet();
        private int ovF = 0;
        private boolean ovG = false;
        private bf ovI = new bf();
        private Bitmap ovJ;
        private TalkRoomPopupNav ovK;
        private MultiTalkRoomPopupNav ovL;
        private com.tencent.mm.ui.base.TalkRoomPopupNav.a ovM = new com.tencent.mm.ui.base.TalkRoomPopupNav.a(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void bCZ() {
                if (com.tencent.mm.as.u.bj(this.ovO.nDR.nEl) || com.tencent.mm.ah.a.aT(this.ovO.nDR.nEl)) {
                    v.d("MicroMsg.ChattingUI", "voip is running");
                    return;
                }
                List vH = com.tencent.mm.pluginsdk.j.a.lxQ.vH(this.ovO.bhV.field_username);
                v.i("MicroMsg.ChattingUI", "Click banner : %d", Integer.valueOf(vH.size()));
                if (com.tencent.mm.pluginsdk.j.a.lxQ.vJ(this.ovO.bhV.field_username)) {
                    a.ay(this.ovO);
                } else {
                    this.ovO.jP(true);
                }
            }

            public final void bDa() {
                com.tencent.mm.sdk.c.b pdVar = new pd();
                pdVar.bqt.bqw = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                this.ovO.OY(this.ovO.bhV.field_username);
            }
        };
        private com.tencent.mm.pluginsdk.d.b ovN = new com.tencent.mm.pluginsdk.d.b(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r2;
            }

            public final void a(int i, int i2, String str, com.tencent.mm.sdk.c.b bVar) {
                if (this.ovO.dwg != null) {
                    this.ovO.dwg.dismiss();
                    this.ovO.dwg = null;
                }
                if (bVar instanceof ih) {
                    if (i == 0 && i2 == 0) {
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.ui.base.g.bf(this.ovO.nDR.nEl, this.ovO.vN(2131234590));
                        }
                    } else if (i != 0 || i2 != 0) {
                        if (i2 == -2024) {
                            com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
                            if (dm != null) {
                                dm.a(this.ovO.nDR.nEl, null, null);
                                return;
                            } else {
                                com.tencent.mm.ui.base.g.a(this.ovO.nDR.nEl, this.ovO.vN(2131234587), null, this.ovO.vN(2131234588), false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass40 fVc;

                                    {
                                        this.fVc = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                                return;
                            }
                        }
                        com.tencent.mm.ui.base.g.a(this.ovO.nDR.nEl, this.ovO.vN(2131234596), null, this.ovO.vN(2131231107), false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass40 fVc;

                            {
                                this.fVc = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    }
                } else if (!(bVar instanceof im)) {
                } else {
                    if (i != 0 || i2 != 0) {
                        com.tencent.mm.ui.base.g.a(this.ovO.nDR.nEl, this.ovO.vN(2131234596), null, this.ovO.vN(2131231107), false, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass40 fVc;

                            {
                                this.fVc = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else if (i == 0 && i2 == 0) {
                        com.tencent.mm.ui.base.g.bf(this.ovO.nDR.nEl, this.ovO.vN(2131234585));
                    }
                }
            }
        };
        private boolean ova = false;
        private boolean ovb = false;
        private String ovc;
        private View ovd;
        private ViewGroup ove;
        private int ovf = 0;
        private final int ovg = 10;
        private String ovh;
        private final cz ovi = new cz(this);
        private long ovj = 0;
        private boolean ovk = false;
        private String ovl = null;
        private OnMenuItemClickListener ovm = new OnMenuItemClickListener(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return a.Q(this.ovO);
            }
        };
        private int ovn;
        private int ovo;
        private boolean ovp = false;
        final com.tencent.mm.ui.n ovq = new c(this);
        final int ovr = 1;
        final int ovs = 2;
        final OnMenuItemClickListener ovt = new OnMenuItemClickListener(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.sdk.c.b qiVar = new qi();
                qiVar.brC.bdn = 5;
                qiVar.brC.bdo = this.ovO.bhV.field_username;
                qiVar.brC.context = this.ovO.nDR.nEl;
                if (menuItem.getItemId() == 1) {
                    qiVar.brC.brx = 4;
                } else if (menuItem.getItemId() == 2) {
                    qiVar.brC.brx = 2;
                }
                com.tencent.mm.sdk.c.a.nhr.z(qiVar);
                return true;
            }
        };
        private View ovu = null;
        private boolean ovv;
        private boolean ovw;
        private final long ovx = 259200000;
        public com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b ovy = new com.tencent.mm.pluginsdk.ui.chat.ChatFooter.b(this) {
            final /* synthetic */ a ovO;

            {
                this.ovO = r1;
            }

            public final void a(Boolean bool, Boolean bool2) {
                if (!bool.booleanValue()) {
                    return;
                }
                if (bool2.booleanValue()) {
                    this.ovO.c(Boolean.valueOf(true), Boolean.valueOf(true));
                } else {
                    this.ovO.c(Boolean.valueOf(false), Boolean.valueOf(true));
                }
            }

            public final void b(Boolean bool, Boolean bool2) {
                if (!bool.booleanValue()) {
                    return;
                }
                if (bool2.booleanValue()) {
                    this.ovO.c(Boolean.valueOf(true), Boolean.valueOf(false));
                } else {
                    this.ovO.c(Boolean.valueOf(false), Boolean.valueOf(false));
                }
            }
        };
        private boolean ovz = false;
        private int xe = 0;

        class AnonymousClass10 implements Runnable {
            final /* synthetic */ at crs;
            final /* synthetic */ boolean fUQ = false;
            final /* synthetic */ a ovO;

            AnonymousClass10(a aVar, at atVar, boolean z) {
                this.ovO = aVar;
                this.crs = atVar;
            }

            public final void run() {
                bx bxVar = this.crs;
                String w = com.tencent.mm.modelstat.o.w(bxVar);
                if (w != null) {
                    byte[] decode = Base64.decode(w, 0);
                    axz com_tencent_mm_protocal_c_axz = new axz();
                    try {
                        com_tencent_mm_protocal_c_axz.az(decode);
                        if (com_tencent_mm_protocal_c_axz.mVt != null) {
                            String str = bxVar.field_talker.endsWith("@chatroom") ? com.tencent.mm.modelstat.o.a.TalkChat.value : com.tencent.mm.modelstat.o.a.Chat.value;
                            v.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%s), statExtStr:%s(id=%s, uxinfo=%s)", str, w, com_tencent_mm_protocal_c_axz.mVt.mVw, com_tencent_mm_protocal_c_axz.mVt.mVx);
                            g.iuh.h(13235, str, com_tencent_mm_protocal_c_axz.mVt.mVw, com_tencent_mm_protocal_c_axz.mVt.mVx);
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.SnsStatExtUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
                bx bxVar2 = this.crs;
                boolean z = this.fUQ;
                PString pString = new PString();
                PString pString2 = new PString();
                if (a.a(bxVar2, pString, pString2)) {
                    String str2 = pString.value;
                    String str3 = pString2.value;
                    w = bxVar2.field_talker;
                    boolean endsWith = w.endsWith("@chatroom");
                    str = bxVar2.field_isSend == 1 ? com.tencent.mm.model.k.xF() : endsWith ? aw.fL(bxVar2.field_content) : w;
                    com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
                    cVar.n("20source_publishid", str2 + ",");
                    cVar.n("21uxinfo", str3 + ",");
                    cVar.n("22clienttime", be.Ni() + ",");
                    cVar.n("23source_type", (bxVar2.field_type == 62 ? 1 : 2) + ",");
                    cVar.n("24scene", (endsWith ? 4 : 3) + ",");
                    cVar.n("25scene_chatname", w + ",");
                    cVar.n("26scene_username", str + ",");
                    cVar.n("27curr_publishid", ",");
                    cVar.n("28curr_msgid", bxVar2.field_msgSvrId + ",");
                    cVar.n("29curr_favid", "0,");
                    cVar.n("30isdownload", (z ? 1 : 0) + ",");
                    cVar.n("31chatroom_membercount", (endsWith ? i.el(w) : 0) + ",");
                    com.tencent.mm.modelstat.o.a(com.tencent.mm.modelstat.o.w(bxVar2), cVar);
                    v.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + cVar.JH());
                    g.iuh.h(12989, cVar);
                }
            }
        }

        private class a implements TextWatcher {
            final /* synthetic */ a ovO;
            private boolean oxg;
            private List<String> oxh;

            private a(a aVar) {
                this.ovO = aVar;
                this.oxg = false;
                this.oxh = null;
            }

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            private static void b(List<String> list, String[] strArr) {
                for (String str : strArr) {
                    if (str.length() > 0 && str.substring(str.length() - 1, str.length()).matches("[_0-9a-zA-Z]$")) {
                        list.add(str);
                    }
                }
            }

            private boolean ch(String str, int i) {
                if (str == null || i < 0 || str.length() <= i) {
                    return false;
                }
                if (i == 0) {
                    return true;
                }
                if (!str.substring(i - 1, i).matches("[_0-9a-zA-Z]$")) {
                    return true;
                }
                if (this.oxh == null) {
                    this.oxh = new LinkedList();
                    b(this.oxh, this.ovO.bAq().getStringArray(2131296282));
                    b(this.oxh, this.ovO.bAq().getStringArray(2131296283));
                }
                String substring = str.substring(0, i);
                for (String endsWith : this.oxh) {
                    if (substring.endsWith(endsWith)) {
                        return true;
                    }
                }
                return false;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String b;
                v.i("MicroMsg.ChattingUI", "[onTextChanged]");
                this.ovO.xm(1);
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i, i + i3);
                Intent intent;
                if (this.ovO.onl && "@".equals(substring) && !valueOf.equals(this.ovO.hjH.lMw.lNv) && !this.ovO.hjH.lMx) {
                    this.ovO.hjH.HE(valueOf);
                    this.ovO.hjH.uf(i + 1);
                    if (ch(valueOf, i)) {
                        b = be.b(i.ej(this.ovO.bEn()), ",");
                        intent = new Intent();
                        intent.setClass(this.ovO.nDR.nEl, AtSomeoneUI.class);
                        intent.putExtra("Block_list", com.tencent.mm.model.k.xF());
                        intent.putExtra("Chatroom_member_list", b);
                        intent.putExtra("Chat_User", this.ovO.bhV.field_username);
                        intent.putExtra("Add_address_titile", this.ovO.vN(2131234563));
                        this.ovO.startActivityForResult(intent, 212);
                    }
                } else if (this.ovO.otJ && "@".equals(substring) && !valueOf.equals(this.ovO.hjH.lMw.lNv) && !this.ovO.hjH.lMx) {
                    this.ovO.hjH.HE(valueOf);
                    this.ovO.hjH.uf(i + 1);
                    if (ch(valueOf, i)) {
                        b = this.ovO.ogZ.field_userList;
                        intent = new Intent();
                        intent.setClass(this.ovO.nDR.nEl, BizChatAtSomeoneUI.class);
                        intent.putExtra("Block_list", com.tencent.mm.modelbiz.u.DC().ii(this.ovO.bEn()));
                        intent.putExtra("Chatroom_member_list", b);
                        intent.putExtra("Chat_User", this.ovO.bhV.field_username);
                        intent.putExtra("Add_address_titile", this.ovO.vN(2131234563));
                        intent.putExtra("key_biz_chat_id", this.ovO.bFS());
                        this.ovO.startActivityForResult(intent, 212);
                    }
                } else if (!valueOf.equals(this.ovO.hjH.lMw.lNv)) {
                    this.ovO.hjH.HE(valueOf);
                }
                if ((this.ovO.hks == null || !this.ovO.hks.isShowing()) && !be.kS(substring) && com.tencent.mm.sdk.platformtools.o.JY(substring)) {
                    if (this.ovO.onm) {
                        this.ovO.hks = com.tencent.mm.ui.base.g.A(this.ovO.nDR.nEl, this.ovO.vN(2131231824), this.ovO.vN(2131231107));
                    } else {
                        Bitmap b2 = com.tencent.mm.sdk.platformtools.d.b(substring, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD, SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD, false);
                        if (b2 == null) {
                            v.e("MicroMsg.ChattingUI", "showAlert fail, bmp is null");
                            return;
                        }
                        boolean z;
                        View imageView = new ImageView(this.ovO.nDR.nEl);
                        int dimensionPixelSize = this.ovO.bAq().getDimensionPixelSize(2131493135);
                        imageView.setImageBitmap(b2);
                        imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                        com.tencent.mm.ui.h hVar = this.ovO;
                        b = Secure.getString(hVar.bzo() != null ? hVar.bzo().getContentResolver() : null, "default_input_method");
                        if (com.tencent.mm.sdk.platformtools.o.be(com.tencent.mm.a.e.c(substring, 0, com.tencent.mm.a.e.aQ(substring))) && (b.contains("com.sohu.inputmethod.sogou") || b.contains("com.tencent.qqpinyin"))) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.ovO.hks = com.tencent.mm.ui.base.g.a(this.ovO.nDR.nEl, this.ovO.vN(2131231896), imageView, this.ovO.vN(2131231107), this.ovO.vN(2131231010), new OnClickListener(this) {
                            final /* synthetic */ a oxj;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                if (!z || this.oxj.ovO.hjH == null || this.oxj.ovO.hjH.lGn == null || !(this.oxj.ovO.hjH.lGn instanceof cw)) {
                                    ak.vy().a(new com.tencent.mm.ae.k(5, this.oxj.ovO.bFR(), this.oxj.ovO.bEn(), substring, 0, null, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, 2130837922), 0);
                                    return;
                                }
                                String a = com.tencent.mm.pluginsdk.j.a.bmr().a(this.oxj.ovO.nDR.nEl, new WXMediaMessage(new WXEmojiObject(substring)), null);
                                if (a != null) {
                                    ((cw) this.oxj.ovO.hjH.lGn).o(com.tencent.mm.pluginsdk.j.a.bmr().rg(a));
                                }
                            }
                        }, null);
                    }
                    b = valueOf.substring(0, i);
                    this.ovO.hjH.postDelayed(new Runnable(this) {
                        final /* synthetic */ a oxj;

                        public final void run() {
                            this.oxj.ovO.hjH.l(b, -1, false);
                        }
                    }, 10);
                }
                if (!this.ovO.lKa) {
                    ChatFooter chatFooter = this.ovO.hjH;
                    if (chatFooter.lMt != null && chatFooter.hhL != null) {
                        chatFooter.lMt.lOf = true;
                        com.tencent.mm.pluginsdk.ui.chat.m mVar = chatFooter.lMt;
                        v.d("MicroMsg.emoji.SuggestEmoticonBubble", "[checkIfShow]");
                        if (!(be.kS(valueOf) || valueOf.equals(mVar.lOe))) {
                            ak.vA().x(new com.tencent.mm.pluginsdk.ui.chat.m.AnonymousClass6(mVar, valueOf));
                        }
                        mVar.lOe = valueOf;
                    }
                }
            }
        }

        public interface b {
            boolean bGj();
        }

        private enum d {
            ;

            static {
                oxl = 1;
                oxm = 2;
                oxn = new int[]{oxl, oxm};
            }
        }

        interface e {
        }

        class c extends com.tencent.mm.ui.n {
            final /* synthetic */ a ovO;

            c(a aVar) {
                this.ovO = aVar;
            }

            public final void bfd() {
                boolean z = false;
                Intent intent = new Intent();
                this.ovO.ale();
                if (this.ovO.nQK && !this.ovO.lKa) {
                    intent.putExtra("Chat_User", this.ovO.bhV.field_username);
                    intent.putExtra("RoomInfo_Id", this.ovO.bEn());
                    intent.putExtra("Is_Chatroom", this.ovO.onl);
                    intent.putExtra("Is_Lbsroom", this.ovO.onm);
                    com.tencent.mm.ay.c.b(this.ovO.nDR.nEl, "chatroom", ".ui.ChatroomInfoUI", intent);
                } else if (this.ovO.lKa) {
                    intent.setClass(this.ovO.nDR.nEl, BizChatroomInfoUI.class);
                    intent.putExtra("Chat_User", this.ovO.bhV.field_username);
                    intent.putExtra("key_biz_chat_id", this.ovO.bFS());
                    if (this.ovO.bzo() instanceof ChattingUI) {
                        intent.putExtra("key_biz_chat_info_from_scene", 1);
                    } else {
                        intent.putExtra("key_biz_chat_info_from_scene", 2);
                    }
                    this.ovO.startActivity(intent);
                } else if (m.fi(this.ovO.bEn())) {
                    this.ovO.startActivity(new Intent(this.ovO.nDR.nEl, ServiceNotifySettingsUI.class));
                } else if (m.fk(this.ovO.bEn()) || u.LH(this.ovO.bEn()) || u.LJ(this.ovO.bEn()) || m.fg(this.ovO.bEn()) || u.ew(this.ovO.bEn()) || this.ovO.bhV.bvm()) {
                    intent = new Intent();
                    com.tencent.mm.ui.contact.e.j(intent, this.ovO.bEn());
                    intent.putExtra("Kdel_from", 0);
                    Intent intent2 = this.ovO.nDR.nEl.getIntent();
                    int intExtra = intent2.getIntExtra("key_temp_session_scene", 5);
                    if (intExtra == 16 || intExtra == 17 || intent2.getBooleanExtra("key_biz_profile_stay_after_follow_op", false)) {
                        intent.putExtra("Kdel_from", 1);
                        z = true;
                    }
                    intent.putExtra("key_biz_profile_stay_after_follow_op", z);
                    if (this.ovO.otb && a.OS(this.ovO.bEn())) {
                        if (intExtra == 16) {
                            intent.putExtra("Contact_Scene", 92);
                        } else if (intExtra == 17) {
                            intent.putExtra("Contact_Scene", 93);
                        } else if (intExtra == 18) {
                            intent.putExtra("Contact_Scene", 94);
                        } else {
                            intent.putExtra("Contact_Scene", 81);
                        }
                    }
                    com.tencent.mm.ay.c.b(this.ovO.nDR.nEl, "profile", ".ui.ContactInfoUI", intent, 213);
                } else if (this.ovO.lMy) {
                    a.U(this.ovO);
                } else {
                    intent.setClass(this.ovO.nDR.nEl, SingleChatInfoUI.class);
                    intent.putExtra("Single_Chat_Talker", this.ovO.bEn());
                    this.ovO.startActivity(intent);
                }
            }
        }

        static /* synthetic */ boolean Q(a aVar) {
            if (aVar.nDR.nEb) {
                aVar.goBack();
            } else {
                v.w("MicroMsg.ChattingUI", "Actionbar customView onclick screen not enable");
            }
            return true;
        }

        static /* synthetic */ void U(a aVar) {
            String str = be.kS(aVar.ovc) ? aVar.bhV.field_username : aVar.ovc;
            if (str != null && !str.equals(SQLiteDatabase.KeyEmpty)) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Encryptusername", true);
                if (aVar.lMy) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                    intent.putExtra("Contact_IsLbsChattingProfile", true);
                    intent.putExtra("Contact_Scene", 18);
                } else {
                    g.iuh.h(11004, aVar.ovc, Integer.valueOf(2));
                }
                com.tencent.mm.ay.c.b(aVar.nDR.nEl, "profile", ".ui.ContactInfoUI", intent);
            }
        }

        static /* synthetic */ void a(a aVar, Intent intent, String str) {
            if (intent != null) {
                aVar.otf = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                aVar.otg = intent.getStringArrayListExtra("key_select_video_list");
                com.tencent.mm.ae.k.aj(intent.getLongExtra("KSelectImgUseTime", 0));
                if (aVar.otf == null || aVar.otf.size() <= 0) {
                    aVar.otf = null;
                    v.e("MicroMsg.ChattingUI", "send image list is null or nil");
                } else {
                    ArrayList arrayList;
                    v.i("MicroMsg.ChattingUI", "sendMutiImage rawUserName:%s %s", aVar.onj, aVar.otf.toString());
                    ArrayList integerArrayListExtra = intent.getIntegerArrayListExtra("GalleryUI_ImgIdList");
                    if (integerArrayListExtra == null || (integerArrayListExtra.size() == 1 && ((Integer) integerArrayListExtra.get(0)).intValue() == -1)) {
                        com.tencent.mm.ae.m Gy = com.tencent.mm.ae.m.Gy();
                        for (com.tencent.mm.ae.m.e eVar : Gy.cNQ.values()) {
                            PString pString = new PString();
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            eVar.cOj = com.tencent.mm.ae.n.GH().a(eVar.cOg, eVar.cLy, eVar.bbT, eVar.bha, pString, pInt, pInt2, eVar.cOh, eVar.cOi, eVar.bao, eVar.cOn, eVar.cOo, eVar.cOp);
                            ak.yW();
                            at ek = com.tencent.mm.model.c.wJ().ek(eVar.bao);
                            if (be.kS(ek.field_imgPath)) {
                                ek.cI(pString.value);
                                ek.dt(pInt.value);
                                ek.du(pInt2.value);
                                ak.yW();
                                com.tencent.mm.model.c.wJ().a(eVar.bao, ek);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (int i = 0; i < Gy.cNR.size(); i++) {
                            arrayList2.add(Integer.valueOf((int) ((com.tencent.mm.ae.m.e) Gy.cNQ.get(Gy.cNR.get(i))).cOj));
                        }
                        Gy.cNQ.clear();
                        Gy.cNR.clear();
                        arrayList = arrayList2;
                    } else {
                        arrayList = integerArrayListExtra;
                    }
                    aVar.a(intent, str, aVar.otf, arrayList);
                }
                if (aVar.otg == null || aVar.otg.size() <= 0) {
                    aVar.otg = null;
                    v.e("MicroMsg.ChattingUI", "send video list is null or nil");
                } else if (com.tencent.mm.network.aa.bk(aVar.nDR.nEl)) {
                    aVar.bFN();
                } else {
                    com.tencent.mm.ui.base.g.a(aVar.nDR.nEl, 2131235789, 2131231164, new OnClickListener(aVar) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ovO.bFN();
                        }
                    }, null);
                }
            }
        }

        static /* synthetic */ void a(a aVar, com.tencent.mm.network.e eVar) {
            String str;
            String str2;
            String ispId = eVar.getIspId();
            long j = !be.kS(ispId) ? be.getLong(ispId, 0) : 0;
            String str3 = "TypingTrigger";
            String str4 = "TypingInterval";
            if (j != 0) {
                str = str3 + "_ISP" + j;
                str2 = str4 + "_ISP" + j;
            } else {
                str2 = str4;
                str = str3;
            }
            str = be.ah(com.tencent.mm.h.j.sU().getValue(str), "10");
            str2 = be.ah(com.tencent.mm.h.j.sU().getValue(str2), "15");
            aVar.ouH = be.getInt(str, 0);
            aVar.djS = be.getInt(str2, 0);
            v.i("MicroMsg.ChattingUI", "ispId: %d, trigger:%d, interval:%d", Long.valueOf(j), Integer.valueOf(aVar.ouH), Integer.valueOf(aVar.djS));
            if (!(aVar.ouH == -1 || aVar.ouH == -2 || aVar.ouH > 0)) {
                aVar.ouH = 10;
            }
            if (aVar.djS <= 0) {
                aVar.djS = 15;
            }
            eVar.setSignallingStrategy((long) (aVar.djS * 1000), 20000);
        }

        static /* synthetic */ void a(a aVar, gx gxVar) {
            v.i("MicroMsg.ChattingUI", "updateBizChatMemberList()");
            String vN = aVar.vN(2131234578);
            com.tencent.mm.modelbiz.u.DE();
            final x a = com.tencent.mm.modelbiz.a.h.a(aVar.ogZ.field_brandUserName, aVar.ogZ.field_bizChatServId, null, gxVar, aVar);
            Context context = aVar.nDR.nEl;
            aVar.vN(2131231164);
            aVar.dwg = com.tencent.mm.ui.base.g.a(context, vN, true, new OnCancelListener(aVar) {
                final /* synthetic */ a ovO;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(a);
                }
            });
        }

        static /* synthetic */ void a(a aVar, at atVar, ai aiVar) {
            if (aVar.oth != null) {
                int firstVisiblePosition = aVar.oth.getFirstVisiblePosition();
                int lastVisiblePosition = aVar.oth.getLastVisiblePosition();
                for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                    at atVar2 = (at) aVar.oth.getAdapter().getItem(i);
                    if (!(atVar == null || atVar2 == null || atVar2.field_msgId != atVar.field_msgId)) {
                        View childAt = aVar.oth.getChildAt(i - firstVisiblePosition);
                        View view = null;
                        if (atVar.bwj() || atVar.bwn() || atVar.bwo()) {
                            view = childAt.findViewById(2131756186);
                        } else if (atVar.bwr()) {
                            view = childAt.findViewById(2131756168);
                        }
                        if (view != null) {
                            int[] iArr = new int[2];
                            view.getLocationInWindow(iArr);
                            aiVar.aXU.aXV = iArr[0];
                            aiVar.aXU.aXW = iArr[1];
                            aiVar.aXU.aXX = view.getWidth();
                            aiVar.aXU.aXY = view.getHeight();
                        }
                    }
                }
            }
        }

        static /* synthetic */ void aC(a aVar) {
            boolean z = true;
            if (aVar.lKa && aVar.ogZ != null && !be.kS(aVar.ogZ.field_brandUserName)) {
                String ii = com.tencent.mm.modelbiz.u.DC().ii(aVar.ogZ.field_brandUserName);
                com.tencent.mm.modelbiz.a.j ig = com.tencent.mm.modelbiz.u.DC().ig(ii);
                String str = "MicroMsg.ChattingUI";
                String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
                Object[] objArr = new Object[3];
                objArr[0] = aVar.ogZ.field_brandUserName;
                objArr[1] = ii;
                if (ig != null) {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                v.i(str, str2, objArr);
                if (be.kS(ii) || ig == null || ig.DO() || be.kS(ig.field_addMemberUrl)) {
                    com.tencent.mm.modelbiz.u.DE();
                    com.tencent.mm.modelbiz.a.h.a(aVar.ogZ.field_brandUserName, (k) aVar);
                }
            }
        }

        static /* synthetic */ boolean ap(a aVar) {
            if (!m.fn(aVar.bEn()) && m.dE(aVar.bEn())) {
                ak.yW();
                af Mh = com.tencent.mm.model.c.wK().Mh(aVar.bEn());
                if (Mh == null || (Mh.field_showTips & 1) > 0) {
                    return false;
                }
                ak.yW();
                if (com.tencent.mm.model.c.wH().LX(aVar.bEn()).bCh == 1 && aVar.otD >= 40) {
                    return true;
                }
            }
            return false;
        }

        static /* synthetic */ void ay(a aVar) {
            if (!aVar.bhV.field_username.toLowerCase().endsWith("@chatroom") || aVar.nGj) {
                com.tencent.mm.sdk.c.b pdVar = new pd();
                pdVar.bqt.bqv = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                String str;
                if (be.kS(pdVar.bqu.bqx) || aVar.bhV.field_username.equals(pdVar.bqu.bqx)) {
                    str = aVar.bhV.field_username;
                    aVar.bGa();
                    return;
                }
                pdVar = new pd();
                pdVar.bqt.bqw = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                str = aVar.bhV.field_username;
                aVar.bGa();
                return;
            }
            com.tencent.mm.ui.base.g.A(aVar.nDR.nEl, aVar.vN(2131235687), null);
        }

        static /* synthetic */ void d(a aVar, at atVar) {
            final String str = atVar.field_content;
            final String str2 = aVar.bhV.field_username;
            final long j = atVar.field_msgId;
            ak.vA().x(new Runnable(aVar) {
                final /* synthetic */ a ovO;

                public final void run() {
                    String str = str;
                    if (m.dE(str2) && !be.ah(str, SQLiteDatabase.KeyEmpty).startsWith("<")) {
                        int indexOf = str.indexOf(58);
                        if (indexOf != -1) {
                            str = str.substring(indexOf + 1);
                        }
                    }
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(str));
                    if (dV != null) {
                        switch (dV.type) {
                            case 3:
                                ajr HE = com.tencent.mm.ai.b.HE();
                                if (HE != null && HE.mJW != null && HE.mJV == 0) {
                                    try {
                                        if (j == be.getLong(HE.mJW, 0)) {
                                            com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass138 oxa;

                                                {
                                                    this.oxa = r1;
                                                }

                                                public final void run() {
                                                    com.tencent.mm.ai.b.HB();
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    } catch (Exception e) {
                                        return;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            });
        }

        static /* synthetic */ void e(a aVar, final at atVar) {
            final com.tencent.mm.v.k vVar = new com.tencent.mm.modelsimple.v(atVar, aVar.vN(2131231878));
            aVar.dwg = com.tencent.mm.ui.base.g.a(aVar.nDR.nEl, aVar.vN(2131231877), true, new OnCancelListener(aVar) {
                final /* synthetic */ a ovO;

                public final void onCancel(DialogInterface dialogInterface) {
                    v.i("MicroMsg.ChattingUI", "cancel revoke msg:%d", Long.valueOf(atVar.field_msgId));
                    ak.vy().c(vVar);
                }
            });
            ak.vy().a(vVar, 0);
        }

        static /* synthetic */ void f(a aVar, at atVar) {
            if (atVar.bwu()) {
                if (atVar.bwy()) {
                    if (atVar.bwu()) {
                        atVar.ds(atVar.bNn & -17);
                    }
                    aVar.a(atVar.field_msgId, com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate);
                    com.tencent.mm.modelstat.b.daJ.a(atVar, false);
                } else {
                    atVar.bwz();
                    aVar.a(atVar.field_msgId, com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translated);
                    com.tencent.mm.modelstat.b.daJ.a(atVar, true);
                }
                ak.yW();
                com.tencent.mm.model.c.wJ().a(atVar.field_msgId, atVar);
            } else if (aVar.al(atVar) != com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translating) {
                com.tencent.mm.sdk.c.b piVar = new pi();
                piVar.bqG.bqI = false;
                piVar.bqG.id = atVar.field_msgId;
                piVar.bqG.bqH = atVar.field_content;
                if (!aVar.nQK || atVar.field_isSend == 1) {
                    piVar.bqG.type = 0;
                } else {
                    piVar.bqG.type = 1;
                }
                piVar.bqG.aHM = aVar.bhV.field_username;
                com.tencent.mm.sdk.c.a.nhr.z(piVar);
                aVar.a(atVar.field_msgId, com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translating);
            } else {
                return;
            }
            aVar.onh.notifyDataSetChanged();
        }

        static /* synthetic */ void g(a aVar, at atVar) {
            aVar.ovE.add(Long.valueOf(atVar.field_msgSvrId));
            com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
            cVar.n("20MessageID", atVar.field_msgSvrId + ",");
            cVar.n("21MessageInnerType", atVar.field_type + ",");
            cVar.n("22currChatName", atVar.field_talker + ",");
            String str = SQLiteDatabase.KeyEmpty;
            if (atVar.field_isSend == 1) {
                str = com.tencent.mm.model.k.xF();
            } else if (!aVar.onl) {
                str = atVar.field_talker;
            } else if (atVar.field_content != null) {
                int fK = aw.fK(atVar.field_content);
                if (fK != -1) {
                    str = atVar.field_content.substring(0, fK).trim();
                }
            }
            cVar.n("23msgPostUserName", str + ",");
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
            if (dV != null) {
                cVar.n("24AppId", dV.appId + ",");
                if (dV.bnY != null) {
                    axz com_tencent_mm_protocal_c_axz = new axz();
                    try {
                        com_tencent_mm_protocal_c_axz.az(Base64.decode(dV.bnY, 0));
                    } catch (Exception e) {
                    }
                    if (com_tencent_mm_protocal_c_axz.mVv != null) {
                        cVar.n("25SourceAppId", com_tencent_mm_protocal_c_axz.mVv.ghW + ",");
                    }
                }
                v.v("MicroMsg.ChattingUI", "appExposeReport report logbuffer(13634): " + cVar.JH());
                g.iuh.h(13634, cVar);
            }
        }

        public static a bEW() {
            return new a();
        }

        @SuppressLint({"ValidFragment"})
        public a(boolean z) {
            super(true);
        }

        public final void ey(long j) {
            v.i("MicroMsg.ChattingUI", "set last click short video msg id %d", Long.valueOf(j));
            this.otd = j;
        }

        public final boolean xg(int i) {
            return this.otj.get(i, !tM());
        }

        public final boolean xh(int i) {
            boolean z = !xg(i);
            this.otj.put(i, z);
            return z;
        }

        public final com.tencent.mm.ui.chatting.ChattingTranslateView.a al(at atVar) {
            com.tencent.mm.ui.chatting.ChattingTranslateView.a aVar = (com.tencent.mm.ui.chatting.ChattingTranslateView.a) this.ouz.get(Long.valueOf(atVar.field_msgId));
            if (aVar != null) {
                return aVar;
            }
            if (!atVar.bwu()) {
                com.tencent.mm.sdk.c.b pjVar = new pj();
                pjVar.bqJ.id = atVar.field_msgId;
                com.tencent.mm.sdk.c.a.nhr.z(pjVar);
                if (!pjVar.bqK.bqL) {
                    return com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate;
                }
                aVar = com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translating;
                a(atVar.field_msgId, aVar);
                return aVar;
            } else if (atVar.bwy()) {
                return com.tencent.mm.ui.chatting.ChattingTranslateView.a.Translated;
            } else {
                return com.tencent.mm.ui.chatting.ChattingTranslateView.a.NoTranslate;
            }
        }

        public final void a(long j, com.tencent.mm.ui.chatting.ChattingTranslateView.a aVar) {
            this.ouz.put(Long.valueOf(j), aVar);
        }

        private ViewStub xi(int i) {
            ViewStub viewStub = (ViewStub) findViewById(i);
            if (viewStub != null) {
                viewStub.inflate();
            }
            return viewStub;
        }

        public final void keepSignalling() {
            if (this.ouH == -2) {
                ak.vy().a(new ay(new com.tencent.mm.model.ay.a(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            eVar.keepSignalling();
                        }
                    }
                }), 0);
            }
        }

        public final void stopSignalling() {
            ak.vy().a(new ay(new com.tencent.mm.model.ay.a(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void a(com.tencent.mm.network.e eVar) {
                    if (eVar != null) {
                        eVar.stopSignalling();
                    }
                }
            }), 0);
        }

        private void bEX() {
            v.i("MicroMsg.ChattingUI", "visibleCustomFooter customFooter is %s", this.ote);
            if (this.ote != null) {
                this.ote.setVisibility(0);
                if (this.hjH != null) {
                    this.hjH.setVisibility(8);
                }
            }
        }

        private void bEY() {
            if (this.hjH != null) {
                this.hjH.setVisibility(0);
                if (this.ote != null) {
                    this.ote.setVisibility(8);
                }
            }
        }

        private void bEZ() {
            if (this.hjH != null) {
                this.hjH.setVisibility(8);
            }
            if (this.ote != null) {
                this.ote.setVisibility(8);
            }
        }

        public final void bFa() {
            this.ouJ = new AnimationSet(false);
            Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.ouJ.setInterpolator(new DecelerateInterpolator(1.5f));
            this.ouJ.addAnimation(translateAnimation);
            this.ouJ.addAnimation(alphaAnimation);
            this.ouJ.setDuration(300);
            this.ouJ.setFillBefore(true);
            if (this.hjH != null) {
                this.hjH.startAnimation(this.ouJ);
            }
        }

        @SuppressLint({"DefaultLocale"})
        public final String er(String str) {
            String et = com.tencent.mm.model.l.et(str);
            if (!this.lKa && !be.kS(et)) {
                return et;
            }
            if (this.otS.containsKey(str)) {
                et = (String) this.otS.get(str);
                if (!be.kS(et)) {
                    return et;
                }
            }
            if (this.onm && !str.toLowerCase().endsWith("@chatroom")) {
                com.tencent.mm.model.ab.a.crZ.a(str, SQLiteDatabase.KeyEmpty, new com.tencent.mm.model.ab.c.a(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void p(String str, boolean z) {
                        if (z) {
                            this.ovO.onh.a(null, null);
                        }
                    }
                });
            }
            if (this.lKa) {
                return this.ogZ.er(str);
            }
            return com.tencent.mm.model.l.er(str);
        }

        public final String hW(String str) {
            com.tencent.mm.modelbiz.a.j hQ = this.ogZ.hQ(str);
            if (hQ != null) {
                return hQ.field_headImageUrl;
            }
            return null;
        }

        @TargetApi(9)
        public final void jK(boolean z) {
            if (!this.nDR.bAe()) {
                return;
            }
            if (!z) {
                setRequestedOrientation(-1);
            } else if (VERSION.SDK_INT >= 9) {
                v.i("MicroMsg.ChattingUI", "rotation %d", Integer.valueOf(getWindowManager().getDefaultDisplay().getOrientation()));
                switch (getWindowManager().getDefaultDisplay().getOrientation()) {
                    case 0:
                        setRequestedOrientation(1);
                        return;
                    case 1:
                        setRequestedOrientation(0);
                        return;
                    case 2:
                        setRequestedOrientation(9);
                        return;
                    case 3:
                        setRequestedOrientation(8);
                        return;
                    default:
                        return;
                }
            } else if (bAq().getConfiguration().orientation == 2) {
                setRequestedOrientation(0);
            } else if (bAq().getConfiguration().orientation == 1) {
                setRequestedOrientation(1);
            }
        }

        protected final int getLayoutId() {
            return 2130903279;
        }

        protected final View bAd() {
            boolean z = true;
            String str = "MicroMsg.ChattingUI";
            String str2 = "call getLayoutView, result is NULL ? %B";
            Object[] objArr = new Object[1];
            if (this.ouW != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.d(str, str2, objArr);
            return this.ouW;
        }

        protected final void bB(View view) {
            super.bB(view);
            v.d("MicroMsg.ChattingUI", "dealContentView");
            if (bAm()) {
                if (this.ouS == null) {
                    this.ouS = (ActionBarContainer) ((ViewStub) view.findViewById(2131756038)).inflate();
                }
                this.ouT.nFp.Ek = (ViewGroup) view;
            }
        }

        public final void d(View view, View view2) {
            boolean z = true;
            String str = "MicroMsg.ChattingUI";
            String str2 = "call prepareLayoutView, mLayoutViewCache cache is NULL ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.ouW == null);
            v.d(str, str2, objArr);
            String str3 = "MicroMsg.ChattingUI";
            str = "call prepareLayoutView, mAbContentViewCache cache is NULL ? %B";
            Object[] objArr2 = new Object[1];
            if (this.ouV != null) {
                z = false;
            }
            objArr2[0] = Boolean.valueOf(z);
            v.d(str3, str, objArr2);
            this.ouW = view;
            this.ouV = view2;
        }

        private View i(ViewGroup viewGroup) {
            if (this.ouV == null) {
                if (viewGroup == null) {
                    this.ouV = com.tencent.mm.ui.q.em(this.nDR.nEl).inflate(2130903073, null);
                } else {
                    this.ouV = com.tencent.mm.ui.q.em(this.nDR.nEl).inflate(2130903073, viewGroup, false);
                }
                return this.ouV;
            } else if (this.ouV.getParent() == null) {
                return this.ouV;
            } else {
                if (this.ouV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.ouV.getParent()).removeView(this.ouV);
                    return this.ouV;
                }
                if (viewGroup == null) {
                    this.ouV = com.tencent.mm.ui.q.em(this.nDR.nEl).inflate(2130903073, null);
                } else {
                    this.ouV = com.tencent.mm.ui.q.em(this.nDR.nEl).inflate(2130903073, viewGroup, false);
                }
                return this.ouV;
            }
        }

        private void bFb() {
            ActionBar cV;
            if (this.nAV || !bAm()) {
                cV = ((ActionBarActivity) bzo()).cU().cV();
                View i = i(null);
                cV.setCustomView(i);
                this.ouU = new com.tencent.mm.ui.b(i);
            } else {
                ViewGroup viewGroup = (ViewGroup) this.ouS.findViewById(android.support.v7.a.a.f.IU);
                v.i("MicroMsg.ChattingUI", "mActionBarContainer %s", this.ouS);
                v.i("MicroMsg.ChattingUI", "ctxView %s", this.ouS.findViewById(android.support.v7.a.a.f.IZ));
                viewGroup.setVisibility(0);
                ActionBar cV2 = this.ouT.cV();
                View i2 = i(viewGroup);
                cV2.setCustomView(i2);
                this.ouU = new com.tencent.mm.ui.b(i2);
                int height = cV2.getHeight();
                if (height == 0) {
                    DisplayMetrics displayMetrics = bAq().getDisplayMetrics();
                    if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                        height = bAq().getDimensionPixelSize(2131493014);
                    } else {
                        height = bAq().getDimensionPixelSize(2131493015);
                    }
                }
                i2.setMinimumHeight(height);
                ViewGroup.LayoutParams layoutParams = i2.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -1);
                }
                layoutParams.height = height;
                i2.setLayoutParams(layoutParams);
                cV = cV2;
            }
            this.ouU.iF(false);
            cV.setDisplayOptions((((cV.getDisplayOptions() | 16) & -5) & -3) & -9);
            this.oup.clear();
            this.oup.add(getStringExtra("Chat_User"));
            b(this.ovm);
        }

        public final void vD(int i) {
            Fd(vN(i));
        }

        public final void Fd(String str) {
            bAp().getDimensionPixelSize(2131492967);
            this.ouU.setTitle(com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, (CharSequence) str, com.tencent.mm.bd.a.N(this.nDR.nEl, 2131492967)));
            NZ(d(2131231762, r0));
        }

        public final void NY(String str) {
            v.i("MicroMsg.ChattingUI", "now connect state, text : %s", str);
            CharSequence a = com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, (CharSequence) str, com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493128));
            com.tencent.mm.ui.b bVar = this.ouU;
            if (a == null || be.kS(a.toString())) {
                bVar.nzp.setVisibility(8);
                return;
            }
            bVar.nzp.setVisibility(0);
            bVar.nzp.setText(a);
            if (com.tencent.mm.bd.a.dt(bVar.nzp.getContext())) {
                bVar.nzp.setTextSize(1, 14.0f);
                bVar.dtY.setTextSize(1, 18.0f);
            }
        }

        public final void vE(int i) {
            NY(vN(i));
        }

        public final void b(final OnMenuItemClickListener onMenuItemClickListener) {
            this.ouU.i(new View.OnClickListener(this) {
                final /* synthetic */ a ovO;

                public final void onClick(View view) {
                    if (!this.ovO.nDR.nEb) {
                        v.w("MicroMsg.ChattingUI", "Actionbar customView onclick screen not enable");
                    } else if (onMenuItemClickListener != null) {
                        onMenuItemClickListener.onMenuItemClick(null);
                    }
                }
            });
        }

        public final void vM(int i) {
            int i2;
            int i3 = 0;
            com.tencent.mm.ui.b bVar = this.ouU;
            if (i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ImageView imageView = bVar.nzr;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        public final void vI(int i) {
            boolean z = false;
            if (m.fi(bEn())) {
                this.ouU.iE(false);
                return;
            }
            com.tencent.mm.ui.b bVar = this.ouU;
            if (i == 0) {
                z = true;
            }
            bVar.iE(z);
        }

        public final void xj(int i) {
            int i2;
            int i3 = 0;
            com.tencent.mm.ui.b bVar = this.ouU;
            if (i == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            ImageView imageView = bVar.nzt;
            if (i2 == 0) {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }

        private void bFc() {
            if (this.bhV == null) {
                v.e("MicroMsg.ChattingUI", "getChatroomMemberDetail() talker == null");
            } else if (m.dE(this.bhV.field_username)) {
                v.d("MicroMsg.ChattingUI", "cpan[changeTalker]");
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void run() {
                        com.tencent.mm.storage.o LC = ak.yW().wO().LC(this.ovO.bhV.field_username);
                        if (LC != null && LC.bvd()) {
                            v.d("MicroMsg.ChattingUI", "cpan[doScene NetSceneGetChatroomMemberDetail]");
                            com.tencent.mm.sdk.c.b iiVar = new ii();
                            iiVar.biD.biB = this.ovO.bhV.field_username;
                            iiVar.biD.biE = LC.bvc();
                            com.tencent.mm.sdk.c.a.nhr.z(iiVar);
                        }
                    }
                }, 1000);
            }
        }

        private void bFd() {
            int i = 0;
            this.otw = true;
            this.osX = false;
            this.osY = false;
            bFb();
            ak.yW();
            com.tencent.mm.storage.ab Mh = com.tencent.mm.model.c.wK().Mh(this.bhV.field_username);
            osT = this.bhV.field_username;
            h(Mh);
            if (Mh != null) {
                this.otD = Mh.field_unReadCount;
                this.otN = Mh.field_chatmode;
            }
            v.d("MicroMsg.ChattingUI", "dkcm init old:%d   ", Integer.valueOf(this.otN));
            String str = this.onj;
            if (this.hjH == null) {
                this.hjH = (ChatFooter) findViewById(2131756055);
            }
            this.hjH.uk(2131755468);
            v.i("MicroMsg.ChattingUI", "resetFooter customFooter is %s", this.ote);
            if (this.ote != null) {
                this.ote.aWV();
                this.ote.lMv = null;
                this.ote.olP = null;
                this.hjH.a(null);
                this.ote.bEa();
            }
            bEZ();
            ChatFooter chatFooter = this.hjH;
            if (chatFooter.lMm != null) {
                chatFooter.lMm.setVisibility(0);
            }
            if (this.otU || this.onc) {
                bEZ();
            } else if (m.eG(str)) {
                bEZ();
                xi(2131756056);
                r1 = this.ote == null;
                this.ote = (ChatFooterCustom) findViewById(2131756084);
                if (r1) {
                    this.ote.h((ViewGroup) findViewById(2131756040));
                }
                this.otq = new cu(this.ote);
                cu cuVar = this.otq;
                r1 = com.tencent.mm.sdk.platformtools.f.aPW == 1;
                cuVar.ors.findViewById(2131756085).setVisibility(8);
                cuVar.fqo = (LinearLayout) cuVar.ors.findViewById(2131756086);
                cuVar.ors.findViewById(2131756087).setVisibility(8);
                cuVar.fqo.setWeightSum(r1 ? 1.0f : 2.0f);
                cuVar.ort = (FrameLayout) cuVar.fqo.getChildAt(0);
                cuVar.ort.setVisibility(0);
                cuVar.ort.setOnClickListener(cuVar.orC);
                ((TextView) cuVar.ort.getChildAt(0).findViewById(2131756083)).setText(2131231737);
                cuVar.ort.getChildAt(0).findViewById(2131756082).setVisibility(8);
                cuVar.ort.getChildAt(1).setVisibility(8);
                if (r1) {
                    for (r0 = 1; r0 < 6; r0++) {
                        cuVar.fqo.getChildAt(r0).setVisibility(8);
                    }
                } else {
                    cuVar.oru = (FrameLayout) cuVar.fqo.getChildAt(1);
                    cuVar.oru.setVisibility(0);
                    cuVar.oru.setOnClickListener(cuVar.orD);
                    cuVar.orv = (TextView) cuVar.oru.getChildAt(0).findViewById(2131756083);
                    cuVar.orw = (ImageView) cuVar.oru.getChildAt(0).findViewById(2131756082);
                    cuVar.orw.setVisibility(0);
                    cuVar.bEO();
                    ak.yW();
                    cuVar.ory = ((Integer) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                    if (cuVar.ory >= 0) {
                        cuVar.bEQ();
                    } else {
                        cuVar.orv.setText(2131231750);
                    }
                    cuVar.oru.getChildAt(1).setVisibility(8);
                    for (r0 = 2; r0 < 6; r0++) {
                        cuVar.fqo.getChildAt(r0).setVisibility(8);
                    }
                    cuVar.orB = com.tencent.mm.h.j.sV().getMailAppEnterUlAndroid();
                    if (be.kS(cuVar.orB)) {
                        cuVar.orB = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                    }
                    ak.yW();
                    cuVar.orB = cuVar.orB.replace("$uin$", new com.tencent.mm.a.o(be.f((Integer) com.tencent.mm.model.c.vf().get(9, null))).toString());
                    cuVar.igJ = com.tencent.mm.h.j.sV().sS();
                    cuVar.orz = true;
                }
                bEX();
            } else {
                this.otq = null;
                if (m.ez(str)) {
                    bEZ();
                    xi(2131756056);
                    r1 = this.ote == null;
                    this.ote = (ChatFooterCustom) findViewById(2131756084);
                    if (r1) {
                        this.ote.h((ViewGroup) findViewById(2131756040));
                    }
                    this.otr = new cx(this.ote);
                    this.otr.bCh();
                    bEX();
                } else {
                    this.otr = null;
                    if (!(m.eH(str) || m.ez(str) || m.eG(str))) {
                        m.yr();
                        if (!m.fi(str)) {
                            AppPanel appPanel;
                            ChatFooter chatFooter2;
                            LayoutParams layoutParams;
                            bEY();
                            R(this.bhV);
                            r0 = OU(this.onj);
                            if (r0 == 2) {
                                v.i("MicroMsg.ChattingUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), bzo());
                                if (com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                                    this.hjH.R(r0, false);
                                }
                            } else {
                                this.hjH.R(r0, false);
                            }
                            this.hjH.HH(str);
                            this.hjH.bpC();
                            if (!bFp()) {
                                this.hjH.bpN();
                            }
                            if (this.lKa) {
                                BizInfo hw = com.tencent.mm.modelbiz.e.hw(bEn());
                                if (hw == null || hw.field_enterpriseFather == null) {
                                    r0 = 0;
                                } else {
                                    Cursor hq = com.tencent.mm.modelbiz.u.Dy().hq(hw.field_enterpriseFather);
                                    r0 = (hq == null || hq.getCount() <= 0) ? 0 : true;
                                    if (hq != null) {
                                        hq.close();
                                    }
                                }
                                if (r0 != 0) {
                                    appPanel = this.hjH.lMi;
                                    appPanel.lLp.lMd.value = true;
                                    appPanel.bpu();
                                }
                            }
                            if (!this.onl) {
                                this.hjH.bqa();
                            }
                            if (u.ew(str)) {
                                this.hjH.bpP();
                                this.hjH.bpW();
                                this.hjH.bpX();
                                this.hjH.bpO();
                                this.hjH.bpQ();
                                this.hjH.bpV();
                                this.hjH.bpS();
                                this.hjH.bpT();
                                this.hjH.bpU();
                            }
                            if (u.LJ(str)) {
                                this.hjH.bpP();
                                this.hjH.bpW();
                                this.hjH.bpX();
                                this.hjH.bpO();
                                this.hjH.bpQ();
                                this.hjH.bpV();
                                this.hjH.bpS();
                                this.hjH.bpT();
                                this.hjH.bpU();
                            }
                            if (u.LH(str)) {
                                this.hjH.bpP();
                                this.hjH.bpW();
                                this.hjH.bpX();
                                this.hjH.bpO();
                                this.hjH.bpL();
                                this.hjH.bpQ();
                                this.hjH.bpV();
                                this.hjH.bpS();
                                this.hjH.bpT();
                                this.hjH.bpU();
                            }
                            if (m.eS(str)) {
                                this.hjH.bpP();
                                this.hjH.bpW();
                                this.hjH.bpX();
                                this.hjH.bpQ();
                                this.hjH.bpV();
                                this.hjH.bpS();
                                this.hjH.bpT();
                                this.hjH.bpU();
                            }
                            if (this.onm) {
                                this.hjH.bpX();
                                this.hjH.bpP();
                                this.hjH.bpW();
                                appPanel = this.hjH.lMi;
                                appPanel.lLp.lLK.value = false;
                                appPanel.bpu();
                                this.hjH.bpO();
                                this.hjH.bpS();
                                this.hjH.bpV();
                                this.hjH.bpY();
                                this.hjH.lMp.setVisibility(8);
                                this.hjH.bpQ();
                                this.hjH.bpU();
                            }
                            if (m.eP(str)) {
                                this.hjH.bpP();
                                this.hjH.bpS();
                                this.hjH.bpV();
                            }
                            ak.yW();
                            u LX = com.tencent.mm.model.c.wH().LX(str);
                            if (LX != null && LX.bvm()) {
                                this.hjH.bpP();
                                this.hjH.bpS();
                                this.hjH.bpO();
                                this.hjH.bpV();
                            }
                            if (this.onl) {
                                if (com.tencent.mm.h.j.sU().getInt("MultitalkBlockCaller", 0) == 0) {
                                    this.hjH.ii(false);
                                    if (this.onl || this.otK) {
                                        this.hjH.bpS();
                                        this.hjH.bpU();
                                    }
                                    com.tencent.mm.ay.c.brh();
                                    if (this.otK) {
                                        this.hjH.bpV();
                                    }
                                    if (bEn().equals(com.tencent.mm.model.k.xF())) {
                                        this.hjH.bpV();
                                        this.hjH.bpS();
                                        this.hjH.bpT();
                                        this.hjH.bpU();
                                    }
                                    if (this.lKa) {
                                        this.hjH.bpP();
                                        this.hjH.bpX();
                                        this.hjH.bpO();
                                        this.hjH.bpV();
                                        this.hjH.bpS();
                                        this.hjH.bpT();
                                        this.hjH.bpU();
                                        this.hjH.bpN();
                                        this.hjH.bpR();
                                        this.hjH.bpM();
                                        this.hjH.bpZ();
                                        this.hjH.ahm();
                                    }
                                    this.hjH.ih(com.tencent.mm.ay.c.brh());
                                    chatFooter2 = this.hjH;
                                    com.tencent.mm.ay.c.brh();
                                    chatFooter2.ij(com.tencent.mm.af.b.GZ());
                                    this.hjH.bpV();
                                    bFG();
                                    if (this.lMy) {
                                        this.hjH.lMy = true;
                                        chatFooter = this.hjH;
                                        if (chatFooter.lMp != null) {
                                            chatFooter.lMp.setVisibility(8);
                                        }
                                        chatFooter2 = this.hjH;
                                        if (chatFooter2.lMm != null) {
                                            chatFooter2.lMm.setVisibility(8);
                                            if (chatFooter2.lMj != null && chatFooter2.lMj.getVisibility() == 0) {
                                                layoutParams = (LayoutParams) chatFooter2.lMj.getLayoutParams();
                                                layoutParams.rightMargin = com.tencent.mm.bd.a.fromDPToPix(chatFooter2.getContext(), 8);
                                                chatFooter2.lMj.setLayoutParams(layoutParams);
                                            }
                                        }
                                    }
                                }
                            }
                            this.hjH.ii(true);
                            this.hjH.bpS();
                            this.hjH.bpU();
                            com.tencent.mm.ay.c.brh();
                            if (this.otK) {
                                this.hjH.bpV();
                            }
                            if (bEn().equals(com.tencent.mm.model.k.xF())) {
                                this.hjH.bpV();
                                this.hjH.bpS();
                                this.hjH.bpT();
                                this.hjH.bpU();
                            }
                            if (this.lKa) {
                                this.hjH.bpP();
                                this.hjH.bpX();
                                this.hjH.bpO();
                                this.hjH.bpV();
                                this.hjH.bpS();
                                this.hjH.bpT();
                                this.hjH.bpU();
                                this.hjH.bpN();
                                this.hjH.bpR();
                                this.hjH.bpM();
                                this.hjH.bpZ();
                                this.hjH.ahm();
                            }
                            this.hjH.ih(com.tencent.mm.ay.c.brh());
                            chatFooter2 = this.hjH;
                            com.tencent.mm.ay.c.brh();
                            if (com.tencent.mm.af.b.GZ()) {
                            }
                            chatFooter2.ij(com.tencent.mm.af.b.GZ());
                            this.hjH.bpV();
                            bFG();
                            if (this.lMy) {
                                this.hjH.lMy = true;
                                chatFooter = this.hjH;
                                if (chatFooter.lMp != null) {
                                    chatFooter.lMp.setVisibility(8);
                                }
                                chatFooter2 = this.hjH;
                                if (chatFooter2.lMm != null) {
                                    chatFooter2.lMm.setVisibility(8);
                                    layoutParams = (LayoutParams) chatFooter2.lMj.getLayoutParams();
                                    layoutParams.rightMargin = com.tencent.mm.bd.a.fromDPToPix(chatFooter2.getContext(), 8);
                                    chatFooter2.lMj.setLayoutParams(layoutParams);
                                }
                            }
                        }
                    }
                    bEZ();
                }
            }
            bFe();
            if (this.oti != null) {
                this.oti.eSI = this.bhV.field_username;
            }
            bDO();
            this.otc = new ac(this.oth, this.onh, this, this.hjH, this.onj);
            this.otc.onn = aL("key_need_send_video", true).booleanValue();
            this.hjH.lMu = this.otc;
            com.tencent.mm.pluginsdk.ui.chat.k cwVar = new cw(this.nDR.nEl, this.bhV, this.onj);
            this.hjH.b((com.tencent.mm.pluginsdk.ui.chat.g) cwVar);
            this.hjH.a(cwVar);
            this.nDR.bAi();
            if (this.otU) {
                g.iuh.a(219, 11, 1, true);
                xi(2131756050);
                this.otT = findViewById(2131756051);
                this.oub = findViewById(2131758999);
                this.oth.setFocusable(false);
                this.oth.setFocusableInTouchMode(false);
                this.oub.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onClick(View view) {
                    }
                });
                if (this.otZ == null) {
                    xi(2131756046);
                    this.otZ = (TextView) findViewById(2131756317);
                }
                this.orj = new cv(this.nDR.nEl, new at(), bEn(), bFR(), this.nQK);
                this.orj.orP = new com.tencent.mm.ui.chatting.cv.a(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void xe(int i) {
                        this.ovO.xk(i);
                    }
                };
                this.oua = (ListView) findViewById(2131758998);
                this.oua.setAdapter(this.orj);
                this.oua.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        at atVar = (at) this.ovO.orj.getItem(i);
                        if (atVar != null && !be.kS(atVar.field_talker)) {
                            g.iuh.h(10450, Integer.valueOf(1));
                            Intent intent = new Intent(this.ovO.nDR.nEl, ChattingUI.class);
                            intent.putExtra("Chat_User", atVar.field_talker);
                            intent.putExtra("finish_direct", true);
                            intent.putExtra("show_search_chat_content_result", false);
                            intent.putExtra("msg_local_id", atVar.field_msgId);
                            intent.putExtra("img_gallery_enter_from_chatting_ui", true);
                            this.ovO.startActivity(intent);
                        }
                    }
                });
                this.oua.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.ovO.ale();
                        return false;
                    }
                });
                this.eSv = new com.tencent.mm.ui.tools.p();
                this.eSv.oUs = new com.tencent.mm.ui.tools.p.b(this) {
                    final /* synthetic */ a ovO;
                    private int owM = 0;

                    {
                        this.ovO = r2;
                    }

                    public final void ml(String str) {
                        if (be.kS(str)) {
                            this.owM = 0;
                            this.ovO.xk(-1);
                            return;
                        }
                        if (str.length() > this.owM) {
                            g.iuh.h(10451, Integer.valueOf(1));
                        }
                        this.owM = str.length();
                        g.iuh.h(10456, Integer.valueOf(1));
                        this.ovO.orj.uU(str);
                    }

                    public final void Of() {
                        new ac().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass110 owN;

                            {
                                this.owN = r1;
                            }

                            public final void run() {
                                a.Q(this.owN.ovO);
                            }
                        });
                    }

                    public final void Og() {
                    }

                    public final boolean mk(String str) {
                        return false;
                    }

                    public final void Oh() {
                    }
                };
                a(true, this.eSv);
                this.eSv.kj(true);
            }
            bDN();
            if (this.nQK) {
                com.tencent.mm.aq.c.chatType = 1;
            } else if (this.bhV.bvm()) {
                com.tencent.mm.aq.c.chatType = 2;
            } else {
                com.tencent.mm.aq.c.chatType = 0;
            }
            bDM();
            b(this.ovm);
            if (!m.fn(bEn()) && m.dE(bEn())) {
                ak.yW();
                Mh = com.tencent.mm.model.c.wK().Mh(bEn());
                if (Mh == null || (Mh.field_showTips & 2) > 0) {
                    v.d("MicroMsg.ChattingUI", "jacks ont need auto display name because : already tips");
                } else {
                    com.tencent.mm.storage.o LC = ak.yW().wO().LC(bEn());
                    if (LC == null || LC.DM().size() < 20) {
                        v.d("MicroMsg.ChattingUI", "jacks ont need auto display name because : member nums too few");
                    } else if (!(LC == null || LC.bvh())) {
                        i.a(bEn(), LC, true);
                        Mh.field_showTips = 2;
                        Mh.bCT = true;
                        ak.yW();
                        com.tencent.mm.model.c.wK().a(Mh, bEn(), true);
                        v.i("MicroMsg.ChattingUI", "Jacks Show auto Display name tips");
                        com.tencent.mm.model.h.a(bEn(), null, vN(2131231900), false, SQLiteDatabase.KeyEmpty, 0);
                    }
                }
            }
            if (com.tencent.mm.i.a.ei(this.bhV.field_type) && this.bhV.bvm() && !com.tencent.mm.modelbiz.e.hC(bEn())) {
                com.tencent.mm.modelbiz.u.DH();
                com.tencent.mm.modelbiz.i.hI(bEn());
            }
            bGc();
            bjR();
            if (this.oud && this.ouh == null) {
                this.ouh = new ab(this, this.onh, this.hjH, this.ote, this.bhV, this.nQK, this.ond);
                ab abVar = this.ouh;
                abVar.omY.bFC();
                cp cpVar = abVar.omZ;
                cpVar.oqE = true;
                cpVar.bEH();
                abVar.omZ.oqG.clear();
                if (abVar.ond != null) {
                    long[] jArr = abVar.ond;
                    int length = jArr.length;
                    while (i < length) {
                        abVar.omZ.ew(jArr[i]);
                        i++;
                    }
                }
                if (abVar.ona != null) {
                    abVar.ona.setVisibility(8);
                }
                if (abVar.onb != null) {
                    abVar.onb.setVisibility(8);
                }
                abVar.omY.bGb();
                abVar.omY.ale();
                abVar.omY.bFt();
                abVar.omY.iY(true);
            }
            this.irY = com.tencent.mm.plugin.wallet.a.bg(osT, 1);
            this.irY.aj(1, osT);
        }

        private void bFe() {
            v.i("MicroMsg.ChattingUI", "isTempSession : %s, showType : %d.", Boolean.valueOf(this.otb), Integer.valueOf(getIntExtra("key_temp_session_show_type", 0)));
            ak.yW();
            af Mh = com.tencent.mm.model.c.wK().Mh(this.bhV.field_username);
            if (this.otb) {
                ak.vy().a(new com.tencent.mm.modelsimple.k(this.onj, getIntExtra("key_temp_session_scene", 5), getStringExtra("key_temp_session_from")), 0);
            }
            if (!this.bhV.bvm() || com.tencent.mm.i.a.ei(this.bhV.field_type)) {
                this.otb = false;
            } else if (Mh == null) {
                if (this.otb) {
                    com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab(this.bhV.field_username);
                    abVar.ek(4194304);
                    abVar.bvG();
                    ak.yW();
                    com.tencent.mm.model.c.wK().d(abVar);
                }
            } else if (Mh.el(4194304)) {
                this.otb = true;
            } else if (Mh.field_conversationTime < com.tencent.mm.modelbiz.u.DK()) {
                ak.yW();
                r1 = com.tencent.mm.model.c.wK().b(this.bhV.field_username, 4194304, true, Mh.field_attrflag);
                v.i("MicroMsg.ChattingUI", "It is a old version temp session, Set attr flag(talker : %s), %s", this.bhV.field_username, Boolean.valueOf(r1));
                this.otb = true;
            } else if (this.otb) {
                ak.yW();
                r1 = com.tencent.mm.model.c.wK().b(this.bhV.field_username, 4194304, true, Mh.field_attrflag);
                v.i("MicroMsg.ChattingUI", "It is a temp session, Set attr flag(talker : %s), %s", this.bhV.field_username, Boolean.valueOf(r1));
            }
            v.d("MicroMsg.ChattingUI", "is temp session : %s.", Boolean.valueOf(this.otb));
            if (!this.otb) {
                return;
            }
            if (r0 == 1) {
                this.lMv.im(true);
            } else {
                this.lMv.im(false);
            }
        }

        private void bFf() {
            if (this.bhV != null && this.bhV.bvm()) {
                com.tencent.mm.modelbiz.u.DI().a(this.bhV.field_username, new com.tencent.mm.modelbiz.a.a(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void a(boolean z, final String str) {
                        boolean z2 = true;
                        if (!z || str == null || this.ovO.bhV == null || !str.equals(this.ovO.bhV.field_username)) {
                            String str2 = "MicroMsg.ChattingUI";
                            String str3 = "updateBizAttrs failed, succ(%b), username(%s), talker(isNull : %s).";
                            Object[] objArr = new Object[3];
                            objArr[0] = Boolean.valueOf(z);
                            objArr[1] = str;
                            if (this.ovO.bhV != null) {
                                z2 = false;
                            }
                            objArr[2] = Boolean.valueOf(z2);
                            v.i(str2, str3, objArr);
                            return;
                        }
                        ak.yW();
                        final com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(str);
                        if (LX == null || ((int) LX.chr) == 0) {
                            v.i("MicroMsg.ChattingUI", "Get contact from db return null.(username : %s)", str);
                            return;
                        }
                        final BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
                        com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass76 owu;

                            public final void run() {
                                if (this.owu.ovO.bhV != null && str.equals(this.owu.ovO.bhV.field_username) && this.owu.ovO.nBc) {
                                    v.i("MicroMsg.ChattingUI", "try to refresh footer.");
                                    this.owu.ovO.bhV = LX;
                                    this.owu.ovO.exj = hw;
                                    this.owu.ovO.R(this.owu.ovO.bhV);
                                }
                            }
                        });
                    }
                });
            }
        }

        private void h(com.tencent.mm.storage.ab abVar) {
            List h;
            if (this.lKa) {
                h = ak.yW().cqY.h(this.bhV.field_username, bFS(), com.tencent.mm.modelbiz.u.DB().T(bFS()).field_unReadCount);
            } else if (abVar == null || abVar.field_unReadCount <= 0) {
                h = null;
            } else {
                ak.yW();
                h = com.tencent.mm.model.c.wJ().bN(this.bhV.field_username, abVar.field_unReadCount);
            }
            if (h != null) {
                if (h.size() > 0) {
                    this.oue = ((at) h.get(0)).field_createTime;
                }
                cz czVar = this.ovi;
                if (!(czVar.oxp == null || czVar.oxo == null)) {
                    df dfVar = czVar.oxp;
                    Activity bzo = czVar.oxo.bzo();
                    dfVar.eBB = h;
                    dfVar.oxB = bzo;
                    if (dfVar.mHandler != null) {
                        dfVar.mHandler.sendEmptyMessageDelayed(0, 800);
                    }
                }
            }
            if (this.oue == 0) {
                bx I;
                if (this.lKa) {
                    I = ak.yW().cqY.I(this.bhV.field_username, bFS());
                } else {
                    ak.yW();
                    I = com.tencent.mm.model.c.wJ().MH(this.bhV.field_username);
                }
                if (I != null && !be.kS(I.field_talker)) {
                    this.oue = I.field_createTime;
                }
            }
        }

        public final void bFg() {
            v.d("MicroMsg.ChattingUI", "jacks onFragment Close");
            this.otw = false;
            if (this.lKa) {
                bGg();
                com.tencent.mm.modelbiz.u.DJ();
                com.tencent.mm.modelbiz.a.c cVar = this.ogZ;
                ak.yW();
                if (com.tencent.mm.model.c.wC()) {
                    ae.a(cVar.field_brandUserName, 8, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                    v.d("MicroMsg.BizChatStatusNotifyService", "quitChat:arg:%s", r1);
                }
                com.tencent.mm.modelbiz.a.a T = com.tencent.mm.modelbiz.u.DB().T(bFS());
                if (this.hjH != null && (this.ovh == null || !this.hjH.bpJ().trim().equals(this.ovh))) {
                    this.ovh = this.hjH.bpJ().trim();
                    T.field_editingMsg = this.ovh;
                    T.field_flag = com.tencent.mm.modelbiz.a.b.a(T, 1, be.kS(T.field_editingMsg) ? T.field_lastMsgTime : System.currentTimeMillis());
                    com.tencent.mm.modelbiz.u.DB().b(T);
                    v.v("MicroMsg.ChattingUI", "set editMsg history");
                }
            } else {
                com.tencent.mm.storage.ab abVar;
                ak.yW();
                com.tencent.mm.storage.ab Mh = com.tencent.mm.model.c.wK().Mh(bEn());
                if (Mh != null || this.hjH == null || be.kS(this.hjH.bpJ().trim())) {
                    abVar = Mh;
                } else {
                    af abVar2 = new com.tencent.mm.storage.ab(this.bhV.field_username);
                    abVar2.s(System.currentTimeMillis());
                    if (this.otb) {
                        abVar2.ek(4194304);
                    }
                    ak.yW();
                    com.tencent.mm.model.c.wK().d(abVar2);
                    abVar = abVar2;
                }
                if (!(abVar == null || this.hjH == null || (this.ovh != null && this.hjH.bpJ().trim().equals(this.ovh)))) {
                    this.ovh = this.hjH.bpJ().trim();
                    abVar.cx(this.hjH.bpJ().trim());
                    abVar.t(com.tencent.mm.storage.ac.a(abVar, 1, be.kS(abVar.field_editingMsg) ? abVar.field_conversationTime : System.currentTimeMillis()));
                    ak.yW();
                    com.tencent.mm.model.c.wK().a(abVar, abVar.field_username, false);
                    v.v("MicroMsg.ChattingUI", "jacks set editMsg history");
                }
            }
            com.tencent.mm.sdk.c.b pnVar = new pn();
            pnVar.bqP.type = 3;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            this.otj.clear();
            com.tencent.mm.plugin.sight.decode.a.b.wc();
            v.i("MicroMsg.ChattingUI", "[unregitListener]");
            com.tencent.mm.ae.n.GF().cMG = null;
            ak.vy().b(522, (com.tencent.mm.v.e) this);
            ak.vy().b((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (com.tencent.mm.v.e) this);
            ak.vy().b(10, (com.tencent.mm.v.e) this);
            ak.vy().b(127, (com.tencent.mm.v.e) this);
            ak.vy().b(594, (com.tencent.mm.v.e) this);
            ak.vy().b(551, (com.tencent.mm.v.e) this);
            ak.vy().b(610, (com.tencent.mm.v.e) this);
            ak.vy().b(137, (com.tencent.mm.v.e) this);
            com.tencent.mm.pluginsdk.d.b.b(ih.class.getName(), this.ovN);
            com.tencent.mm.pluginsdk.d.b.b(im.class.getName(), this.ovN);
            ak.vy().b(223, (com.tencent.mm.v.e) this);
            r.b(this.oqd);
            com.tencent.mm.modelvoice.e.b(this.oqd);
            el elVar = this.ouR;
            el.ozC.remove(elVar);
            elVar.ozB.clear();
            el.b(elVar.onG.nDR.nEl, null);
            if (ak.uz()) {
                ak.yW();
                com.tencent.mm.model.c.wH().b(this);
                ak.yW().wO().d(this.ouQ);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouM);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouA);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouu);
                com.tencent.mm.sdk.c.a.nhr.f(this.oux);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouG);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouB);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouC);
                am.Wf().d(this.ouO);
                am.bnB().d(this.ouP);
                ak.yW();
                com.tencent.mm.model.c.wJ().a((com.tencent.mm.storage.au.a) this);
                ak.yW();
                com.tencent.mm.model.c.wK().nuF.remove(this);
                com.tencent.mm.ae.n.GI().a((com.tencent.mm.ae.c.a) this);
                com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
                com.tencent.mm.u.n.AX().b(this.ouL);
                if (this.lKa) {
                    com.tencent.mm.modelbiz.u.DA().a(this.ohG);
                }
                com.tencent.mm.sdk.c.a.nhr.f(this.ouD);
                com.tencent.mm.sdk.c.a.nhr.f(this.ouE);
            }
            if (!this.nAV) {
                this.hkk.jr(true);
                ChatFooter chatFooter = this.hjH;
                View findViewById = chatFooter.findViewById(2131756069);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                chatFooter.mHandler.removeMessages(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                if (chatFooter.lMp != null) {
                    chatFooter.lMp.setVisibility(8);
                }
                if (chatFooter.lMq != null) {
                    chatFooter.lMq.setVisibility(8);
                }
                if (chatFooter.lMn != null) {
                    chatFooter.lMn.setVisibility(8);
                }
                if (chatFooter.fTc != null) {
                    chatFooter.fTc.setVisibility(8);
                }
                chatFooter.hhL.setVisibility(8);
                if (chatFooter.fTe != null) {
                    chatFooter.fTe.setVisibility(8);
                }
                if (chatFooter.fTf != null) {
                    chatFooter.fTf.setVisibility(8);
                }
                if (chatFooter.fTd != null) {
                    chatFooter.fTd.setVisibility(8);
                }
                if (chatFooter.lMh != null) {
                    chatFooter.lMh.setVisibility(8);
                    chatFooter.lMF = false;
                    chatFooter.lMh.destory();
                    if (chatFooter.hhK != null) {
                        chatFooter.hhK.setVisibility(0);
                    }
                }
                if (chatFooter.fTc != null) {
                    chatFooter.fTc.setVisibility(8);
                }
                if (chatFooter.klu != null) {
                    chatFooter.klu.setVisibility(8);
                }
                if (chatFooter.klr != null) {
                    chatFooter.klr.update();
                }
                if (chatFooter.lMk != null) {
                    chatFooter.lMk.setVisibility(8);
                }
                if (chatFooter.lMo != null) {
                    chatFooter.lMo.setVisibility(8);
                }
                chatFooter.lMi = (AppPanel) chatFooter.findViewById(2131756081);
                if (chatFooter.lMi != null) {
                    chatFooter.lMi.setVisibility(8);
                    AppPanel appPanel = chatFooter.lMi;
                    if (appPanel.iCu != null) {
                        appPanel.iCu.wx(0);
                    }
                }
                if (chatFooter.hhM != null) {
                    chatFooter.hhM.destroy();
                    chatFooter.lMo.removeView(chatFooter.hhM);
                    chatFooter.hhM = null;
                }
                chatFooter.bqj();
                ChatFooter chatFooter2 = this.hjH;
                chatFooter2.hhK.setText(SQLiteDatabase.KeyEmpty);
                chatFooter2.ig(false);
                this.hjH.lMw.lNv = null;
            }
            if (this.ote != null) {
                this.ote.bEa();
            }
            if (this.ovi != null) {
                cz czVar = this.ovi;
                if (czVar.oxp != null) {
                    df dfVar = czVar.oxp;
                    dfVar.mHandler.removeMessages(0);
                    if (dfVar.oxA != null) {
                        dfVar.oxA.stop();
                    }
                    v.d("MicroMsg.EggMgr", "egg has been stop");
                }
            }
            com.tencent.mm.sdk.c.a.nhr.z(new com.tencent.mm.e.a.ax());
            pnVar = new hq();
            pnVar.bhv.bhq = 2;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            if (com.tencent.mm.app.plugin.a.a.a(this.exj)) {
                v.i("MicroMsg.ChattingUI", "hardevice brand account, init event : %s, notify exit chattingui", bFU());
                if (this.ouZ == null) {
                    this.ouZ = new com.tencent.mm.app.plugin.a.a(this);
                }
                this.ouZ.a(2, this.exj);
                NY(null);
            }
            bDX();
            if (this.onh != null) {
                this.onh.bEC();
                v.i("MicroMsg.ChattingUI", "ChattingUI resetAdapter");
            }
            com.tencent.mm.pluginsdk.ui.d.e.clearCache();
            if (this.hjH != null) {
                chatFooter2 = this.hjH;
                if (chatFooter2.lMt != null) {
                    chatFooter2.lMt.lOf = false;
                    chatFooter2.lMt.hide();
                }
            }
        }

        public void onActivityCreated(Bundle bundle) {
            v.i("MicroMsg.ChattingUI", "onCreate %d", Integer.valueOf(hashCode()));
            super.onActivityCreated(bundle);
            bDK();
        }

        private void bFh() {
            v.d("MicroMsg.ChattingUI", "doCreateOnerousJob!!! rawUserName:%s", this.onj);
            com.tencent.mm.sdk.c.b pnVar = new pn();
            pnVar.bqP.type = 4;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            v.i("MicroMsg.ChattingUI", "[regitListener]");
            ak.vy().a(522, (com.tencent.mm.v.e) this);
            ak.vy().a((int) MMGIFException.D_GIF_ERR_CLOSE_FAILED, (com.tencent.mm.v.e) this);
            ak.vy().a(10, (com.tencent.mm.v.e) this);
            ak.vy().a(127, (com.tencent.mm.v.e) this);
            ak.vy().a(610, (com.tencent.mm.v.e) this);
            ak.vy().a(594, (com.tencent.mm.v.e) this);
            ak.vy().a(551, (com.tencent.mm.v.e) this);
            ak.vy().a(137, (com.tencent.mm.v.e) this);
            ak.yW();
            com.tencent.mm.model.c.wH().a(this);
            ak.yW().wO().c(this.ouQ);
            ak.yW();
            com.tencent.mm.model.c.wJ().a((com.tencent.mm.storage.au.a) this, Looper.getMainLooper());
            ak.yW();
            com.tencent.mm.model.c.wK().a((com.tencent.mm.storage.ac.b) this, Looper.getMainLooper());
            com.tencent.mm.pluginsdk.d.b.a(ih.class.getName(), this.ovN);
            com.tencent.mm.pluginsdk.d.b.a(im.class.getName(), this.ovN);
            ak.vy().a(223, (com.tencent.mm.v.e) this);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouM);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouA);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouu);
            com.tencent.mm.sdk.c.a.nhr.e(this.oux);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouG);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouB);
            com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouC);
            t.HT().c(this.ouN);
            t.HS().c(this.ouN);
            am.Wf().c(this.ouO);
            am.bnB().c(this.ouP);
            com.tencent.mm.u.n.AX().a(this.ouL);
            if (this.lKa) {
                com.tencent.mm.modelbiz.u.DA().a(this.ohG, Looper.getMainLooper());
            }
            el.ozC.a(this.ouR, null);
            com.tencent.mm.ae.n.GF().cMG = this;
            com.tencent.mm.sdk.c.a.nhr.e(this.ouD);
            com.tencent.mm.sdk.c.a.nhr.e(this.ouE);
            pnVar = new hq();
            pnVar.bhv.bhq = 0;
            pnVar.bhv.aOo = com.tencent.mm.sdk.platformtools.u.bsY();
            if (m.dE(this.bhV.field_username)) {
                pnVar.bhv.bhx = true;
            } else {
                pnVar.bhv.bhx = false;
            }
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            if (m.dE(this.bhV.field_username) && i.eg(this.bhV.field_username)) {
                v.d("MicroMsg.ChattingUI", "chattingui find chatroom contact need update %s", this.bhV.field_username);
                com.tencent.mm.model.ab.a.crZ.I(this.bhV.field_username, SQLiteDatabase.KeyEmpty);
            }
            if (!(com.tencent.mm.pluginsdk.j.a.lxP == null || this.bhV.field_username.equals(com.tencent.mm.pluginsdk.j.a.lxP.awp()))) {
                v.i("MicroMsg.ChattingUI", "chatting oncreate end track %s", com.tencent.mm.pluginsdk.j.a.lxP.awp());
                pnVar = new dx();
                pnVar.bbQ.username = this.bhV.field_username;
                com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            }
            ak.yW();
            if (com.tencent.mm.model.c.wC()) {
                ae.z(this.onj, 2);
            }
            if (this.onm) {
                pnVar = new ho();
                pnVar.bhk.bdf = 4;
                com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            } else {
                com.tencent.mm.app.plugin.b.cJ(2);
            }
            if (this.otJ) {
                this.nGj = com.tencent.mm.modelbiz.a.e.d(this.ogZ);
            } else {
                this.nGj = i.ef(bEn());
            }
            bFc();
            pnVar = new jl();
            pnVar.bjQ.bdo = this.bhV.field_username;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            if (m.eZ(bEn())) {
                boolean a = com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.BODY_SENSORS", MMGIFException.D_GIF_ERR_IMAGE_DEFECT, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                v.i("MicroMsg.ChattingUI", "summerper checkPermission checkBodySenors[%b], activity[%s]", Boolean.valueOf(a), bzo());
            }
        }

        private void bFi() {
            if (osT != null) {
                int i;
                int i2;
                int i3;
                int i4;
                if ("notification_messages".equals(osT)) {
                    i = 1;
                    i2 = 8;
                    i3 = 0;
                } else {
                    if (m.eD(osT)) {
                        if (this.lKa) {
                            if (tM()) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (this.otJ) {
                                i3 = this.ogZ.DM().size();
                                i2 = 5;
                            } else {
                                i3 = 0;
                                i2 = 4;
                            }
                        } else if (com.tencent.mm.modelbiz.e.hA(osT)) {
                            i = tM() ? 0 : 1;
                            i3 = 0;
                            i2 = 3;
                        } else if (com.tencent.mm.modelbiz.e.hB(osT)) {
                            i = 1;
                            i3 = 0;
                            i2 = 0;
                        } else if (com.tencent.mm.modelbiz.e.hx(osT)) {
                            i3 = 6;
                            i = 0;
                        } else {
                            i3 = 7;
                            i = 0;
                        }
                    } else if (this.nQK) {
                        i3 = i.el(osT);
                        i = tM() ? 0 : 1;
                        i2 = 2;
                    } else if (tM()) {
                        i = 0;
                        i3 = 1;
                    } else {
                        i = 1;
                        i3 = 1;
                    }
                    i2 = i3;
                    i3 = 0;
                }
                if (this.onm || this.otK) {
                    i4 = 0;
                } else {
                    for (String equals : m.crG) {
                        if (equals.equals(osT)) {
                            i2 = 0;
                        }
                    }
                    i4 = i2;
                }
                if (i4 != 0) {
                    ak.yW();
                    af Mh = com.tencent.mm.model.c.wK().Mh(osT);
                    i2 = Mh == null ? 0 : Mh.field_unReadCount;
                    z zVar = z.bYz;
                    String str = osT;
                    if (zVar.bYE == null) {
                        zVar.bYE = com.tencent.mm.model.k.xF();
                    }
                    if (!zVar.bYE.equals(str)) {
                        if (zVar.bYB != null) {
                            v.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", zVar.bYB.bYK);
                            zVar.cY(zVar.bYB.bYK);
                        }
                        if (zVar.bYA.getInt(6, 0) == 0) {
                            zVar.bYA.setLong(4, com.tencent.mm.platformtools.t.Nh());
                        }
                        zVar.bYB = new a(zVar);
                        zVar.bYB.bYK = str;
                        zVar.bYC = com.tencent.mm.platformtools.t.Nj();
                        zVar.bYB.type = i4;
                        zVar.bYB.bYL = i;
                        zVar.bYB.aWI = i2;
                        zVar.bYB.bYM = i3;
                        zVar.bYB.bYN = com.tencent.mm.platformtools.t.Nh();
                        v.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", str, Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                    }
                }
            }
        }

        public void bDK() {
            boolean z;
            int i = 0;
            this.ovj = System.currentTimeMillis();
            this.ovk = true;
            v.i("MicroMsg.ChattingUI", "do Create !!!!");
            this.ovz = false;
            this.ovA = false;
            this.ovB = 0;
            v.d("MicroMsg.ChattingUI", "jacks mark reset keybord state");
            this.oty = d.oxl;
            boolean kS = be.kS(this.onj);
            this.lKa = aL("key_is_biz_chat", false).booleanValue();
            if (this.lKa) {
                kS = -1 == this.ouc;
            }
            String stringExtra = getStringExtra("Chat_User");
            long NW = NW("key_biz_chat_id");
            if (stringExtra.equals(this.onj)) {
                z = false;
            } else {
                z = true;
            }
            if (this.lKa) {
                if (NW != this.ouc) {
                    z = true;
                } else {
                    z = false;
                }
            }
            this.ova = false;
            this.ovb = false;
            this.otp = true;
            this.otb = false;
            this.ouz.clear();
            this.otQ = true;
            if (this.nAV || r1) {
                u uVar;
                v.i("MicroMsg.ChattingUI", "resetBaseParams rawUserName from :%s to :%s ", this.onj, getStringExtra("Chat_User"));
                this.otb = aL("key_is_temp_session", false).booleanValue();
                this.onj = getStringExtra("Chat_User");
                this.ouc = NW("key_biz_chat_id");
                this.otL = aL("finish_direct", false).booleanValue();
                this.otU = aL("search_chat_content", false).booleanValue();
                this.onc = aL("show_search_chat_content_result", false).booleanValue();
                this.otV = aL("need_hight_item", false).booleanValue();
                this.otX = aL("from_global_search", false).booleanValue();
                this.otW = aL("img_gallery_enter_from_chatting_ui", false).booleanValue();
                v.d("MicroMsg.ChattingUI", "isFromSearch  " + this.otL);
                ak.yW();
                this.bhV = com.tencent.mm.model.c.wH().LX(this.onj);
                com.tencent.mm.e.b.ab abVar = this.bhV;
                String str = this.onj;
                String str2 = "MicroMsg.ChattingUI";
                String str3 = "protectContactNotExist user:%s contact:%d ";
                Object[] objArr = new Object[2];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(abVar == null ? -1 : (int) abVar.chr);
                v.w(str2, str3, objArr);
                if (abVar == null || ((int) abVar.chr) == 0 || be.kS(abVar.field_username)) {
                    uVar = new u();
                    uVar.setUsername(str);
                    uVar.tq();
                    uVar.cU(3);
                    ak.yW();
                    com.tencent.mm.model.c.wH().M(uVar);
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(str);
                    if (LX == null) {
                        v.e("MicroMsg.ChattingUI", "protectContactNotExist contact get from db is null!");
                    } else {
                        uVar = LX;
                    }
                } else {
                    com.tencent.mm.e.b.ab abVar2 = abVar;
                }
                this.bhV = uVar;
                this.bhj = be.kS(this.bhV.field_encryptUsername) ? this.bhV.field_username : this.bhV.field_encryptUsername;
                this.exj = com.tencent.mm.modelbiz.e.hw(bEn());
                if (this.lKa) {
                    this.ogZ = com.tencent.mm.modelbiz.u.DA().Z(this.ouc);
                    this.ogZ = com.tencent.mm.modelbiz.a.e.a(this.ogZ, this.ouc);
                }
                z = this.lKa && com.tencent.mm.modelbiz.a.e.hT(this.ogZ.field_bizChatServId);
                this.otJ = z;
                if (this.lKa && !this.otJ) {
                    this.hVf = com.tencent.mm.modelbiz.u.DC().ig(this.ogZ.field_bizChatServId);
                    this.hVf = com.tencent.mm.modelbiz.a.e.a(this.hVf, this.ogZ.field_bizChatServId);
                }
                this.oud = aL("expose_edit_mode", false).booleanValue();
                this.ond = this.oJ.getLongArray("expose_selected_ids");
                this.lMy = aL("lbs_mode", false).booleanValue();
                this.enX = getStringExtra("lbs_ticket");
                if (this.lMy) {
                    stringExtra = this.bhV.field_username;
                    if (!(stringExtra == null || m.eB(stringExtra))) {
                        this.bhV.setUsername(this.onj);
                        this.bhV.bY(null);
                        ak.yW();
                        com.tencent.mm.model.c.wH().a(stringExtra, this.bhV);
                        this.onj = this.bhV.field_username;
                    }
                }
                this.iRy = getIntExtra("add_scene", 0);
                this.ouz.clear();
                stringExtra = new com.tencent.mm.storage.ax.a(bEn()).Nq(SQLiteDatabase.KeyEmpty);
                v.d("MicroMsg.ChattingUI", "new RoleInfo.Parser(getTalkerUserName())" + stringExtra);
                ak.yW();
                this.olR = com.tencent.mm.model.c.wN().Nr(stringExtra);
                stringExtra = bEn();
                this.onl = stringExtra.endsWith("@chatroom");
                this.otK = OT(stringExtra);
                this.onm = m.ey(stringExtra);
                if (this.otJ) {
                    this.nGj = com.tencent.mm.modelbiz.a.e.d(this.ogZ);
                } else {
                    this.nGj = i.ef(bEn());
                }
                z = this.onl || this.onm || this.otJ;
                this.nQK = z;
                if (this.lKa) {
                    stringExtra = com.tencent.mm.modelbiz.u.DB().T(bFS()).field_editingMsg;
                    this.ouo = stringExtra;
                    this.ovh = stringExtra;
                    bGf();
                } else {
                    ak.yW();
                    af Mh = com.tencent.mm.model.c.wK().Mh(bEn());
                    if (Mh != null) {
                        stringExtra = Mh.field_editingMsg;
                        this.ouo = stringExtra;
                        this.ovh = stringExtra;
                    }
                }
                this.osX = false;
                this.ota = this.onl;
                if (be.kS(this.onj)) {
                    g.iuh.a(110, 0, 1, true);
                }
                com.tencent.mm.booter.notification.queue.b qC = com.tencent.mm.booter.notification.queue.b.qC();
                String str4 = this.bhV.field_username;
                if (!com.tencent.mm.platformtools.t.kS(str4)) {
                    qC.bZL.dd(str4);
                }
                if (kS) {
                    this.fRJ = (ClipboardManager) this.nDR.nEl.getSystemService("clipboard");
                    ak.vy().a(new ay(new com.tencent.mm.model.ay.a(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar != null) {
                                a.a(this.ovO, eVar);
                            }
                        }
                    }), 0);
                    if (com.tencent.mm.app.plugin.a.a.a(this.exj)) {
                        v.i("MicroMsg.ChattingUI", "hardevice brand account, init event : %s", bFU());
                        this.ouZ = new com.tencent.mm.app.plugin.a.a(this);
                    }
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void run() {
                            this.ovO.bFb();
                            this.ovO.bDM();
                        }
                    });
                }
                bFd();
                bFf();
                if (this.gYg) {
                    bFh();
                }
                this.ous = new com.tencent.mm.pluginsdk.ui.chat.d(this.nDR.nEl, this.hjH);
                bFi();
                com.tencent.mm.modelstat.b.daJ.bc(osT);
                return;
            }
            if (this.bhV != null) {
                String str5;
                if (this.lKa) {
                    str5 = com.tencent.mm.modelbiz.u.DB().T(bFS()).field_editingMsg;
                    this.ouo = str5;
                    this.ovh = str5;
                    bGf();
                } else {
                    ak.yW();
                    af Mh2 = com.tencent.mm.model.c.wK().Mh(bEn());
                    if (Mh2 != null) {
                        str5 = Mh2.field_editingMsg;
                        this.ouo = str5;
                        this.ovh = str5;
                    }
                }
            }
            this.exj = com.tencent.mm.modelbiz.e.hw(bEn());
            bFb();
            bDM();
            int OU = OU(this.onj);
            if (OU == 2) {
                v.i("MicroMsg.ChattingUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), bzo());
                if (com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                    this.hjH.R(OU, false);
                }
            } else {
                this.hjH.R(OU, false);
            }
            bFG();
            bFe();
            bDN();
            ak.yW();
            com.tencent.mm.storage.ab Mh3 = com.tencent.mm.model.c.wK().Mh(this.bhV.field_username);
            h(Mh3);
            if (Mh3 == null || Mh3.field_UnDeliverCount == 0) {
                a(Mh3, false);
            } else if (this.osV != null) {
                this.osV.setVisibility(8);
                v.i("MicroMsg.ChattingUI", "summerbadcr not updateGoBacktoHistroyMessage onCreate UnDeliver:%d, UnRead:%d", Integer.valueOf(Mh3.field_UnDeliverCount), Integer.valueOf(Mh3.field_unReadCount));
            }
            bFf();
            bFi();
            com.tencent.mm.modelstat.b.daJ.bc(osT);
            while (i < this.otz.size()) {
                this.otz.get(i);
                i++;
            }
        }

        public final void bFj() {
            v.i("MicroMsg.ChattingUI", "ashutest::doJobOnAnimInEnd");
            if (this.gYg) {
                bFh();
                bDL();
            }
        }

        public final void bFk() {
            int i = 10;
            if (!(this.onc || this.otX)) {
                int i2 = this.ovf;
                this.ovf = i2 + 1;
                if (i2 < 10 && (bzo() instanceof ChattingUI)) {
                    ListView listView = this.oth;
                    Runnable anonymousClass83 = new Runnable(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void run() {
                            if (this.ovO.ouX || this.ovO.xe != 0) {
                                this.ovO.ovf = 10;
                                v.i("MicroMsg.ChattingUI", "scrollToLastProtect userTouched: %s state: %s", Boolean.valueOf(this.ovO.ouX), Integer.valueOf(this.ovO.xe));
                                return;
                            }
                            v.i("MicroMsg.ChattingUI", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", Integer.valueOf(this.ovO.ovf), Integer.valueOf(this.ovO.oth.getLastVisiblePosition()), Integer.valueOf(this.ovO.oth.getCount() - 1));
                            if (this.ovO.oth.getLastVisiblePosition() < this.ovO.oth.getCount() - 1) {
                                this.ovO.jM(true);
                                this.ovO.bFk();
                                return;
                            }
                            this.ovO.ovf = 10;
                        }
                    };
                    if (this.ovf != 1) {
                        i = 100;
                    }
                    listView.postDelayed(anonymousClass83, (long) i);
                    return;
                }
            }
            v.d("MicroMsg.ChattingUI", "scrollToLastProtect:%s, %s ,%s", Boolean.valueOf(this.onc), Boolean.valueOf(this.otX), Integer.valueOf(this.ovf));
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
            ViewGroup.LayoutParams layoutParams = onCreateView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            onCreateView.setLayoutParams(layoutParams);
            return onCreateView;
        }

        public void onDestroy() {
            com.tencent.mm.model.ax.q("bizflag", false);
            v.i("MicroMsg.ChattingUI", "dktask FragmentonDestroy %s#0x%x task:%s ", bzo().getClass().getSimpleName(), Integer.valueOf(bzo().hashCode()), be.ea(bzo()));
            if (this.onj != null) {
                com.tencent.mm.sdk.c.b hoVar;
                v.i("MicroMsg.ChattingUI", "onDestroy %d", Integer.valueOf(hashCode()));
                if (this.onm) {
                    hoVar = new ho();
                    hoVar.bhk.bdf = 5;
                    com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                    com.tencent.mm.app.plugin.b.cJ(3);
                }
                if (this.hjH != null) {
                    this.hjH.lMu = null;
                    this.otc = null;
                    this.hjH.b(null);
                    this.hjH.a(null);
                }
                if (this.otO != null) {
                    this.otO.onDetach();
                }
                if (this.ote != null) {
                    this.ote.aWV();
                    this.ote = null;
                }
                bFg();
                if (ak.uz()) {
                    t.HT().d(this.ouN);
                    t.HS().d(this.ouN);
                }
                releaseWakeLock();
                if (this.oqd != null) {
                    this.oqd.bDQ();
                    com.tencent.mm.model.v vVar = this.oqd;
                    vVar.release();
                    vVar.ols = null;
                    vVar.olw = false;
                    com.tencent.mm.sdk.c.a.nhr.f(vVar.olx);
                    ak.oJ().b(vVar);
                }
                hoVar = new hq();
                hoVar.bhv.bhq = 2;
                com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                this.onh.avc();
                if (this.orj != null) {
                    this.orj.avc();
                }
                if (this.eSv != null) {
                    this.eSv.clearFocus();
                }
                this.onh.nDK = null;
                bFW();
                ak.yW();
                if (com.tencent.mm.model.c.wC()) {
                    ae.z(bEn(), 5);
                }
                if (ak.uz() && com.tencent.mm.i.a.ei(this.bhV.field_type) && this.bhV.bvm() && !com.tencent.mm.modelbiz.e.hC(bEn())) {
                    com.tencent.mm.modelbiz.u.DH();
                    com.tencent.mm.modelbiz.i.hJ(bEn());
                }
                if (this.nAV && this.hjH != null) {
                    this.hjH.destroy();
                }
                if (this.ovK != null) {
                    this.ovK.stop();
                }
                this.otB.QI();
                this.ouK.QI();
                if (this.ouZ != null) {
                    com.tencent.mm.app.plugin.a.a aVar = this.ouZ;
                    v.d("MicroMsg.exdevice.ChattingUIExDeviceLogic", "now release the event listener");
                    if (aVar.aSE != null) {
                        com.tencent.mm.sdk.c.a.nhr.f(aVar.aSE);
                        aVar.aSE = null;
                        if (aVar.aSG != null) {
                            aVar.aSG.clear();
                        }
                    }
                }
                if (this.our != null) {
                    this.our.onDetach();
                }
                com.tencent.mm.ui.chatting.gallery.f fVar = this.otC;
                fVar.sR.clear();
                fVar.aqU();
            }
            z.bYz.cY(osT);
            com.tencent.mm.modelstat.b.daJ.qq();
            super.onDestroy();
        }

        public final void onStart() {
            ak.yW().xt().a(new com.tencent.mm.model.b.d.a(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void Am() {
                    this.ovO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass84 oww;

                        {
                            this.oww = r1;
                        }

                        public final void run() {
                            this.oww.ovO.bFx();
                        }
                    });
                }

                public final void An() {
                    this.ovO.bFy();
                }
            });
            ak.yW().xu().a(new com.tencent.mm.model.b.d.a(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void Am() {
                    this.ovO.handler.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass85 owx;

                        {
                            this.owx = r1;
                        }

                        public final void run() {
                            this.owx.ovO.bFz();
                        }
                    });
                }

                public final void An() {
                    this.ovO.bFA();
                }
            });
            super.onStart();
        }

        public final void onStop() {
            ak.yW().xt().a(null);
            ak.yW().xu().a(null);
            com.tencent.mm.sdk.platformtools.ad.B(this.ouv);
            com.tencent.mm.sdk.platformtools.ad.B(this.ouw);
            super.onStop();
        }

        public final boolean tM() {
            if (this.lKa) {
                if (this.otJ) {
                    return this.ogZ.fe(1);
                }
                return this.hVf.fe(1);
            } else if ((this.nQK && this.bhV.bCh == 0) || this.bhV.tM()) {
                return true;
            } else {
                return false;
            }
        }

        private void bFl() {
            if (this.oug == null || !this.oug.oqD) {
                int i;
                if (tM()) {
                    vI(0);
                } else {
                    vI(8);
                }
                ak.yW();
                Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(26, null);
                if (bool == null) {
                    this.evz = false;
                } else {
                    this.evz = bool.booleanValue();
                }
                if (this.evz) {
                    i = 0;
                } else {
                    i = 8;
                }
                vM(i);
                return;
            }
            v.d("MicroMsg.ChattingUI", "trigger title icon, in show mode");
            iY(false);
            vM(8);
            vI(8);
        }

        public void onCreate(Bundle bundle) {
            v.i("MicroMsg.ChattingUI", "dktask FragmentonCreate:%s#0x%x task:%s ", bzo().getClass().getSimpleName(), Integer.valueOf(bzo().hashCode()), be.ea(bzo()));
            if (bAm()) {
                this.ouT = new com.tencent.mm.ui.l();
                Object obj = this.ouT;
                obj.nFo = this;
                obj.nFp = new com.tencent.mm.ui.b.b(bzo(), obj);
                com.tencent.mm.ui.k kVar = this.ouT;
                if (kVar != null) {
                    this.nDR = kVar;
                }
            }
            super.onCreate(bundle);
        }

        protected void bDL() {
            boolean z;
            o oVar;
            ExtInfo aX;
            ChatFooter chatFooter;
            CharSequence vN;
            v.i("MicroMsg.ChattingUI", "onResumeOnerousJob!!!");
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final boolean queueIdle() {
                    v.i("MicroMsg.ChattingUI", "now try to activity the tools process");
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(com.tencent.mm.ui.d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                    this.ovO.sendBroadcast(intent);
                    return false;
                }
            });
            com.tencent.mm.sdk.c.b pnVar = new pn();
            pnVar.bqP.type = 0;
            if (this.oth != null) {
                pnVar.bqP.bqS = this.oth.getHeaderViewsCount();
                pnVar.bqP.bqQ = this.oth.getFirstVisiblePosition();
                pnVar.bqP.bqR = this.oth.getLastVisiblePosition();
            }
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            if (!this.nAV && (bzo() instanceof LauncherUI)) {
                ((LauncherUI) bzo()).bzF();
            }
            if (com.tencent.mm.app.plugin.a.a.a(this.exj)) {
                v.i("MicroMsg.ChattingUI", "hardevice brand account, onresume: %s, notify switch view enter chattingui", bFU());
                if (this.ouZ == null) {
                    this.ouZ = new com.tencent.mm.app.plugin.a.a(this);
                }
                this.ouZ.a(1, this.exj);
            } else {
                NY(null);
            }
            BizInfo bizInfo = this.exj;
            if (!(bizInfo == null || bizInfo == null)) {
                ExtInfo aX2 = bizInfo.aX(false);
                if (aX2 != null && aX2.CI()) {
                    String d;
                    z = true;
                    if (z) {
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void run() {
                                com.tencent.mm.sdk.c.b mfVar = new mf();
                                mfVar.bnp.userName = this.ovO.exj.field_username;
                                com.tencent.mm.sdk.c.a.nhr.z(mfVar);
                            }
                        });
                    }
                    bFu();
                    ak.oH().db(bEn());
                    MMAppMgr.oz();
                    if (otP) {
                        otP = false;
                        a(true, true, null);
                    }
                    if (!com.tencent.mm.i.a.ei(this.bhV.field_type) && this.bhV.bvm() && this.exj != null) {
                        aX2 = this.exj.aX(false);
                        if (aX2 != null && aX2.Cv()) {
                            z = (com.tencent.mm.modelgeo.c.FZ() || com.tencent.mm.modelgeo.c.Ga()) ? false : true;
                            if (this.exj.field_hadAlert == 0 || (this.exj.Cs() && z)) {
                                if (this.exj.field_hadAlert == 0 && z) {
                                    d = d(2131231767, this.bhV.tU());
                                } else if (z) {
                                    d = d(2131231768, this.bhV.tU());
                                } else {
                                    d = d(2131231766, this.bhV.tU());
                                }
                                this.hVo = com.tencent.mm.ui.base.g.a(this.nDR.nEl, d, vN(2131231164), new OnClickListener(this) {
                                    final /* synthetic */ a ovO;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.ovO.exj.field_hadAlert = 1;
                                        BizInfo L = this.ovO.exj;
                                        if (L != null) {
                                            L.field_brandFlag |= 4;
                                            com.tencent.mm.modelbiz.e.g(L);
                                        }
                                        if (z) {
                                            this.ovO.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                                            return;
                                        }
                                        com.tencent.mm.modelbiz.u.DH().hK(this.ovO.bEn());
                                    }
                                }, new OnClickListener(this) {
                                    final /* synthetic */ a ovO;

                                    {
                                        this.ovO = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.ovO.exj.field_hadAlert = 1;
                                        BizInfo L = this.ovO.exj;
                                        if (L != null) {
                                            L.field_brandFlag &= -5;
                                            com.tencent.mm.modelbiz.e.g(L);
                                        }
                                        com.tencent.mm.modelbiz.u.DH().hK(this.ovO.bEn());
                                    }
                                });
                            } else {
                                com.tencent.mm.modelbiz.u.DH().hK(bEn());
                            }
                        }
                        if (this.exj.Ct() && !(this.bhV.bvm() && com.tencent.mm.modelbiz.a.Cq())) {
                            com.tencent.mm.model.ab.a.crZ.I(this.bhV.field_username, SQLiteDatabase.KeyEmpty);
                            com.tencent.mm.u.b.gC(this.bhV.field_username);
                        }
                        if (this.exj.field_status == 1) {
                            this.exj.field_status = 0;
                            com.tencent.mm.modelbiz.u.Dy().e(this.exj);
                        }
                    } else if (!(aL("key_has_add_contact", false).booleanValue() || com.tencent.mm.i.a.ei(this.bhV.field_type) || !this.bhV.bvm())) {
                        com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void run() {
                                if (!com.tencent.mm.i.a.ei(this.ovO.bhV.field_type) && this.ovO.bhV.bvm()) {
                                    this.ovO.vE(2131231765);
                                }
                            }
                        });
                    }
                    jO(true);
                    pnVar = new jr();
                    pnVar.bkd.bke = true;
                    com.tencent.mm.sdk.c.a.nhr.a(pnVar, Looper.getMainLooper());
                    v.i("MicroMsg.ChattingUI", "ChattingUI req pause auto download logic");
                    if (this.oqd != null) {
                        this.oqd = new o(this, this.bhV.field_username);
                        r.c(this.oqd);
                        com.tencent.mm.modelvoice.e.a(this.oqd);
                    } else {
                        this.oqd.OH(this.bhV.field_username);
                    }
                    ak.yW();
                    z = be.a((Boolean) com.tencent.mm.model.c.vf().get(16387, null), true);
                    oVar = this.oqd;
                    if (!oVar.olw) {
                        oVar.olu = z;
                        oVar.bDQ();
                    }
                    if (this.exj != null) {
                        aX = this.exj.aX(false);
                        if (aX != null) {
                            if (aX.cBx != null) {
                                aX.cBM = aX.cBx.optInt("AudioPlayType", 0) != 1;
                            }
                            if (aX.cBM) {
                                this.oqd.olv = false;
                            }
                        }
                    }
                    this.onh.oqd = this.oqd;
                    oVar = this.oqd;
                    if (this.evz) {
                        z = true;
                    } else {
                        z = false;
                    }
                    oVar.evw = z;
                    this.oqd.bDU();
                    if (R(this.bhV)) {
                        if (this.hjH != null) {
                            ak.yW();
                            z = ((Boolean) com.tencent.mm.model.c.vf().get(66832, Boolean.valueOf(false))).booleanValue();
                            v.d("MicroMsg.ChattingUI", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(z));
                            this.hjH.bql();
                            if (z) {
                                this.hjH.bqb();
                                this.hjH.bpY();
                            }
                            if (z) {
                                this.hjH.bpM();
                            }
                            chatFooter = this.hjH;
                            if (chatFooter.lMi != null) {
                                chatFooter.lMi.bpt();
                            }
                        }
                        if (this.bhV != null) {
                            if (be.kS(this.ouo) && this.hjH != null) {
                                if (this.hjH.lMB == 1 && be.kS(this.ovl)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    bFn();
                                } else if (this.hjH != null) {
                                    chatFooter = this.hjH;
                                    chatFooter.k(1, -1, true);
                                    chatFooter.ig(true);
                                }
                                int i;
                                if (this.nQK && this.otH) {
                                    this.otH = false;
                                    String str = this.hjH.lMw.lNw;
                                    if (!be.kS(str)) {
                                        i = this.hjH.lMw.lNx;
                                        if (i > this.ouo.length()) {
                                            i = this.ouo.length();
                                        }
                                        d = this.ouo.substring(0, i) + str + ' ' + this.ouo.substring(i, this.ouo.length());
                                        i = (i + str.length()) + 1;
                                        this.hjH.HE(d);
                                        this.hjH.l(d, i, false);
                                        this.hjH.HD(null);
                                        this.nDR.aJs();
                                    }
                                } else {
                                    this.hjH.HE(this.ouo);
                                    this.hjH.HF(this.ouo);
                                    if (!be.kS(this.ouo)) {
                                        i = OU(this.onj);
                                        if (i == 2) {
                                            v.i("MicroMsg.ChattingUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), bzo());
                                            if (com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.RECORD_AUDIO", 80, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty) && be.kS(this.ovl)) {
                                                this.hjH.R(i, true);
                                            }
                                        } else if (be.kS(this.ovl)) {
                                            this.hjH.R(i, true);
                                        }
                                    }
                                }
                                bEY();
                            } else if (this.hjH != null) {
                                if (this.lMy) {
                                    this.hjH.HF(this.ouo);
                                    chatFooter = this.hjH;
                                    vN = vN(2131231912);
                                    if (chatFooter.hhK != null) {
                                        chatFooter.hhK.setHint(vN);
                                    }
                                } else if (this.hjH.lMF) {
                                    bFn();
                                } else {
                                    bEY();
                                }
                            }
                        }
                        if (this.hjH != null) {
                            this.hjH.bqd();
                            this.hjH.addTextChangedListener(new a());
                            v.i("MicroMsg.ChattingUI", "addTextChangedListener");
                        }
                    }
                    if (!this.otU || this.onc || ((this.oug != null && this.oug.oqD) || this.bhV == null || this.bhV.bvm() || m.fk(this.bhV.field_username) || com.tencent.mm.ui.snackbar.a.aQa())) {
                        v.i("MicroMsg.ChattingUI", "no call visibleFooter again.");
                    } else {
                        v.i("MicroMsg.ChattingUI", "call visibleFooter again.");
                        bEY();
                    }
                    if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
                        com.tencent.mm.pluginsdk.j.a.lxG.a(this);
                    }
                    if (com.tencent.mm.pluginsdk.j.a.lxQ != null) {
                        com.tencent.mm.pluginsdk.j.a.lxQ.a(this);
                    }
                    if (com.tencent.mm.pluginsdk.j.a.lxR != null) {
                        com.tencent.mm.pluginsdk.j.a.lxR.a(this);
                    }
                    ak.vy().a(411, (com.tencent.mm.v.e) this);
                    if (!com.tencent.mm.sdk.c.a.nhr.g(this.bZd)) {
                        com.tencent.mm.sdk.c.a.nhr.e(this.bZd);
                    }
                    if (m.fa(bEn()) && com.tencent.mm.model.ab.a.csd != null) {
                        com.tencent.mm.model.ab.a.csd.a(this.khS);
                    }
                    com.tencent.mm.plugin.bbom.l.a(this.ovi);
                    ak.yW();
                    com.tencent.mm.model.c.wJ().c(this.onh);
                    com.tencent.mm.as.k.KV().a(this.onh, ak.vA().htb.getLooper());
                    com.tencent.mm.platformtools.j.b((com.tencent.mm.platformtools.j.a) this);
                    bFT();
                }
            }
            z = false;
            if (z) {
                ak.vA().x(/* anonymous class already generated */);
            }
            bFu();
            ak.oH().db(bEn());
            MMAppMgr.oz();
            if (otP) {
                otP = false;
                a(true, true, null);
            }
            if (!com.tencent.mm.i.a.ei(this.bhV.field_type)) {
            }
            com.tencent.mm.sdk.platformtools.ad.o(/* anonymous class already generated */);
            jO(true);
            pnVar = new jr();
            pnVar.bkd.bke = true;
            com.tencent.mm.sdk.c.a.nhr.a(pnVar, Looper.getMainLooper());
            v.i("MicroMsg.ChattingUI", "ChattingUI req pause auto download logic");
            if (this.oqd != null) {
                this.oqd.OH(this.bhV.field_username);
            } else {
                this.oqd = new o(this, this.bhV.field_username);
                r.c(this.oqd);
                com.tencent.mm.modelvoice.e.a(this.oqd);
            }
            ak.yW();
            z = be.a((Boolean) com.tencent.mm.model.c.vf().get(16387, null), true);
            oVar = this.oqd;
            if (oVar.olw) {
                oVar.olu = z;
                oVar.bDQ();
            }
            if (this.exj != null) {
                aX = this.exj.aX(false);
                if (aX != null) {
                    if (aX.cBx != null) {
                        if (aX.cBx.optInt("AudioPlayType", 0) != 1) {
                        }
                        aX.cBM = aX.cBx.optInt("AudioPlayType", 0) != 1;
                    }
                    if (aX.cBM) {
                        this.oqd.olv = false;
                    }
                }
            }
            this.onh.oqd = this.oqd;
            oVar = this.oqd;
            if (this.evz) {
                z = false;
            } else {
                z = true;
            }
            oVar.evw = z;
            this.oqd.bDU();
            if (R(this.bhV)) {
                if (this.hjH != null) {
                    ak.yW();
                    z = ((Boolean) com.tencent.mm.model.c.vf().get(66832, Boolean.valueOf(false))).booleanValue();
                    v.d("MicroMsg.ChattingUI", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(z));
                    this.hjH.bql();
                    if (z) {
                        this.hjH.bqb();
                        this.hjH.bpY();
                    }
                    if (z) {
                        this.hjH.bpM();
                    }
                    chatFooter = this.hjH;
                    if (chatFooter.lMi != null) {
                        chatFooter.lMi.bpt();
                    }
                }
                if (this.bhV != null) {
                    if (be.kS(this.ouo)) {
                    }
                    if (this.hjH != null) {
                        if (this.lMy) {
                            this.hjH.HF(this.ouo);
                            chatFooter = this.hjH;
                            vN = vN(2131231912);
                            if (chatFooter.hhK != null) {
                                chatFooter.hhK.setHint(vN);
                            }
                        } else if (this.hjH.lMF) {
                            bFn();
                        } else {
                            bEY();
                        }
                    }
                }
                if (this.hjH != null) {
                    this.hjH.bqd();
                    this.hjH.addTextChangedListener(new a());
                    v.i("MicroMsg.ChattingUI", "addTextChangedListener");
                }
            }
            if (this.otU) {
            }
            v.i("MicroMsg.ChattingUI", "no call visibleFooter again.");
            if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
                com.tencent.mm.pluginsdk.j.a.lxG.a(this);
            }
            if (com.tencent.mm.pluginsdk.j.a.lxQ != null) {
                com.tencent.mm.pluginsdk.j.a.lxQ.a(this);
            }
            if (com.tencent.mm.pluginsdk.j.a.lxR != null) {
                com.tencent.mm.pluginsdk.j.a.lxR.a(this);
            }
            ak.vy().a(411, (com.tencent.mm.v.e) this);
            if (com.tencent.mm.sdk.c.a.nhr.g(this.bZd)) {
                com.tencent.mm.sdk.c.a.nhr.e(this.bZd);
            }
            com.tencent.mm.model.ab.a.csd.a(this.khS);
            com.tencent.mm.plugin.bbom.l.a(this.ovi);
            ak.yW();
            com.tencent.mm.model.c.wJ().c(this.onh);
            com.tencent.mm.as.k.KV().a(this.onh, ak.vA().htb.getLooper());
            com.tencent.mm.platformtools.j.b((com.tencent.mm.platformtools.j.a) this);
            bFT();
        }

        private void bFm() {
            int i = 0;
            if (this.ovk) {
                long currentTimeMillis = System.currentTimeMillis() - this.ovj;
                this.ovj = 0;
                this.ovk = false;
                g gVar = g.iuh;
                long[] jArr = new long[]{0, 200, 400, 600, 800, 1000, 1500, 2000};
                while (i < 8) {
                    if (currentTimeMillis < jArr[i]) {
                        break;
                    } else if (i == 7) {
                        i = 8;
                        break;
                    } else {
                        i++;
                    }
                }
                i = -1;
                gVar.a(109, (long) i, 1, true);
            }
        }

        public final void onResume() {
            boolean isShown;
            for (int i = 0; i < this.otz.size(); i++) {
                this.otz.get(i);
            }
            boolean isShown2 = this.nDR.dtW != null ? this.nDR.dtW.isShown() : false;
            if (this.mView != null) {
                isShown = this.mView.isShown();
            } else {
                isShown = false;
            }
            com.tencent.mm.model.ax.q("bizflag", this.otb);
            if (bFD()) {
                v.i("MicroMsg.ChattingUI", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b", Boolean.valueOf(isShown2), Boolean.valueOf(isShown));
                super.onResume();
                bFm();
            } else if (ak.uz()) {
                String str;
                String str2;
                v.i("MicroMsg.ChattingUI", "ashutest::onResume %d,  chatting is show %b, viewShow %b", Integer.valueOf(hashCode()), Boolean.valueOf(isShown2), Boolean.valueOf(isShown));
                long currentTimeMillis = System.currentTimeMillis();
                if (m.dE(bEn())) {
                    com.tencent.mm.storage.o LC = ak.yW().wO().LC(bEn());
                    this.otR = LC == null ? false : LC.bvh();
                    if (this.otR) {
                        i.a(bEn(), this.otS);
                    } else {
                        this.otS.clear();
                    }
                    str = "MicroMsg.ChattingUI";
                    StringBuilder stringBuilder = new StringBuilder("chatroom display  ");
                    if (this.otR) {
                        str2 = "show ";
                    } else {
                        str2 = "not show";
                    }
                    v.d(str, stringBuilder.append(str2).toString());
                } else if (m.ey(bEn())) {
                    this.otR = true;
                } else if (this.otJ) {
                    this.otR = true;
                } else {
                    this.otR = false;
                    this.otS.clear();
                }
                if (this.onh != null) {
                    com.tencent.mm.pluginsdk.ui.d.e.a(this.onh.oqc);
                }
                this.otA = 0;
                super.onResume();
                this.ots = null;
                if (!com.tencent.mm.model.k.xF().equals(bEn()) && ((this.onl && this.bhV.bCh == 0) || !com.tencent.mm.protocal.d.lWi)) {
                    this.ots = bEn();
                    this.ott = System.currentTimeMillis();
                    this.otv = 0;
                    str2 = this.ots;
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ a ovO;

                        public final void run() {
                            if (!be.kS(str2)) {
                                this.ovO.otv = com.tencent.mm.model.n.E(str2, m.crA);
                                v.i("MicroMsg.ChattingUI", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", str2, Integer.valueOf(this.ovO.otv), be.eb(this.ovO.ott), Long.valueOf(this.ovO.ott));
                            }
                        }
                    });
                }
                this.ovl = getStringExtra("smiley_product_id");
                if (this.hjH.bqk()) {
                    keepSignalling();
                }
                if (m.eG(bEn()) && this.otq != null && this.otq.orz) {
                    this.otq.bEP();
                }
                com.tencent.mm.pluginsdk.wallet.f.ux(6);
                this.nBc = true;
                this.ouK.ea(300000);
                com.tencent.mm.sdk.platformtools.ab.Ki("keep_chatting_silent" + bEn());
                bFl();
                this.onh.aRp = true;
                v.i("MicroMsg.ChattingListAdapter", "adapter resume");
                this.onh.bEE();
                isShown2 = (this.ova || this.onc || this.otX) ? false : true;
                if (isShown2) {
                    this.ova = true;
                    this.ovb = true;
                    if (this.onc || this.otX) {
                        v.i("MicroMsg.ChattingUI", "From Show Search ChatResult %b, From Gloabl Search %b", Boolean.valueOf(this.onc), Boolean.valueOf(this.otX));
                    } else {
                        this.ouX = false;
                        this.oth.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void onGlobalLayout() {
                                this.ovO.oth.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                                this.ovO.ouY.run();
                            }
                        });
                    }
                }
                if (this.onl) {
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void run() {
                            final String str = this.ovO.bhV.field_username;
                            ak.yW();
                            af Mh = com.tencent.mm.model.c.wK().Mh(str);
                            if (Mh != null) {
                                final long j = Mh.field_lastSeq;
                                final int i = Mh.field_UnDeliverCount;
                                final long j2 = Mh.field_firstUnDeliverSeq;
                                v.i("MicroMsg.ChattingUI", "summerbadcr onResume filterSeq[%d], lastSeq[%d], undeliverCount[%d], chatRoomId[%s]", Long.valueOf(j2), Long.valueOf(j), Integer.valueOf(i), str);
                                if (j > 0) {
                                    ak.yW();
                                    bx T = com.tencent.mm.model.c.wJ().T(str, j);
                                    if (T.field_msgId == 0 && T.field_msgSeq != j) {
                                        ak.yW();
                                        int MW = com.tencent.mm.model.c.wJ().MW(str);
                                        v.i("MicroMsg.ChattingUI", "summerbadcr onResume need getChatRoomMsg up msg == null[%b] svrid[%d], msgseq[%d], msgCount[%d]", Boolean.valueOf(false), Long.valueOf(T.field_msgSvrId), Long.valueOf(T.field_msgSeq), Integer.valueOf(MW));
                                        com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass91 owC;

                                            public final void run() {
                                                this.owC.ovO.hkk.jp(false);
                                                this.owC.ovO.hkk.jq(true);
                                                this.owC.ovO.hkk.jt(true);
                                                v.i("MicroMsg.ChattingUI", "summerbadcr forceBottomLoadData true needCheckHistoryTips true");
                                                this.owC.ovO.osX = false;
                                                this.owC.ovO.osY = true;
                                                com.tencent.mm.plugin.report.b.itm.a(403, 5, 1, false);
                                                com.tencent.mm.modelmulti.o.Hp().a(new com.tencent.mm.modelmulti.b.a(str, (int) j2, (int) j, i, 1), this.owC.ovO);
                                            }
                                        });
                                    }
                                }
                            }
                        }
                    });
                }
                ChatFooter chatFooter = this.hjH;
                chatFooter.lMJ = this;
                if (!chatFooter.lMF) {
                    chatFooter.findViewById(2131756068).setVisibility(0);
                }
                chatFooter.a(this.nDR.nEl, bzo());
                chatFooter.lNp = true;
                if (!(be.kS(this.ovl) || this.hjH == null)) {
                    v.d("MicroMsg.ChattingUI", "deal use smiley panel in product: %s", this.ovl);
                    chatFooter = this.hjH;
                    str = this.ovl;
                    if (!be.kS(str)) {
                        if (chatFooter.hhM == null) {
                            chatFooter.bpE();
                        }
                        chatFooter.hhM.rM(str);
                    }
                    this.hjH.bpG();
                }
                this.nDR.nEl.getIntent().putExtra("smiley_product_id", SQLiteDatabase.KeyEmpty);
                this.hjH.HH(this.bhV.field_username);
                chatFooter = this.hjH;
                str = bFR();
                String bEn = bEn();
                chatFooter.bhM = str;
                chatFooter.toUser = bEn;
                if (aL("key_show_bottom_app_panel", false).booleanValue()) {
                    chatFooter = this.hjH;
                    if (chatFooter.lMp != null) {
                        chatFooter.lMp.performClick();
                        v.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
                    }
                }
                if (bAm()) {
                    this.nFw.hVC = true;
                    this.nFw.init();
                }
                if (this.gYg) {
                    bDL();
                }
                v.v("Test", "KEVIN Chatting OnResume: diff:%d  rawUserName:%s ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), this.onj);
                bFm();
                if (com.tencent.mm.model.k.yo().booleanValue()) {
                    if (!this.bhV.bvm()) {
                        ak.yW();
                        this.ovv = be.c((Boolean) com.tencent.mm.model.c.vf().get(340228, null));
                        if (!(this.ovv || this.nGj)) {
                            f(Boolean.valueOf(true));
                        }
                        ak.yW();
                        this.ovw = be.c((Boolean) com.tencent.mm.model.c.vf().get(340229, null));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ak.yW();
                        currentTimeMillis2 -= be.a((Long) com.tencent.mm.model.c.vf().get(340240, null), 0);
                        if (this.ovv && !this.ovw && currentTimeMillis2 >= 259200000) {
                            f(Boolean.valueOf(false));
                        }
                    }
                    this.hjH.lMG = this.ovy;
                }
            } else {
                v.w("MicroMsg.ChattingUI", "account not ready, mabey not call onDestroy!!!");
                finish();
                bFm();
            }
        }

        private void bFn() {
            if (this.hjH != null) {
                boolean z = this.oty == d.oxm;
                View view = this.hjH;
                be.cw(view);
                view.ig(z);
            }
        }

        public final boolean ale() {
            if (this.hjH != null) {
                return be.cw(this.hjH);
            }
            return super.ale();
        }

        public final void onPause() {
            for (int i = 0; i < this.otz.size(); i++) {
                this.otz.get(i);
            }
            ay.dismiss();
            v.d("MicroMsg.ChattingUI", "on chatting ui pause  rawuser:%s", this.onj);
            com.tencent.mm.sdk.c.b pnVar = new pn();
            pnVar.bqP.type = 1;
            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
            if (this.onh != null) {
                com.tencent.mm.pluginsdk.ui.d.e.b(this.onh.oqc);
            }
            if (this.oti != null && this.oti.aQa()) {
                this.oti.fH(true);
            }
            if (this.jHl != null) {
                com.tencent.mm.plugin.sight.decode.ui.c cVar = this.jHl;
                cVar.iVp = true;
                cVar.dismiss();
                cVar.iVp = false;
            }
            ey(-1);
            if (this.onj == null) {
                super.onPause();
                return;
            }
            boolean isShown;
            if (this.nDR.dtW != null) {
                isShown = this.nDR.dtW.isShown();
            } else {
                isShown = false;
            }
            if (bFD() || !(this.nAV || this.nBc)) {
                v.i("MicroMsg.ChattingUI", "onPause fragment not foreground, hasPause:%b, chattingShow:%b", Boolean.valueOf(this.nBc), Boolean.valueOf(isShown));
                super.onPause();
                return;
            }
            v.i("MicroMsg.ChattingUI", "onPause %d, chattingShow:%b", Integer.valueOf(hashCode()), Boolean.valueOf(isShown));
            super.onPause();
            this.nBc = false;
            this.onh.aRp = false;
            v.i("MicroMsg.ChattingListAdapter", "adapter pause");
            if (this.hjH != null) {
                if (this.hjH.bqk()) {
                    this.oty = d.oxm;
                    v.d("MicroMsg.ChattingUI", "jacks mark refreshKeyBordState keybord state: show");
                } else {
                    this.oty = d.oxl;
                    v.d("MicroMsg.ChattingUI", "jacks mark refreshKeyBordState keybord state: hide");
                }
            }
            stopSignalling();
            if (this.oui) {
                bFC();
                if (this.oug != null) {
                    this.oug.bEL();
                }
            }
            if (m.fa(bEn()) && com.tencent.mm.model.ab.a.csd != null) {
                com.tencent.mm.model.ab.a.csd.b(this.khS);
            }
            this.ouK.QI();
            this.hjH.onPause();
            bDP();
            ak.yX().qT();
            ak.oH().db(SQLiteDatabase.KeyEmpty);
            com.tencent.mm.plugin.bbom.l.b(this.ovi);
            com.tencent.mm.modelmulti.i.a((ad) this);
            ak.yW();
            com.tencent.mm.model.c.wJ().d(this.onh);
            com.tencent.mm.as.k.KV().a(this.onh);
            com.tencent.mm.platformtools.j.c((com.tencent.mm.platformtools.j.a) this);
            ak.yW();
            com.tencent.mm.model.c.vf().set(18, Integer.valueOf(this.hjH.lMB));
            ak.yW();
            com.tencent.mm.model.c.vf().set(26, Boolean.valueOf(this.evz));
            v.d("MicroMsg.ChattingUI", "dkcm old:%d footer:%d ", Integer.valueOf(this.otN), Integer.valueOf(this.hjH.lMB));
            if (this.otN != this.hjH.lMB) {
                this.otN = this.hjH.lMB;
                ak.yW();
                com.tencent.mm.storage.ab Mh = com.tencent.mm.model.c.wK().Mh(bEn());
                if (Mh != null && bEn().equals(Mh.field_username)) {
                    Mh.dg(this.otN);
                    ak.yW();
                    com.tencent.mm.model.c.wK().a(Mh, bEn(), true);
                }
            }
            v.v("MicroMsg.ChattingUI", "record stop on pause");
            this.hjH.anf();
            com.tencent.mm.sdk.platformtools.ab.Kj("keep_app_silent");
            com.tencent.mm.sdk.platformtools.ab.Kj("keep_chatting_silent" + bEn());
            this.ouo = this.hjH.bpJ();
            if (!(com.tencent.mm.ui.k.nDV || this.oqd == null)) {
                this.oqd.bDQ();
                this.oqd.jE(false);
                this.oqd.release();
            }
            bDX();
            if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
                com.tencent.mm.pluginsdk.j.a.lxG.b(this);
            }
            if (com.tencent.mm.pluginsdk.j.a.lxQ != null) {
                com.tencent.mm.pluginsdk.j.a.lxQ.b(this);
            }
            if (com.tencent.mm.pluginsdk.j.a.lxR != null) {
                com.tencent.mm.pluginsdk.j.a.lxR.b(this);
            }
            if (com.tencent.mm.i.a.ei(this.bhV.field_type) && this.bhV.bvm() && this.exj != null) {
                com.tencent.mm.modelbiz.u.DH().Dr();
                if (this.hVo != null) {
                    this.hVo.dismiss();
                }
            }
            ale();
            ak.vy().b(411, (com.tencent.mm.v.e) this);
            com.tencent.mm.ae.n.GI().a((com.tencent.mm.ae.c.a) this);
            this.otB.QI();
            pnVar = new jr();
            pnVar.bkd.bke = false;
            com.tencent.mm.sdk.c.a.nhr.a(pnVar, Looper.getMainLooper());
            v.d("MicroMsg.ChattingUI", "chattingui cancel pause auto download logic");
            if (this.hjH != null) {
                ChatFooter chatFooter = this.hjH;
                if (chatFooter.lMR != null) {
                    chatFooter.hhK.removeTextChangedListener(chatFooter.lMR);
                    chatFooter.lMR = null;
                }
                v.i("MicroMsg.ChattingUI", "removeTextChangeListener");
            }
            com.tencent.mm.sdk.c.a.nhr.f(this.bZd);
            ef.clear();
            if (!TextUtils.isEmpty(this.ots) && ((this.onl && this.bhV.bCh == 0) || !com.tencent.mm.protocal.d.lWi)) {
                this.otu = System.currentTimeMillis();
                final String str = this.ots;
                this.ots = SQLiteDatabase.KeyEmpty;
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    public final void run() {
                        if (!be.kS(str)) {
                            int el = i.el(str);
                            ak.yW();
                            Cursor m = com.tencent.mm.model.c.wJ().m(str, this.ovO.ott, this.ovO.otu);
                            int i = 0;
                            int i2 = 0;
                            if (m == null || !m.moveToFirst()) {
                                if (m != null) {
                                    m.close();
                                }
                                v.d("MicroMsg.ChattingUI", "dkchatmsg MuteRoomKvStat:muteRoomName%s stayTime%d memberNum%d newMsg%d sendMsgNum%d unreadMsgNum%d", str, Long.valueOf(this.ovO.otu - this.ovO.ott), Integer.valueOf(el), Integer.valueOf(this.ovO.otv + i2), Integer.valueOf(i), Integer.valueOf(this.ovO.otv));
                                g.iuh.h(12077, str, Long.valueOf(this.ovO.otu - this.ovO.ott), Integer.valueOf(el), Integer.valueOf(i2 + this.ovO.otv), Integer.valueOf(i), Integer.valueOf(this.ovO.otv));
                            }
                            bx atVar = new at();
                            do {
                                atVar.b(m);
                                if (atVar.field_isSend == 1) {
                                    i++;
                                } else {
                                    i2++;
                                }
                            } while (m.moveToNext());
                            if (m != null) {
                                m.close();
                            }
                            v.d("MicroMsg.ChattingUI", "dkchatmsg MuteRoomKvStat:muteRoomName%s stayTime%d memberNum%d newMsg%d sendMsgNum%d unreadMsgNum%d", str, Long.valueOf(this.ovO.otu - this.ovO.ott), Integer.valueOf(el), Integer.valueOf(this.ovO.otv + i2), Integer.valueOf(i), Integer.valueOf(this.ovO.otv));
                            g.iuh.h(12077, str, Long.valueOf(this.ovO.otu - this.ovO.ott), Integer.valueOf(el), Integer.valueOf(i2 + this.ovO.otv), Integer.valueOf(i), Integer.valueOf(this.ovO.otv));
                        }
                    }
                });
            }
            if (!this.bhV.bvm() && com.tencent.mm.model.k.yo().booleanValue()) {
                c(Boolean.valueOf(false), Boolean.valueOf(false));
            }
        }

        public final String bFo() {
            return avS();
        }

        protected final String avS() {
            if (this.bhV == null || ((int) this.bhV.chr) == 0 || be.kS(this.bhV.field_username)) {
                return SQLiteDatabase.KeyEmpty;
            }
            v.i("MicroMsg.ChattingUI", "getIdentString %s", this.bhV.field_username);
            if (com.tencent.mm.modelbiz.e.hC(this.bhV.field_username)) {
                return "_EnterpriseChat";
            }
            if (com.tencent.mm.modelbiz.e.hB(this.bhV.field_username)) {
                return "_EnterpriseFatherBiz";
            }
            if (com.tencent.mm.modelbiz.e.hA(this.bhV.field_username)) {
                return "_EnterpriseChildBiz";
            }
            if (this.bhV.bvm()) {
                return "_bizContact";
            }
            if (m.dE(this.bhV.field_username)) {
                return "_chatroom";
            }
            if (m.ew(this.bhV.field_username)) {
                return "_bottle";
            }
            if (m.ex(this.bhV.field_username)) {
                return "_QQ";
            }
            return SQLiteDatabase.KeyEmpty;
        }

        private void bDX() {
            if (this.olt != null) {
                this.olt.dismiss();
            }
        }

        public final void aRG() {
            if (this.nDR.nEB == 1) {
                this.oth.post(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void run() {
                        this.ovO.a(true, false, null);
                    }
                });
            }
        }

        private boolean bFp() {
            if (this.oug != null && this.oug.oqD) {
                v.w("MicroMsg.ChattingUI", "match shake, in show mode, do not open short video recode view");
                return false;
            } else if (this.otU || this.onc) {
                v.w("MicroMsg.ChattingUI", "match shake, in search mode, do not open short video recode view");
                return false;
            } else if (u.LJ(this.bhV.field_username) || u.ew(this.bhV.field_username)) {
                v.w("MicroMsg.ChattingUI", "match shake, but is Qcontact or Bcontact");
                return false;
            } else if (m.fn(this.bhV.field_username)) {
                return false;
            } else {
                return true;
            }
        }

        final void bFq() {
            if (!bFp()) {
                return;
            }
            if (this.oti != null) {
                bFr();
                this.oti.show();
                return;
            }
            setRequestedOrientation(1);
            com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void run() {
                    ((ViewStub) this.ovO.findViewById(2131756059)).inflate();
                    this.ovO.oti = (ChattingSightContainerView) this.ovO.findViewById(2131756319);
                    this.ovO.oti.eSI = this.ovO.bhV.field_username;
                    ChattingSightContainerView R = this.ovO.oti;
                    R.iXJ = new com.tencent.mm.plugin.sight.encode.a.b.a(this) {
                        final /* synthetic */ AnonymousClass96 owD;

                        {
                            this.owD = r1;
                        }

                        public final void onStart() {
                        }

                        public final void aPT() {
                            v.i("MicroMsg.ChattingUI", "on sent");
                            this.owD.ovO.bFI();
                            this.owD.ovO.oti.fH(true);
                        }

                        public final void onError() {
                            v.i("MicroMsg.ChattingUI", "on error");
                            this.owD.ovO.oti.J(this.owD.ovO.oth.getHeaderViewsCount(), this.owD.ovO.oth.getFirstVisiblePosition(), this.owD.ovO.oth.getLastVisiblePosition());
                        }

                        public final void onStop() {
                            v.i("MicroMsg.ChattingUI", "on stop");
                            this.owD.ovO.oti.J(this.owD.ovO.oth.getHeaderViewsCount(), this.owD.ovO.oth.getFirstVisiblePosition(), this.owD.ovO.oth.getLastVisiblePosition());
                        }
                    };
                    if (R.iXH != null) {
                        R.iXH.a(R.iXJ);
                    }
                    this.ovO.oti.iXK = new com.tencent.mm.plugin.sight.encode.ui.ChattingSightContainerView.a(this) {
                        final /* synthetic */ AnonymousClass96 owD;
                        View owE = null;

                        {
                            this.owD = r2;
                        }

                        public final void aEU() {
                            com.tencent.mm.sdk.c.b pnVar = new pn();
                            pnVar.bqP.type = 6;
                            com.tencent.mm.sdk.c.a.nhr.z(pnVar);
                            this.owD.ovO.setRequestedOrientation(1);
                            this.owD.ovO.ale();
                            this.owD.ovO.bFs();
                            this.owD.ovO.bFI();
                            if (this.owE == null) {
                                this.owE = ((ViewStub) this.owD.ovO.findViewById(2131756052)).inflate();
                            }
                            this.owE.setVisibility(0);
                            this.owE.startAnimation(AnimationUtils.loadAnimation(this.owD.ovO.nDR.nEl, 2130968622));
                        }

                        public final void onHide() {
                            this.owD.ovO.setRequestedOrientation(-1);
                            this.owD.ovO.bFs();
                            if (this.owE != null && this.owE.getVisibility() == 0) {
                                this.owE.setVisibility(8);
                                this.owE.startAnimation(AnimationUtils.loadAnimation(this.owD.ovO.nDR.nEl, 2130968623));
                            }
                            new ac().post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 owF;

                                {
                                    this.owF = r1;
                                }

                                public final void run() {
                                    com.tencent.mm.sdk.c.b pnVar = new pn();
                                    pnVar.bqP.type = 7;
                                    pnVar.bqP.bqQ = this.owF.owD.ovO.oth.getFirstVisiblePosition();
                                    pnVar.bqP.bqR = this.owF.owD.ovO.oth.getLastVisiblePosition();
                                    pnVar.bqP.bqS = this.owF.owD.ovO.oth.getHeaderViewsCount();
                                    com.tencent.mm.sdk.c.a.nhr.z(pnVar);
                                }
                            });
                        }
                    };
                    this.ovO.bFr();
                    this.ovO.oti.show();
                }
            });
        }

        private void bFr() {
            int Ec = com.tencent.mm.modelcontrol.b.Ec();
            if (this.oti != null) {
                ChattingSightContainerView chattingSightContainerView = this.oti;
                if (chattingSightContainerView.iXG != null) {
                    chattingSightContainerView.iXG.pM(Ec);
                }
            }
        }

        public final void bFs() {
            v.i("MicroMsg.ChattingUI", "triggerFooter");
            if (this.hjH == null) {
                this.hjH = (ChatFooter) findViewById(2131756055);
            }
            if ((this.oug == null || !this.oug.oqD) && ((this.oti == null || !this.oti.aQa()) && !com.tencent.mm.ui.snackbar.a.aQa())) {
                this.ovp = false;
                if (this.ovn == 8 && this.ovo == 8) {
                    bEZ();
                    return;
                } else if (this.ovn == 0) {
                    bEY();
                    return;
                } else {
                    bEX();
                    return;
                }
            }
            if (!this.ovp) {
                this.ovn = this.hjH.getVisibility();
            }
            this.hjH.k(0, -1, false);
            if (this.ote == null) {
                this.ovo = -1;
            } else if (!this.ovp) {
                this.ovo = this.ote.getVisibility();
            }
            bEZ();
            this.ovp = true;
        }

        public final void bFt() {
            if (this.oug != null) {
                if (this.oug.oqD) {
                    iU(false);
                } else {
                    bDN();
                }
            }
            bFl();
        }

        protected void bDN() {
            if (this.otU || this.onc) {
                iU(false);
                return;
            }
            if (m.ez(bEn())) {
                a(0, 2131230801, 2131165208, this.ovq);
            } else if (m.eG(bEn())) {
                a(0, 2131230801, 2131165208, this.ovq);
                g.iuh.Y(10071, "1");
            } else if (m.eH(bEn())) {
                a(0, 2131230801, 2131165208, this.ovq);
            } else if (m.fi(bEn())) {
                a(0, 2131230801, 2131165208, this.ovq);
            } else if (m.fn(bEn())) {
                a(0, 2131230801, 2131165208, this.ovq);
            } else if (u.LH(bEn()) || u.LJ(bEn()) || u.ew(bEn())) {
                a(0, 2131231869, 2131165203, this.ovq);
            } else if (this.otb && OS(bEn())) {
                a(0, 2131231869, 2131165772, this.ovq);
            } else if (!bEn().endsWith("@chatroom") && !m.ey(bEn()) && !this.lKa) {
                if (!(!(1 == be.getInt(com.tencent.mm.h.j.sU().getValue("VOIPShowInChat"), 0)) || m.eD(bEn()) || bEn().endsWith("@chatroom") || u.LH(bEn()) || u.LJ(bEn()) || u.ew(bEn()))) {
                    if (1 == be.getInt(com.tencent.mm.h.j.sU().getValue("VOIPCallType"), 0)) {
                        a(2, 2131231914, 2131165210, this.ovt);
                    } else {
                        a(1, 2131231915, 2131165211, this.ovt);
                    }
                }
                a(0, 2131231869, 2131165203, this.ovq);
            } else if (this.nGj) {
                v.i("MicroMsg.ChattingUI", "cpan show chatroom right btn");
                a(0, 2131231869, 2131165194, this.ovq);
                iU(true);
            } else if (!this.lKa || this.otJ) {
                iU(false);
                return;
            } else {
                a(0, 2131231869, 2131165203, this.ovq);
                iU(true);
            }
            if (u.ew(bEn())) {
                iY(true);
            } else {
                iU(true);
            }
        }

        private void bFu() {
            if (this.nQK) {
                String str;
                com.tencent.mm.storage.o LC = ak.yW().wO().LC(bEn());
                if (LC != null && LC.DM().size() == 2) {
                    int size = LC.DM().size();
                    for (int i = 0; i < size; i++) {
                        str = (String) LC.DM().get(i);
                        if (OS(str)) {
                            break;
                        }
                    }
                }
                str = null;
                this.ovc = str;
                if (be.kS(this.ovc) || !this.nGj) {
                    bFy();
                } else {
                    bFw();
                }
            } else if (OS(bEn()) && !this.otb) {
                this.ovc = bEn();
                bFw();
            } else if (this.lMy) {
                com.tencent.mm.ar.h kL = com.tencent.mm.ar.l.KE().kL(this.bhj);
                if (!(this.enX == null && kL == null)) {
                    bFw();
                }
            } else {
                bFy();
                bFx();
            }
            bFz();
        }

        private static boolean OS(String str) {
            int i = -1;
            if (m.eC(str) || !m.ev(str) || com.tencent.mm.model.k.eo(str)) {
                return false;
            }
            int i2;
            ak.yW();
            com.tencent.mm.e.b.ab LX = com.tencent.mm.model.c.wH().LX(str);
            if (LX != null) {
                i2 = LX.field_type;
                ak.yW();
                LX = com.tencent.mm.model.c.wH().LX(LX.field_encryptUsername);
                if (LX != null) {
                    i = LX.field_type;
                }
            } else {
                i2 = -1;
            }
            v.i("MicroMsg.ChattingUI", "isStranger:%s type:%d etype:%d", str, Integer.valueOf(i2), Integer.valueOf(i));
            return true;
        }

        private int bFv() {
            if (this.otE == null || !this.otE.isShown()) {
                return 0;
            }
            return this.otE.getHeight() + 0;
        }

        protected void bDO() {
            this.oth = (ListView) findViewById(2131756043);
            this.oth.setVisibility(0);
            this.xe = 0;
            this.hkk = (MMPullDownView) findViewById(2131756042);
            this.hkk.nXo = false;
            this.hkk.js(false);
            this.hkk.nWT = new MMPullDownView.g(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final boolean azp() {
                    v.d("MicroMsg.ChattingUI", "summerbadcr onTopLoadData isChatroomChat[%b], talker[%s]", Boolean.valueOf(this.ovO.onl), this.ovO.bhV.field_username);
                    if (this.ovO.onc || this.ovO.otY || this.ovO.otX) {
                        this.ovO.onh.oqA = true;
                    }
                    if (this.ovO.onl) {
                        final at atVar = (at) this.ovO.onh.getItem(0);
                        if (atVar == null || atVar.field_msgId == 0) {
                            v.d("MicroMsg.ChattingUI", "summerbadcr onTopLoadData firstMsgInfo is null");
                        } else {
                            v.i("MicroMsg.ChattingUI", "summerbadcr onTopLoadData check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(atVar.field_flag), Integer.valueOf(atVar.field_isSend), Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), Long.valueOf(atVar.field_msgSeq), Long.valueOf(atVar.field_createTime), Integer.valueOf(atVar.field_type), atVar.field_talker);
                            if (!((atVar.field_flag & 1) == 0 || (atVar.field_flag & 4) == 0)) {
                                v.i("MicroMsg.ChattingUI", "summerbadcr onTopLoadData check fault found");
                                this.ovO.onh.jI(true);
                                ak.vA().x(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass116 owP;

                                    public final void run() {
                                        com.tencent.mm.plugin.report.b.itm.a(403, 6, 1, false);
                                        this.owP.ovO.am(atVar);
                                    }
                                });
                                return false;
                            }
                        }
                    }
                    if (this.ovO.onh.bEF()) {
                        v.i("MicroMsg.ChattingUI", "pullDownView showTopAll on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(1), Integer.valueOf(this.ovO.hkk.nWV));
                        c.a(this.ovO.oth, 1, this.ovO.hkk.nWV, false);
                        this.ovO.hkk.jo(true);
                        return true;
                    }
                    int count = this.ovO.onh.getCount();
                    this.ovO.onh.xb(18);
                    this.ovO.onh.a(null, null);
                    int count2 = this.ovO.onh.getCount();
                    v.d("MicroMsg.ChattingUI", "onTopLoadData talker[%s], nowCount:%d, preCount:%d", this.ovO.bhV.field_username, Integer.valueOf(count2), Integer.valueOf(count));
                    if (count2 > count) {
                        count = count2 - count;
                        this.ovO.onh.xc(count);
                        v.i("MicroMsg.ChattingUI", "pullDownView nowCount > preCount on set position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(count + 1), Integer.valueOf(this.ovO.bFv() + this.ovO.hkk.nWV));
                        c.a(this.ovO.oth, count + 1, this.ovO.bFv() + this.ovO.hkk.nWV, false);
                    }
                    return true;
                }
            };
            this.hkk.nWU = new com.tencent.mm.ui.base.MMPullDownView.e(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final boolean agi() {
                    v.i("MicroMsg.ChattingUI", "summerbadcr onBottomLoadData isChatroomChat[%b], needCheckHistoryTips[%b]", Boolean.valueOf(this.ovO.onl), Boolean.valueOf(this.ovO.osY));
                    if (this.ovO.onc || this.ovO.otY) {
                        this.ovO.onh.oqB = true;
                    }
                    if (this.ovO.onl && this.ovO.osY) {
                        return false;
                    }
                    if (this.ovO.onh.bEG()) {
                        v.i("MicroMsg.ChattingUI", "pullDownView showButtomAll on set position %d", Integer.valueOf(this.ovO.onh.getCount() - 1));
                        this.ovO.oth.setSelection(this.ovO.onh.getCount() - 1);
                        this.ovO.hkk.jp(true);
                        return true;
                    }
                    int count = this.ovO.onh.getCount();
                    this.ovO.onh.a(null);
                    if (this.ovO.onh.getCount() > count) {
                        v.i("MicroMsg.ChattingUI", "pullDownView height: " + this.ovO.hkk.getHeight() + ", chatHistoryList height: " + this.ovO.oth.getHeight() + " header height: " + this.ovO.otE.getHeight() + " topHeight: " + this.ovO.hkk.nWV);
                        c.a(this.ovO.oth, count + 1, (this.ovO.oth.getHeight() - this.ovO.bFv()) - this.ovO.hkk.nWV, false);
                    }
                    return true;
                }
            };
            this.hkk.jr(true);
            this.hkk.nXf = new com.tencent.mm.ui.base.MMPullDownView.c(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final boolean agv() {
                    View childAt = this.ovO.oth.getChildAt(this.ovO.oth.getChildCount() - 1);
                    if (childAt == null) {
                        return true;
                    }
                    if (childAt.getBottom() > this.ovO.oth.getHeight() || this.ovO.oth.getLastVisiblePosition() != this.ovO.oth.getAdapter().getCount() - 1) {
                        return false;
                    }
                    return true;
                }
            };
            this.hkk.nXg = new com.tencent.mm.ui.base.MMPullDownView.d(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final boolean agu() {
                    View childAt = this.ovO.oth.getChildAt(this.ovO.oth.getFirstVisiblePosition());
                    return childAt != null && childAt.getTop() == 0;
                }
            };
            this.hkk.nXz = new com.tencent.mm.ui.base.MMPullDownView.b(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void aks() {
                }
            };
            this.hkk.nXp.oSY = new com.tencent.mm.ui.tools.k.a(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void bGk() {
                    v.v("MicroMsg.ChattingUI", "on fling up");
                }

                public final void bGl() {
                    v.v("MicroMsg.ChattingUI", "on fling right");
                }

                public final void bGm() {
                    v.v("MicroMsg.ChattingUI", "on fling left");
                }

                public final void bGn() {
                    v.v("MicroMsg.ChattingUI", "on fling down");
                }
            };
            this.hkk.jp(true);
            this.hkk.jq(this.onc);
            this.oth.setOnScrollListener(new OnScrollListener(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void onScrollStateChanged(AbsListView absListView, int i) {
                    v.d("MicroMsg.ChattingUI", "onScrollStateChanged mScrollState=%d, scrollState=%d", Integer.valueOf(this.ovO.xe), Integer.valueOf(i));
                    this.ovO.xe = i;
                    cp cpVar = this.ovO.onh;
                    this.ovO.xl(i);
                    com.tencent.mm.ae.n.GL().ba(i);
                }

                public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
                    if (this.ovO.ovb) {
                        if (this.ovO.oth.getLastVisiblePosition() == i3 - 1) {
                            this.ovO.ovb = false;
                        }
                    }
                    if (this.ovO.osX && i3 - i == (this.ovO.osZ << 1)) {
                        this.ovO.osX = false;
                        v.i("MicroMsg.ChattingUI", "summerbadcr set dealHistoryGetMsg %b firstVisibleItem: %d, totalItemCount:%d mUnreadMessageBeforeCheckHistory:%d", Boolean.valueOf(this.ovO.osX), Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(this.ovO.osZ));
                    }
                    if (this.ovO.osU > 0 && i3 - (i + 1) >= this.ovO.osU && this.ovO.osV != null && this.ovO.osV.getVisibility() == 0) {
                        v.i("MicroMsg.ChattingUI", "summerbadcr jacks onScroll dismissGoBackToHistory mUnreadMessage[%d] [%d,%d]", Integer.valueOf(this.ovO.osU), Integer.valueOf(i3), Integer.valueOf(i));
                        this.ovO.bFK();
                    }
                }
            });
            if (this.onh == null) {
                this.onh = new cp(this, new at(), bEn(), bFR(), this.oqd, this.ima);
                if (this.lMy) {
                    this.onh.oqF = true;
                }
            } else {
                this.onh.a(bEn(), this.oqd, bFR());
            }
            this.onh.iQ(true);
            this.onh.fnw = this.handler;
            if (this.onc || this.otX) {
                final long NW = NW("msg_local_id");
                final int k = this.onh.k(NW, this.otX);
                this.oth.postDelayed(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    public final void run() {
                        c.a(this.ovO.oth, k, false);
                        com.tencent.mm.ui.h hVar = this.ovO;
                        (hVar.bzo() != null ? hVar.bzo().getWindow() : null).getDecorView().post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass98 owH;

                            {
                                this.owH = r1;
                            }

                            public final void run() {
                                c.a(this.owH.ovO.oth, k, false);
                                if (this.owH.ovO.otV && !this.owH.ovO.otX) {
                                    new ac().postDelayed(new Runnable(this.owH.ovO, k, NW) {
                                        final /* synthetic */ a ovO;

                                        public final void run() {
                                            int firstVisiblePosition = r5 - this.ovO.oth.getFirstVisiblePosition();
                                            View childAt = this.ovO.oth.getChildAt(firstVisiblePosition);
                                            View childAt2 = this.ovO.oth.getChildAt(firstVisiblePosition + this.ovO.oth.getHeaderViewsCount());
                                            ak.yW();
                                            at ek = com.tencent.mm.model.c.wJ().ek(r6);
                                            View view = null;
                                            if (childAt != null) {
                                                if (ek.bwj() || ek.bwn()) {
                                                    view = childAt.findViewById(2131756186);
                                                } else if (ek.bwo()) {
                                                    view = childAt.findViewById(android.support.v7.a.a.f.Jm);
                                                } else if (ek.bwr()) {
                                                    view = childAt.findViewById(2131756168);
                                                }
                                                if (view == null && childAt2 != null) {
                                                    if (ek.bwj() || ek.bwn()) {
                                                        view = childAt2.findViewById(2131756186);
                                                    } else if (ek.bwo()) {
                                                        view = childAt2.findViewById(android.support.v7.a.a.f.Jm);
                                                    }
                                                }
                                                if (view != null) {
                                                    com.tencent.mm.ui.g.a.b(this.ovO.nDR.nEl, view);
                                                }
                                            }
                                        }
                                    }, 200);
                                    ak.yW();
                                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_POSITION_AT_CHATRECORD_FIRST_IN_BOOLEAN, Boolean.valueOf(false));
                                }
                            }
                        });
                    }
                }, 100);
            }
            this.onh.nDK = new com.tencent.mm.ui.j.a(this) {
                private int count = 0;
                final /* synthetic */ a ovO;

                {
                    this.ovO = r2;
                }

                public final void Oi() {
                    boolean z = false;
                    if (this.ovO.bFD()) {
                        v.i("MicroMsg.ChattingUI", "onPostRset fragment not foreground, return");
                        return;
                    }
                    v.i("MicroMsg.ChattingUI", "onPostReset");
                    this.ovO.otB.QI();
                    if (this.ovO.gYg) {
                        this.ovO.otB.ea(2000);
                    } else {
                        this.ovO.otB.ea(1000);
                    }
                    this.ovO.oth.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass99 owI;

                        {
                            this.owI = r1;
                        }

                        public final void run() {
                            com.tencent.mm.plugin.report.service.f.oS(13);
                        }
                    });
                    this.ovO.hkk.jo(this.ovO.onh.bEF());
                    this.ovO.hkk.jp(this.ovO.onh.bEG());
                    if (this.ovO.onh.emv - this.count > 0 && !this.ovO.onc) {
                        v.v("MicroMsg.ChattingUI", "ncnt > 0 && (!isShowSearchChatResult) scroll to last");
                        this.ovO.a(false, false, null);
                    }
                    if (!this.ovO.otX && this.ovO.otY && !this.ovO.oug.oqD && this.ovO.onh.bED()) {
                        v.v("MicroMsg.ChattingUI", "useEditSearchMode && !chattingMoreHelper.inShowMode() && adapter.triggerMoveToLast()");
                        this.ovO.a(false, false, null);
                    }
                    if (this.ovO.nDR.nEB == 1) {
                        v.v("MicroMsg.ChattingUI", "kbshown scroll to last");
                        this.ovO.a(true, false, null);
                    }
                    a aVar = this.ovO;
                    if (!aVar.bFD()) {
                        z = aVar.nBc;
                    }
                    if (z) {
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ AnonymousClass99 owI;

                            {
                                this.owI = r1;
                            }

                            public final void run() {
                                long currentTimeMillis = System.currentTimeMillis();
                                this.owI.ovO.bDP();
                                v.i("MicroMsg.ChattingUI", "ChattingUI writeOpLogAndMarkRead last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            }
                        });
                    }
                }

                public final void Oj() {
                    if (this.ovO.bFD()) {
                        v.i("MicroMsg.ChattingUI", "onPreReset fragment not foreground, return");
                        return;
                    }
                    com.tencent.mm.plugin.report.service.f.oR(13);
                    this.count = this.ovO.onh.emv;
                }
            };
            if (this.oth.getHeaderViewsCount() > 0) {
                this.otE = (LinearLayout) this.oth.findViewById(2131756282);
            } else {
                this.otE = (LinearLayout) bzo().getLayoutInflater().inflate(2130903364, null);
                this.oth.addHeaderView(this.otE);
            }
            this.otE.removeAllViews();
            bFu();
            ak.yW();
            com.tencent.mm.storage.ab Mh = com.tencent.mm.model.c.wK().Mh(this.bhV.field_username);
            if (Mh == null || Mh.field_UnDeliverCount == 0) {
                a(Mh, false);
            } else if (this.osV != null) {
                this.osV.setVisibility(8);
                v.i("MicroMsg.ChattingUI", "summerbadcr not updateGoBacktoHistroyMessage initList UnDeliver:%d, UnRead:%d", Integer.valueOf(Mh.field_UnDeliverCount), Integer.valueOf(Mh.field_unReadCount));
            }
            if (this.oth.getAdapter() == null) {
                this.oth.setAdapter(this.onh);
                v.i("MicroMsg.INIT", "chatHistoryList.setAdapter");
            }
            if (this.onc) {
                this.oth.setTranscriptMode(0);
            } else {
                this.oth.setTranscriptMode(1);
            }
            this.oth.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    this.ovO.ouX = true;
                    if (this.ovO.otQ) {
                        this.ovO.hjH.k(0, -1, false);
                    }
                    return false;
                }
            });
            this.oth.setOnCreateContextMenuListener(this);
        }

        public final void jL(boolean z) {
            if (this.onh != null) {
                this.onh.jI(z);
            }
        }

        private void bFw() {
            bFy();
            if (this.otF == null) {
                xi(2131756039);
                this.otF = (LinearLayout) findViewById(2131756067);
            }
            this.otF.setVisibility(0);
            final LinearLayout linearLayout = (LinearLayout) bzo().getLayoutInflater().inflate(2130903363, null);
            ImageView imageView = (ImageView) linearLayout.findViewById(2131756279);
            String str = this.ovc;
            if (be.kS(str)) {
                str = this.bhV.field_username;
            }
            Bitmap a = com.tencent.mm.u.b.a(str, false, -1);
            if (a == null) {
                imageView.setImageResource(2131165440);
            } else {
                imageView.setImageBitmap(a);
            }
            Button button = (Button) linearLayout.findViewById(2131756281);
            if (this.lMy) {
                if (this.enX == null) {
                    com.tencent.mm.ar.h kL = com.tencent.mm.ar.l.KE().kL(this.bhj);
                    if (kL != null) {
                        ((TextView) linearLayout.findViewById(2131756280)).setText(kL.field_sayhicontent);
                        ((Button) linearLayout.findViewById(2131756281)).setText(2131231819);
                    } else {
                        this.otF.setVisibility(8);
                    }
                } else if (this.otx) {
                    ((TextView) linearLayout.findViewById(2131756280)).setText(2131231821);
                    button.setVisibility(8);
                } else {
                    ((TextView) linearLayout.findViewById(2131756280)).setText(2131231822);
                    ((Button) linearLayout.findViewById(2131756281)).setText(2131231820);
                }
            }
            imageView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void onClick(View view) {
                    a.U(this.ovO);
                }
            });
            button.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ a ovO;

                public final void onClick(View view) {
                    if (this.ovO.lMy) {
                        if (this.ovO.enX != null) {
                            String format = String.format(this.ovO.vN(2131231369), new Object[]{be.ma(com.tencent.mm.model.k.xH())});
                            ak.vy().a(new com.tencent.mm.pluginsdk.model.m(2, Arrays.asList(new String[]{this.ovO.bhj}), Arrays.asList(new Integer[]{Integer.valueOf(18)}), format, SQLiteDatabase.KeyEmpty), 0);
                            this.ovO.otx = true;
                        } else {
                            com.tencent.mm.sdk.h.c kL = com.tencent.mm.ar.l.KE().kL(this.ovO.bhj);
                            ak.vy().a(new com.tencent.mm.pluginsdk.model.m(this.ovO.bhj, kL.field_ticket, this.ovO.iRy), 0);
                            kL.field_flag = 2;
                            com.tencent.mm.ar.l.KE().a(kL, new String[0]);
                        }
                        this.ovO.bFw();
                        return;
                    }
                    if (((int) this.ovO.bhV.chr) == 0) {
                        ak.yW();
                        if (com.tencent.mm.model.c.wH().O(this.ovO.bhV) != -1) {
                            a aVar = this.ovO;
                            ak.yW();
                            aVar.bhV = com.tencent.mm.model.c.wH().LX(this.ovO.ovc);
                        }
                    }
                    com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(this.ovO.nDR.nEl, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                        final /* synthetic */ AnonymousClass102 owK;

                        {
                            this.owK = r1;
                        }

                        public final void a(boolean z, boolean z2, String str, String str2) {
                            if (z) {
                                m.n(this.owK.ovO.bhV);
                                linearLayout.setVisibility(8);
                            }
                        }
                    });
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(3));
                    aVar2.c(this.ovO.ovc, linkedList);
                    g.iuh.h(11004, this.ovO.ovc, Integer.valueOf(3));
                }
            });
            g.iuh.h(11004, this.ovc, Integer.valueOf(1));
            this.otF.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        }

        private void bFx() {
            if (!this.nQK && this.otE != null) {
                bFy();
                com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQv, new Object[]{bEn(), bFU()});
                if (!(a == null || a.getView() == null)) {
                    this.otE.addView(a.getView(), new ViewGroup.LayoutParams(-1, -2));
                    this.otE.setVisibility(0);
                }
                g.iuh.h(11003, bEn(), Integer.valueOf(1), Integer.valueOf(0));
            }
        }

        private void bFy() {
            if (this.otE != null) {
                this.otE.removeAllViews();
            }
            if (this.otF != null) {
                this.otF.setVisibility(8);
                this.otF.removeAllViews();
            }
        }

        private void bFz() {
            if (aG() == null) {
                v.w("MicroMsg.ChattingUI", "getActivity is null");
                return;
            }
            bFA();
            ViewGroup viewGroup = (ViewGroup) findViewById(2131756040);
            com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQw, new Object[]{bEn(), bFU(), Boolean.valueOf(this.nQK)});
            if (viewGroup != null && a != null && a.getView() != null && this.ovu == null) {
                this.ovu = a.getView();
                viewGroup.addView(this.ovu, new ViewGroup.LayoutParams(-1, -2));
            }
        }

        private void bFA() {
            ViewGroup viewGroup = (ViewGroup) findViewById(2131756040);
            if (viewGroup != null && this.ovu != null) {
                viewGroup.removeView(this.ovu);
                this.ovu = null;
            }
        }

        private void f(final Boolean bool) {
            ViewGroup.LayoutParams layoutParams;
            this.ove = (ViewGroup) findViewById(2131756040);
            this.ovd = View.inflate(this.nDR.nEl, 2130904129, null);
            TextView textView = (TextView) this.ovd.findViewById(2131758456);
            if (bool.booleanValue()) {
                textView.setText(this.nDR.nEl.getString(2131234913));
                this.ovd.setBackgroundResource(2130838814);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, 85);
            } else {
                textView.setText(this.nDR.nEl.getString(2131234917));
                this.ovd.setBackgroundResource(2130838813);
                layoutParams = new FrameLayout.LayoutParams(-2, -2, 83);
            }
            if (this.ove != null && this.ovd != null) {
                this.ove.addView(this.ovd, layoutParams);
                this.ovd.startAnimation(AnimationUtils.loadAnimation(this.nDR.nEl, 2130968668));
                this.ovd.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    public final void onClick(View view) {
                        if (bool.booleanValue()) {
                            this.ovO.c(Boolean.valueOf(true), Boolean.valueOf(true));
                            this.ovO.hjH.bpD();
                            return;
                        }
                        this.ovO.c(Boolean.valueOf(true), Boolean.valueOf(false));
                        this.ovO.hjH.R(2, true);
                    }
                });
            }
        }

        private void c(Boolean bool, Boolean bool2) {
            if (this.ovd != null) {
                this.ovd.clearAnimation();
                this.ovd.setVisibility(8);
                if (bool2.booleanValue()) {
                    if (bool.booleanValue()) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(340228, Boolean.valueOf(true));
                        g.iuh.a(232, 1, 1, false);
                    }
                } else if (bool.booleanValue()) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(340229, Boolean.valueOf(true));
                    g.iuh.a(232, 2, 1, false);
                }
            }
        }

        public final void bFB() {
            String str = "MicroMsg.ChattingUI";
            String str2 = "enter edit search mode, search stub view is null?%B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.otT == null);
            v.v(str, str2, objArr);
            this.oui = true;
            this.oth.setVisibility(8);
            if (this.otT != null) {
                this.otT.setVisibility(0);
            } else {
                xi(2131756050);
                this.otT = findViewById(2131756051);
                this.otT.setVisibility(0);
                this.oub = findViewById(2131758999);
                this.oth.setFocusable(false);
                this.oth.setFocusableInTouchMode(false);
                this.oub.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onClick(View view) {
                    }
                });
                this.oub.setVisibility(8);
                this.otZ = (TextView) findViewById(2131756317);
                this.orj = new cv(this.nDR.nEl, new at(), bEn(), bFR(), this.nQK);
                this.orj.orP = new com.tencent.mm.ui.chatting.cv.a(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void xe(int i) {
                        this.ovO.xk(i);
                    }
                };
                this.oua = (ListView) findViewById(2131758998);
                this.oua.setVisibility(0);
                this.oua.setAdapter(this.orj);
                this.oua.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                        at atVar = (at) this.ovO.orj.getItem(i);
                        if (atVar != null && !be.kS(atVar.field_talker)) {
                            this.ovO.bFC();
                            if (this.ovO.oug != null) {
                                ct Y = this.ovO.oug;
                                if (atVar == null) {
                                    v.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
                                } else if (Y.omZ.ew(atVar.field_msgId)) {
                                    Y.ori.xa(Y.omZ.oqG.size());
                                    Y.ori.setVisibility(0);
                                    Y.eSv.bJs();
                                }
                            }
                            if (!this.ovO.otY) {
                                this.ovO.otY = true;
                                this.ovO.hkk.jq(true);
                                this.ovO.oth.setTranscriptMode(0);
                            }
                            this.ovO.hkk.jo(false);
                            this.ovO.hkk.jp(false);
                            final int k = this.ovO.onh.k(atVar.field_msgId, false);
                            this.ovO.onh.a(null, null);
                            this.ovO.oth.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass113 owO;

                                public final void run() {
                                    v.i("MicroMsg.ChattingUI", "on search click, click position %d, set selection %d", Integer.valueOf(i), Integer.valueOf(k));
                                    c.a(this.owO.ovO.oth, k, false);
                                }
                            });
                        }
                    }
                });
                this.oua.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        this.ovO.ale();
                        return false;
                    }
                });
                if (this.oug != null) {
                    this.oug.orj = this.orj;
                }
            }
            xk(-1);
        }

        public final void bFC() {
            v.v("MicroMsg.ChattingUI", "exit edit search mode");
            this.oui = false;
            this.ouj = true;
            if (this.otZ != null) {
                this.otZ.setVisibility(8);
            }
            if (this.oub != null) {
                this.oub.setVisibility(8);
            }
            if (this.oua != null) {
                this.oua.setVisibility(8);
            }
            this.oth.setVisibility(0);
            ale();
        }

        public final void xk(int i) {
            v.v("MicroMsg.ChattingUI", "search result count %d, in edit mode %B, can report %B", Integer.valueOf(i), Boolean.valueOf(this.oui), Boolean.valueOf(this.ouj));
            if (this.otU || this.oui) {
                if (this.ouj && i >= 0) {
                    this.ouj = false;
                    g.iuh.h(10811, Integer.valueOf(2));
                }
                if (i > 0) {
                    this.oua.setVisibility(0);
                    this.oth.setVisibility(8);
                    this.otZ.setVisibility(8);
                    this.oub.setVisibility(8);
                    return;
                } else if (i == 0) {
                    this.oua.setVisibility(8);
                    this.oth.setVisibility(8);
                    this.otZ.setVisibility(0);
                    this.oub.setVisibility(8);
                    return;
                } else {
                    this.oua.setVisibility(8);
                    this.oth.setVisibility(0);
                    this.otZ.setVisibility(8);
                    this.oub.setVisibility(0);
                    return;
                }
            }
            v.d("MicroMsg.ChattingUI", "not search now");
        }

        final void am(at atVar) {
            long j = 0;
            if (atVar != null && atVar.field_msgId != 0) {
                int i;
                long j2 = atVar.field_msgSeq;
                boolean z = (atVar.field_flag & 4) != 0;
                int i2 = 18;
                ak.yW();
                af Mh = com.tencent.mm.model.c.wK().Mh(this.bhV.field_username);
                if (Mh != null) {
                    long j3 = z ? Mh.field_firstUnDeliverSeq : Mh.field_lastSeq;
                    if (z && j3 == 0) {
                        i2 = Mh.field_UnDeliverCount;
                        j = j3;
                    } else {
                        j = j3;
                    }
                }
                v.i("MicroMsg.ChattingUI", "summerbadcr getChatroomMsgWithFaultMsg filterSeq[%d], lastSeq[%d], needCount[%d], flag[%d], up[%b]", Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(atVar.field_flag), Boolean.valueOf(z));
                this.osX = false;
                String str = this.bhV.field_username;
                int i3 = (int) j;
                int i4 = (int) j2;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                com.tencent.mm.modelmulti.o.Hp().a(new com.tencent.mm.modelmulti.b.a(str, i3, i4, i2, i), (com.tencent.mm.modelmulti.b.c) this);
            }
        }

        protected final void xl(int i) {
            if (i == 0) {
                View childAt = this.oth.getChildAt(this.oth.getFirstVisiblePosition());
                at atVar;
                if (childAt != null && childAt.getTop() == 0) {
                    v.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange forceTopLoadData true");
                    if (this.onl) {
                        atVar = (at) this.onh.getItem(0);
                        if (!(atVar == null || atVar.field_msgId == 0)) {
                            v.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(atVar.field_flag), Integer.valueOf(atVar.field_isSend), Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), Long.valueOf(atVar.field_msgSeq), Long.valueOf(atVar.field_createTime), Integer.valueOf(atVar.field_type), atVar.field_talker);
                            if (!((atVar.field_flag & 1) == 0 || (atVar.field_flag & 4) == 0)) {
                                this.hkk.jo(false);
                            }
                        }
                    }
                    this.hkk.js(true);
                } else if (this.onl && this.oth.getChildAt(this.oth.getChildCount() - 1) != null && this.oth.getLastVisiblePosition() == this.oth.getAdapter().getCount() - 1) {
                    atVar = (at) this.onh.getItem(this.onh.getCount() - 1);
                    if (!(atVar == null || atVar.field_msgId == 0)) {
                        v.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange bottom check fault[%d, %d, %d, %d, %d, %d, %d, %s]", Integer.valueOf(atVar.field_flag), Integer.valueOf(atVar.field_isSend), Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId), Long.valueOf(atVar.field_msgSeq), Long.valueOf(atVar.field_createTime), Integer.valueOf(atVar.field_type), atVar.field_talker);
                        if ((atVar.field_flag & 1) != 0 && (atVar.field_flag & 4) == 0) {
                            v.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange forceBottomLoadData not");
                            v.i("MicroMsg.ChattingUI", "summerbadcr handleScrollChange bottom check fault found");
                            this.onh.jI(true);
                            ak.vA().x(new Runnable(this) {
                                final /* synthetic */ a ovO;

                                public final void run() {
                                    com.tencent.mm.plugin.report.b.itm.a(403, 7, 1, false);
                                    this.ovO.am(atVar);
                                }
                            });
                            return;
                        }
                    }
                }
                this.otB.QI();
                this.otB.ea(1000);
                if (this.jHl == null || !this.jHl.isShowing()) {
                    com.tencent.mm.sdk.c.b pnVar = new pn();
                    pnVar.bqP.type = 5;
                    pnVar.bqP.bqQ = this.oth.getFirstVisiblePosition();
                    pnVar.bqP.bqR = this.oth.getLastVisiblePosition();
                    pnVar.bqP.bqS = this.oth.getHeaderViewsCount();
                    com.tencent.mm.sdk.c.a.nhr.z(pnVar);
                } else {
                    return;
                }
            }
            if (i == 2) {
                com.tencent.mm.bh.c.byp().bX(ChattingUI.class.getName() + ".Listview", 4);
                this.otB.QI();
                com.tencent.mm.ae.n.GI().a((com.tencent.mm.ae.c.a) this);
            }
        }

        private boolean R(u uVar) {
            if (this.otU || this.onc || (this.oug != null && this.oug.oqD)) {
                bEZ();
                return false;
            }
            if (!(uVar == null || !uVar.bvm() || this.exj == null)) {
                ExtInfo aX = this.exj.aX(false);
                if (aX != null) {
                    if (aX.cBx != null) {
                        aX.cBz = "1".equals(aX.cBx.optString("IsHideInputToolbarInMsg"));
                    }
                    if (aX.cBz) {
                        v.i("MicroMsg.ChattingUI", "bizinfo name=" + uVar.field_username + " is hide tool bar");
                        bEZ();
                        return false;
                    }
                }
                if (!(be.kS(uVar.field_username) || aX == null)) {
                    int intExtra = getIntExtra("key_temp_session_show_type", 0);
                    switch (aX.CP()) {
                        case 2:
                            v.i("MicroMsg.ChattingUI", "bizinfo name=" + uVar.field_username + " is show custom menu");
                            if (this.ote == null) {
                                xi(2131756056);
                                this.ote = (ChatFooterCustom) findViewById(2131756084);
                                this.ote.h((ViewGroup) findViewById(2131756040));
                            }
                            try {
                                if (!m.ez(uVar.field_username)) {
                                    ChatFooterCustom chatFooterCustom = this.ote;
                                    if (chatFooterCustom.olN != null) {
                                        chatFooterCustom.olN.setVisibility(0);
                                    }
                                    if (chatFooterCustom.olO != null) {
                                        chatFooterCustom.olO.bEd();
                                    }
                                    this.ote.bhV = this.bhV;
                                    this.ote.a(this, aX.CX(), uVar.field_username);
                                    this.ote.lMv = this.lMv;
                                    this.ote.olP = this.ouI;
                                    this.hjH.a(this.lMv);
                                    if (!this.otb || intExtra != 1) {
                                        bEX();
                                        break;
                                    }
                                    bEY();
                                    break;
                                }
                                this.otr = new cx(this.ote);
                                this.otr.bCh();
                                bEX();
                                break;
                            } catch (Throwable e) {
                                com.tencent.mm.modelbiz.BizInfo.ExtInfo.b CX = aX.CX();
                                if (CX == null || CX.cCf == null || CX.cCf.size() == 0) {
                                    bEY();
                                } else {
                                    this.lMv.im(true);
                                }
                                v.a("MicroMsg.ChattingUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                break;
                            }
                            break;
                        default:
                            boolean z;
                            bEY();
                            String str = "MicroMsg.ChattingUI";
                            String str2 = "bizinfo name=%s, %b, %d";
                            Object[] objArr = new Object[3];
                            objArr[0] = uVar.field_username;
                            if (aX != null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            objArr[1] = Boolean.valueOf(z);
                            objArr[2] = Integer.valueOf(aX.CP());
                            v.e(str, str2, objArr);
                            break;
                    }
                }
            }
            return true;
        }

        private static boolean OT(String str) {
            return u.ew(str) || u.LJ(str) || u.LH(str) || m.eS(str);
        }

        public final void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
            if (!bFD()) {
                super.onCreateOptionsMenu(menu, menuInflater);
            }
        }

        public final boolean bFD() {
            return (this.cSL || this.nAV) ? false : true;
        }

        final void p(com.tencent.mm.pluginsdk.model.app.f fVar) {
            if (fVar == null || !fVar.bnl()) {
                v.e("MicroMsg.ChattingUI", "serviceAppSelect not service app");
            } else if (this.bhV == null || be.kS(this.bhV.field_username)) {
                v.e("MicroMsg.ChattingUI", "serviceAppSelect talker is null");
            } else {
                v.i("MicroMsg.ChattingUI", "serviceApp, jumpType[%d], package[%s], appid[%s]", Integer.valueOf(fVar.bxJ), fVar.field_packageName, fVar.field_appId);
                if (fVar.bxJ == 2 && !be.kS(fVar.bxI)) {
                    q(fVar);
                } else if (fVar.bxJ == 3) {
                    if (be.kS(fVar.field_openId)) {
                        am.bnF().Ez(fVar.field_appId);
                        v.e("MicroMsg.ChattingUI", "JUMP 3RD APP fail, openId is null, go get it");
                    } else if (this.ouR == null || be.kS(fVar.field_packageName)) {
                        v.e("MicroMsg.ChattingUI", "JUMP 3RD APP fail");
                        q(fVar);
                    } else {
                        v.i("MicroMsg.ChattingUI", "JUMP 3RD APP success[%s]", Boolean.valueOf(this.ouR.dY(fVar.field_packageName, fVar.field_openId)));
                        if (!this.ouR.dY(fVar.field_packageName, fVar.field_openId)) {
                            q(fVar);
                        }
                    }
                } else if (fVar.bxJ == 1) {
                    v.i("MicroMsg.ChattingUI", "JUMP NATIVE ForwardUrl[%s]", fVar.bxI);
                    com.tencent.mm.pluginsdk.j.a.lxU.a(this.nDR.nEl, fVar.bxI, false, new com.tencent.mm.pluginsdk.m(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final Object bmD() {
                            return this.ovO.bhV.field_username;
                        }

                        public final Object bmE() {
                            return this.ovO.irY;
                        }
                    });
                }
            }
        }

        private void q(com.tencent.mm.pluginsdk.model.app.f fVar) {
            if (fVar == null || be.kS(fVar.field_appId)) {
                v.e("MicroMsg.ChattingUI", "jumpServiceH5 error args");
            } else if (be.kS(fVar.bxI)) {
                v.e("MicroMsg.ChattingUI", "ForwardUrl is null");
            } else {
                int size;
                Intent intent;
                Bundle bundle;
                String d = com.tencent.mm.sdk.platformtools.u.d(NV(aa.bti()));
                if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                    d = Locale.getDefault().toString();
                }
                if (m.dE(bEn())) {
                    com.tencent.mm.storage.o LC = ak.yW().wO().LC(bEn());
                    if (LC != null) {
                        size = LC.DM().size();
                        intent = new Intent();
                        bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", fVar.field_appId);
                        bundle.putBoolean("isFromService", true);
                        intent.putExtra("forceHideShare", true);
                        bundle.putString("sendAppMsgToUserName", this.bhV.field_username);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("show_bottom", false);
                        intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.bxI, Integer.valueOf(size), d}));
                        com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
                size = 1;
                intent = new Intent();
                bundle = new Bundle();
                bundle.putString("jsapi_args_appid", fVar.field_appId);
                bundle.putBoolean("isFromService", true);
                intent.putExtra("forceHideShare", true);
                bundle.putString("sendAppMsgToUserName", this.bhV.field_username);
                intent.putExtra("jsapiargs", bundle);
                intent.putExtra("show_bottom", false);
                intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.bxI, Integer.valueOf(size), d}));
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        }

        final void an(at atVar) {
            String str = atVar.field_content;
            if (atVar.field_isSend == 0) {
                str = cf(str, atVar.field_isSend);
            }
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
            com.tencent.mm.pluginsdk.model.app.f aC = com.tencent.mm.pluginsdk.model.app.g.aC(dV.appId, true);
            if (aC == null || !com.tencent.mm.pluginsdk.model.app.p.o(this.nDR.nEl, aC.field_packageName)) {
                str = com.tencent.mm.pluginsdk.model.app.p.t(this.nDR.nEl, dV.appId, "message");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            } else if (aC.field_status == 3) {
                v.e("MicroMsg.ChattingUI", "requestAppShow fail, app is in blacklist, packageName = " + aC.field_packageName);
            } else if (!com.tencent.mm.pluginsdk.model.app.p.b(this.nDR.nEl, aC)) {
                v.e("MicroMsg.ChattingUI", "The app %s signature is incorrect.", aC.field_appName);
                Toast.makeText(this.nDR.nEl, d(2131233088, com.tencent.mm.pluginsdk.model.app.g.a(this.nDR.nEl, aC, null)), 1).show();
            } else if (!a(atVar, aC)) {
                com.tencent.mm.sdk.modelmsg.WXMediaMessage.b wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = dV.extInfo;
                if (dV.aXa != null && dV.aXa.length() > 0) {
                    com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                    wXAppExtendObject.filePath = Gu == null ? null : Gu.field_fileFullPath;
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.sdkVer = 587333634;
                wXMediaMessage.mediaObject = wXAppExtendObject;
                wXMediaMessage.title = dV.title;
                wXMediaMessage.description = dV.description;
                wXMediaMessage.messageAction = dV.messageAction;
                wXMediaMessage.messageExt = dV.messageExt;
                wXMediaMessage.thumbData = com.tencent.mm.a.e.c(com.tencent.mm.ae.n.GH().iW(atVar.field_imgPath), 0, -1);
                new em(this.nDR.nEl).a(aC.field_packageName, wXMediaMessage, aC.field_openId);
            }
        }

        private boolean a(at atVar, com.tencent.mm.pluginsdk.model.app.f fVar) {
            if (!atVar.field_talker.endsWith("@qqim") || !fVar.field_packageName.equals("com.tencent.mobileqq")) {
                return false;
            }
            int i;
            v.d("MicroMsg.ChattingUI", "jacks open QQ");
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setClassName("com.tencent.mobileqq", al(this.nDR.nEl, "com.tencent.mobileqq"));
            intent.putExtra("platformId", "wechat");
            ak.yW();
            Object obj = com.tencent.mm.model.c.vf().get(9, null);
            if (obj == null || !(obj instanceof Integer)) {
                i = 0;
            } else {
                i = ((Integer) obj).intValue();
            }
            if (i != 0) {
                try {
                    byte[] bytes = String.valueOf(i).getBytes("utf-8");
                    byte[] bytes2 = "asdfghjkl;'".getBytes("utf-8");
                    int length = bytes2.length;
                    i = 0;
                    int i2 = 0;
                    while (i < length) {
                        byte b = bytes2[i];
                        if (i2 >= bytes.length) {
                            break;
                        }
                        int i3 = i2 + 1;
                        bytes[i2] = (byte) (b ^ bytes[i2]);
                        i++;
                        i2 = i3;
                    }
                    intent.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    v.a("MicroMsg.ChattingUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
            try {
                startActivity(intent);
            } catch (Exception e2) {
            }
            return true;
        }

        private static String al(Context context, String str) {
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(packageInfo.packageName);
                ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
                if (resolveInfo != null) {
                    return resolveInfo.activityInfo.name;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.ChattingUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            return null;
        }

        protected final void bFE() {
            z.bYz.cY(osT);
            com.tencent.mm.modelstat.b.daJ.qq();
            this.ovC.clear();
            if (this.nAV || !bAm()) {
                bFH();
                return;
            }
            SwipeBackLayout swipeBackLayout = this.nFw;
            v.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", Boolean.valueOf(swipeBackLayout.paQ), Boolean.valueOf(swipeBackLayout.pey), Boolean.valueOf(swipeBackLayout.pez));
            if (!swipeBackLayout.bKv()) {
                com.tencent.mm.ui.widget.j.al(0.0f);
                swipeBackLayout.paQ = true;
                swipeBackLayout.pez = false;
                int width = (swipeBackLayout.Hq.getWidth() + swipeBackLayout.pev.getIntrinsicWidth()) + 10;
                com.tencent.mm.ui.mogic.a aVar = swipeBackLayout.pet;
                aVar.Ei = swipeBackLayout.Hq;
                aVar.fk = -1;
                aVar.e(width, 0, 0, 0);
                swipeBackLayout.invalidate();
                if (swipeBackLayout.peB != null) {
                    swipeBackLayout.peB.Rk();
                }
                com.tencent.mm.ui.widget.j.r(true, 0);
            }
        }

        private void goBack() {
            if (ale()) {
                com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void run() {
                        this.ovO.bFF();
                    }
                }, 300);
            } else {
                bFF();
            }
        }

        public final void Rj() {
            z.bYz.cY(osT);
            com.tencent.mm.modelstat.b.daJ.qq();
            bFH();
            if (bAm()) {
                this.nFw.hVC = false;
                if (this.onh != null) {
                    this.onh.jI(false);
                }
            }
        }

        public final void bAn() {
            if (bAm() && this.onh != null) {
                this.onh.jI(true);
                this.otQ = false;
            }
        }

        public final void bAo() {
            if (bAm() && this.onh != null) {
                this.onh.jI(false);
                this.otQ = true;
            }
        }

        private void bFF() {
            if (com.tencent.mm.pluginsdk.j.a.lxQ == null || !com.tencent.mm.pluginsdk.j.a.lxQ.bY(this.bhV.field_username, bFR())) {
                bFE();
            } else {
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131235685), vN(2131231164), true, new OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ovO.bFE();
                        com.tencent.mm.sdk.c.b dxVar = new dx();
                        dxVar.bbQ.username = this.ovO.bhV.field_username;
                        com.tencent.mm.sdk.c.a.nhr.z(dxVar);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }

        private boolean bFG() {
            if (this.oug == null || !this.oug.oqD) {
                return false;
            }
            if (this.oui) {
                bFC();
                this.oug.bEL();
            } else {
                this.oug.bEK();
            }
            return true;
        }

        private void bFH() {
            boolean z = true;
            bFG();
            for (int i = 0; i < this.otz.size(); i++) {
                b bVar = (b) this.otz.get(i);
                if (bVar != null) {
                    bVar.bEB();
                }
            }
            Intent intent;
            if (u.LH(bEn())) {
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "tmessage", ".ui.TConversationUI", intent);
            } else if (u.LJ(bEn())) {
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "qmessage", ".ui.QConversationUI", intent);
                overridePendingTransition(2130968589, 2130968642);
                return;
            } else if (this.onm) {
                if (this.otM) {
                    String bEn = bEn();
                    com.tencent.mm.sdk.c.b hoVar = new ho();
                    hoVar.bhk.bdf = 6;
                    hoVar.bhk.bhm = bEn;
                    com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                } else {
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131231823), vN(2131231164), true, new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.app.plugin.b.cJ(1);
                            this.ovO.bzp();
                            this.ovO.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
            } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.bhV != null && this.bhV.bvm() && this.exj != null && this.exj.CA() && this.exj.aX(false) != null && this.exj.aX(false).CZ() != null && !be.kS(this.exj.CF())) {
                finish();
                return;
            } else if (this.lMy) {
                finish();
            } else if (!this.otL) {
                if (this.nAV) {
                    intent = new Intent(this.nDR.nEl, LauncherUI.class);
                    intent.addFlags(67108864);
                    startActivity(intent);
                    overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.nFG, com.tencent.mm.ui.MMFragmentActivity.a.nFH);
                    finish();
                    return;
                } else if (bzo() instanceof LauncherUI) {
                    LauncherUI launcherUI = (LauncherUI) bzo();
                    if (launcherUI != null) {
                        if (bAm()) {
                            z = false;
                        }
                        launcherUI.iP(z);
                        return;
                    }
                    return;
                } else if (bzo() instanceof BaseConversationUI) {
                    BaseConversationUI baseConversationUI = (BaseConversationUI) bzo();
                    if (baseConversationUI != null) {
                        if (bAm()) {
                            z = false;
                        }
                        baseConversationUI.iP(z);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            finish();
        }

        public final void xm(int i) {
            int intValue = ((Integer) ak.yT().get(35, Integer.valueOf(10))).intValue();
            List linkedList = new LinkedList();
            linkedList.add(bEn());
            if (intValue == -2) {
                if (this.nQK && (i == 1 || i == 2)) {
                    v.d("MicroMsg.ChattingUI", "oreh old logic doDirectSend not support chatStatus:%d", Integer.valueOf(i));
                    return;
                }
                v.d("MicroMsg.ChattingUI", "oreh old logic doDirectSend done chatStatus:%d", Integer.valueOf(i));
                ak.vy().a(new com.tencent.mm.modelsimple.j(linkedList, com.tencent.mm.a.n.cE(i)), 0);
            } else if (this.nQK || u.LJ(this.bhV.field_username) || u.LH(this.bhV.field_username) || this.bhV.bvm()) {
                v.d("MicroMsg.ChattingUI", "oreh doDirectSend not support");
            } else {
                long ay = be.ay(this.oue);
                if (intValue == -1 || ay > ((long) intValue) * 1000) {
                    v.d("MicroMsg.ChattingUI", "oreh doDirectSend interval too long: %d;  interval: %d", Long.valueOf(ay / 1000), Integer.valueOf(intValue));
                    return;
                }
                v.d("MicroMsg.ChattingUI", "oreh doDirectSend done chatStatus:%d, delt:%d", Integer.valueOf(i), Long.valueOf(ay / 1000));
                ak.vy().a(new com.tencent.mm.modelsimple.j(linkedList, com.tencent.mm.a.n.cE(i)), 0);
            }
        }

        @Deprecated
        protected final void bFI() {
            a(true, true, null);
        }

        @Deprecated
        protected final void a(final boolean z, boolean z2, e eVar) {
            if (z2) {
                this.handler.postDelayed(new Runnable(this, null) {
                    final /* synthetic */ a ovO;

                    public final void run() {
                        this.ovO.jM(z);
                    }
                }, 10);
            } else {
                jM(z);
            }
        }

        private void jM(boolean z) {
            int count = this.oth.getCount() - 1;
            v.i("MicroMsg.ChattingUI", "mFirstScroll : %s, last visible/adapter=%s/%s %s", Boolean.valueOf(this.otp), Integer.valueOf(this.oth.getLastVisiblePosition()), Integer.valueOf(count), Boolean.valueOf(z));
            this.otp = false;
            if (this.oth.getLastVisiblePosition() >= count - 1 || z) {
                int count2 = this.onh.getCount();
                if (count2 <= 1 || !((at) this.onh.getItem(count2 - 2)).isSystem()) {
                    c.a(this.oth, count, true);
                    return;
                }
                c.a(this.oth, count - 1, 0, false);
            }
        }

        private boolean bFJ() {
            return this.bhV.field_username.equals("medianote") && (com.tencent.mm.model.k.xJ() & 16384) == 0;
        }

        public final boolean aXG() {
            if (this.nAV) {
                return false;
            }
            return true;
        }

        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            v.i("MicroMsg.ChattingUI", "chatting onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
            if (keyEvent.getKeyCode() != 4) {
                int selectionStart;
                int lastIndexOf;
                if (keyEvent.getKeyCode() == 67) {
                    if (bFD()) {
                        v.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                        return false;
                    }
                    ChatFooter chatFooter;
                    if (keyEvent.getAction() == 0) {
                        chatFooter = this.hjH;
                        selectionStart = chatFooter.hhK.getSelectionStart();
                        if ((selectionStart <= 0 ? 'x' : chatFooter.bpJ().charAt(selectionStart - 1)) == ' ') {
                            this.otI = true;
                        } else {
                            this.otI = false;
                        }
                    }
                    if (keyEvent.getAction() == 1 && this.otI) {
                        this.otI = false;
                        chatFooter = this.hjH;
                        selectionStart = chatFooter.hhK.getSelectionStart();
                        String substring = chatFooter.bpJ().substring(0, selectionStart);
                        lastIndexOf = substring.lastIndexOf(64);
                        if (lastIndexOf < substring.length() && lastIndexOf >= 0) {
                            substring = substring.substring(0, lastIndexOf);
                            String substring2 = chatFooter.bpJ().substring(selectionStart);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(substring).append(substring2);
                            chatFooter.HF(stringBuilder.toString());
                            chatFooter.hhK.setSelection(lastIndexOf);
                        }
                    }
                }
                if (keyEvent.getKeyCode() == 82 && keyEvent.getAction() == 1 && (this.exj == null || this.exj.aX(false) == null || this.exj.aX(false).CX() == null || this.exj.aX(false).CX().cCf == null || this.exj.aX(false).CX().cCf.isEmpty())) {
                    this.hjH.bpD();
                }
                if (bFD()) {
                    v.i("MicroMsg.ChattingUI", "onKeyDown fragment not foreground");
                    return false;
                }
                AudioManager audioManager = (AudioManager) this.nDR.nEl.getSystemService("audio");
                int streamMaxVolume = audioManager.getStreamMaxVolume(0);
                if (keyEvent.getAction() == 0 && i == 25 && this.oqd != null && this.oqd.isPlaying() && (this.evz || !this.oqd.evw)) {
                    lastIndexOf = audioManager.getStreamVolume(0);
                    v.v("MicroMsg.ChattingUI", "volume current:" + lastIndexOf + " max:" + streamMaxVolume);
                    selectionStart = streamMaxVolume / 7;
                    if (selectionStart == 0) {
                        selectionStart = 1;
                    }
                    audioManager.setStreamVolume(0, lastIndexOf - selectionStart, 5);
                    v.v("MicroMsg.ChattingUI", "volume current:" + lastIndexOf + " max:" + streamMaxVolume);
                    return true;
                } else if (keyEvent.getAction() != 0 || i != 24 || this.oqd == null || !this.oqd.isPlaying() || (!this.evz && this.oqd.evw)) {
                    return false;
                } else {
                    lastIndexOf = audioManager.getStreamVolume(0);
                    v.v("MicroMsg.ChattingUI", "volume current:" + lastIndexOf + " max:" + streamMaxVolume);
                    selectionStart = streamMaxVolume / 7;
                    if (selectionStart == 0) {
                        selectionStart = 1;
                    }
                    audioManager.setStreamVolume(0, selectionStart + lastIndexOf, 5);
                    v.v("MicroMsg.ChattingUI", "volume current:" + lastIndexOf + " max:" + streamMaxVolume);
                    return true;
                }
            } else if (bFD()) {
                v.i("MicroMsg.ChattingUI", "onKeyDown back key fragment not foreground");
                return false;
            } else if (bAm() && this.nFw.bKu()) {
                v.w("MicroMsg.ChattingUI", "ashutest::onKeyDown back ScrollToFinishing");
                return true;
            } else {
                if (keyEvent.getAction() == 0) {
                    this.ovz = true;
                    this.ovB = System.currentTimeMillis();
                }
                if (keyEvent.getAction() != 1) {
                    return true;
                }
                if (this.oti == null || !this.oti.aQa()) {
                    v.d("MicroMsg.ChattingUI", "hasBack %B, %d", Boolean.valueOf(this.ovz), Long.valueOf(System.currentTimeMillis() - this.ovB));
                    if (!this.ovz || System.currentTimeMillis() - this.ovB > 30000) {
                        return true;
                    }
                    this.ovA = true;
                    if (this.oug == null || !this.oug.oqD) {
                        if (this.hjH == null || !this.hjH.bqe()) {
                            goBack();
                            return true;
                        }
                        this.hjH.k(2, 23, false);
                        return true;
                    } else if (this.oui) {
                        bFC();
                        this.oug.bEL();
                        return true;
                    } else {
                        this.oug.bEK();
                        return true;
                    }
                }
                this.oti.fH(false);
                return true;
            }
        }

        public final boolean onKeyUp(int i, KeyEvent keyEvent) {
            v.d("MicroMsg.ChattingUI", "chatting ui fragment on key up, %d, %s", Integer.valueOf(i), keyEvent);
            return super.onKeyUp(i, keyEvent);
        }

        private int OU(String str) {
            if (m.eI(str) || u.LH(str)) {
                return 1;
            }
            if (m.eY(str)) {
                return 2;
            }
            int intExtra = getIntExtra("Chat_Mode", 0);
            v.d("MicroMsg.ChattingUI", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.otN), Integer.valueOf(intExtra));
            if (this.otN != 0) {
                intExtra = this.otN;
            }
            String value = com.tencent.mm.h.j.sU().getValue("DefaultMsgType");
            if (this.otN == 0 && value != null) {
                v.d("MicroMsg.ChattingUI", "config def chatmode is %s", value);
                intExtra = be.getInt(com.tencent.mm.h.j.sU().getValue("DefaultMsgType"), 0);
            }
            if (intExtra == 0 && com.tencent.mm.i.a.ei(this.bhV.field_type)) {
                ak.yW();
                intExtra = ((Integer) com.tencent.mm.model.c.vf().get(18, Integer.valueOf(0))).intValue();
            }
            if (intExtra == 0) {
                intExtra = 1;
            }
            v.d("MicroMsg.ChattingUI", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.otN), Integer.valueOf(intExtra));
            return intExtra;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected void bDM() {
            /*
            r7 = this;
            r6 = 2131232864; // 0x7f080860 float:1.808185E38 double:1.0529689414E-314;
            r4 = 2131231879; // 0x7f080487 float:1.8079851E38 double:1.0529684547E-314;
            r2 = 2;
            r3 = 1;
            r5 = 0;
            r7.otm = r5;
            r7.otn = r5;
            r0 = r7.oum;
            if (r0 == 0) goto L_0x0022;
        L_0x0011:
            r0 = r7.oum;
            r0 = r0.getVisibility();
            r1 = 8;
            if (r0 == r1) goto L_0x0022;
        L_0x001b:
            r0 = r7.oum;
            r1 = 8;
            r0.setVisibility(r1);
        L_0x0022:
            r0 = r7.bEn();
            r0 = com.tencent.mm.model.m.ez(r0);
            if (r0 == 0) goto L_0x0036;
        L_0x002c:
            r0 = r7.bhV;
            r0 = r0.tT();
            r7.Fd(r0);
        L_0x0035:
            return;
        L_0x0036:
            r0 = r7.otU;
            if (r0 == 0) goto L_0x0041;
        L_0x003a:
            r0 = 2131234805; // 0x7f080ff5 float:1.8085786E38 double:1.0529699004E-314;
            r7.vD(r0);
            goto L_0x0035;
        L_0x0041:
            r0 = r7.bEn();
            r0 = com.tencent.mm.storage.u.LH(r0);
            if (r0 == 0) goto L_0x0074;
        L_0x004b:
            r1 = r7.hjH;
            r0 = r1.fDt;
            r2 = 2131756077; // 0x7f10042d float:1.9143051E38 double:1.053227443E-314;
            r0 = r0.findViewById(r2);
            r0 = (android.widget.TextView) r0;
            r1.lMk = r0;
            r0 = r1.hhK;
            r1 = new android.text.InputFilter[r3];
            r2 = new android.text.InputFilter$LengthFilter;
            r3 = 140; // 0x8c float:1.96E-43 double:6.9E-322;
            r2.<init>(r3);
            r1[r5] = r2;
            r0.setFilters(r1);
            r0 = r7.bhV;
            r0 = r0.tU();
            r7.Fd(r0);
            goto L_0x0035;
        L_0x0074:
            r0 = r7.bEn();
            r0 = com.tencent.mm.model.m.fk(r0);
            if (r0 == 0) goto L_0x0088;
        L_0x007e:
            r0 = r7.bhV;
            r0 = r0.tT();
            r7.Fd(r0);
            goto L_0x0035;
        L_0x0088:
            r0 = r7.bEn();
            r0 = com.tencent.mm.storage.u.ew(r0);
            if (r0 == 0) goto L_0x00ee;
        L_0x0092:
            r1 = 2131231515; // 0x7f08031b float:1.8079113E38 double:1.052968275E-314;
            r2 = new java.lang.Object[r3];
            r3 = r7.bhV;
            if (r3 == 0) goto L_0x00e6;
        L_0x009b:
            r0 = r3.getCountryCode();
            r0 = com.tencent.mm.storage.RegionCodeDecoder.Nn(r0);
            if (r0 == 0) goto L_0x00d8;
        L_0x00a5:
            r0 = r3.getCity();
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r4 != 0) goto L_0x00be;
        L_0x00af:
            r2[r5] = r0;
            r0 = r7.d(r1, r2);
            r0 = r0.trim();
            r7.Fd(r0);
            goto L_0x0035;
        L_0x00be:
            r0 = r3.getProvince();
            r0 = com.tencent.mm.model.l.eu(r0);
            r4 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r4 == 0) goto L_0x00af;
        L_0x00cc:
            com.tencent.mm.storage.RegionCodeDecoder.bxc();
            r0 = r3.getCountryCode();
            r0 = com.tencent.mm.storage.RegionCodeDecoder.getLocName(r0);
            goto L_0x00af;
        L_0x00d8:
            r0 = r3.getProvince();
            r0 = com.tencent.mm.model.l.eu(r0);
            r3 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r3 == 0) goto L_0x00af;
        L_0x00e6:
            r0 = 2131231544; // 0x7f080338 float:1.8079172E38 double:1.052968289E-314;
            r0 = r7.vN(r0);
            goto L_0x00af;
        L_0x00ee:
            r0 = r7.onl;
            if (r0 == 0) goto L_0x014f;
        L_0x00f2:
            r0 = r7.bhV;
            r0 = r0.field_nickname;
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r0 == 0) goto L_0x012e;
        L_0x00fc:
            r0 = r7.bEn();
            r0 = com.tencent.mm.model.i.el(r0);
            if (r0 != 0) goto L_0x010f;
        L_0x0106:
            r0 = r7.vN(r4);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x010f:
            r0 = new java.lang.Object[r2];
            r1 = r7.vN(r4);
            r0[r5] = r1;
            r1 = r7.bEn();
            r1 = com.tencent.mm.model.i.el(r1);
            r1 = java.lang.Integer.valueOf(r1);
            r0[r3] = r1;
            r0 = r7.d(r6, r0);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x012e:
            r0 = new java.lang.Object[r2];
            r1 = r7.bhV;
            r1 = r1.tT();
            r0[r5] = r1;
            r1 = r7.bEn();
            r1 = com.tencent.mm.model.i.el(r1);
            r1 = java.lang.Integer.valueOf(r1);
            r0[r3] = r1;
            r0 = r7.d(r6, r0);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x014f:
            r0 = r7.onm;
            if (r0 == 0) goto L_0x0172;
        L_0x0153:
            r0 = r7.bhV;
            r0 = r0.field_nickname;
            r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r0 == 0) goto L_0x0169;
        L_0x015d:
            r0 = 2131234010; // 0x7f080cda float:1.8084174E38 double:1.0529695076E-314;
            r0 = r7.vN(r0);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x0169:
            r0 = r7.bhV;
            r0 = r0.field_nickname;
            r7.Fd(r0);
            goto L_0x0035;
        L_0x0172:
            r0 = r7.lKa;
            if (r0 == 0) goto L_0x01ce;
        L_0x0176:
            r0 = r7.otJ;
            if (r0 == 0) goto L_0x01c5;
        L_0x017a:
            r0 = r7.bFS();
            r0 = com.tencent.mm.modelbiz.a.e.aa(r0);
            r1 = r7.ogZ;
            r1 = r1.field_chatName;
            r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
            if (r1 == 0) goto L_0x01ae;
        L_0x018c:
            if (r0 != 0) goto L_0x0197;
        L_0x018e:
            r0 = r7.vN(r4);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x0197:
            r1 = new java.lang.Object[r2];
            r2 = r7.vN(r4);
            r1[r5] = r2;
            r0 = java.lang.Integer.valueOf(r0);
            r1[r3] = r0;
            r0 = r7.d(r6, r1);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x01ae:
            r1 = new java.lang.Object[r2];
            r2 = r7.ogZ;
            r2 = r2.field_chatName;
            r1[r5] = r2;
            r0 = java.lang.Integer.valueOf(r0);
            r1[r3] = r0;
            r0 = r7.d(r6, r1);
            r7.Fd(r0);
            goto L_0x0035;
        L_0x01c5:
            r0 = r7.hVf;
            r0 = r0.field_userName;
            r7.Fd(r0);
            goto L_0x0035;
        L_0x01ce:
            r0 = r7.bhV;
            r0 = r0.tU();
            r7.Fd(r0);
            r0 = r7.ouU;
            r1 = r7.bEn();
            r1 = com.tencent.mm.storage.u.LJ(r1);
            r0.iF(r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingUI.a.bDM():void");
        }

        private void a(final com.tencent.mm.storage.ab abVar, boolean z) {
            this.osV = findViewById(2131756053);
            if (this.osV != null) {
                com.tencent.mm.modelbiz.a.a aVar = null;
                if (this.lKa) {
                    aVar = com.tencent.mm.modelbiz.u.DB().T(bFS());
                }
                if (!(abVar == null && aVar == null) && (!(OT(this.bhV.field_username) || m.fl(this.bhV.field_username) || m.eD(this.bhV.field_username) || m.fg(this.bhV.field_username) || m.eG(this.bhV.field_username)) || this.onl || this.lKa || bFM())) {
                    if (this.lKa && aVar != null) {
                        this.osU = aVar.field_unReadCount;
                    } else if (abVar != null) {
                        this.osU = abVar.field_unReadCount;
                    } else {
                        this.osV.setVisibility(8);
                        return;
                    }
                    int i = this.osU;
                    if (z && abVar != null && abVar.field_UnDeliverCount > 0) {
                        i += abVar.field_UnDeliverCount;
                        v.i("MicroMsg.ChattingUI", "summerbadcr updateGoBacktoHistroyMessage mUnreadMessage fixUnreadMessage[%d, %d]", Integer.valueOf(i), Integer.valueOf(this.osU));
                        this.osZ = this.osU;
                    }
                    int i2 = i;
                    if (i2 >= (bFM() ? 5 : 10)) {
                        this.osV.setVisibility(0);
                        this.osW = (TextView) findViewById(2131756054);
                        if (i2 > TbsLog.TBSLOG_CODE_SDK_INIT) {
                            this.osW.setText(String.format(vN(2131231799), new Object[]{Integer.valueOf(TbsLog.TBSLOG_CODE_SDK_INIT)}));
                        } else {
                            this.osW.setText(String.format(vN(2131231799), new Object[]{Integer.valueOf(i2)}));
                        }
                        if (this.lKa) {
                            i = ak.yW().cqY.M(this.bhV.field_username, bFS()) - this.osU;
                        } else {
                            ak.yW();
                            i = com.tencent.mm.model.c.wJ().MW(this.bhV.field_username) - this.osU;
                        }
                        this.osV.setOnClickListener(new View.OnClickListener(this) {
                            final /* synthetic */ a ovO;

                            public final void onClick(View view) {
                                if (abVar == null || abVar.field_UnDeliverCount <= 0) {
                                    this.ovO.Y(i, false);
                                    return;
                                }
                                v.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout Unread[%d] UnDeliver[%d] pos[%d]", Integer.valueOf(this.ovO.osU), Integer.valueOf(abVar.field_UnDeliverCount), Integer.valueOf(i));
                                if (abVar.field_UnDeliverCount <= 0) {
                                    v.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] less then one scene do normal", Integer.valueOf(r0));
                                } else {
                                    final int i = (int) abVar.field_firstUnDeliverSeq;
                                    v.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout undeliverCount[%d] need get firstSeq[%d]", Integer.valueOf(r0), Integer.valueOf(i));
                                    if (i > 0) {
                                        ak.vA().x(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass132 owT;

                                            public final void run() {
                                                v.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout try get undeliver msg from firstseq[%d]", Integer.valueOf(i));
                                                ak.yW();
                                                if (com.tencent.mm.model.c.wJ().T(abVar.field_username, (long) i).field_msgId > 0) {
                                                    v.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout first msg exist just do nothing [%d] [%d]", Long.valueOf(com.tencent.mm.model.c.wJ().T(abVar.field_username, (long) i).field_msgId), Long.valueOf(com.tencent.mm.model.c.wJ().T(abVar.field_username, (long) i).field_msgSeq));
                                                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                                                        final /* synthetic */ AnonymousClass1 owU;

                                                        {
                                                            this.owU = r1;
                                                        }

                                                        public final void run() {
                                                            this.owU.owT.ovO.Y(i, false);
                                                        }
                                                    });
                                                    return;
                                                }
                                                long j;
                                                long j2 = abVar.field_lastSeq;
                                                ak.yW();
                                                bx Nj = com.tencent.mm.model.c.wJ().Nj(abVar.field_username);
                                                if (Nj == null || Nj.field_msgId <= 0) {
                                                    j = j2;
                                                } else {
                                                    j = Nj.field_msgSeq;
                                                }
                                                this.owT.ovO.osX = true;
                                                v.i("MicroMsg.ChattingUI", "summerbadcr mGoBackToHistryMsgLayout get msg mUnreadMessageBeforeCheckHistory[%d], filterSeq[%d], firstSeq[%d]", Integer.valueOf(this.owT.ovO.osZ), Long.valueOf(j), Integer.valueOf(i));
                                                com.tencent.mm.modelmulti.o.Hp().a(new com.tencent.mm.modelmulti.b.a(abVar.field_username, (int) j, i, 18, 0), this.owT.ovO);
                                            }
                                        });
                                        return;
                                    }
                                }
                                this.ovO.Y(i, false);
                            }
                        });
                        this.osV.post(new Runnable(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void run() {
                                if (this.ovO.ovK != null && this.ovO.ovK.getVisibility() == 0) {
                                    this.ovO.xn(1);
                                } else if (a.ap(this.ovO)) {
                                    this.ovO.xn(3);
                                } else {
                                    this.ovO.xn(0);
                                }
                                Animation translateAnimation = new TranslateAnimation((float) this.ovO.osV.getWidth(), 0.0f, 0.0f, 0.0f);
                                translateAnimation.setDuration(300);
                                translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.ovO.nDR.nEl, 17432581));
                                this.ovO.osV.startAnimation(translateAnimation);
                                translateAnimation.setAnimationListener(new AnimationListener(this) {
                                    final /* synthetic */ AnonymousClass134 owV;

                                    {
                                        this.owV = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                        this.owV.ovO.osV.setClickable(false);
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        this.owV.ovO.osV.setClickable(true);
                                    }
                                });
                            }
                        });
                        return;
                    }
                }
                this.osV.setVisibility(8);
            }
        }

        private void bFK() {
            if (this.osV != null) {
                this.osU = -1;
                if (this.osV.getVisibility() == 0) {
                    Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.osV.getWidth(), 0.0f, 0.0f);
                    translateAnimation.setDuration(300);
                    translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.nDR.nEl, 17432581));
                    this.osV.startAnimation(translateAnimation);
                }
                this.osV.setVisibility(8);
            }
        }

        private void xn(int i) {
            if (this.osU >= (bFM() ? 5 : 10) && this.osV != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.osV.getLayoutParams();
                switch (i) {
                    case -2:
                        if (this.ovK == null || this.ovK.getVisibility() != 0) {
                            layoutParams.setMargins(0, bAq().getDimensionPixelSize(2131493135), 0, 0);
                            return;
                        }
                        return;
                    case 0:
                        layoutParams.setMargins(0, bAq().getDimensionPixelSize(2131493135), 0, 0);
                        return;
                    case 1:
                        int i2;
                        int i3;
                        if (this.ovK == null || this.ovK.getVisibility() != 0) {
                            i2 = 0;
                        } else {
                            i2 = this.ovK.getHeight();
                        }
                        if (this.ovL == null || this.ovL.getVisibility() != 0) {
                            i3 = 0;
                        } else {
                            i3 = bAq().getDimensionPixelSize(2131493163);
                        }
                        if (i3 > i2) {
                            i2 = i3;
                        }
                        layoutParams.setMargins(0, i2 + bAq().getDimensionPixelSize(2131493135), 0, 0);
                        return;
                    case 3:
                        layoutParams.setMargins(0, bAq().getDimensionPixelSize(2131493135) * 3, 0, 0);
                        return;
                    default:
                        return;
                }
            }
        }

        public final boolean bFL() {
            if ((this.bhV.bvm() || m.fk(bEn()) || u.LH(bEn())) && !this.lKa) {
                return false;
            }
            return true;
        }

        private boolean bFM() {
            if (m.fi(bEn())) {
                return true;
            }
            if (this.bhV.bvm() && this.exj != null && (this.exj.Cx() || this.exj.Cw())) {
                return true;
            }
            return false;
        }

        public void openContextMenu(View view) {
            if (this.eyZ == null) {
                this.eyZ = new l(this.nDR.nEl);
            }
            this.eyZ.b(view, this.ima, this.hkn);
        }

        public final String xo(int i) {
            at atVar = (at) this.onh.getItem(i);
            Object obj = (com.tencent.mm.app.plugin.c.oP() && atVar.bwy()) ? 1 : null;
            if (obj != null) {
                return cf(atVar.field_content, atVar.field_isSend) + "\n\n" + cf(atVar.field_transContent, atVar.field_isSend);
            }
            return cf(atVar.field_content, atVar.field_isSend);
        }

        private void Y(int i, boolean z) {
            int i2;
            int count;
            int count2 = this.onh.getCount();
            int i3 = this.onh.emv - i;
            if (i3 <= 18) {
                i2 = count2 - i3;
            } else if (count2 > i3) {
                i2 = count2 - i3;
            } else {
                this.onh.xb(i3 - count2);
                this.onh.a(null, null);
                i2 = 0;
            }
            if (z) {
                v.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster get pos=%d, preCount=%d, totalCount=%d, msgCount =%d, select=%d, newTotalCount=%d, newCount=%d, stack[%s]", Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(this.onh.emv), Integer.valueOf(this.onh.getCount()), be.bur());
                count = this.onh.getCount() - count2;
            } else {
                count = i2;
            }
            v.i("MicroMsg.ChattingUI", "summerbadcr goBackToHistroyMsg dzmonster pos=%d, preCount=%d, totalCount=%d, msgCount =%d, fSelect=%d, newTotalCount=%d, newCount=%d, stack[%s]", Integer.valueOf(i), Integer.valueOf(count2), Integer.valueOf(r4), Integer.valueOf(i3), Integer.valueOf(count), Integer.valueOf(this.onh.emv), Integer.valueOf(this.onh.getCount()), be.bur());
            cp cpVar = this.onh;
            at atVar = (at) cpVar.getItem(count);
            if (!(atVar == null || atVar.field_msgId == 0)) {
                cpVar.oqa = atVar.field_msgId;
            }
            bFK();
            this.oth.post(new Runnable(this) {
                final /* synthetic */ a ovO;

                public final void run() {
                    v.i("MicroMsg.ChattingUI", "summerbadcr dz: scroll to fSelect:%d", Integer.valueOf(count));
                    com.tencent.mm.ui.tools.o oVar = new com.tencent.mm.ui.tools.o(this.ovO.oth);
                    int headerViewsCount = this.ovO.oth.getHeaderViewsCount() + count;
                    oVar.hOQ.removeCallbacks(oVar);
                    oVar.oUg = System.currentTimeMillis();
                    oVar.oUl = 0;
                    int firstVisiblePosition = oVar.hOQ.getFirstVisiblePosition();
                    int childCount = (oVar.hOQ.getChildCount() + firstVisiblePosition) - 1;
                    if (headerViewsCount <= firstVisiblePosition) {
                        firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
                        oVar.mMode = 2;
                    } else if (headerViewsCount >= childCount) {
                        firstVisiblePosition = (headerViewsCount - childCount) + 1;
                        oVar.mMode = 1;
                    } else {
                        return;
                    }
                    if (firstVisiblePosition > 0) {
                        oVar.oUj = 1000 / firstVisiblePosition;
                    } else {
                        oVar.oUj = 1000;
                    }
                    oVar.oUh = headerViewsCount;
                    oVar.oUi = -1;
                    oVar.hOQ.post(oVar);
                }
            });
        }

        final void ao(at atVar) {
            if (this.oug == null) {
                if (this.ouf == null) {
                    xi(2131756057);
                    this.ouf = (ChattingFooterMoreBtnBar) findViewById(2131756318);
                }
                this.oug = new ct(this, this.ouf, this.onh, this.hjH, this.ote, this.bhV, this.nQK);
            } else {
                this.oug.b(this.bhV, this.nQK);
            }
            this.ouf.bEv();
            ct ctVar = this.oug;
            ctVar.omY.a(true, ctVar.eSv);
            ctVar.ori.startAnimation(ctVar.iVP);
            ctVar.ori.setVisibility(0);
            ctVar.oqD = true;
            ctVar.omY.bFC();
            ctVar.omZ.bEI();
            ctVar.omZ.oqG.clear();
            ctVar.omZ.ew(atVar.field_msgId);
            ctVar.ori.xa(ctVar.omZ.oqG.size());
            ctVar.omY.bGb();
            ctVar.omY.ale();
            ctVar.omY.bFt();
            ctVar.omY.bFs();
            g.iuh.h(10811, Integer.valueOf(1));
            this.oug.onc = this.otY;
            if (this.bhV.bvm()) {
                this.nDR.vH(2131755061);
            }
            bFK();
        }

        final void ap(at atVar) {
            if (atVar.field_msgId == this.oqd.olq) {
                this.oqd.jE(true);
            }
            if (!this.bhV.field_username.equals("medianote")) {
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
            }
            dw.aC(atVar);
        }

        final void aq(at atVar) {
            if (!this.bhV.field_username.equals("medianote")) {
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
            }
            dw.aD(atVar);
            a(true, true, null);
        }

        final void ar(at atVar) {
            v.d("MicroMsg.ChattingUI", "resendEmoji");
            if (!this.bhV.field_username.equals("medianote")) {
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
            }
            dw.ar(atVar);
        }

        final void as(at atVar) {
            if (!this.bhV.field_username.equals("medianote")) {
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
            }
            dw.as(atVar);
            a(true, true, null);
        }

        final void at(at atVar) {
            if (!this.bhV.field_username.equals("medianote")) {
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
            }
            dw.at(atVar);
            a(true, true, null);
        }

        final void au(at atVar) {
            v.d("MicroMsg.ChattingUI", "resendAppMsgEmoji");
            if (!this.bhV.field_username.equals("medianote")) {
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.e(atVar.field_talker, atVar.field_msgSvrId));
            }
            dw.au(atVar);
            a(true, true, null);
        }

        final void av(at atVar) {
            dw.aE(atVar);
            a(true, true, null);
        }

        final String cf(String str, int i) {
            if (this.otJ || !this.nQK || str == null || i != 0) {
                return str;
            }
            return aw.fM(str);
        }

        public final void onActivityResult(final int i, int i2, final Intent intent) {
            if (bFD()) {
                v.i("MicroMsg.ChattingUI", "onActivityResult not foreground, return, requestCode:%d", Integer.valueOf(i));
                return;
            }
            String str = "MicroMsg.ChattingUI";
            String str2 = "onActivityResult requestCode:%d, data is null:%b  rawUserName:%s ";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(intent == null);
            objArr[2] = this.onj;
            v.i(str, str2, objArr);
            if (this.onh.oqD && this.oui) {
                bFC();
            }
            if (i == 12001 && this.ouZ != null) {
                com.tencent.mm.app.plugin.a.a aVar = this.ouZ;
                if (aVar.aSD == null) {
                    v.e("MicroMsg.exdevice.ChattingUIExDeviceLogic", "context is null, maybe has been released");
                } else if (i2 == -1) {
                    Toast.makeText(aVar.aSD.nDR.nEl, 2131232556, 0).show();
                    com.tencent.mm.sdk.c.b dcVar = new dc();
                    dcVar.bbb.op = 0;
                    dcVar.bbb.userName = aVar.aSD.bEn();
                    dcVar.bbb.context = aVar.aSD.nDR.nEl;
                    com.tencent.mm.sdk.c.a.nhr.z(dcVar);
                } else if (i2 == 0) {
                    Toast.makeText(aVar.aSD.nDR.nEl, 2131232555, 0).show();
                }
            } else if (i == 221) {
                if (intent != null) {
                    r0 = intent.getStringExtra("result_msg");
                    if (!be.kS(r0)) {
                        com.tencent.mm.ui.base.g.bf(this.nDR.nEl, r0);
                    }
                }
            } else if (i2 == -1) {
                if (!(i == 217 || this.ote == null)) {
                    this.ote.g(i, intent);
                }
                boolean z;
                String wP;
                com.tencent.mm.sdk.c.b peVar;
                String str3;
                switch (i) {
                    case 200:
                        if (intent != null) {
                            Intent intent2 = new Intent(this.nDR.nEl, CropImageNewUI.class);
                            intent2.putExtra("CropImageMode", 4);
                            intent2.putExtra("CropImage_Filter", true);
                            str = "CropImage_Has_Raw_Img_Btn";
                            r0 = bEn();
                            z = r0 == null || !(u.LH(r0) || u.LJ(r0));
                            intent2.putExtra(str, z);
                            intent2.putExtra("from_source", 3);
                            ak.yW();
                            wP = com.tencent.mm.model.c.wP();
                            if (intent.getData().toString().startsWith("content://com.google.android.gallery3d")) {
                                new com.tencent.mm.ui.tools.a.AnonymousClass1(intent, this, wP, null, intent2, 203).execute(new Integer[]{Integer.valueOf(0)});
                                return;
                            }
                            r0 = com.tencent.mm.ui.tools.a.b(this.nDR.nEl, intent, wP);
                            if (!be.kS(r0)) {
                                intent2.putExtra("CropImage_ImgPath", r0);
                                startActivityForResult(intent2, 203);
                                return;
                            }
                            return;
                        }
                        return;
                    case 201:
                        Context applicationContext = this.nDR.nEl.getApplicationContext();
                        ak.yW();
                        this.filePath = com.tencent.mm.pluginsdk.ui.tools.l.a(applicationContext, intent, com.tencent.mm.model.c.wP());
                        if (this.filePath != null) {
                            Intent intent3 = new Intent();
                            ArrayList arrayList = new ArrayList(1);
                            arrayList.add(this.filePath);
                            intent3.putExtra("query_source_type", 3);
                            intent3.putExtra("preview_image", true);
                            intent3.putExtra("isTakePhoto", true);
                            intent3.putExtra("GalleryUI_FromUser", bFR());
                            intent3.putExtra("GalleryUI_ToUser", bEn());
                            intent3.putExtra("is_long_click", true);
                            intent3.putStringArrayListExtra("preview_image_list", arrayList);
                            intent3.addFlags(67108864);
                            com.tencent.mm.ay.c.a((Fragment) this, "gallery", ".ui.GalleryEntryUI", intent3, 217);
                            return;
                        }
                        return;
                    case 202:
                        if (intent == null) {
                            v.e("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                            return;
                        }
                        int intExtra = intent.getIntExtra("Chat_Mode", 1);
                        if (this.hjH != null) {
                            this.hjH.R(intExtra, true);
                            return;
                        }
                        return;
                    case 203:
                        this.filePath = intent.getStringExtra("CropImage_OutputPath");
                        if (this.filePath == null) {
                            this.hjH.clearFocus();
                            return;
                        }
                        str = this.filePath;
                        z = com.tencent.mm.model.k.a(str, bEn(), intent.getBooleanExtra("CropImage_Compress_Img", true));
                        intent.getIntExtra("from_source", 0);
                        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
                        v.d("MicroMsg.ChattingUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
                        r(z ? 1 : 0, intExtra2, str);
                        this.hjH.clearFocus();
                        new ac(Looper.getMainLooper()).post(new Runnable(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void run() {
                                com.tencent.mm.sdk.c.b peVar = new pe();
                                peVar.bqy.bqA = true;
                                com.tencent.mm.sdk.c.a.nhr.z(peVar);
                            }
                        });
                        return;
                    case 204:
                        return;
                    case 207:
                        cg(intent.getStringExtra("art_smiley_slelct_data"), 4);
                        return;
                    case 208:
                        aa(intent);
                        return;
                    case 210:
                        if (i2 == -1) {
                            long longExtra = intent.getLongExtra("App_MsgId", 0);
                            ak.yW();
                            an(com.tencent.mm.model.c.wJ().ek(longExtra));
                            return;
                        }
                        return;
                    case 211:
                        if (i2 == -1) {
                            Cursor managedQuery = bzo() != null ? bzo().managedQuery(intent.getData(), null, null, null, null) : null;
                            if (managedQuery.moveToFirst()) {
                                startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                                return;
                            }
                            return;
                        }
                        return;
                    case 212:
                        if (intent != null) {
                            r0 = intent.getStringExtra("Select_Conv_User");
                            if (be.kS(r0)) {
                                v.d("MicroMsg.ChattingUI", "@ %s", "[nobody]");
                                this.hjH.HD(SQLiteDatabase.KeyEmpty);
                                this.otH = false;
                                return;
                            }
                            v.d("MicroMsg.ChattingUI", "@ %s", r0);
                            this.hjH.HD(r0);
                            this.otH = true;
                            return;
                        }
                        return;
                    case 213:
                        if (intent != null && intent.getBooleanExtra("_delete_ok_", false)) {
                            finish();
                            return;
                        }
                        return;
                    case 214:
                        ChatFooter.bqf();
                        this.hjH.bqc();
                        return;
                    case 215:
                        aa(intent);
                        return;
                    case 216:
                        Z(intent);
                        return;
                    case 217:
                        if (intent == null) {
                            v.e("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                            return;
                        }
                        str2 = intent.getStringExtra("GalleryUI_ToUser");
                        str = be.kS(str2) ? this.onj : str2;
                        v.i("MicroMsg.ChattingUI", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE userFromIntent:%s rawUsername:%s", str2, this.onj);
                        this.hjH.clearFocus();
                        this.hjH.bqg();
                        peVar = new pe();
                        peVar.bqy.bqA = true;
                        com.tencent.mm.sdk.c.a.nhr.z(peVar);
                        DrawedCallBackLinearLayout drawedCallBackLinearLayout = (DrawedCallBackLinearLayout) this.mView.findViewById(2131755468);
                        if (drawedCallBackLinearLayout != null) {
                            drawedCallBackLinearLayout.pbn = new com.tencent.mm.ui.widget.DrawedCallBackLinearLayout.a(this) {
                                final /* synthetic */ a ovO;

                                public final void oo() {
                                    ak.vA().f(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass141 oxd;

                                        {
                                            this.oxd = r1;
                                        }

                                        public final void run() {
                                            ak.vA().btu();
                                            a.a(this.oxd.ovO, intent, str);
                                            if (this.oxd.ovO.ote != null) {
                                                this.oxd.ovO.ote.g(i, intent);
                                            }
                                            ak.vA().btw();
                                        }
                                    }, 100);
                                }
                            };
                            return;
                        }
                        return;
                    case 218:
                        if (intent == null) {
                            return;
                        }
                        if (intent.getBooleanExtra("from_record", false)) {
                            Z(intent);
                            return;
                        } else {
                            aa(intent);
                            return;
                        }
                    case 220:
                        if (-1 == i2 && this.oug != null && this.oug.oqD) {
                            this.oug.bEK();
                            return;
                        }
                        return;
                    case 222:
                        if (i2 == -1 && intent != null) {
                            str = intent.getStringExtra("service_app_package_name");
                            str2 = intent.getStringExtra("service_app_openid");
                            wP = intent.getStringExtra("service_app_appid");
                            str3 = "MicroMsg.ChattingUI";
                            String str4 = "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Boolean.valueOf(this.ouR != null);
                            objArr2[1] = str;
                            objArr2[2] = wP;
                            objArr2[3] = str2;
                            v.i(str3, str4, objArr2);
                            if (be.kS(wP)) {
                                v.e("MicroMsg.ChattingUI", "REQUEST_CODE_SERVICE_APP openId is null");
                                return;
                            } else if (this.ouR == null || be.kS(str)) {
                                q(com.tencent.mm.pluginsdk.model.app.g.aC(wP, true));
                                return;
                            } else if (be.kS(str2)) {
                                am.bnF().Ez(wP);
                                v.e("MicroMsg.ChattingUI", "request send wx msg fail, openId is null, go get it");
                                return;
                            } else {
                                v.d("MicroMsg.ChattingUI", "request send wx msg success = %b", Boolean.valueOf(this.ouR.dY(str, str2)));
                                if (!this.ouR.dY(str, str2)) {
                                    q(com.tencent.mm.pluginsdk.model.app.g.aC(wP, true));
                                    return;
                                }
                                return;
                            }
                        }
                        return;
                    case 223:
                        if (i2 == -1 && intent != null) {
                            str = intent.getStringExtra("be_send_card_name");
                            str2 = com.tencent.mm.model.l.er(str);
                            wP = intent.getStringExtra("received_card_name");
                            final boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                            com.tencent.mm.pluginsdk.ui.applet.c.c cVar = new com.tencent.mm.pluginsdk.ui.applet.c.c(this.nDR.nEl);
                            com.tencent.mm.u.b.a(str, true, -1);
                            ak.yW();
                            if (m.eG(com.tencent.mm.model.c.wH().LV(str).field_verifyFlag)) {
                                r0 = getResources().getString(2131231069);
                            } else {
                                r0 = getResources().getString(2131231070);
                            }
                            cVar.ba(wP).Hw(new StringBuffer(r0).append(str2).toString()).d(Boolean.valueOf(true)).tS(2131231149).a(new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                                final /* synthetic */ a ovO;

                                public final void a(boolean z, String str, int i) {
                                    this.ovO.ale();
                                    if (z) {
                                        com.tencent.mm.pluginsdk.j.a.bmt().m(str, wP, booleanExtra);
                                        com.tencent.mm.pluginsdk.j.a.bmt().df(str, wP);
                                    }
                                }
                            }).iji.show();
                            return;
                        }
                        return;
                    case 224:
                        if (i2 == -1 && intent != null) {
                            r0 = intent.getStringExtra("be_send_card_name");
                            str = intent.getStringExtra("received_card_name");
                            str2 = intent.getStringExtra("custom_send_text");
                            boolean booleanExtra2 = intent.getBooleanExtra("Is_Chatroom", false);
                            Intent intent4 = new Intent(this.nDR.nEl, ChattingUI.class);
                            intent4.putExtra("Chat_User", str);
                            intent4.putExtra("send_card_username", r0);
                            intent4.putExtra("send_card_edittext", str2);
                            intent4.putExtra("Is_Chatroom", booleanExtra2);
                            startActivity(intent4);
                            return;
                        }
                        return;
                    case 225:
                        r0 = intent.getStringExtra("enterprise_biz_name");
                        long longExtra2 = intent.getLongExtra("key_biz_chat_id", -1);
                        ct ctVar = this.oug;
                        z.a(ctVar.omY, ctVar, r0, longExtra2);
                        return;
                    case 226:
                        SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                        if (sightCaptureResult == null) {
                            return;
                        }
                        boolean z2;
                        if (sightCaptureResult.lTX) {
                            str3 = sightCaptureResult.lUf;
                            if (!be.kS(str3)) {
                                try {
                                    z2 = sightCaptureResult.lTY;
                                    v.i("MicroMsg.ChattingUI", "doSendChattingImage, path: %s", str3);
                                    ak.vy().a(new com.tencent.mm.ae.k(z2 ? 2 : 1, com.tencent.mm.model.k.xF(), this.bhV.field_username, str3, 0, null, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, 2130837922), 0);
                                    return;
                                } catch (Exception e) {
                                    v.e("MicroMsg.ChattingUI", "doSendChattingImage error: %s", e.getMessage());
                                    return;
                                }
                            }
                            return;
                        }
                        v.i("MicroMsg.ChattingUI", "video path %s thumb path ", sightCaptureResult.lTZ, sightCaptureResult.lUa);
                        com.tencent.mm.as.k.KV();
                        str = o.lc(sightCaptureResult.lUb);
                        if (!sightCaptureResult.lTZ.equals(str)) {
                            v.i("MicroMsg.ChattingUI", "filepath not videopath and move it %s %s", sightCaptureResult.lTZ, str);
                            FileOp.ab(sightCaptureResult.lTZ, str);
                        }
                        str2 = sightCaptureResult.lUb;
                        int i3 = sightCaptureResult.lUd;
                        wP = this.bhV.field_username;
                        ahn com_tencent_mm_protocal_c_ahn = sightCaptureResult.lUe;
                        n nVar = new n();
                        nVar.aST = str2;
                        nVar.dhK = i3;
                        nVar.ble = wP;
                        ak.yW();
                        nVar.dhC = (String) com.tencent.mm.model.c.vf().get(2, SQLiteDatabase.KeyEmpty);
                        nVar.dhH = be.Nh();
                        nVar.dhI = be.Nh();
                        nVar.dhU = com_tencent_mm_protocal_c_ahn;
                        nVar.dhO = 0;
                        nVar.dhR = 1;
                        com.tencent.mm.as.k.KV();
                        i3 = o.le(o.lc(str2));
                        if (i3 <= 0) {
                            v.e("MicroMsg.VideoLogic", "get Video size failed :" + str2);
                            z2 = false;
                        } else {
                            nVar.cyu = i3;
                            com.tencent.mm.as.k.KV();
                            str = o.ld(str2);
                            int le = o.le(str);
                            if (le <= 0) {
                                v.e("MicroMsg.VideoLogic", "get Thumb size failed :" + str + " size:" + le);
                                z2 = false;
                            } else {
                                nVar.dhG = le;
                                v.i("MicroMsg.VideoLogic", "prepareMMSightRecord file:" + str2 + " thumbsize:" + nVar.dhG + " videosize:" + nVar.cyu);
                                nVar.status = MMGIFException.D_GIF_ERR_READ_FAILED;
                                at atVar = new at();
                                atVar.cH(nVar.Ld());
                                atVar.setType(43);
                                atVar.di(1);
                                atVar.cI(str2);
                                atVar.dh(1);
                                atVar.z(aw.fN(nVar.Ld()));
                                nVar.dhL = (int) aw.e(atVar);
                                z2 = com.tencent.mm.as.k.KV().a(nVar);
                            }
                        }
                        if (z2) {
                            com.tencent.mm.as.p.lk(sightCaptureResult.lUb);
                            return;
                        } else {
                            v.e("MicroMsg.ChattingUI", "prepareMMSightRecord failed");
                            return;
                        }
                    case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                        peVar = new com.tencent.mm.e.a.bx();
                        peVar.aZs.aZt = i;
                        peVar.aZs.aKK = i2;
                        peVar.aZs.aZu = intent;
                        com.tencent.mm.sdk.c.a.nhr.z(peVar);
                        return;
                    case MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK /*2002*/:
                        if (intent.getBooleanExtra("kfavorite", false)) {
                            bp bpVar = new bp();
                            com.tencent.mm.pluginsdk.model.d.a(bpVar, intent);
                            bpVar.aZd.og = this;
                            bpVar.aZd.aZl = 42;
                            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                            return;
                        }
                        return;
                    default:
                        v.e("MicroMsg.ChattingUI", "onActivityResult: not found this requestCode");
                        return;
                }
            } else if (i == 200 || i == 201 || i == 203) {
                this.hjH.clearFocus();
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void run() {
                        com.tencent.mm.sdk.c.b peVar = new pe();
                        peVar.bqy.bqA = true;
                        com.tencent.mm.sdk.c.a.nhr.z(peVar);
                    }
                });
            }
        }

        public static void m(String str, String str2, boolean z) {
            if (z) {
                ak.vy().a(new com.tencent.mm.modelmulti.i(be.ah(str2, SQLiteDatabase.KeyEmpty), com.tencent.mm.ui.contact.u.Pj(str), 42), 0);
                return;
            }
            List g = be.g(be.ah(str2, SQLiteDatabase.KeyEmpty).split(","));
            String Pj = com.tencent.mm.ui.contact.u.Pj(str);
            for (int i = 0; i < g.size(); i++) {
                ak.vy().a(new com.tencent.mm.modelmulti.i((String) g.get(i), Pj, 42), 0);
            }
        }

        private void Z(Intent intent) {
            v.d("MicroMsg.ChattingUI", "sendVedioFromCustomRecord");
            if (intent == null) {
                v.e("MicroMsg.ChattingUI", "data == null");
                return;
            }
            String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
            String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
            int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
            v.e("MicroMsg.ChattingUI", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
            if (!be.kS(stringExtra) && !be.kS(stringExtra2) && intExtra >= 0) {
                if (stringExtra.equals("medianote") && (com.tencent.mm.model.k.xJ() & 16384) == 0) {
                    n nVar = new n();
                    nVar.aST = stringExtra2;
                    nVar.dhK = intExtra;
                    nVar.ble = stringExtra;
                    ak.yW();
                    nVar.dhC = (String) com.tencent.mm.model.c.vf().get(2, SQLiteDatabase.KeyEmpty);
                    nVar.dhH = be.Nh();
                    nVar.dhI = be.Nh();
                    nVar.dhE = intExtra;
                    nVar.dgC = intExtra;
                    com.tencent.mm.as.k.KV();
                    int le = o.le(o.lc(stringExtra2));
                    if (le <= 0) {
                        v.e("MicroMsg.VideoLogic", "get Video size failed :" + stringExtra2);
                        return;
                    }
                    nVar.cyu = le;
                    com.tencent.mm.as.k.KV();
                    stringExtra = o.ld(stringExtra2);
                    intExtra = o.le(stringExtra);
                    if (intExtra <= 0) {
                        v.e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                        return;
                    }
                    nVar.dhG = intExtra;
                    v.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + nVar.dhG + " videosize:" + nVar.cyu);
                    nVar.status = 199;
                    at atVar = new at();
                    atVar.cH(nVar.Ld());
                    atVar.setType(43);
                    atVar.di(1);
                    atVar.cI(stringExtra2);
                    atVar.dh(2);
                    atVar.z(aw.fN(nVar.Ld()));
                    nVar.dhL = (int) aw.e(atVar);
                    com.tencent.mm.as.k.KV().a(nVar);
                    return;
                }
                com.tencent.mm.as.p.b(stringExtra2, intExtra, stringExtra, null);
                com.tencent.mm.as.p.lk(stringExtra2);
                a(true, true, null);
            }
        }

        private void bFN() {
            v.v("MicroMsg.ChattingUI", "send video path: %s", this.otg.toString());
            final Runnable hVar = new com.tencent.mm.pluginsdk.model.h(this.nDR.nEl, this.otg, null, this.bhV.field_username, 2, new com.tencent.mm.pluginsdk.model.h.a(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void bmV() {
                    if (this.ovO.dwg != null) {
                        this.ovO.dwg.dismiss();
                        this.ovO.dwg = null;
                    }
                }
            });
            Context context = this.nDR.nEl;
            vN(2131231164);
            this.dwg = com.tencent.mm.ui.base.g.a(context, vN(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ a ovO;

                public final void onCancel(DialogInterface dialogInterface) {
                    hVar.bmS();
                }
            });
            com.tencent.mm.sdk.i.e.a(hVar, "ChattingUI_importMultiVideo");
        }

        private void aa(final Intent intent) {
            v.d("MicroMsg.ChattingUI", "sendVedio");
            if (com.tencent.mm.network.aa.bk(this.nDR.nEl)) {
                D(intent);
            } else {
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131235789, 2131231164, new OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.ovO.D(intent);
                    }
                }, null);
            }
        }

        private void D(Intent intent) {
            final com.tencent.mm.as.a aVar = new com.tencent.mm.as.a();
            aVar.a(this.nDR.nEl, intent, new com.tencent.mm.as.a.a(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void a(int i, String str, String str2, int i2) {
                    if (i == -50002) {
                        Toast.makeText(this.ovO.nDR.nEl, this.ovO.nDR.nEl.getString(2131235788), 0).show();
                    } else if (i < 0) {
                        Toast.makeText(this.ovO.nDR.nEl, this.ovO.nDR.nEl.getString(2131235787), 0).show();
                    } else {
                        com.tencent.mm.as.p.b(str, i2, this.ovO.bhV.field_username, str2);
                        com.tencent.mm.as.p.lk(str);
                    }
                    if (this.ovO.dwg != null) {
                        this.ovO.dwg.dismiss();
                        this.ovO.dwg = null;
                    }
                }
            });
            Context context = this.nDR.nEl;
            vN(2131231164);
            this.dwg = com.tencent.mm.ui.base.g.a(context, vN(2131231182), true, new OnCancelListener(this) {
                final /* synthetic */ a ovO;

                public final void onCancel(DialogInterface dialogInterface) {
                    aVar.dgj = null;
                }
            });
        }

        private void a(Intent intent, String str, ArrayList<String> arrayList, ArrayList<Integer> arrayList2) {
            if (intent == null || arrayList == null || arrayList.size() == 0) {
                v.e("MicroMsg.ChattingUI", "filelist is empty!");
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
            boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
            if (booleanExtra2) {
                g.iuh.h(11095, Integer.valueOf(1));
            } else {
                g.iuh.h(11095, Integer.valueOf(0));
            }
            int intExtra = intent.getIntExtra("CropImage_rotateCount", 0);
            v.i("MicroMsg.ChattingUI", "dkimgsource source:%d  isTakePhoto:%b rotateCount:%d compressImg:%b rawUserName:%s", Integer.valueOf(3), Boolean.valueOf(booleanExtra), Integer.valueOf(intExtra), Boolean.valueOf(booleanExtra2), this.onj);
            String str2;
            if (this.olR == null || this.olR.aeX()) {
                if (booleanExtra) {
                    LatLongData latLongData = (LatLongData) intent.getParcelableExtra("KlatLng");
                    if (latLongData != null) {
                        v.d("MicroMsg.ChattingUI", "latLongData %f %f", Float.valueOf(latLongData.bhs), Float.valueOf(latLongData.cNt));
                        g gVar = g.iuh;
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf((int) (latLongData.bhs * 1000000.0f));
                        objArr[1] = Integer.valueOf((int) (latLongData.cNt * 1000000.0f));
                        objArr[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                        objArr[3] = Integer.valueOf(1);
                        gVar.h(11345, objArr);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                int sH = com.tencent.mm.h.b.sH();
                int sJ = com.tencent.mm.h.b.sJ();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    str2 = (String) it.next();
                    if (str2 == null || str2.equals(SQLiteDatabase.KeyEmpty) || !com.tencent.mm.a.e.aR(str2)) {
                        v.d("MicroMsg.ChattingUI", " doSendImage : filePath is null or empty");
                    } else {
                        if (!booleanExtra) {
                            LatLongData JR = ExifHelper.JR(str2);
                            if (JR != null) {
                                v.i("MicroMsg.ChattingUI", "latLongData %f %f", Float.valueOf(JR.bhs), Float.valueOf(JR.cNt));
                                g gVar2 = g.iuh;
                                Object[] objArr2 = new Object[4];
                                objArr2[0] = Integer.valueOf((int) (JR.bhs * 1000000.0f));
                                objArr2[1] = Integer.valueOf((int) (JR.cNt * 1000000.0f));
                                objArr2[2] = Integer.valueOf(booleanExtra ? 1 : 2);
                                objArr2[3] = Integer.valueOf(1);
                                gVar2.h(11345, objArr2);
                            } else {
                                v.d("MicroMsg.ChattingUI", "cannot get location");
                            }
                        }
                        long aQ = (long) com.tencent.mm.a.e.aQ(str2);
                        if (com.tencent.mm.sdk.platformtools.o.JZ(str2) && this.hjH != null && this.hjH.lGn != null && (this.hjH.lGn instanceof cw)) {
                            if (u.dW(str)) {
                                v.i("MicroMsg.ChattingUI", "tummy, add gif msg filePath");
                                arrayList4.add(str2);
                            } else if (aQ <= ((long) sH)) {
                                com.tencent.mm.storage.a.c rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(com.tencent.mm.a.g.aX(str2));
                                if (rg == null) {
                                    rg = com.tencent.mm.pluginsdk.j.a.bmr().rg(com.tencent.mm.pluginsdk.j.a.bmr().rh(str2));
                                }
                                if (rg != null) {
                                    ((cw) this.hjH.lGn).n(rg);
                                    g.iuh.h(13459, Long.valueOf(aQ), Integer.valueOf(0), rg.EB(), Integer.valueOf(0));
                                } else {
                                    v.w("MicroMsg.ChattingUI", "emoji is null");
                                }
                                v.i("MicroMsg.ChattingUI", "cpan send custom emoji.");
                            } else if (aQ <= ((long) sJ)) {
                                String a = com.tencent.mm.pluginsdk.j.a.bmr().a(this.nDR.nEl, new WXMediaMessage(new WXEmojiObject(str2)), null);
                                if (a != null) {
                                    ((cw) this.hjH.lGn).o(com.tencent.mm.pluginsdk.j.a.bmr().rg(a));
                                }
                                g.iuh.h(13459, Long.valueOf(aQ), Integer.valueOf(0), a, Integer.valueOf(0));
                                v.i("MicroMsg.ChattingUI", "cpan send app emoji msg.");
                            } else {
                                v.i("MicroMsg.ChattingUI", "cpan emoji is too large, ignore.");
                            }
                        }
                        arrayList3.add(str2);
                    }
                }
                if (!bFJ()) {
                    int i = 98;
                    if (booleanExtra) {
                        i = intent.getBooleanExtra("is_long_click", false) ? 99 : 97;
                    }
                    g.iuh.a(106, (long) i, 1, false);
                    g.iuh.a(106, booleanExtra2 ? 94 : 95, 1, false);
                    if (arrayList3.size() > 0) {
                        if (arrayList2 == null || arrayList2.size() <= 0) {
                            com.tencent.mm.ae.n.GF().a(bFR(), str, arrayList3, intExtra, booleanExtra2);
                        } else {
                            com.tencent.mm.ae.n.GF().a(arrayList2, bFR(), str, arrayList3, intExtra, booleanExtra2);
                        }
                    }
                    if (arrayList4.size() > 0) {
                        com.tencent.mm.ae.n.GF().a(bFR(), str, arrayList4, intExtra, booleanExtra2);
                    }
                    a(true, true, null);
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void run() {
                            this.ovO.bCe();
                        }
                    });
                    return;
                }
                return;
            }
            Context context = this.nDR.nEl;
            if (this.olR.nwC.Nq(SQLiteDatabase.KeyEmpty).equalsIgnoreCase("@t.qq.com")) {
                str2 = vN(2131232925);
            } else {
                str2 = d(2131232923, com.tencent.mm.i.a.dK(this.olR.name));
            }
            com.tencent.mm.ui.base.g.A(context, str2, vN(2131231164));
        }

        public final void bCe() {
            if (this.onh != null) {
                this.onh.notifyDataSetChanged();
            }
        }

        protected boolean bDP() {
            boolean z = false;
            v.d("MicroMsg.ChattingUI", "writeOpLogAndMarkRead :" + bEn());
            if (u.LH(bEn())) {
                ak.yW();
                Cursor MR = com.tencent.mm.model.c.wJ().MR(bEn());
                MR.moveToFirst();
                while (!MR.isAfterLast()) {
                    bx atVar = new at();
                    atVar.b(MR);
                    if (atVar.field_type != 34) {
                        atVar.dh(4);
                        v.d("MicroMsg.ChattingUI", "writeOpLog: msgSvrId = " + atVar.field_msgSvrId + " status = " + atVar.field_status);
                    }
                    MR.moveToNext();
                    z = true;
                }
                MR.close();
                if (!z) {
                    return z;
                }
                ak.yW();
                com.tencent.mm.model.c.wK().Mj(bEn());
                ak.yW();
                com.tencent.mm.model.c.wJ().MP(bEn());
                return z;
            }
            if (!this.bhV.bvm() || this.exj == null) {
                if (u.LJ(bEn())) {
                    int a;
                    List list = this.oup;
                    if (ak.uz()) {
                        if ((com.tencent.mm.model.k.xJ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                            if (list == null) {
                                list = new ArrayList();
                            }
                            if (!list.contains("floatbottle")) {
                                list.add("floatbottle");
                            }
                            a = com.tencent.mm.model.n.a(m.crA, list);
                        } else {
                            a = com.tencent.mm.model.n.a(m.crA, list);
                        }
                        if (a != com.tencent.mm.ui.conversation.d.oMA) {
                            v.i("MicroMsg.UnreadCountHelper", "unreadcheck wrong should be %d, but is %d", Integer.valueOf(a), Integer.valueOf(com.tencent.mm.ui.conversation.d.oMA));
                            com.tencent.mm.ui.conversation.d.oMA = -1;
                        }
                    } else {
                        v.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
                        a = 0;
                    }
                    ak.yW();
                    com.tencent.mm.storage.ab Mh = com.tencent.mm.model.c.wK().Mh("qmessage");
                    if (Mh == null || be.kS(Mh.field_username)) {
                        v.e("MicroMsg.ChattingUI", "update Unread: can not find QMessage");
                    } else {
                        Mh.df(Mh.field_unReadCount - a);
                        ak.yW();
                        if (com.tencent.mm.model.c.wK().a(Mh, Mh.field_username, true) == -1) {
                            v.e("MicroMsg.ChattingUI", "update qmessage unread failed");
                        }
                    }
                }
            } else if (this.lKa) {
                return com.tencent.mm.modelbiz.u.DB().V(bFS());
            } else {
                af Ms;
                if (this.exj.CA()) {
                    if (!(this.exj.aX(false) == null || this.exj.aX(false).CZ() == null || be.kS(this.exj.CF()))) {
                        ak.yW();
                        com.tencent.mm.model.c.wK();
                        Ms = com.tencent.mm.storage.ac.Ms(this.exj.CF());
                        if (Ms != null && Ms.field_username.equals(bEn()) && Ms.field_unReadCount > 0) {
                            if (getIntExtra("chat_from_scene", 0) == 2) {
                                return false;
                            }
                            ak.yW();
                            com.tencent.mm.model.c.wK().Mj(this.exj.CF());
                        }
                    }
                } else if (!(this.exj.Cw() || this.exj.Cy())) {
                    ak.yW();
                    com.tencent.mm.model.c.wK();
                    Ms = com.tencent.mm.storage.ac.bvN();
                    if (Ms != null && Ms.field_username.equals(bEn()) && Ms.field_unReadCount > 0) {
                        ak.yW();
                        com.tencent.mm.model.c.wK().Mj("officialaccounts");
                    }
                }
            }
            ak.yW();
            return com.tencent.mm.model.c.wK().Mj(bEn());
        }

        public final void aw(at atVar) {
            if (!this.ovC.contains(Long.valueOf(atVar.field_msgSvrId))) {
                this.ovC.add(Long.valueOf(atVar.field_msgSvrId));
                com.tencent.mm.sdk.i.e.a(new AnonymousClass10(this, atVar, false), "ChattingUI.adVideoExposeReport");
            }
        }

        public final void ax(final at atVar) {
            if (!this.ovD.contains(Long.valueOf(atVar.field_msgSvrId))) {
                this.ovD.add(Long.valueOf(atVar.field_msgSvrId));
                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    public final void run() {
                        com.tencent.mm.modelstat.a.a(atVar, com.tencent.mm.modelstat.a.a.Expose);
                    }
                }, "ChattingUI.expExposeReport");
            }
        }

        public final void ay(final at atVar) {
            if (!this.ovG) {
                this.ovG = true;
                com.tencent.mm.storage.c Ls = com.tencent.mm.model.c.c.Au().Ls(ovH);
                if (Ls.isValid()) {
                    this.ovF = com.tencent.mm.platformtools.t.getInt((String) Ls.buX().get("needUploadData"), 0);
                }
            }
            if (this.ovF != 0 && !this.ovE.contains(Long.valueOf(atVar.field_msgSvrId))) {
                com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    public final void run() {
                        a.g(this.ovO, atVar);
                    }
                }, "ChattingUI.appExposeReport");
            }
        }

        public final void finish() {
            ale();
            com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void run() {
                    boolean z = true;
                    if (this.ovO.nAV) {
                        super.finish();
                    } else if (this.ovO.bzo() instanceof LauncherUI) {
                        LauncherUI launcherUI = (LauncherUI) this.ovO.bzo();
                        if (launcherUI != null) {
                            if (this.ovO.bAm()) {
                                z = false;
                            }
                            launcherUI.iP(z);
                        }
                    } else if (this.ovO.bzo() instanceof BaseConversationUI) {
                        BaseConversationUI baseConversationUI = (BaseConversationUI) this.ovO.bzo();
                        if (baseConversationUI != null) {
                            if (this.ovO.bAm()) {
                                z = false;
                            }
                            baseConversationUI.iP(z);
                        }
                    }
                }
            }, 100);
        }

        public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
            v.i("MicroMsg.ChattingUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " sceneType:" + kVar.getType());
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            if (this.otG != null) {
                this.otG.dismiss();
                this.otG = null;
            }
            if (bFD()) {
                v.i("MicroMsg.ChattingUI", "onSceneEnd fragment not foreground, return");
            } else if (!be.bm(this.nDR.nEl)) {
            } else {
                if (10 == kVar.getType() || !k(i, i2, str)) {
                    if (i == 0 && i2 == 0) {
                        switch (kVar.getType()) {
                            case 10:
                                com.tencent.mm.modelsimple.j jVar = (com.tencent.mm.modelsimple.j) kVar;
                                if (!(jVar.cYw == null || !jVar.cYw.equals(bEn()) || this.onc || this.otU || this.otY)) {
                                    if (jVar.content != null && jVar.content.length == 4) {
                                        int c = com.tencent.mm.a.n.c(jVar.content, 0);
                                        v.d("MicroMsg.ChattingUI", "directsend: status=" + c);
                                        switch (c) {
                                            case 1:
                                                this.otk = true;
                                                vD(2131231903);
                                                this.handler.sendMessageDelayed(new Message(), 15000);
                                                com.tencent.mm.sdk.c.a.nhr.z(new kr());
                                                break;
                                            case 3:
                                                this.otk = true;
                                                vD(2131231904);
                                                this.handler.sendMessageDelayed(new Message(), 15000);
                                                break;
                                            default:
                                                this.otk = false;
                                                bDM();
                                                bCe();
                                                break;
                                        }
                                    }
                                    v.e("MicroMsg.ChattingUI", "unknown directsend op");
                                    return;
                                }
                                break;
                            case 127:
                                com.tencent.mm.modelvoice.p lJ = com.tencent.mm.modelvoice.m.Lz().lJ(((com.tencent.mm.modelvoice.f) kVar).aST);
                                if (lJ != null && lJ.status == 99) {
                                    ao.T(this.nDR.nEl, 2131230886);
                                    break;
                                }
                            case 137:
                                List list = ((com.tencent.mm.pluginsdk.model.m) kVar).lzD;
                                if (list == null || list.contains(this.bhV.field_username)) {
                                    ChattingUI.Q(this.bhV);
                                    break;
                                }
                            case 551:
                                v.i("MicroMsg.ChattingUI", "cpan[refresh top btn]");
                                this.nGj = i.ef(bEn());
                                bDN();
                                break;
                            case 594:
                                arc Ju = ((com.tencent.mm.modelsimple.v) kVar).Ju();
                                if (!be.kS(Ju.mQs)) {
                                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, Ju.mQs, SQLiteDatabase.KeyEmpty, vN(2131231875), new OnClickListener(this) {
                                        final /* synthetic */ a ovO;

                                        {
                                            this.ovO = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            if (dialogInterface != null) {
                                                dialogInterface.dismiss();
                                            }
                                        }
                                    });
                                    break;
                                }
                                break;
                            case 610:
                                bx bxVar = ((com.tencent.mm.plugin.chatroom.c.k) kVar).bmk;
                                bxVar.bwA();
                                ak.yW();
                                com.tencent.mm.model.c.wJ().b(bxVar.field_msgSvrId, bxVar);
                                Toast.makeText(this.nDR.nEl, vN(2131233325), 0).show();
                                g.iuh.a(219, 24, (long) ((com.tencent.mm.plugin.chatroom.c.k) kVar).eOX, true);
                                break;
                        }
                    }
                    if (i2 == -49) {
                        if (this.our == null) {
                            this.our = new com.tencent.mm.ui.bindqq.b(this.nDR.nEl, new com.tencent.mm.ui.bindqq.b.a(this) {
                                final /* synthetic */ a ovO;

                                {
                                    this.ovO = r1;
                                }

                                public final boolean q(int i, int i2, String str) {
                                    return this.ovO.k(i, i2, str);
                                }

                                public final void bDr() {
                                }
                            });
                        }
                        this.our.bDs();
                    } else if (kVar.getType() == MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM) {
                        com.tencent.mm.ui.base.g.f(this.nDR.nEl, 2131231798, 2131231164);
                    } else if (this.onm && i2 == -21) {
                        this.otM = true;
                    }
                    if (kVar.getType() == 594) {
                        boolean z;
                        arc Ju2 = ((com.tencent.mm.modelsimple.v) kVar).Ju();
                        v.d("MicroMsg.ChattingUI", "[oneliang][revokeMsgTimeout] sysWording:%s", Ju2.mQt);
                        if (i2 == 0 || be.kS(Ju2.mQt)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            v.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] errorCode:%s,sysWording:%s", Integer.valueOf(i2), Ju2.mQt);
                            this.otG = com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131231876), SQLiteDatabase.KeyEmpty, vN(2131231875), new OnClickListener(this) {
                                final /* synthetic */ a ovO;

                                {
                                    this.ovO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.ovO.otG != null) {
                                        this.ovO.otG.dismiss();
                                    }
                                }
                            });
                        } else {
                            v.d("MicroMsg.ChattingUI", "[oneliang][revokeMsg] sysWording:%s", Ju2.mQt);
                            this.otG = com.tencent.mm.ui.base.g.a(this.nDR.nEl, Ju2.mQt, SQLiteDatabase.KeyEmpty, vN(2131231875), new OnClickListener(this) {
                                final /* synthetic */ a ovO;

                                {
                                    this.ovO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (this.ovO.otG != null) {
                                        this.ovO.otG.dismiss();
                                    }
                                }
                            });
                        }
                    }
                    if (kVar.getType() == 610) {
                        v.d("MicroMsg.ChattingUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(610), Integer.valueOf(i2), Integer.valueOf(i), be.ma(str));
                        com.tencent.mm.ui.base.g.A(this.nDR.nEl, getString(2131233323), getString(2131231164));
                    }
                    kVar.getType();
                }
            }
        }

        public final void a(int i, com.tencent.mm.v.k kVar) {
            if (kVar.getType() == 1357) {
                if (this.dwg != null) {
                    this.dwg.dismiss();
                    this.dwg = null;
                }
                if (i != 0) {
                    Toast.makeText(aa.getContext(), vN(2131234571), 0).show();
                }
            }
        }

        public final void bFO() {
            Intent intent = new Intent();
            g.iuh.h(12809, Integer.valueOf(1), SQLiteDatabase.KeyEmpty);
            intent.putExtra("map_view_type", 0);
            intent.putExtra("map_sender_name", bFR());
            intent.putExtra("map_talker_name", bEn());
            com.tencent.mm.ay.c.b(this.nDR.nEl, "location", ".ui.RedirectUI", intent);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void bFP() {
            /*
            r5 = this;
            r1 = 1;
            r0 = r5.nDR;
            r0 = r0.nEl;
            r0 = com.tencent.mm.as.u.bj(r0);
            if (r0 != 0) goto L_0x0037;
        L_0x000b:
            r0 = r5.nDR;
            r0 = r0.nEl;
            r0 = com.tencent.mm.ah.a.aT(r0);
            if (r0 != 0) goto L_0x0037;
        L_0x0015:
            r0 = com.tencent.mm.pluginsdk.j.a.lxR;
            r2 = r5.bhV;
            r2 = r2.field_username;
            r0 = r0.wH(r2);
            if (r0 == 0) goto L_0x0038;
        L_0x0021:
            r0 = "MicroMsg.ChattingUI";
            r1 = "click share location, but now is in multitalk!";
            com.tencent.mm.sdk.platformtools.v.i(r0, r1);
            r0 = r5.nDR;
            r0 = r0.nEl;
            r1 = 2131233928; // 0x7f080c88 float:1.8084007E38 double:1.052969467E-314;
            r2 = 2131231164; // 0x7f0801bc float:1.8078401E38 double:1.0529681015E-314;
            com.tencent.mm.ui.base.g.f(r0, r1, r2);
        L_0x0037:
            return;
        L_0x0038:
            r0 = 0;
            r2 = new com.tencent.mm.e.a.pd;
            r2.<init>();
            r3 = com.tencent.mm.pluginsdk.j.a.lxG;
            if (r3 == 0) goto L_0x005c;
        L_0x0042:
            r3 = r2.bqt;
            r3.bqv = r1;
            r3 = com.tencent.mm.sdk.c.a.nhr;
            r3.z(r2);
            r2 = r2.bqu;
            r2 = r2.bqx;
            r2 = com.tencent.mm.sdk.platformtools.be.kS(r2);
            if (r2 != 0) goto L_0x00ae;
        L_0x0055:
            r0 = 2131232450; // 0x7f0806c2 float:1.808101E38 double:1.052968737E-314;
            r0 = r5.vN(r0);
        L_0x005c:
            r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);
            if (r2 != 0) goto L_0x00c2;
        L_0x0062:
            r2 = 0;
            r3 = com.tencent.mm.pluginsdk.j.a.lxQ;
            if (r3 == 0) goto L_0x00ca;
        L_0x0067:
            r3 = com.tencent.mm.pluginsdk.j.a.lxQ;
            r4 = r5.bhV;
            r4 = r4.field_username;
            r3 = r3.vJ(r4);
            if (r3 == 0) goto L_0x00ca;
        L_0x0073:
            r3 = com.tencent.mm.pluginsdk.j.a.lxQ;
            r4 = r5.bhV;
            r4 = r4.field_username;
            r3 = r3.vH(r4);
            if (r3 == 0) goto L_0x00ca;
        L_0x007f:
            r4 = r5.bFR();
            r3 = r3.contains(r4);
            if (r3 == 0) goto L_0x00ca;
        L_0x0089:
            if (r1 != 0) goto L_0x00c2;
        L_0x008b:
            r1 = new com.tencent.mm.ui.base.h$a;
            r2 = r5.nDR;
            r2 = r2.nEl;
            r1.<init>(r2);
            r1.Oq(r0);
            r0 = 2131233285; // 0x7f080a05 float:1.8082703E38 double:1.0529691494E-314;
            r0 = r1.wp(r0);
            r2 = new com.tencent.mm.ui.chatting.ChattingUI$a$20;
            r2.<init>(r5);
            r0.a(r2);
            r0 = r1.RX();
            r0.show();
            goto L_0x0037;
        L_0x00ae:
            r2 = com.tencent.mm.pluginsdk.j.a.lxG;
            r3 = r5.bhV;
            r3 = r3.field_username;
            r2 = r2.CB(r3);
            if (r2 == 0) goto L_0x005c;
        L_0x00ba:
            r0 = 2131232451; // 0x7f0806c3 float:1.8081012E38 double:1.0529687373E-314;
            r0 = r5.vN(r0);
            goto L_0x005c;
        L_0x00c2:
            r0 = "fromPluginLocation";
            r5.OX(r0);
            goto L_0x0037;
        L_0x00ca:
            r1 = r2;
            goto L_0x0089;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingUI.a.bFP():void");
        }

        final boolean bFQ() {
            if (this.bhV.bvm() || m.fk(bEn()) || u.LH(bEn()) || u.LJ(bEn()) || u.ew(bEn()) || bEn().equals(com.tencent.mm.model.k.xF())) {
                return false;
            }
            return true;
        }

        public final boolean OV(String str) {
            return cg(str, 0);
        }

        private boolean cg(final String str, final int i) {
            if (str == null || str.length() == 0) {
                v.e("MicroMsg.ChattingUI", "doSendMessage null");
                return false;
            }
            cz czVar = this.ovi;
            if (!com.tencent.mm.platformtools.t.kS(str)) {
                at atVar = new at();
                atVar.setContent(str);
                atVar.di(1);
                czVar.aA(atVar);
            }
            this.ovI.aYK.aYM = str;
            this.ovI.aYK.context = this.nDR.nEl;
            com.tencent.mm.sdk.c.a.nhr.z(this.ovI);
            if (this.ovI.aYL.aYN) {
                return true;
            }
            if (this.olR != null) {
                String Nq = this.olR.nwC.Nq(SQLiteDatabase.KeyEmpty);
                if (Nq.equalsIgnoreCase("@t.qq.com") && !this.olR.aeX()) {
                    Nq = vN(2131232925);
                } else if (Nq.equalsIgnoreCase("@qqim") && (com.tencent.mm.model.k.xJ() & 64) == 0) {
                    Nq = vN(2131232924);
                } else if (this.olR.aeX()) {
                    Nq = null;
                } else {
                    Nq = d(2131232923, com.tencent.mm.i.a.dK(this.olR.name));
                }
                if (Nq != null) {
                    com.tencent.mm.ui.base.g.A(this.nDR.nEl, Nq, vN(2131231164));
                    return false;
                }
            }
            this.handler.post(new Runnable(this) {
                final /* synthetic */ a ovO;

                public final void run() {
                    com.tencent.mm.ar.h hVar = null;
                    com.tencent.mm.plugin.report.service.f.oR(20);
                    if (this.ovO.bFJ()) {
                        this.ovO.bFR();
                        ak.vy().a(new com.tencent.mm.aa.a(this.ovO.bhV.field_username, str), 0);
                        return;
                    }
                    String ax;
                    if (this.ovO.onh.getCount() == 0 && u.LJ(this.ovO.bEn())) {
                        bl.zQ().b(10076, Integer.valueOf(1));
                    }
                    String bEn = this.ovO.bEn();
                    int fp = m.fp(bEn);
                    String str = str;
                    if (fp == 1) {
                        m.eS(bEn);
                    }
                    if (this.ovO.lMy) {
                        v.i("MicroMsg.ChattingUI", "[oneliang]encrypt:" + this.ovO.bhj + ",raw:" + this.ovO.onj);
                        ax = be.kS(this.ovO.bhj) ? this.ovO.onj : this.ovO.bhj;
                    } else {
                        ax = bEn;
                    }
                    com.tencent.mm.v.k iVar = new com.tencent.mm.modelmulti.i(ax, str, fp);
                    if (this.ovO.lMy) {
                        ax = this.ovO.enX;
                        com.tencent.mm.ar.i KE = com.tencent.mm.ar.l.KE();
                        str = this.ovO.bhj;
                        Cursor rawQuery = KE.cie.rawQuery("SELECT * FROM " + KE.getTableName() + " where sayhiencryptuser=? and isSend=0 and flag=0" + " ORDER BY createtime desc LIMIT 1", new String[]{str});
                        if (rawQuery != null) {
                            if (rawQuery.getCount() != 1) {
                                rawQuery.close();
                            } else {
                                rawQuery.moveToFirst();
                                hVar = new com.tencent.mm.ar.h();
                                hVar.b(rawQuery);
                                rawQuery.close();
                            }
                        }
                        if (!(hVar == null || be.kS(hVar.field_ticket))) {
                            ax = hVar.field_ticket;
                        }
                        if (be.kS(ax)) {
                            hVar = com.tencent.mm.ar.l.KE().kL(this.ovO.bhj);
                            if (!(hVar == null || be.kS(hVar.field_ticket))) {
                                ax = hVar.field_ticket;
                            }
                        }
                        if (ax != null) {
                            iVar.cRz = new com.tencent.mm.plugin.bbom.f(ax);
                        }
                    }
                    ak.vy().a(iVar, 0);
                    if (m.fl(bEn)) {
                        ak.vy().a(new com.tencent.mm.pluginsdk.model.l(com.tencent.mm.compatible.d.p.rY(), str + " key " + az.bxj() + " local key " + az.bxi() + "NetType:" + com.tencent.mm.sdk.platformtools.ak.getNetTypeString(this.ovO.nDR.nEl.getApplicationContext()) + " hasNeon: " + com.tencent.mm.compatible.d.m.rD() + " isArmv6: " + com.tencent.mm.compatible.d.m.rF() + " isArmv7: " + com.tencent.mm.compatible.d.m.rE()), 0);
                    }
                }
            });
            a(true, true, null);
            return true;
        }

        public final String bFR() {
            v.d("MicroMsg.ChattingUI", "getSender " + (this.olR == null) + " " + (this.olR == null ? com.tencent.mm.model.k.xF() : this.olR.name));
            return this.olR == null ? com.tencent.mm.model.k.xF() : this.olR.name;
        }

        public final String bEn() {
            if (u.ew(this.bhV.field_username)) {
                return this.onj;
            }
            return this.bhV == null ? null : this.bhV.field_username;
        }

        public final long bFS() {
            return this.ogZ == null ? -1 : this.ogZ.field_bizChatLocalId;
        }

        protected final void bFT() {
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void run() {
                    if (this.ovO.lKa && this.ovO.onh != null && !this.ovO.onh.oqD) {
                        com.tencent.mm.modelbiz.a.e.e(this.ovO.ogZ);
                    }
                }
            }, 500);
        }

        public final String bFU() {
            if (this.lKa) {
                if (this.otJ) {
                    if (this.ogZ == null) {
                        return null;
                    }
                    return this.ogZ.field_chatName;
                } else if (this.hVf != null) {
                    return this.hVf.field_userName;
                } else {
                    return null;
                }
            } else if (this.bhV != null) {
                return this.bhV.field_nickname;
            } else {
                return null;
            }
        }

        public final String OW(String str) {
            if (!TextUtils.isEmpty(str) && str.contains("http://weixin.qq.com/emoticonstore/")) {
                String substring = str.substring(str.lastIndexOf("/") + 1);
                if (com.tencent.mm.i.a.ei(this.bhV.field_type) && this.bhV.bvm() && this.exj != null) {
                    ExtInfo aX = this.exj.aX(false);
                    if (!(aX == null || TextUtils.isEmpty(aX.CW()) || !substring.contains(aX.CW()))) {
                        return substring;
                    }
                }
            }
            return null;
        }

        private void r(int i, int i2, String str) {
            if (str == null || str.equals(SQLiteDatabase.KeyEmpty) || !com.tencent.mm.a.e.aR(str)) {
                v.d("MicroMsg.ChattingUI", " doSendImage : filePath is null or empty");
            } else if (this.olR != null && !this.olR.aeX()) {
                String vN;
                Context context = this.nDR.nEl;
                if (this.olR.nwC.Nq(SQLiteDatabase.KeyEmpty).equalsIgnoreCase("@t.qq.com")) {
                    vN = vN(2131232925);
                } else {
                    vN = d(2131232923, com.tencent.mm.i.a.dK(this.olR.name));
                }
                com.tencent.mm.ui.base.g.A(context, vN, vN(2131231164));
            } else if (!bFJ()) {
                ak.vy().a(new com.tencent.mm.ae.k(4, bFR(), bEn(), str, i, null, i2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, 2130837922), 0);
                a(true, true, null);
            }
        }

        protected final boolean k(int i, int i2, String str) {
            if (com.tencent.mm.ui.o.a.a(this.nDR.nEl, i, i2, str, 7) || com.tencent.mm.ui.o.a(this.nDR.nEl, i, i2, new Intent().setClass(this.nDR.nEl, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                return true;
            }
            return false;
        }

        public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
            if (bFD()) {
                v.i("MicroMsg.ChattingUI", "onNotifyChange fragment not foreground, return");
                return;
            }
            v.i("MicroMsg.ChattingUI", "onNotifyChange " + str);
            ak.yW();
            com.tencent.mm.e.b.ab LX = com.tencent.mm.model.c.wH().LX(bEn());
            if (LX != null && ((int) LX.chr) != 0) {
                if (be.kS(LX.field_nickname)) {
                    LX.bS(this.bhV.field_nickname);
                }
                this.bhV = LX;
                bDM();
                bCe();
                if (this.otJ) {
                    this.nGj = com.tencent.mm.modelbiz.a.e.d(this.ogZ);
                } else {
                    this.nGj = i.ef(bEn());
                }
                bFu();
            }
        }

        public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
            if (obj == null || !(obj instanceof String)) {
                v.d("MicroMsg.ChattingUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
                return;
            }
            a((String) obj, null);
        }

        public final void fF(String str) {
            if (str != null && !str.equals(bEn())) {
                be.j(this.nDR.nEl, com.tencent.mm.h.a.sx());
            }
        }

        protected final void releaseWakeLock() {
            this.oth.setKeepScreenOn(false);
        }

        public final void jN(boolean z) {
            if (this.oqd == null) {
                v.e("MicroMsg.ChattingUI", "setForceSpeakOff error, autoPlay is null!!!");
            } else if (z) {
                this.oqd.evw = false;
                this.evz = true;
                ak.yW();
                com.tencent.mm.model.c.vf().set(26, Boolean.valueOf(true));
                vM(0);
                bDX();
                Toast.makeText(this.nDR.nEl, vN(2131232917), 0).show();
                this.oqd.bDV();
                vL(2131165193);
            } else {
                this.oqd.evw = true;
                this.evz = false;
                ak.yW();
                com.tencent.mm.model.c.vf().set(26, Boolean.valueOf(false));
                vM(8);
                bDX();
                Toast.makeText(this.nDR.nEl, vN(2131232918), 0).show();
                this.oqd.bDV();
                vL(2131165199);
            }
        }

        public final cp bFV() {
            return this.onh;
        }

        private void bFW() {
            if (this.ovJ != null) {
                v.i("MicroMsg.ChattingUI", "recycle bitmap:%s", this.ovJ.toString());
                this.ovJ.recycle();
            }
        }

        private int bFX() {
            return bAp().getColor(2131689622);
        }

        private void bjR() {
            if (this.onh == null) {
                v.e("MicroMsg.ChattingUI", "initBackground, adapter is not initialized properly");
                return;
            }
            int intValue;
            com.tencent.mm.al.a jt = t.HT().jt(this.bhV.field_username);
            if (jt == null) {
                ak.yW();
                intValue = ((Integer) com.tencent.mm.model.c.vf().get(12311, Integer.valueOf(-2))).intValue();
            } else {
                intValue = jt.cTU;
            }
            if (intValue == -2) {
                setBackgroundColor(bFX());
                if (this.onh == null) {
                    finish();
                    return;
                } else {
                    this.onh.bh(this.nDR.nEl, "chatting/purecolor_chat.xml");
                    return;
                }
            }
            t.HS();
            int aU = com.tencent.mm.al.n.aU(this.nDR.nEl);
            if (intValue == 0) {
                Object obj;
                switch (aU) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        intValue = 2130837982;
                        break;
                    default:
                        obj = -1;
                        break;
                }
                if (obj != -1) {
                    bFW();
                    try {
                        this.ovJ = BitmapFactory.decodeResource(bAq(), 2130837982);
                    } catch (Throwable e) {
                        v.a("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                        throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                    } catch (Throwable th) {
                    }
                    if (this.ovJ == null) {
                        v.e("MicroMsg.ChattingUI", new StringBuilder("setBackground decodeFile fail, bm is null, resId = 2130837982").toString());
                        setBackgroundColor(bAq().getColor(2131689622));
                    } else {
                        if (this.oul == null) {
                            this.oul = (ImageView) findViewById(2131756063);
                        }
                        this.oul.setImageBitmap(this.ovJ);
                    }
                    this.onh.bh(this.nDR.nEl, "chatting/reserved_chat.xml");
                    return;
                }
                return;
            }
            String str;
            com.tencent.mm.al.n HS = t.HS();
            if (intValue > 0) {
                this.onh.OP(HS.aN(intValue, 1) + "chat.xml");
                switch (aU) {
                    case 1:
                        str = HS.aN(intValue, 1) + "horizontal_hdpi.jpg";
                        break;
                    case 2:
                        str = HS.aN(intValue, 1) + "horizontal_ldpi.jpg";
                        break;
                    case 3:
                        str = HS.aN(intValue, 1) + "vertical_hdpi.jpg";
                        break;
                    case 4:
                        str = HS.aN(intValue, 1) + "vertical_ldpi.jpg";
                        break;
                    default:
                        str = null;
                        break;
                }
            }
            this.onh.bh(this.nDR.nEl, "chatting/default_chat.xml");
            str = jt == null ? HS.x("default", aU) : HS.x(bEn(), aU);
            bFW();
            this.ovJ = com.tencent.mm.platformtools.j.lW(str);
            if (this.ovJ == null) {
                v.e("MicroMsg.ChattingUI", "setBackground decodeFile fail, bm is null, path = " + str);
                setBackgroundColor(bFX());
                return;
            }
            if (this.oul == null) {
                this.oul = (ImageView) findViewById(2131756063);
            }
            this.oul.setImageBitmap(this.ovJ);
        }

        private void setBackgroundColor(int i) {
            bFW();
            if (this.oul == null) {
                View findViewById = findViewById(2131755468);
                if (findViewById != null) {
                    findViewById.setBackgroundColor(i);
                    return;
                }
                return;
            }
            this.oul.setImageDrawable(new ColorDrawable(i));
        }

        public final void k(String str, Bitmap bitmap) {
            if (!be.kS(str) && this.oth != null && bitmap != null) {
                this.otl.post(new Runnable(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void run() {
                        if (this.ovO.onh != null) {
                            this.ovO.bCe();
                        }
                    }
                });
            }
        }

        public final void bFY() {
            try {
                if (this.hjH.bqe()) {
                    this.hjH.bqg();
                }
            } catch (Exception e) {
            }
        }

        public void onConfigurationChanged(Configuration configuration) {
            int i = 1;
            super.onConfigurationChanged(configuration);
            v.d("MicroMsg.ChattingUI", "getConfiguration().orientation = " + bAq().getConfiguration().orientation + ", newConfig.orientation = " + configuration.orientation);
            bAq().getConfiguration().orientation = configuration.orientation;
            ChatFooter chatFooter = this.hjH;
            chatFooter.bpH();
            chatFooter.bqi();
            chatFooter.uj(-1);
            chatFooter.lMT = true;
            if (chatFooter.hhM != null) {
                chatFooter.hhM.ahk();
            }
            bjR();
            int i2 = this.ouS != null ? 1 : 0;
            if (this.ouV == null) {
                i = 0;
            }
            if ((i2 & i) != 0) {
                i = com.tencent.mm.compatible.util.a.e(bzo());
                this.ouV.setMinimumHeight(i);
                ViewGroup.LayoutParams layoutParams = this.ouV.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, -1);
                }
                layoutParams.height = i;
                this.ouV.setLayoutParams(layoutParams);
                layoutParams = this.ouS.getLayoutParams();
                layoutParams.height = i;
                this.ouS.setLayoutParams(layoutParams);
            }
            if (this.ouT != null) {
                this.ouT.nFp.FG.onConfigurationChanged(configuration);
            }
        }

        public final void y(String str, String str2, String str3) {
            if (str.equals(this.bhV.field_username)) {
                jO(false);
            }
        }

        public final void Gj(String str) {
            if (str.equals(this.bhV.field_username)) {
                jO(false);
            }
        }

        public final void Gg(String str) {
            if (str.equals(this.bhV.field_username)) {
                jO(false);
            }
        }

        private void a(com.tencent.mm.ui.base.TalkRoomPopupNav.a aVar) {
            if (this.ovK == null) {
                xi(2131756048);
                this.ovK = (TalkRoomPopupNav) findViewById(2131759550);
                if (this.ovK == null) {
                    return;
                }
            }
            if (this.ovK != null) {
                this.ovK.obB = aVar;
            }
        }

        public final void jO(boolean z) {
            if (!m.dE(this.bhV.field_username) || this.nGj) {
                bFZ();
                String str;
                if (com.tencent.mm.pluginsdk.j.a.lxQ != null && com.tencent.mm.pluginsdk.j.a.lxQ.vJ(this.bhV.field_username)) {
                    a(this.ovM);
                    if (this.ovK != null) {
                        List vH = com.tencent.mm.pluginsdk.j.a.lxQ.vH(this.bhV.field_username);
                        str = SQLiteDatabase.KeyEmpty;
                        if (vH == null || !vH.contains(bFR())) {
                            this.ovK.wF(-1);
                            this.ovK.stop();
                            this.ovK.wD(2130839278);
                            if (vH != null && vH.size() == 1) {
                                str = d(2131235688, com.tencent.mm.model.l.er((String) vH.get(0)));
                            } else if (vH != null) {
                                str = d(2131235690, Integer.valueOf(vH.size()));
                            }
                            this.ovK.wE(2131165642);
                        } else {
                            this.ovK.wD(2130839279);
                            str = vN(2131235689);
                            this.ovK.wE(2131165643);
                            this.ovK.wF(2130838493);
                            TalkRoomPopupNav talkRoomPopupNav = this.ovK;
                            if (talkRoomPopupNav.obM == null || talkRoomPopupNav.obN == null) {
                                talkRoomPopupNav.obM = new AlphaAnimation(0.0f, 1.0f);
                                talkRoomPopupNav.obM.setDuration(1000);
                                talkRoomPopupNav.obM.setStartOffset(0);
                                talkRoomPopupNav.obN = new AlphaAnimation(1.0f, 0.0f);
                                talkRoomPopupNav.obN.setDuration(1000);
                                talkRoomPopupNav.obN.setStartOffset(0);
                                talkRoomPopupNav.obM.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                    final /* synthetic */ TalkRoomPopupNav obO;

                                    {
                                        this.obO = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        if (this.obO.obN != null) {
                                            this.obO.obF.startAnimation(this.obO.obN);
                                        }
                                    }
                                });
                                talkRoomPopupNav.obN.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                    final /* synthetic */ TalkRoomPopupNav obO;

                                    {
                                        this.obO = r1;
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        if (this.obO.obM != null) {
                                            this.obO.obF.startAnimation(this.obO.obM);
                                        }
                                    }
                                });
                                talkRoomPopupNav.obF.startAnimation(talkRoomPopupNav.obM);
                            }
                        }
                        this.ovK.setVisibility(0);
                        this.ovK.Ov(str);
                        xn(1);
                        return;
                    }
                    return;
                } else if (com.tencent.mm.pluginsdk.j.a.lxG != null && com.tencent.mm.pluginsdk.j.a.lxG.CB(this.bhV.field_username)) {
                    a(this.ovM);
                    com.tencent.mm.sdk.c.b pdVar = new pd();
                    pdVar.bqt.bqv = true;
                    com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                    if (this.bhV.field_username.equals(pdVar.bqu.bqx)) {
                        this.ovK.wD(2130839279);
                    } else {
                        this.ovK.wD(2130839278);
                    }
                    str = d(2131235631, Integer.valueOf(com.tencent.mm.pluginsdk.j.a.lxG.CC(this.bhV.field_username).size()));
                    this.ovK.wE(2130839296);
                    this.ovK.wF(-1);
                    this.ovK.stop();
                    this.ovK.setVisibility(0);
                    this.ovK.Ov(str);
                    xn(1);
                    return;
                } else if (!m.dE(this.bhV.field_username) || com.tencent.mm.pluginsdk.j.a.lxR == null) {
                    bFZ();
                    return;
                } else {
                    com.tencent.mm.ah.b Rk = com.tencent.mm.pluginsdk.j.a.lxR.Rk(this.bhV.field_username);
                    if (Rk != null && Rk.field_wxGroupId != null && Rk.field_wxGroupId.equals(this.bhV.field_username)) {
                        if (this.ovL == null) {
                            xi(2131756049);
                            this.ovL = (MultiTalkRoomPopupNav) findViewById(2131758368);
                        }
                        if (this.ovL != null) {
                            v.i("MicroMsg.ChattingUI", "show multiTalkBanner! ");
                            this.ovL.nGh = this.bhV.field_username;
                            this.ovL.nGi = bFR();
                            this.ovL.nGj = this.nGj;
                            MultiTalkRoomPopupNav multiTalkRoomPopupNav = this.ovL;
                            multiTalkRoomPopupNav.nGo = false;
                            if (multiTalkRoomPopupNav.nGh == null || multiTalkRoomPopupNav.nGi == null) {
                                v.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.nGh + ",currentSenderUserName:" + multiTalkRoomPopupNav.nGi);
                            } else {
                                String str2 = multiTalkRoomPopupNav.nGh;
                                if (com.tencent.mm.pluginsdk.j.a.lxR == null || !com.tencent.mm.pluginsdk.j.a.lxR.wH(str2)) {
                                    multiTalkRoomPopupNav.bAB();
                                } else {
                                    List wJ = com.tencent.mm.pluginsdk.j.a.lxR.wJ(str2);
                                    if (wJ.size() == 0) {
                                        com.tencent.mm.pluginsdk.j.a.lxR.hc(str2);
                                        multiTalkRoomPopupNav.bAB();
                                    } else {
                                        int cg = com.tencent.mm.pluginsdk.j.a.lxR.cg(str2, multiTalkRoomPopupNav.nGi);
                                        if (cg == 1) {
                                            multiTalkRoomPopupNav.nGk = b.nGs;
                                            if (com.tencent.mm.pluginsdk.j.a.lxR.wK(str2)) {
                                                multiTalkRoomPopupNav.bAB();
                                            } else {
                                                CharSequence er = com.tencent.mm.pluginsdk.j.a.lxR.er(com.tencent.mm.pluginsdk.j.a.lxR.cf(str2, multiTalkRoomPopupNav.nGi));
                                                multiTalkRoomPopupNav.nGd.setBackgroundResource(2130838729);
                                                multiTalkRoomPopupNav.nGf.setTextColor(multiTalkRoomPopupNav.getResources().getColor(2131689890));
                                                multiTalkRoomPopupNav.nGf.setText(er);
                                                multiTalkRoomPopupNav.nGe.setVisibility(8);
                                                multiTalkRoomPopupNav.nGg.setVisibility(0);
                                                multiTalkRoomPopupNav.nGf.setVisibility(0);
                                                multiTalkRoomPopupNav.nGn.setVisibility(8);
                                            }
                                        } else if (cg == 10) {
                                            multiTalkRoomPopupNav.nGk = b.nGt;
                                            if (com.tencent.mm.pluginsdk.j.a.lxR.wK(str2)) {
                                                multiTalkRoomPopupNav.bAB();
                                            } else if (com.tencent.mm.pluginsdk.j.a.lxR.aCc()) {
                                                multiTalkRoomPopupNav.bAB();
                                            } else {
                                                multiTalkRoomPopupNav.nGk = b.nGu;
                                                multiTalkRoomPopupNav.Oc(aa.getContext().getString(2131233950, new Object[]{Integer.valueOf(wJ.size())}));
                                            }
                                        } else {
                                            multiTalkRoomPopupNav.nGk = b.nGu;
                                            multiTalkRoomPopupNav.Oc(aa.getContext().getString(2131233950, new Object[]{Integer.valueOf(wJ.size())}));
                                        }
                                        multiTalkRoomPopupNav.setVisibility(0);
                                        multiTalkRoomPopupNav.nGc.setVisibility(0);
                                        multiTalkRoomPopupNav.nGd.setVisibility(0);
                                        if (multiTalkRoomPopupNav.nGl != null && (z || multiTalkRoomPopupNav.nGn == null || multiTalkRoomPopupNav.nGn.getVisibility() != 0)) {
                                            multiTalkRoomPopupNav.nGl.nGq.setVisibility(8);
                                        }
                                        multiTalkRoomPopupNav.cl(MultiTalkRoomPopupNav.i(wJ, SQLiteDatabase.KeyEmpty));
                                    }
                                }
                            }
                            this.ovL.pQS = Rk;
                            xn(1);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            if (this.ovK != null) {
                this.ovK.setVisibility(8);
                xn(-1);
            }
            if (this.ovL != null) {
                this.ovL.nGj = this.nGj;
                this.ovL.setVisibility(8);
            }
        }

        private void bFZ() {
            if (this.ovK != null) {
                this.ovK.setVisibility(8);
                this.ovK.wF(-1);
                this.ovK.stop();
                xn(-1);
            }
            if (this.ovL != null) {
                if (!com.tencent.mm.pluginsdk.j.a.lxR.wH(bEn())) {
                    this.ovL.bAB();
                }
                this.ovL.setVisibility(8);
                xn(-1);
            }
        }

        public final void jP(final boolean z) {
            if (!this.bhV.field_username.toLowerCase().endsWith("@chatroom") || this.nGj) {
                com.tencent.mm.sdk.c.b pdVar = new pd();
                pdVar.bqt.bqv = true;
                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                if (z) {
                    if (be.kS(pdVar.bqu.bqx) || this.bhV.field_username.equals(pdVar.bqu.bqx)) {
                        OY(this.bhV.field_username);
                        return;
                    } else if (this.ovK == null || this.ovK.getVisibility() != 0) {
                        com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131235612), null, new OnClickListener(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.c.b pdVar = new pd();
                                pdVar.bqt.bqw = true;
                                com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                                this.ovO.OY(this.ovO.bhV.field_username);
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ a ovO;

                            {
                                this.ovO = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    } else {
                        TalkRoomPopupNav talkRoomPopupNav = this.ovK;
                        ((TextView) talkRoomPopupNav.findViewById(2131759546)).setText(vN(2131235612));
                        talkRoomPopupNav = this.ovK;
                        if (talkRoomPopupNav.obG == null) {
                            talkRoomPopupNav.obG = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.obI) * 1.0f) / ((float) talkRoomPopupNav.obJ), 1.0f);
                            talkRoomPopupNav.obG.setDuration(300);
                            talkRoomPopupNav.obG.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                final /* synthetic */ TalkRoomPopupNav obO;

                                {
                                    this.obO = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    this.obO.obD.startAnimation(AnimationUtils.loadAnimation(this.obO.getContext(), 2130968622));
                                    this.obO.obD.setVisibility(0);
                                }
                            });
                        }
                        if (talkRoomPopupNav.obH == null) {
                            talkRoomPopupNav.obH = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), 2130968623);
                            talkRoomPopupNav.obH.setFillAfter(true);
                            talkRoomPopupNav.obH.setAnimationListener(new AnimationListener(talkRoomPopupNav) {
                                final /* synthetic */ TalkRoomPopupNav obO;

                                {
                                    this.obO = r1;
                                }

                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    this.obO.nGc.setVisibility(8);
                                    this.obO.nGc.setClickable(false);
                                }
                            });
                        }
                        ViewGroup.LayoutParams layoutParams = talkRoomPopupNav.fTh.getLayoutParams();
                        layoutParams.height = talkRoomPopupNav.obJ;
                        talkRoomPopupNav.fTh.setLayoutParams(layoutParams);
                        talkRoomPopupNav.fTh.startAnimation(talkRoomPopupNav.obG);
                        talkRoomPopupNav.nGc.startAnimation(talkRoomPopupNav.obH);
                        talkRoomPopupNav.obC.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), 2130968622));
                        talkRoomPopupNav.obC.setVisibility(0);
                        return;
                    }
                } else if (com.tencent.mm.pluginsdk.j.a.lxQ != null && com.tencent.mm.pluginsdk.j.a.lxQ.vJ(this.bhV.field_username)) {
                    String vN;
                    int i;
                    List vH = com.tencent.mm.pluginsdk.j.a.lxQ.vH(this.bhV.field_username);
                    if (vH == null || !vH.contains(bFR())) {
                        vN = vN(2131235618);
                        i = 2131233445;
                    } else {
                        vN = vN(2131235617);
                        i = 2131232449;
                    }
                    g.iuh.h(10997, Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.nDR.nEl);
                    aVar.Oq(vN);
                    aVar.wp(2131231010).a(new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.wq(i).b(new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ovO.OX(z ? "fromBanner" : "fromPluginTalk");
                        }
                    });
                    aVar.RX().show();
                    return;
                } else if (be.kS(pdVar.bqu.bqx) || this.bhV.field_username.equals(pdVar.bqu.bqx)) {
                    OY(this.bhV.field_username);
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131235612), null, new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.b pdVar = new pd();
                            pdVar.bqt.bqw = true;
                            com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                            this.ovO.OY(this.ovO.bhV.field_username);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            }
            com.tencent.mm.ui.base.g.A(this.nDR.nEl, vN(2131235622), null);
        }

        private void bGa() {
            aQ("fromBanner", false);
        }

        public final void aQ(final String str, boolean z) {
            if ((com.tencent.mm.pluginsdk.j.a.lxQ != null && com.tencent.mm.pluginsdk.j.a.lxQ.vJ(this.bhV.field_username)) || z) {
                List vH = com.tencent.mm.pluginsdk.j.a.lxQ.vH(this.bhV.field_username);
                if (vH == null || !vH.contains(bFR())) {
                    g.iuh.h(10997, Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131232452), null, new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ovO.OX(str);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            g.iuh.h(10997, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            }
            OX(str);
        }

        public final void OX(String str) {
            Intent intent = new Intent();
            intent.putExtra("map_view_type", 6);
            intent.putExtra("map_sender_name", bFR());
            intent.putExtra("map_talker_name", bEn());
            intent.putExtra("fromWhereShare", str);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "location", ".ui.RedirectUI", intent);
        }

        private void OY(String str) {
            Intent intent = new Intent();
            intent.putExtra("enter_room_username", str);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "talkroom", ".ui.TalkRoomUI", intent);
        }

        @TargetApi(11)
        private void bGb() {
            if (VERSION.SDK_INT < 11) {
                v.d("MicroMsg.ChattingUI", "sdk not support dragdrop event");
                return;
            }
            if (this.oth != null) {
                this.oth.setOnDragListener(null);
            }
            if (this.hjH != null) {
                this.hjH.setOnDragListener(null);
                this.hjH.a(null);
            }
        }

        @TargetApi(11)
        public final void bGc() {
            if (!this.onc && !this.otU) {
                if (VERSION.SDK_INT < 11) {
                    v.d("MicroMsg.ChattingUI", "sdk not support dragdrop event");
                } else {
                    new Runnable(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void run() {
                            OnDragListener anonymousClass1 = new OnDragListener(this) {
                                final /* synthetic */ AnonymousClass35 fUY;

                                {
                                    this.fUY = r1;
                                }

                                public final boolean onDrag(View view, DragEvent dragEvent) {
                                    switch (dragEvent.getAction()) {
                                        case 1:
                                            v.i("MicroMsg.ChattingUI", "ACTION_DRAG_STARTED");
                                            return true;
                                        case 2:
                                            v.i("MicroMsg.ChattingUI", "ACTION_DRAG_LOCATION");
                                            return true;
                                        case 3:
                                            v.i("MicroMsg.ChattingUI", "ACTION_DROP");
                                            ClipData clipData = dragEvent.getClipData();
                                            if (clipData == null) {
                                                return true;
                                            }
                                            int itemCount = clipData.getItemCount();
                                            for (int i = 0; i < itemCount; i++) {
                                                Item itemAt = clipData.getItemAt(i);
                                                if (itemAt == null) {
                                                    v.e("MicroMsg.ChattingUI", "item == null");
                                                } else if (itemAt.getIntent() != null) {
                                                    this.fUY.ovO.startActivity(itemAt.getIntent());
                                                } else if (itemAt.getUri() != null) {
                                                    com.tencent.mm.pluginsdk.ui.tools.m mVar = new com.tencent.mm.pluginsdk.ui.tools.m(this.fUY.ovO.nDR.nEl, itemAt.getUri());
                                                    if (mVar.fileType != 0 && mVar.filePath != null) {
                                                        switch (mVar.fileType) {
                                                            case 3:
                                                                this.fUY.ovO.filePath = mVar.filePath;
                                                                this.fUY.ovO.r(com.tencent.mm.model.k.a(this.fUY.ovO.filePath, this.fUY.ovO.bEn(), true) ? 1 : 0, 0, this.fUY.ovO.filePath);
                                                                break;
                                                            case 4:
                                                                Intent intent = new Intent();
                                                                intent.setData(itemAt.getUri());
                                                                this.fUY.ovO.aa(intent);
                                                                break;
                                                            default:
                                                                bl.zQ().b(38, Integer.valueOf(1));
                                                                this.fUY.ovO.filePath = mVar.filePath;
                                                                WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXFileObject(this.fUY.ovO.filePath));
                                                                wXMediaMessage.title = new File(this.fUY.ovO.filePath).getName();
                                                                wXMediaMessage.description = be.aw((long) com.tencent.mm.a.e.aQ(this.fUY.ovO.filePath));
                                                                com.tencent.mm.sdk.h.c fVar = new com.tencent.mm.pluginsdk.model.app.f();
                                                                fVar.field_appId = "wx4310bbd51be7d979";
                                                                am.bnB().b(fVar, new String[0]);
                                                                com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, fVar.field_appId, fVar.field_appName, this.fUY.ovO.bEn(), 2, null);
                                                                break;
                                                        }
                                                    }
                                                    v.e("MicroMsg.ChattingUI", "get file path failed");
                                                } else if (itemAt.getText() != null && itemAt.getText().length() > 0) {
                                                    this.fUY.ovO.OV(itemAt.getText().toString());
                                                }
                                            }
                                            return true;
                                        case 4:
                                            v.i("MicroMsg.ChattingUI", "ACTION_DRAG_ENDED");
                                            return true;
                                        case 5:
                                            v.i("MicroMsg.ChattingUI", "ACTION_DRAG_ENTERED");
                                            return true;
                                        default:
                                            v.e("MicroMsg.ChattingUI", "Unknown action type received by OnDragListener.");
                                            return false;
                                    }
                                }
                            };
                            if (this.ovO.oth != null) {
                                this.ovO.oth.setOnDragListener(anonymousClass1);
                            }
                            if (this.ovO.hjH != null) {
                                this.ovO.hjH.setOnDragListener(anonymousClass1);
                                this.ovO.hjH.a(anonymousClass1);
                            }
                        }
                    }.run();
                }
            }
        }

        public final void a(final com.tencent.mm.storage.ab abVar, com.tencent.mm.storage.ac acVar) {
            v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify cvs.getUsername[%s] tid[%d]", abVar.field_username, Long.valueOf(Thread.currentThread().getId()));
            if (this.onl && this.bhV.field_username.equals(abVar.field_username)) {
                int i = abVar.field_msgCount;
                int i2 = this.onh.emv;
                v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify newCvsCount[%d], total[%d], dealHistoryGetMsg[%b], UnDeliverCount[%d]", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.osX), Integer.valueOf(abVar.field_UnDeliverCount));
                if (i > i2) {
                    bx bxVar = abVar.nuz;
                    if (bxVar != null) {
                        int i3 = bxVar.field_flag;
                        v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify receive get msg svrId[%d], seq[%d], flag[%d], stack[%s]", Long.valueOf(bxVar.field_msgSvrId), Long.valueOf(bxVar.field_msgSeq), Integer.valueOf(i3), be.bur());
                        if ((i3 & 2) == 0) {
                            return;
                        }
                        int firstVisiblePosition;
                        int i4;
                        if ((i3 & 4) == 0) {
                            v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify down");
                            if (this.osX) {
                                v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify down but dealHistoryGetMsg so ignore");
                                return;
                            }
                            firstVisiblePosition = this.oth.getFirstVisiblePosition();
                            i3 = this.onh.getCount();
                            this.onh.bEE();
                            i4 = i - i2;
                            v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify down talker[%s],firstVisiblePosition:%d, new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.bhV.field_username, Integer.valueOf(firstVisiblePosition), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(this.onh.getCount()), Integer.valueOf(i3), Integer.valueOf(this.onh.getCount() - i3), Integer.valueOf(this.onh.eTd), Boolean.valueOf(this.osY));
                            if (this.onh.getCount() - i3 > 1) {
                                this.oth.setAdapter(this.onh);
                                this.oth.setSelection(firstVisiblePosition);
                                return;
                            }
                            return;
                        }
                        firstVisiblePosition = this.onh.getCount();
                        this.onh.bEE();
                        int i5 = i - i2;
                        i4 = this.onh.getCount() - firstVisiblePosition;
                        v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify up talker[%s],new oldTotal[%d,%d,%d], now preCount:[%d,%d,%d] fromcount:%d, needCheckHistoryTips:%b", this.bhV.field_username, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(this.onh.getCount()), Integer.valueOf(firstVisiblePosition), Integer.valueOf(i4), Integer.valueOf(this.onh.eTd), Boolean.valueOf(this.osY));
                        if (i4 <= 0 || i5 != i4 || this.onh.eTd < 0) {
                            v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify up incTotal incCount[%d, %d, %d] keep same", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(this.onh.eTd));
                        } else {
                            this.onh.xc(i4);
                            v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify up nowCount > preCount on set select:%d position %d, set pullDownView.getTopHeight() %d", Integer.valueOf(i4), Integer.valueOf(i4 + 1), Integer.valueOf(bFv() + this.hkk.nWV));
                            c.a(this.oth, i4 + 1, bFv() + this.hkk.nWV, false);
                        }
                        this.hkk.js(false);
                        this.onh.oqP = true;
                        if (abVar.field_UnDeliverCount <= 0) {
                            bFK();
                        }
                        if (this.osY) {
                            this.osY = false;
                            this.hkk.jt(false);
                            this.hkk.jp(this.onh.bEG());
                            this.hkk.jq(this.onc);
                            v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify set needCheckHistoryTips[%b]", Boolean.valueOf(this.osY));
                            this.handler.postDelayed(new Runnable(this) {
                                final /* synthetic */ a ovO;

                                public final void run() {
                                    v.i("MicroMsg.ChattingUI", "summerbadcr onMsgChangeNotify updateGoBacktoHistroyMessage up UnDeliver:%d, UnRead:%d", Integer.valueOf(abVar.field_UnDeliverCount), Integer.valueOf(abVar.field_unReadCount));
                                    this.ovO.a(abVar, true);
                                }
                            }, 500);
                        }
                    }
                }
            }
        }

        public final void a(au auVar, com.tencent.mm.storage.au.c cVar) {
            v.d("MicroMsg.ChattingUI", "on msg notify change");
            if (this.bhV.field_username.equals(cVar.bdo) && "insert".equals(cVar.nws) && cVar.nwt.size() > 0 && ((at) cVar.nwt.get(0)).field_isSend == 0) {
                v.i("MicroMsg.ChattingUI", "summerbadcr oreh onNotifyChange receive a new msg flag[%d], msgSeq[%d]", Integer.valueOf(((at) cVar.nwt.get(0)).field_flag), Long.valueOf(((at) cVar.nwt.get(0)).field_msgSeq));
                this.oue = be.Ni();
            }
        }

        public static boolean bGd() {
            ak.yW();
            return !((Boolean) com.tencent.mm.model.c.vf().get(75, Boolean.valueOf(false))).booleanValue();
        }

        public static void bGe() {
            ak.yW();
            com.tencent.mm.model.c.vf().set(75, Boolean.valueOf(true));
        }

        public final void az(at atVar) {
            if (atVar == null) {
                v.d("MicroMsg.ChattingUI", "jacks go VoiceTransText need MsgInfo but null");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("voice_trans_text_msg_id", atVar.field_msgId);
            intent.putExtra("voice_trans_text_img_path", atVar.field_imgPath);
            intent.putExtra("MMActivity.OverrideExitAnimation", 2130968623);
            intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
            com.tencent.mm.modelvoice.q.A(atVar);
            com.tencent.mm.ay.c.b(this.nDR.nEl, "subapp", ".ui.voicetranstext.VoiceTransTextUI", intent);
            this.nDR.nEl.overridePendingTransition(2130968622, 2130968589);
        }

        public final void a(int i, int i2, com.tencent.mm.v.k kVar) {
        }

        public final void a(long j, int i, int i2, Object obj, int i3, int i4, com.tencent.mm.v.k kVar) {
        }

        public final void a(long j, long j2, int i, Object obj, int i2, int i3) {
            com.tencent.mm.modelcontrol.c.Eg();
            if (!com.tencent.mm.modelcontrol.c.Eh()) {
                com.tencent.mm.ae.n.GI().a((com.tencent.mm.ae.c.a) this);
            }
            boolean z = i2 == 0 && i3 == 0;
            com.tencent.mm.ae.n.GJ();
            com.tencent.mm.ae.a.a(j, j2, z);
            ak.yW();
            bx ek = com.tencent.mm.model.c.wJ().ek(j2);
            cp cpVar = this.onh;
            if (cpVar.oqI.containsKey(Long.valueOf(j2)) && cpVar.oqJ.containsKey(Long.valueOf(j2))) {
                com.tencent.mm.ui.chatting.ad.a aVar = (com.tencent.mm.ui.chatting.ad.a) ((View) cpVar.oqI.get(Long.valueOf(j2))).getTag();
                bm bmVar = (bm) cpVar.X(3, ((Integer) cpVar.oqJ.get(Long.valueOf(j2))).intValue() == 1);
                if (bmVar != null && true == z) {
                    dk dkVar = (dk) aVar;
                    com.tencent.mm.ae.n.GH().a(dkVar.okl, ek.field_imgPath, com.tencent.mm.bd.a.getDensity(bmVar.onG.nDR.nEl), ek.bNp, ek.bNq, true, 2130837919, dkVar.oxM, 2130837921, 1, true, null);
                    return;
                }
                return;
            }
            v.d("MicroMsg.ChattingListAdapter", "msg not display, " + j2);
        }

        public final void a(long j, Object obj) {
        }

        public final void a(long j, int i, int i2) {
            cp cpVar = this.onh;
            if (cpVar.oqI.containsKey(Long.valueOf(j)) && cpVar.oqJ.containsKey(Long.valueOf(j))) {
                com.tencent.mm.ui.chatting.ad.a aVar = (com.tencent.mm.ui.chatting.ad.a) ((View) cpVar.oqI.get(Long.valueOf(j))).getTag();
                cpVar.X(3, ((Integer) cpVar.oqJ.get(Long.valueOf(j))).intValue() == 1);
                bn.a(aVar, i, i2);
                return;
            }
            v.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }

        public final void b(long j, boolean z) {
            cp cpVar = this.onh;
            if (cpVar.oqI.containsKey(Long.valueOf(j)) && cpVar.oqJ.containsKey(Long.valueOf(j))) {
                com.tencent.mm.ui.chatting.ad.a aVar = (com.tencent.mm.ui.chatting.ad.a) ((View) cpVar.oqI.get(Long.valueOf(j))).getTag();
                if (((bn) cpVar.X(3, ((Integer) cpVar.oqJ.get(Long.valueOf(j))).intValue() == 1)) != null && z) {
                    dk dkVar = (dk) aVar;
                    dkVar.ieT.setVisibility(4);
                    dkVar.oxL.setVisibility(4);
                    dkVar.oxN.setVisibility(4);
                    return;
                }
                return;
            }
            v.d("MicroMsg.ChattingListAdapter", "msg not display, " + j);
        }

        public final String Hh() {
            if (this.onl) {
                return bEn();
            }
            return SQLiteDatabase.KeyEmpty;
        }

        public final void fM(int i) {
            v.i("MicroMsg.ChattingUI", "summerbadcr onGetFinish retcode[%d] thread[%d], dealHistoryGetMsg[%b], needCheckHistoryTips[%b]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()), Boolean.valueOf(this.osX), Boolean.valueOf(this.osY));
            if (i == 0 && this.osX) {
                ak.yW();
                af Mh = com.tencent.mm.model.c.wK().Mh(this.bhV.field_username);
                if (Mh != null) {
                    int i2 = Mh.field_unReadCount;
                    int i3 = Mh.field_UnDeliverCount;
                    ak.yW();
                    final int MW = (com.tencent.mm.model.c.wJ().MW(this.bhV.field_username) - this.osZ) - i2;
                    v.i("MicroMsg.ChattingUI", "summerbadcr onGetFinish unReadCount[%d] unDeliverCount[%d] beforemsgCount[%d], msgCount[%d] pos[%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.osZ), Integer.valueOf(com.tencent.mm.model.c.wJ().MW(this.bhV.field_username)), Integer.valueOf(MW));
                    com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                        final /* synthetic */ a ovO;

                        public final void run() {
                            this.ovO.Y(MW, true);
                        }
                    });
                    return;
                }
                return;
            }
            com.tencent.mm.sdk.platformtools.ad.o(new Runnable(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void run() {
                    this.ovO.hkk.js(false);
                    if (this.ovO.osY) {
                        this.ovO.osY = false;
                        this.ovO.hkk.jt(false);
                        this.ovO.hkk.jp(this.ovO.onh.bEG());
                        this.ovO.hkk.jq(this.ovO.onc);
                        v.i("MicroMsg.ChattingUI", "summerbadcr onGetFinish set needCheckHistoryTips[%b]", Boolean.valueOf(this.ovO.osY));
                    }
                }
            });
        }

        public final boolean Hi() {
            return this.osX;
        }

        private String ak(LinkedList<String> linkedList) {
            if (linkedList.size() <= 0) {
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(this.ogZ.er((String) linkedList.get(0)));
            for (int i = 1; i < linkedList.size(); i++) {
                stringBuilder.append(this.nDR.nEl.getString(2131231758)).append(this.ogZ.er((String) linkedList.get(i)));
            }
            return stringBuilder.toString();
        }

        private void d(LinkedList<String> linkedList, int i) {
            com.tencent.mm.storage.o LC = ak.yW().wO().LC(this.bhV.field_username);
            if (LC == null) {
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131234593), null, vN(2131234588), new OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            }
            String str = this.bhV.field_username;
            final List linkedList2 = new LinkedList();
            List DM = LC.DM();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (DM != null && DM.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            if (linkedList2.size() == 0) {
                if (linkedList.size() == 1) {
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131234587), null, vN(2131234588), new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131234583), null, vN(2131234588), new OnClickListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            } else if (linkedList.size() == 1) {
                Object[] objArr = new Object[1];
                str2 = (String) linkedList.get(0);
                if (this.nQK) {
                    ak.yW();
                    com.tencent.mm.e.b.ab LX = com.tencent.mm.model.c.wH().LX(str2);
                    if (!(LX == null || ((int) LX.chr) == 0)) {
                        if (be.kS(LX.field_conRemark)) {
                            LC = ak.yW().wO().LC(this.bhV.field_username);
                            str2 = LC == null ? null : LC.er(LX.field_username);
                        } else {
                            str2 = LX.field_conRemark;
                        }
                        if (be.kS(str2)) {
                            str2 = LX.field_conRemark;
                        }
                        if (be.kS(str2)) {
                            str2 = LX.tT();
                        }
                    }
                } else {
                    str2 = null;
                }
                objArr[0] = str2;
                com.tencent.mm.ui.base.g.a(this.nDR.nEl, d(2131234582, objArr), null, vN(2131234589), vN(2131231010), true, new OnClickListener(this, 1) {
                    final /* synthetic */ a ovO;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        final com.tencent.mm.sdk.c.b ihVar = new ih();
                        a aVar = this.ovO;
                        Context context = this.ovO.nDR.nEl;
                        this.ovO.vN(2131231164);
                        aVar.dwg = com.tencent.mm.ui.base.g.a(context, this.ovO.vN(2131234578), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass50 fVf;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ihVar.biz.bin = true;
                                com.tencent.mm.sdk.c.a.nhr.z(ihVar);
                            }
                        });
                        ihVar.biz.biB = this.ovO.bhV.field_username;
                        ihVar.biz.biC = linkedList2;
                        ihVar.biz.scene = 1;
                        com.tencent.mm.sdk.c.a.nhr.z(ihVar);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ a ovO;

                    {
                        this.ovO = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else {
                Intent intent = new Intent();
                intent.putExtra("members", be.b(linkedList2, ","));
                intent.putExtra("RoomInfo_Id", this.bhV.field_username);
                intent.putExtra("scene", 1);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "chatroom", ".ui.DelChatroomMemberUI", intent);
            }
        }

        public final void a(View view, at atVar, com.tencent.mm.aj.a aVar, int i) {
            String ma;
            if (aVar instanceof com.tencent.mm.aj.d) {
                com.tencent.mm.aj.d dVar = (com.tencent.mm.aj.d) aVar;
                if (dVar == null) {
                    v.e("MicroMsg.ChattingUI", "link is null!");
                    return;
                }
                ma = be.ma(dVar.cSY);
                v.d("MicroMsg.ChattingUI", "click delchatroommember link %s,isBizChat:%s", ma, Boolean.valueOf(this.lKa));
                if (dVar.cTm == null) {
                    v.e("MicroMsg.ChattingUI", "click members is null!!!");
                } else if (!this.nQK) {
                    v.e("MicroMsg.ChattingUI", "not group chat !!!!!");
                } else if (ma.equals("invite")) {
                    if (this.lKa) {
                        LinkedList linkedList = dVar.cTm;
                        com.tencent.mm.modelbiz.u.DA().Z(bFS());
                        final LinkedList linkedList2 = new LinkedList();
                        List DM = this.ogZ.DM();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ma = (String) it.next();
                            if (DM != null && DM.contains(ma)) {
                                linkedList2.add(ma);
                            }
                        }
                        if (linkedList2.size() != 0) {
                            com.tencent.mm.ui.base.g.a(this.nDR.nEl, d(2131234582, ak(linkedList2)), null, vN(2131234589), vN(2131231010), true, new OnClickListener(this) {
                                final /* synthetic */ a ovO;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    gx gxVar = new gx();
                                    for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                                        gw gwVar = new gw();
                                        gwVar.mhK = (String) linkedList2.get(i2);
                                        gxVar.mhL.add(gwVar);
                                    }
                                    a.a(this.ovO, gxVar);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ a ovO;

                                {
                                    this.ovO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        } else if (linkedList.size() == 1) {
                            com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131234587), null, vN(2131234588), new OnClickListener(this) {
                                final /* synthetic */ a ovO;

                                {
                                    this.ovO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        } else {
                            com.tencent.mm.ui.base.g.a(this.nDR.nEl, vN(2131234583), null, vN(2131234588), new OnClickListener(this) {
                                final /* synthetic */ a ovO;

                                {
                                    this.ovO = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            return;
                        }
                    }
                    d(dVar.cTm, 1);
                } else if (ma.equals("qrcode")) {
                    if (this.eyZ == null) {
                        this.eyZ = new l(this.nDR.nEl);
                    }
                    final com.tencent.mm.aj.d dVar2 = dVar;
                    this.eyZ.b(view, new OnCreateContextMenuListener(this) {
                        final /* synthetic */ a ovO;

                        {
                            this.ovO = r1;
                        }

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 0, 0, view.getContext().getString(2131234591));
                            contextMenu.add(0, 1, 1, view.getContext().getString(2131234584));
                        }
                    }, new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ a ovO;

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    this.ovO.d(dVar2.cTm, 1);
                                    return;
                                case 1:
                                    final com.tencent.mm.sdk.c.b imVar = new im();
                                    a aVar = this.ovO;
                                    Context context = this.ovO.nDR.nEl;
                                    this.ovO.getString(2131231164);
                                    aVar.dwg = com.tencent.mm.ui.base.g.a(context, this.ovO.getString(2131234586), true, new OnCancelListener(this) {
                                        final /* synthetic */ AnonymousClass53 fVq;

                                        public final void onCancel(DialogInterface dialogInterface) {
                                            imVar.biU.bin = true;
                                            com.tencent.mm.sdk.c.a.nhr.z(imVar);
                                        }
                                    });
                                    imVar.biU.biB = this.ovO.bhV.field_username;
                                    imVar.biU.biW = dVar2.biW;
                                    com.tencent.mm.sdk.c.a.nhr.z(imVar);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                } else if (ma.equals("webview") && !be.kS(dVar.url)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", dVar.url);
                    intent.putExtra("geta8key_username", com.tencent.mm.model.k.xF());
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (aVar instanceof com.tencent.mm.aj.c) {
                com.tencent.mm.aj.c cVar = (com.tencent.mm.aj.c) aVar;
                if (i == 0) {
                    ma = cVar.cTj;
                    String str = cVar.cTk;
                    String str2 = cVar.cTd;
                    String str3 = cVar.bax;
                    List list = cVar.cTe;
                    List list2 = cVar.cTh;
                    List list3 = cVar.cTi;
                    Intent intent2 = new Intent();
                    intent2.putExtra("msgLocalId", atVar.field_msgId);
                    intent2.putExtra("invitertitle", getString(2131230789, Integer.valueOf(list.size())));
                    intent2.putExtra("inviterusername", ma);
                    intent2.putExtra("chatroom", str2);
                    intent2.putExtra("invitationreason", str);
                    intent2.putExtra("ticket", str3);
                    intent2.putExtra("username", be.b(list, ","));
                    intent2.putExtra("nickname", be.b(list2, ","));
                    intent2.putExtra("headimgurl", be.b(list3, ","));
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "chatroom", ".ui.SeeAccessVerifyInfoUI", intent2);
                }
            } else if (aVar instanceof com.tencent.mm.aj.b) {
                com.tencent.mm.aj.b bVar = (com.tencent.mm.aj.b) aVar;
                List arrayList = new ArrayList();
                arrayList.addAll(bVar.cTe);
                final com.tencent.mm.v.k kVar = new com.tencent.mm.plugin.chatroom.c.k(Hh(), arrayList, bVar.bax, atVar);
                ak.vy().a(kVar, 0);
                Context context = this.nDR.nEl;
                getString(2131231164);
                this.dwg = com.tencent.mm.ui.base.g.a(context, getString(2131234605), true, new OnCancelListener(this) {
                    final /* synthetic */ a ovO;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(kVar);
                    }
                });
            }
        }

        private void bGf() {
            v.d("MicroMsg.ChattingUI", "getBizChatInfo");
            ak.vA().f(new Runnable(this) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!this.ovO.lKa || this.ovO.ogZ == null || this.ovO.bhV == null) {
                        v.i("MicroMsg.ChattingUI", "bizChatInfo:%s  talker:%s", this.ovO.ogZ, this.ovO.bhV);
                    } else {
                        this.ovO.bGg();
                        com.tencent.mm.modelbiz.u.DJ();
                        com.tencent.mm.modelbiz.a.c cVar = this.ovO.ogZ;
                        ak.yW();
                        if (com.tencent.mm.model.c.wC()) {
                            ae.a(cVar.field_brandUserName, 7, "EnterpriseChatStatus", String.format("%s;%s;%d", new Object[]{cVar.field_brandUserName, cVar.field_bizChatServId, Long.valueOf(System.currentTimeMillis() / 1000)}));
                            v.d("MicroMsg.BizChatStatusNotifyService", "enterChat:arg:%s", r3);
                        }
                        if (this.ovO.otJ) {
                            if (this.ovO.ogZ.DO()) {
                                com.tencent.mm.modelbiz.u.DE();
                                com.tencent.mm.modelbiz.a.h.b(this.ovO.ogZ.field_bizChatServId, this.ovO.bhV.field_username, true);
                            } else {
                                com.tencent.mm.modelbiz.a.e.f(this.ovO.ogZ);
                            }
                        }
                        a.aC(this.ovO);
                    }
                    v.d("MicroMsg.ChattingUI", "willen test  updateBizChatInfo use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                }
            }, 500);
        }

        private void bGg() {
            if (this.lKa) {
                com.tencent.mm.modelbiz.u.DE();
                ak.vy().a(new com.tencent.mm.modelbiz.a.v(bEn(), this.ogZ.field_bizChatServId, (int) (System.currentTimeMillis() / 1000)), 0);
            }
        }

        public final void bGh() {
            v.i("MicroMsg.INIT", "summerper setFooterMode mode[%d], footer[%s], stack[%s]", Integer.valueOf(2), this.hjH, be.bur());
            if (this.hjH != null) {
                this.hjH.R(2, true);
            }
        }

        public final void bEo() {
            v.i("MicroMsg.INIT", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.bEo();
            }
        }

        public final void bGi() {
            v.i("MicroMsg.INIT", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.bEp();
            }
        }

        public final void bEq() {
            v.i("MicroMsg.INIT", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.bEq();
            }
        }

        public final void bEr() {
            v.i("MicroMsg.INIT", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.bEr();
            }
        }

        public final void aGQ() {
            v.i("MicroMsg.INIT", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.aGQ();
            }
        }

        public final void aGP() {
            v.i("MicroMsg.INIT", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.aGP();
            }
        }

        public final void bEs() {
            v.i("MicroMsg.INIT", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.bEs();
            }
        }

        public final void bEt() {
            v.i("MicroMsg.INIT", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.otc, be.bur());
            if (this.otc != null) {
                this.otc.bEt();
            }
        }

        public final boolean a(b bVar) {
            return this.otz.remove(bVar);
        }
    }

    static /* synthetic */ void Q(u uVar) {
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(uVar.field_username);
        if (LX == null || ((int) LX.chr) == 0) {
            ak.yW();
            if (com.tencent.mm.model.c.wH().M(uVar)) {
                ak.yW();
                LX = com.tencent.mm.model.c.wH().LX(uVar.field_username);
            } else {
                v.e("MicroMsg.ChattingUI", "insert contact failed, username = " + uVar.field_username);
                LX = null;
            }
        }
        if (LX != null) {
            m.n(LX);
        }
    }

    public void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        e.N(this);
        super.onCreate(null);
        String stringExtra = getIntent().getStringExtra("Chat_User");
        boolean booleanExtra = getIntent().getBooleanExtra("key_is_biz_chat", false);
        if (!booleanExtra && stringExtra == null) {
            finish();
            v.e("MicroMsg.ChattingUI", "talker is null !!!");
        } else if (booleanExtra && getIntent().getLongExtra("key_biz_chat_id", -1) == -1) {
            finish();
            v.e("MicroMsg.ChattingUI", "bizChatId is null !!");
        } else {
            setContentView(2130903374);
            this.ojM = new a(true);
            Bundle extras = getIntent().getExtras();
            extras.putBoolean("FROM_CHATTING_ACTIVITY", true);
            this.ojM.setArguments(extras);
            aS().aW().a(2131755641, this.ojM).commit();
            cU().cV().show();
            String stringExtra2 = getIntent().getStringExtra("send_card_username");
            if (!be.kS(stringExtra2)) {
                boolean booleanExtra2 = getIntent().getBooleanExtra("Is_Chatroom", false);
                String stringExtra3 = getIntent().getStringExtra("send_card_edittext");
                a.m(stringExtra2, stringExtra, booleanExtra2);
                if (stringExtra3 != null) {
                    com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra3, stringExtra);
                }
            }
            if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
                com.tencent.mm.sdk.platformtools.ad.g(new Runnable(this) {
                    final /* synthetic */ ChattingUI osR;

                    {
                        this.osR = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.g.b(this.osR, this.osR.getString(2131234092), SQLiteDatabase.KeyEmpty, this.osR.getString(2131234093), this.osR.getString(2131231010), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 osS;

                            {
                                this.osS = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.c.a.nhr.z(new ln());
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 osS;

                            {
                                this.osS = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                com.tencent.mm.sdk.c.a.nhr.z(new jc());
                            }
                        });
                    }
                }, 500);
                getIntent().putExtra("is_need_resend_sns", false);
            }
            com.tencent.mm.permission.a.MQ().MR();
            bAr();
            this.ojN.post(new Runnable(this) {
                final /* synthetic */ ChattingUI osR;

                {
                    this.osR = r1;
                }

                public final void run() {
                    if (this.osR.ojM != null) {
                        e.a(this.osR, this.osR.ojM.nDR.nDX);
                    }
                }
            });
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        v.d("MicroMsg.ChattingUI", "chatting ui dispatch key event %s", keyEvent);
        if (this.ojM == null || !this.ojM.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        v.d("MicroMsg.ChattingUI", "chatting ui on key up");
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        v.d("MicroMsg.ChattingUI", "chatting ui on key down, %d, %s", Integer.valueOf(i), keyEvent);
        return super.onKeyDown(i, keyEvent);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 2131234163;
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            if (iArr == null) {
                i2 = -1;
            } else {
                i2 = iArr.length;
            }
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = be.bur();
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.ChattingUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case android.support.v7.a.a.k.MG /*18*/:
                if (iArr[0] != 0) {
                    if ("android.permission.CAMERA".equals(strArr[0])) {
                        i2 = 2131234160;
                    }
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                            final /* synthetic */ ChattingUI osR;

                            {
                                this.osR = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ ChattingUI osR;

                            {
                                this.osR = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.ojM instanceof a) {
                    ((a) this.ojM).bGi();
                    return;
                } else {
                    return;
                }
            case 19:
            case 21:
            case android.support.v7.a.a.k.MM /*22*/:
                if (iArr[0] != 0) {
                    if ("android.permission.CAMERA".equals(strArr[0])) {
                        i2 = 2131234160;
                    }
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                            final /* synthetic */ ChattingUI osR;

                            {
                                this.osR = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ ChattingUI osR;

                            {
                                this.osR = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        return;
                    }
                    return;
                } else if (!(this.ojM instanceof a)) {
                    return;
                } else {
                    if (i == 19) {
                        ((a) this.ojM).aGQ();
                        return;
                    } else if (i == 21) {
                        ((a) this.ojM).bEr();
                        return;
                    } else {
                        ((a) this.ojM).bEo();
                        return;
                    }
                }
            case 20:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234160), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ChattingUI osR;

                        {
                            this.osR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (this.ojM instanceof a) {
                    ((a) this.ojM).bEt();
                    return;
                } else {
                    return;
                }
            case 67:
            case 68:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ChattingUI osR;

                        {
                            this.osR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (!(this.ojM instanceof a)) {
                    return;
                } else {
                    if (i == 67) {
                        ((a) this.ojM).bFO();
                        return;
                    } else {
                        ((a) this.ojM).bFP();
                        return;
                    }
                }
            case 80:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234163), SQLiteDatabase.KeyEmpty, getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ChattingUI osR;

                        {
                            this.osR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ ChattingUI osR;

                        {
                            this.osR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                } else if (this.ojM instanceof a) {
                    ((a) this.ojM).bGh();
                    return;
                } else {
                    return;
                }
            case 81:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ChattingUI osR;

                        {
                            this.osR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (this.ojM instanceof a) {
                    ((a) this.ojM).bEs();
                    return;
                } else {
                    return;
                }
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ChattingUI osR;

                        {
                            this.osR = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.osR.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                } else if (!(this.ojM instanceof a)) {
                    return;
                } else {
                    if (i == 82) {
                        ((a) this.ojM).aGP();
                        return;
                    } else {
                        ((a) this.ojM).bEq();
                        return;
                    }
                }
            default:
                return;
        }
    }
}
