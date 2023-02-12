package com.study.duckapi.domain.repository

import com.study.duckapi.domain.model.DuckModel
import com.study.duckapi.domain.util.ResourceState

interface DuckRepository {
    suspend fun fetchDuckApiFromRepository(): ResourceState<DuckModel>
}