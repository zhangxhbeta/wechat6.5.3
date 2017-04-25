package com.tencent.gmtrace;

import android.os.Process;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GMTrace {
    protected static volatile long currentDiffTime;
    private static GMTraceWorker gmTraceWorker;
    private static boolean isInit;
    private static boolean isStartTrace;
    private static long[] mainThreadBuffer;
    private static int mainThreadIndex;
    private static GMTraceBitSet methodInFlagSet;
    private static HashMap<Integer, List<GMTraceHandler>> methodInHandlerMap;
    private static List<GMTraceHandler> methodPostDataHandlerList;
    private static long[] otherThreadBuffer;
    private static AtomicInteger otherThreadIndex;
    protected static long startTime;
    private static HashMap<Integer, String> threadNameMap;
    private static GMTraceBitSet threadNameSet;

    private static class GMTraceWorker implements Runnable {
        private boolean isReady;

        private GMTraceWorker() {
            this.isReady = false;
        }

        public void stop() {
            if (this.isReady) {
                this.isReady = false;
            }
        }

        public void start() {
            if (!this.isReady) {
                this.isReady = true;
                new Thread(this).start();
            }
        }

        public void run() {
            Process.setThreadPriority(0);
            while (this.isReady && GMTrace.isInit) {
                GMTrace.currentDiffTime = System.currentTimeMillis() - GMTrace.startTime;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void i(long j, int i) {
        if (isInit) {
            if (isStartTrace) {
                long id = Thread.currentThread().getId();
                long j2 = (currentDiffTime | (Long.MIN_VALUE | (id << 46))) | j;
                int i2;
                if (id == 1) {
                    i2 = mainThreadIndex + 1;
                    mainThreadIndex = i2;
                    mainThreadIndex = i2 % Constants.MAX_BUFFER_SIZE;
                    mainThreadBuffer[mainThreadIndex] = j2;
                    if (mainThreadIndex % Constants.WRITE_BUFFER_SIZE == 0) {
                        notifyPostData(true);
                    }
                } else {
                    i2 = otherThreadIndex.incrementAndGet() % Constants.MAX_BUFFER_SIZE;
                    otherThreadBuffer[i2] = j2;
                    if (i2 % Constants.WRITE_BUFFER_SIZE == 0) {
                        notifyPostData(false);
                    }
                }
            }
            if (methodInFlagSet != null && methodInFlagSet.get(i)) {
                notifySyncDo(i);
            }
        }
    }

    private static void notifySyncDo(int i) {
        List list = (List) methodInHandlerMap.get(Integer.valueOf(i));
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ((GMTraceHandler) list.get(i2)).syncDo(i, currentDiffTime);
            }
        }
    }

    private static void notifyPostData(boolean z) {
        for (GMTraceHandler postBufferData : methodPostDataHandlerList) {
            postBufferData.postBufferData(z);
        }
    }

    public static void o(long j, int i) {
        if (isInit && isStartTrace) {
            long id = Thread.currentThread().getId();
            long j2 = (currentDiffTime | (0 | (id << 46))) | j;
            int i2;
            if (id == 1) {
                i2 = mainThreadIndex + 1;
                mainThreadIndex = i2;
                mainThreadIndex = i2 % Constants.MAX_BUFFER_SIZE;
                mainThreadBuffer[mainThreadIndex] = j2;
                if (mainThreadIndex % Constants.WRITE_BUFFER_SIZE == 0) {
                    notifyPostData(true);
                    return;
                }
                return;
            }
            i2 = (int) id;
            if (!threadNameSet.get(i2)) {
                threadNameSet.set(i2);
                threadNameMap.put(Integer.valueOf(i2), Thread.currentThread().getName());
            }
            i2 = otherThreadIndex.incrementAndGet() % Constants.MAX_BUFFER_SIZE;
            otherThreadBuffer[i2] = j2;
            if (i2 % Constants.WRITE_BUFFER_SIZE == 0) {
                notifyPostData(false);
            }
        }
    }

    public static void init() {
        if (!isInit) {
            isInit = true;
            startTime = System.currentTimeMillis();
            mainThreadIndex = 0;
            otherThreadIndex = new AtomicInteger(0);
            mainThreadBuffer = new long[Constants.MAX_BUFFER_SIZE];
            otherThreadBuffer = new long[Constants.MAX_BUFFER_SIZE];
            methodInHandlerMap = new HashMap();
            methodPostDataHandlerList = new ArrayList();
            threadNameMap = new HashMap();
            threadNameSet = new GMTraceBitSet(Constants.THREAD_BITSET_SIZE);
            methodInFlagSet = new GMTraceBitSet(Constants.METHOD_BITSET_SIZE);
            startTrace();
        }
    }

    public static void startTrace() {
        if (isInit && !isStartTrace) {
            isStartTrace = true;
            GMTraceWorker gMTraceWorker = new GMTraceWorker();
            gmTraceWorker = gMTraceWorker;
            gMTraceWorker.start();
        }
    }

    public static void stopTrace() {
        if (isInit && isStartTrace) {
            isStartTrace = false;
            gmTraceWorker.stop();
            gmTraceWorker = null;
        }
    }

    public static HashMap<Integer, String> getThreadNameMap() {
        return threadNameMap;
    }

    public static void registerHandler(GMTraceHandler gMTraceHandler) {
        if (isInit) {
            if (gMTraceHandler.getPointId() != null && gMTraceHandler.getPointId().size() > 0) {
                new StringBuilder("register handler ").append(gMTraceHandler.getPointId().toString());
                for (Integer intValue : gMTraceHandler.getPointId()) {
                    List list;
                    int intValue2 = intValue.intValue();
                    if (methodInFlagSet != null) {
                        methodInFlagSet.set(intValue2);
                    }
                    if (methodInHandlerMap.containsKey(Integer.valueOf(intValue2))) {
                        list = (List) methodInHandlerMap.get(Integer.valueOf(intValue2));
                    } else {
                        list = new ArrayList();
                    }
                    list.add(gMTraceHandler);
                    methodInHandlerMap.put(Integer.valueOf(intValue2), list);
                }
            }
            methodPostDataHandlerList.add(gMTraceHandler);
        }
    }

    public static void unregisterHandler(GMTraceHandler gMTraceHandler) {
        methodPostDataHandlerList.remove(gMTraceHandler);
        if (gMTraceHandler.getPointId() != null && gMTraceHandler.getPointId().size() > 0) {
            new StringBuilder("unregister handler ").append(gMTraceHandler.getPointId().toString());
            for (Integer intValue : gMTraceHandler.getPointId()) {
                int intValue2 = intValue.intValue();
                List list = (List) methodInHandlerMap.get(Integer.valueOf(intValue2));
                if (list != null) {
                    list.remove(gMTraceHandler);
                    if (list.size() == 0 && methodInFlagSet != null) {
                        methodInFlagSet.unset(intValue2);
                    }
                    methodInHandlerMap.put(Integer.valueOf(intValue2), list);
                } else if (methodInFlagSet != null) {
                    methodInFlagSet.unset(intValue2);
                }
            }
        }
    }

    public static void clearHandler() {
        if (isInit) {
            if (methodInFlagSet != null) {
                methodInFlagSet.clear();
            }
            if (methodInHandlerMap != null) {
                methodInHandlerMap.clear();
            }
        }
    }

    public static boolean isEmptyHandler() {
        if (isInit) {
            return methodInHandlerMap.isEmpty();
        }
        return true;
    }

    public static long[] getMainThreadBuffer() {
        return mainThreadBuffer;
    }

    public static long[] getOtherThreadBuffer() {
        return otherThreadBuffer;
    }

    public static int getMainThreadIndex() {
        return mainThreadIndex;
    }

    public static int getOtherThreadIndex() {
        return otherThreadIndex.get() % Constants.MAX_BUFFER_SIZE;
    }

    public static long getStartTime() {
        return startTime;
    }

    public static long getCurrentDiffTime() {
        return currentDiffTime;
    }

    public static boolean isInit() {
        return isInit;
    }
}
