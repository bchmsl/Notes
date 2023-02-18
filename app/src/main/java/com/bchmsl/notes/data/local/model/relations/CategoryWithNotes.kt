package com.bchmsl.notes.data.local.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.data.local.model.Note

data class CategoryWithNotes(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "category"
    ) val notes: List<Note>
)