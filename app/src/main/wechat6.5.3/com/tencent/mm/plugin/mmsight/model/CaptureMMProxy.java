package com.tencent.mm.plugin.mmsight.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ae.n;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.e;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.io.Serializable;
import java.lang.reflect.Method;

public class CaptureMMProxy extends a {
    private static CaptureMMProxy hlE;
    private static String hlF = "";

    public static void createProxy(CaptureMMProxy captureMMProxy) {
        hlE = captureMMProxy;
    }

    public static CaptureMMProxy getInstance() {
        return hlE;
    }

    public CaptureMMProxy(d dVar) {
        super(dVar);
    }

    public String getAccVideoPath() {
        String str = (String) REMOTE_CALL("getAccVideoPathInMM", new Object[0]);
        v.i("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM " + str + " accVideoPath: " + hlF);
        if (!be.kS(str)) {
            hlF = str;
        }
        if (be.kS(hlF)) {
            return str;
        }
        return hlF;
    }

    public String getSubCoreImageFullPath(String str) {
        String str2 = (String) REMOTE_CALL("getSubCoreImageFullPathInMM", str);
        v.i("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPath " + str2);
        return str2;
    }

    public Object get(t.a aVar, Object obj) {
        v.i("MicroMsg.CaptureMMProxy", "get %s %s", new Object[]{aVar, obj});
        Object REMOTE_CALL = REMOTE_CALL("getConfigStorage", aVar, obj);
        v.i("MicroMsg.CaptureMMProxy", "get %s %s and get val %s", new Object[]{aVar, obj, REMOTE_CALL});
        return REMOTE_CALL == null ? obj : REMOTE_CALL;
    }

    public boolean set(t.a aVar, Object obj) {
        Boolean bool = (Boolean) REMOTE_CALL("setConfigStorage", aVar, obj);
        v.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[]{aVar, obj});
        return bool.booleanValue();
    }

    public VideoTransPara getSnsAlbumVideoTransPara() {
        Parcelable parcelable = (Parcelable) REMOTE_CALL("getSnsAlbumVideoTransParaInMM", new Object[0]);
        v.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransPara() returned: " + parcelable);
        return (VideoTransPara) parcelable;
    }

    public String getDeviceInfoConfig() {
        v.i("MicroMsg.CaptureMMProxy", "getDeviceInfoConfig return: %s", new Object[]{(String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0])});
        return (String) REMOTE_CALL("getDeviceInfoConfigInMM", new Object[0]);
    }

    public String getDynamicConfig(String str) {
        v.i("MicroMsg.CaptureMMProxy", "getDynamicConfig, key: %s, value: %s", new Object[]{str, (String) REMOTE_CALL("getDynamicConfigInMM", str)});
        return (String) REMOTE_CALL("getDynamicConfigInMM", str);
    }

    public byte[] getWeixinMeta() {
        v.i("MicroMsg.CaptureMMProxy", "getWeixinMeta result: %s", new Object[]{(byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0])});
        return (byte[]) REMOTE_CALL("getWeixinMetaDataInMM", new Object[0]);
    }

    @f
    public VideoTransPara getSnsAlbumVideoTransParaInMM() {
        boolean uM = ak.uM();
        v.d("MicroMsg.CaptureMMProxy", "getSnsAlbumVideoTransParaInMM() called");
        if (uM) {
            return (VideoTransPara) new az<VideoTransPara>(this) {
                final /* synthetic */ CaptureMMProxy hlG;

                {
                    this.hlG = r4;
                }

                protected final /* synthetic */ Object run() {
                    VideoTransPara El = com.tencent.mm.modelcontrol.d.En().El();
                    v.d("MicroMsg.CaptureMMProxy", "run() returned: " + El);
                    return El;
                }
            }.c(new ac());
        }
        VideoTransPara El = com.tencent.mm.modelcontrol.d.En().El();
        v.d("MicroMsg.CaptureMMProxy", "getVideoTransParaInMM() returned: " + El);
        return El;
    }

    @f
    public String getAccVideoPathInMM() {
        boolean uM = ak.uM();
        v.d("MicroMsg.CaptureMMProxy", "getAccVideoPathInMM");
        if (uM) {
            return (String) new az<String>(this) {
                final /* synthetic */ CaptureMMProxy hlG;

                {
                    this.hlG = r4;
                }

                protected final /* synthetic */ Object run() {
                    ak.yW();
                    return c.getAccVideoPath();
                }
            }.c(new ac());
        }
        ak.yW();
        return c.getAccVideoPath();
    }

    @f
    public String getSubCoreImageFullPathInMM(final String str) {
        boolean uM = ak.uM();
        v.d("MicroMsg.CaptureMMProxy", "getSubCoreImageFullPathInMM, %s", new Object[]{str});
        if (uM) {
            return (String) new az<String>(this) {
                final /* synthetic */ CaptureMMProxy hlG;

                protected final /* synthetic */ Object run() {
                    return n.GH().iU(str);
                }
            }.c(new ac());
        }
        return n.GH().iU(str);
    }

    @f
    public Object getConfigStorage(int i, final Object obj) {
        final t.a aVar = ((t.a[]) t.a.class.getEnumConstants())[i];
        boolean uM = ak.uM();
        v.d("MicroMsg.CaptureMMProxy", "getConfigStorage, %s %s", new Object[]{aVar, obj});
        if (uM) {
            return new az<Object>(this) {
                final /* synthetic */ CaptureMMProxy hlG;

                protected final Object run() {
                    ak.yW();
                    return c.vf().get(aVar, obj);
                }
            }.c(new ac());
        }
        ak.yW();
        return c.vf().get(aVar, obj);
    }

    @f
    public boolean setConfigStorage(int i, final Object obj) {
        boolean uM = ak.uM();
        final t.a aVar = ((t.a[]) t.a.class.getEnumConstants())[i];
        v.d("MicroMsg.CaptureMMProxy", "setConfigStorage, %s %s", new Object[]{aVar, obj});
        if (uM) {
            return ((Boolean) new az<Boolean>(this) {
                final /* synthetic */ CaptureMMProxy hlG;

                protected final /* synthetic */ Object run() {
                    ak.yW();
                    c.vf().a(aVar, obj);
                    return Boolean.valueOf(true);
                }
            }.c(new ac())).booleanValue();
        }
        ak.yW();
        c.vf().a(aVar, obj);
        return true;
    }

    @f
    public String getDeviceInfoConfigInMM() {
        if (ak.uM()) {
            return (String) new az<String>(this) {
                final /* synthetic */ CaptureMMProxy hlG;

                {
                    this.hlG = r4;
                }

                protected final /* synthetic */ Object run() {
                    ak.yW();
                    return c.vg().bxh();
                }
            }.c(new ac());
        }
        ak.yW();
        return c.vg().bxh();
    }

    @f
    public String getDynamicConfigInMM(String str) {
        return j.sU().getValue(str);
    }

    @f
    public byte[] getWeixinMetaDataInMM() {
        return com.tencent.mm.modelcontrol.d.En().getWeixinMeta();
    }

    protected final Bundle objectsToBundle(Object... objArr) {
        Bundle bundle = new Bundle();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] instanceof Bundle) {
                bundle.putBundle(String.valueOf(i), (Bundle) objArr[i]);
            } else if (objArr[i] instanceof Parcelable) {
                bundle.putParcelable(String.valueOf(i), (Parcelable) objArr[i]);
            } else if (objArr[i] instanceof t.a) {
                bundle.putInt(String.valueOf(i), ((t.a) objArr[i]).ordinal());
            } else {
                bundle.putSerializable(String.valueOf(i), (Serializable) objArr[i]);
            }
        }
        return bundle;
    }

    public void onCallback(String str, Bundle bundle, boolean z) {
        v.d("MicroMsg.CaptureMMProxy", "class:%s, method:%s, clientCall:%B", new Object[]{getClass().getName(), str, Boolean.valueOf(z)});
        Method method = null;
        try {
            for (Method method2 : getClass().getMethods()) {
                if (method2.getName().equalsIgnoreCase(str)) {
                    method = method2;
                    break;
                }
            }
            if (method != null) {
                if (method.isAnnotationPresent(z ? e.class : f.class)) {
                    Object invoke = method.invoke(this, getArgs(bundle));
                    if (method.getReturnType() == Void.TYPE) {
                        return;
                    }
                    if (invoke instanceof Parcelable) {
                        bundle.putParcelable("result_key", (Parcelable) invoke);
                    } else {
                        bundle.putSerializable("result_key", (Serializable) invoke);
                    }
                }
            }
        } catch (Throwable e) {
            v.e("MicroMsg.CaptureMMProxy", "exception:%s", new Object[]{be.e(e)});
        }
    }
}
