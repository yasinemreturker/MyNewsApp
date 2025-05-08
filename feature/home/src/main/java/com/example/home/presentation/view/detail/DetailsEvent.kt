package com.example.home.presentation.view.detail

import com.example.network.api.home.model.local.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    object RemoveSideEffect : DetailsEvent()

}