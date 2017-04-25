package com.tencent.qqvideo.proxy.api;

import com.tencent.qqvideo.proxy.common.PlayManagerImp;

public class FactoryProxyManager {
    private static IPlayManager playManager = null;

    public static synchronized IPlayManager getPlayManager() {
        IPlayManager iPlayManager;
        synchronized (FactoryProxyManager.class) {
            if (playManager == null) {
                playManager = new PlayManagerImp();
            }
            iPlayManager = playManager;
        }
        return iPlayManager;
    }
}
