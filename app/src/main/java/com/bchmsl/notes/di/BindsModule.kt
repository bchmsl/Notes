package com.bchmsl.notes.di

import com.bchmsl.notes.data.repository.UsernameRepositoryImpl
import com.bchmsl.notes.domain.repository.UsernameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindsModule {

    @Binds
    @Singleton
    abstract fun bindUsernameRepository(usernameRepositoryImpl: UsernameRepositoryImpl): UsernameRepository
}