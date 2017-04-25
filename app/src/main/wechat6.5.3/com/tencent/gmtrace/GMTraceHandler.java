package com.tencent.gmtrace;

import java.util.List;

public abstract class GMTraceHandler {
    public abstract List<Integer> getPointId();

    public abstract void postBufferData(boolean z);

    public abstract void syncDo(int i, long j);
}
