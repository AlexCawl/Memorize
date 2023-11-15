package org.alexcawl.memorize.common.resolver

import org.alexcawl.memorize.common.util.OneWayMapper
import org.alexcawl.memorize.common.model.CountryModel

interface ICountryResolver : OneWayMapper<CountryModel, String>