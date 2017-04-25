package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.mm.pluginsdk.j.c;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e implements c {
    private static e aSn = null;
    URISpanHandlerSet aSo;
    ArrayList<BaseUriSpanHandler> aSp = new ArrayList();
    ArrayList<BaseUriSpanHandler> aSq = new ArrayList();
    ArrayList<BaseUriSpanHandler> aSr = new ArrayList();
    Context mContext = null;

    public static e oQ() {
        if (aSn == null) {
            aSn = new e();
        }
        return aSn;
    }

    private e() {
        long Ni = be.Ni();
        v.d("MicroMsg.URISpanHandler", "init URISpanHandler");
        this.mContext = aa.getContext();
        this.aSo = new URISpanHandlerSet(this.mContext);
        for (Class cls : URISpanHandlerSet.class.getDeclaredClasses()) {
            if (cls != null && cls.getSuperclass() != null && cls.isAnnotationPresent(a.class) && cls.getSuperclass().getName().equals(BaseUriSpanHandler.class.getName())) {
                try {
                    a aVar = (a) cls.getAnnotation(a.class);
                    Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[]{URISpanHandlerSet.class});
                    if (declaredConstructor != null) {
                        BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) BaseUriSpanHandler.class.cast(declaredConstructor.newInstance(new Object[]{this.aSo}));
                        PRIORITY oS = aVar.oS();
                        if (oS == PRIORITY.LOW) {
                            this.aSr.add(baseUriSpanHandler);
                        } else if (oS == PRIORITY.NORMAL) {
                            this.aSq.add(baseUriSpanHandler);
                        } else if (oS == PRIORITY.HIGH) {
                            this.aSp.add(baseUriSpanHandler);
                        }
                        v.d("MicroMsg.URISpanHandler", "successfully add: %s", cls.getName());
                    } else {
                        v.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", cls.getName());
                    }
                } catch (Throwable e) {
                    v.a("MicroMsg.URISpanHandler", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    v.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", cls.getName(), e.getMessage(), e.getClass().getName());
                }
            }
        }
        v.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", Long.valueOf(be.Ni() - Ni));
    }

    public final h r(Context context, String str) {
        v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", str, Integer.valueOf(this.aSp.size()), Integer.valueOf(this.aSq.size()), Integer.valueOf(this.aSr.size()));
        if (context == null) {
            v.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
            this.aSo.mContext = null;
            return null;
        }
        this.mContext = context;
        this.aSo.mContext = this.mContext;
        if (be.kS(str)) {
            v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
            this.mContext = null;
            this.aSo.mContext = null;
            return null;
        }
        Iterator it = this.aSp.iterator();
        while (it.hasNext()) {
            h bw = ((BaseUriSpanHandler) it.next()).bw(str);
            if (bw != null) {
                v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(bw.type));
                this.mContext = null;
                this.aSo.mContext = null;
                return bw;
            }
        }
        it = this.aSq.iterator();
        while (it.hasNext()) {
            bw = ((BaseUriSpanHandler) it.next()).bw(str);
            if (bw != null) {
                v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(bw.type));
                this.mContext = null;
                this.aSo.mContext = null;
                return bw;
            }
        }
        it = this.aSr.iterator();
        while (it.hasNext()) {
            bw = ((BaseUriSpanHandler) it.next()).bw(str);
            if (bw != null) {
                v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", Integer.valueOf(bw.type));
                this.mContext = null;
                this.aSo.mContext = null;
                return bw;
            }
        }
        this.mContext = null;
        this.aSo.mContext = null;
        v.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
        return null;
    }

    public final boolean a(Context context, h hVar, b bVar) {
        if (hVar == null) {
            v.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
            return false;
        }
        String str = "MicroMsg.URISpanHandler";
        String str2 = "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(hVar.type);
        objArr[1] = Boolean.valueOf(bVar == null);
        objArr[2] = Integer.valueOf(this.aSp.size());
        objArr[3] = Integer.valueOf(this.aSq.size());
        objArr[4] = Integer.valueOf(this.aSr.size());
        v.d(str, str2, objArr);
        if (context == null) {
            v.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
            this.aSo.mContext = null;
            return false;
        }
        this.mContext = context;
        this.aSo.mContext = this.mContext;
        Iterator it = this.aSp.iterator();
        while (it.hasNext()) {
            BaseUriSpanHandler baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.oR(), hVar.type) && baseUriSpanHandler.a(hVar, bVar)) {
                v.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.aSo.mContext = null;
                return true;
            }
        }
        it = this.aSq.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.oR(), hVar.type) && baseUriSpanHandler.a(hVar, bVar)) {
                v.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.aSo.mContext = null;
                return true;
            }
        }
        it = this.aSr.iterator();
        while (it.hasNext()) {
            baseUriSpanHandler = (BaseUriSpanHandler) it.next();
            if (b(baseUriSpanHandler.oR(), hVar.type) && baseUriSpanHandler.a(hVar, bVar)) {
                v.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", baseUriSpanHandler.getClass().getName());
                this.mContext = null;
                this.aSo.mContext = null;
                return true;
            }
        }
        this.mContext = null;
        this.aSo.mContext = null;
        v.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
        return false;
    }

    private static boolean b(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
