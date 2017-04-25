package com.tencent.mm.modelsearch;

public interface n extends Comparable<n> {
    void create();

    void destroy();

    String getName();

    int getPriority();

    int getType();
}
