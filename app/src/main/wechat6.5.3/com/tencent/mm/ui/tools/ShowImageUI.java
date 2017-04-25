package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.gif.d;
import com.tencent.mm.plugin.gif.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class ShowImageUI extends MMActivity {
    private MMGestureGallery eIS;
    private boolean oUN;
    private a oUO;
    private boolean oUP;

    private class a extends BaseAdapter {
        String imagePath;
        final /* synthetic */ ShowImageUI oUQ;

        private a(ShowImageUI showImageUI) {
            this.oUQ = showImageUI;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (o.JZ(this.imagePath)) {
                Context context = viewGroup.getContext();
                String str = this.imagePath;
                d dVar = new d(str);
                if (view == null || !(view instanceof MMGIFImageView)) {
                    view = new MMGIFImageView(context);
                } else {
                    MMGIFImageView mMGIFImageView = (MMGIFImageView) view;
                }
                view.bM(str, str);
                view.a(str, Integer.MAX_VALUE, new e(this) {
                    final /* synthetic */ a oUT;

                    public final void onAnimationEnd() {
                    }

                    public final void invalidate() {
                        view.invalidate();
                    }
                });
                if (view.getDrawable() != null && (view.getDrawable() instanceof com.tencent.mm.plugin.gif.a)) {
                    ((com.tencent.mm.plugin.gif.a) view.getDrawable()).stop();
                }
                if (view.getDrawable() != null && (view.getDrawable() instanceof com.tencent.mm.plugin.gif.a)) {
                    ((com.tencent.mm.plugin.gif.a) view.getDrawable()).start();
                }
            } else {
                Bitmap lW = j.lW(this.imagePath);
                if (lW == null) {
                    v.w("MicroMsg.ShowImageUI", "get image fail");
                    if (view == null || (view instanceof MultiTouchImageView)) {
                        view = View.inflate(viewGroup.getContext(), 2130904390, null);
                    }
                    ((ImageView) view.findViewById(2131756901)).setImageResource(2131165477);
                    view.setLayoutParams(new LayoutParams(-1, -1));
                } else {
                    Context context2 = viewGroup.getContext();
                    if (view == null || !(view instanceof MultiTouchImageView)) {
                        view = new MultiTouchImageView(context2, lW.getWidth(), lW.getHeight());
                    } else {
                        MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                        multiTouchImageView.di(lW.getWidth(), lW.getHeight());
                    }
                    view.setLayoutParams(new LayoutParams(-1, -1));
                    view.setImageBitmap(lW);
                    view.oad = true;
                }
            }
            return view;
        }
    }

    static /* synthetic */ void b(ShowImageUI showImageUI) {
        String stringExtra = showImageUI.getIntent().getStringExtra("key_image_path");
        int intExtra = showImageUI.getIntent().getIntExtra("key_compress_type", 0);
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", longExtra);
        ak.yW();
        bx ek = c.wJ().ek(longExtra);
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(ek.field_content);
        if (o.JZ(stringExtra) || (ek.bvY() && dV != null && dV.type == 2)) {
            intent.putExtra("Retr_Msg_Type", 2);
            intent.putExtra("Retr_Msg_content", ek.field_content);
            if (dV != null && dV.type == 2) {
                stringExtra = com.tencent.mm.model.o.fz("msg_" + ek.field_msgSvrId);
                com.tencent.mm.model.o.yx().n(stringExtra, true).l("prePublishId", "msg_" + ek.field_msgSvrId);
                intent.putExtra("reportSessionId", stringExtra);
            }
        } else {
            intent.putExtra("Retr_Msg_Type", 0);
        }
        intent.putExtra("Retr_Compress_Type", intExtra);
        showImageUI.startActivity(intent);
    }

    static /* synthetic */ void d(ShowImageUI showImageUI) {
        long longExtra = showImageUI.getIntent().getLongExtra("key_message_id", -1);
        Intent intent = new Intent(showImageUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", longExtra);
        showImageUI.startActivity(intent);
    }

    protected final int getLayoutId() {
        return 2130904389;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (!be.kS(stringExtra)) {
            Fd(stringExtra);
        }
        this.oUN = getIntent().getBooleanExtra("key_favorite", false);
        this.oUP = getIntent().getBooleanExtra("show_menu", true);
        this.eIS = (MMGestureGallery) findViewById(2131755843);
        this.eIS.setVerticalFadingEdgeEnabled(false);
        this.eIS.setHorizontalFadingEdgeEnabled(false);
        this.oUO = new a();
        this.oUO.imagePath = getIntent().getStringExtra("key_image_path");
        this.eIS.setAdapter(this.oUO);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShowImageUI oUQ;

            {
                this.oUQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oUQ.finish();
                return true;
            }
        });
        if (this.oUP) {
            a(0, 2131165801, new OnMenuItemClickListener(this) {
                final /* synthetic */ ShowImageUI oUQ;

                {
                    this.oUQ = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    if (this.oUQ.oUN && com.tencent.mm.ay.c.EH("favorite")) {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(this.oUQ.getString(2131234560));
                        linkedList2.add(Integer.valueOf(1));
                        linkedList.add(this.oUQ.getString(2131234180));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(this.oUQ.getString(2131234727));
                    } else {
                        linkedList2.add(Integer.valueOf(0));
                        linkedList.add(this.oUQ.getString(2131234560));
                        linkedList2.add(Integer.valueOf(2));
                        linkedList.add(this.oUQ.getString(2131234727));
                    }
                    b cpVar = new cp();
                    cpVar.bay.bao = this.oUQ.getIntent().getLongExtra("key_message_id", -1);
                    com.tencent.mm.sdk.c.a.nhr.z(cpVar);
                    if (cpVar.baz.aZW) {
                        linkedList2.add(Integer.valueOf(3));
                        linkedList.add(this.oUQ.getString(2131231834));
                    }
                    g.a(this.oUQ, SQLiteDatabase.KeyEmpty, linkedList, linkedList2, SQLiteDatabase.KeyEmpty, false, new g.d(this) {
                        final /* synthetic */ AnonymousClass2 oUR;

                        {
                            this.oUR = r1;
                        }

                        public final void bw(int i, int i2) {
                            switch (i2) {
                                case 0:
                                    ShowImageUI.b(this.oUR.oUQ);
                                    return;
                                case 1:
                                    Activity activity = this.oUR.oUQ;
                                    bp bpVar = new bp();
                                    long longExtra = activity.getIntent().getLongExtra("key_message_id", -1);
                                    if (-1 == longExtra) {
                                        v.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                                        com.tencent.mm.pluginsdk.model.d.a(bpVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.getIntent().getStringExtra("key_image_path"));
                                    } else {
                                        com.tencent.mm.pluginsdk.model.d.a(bpVar, longExtra);
                                    }
                                    bpVar.aZd.aXH = activity;
                                    com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                                    return;
                                case 2:
                                    l.h(this.oUR.oUQ.getIntent().getStringExtra("key_image_path"), this.oUR.oUQ);
                                    return;
                                case 3:
                                    ShowImageUI.d(this.oUR.oUQ);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return true;
                }
            });
        }
    }
}
