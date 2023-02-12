package com.study.duckapi.di

import com.study.duckapi.data.remote.DuckRepositoryImpl
import com.study.duckapi.domain.repository.DuckRepository
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
    abstract fun bindDuckRepository(duckRepositoryImpl: DuckRepositoryImpl): DuckRepository

}