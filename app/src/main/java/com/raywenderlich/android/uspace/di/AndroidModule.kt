package com.raywenderlich.android.uspace.di

import com.raywenderlich.android.uspace.ui.fragments.CapsulesFragment
import com.raywenderlich.android.uspace.ui.fragments.DragonsFragment
import com.raywenderlich.android.uspace.ui.fragments.CrewFragment
import com.raywenderlich.android.uspace.ui.fragments.RocketsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidModule {

  @ContributesAndroidInjector
  abstract fun rocketsFragment(): RocketsFragment

  @ContributesAndroidInjector
  abstract fun crewFragment(): CrewFragment

  @ContributesAndroidInjector
  abstract fun dragonsFragment(): DragonsFragment

  @ContributesAndroidInjector
  abstract fun capsulesFragment(): CapsulesFragment
}