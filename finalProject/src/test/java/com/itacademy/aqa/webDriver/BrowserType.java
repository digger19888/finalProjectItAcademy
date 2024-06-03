package com.itacademy.aqa.webDriver;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    CHROME_EMULATOR("mobile"),
    EDGE("web"),
    REMOTE_CHROME("web");

    BrowserType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    private String type;
}
