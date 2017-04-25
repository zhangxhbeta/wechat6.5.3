package com.tencent.mapsdk.raster.model;

public enum QMapLanguage {
    QMapLanguage_zh,
    QMapLanguage_en;

    public static String getLanguageCode(QMapLanguage qMapLanguage) {
        return (qMapLanguage == null || qMapLanguage.name() == null || qMapLanguage.name().indexOf("_") == -1) ? "en" : qMapLanguage.name().substring(qMapLanguage.name().indexOf("_") + 1);
    }
}
