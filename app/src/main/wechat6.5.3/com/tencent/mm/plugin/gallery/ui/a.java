package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.gridviewheaders.e;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map.Entry;

public final class a extends BaseAdapter implements e {
    private SimpleDateFormat eXY = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    int geH = 9;
    com.tencent.mm.plugin.gallery.stub.a geI = null;
    ArrayList<MediaItem> geJ = new ArrayList();
    ArrayList<MediaItem> geK = new ArrayList();
    private b geL;
    int geM;
    LinkedList<a> geN = new LinkedList();
    boolean geO = false;
    private OnClickListener geP = new OnClickListener(this) {
        final /* synthetic */ a geR;

        {
            this.geR = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r12) {
            /*
            r11 = this;
            r10 = 2131757446; // 0x7f100986 float:1.9145828E38 double:1.0532281193E-314;
            r9 = 2131758989; // 0x7f100f8d float:1.9148958E38 double:1.0532288817E-314;
            r2 = 1;
            r3 = 0;
            r0 = 2131757447; // 0x7f100987 float:1.914583E38 double:1.05322812E-314;
            r0 = r12.getTag(r0);
            r0 = (java.lang.Integer) r0;
            r1 = r11.geR;
            r1 = r1.geJ;
            r4 = r0.intValue();
            r1 = r1.get(r4);
            r1 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r1;
            r4 = "MicroMsg.AlbumAdapter";
            r5 = new java.lang.StringBuilder;
            r6 = "click Image path:";
            r5.<init>(r6);
            r6 = r1.gdY;
            r5 = r5.append(r6);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.v.i(r4, r5);
            r4 = r11.geR;
            r4 = r4.geK;
            r4 = r4.contains(r1);
            if (r4 == 0) goto L_0x0090;
        L_0x0045:
            r4 = r11.geR;
            r4 = r4.geK;
            r4.remove(r1);
            r1 = r2;
            r4 = r3;
        L_0x0050:
            if (r4 != 0) goto L_0x014f;
        L_0x0052:
            r4 = r11.geR;
            r4 = r4.geL;
            if (r4 == 0) goto L_0x006f;
        L_0x005a:
            r4 = r11.geR;
            r4 = r4.geL;
            r5 = r11.geR;
            r5 = r5.geK;
            r5 = r5.size();
            r0 = r0.intValue();
            r4.A(r5, r0, r1);
        L_0x006f:
            if (r2 != r1) goto L_0x01f0;
        L_0x0071:
            r0 = r12.getTag(r10);
            r0 = (android.widget.CheckBox) r0;
            r0.setChecked(r3);
            r0 = r12.getTag(r9);
            r0 = (android.view.View) r0;
            r0.setVisibility(r3);
            r0 = r12.getTag(r9);
            r0 = (android.view.View) r0;
            r1 = 2130838415; // 0x7f02038f float:1.7281812E38 double:1.0527740577E-314;
            r0.setBackgroundResource(r1);
        L_0x008f:
            return;
        L_0x0090:
            r4 = com.tencent.mm.plugin.gallery.model.c.aqn();
            r4 = r4.aqL();
            r5 = 3;
            if (r4 != r5) goto L_0x0130;
        L_0x009b:
            if (r1 == 0) goto L_0x0130;
        L_0x009d:
            r4 = r1.mMimeType;
            r5 = "image/gif";
            r4 = r4.equalsIgnoreCase(r5);
            if (r4 == 0) goto L_0x0130;
        L_0x00a8:
            r4 = new com.tencent.mm.plugin.gif.d;
            r5 = r1.gdY;
            r4.<init>(r5);
            r5 = r1.gdY;
            r5 = com.tencent.mm.a.e.aQ(r5);
            if (r5 == 0) goto L_0x00c3;
        L_0x00b7:
            r6 = r11.geR;	 Catch:{ Exception -> 0x0123 }
            r6 = r6.geI;	 Catch:{ Exception -> 0x0123 }
            r6 = r6.sJ();	 Catch:{ Exception -> 0x0123 }
            if (r5 > r6) goto L_0x00e5;
        L_0x00c3:
            r6 = r4.gCp;	 Catch:{ Exception -> 0x0123 }
            r7 = 0;
            r6 = r6[r7];	 Catch:{ Exception -> 0x0123 }
            r7 = r11.geR;	 Catch:{ Exception -> 0x0123 }
            r7 = r7.geI;	 Catch:{ Exception -> 0x0123 }
            r7 = r7.sI();	 Catch:{ Exception -> 0x0123 }
            if (r6 > r7) goto L_0x00e5;
        L_0x00d4:
            r4 = r4.gCp;	 Catch:{ Exception -> 0x0123 }
            r6 = 1;
            r4 = r4[r6];	 Catch:{ Exception -> 0x0123 }
            r6 = r11.geR;	 Catch:{ Exception -> 0x0123 }
            r6 = r6.geI;	 Catch:{ Exception -> 0x0123 }
            r6 = r6.sI();	 Catch:{ Exception -> 0x0123 }
            if (r4 <= r6) goto L_0x0130;
        L_0x00e5:
            r0 = r11.geR;	 Catch:{ Exception -> 0x0123 }
            r0 = r0.geI;	 Catch:{ Exception -> 0x0123 }
            r1 = 13459; // 0x3493 float:1.886E-41 double:6.6496E-320;
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0123 }
            r2.<init>();	 Catch:{ Exception -> 0x0123 }
            r2 = r2.append(r5);	 Catch:{ Exception -> 0x0123 }
            r3 = ",1,";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x0123 }
            r3 = ",0";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x0123 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x0123 }
            r0.Q(r1, r2);	 Catch:{ Exception -> 0x0123 }
            r0 = r11.geR;	 Catch:{ Exception -> 0x0123 }
            r0 = r0.mContext;	 Catch:{ Exception -> 0x0123 }
            r1 = r11.geR;	 Catch:{ Exception -> 0x0123 }
            r1 = r1.mContext;	 Catch:{ Exception -> 0x0123 }
            r2 = 2131233045; // 0x7f080915 float:1.8082216E38 double:1.052969031E-314;
            r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0123 }
            com.tencent.mm.ui.base.g.bf(r0, r1);	 Catch:{ Exception -> 0x0123 }
            goto L_0x008f;
        L_0x0123:
            r0 = move-exception;
            r1 = "MicroMsg.AlbumAdapter";
            r0 = com.tencent.mm.sdk.platformtools.be.e(r0);
            com.tencent.mm.sdk.platformtools.v.e(r1, r0);
            goto L_0x008f;
        L_0x0130:
            r4 = r11.geR;
            r4 = r4.geK;
            r4 = r4.size();
            r5 = r11.geR;
            r5 = r5.geH;
            if (r4 >= r5) goto L_0x0210;
        L_0x0142:
            r4 = r11.geR;
            r4 = r4.geK;
            r4.add(r1);
            r1 = r3;
            r4 = r3;
            goto L_0x0050;
        L_0x014f:
            r0 = r11.geR;
            r0 = r0.geM;
            if (r0 != r2) goto L_0x0187;
        L_0x0157:
            r0 = r11.geR;
            r0 = r0.mContext;
            r4 = r11.geR;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = 2131361804; // 0x7f0a000c float:1.834337E38 double:1.053032646E-314;
            r6 = r11.geR;
            r6 = r6.geH;
            r7 = new java.lang.Object[r2];
            r8 = r11.geR;
            r8 = r8.geH;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.g.bf(r0, r4);
            goto L_0x006f;
        L_0x0187:
            r0 = r11.geR;
            r0 = r0.geM;
            r4 = 2;
            if (r0 != r4) goto L_0x01c0;
        L_0x0190:
            r0 = r11.geR;
            r0 = r0.mContext;
            r4 = r11.geR;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = 2131361806; // 0x7f0a000e float:1.8343375E38 double:1.053032647E-314;
            r6 = r11.geR;
            r6 = r6.geH;
            r7 = new java.lang.Object[r2];
            r8 = r11.geR;
            r8 = r8.geH;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.g.bf(r0, r4);
            goto L_0x006f;
        L_0x01c0:
            r0 = r11.geR;
            r0 = r0.mContext;
            r4 = r11.geR;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = 2131361805; // 0x7f0a000d float:1.8343373E38 double:1.0530326467E-314;
            r6 = r11.geR;
            r6 = r6.geH;
            r7 = new java.lang.Object[r2];
            r8 = r11.geR;
            r8 = r8.geH;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.g.bf(r0, r4);
            goto L_0x006f;
        L_0x01f0:
            r0 = r12.getTag(r10);
            r0 = (android.widget.CheckBox) r0;
            r0.setChecked(r2);
            r0 = r12.getTag(r9);
            r0 = (android.view.View) r0;
            r0.setVisibility(r3);
            r0 = r12.getTag(r9);
            r0 = (android.view.View) r0;
            r1 = 2131689781; // 0x7f0f0135 float:1.9008587E38 double:1.0531946884E-314;
            r0.setBackgroundResource(r1);
            goto L_0x008f;
        L_0x0210:
            r1 = r2;
            r4 = r2;
            goto L_0x0050;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.a.2.onClick(android.view.View):void");
        }
    };
    Context mContext;

    public interface a {
        View getView();
    }

    public interface b {
        void A(int i, int i2, int i3);
    }

    private static class c implements Runnable {
        private static HashMap<TextView, c> geV = new HashMap();
        private WeakReference<TextView> geS;
        private VideoMediaItem geT;
        private a geU;

        private interface a {
            void a(c cVar, int i);
        }

        private c(TextView textView, VideoMediaItem videoMediaItem, a aVar) {
            this.geS = new WeakReference(textView);
            this.geT = videoMediaItem;
            this.geU = aVar;
        }

        private void e(TextView textView) {
            this.geS = new WeakReference(textView);
        }

        static void a(TextView textView, VideoMediaItem videoMediaItem) {
            Entry entry = null;
            if (textView == null || videoMediaItem == null) {
                v.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
                return;
            }
            if (geV.containsKey(textView)) {
                c cVar = (c) geV.get(textView);
                if (!cVar.geT.equals(videoMediaItem)) {
                    if (textView.equals(cVar.geS.get())) {
                        cVar.e(null);
                    }
                } else {
                    return;
                }
            }
            if (videoMediaItem.gee >= 0) {
                v.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[]{Integer.valueOf(videoMediaItem.gee), videoMediaItem});
                c(textView, videoMediaItem.gee);
                geV.remove(textView);
                return;
            }
            textView.setText("");
            Runnable cVar2 = new c(textView, videoMediaItem, new a() {
                public final void a(c cVar, int i) {
                    if (cVar != null && cVar.geS != null) {
                        TextView textView = (TextView) cVar.geS.get();
                        if (textView != null) {
                            c.c(textView, i);
                            c.geV.remove(textView);
                        }
                    }
                }
            });
            if (com.tencent.mm.sdk.i.e.M(cVar2)) {
                v.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
                for (Entry entry2 : geV.entrySet()) {
                    if (cVar2.equals(entry2.getValue())) {
                        entry = entry2;
                        break;
                    }
                }
                if (entry == null || entry.getValue() == null) {
                    v.e("MicroMsg.AlbumAdapter", "no entry found");
                    return;
                }
                ((c) entry.getValue()).e(textView);
                geV.remove(entry.getKey());
                geV.put(textView, entry.getValue());
                return;
            }
            com.tencent.mm.sdk.i.e.a(cVar2, "load_duration_for_" + videoMediaItem.gdY);
            geV.put(textView, cVar2);
        }

        private static void c(TextView textView, int i) {
            if (textView != null) {
                if (i < 0) {
                    textView.setText("--:--");
                    return;
                }
                textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(i / 60000), Integer.valueOf(Math.round(((float) (i % 60000)) / 1000.0f))}));
            }
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.geT.equals(((c) obj).geT);
        }

        public final int hashCode() {
            return this.geT.hashCode();
        }

        public final void run() {
            MediaMetadataRetriever mediaMetadataRetriever;
            Throwable e;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.geT.aqB());
                    this.geT.gee = be.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.AlbumAdapter", e2, "%s", new Object[]{e2.getMessage()});
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        v.a("MicroMsg.AlbumAdapter", e2, "Analysis duration of mediaItem %s error %s", new Object[]{this.geT.gdY, e2.getMessage()});
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e22) {
                                v.a("MicroMsg.AlbumAdapter", e22, "%s", new Object[]{e22.getMessage()});
                            }
                        }
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ c geW;

                                {
                                    this.geW = r1;
                                }

                                public final void run() {
                                    if (this.geW.geU != null) {
                                        this.geW.geU.a(this.geW, this.geW.geT.gee);
                                    }
                                }
                            });
                        } else if (this.geU == null) {
                            this.geU.a(this, this.geT.gee);
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e4) {
                                v.a("MicroMsg.AlbumAdapter", e4, "%s", new Object[]{e4.getMessage()});
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                mediaMetadataRetriever = null;
                v.a("MicroMsg.AlbumAdapter", e22, "Analysis duration of mediaItem %s error %s", new Object[]{this.geT.gdY, e22.getMessage()});
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    ad.o(/* anonymous class already generated */);
                } else if (this.geU == null) {
                    this.geU.a(this, this.geT.gee);
                }
            } catch (Throwable th2) {
                e22 = th2;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw e22;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ad.o(/* anonymous class already generated */);
            } else if (this.geU == null) {
                this.geU.a(this, this.geT.gee);
            }
        }
    }

    private static class d {
        public ImageView geX;
        public ImageView geY;
        public RelativeLayout geZ;
        public TextView gfa;
        public CheckBox gfb;
        public View gfc;
        public ImageView gfd;
        public ImageView gfe;

        private d() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return lk(i);
    }

    public a(Context context, b bVar) {
        this.mContext = context;
        this.geL = bVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            v.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            return;
        }
        this.geN.remove(aVar);
        this.geN.add(aVar);
    }

    public final ArrayList<String> aqO() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.geK.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).gdY);
        }
        return arrayList;
    }

    public final void D(ArrayList<String> arrayList) {
        v.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", new Object[]{this.geK});
        this.geK.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.a(0, 0, str, str, "");
                if (com.tencent.mm.plugin.gallery.model.c.aqq() != null) {
                    int indexOf = com.tencent.mm.plugin.gallery.model.c.aqq().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aqq().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.geK.add(MediaItem.a(2, 0, str, "", ""));
                        }
                    }
                }
                v.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                int i = 1;
                long j = 0;
                String str2 = str;
                this.geK.add(MediaItem.a(i, j, str2, "", ""));
            }
        }
        v.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", new Object[]{this.geK});
    }

    public final ArrayList<MediaItem> lj(int i) {
        ArrayList<MediaItem> arrayList = new ArrayList();
        Iterator it = this.geJ.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        return arrayList;
    }

    public final int getCount() {
        return this.geN.size() + this.geJ.size();
    }

    public final int getViewTypeCount() {
        return this.geN.size() + 1;
    }

    public final int getItemViewType(int i) {
        return i < this.geN.size() ? i : this.geN.size();
    }

    public final MediaItem lk(int i) {
        if (i < this.geN.size()) {
            v.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int size = i - this.geN.size();
        if (size < this.geJ.size()) {
            return (MediaItem) this.geJ.get(size);
        }
        v.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[]{Integer.valueOf(this.geJ.size()), Integer.valueOf(size)});
        MediaItem imageMediaItem = new ImageMediaItem();
        imageMediaItem.geb = be.Ni();
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        v.v("MicroMsg.AlbumAdapter", "duanyi getview index[%d] header size[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.geN.size())});
        if (i < this.geN.size()) {
            v.i("MicroMsg.AlbumAdapter", "position[%d], get header view", new Object[]{Integer.valueOf(i)});
            return ((a) this.geN.get(i)).getView();
        }
        View inflate;
        d dVar;
        int size = i - this.geN.size();
        MediaItem mediaItem = (MediaItem) this.geJ.get(size);
        v.i("MicroMsg.AlbumAdapter", "addtime:%s", new Object[]{Long.valueOf(mediaItem.geb)});
        if (view == null || !(view.getTag() instanceof d)) {
            String str = "MicroMsg.AlbumAdapter";
            String str2 = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            v.d(str, str2, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(2130904303, viewGroup, false);
            d dVar2 = new d();
            dVar2.geX = (ImageView) inflate.findViewById(2131758985);
            dVar2.geY = (ImageView) inflate.findViewById(2131756015);
            dVar2.geZ = (RelativeLayout) inflate.findViewById(2131757492);
            dVar2.gfa = (TextView) inflate.findViewById(2131758987);
            dVar2.gfb = (CheckBox) inflate.findViewById(2131757446);
            dVar2.gfc = inflate.findViewById(2131757447);
            dVar2.gfd = (ImageView) inflate.findViewById(2131758989);
            dVar2.gfc.setOnClickListener(this.geP);
            dVar2.gfc.setTag(2131757446, dVar2.gfb);
            dVar2.gfc.setTag(2131758989, dVar2.gfd);
            if (com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 0 || com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 5 || com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 10 || com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 11) {
                dVar2.gfb.setVisibility(8);
                dVar2.gfc.setVisibility(8);
                dVar2.gfd.setVisibility(8);
            }
            dVar2.gfe = (ImageView) inflate.findViewById(2131758988);
            inflate.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            v.e("MicroMsg.AlbumAdapter", "get item failed");
            return inflate;
        }
        dVar.geX.setVisibility(0);
        if (mediaItem.getType() == 2) {
            dVar.geZ.setVisibility(0);
            c.a(dVar.gfa, (VideoMediaItem) mediaItem);
        } else {
            dVar.geZ.setVisibility(8);
        }
        str2 = mediaItem.aqB();
        String str3 = mediaItem.gdY;
        if (be.kS(str2) && be.kS(str3)) {
            v.e("MicroMsg.AlbumAdapter", "null or nil filepath: " + size);
            return inflate;
        }
        dVar.gfc.setTag(2131757447, Integer.valueOf(size));
        int i2 = 2131234177;
        if (mediaItem.getType() == 2) {
            i2 = 2131235803;
        }
        v.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", new Object[]{str2, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.geN.size()), this.eXY.format(new Date(mediaItem.geb))})});
        dVar.geY.setContentDescription(r2);
        final ImageView imageView = dVar.geX;
        f.a(dVar.geY, mediaItem.getType(), str2, str3, mediaItem.gea, -1, new com.tencent.mm.plugin.gallery.ui.f.a(this) {
            final /* synthetic */ a geR;

            public final void aqP() {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
        });
        if (this.geO) {
            if (mediaItem.getType() == 2) {
                dVar.gfb.setVisibility(8);
                dVar.gfc.setVisibility(8);
                dVar.gfd.setVisibility(8);
            } else if (this.geK.contains(mediaItem)) {
                dVar.gfb.setChecked(true);
                dVar.gfd.setBackgroundResource(2131689781);
                dVar.gfc.setVisibility(0);
                dVar.gfb.setVisibility(0);
                dVar.gfd.setVisibility(0);
            } else {
                dVar.gfb.setChecked(false);
                dVar.gfd.setBackgroundResource(2130838415);
                dVar.gfb.setVisibility(0);
                dVar.gfc.setVisibility(0);
                dVar.gfd.setVisibility(0);
            }
        } else if (this.geK.contains(mediaItem)) {
            dVar.gfb.setChecked(true);
            dVar.gfd.setVisibility(0);
            dVar.gfd.setBackgroundResource(2131689781);
        } else {
            dVar.gfb.setChecked(false);
            dVar.gfd.setVisibility(0);
            dVar.gfd.setBackgroundResource(2130838415);
        }
        if ((com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 3 || com.tencent.mm.plugin.gallery.model.c.aqn().aqL() == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            dVar.gfe.setVisibility(0);
        } else {
            dVar.gfe.setVisibility(8);
        }
        return inflate;
    }

    public final long jw(int i) {
        if (i < this.geN.size()) {
            v.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.geN.size();
        }
        Date date = new Date(lk(i).geb);
        com.tencent.mm.ui.tools.gridviewheaders.a bJA = com.tencent.mm.ui.tools.gridviewheaders.a.bJA();
        long b = date.getTime() >= bJA.oVE ? Long.MAX_VALUE : date.getTime() >= bJA.oVF ? 9223372036854775806L : com.tencent.mm.ui.tools.gridviewheaders.a.b(date);
        v.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(r2.geb), date, Long.valueOf(b)});
        return b;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        View textView;
        if (i < this.geN.size()) {
            v.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.geN.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(2130838468);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493199);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(2131493199);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(2131689729));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(2131493128));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        v.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(r0.geb), new Date(lk(i).geb), com.tencent.mm.ui.tools.gridviewheaders.a.bJA().a(new Date(lk(i).geb), this.mContext)});
        ((TextView) textView).setText(r3);
        return textView;
    }
}
