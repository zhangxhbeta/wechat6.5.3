package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public final class a implements b {
    private ListView Eq;
    private OnClickListener fQr = new OnClickListener(this) {
        final /* synthetic */ a iqM;

        {
            this.iqM = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            switch (bVar.aKG) {
                case 0:
                    intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                    intent.putExtra("message_id", bVar.bao);
                    intent.putExtra("record_data_id", bVar.bdE.luu);
                    intent.putExtra("record_xml", bVar.bmh);
                    view.getContext().startActivity(intent);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("key_detail_info_id", bVar.ipT.field_localId);
                    intent.putExtra("key_detail_data_id", bVar.bdE.luu);
                    c.b(view.getContext(), "favorite", ".ui.FavImgGalleryUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    private OnLongClickListener fRk = new OnLongClickListener(this) {
        final /* synthetic */ a iqM;

        {
            this.iqM = r1;
        }

        public final boolean onLongClick(View view) {
            final com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            final com.tencent.mm.plugin.record.a.c cVar = bVar.ipT;
            final Context context = view.getContext();
            l lVar = new l(context);
            lVar.jXn = new n.c(this) {
                final /* synthetic */ AnonymousClass2 iqO;

                public final void a(com.tencent.mm.ui.base.l lVar) {
                    int i = 0;
                    if (((cVar.field_favProto.mtl & 1) != 0 ? 1 : 0) != 0) {
                        lVar.d(2, context.getString(2131232731));
                    }
                    if ((cVar.field_favProto.mtl & 2) != 0) {
                        i = 1;
                    }
                    if (i != 0) {
                        lVar.d(1, context.getString(2131232704));
                    }
                    lVar.d(3, context.getString(2131232726));
                }
            };
            lVar.jXo = new d(this) {
                final /* synthetic */ AnonymousClass2 iqO;

                public final void c(MenuItem menuItem, int i) {
                    ez ezVar = new ez();
                    ezVar.bdQ.type = 2;
                    ezVar.bdQ.bdS = bVar.bdE;
                    com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                    String str = ezVar.bdR.path;
                    if (e.aR(str)) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 1:
                                intent = new Intent();
                                intent.putExtra("Ksnsupload_type", 0);
                                intent.putExtra("sns_kemdia_path", str);
                                str = o.fz("fav_");
                                o.yx().n(str, true).l("prePublishId", "fav_");
                                intent.putExtra("reportSessionId", str);
                                c.b(context, "sns", ".ui.SnsUploadUI", intent);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Retr_File_Name", str);
                                intent.putExtra("Retr_Compress_Type", 0);
                                intent.putExtra("Retr_Msg_Type", 0);
                                c.a(context, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 3:
                                if (!com.tencent.mm.platformtools.d.b(str, context)) {
                                    Toast.makeText(context, context.getString(2131232725), 1).show();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                    v.w("MicroMsg.ImageViewWrapper", "file not exists");
                }
            };
            lVar.aXZ();
            return true;
        }
    };
    int iqL;
    com.tencent.mm.plugin.record.ui.h.a iql;

    public a(com.tencent.mm.plugin.record.ui.h.a aVar, ListView listView) {
        this.iql = aVar;
        this.Eq = listView;
    }

    public final View cq(Context context) {
        View inflate = View.inflate(context, 2130904256, null);
        this.iqL = com.tencent.mm.bd.a.fromDPToPix(context, 260);
        return inflate;
    }

    public final void a(View view, int i, final com.tencent.mm.plugin.record.ui.a.b bVar) {
        final ImageView imageView = (ImageView) view.findViewById(2131758844);
        imageView.setTag(bVar);
        imageView.setOnClickListener(this.fQr);
        if (bVar.aKG == 1) {
            imageView.setOnLongClickListener(this.fRk);
        }
        com.tencent.mm.plugin.record.ui.h.a.b bVar2 = new com.tencent.mm.plugin.record.ui.h.a.b();
        if (bVar.aKG == 0) {
            bVar2.iqn = bVar.bao;
        } else if (bVar.aKG == 1) {
            bVar2.iqn = bVar.ipT.field_localId;
        }
        bVar2.bdE = bVar.bdE;
        bVar2.bdH = true;
        bVar2.maxWidth = this.iqL;
        Bitmap a = this.iql.a(bVar2);
        if (a != null) {
            v.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[]{bVar2.bdE.luu, a});
            a(imageView, a, 2131165527, bVar.bdE.luu);
            return;
        }
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ a iqM;

            public final void run() {
                int i;
                int i2;
                Bitmap a;
                com.tencent.mm.plugin.record.ui.a.a aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                if (aVar.aKG == 0) {
                    if (m.g(aVar.bdE, aVar.bao)) {
                        i = 2131165871;
                    }
                    i = -1;
                } else {
                    if (aVar.aKG == 1 && be.kS(aVar.bdE.mrS)) {
                        i = 2131165871;
                    }
                    i = -1;
                }
                if (i == -1) {
                    i2 = 2131165527;
                } else {
                    i2 = i;
                }
                aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                com.tencent.mm.plugin.record.ui.h.a aVar2 = this.iqM.iql;
                int i3 = this.iqM.iqL;
                com.tencent.mm.plugin.record.ui.h.a.b bVar = new com.tencent.mm.plugin.record.ui.h.a.b();
                bVar.bdE = aVar.bdE;
                bVar.bdH = false;
                bVar.maxWidth = i3;
                com.tencent.mm.plugin.record.ui.h.a.c cVar = new com.tencent.mm.plugin.record.ui.h.a.c();
                cVar.bdE = aVar.bdE;
                Bitmap a2;
                if (aVar.aKG == 0) {
                    if (!m.g(aVar.bdE, aVar.bao)) {
                        bVar.iqn = aVar.bao;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.iqn = aVar.bao;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                } else {
                    if (aVar.aKG == 1) {
                        bVar.iqn = aVar.ipT.field_localId;
                        bVar.bdI = false;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.iqn = aVar.ipT.field_localId;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                }
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 iqS;

                    public final void run() {
                        this.iqS.iqM.a(imageView, a, i2, bVar.bdE.luu);
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|fillView";
            }
        });
    }

    final void a(ImageView imageView, Bitmap bitmap, int i, String str) {
        if (!((com.tencent.mm.plugin.record.ui.a.b) imageView.getTag()).bdE.luu.equals(str)) {
            v.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[]{str, imageView.getTag()});
        } else if (bitmap == null) {
            r0 = imageView.getLayoutParams();
            r0.height = 200;
            r0.width = 280;
            imageView.setImageResource(i);
            imageView.setBackgroundResource(2131689814);
        } else {
            v.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight())});
            r0 = imageView.getLayoutParams();
            if (bitmap.getWidth() > this.iqL) {
                r0.width = this.iqL;
                r0.height = (int) ((((float) this.iqL) / ((float) bitmap.getWidth())) * ((float) bitmap.getHeight()));
                imageView.setScaleType(ScaleType.FIT_XY);
            } else {
                r0.width = bitmap.getWidth();
                r0.height = bitmap.getHeight();
                imageView.setScaleType(ScaleType.FIT_XY);
            }
            k.h(imageView, bitmap.getWidth(), bitmap.getHeight());
            if (imageView.getLayerType() == 1) {
                this.Eq.setLayerType(1, null);
            }
            imageView.setImageBitmap(bitmap);
            imageView.setBackgroundResource(0);
        }
    }

    public final void destroy() {
    }
}
