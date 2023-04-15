package com.obs.utils;

import java.util.Date;

public class Utils {
    public String generateSession(){
        //dummy session
        return String.valueOf(new Date().getTime());
    }
}
