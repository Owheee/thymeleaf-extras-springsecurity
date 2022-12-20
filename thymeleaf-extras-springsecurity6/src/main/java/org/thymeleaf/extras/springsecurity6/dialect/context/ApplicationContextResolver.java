package org.thymeleaf.extras.springsecurity6.dialect.context;

import org.springframework.context.ApplicationContext;
import org.thymeleaf.context.IContext;

public interface ApplicationContextResolver {
    ApplicationContext getContext(final IContext context);
}
