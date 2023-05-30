package com.legp.totalplaytest.mvp.core.dagger.modules

import android.content.Context
import com.legp.totalplaytest.utils.SharedPreferences

import dagger.Module
import dagger.Provides

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object PreferencesModule {
    /**
     * Provides the Context
     * @param baseView the BaseView used to provides the context
     * @return the Context to be provided
     */
    /*  @Provides
      @JvmStatic
      internal fun providePrefrences(baseView: BaseView): Preferences {
          return Preferences(baseView)
      }
  */
    /**
     * Provides the Application Context
     * @param context Context in which the application is running
     * @return the Application Context to be provided
     */
    @Provides
    @JvmStatic
    internal fun providePrefrences(context: Context): SharedPreferences {
        return SharedPreferences(context)
    }
}