package ru.javawebinar.topjava.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ru.javawebinar.topjava.AuthorizedUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static ru.javawebinar.topjava.web.SecurityUtil.safeGet;

/**
 * This interceptor adds userTo to the model of every requests
 */
public class ModelInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && !modelAndView.isEmpty()) {
            AuthorizedUser autorizedUser = safeGet();
            if (autorizedUser != null) {
                modelAndView.getModelMap().addAttribute("userTo", autorizedUser.getUserTo());
            }
        }
    }
}
