package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class d implements e {
    public int index;
    public SparseArray<c> knV = null;
    public boolean knW = false;
    public b knX;
    a knY;
    public ah knZ = new ah(new a(this) {
        final /* synthetic */ d koa;

        {
            this.koa = r1;
        }

        public final boolean oU() {
            if (this.koa.knW) {
                v.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[]{Integer.valueOf(this.koa.index)});
                this.koa.baO();
                this.koa.knY.a(-1, this.koa.knV, null);
            }
            return false;
        }
    }, false);
    long start;

    public d(int i, a aVar) {
        this.index = i;
        this.knY = aVar;
    }

    public final void baO() {
        this.knX = null;
        this.knW = false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.knX != kVar) {
            v.e("MicroMsg.WorkingTranslate", "not my translate work");
            return;
        }
        int size;
        this.knZ.QI();
        v.d("MicroMsg.WorkingTranslate", "translate take time : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.start)});
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((b) kVar).knM != null) {
            size = ((b) kVar).knM.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        v.d(str2, str3, objArr);
        baO();
        this.knY.a(i2, this.knV, ((b) kVar).knM);
    }
}
