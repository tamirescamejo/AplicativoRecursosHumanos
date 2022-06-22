package br.com.zup.recursoshumanos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.recursoshumanos.databinding.FragmentSalarioFuncionarieBinding
import br.com.zup.recursoshumanos.model.Funcionarie

class SalarioFuncionarieFragment : Fragment() {
    private lateinit var binding: FragmentSalarioFuncionarieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSalarioFuncionarieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val funcionarie = arguments?.getParcelable<Funcionarie>(CHAVE_FUNCIONARIE)
        if (funcionarie != null) {
            binding.tvNomeFuncionarie.text = funcionarie.getNomeSobrenome()
            binding.tvHorasTrabalhadas.text = "Horas Trabalhadas: ${funcionarie.getHorasTrabalhadas()}"
            binding.tvValorHora.text = "Valor Por Hora: R$ ${funcionarie.getValorPorHora()}"
            binding.tvSalarioReceberTotal.text = "Salário a Receber: R$ ${funcionarie.getValorTotalSalario()}"
        }
    }
}