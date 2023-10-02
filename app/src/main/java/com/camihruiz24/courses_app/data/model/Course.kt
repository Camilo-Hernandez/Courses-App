package com.camihruiz24.courses_app.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val titleId: Int,
    val associateCourses: Int,
    @DrawableRes val imageId: Int,
)
