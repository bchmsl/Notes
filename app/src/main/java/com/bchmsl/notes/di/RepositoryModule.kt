package com.bchmsl.notes.di

import com.bchmsl.notes.data.repository.CategoryRepositoryImpl
import com.bchmsl.notes.data.repository.NoteRepositoryImpl
import com.bchmsl.notes.data.repository.UsernameRepositoryImpl
import com.bchmsl.notes.domain.repository.CategoryRepository
import com.bchmsl.notes.domain.repository.NoteRepository
import com.bchmsl.notes.domain.repository.UsernameRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUsernameRepository(usernameRepositoryImpl: UsernameRepositoryImpl): UsernameRepository

    @Binds
    @Singleton
    abstract fun bindCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    @Singleton
    abstract fun bindNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository
}