package com.tencent.mm.kernel.plugin;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.v;
import junit.framework.Assert;

public abstract class b implements a {
    public static final String TAG = "MMKernel.Plugin";
    private boolean mConfigured = false;
    private boolean mInstalled = false;
    private boolean mMakingDependencies = false;

    public void installed() {
        this.mInstalled = true;
    }

    public void uninstalled() {
        this.mConfigured = false;
        this.mInstalled = false;
    }

    public void invokeDependency() {
        this.mMakingDependencies = true;
        dependency();
        this.mMakingDependencies = false;
    }

    public void invokeConfigure(ProcessProfile processProfile) {
        configure(processProfile);
        this.mConfigured = true;
    }

    public void alias(Class<? extends a> cls) {
        Assert.assertNotNull(cls);
        Assert.assertTrue(cls.isInstance(this));
        g.vx();
        g.vs().a(getClass(), (Class) cls);
    }

    public void dependsOnRoot() {
        if (this.mMakingDependencies) {
            g.vx();
            g.vs().b(getClass(), getClass());
            return;
        }
        v.w(TAG, "Ignore this dependency. It's not dependency phase now!");
    }

    public void dependsOn(Class<? extends a> cls) {
        if (this.mMakingDependencies) {
            g.vx();
            g.vs().b(getClass(), cls);
            return;
        }
        v.w(TAG, "Ignore this dependency. It's not dependency phase now!");
    }

    public String identify() {
        return getClass().getSimpleName();
    }

    public String name() {
        return toString();
    }

    public String[] ofProcesses() {
        return new String[0];
    }
}
