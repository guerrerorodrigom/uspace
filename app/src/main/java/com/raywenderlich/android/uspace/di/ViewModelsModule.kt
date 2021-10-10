package com.raywenderlich.android.uspace.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.android.uspace.ui.viewmodels.RocketsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelsModule {

  @Binds
  @IntoMap
  @ViewModelKey(RocketsViewModel::class)
  abstract fun bindRocketsViewModel(rocketsViewModel: RocketsViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}