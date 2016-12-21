package de.tum.in.www1.exerciseapp.config;

import de.tum.in.www1.exerciseapp.security.CustomPermissionEvaluator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import javax.inject.Inject;

/**
 * Created by Josias Montag on 21.12.16.
 */
@Configuration
@ComponentScan("de.tum.in.www1.exerciseapp.security.*")
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {


    @Inject
    private CustomPermissionEvaluator customPermissionEvaluator;

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler expressionHandler =
            new DefaultMethodSecurityExpressionHandler();
        expressionHandler.setPermissionEvaluator(customPermissionEvaluator);
        return expressionHandler;
    }


}
