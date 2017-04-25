package com.tencent.tinker.loader.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.SystemClock;
import com.tencent.tinker.loader.TinkerLoader;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.TinkerUncaughtHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.Serializable;

public abstract class TinkerApplication extends Application {
    private static final String INTENT_PATCH_EXCEPTION = "intent_patch_exception";
    private static final int TINKER_DISABLE = 0;
    private static final String TINKER_LOADER_METHOD = "tryLoad";
    private long applicationStartElapsedTime;
    private long applicationStartMillisTime;
    private AssetManager[] assetManager;
    private ClassLoader[] classLoader;
    private Object delegate;
    private final String delegateClassName;
    private final String loaderClassName;
    private Resources[] resources;
    private final int tinkerFlags;
    private final boolean tinkerLoadVerifyFlag;
    private Intent tinkerResultIntent;
    private boolean useSafeMode;

    protected TinkerApplication(int i) {
        this(i, "com.tencent.tinker.loader.app.DefaultApplicationLike", TinkerLoader.class.getName(), false);
    }

    public TinkerApplication(int i, String str, String str2, boolean z) {
        this.delegate = null;
        this.resources = new Resources[1];
        this.classLoader = new ClassLoader[1];
        this.assetManager = new AssetManager[1];
        this.tinkerFlags = i;
        this.delegateClassName = str;
        this.loaderClassName = str2;
        this.tinkerLoadVerifyFlag = z;
    }

    protected TinkerApplication(int i, String str) {
        this(i, str, TinkerLoader.class.getName(), false);
    }

    private Object createDelegate() {
        try {
            return Class.forName(this.delegateClassName, false, getClassLoader()).getConstructor(new Class[]{Application.class, Integer.TYPE, Boolean.TYPE, Long.TYPE, Long.TYPE, Intent.class, Resources[].class, ClassLoader[].class, AssetManager[].class}).newInstance(new Object[]{this, Integer.valueOf(this.tinkerFlags), Boolean.valueOf(this.tinkerLoadVerifyFlag), Long.valueOf(this.applicationStartElapsedTime), Long.valueOf(this.applicationStartMillisTime), this.tinkerResultIntent, this.resources, this.classLoader, this.assetManager});
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("createDelegate failed", th);
        }
    }

    private synchronized void ensureDelegate() {
        if (this.delegate == null) {
            this.delegate = createDelegate();
        }
    }

    private void onBaseContextAttached(Context context) {
        this.applicationStartElapsedTime = SystemClock.elapsedRealtime();
        this.applicationStartMillisTime = System.currentTimeMillis();
        loadTinker();
        ensureDelegate();
        try {
            ShareReflectUtil.a(this.delegate, "onBaseContextAttached", Context.class).invoke(this.delegate, new Object[]{context});
            if (this.useSafeMode) {
                getSharedPreferences("tinker_own_config_" + ShareTinkerInternals.gx(this), 0).edit().putInt("safe_mode_count", 0).commit();
            }
        } catch (Throwable th) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("onBaseContextAttached method not found", th);
        }
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Thread.setDefaultUncaughtExceptionHandler(new TinkerUncaughtHandler(this));
        onBaseContextAttached(context);
    }

    private void loadTinker() {
        if (this.tinkerFlags != 0) {
            this.tinkerResultIntent = new Intent();
            try {
                Class cls = Class.forName(this.loaderClassName, false, getClassLoader());
                this.tinkerResultIntent = (Intent) cls.getMethod(TINKER_LOADER_METHOD, new Class[]{TinkerApplication.class, Integer.TYPE, Boolean.TYPE}).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[]{this, Integer.valueOf(this.tinkerFlags), Boolean.valueOf(this.tinkerLoadVerifyFlag)});
            } catch (Serializable th) {
                ShareIntentUtil.a(this.tinkerResultIntent, -19);
                this.tinkerResultIntent.putExtra(INTENT_PATCH_EXCEPTION, th);
            }
        }
    }

    private void delegateMethod(String str) {
        if (this.delegate != null) {
            try {
                ShareReflectUtil.a(this.delegate, str, new Class[0]).invoke(this.delegate, new Object[0]);
            } catch (Throwable th) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException(String.format("%s method not found", new Object[]{str}), th);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        ensureDelegate();
        delegateMethod("onCreate");
    }

    public void onTerminate() {
        super.onTerminate();
        delegateMethod("onTerminate");
    }

    public void onLowMemory() {
        super.onLowMemory();
        delegateMethod("onLowMemory");
    }

    private void delegateTrimMemory(int i) {
        if (this.delegate != null) {
            try {
                ShareReflectUtil.a(this.delegate, "onTrimMemory", Integer.TYPE).invoke(this.delegate, new Object[]{Integer.valueOf(i)});
            } catch (Throwable th) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("onTrimMemory method not found", th);
            }
        }
    }

    @TargetApi(14)
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        delegateTrimMemory(i);
    }

    private void delegateConfigurationChanged(Configuration configuration) {
        if (this.delegate != null) {
            try {
                ShareReflectUtil.a(this.delegate, "onConfigurationChanged", Configuration.class).invoke(this.delegate, new Object[]{configuration});
            } catch (Throwable th) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("onConfigurationChanged method not found", th);
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        delegateConfigurationChanged(configuration);
    }

    public Resources getResources() {
        if (this.resources[0] != null) {
            return this.resources[0];
        }
        return super.getResources();
    }

    public ClassLoader getClassLoader() {
        if (this.classLoader[0] != null) {
            return this.classLoader[0];
        }
        return super.getClassLoader();
    }

    public AssetManager getAssets() {
        if (this.assetManager[0] != null) {
            return this.assetManager[0];
        }
        return super.getAssets();
    }

    public void setUseSafeMode(boolean z) {
        this.useSafeMode = z;
    }
}
