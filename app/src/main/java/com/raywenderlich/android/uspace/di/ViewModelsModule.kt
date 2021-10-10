package com.raywenderlich.android.uspace.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.android.uspace.ui.viewmodels.CrewViewModel
import com.raywenderlich.android.uspace.ui.viewmodels.DragonViewModel
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
  @IntoMap
  @ViewModelKey(CrewViewModel::class)
  abstract fun bindCrewViewModel(crewViewModel: CrewViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(DragonViewModel::class)
  abstract fun bindDragonViewModel(dragonViewModel: DragonViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}