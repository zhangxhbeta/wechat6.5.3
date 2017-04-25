package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c extends t {
    private Bitmap aQs = null;
    ArrayList<MediaItem> geJ = new ArrayList();
    ArrayList<String> gfX = new ArrayList();
    boolean gfY;
    HashSet<String> gfZ = new HashSet();
    private HashMap<String, WeakReference<b>> gga = new HashMap();
    public e ggb = new e(this);
    public d ggc = new d(this);
    Context mContext;

    class a implements OnClickListener {
        private String filePath;
        final /* synthetic */ c ggd;

        public a(c cVar, String str) {
            this.ggd = cVar;
            this.filePath = str;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(this.filePath)), "video/*");
            try {
                this.ggd.mContext.startActivity(intent);
            } catch (Exception e) {
            }
        }
    }

    static class b {
        ImageView fSI;
        MultiTouchImageView gge;
        TextView ggf;

        b() {
        }
    }

    public final /* synthetic */ Object d(int i, View view) {
        b bVar;
        String str;
        MediaItem mediaItem;
        String str2;
        long Nj = be.Nj();
        if (view == null) {
            view = View.inflate(this.mContext, 2130903798, null);
            b bVar2 = new b();
            bVar2.gge = (MultiTouchImageView) view.findViewById(2131755052);
            bVar2.fSI = (ImageView) view.findViewById(2131757492);
            bVar2.ggf = (TextView) view.findViewById(2131757493);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        String str3;
        if (this.gfY) {
            MediaItem mediaItem2 = (MediaItem) this.geJ.get(i);
            str3 = mediaItem2.gdY;
            str = mediaItem2.gdZ;
            mediaItem = mediaItem2;
            str2 = str3;
        } else {
            str3 = (String) this.gfX.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aqq() != null) {
                int indexOf = com.tencent.mm.plugin.gallery.model.c.aqq().indexOf(MediaItem.a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aqq().get(indexOf);
                    str = null;
                    str2 = str3;
                }
            }
            mediaItem = null;
            str = null;
            str2 = str3;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.ggf.setText(this.mContext.getString(2131233021, new Object[]{be.aw(new File(str2).length())}));
                bVar.ggf.setVisibility(0);
            } else {
                bVar.ggf.setVisibility(8);
            }
            bVar.fSI.setVisibility(8);
            bVar.fSI.setOnClickListener(null);
        } else {
            bVar.ggf.setVisibility(8);
            bVar.fSI.setVisibility(0);
            bVar.fSI.setOnClickListener(new a(this, str2));
            if (com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 4) {
                Runnable mVar = new m(mediaItem.gdY, i, (VideoMediaItem) mediaItem, null);
                if (e.M(mVar)) {
                    v.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", new Object[]{Integer.valueOf(16842794)});
                } else {
                    e.a(mVar, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView;
        if (com.tencent.mm.plugin.gallery.model.c.aqn().aqL() != 3 || (!(mediaItem == null && o.JZ(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            com.tencent.mm.plugin.gallery.model.c.aqo().aqA();
            if (this.ggc.ggr.aI(str2)) {
                bitmap = (Bitmap) this.ggc.ggr.get(str2);
                if (!bitmap.isRecycled()) {
                    a(bVar.gge, bitmap);
                }
            }
            bitmap = com.tencent.mm.plugin.gallery.model.c.aqm().tU(be.kS(str) ? str2 : str);
            if (bitmap == null) {
                multiTouchImageView = bVar.gge;
                if (this.aQs == null || this.aQs.isRecycled()) {
                    this.aQs = BitmapFactory.decodeResource(this.mContext.getResources(), 2130838891);
                }
                a(multiTouchImageView, this.aQs);
            } else {
                a(bVar.gge, bitmap);
            }
            if (!this.gfZ.contains(str2)) {
                this.gfZ.add(str2);
                d dVar = this.ggc;
                MultiTouchImageView multiTouchImageView2 = bVar.gge;
                if (!dVar.sR.contains(str2)) {
                    int hashCode = multiTouchImageView2.hashCode();
                    dVar.lq(hashCode);
                    dVar.ggo.put(str2, Integer.valueOf(hashCode));
                    dVar.ggp.put(hashCode, str2);
                    dVar.ggn.put(hashCode, new WeakReference(multiTouchImageView2));
                    dVar.sR.add(str2);
                    dVar.aqW();
                }
            }
        } else {
            multiTouchImageView = bVar.gge;
            multiTouchImageView.oak = true;
            try {
                multiTouchImageView.oal = com.tencent.mm.plugin.gif.b.atw().bL(str2, str2);
                multiTouchImageView.setImageDrawable(multiTouchImageView.oal);
                multiTouchImageView.di(multiTouchImageView.oal.getIntrinsicWidth(), multiTouchImageView.oal.getIntrinsicHeight());
            } catch (Exception e) {
                multiTouchImageView.oak = false;
            }
            multiTouchImageView = bVar.gge;
            if (multiTouchImageView.oak && multiTouchImageView.oal != null) {
                multiTouchImageView.oal.stop();
                multiTouchImageView.oal.start();
            }
            bVar.gge.ah(1.0f);
            bVar.gge.jOS = false;
            if (VERSION.SDK_INT == 20) {
                bVar.gge.setLayerType(1, null);
            } else {
                k.h(bVar.gge, bVar.gge.getWidth(), bVar.gge.getHeight());
            }
            bVar.gge.requestLayout();
        }
        v.v("MicroMsg.ImageAdapter", "test getview: %d", new Object[]{Long.valueOf(be.az(Nj))});
        return view;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        if (this.gfY) {
            return this.geJ.size();
        }
        return this.gfX.size();
    }

    public final MultiTouchImageView lo(int i) {
        View wA = super.wA(i);
        if (wA == null) {
            v.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        } else if (wA == null || wA.getVisibility() == 8) {
            return null;
        } else {
            wA = wA.findViewById(2131755052);
            if (wA == null) {
                return null;
            }
            return (MultiTouchImageView) wA;
        }
    }

    public final String hd(int i) {
        if (this.gfY) {
            if (i >= 0 && i < this.geJ.size()) {
                return ((MediaItem) this.geJ.get(i)).gdY;
            }
            v.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.geJ.size())});
            return "";
        } else if (i >= 0 && i < this.gfX.size()) {
            return (String) this.gfX.get(i);
        } else {
            v.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.gfX.size())});
            return "";
        }
    }

    public final MediaItem lp(int i) {
        if (this.gfY) {
            if (i >= 0 && i < this.geJ.size()) {
                return (MediaItem) this.geJ.get(i);
            }
            v.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[]{Integer.valueOf(i), Integer.valueOf(this.geJ.size())});
            return null;
        } else if (i < 0 || i >= this.gfX.size()) {
            v.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.gfX.size())});
            return null;
        } else {
            String str = (String) this.gfX.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aqq() == null) {
                return null;
            }
            int indexOf = com.tencent.mm.plugin.gallery.model.c.aqq().indexOf(MediaItem.a(0, 0, str, str, ""));
            if (indexOf >= 0) {
                return (MediaItem) com.tencent.mm.plugin.gallery.model.c.aqq().get(indexOf);
            }
            return null;
        }
    }

    @TargetApi(11)
    static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        multiTouchImageView.ah(4.5f);
        multiTouchImageView.jOS = false;
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            k.h(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.di(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
    }

    public final void release() {
        detach();
        this.gga.clear();
        this.gfZ.clear();
    }

    public final void detach() {
        super.detach();
        d dVar = this.ggc;
        dVar.ggt = null;
        dVar.ggn.clear();
        dVar.ggq.clear();
        dVar.ggp.clear();
        dVar.ggo.clear();
        dVar.aqU();
    }
}
