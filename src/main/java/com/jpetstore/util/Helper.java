package com.jpetstore.util;

public class Helper {

    public static boolean isWebDriverManager() {

        if(PropertyReader.getInstance().
                getProperty(PropKey.BROWSER_MANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager")) {
            return true;
        }

        return false;
    }
}