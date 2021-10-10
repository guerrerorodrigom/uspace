package com.raywenderlich.android.uspace.di

import com.raywenderlich.android.uspace.SpaceApp
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
      AndroidSupportInjectionModule::class,
      AndroidModule::class,
      SpaceModule::class,
      ViewModelsModule::class
    ]
)
interface AppComponent {
  fun inject(app: SpaceApp)
}