package com.maulana.di.component

import com.maulana.di.module.AuthDataModule
import com.maulana.di.module.RestModule
import com.maulana.todolist.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AuthDataModule::class, RestModule::class])
@AuthScope
@Singleton
interface AuthComponent {
    fun inject(activity: MainActivity)
}