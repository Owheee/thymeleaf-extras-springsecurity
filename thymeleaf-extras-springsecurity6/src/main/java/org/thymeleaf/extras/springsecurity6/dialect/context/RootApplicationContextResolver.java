package org.thymeleaf.extras.springsecurity6.dialect.context;

import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.IContext;
import org.thymeleaf.extras.springsecurity6.util.SpringSecurityContextUtils;

public class RootApplicationContextResolver implements ApplicationContextResolver {

    @Override
    public ApplicationContext getContext(final IContext context) {
        return SpringSecurityContextUtils.getApplicationContext(context);
    }


}
