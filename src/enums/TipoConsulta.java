package enums;

public enum TipoConsulta {
    ROTINA("Consulta de rotina."),
    VACINACAO("Vacinação de rotina."),
    EMERGENCIA("Atendimento de emergência."),
    RETORNO("Retorno de consulta. "),
    CIRURGIA("Cirurgia agendada.");

    private String descricao;

    private TipoConsulta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }


}
