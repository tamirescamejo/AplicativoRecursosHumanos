package br.com.zup.recursoshumanos.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Funcionarie(
    private var nomeSobrenome: String,
    private var horasTrabalhadas: Double,
    private var valorPorHora: Double
) : Parcelable{
    fun getNomeSobrenome() = this.nomeSobrenome
    fun getHorasTrabalhadas() = this.horasTrabalhadas
    fun getValorPorHora() = this.valorPorHora
    fun getValorTotalSalario() = this.valorTotalSalário

    private var valorTotalSalário = horasTrabalhadas*valorPorHora
}
