package org.alexcawl.memorize.common.resolver

import org.alexcawl.memorize.common.util.OneWayMapper
import org.alexcawl.memorize.common.model.CategoryModel

interface ICategoryResolver : OneWayMapper<CategoryModel, String>