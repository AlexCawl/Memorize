package org.alexcawl.memorize.common.resolver

import android.content.Context
import org.alexcawl.memorize.common.R
import org.alexcawl.memorize.common.model.CountryModel
import javax.inject.Inject

class CountryResolver @Inject constructor(
    private val context: Context
) : ICountryResolver {
    override fun map(from: CountryModel): String {
        return when (from) {
            CountryModel.AE -> context.getString(R.string.ae)
            CountryModel.AR -> context.getString(R.string.ar)
            CountryModel.AT -> context.getString(R.string.at)
            CountryModel.AU -> context.getString(R.string.au)
            CountryModel.BE -> context.getString(R.string.be)
            CountryModel.BG -> context.getString(R.string.bg)
            CountryModel.BR -> context.getString(R.string.br)
            CountryModel.CA -> context.getString(R.string.ca)
            CountryModel.CH -> context.getString(R.string.ch)
            CountryModel.CN -> context.getString(R.string.cn)
            CountryModel.CO -> context.getString(R.string.co)
            CountryModel.CU -> context.getString(R.string.cu)
            CountryModel.CZ -> context.getString(R.string.cz)
            CountryModel.DE -> context.getString(R.string.de)
            CountryModel.EG -> context.getString(R.string.eg)
            CountryModel.FR -> context.getString(R.string.fr)
            CountryModel.GB -> context.getString(R.string.gb)
            CountryModel.GR -> context.getString(R.string.gr)
            CountryModel.HK -> context.getString(R.string.hk)
            CountryModel.HU -> context.getString(R.string.hu)
            CountryModel.ID -> context.getString(R.string.id)
            CountryModel.IE -> context.getString(R.string.ie)
            CountryModel.IL -> context.getString(R.string.il)
            CountryModel.IN -> context.getString(R.string.`in`)
            CountryModel.IT -> context.getString(R.string.it)
            CountryModel.JP -> context.getString(R.string.jp)
            CountryModel.KR -> context.getString(R.string.kr)
            CountryModel.LT -> context.getString(R.string.lt)
            CountryModel.LV -> context.getString(R.string.lv)
            CountryModel.MA -> context.getString(R.string.ma)
            CountryModel.MX -> context.getString(R.string.mx)
            CountryModel.MY -> context.getString(R.string.my)
            CountryModel.NG -> context.getString(R.string.ng)
            CountryModel.NL -> context.getString(R.string.nl)
            CountryModel.NO -> context.getString(R.string.no)
            CountryModel.NZ -> context.getString(R.string.nz)
            CountryModel.PH -> context.getString(R.string.ph)
            CountryModel.PL -> context.getString(R.string.pl)
            CountryModel.PT -> context.getString(R.string.pt)
            CountryModel.RO -> context.getString(R.string.ro)
            CountryModel.RS -> context.getString(R.string.rs)
            CountryModel.RU -> context.getString(R.string.ru)
            CountryModel.SA -> context.getString(R.string.sa)
            CountryModel.SE -> context.getString(R.string.se)
            CountryModel.SG -> context.getString(R.string.sg)
            CountryModel.SI -> context.getString(R.string.si)
            CountryModel.SK -> context.getString(R.string.sk)
            CountryModel.TH -> context.getString(R.string.th)
            CountryModel.TR -> context.getString(R.string.tr)
            CountryModel.TW -> context.getString(R.string.tw)
            CountryModel.UA -> context.getString(R.string.ua)
            CountryModel.US -> context.getString(R.string.us)
            CountryModel.VE -> context.getString(R.string.ve)
            CountryModel.ZA -> context.getString(R.string.za)
        }
    }
}