package com.example.a7ml2.di

import com.example.a7ml2.data.mapper.NoteMapper
import com.example.a7ml2.data.repository.NoteRepositoryImpl
import com.example.a7ml2.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    val noteMapper = NoteMapper()

    @Singleton
    @Provides
    fun provideNoteRepository(): NoteRepository {
        return NoteRepositoryImpl(noteMapper)
    }
}