package com.redbudcloud.aid.common.utils;

public class Constants {
    public final static Short ACTIVE_STATE = 0;
    public final static Short INACTIVE_STATE = 1;

    /**
     * Token constants
     */
    public static final int TOKEN_EXPIRE_TIME = 30 * 60 * 1000;//Token过期时间
    public static final long RENEW_TOKEN_POINT = 5 * 60 * 1000;//Token更新时间点（离过期5分钟）
    public static final String TOKEN_HEAD = "Bearer ";
    /**
     * ERROR response constants
     */
    public static final String SYSTEM_ERROR_RESPONSE = "系统故障，请联系管理员";
}
