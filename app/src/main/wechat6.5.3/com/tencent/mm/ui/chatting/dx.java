package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.p;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class dx extends c<ly> {
    Activity aXH = null;
    private a oyQ = null;

    public enum a {
        CHATTING_ITEM_VIDEO,
        IMAGE_GALLERY_UI,
        VIDEO_GALLERY
    }

    public dx(a aVar, Activity activity) {
        super(0);
        this.oyQ = aVar;
        this.aXH = activity;
        this.nhz = ly.class.getName().hashCode();
    }

    private boolean a(ly lyVar) {
        int i = 1;
        if (!(this.oyQ == null || lyVar == null || !(lyVar instanceof ly))) {
            bx bxVar;
            long j = lyVar.bnd.bao;
            String str = lyVar.bnd.bne;
            bx bxVar2 = lyVar.bnd.bnf;
            if (bxVar2 == null || bxVar2.field_msgId <= 0) {
                bxVar = lyVar.bnd.bnf;
            } else {
                bxVar = bxVar2;
            }
            if (bxVar != null) {
                switch (bxVar.field_type) {
                    case 3:
                        switch (this.oyQ) {
                            case IMAGE_GALLERY_UI:
                                if (bxVar != null && bxVar.field_msgId > 0) {
                                    try {
                                        g.DZ().iq(d.a("downimg", bxVar.field_createTime, bxVar.field_talker, bxVar.field_msgId));
                                        v.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", Boolean.valueOf(true));
                                        ak.vy().cancel(MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM);
                                        n.GI().d(com.tencent.mm.ui.chatting.gallery.d.aW(bxVar).cLu, j);
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", e.getMessage());
                                    }
                                }
                                if (this.aXH != null && (this.aXH instanceof ImageGalleryUI)) {
                                    v.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", Long.valueOf(j), Long.valueOf(((ImageGalleryUI) this.aXH).bao));
                                    if (j == ((ImageGalleryUI) this.aXH).bao) {
                                        com.tencent.mm.ui.base.g.a(this.aXH, str, SQLiteDatabase.KeyEmpty, false, new OnClickListener(this) {
                                            final /* synthetic */ dx oyR;

                                            {
                                                this.oyR = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                this.oyR.aXH.finish();
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    case 43:
                    case 62:
                        String str2 = "MicroMsg.RevokeMsgListener";
                        String str3 = "ashutest::revoke msg, type %s, isWorkerThread %B";
                        Object[] objArr = new Object[2];
                        objArr[0] = this.oyQ;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == ak.vA().htb.getLooper());
                        v.v(str2, str3, objArr);
                        switch (this.oyQ) {
                            case VIDEO_GALLERY:
                                aG(bxVar);
                                if (this.aXH instanceof ImageGalleryUI) {
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) this.aXH;
                                    if (!(imageGalleryUI.ozG != null && b.aI(bxVar) && bxVar.field_msgId == imageGalleryUI.ozG.bGt().field_msgId)) {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        imageGalleryUI.xL(imageGalleryUI.bGP());
                                        com.tencent.mm.ui.base.g.a(this.aXH, str, SQLiteDatabase.KeyEmpty, false, new OnClickListener(this) {
                                            final /* synthetic */ dx oyR;

                                            {
                                                this.oyR = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                this.oyR.aXH.finish();
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            case CHATTING_ITEM_VIDEO:
                                aG(bxVar);
                                break;
                            default:
                                break;
                        }
                    default:
                        break;
                }
            }
            v.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        }
        return false;
    }

    private static void aG(at atVar) {
        com.tencent.mm.as.n lp = p.lp(atVar.field_imgPath);
        if (lp != null) {
            try {
                g.DZ().iq(d.a("downvideo", lp.dhH, lp.Ld(), lp.getFileName()));
                v.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", Boolean.valueOf(true));
                com.tencent.mm.as.t.a KY = k.KY();
                ak.vy().c(KY.dit);
                KY.pu();
                k.KV().la(lp.getFileName());
            } catch (Throwable e) {
                v.a("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e.getMessage());
            }
        }
    }
}
