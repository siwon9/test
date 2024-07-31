package org.choongang.member;

import org.choongang.member.entities.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MemberUtil {

    public boolean isLogin() {
        return getMember() != null;
    }

    public boolean isAdmin() {
        if(isLogin()) {

        }

        return false;
    }

    public Member getMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.isAuthenticated() && authentication.getPrincipal() instanceof MemberInfo) {
            MemberInfo memberInfo = (MemberInfo) authentication.getPrincipal();

            return memberInfo.getMember();
        }

        return null;
    }
}