package com.nashss.se.simple_plan.dependency;

import com.nashss.se.simple_plan.activity.*;
import com.nashss.se.simple_plan.activity.CreateBudgetActivity;
import com.nashss.se.simple_plan.activity.CreateCategoryActivity;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Simple Plan Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {
    /**
     * Provides the relevant activity.
     * @return CreateBudgetActivity
     */
    CreateBudgetActivity provideCreateBudgetActivity();

    /**
     * Provides the relevant activity.
     * @return CreateCategoryActivity
     */
    CreateCategoryActivity provideCreateCategoryActivity();

    /**
     * Provides the relevant activity.
     * @return GetSingleExpenseActivity
     */
    GetSingleExpenseActivity provideGetSingleExpenseActivity();

    /**
     * Provides the relevant activity.
     * @return GetSingleExpenseActivity
     */

    CreateExpenseActivity provideCreateExpenseActivity();
}
