/*
 * =============================================================================
 *
 *   Copyright (c) 2011-2018, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package org.thymeleaf.extras.springsecurity6.auth;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.core.Authentication;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.util.Validate;


/**
 *
 * @author Daniel Fern&aacute;ndez
 * @since 2.0.1
 *
 */
public final class AclAuthorization {


    private final IExpressionContext context;
    private final ApplicationContext applicationContext;
    private final Authentication authentication;



    public AclAuthorization(
            final IExpressionContext context,
            final ApplicationContext applicationContext,
            final Authentication authentication) {

        super();

        this.context = context;
        this.applicationContext = applicationContext;
        this.authentication = authentication;

    }


    public Authentication getAuthentication() {
        return this.authentication;
    }



    public boolean acl(final Object domainObject, final String permissions) {

        Validate.notEmpty(permissions, "permissions cannot be null or empty");


        final List<Permission> permissionsList =
                AclAuthUtils.parsePermissionsString(this.applicationContext, permissions);

        return AclAuthUtils.authorizeUsingAccessControlList(
                this.context, domainObject, this.applicationContext, permissionsList, this.authentication);

    }


}
