package com.study.duckapi.data.mapper

import com.study.duckapi.data.remote.response.ResponseDto
import com.study.duckapi.domain.model.DuckModel

fun ResponseDto.toDomain(): DuckModel {
    return DuckModel(
        url = this.link,
        img = this.image
    )
}