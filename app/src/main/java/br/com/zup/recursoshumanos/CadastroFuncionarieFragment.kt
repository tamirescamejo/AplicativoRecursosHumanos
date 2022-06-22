package br.com.zup.recursoshumanos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.recursoshumanos.databinding.FragmentCadastroFuncionarieBinding
import br.com.zup.recursoshumanos.model.Funcionarie

class CadastroFuncionarieFragment : Fragment() {
    private lateinit var binding: FragmentCadastroFuncionarieBinding
    private lateinit var nomeSobrenome: String
    private lateinit var horasTrabalhadas: String
    private lateinit var valorPorHora: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroFuncionarieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalcularSalario.setOnClickListener {
            enviarDadosFuncionarie()
        }
    }

    private fun enviarDadosFuncionarie() {
        recuperarDadosCamposEdicao()
        if (!verificarCamposEdicao()) {
            val funcionarie = Funcionarie(
                nomeSobrenome,
                horasTrabalhadas.toDouble(),
                valorPorHora.toDouble()
            )
            irParaCalcularSalario(funcionarie)
            limparCamposEdicao()
        }
    }

    private fun recuperarDadosCamposEdicao() {
        this.nomeSobrenome = binding.etNomeSobrenome.text.toString()
        this.horasTrabalhadas = binding.etHorasTrabalhadas.text.toString()
        this.valorPorHora = binding.etValorHora.text.toString()
    }

    private fun verificarCamposEdicao(): Boolean {
        when {
            this.nomeSobrenome.isEmpty() -> {
                binding.etNomeSobrenome.error = MENSAGEM_CAMPO_OBRIGATORIO
                return true
            }
            this.horasTrabalhadas.isEmpty() -> {
                binding.etHorasTrabalhadas.error = MENSAGEM_CAMPO_OBRIGATORIO
                return true
            }
            this.valorPorHora.isEmpty() -> {
                binding.etValorHora.error = MENSAGEM_CAMPO_OBRIGATORIO
                return true
            }
        }
        return false
    }

    private fun limparCamposEdicao() {
        binding.etNomeSobrenome.text.clear()
        binding.etHorasTrabalhadas.text.clear()
        binding.etValorHora.text.clear()
    }

    private fun irParaCalcularSalario(funcionarie: Funcionarie) {
        val bundle = bundleOf(CHAVE_FUNCIONARIE to funcionarie)

        NavHostFragment.findNavController(this).navigate(
            R.id.action_cadastroFuncionarie_to_salarioFuncionarie, bundle
        )
    }
}