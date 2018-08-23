package com.snail2lb.web.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.snail2lb.web.commons.api.User;


/**
 *
 * Created by lvbiao on 2018-02-22 上午 11:29.
 */
public class LoginUtil {

    /**
     * 获取当前登录的user
     */
    public static User getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object object = authentication.getPrincipal();
            if (object != null) {
                return (User) object;
            }
        }
        return null;
    }

}
