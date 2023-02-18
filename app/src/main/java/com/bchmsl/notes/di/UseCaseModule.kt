package com.bchmsl.notes.di

import com.bchmsl.notes.domain.usecase.categories.add.AddCategoryUseCase
import com.bchmsl.notes.domain.usecase.categories.add.AddCategoryUseCaseImpl
import com.bchmsl.notes.domain.usecase.categories.delete.DeleteCategoryUseCase
import com.bchmsl.notes.domain.usecase.categories.delete.DeleteCategoryUseCaseImpl
import com.bchmsl.notes.domain.usecase.categories.read.ReadCategoryUseCase
import com.bchmsl.notes.domain.usecase.categories.read.ReadCategoryUseCaseImpl
import com.bchmsl.notes.domain.usecase.categories.read_all.ReadAllCategoriesUseCase
import com.bchmsl.notes.domain.usecase.categories.read_all.ReadAllCategoriesUseCaseImpl
import com.bchmsl.notes.domain.usecase.notes.add.AddNoteUseCase
import com.bchmsl.notes.domain.usecase.notes.add.AddNoteUseCaseImpl
import com.bchmsl.notes.domain.usecase.notes.delete.DeleteNoteUseCase
import com.bchmsl.notes.domain.usecase.notes.delete.DeleteNoteUseCaseImpl
import com.bchmsl.notes.domain.usecase.notes.read.ReadNoteUseCase
import com.bchmsl.notes.domain.usecase.notes.read.ReadNoteUseCaseImpl
import com.bchmsl.notes.domain.usecase.notes.read_all.ReadAllNotesUseCase
import com.bchmsl.notes.domain.usecase.notes.read_all.ReadAllNotesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    abstract fun bindAddCategoryUC(addCategoryUseCaseImpl: AddCategoryUseCaseImpl): AddCategoryUseCase

    @Binds
    @Singleton
    abstract fun bindDeleteCategoryUC(deleteCategoryUseCaseImpl: DeleteCategoryUseCaseImpl): DeleteCategoryUseCase

    @Binds
    @Singleton
    abstract fun bindReadCategoryUC(readCategoryUseCaseImpl: ReadCategoryUseCaseImpl): ReadCategoryUseCase

    @Binds
    @Singleton
    abstract fun bindReadAllCategoriesUC(readAllCategoriesUseCaseImpl: ReadAllCategoriesUseCaseImpl): ReadAllCategoriesUseCase

    @Binds
    @Singleton
    abstract fun bindAddNoteUC(addNoteUseCaseImpl: AddNoteUseCaseImpl): AddNoteUseCase

    @Binds
    @Singleton
    abstract fun bindDeleteNoteUC(deleteNoteUseCaseImpl: DeleteNoteUseCaseImpl): DeleteNoteUseCase

    @Binds
    @Singleton
    abstract fun bindReadNoteUC(readNoteUseCaseImpl: ReadNoteUseCaseImpl): ReadNoteUseCase

    @Binds
    @Singleton
    abstract fun bindReadAllNotesUC(readAllNotesUseCaseImpl: ReadAllNotesUseCaseImpl): ReadAllNotesUseCase
}