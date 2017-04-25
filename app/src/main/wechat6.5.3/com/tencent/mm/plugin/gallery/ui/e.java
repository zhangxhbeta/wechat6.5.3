package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.be;

final class e {
    int dWm = -1;
    private c ggy;

    public e(c cVar) {
        this.ggy = cVar;
    }

    final void lr(int i) {
        c cVar = this.ggy;
        if (cVar.geJ != null && cVar.geJ.size() > i && i >= 0) {
            long j = ((MediaItem) cVar.geJ.get(i)).gea;
            String str = ((MediaItem) cVar.geJ.get(i)).gdZ;
            String str2 = ((MediaItem) cVar.geJ.get(i)).gdY;
            if (be.kS(str)) {
                str = str2;
            }
            c.aqm().b(str, ((MediaItem) cVar.geJ.get(i)).getType(), str2, j);
        }
    }
}
