package com.study.duckapi.data.remote

import com.study.duckapi.data.DuckApi
import com.study.duckapi.data.mapper.toDomain
import com.study.duckapi.domain.model.DuckModel
import com.study.duckapi.domain.repository.DuckRepository
import com.study.duckapi.domain.util.ResourceState
import javax.inject.Inject

class DuckRepositoryImpl @Inject constructor(
    private val duckApi: DuckApi
): DuckRepository {
    override suspend fun fetchDuckApiFromRepository(): ResourceState<DuckModel> {
        return try {
            ResourceState.Success(
                data = duckApi.fetchDuckApiFromData().toDomain()
            )
        } catch (e: Exception) {
            ResourceState.Error(
                message = "Unknown error HEY! $e"
            )
        }
    }


}